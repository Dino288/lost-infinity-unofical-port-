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
import net.minecraft.world.phys.Vec3;
import xol.lostinfinity.block.tileentity.BlockEntityPortalNexus;
import xol.lostinfinity.init.BlockInit;

public class RenderPortalNexus
extends BlockEntitySpecialRenderer<BlockEntityPortalNexus> {
    public static final ResourceLocation TEXTURE_SUMMONING_PORTAL = new ResourceLocation("lostinfinity:textures/particles/summoning_portal.png");

    public void render(BlockEntityPortalNexus te, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
        BlockState state = te.func_145831_w().func_180495_p(te.func_174877_v());
        Block block = state.func_177230_c();
        if (block.equals(BlockInit.portalNode) && state != BlockInit.portalNode.func_176203_a(1)) {
            return;
        }
        double targetHeight = 1.0;
        this.func_147499_a(TEXTURE_SUMMONING_PORTAL);
        Tessellator tessellator = Tessellator.func_178181_a();
        BufferBuilder bufferbuilder = tessellator.func_178180_c();
        GlStateManager.func_179129_p();
        GlStateManager.func_179141_d();
        GlStateManager.func_179147_l();
        GlStateManager.func_179092_a((int)516, (float)0.3f);
        bufferbuilder.func_181668_a(7, DefaultVertexFormats.field_181707_g);
        double growth = te.getGrowth();
        float rotation = te.getRotation();
        double xPos = x + 0.5;
        double yPos = y + (double)0.1f;
        double zPos = z + 0.5;
        Vec3 dirRight = new Vec3(1.0, 0.0, 0.0);
        dirRight = dirRight.func_178785_b(rotation);
        Vec3 dirForward = new Vec3(0.0, 0.0, 1.0);
        dirForward = dirForward.func_178785_b(rotation);
        bufferbuilder.func_181662_b(-0.5 * growth * dirRight.field_72450_a + 0.5 * growth * dirForward.field_72450_a + xPos, targetHeight + yPos, -0.5 * growth * dirRight.field_72449_c + 0.5 * growth * dirForward.field_72449_c + zPos).func_187315_a(0.0, 1.0).func_181675_d();
        bufferbuilder.func_181662_b(-0.5 * growth * dirRight.field_72450_a - 0.5 * growth * dirForward.field_72450_a + xPos, targetHeight + yPos, -0.5 * growth * dirRight.field_72449_c - 0.5 * growth * dirForward.field_72449_c + zPos).func_187315_a(0.0, 0.0).func_181675_d();
        bufferbuilder.func_181662_b(0.5 * growth * dirRight.field_72450_a - 0.5 * growth * dirForward.field_72450_a + xPos, targetHeight + yPos, 0.5 * growth * dirRight.field_72449_c - 0.5 * growth * dirForward.field_72449_c + zPos).func_187315_a(1.0, 0.0).func_181675_d();
        bufferbuilder.func_181662_b(0.5 * growth * dirRight.field_72450_a + 0.5 * growth * dirForward.field_72450_a + xPos, targetHeight + yPos, 0.5 * growth * dirRight.field_72449_c + 0.5 * growth * dirForward.field_72449_c + zPos).func_187315_a(1.0, 1.0).func_181675_d();
        tessellator.func_78381_a();
        GlStateManager.func_179089_o();
        GlStateManager.func_179084_k();
    }
}

