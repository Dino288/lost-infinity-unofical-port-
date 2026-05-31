/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.inventory.GuiContainer
 *  net.minecraft.entity.player.Inventory
 *  net.minecraft.inventory.Container
 *  net.minecraft.util.ResourceLocation
 */
package xol.lostinfinity.gui.guis;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.inventory.Container;
import net.minecraft.resources.ResourceLocation;
import xol.lostinfinity.block.tileentity.BlockEntityCthulhuSpawner;
import xol.lostinfinity.gui.containers.ContainerCthulhuSpawner;

public class GuiCthulhuSpawner
extends GuiContainer {
    public static final int WIDTH = 175;
    public static final int HEIGHT = 165;
    private static final ResourceLocation background = new ResourceLocation("lostinfinity", "textures/gui/cthulhu_spawner.png");
    private final Inventory player;
    private final BlockEntityCthulhuSpawner tileentity;

    public GuiCthulhuSpawner(Inventory player, BlockEntityCthulhuSpawner tileEntityCthulhuSpawner) {
        super((Container)new ContainerCthulhuSpawner(player, tileEntityCthulhuSpawner));
        this.player = player;
        this.tileentity = tileEntityCthulhuSpawner;
        this.field_146999_f = 175;
        this.field_147000_g = 165;
    }

    public void func_73863_a(int mouseX, int mouseY, float partialTicks) {
        this.func_146276_q_();
        super.func_73863_a(mouseX, mouseY, partialTicks);
        this.func_191948_b(mouseX, mouseY);
    }

    protected void func_146976_a(float partialTicks, int mouseX, int mouseY) {
        this.field_146297_k.func_110434_K().func_110577_a(background);
        this.func_73729_b(this.field_147003_i, this.field_147009_r, 0, 0, this.field_146999_f, this.field_147000_g);
    }

    protected void func_146979_b(int mouseX, int mouseY) {
        this.field_146289_q.func_78276_b("I.D.R.", 42, 7, 121075);
    }

    private int getBurnLeftScaled(int pixels) {
        int i = this.tileentity.func_174887_a_(1);
        if (i == 0) {
            i = 200;
        }
        return 0;
    }

    private int getCookProgressScaled(int pixels) {
        return 0;
    }
}

