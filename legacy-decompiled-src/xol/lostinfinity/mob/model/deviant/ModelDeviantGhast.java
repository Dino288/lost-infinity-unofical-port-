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

public class ModelDeviantGhast
extends ModelBase {
    public ModelRenderer leg1;
    public ModelRenderer leg2;
    public ModelRenderer leg3;
    public ModelRenderer leg4;
    public ModelRenderer leg5;
    public ModelRenderer leg7;
    public ModelRenderer leg8;
    public ModelRenderer leg9;
    public ModelRenderer leg10;
    public ModelRenderer finl;
    public ModelRenderer finr;
    public ModelRenderer body;
    public ModelRenderer t1;
    public ModelRenderer t2;
    public ModelRenderer t3;
    public ModelRenderer t4;
    public ModelRenderer t5;
    public ModelRenderer t6;
    public ModelRenderer t7;
    public ModelRenderer t8;

    public ModelDeviantGhast() {
        this.field_78090_t = 64;
        this.field_78089_u = 64;
        this.t2 = new ModelRenderer((ModelBase)this, 45, 35);
        this.t2.field_78809_i = true;
        this.t2.func_78793_a(0.0f, 8.0f, 0.0f);
        this.t2.func_78790_a(-7.0f, -13.0f, -3.0f, 2, 5, 2, 0.0f);
        this.t3 = new ModelRenderer((ModelBase)this, 54, 35);
        this.t3.func_78793_a(0.0f, 8.0f, 0.0f);
        this.t3.func_78790_a(-7.0f, -12.0f, 1.0f, 2, 4, 2, 0.0f);
        this.leg4 = new ModelRenderer((ModelBase)this, 0, 0);
        this.leg4.func_78793_a(6.25f, 15.0f, -5.0f);
        this.leg4.func_78790_a(-1.0f, 0.0f, -1.0f, 2, 9, 2, 0.0f);
        this.setRotateAngle(this.leg4, 0.5818928f, 0.0f, 0.0f);
        this.t7 = new ModelRenderer((ModelBase)this, 54, 35);
        this.t7.field_78809_i = true;
        this.t7.func_78793_a(0.0f, 8.0f, 0.0f);
        this.t7.func_78790_a(5.0f, -12.0f, 1.0f, 2, 4, 2, 0.0f);
        this.leg1 = new ModelRenderer((ModelBase)this, 0, 0);
        this.leg1.func_78793_a(1.25f, 15.0f, -5.0f);
        this.leg1.func_78790_a(-1.0f, 0.0f, -1.0f, 2, 13, 2, 0.0f);
        this.setRotateAngle(this.leg1, 0.5682792f, 0.0f, 0.0f);
        this.leg5 = new ModelRenderer((ModelBase)this, 0, 0);
        this.leg5.func_78793_a(3.75f, 15.0f, 0.0f);
        this.leg5.func_78790_a(-1.0f, 0.0f, -1.0f, 2, 10, 2, 0.0f);
        this.setRotateAngle(this.leg5, 0.20821778f, 0.0f, 0.0f);
        this.leg2 = new ModelRenderer((ModelBase)this, 0, 0);
        this.leg2.func_78793_a(-3.75f, 15.0f, -5.0f);
        this.leg2.func_78790_a(-1.0f, 0.0f, -1.0f, 2, 8, 2, 0.0f);
        this.setRotateAngle(this.leg2, 0.40002945f, 0.0f, 0.0f);
        this.finl = new ModelRenderer((ModelBase)this, 0, 34);
        this.finl.field_78809_i = true;
        this.finl.func_78793_a(7.0f, 8.0f, 0.0f);
        this.finl.func_78790_a(0.0f, 0.0f, -7.0f, 14, 1, 16, 0.0f);
        this.t8 = new ModelRenderer((ModelBase)this, 54, 35);
        this.t8.func_78793_a(0.0f, 8.0f, 0.0f);
        this.t8.func_78790_a(5.0f, -11.0f, 5.0f, 2, 3, 2, 0.0f);
        this.leg8 = new ModelRenderer((ModelBase)this, 0, 0);
        this.leg8.func_78793_a(1.25f, 15.0f, 5.0f);
        this.leg8.func_78790_a(-1.0f, 0.0f, -1.0f, 2, 9, 2, 0.0f);
        this.setRotateAngle(this.leg8, 0.5314528f, 0.0f, 0.0f);
        this.leg7 = new ModelRenderer((ModelBase)this, 0, 0);
        this.leg7.func_78793_a(-1.25f, 15.0f, 0.0f);
        this.leg7.func_78790_a(-1.0f, 0.0f, -1.0f, 2, 11, 2, 0.0f);
        this.setRotateAngle(this.leg7, 0.24870943f, 0.0f, 0.0f);
        this.finr = new ModelRenderer((ModelBase)this, 0, 34);
        this.finr.func_78793_a(-7.0f, 8.0f, 0.0f);
        this.finr.func_78790_a(-14.0f, 0.0f, -7.0f, 14, 1, 16, 0.0f);
        this.t1 = new ModelRenderer((ModelBase)this, 45, 35);
        this.t1.func_78793_a(0.0f, 8.0f, 0.0f);
        this.t1.func_78790_a(-7.0f, -14.0f, -7.0f, 2, 6, 2, 0.0f);
        this.leg9 = new ModelRenderer((ModelBase)this, 0, 0);
        this.leg9.func_78793_a(-3.75f, 15.0f, 5.0f);
        this.leg9.func_78790_a(-1.0f, 0.0f, -1.0f, 2, 12, 2, 0.0f);
        this.setRotateAngle(this.leg9, 0.34417892f, 0.0f, 0.0f);
        this.leg10 = new ModelRenderer((ModelBase)this, 0, 0);
        this.leg10.func_78793_a(6.25f, 15.0f, 5.0f);
        this.leg10.func_78790_a(-1.0f, 0.0f, -1.0f, 2, 12, 2, 0.0f);
        this.setRotateAngle(this.leg10, 0.5979498f, 0.0f, 0.0f);
        this.t4 = new ModelRenderer((ModelBase)this, 54, 35);
        this.t4.field_78809_i = true;
        this.t4.func_78793_a(0.0f, 8.0f, 0.0f);
        this.t4.func_78790_a(-7.0f, -11.0f, 5.0f, 2, 3, 2, 0.0f);
        this.t6 = new ModelRenderer((ModelBase)this, 45, 35);
        this.t6.func_78793_a(0.0f, 8.0f, 0.0f);
        this.t6.func_78790_a(5.0f, -13.0f, -3.0f, 2, 5, 2, 0.0f);
        this.leg3 = new ModelRenderer((ModelBase)this, 0, 0);
        this.leg3.func_78793_a(-6.25f, 15.0f, 0.0f);
        this.leg3.func_78790_a(-1.0f, 0.0f, -1.0f, 2, 11, 2, 0.0f);
        this.setRotateAngle(this.leg3, 0.4283038f, 0.0f, 0.0f);
        this.body = new ModelRenderer((ModelBase)this, 0, 0);
        this.body.func_78793_a(0.0f, 8.0f, 0.0f);
        this.body.func_78790_a(-8.0f, -8.0f, -8.0f, 16, 16, 16, 0.0f);
        this.t5 = new ModelRenderer((ModelBase)this, 45, 35);
        this.t5.field_78809_i = true;
        this.t5.func_78793_a(0.0f, 8.0f, 0.0f);
        this.t5.func_78790_a(5.0f, -14.0f, -7.0f, 2, 6, 2, 0.0f);
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.leg2.func_78785_a(f5);
        this.leg3.func_78785_a(f5);
        this.finl.func_78785_a(f5);
        this.finr.func_78785_a(f5);
        this.leg8.func_78785_a(f5);
        this.leg7.func_78785_a(f5);
        this.body.func_78785_a(f5);
        this.t2.func_78785_a(f5);
        this.leg5.func_78785_a(f5);
        this.leg10.func_78785_a(f5);
        this.t4.func_78785_a(f5);
        this.t8.func_78785_a(f5);
        this.leg9.func_78785_a(f5);
        this.leg4.func_78785_a(f5);
        this.t5.func_78785_a(f5);
        this.t6.func_78785_a(f5);
        this.t7.func_78785_a(f5);
        this.t3.func_78785_a(f5);
        this.leg1.func_78785_a(f5);
        this.t1.func_78785_a(f5);
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.leg1.field_78795_f = 0.2f * Mth.func_76126_a((float)(ageInTicks * 0.3f + 1.0f)) + 0.4f;
        this.leg1.field_78795_f = 0.2f * Mth.func_76126_a((float)(ageInTicks * 0.3f + 2.0f)) + 0.4f;
        this.leg1.field_78795_f = 0.2f * Mth.func_76126_a((float)(ageInTicks * 0.3f + 3.0f)) + 0.4f;
        this.leg1.field_78795_f = 0.2f * Mth.func_76126_a((float)(ageInTicks * 0.3f + 4.0f)) + 0.4f;
        this.leg1.field_78795_f = 0.2f * Mth.func_76126_a((float)(ageInTicks * 0.3f + 5.0f)) + 0.4f;
        this.leg1.field_78795_f = 0.2f * Mth.func_76126_a((float)(ageInTicks * 0.3f + 6.0f)) + 0.4f;
        this.leg1.field_78795_f = 0.2f * Mth.func_76126_a((float)(ageInTicks * 0.3f + 7.0f)) + 0.4f;
        this.leg1.field_78795_f = 0.2f * Mth.func_76126_a((float)(ageInTicks * 0.3f + 8.0f)) + 0.4f;
        this.leg1.field_78795_f = 0.2f * Mth.func_76126_a((float)(ageInTicks * 0.3f + 9.0f)) + 0.4f;
        this.leg1.field_78795_f = 0.2f * Mth.func_76126_a((float)(ageInTicks * 0.3f + 10.0f)) + 0.4f;
        this.finl.field_78808_h = Mth.func_76134_b((float)(ageInTicks * 0.1f)) * (float)Math.PI * 0.15f;
        this.finr.field_78808_h = -this.finl.field_78808_h;
    }
}

