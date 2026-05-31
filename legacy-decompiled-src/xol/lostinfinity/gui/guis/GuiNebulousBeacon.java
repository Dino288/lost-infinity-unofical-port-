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
import xol.lostinfinity.block.tileentity.BlockEntityNebulousBeacon;
import xol.lostinfinity.gui.containers.ContainerNebulousBeacon;
import xol.lostinfinity.util.client.GuiUtil;

public class GuiNebulousBeacon
extends GuiContainer {
    private static final boolean DEBUG = false;
    private static final ResourceLocation TEXTURE = new ResourceLocation("lostinfinity", "textures/gui/nebulous_beacon.png");
    private final BlockEntityNebulousBeacon tileEntity;

    public GuiNebulousBeacon(Inventory invPlayer, BlockEntityNebulousBeacon tileEntity) {
        super((Container)new ContainerNebulousBeacon(invPlayer, tileEntity));
        this.tileEntity = tileEntity;
    }

    protected void func_146976_a(float partialTicks, int mouseX, int mouseY) {
        this.field_146297_k.func_110434_K().func_110577_a(TEXTURE);
        this.func_73729_b(this.field_147003_i, this.field_147009_r, 0, 0, this.field_146999_f, this.field_147000_g);
        int healthX = this.field_147003_i + 17;
        int healthY = this.field_147009_r + 24;
        int healthWidth = 141;
        int healthHeight = 9;
        this.func_73729_b(healthX, healthY, 0, 182, (int)((float)healthWidth * ((float)this.tileEntity.getCurrentHealth() / 100.0f)), healthHeight);
        int progressX = this.field_147003_i + 17;
        int progressY = this.field_147009_r + 58;
        int progressWidth = 141;
        int progressHeight = 15;
        this.func_73729_b(progressX, progressY, 0, 166, (int)((float)progressWidth * ((float)this.tileEntity.getCurrentDuration() / 4800.0f)), progressHeight);
        if (GuiUtil.isInRect(healthX, healthY, healthWidth, healthHeight, mouseX, mouseY)) {
            this.func_146279_a(this.tileEntity.getCurrentHealth() + "/" + 100, mouseX, mouseY);
        }
        if (GuiUtil.isInRect(progressX, progressY, progressWidth, progressHeight, mouseX, mouseY)) {
            this.func_146279_a(this.tileEntity.getCurrentDuration() + "/" + 4800 + " J", mouseX, mouseY);
        }
    }
}

