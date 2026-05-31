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
package xol.lostinfinity.mob.model.starforge;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;

public class ModelExplosect
extends ModelBase {
    public ModelRenderer body;
    public ModelRenderer wingL;
    public ModelRenderer wingR;
    public ModelRenderer head;
    public ModelRenderer wingL2;
    public ModelRenderer wingR2;
    public ModelRenderer body2;
    public ModelRenderer body3;

    public ModelExplosect() {
        this.field_78090_t = 64;
        this.field_78089_u = 32;
        this.body = new ModelRenderer((ModelBase)this, 0, 0);
        this.body.func_78793_a(0.0f, 14.5f, -3.0f);
        this.body.func_78790_a(-4.0f, 0.0f, 0.0f, 8, 4, 16, 0.0f);
        this.wingL = new ModelRenderer((ModelBase)this, 27, 23);
        this.wingL.func_78793_a(3.5f, 15.0f, 1.0f);
        this.wingL.func_78790_a(0.0f, 0.0f, -3.5f, 10, 1, 7, 0.0f);
        this.wingL2 = new ModelRenderer((ModelBase)this, 27, 23);
        this.wingL2.func_78793_a(3.5f, 15.5f, 9.0f);
        this.wingL2.func_78790_a(0.0f, 0.0f, -3.5f, 10, 1, 7, 0.0f);
        this.body3 = new ModelRenderer((ModelBase)this, 33, 0);
        this.body3.func_78793_a(0.0f, 14.0f, -1.5f);
        this.body3.func_78790_a(1.5f, -0.5f, 0.0f, 2, 1, 12, 0.0f);
        this.wingR = new ModelRenderer((ModelBase)this, 27, 23);
        this.wingR.field_78809_i = true;
        this.wingR.func_78793_a(-3.3f, 15.0f, 1.0f);
        this.wingR.func_78790_a(-10.0f, 0.0f, -3.5f, 10, 1, 7, 0.0f);
        this.head = new ModelRenderer((ModelBase)this, 0, 20);
        this.head.func_78793_a(0.0f, 17.0f, -3.5f);
        this.head.func_78790_a(-3.0f, -3.0f, -5.0f, 6, 6, 6, 0.0f);
        this.body2 = new ModelRenderer((ModelBase)this, 33, 0);
        this.body2.func_78793_a(0.0f, 14.0f, -1.5f);
        this.body2.func_78790_a(-3.5f, -0.5f, 0.0f, 2, 1, 12, 0.0f);
        this.wingR2 = new ModelRenderer((ModelBase)this, 27, 23);
        this.wingR2.field_78809_i = true;
        this.wingR2.func_78793_a(-3.3f, 15.5f, 9.0f);
        this.wingR2.func_78790_a(-10.0f, 0.0f, -3.5f, 10, 1, 7, 0.0f);
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.body.func_78785_a(f5);
        GlStateManager.func_179147_l();
        GlStateManager.func_179112_b((int)770, (int)771);
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)0.6f);
        this.wingL.func_78785_a(f5);
        GlStateManager.func_179084_k();
        GlStateManager.func_179147_l();
        GlStateManager.func_179112_b((int)770, (int)771);
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)0.6f);
        this.wingL2.func_78785_a(f5);
        GlStateManager.func_179084_k();
        this.body3.func_78785_a(f5);
        GlStateManager.func_179147_l();
        GlStateManager.func_179112_b((int)770, (int)771);
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)0.6f);
        this.wingR.func_78785_a(f5);
        GlStateManager.func_179084_k();
        GlStateManager.func_179147_l();
        GlStateManager.func_179112_b((int)770, (int)771);
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)0.8f);
        this.head.func_78785_a(f5);
        GlStateManager.func_179084_k();
        this.body2.func_78785_a(f5);
        GlStateManager.func_179147_l();
        GlStateManager.func_179112_b((int)770, (int)771);
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)0.6f);
        this.wingR2.func_78785_a(f5);
        GlStateManager.func_179084_k();
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.head.field_78795_f = headPitch * ((float)Math.PI / 180);
        this.head.field_78796_g = netHeadYaw * ((float)Math.PI / 180);
        this.wingL.field_78808_h = Mth.func_76134_b((float)(ageInTicks * 2.5f)) * (float)Math.PI * 0.15f;
        this.wingR.field_78808_h = -this.wingL.field_78808_h;
        this.wingL2.field_78808_h = Mth.func_76134_b((float)(ageInTicks * 2.5f)) * (float)Math.PI * 0.15f;
        this.wingR2.field_78808_h = -this.wingL.field_78808_h;
    }
}

