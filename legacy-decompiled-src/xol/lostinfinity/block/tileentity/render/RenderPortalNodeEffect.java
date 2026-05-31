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
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3
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
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.Vec3;
import xol.lostinfinity.block.activator.BlockPortalNode;
import xol.lostinfinity.block.tileentity.BlockEntityPortalNexus;
import xol.lostinfinity.block.tileentity.BlockEntityPortalNode;
import xol.lostinfinity.init.BlockInit;

public class RenderPortalNodeEffect
extends BlockEntitySpecialRenderer<BlockEntityPortalNode> {
    public static final ResourceLocation TEXTURE_PORTAL_BEAM = new ResourceLocation("lostinfinity:textures/particles/portal_beam.png");

    public void render(BlockEntityPortalNode te, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
        BlockState state = te.func_145831_w().func_180495_p(te.func_174877_v());
        Block block = state.func_177230_c();
        if (block.equals(BlockInit.portalNode) && state != ((BlockPortalNode)BlockInit.portalNode).func_176203_a(1)) {
            return;
        }
        BlockPos nexusPos = te.getNexusPos();
        if (nexusPos == null) {
            return;
        }
        BlockEntityPortalNexus nexus = (BlockEntityPortalNexus)te.func_145831_w().func_175625_s(nexusPos);
        if (nexus == null) {
            return;
        }
        Vec3 nexusVec = new Vec3((double)te.getNexusPos().func_177958_n() + 0.5, (double)te.getNexusPos().func_177956_o(), (double)te.getNexusPos().func_177952_p() + 0.5);
        Vec3 pos = new Vec3((double)te.func_174877_v().func_177958_n(), (double)te.func_174877_v().func_177956_o(), (double)te.func_174877_v().func_177952_p());
        this.func_147499_a(TEXTURE_PORTAL_BEAM);
        Tessellator tessellator = Tessellator.func_178181_a();
        BufferBuilder bufferbuilder = tessellator.func_178180_c();
        GlStateManager.func_179129_p();
        GlStateManager.func_179141_d();
        GlStateManager.func_179147_l();
        GlStateManager.func_179092_a((int)516, (float)0.3f);
        bufferbuilder.func_181668_a(7, DefaultVertexFormats.field_181707_g);
        double dist = pos.func_72438_d(nexusVec);
        Vec3 dir = nexusVec.func_178788_d(pos);
        dir = dir.func_72432_b();
        float segmentHeight = 2.0f;
        float segmentLength = 1.0f;
        double growth = nexus.getGrowth();
        for (int i = 0; i < (int)Math.floor((dist - growth / 2.0) / (double)segmentLength); ++i) {
            double xPos = x + dir.field_72450_a * (double)i * (double)segmentLength;
            double yPos = y + dir.field_72448_b * (double)i * (double)segmentLength;
            double zPos = z + dir.field_72449_c * (double)i * (double)segmentLength;
            bufferbuilder.func_181662_b(xPos, yPos + (double)segmentHeight, zPos).func_187315_a(0.0, 1.0).func_181675_d();
            bufferbuilder.func_181662_b(xPos, yPos, zPos).func_187315_a(0.0, 0.0).func_181675_d();
            bufferbuilder.func_181662_b(xPos + (double)segmentLength * dir.field_72450_a, yPos + (double)segmentLength * dir.field_72448_b, zPos + (double)segmentLength * dir.field_72449_c).func_187315_a(1.0, 0.0).func_181675_d();
            bufferbuilder.func_181662_b(xPos + (double)segmentLength * dir.field_72450_a, yPos + (double)segmentHeight + (double)segmentLength * dir.field_72448_b, zPos + (double)segmentLength * dir.field_72449_c).func_187315_a(1.0, 1.0).func_181675_d();
        }
        tessellator.func_78381_a();
        GlStateManager.func_179089_o();
        GlStateManager.func_179084_k();
    }
}

