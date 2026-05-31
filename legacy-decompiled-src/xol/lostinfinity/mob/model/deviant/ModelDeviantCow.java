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

public class ModelDeviantCow
extends ModelBase {
    public ModelRenderer lbl;
    public ModelRenderer lfl;
    public ModelRenderer lbr;
    public ModelRenderer lfr;
    public ModelRenderer head;
    public ModelRenderer h1;
    public ModelRenderer h2;
    public ModelRenderer lblt;
    public ModelRenderer lflt;
    public ModelRenderer lbrt;
    public ModelRenderer lfrt;
    public ModelRenderer lblf;
    public ModelRenderer lflf;
    public ModelRenderer lbrf;
    public ModelRenderer lfrf;
    public ModelRenderer spine1;
    public ModelRenderer spine2;
    public ModelRenderer body;
    public ModelRenderer spinec3;
    public ModelRenderer spinec1;
    public ModelRenderer spinec2;
    public ModelRenderer spinec4;

    public ModelDeviantCow() {
        this.field_78090_t = 128;
        this.field_78089_u = 64;
        this.lflt = new ModelRenderer((ModelBase)this, 0, 39);
        this.lflt.field_78809_i = true;
        this.lflt.func_78793_a(12.0f, 4.0f, -6.0f);
        this.lflt.func_78790_a(-8.0f, -2.0f, -3.0f, 6, 12, 6, 0.0f);
        this.setRotateAngle(this.lflt, 0.0f, 0.0f, -0.5235988f);
        this.spinec2 = new ModelRenderer((ModelBase)this, 45, 43);
        this.spinec2.func_78793_a(0.0f, 8.0f, 2.0f);
        this.spinec2.func_78790_a(4.0f, -15.0f, -2.5f, 2, 10, 2, 0.0f);
        this.setRotateAngle(this.spinec2, 0.7853982f, 0.0f, 0.0f);
        this.lfl = new ModelRenderer((ModelBase)this, 0, 16);
        this.lfl.func_78793_a(12.0f, 4.0f, -6.0f);
        this.lfl.func_78790_a(-2.0f, 8.0f, -2.0f, 4, 12, 4, 0.0f);
        this.lbr = new ModelRenderer((ModelBase)this, 0, 16);
        this.lbr.field_78809_i = true;
        this.lbr.func_78793_a(-12.0f, 4.0f, 11.0f);
        this.lbr.func_78790_a(-2.0f, 8.0f, -2.0f, 4, 12, 4, 0.0f);
        this.h1 = new ModelRenderer((ModelBase)this, 22, 0);
        this.h1.func_78793_a(0.0f, 6.0f, -8.0f);
        this.h1.func_78790_a(-5.0f, -5.0f, -4.0f, 1, 3, 1, 0.0f);
        this.lblf = new ModelRenderer((ModelBase)this, 85, 39);
        this.lblf.func_78793_a(12.0f, 4.0f, 11.0f);
        this.lblf.func_78790_a(-2.0f, -3.0f, 0.0f, 10, 12, 1, 0.0f);
        this.spinec4 = new ModelRenderer((ModelBase)this, 45, 43);
        this.spinec4.func_78793_a(0.0f, 8.0f, 2.0f);
        this.spinec4.func_78790_a(-6.0f, -17.0f, 3.5f, 2, 10, 2, 0.0f);
        this.setRotateAngle(this.spinec4, -0.7853982f, 0.0f, 0.0f);
        this.spinec1 = new ModelRenderer((ModelBase)this, 45, 43);
        this.spinec1.func_78793_a(0.0f, 8.0f, 2.0f);
        this.spinec1.func_78790_a(-6.0f, -15.0f, -2.5f, 2, 10, 2, 0.0f);
        this.setRotateAngle(this.spinec1, 0.7853982f, 0.0f, 0.0f);
        this.head = new ModelRenderer((ModelBase)this, 0, 0);
        this.head.func_78793_a(0.0f, 6.0f, -8.0f);
        this.head.func_78790_a(-4.0f, -4.0f, -6.0f, 8, 8, 6, 0.0f);
        this.spine1 = new ModelRenderer((ModelBase)this, 86, 4);
        this.spine1.func_78793_a(0.0f, 8.0f, 2.0f);
        this.spine1.func_78790_a(-5.0f, -10.0f, 6.0f, 1, 24, 8, 0.0f);
        this.setRotateAngle(this.spine1, 1.5707964f, 0.0f, 0.0f);
        this.lbl = new ModelRenderer((ModelBase)this, 0, 16);
        this.lbl.func_78793_a(12.0f, 4.0f, 11.0f);
        this.lbl.func_78790_a(-2.0f, 8.0f, -2.0f, 4, 12, 4, 0.0f);
        this.lbrt = new ModelRenderer((ModelBase)this, 0, 39);
        this.lbrt.func_78793_a(-12.0f, 4.0f, 11.0f);
        this.lbrt.func_78790_a(2.0f, -2.0f, -3.0f, 6, 12, 6, 0.0f);
        this.setRotateAngle(this.lbrt, 0.0f, 0.0f, 0.5235988f);
        this.spine2 = new ModelRenderer((ModelBase)this, 86, 4);
        this.spine2.field_78809_i = true;
        this.spine2.func_78793_a(0.0f, 8.0f, 2.0f);
        this.spine2.func_78790_a(4.0f, -10.0f, 6.0f, 1, 24, 8, 0.0f);
        this.setRotateAngle(this.spine2, 1.5707964f, 0.0f, 0.0f);
        this.lfrt = new ModelRenderer((ModelBase)this, 0, 39);
        this.lfrt.func_78793_a(-12.0f, 4.0f, -6.0f);
        this.lfrt.func_78790_a(2.0f, -2.0f, -3.0f, 6, 12, 6, 0.0f);
        this.setRotateAngle(this.lfrt, -0.0f, 0.0f, 0.5235988f);
        this.lblt = new ModelRenderer((ModelBase)this, 0, 39);
        this.lblt.field_78809_i = true;
        this.lblt.func_78793_a(12.0f, 4.0f, 11.0f);
        this.lblt.func_78790_a(-8.0f, -2.0f, -3.0f, 6, 12, 6, 0.0f);
        this.setRotateAngle(this.lblt, -0.0f, 0.0f, -0.5235988f);
        this.lbrf = new ModelRenderer((ModelBase)this, 85, 39);
        this.lbrf.field_78809_i = true;
        this.lbrf.func_78793_a(-12.0f, 4.0f, 11.0f);
        this.lbrf.func_78790_a(-8.0f, -3.0f, 0.0f, 10, 12, 1, 0.0f);
        this.spinec3 = new ModelRenderer((ModelBase)this, 45, 43);
        this.spinec3.func_78793_a(0.0f, 8.0f, 2.0f);
        this.spinec3.func_78790_a(4.0f, -17.0f, 3.5f, 2, 10, 2, 0.0f);
        this.setRotateAngle(this.spinec3, -0.7853982f, 0.0f, 0.0f);
        this.h2 = new ModelRenderer((ModelBase)this, 22, 0);
        this.h2.func_78793_a(0.0f, 6.0f, -8.0f);
        this.h2.func_78790_a(4.0f, -5.0f, -4.0f, 1, 3, 1, 0.0f);
        this.body = new ModelRenderer((ModelBase)this, 20, 4);
        this.body.func_78793_a(0.0f, 8.0f, 2.0f);
        this.body.func_78790_a(-9.0f, -10.0f, -8.0f, 18, 24, 14, 0.0f);
        this.setRotateAngle(this.body, 1.5707964f, 0.0f, 0.0f);
        this.lflf = new ModelRenderer((ModelBase)this, 85, 39);
        this.lflf.func_78793_a(12.0f, 4.0f, -6.0f);
        this.lflf.func_78790_a(-2.0f, -3.0f, 0.0f, 10, 12, 1, 0.0f);
        this.lfr = new ModelRenderer((ModelBase)this, 0, 16);
        this.lfr.field_78809_i = true;
        this.lfr.func_78793_a(-12.0f, 4.0f, -6.0f);
        this.lfr.func_78790_a(-2.0f, 8.0f, -2.0f, 4, 12, 4, 0.0f);
        this.lfrf = new ModelRenderer((ModelBase)this, 85, 39);
        this.lfrf.field_78809_i = true;
        this.lfrf.func_78793_a(-12.0f, 4.0f, -6.0f);
        this.lfrf.func_78790_a(-8.0f, -3.0f, 0.0f, 10, 12, 1, 0.0f);
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.lblf.func_78785_a(f5);
        this.h1.func_78785_a(f5);
        this.lflf.func_78785_a(f5);
        this.spinec4.func_78785_a(f5);
        this.lbrf.func_78785_a(f5);
        this.h2.func_78785_a(f5);
        this.lfr.func_78785_a(f5);
        this.head.func_78785_a(f5);
        this.lfrt.func_78785_a(f5);
        this.lbrt.func_78785_a(f5);
        this.spinec2.func_78785_a(f5);
        this.lbr.func_78785_a(f5);
        this.spine2.func_78785_a(f5);
        this.lblt.func_78785_a(f5);
        this.spinec3.func_78785_a(f5);
        this.spinec1.func_78785_a(f5);
        this.lfl.func_78785_a(f5);
        this.lflt.func_78785_a(f5);
        this.lfrf.func_78785_a(f5);
        this.spine1.func_78785_a(f5);
        this.body.func_78785_a(f5);
        this.lbl.func_78785_a(f5);
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.head.field_78795_f = headPitch * ((float)Math.PI / 180);
        this.head.field_78796_g = netHeadYaw * ((float)Math.PI / 180);
        this.h1.field_78795_f = headPitch * ((float)Math.PI / 180);
        this.h1.field_78796_g = netHeadYaw * ((float)Math.PI / 180);
        this.h2.field_78795_f = headPitch * ((float)Math.PI / 180);
        this.h2.field_78796_g = netHeadYaw * ((float)Math.PI / 180);
        this.lfl.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.1162f)) * 0.9f * limbSwingAmount;
        this.lflt.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.1162f)) * 0.9f * limbSwingAmount;
        this.lflf.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.1162f)) * 0.9f * limbSwingAmount;
        this.lfr.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.1162f)) * 0.9f * limbSwingAmount;
        this.lfrt.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.1162f)) * 0.9f * limbSwingAmount;
        this.lfrf.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.1162f)) * 0.9f * limbSwingAmount;
        this.lbl.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.1162f + (float)Math.PI)) * 0.9f * limbSwingAmount;
        this.lblt.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.1162f + (float)Math.PI)) * 0.9f * limbSwingAmount;
        this.lblf.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.1162f + (float)Math.PI)) * 0.9f * limbSwingAmount;
        this.lbr.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.1162f + (float)Math.PI)) * 0.9f * limbSwingAmount;
        this.lbrt.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.1162f + (float)Math.PI)) * 0.9f * limbSwingAmount;
        this.lbrf.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.1162f + (float)Math.PI)) * 0.9f * limbSwingAmount;
    }
}

