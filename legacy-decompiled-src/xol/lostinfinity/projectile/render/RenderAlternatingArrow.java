/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.client.renderer.BufferBuilder
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.Tessellator
 *  net.minecraft.client.renderer.entity.Render
 *  net.minecraft.client.renderer.entity.RenderManager
 *  net.minecraft.client.renderer.vertex.DefaultVertexFormats
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.math.Mth
 */
package xol.lostinfinity.projectile.render;

import javax.annotation.Nullable;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import xol.lostinfinity.projectile.entity.EntityBaseThrowable;

public class RenderAlternatingArrow<T extends EntityBaseThrowable>
extends Render<T> {
    private final ResourceLocation texture;
    private final ResourceLocation texture2;
    private int switch_timer = 5;

    public RenderAlternatingArrow(RenderManager renderManager, ResourceLocation location, ResourceLocation loc2) {
        super(renderManager);
        this.texture = location;
        this.texture2 = loc2;
    }

    public RenderAlternatingArrow(RenderManager renderManager, ResourceLocation location, ResourceLocation loc2, int timer) {
        super(renderManager);
        this.texture = location;
        this.texture2 = loc2;
        this.switch_timer = timer;
    }

    public void doRender(T entity, double x, double y, double z, float entityYaw, float partialTicks) {
        this.func_180548_c((Entity)entity);
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        GlStateManager.func_179094_E();
        GlStateManager.func_179140_f();
        GlStateManager.func_179109_b((float)((float)x), (float)((float)y), (float)((float)z));
        GlStateManager.func_179114_b((float)(((EntityBaseThrowable)entity).field_70126_B + (((EntityBaseThrowable)entity).field_70177_z - ((EntityBaseThrowable)entity).field_70126_B) * partialTicks - 90.0f), (float)0.0f, (float)1.0f, (float)0.0f);
        GlStateManager.func_179114_b((float)(((EntityBaseThrowable)entity).field_70127_C + (((EntityBaseThrowable)entity).field_70125_A - ((EntityBaseThrowable)entity).field_70127_C) * partialTicks), (float)0.0f, (float)0.0f, (float)1.0f);
        Tessellator tessellator = Tessellator.func_178181_a();
        BufferBuilder bufferbuilder = tessellator.func_178180_c();
        boolean i = false;
        float f = 0.0f;
        float f1 = 0.5f;
        float f2 = 0.0f;
        float f3 = 0.15625f;
        float f4 = 0.0f;
        float f5 = 0.15625f;
        float f6 = 0.15625f;
        float f7 = 0.3125f;
        float f8 = 0.05625f;
        GlStateManager.func_179091_B();
        float f9 = 0.0f;
        if (f9 > 0.0f) {
            float f10 = -Mth.func_76126_a((float)(f9 * 3.0f)) * f9;
            GlStateManager.func_179114_b((float)f10, (float)0.0f, (float)0.0f, (float)1.0f);
        }
        GlStateManager.func_179114_b((float)45.0f, (float)1.0f, (float)0.0f, (float)0.0f);
        GlStateManager.func_179152_a((float)0.05625f, (float)0.05625f, (float)0.05625f);
        GlStateManager.func_179109_b((float)-4.0f, (float)0.0f, (float)0.0f);
        if (this.field_188301_f) {
            GlStateManager.func_179142_g();
            GlStateManager.func_187431_e((int)this.func_188298_c((Entity)entity));
        }
        GlStateManager.func_187432_a((float)0.05625f, (float)0.0f, (float)0.0f);
        bufferbuilder.func_181668_a(7, DefaultVertexFormats.field_181707_g);
        bufferbuilder.func_181662_b(-7.0, -2.0, -2.0).func_187315_a(0.0, 0.15625).func_181675_d();
        bufferbuilder.func_181662_b(-7.0, -2.0, 2.0).func_187315_a(0.15625, 0.15625).func_181675_d();
        bufferbuilder.func_181662_b(-7.0, 2.0, 2.0).func_187315_a(0.15625, 0.3125).func_181675_d();
        bufferbuilder.func_181662_b(-7.0, 2.0, -2.0).func_187315_a(0.0, 0.3125).func_181675_d();
        tessellator.func_78381_a();
        GlStateManager.func_187432_a((float)-0.05625f, (float)0.0f, (float)0.0f);
        bufferbuilder.func_181668_a(7, DefaultVertexFormats.field_181707_g);
        bufferbuilder.func_181662_b(-7.0, 2.0, -2.0).func_187315_a(0.0, 0.15625).func_181675_d();
        bufferbuilder.func_181662_b(-7.0, 2.0, 2.0).func_187315_a(0.15625, 0.15625).func_181675_d();
        bufferbuilder.func_181662_b(-7.0, -2.0, 2.0).func_187315_a(0.15625, 0.3125).func_181675_d();
        bufferbuilder.func_181662_b(-7.0, -2.0, -2.0).func_187315_a(0.0, 0.3125).func_181675_d();
        tessellator.func_78381_a();
        for (int j = 0; j < 4; ++j) {
            GlStateManager.func_179114_b((float)90.0f, (float)1.0f, (float)0.0f, (float)0.0f);
            GlStateManager.func_187432_a((float)0.0f, (float)0.0f, (float)0.05625f);
            bufferbuilder.func_181668_a(7, DefaultVertexFormats.field_181707_g);
            bufferbuilder.func_181662_b(-8.0, -2.0, 0.0).func_187315_a(0.0, 0.0).func_181675_d();
            bufferbuilder.func_181662_b(8.0, -2.0, 0.0).func_187315_a(0.5, 0.0).func_181675_d();
            bufferbuilder.func_181662_b(8.0, 2.0, 0.0).func_187315_a(0.5, 0.15625).func_181675_d();
            bufferbuilder.func_181662_b(-8.0, 2.0, 0.0).func_187315_a(0.0, 0.15625).func_181675_d();
            tessellator.func_78381_a();
        }
        if (this.field_188301_f) {
            GlStateManager.func_187417_n();
            GlStateManager.func_179119_h();
        }
        GlStateManager.func_179101_C();
        GlStateManager.func_179145_e();
        GlStateManager.func_179121_F();
        super.func_76986_a(entity, x, y, z, entityYaw, partialTicks);
    }

    @Nullable
    protected ResourceLocation getEntityTexture(T entity) {
        if (((EntityBaseThrowable)entity).field_70173_aa % this.switch_timer * 2 < this.switch_timer) {
            return this.texture;
        }
        return this.texture2;
    }
}

