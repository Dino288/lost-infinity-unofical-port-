/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.model.ModelRenderer
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.math.Mth
 */
package xol.lostinfinity.stone.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;

public class ModelInfinityOpal
extends ModelBase {
    public ModelRenderer shape1;
    public ModelRenderer shape2;
    public ModelRenderer shape3;
    public ModelRenderer shape4;

    public ModelInfinityOpal() {
        this.field_78090_t = 128;
        this.field_78089_u = 32;
        this.shape1 = new ModelRenderer((ModelBase)this, 0, 0);
        this.shape1.func_78793_a(0.0f, 5.0f, 0.0f);
        this.shape1.func_78790_a(-2.0f, -9.0f, -2.0f, 4, 18, 4, 0.0f);
        this.shape3 = new ModelRenderer((ModelBase)this, 51, 0);
        this.shape3.func_78793_a(0.0f, 5.0f, 0.0f);
        this.shape3.func_78790_a(-4.0f, -7.0f, -4.0f, 8, 14, 8, 0.0f);
        this.shape2 = new ModelRenderer((ModelBase)this, 20, 0);
        this.shape2.func_78793_a(0.0f, 5.0f, 0.0f);
        this.shape2.func_78790_a(-3.0f, -8.0f, -3.0f, 6, 16, 6, 0.0f);
        this.shape4 = new ModelRenderer((ModelBase)this, 86, 0);
        this.shape4.func_78793_a(0.0f, 5.0f, 0.0f);
        this.shape4.func_78790_a(-5.0f, -5.0f, -5.0f, 10, 10, 10, 0.0f);
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        GlStateManager.func_179147_l();
        GlStateManager.func_179112_b((int)770, (int)771);
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)(0.7f + 0.2f * Mth.func_76126_a((float)(f2 * 0.1f))));
        this.shape1.func_78785_a(f5);
        GlStateManager.func_179084_k();
        GlStateManager.func_179147_l();
        GlStateManager.func_179112_b((int)770, (int)771);
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)(0.7f + 0.2f * Mth.func_76126_a((float)(f2 * 0.1f))));
        this.shape3.func_78785_a(f5);
        GlStateManager.func_179084_k();
        GlStateManager.func_179147_l();
        GlStateManager.func_179112_b((int)770, (int)771);
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)(0.7f + 0.2f * Mth.func_76126_a((float)(f2 * 0.1f))));
        this.shape2.func_78785_a(f5);
        GlStateManager.func_179084_k();
        GlStateManager.func_179147_l();
        GlStateManager.func_179112_b((int)770, (int)771);
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)(0.7f + 0.2f * Mth.func_76126_a((float)(f2 * 0.1f))));
        this.shape4.func_78785_a(f5);
        GlStateManager.func_179084_k();
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.shape1.field_78796_g = Mth.func_76134_b((float)(ageInTicks * 0.05f)) * (float)Math.PI * 0.67f - 0.7f;
        this.shape2.field_78796_g = Mth.func_76134_b((float)(ageInTicks * 0.05f)) * (float)Math.PI * 0.67f - 0.7f;
        this.shape3.field_78796_g = Mth.func_76134_b((float)(ageInTicks * 0.05f)) * (float)Math.PI * 0.67f - 0.7f;
        this.shape4.field_78796_g = Mth.func_76134_b((float)(ageInTicks * 0.05f)) * (float)Math.PI * 0.67f - 0.7f;
    }
}

