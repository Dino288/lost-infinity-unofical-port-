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

public class LostMachineRecipe implements Recipe<Container> {
    private final ResourceLocation id;
    private final String machine;
    private final Ingredient input;
    private final Ingredient catalyst;
    private final ItemStack output;
    private final int energy;
    private final int time;
    private final boolean consumeCatalyst;
    private final String fluid;

    public LostMachineRecipe(ResourceLocation id, String machine, Ingredient input, Ingredient catalyst, ItemStack output,
                             int energy, int time, boolean consumeCatalyst, String fluid) {
        this.id = id;
        this.machine = machine.toLowerCase(Locale.ROOT);
        this.input = input;
        this.catalyst = catalyst;
        this.output = output;
        this.energy = Math.max(0, energy);
        this.time = Math.max(1, time);
        this.consumeCatalyst = consumeCatalyst;
        this.fluid = fluid;
    }

    @Override
    public boolean matches(Container container, Level level) {
        if (container.getContainerSize() < 1 || !input.test(container.getItem(0))) {
            return false;
        }
        return catalyst.isEmpty() || container.getContainerSize() > 1 && catalyst.test(container.getItem(1));
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

    public int time() {
        return time;
    }

    public boolean consumeCatalyst() {
        return consumeCatalyst;
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
            boolean consumeCatalyst = GsonHelper.getAsBoolean(json, "consume_catalyst", !catalyst.isEmpty());
            String fluid = GsonHelper.getAsString(json, "fluid", "");
            return new LostMachineRecipe(id, machine, input, catalyst, output, energy, time, consumeCatalyst, fluid);
        }

        @Override
        public LostMachineRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf buffer) {
            String machine = buffer.readUtf();
            Ingredient input = Ingredient.fromNetwork(buffer);
            boolean hasCatalyst = buffer.readBoolean();
            Ingredient catalyst = hasCatalyst ? Ingredient.fromNetwork(buffer) : Ingredient.EMPTY;
            ItemStack output = buffer.readItem();
            int energy = buffer.readVarInt();
            int time = buffer.readVarInt();
            boolean consumeCatalyst = buffer.readBoolean();
            String fluid = buffer.readUtf();
            return new LostMachineRecipe(id, machine, input, catalyst, output, energy, time, consumeCatalyst, fluid);
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
            buffer.writeVarInt(recipe.energy);
            buffer.writeVarInt(recipe.time);
            buffer.writeBoolean(recipe.consumeCatalyst);
            buffer.writeUtf(recipe.fluid);
        }
    }
}
