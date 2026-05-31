/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.renderer.BufferBuilder
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.OpenGlHelper
 *  net.minecraft.client.renderer.Tessellator
 *  net.minecraft.client.renderer.tileentity.BlockEntitySpecialRenderer
 *  net.minecraft.client.renderer.vertex.DefaultVertexFormats
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3
 *  org.lwjgl.opengl.GL11
 */
package xol.lostinfinity.projectile.render;

import java.util.ArrayList;
import net.minecraft.world.level.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.BlockEntitySpecialRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.Vec3;
import org.lwjgl.opengl.GL11;
import xol.lostinfinity.block.tileentity.BlockEntityLightEmitter;
import xol.lostinfinity.init.BlockInit;

public class RenderLightBeamEffect
extends BlockEntitySpecialRenderer<BlockEntityLightEmitter> {
    public static final ResourceLocation TEXTURE_LIGHT_BEAM = new ResourceLocation("lostinfinity:textures/particles/light_beam.png");

    public void render(BlockEntityLightEmitter te, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
        float a = 1.0f;
        Minecraft.func_71410_x().func_110434_K().func_110577_a(TEXTURE_LIGHT_BEAM);
        Vec3 playerPos = null;
        if (Minecraft.func_71410_x().field_71439_g != null) {
            playerPos = Minecraft.func_71410_x().field_71439_g.func_174791_d();
        }
        Vec3 offset = new Vec3(0.5, 0.3, 0.5);
        Vec3 target = te.getStartPos();
        Vec3 target2 = te.getStopPos();
        ArrayList<Vec3> reflectors = te.getReflectors();
        if (target != null && target2 != null && playerPos != null && reflectors.size() < 2) {
            Vec3 targetVec = new Vec3(target.field_72450_a, target.field_72448_b, target.field_72449_c).func_178787_e(offset);
            Vec3 target2Vec = new Vec3(target2.field_72450_a, target2.field_72448_b, target2.field_72449_c).func_178787_e(offset);
            Vec3 dir = target2Vec.func_178788_d(targetVec);
            dir = dir.func_72432_b();
            double dist = Math.sqrt(Math.pow(targetVec.field_72450_a - target2Vec.field_72450_a, 2.0) + Math.pow(targetVec.field_72448_b - target2Vec.field_72448_b, 2.0) + Math.pow(targetVec.field_72449_c - target2Vec.field_72449_c, 2.0));
            this.func_147499_a(TEXTURE_LIGHT_BEAM);
            Tessellator tessellator = Tessellator.func_178181_a();
            BufferBuilder bufferbuilder = tessellator.func_178180_c();
            double segmentLength = 0.4;
            double segmentHeight = 0.4;
            GlStateManager.func_179140_f();
            int bright = 240;
            int brightX = bright % 65536;
            int brightY = bright / 65536;
            OpenGlHelper.func_77475_a((int)OpenGlHelper.field_77476_b, (float)brightX, (float)brightY);
            GL11.glEnable((int)3008);
            GlStateManager.func_179141_d();
            GlStateManager.func_179129_p();
            bufferbuilder.func_181668_a(7, DefaultVertexFormats.field_181709_i);
            for (int i = 0; i < (int)Math.floor(dist / segmentLength); ++i) {
                double xPos = targetVec.field_72450_a - playerPos.field_72450_a + dir.field_72450_a * (double)i * segmentLength;
                double yPos = targetVec.field_72448_b - playerPos.field_72448_b + dir.field_72448_b * (double)i * segmentLength;
                double zPos = targetVec.field_72449_c - playerPos.field_72449_c + dir.field_72449_c * (double)i * segmentLength;
                bufferbuilder.func_181662_b(xPos, yPos + segmentHeight, zPos).func_187315_a(0.0, 1.0).func_181666_a(1.0f, 1.0f, 1.0f, 1.0f).func_181675_d();
                bufferbuilder.func_181662_b(xPos, yPos, zPos).func_187315_a(0.0, 0.0).func_181666_a(1.0f, 1.0f, 1.0f, 1.0f).func_181675_d();
                bufferbuilder.func_181662_b(xPos + segmentLength * dir.field_72450_a, yPos + segmentLength * dir.field_72448_b, zPos + segmentLength * dir.field_72449_c).func_187315_a(1.0, 0.0).func_181666_a(1.0f, 1.0f, 1.0f, 1.0f).func_181675_d();
                bufferbuilder.func_181662_b(xPos + segmentLength * dir.field_72450_a, yPos + segmentHeight + segmentLength * dir.field_72448_b, zPos + segmentLength * dir.field_72449_c).func_187315_a(1.0, 1.0).func_181666_a(1.0f, 1.0f, 1.0f, 1.0f).func_181675_d();
            }
            tessellator.func_78381_a();
            GlStateManager.func_179145_e();
            GlStateManager.func_179118_c();
            GlStateManager.func_179089_o();
        } else {
            double zPos;
            double yPos;
            double xPos;
            int i;
            int brightY;
            int brightX;
            int bright;
            double segmentHeight;
            double segmentLength;
            BufferBuilder bufferbuilder;
            Tessellator tessellator;
            for (int k = 0; k < reflectors.size() - 1; ++k) {
                offset = new Vec3(0.5, 0.3, 0.5);
                target = reflectors.get(k);
                target2 = reflectors.get(k + 1);
                if (target == null || target2 == null || playerPos == null) continue;
                Vec3 targetVec = new Vec3(target.field_72450_a, target.field_72448_b, target.field_72449_c).func_178787_e(offset);
                Vec3 target2Vec = new Vec3(target2.field_72450_a, target2.field_72448_b, target2.field_72449_c).func_178787_e(offset);
                Vec3 dir = target2Vec.func_178788_d(targetVec);
                dir = dir.func_72432_b();
                if (Math.abs(dir.field_72450_a) > 0.0 && Math.abs(dir.field_72449_c) > 0.0) {
                    return;
                }
                double dist = Math.sqrt(Math.pow(targetVec.field_72450_a - target2Vec.field_72450_a, 2.0) + Math.pow(targetVec.field_72448_b - target2Vec.field_72448_b, 2.0) + Math.pow(targetVec.field_72449_c - target2Vec.field_72449_c, 2.0));
                this.func_147499_a(TEXTURE_LIGHT_BEAM);
                tessellator = Tessellator.func_178181_a();
                bufferbuilder = tessellator.func_178180_c();
                segmentLength = 0.4;
                segmentHeight = 0.4;
                GlStateManager.func_179140_f();
                bright = 240;
                brightX = bright % 65536;
                brightY = bright / 65536;
                OpenGlHelper.func_77475_a((int)OpenGlHelper.field_77476_b, (float)brightX, (float)brightY);
                GL11.glEnable((int)3008);
                GlStateManager.func_179141_d();
                GlStateManager.func_179129_p();
                bufferbuilder.func_181668_a(7, DefaultVertexFormats.field_181707_g);
                for (i = 0; i < (int)Math.floor(dist / segmentLength); ++i) {
                    xPos = targetVec.field_72450_a - playerPos.field_72450_a + dir.field_72450_a * (double)i * segmentLength;
                    yPos = targetVec.field_72448_b - playerPos.field_72448_b + dir.field_72448_b * (double)i * segmentLength;
                    zPos = targetVec.field_72449_c - playerPos.field_72449_c + dir.field_72449_c * (double)i * segmentLength;
                    bufferbuilder.func_181662_b(xPos, yPos + segmentHeight, zPos).func_187315_a(0.0, 1.0).func_181675_d();
                    bufferbuilder.func_181662_b(xPos, yPos, zPos).func_187315_a(0.0, 0.0).func_181675_d();
                    bufferbuilder.func_181662_b(xPos + segmentLength * dir.field_72450_a, yPos + segmentLength * dir.field_72448_b, zPos + segmentLength * dir.field_72449_c).func_187315_a(1.0, 0.0).func_181675_d();
                    bufferbuilder.func_181662_b(xPos + segmentLength * dir.field_72450_a, yPos + segmentHeight + segmentLength * dir.field_72448_b, zPos + segmentLength * dir.field_72449_c).func_187315_a(1.0, 1.0).func_181675_d();
                }
                tessellator.func_78381_a();
                GlStateManager.func_179145_e();
                GlStateManager.func_179118_c();
                GlStateManager.func_179089_o();
            }
            if (te.isComplete()) {
                int radius = 20;
                offset = new Vec3(0.5, 0.3, 0.5);
                target = reflectors.get(reflectors.size() - 1);
                target2 = null;
                for (int i2 = -radius; i2 < radius; ++i2) {
                    block4: for (int j = -radius; j < radius; ++j) {
                        for (int k = -radius; k < radius; ++k) {
                            BlockPos checkPos = new BlockPos((int)target.field_72450_a + i2, (int)target.field_72448_b + j, (int)target.field_72449_c + k);
                            Block checkBlock = te.func_145831_w().func_180495_p(checkPos).func_177230_c();
                            if (!checkBlock.equals(BlockInit.lightReceiver)) continue;
                            target2 = new Vec3((double)checkPos.func_177958_n(), (double)checkPos.func_177956_o(), (double)checkPos.func_177952_p());
                            continue block4;
                        }
                    }
                }
                if (target != null && target2 != null && playerPos != null) {
                    Vec3 targetVec = new Vec3(target.field_72450_a, target.field_72448_b, target.field_72449_c).func_178787_e(offset);
                    Vec3 target2Vec = new Vec3(target2.field_72450_a, target2.field_72448_b, target2.field_72449_c).func_178787_e(offset);
                    Vec3 dir = target2Vec.func_178788_d(targetVec);
                    dir = dir.func_72432_b();
                    double dist = Math.sqrt(Math.pow(targetVec.field_72450_a - target2Vec.field_72450_a, 2.0) + Math.pow(targetVec.field_72448_b - target2Vec.field_72448_b, 2.0) + Math.pow(targetVec.field_72449_c - target2Vec.field_72449_c, 2.0));
                    this.func_147499_a(TEXTURE_LIGHT_BEAM);
                    tessellator = Tessellator.func_178181_a();
                    bufferbuilder = tessellator.func_178180_c();
                    segmentLength = 0.4;
                    segmentHeight = 0.4;
                    GlStateManager.func_179140_f();
                    bright = 240;
                    brightX = bright % 65536;
                    brightY = bright / 65536;
                    OpenGlHelper.func_77475_a((int)OpenGlHelper.field_77476_b, (float)brightX, (float)brightY);
                    GL11.glEnable((int)3008);
                    GlStateManager.func_179141_d();
                    GlStateManager.func_179129_p();
                    bufferbuilder.func_181668_a(7, DefaultVertexFormats.field_181707_g);
                    for (i = 0; i < (int)Math.floor(dist / segmentLength); ++i) {
                        xPos = targetVec.field_72450_a - playerPos.field_72450_a + dir.field_72450_a * (double)i * segmentLength;
                        yPos = targetVec.field_72448_b - playerPos.field_72448_b + dir.field_72448_b * (double)i * segmentLength;
                        zPos = targetVec.field_72449_c - playerPos.field_72449_c + dir.field_72449_c * (double)i * segmentLength;
                        bufferbuilder.func_181662_b(xPos, yPos + segmentHeight, zPos).func_187315_a(0.0, 1.0).func_181675_d();
                        bufferbuilder.func_181662_b(xPos, yPos, zPos).func_187315_a(0.0, 0.0).func_181675_d();
                        bufferbuilder.func_181662_b(xPos + segmentLength * dir.field_72450_a, yPos + segmentLength * dir.field_72448_b, zPos + segmentLength * dir.field_72449_c).func_187315_a(1.0, 0.0).func_181675_d();
                        bufferbuilder.func_181662_b(xPos + segmentLength * dir.field_72450_a, yPos + segmentHeight + segmentLength * dir.field_72448_b, zPos + segmentLength * dir.field_72449_c).func_187315_a(1.0, 1.0).func_181675_d();
                    }
                    tessellator.func_78381_a();
                    GlStateManager.func_179145_e();
                    GlStateManager.func_179118_c();
                    GlStateManager.func_179089_o();
                }
            }
        }
    }

    public boolean isGlobalRenderer(BlockEntityLightEmitter emitter) {
        return true;
    }
}

