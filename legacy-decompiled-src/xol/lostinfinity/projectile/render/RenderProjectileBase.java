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
 */
package xol.lostinfinity.projectile.render;

import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.world.entity.Entity;

public abstract class RenderProjectileBase<T extends Entity>
extends Render<T> {
    private final float scale;

    public RenderProjectileBase(RenderManager manager, float scaleIn) {
        super(manager);
        this.scale = scaleIn;
    }

    public void func_76986_a(T entity, double x, double y, double z, float entityYaw, float partialTicks) {
        GlStateManager.func_179094_E();
        this.func_180548_c((Entity)entity);
        GlStateManager.func_179109_b((float)((float)x), (float)((float)y), (float)((float)z));
        GlStateManager.func_179091_B();
        GlStateManager.func_179152_a((float)(this.scale * 0.5f), (float)(this.scale * 0.5f), (float)(this.scale * 0.5f));
        Tessellator tessellator = Tessellator.func_178181_a();
        BufferBuilder bufferbuilder = tessellator.func_178180_c();
        float f = 1.0f;
        float f1 = 0.5f;
        float f2 = 0.25f;
        GlStateManager.func_179114_b((float)(180.0f - this.field_76990_c.field_78735_i), (float)0.0f, (float)1.0f, (float)0.0f);
        GlStateManager.func_179114_b((float)((float)(this.field_76990_c.field_78733_k.field_74320_O == 2 ? -1 : 1) * -this.field_76990_c.field_78732_j), (float)1.0f, (float)0.0f, (float)0.0f);
        if (this.field_188301_f) {
            GlStateManager.func_179142_g();
            GlStateManager.func_187431_e((int)this.func_188298_c((Entity)entity));
        }
        bufferbuilder.func_181668_a(7, DefaultVertexFormats.field_181710_j);
        bufferbuilder.func_181662_b(-0.5, -0.25, 0.0).func_187315_a(0.0, 1.0).func_181663_c(0.0f, 1.0f, 0.0f).func_181675_d();
        bufferbuilder.func_181662_b(0.5, -0.25, 0.0).func_187315_a(1.0, 1.0).func_181663_c(0.0f, 1.0f, 0.0f).func_181675_d();
        bufferbuilder.func_181662_b(0.5, 0.75, 0.0).func_187315_a(1.0, 0.0).func_181663_c(0.0f, 1.0f, 0.0f).func_181675_d();
        bufferbuilder.func_181662_b(-0.5, 0.75, 0.0).func_187315_a(0.0, 0.0).func_181663_c(0.0f, 1.0f, 0.0f).func_181675_d();
        tessellator.func_78381_a();
        if (this.field_188301_f) {
            GlStateManager.func_187417_n();
            GlStateManager.func_179119_h();
        }
        GlStateManager.func_179101_C();
        GlStateManager.func_179121_F();
        super.func_76986_a(entity, x, y, z, entityYaw, partialTicks);
    }
}

