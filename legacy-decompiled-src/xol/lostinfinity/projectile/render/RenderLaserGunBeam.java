/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.renderer.BufferBuilder
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.Tessellator
 *  net.minecraft.client.renderer.culling.ICamera
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
import net.minecraft.client.renderer.culling.ICamera;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.phys.Vec3;
import xol.lostinfinity.projectile.entity.EntityLaserGunBeam;

public class RenderLaserGunBeam<T extends Entity>
extends Render<T> {
    public static final ResourceLocation TEXTURE_LASER_BEAM = new ResourceLocation("lostinfinity:textures/particles/laser_beam.png");
    public static final ResourceLocation TEXTURE_LASER_END = new ResourceLocation("lostinfinity:textures/particles/laser_beam_blue_bright.png");

    public RenderLaserGunBeam(RenderManager renderManager) {
        super(renderManager);
    }

    public void func_76986_a(T entity, double x, double y, double z, float entityYaw, float partialTicks) {
        EntityLaserGunBeam attackEntity = (EntityLaserGunBeam)entity;
        Vec3 stopPos = attackEntity.getTargetPos();
        if (stopPos == null) {
            return;
        }
        int chargePoint = 22;
        float growth = 0.004f;
        float acceleration = 0.0f;
        float maxSegHeight = 1.6f;
        float segmentHeight = (growth + acceleration * (float)attackEntity.counter / 2.0f) * (float)attackEntity.counter;
        if (attackEntity.counter > chargePoint) {
            acceleration = 0.003f;
            segmentHeight = (growth + acceleration * ((float)attackEntity.counter / 2.0f)) * (float)(attackEntity.counter - chargePoint) + 0.08f;
        }
        if (segmentHeight > maxSegHeight) {
            segmentHeight = maxSegHeight;
        }
        float segmentLength = 1.0f;
        if (attackEntity.counter > 2) {
            if (attackEntity.counter > 34 && attackEntity.counter < 38) {
                this.func_110776_a(TEXTURE_LASER_END);
            } else {
                this.func_110776_a(TEXTURE_LASER_BEAM);
            }
            Tessellator tessellator = Tessellator.func_178181_a();
            BufferBuilder bufferbuilder = tessellator.func_178180_c();
            GlStateManager.func_179129_p();
            GlStateManager.func_179141_d();
            GlStateManager.func_179140_f();
            GlStateManager.func_179147_l();
            GlStateManager.func_179092_a((int)516, (float)0.15f);
            GlStateManager.func_179112_b((int)770, (int)771);
            float alpha = 1.0f;
            if (attackEntity.counter > 32) {
                alpha = 1.0f - 0.125f * (float)(attackEntity.counter - 32);
            }
            GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)alpha);
            bufferbuilder.func_181668_a(7, DefaultVertexFormats.field_181707_g);
            float dist = (float)attackEntity.getDist();
            Vec3 dir = stopPos.func_178788_d(attackEntity.func_174791_d());
            dir = dir.func_72432_b();
            for (int i = 0; i < (int)Math.floor(dist / segmentLength); ++i) {
                double xPos = x + dir.field_72450_a * (double)i * (double)segmentLength;
                double yPos = y + dir.field_72448_b * (double)i * (double)segmentLength - (double)(segmentHeight / 2.0f) + 0.5;
                double zPos = z + dir.field_72449_c * (double)i * (double)segmentLength;
                bufferbuilder.func_181662_b(xPos, yPos + (double)segmentHeight, zPos).func_187315_a(0.0, 1.0).func_181675_d();
                bufferbuilder.func_181662_b(xPos, yPos, zPos).func_187315_a(0.0, 0.0).func_181675_d();
                bufferbuilder.func_181662_b(xPos + (double)segmentLength * dir.field_72450_a, yPos + (double)segmentLength * dir.field_72448_b, zPos + (double)segmentLength * dir.field_72449_c).func_187315_a(1.0, 0.0).func_181675_d();
                bufferbuilder.func_181662_b(xPos + (double)segmentLength * dir.field_72450_a, yPos + (double)segmentHeight + (double)segmentLength * dir.field_72448_b, zPos + (double)segmentLength * dir.field_72449_c).func_187315_a(1.0, 1.0).func_181675_d();
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

    public boolean func_177071_a(T livingEntity, ICamera camera, double camX, double camY, double camZ) {
        return true;
    }
}

