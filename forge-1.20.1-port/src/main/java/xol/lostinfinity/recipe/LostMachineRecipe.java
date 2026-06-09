package xol.lostinfinity.recipe;

import com.google.gson.JsonObject;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.nbt.TagParser;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.ShapedRecipe;
import net.minecraft.world.level.Level;
import xol.lostinfinity.registry.ModRecipeTypes;

import java.util.Locale;
import java.util.ArrayList;
import java.util.List;

public class LostMachineRecipe implements Recipe<Container> {
    private final ResourceLocation id;
    private final String machine;
    private final Ingredient input;
    private final Ingredient catalyst;
    private final List<Ingredient> extras;
    private final ItemStack output;
    private final int inputCount;
    private final int energy;
    private final int time;
    private final boolean consumeCatalyst;
    private final boolean consumeExtras;
    private final String fluid;

    public LostMachineRecipe(ResourceLocation id, String machine, Ingredient input, Ingredient catalyst, ItemStack output,
                             int inputCount, int energy, int time, boolean consumeCatalyst, boolean consumeExtras, String fluid,
                             List<Ingredient> extras) {
        this.id = id;
        this.machine = machine.toLowerCase(Locale.ROOT);
        this.input = input;
        this.catalyst = catalyst;
        this.extras = List.copyOf(extras);
        this.output = output;
        this.inputCount = Math.max(1, inputCount);
        this.energy = Math.max(0, energy);
        this.time = Math.max(1, time);
        this.consumeCatalyst = consumeCatalyst;
        this.consumeExtras = consumeExtras;
        this.fluid = fluid;
    }

    @Override
    public boolean matches(Container container, Level level) {
        if (container.getContainerSize() < 1 || !input.test(container.getItem(0))) {
            return false;
        }
        if (container.getItem(0).getCount() < inputCount) {
            return false;
        }
        if (!catalyst.isEmpty() && (container.getContainerSize() <= 1 || !catalyst.test(container.getItem(1)))) {
            return false;
        }
        return extrasMatch(container);
    }

    private boolean extrasMatch(Container container) {
        if (extras.isEmpty()) {
            return true;
        }
        if (container.getContainerSize() <= 3) {
            return false;
        }
        boolean[] used = new boolean[container.getContainerSize()];
        for (Ingredient extra : extras) {
            boolean matched = false;
            int end = Math.min(container.getContainerSize(), 8);
            for (int slot = 3; slot < end; slot++) {
                if (!used[slot] && extra.test(container.getItem(slot))) {
                    used[slot] = true;
                    matched = true;
                    break;
                }
            }
            if (!matched) {
                return false;
            }
        }
        return true;
    }

    public boolean matchesMachine(String machineId) {
        String current = machineId.toLowerCase(Locale.ROOT);
        return machine.isBlank() || current.contains(machine) || machine.contains(current);
    }

    @Override
    public ItemStack assemble(Container container, net.minecraft.core.RegistryAccess registryAccess) {
        return output.copy();
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getResultItem(net.minecraft.core.RegistryAccess registryAccess) {
        return output.copy();
    }

    public ItemStack output() {
        return output.copy();
    }

    public int energy() {
        return energy;
    }

    public int inputCount() {
        return inputCount;
    }

    public int time() {
        return time;
    }

    public boolean consumeCatalyst() {
        return consumeCatalyst;
    }

    public boolean consumeExtras() {
        return consumeExtras;
    }

    public List<Ingredient> extras() {
        return extras;
    }

    public String fluid() {
        return fluid;
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipeTypes.MACHINE_SERIALIZER.get();
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipeTypes.MACHINE;
    }

    public static class Serializer implements RecipeSerializer<LostMachineRecipe> {
        @Override
        public LostMachineRecipe fromJson(ResourceLocation id, JsonObject json) {
            String machine = GsonHelper.getAsString(json, "machine", "");
            Ingredient input = Ingredient.fromJson(GsonHelper.getAsJsonObject(json, "input"));
            Ingredient catalyst = json.has("catalyst") ? Ingredient.fromJson(GsonHelper.getAsJsonObject(json, "catalyst")) : Ingredient.EMPTY;
            JsonObject outputJson = GsonHelper.getAsJsonObject(json, "output");
            ItemStack output = ShapedRecipe.itemStackFromJson(outputJson);
            if (outputJson.has("nbt")) {
                try {
                    output.setTag(TagParser.parseTag(GsonHelper.getAsString(outputJson, "nbt")));
                } catch (CommandSyntaxException exception) {
                    throw new IllegalArgumentException("Invalid NBT for Lost Infinity machine recipe " + id, exception);
                }
            }
            int energy = GsonHelper.getAsInt(json, "energy", 35);
            int time = GsonHelper.getAsInt(json, "time", 120);
            int inputCount = GsonHelper.getAsInt(json, "input_count", 1);
            boolean consumeCatalyst = GsonHelper.getAsBoolean(json, "consume_catalyst", !catalyst.isEmpty());
            List<Ingredient> extras = new ArrayList<>();
            if (json.has("extras")) {
                json.getAsJsonArray("extras").forEach(element -> extras.add(Ingredient.fromJson(element)));
            }
            boolean consumeExtras = GsonHelper.getAsBoolean(json, "consume_extras", !extras.isEmpty());
            String fluid = GsonHelper.getAsString(json, "fluid", "");
            return new LostMachineRecipe(id, machine, input, catalyst, output, inputCount, energy, time, consumeCatalyst, consumeExtras, fluid, extras);
        }

        @Override
        public LostMachineRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf buffer) {
            String machine = buffer.readUtf();
            Ingredient input = Ingredient.fromNetwork(buffer);
            boolean hasCatalyst = buffer.readBoolean();
            Ingredient catalyst = hasCatalyst ? Ingredient.fromNetwork(buffer) : Ingredient.EMPTY;
            ItemStack output = buffer.readItem();
            int inputCount = buffer.readVarInt();
            int energy = buffer.readVarInt();
            int time = buffer.readVarInt();
            boolean consumeCatalyst = buffer.readBoolean();
            boolean consumeExtras = buffer.readBoolean();
            String fluid = buffer.readUtf();
            List<Ingredient> extras = new ArrayList<>();
            int extraCount = buffer.readVarInt();
            for (int index = 0; index < extraCount; index++) {
                extras.add(Ingredient.fromNetwork(buffer));
            }
            return new LostMachineRecipe(id, machine, input, catalyst, output, inputCount, energy, time, consumeCatalyst, consumeExtras, fluid, extras);
        }

        @Override
        public void toNetwork(FriendlyByteBuf buffer, LostMachineRecipe recipe) {
            buffer.writeUtf(recipe.machine);
            recipe.input.toNetwork(buffer);
            buffer.writeBoolean(!recipe.catalyst.isEmpty());
            if (!recipe.catalyst.isEmpty()) {
                recipe.catalyst.toNetwork(buffer);
            }
            buffer.writeItem(recipe.output);
            buffer.writeVarInt(recipe.inputCount);
            buffer.writeVarInt(recipe.energy);
            buffer.writeVarInt(recipe.time);
            buffer.writeBoolean(recipe.consumeCatalyst);
            buffer.writeBoolean(recipe.consumeExtras);
            buffer.writeUtf(recipe.fluid);
            buffer.writeVarInt(recipe.extras.size());
            recipe.extras.forEach(extra -> extra.toNetwork(buffer));
        }
    }
}
