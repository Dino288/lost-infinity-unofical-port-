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

public class ModelDeviantWitch
extends ModelBase {
    public ModelRenderer head;
    public ModelRenderer armr;
    public ModelRenderer arml;
    public ModelRenderer armc;
    public ModelRenderer legl;
    public ModelRenderer body;
    public ModelRenderer coat;
    public ModelRenderer legr;
    public ModelRenderer wingl;
    public ModelRenderer wingr;
    public ModelRenderer hatspin;
    public ModelRenderer hatspin2;
    public ModelRenderer nose1;
    public ModelRenderer hat1;
    public ModelRenderer nose2;
    public ModelRenderer hat2;
    public ModelRenderer hat3;
    public ModelRenderer hat4;

    public ModelDeviantWitch() {
        this.field_78090_t = 64;
        this.field_78089_u = 128;
        this.legl = new ModelRenderer((ModelBase)this, 0, 22);
        this.legl.field_78809_i = true;
        this.legl.func_78793_a(2.0f, 12.0f, 0.0f);
        this.legl.func_78790_a(-2.0f, 0.0f, -2.0f, 4, 12, 4, 0.0f);
        this.hat1 = new ModelRenderer((ModelBase)this, 0, 64);
        this.hat1.func_78793_a(-5.0f, -10.03f, -5.0f);
        this.hat1.func_78790_a(0.0f, 0.0f, 0.0f, 10, 2, 10, 0.0f);
        this.nose2 = new ModelRenderer((ModelBase)this, 0, 0);
        this.nose2.field_78809_i = true;
        this.nose2.func_78793_a(0.0f, -2.0f, 0.0f);
        this.nose2.func_78790_a(0.0f, 3.0f, -6.75f, 1, 1, 1, 0.0f);
        this.armc = new ModelRenderer((ModelBase)this, 40, 38);
        this.armc.func_78793_a(0.0f, 3.0f, -1.0f);
        this.armc.func_78790_a(-4.0f, 2.0f, -2.0f, 8, 4, 4, 0.0f);
        this.setRotateAngle(this.armc, -0.749968f, 0.0f, 0.0f);
        this.hat3 = new ModelRenderer((ModelBase)this, 0, 87);
        this.hat3.func_78793_a(1.75f, -4.0f, 2.0f);
        this.hat3.func_78790_a(0.0f, 0.0f, 0.0f, 4, 4, 4, 0.0f);
        this.setRotateAngle(this.hat3, -0.10471976f, 0.0f, 0.05235988f);
        this.coat = new ModelRenderer((ModelBase)this, 0, 38);
        this.coat.func_78793_a(0.0f, 0.0f, 0.0f);
        this.coat.func_78790_a(-4.0f, 0.0f, -3.0f, 8, 18, 6, 0.5f);
        this.armr = new ModelRenderer((ModelBase)this, 44, 22);
        this.armr.func_78793_a(0.0f, 3.0f, -1.0f);
        this.armr.func_78790_a(-8.0f, -2.0f, -2.0f, 4, 8, 4, 0.0f);
        this.setRotateAngle(this.armr, -0.749968f, 0.0f, 0.0f);
        this.head = new ModelRenderer((ModelBase)this, 0, 0);
        this.head.func_78793_a(0.0f, 0.0f, 0.0f);
        this.head.func_78790_a(-4.0f, -10.0f, -4.0f, 8, 10, 8, 0.0f);
        this.wingl = new ModelRenderer((ModelBase)this, 40, 69);
        this.wingl.field_78809_i = true;
        this.wingl.func_78793_a(2.5f, 4.0f, 4.0f);
        this.wingl.func_78790_a(-0.5f, -7.0f, 0.0f, 1, 18, 10, 0.5f);
        this.hat4 = new ModelRenderer((ModelBase)this, 0, 95);
        this.hat4.func_78793_a(1.75f, -2.0f, 2.0f);
        this.hat4.func_78790_a(0.0f, 0.0f, 0.0f, 1, 2, 1, 0.0f);
        this.setRotateAngle(this.hat4, -0.20943952f, 0.0f, 0.10471976f);
        this.hatspin = new ModelRenderer((ModelBase)this, 16, 98);
        this.hatspin.func_78793_a(0.0f, -10.0f, 0.0f);
        this.hatspin.func_78790_a(7.0f, -1.5f, -1.5f, 3, 3, 3, 0.0f);
        this.hatspin2 = new ModelRenderer((ModelBase)this, 16, 98);
        this.hatspin2.func_78793_a(0.0f, -10.0f, 0.0f);
        this.hatspin2.func_78790_a(-10.0f, -1.5f, -1.5f, 3, 3, 3, 0.0f);
        this.body = new ModelRenderer((ModelBase)this, 16, 20);
        this.body.func_78793_a(0.0f, 0.0f, 0.0f);
        this.body.func_78790_a(-4.0f, 0.0f, -3.0f, 8, 12, 6, 0.0f);
        this.hat2 = new ModelRenderer((ModelBase)this, 0, 76);
        this.hat2.func_78793_a(1.75f, -4.0f, 2.0f);
        this.hat2.func_78790_a(0.0f, 0.0f, 0.0f, 7, 4, 7, 0.0f);
        this.setRotateAngle(this.hat2, -0.05235988f, 0.0f, 0.02617994f);
        this.legr = new ModelRenderer((ModelBase)this, 0, 22);
        this.legr.func_78793_a(-2.0f, 12.0f, 0.0f);
        this.legr.func_78790_a(-2.0f, 0.0f, -2.0f, 4, 12, 4, 0.0f);
        this.nose1 = new ModelRenderer((ModelBase)this, 24, 0);
        this.nose1.func_78793_a(0.0f, -2.0f, 0.0f);
        this.nose1.func_78790_a(-1.0f, -1.0f, -6.0f, 2, 4, 2, 0.0f);
        this.setRotateAngle(this.nose1, 0.0f, 0.0f, 0.04363323f);
        this.arml = new ModelRenderer((ModelBase)this, 44, 22);
        this.arml.func_78793_a(0.0f, 3.0f, -1.0f);
        this.arml.func_78790_a(4.0f, -2.0f, -2.0f, 4, 8, 4, 0.0f);
        this.setRotateAngle(this.arml, -0.749968f, 0.0f, 0.0f);
        this.wingr = new ModelRenderer((ModelBase)this, 40, 69);
        this.wingr.func_78793_a(-2.5f, 4.0f, 4.0f);
        this.wingr.func_78790_a(-0.5f, -7.0f, 0.0f, 1, 18, 10, 0.5f);
        this.head.func_78792_a(this.hat1);
        this.nose1.func_78792_a(this.nose2);
        this.hat2.func_78792_a(this.hat3);
        this.hat3.func_78792_a(this.hat4);
        this.hat1.func_78792_a(this.hat2);
        this.head.func_78792_a(this.nose1);
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.legl.func_78785_a(f5);
        this.armc.func_78785_a(f5);
        this.coat.func_78785_a(f5);
        this.armr.func_78785_a(f5);
        this.head.func_78785_a(f5);
        this.wingl.func_78785_a(f5);
        this.hatspin.func_78785_a(f5);
        this.hatspin2.func_78785_a(f5);
        this.body.func_78785_a(f5);
        this.legr.func_78785_a(f5);
        this.arml.func_78785_a(f5);
        this.wingr.func_78785_a(f5);
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.legr.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f)) * 1.4f * limbSwingAmount * 0.5f;
        this.legl.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f + (float)Math.PI)) * 1.4f * limbSwingAmount * 0.5f;
        this.wingr.field_78796_g = -0.5f + (float)Math.sin((double)ageInTicks * 0.1) * 0.5f;
        this.wingl.field_78796_g = 0.5f - (float)Math.sin((double)ageInTicks * 0.1) * 0.5f;
        this.hatspin.field_78796_g = ageInTicks * -0.2f;
        this.hatspin2.field_78796_g = ageInTicks * 0.2f;
    }
}

