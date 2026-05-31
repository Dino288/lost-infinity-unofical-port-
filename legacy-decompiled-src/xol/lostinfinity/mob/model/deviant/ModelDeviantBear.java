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

public class ModelDeviantBear
extends ModelBase {
    public ModelRenderer back;
    public ModelRenderer front;
    public ModelRenderer legbl;
    public ModelRenderer legfl;
    public ModelRenderer legbr;
    public ModelRenderer legfr;
    public ModelRenderer head;
    public ModelRenderer nose;
    public ModelRenderer earr;
    public ModelRenderer earl;
    public ModelRenderer finbr;
    public ModelRenderer finb;
    public ModelRenderer finbl;

    public ModelDeviantBear() {
        this.field_78090_t = 128;
        this.field_78089_u = 64;
        this.back = new ModelRenderer((ModelBase)this, 0, 19);
        this.back.func_78793_a(-2.0f, 9.0f, 12.0f);
        this.back.func_78790_a(-5.0f, -13.0f, -7.0f, 14, 14, 11, 0.0f);
        this.setRotateAngle(this.back, 1.5707964f, 0.0f, 0.0f);
        this.legfr = new ModelRenderer((ModelBase)this, 50, 40);
        this.legfr.func_78793_a(-3.5f, 14.0f, -8.0f);
        this.legfr.func_78790_a(-2.0f, 0.0f, -2.0f, 4, 10, 6, 0.0f);
        this.finb = new ModelRenderer((ModelBase)this, 70, 23);
        this.finb.func_78793_a(-1.0f, 0.0f, -10.0f);
        this.finb.func_78790_a(0.0f, 0.0f, 0.0f, 2, 14, 27, 0.0f);
        this.earl = new ModelRenderer((ModelBase)this, 26, 0);
        this.earl.field_78809_i = true;
        this.earl.func_78793_a(0.0f, 10.0f, -16.0f);
        this.earl.func_78790_a(2.5f, -4.0f, -1.0f, 2, 2, 1, 0.0f);
        this.head = new ModelRenderer((ModelBase)this, 0, 0);
        this.head.func_78793_a(0.0f, 10.0f, -16.0f);
        this.head.func_78790_a(-3.5f, -3.0f, -3.0f, 7, 7, 7, 0.0f);
        this.earr = new ModelRenderer((ModelBase)this, 26, 0);
        this.earr.func_78793_a(0.0f, 10.0f, -16.0f);
        this.earr.func_78790_a(-4.5f, -4.0f, -1.0f, 2, 2, 1, 0.0f);
        this.legbl = new ModelRenderer((ModelBase)this, 50, 22);
        this.legbl.func_78793_a(4.5f, 14.0f, 6.0f);
        this.legbl.func_78790_a(-2.0f, 0.0f, -2.0f, 4, 10, 8, 0.0f);
        this.finbl = new ModelRenderer((ModelBase)this, 76, 1);
        this.finbl.func_78793_a(6.0f, 1.0f, -10.0f);
        this.finbl.func_78790_a(0.0f, 0.0f, 0.0f, 1, 6, 22, 0.0f);
        this.setRotateAngle(this.finbl, 0.0f, 0.0f, 0.2617994f);
        this.nose = new ModelRenderer((ModelBase)this, 0, 44);
        this.nose.func_78793_a(0.0f, 10.0f, -16.0f);
        this.nose.func_78790_a(-2.5f, 1.0f, -6.0f, 5, 3, 3, 0.0f);
        this.finbr = new ModelRenderer((ModelBase)this, 76, 1);
        this.finbr.func_78793_a(-6.0f, 1.0f, -10.0f);
        this.finbr.func_78790_a(0.0f, 0.0f, 0.0f, 1, 6, 22, 0.0f);
        this.setRotateAngle(this.finbr, 0.0f, 0.0f, -0.2617994f);
        this.legfl = new ModelRenderer((ModelBase)this, 50, 40);
        this.legfl.func_78793_a(3.5f, 14.0f, -8.0f);
        this.legfl.func_78790_a(-2.0f, 0.0f, -2.0f, 4, 10, 6, 0.0f);
        this.legbr = new ModelRenderer((ModelBase)this, 50, 22);
        this.legbr.func_78793_a(-4.5f, 14.0f, 6.0f);
        this.legbr.func_78790_a(-2.0f, 0.0f, -2.0f, 4, 10, 8, 0.0f);
        this.front = new ModelRenderer((ModelBase)this, 39, 0);
        this.front.func_78793_a(-2.0f, 9.0f, 12.0f);
        this.front.func_78790_a(-4.0f, -25.0f, -7.0f, 12, 12, 10, 0.0f);
        this.setRotateAngle(this.front, 1.5707964f, 0.0f, 0.0f);
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.back.func_78785_a(f5);
        this.legfr.func_78785_a(f5);
        this.finb.func_78785_a(f5);
        this.earl.func_78785_a(f5);
        this.head.func_78785_a(f5);
        this.earr.func_78785_a(f5);
        this.legbl.func_78785_a(f5);
        this.finbl.func_78785_a(f5);
        this.nose.func_78785_a(f5);
        this.finbr.func_78785_a(f5);
        this.legfl.func_78785_a(f5);
        this.legbr.func_78785_a(f5);
        this.front.func_78785_a(f5);
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.legfl.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.2662f)) * 1.4f * limbSwingAmount;
        this.legfr.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.2662f)) * 1.4f * limbSwingAmount;
        this.legbl.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.2662f + (float)Math.PI)) * 1.4f * limbSwingAmount;
        this.legbr.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.2662f + (float)Math.PI)) * 1.4f * limbSwingAmount;
        this.head.field_78795_f = headPitch * ((float)Math.PI / 180);
        this.head.field_78796_g = netHeadYaw * ((float)Math.PI / 180);
        this.earl.field_78795_f = headPitch * ((float)Math.PI / 180);
        this.earl.field_78796_g = netHeadYaw * ((float)Math.PI / 180);
        this.earr.field_78795_f = headPitch * ((float)Math.PI / 180);
        this.earr.field_78796_g = netHeadYaw * ((float)Math.PI / 180);
        this.nose.field_78795_f = headPitch * ((float)Math.PI / 180);
        this.nose.field_78796_g = netHeadYaw * ((float)Math.PI / 180);
    }
}

