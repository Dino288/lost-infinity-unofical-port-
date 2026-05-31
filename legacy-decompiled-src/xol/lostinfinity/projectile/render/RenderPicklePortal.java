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
import xol.lostinfinity.projectile.entity.EntityPicklePortal;

public class RenderPicklePortal<T extends Entity>
extends Render<T> {
    public static final ResourceLocation TEXTURE_PORTAL_EFFECT = new ResourceLocation("lostinfinity:textures/particles/pickle_portal.png");

    public RenderPicklePortal(RenderManager renderManager) {
        super(renderManager);
    }

    public void func_76986_a(T entity, double x, double y, double z, float entityYaw, float partialTicks) {
        EntityPicklePortal attackEntity = (EntityPicklePortal)((Object)entity);
        Vec3 target = attackEntity.func_174791_d();
        double targetHeight = 0.0;
        if (target != null && ((Entity)entity).field_70173_aa > 2) {
            this.func_110776_a(TEXTURE_PORTAL_EFFECT);
            Tessellator tessellator = Tessellator.func_178181_a();
            BufferBuilder bufferbuilder = tessellator.func_178180_c();
            float growth = attackEntity.getGrowth();
            float rotation = attackEntity.getRotation();
            float alpha = 1.0f;
            if (attackEntity.field_70173_aa >= 100) {
                alpha -= (float)(attackEntity.field_70173_aa - 100) * 0.05f;
            }
            GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)alpha);
            GlStateManager.func_179129_p();
            GlStateManager.func_179141_d();
            GlStateManager.func_179140_f();
            GlStateManager.func_179147_l();
            GlStateManager.func_179092_a((int)516, (float)0.2f);
            GlStateManager.func_179112_b((int)770, (int)771);
            bufferbuilder.func_181668_a(7, DefaultVertexFormats.field_181707_g);
            double xPos = x;
            double yPos = y;
            double zPos = z;
            Vec3 dirRight = new Vec3(1.0, 0.0, 0.0);
            dirRight = dirRight.func_178785_b(rotation);
            Vec3 dirForward = new Vec3(0.0, 0.0, 1.0);
            dirForward = dirForward.func_178785_b(rotation);
            bufferbuilder.func_181662_b((double)(-0.5f * growth) * dirRight.field_72450_a + (double)(0.5f * growth) * dirForward.field_72450_a + xPos, (double)(-0.5f * growth) * dirRight.field_72449_c + (double)(0.5f * growth) * dirForward.field_72449_c + targetHeight + yPos, zPos).func_187315_a(0.0, 1.0).func_181675_d();
            bufferbuilder.func_181662_b((double)(-0.5f * growth) * dirRight.field_72450_a - (double)(0.5f * growth) * dirForward.field_72450_a + xPos, (double)(-0.5f * growth) * dirRight.field_72449_c - (double)(0.5f * growth) * dirForward.field_72449_c + targetHeight + yPos, zPos).func_187315_a(0.0, 0.0).func_181675_d();
            bufferbuilder.func_181662_b((double)(0.5f * growth) * dirRight.field_72450_a - (double)(0.5f * growth) * dirForward.field_72450_a + xPos, (double)(0.5f * growth) * dirRight.field_72449_c - (double)(0.5f * growth) * dirForward.field_72449_c + targetHeight + yPos, zPos).func_187315_a(1.0, 0.0).func_181675_d();
            bufferbuilder.func_181662_b((double)(0.5f * growth) * dirRight.field_72450_a + (double)(0.5f * growth) * dirForward.field_72450_a + xPos, (double)(0.5f * growth) * dirRight.field_72449_c + (double)(0.5f * growth) * dirForward.field_72449_c + targetHeight + yPos, zPos).func_187315_a(1.0, 1.0).func_181675_d();
            tessellator.func_78381_a();
            GlStateManager.func_179145_e();
            GlStateManager.func_179089_o();
            GlStateManager.func_179084_k();
            GlStateManager.func_179118_c();
        }
    }

    protected ResourceLocation func_110775_a(T entity) {
        return null;
    }
}

