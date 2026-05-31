/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.inventory.GuiContainer
 *  net.minecraft.inventory.Container
 *  net.minecraft.inventory.IInventory
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.ResourceLocation
 */
package xol.lostinfinity.gui.guis;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import xol.lostinfinity.gui.containers.ContainerAugmentor;
import xol.lostinfinity.item.misc.ItemAugmentSlide;

public class GuiAugmentor
extends GuiContainer {
    public static final int WIDTH = 175;
    public static final int HEIGHT = 165;
    private static final ResourceLocation background = new ResourceLocation("lostinfinity", "textures/gui/augmentor.png");

    public GuiAugmentor(IInventory inventory) {
        super((Container)new ContainerAugmentor(inventory));
        this.field_146999_f = 175;
        this.field_147000_g = 165;
    }

    public void func_73863_a(int mouseX, int mouseY, float partialTicks) {
        super.func_73863_a(mouseX, mouseY, partialTicks);
        this.func_191948_b(mouseX, mouseY);
    }

    protected void func_146976_a(float partialTicks, int mouseX, int mouseY) {
        this.field_146297_k.func_110434_K().func_110577_a(background);
        this.func_73729_b(this.field_147003_i, this.field_147009_r, 0, 0, this.field_146999_f, this.field_147000_g);
        this.func_73729_b(this.field_147003_i + 59, this.field_147009_r + 20, 0, this.field_147000_g + 1, 110, 16);
    }

    protected void func_146979_b(int mouseX, int mouseY) {
        ItemStack slideStack = this.field_147002_h.func_75139_a(1).func_75211_c();
        if (slideStack.func_77973_b() instanceof ItemAugmentSlide) {
            ItemAugmentSlide slide = (ItemAugmentSlide)slideStack.func_77973_b();
            this.field_146289_q.func_78276_b(slide.type.description, 62, 24, 0x404040);
        }
        this.field_146289_q.func_78276_b("Augmentor", 60, 6, 0x404040);
        this.field_146289_q.func_78276_b("Inventory", 8, this.field_147000_g - 96 + 2, 0x404040);
    }
}

