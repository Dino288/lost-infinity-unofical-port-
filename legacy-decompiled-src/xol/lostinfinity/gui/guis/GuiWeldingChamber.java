/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.inventory.GuiContainer
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.entity.player.Inventory
 *  net.minecraft.inventory.Container
 *  net.minecraft.util.ResourceLocation
 */
package xol.lostinfinity.gui.guis;

import java.io.IOException;
import java.util.ArrayList;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.inventory.Container;
import net.minecraft.resources.ResourceLocation;
import xol.lostinfinity.block.tileentity.BlockEntityWeldingChamber;
import xol.lostinfinity.common.lostinfinity;
import xol.lostinfinity.common.packets.serverbound.PacketWeldingChamber;
import xol.lostinfinity.gui.containers.ContainerWeldingChamber;
import xol.lostinfinity.init.SoundInit;

public class GuiWeldingChamber
extends GuiContainer {
    private static final ResourceLocation texture = new ResourceLocation("lostinfinity", "textures/gui/welding_chamber.png");
    private final BlockEntityWeldingChamber tileEntity;
    private final Inventory invPlayer;

    public GuiWeldingChamber(Inventory invPlayer, BlockEntityWeldingChamber tileEntity) {
        super((Container)new ContainerWeldingChamber(invPlayer, tileEntity));
        this.invPlayer = invPlayer;
        this.tileEntity = tileEntity;
    }

    protected void func_146979_b(int mouseX, int mouseY) {
        ArrayList<String> hoverText;
        this.field_146289_q.func_78276_b("Welding Chamber", 51, 6, 0x404040);
        int progressWidth = 98;
        int progressHeight = 14;
        int progressX = 38;
        int progressY = 27;
        int acetyleneWidth = 98;
        int acetyleneHeight = 8;
        int acetyleneX = 38;
        int acetyleneY = 45;
        int heatWidth = 98;
        int heatHeight = 8;
        int heatX = 38;
        int heatY = 15;
        if (this.isInRect(this.field_147003_i + progressX, this.field_147009_r + progressY, progressWidth, progressHeight, mouseX, mouseY)) {
            hoverText = new ArrayList<String>();
            int percent = this.smeltProgressToPercent();
            hoverText.add("Welding Progress:");
            hoverText.add(percent + "%");
            this.drawHoveringText(hoverText, mouseX - this.field_147003_i, mouseY - this.field_147009_r, this.field_146289_q);
        }
        if (this.isInRect(this.field_147003_i + acetyleneX, this.field_147009_r + acetyleneY, acetyleneWidth, acetyleneHeight, mouseX, mouseY)) {
            hoverText = new ArrayList();
            int level = this.tileEntity.func_174887_a_(2);
            hoverText.add("Acetylene Level:");
            hoverText.add(level + "/7");
            this.drawHoveringText(hoverText, mouseX - this.field_147003_i, mouseY - this.field_147009_r, this.field_146289_q);
        }
        if (this.isInRect(this.field_147003_i + heatX, this.field_147009_r + heatY, heatWidth, heatHeight, mouseX, mouseY)) {
            hoverText = new ArrayList();
            int heat = this.tileEntity.func_174887_a_(1);
            hoverText.add("Heat:");
            hoverText.add(heat + "C");
            this.drawHoveringText(hoverText, mouseX - this.field_147003_i, mouseY - this.field_147009_r, this.field_146289_q);
        }
    }

    protected void func_146976_a(float partialTicks, int mouseX, int mouseY) {
        this.field_146297_k.func_110434_K().func_110577_a(texture);
        this.func_73729_b(this.field_147003_i, this.field_147009_r, 0, 0, this.field_146999_f, this.field_147000_g);
        int acetyleneWidth = 98;
        int acetyleneHeight = 8;
        int acetyleneX = this.field_147003_i + 38;
        int acetyleneY = this.field_147009_r + 45;
        int acetyleneLevel = this.tileEntity.func_174887_a_(2);
        int acetyleneLevelWidth = acetyleneWidth * acetyleneLevel / 7;
        int buttonWidth = 17;
        int buttonHeight = 14;
        int greenButtonX = this.field_147003_i + 119;
        int greenButtonY = this.field_147009_r + 57;
        int redButtonX = this.field_147003_i + 39;
        int redButtonY = this.field_147009_r + 57;
        int heatWidth = 98;
        int heatHeight = 8;
        int heatX = this.field_147003_i + 38;
        int heatY = this.field_147009_r + 15;
        int heatProgressWidth = this.heatProgressPercent() * heatWidth / 100;
        int progressWidth = 98;
        int progressHeight = 14;
        int progressX = this.field_147003_i + 38;
        int progressY = this.field_147009_r + 27;
        int currentProgressWidth = this.smeltProgressToPercent() * progressWidth / 100;
        this.func_73729_b(acetyleneX, acetyleneY, 0, 218, acetyleneLevelWidth, acetyleneHeight);
        if (this.isInRect(greenButtonX, greenButtonY, buttonWidth, buttonHeight, mouseX, mouseY)) {
            this.func_73729_b(greenButtonX, greenButtonY, 18, 228, buttonWidth, buttonHeight);
        }
        if (this.isInRect(redButtonX, redButtonY, buttonWidth, buttonHeight, mouseX, mouseY)) {
            this.func_73729_b(redButtonX, redButtonY, 18, 242, buttonWidth, buttonHeight);
        }
        this.func_73729_b(progressX, progressY, 0, 182, currentProgressWidth, progressHeight);
        this.func_73729_b(heatX, heatY, 0, 208, heatProgressWidth, heatHeight);
    }

    public void func_73863_a(int mouseX, int mouseY, float partialTicks) {
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        this.func_146276_q_();
        super.func_73863_a(mouseX, mouseY, partialTicks);
        this.func_191948_b(mouseX, mouseY);
        GlStateManager.func_179140_f();
        GlStateManager.func_179084_k();
    }

    protected void func_73864_a(int mouseX, int mouseY, int mouseButton) throws IOException {
        super.func_73864_a(mouseX, mouseY, mouseButton);
        int buttonWidth = 17;
        int buttonHeight = 14;
        int greenButtonX = this.field_147003_i + 119;
        int greenButtonY = this.field_147009_r + 57;
        int redButtonX = this.field_147003_i + 39;
        int redButtonY = this.field_147009_r + 57;
        if (this.isInRect(greenButtonX, greenButtonY, buttonWidth, buttonHeight, mouseX, mouseY)) {
            lostinfinity.instance.packetHandler.sendServerBasicPacket(new PacketWeldingChamber(this.tileEntity.func_174877_v(), this.tileEntity.func_174887_a_(2) + 1));
            this.invPlayer.field_70458_d.func_184185_a(SoundInit.GENERIC_UI_5, 1.0f, 1.0f);
        }
        if (this.isInRect(redButtonX, redButtonY, buttonWidth, buttonHeight, mouseX, mouseY)) {
            lostinfinity.instance.packetHandler.sendServerBasicPacket(new PacketWeldingChamber(this.tileEntity.func_174877_v(), this.tileEntity.func_174887_a_(2) - 1));
            this.invPlayer.field_70458_d.func_184185_a(SoundInit.GENERIC_UI_5, 1.0f, 1.0f);
        }
    }

    private boolean isInRect(int x, int y, int xSize, int ySize, int mouseX, int mouseY) {
        return mouseX >= x && mouseX <= x + xSize && mouseY >= y && mouseY <= y + ySize;
    }

    public int smeltProgressToPercent() {
        if (this.tileEntity.func_174887_a_(0) == 0) {
            return 0;
        }
        return this.tileEntity.func_174887_a_(0) * 100 / this.tileEntity.getSmeltTime();
    }

    public int heatProgressPercent() {
        if (this.tileEntity.func_174887_a_(1) == 0) {
            return 0;
        }
        return this.tileEntity.func_174887_a_(1) * 100 / this.tileEntity.getMaxHeat();
    }
}

