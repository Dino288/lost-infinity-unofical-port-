/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
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

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.phys.Vec3;
import xol.lostinfinity.projectile.entity.EntityChainOfVenomsAttack;

public class RenderChainOfVenomsAttack<T extends Entity>
extends Render<T> {
    public static final ResourceLocation TEXTURE_VENOM_CHAIN = new ResourceLocation("lostinfinity:textures/particles/venom_chain.png");

    public RenderChainOfVenomsAttack(RenderManager renderManager) {
        super(renderManager);
    }

    public void func_76986_a(T entity, double x, double y, double z, float entityYaw, float partialTicks) {
        EntityChainOfVenomsAttack attackEntity = (EntityChainOfVenomsAttack)((Object)entity);
        Vec3 playerPos = null;
        if (Minecraft.func_71410_x().field_71439_g != null) {
            playerPos = Minecraft.func_71410_x().field_71439_g.func_174791_d();
        }
        Vec3 target = attackEntity.getOriginPos();
        Vec3 target2 = attackEntity.getTargetPos();
        double targetHeight = attackEntity.getOriginHeight();
        double target2Height = attackEntity.getTargetHeight();
        if (target != null && target2 != null && playerPos != null) {
            float alpha;
            Vec3 targetVec = new Vec3(target.field_72450_a, target.field_72448_b + targetHeight / 2.0, target.field_72449_c);
            Vec3 target2Vec = new Vec3(target2.field_72450_a, target2.field_72448_b + target2Height / 2.0, target2.field_72449_c);
            Vec3 dir = target2Vec.func_178788_d(targetVec);
            dir = dir.func_72432_b();
            double dist = Math.sqrt(Math.pow(targetVec.field_72450_a - target2Vec.field_72450_a, 2.0) + Math.pow(targetVec.field_72448_b - target2Vec.field_72448_b, 2.0) + Math.pow(targetVec.field_72449_c - target2Vec.field_72449_c, 2.0));
            this.func_110776_a(TEXTURE_VENOM_CHAIN);
            Tessellator tessellator = Tessellator.func_178181_a();
            BufferBuilder bufferbuilder = tessellator.func_178180_c();
            double segmentLength = 0.8;
            double segmentHeight = 0.8;
            GlStateManager.func_179129_p();
            GlStateManager.func_179141_d();
            float brightness = 1.0f;
            GlStateManager.func_179147_l();
            GlStateManager.func_179092_a((int)516, (float)0.4f);
            if (((Entity)entity).field_70173_aa % 20 < 8) {
                brightness = 0.5f + (float)(((Entity)entity).field_70173_aa % 20) * 0.0625f;
                alpha = 0.3f + (float)(((Entity)entity).field_70173_aa % 20) * 0.2f;
            } else {
                alpha = 1.0f - (float)(((Entity)entity).field_70173_aa % 20 - 8) * 0.1f;
            }
            GlStateManager.func_179131_c((float)brightness, (float)brightness, (float)brightness, (float)alpha);
            bufferbuilder.func_181668_a(7, DefaultVertexFormats.field_181707_g);
            for (int i = 0; i < (int)Math.floor(dist / segmentLength); ++i) {
                double xPos = targetVec.field_72450_a - playerPos.field_72450_a + dir.field_72450_a * (double)i * segmentLength;
                double yPos = targetVec.field_72448_b - playerPos.field_72448_b + dir.field_72448_b * (double)i * segmentLength;
                double zPos = targetVec.field_72449_c - playerPos.field_72449_c + dir.field_72449_c * (double)i * segmentLength;
                bufferbuilder.func_181662_b(xPos, yPos + segmentHeight, zPos).func_187315_a(0.0, 1.0).func_181675_d();
                bufferbuilder.func_181662_b(xPos, yPos, zPos).func_187315_a(0.0, 0.0).func_181675_d();
                bufferbuilder.func_181662_b(xPos + segmentLength * dir.field_72450_a, yPos + segmentLength * dir.field_72448_b, zPos + segmentLength * dir.field_72449_c).func_187315_a(1.0, 0.0).func_181675_d();
                bufferbuilder.func_181662_b(xPos + segmentLength * dir.field_72450_a, yPos + segmentHeight + segmentLength * dir.field_72448_b, zPos + segmentLength * dir.field_72449_c).func_187315_a(1.0, 1.0).func_181675_d();
            }
            tessellator.func_78381_a();
            GlStateManager.func_179089_o();
            GlStateManager.func_179084_k();
        }
    }

    protected ResourceLocation func_110775_a(T entity) {
        return null;
    }
}

