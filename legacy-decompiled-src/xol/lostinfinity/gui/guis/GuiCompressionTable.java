/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.client.gui.inventory.GuiContainer
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.entity.player.Inventory
 *  net.minecraft.inventory.Container
 *  net.minecraft.inventory.IInventory
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 */
package xol.lostinfinity.gui.guis;

import java.util.ArrayList;
import net.minecraft.world.level.block.Block;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import xol.lostinfinity.block.tileentity.BlockEntityCompressionTable;
import xol.lostinfinity.gui.containers.ContainerCompressionTable;

public class GuiCompressionTable
extends GuiContainer {
    private static final ResourceLocation texture = new ResourceLocation("lostinfinity", "textures/gui/compression_table.png");
    private final ContainerCompressionTable table;
    private final Level world;
    private final BlockPos pos;
    private final Inventory playerInventory;
    private final IInventory inv;

    public GuiCompressionTable(Inventory invPlayer, Level worldIn, BlockPos pos, Block block, IInventory inv) {
        super((Container)new ContainerCompressionTable(invPlayer, worldIn, pos, block, inv));
        this.pos = pos;
        this.world = worldIn;
        this.table = (ContainerCompressionTable)this.field_147002_h;
        this.playerInventory = invPlayer;
        this.inv = inv;
    }

    public void func_73866_w_() {
        super.func_73866_w_();
    }

    public void func_146281_b() {
        super.func_146281_b();
    }

    protected void func_146979_b(int mouseX, int mouseY) {
        GlStateManager.func_179140_f();
        GlStateManager.func_179084_k();
        this.field_146289_q.func_78276_b("Compression Table", 60, 6, 0x404040);
        ArrayList<String> hoverText = new ArrayList<String>();
        int progressWidth = 23;
        int progressHeight = 16;
        if (GuiCompressionTable.isInRect(this.field_147003_i + 76, this.field_147009_r + 35, progressWidth, progressHeight, mouseX, mouseY)) {
            hoverText.add("Compression Progress:");
            int percent = (int)(((BlockEntityCompressionTable)this.world.func_175625_s(this.pos)).getProgressAsFraction() * 100.0);
            hoverText.add(percent + "%");
        }
        if (!hoverText.isEmpty()) {
            this.drawHoveringText(hoverText, mouseX - this.field_147003_i, mouseY - this.field_147009_r, this.field_146289_q);
        }
        GlStateManager.func_179145_e();
    }

    public static boolean isInRect(int x, int y, int xSize, int ySize, int mouseX, int mouseY) {
        return mouseX >= x && mouseX <= x + xSize && mouseY >= y && mouseY <= y + ySize;
    }

    public void func_73863_a(int mouseX, int mouseY, float partialTicks) {
        this.func_146276_q_();
        super.func_73863_a(mouseX, mouseY, partialTicks);
        this.func_191948_b(mouseX, mouseY);
        GlStateManager.func_179140_f();
        GlStateManager.func_179084_k();
    }

    protected void func_146976_a(float partialTicks, int mouseX, int mouseY) {
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        this.field_146297_k.func_110434_K().func_110577_a(texture);
        int i = (this.field_146294_l - this.field_146999_f) / 2;
        int j = (this.field_146295_m - this.field_147000_g) / 2;
        this.func_73729_b(i, j, 0, 0, this.field_146999_f, this.field_147000_g);
        int progressWidth = 23;
        int progressHeight = 16;
        double compressionProgress = ((BlockEntityCompressionTable)this.world.func_175625_s(this.pos)).getProgressAsFraction();
        this.func_73729_b(76, 35, 14, 176, (int)(compressionProgress * (double)progressWidth), progressHeight);
        BlockEntityCompressionTable table = (BlockEntityCompressionTable)this.world.func_175625_s(this.pos);
        if (table.canProgress()) {
            int pix = this.getCPRogressScaled(24);
            this.func_73729_b(this.field_147003_i + 76, this.field_147009_r + 20, this.field_146999_f, 0, pix + 1, 30);
        }
    }

    private int getCPRogressScaled(int pixels) {
        int i = this.inv.func_174887_a_(0);
        return i != -1 ? i * pixels / 500 : 0;
    }
}

