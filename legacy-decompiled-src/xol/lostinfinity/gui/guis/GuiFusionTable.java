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

import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.inventory.Container;
import net.minecraft.resources.ResourceLocation;
import xol.lostinfinity.block.tileentity.BlockEntityFusionTable;
import xol.lostinfinity.common.lostinfinity;
import xol.lostinfinity.common.packets.serverbound.PacketFusionTable;
import xol.lostinfinity.gui.containers.ContainerFusionTable;
import xol.lostinfinity.init.SoundInit;

public class GuiFusionTable
extends GuiContainer {
    private static final ResourceLocation texture = new ResourceLocation("lostinfinity", "textures/gui/fusion_table.png");
    private static final int SHAPE_WIDTH = 12;
    private static final int SHAPE_HEIGHT = 12;
    private final BlockEntityFusionTable tileEntity;
    private final Inventory invPlayer;

    public GuiFusionTable(Inventory invPlayer, BlockEntityFusionTable tileEntity) {
        super((Container)new ContainerFusionTable(invPlayer, tileEntity));
        this.tileEntity = tileEntity;
        this.invPlayer = invPlayer;
    }

    protected void func_146976_a(float partialTicks, int mouseX, int mouseY) {
        this.field_146297_k.func_110434_K().func_110577_a(texture);
        this.func_73729_b(this.field_147003_i, this.field_147009_r, 0, 0, this.field_146999_f, this.field_147000_g);
        int boardX = this.field_147003_i + 40;
        int boardY = this.field_147009_r + 16;
        int gap = 5;
        int gap2 = 4;
        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j < 6; ++j) {
                int offsetX = boardX + 12 * j + gap * j;
                int offsetY = boardY + 12 * i + gap * i;
                int boardIndex = i * 6 + j;
                if (this.tileEntity.func_174887_a_(boardIndex) > 0 && this.tileEntity.func_174887_a_(boardIndex) < 6) {
                    this.func_73729_b(offsetX, offsetY, BlockEntityFusionTable.Shapes.getShapeFromId(this.tileEntity.func_174887_a_(boardIndex)).getPixelX(), BlockEntityFusionTable.Shapes.getShapeFromId(this.tileEntity.func_174887_a_(boardIndex)).getPixelY(), 12, 12);
                }
                int offSetX2 = this.field_147003_i + 39 + 13 * j + gap2 * j;
                int offSetY2 = this.field_147009_r + 15 + 13 * i + gap2 * i;
                if (!this.isInRect(offsetX, offsetY, 12, 12, mouseX, mouseY) || this.tileEntity.func_174887_a_(boardIndex) > 0 && this.tileEntity.func_174887_a_(boardIndex) < 6) continue;
                this.func_73729_b(offSetX2, offSetY2, 0, 186, 14, 14);
            }
        }
        int upcomingX1 = this.field_147003_i + 21;
        int upcomingY1 = this.field_147009_r + 65;
        if (this.tileEntity.func_174887_a_(24) > 0) {
            this.func_73729_b(upcomingX1, upcomingY1, BlockEntityFusionTable.Shapes.getShapeFromId(this.tileEntity.func_174887_a_(24)).getPixelX(), BlockEntityFusionTable.Shapes.getShapeFromId(this.tileEntity.func_174887_a_(24)).getPixelY(), 12, 12);
        }
        int upcomingX2 = this.field_147003_i + 21;
        int upcomingY2 = this.field_147009_r + 50;
        if (this.tileEntity.func_174887_a_(25) > 0) {
            this.func_73729_b(upcomingX2, upcomingY2, BlockEntityFusionTable.Shapes.getShapeFromId(this.tileEntity.func_174887_a_(25)).getPixelX(), BlockEntityFusionTable.Shapes.getShapeFromId(this.tileEntity.func_174887_a_(25)).getPixelY(), 12, 12);
        }
        int progressX = this.field_147003_i + 39;
        int progressY = this.field_147009_r + 5;
        int progressWidth = 14;
        int progressHeight = 8;
        int gap3 = 3;
        for (int i = 0; i < this.tileEntity.func_174887_a_(27); ++i) {
            int offsetX = progressX + progressWidth * i + gap3 * i;
            this.func_73729_b(offsetX, progressY, 0, 178, progressWidth, progressHeight);
        }
    }

    protected void func_73864_a(int mouseX, int mouseY, int mouseButton) throws IOException {
        super.func_73864_a(mouseX, mouseY, mouseButton);
        int boardX = this.field_147003_i + 40;
        int boardY = this.field_147009_r + 16;
        int gap = 5;
        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j < 6; ++j) {
                int offsetX = boardX + 12 * j + gap * j;
                int offsetY = boardY + 12 * i + gap * i;
                int boardIndex = i * 6 + j;
                if (!this.isInRect(offsetX, offsetY, 12, 12, mouseX, mouseY) || this.tileEntity.func_174887_a_(boardIndex) > 0 && this.tileEntity.func_174887_a_(boardIndex) < 6) continue;
                lostinfinity.instance.packetHandler.sendServerBasicPacket(new PacketFusionTable(this.tileEntity.func_174877_v(), this.tileEntity.func_174887_a_(24), boardIndex));
                this.tileEntity.func_174885_b(24, this.tileEntity.func_174887_a_(25));
                this.tileEntity.func_174885_b(25, ThreadLocalRandom.current().nextInt(1, 6));
                lostinfinity.instance.packetHandler.sendServerBasicPacket(new PacketFusionTable(this.tileEntity.func_174877_v(), this.tileEntity.func_174887_a_(24), 24));
                lostinfinity.instance.packetHandler.sendServerBasicPacket(new PacketFusionTable(this.tileEntity.func_174877_v(), this.tileEntity.func_174887_a_(25), 25));
                this.invPlayer.field_70458_d.func_184185_a(SoundInit.GENERIC_UI_5, 1.0f, 1.0f);
            }
        }
    }

    private boolean isInRect(int x, int y, int xSize, int ySize, int mouseX, int mouseY) {
        return mouseX >= x && mouseX <= x + xSize && mouseY >= y && mouseY <= y + ySize;
    }
}

