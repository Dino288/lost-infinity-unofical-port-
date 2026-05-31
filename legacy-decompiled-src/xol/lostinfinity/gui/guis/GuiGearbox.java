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
import xol.lostinfinity.block.tileentity.BlockEntityGearbox;
import xol.lostinfinity.common.lostinfinity;
import xol.lostinfinity.common.packets.serverbound.PacketGearbox;
import xol.lostinfinity.gui.containers.ContainerGearbox;

public class GuiGearbox
extends GuiContainer {
    private static final ResourceLocation TEXTURE = new ResourceLocation("lostinfinity", "textures/gui/gearbox.png");
    private final Inventory player;
    private final BlockEntityGearbox tileentity;
    private static final int pegLeft = 0;
    private static final int pegTop = 166;
    private static final int pegWidth = 4;
    private static final int pegStartX = 57;
    private static final int pegStartY = 55;
    private int selectedGear = 0;

    public GuiGearbox(Inventory player, BlockEntityGearbox tileentity) {
        super((Container)new ContainerGearbox(player, tileentity));
        this.player = player;
        this.tileentity = tileentity;
    }

    public void func_73863_a(int mouseX, int mouseY, float partialTicks) {
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        this.func_146276_q_();
        super.func_73863_a(mouseX, mouseY, partialTicks);
        this.func_191948_b(mouseX, mouseY);
        GlStateManager.func_179140_f();
        GlStateManager.func_179084_k();
    }

    protected void func_146976_a(float partialTicks, int mouseX, int mouseY) {
        int i;
        this.field_146297_k.func_110434_K().func_110577_a(TEXTURE);
        this.func_73729_b(this.field_147003_i, this.field_147009_r, 0, 0, this.field_146999_f, this.field_147000_g);
        int[] pegs = this.tileentity.getPegPositions();
        int[] gears = this.tileentity.getPlacedGears();
        for (i = 0; i < pegs.length; ++i) {
            this.func_73729_b(57 + pegs[i] + this.field_147003_i, 55 + this.field_147009_r, 0, 166, 5, 5);
        }
        for (i = 0; i < gears.length; ++i) {
            int gear = gears[i];
            int gearLeft = 0;
            int gearTop = 166;
            int gearWidth = 0;
            int yOffset = 0;
            int xOffset = 0;
            switch (gear) {
                case 2: {
                    gearLeft = 5;
                    gearWidth = 5;
                    yOffset = 0;
                    xOffset = 0;
                    break;
                }
                case 3: {
                    gearLeft = 10;
                    gearWidth = 7;
                    yOffset = -1;
                    xOffset = -1;
                    break;
                }
                case 4: {
                    gearLeft = 17;
                    gearWidth = 9;
                    yOffset = -2;
                    xOffset = -2;
                    break;
                }
                case 5: {
                    gearLeft = 26;
                    gearWidth = 11;
                    yOffset = -3;
                    xOffset = -3;
                    break;
                }
                case 6: {
                    gearLeft = 37;
                    gearWidth = 13;
                    yOffset = -4;
                    xOffset = -4;
                }
            }
            this.func_73729_b(57 + pegs[i] + this.field_147003_i + xOffset, 55 + this.field_147009_r + yOffset, gearLeft, 166, gearWidth, gearWidth);
        }
    }

    protected void func_146979_b(int mouseX, int mouseY) {
        this.field_146289_q.func_78276_b("Gearbox", 66, 6, 0);
    }

    protected void func_73864_a(int mouseX, int mouseY, int mouseButton) throws IOException {
        super.func_73864_a(mouseX, mouseY, mouseButton);
        if (GuiGearbox.isInRect(53 + this.field_147003_i, 19 + this.field_147009_r, 12, 12, mouseX, mouseY)) {
            this.selectedGear = 6;
        }
        if (GuiGearbox.isInRect(71 + this.field_147003_i, 21 + this.field_147009_r, 10, 10, mouseX, mouseY)) {
            this.selectedGear = 5;
        }
        if (GuiGearbox.isInRect(87 + this.field_147003_i, 23 + this.field_147009_r, 8, 8, mouseX, mouseY)) {
            this.selectedGear = 4;
        }
        if (GuiGearbox.isInRect(101 + this.field_147003_i, 25 + this.field_147009_r, 6, 6, mouseX, mouseY)) {
            this.selectedGear = 3;
        }
        if (GuiGearbox.isInRect(113 + this.field_147003_i, 27 + this.field_147009_r, 4, 4, mouseX, mouseY)) {
            this.selectedGear = 2;
        }
        if (this.selectedGear != 0) {
            int[] pegs = this.tileentity.getPegPositions();
            int[] gears = this.tileentity.getPlacedGears();
            int[] requiredGears = this.tileentity.getGears();
            for (int i = 0; i < pegs.length; ++i) {
                if (!GuiGearbox.isInRect(this.field_147003_i + pegs[i] + 57, this.field_147009_r + 55, 5, 5, mouseX, mouseY)) continue;
                boolean canPlace = true;
                if (this.selectedGear > gears[i]) {
                    if (i - 1 >= 0 && gears[i - 1] + this.selectedGear > requiredGears[i - 1] + requiredGears[i]) {
                        canPlace = false;
                    } else if (i + 1 < pegs.length && gears[i + 1] + this.selectedGear > requiredGears[i + 1] + requiredGears[i]) {
                        canPlace = false;
                    } else if (i == 0 && this.selectedGear != requiredGears[0]) {
                        canPlace = false;
                    }
                }
                if (!canPlace) continue;
                gears[i] = this.selectedGear;
            }
            boolean complete = true;
            for (int i = 0; i < gears.length; ++i) {
                if (gears[i] == requiredGears[i]) continue;
                complete = false;
            }
            lostinfinity.instance.packetHandler.sendServerBasicPacket(new PacketGearbox(this.tileentity.func_174877_v(), complete));
            this.tileentity.setPlacedGears(gears);
        }
    }

    public static boolean isInRect(int x, int y, int xSize, int ySize, int mouseX, int mouseY) {
        return mouseX >= x && mouseX <= x + xSize && mouseY >= y && mouseY <= y + ySize;
    }
}

