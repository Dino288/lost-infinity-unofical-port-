package xol.lostinfinity.blockentity;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.NonNullList;
import net.minecraftforge.registries.ForgeRegistries;
import xol.lostinfinity.block.LostMachineBlock;
import xol.lostinfinity.effect.LostFx;
import xol.lostinfinity.menu.LostMachineMenu;
import xol.lostinfinity.registry.ModBlockEntities;
import xol.lostinfinity.LostInfinity;
import xol.lostinfinity.recipe.LostMachineRecipe;
import xol.lostinfinity.registry.ModRecipeTypes;

public class LostMachineBlockEntity extends BlockEntity implements MenuProvider, Container {
    private static final int INPUT_SLOT = 0;
    private static final int CATALYST_SLOT = 1;
    private static final int FUEL_SLOT = 2;
    private static final int MODULE_START_SLOT = 3;
    private static final int MODULE_END_SLOT = 7;
    private static final int OUTPUT_SLOT = 8;
    private static final int ENERGY_CAPACITY = 1000;
    private static final String ITEM_ENERGY_TAG = "LostEnergy";
    private static final String ITEM_AMMO_TAG = "LostAmmo";
    private final NonNullList<ItemStack> items = NonNullList.withSize(9, ItemStack.EMPTY);
    private final ContainerData data = new ContainerData() {
        @Override
        public int get(int index) {
            return switch (index) {
                case 0 -> progress;
                case 1 -> processTime;
                case 2 -> energy;
                case 3 -> active ? 1 : 0;
                case 4 -> puzzleState;
                default -> 0;
            };
        }

        @Override
        public void set(int index, int value) {
            switch (index) {
                case 0 -> progress = value;
                case 1 -> processTime = value;
                case 2 -> energy = value;
                case 3 -> active = value != 0;
                case 4 -> puzzleState = value;
                default -> {
                }
            }
        }

        @Override
        public int getCount() {
            return 5;
        }
    };
    private String machineId = "lost_machine";
    private int progress;
    private int energy;
    private int processTime = 120;
    private int puzzleState;
    private boolean active;

    public LostMachineBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.LOST_MACHINE.get(), pos, state);
        if (state.getBlock() instanceof LostMachineBlock machineBlock) {
            this.machineId = machineBlock.machineId();
        }
    }

    public static void tick(Level level, BlockPos pos, BlockState state, LostMachineBlockEntity machine) {
        if (state.getBlock() instanceof LostMachineBlock machineBlock && !machine.machineId.equals(machineBlock.machineId())) {
            machine.machineId = machineBlock.machineId();
        }
        if (level.isClientSide) {
            return;
        }
        machine.tickServer(level, pos);
    }

    public void applyNetworkUpdate(int index, int value) {
        switch (index) {
            case 0 -> progress = Math.max(0, value);
            case 1 -> processTime = Math.max(1, value);
            case 2 -> energy = Math.max(0, Math.min(ENERGY_CAPACITY, value));
            case 3 -> active = value != 0;
            case 4 -> puzzleState = Math.floorMod(value, 16);
            default -> {
            }
        }
        setChanged();
    }

    private void tickServer(Level level, BlockPos pos) {
        active = false;
        if (isGenerator()) {
            generateEnergy();
            pulseMachineEffect(level, pos);
            setChanged();
            return;
        }
        if (isPuzzleMachine()) {
            tickPuzzleMachine(level, pos);
            setChanged();
            return;
        }
        if (isWeaponMachine()) {
            chargeFromFuel();
            pulseMachineEffect(level, pos);
        }

        MachineRecipe recipe = recipeForCurrentInput(level);
        if (recipe == null || !canOutput(recipe.output())) {
            progress = 0;
            setChanged();
            return;
        }
        chargeFromFuel();
        if (energy < recipe.energyCost()) {
            setChanged();
            return;
        }
        active = true;
        processTime = effectiveTime(recipe.time());
        progress++;
        if (progress >= processTime) {
            craft(level, recipe);
            progress = 0;
        }
        setChanged();
    }

    private void generateEnergy() {
        active = true;
        progress = (progress + 1) % 100;
        processTime = 100;
        ItemStack fuel = items.get(FUEL_SLOT);
        if (canStoreItemEnergy(fuel) && chargeItem(fuel, machineId.contains("hyper") ? 8 : 4)) {
            energy = Math.min(ENERGY_CAPACITY, energy + 1);
        } else if (isFuel(fuel) && energy <= ENERGY_CAPACITY - 100) {
            energy += consumeFuelEnergy(fuel);
        } else {
            energy = Math.min(ENERGY_CAPACITY, energy + (machineId.contains("hyper") ? 5 : 2));
        }
    }

    private void tickPuzzleMachine(Level level, BlockPos pos) {
        active = !items.get(INPUT_SLOT).isEmpty() || level.hasNeighborSignal(pos);
        processTime = machineId.contains("melodic") ? 64 : 32;
        if (active) {
            progress++;
            if (progress >= processTime) {
                progress = 0;
                puzzleState = (puzzleState + 1) % 16;
                if (machineId.contains("light_emitter")) {
                    energy = Math.min(ENERGY_CAPACITY, energy + 25);
                }
            }
        } else {
            progress = 0;
        }
    }

    private void pulseMachineEffect(Level level, BlockPos pos) {
        if (energy <= 0 || level.getGameTime() % 40 != 0) {
            return;
        }
        if (machineId.contains("shockwave")) {
            LostFx.burst(level, pos, "electric_explosion_blue", 18, 1.0D, 0.05D);
            LostFx.play(level, pos, "electric_bounce", SoundSource.BLOCKS, 0.8F, 0.8F);
            for (LivingEntity entity : level.getEntitiesOfClass(LivingEntity.class, new net.minecraft.world.phys.AABB(pos).inflate(effectRange(5.0D)))) {
                entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 1));
                entity.hurt(level.damageSources().magic(), 2.0F);
            }
            energy = Math.max(0, energy - effectiveEnergyCost(20));
        } else if (machineId.contains("rainfall")) {
            LostFx.burst(level, pos, "murky_mist", 14, 1.5D, 0.04D);
            LostFx.play(level, pos, "rainfall_generator", SoundSource.BLOCKS, 0.75F, 1.0F);
            for (LivingEntity entity : level.getEntitiesOfClass(LivingEntity.class, new net.minecraft.world.phys.AABB(pos).inflate(effectRange(6.0D)))) {
                entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 80, 0));
            }
            energy = Math.max(0, energy - effectiveEnergyCost(10));
        } else if (machineId.contains("beacon") || machineId.contains("tesla")) {
            LostFx.burst(level, pos, machineId.contains("tesla") ? "zap" : "portal_beam", 12, 0.75D, 0.03D);
            LostFx.play(level, pos, machineId.contains("tesla") ? "charging_power" : "nebulous_beacon", SoundSource.BLOCKS, 0.8F, 1.0F);
            for (Player player : level.getEntitiesOfClass(Player.class, new net.minecraft.world.phys.AABB(pos).inflate(effectRange(8.0D)))) {
                player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 80, 0, true, false));
            }
            energy = Math.max(0, energy - effectiveEnergyCost(8));
        }
    }

    private void craft(Level level, MachineRecipe recipe) {
        ItemStack input = items.get(INPUT_SLOT);
        ItemStack catalyst = items.get(CATALYST_SLOT);
        input.shrink(1);
        if (recipe.usesCatalyst() && !catalyst.isEmpty()) {
            catalyst.shrink(1);
        }
        energy = Math.max(0, energy - effectiveEnergyCost(recipe.energyCost()));
        LostFx.burst(level, worldPosition, machineParticle(), 16, 0.65D, 0.04D);
        LostFx.play(level, worldPosition, machineSound(), SoundSource.BLOCKS, 0.8F, 0.9F + level.random.nextFloat() * 0.25F);
        ItemStack output = recipe.output().copy();
        output.grow(Math.min(extraOutput(), output.getMaxStackSize() - output.getCount()));
        ItemStack existing = items.get(OUTPUT_SLOT);
        if (existing.isEmpty()) {
            items.set(OUTPUT_SLOT, output);
        } else {
            existing.grow(output.getCount());
        }
    }

    private String machineParticle() {
        if (machineId.contains("infuser")) return "ancient_spell";
        if (machineId.contains("polymer") || machineId.contains("chem")) return "acid";
        if (machineId.contains("fusion") || machineId.contains("collider")) return "plasma";
        if (machineId.contains("grinder") || machineId.contains("crusher")) return "small_spark";
        if (machineId.contains("circuit") || machineId.contains("calibrator")) return "zap";
        return "space_magic";
    }

    private String machineSound() {
        if (machineId.contains("infuser")) return "infuser";
        if (machineId.contains("polymer") || machineId.contains("chem")) return "chemical_mixing";
        if (machineId.contains("fusion") || machineId.contains("collider")) return "manufacture_machine";
        if (machineId.contains("grinder") || machineId.contains("crusher")) return "rock_tumble";
        if (machineId.contains("circuit") || machineId.contains("calibrator")) return "minigame_score";
        return "block_ding";
    }

    private MachineRecipe recipeForCurrentInput(Level level) {
        ItemStack input = items.get(INPUT_SLOT);
        if (input.isEmpty()) {
            return null;
        }
        MachineRecipe datapackRecipe = datapackRecipe(level);
        if (datapackRecipe != null) {
            return datapackRecipe;
        }
        String inputId = itemPath(input);
        Item output = inferOutput(inputId);
        if (output == Items.AIR) {
            return null;
        }
        int time = machineId.contains("compression") || machineId.contains("fusion") || machineId.contains("collider") ? 200 : 120;
        int cost = machineId.contains("compression") || machineId.contains("fusion") || machineId.contains("collider") ? 80 : 35;
        int count = machineId.contains("grinder") || machineId.contains("crusher") ? 2 : 1;
        boolean usesCatalyst = machineId.contains("infuser") || machineId.contains("polymer") || machineId.contains("fusion");
        return new MachineRecipe(new ItemStack(output, count), time, cost, usesCatalyst);
    }

    private MachineRecipe datapackRecipe(Level level) {
        return level.getRecipeManager().getAllRecipesFor(ModRecipeTypes.MACHINE).stream()
                .filter(recipe -> recipe.matchesMachine(machineId) && recipe.matches(this, level))
                .findFirst()
                .map(recipe -> new MachineRecipe(recipe.output(), recipe.time(), recipe.energy(), recipe.consumeCatalyst()))
                .orElse(null);
    }

    private Item inferOutput(String inputId) {
        if (machineId.contains("grinder") || machineId.contains("crusher")) {
            Item dust = item(inputId.replace("_ore", "_dust").replace("_ingot", "_dust"));
            if (dust != Items.AIR) return dust;
            return item("dust_" + inputId.replace("_ore", "").replace("_ingot", ""));
        }
        if (machineId.contains("compression")) {
            Item block = item(inputId + "_block");
            if (block != Items.AIR) return block;
            return item("compressed_" + inputId);
        }
        if (machineId.contains("welding") || machineId.contains("circuit") || machineId.contains("gearbox")) {
            Item plate = item(inputId.replace("_ingot", "_plate"));
            if (plate != Items.AIR) return plate;
            return item("metal_plate");
        }
        if (machineId.contains("infuser") || machineId.contains("fusion") || machineId.contains("collider")) {
            Item infused = item("infused_" + inputId);
            if (infused != Items.AIR) return infused;
            Item crystal = item(inputId.replace("_dust", "_crystal").replace("_ingot", "_crystal"));
            return crystal != Items.AIR ? crystal : item("multiversite");
        }
        if (machineId.contains("polymer")) {
            Item polymer = item(inputId.replace("_dust", "_polymer"));
            return polymer != Items.AIR ? polymer : item("synthetic_fibre");
        }
        if (machineId.contains("chemistry")) {
            Item solution = item(inputId.replace("_dust", "_solution"));
            return solution != Items.AIR ? solution : item("acidblood_solution");
        }
        if (machineId.contains("sap_evaporator")) {
            return item("hardened_sap");
        }
        if (machineId.contains("shipment_filler")) {
            return item("shipment_crate");
        }
        return item(inputId + "_processed");
    }

    private boolean canOutput(ItemStack output) {
        output = output.copy();
        output.grow(Math.min(extraOutput(), output.getMaxStackSize() - output.getCount()));
        ItemStack existing = items.get(OUTPUT_SLOT);
        return existing.isEmpty() || (ItemStack.isSameItemSameTags(existing, output)
                && existing.getCount() + output.getCount() <= existing.getMaxStackSize());
    }

    private int effectiveTime(int baseTime) {
        int time = baseTime;
        int speed = moduleCount("speed") + moduleCount("rapid") + moduleCount("accelerat") + moduleCount("overclock");
        int precision = moduleCount("precision") + moduleCount("calibrat");
        time -= speed * 18;
        time -= precision * 8;
        return Math.max(20, time);
    }

    private int effectiveEnergyCost(int baseCost) {
        int cost = baseCost;
        int efficient = moduleCount("efficien") + moduleCount("conserv") + moduleCount("stabil");
        int power = moduleCount("power") + moduleCount("amplifier") + moduleCount("overclock");
        cost -= efficient * Math.max(1, baseCost / 5);
        cost += power * Math.max(1, baseCost / 8);
        return Math.max(1, cost);
    }

    private int extraOutput() {
        int bonus = moduleCount("yield") + moduleCount("duplicat") + moduleCount("replicat");
        if (machineId.contains("duplicator") || machineId.contains("replicator")) {
            bonus++;
        }
        return Math.min(3, bonus);
    }

    private double effectRange(double baseRange) {
        return baseRange + moduleCount("range") * 2.0D + moduleCount("amplifier") * 1.0D;
    }

    private int moduleCount(String token) {
        int count = 0;
        for (int slot = MODULE_START_SLOT; slot <= MODULE_END_SLOT; slot++) {
            String path = itemPath(items.get(slot));
            if ((path.contains("module") && path.contains(token)) || path.contains(token + "_chip") || path.contains(token + "_upgrade")) {
                count++;
            }
        }
        return count;
    }

    private void chargeFromFuel() {
        ItemStack fuel = items.get(FUEL_SLOT);
        if (fuel.isEmpty() || energy >= ENERGY_CAPACITY) {
            return;
        }
        if (canStoreItemEnergy(fuel) && fuel.getOrCreateTag().getInt(ITEM_ENERGY_TAG) > 0) {
            int transfer = Math.min(Math.min(32, fuel.getOrCreateTag().getInt(ITEM_ENERGY_TAG)), ENERGY_CAPACITY - energy);
            fuel.getOrCreateTag().putInt(ITEM_ENERGY_TAG, fuel.getOrCreateTag().getInt(ITEM_ENERGY_TAG) - transfer);
            energy += transfer;
        } else if (isFuel(fuel) && energy <= ENERGY_CAPACITY - 80) {
            energy += consumeFuelEnergy(fuel);
        }
    }

    private static boolean isFuel(ItemStack stack) {
        return stack.is(Items.REDSTONE) || stack.is(Items.COAL) || stack.is(Items.CHARCOAL) || stack.is(Items.COAL_BLOCK)
                || canStoreItemEnergy(stack) || itemPath(stack).contains("fuel") || itemPath(stack).contains("power_cell");
    }

    private static int consumeFuelEnergy(ItemStack fuel) {
        if (fuel.isEmpty()) {
            return 0;
        }
        int amount;
        if (fuel.is(Items.COAL_BLOCK)) {
            amount = 800;
        } else if (fuel.is(Items.REDSTONE)) {
            amount = 60;
        } else if (itemPath(fuel).contains("power_fuel")) {
            amount = 180;
        } else {
            amount = 80;
        }
        fuel.shrink(1);
        return amount;
    }

    private static boolean canStoreItemEnergy(ItemStack stack) {
        String path = itemPath(stack);
        return path.contains("battery") || path.contains("energy_cell") || path.contains("power_cell")
                || path.contains("tesla_core") || path.contains("unpowered_cell") || path.contains("mechanicalpowercell")
                || path.contains("organicpowercell") || (stack.hasTag() && stack.getOrCreateTag().contains(ITEM_ENERGY_TAG));
    }

    private static boolean chargeItem(ItemStack stack, int amount) {
        if (!canStoreItemEnergy(stack)) {
            return false;
        }
        CompoundTag tag = stack.getOrCreateTag();
        int capacity = itemEnergyCapacity(stack);
        int current = Math.max(0, tag.getInt(ITEM_ENERGY_TAG));
        if (current >= capacity) {
            return false;
        }
        tag.putInt(ITEM_ENERGY_TAG, Math.min(capacity, current + amount));
        if (itemPath(stack).contains("cell") || itemPath(stack).contains("battery")) {
            tag.putInt(ITEM_AMMO_TAG, Math.max(tag.getInt(ITEM_AMMO_TAG), tag.getInt(ITEM_ENERGY_TAG) / 8));
        }
        return true;
    }

    private static int itemEnergyCapacity(ItemStack stack) {
        String path = itemPath(stack);
        if (path.contains("tesla")) return 500;
        if (path.contains("power_cell") || path.contains("mechanicalpowercell") || path.contains("organicpowercell")) return 400;
        if (path.contains("battery") || path.contains("energy_cell") || path.contains("unpowered_cell")) return 250;
        return 300;
    }

    private boolean isGenerator() {
        return machineId.contains("generator") || machineId.contains("engine");
    }

    private boolean isPuzzleMachine() {
        return machineId.contains("game") || machineId.contains("dial") || machineId.contains("sequencer")
                || machineId.contains("interpreter") || machineId.contains("emitter") || machineId.contains("navigation");
    }

    private boolean isWeaponMachine() {
        return machineId.contains("shockwave") || machineId.contains("beacon") || machineId.contains("tesla");
    }

    private static Item item(String path) {
        Item item = ForgeRegistries.ITEMS.getValue(ResourceLocation.fromNamespaceAndPath(LostInfinity.MODID, path));
        return item == null ? Items.AIR : item;
    }

    private static String itemPath(ItemStack stack) {
        if (stack.isEmpty()) {
            return "";
        }
        ResourceLocation id = stack.getItem().builtInRegistryHolder().key().location();
        return id.getPath();
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.putString("MachineId", machineId);
        tag.putInt("Progress", progress);
        tag.putInt("ProcessTime", processTime);
        tag.putInt("Energy", energy);
        tag.putInt("PuzzleState", puzzleState);
        tag.putBoolean("Active", active);
        ContainerHelper.saveAllItems(tag, items);
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        machineId = tag.getString("MachineId");
        progress = tag.getInt("Progress");
        processTime = tag.contains("ProcessTime") ? tag.getInt("ProcessTime") : 120;
        energy = tag.getInt("Energy");
        puzzleState = tag.getInt("PuzzleState");
        active = tag.getBoolean("Active");
        ContainerHelper.loadAllItems(tag, items);
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("block.lostinfinity." + machineId);
    }

    @Override
    public AbstractContainerMenu createMenu(int containerId, Inventory playerInventory, Player player) {
        return new LostMachineMenu(containerId, playerInventory, this, data);
    }

    public ContainerData data() {
        return data;
    }

    public String machineId() {
        return machineId;
    }

    public void dropContents(Level level, BlockPos pos) {
        SimpleContainer container = new SimpleContainer(items.size());
        for (int index = 0; index < items.size(); index++) {
            container.setItem(index, items.get(index));
        }
        net.minecraft.world.Containers.dropContents(level, pos, container);
    }

    public int redstoneSignal() {
        if (isPuzzleMachine()) {
            return puzzleState;
        }
        return Math.max(active ? 1 : 0, (int) Math.ceil(energy * 15.0D / ENERGY_CAPACITY));
    }

    @Override
    public int getContainerSize() {
        return items.size();
    }

    @Override
    public boolean isEmpty() {
        return items.stream().allMatch(ItemStack::isEmpty);
    }

    @Override
    public ItemStack getItem(int slot) {
        return items.get(slot);
    }

    @Override
    public ItemStack removeItem(int slot, int amount) {
        ItemStack stack = ContainerHelper.removeItem(items, slot, amount);
        if (!stack.isEmpty()) {
            setChanged();
        }
        return stack;
    }

    @Override
    public ItemStack removeItemNoUpdate(int slot) {
        return ContainerHelper.takeItem(items, slot);
    }

    @Override
    public void setItem(int slot, ItemStack stack) {
        items.set(slot, stack);
        if (stack.getCount() > getMaxStackSize()) {
            stack.setCount(getMaxStackSize());
        }
        setChanged();
    }

    @Override
    public boolean stillValid(Player player) {
        return level != null && level.getBlockEntity(worldPosition) == this
                && player.distanceToSqr(worldPosition.getX() + 0.5D, worldPosition.getY() + 0.5D, worldPosition.getZ() + 0.5D) <= 64.0D;
    }

    @Override
    public void clearContent() {
        items.clear();
        setChanged();
    }

    private record MachineRecipe(ItemStack output, int time, int energyCost, boolean usesCatalyst) {
    }
}
