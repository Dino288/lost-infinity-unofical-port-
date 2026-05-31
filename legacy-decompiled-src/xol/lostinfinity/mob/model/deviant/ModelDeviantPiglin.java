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

public class ModelDeviantPiglin
extends ModelBase {
    public ModelRenderer armr;
    public ModelRenderer legr;
    public ModelRenderer head;
    public ModelRenderer body;
    public ModelRenderer arml;
    public ModelRenderer legl;
    public ModelRenderer back2;
    public ModelRenderer back1;
    public ModelRenderer back3;
    public ModelRenderer armr2;
    public ModelRenderer legr2;
    public ModelRenderer earr;
    public ModelRenderer earl;
    public ModelRenderer nose;
    public ModelRenderer horn1;
    public ModelRenderer horn2;
    public ModelRenderer arml2;
    public ModelRenderer legl2;

    public ModelDeviantPiglin() {
        this.field_78090_t = 64;
        this.field_78089_u = 64;
        this.nose = new ModelRenderer((ModelBase)this, 31, 1);
        this.nose.field_78809_i = true;
        this.nose.func_78793_a(-2.0f, -5.0f, -5.0f);
        this.nose.func_78790_a(0.0f, 0.0f, 0.0f, 4, 4, 1, 0.0f);
        this.legl = new ModelRenderer((ModelBase)this, 0, 16);
        this.legl.field_78809_i = true;
        this.legl.func_78793_a(1.9f, 12.0f, 0.1f);
        this.legl.func_78790_a(-2.0f, 0.0f, -2.0f, 4, 12, 4, 0.0f);
        this.back3 = new ModelRenderer((ModelBase)this, 0, 33);
        this.back3.func_78793_a(-2.5f, 6.5f, 0.0f);
        this.back3.func_78790_a(-1.0f, 0.0f, -3.0f, 2, 12, 6, 0.0f);
        this.setRotateAngle(this.back3, 0.87266463f, 0.0f, 0.0f);
        this.horn2 = new ModelRenderer((ModelBase)this, 2, 0);
        this.horn2.field_78809_i = true;
        this.horn2.func_78793_a(3.0f, -5.0f, -5.0f);
        this.horn2.func_78790_a(-1.0f, 2.0f, 0.0f, 1, 2, 1, 0.0f);
        this.legr = new ModelRenderer((ModelBase)this, 0, 16);
        this.legr.func_78793_a(-1.9f, 12.0f, 0.1f);
        this.legr.func_78790_a(-2.0f, 0.0f, -2.0f, 4, 12, 4, 0.0f);
        this.arml2 = new ModelRenderer((ModelBase)this, 50, 34);
        this.arml2.field_78809_i = true;
        this.arml2.func_78793_a(3.0f, -2.0f, -2.0f);
        this.arml2.func_78790_a(0.0f, 0.0f, 0.0f, 1, 12, 4, 0.0f);
        this.armr2 = new ModelRenderer((ModelBase)this, 50, 34);
        this.armr2.func_78793_a(-4.0f, -2.0f, -2.0f);
        this.armr2.func_78790_a(0.0f, 0.0f, 0.0f, 1, 12, 4, 0.0f);
        this.earr = new ModelRenderer((ModelBase)this, 39, 6);
        this.earr.func_78793_a(-5.0f, -7.0f, -2.0f);
        this.earr.func_78790_a(-1.0f, 0.0f, 0.0f, 1, 5, 4, 0.0f);
        this.arml = new ModelRenderer((ModelBase)this, 40, 16);
        this.arml.field_78809_i = true;
        this.arml.func_78793_a(5.0f, 2.0f, 0.0f);
        this.arml.func_78790_a(-1.0f, -2.0f, -2.0f, 4, 12, 4, 0.0f);
        this.legr2 = new ModelRenderer((ModelBase)this, 24, 35);
        this.legr2.func_78793_a(-3.0f, 0.0f, -2.0f);
        this.legr2.func_78790_a(0.0f, 0.0f, 0.0f, 1, 12, 4, 0.0f);
        this.horn1 = new ModelRenderer((ModelBase)this, 2, 0);
        this.horn1.field_78809_i = true;
        this.horn1.func_78793_a(-2.0f, -5.0f, -5.0f);
        this.horn1.func_78790_a(-1.0f, 2.0f, 0.0f, 1, 2, 1, 0.0f);
        this.earl = new ModelRenderer((ModelBase)this, 39, 6);
        this.earl.field_78809_i = true;
        this.earl.func_78793_a(5.0f, -7.0f, -2.0f);
        this.earl.func_78790_a(0.0f, 0.0f, 0.0f, 1, 5, 4, 0.0f);
        this.body = new ModelRenderer((ModelBase)this, 16, 16);
        this.body.func_78793_a(0.0f, 0.0f, 0.0f);
        this.body.func_78790_a(-4.0f, 0.0f, -2.0f, 8, 12, 4, 0.0f);
        this.back1 = new ModelRenderer((ModelBase)this, 0, 33);
        this.back1.func_78793_a(0.0f, 4.5f, 0.0f);
        this.back1.func_78790_a(-1.0f, 0.0f, -3.0f, 2, 12, 6, 0.0f);
        this.setRotateAngle(this.back1, 2.268928f, 0.0f, 0.0f);
        this.back2 = new ModelRenderer((ModelBase)this, 0, 33);
        this.back2.func_78793_a(2.5f, 6.5f, 0.0f);
        this.back2.func_78790_a(-1.0f, 0.0f, -3.0f, 2, 12, 6, 0.0f);
        this.setRotateAngle(this.back2, 0.87266463f, 0.0f, 0.0f);
        this.legl2 = new ModelRenderer((ModelBase)this, 24, 35);
        this.legl2.field_78809_i = true;
        this.legl2.func_78793_a(2.0f, 0.0f, -2.0f);
        this.legl2.func_78790_a(0.0f, 0.0f, 0.0f, 1, 12, 4, 0.0f);
        this.armr = new ModelRenderer((ModelBase)this, 40, 16);
        this.armr.func_78793_a(-5.0f, 2.0f, 0.0f);
        this.armr.func_78790_a(-3.0f, -2.0f, -2.0f, 4, 12, 4, 0.0f);
        this.head = new ModelRenderer((ModelBase)this, 0, 0);
        this.head.func_78793_a(0.0f, 0.0f, 0.0f);
        this.head.func_78790_a(-5.0f, -8.0f, -4.0f, 10, 8, 8, 0.0f);
        this.head.func_78792_a(this.nose);
        this.head.func_78792_a(this.horn2);
        this.arml.func_78792_a(this.arml2);
        this.armr.func_78792_a(this.armr2);
        this.head.func_78792_a(this.earr);
        this.legr.func_78792_a(this.legr2);
        this.head.func_78792_a(this.horn1);
        this.head.func_78792_a(this.earl);
        this.legl.func_78792_a(this.legl2);
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.legl.func_78785_a(f5);
        this.back3.func_78785_a(f5);
        this.legr.func_78785_a(f5);
        this.arml.func_78785_a(f5);
        this.body.func_78785_a(f5);
        this.back1.func_78785_a(f5);
        this.back2.func_78785_a(f5);
        this.armr.func_78785_a(f5);
        this.head.func_78785_a(f5);
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.head.field_78796_g = netHeadYaw * ((float)Math.PI / 180);
        this.head.field_78795_f = headPitch * ((float)Math.PI / 180);
        this.legr.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f)) * 1.4f * limbSwingAmount * 0.5f;
        this.legl.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f + (float)Math.PI)) * 1.4f * limbSwingAmount * 0.5f;
        this.armr.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f + (float)Math.PI)) * 2.0f * limbSwingAmount * 0.5f;
        this.arml.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f)) * 2.0f * limbSwingAmount * 0.5f;
        this.earl.field_78808_h = 0.2f * (float)((double)Mth.func_76134_b((float)(ageInTicks * 0.1f)) - 1.0471975511965976);
        this.arml2.field_78808_h = 0.2f * (float)((double)Mth.func_76134_b((float)((ageInTicks + 30.0f) * 0.1f)) - 1.0471975511965976);
        this.legl2.field_78808_h = 0.2f * (float)((double)Mth.func_76134_b((float)((ageInTicks + 60.0f) * 0.1f)) - 1.0471975511965976);
        this.earr.field_78808_h = -this.earl.field_78808_h;
        this.armr2.field_78808_h = -this.arml2.field_78808_h;
        this.legr2.field_78808_h = -this.legl2.field_78808_h;
        this.back1.field_78795_f = (float)((double)(0.5f * Mth.func_76134_b((float)(ageInTicks * 0.1f))) + 1.5707963267948966);
        this.back2.field_78795_f = (float)((double)(0.5f * -Mth.func_76134_b((float)(ageInTicks * 0.1f))) + 1.5707963267948966);
        this.back3.field_78795_f = (float)((double)(0.5f * -Mth.func_76134_b((float)(ageInTicks * 0.1f))) + 1.5707963267948966);
    }
}

