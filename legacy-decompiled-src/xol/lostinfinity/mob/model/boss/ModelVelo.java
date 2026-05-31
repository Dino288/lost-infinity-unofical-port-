/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.model.ModelRenderer
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.math.Mth
 */
package xol.lostinfinity.mob.model.boss;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;

public class ModelVelo
extends ModelBase {
    public ModelRenderer armr;
    public ModelRenderer legr;
    public ModelRenderer head;
    public ModelRenderer arml;
    public ModelRenderer legl;
    public ModelRenderer armr2;
    public ModelRenderer arml2;
    public ModelRenderer armr3;
    public ModelRenderer arml3;
    public ModelRenderer body;
    public ModelRenderer spike1;
    public ModelRenderer spike2;
    public ModelRenderer spike3;
    public ModelRenderer spike4;
    public ModelRenderer spike5;
    public ModelRenderer spike6;
    public ModelRenderer spike7;
    public ModelRenderer spike8;
    public ModelRenderer spike9;
    public ModelRenderer spike10;
    public ModelRenderer spike11;
    public ModelRenderer spike12;
    public ModelRenderer headcase;
    public ModelRenderer armlp;
    public ModelRenderer armrp;
    public ModelRenderer bobble1;
    public ModelRenderer bobble2;
    public ModelRenderer bobble3;
    public ModelRenderer headcase2;
    public ModelRenderer headcase3;

    public ModelVelo() {
        this.field_78090_t = 128;
        this.field_78089_u = 64;
        this.legr = new ModelRenderer((ModelBase)this, 0, 16);
        this.legr.func_78793_a(-2.4f, 11.0f, 2.4f);
        this.legr.func_78790_a(-2.0f, 0.0f, -2.0f, 4, 13, 4, 0.0f);
        this.spike10 = new ModelRenderer((ModelBase)this, 16, 33);
        this.spike10.func_78793_a(0.0f, 0.0f, 0.0f);
        this.spike10.func_78790_a(1.5f, 8.5f, 2.0f, 2, 2, 4, 0.0f);
        this.setRotateAngle(this.spike10, 0.2617994f, 0.0f, 0.0f);
        this.spike7 = new ModelRenderer((ModelBase)this, 16, 42);
        this.spike7.func_78793_a(0.0f, 0.0f, 0.0f);
        this.spike7.func_78790_a(-9.5f, 5.0f, 6.0f, 8, 2, 2, 0.0f);
        this.setRotateAngle(this.spike7, 0.2617994f, 0.0f, 0.0f);
        this.body = new ModelRenderer((ModelBase)this, 16, 16);
        this.body.func_78793_a(0.0f, 0.0f, 0.0f);
        this.body.func_78790_a(-4.0f, 0.0f, -2.0f, 8, 12, 4, 0.0f);
        this.setRotateAngle(this.body, 0.2617994f, 0.0f, 0.0f);
        this.arml3 = new ModelRenderer((ModelBase)this, 40, 43);
        this.arml3.field_78809_i = true;
        this.arml3.func_78793_a(7.0f, 2.0f, 0.0f);
        this.arml3.func_78790_a(-2.0f, 10.0f, -2.0f, 4, 3, 4, 0.0f);
        this.spike4 = new ModelRenderer((ModelBase)this, 16, 42);
        this.spike4.field_78809_i = true;
        this.spike4.func_78793_a(0.0f, 0.0f, 0.0f);
        this.spike4.func_78790_a(1.5f, 1.5f, 6.0f, 8, 2, 2, 0.0f);
        this.setRotateAngle(this.spike4, 0.2617994f, 0.0f, 0.0f);
        this.armrp = new ModelRenderer((ModelBase)this, 40, 51);
        this.armrp.func_78793_a(-7.0f, 2.0f, 0.0f);
        this.armrp.func_78790_a(-4.0f, -1.5f, -2.5f, 1, 5, 5, 0.0f);
        this.setRotateAngle(this.armrp, -1.134464f, 0.0f, 0.0f);
        this.bobble3 = new ModelRenderer((ModelBase)this, 62, 43);
        this.bobble3.func_78793_a(-7.0f, 6.0f, -10.5f);
        this.bobble3.func_78790_a(-2.0f, 11.0f, -2.0f, 4, 4, 4, 0.0f);
        this.spike6 = new ModelRenderer((ModelBase)this, 16, 33);
        this.spike6.func_78793_a(0.0f, 0.0f, 0.0f);
        this.spike6.func_78790_a(1.5f, 5.0f, 2.0f, 2, 2, 4, 0.0f);
        this.setRotateAngle(this.spike6, 0.2617994f, 0.0f, 0.0f);
        this.spike9 = new ModelRenderer((ModelBase)this, 16, 33);
        this.spike9.func_78793_a(0.0f, 0.0f, 0.0f);
        this.spike9.func_78790_a(-3.5f, 8.5f, 2.0f, 2, 2, 4, 0.0f);
        this.setRotateAngle(this.spike9, 0.2617994f, 0.0f, 0.0f);
        this.spike8 = new ModelRenderer((ModelBase)this, 16, 42);
        this.spike8.field_78809_i = true;
        this.spike8.func_78793_a(0.0f, 0.0f, 0.0f);
        this.spike8.func_78790_a(1.5f, 5.0f, 6.0f, 8, 2, 2, 0.0f);
        this.setRotateAngle(this.spike8, 0.2617994f, 0.0f, 0.0f);
        this.arml2 = new ModelRenderer((ModelBase)this, 40, 30);
        this.arml2.field_78809_i = true;
        this.arml2.func_78793_a(7.0f, 2.0f, 0.0f);
        this.arml2.func_78790_a(-2.5f, 4.0f, -2.5f, 5, 6, 5, 0.0f);
        this.headcase = new ModelRenderer((ModelBase)this, 34, 0);
        this.headcase.func_78793_a(0.0f, 0.0f, 0.0f);
        this.headcase.func_78790_a(-4.5f, -8.5f, -4.5f, 9, 6, 9, 0.0f);
        this.spike11 = new ModelRenderer((ModelBase)this, 16, 42);
        this.spike11.func_78793_a(0.0f, 0.0f, 0.0f);
        this.spike11.func_78790_a(-9.5f, 8.5f, 6.0f, 8, 2, 2, 0.0f);
        this.setRotateAngle(this.spike11, 0.2617994f, 0.0f, 0.0f);
        this.spike5 = new ModelRenderer((ModelBase)this, 16, 33);
        this.spike5.func_78793_a(0.0f, 0.0f, 0.0f);
        this.spike5.func_78790_a(-3.5f, 5.0f, 2.0f, 2, 2, 4, 0.0f);
        this.setRotateAngle(this.spike5, 0.2617994f, 0.0f, 0.0f);
        this.headcase2 = new ModelRenderer((ModelBase)this, 73, 0);
        this.headcase2.func_78793_a(0.0f, 0.0f, 0.0f);
        this.headcase2.func_78790_a(-3.5f, -9.5f, -9.0f, 2, 2, 11, 0.0f);
        this.legl = new ModelRenderer((ModelBase)this, 0, 16);
        this.legl.field_78809_i = true;
        this.legl.func_78793_a(2.4f, 11.0f, 2.4f);
        this.legl.func_78790_a(-2.0f, 0.0f, -2.0f, 4, 13, 4, 0.0f);
        this.bobble2 = new ModelRenderer((ModelBase)this, 73, 29);
        this.bobble2.func_78793_a(-7.0f, 6.0f, -10.5f);
        this.bobble2.func_78790_a(-3.0f, 10.0f, -3.0f, 6, 6, 6, 0.0f);
        this.spike2 = new ModelRenderer((ModelBase)this, 16, 33);
        this.spike2.func_78793_a(0.0f, 0.0f, 0.0f);
        this.spike2.func_78790_a(1.5f, 1.5f, 2.0f, 2, 2, 4, 0.0f);
        this.setRotateAngle(this.spike2, 0.2617994f, 0.0f, 0.0f);
        this.bobble1 = new ModelRenderer((ModelBase)this, 62, 29);
        this.bobble1.func_78793_a(-7.0f, 6.0f, -10.5f);
        this.bobble1.func_78790_a(-0.8f, 0.0f, -1.5f, 1, 10, 3, 0.0f);
        this.spike1 = new ModelRenderer((ModelBase)this, 16, 33);
        this.spike1.func_78793_a(0.0f, 0.0f, 0.0f);
        this.spike1.func_78790_a(-3.5f, 1.5f, 2.0f, 2, 2, 4, 0.0f);
        this.setRotateAngle(this.spike1, 0.2617994f, 0.0f, 0.0f);
        this.spike12 = new ModelRenderer((ModelBase)this, 16, 42);
        this.spike12.field_78809_i = true;
        this.spike12.func_78793_a(0.0f, 0.0f, 0.0f);
        this.spike12.func_78790_a(1.5f, 8.5f, 6.0f, 8, 2, 2, 0.0f);
        this.setRotateAngle(this.spike12, 0.2617994f, 0.0f, 0.0f);
        this.arml = new ModelRenderer((ModelBase)this, 40, 16);
        this.arml.field_78809_i = true;
        this.arml.func_78793_a(7.0f, 2.0f, 0.0f);
        this.arml.func_78790_a(-3.0f, -2.0f, -3.0f, 6, 6, 6, 0.0f);
        this.head = new ModelRenderer((ModelBase)this, 0, 0);
        this.head.func_78793_a(0.0f, 0.0f, 0.0f);
        this.head.func_78790_a(-4.0f, -8.0f, -4.0f, 8, 8, 8, 0.0f);
        this.headcase3 = new ModelRenderer((ModelBase)this, 73, 0);
        this.headcase3.func_78793_a(0.0f, 0.0f, 0.0f);
        this.headcase3.func_78790_a(1.5f, -9.5f, -9.0f, 2, 2, 11, 0.0f);
        this.armr2 = new ModelRenderer((ModelBase)this, 40, 30);
        this.armr2.func_78793_a(-7.0f, 2.0f, 0.0f);
        this.armr2.func_78790_a(-2.5f, 4.0f, -2.5f, 5, 6, 5, 0.0f);
        this.setRotateAngle(this.armr2, -1.134464f, 0.0f, 0.0f);
        this.armr = new ModelRenderer((ModelBase)this, 40, 16);
        this.armr.func_78793_a(-7.0f, 2.0f, 0.0f);
        this.armr.func_78790_a(-3.0f, -2.0f, -3.0f, 6, 6, 6, 0.0f);
        this.setRotateAngle(this.armr, -1.134464f, 0.0f, 0.0f);
        this.armr3 = new ModelRenderer((ModelBase)this, 40, 43);
        this.armr3.func_78793_a(-7.0f, 2.0f, 0.0f);
        this.armr3.func_78790_a(-2.0f, 10.0f, -2.0f, 4, 3, 4, 0.0f);
        this.setRotateAngle(this.armr3, -1.134464f, 0.0f, 0.0f);
        this.spike3 = new ModelRenderer((ModelBase)this, 16, 42);
        this.spike3.func_78793_a(0.0f, 0.0f, 0.0f);
        this.spike3.func_78790_a(-9.5f, 1.5f, 6.0f, 8, 2, 2, 0.0f);
        this.setRotateAngle(this.spike3, 0.2617994f, 0.0f, 0.0f);
        this.armlp = new ModelRenderer((ModelBase)this, 40, 51);
        this.armlp.field_78809_i = true;
        this.armlp.func_78793_a(7.0f, 2.0f, 0.0f);
        this.armlp.func_78790_a(3.0f, -1.5f, -2.5f, 1, 5, 5, 0.0f);
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.legr.func_78785_a(f5);
        this.spike10.func_78785_a(f5);
        this.spike7.func_78785_a(f5);
        this.body.func_78785_a(f5);
        this.arml3.func_78785_a(f5);
        this.spike4.func_78785_a(f5);
        this.armrp.func_78785_a(f5);
        this.bobble3.func_78785_a(f5);
        this.spike6.func_78785_a(f5);
        this.spike9.func_78785_a(f5);
        this.spike8.func_78785_a(f5);
        this.arml2.func_78785_a(f5);
        this.headcase.func_78785_a(f5);
        this.spike11.func_78785_a(f5);
        this.spike5.func_78785_a(f5);
        this.headcase2.func_78785_a(f5);
        this.legl.func_78785_a(f5);
        this.bobble2.func_78785_a(f5);
        this.spike2.func_78785_a(f5);
        this.bobble1.func_78785_a(f5);
        this.spike1.func_78785_a(f5);
        this.spike12.func_78785_a(f5);
        this.arml.func_78785_a(f5);
        this.head.func_78785_a(f5);
        this.headcase3.func_78785_a(f5);
        this.armr2.func_78785_a(f5);
        this.armr.func_78785_a(f5);
        this.armr3.func_78785_a(f5);
        this.spike3.func_78785_a(f5);
        this.armlp.func_78785_a(f5);
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.head.field_78796_g = netHeadYaw * ((float)Math.PI / 180);
        this.head.field_78795_f = headPitch * ((float)Math.PI / 180);
        this.headcase.field_78796_g = netHeadYaw * ((float)Math.PI / 180);
        this.headcase.field_78795_f = headPitch * ((float)Math.PI / 180);
        this.headcase2.field_78796_g = netHeadYaw * ((float)Math.PI / 180);
        this.headcase2.field_78795_f = headPitch * ((float)Math.PI / 180);
        this.headcase3.field_78796_g = netHeadYaw * ((float)Math.PI / 180);
        this.headcase3.field_78795_f = headPitch * ((float)Math.PI / 180);
        this.legr.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f)) * 1.4f * limbSwingAmount * 0.5f;
        this.legl.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f + (float)Math.PI)) * 1.4f * limbSwingAmount * 0.5f;
        this.arml.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f)) * 2.0f * limbSwingAmount * 0.5f;
        this.armlp.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f)) * 2.0f * limbSwingAmount * 0.5f;
        this.arml2.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f)) * 2.0f * limbSwingAmount * 0.5f;
        this.arml3.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f)) * 2.0f * limbSwingAmount * 0.5f;
        this.bobble1.field_78795_f = Mth.func_76134_b((float)(ageInTicks * 0.1f)) * (float)Math.PI * 0.15f;
        this.bobble2.field_78795_f = Mth.func_76134_b((float)(ageInTicks * 0.1f)) * (float)Math.PI * 0.15f;
        this.bobble3.field_78795_f = Mth.func_76134_b((float)(ageInTicks * 0.1f)) * (float)Math.PI * 0.15f;
    }
}

