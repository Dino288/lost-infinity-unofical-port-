/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  mezz.jei.api.IGuiHelper
 *  mezz.jei.api.gui.IDrawable
 *  mezz.jei.api.gui.IGuiItemStackGroup
 *  mezz.jei.api.gui.IRecipeLayout
 *  mezz.jei.api.ingredients.IIngredients
 *  mezz.jei.api.recipe.IRecipeCategory
 *  mezz.jei.api.recipe.IRecipeWrapper
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.ResourceLocation
 */
package xol.lostinfinity.util.compatibility.jei.fossilcombiner;

import javax.annotation.Nullable;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IGuiItemStackGroup;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeCategory;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import xol.lostinfinity.init.BlockInit;

public class FossilCombinerRecipeCategory
implements IRecipeCategory {
    private final IDrawable background;
    private final IDrawable icon;
    private final String uid = "lostinfinity.fossilcombiner";
    private final String title = "Fossil Combiner";
    private static final ResourceLocation BACKGROUND_TEXTURE = new ResourceLocation("lostinfinity", "textures/gui/fossil_combiner.png");

    public FossilCombinerRecipeCategory(IGuiHelper guiHelper) {
        this.background = guiHelper.drawableBuilder(BACKGROUND_TEXTURE, 5, 5, 150, 76).build();
        this.icon = guiHelper.createDrawableIngredient((Object)new ItemStack(BlockInit.fossilCombiner));
    }

    public String getUid() {
        return "lostinfinity.fossilcombiner";
    }

    public String getTitle() {
        return "Fossil Combiner";
    }

    public String getModName() {
        return "Lost Infinity Stones";
    }

    public IDrawable getBackground() {
        return this.background;
    }

    @Nullable
    public IDrawable getIcon() {
        return this.icon;
    }

    public void setRecipe(IRecipeLayout recipeLayout, IRecipeWrapper recipeWrapper, IIngredients ingredients) {
        IGuiItemStackGroup guiItemStackGroup = recipeLayout.getItemStacks();
        guiItemStackGroup.init(0, true, 3, 10);
        guiItemStackGroup.init(1, true, 22, 10);
        guiItemStackGroup.init(2, true, 41, 10);
        guiItemStackGroup.init(3, true, 60, 10);
        guiItemStackGroup.init(4, true, 79, 10);
        guiItemStackGroup.init(5, true, 3, 29);
        guiItemStackGroup.init(6, true, 22, 29);
        guiItemStackGroup.init(7, true, 41, 29);
        guiItemStackGroup.init(8, true, 60, 29);
        guiItemStackGroup.init(9, true, 79, 29);
        guiItemStackGroup.init(10, true, 3, 50);
        guiItemStackGroup.init(11, true, 22, 50);
        guiItemStackGroup.init(12, true, 41, 50);
        guiItemStackGroup.init(13, true, 60, 50);
        guiItemStackGroup.init(14, true, 79, 50);
        guiItemStackGroup.init(15, false, 128, 29);
        guiItemStackGroup.set(ingredients);
    }
}

