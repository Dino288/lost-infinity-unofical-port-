package xol.lostinfinity.blockentity;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.NonNullList;
import xol.lostinfinity.block.LostMachineBlock;
import xol.lostinfinity.menu.LostMachineMenu;
import xol.lostinfinity.registry.ModBlockEntities;

public class LostMachineBlockEntity extends BlockEntity implements MenuProvider, Container {
    private final NonNullList<ItemStack> items = NonNullList.withSize(9, ItemStack.EMPTY);
    private String machineId = "lost_machine";
    private int progress;
    private int energy;
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
        boolean hasInput = machine.items.stream().anyMatch(stack -> !stack.isEmpty());
        machine.active = hasInput;
        if (machine.active) {
            machine.progress = (machine.progress + 1) % 200;
            machine.energy = Math.min(machine.energy + 1, 1000);
        } else if (machine.progress != 0) {
            machine.progress = 0;
        }
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.putString("MachineId", machineId);
        tag.putInt("Progress", progress);
        tag.putInt("Energy", energy);
        tag.putBoolean("Active", active);
        ContainerHelper.saveAllItems(tag, items);
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        machineId = tag.getString("MachineId");
        progress = tag.getInt("Progress");
        energy = tag.getInt("Energy");
        active = tag.getBoolean("Active");
        ContainerHelper.loadAllItems(tag, items);
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("block.lostinfinity." + machineId);
    }

    @Override
    public AbstractContainerMenu createMenu(int containerId, Inventory playerInventory, Player player) {
        return new LostMachineMenu(containerId, playerInventory, this);
    }

    public void dropContents(Level level, BlockPos pos) {
        SimpleContainer container = new SimpleContainer(items.size());
        for (int index = 0; index < items.size(); index++) {
            container.setItem(index, items.get(index));
        }
        net.minecraft.world.Containers.dropContents(level, pos, container);
    }

    public int redstoneSignal() {
        int filled = 0;
        for (ItemStack stack : items) {
            if (!stack.isEmpty()) {
                filled++;
            }
        }
        return (int) Math.ceil(filled * 15.0D / items.size());
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
}
