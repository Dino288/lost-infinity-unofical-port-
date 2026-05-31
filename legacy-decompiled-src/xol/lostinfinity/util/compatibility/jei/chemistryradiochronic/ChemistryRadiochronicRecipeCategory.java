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
 *  net.minecraft.client.Minecraft
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.ResourceLocation
 */
package xol.lostinfinity.util.compatibility.jei.chemistryradiochronic;

import javax.annotation.Nullable;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IGuiItemStackGroup;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeCategory;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import xol.lostinfinity.init.ItemInit;

public class ChemistryRadiochronicRecipeCategory
implements IRecipeCategory {
    private final IDrawable background;
    private final IDrawable icon;
    private final String uid = "lostinfinity.chemistryradiochronic";
    private final String title = "Chemistry - Radiochronic";
    private final IDrawable purpleline;
    private final IDrawable greenline;
    private final IDrawable orangeline;
    private static final ResourceLocation BACKGROUND_TEXTURE = new ResourceLocation("lostinfinity", "textures/gui/chemistry_table.png");

    public ChemistryRadiochronicRecipeCategory(IGuiHelper guiHelper) {
        this.background = guiHelper.drawableBuilder(BACKGROUND_TEXTURE, 6, 5, 160, 74).build();
        this.icon = guiHelper.createDrawableIngredient((Object)new ItemStack(ItemInit.radiochronicIsotope));
        this.purpleline = guiHelper.drawableBuilder(BACKGROUND_TEXTURE, 0, 194, 56, 5).build();
        this.greenline = guiHelper.drawableBuilder(BACKGROUND_TEXTURE, 0, 189, 56, 5).build();
        this.orangeline = guiHelper.drawableBuilder(BACKGROUND_TEXTURE, 0, 184, 56, 5).build();
    }

    public String getUid() {
        return "lostinfinity.chemistryradiochronic";
    }

    public String getTitle() {
        return "Chemistry - Radiochronic";
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
        guiItemStackGroup.init(0, true, 11, 6);
        guiItemStackGroup.init(1, true, 11, 28);
        guiItemStackGroup.init(2, true, 11, 50);
        guiItemStackGroup.init(3, false, 135, 29);
        guiItemStackGroup.set(ingredients);
    }

    public void drawExtras(Minecraft minecraft) {
        this.orangeline.draw(minecraft, 66, 63);
        this.greenline.draw(minecraft, 66, 56);
        this.orangeline.draw(minecraft, 66, 49);
        this.greenline.draw(minecraft, 66, 42);
        this.purpleline.draw(minecraft, 66, 35);
        this.purpleline.draw(minecraft, 66, 28);
        this.purpleline.draw(minecraft, 66, 21);
        this.orangeline.draw(minecraft, 66, 14);
        this.greenline.draw(minecraft, 66, 7);
    }
}

