/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  mezz.jei.api.IGuiHelper
 *  mezz.jei.api.gui.IDrawable
 *  mezz.jei.api.gui.IDrawableAnimated
 *  mezz.jei.api.gui.IDrawableAnimated$StartDirection
 *  mezz.jei.api.gui.IGuiItemStackGroup
 *  mezz.jei.api.gui.IRecipeLayout
 *  mezz.jei.api.ingredients.IIngredients
 *  mezz.jei.api.recipe.IRecipeCategory
 *  mezz.jei.api.recipe.IRecipeWrapper
 *  net.minecraft.client.Minecraft
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.ResourceLocation
 */
package xol.lostinfinity.util.compatibility.jei.compressiontable;

import javax.annotation.Nullable;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IDrawableAnimated;
import mezz.jei.api.gui.IGuiItemStackGroup;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeCategory;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import xol.lostinfinity.init.BlockInit;

public class CompressionTableRecipeCategory
implements IRecipeCategory {
    private final IDrawable background;
    private final IDrawable icon;
    private final String uid = "lostinfinity.compressiontable";
    private final String title = "Compression Table";
    protected final IDrawableAnimated arrow;
    private static final ResourceLocation BACKGROUND_TEXTURE = new ResourceLocation("lostinfinity", "textures/gui/compression_table.png");

    public CompressionTableRecipeCategory(IGuiHelper guiHelper) {
        this.background = guiHelper.drawableBuilder(BACKGROUND_TEXTURE, 20, 14, 125, 60).build();
        this.icon = guiHelper.createDrawableIngredient((Object)new ItemStack(BlockInit.compressionTable));
        this.arrow = guiHelper.drawableBuilder(new ResourceLocation("jei", "textures/gui/gui_vanilla.png"), 82, 128, 25, 17).buildAnimated(200, IDrawableAnimated.StartDirection.LEFT, false);
    }

    public String getUid() {
        return "lostinfinity.compressiontable";
    }

    public String getTitle() {
        return "Compression Table";
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
        guiItemStackGroup.init(0, true, 18, 20);
        guiItemStackGroup.init(1, false, 95, 20);
        guiItemStackGroup.set(ingredients);
    }

    public void drawExtras(Minecraft minecraft) {
        this.arrow.draw(minecraft, 55, 20);
    }
}

