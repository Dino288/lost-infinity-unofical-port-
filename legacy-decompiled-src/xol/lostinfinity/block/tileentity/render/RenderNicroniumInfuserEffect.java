/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.client.renderer.BufferBuilder
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.Tessellator
 *  net.minecraft.client.renderer.tileentity.BlockEntitySpecialRenderer
 *  net.minecraft.client.renderer.vertex.DefaultVertexFormats
 *  net.minecraft.util.ResourceLocation
 */
package xol.lostinfinity.block.tileentity.render;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.BlockEntitySpecialRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.resources.ResourceLocation;
import xol.lostinfinity.block.crafting.BlockNicroniumInfuser;
import xol.lostinfinity.block.tileentity.BlockEntityNicroniumInfuser;
import xol.lostinfinity.init.BlockInit;

public class RenderNicroniumInfuserEffect
extends BlockEntitySpecialRenderer<BlockEntityNicroniumInfuser> {
    public static final ResourceLocation TEXTURE_NICRONIUM_RING = new ResourceLocation("lostinfinity:textures/particles/nicronium_ring.png");

    public void render(BlockEntityNicroniumInfuser te, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
        BlockState state = te.func_145831_w().func_180495_p(te.func_174877_v());
        Block block = state.func_177230_c();
        if (block.equals(BlockInit.nicroniumInfuser) && state != ((BlockNicroniumInfuser)BlockInit.nicroniumInfuser).func_176203_a(1)) {
            return;
        }
        double targetHeight = 1.0;
        this.func_147499_a(TEXTURE_NICRONIUM_RING);
        Tessellator tessellator = Tessellator.func_178181_a();
        BufferBuilder bufferbuilder = tessellator.func_178180_c();
        GlStateManager.func_179129_p();
        GlStateManager.func_179141_d();
        float growth = 0.5f;
        GlStateManager.func_179147_l();
        GlStateManager.func_179092_a((int)516, (float)0.3f);
        float a = 1.0f;
        growth = 0.1f + (float)(te.func_145831_w().func_82737_E() % 40L) * 0.3f;
        a = 1.0f - (float)(te.func_145831_w().func_82737_E() % 40L) * 0.022224f;
        if (a <= 0.0f) {
            a = 0.0f;
        }
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)a);
        bufferbuilder.func_181668_a(7, DefaultVertexFormats.field_181707_g);
        double xPos = x + 0.5;
        double yPos = y + (double)0.1f;
        double zPos = z + 0.5;
        bufferbuilder.func_181662_b((double)(-0.5f * growth) + xPos, targetHeight + yPos, (double)(0.5f * growth) + zPos).func_187315_a(0.0, 1.0).func_181675_d();
        bufferbuilder.func_181662_b((double)(-0.5f * growth) + xPos, targetHeight + yPos, (double)(-0.5f * growth) + zPos).func_187315_a(0.0, 0.0).func_181675_d();
        bufferbuilder.func_181662_b((double)(0.5f * growth) + xPos, targetHeight + yPos, (double)(-0.5f * growth) + zPos).func_187315_a(1.0, 0.0).func_181675_d();
        bufferbuilder.func_181662_b((double)(0.5f * growth) + xPos, targetHeight + yPos, (double)(0.5f * growth) + zPos).func_187315_a(1.0, 1.0).func_181675_d();
        tessellator.func_78381_a();
        GlStateManager.func_179089_o();
        GlStateManager.func_179084_k();
    }
}

