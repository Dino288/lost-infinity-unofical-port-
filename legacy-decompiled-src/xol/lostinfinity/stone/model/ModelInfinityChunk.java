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

public class ModelInfinityChunk
extends ModelBase {
    public ModelRenderer shape2;
    public ModelRenderer shape3;
    public ModelRenderer shape4;
    public ModelRenderer shape5;
    public ModelRenderer shape6;
    public ModelRenderer shape7;
    public ModelRenderer shape8;
    public ModelRenderer shape9;
    public ModelRenderer shape10;
    public ModelRenderer shape11;
    public ModelRenderer shape12;
    public ModelRenderer shape13;
    public ModelRenderer shape14;
    public ModelRenderer shape15;
    public ModelRenderer shape16;
    public ModelRenderer shape18;
    public ModelRenderer shape17;
    public ModelRenderer shape19;
    public ModelRenderer shape20;
    public ModelRenderer shape21;
    public ModelRenderer shape22;
    public ModelRenderer shape23;
    public ModelRenderer shape1;

    public ModelInfinityChunk() {
        this.field_78090_t = 32;
        this.field_78089_u = 32;
        this.shape7 = new ModelRenderer((ModelBase)this, 16, 0);
        this.shape7.func_78793_a(0.0f, 10.0f, 0.0f);
        this.shape7.func_78790_a(-6.0f, -6.0f, -2.0f, 4, 4, 4, 0.0f);
        this.shape13 = new ModelRenderer((ModelBase)this, 16, 0);
        this.shape13.func_78793_a(0.0f, 10.0f, 0.0f);
        this.shape13.func_78790_a(-6.0f, -2.0f, -2.0f, 4, 4, 4, 0.0f);
        this.shape16 = new ModelRenderer((ModelBase)this, 16, 16);
        this.shape16.func_78793_a(0.0f, 10.0f, 0.0f);
        this.shape16.func_78790_a(-2.0f, -10.0f, -6.0f, 4, 4, 4, 0.0f);
        this.shape17 = new ModelRenderer((ModelBase)this, 16, 0);
        this.shape17.func_78793_a(0.0f, 10.0f, 0.0f);
        this.shape17.func_78790_a(-2.0f, -6.0f, 2.0f, 4, 4, 4, 0.0f);
        this.shape9 = new ModelRenderer((ModelBase)this, 0, 0);
        this.shape9.func_78793_a(0.0f, 10.0f, 0.0f);
        this.shape9.func_78790_a(-2.0f, -6.0f, -10.0f, 4, 4, 4, 0.0f);
        this.shape15 = new ModelRenderer((ModelBase)this, 16, 0);
        this.shape15.func_78793_a(0.0f, 10.0f, 0.0f);
        this.shape15.func_78790_a(-6.0f, -10.0f, -2.0f, 4, 4, 4, 0.0f);
        this.shape23 = new ModelRenderer((ModelBase)this, 0, 0);
        this.shape23.func_78793_a(0.0f, 10.0f, 0.0f);
        this.shape23.func_78790_a(2.0f, -2.0f, -2.0f, 4, 4, 4, 0.0f);
        this.shape18 = new ModelRenderer((ModelBase)this, 0, 0);
        this.shape18.func_78793_a(0.0f, 10.0f, 0.0f);
        this.shape18.func_78790_a(-2.0f, -10.0f, 2.0f, 4, 4, 4, 0.0f);
        this.shape4 = new ModelRenderer((ModelBase)this, 16, 16);
        this.shape4.func_78793_a(0.0f, 10.0f, 0.0f);
        this.shape4.func_78790_a(-2.0f, -10.0f, -2.0f, 4, 4, 4, 0.0f);
        this.shape6 = new ModelRenderer((ModelBase)this, 0, 0);
        this.shape6.func_78793_a(0.0f, 10.0f, 0.0f);
        this.shape6.func_78790_a(-2.0f, -6.0f, 2.0f, 4, 4, 4, 0.0f);
        this.shape12 = new ModelRenderer((ModelBase)this, 0, 16);
        this.shape12.func_78793_a(0.0f, 10.0f, 0.0f);
        this.shape12.func_78790_a(-6.0f, -6.0f, 2.0f, 4, 4, 4, 0.0f);
        this.shape20 = new ModelRenderer((ModelBase)this, 0, 0);
        this.shape20.func_78793_a(0.0f, 10.0f, 0.0f);
        this.shape20.func_78790_a(2.0f, -10.0f, -2.0f, 4, 4, 4, 0.0f);
        this.shape21 = new ModelRenderer((ModelBase)this, 16, 0);
        this.shape21.func_78793_a(0.0f, 10.0f, 0.0f);
        this.shape21.func_78790_a(6.0f, -6.0f, -2.0f, 4, 4, 4, 0.0f);
        this.shape2 = new ModelRenderer((ModelBase)this, 16, 0);
        this.shape2.func_78793_a(0.0f, 10.0f, 0.0f);
        this.shape2.func_78790_a(-2.0f, -2.0f, -6.0f, 4, 4, 4, 0.0f);
        this.shape14 = new ModelRenderer((ModelBase)this, 0, 0);
        this.shape14.func_78793_a(0.0f, 10.0f, 0.0f);
        this.shape14.func_78790_a(-6.0f, -6.0f, -6.0f, 4, 4, 4, 0.0f);
        this.shape8 = new ModelRenderer((ModelBase)this, 0, 0);
        this.shape8.func_78793_a(0.0f, 10.0f, 0.0f);
        this.shape8.func_78790_a(2.0f, -6.0f, -2.0f, 4, 4, 4, 0.0f);
        this.shape19 = new ModelRenderer((ModelBase)this, 0, 16);
        this.shape19.func_78793_a(0.0f, 10.0f, 0.0f);
        this.shape19.func_78790_a(-2.0f, -14.0f, -2.0f, 4, 4, 4, 0.0f);
        this.shape22 = new ModelRenderer((ModelBase)this, 16, 16);
        this.shape22.func_78793_a(0.0f, 10.0f, 0.0f);
        this.shape22.func_78790_a(2.0f, -10.0f, 2.0f, 4, 4, 4, 0.0f);
        this.shape10 = new ModelRenderer((ModelBase)this, 16, 16);
        this.shape10.func_78793_a(0.0f, 10.0f, 0.0f);
        this.shape10.func_78790_a(2.0f, -6.0f, 2.0f, 4, 4, 4, 0.0f);
        this.shape1 = new ModelRenderer((ModelBase)this, 0, 0);
        this.shape1.func_78793_a(0.0f, 10.0f, 0.0f);
        this.shape1.func_78790_a(-2.0f, -2.0f, -2.0f, 4, 4, 4, 0.0f);
        this.shape3 = new ModelRenderer((ModelBase)this, 16, 0);
        this.shape3.func_78793_a(0.0f, 10.0f, 0.0f);
        this.shape3.func_78790_a(-2.0f, -6.0f, -2.0f, 4, 4, 4, 0.0f);
        this.shape5 = new ModelRenderer((ModelBase)this, 16, 0);
        this.shape5.func_78793_a(0.0f, 10.0f, 0.0f);
        this.shape5.func_78790_a(-2.0f, -6.0f, -6.0f, 4, 4, 4, 0.0f);
        this.shape11 = new ModelRenderer((ModelBase)this, 16, 0);
        this.shape11.func_78793_a(0.0f, 10.0f, 0.0f);
        this.shape11.func_78790_a(-10.0f, -6.0f, -2.0f, 4, 4, 4, 0.0f);
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        GlStateManager.func_179147_l();
        GlStateManager.func_179112_b((int)770, (int)771);
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)(0.75f + 0.15f * Mth.func_76126_a((float)(f2 * 0.3f))));
        this.shape7.func_78785_a(f5);
        GlStateManager.func_179084_k();
        GlStateManager.func_179147_l();
        GlStateManager.func_179112_b((int)770, (int)771);
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)(0.75f + 0.15f * Mth.func_76126_a((float)((f2 + 10.0f) * 0.3f))));
        this.shape13.func_78785_a(f5);
        GlStateManager.func_179084_k();
        GlStateManager.func_179147_l();
        GlStateManager.func_179112_b((int)770, (int)771);
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)(0.75f + 0.15f * Mth.func_76126_a((float)(f2 * 0.3f))));
        this.shape16.func_78785_a(f5);
        GlStateManager.func_179084_k();
        GlStateManager.func_179147_l();
        GlStateManager.func_179112_b((int)770, (int)771);
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)(0.75f + 0.15f * Mth.func_76126_a((float)((f2 + 15.0f) * 0.3f))));
        this.shape17.func_78785_a(f5);
        GlStateManager.func_179084_k();
        GlStateManager.func_179147_l();
        GlStateManager.func_179112_b((int)770, (int)771);
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)(0.75f + 0.15f * Mth.func_76126_a((float)(f2 * 0.3f))));
        this.shape9.func_78785_a(f5);
        GlStateManager.func_179084_k();
        GlStateManager.func_179147_l();
        GlStateManager.func_179112_b((int)770, (int)771);
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)(0.75f + 0.15f * Mth.func_76126_a((float)(f2 * 0.3f))));
        this.shape15.func_78785_a(f5);
        GlStateManager.func_179084_k();
        GlStateManager.func_179147_l();
        GlStateManager.func_179112_b((int)770, (int)771);
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)(0.75f + 0.15f * Mth.func_76126_a((float)(f2 * 0.3f))));
        this.shape23.func_78785_a(f5);
        GlStateManager.func_179084_k();
        GlStateManager.func_179147_l();
        GlStateManager.func_179112_b((int)770, (int)771);
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)(0.75f + 0.15f * Mth.func_76126_a((float)(f2 * 0.3f))));
        this.shape18.func_78785_a(f5);
        GlStateManager.func_179084_k();
        GlStateManager.func_179147_l();
        GlStateManager.func_179112_b((int)770, (int)771);
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)(0.75f + 0.15f * Mth.func_76126_a((float)((f2 + 20.0f) * 0.3f))));
        this.shape4.func_78785_a(f5);
        GlStateManager.func_179084_k();
        GlStateManager.func_179147_l();
        GlStateManager.func_179112_b((int)770, (int)771);
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)(0.75f + 0.15f * Mth.func_76126_a((float)((f2 + 20.0f) * 0.3f))));
        this.shape6.func_78785_a(f5);
        GlStateManager.func_179084_k();
        GlStateManager.func_179147_l();
        GlStateManager.func_179112_b((int)770, (int)771);
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)(0.75f + 0.15f * Mth.func_76126_a((float)((f2 + 10.0f) * 0.3f))));
        this.shape12.func_78785_a(f5);
        GlStateManager.func_179084_k();
        GlStateManager.func_179147_l();
        GlStateManager.func_179112_b((int)770, (int)771);
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)(0.75f + 0.15f * Mth.func_76126_a((float)(f2 * 0.3f))));
        this.shape20.func_78785_a(f5);
        GlStateManager.func_179084_k();
        GlStateManager.func_179147_l();
        GlStateManager.func_179112_b((int)770, (int)771);
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)(0.75f + 0.15f * Mth.func_76126_a((float)((f2 + 15.0f) * 0.3f))));
        this.shape21.func_78785_a(f5);
        GlStateManager.func_179084_k();
        GlStateManager.func_179147_l();
        GlStateManager.func_179112_b((int)770, (int)771);
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)(0.75f + 0.15f * Mth.func_76126_a((float)((f2 + 5.0f) * 0.3f))));
        this.shape2.func_78785_a(f5);
        GlStateManager.func_179084_k();
        GlStateManager.func_179147_l();
        GlStateManager.func_179112_b((int)770, (int)771);
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)(0.75f + 0.15f * Mth.func_76126_a((float)((f2 + 10.0f) * 0.3f))));
        this.shape14.func_78785_a(f5);
        GlStateManager.func_179084_k();
        GlStateManager.func_179147_l();
        GlStateManager.func_179112_b((int)770, (int)771);
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)(0.75f + 0.15f * Mth.func_76126_a((float)((f2 + 40.0f) * 0.3f))));
        this.shape8.func_78785_a(f5);
        GlStateManager.func_179084_k();
        GlStateManager.func_179147_l();
        GlStateManager.func_179112_b((int)770, (int)771);
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)(0.75f + 0.15f * Mth.func_76126_a((float)((f2 + 35.0f) * 0.3f))));
        this.shape19.func_78785_a(f5);
        GlStateManager.func_179084_k();
        GlStateManager.func_179147_l();
        GlStateManager.func_179112_b((int)770, (int)771);
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)(0.75f + 0.15f * Mth.func_76126_a((float)((f2 + 45.0f) * 0.3f))));
        this.shape22.func_78785_a(f5);
        GlStateManager.func_179084_k();
        GlStateManager.func_179147_l();
        GlStateManager.func_179112_b((int)770, (int)771);
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)(0.75f + 0.15f * Mth.func_76126_a((float)((f2 + 30.0f) * 0.3f))));
        this.shape10.func_78785_a(f5);
        GlStateManager.func_179084_k();
        GlStateManager.func_179147_l();
        GlStateManager.func_179112_b((int)770, (int)771);
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)(0.75f + 0.15f * Mth.func_76126_a((float)((f2 + 5.0f) * 0.3f))));
        this.shape1.func_78785_a(f5);
        GlStateManager.func_179084_k();
        GlStateManager.func_179147_l();
        GlStateManager.func_179112_b((int)770, (int)771);
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)(0.75f + 0.15f * Mth.func_76126_a((float)((f2 + 15.0f) * 0.3f))));
        this.shape3.func_78785_a(f5);
        GlStateManager.func_179084_k();
        GlStateManager.func_179147_l();
        GlStateManager.func_179112_b((int)770, (int)771);
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)(0.75f + 0.15f * Mth.func_76126_a((float)((f2 + 10.0f) * 0.3f))));
        this.shape5.func_78785_a(f5);
        GlStateManager.func_179084_k();
        GlStateManager.func_179147_l();
        GlStateManager.func_179112_b((int)770, (int)771);
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)(0.75f + 0.15f * Mth.func_76126_a((float)((f2 + 20.0f) * 0.3f))));
        this.shape11.func_78785_a(f5);
        GlStateManager.func_179084_k();
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.shape1.field_78796_g = ageInTicks * 0.01f;
        this.shape2.field_78796_g = ageInTicks * 0.01f;
        this.shape3.field_78796_g = ageInTicks * 0.01f;
        this.shape4.field_78796_g = ageInTicks * 0.01f;
        this.shape5.field_78796_g = ageInTicks * 0.01f;
        this.shape6.field_78796_g = ageInTicks * 0.01f;
        this.shape7.field_78796_g = ageInTicks * 0.01f;
        this.shape8.field_78796_g = ageInTicks * 0.01f;
        this.shape9.field_78796_g = ageInTicks * 0.01f;
        this.shape10.field_78796_g = ageInTicks * 0.01f;
        this.shape11.field_78796_g = ageInTicks * 0.01f;
        this.shape12.field_78796_g = ageInTicks * 0.01f;
        this.shape13.field_78796_g = ageInTicks * 0.01f;
        this.shape14.field_78796_g = ageInTicks * 0.01f;
        this.shape15.field_78796_g = ageInTicks * 0.01f;
        this.shape16.field_78796_g = ageInTicks * 0.01f;
        this.shape17.field_78796_g = ageInTicks * 0.01f;
        this.shape18.field_78796_g = ageInTicks * 0.01f;
        this.shape19.field_78796_g = ageInTicks * 0.01f;
        this.shape20.field_78796_g = ageInTicks * 0.01f;
        this.shape21.field_78796_g = ageInTicks * 0.01f;
        this.shape22.field_78796_g = ageInTicks * 0.01f;
        this.shape23.field_78796_g = ageInTicks * 0.01f;
    }
}

