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

import java.util.AbstractMap;
import java.util.ArrayList;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.inventory.Container;
import net.minecraft.resources.ResourceLocation;
import xol.lostinfinity.block.tileentity.BlockEntityGrinder;
import xol.lostinfinity.common.lostinfinity;
import xol.lostinfinity.common.packets.serverbound.PacketGrinder;
import xol.lostinfinity.gui.containers.ContainerGrinder;
import xol.lostinfinity.init.BlockInit;

public class GuiGrinder
extends GuiContainer {
    private static final ResourceLocation TEXTURE = new ResourceLocation("lostinfinity", "textures/gui/grinder.png");
    private final Inventory player;
    private final BlockEntityGrinder tileentity;
    private static final int materialTextureX = 0;
    private static final int materialTextureY = 166;
    private static final int materialWidth = 35;
    private static final int materialHeight = 33;
    private static final int materialX = 71;
    private static final int materialY = 21;
    private static final int pointTexX = 8;
    private static final int pointTexY = 138;
    private static final int debrisTexX = 35;
    private static final int debrisTexY = 166;
    ArrayList<AbstractMap.SimpleEntry<Integer, Integer>> points = new ArrayList();
    ArrayList<AbstractMap.SimpleEntry<Integer, Integer>> debris = new ArrayList();

    public GuiGrinder(Inventory player, BlockEntityGrinder tileentity) {
        super((Container)new ContainerGrinder(player, tileentity));
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
        this.field_146297_k.func_110434_K().func_110577_a(TEXTURE);
        this.func_73729_b(this.field_147003_i, this.field_147009_r, 0, 0, this.field_146999_f, this.field_147000_g);
        if (this.debris.isEmpty()) {
            this.resetDebris();
        }
        if (this.tileentity.func_145831_w().func_180495_p(this.tileentity.func_174877_v()) == BlockInit.grinder.func_176203_a(1)) {
            this.func_73729_b(this.field_147003_i + 71, this.field_147009_r + 21, 0, 166, 35, 33);
            for (AbstractMap.SimpleEntry<Integer, Integer> simpleEntry : this.points) {
            }
            for (AbstractMap.SimpleEntry<Integer, Integer> point : this.debris) {
                this.func_73729_b(point.getKey() - 1, point.getValue() - 1, 35, 166, 1, 1);
            }
        }
    }

    protected void func_146979_b(int mouseX, int mouseY) {
        this.field_146289_q.func_78276_b("Grinder", 70, 6, 0);
    }

    public static boolean isInRect(int x, int y, int xSize, int ySize, int mouseX, int mouseY) {
        return mouseX >= x && mouseX <= x + xSize && mouseY >= y && mouseY <= y + ySize;
    }

    protected void func_146273_a(int mouseX, int mouseY, int clickedMouseButton, long timeSinceLastClick) {
        super.func_146273_a(mouseX, mouseY, clickedMouseButton, timeSinceLastClick);
        if (GuiGrinder.isInRect(this.field_147003_i + 71 + 2, this.field_147009_r + 21 + 2, 30, 28, mouseX, mouseY)) {
            this.points.add(new AbstractMap.SimpleEntry<Integer, Integer>(mouseX, mouseY));
            ArrayList<AbstractMap.SimpleEntry<Integer, Integer>> toRemove = new ArrayList<AbstractMap.SimpleEntry<Integer, Integer>>();
            for (AbstractMap.SimpleEntry<Integer, Integer> debrisPoint : this.debris) {
                int xDiff = Math.abs(debrisPoint.getKey() - mouseX);
                int yDiff = Math.abs(debrisPoint.getValue() - mouseY);
                if (xDiff > 2 || yDiff > 2) continue;
                toRemove.add(debrisPoint);
            }
            this.debris.removeAll(toRemove);
            if (this.debris.isEmpty()) {
                lostinfinity.instance.packetHandler.sendServerBasicPacket(new PacketGrinder(this.tileentity.func_174877_v(), true));
                return;
            }
            if (GuiGrinder.isInRect(this.field_147003_i + 71 + 8, this.field_147009_r + 21 + 7, 17, 20, mouseX, mouseY)) {
                lostinfinity.instance.packetHandler.sendServerBasicPacket(new PacketGrinder(this.tileentity.func_174877_v(), false));
                this.points.clear();
                this.debris.clear();
                this.resetDebris();
            }
        }
    }

    private void resetDebris() {
        int leftBound = this.field_147003_i + 71 + 2;
        int topBound = this.field_147009_r + 21 + 2;
        int innerBoundLeft = this.field_147003_i + 71 + 7;
        int innerBoundTop = this.field_147009_r + 21 + 5;
        int innerBoundRight = innerBoundLeft + 35 - 14;
        int innerBoundBottom = innerBoundTop + 33 - 8;
        for (int i = leftBound; i < leftBound + 35 - 3; ++i) {
            for (int j = topBound; j < topBound + 33 - 3; ++j) {
                if (i > innerBoundLeft && i < innerBoundRight && j > innerBoundTop && j < innerBoundBottom || this.tileentity.func_145831_w().field_73012_v.nextInt(3) != 0) continue;
                this.debris.add(new AbstractMap.SimpleEntry<Integer, Integer>(i, j));
            }
        }
    }
}

