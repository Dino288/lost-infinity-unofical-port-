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
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.inventory.Container;
import net.minecraft.resources.ResourceLocation;
import xol.lostinfinity.block.tileentity.BlockEntityChemistryTable;
import xol.lostinfinity.common.lostinfinity;
import xol.lostinfinity.common.packets.serverbound.PacketChemistryTable;
import xol.lostinfinity.gui.containers.ContainerChemistryTable;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.util.client.GuiUtil;

public class GuiChemistryTable
extends GuiContainer {
    private static final ResourceLocation TEXTURE = new ResourceLocation("lostinfinity", "textures/gui/chemistry_table.png");
    private final Inventory player;
    private final BlockEntityChemistryTable tileEntity;

    public GuiChemistryTable(Inventory invPlayer, BlockEntityChemistryTable tileEntity) {
        super((Container)new ContainerChemistryTable(invPlayer, tileEntity));
        this.player = invPlayer;
        this.tileEntity = tileEntity;
    }

    protected void func_146976_a(float partialTicks, int mouseX, int mouseY) {
        this.field_146297_k.func_110434_K().func_110577_a(TEXTURE);
        this.func_73729_b(this.field_147003_i, this.field_147009_r, 0, 0, this.field_146999_f, this.field_147000_g);
        int buttonX = this.field_147003_i + 43;
        int button0Y = this.field_147009_r + 11;
        int button1Y = this.field_147009_r + 33;
        int button2Y = this.field_147009_r + 55;
        int mixX = this.field_147003_i + 72;
        int mixY = this.field_147009_r + 68;
        if (GuiUtil.isInRect(buttonX, button0Y, 14, 17, mouseX, mouseY)) {
            this.func_73729_b(buttonX, button0Y, 0, 166, 14, 17);
        } else if (GuiUtil.isInRect(buttonX, button1Y, 14, 17, mouseX, mouseY)) {
            this.func_73729_b(buttonX, button1Y, 0, 166, 14, 17);
        } else if (GuiUtil.isInRect(buttonX, button2Y, 14, 17, mouseX, mouseY)) {
            this.func_73729_b(buttonX, button2Y, 0, 166, 14, 17);
        }
        if (this.tileEntity.func_174887_a_(9) > 0) {
            for (int i = 0; i < this.tileEntity.func_174887_a_(9); ++i) {
                int mixColor = this.tileEntity.func_174887_a_(i);
                int mixColorX = 0;
                int mixColorY = 0;
                switch (mixColor) {
                    case 0: {
                        mixColorY = 194;
                        break;
                    }
                    case 1: {
                        mixColorY = 189;
                        break;
                    }
                    case 2: {
                        mixColorY = 184;
                    }
                }
                this.func_73729_b(mixX, mixY - i * 7, mixColorX, mixColorY, 56, 5);
            }
        }
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
        int buttonX = this.field_147003_i + 43;
        int button0Y = this.field_147009_r + 11;
        int button1Y = this.field_147009_r + 33;
        int button2Y = this.field_147009_r + 55;
        if (GuiUtil.isInRect(buttonX, button0Y, 14, 17, mouseX, mouseY)) {
            lostinfinity.instance.packetHandler.sendServerBasicPacket(new PacketChemistryTable(this.tileEntity.func_174877_v(), this.tileEntity.func_174887_a_(9), 0));
            this.player.field_70458_d.func_184185_a(SoundInit.CHEMICAL_MIX, 1.0f, 1.0f);
        } else if (GuiUtil.isInRect(buttonX, button1Y, 14, 17, mouseX, mouseY)) {
            lostinfinity.instance.packetHandler.sendServerBasicPacket(new PacketChemistryTable(this.tileEntity.func_174877_v(), this.tileEntity.func_174887_a_(9), 1));
            this.player.field_70458_d.func_184185_a(SoundInit.CHEMICAL_MIX, 1.0f, 1.0f);
        } else if (GuiUtil.isInRect(buttonX, button2Y, 14, 17, mouseX, mouseY)) {
            lostinfinity.instance.packetHandler.sendServerBasicPacket(new PacketChemistryTable(this.tileEntity.func_174877_v(), this.tileEntity.func_174887_a_(9), 2));
            this.player.field_70458_d.func_184185_a(SoundInit.CHEMICAL_MIX, 1.0f, 1.0f);
        }
    }

    public void func_146281_b() {
        super.func_146281_b();
        this.tileEntity.func_174886_c(this.player.field_70458_d);
        lostinfinity.instance.packetHandler.sendServerBasicPacket(new PacketChemistryTable(this.tileEntity.func_174877_v(), 0, 0));
        lostinfinity.instance.packetHandler.sendServerBasicPacket(new PacketChemistryTable(this.tileEntity.func_174877_v(), 1, 0));
        lostinfinity.instance.packetHandler.sendServerBasicPacket(new PacketChemistryTable(this.tileEntity.func_174877_v(), 2, 0));
        lostinfinity.instance.packetHandler.sendServerBasicPacket(new PacketChemistryTable(this.tileEntity.func_174877_v(), 3, 0));
        lostinfinity.instance.packetHandler.sendServerBasicPacket(new PacketChemistryTable(this.tileEntity.func_174877_v(), 4, 0));
        lostinfinity.instance.packetHandler.sendServerBasicPacket(new PacketChemistryTable(this.tileEntity.func_174877_v(), 5, 0));
        lostinfinity.instance.packetHandler.sendServerBasicPacket(new PacketChemistryTable(this.tileEntity.func_174877_v(), 6, 0));
        lostinfinity.instance.packetHandler.sendServerBasicPacket(new PacketChemistryTable(this.tileEntity.func_174877_v(), 7, 0));
        lostinfinity.instance.packetHandler.sendServerBasicPacket(new PacketChemistryTable(this.tileEntity.func_174877_v(), 8, 0));
        lostinfinity.instance.packetHandler.sendServerBasicPacket(new PacketChemistryTable(this.tileEntity.func_174877_v(), 9, 0));
    }
}

