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
package xol.lostinfinity.util.compatibility.jei.mysterybox;

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

public class MysteryBoxRecipeCategory
implements IRecipeCategory {
    private final IDrawable background;
    private final IDrawable icon;
    private final String uid = "lostinfinity.mysterybox";
    private final String title = "Mystery Box";
    private static final ResourceLocation BACKGROUND_TEXTURE = new ResourceLocation("lostinfinity", "textures/gui/jei_mysterybox.png");

    public MysteryBoxRecipeCategory(IGuiHelper guiHelper) {
        this.background = guiHelper.drawableBuilder(BACKGROUND_TEXTURE, 1, 2, 166, 130).addPadding(0, 0, 3, 0).build();
        this.icon = guiHelper.createDrawableIngredient((Object)new ItemStack(ItemInit.mysteryBox));
    }

    public String getUid() {
        return "lostinfinity.mysterybox";
    }

    public String getTitle() {
        return "Mystery Box";
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
        guiItemStackGroup.init(0, true, 77, 13);
        guiItemStackGroup.init(1, false, 3, 53);
        guiItemStackGroup.init(2, false, 21, 53);
        guiItemStackGroup.init(3, false, 39, 53);
        guiItemStackGroup.init(4, false, 57, 53);
        guiItemStackGroup.init(5, false, 75, 53);
        guiItemStackGroup.init(6, false, 93, 53);
        guiItemStackGroup.init(7, false, 111, 53);
        guiItemStackGroup.init(8, false, 129, 53);
        guiItemStackGroup.init(9, false, 147, 53);
        guiItemStackGroup.init(10, false, 3, 72);
        guiItemStackGroup.init(11, false, 21, 72);
        guiItemStackGroup.init(12, false, 39, 72);
        guiItemStackGroup.set(ingredients);
    }

    public void drawExtras(Minecraft minecraft) {
    }
}

