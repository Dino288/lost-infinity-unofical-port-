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
package xol.lostinfinity.util.compatibility.jei.modulator;

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

public class ModulatorRecipeCategory
implements IRecipeCategory {
    private final IDrawable background;
    private final IDrawable icon;
    private final String uid = "lostinfinity.modulator";
    private final String title = "Modulation Station";
    private static final ResourceLocation BACKGROUND_TEXTURE = new ResourceLocation("lostinfinity", "textures/gui/modulator.png");

    public ModulatorRecipeCategory(IGuiHelper guiHelper) {
        this.background = guiHelper.drawableBuilder(BACKGROUND_TEXTURE, 5, 5, 150, 76).build();
        this.icon = guiHelper.createDrawableIngredient((Object)new ItemStack(BlockInit.modulationStation));
    }

    public String getUid() {
        return "lostinfinity.modulator";
    }

    public String getTitle() {
        return "Modulation Station";
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
        guiItemStackGroup.init(0, true, 7, 19);
        guiItemStackGroup.init(1, true, 7, 39);
        guiItemStackGroup.init(2, true, 40, 29);
        guiItemStackGroup.init(3, true, 73, 8);
        guiItemStackGroup.init(4, true, 73, 29);
        guiItemStackGroup.init(5, true, 73, 50);
        guiItemStackGroup.init(6, false, 128, 29);
        guiItemStackGroup.set(ingredients);
    }
}

