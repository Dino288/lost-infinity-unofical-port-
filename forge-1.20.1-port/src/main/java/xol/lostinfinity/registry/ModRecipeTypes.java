package xol.lostinfinity.registry;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import xol.lostinfinity.LostInfinity;
import xol.lostinfinity.recipe.LostMachineRecipe;

public final class ModRecipeTypes {
    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, LostInfinity.MODID);

    public static final RecipeType<LostMachineRecipe> MACHINE =
            RecipeType.simple(new ResourceLocation(LostInfinity.MODID, "machine"));

    public static final RegistryObject<RecipeSerializer<?>> MACHINE_SERIALIZER =
            RECIPE_SERIALIZERS.register("machine", LostMachineRecipe.Serializer::new);

    private ModRecipeTypes() {
    }
}
