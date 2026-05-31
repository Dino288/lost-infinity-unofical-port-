/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  mezz.jei.api.IGuiHelper
 *  mezz.jei.api.gui.IDrawable
 *  mezz.jei.api.gui.IDrawableAnimated
 *  mezz.jei.api.gui.IDrawableAnimated$StartDirection
 *  mezz.jei.api.gui.IDrawableStatic
 *  mezz.jei.api.gui.IGuiItemStackGroup
 *  mezz.jei.api.gui.IRecipeLayout
 *  mezz.jei.api.ingredients.IIngredients
 *  mezz.jei.api.recipe.IRecipeCategory
 *  mezz.jei.api.recipe.IRecipeWrapper
 *  net.minecraft.client.Minecraft
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.ResourceLocation
 */
package xol.lostinfinity.util.compatibility.jei.sapevaporator;

import javax.annotation.Nullable;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IDrawableAnimated;
import mezz.jei.api.gui.IDrawableStatic;
import mezz.jei.api.gui.IGuiItemStackGroup;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeCategory;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import xol.lostinfinity.init.BlockInit;

public class SapEvaporatorRecipeCategory
implements IRecipeCategory {
    private final IDrawable background;
    private final IDrawable icon;
    private final String uid = "lostinfinity.sapevaporator";
    private final String title = "Sap Evaporator";
    protected final IDrawableAnimated arrow;
    protected final IDrawableStatic staticFlame;
    protected final IDrawableAnimated animatedFlame;
    private static final ResourceLocation BACKGROUND_TEXTURE = new ResourceLocation("lostinfinity", "textures/gui/sap_evaporator.png");

    public SapEvaporatorRecipeCategory(IGuiHelper guiHelper) {
        this.background = guiHelper.drawableBuilder(BACKGROUND_TEXTURE, 5, 14, 120, 65).build();
        this.icon = guiHelper.createDrawableIngredient((Object)new ItemStack(BlockInit.sapEvaporator));
        this.staticFlame = guiHelper.createDrawable(new ResourceLocation("jei", "textures/gui/gui_vanilla.png"), 82, 114, 14, 14);
        this.animatedFlame = guiHelper.createAnimatedDrawable(this.staticFlame, 300, IDrawableAnimated.StartDirection.TOP, true);
        this.arrow = guiHelper.drawableBuilder(new ResourceLocation("jei", "textures/gui/gui_vanilla.png"), 82, 128, 25, 17).buildAnimated(200, IDrawableAnimated.StartDirection.LEFT, false);
    }

    public String getUid() {
        return "lostinfinity.sapevaporator";
    }

    public String getTitle() {
        return "Sap Evaporator";
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
        guiItemStackGroup.init(1, true, 11, 42);
        guiItemStackGroup.init(2, false, 92, 24);
        guiItemStackGroup.set(ingredients);
    }

    public void drawExtras(Minecraft minecraft) {
        this.arrow.draw(minecraft, 62, 25);
        this.animatedFlame.draw(minecraft, 12, 25);
    }
}

