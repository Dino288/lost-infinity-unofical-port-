/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.model.ModelRenderer
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.math.Mth
 */
package xol.lostinfinity.mob.model.starforge;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import xol.lostinfinity.mob.entity.starforge.EntityGnawer;

public class ModelGnawer
extends ModelBase {
    public ModelRenderer body;
    public ModelRenderer legbl;
    public ModelRenderer legfl;
    public ModelRenderer legbr;
    public ModelRenderer legfr;
    public ModelRenderer head;
    public ModelRenderer tendril1;
    public ModelRenderer tendril2;
    public ModelRenderer tendril3;
    public ModelRenderer tendril4;
    public ModelRenderer mouthtl;
    public ModelRenderer mouthtr;
    public ModelRenderer mouthbl;
    public ModelRenderer mouthbr;
    public ModelRenderer body2;

    public ModelGnawer() {
        this.field_78090_t = 64;
        this.field_78089_u = 64;
        this.legfr = new ModelRenderer((ModelBase)this, 0, 16);
        this.legfr.func_78793_a(-3.0f, 18.0f, -2.0f);
        this.legfr.func_78790_a(-2.0f, 0.0f, -2.0f, 4, 6, 4, 0.0f);
        this.tendril4 = new ModelRenderer((ModelBase)this, 26, 0);
        this.tendril4.func_78793_a(1.5f, 12.0f, -7.5f);
        this.tendril4.func_78790_a(-0.5f, -0.5f, -5.0f, 1, 1, 5, 0.0f);
        this.legfl = new ModelRenderer((ModelBase)this, 0, 16);
        this.legfl.func_78793_a(3.0f, 18.0f, -2.0f);
        this.legfl.func_78790_a(-2.0f, 0.0f, -2.0f, 4, 6, 4, 0.0f);
        this.tendril3 = new ModelRenderer((ModelBase)this, 26, 0);
        this.tendril3.func_78793_a(-1.5f, 12.0f, -7.5f);
        this.tendril3.func_78790_a(-0.5f, -0.5f, -5.0f, 1, 1, 5, 0.0f);
        this.tendril2 = new ModelRenderer((ModelBase)this, 26, 0);
        this.tendril2.func_78793_a(-1.5f, 14.5f, -7.5f);
        this.tendril2.func_78790_a(-0.5f, -0.5f, -5.0f, 1, 1, 5, 0.0f);
        this.mouthbr = new ModelRenderer((ModelBase)this, 34, 18);
        this.mouthbr.func_78793_a(-2.0f, 15.0f, -8.0f);
        this.mouthbr.func_78790_a(-2.0f, -2.0f, -7.0f, 4, 4, 7, 0.0f);
        this.legbr = new ModelRenderer((ModelBase)this, 0, 16);
        this.legbr.func_78793_a(-3.0f, 18.0f, 10.0f);
        this.legbr.func_78790_a(-2.0f, 0.0f, -2.0f, 4, 6, 4, 0.0f);
        this.body = new ModelRenderer((ModelBase)this, 28, 38);
        this.body.func_78793_a(0.0f, 11.0f, 5.0f);
        this.body.func_78790_a(-5.0f, -10.0f, -7.0f, 10, 16, 8, 0.0f);
        this.setRotateAngle(this.body, 1.5707964f, 0.0f, 0.0f);
        this.body2 = new ModelRenderer((ModelBase)this, 0, 28);
        this.body2.func_78793_a(0.0f, 11.5f, 5.0f);
        this.body2.func_78790_a(-3.0f, -5.0f, -7.0f, 6, 4, 12, 0.0f);
        this.legbl = new ModelRenderer((ModelBase)this, 0, 16);
        this.legbl.func_78793_a(3.0f, 18.0f, 10.0f);
        this.legbl.func_78790_a(-2.0f, 0.0f, -2.0f, 4, 6, 4, 0.0f);
        this.mouthbl = new ModelRenderer((ModelBase)this, 34, 18);
        this.mouthbl.field_78809_i = true;
        this.mouthbl.func_78793_a(2.0f, 15.0f, -8.0f);
        this.mouthbl.func_78790_a(-2.0f, -2.0f, -7.0f, 4, 4, 7, 0.0f);
        this.tendril1 = new ModelRenderer((ModelBase)this, 26, 0);
        this.tendril1.func_78793_a(1.5f, 14.5f, -7.5f);
        this.tendril1.func_78790_a(-0.5f, -0.5f, -5.0f, 1, 1, 5, 0.0f);
        this.mouthtl = new ModelRenderer((ModelBase)this, 34, 1);
        this.mouthtl.field_78809_i = true;
        this.mouthtl.func_78793_a(2.0f, 11.0f, -8.0f);
        this.mouthtl.func_78790_a(-2.0f, -2.0f, -7.0f, 4, 4, 7, 0.0f);
        this.mouthtr = new ModelRenderer((ModelBase)this, 34, 1);
        this.mouthtr.func_78793_a(-2.0f, 11.0f, -8.0f);
        this.mouthtr.func_78790_a(-2.0f, -2.0f, -7.0f, 4, 4, 7, 0.0f);
        this.head = new ModelRenderer((ModelBase)this, 0, 0);
        this.head.func_78793_a(0.0f, 13.0f, -4.0f);
        this.head.func_78790_a(-4.0f, -4.0f, -4.0f, 8, 8, 4, 0.0f);
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.legfr.func_78785_a(f5);
        this.tendril4.func_78785_a(f5);
        this.legfl.func_78785_a(f5);
        this.tendril3.func_78785_a(f5);
        this.tendril2.func_78785_a(f5);
        this.mouthbr.func_78785_a(f5);
        this.legbr.func_78785_a(f5);
        this.body.func_78785_a(f5);
        this.body2.func_78785_a(f5);
        this.legbl.func_78785_a(f5);
        this.mouthbl.func_78785_a(f5);
        this.tendril1.func_78785_a(f5);
        this.mouthtl.func_78785_a(f5);
        this.mouthtr.func_78785_a(f5);
        this.head.func_78785_a(f5);
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.legbr.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f)) * 1.4f * limbSwingAmount;
        this.legbl.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f + (float)Math.PI)) * 1.4f * limbSwingAmount;
        this.legfr.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f + (float)Math.PI)) * 1.4f * limbSwingAmount;
        this.legfl.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f)) * 1.4f * limbSwingAmount;
        EntityGnawer entity = (EntityGnawer)entityIn;
        if (entity.getAngry()) {
            this.mouthbr.field_78795_f = Mth.func_76134_b((float)(ageInTicks * 0.1f)) * 0.1f + 0.7f;
            this.mouthbr.field_78808_h = Mth.func_76134_b((float)(ageInTicks * 0.1f)) * 0.1f + 0.7f;
            this.tendril1.field_78795_f = Mth.func_76134_b((float)(ageInTicks * 0.1f)) * 0.1f;
            this.tendril3.field_78795_f = Mth.func_76134_b((float)((ageInTicks + 2.0f) * 0.1f)) * 0.1f;
            this.tendril2.field_78795_f = Mth.func_76126_a((float)(ageInTicks * 0.1f)) * 0.1f;
            this.tendril4.field_78795_f = Mth.func_76126_a((float)((ageInTicks + 2.0f) * 0.1f)) * 0.1f;
        } else {
            this.mouthbr.field_78795_f = 0.0f;
            this.mouthbr.field_78808_h = 0.0f;
            this.tendril1.field_78795_f = 0.0f;
            this.tendril3.field_78795_f = 0.0f;
            this.tendril2.field_78795_f = 0.0f;
            this.tendril4.field_78795_f = 0.0f;
        }
        this.mouthtr.field_78795_f = -this.mouthbr.field_78795_f;
        this.mouthtr.field_78808_h = -this.mouthbr.field_78808_h;
        this.mouthtl.field_78795_f = -this.mouthbr.field_78795_f;
        this.mouthtl.field_78808_h = this.mouthbr.field_78808_h;
        this.mouthbl.field_78795_f = this.mouthbr.field_78795_f;
        this.mouthbl.field_78808_h = -this.mouthbr.field_78808_h;
    }
}

