/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.client.renderer.BufferBuilder
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.OpenGlHelper
 *  net.minecraft.client.renderer.Tessellator
 *  net.minecraft.client.renderer.tileentity.BlockEntitySpecialRenderer
 *  net.minecraft.client.renderer.vertex.DefaultVertexFormats
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.math.Vec3
 */
package xol.lostinfinity.block.tileentity.render;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.BlockEntitySpecialRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.phys.Vec3;
import xol.lostinfinity.block.tileentity.BlockEntityVoidVacuum;
import xol.lostinfinity.init.BlockInit;

public class RenderVoidVacuum
extends BlockEntitySpecialRenderer<BlockEntityVoidVacuum> {
    public static final ResourceLocation TEXTURE_ELASTIC_STRING = new ResourceLocation("lostinfinity:textures/particles/elastic_thread.png");

    public void render(BlockEntityVoidVacuum te, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
        if (te.getActive()) {
            BlockState state = te.func_145831_w().func_180495_p(te.func_174877_v());
            Block block = state.func_177230_c();
            if (!block.equals(BlockInit.voidVacuum)) {
                return;
            }
            LivingEntity target = te.getTarget();
            if (target == null || target.field_70128_L) {
                return;
            }
            Vec3 pos = new Vec3((double)te.func_174877_v().func_177958_n(), (double)te.func_174877_v().func_177956_o(), (double)te.func_174877_v().func_177952_p());
            Vec3 playerVec = target.func_174791_d();
            this.func_147499_a(TEXTURE_ELASTIC_STRING);
            Tessellator tessellator = Tessellator.func_178181_a();
            BufferBuilder bufferbuilder = tessellator.func_178180_c();
            GlStateManager.func_179129_p();
            GlStateManager.func_179141_d();
            GlStateManager.func_179140_f();
            int bright = 240;
            int brightX = bright % 65536;
            int brightY = bright / 65536;
            OpenGlHelper.func_77475_a((int)OpenGlHelper.field_77476_b, (float)brightX, (float)brightY);
            GlStateManager.func_179147_l();
            GlStateManager.func_179092_a((int)516, (float)0.3f);
            bufferbuilder.func_181668_a(7, DefaultVertexFormats.field_181707_g);
            double dist = pos.func_72438_d(playerVec);
            Vec3 dir = playerVec.func_178788_d(pos);
            dir = dir.func_72432_b();
            float segmentHeight = 2.0f;
            float segmentLength = 1.0f;
            for (int i = 0; i < (int)Math.floor(dist / (double)segmentLength); ++i) {
                double xPos = x + 0.5 + dir.field_72450_a * (double)i * (double)segmentLength;
                double yPos = y + dir.field_72448_b * (double)i * (double)segmentLength;
                double zPos = z + 0.5 + dir.field_72449_c * (double)i * (double)segmentLength;
                bufferbuilder.func_181662_b(xPos, yPos + (double)segmentHeight, zPos).func_187315_a(0.0, 1.0).func_181675_d();
                bufferbuilder.func_181662_b(xPos, yPos, zPos).func_187315_a(0.0, 0.0).func_181675_d();
                bufferbuilder.func_181662_b(xPos + (double)segmentLength * dir.field_72450_a, yPos + (double)segmentLength * dir.field_72448_b, zPos + (double)segmentLength * dir.field_72449_c).func_187315_a(1.0, 0.0).func_181675_d();
                bufferbuilder.func_181662_b(xPos + (double)segmentLength * dir.field_72450_a, yPos + (double)segmentHeight + (double)segmentLength * dir.field_72448_b, zPos + (double)segmentLength * dir.field_72449_c).func_187315_a(1.0, 1.0).func_181675_d();
            }
            tessellator.func_78381_a();
            GlStateManager.func_179145_e();
            GlStateManager.func_179089_o();
            GlStateManager.func_179084_k();
        }
    }
}

