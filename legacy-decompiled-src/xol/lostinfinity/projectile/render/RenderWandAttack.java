/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.renderer.BufferBuilder
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.GlStateManager$DestFactor
 *  net.minecraft.client.renderer.GlStateManager$SourceFactor
 *  net.minecraft.client.renderer.Tessellator
 *  net.minecraft.client.renderer.entity.Render
 *  net.minecraft.client.renderer.entity.RenderManager
 *  net.minecraft.client.renderer.vertex.DefaultVertexFormats
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Mth
 *  net.minecraft.util.math.Vec2f
 *  org.lwjgl.opengl.GL11
 */
package xol.lostinfinity.projectile.render;

import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.util.math.Vec2f;
import org.lwjgl.opengl.GL11;
import xol.lostinfinity.projectile.entity.EntityWandAttack;

public class RenderWandAttack<T extends Entity>
extends Render<T> {
    public static final ResourceLocation TEXTURE_BEACON_BEAM = new ResourceLocation("textures/entity/beacon_beam.png");

    public RenderWandAttack(RenderManager renderManager) {
        super(renderManager);
    }

    public void func_76986_a(T entity, double x, double y, double z, float entityYaw, float partialTicks) {
        EntityWandAttack attackEntity = (EntityWandAttack)((Object)entity);
        BlockPos aimBlockReal = attackEntity.getAimBlock();
        BlockPos playerPos = attackEntity.getPlayerPos();
        Vec2f pitchYaw = attackEntity.func_189653_aC();
        BlockPos aimBlock = new BlockPos(aimBlockReal.func_177958_n() - playerPos.func_177958_n(), aimBlockReal.func_177956_o() - playerPos.func_177956_o(), aimBlockReal.func_177952_p() - playerPos.func_177952_p());
        double dist = aimBlockReal.func_185332_f(playerPos.func_177958_n(), playerPos.func_177956_o(), playerPos.func_177952_p());
        GL11.glRotatef((float)pitchYaw.field_189982_i, (float)0.0f, (float)-1.0f, (float)0.0f);
        GL11.glRotatef((float)pitchYaw.field_189983_j, (float)1.0f, (float)0.0f, (float)0.0f);
        float[] colours = new float[]{1.0f, 0.9f, 0.2f};
        this.func_110776_a(TEXTURE_BEACON_BEAM);
        entity.func_70080_a((double)playerPos.func_177958_n(), (double)playerPos.func_177956_o(), (double)playerPos.func_177952_p(), 0.0f, 0.0f);
        RenderWandAttack.renderBeamSegment(x, y + 1.0, z, partialTicks, 1.0, 10000.0, 0, (int)dist, colours, 0.1, 0.2);
    }

    public static void renderBeamSegment(double x, double y, double z, double partialTicks, double textureScale, double totalWorldTime, int yOffset, double height, float[] colors, double beamRadius, double glowRadius) {
        int i = (int)((double)yOffset + height);
        GlStateManager.func_187421_b((int)3553, (int)10242, (int)10497);
        GlStateManager.func_187421_b((int)3553, (int)10243, (int)10497);
        GlStateManager.func_179140_f();
        GlStateManager.func_179129_p();
        GlStateManager.func_179084_k();
        GlStateManager.func_179132_a((boolean)true);
        GlStateManager.func_187428_a((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE, (GlStateManager.SourceFactor)GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor)GlStateManager.DestFactor.ZERO);
        Tessellator tessellator = Tessellator.func_178181_a();
        BufferBuilder bufferbuilder = tessellator.func_178180_c();
        double d0 = totalWorldTime + partialTicks;
        double d1 = height < 0.0 ? d0 : -d0;
        double d2 = Mth.func_181162_h((double)(d1 * 0.2 - (double)Mth.func_76128_c((double)(d1 * 0.1))));
        float f = colors[0];
        float f1 = colors[1];
        float f2 = colors[2];
        double d3 = d0 * 0.025 * -1.5;
        double d4 = 0.5 + Math.cos(d3 + 2.356194490192345) * beamRadius;
        double d5 = 0.5 + Math.sin(d3 + 2.356194490192345) * beamRadius;
        double d6 = 0.5 + Math.cos(d3 + 0.7853981633974483) * beamRadius;
        double d7 = 0.5 + Math.sin(d3 + 0.7853981633974483) * beamRadius;
        double d8 = 0.5 + Math.cos(d3 + 3.9269908169872414) * beamRadius;
        double d9 = 0.5 + Math.sin(d3 + 3.9269908169872414) * beamRadius;
        double d10 = 0.5 + Math.cos(d3 + 5.497787143782138) * beamRadius;
        double d11 = 0.5 + Math.sin(d3 + 5.497787143782138) * beamRadius;
        double d12 = 0.0;
        double d13 = 1.0;
        double d14 = -1.0 + d2;
        double d15 = height * textureScale * (0.5 / beamRadius) + d14;
        bufferbuilder.func_181668_a(7, DefaultVertexFormats.field_181709_i);
        bufferbuilder.func_181662_b(x + d4, y + (double)i, z + d5).func_187315_a(1.0, d15).func_181666_a(f, f1, f2, 1.0f).func_181675_d();
        bufferbuilder.func_181662_b(x + d4, y + (double)yOffset, z + d5).func_187315_a(1.0, d14).func_181666_a(f, f1, f2, 1.0f).func_181675_d();
        bufferbuilder.func_181662_b(x + d6, y + (double)yOffset, z + d7).func_187315_a(0.0, d14).func_181666_a(f, f1, f2, 1.0f).func_181675_d();
        bufferbuilder.func_181662_b(x + d6, y + (double)i, z + d7).func_187315_a(0.0, d15).func_181666_a(f, f1, f2, 1.0f).func_181675_d();
        bufferbuilder.func_181662_b(x + d10, y + (double)i, z + d11).func_187315_a(1.0, d15).func_181666_a(f, f1, f2, 1.0f).func_181675_d();
        bufferbuilder.func_181662_b(x + d10, y + (double)yOffset, z + d11).func_187315_a(1.0, d14).func_181666_a(f, f1, f2, 1.0f).func_181675_d();
        bufferbuilder.func_181662_b(x + d8, y + (double)yOffset, z + d9).func_187315_a(0.0, d14).func_181666_a(f, f1, f2, 1.0f).func_181675_d();
        bufferbuilder.func_181662_b(x + d8, y + (double)i, z + d9).func_187315_a(0.0, d15).func_181666_a(f, f1, f2, 1.0f).func_181675_d();
        bufferbuilder.func_181662_b(x + d6, y + (double)i, z + d7).func_187315_a(1.0, d15).func_181666_a(f, f1, f2, 1.0f).func_181675_d();
        bufferbuilder.func_181662_b(x + d6, y + (double)yOffset, z + d7).func_187315_a(1.0, d14).func_181666_a(f, f1, f2, 1.0f).func_181675_d();
        bufferbuilder.func_181662_b(x + d10, y + (double)yOffset, z + d11).func_187315_a(0.0, d14).func_181666_a(f, f1, f2, 1.0f).func_181675_d();
        bufferbuilder.func_181662_b(x + d10, y + (double)i, z + d11).func_187315_a(0.0, d15).func_181666_a(f, f1, f2, 1.0f).func_181675_d();
        bufferbuilder.func_181662_b(x + d8, y + (double)i, z + d9).func_187315_a(1.0, d15).func_181666_a(f, f1, f2, 1.0f).func_181675_d();
        bufferbuilder.func_181662_b(x + d8, y + (double)yOffset, z + d9).func_187315_a(1.0, d14).func_181666_a(f, f1, f2, 1.0f).func_181675_d();
        bufferbuilder.func_181662_b(x + d4, y + (double)yOffset, z + d5).func_187315_a(0.0, d14).func_181666_a(f, f1, f2, 1.0f).func_181675_d();
        bufferbuilder.func_181662_b(x + d4, y + (double)i, z + d5).func_187315_a(0.0, d15).func_181666_a(f, f1, f2, 1.0f).func_181675_d();
        tessellator.func_78381_a();
        GlStateManager.func_179147_l();
        GlStateManager.func_187428_a((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor)GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor)GlStateManager.DestFactor.ZERO);
        GlStateManager.func_179132_a((boolean)false);
        d3 = 0.5 - glowRadius;
        d4 = 0.5 - glowRadius;
        d5 = 0.5 + glowRadius;
        d6 = 0.5 - glowRadius;
        d7 = 0.5 - glowRadius;
        d8 = 0.5 + glowRadius;
        d9 = 0.5 + glowRadius;
        d10 = 0.5 + glowRadius;
        d11 = 0.0;
        d12 = 1.0;
        d13 = -1.0 + d2;
        d14 = height * textureScale + d13;
        bufferbuilder.func_181668_a(7, DefaultVertexFormats.field_181709_i);
        bufferbuilder.func_181662_b(x + d3, y + (double)i, z + d4).func_187315_a(1.0, d14).func_181666_a(f, f1, f2, 0.125f).func_181675_d();
        bufferbuilder.func_181662_b(x + d3, y + (double)yOffset, z + d4).func_187315_a(1.0, d13).func_181666_a(f, f1, f2, 0.125f).func_181675_d();
        bufferbuilder.func_181662_b(x + d5, y + (double)yOffset, z + d6).func_187315_a(0.0, d13).func_181666_a(f, f1, f2, 0.125f).func_181675_d();
        bufferbuilder.func_181662_b(x + d5, y + (double)i, z + d6).func_187315_a(0.0, d14).func_181666_a(f, f1, f2, 0.125f).func_181675_d();
        bufferbuilder.func_181662_b(x + d9, y + (double)i, z + d10).func_187315_a(1.0, d14).func_181666_a(f, f1, f2, 0.125f).func_181675_d();
        bufferbuilder.func_181662_b(x + d9, y + (double)yOffset, z + d10).func_187315_a(1.0, d13).func_181666_a(f, f1, f2, 0.125f).func_181675_d();
        bufferbuilder.func_181662_b(x + d7, y + (double)yOffset, z + d8).func_187315_a(0.0, d13).func_181666_a(f, f1, f2, 0.125f).func_181675_d();
        bufferbuilder.func_181662_b(x + d7, y + (double)i, z + d8).func_187315_a(0.0, d14).func_181666_a(f, f1, f2, 0.125f).func_181675_d();
        bufferbuilder.func_181662_b(x + d5, y + (double)i, z + d6).func_187315_a(1.0, d14).func_181666_a(f, f1, f2, 0.125f).func_181675_d();
        bufferbuilder.func_181662_b(x + d5, y + (double)yOffset, z + d6).func_187315_a(1.0, d13).func_181666_a(f, f1, f2, 0.125f).func_181675_d();
        bufferbuilder.func_181662_b(x + d9, y + (double)yOffset, z + d10).func_187315_a(0.0, d13).func_181666_a(f, f1, f2, 0.125f).func_181675_d();
        bufferbuilder.func_181662_b(x + d9, y + (double)i, z + d10).func_187315_a(0.0, d14).func_181666_a(f, f1, f2, 0.125f).func_181675_d();
        bufferbuilder.func_181662_b(x + d7, y + (double)i, z + d8).func_187315_a(1.0, d14).func_181666_a(f, f1, f2, 0.125f).func_181675_d();
        bufferbuilder.func_181662_b(x + d7, y + (double)yOffset, z + d8).func_187315_a(1.0, d13).func_181666_a(f, f1, f2, 0.125f).func_181675_d();
        bufferbuilder.func_181662_b(x + d3, y + (double)yOffset, z + d4).func_187315_a(0.0, d13).func_181666_a(f, f1, f2, 0.125f).func_181675_d();
        bufferbuilder.func_181662_b(x + d3, y + (double)i, z + d4).func_187315_a(0.0, d14).func_181666_a(f, f1, f2, 0.125f).func_181675_d();
        tessellator.func_78381_a();
        GlStateManager.func_179145_e();
        GlStateManager.func_179098_w();
        GlStateManager.func_179132_a((boolean)true);
    }

    protected ResourceLocation func_110775_a(T entity) {
        return null;
    }
}

