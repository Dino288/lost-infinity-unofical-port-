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
 *  net.minecraft.entity.player.Player
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.math.Vec3
 */
package xol.lostinfinity.mob.render.misc;

import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.phys.Vec3;
import xol.lostinfinity.mob.entity.misc.EntityWormholePortal;

public class RenderWormholePortal<T extends Entity>
extends Render<T> {
    public static final ResourceLocation TEXTURE_WORMHOLE_PORTAL = new ResourceLocation("lostinfinity:textures/particles/wormhole_portal.png");

    public RenderWormholePortal(RenderManager renderManager) {
        super(renderManager);
    }

    public void func_76986_a(T entity, double x, double y, double z, float entityYaw, float partialTicks) {
        Player caster;
        EntityWormholePortal attackEntity = (EntityWormholePortal)((Object)entity);
        Vec3 target = attackEntity.func_174791_d();
        if (target != null && !attackEntity.field_70128_L && (caster = attackEntity.getCaster()) != null) {
            this.func_110776_a(TEXTURE_WORMHOLE_PORTAL);
            Tessellator tessellator = Tessellator.func_178181_a();
            BufferBuilder bufferbuilder = tessellator.func_178180_c();
            GlStateManager.func_179129_p();
            GlStateManager.func_179141_d();
            GlStateManager.func_179140_f();
            float alpha = 0.7f;
            GlStateManager.func_179147_l();
            GlStateManager.func_179092_a((int)516, (float)0.2f);
            GlStateManager.func_179112_b((int)770, (int)771);
            GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)alpha);
            bufferbuilder.func_181668_a(7, DefaultVertexFormats.field_181707_g);
            double xPos = x;
            double yPos = y;
            double zPos = z;
            Vec3 targetLook = caster.func_70040_Z().func_72432_b();
            targetLook = targetLook.func_178786_a(0.0, targetLook.field_72448_b, 0.0);
            Vec3 dir = RenderWormholePortal.rotVec(targetLook, 1.5707963267948966);
            Vec3 upDir = new Vec3(0.0, 1.0, 0.0);
            double radians = (double)attackEntity.field_70173_aa / 10.0;
            dir = dir.func_186678_a(Math.cos(radians)).func_178787_e(this.crossProduct(targetLook, dir).func_186678_a(Math.sin(radians))).func_178787_e(targetLook.func_186678_a(this.dotProduct(targetLook, dir) * (1.0 - Math.cos(radians))));
            upDir = upDir.func_186678_a(Math.cos(radians)).func_178787_e(this.crossProduct(targetLook, upDir).func_186678_a(Math.sin(radians))).func_178787_e(targetLook.func_186678_a(this.dotProduct(targetLook, upDir) * (1.0 - Math.cos(radians))));
            float length = 0.5f;
            bufferbuilder.func_181662_b((double)(-0.5f * length) * dir.field_72450_a + 0.5 * (double)length * upDir.field_72450_a + xPos, 0.5 * (double)length * upDir.field_72448_b + yPos - (double)(0.5f * length) * dir.field_72448_b, (double)(-0.5f * length) * dir.field_72449_c + 0.5 * (double)length * upDir.field_72449_c + zPos).func_187315_a(0.0, 1.0).func_181675_d();
            bufferbuilder.func_181662_b((double)(-0.5f * length) * dir.field_72450_a - 0.5 * (double)length * upDir.field_72450_a + xPos, -0.5 * (double)length * upDir.field_72448_b + yPos - (double)(0.5f * length) * dir.field_72448_b, (double)(-0.5f * length) * dir.field_72449_c - 0.5 * (double)length * upDir.field_72449_c + zPos).func_187315_a(0.0, 0.0).func_181675_d();
            bufferbuilder.func_181662_b((double)(0.5f * length) * dir.field_72450_a - 0.5 * (double)length * upDir.field_72450_a + xPos, -0.5 * (double)length * upDir.field_72448_b + yPos + (double)(0.5f * length) * dir.field_72448_b, (double)(0.5f * length) * dir.field_72449_c - 0.5 * (double)length * upDir.field_72449_c + zPos).func_187315_a(1.0, 0.0).func_181675_d();
            bufferbuilder.func_181662_b((double)(0.5f * length) * dir.field_72450_a + 0.5 * (double)length * upDir.field_72450_a + xPos, 0.5 * (double)length * upDir.field_72448_b + yPos + (double)(0.5f * length) * dir.field_72448_b, (double)(0.5f * length) * dir.field_72449_c + 0.5 * (double)length * upDir.field_72449_c + zPos).func_187315_a(1.0, 1.0).func_181675_d();
            tessellator.func_78381_a();
            GlStateManager.func_179145_e();
            GlStateManager.func_179089_o();
            GlStateManager.func_179084_k();
        }
    }

    private double dotProduct(Vec3 vec1, Vec3 vec2) {
        return vec1.field_72450_a * vec2.field_72450_a + vec1.field_72448_b * vec2.field_72448_b + vec1.field_72449_c * vec2.field_72449_c;
    }

    private Vec3 crossProduct(Vec3 vec1, Vec3 vec2) {
        double x = vec1.field_72448_b * vec2.field_72449_c - vec1.field_72449_c * vec2.field_72448_b;
        double y = vec1.field_72449_c * vec2.field_72450_a - vec1.field_72450_a * vec2.field_72449_c;
        double z = vec1.field_72450_a * vec2.field_72448_b - vec1.field_72448_b * vec2.field_72450_a;
        return new Vec3(x, y, z);
    }

    private static Vec3 rotVec(Vec3 vec, double radians) {
        double x = vec.field_72450_a * Math.cos(radians) + vec.field_72449_c * Math.sin(radians);
        double y = vec.field_72448_b;
        double z = -vec.field_72450_a * Math.sin(radians) + vec.field_72449_c * Math.cos(radians);
        return new Vec3(x, y, z);
    }

    protected ResourceLocation func_110775_a(T entity) {
        return null;
    }
}

