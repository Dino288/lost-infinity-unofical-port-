/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.renderer.BufferBuilder
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.Tessellator
 *  net.minecraft.client.renderer.entity.Render
 *  net.minecraft.client.renderer.entity.RenderManager
 *  net.minecraft.client.renderer.vertex.DefaultVertexFormats
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.math.Vec3
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
import net.minecraft.world.phys.Vec3;
import xol.lostinfinity.projectile.entity.EntityDuskerQueenWeb;

public class RenderDuskerQueenWeb<T extends Entity>
extends Render<T> {
    public static final ResourceLocation TEXTURE_QUEEN_WEB = new ResourceLocation("lostinfinity:textures/particles/queen_web.png");

    public RenderDuskerQueenWeb(RenderManager renderManager) {
        super(renderManager);
    }

    public void func_76986_a(T entity, double x, double y, double z, float entityYaw, float partialTicks) {
        EntityDuskerQueenWeb attackEntity = (EntityDuskerQueenWeb)entity;
        Vec3 targetPos = attackEntity.getPlayerPos();
        Vec3 stopPos = attackEntity.getStopPos();
        float segmentHeight = 1.5f;
        float segmentLength = 1.0f;
        float growth = attackEntity.getGrowth();
        if (targetPos != null && ((Entity)entity).field_70173_aa > 2) {
            this.func_110776_a(TEXTURE_QUEEN_WEB);
            Tessellator tessellator = Tessellator.func_178181_a();
            BufferBuilder bufferbuilder = tessellator.func_178180_c();
            GlStateManager.func_179129_p();
            GlStateManager.func_179141_d();
            GlStateManager.func_179140_f();
            GlStateManager.func_179147_l();
            GlStateManager.func_179092_a((int)516, (float)0.4f);
            float alpha = 1.0f;
            GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)alpha);
            bufferbuilder.func_181668_a(7, DefaultVertexFormats.field_181707_g);
            if (stopPos != null) {
                float dist = (float)attackEntity.func_174791_d().func_72438_d(stopPos);
                Vec3 dir = stopPos.func_178788_d(attackEntity.func_174791_d());
                dir = dir.func_72432_b();
                for (int i = 0; i < (int)Math.floor(dist / segmentLength); ++i) {
                    double xPos = x + dir.field_72450_a * (double)i * (double)segmentLength;
                    double yPos = y + dir.field_72448_b * (double)i * (double)segmentLength;
                    double zPos = z + dir.field_72449_c * (double)i * (double)segmentLength;
                    bufferbuilder.func_181662_b(xPos, yPos + (double)segmentHeight, zPos).func_187315_a(0.0, 1.0).func_181675_d();
                    bufferbuilder.func_181662_b(xPos, yPos, zPos).func_187315_a(0.0, 0.0).func_181675_d();
                    bufferbuilder.func_181662_b(xPos + (double)segmentLength * dir.field_72450_a, yPos + (double)segmentLength * dir.field_72448_b, zPos + (double)segmentLength * dir.field_72449_c).func_187315_a(1.0, 0.0).func_181675_d();
                    bufferbuilder.func_181662_b(xPos + (double)segmentLength * dir.field_72450_a, yPos + (double)segmentHeight + (double)segmentLength * dir.field_72448_b, zPos + (double)segmentLength * dir.field_72449_c).func_187315_a(1.0, 1.0).func_181675_d();
                }
            } else {
                float dist = (float)attackEntity.func_174791_d().func_72438_d(targetPos);
                Vec3 dir = targetPos.func_178788_d(attackEntity.func_174791_d());
                dir = dir.func_72432_b();
                for (int i = 0; i < (int)Math.floor(dist * growth / segmentLength); ++i) {
                    double xPos = x + dir.field_72450_a * (double)i * (double)segmentLength;
                    double yPos = y + dir.field_72448_b * (double)i * (double)segmentLength;
                    double zPos = z + dir.field_72449_c * (double)i * (double)segmentLength;
                    bufferbuilder.func_181662_b(xPos, yPos + (double)segmentHeight, zPos).func_187315_a(0.0, 1.0).func_181675_d();
                    bufferbuilder.func_181662_b(xPos, yPos, zPos).func_187315_a(0.0, 0.0).func_181675_d();
                    bufferbuilder.func_181662_b(xPos + (double)segmentLength * dir.field_72450_a, yPos + (double)segmentLength * dir.field_72448_b, zPos + (double)segmentLength * dir.field_72449_c).func_187315_a(1.0, 0.0).func_181675_d();
                    bufferbuilder.func_181662_b(xPos + (double)segmentLength * dir.field_72450_a, yPos + (double)segmentHeight + (double)segmentLength * dir.field_72448_b, zPos + (double)segmentLength * dir.field_72449_c).func_187315_a(1.0, 1.0).func_181675_d();
                }
            }
            tessellator.func_78381_a();
            GlStateManager.func_179118_c();
            GlStateManager.func_179145_e();
            GlStateManager.func_179089_o();
            GlStateManager.func_179084_k();
        }
    }

    protected ResourceLocation func_110775_a(T entity) {
        return null;
    }
}

