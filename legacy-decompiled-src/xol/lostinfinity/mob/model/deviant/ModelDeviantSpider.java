/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.model.ModelRenderer
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.math.Mth
 */
package xol.lostinfinity.mob.model.deviant;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;

public class ModelDeviantSpider
extends ModelBase {
    public ModelRenderer body2;
    public ModelRenderer leg1;
    public ModelRenderer leg2;
    public ModelRenderer leg3;
    public ModelRenderer head;
    public ModelRenderer body1;
    public ModelRenderer leg4;
    public ModelRenderer leg5;
    public ModelRenderer leg6;
    public ModelRenderer leg7;
    public ModelRenderer leg8;
    public ModelRenderer fin2;
    public ModelRenderer fin1;
    public ModelRenderer fin3;
    public ModelRenderer fin4;
    public ModelRenderer horn1;
    public ModelRenderer horn2;
    public ModelRenderer pincer1;
    public ModelRenderer pincer2;
    public ModelRenderer pincer3;
    public ModelRenderer pincer4;

    public ModelDeviantSpider() {
        this.field_78090_t = 64;
        this.field_78089_u = 64;
        this.leg7 = new ModelRenderer((ModelBase)this, 18, 0);
        this.leg7.func_78793_a(4.0f, 15.0f, -1.0f);
        this.leg7.func_78790_a(-1.0f, -1.0f, -1.0f, 16, 2, 2, 0.0f);
        this.setRotateAngle(this.leg7, 0.0f, 0.7853982f, 0.7853982f);
        this.pincer3 = new ModelRenderer((ModelBase)this, 45, 48);
        this.pincer3.func_78793_a(0.0f, 15.0f, -3.0f);
        this.pincer3.func_78790_a(-3.0f, 1.5f, -11.0f, 2, 1, 1, 0.0f);
        this.pincer4 = new ModelRenderer((ModelBase)this, 45, 48);
        this.pincer4.field_78809_i = true;
        this.pincer4.func_78793_a(0.0f, 15.0f, -3.0f);
        this.pincer4.func_78790_a(1.0f, 1.5f, -11.0f, 2, 1, 1, 0.0f);
        this.body1 = new ModelRenderer((ModelBase)this, 0, 12);
        this.body1.func_78793_a(0.0f, 15.0f, 9.0f);
        this.body1.func_78790_a(-5.0f, -4.0f, -6.0f, 10, 8, 12, 0.0f);
        this.fin3 = new ModelRenderer((ModelBase)this, 0, 34);
        this.fin3.func_78793_a(0.0f, 14.0f, 5.0f);
        this.fin3.func_78790_a(-4.0f, -4.0f, 0.0f, 8, 1, 6, 0.0f);
        this.setRotateAngle(this.fin3, 0.7853982f, 0.0f, 0.0f);
        this.horn2 = new ModelRenderer((ModelBase)this, 39, 26);
        this.horn2.func_78793_a(0.0f, 15.0f, -3.0f);
        this.horn2.func_78790_a(-2.0f, -2.0f, -11.0f, 4, 4, 8, 0.0f);
        this.setRotateAngle(this.horn2, -0.7853982f, 0.0f, 0.0f);
        this.fin1 = new ModelRenderer((ModelBase)this, 0, 34);
        this.fin1.func_78793_a(0.0f, 14.0f, 13.0f);
        this.fin1.func_78790_a(-4.0f, -4.0f, 0.0f, 8, 1, 6, 0.0f);
        this.setRotateAngle(this.fin1, 0.7853982f, 0.0f, 0.0f);
        this.head = new ModelRenderer((ModelBase)this, 32, 4);
        this.head.func_78793_a(0.0f, 15.0f, -3.0f);
        this.head.func_78790_a(-4.0f, -4.0f, -8.0f, 8, 8, 8, 0.0f);
        this.fin2 = new ModelRenderer((ModelBase)this, 0, 34);
        this.fin2.func_78793_a(0.0f, 14.0f, 9.0f);
        this.fin2.func_78790_a(-4.0f, -4.0f, 0.0f, 8, 1, 6, 0.0f);
        this.setRotateAngle(this.fin2, 0.7853982f, 0.0f, 0.0f);
        this.leg1 = new ModelRenderer((ModelBase)this, 18, 0);
        this.leg1.func_78793_a(-4.0f, 15.0f, 2.0f);
        this.leg1.func_78790_a(-15.0f, -1.0f, -1.0f, 16, 2, 2, 0.0f);
        this.setRotateAngle(this.leg1, 0.0f, 0.7853982f, -0.7853982f);
        this.fin4 = new ModelRenderer((ModelBase)this, 0, 34);
        this.fin4.func_78793_a(0.0f, 15.0f, 1.0f);
        this.fin4.func_78790_a(-4.0f, -4.0f, 0.0f, 8, 1, 6, 0.0f);
        this.setRotateAngle(this.fin4, 0.7853982f, 0.0f, 0.0f);
        this.pincer1 = new ModelRenderer((ModelBase)this, 32, 48);
        this.pincer1.field_78809_i = true;
        this.pincer1.func_78793_a(0.0f, 15.0f, -3.0f);
        this.pincer1.func_78790_a(-5.0f, 1.0f, -11.0f, 2, 2, 5, 0.0f);
        this.pincer2 = new ModelRenderer((ModelBase)this, 32, 48);
        this.pincer2.func_78793_a(0.0f, 15.0f, -3.0f);
        this.pincer2.func_78790_a(3.0f, 1.0f, -11.0f, 2, 2, 5, 0.0f);
        this.leg2 = new ModelRenderer((ModelBase)this, 18, 0);
        this.leg2.func_78793_a(-4.0f, 15.0f, 0.0f);
        this.leg2.func_78790_a(-15.0f, -1.0f, -1.0f, 16, 2, 2, 0.0f);
        this.setRotateAngle(this.leg2, 0.0f, -0.3926991f, -0.58119464f);
        this.leg4 = new ModelRenderer((ModelBase)this, 18, 0);
        this.leg4.func_78793_a(4.0f, 15.0f, 2.0f);
        this.leg4.func_78790_a(-1.0f, -1.0f, -1.0f, 16, 2, 2, 0.0f);
        this.setRotateAngle(this.leg4, 0.0f, -0.7853982f, 0.7853982f);
        this.leg6 = new ModelRenderer((ModelBase)this, 18, 0);
        this.leg6.func_78793_a(4.0f, 15.0f, 0.0f);
        this.leg6.func_78790_a(-1.0f, -1.0f, -1.0f, 16, 2, 2, 0.0f);
        this.setRotateAngle(this.leg6, 0.0f, 0.3926991f, 0.58119464f);
        this.leg3 = new ModelRenderer((ModelBase)this, 18, 0);
        this.leg3.func_78793_a(-4.0f, 15.0f, -1.0f);
        this.leg3.func_78790_a(-15.0f, -1.0f, -1.0f, 16, 2, 2, 0.0f);
        this.setRotateAngle(this.leg3, 0.0f, -0.7853982f, -0.7853982f);
        this.leg8 = new ModelRenderer((ModelBase)this, 18, 0);
        this.leg8.func_78793_a(-4.0f, 15.0f, 1.0f);
        this.leg8.func_78790_a(-15.0f, -1.0f, -1.0f, 16, 2, 2, 0.0f);
        this.setRotateAngle(this.leg8, 0.0f, 0.3926991f, -0.58119464f);
        this.horn1 = new ModelRenderer((ModelBase)this, 39, 40);
        this.horn1.func_78793_a(0.0f, 15.0f, -3.0f);
        this.horn1.func_78790_a(-1.5f, -1.5f, -14.0f, 3, 3, 3, 0.0f);
        this.setRotateAngle(this.horn1, -0.7853982f, 0.0f, 0.0f);
        this.leg5 = new ModelRenderer((ModelBase)this, 18, 0);
        this.leg5.func_78793_a(4.0f, 15.0f, 1.0f);
        this.leg5.func_78790_a(-1.0f, -1.0f, -1.0f, 16, 2, 2, 0.0f);
        this.setRotateAngle(this.leg5, 0.0f, -0.3926991f, 0.58119464f);
        this.body2 = new ModelRenderer((ModelBase)this, 0, 0);
        this.body2.func_78793_a(0.0f, 15.0f, 0.0f);
        this.body2.func_78790_a(-3.0f, -3.0f, -3.0f, 6, 6, 6, 0.0f);
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.leg7.func_78785_a(f5);
        this.pincer3.func_78785_a(f5);
        this.pincer4.func_78785_a(f5);
        this.body1.func_78785_a(f5);
        this.fin3.func_78785_a(f5);
        this.horn2.func_78785_a(f5);
        this.fin1.func_78785_a(f5);
        this.head.func_78785_a(f5);
        this.fin2.func_78785_a(f5);
        this.leg1.func_78785_a(f5);
        this.fin4.func_78785_a(f5);
        this.pincer1.func_78785_a(f5);
        this.pincer2.func_78785_a(f5);
        this.leg2.func_78785_a(f5);
        this.leg4.func_78785_a(f5);
        this.leg6.func_78785_a(f5);
        this.leg3.func_78785_a(f5);
        this.leg8.func_78785_a(f5);
        this.horn1.func_78785_a(f5);
        this.leg5.func_78785_a(f5);
        this.body2.func_78785_a(f5);
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.head.field_78796_g = netHeadYaw * ((float)Math.PI / 180);
        this.head.field_78795_f = headPitch * ((float)Math.PI / 180);
        this.horn1.field_78796_g = netHeadYaw * ((float)Math.PI / 180);
        this.horn1.field_78795_f = headPitch * ((float)Math.PI / 180) - 0.7853982f;
        this.horn2.field_78796_g = netHeadYaw * ((float)Math.PI / 180);
        this.horn2.field_78795_f = headPitch * ((float)Math.PI / 180) - 0.7853982f;
        this.pincer1.field_78796_g = netHeadYaw * ((float)Math.PI / 180);
        this.pincer1.field_78795_f = headPitch * ((float)Math.PI / 180);
        this.pincer2.field_78796_g = netHeadYaw * ((float)Math.PI / 180);
        this.pincer2.field_78795_f = headPitch * ((float)Math.PI / 180);
        this.pincer3.field_78796_g = netHeadYaw * ((float)Math.PI / 180);
        this.pincer3.field_78795_f = headPitch * ((float)Math.PI / 180);
        this.pincer4.field_78796_g = netHeadYaw * ((float)Math.PI / 180);
        this.pincer4.field_78795_f = headPitch * ((float)Math.PI / 180);
        float f8 = Math.abs(Mth.func_76126_a((float)(limbSwing * 0.6662f + (float)Math.PI)) * 0.4f) * limbSwingAmount;
        this.leg6.field_78808_h = 0.58119464f + f8;
        this.leg7.field_78808_h = 0.58119464f + f8;
        this.leg4.field_78808_h = 0.58119464f + f8;
        this.leg5.field_78808_h = 0.58119464f + f8;
        this.leg1.field_78808_h = -this.leg4.field_78808_h;
        this.leg8.field_78808_h = -this.leg4.field_78808_h;
        this.leg2.field_78808_h = -this.leg4.field_78808_h;
        this.leg3.field_78808_h = -this.leg4.field_78808_h;
        this.leg6.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.1162f)) * 0.9f * limbSwingAmount;
        this.leg7.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.1162f)) * 0.9f * limbSwingAmount;
        this.leg2.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.1162f)) * 0.9f * limbSwingAmount;
        this.leg3.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.1162f)) * 0.9f * limbSwingAmount;
        this.leg1.field_78795_f = -this.leg6.field_78795_f;
        this.leg8.field_78795_f = -this.leg6.field_78795_f;
        this.leg4.field_78795_f = -this.leg6.field_78795_f;
        this.leg5.field_78795_f = -this.leg6.field_78795_f;
        this.fin1.field_78795_f = Mth.func_76134_b((float)(ageInTicks * 0.1f)) * (float)Math.PI * 0.1f + 0.48539817f;
        this.fin2.field_78795_f = Mth.func_76134_b((float)(ageInTicks * 0.1f)) * (float)Math.PI * 0.1f + 0.48539817f;
        this.fin3.field_78795_f = Mth.func_76134_b((float)(ageInTicks * 0.1f)) * (float)Math.PI * 0.1f + 0.48539817f;
        this.fin4.field_78795_f = Mth.func_76134_b((float)(ageInTicks * 0.1f)) * (float)Math.PI * 0.1f + 0.48539817f;
    }
}

