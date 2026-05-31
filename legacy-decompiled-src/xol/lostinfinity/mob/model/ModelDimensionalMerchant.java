/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.model.ModelRenderer
 *  net.minecraft.entity.Entity
 */
package xol.lostinfinity.mob.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.world.entity.Entity;

public class ModelDimensionalMerchant
extends ModelBase {
    public ModelRenderer head;
    public ModelRenderer rightarm;
    public ModelRenderer leftarm;
    public ModelRenderer armsconnect;
    public ModelRenderer leftleg;
    public ModelRenderer body;
    public ModelRenderer jacket;
    public ModelRenderer rightleg;
    public ModelRenderer nose;
    public ModelRenderer goggleTR;
    public ModelRenderer goggleBR;
    public ModelRenderer goggleTL;
    public ModelRenderer goggleBL;
    public ModelRenderer goggleBandbot;
    public ModelRenderer goggleBandtop;
    public ModelRenderer goggleBandBR;
    public ModelRenderer goggleBandTR;
    public ModelRenderer goggleBandBL;
    public ModelRenderer goggleBandTL;

    public ModelDimensionalMerchant() {
        this.field_78090_t = 64;
        this.field_78089_u = 64;
        this.body = new ModelRenderer((ModelBase)this, 16, 20);
        this.body.func_78793_a(0.0f, 0.0f, 0.0f);
        this.body.func_78790_a(-4.0f, 0.0f, -3.0f, 8, 12, 6, 0.0f);
        this.goggleBR = new ModelRenderer((ModelBase)this, 36, 3);
        this.goggleBR.func_78793_a(0.0f, 0.0f, 0.0f);
        this.goggleBR.func_78790_a(-4.0f, -5.0f, -5.0f, 3, 3, 1, 0.0f);
        this.nose = new ModelRenderer((ModelBase)this, 24, 0);
        this.nose.func_78793_a(0.0f, -2.0f, 0.0f);
        this.nose.func_78790_a(-1.0f, -1.0f, -6.0f, 2, 4, 2, 0.0f);
        this.goggleBandbot = new ModelRenderer((ModelBase)this, 46, 3);
        this.goggleBandbot.func_78793_a(0.0f, 0.0f, 0.0f);
        this.goggleBandbot.func_78790_a(-1.0f, -4.5f, -5.0f, 2, 1, 1, 0.0f);
        this.rightleg = new ModelRenderer((ModelBase)this, 0, 22);
        this.rightleg.func_78793_a(-2.0f, 12.0f, 0.0f);
        this.rightleg.func_78790_a(-2.0f, 0.0f, -2.0f, 4, 12, 4, 0.0f);
        this.leftarm = new ModelRenderer((ModelBase)this, 44, 22);
        this.leftarm.func_78793_a(0.0f, 3.0f, -1.0f);
        this.leftarm.func_78790_a(4.0f, -2.0f, -2.0f, 4, 8, 4, 0.0f);
        this.setRotateAngle(this.leftarm, -0.749968f, 0.0f, 0.0f);
        this.goggleBL = new ModelRenderer((ModelBase)this, 36, 3);
        this.goggleBL.func_78793_a(0.0f, 0.0f, 0.0f);
        this.goggleBL.func_78790_a(1.0f, -5.0f, -5.0f, 3, 3, 1, 0.0f);
        this.rightarm = new ModelRenderer((ModelBase)this, 44, 22);
        this.rightarm.func_78793_a(0.0f, 3.0f, -1.0f);
        this.rightarm.func_78790_a(-8.0f, -2.0f, -2.0f, 4, 8, 4, 0.0f);
        this.setRotateAngle(this.rightarm, -0.749968f, 0.0f, 0.0f);
        this.goggleTR = new ModelRenderer((ModelBase)this, 36, 3);
        this.goggleTR.func_78793_a(0.0f, 0.0f, 0.0f);
        this.goggleTR.func_78790_a(-4.0f, -8.5f, -5.0f, 3, 3, 1, 0.0f);
        this.goggleBandtop = new ModelRenderer((ModelBase)this, 46, 3);
        this.goggleBandtop.func_78793_a(0.0f, 0.0f, 0.0f);
        this.goggleBandtop.func_78790_a(-1.0f, -8.0f, -5.0f, 2, 1, 1, 0.0f);
        this.armsconnect = new ModelRenderer((ModelBase)this, 40, 38);
        this.armsconnect.func_78793_a(0.0f, 3.0f, -1.0f);
        this.armsconnect.func_78790_a(-4.0f, 2.0f, -2.0f, 8, 4, 4, 0.0f);
        this.setRotateAngle(this.armsconnect, -0.749968f, 0.0f, 0.0f);
        this.goggleBandTR = new ModelRenderer((ModelBase)this, 36, 11);
        this.goggleBandTR.func_78793_a(0.0f, 0.0f, 0.0f);
        this.goggleBandTR.func_78790_a(-5.0f, -8.0f, -5.0f, 1, 1, 5, 0.0f);
        this.jacket = new ModelRenderer((ModelBase)this, 0, 38);
        this.jacket.func_78793_a(0.0f, 0.0f, 0.0f);
        this.jacket.func_78790_a(-4.0f, 0.0f, -3.0f, 8, 18, 6, 0.5f);
        this.head = new ModelRenderer((ModelBase)this, 0, 0);
        this.head.func_78793_a(0.0f, 0.0f, 0.0f);
        this.head.func_78790_a(-4.0f, -10.0f, -4.0f, 8, 10, 8, 0.0f);
        this.goggleBandBL = new ModelRenderer((ModelBase)this, 36, 11);
        this.goggleBandBL.func_78793_a(0.0f, 0.0f, 0.0f);
        this.goggleBandBL.func_78790_a(4.0f, -4.5f, -5.0f, 1, 1, 5, 0.0f);
        this.goggleBandTL = new ModelRenderer((ModelBase)this, 36, 11);
        this.goggleBandTL.func_78793_a(0.0f, 0.0f, 0.0f);
        this.goggleBandTL.func_78790_a(4.0f, -8.0f, -5.0f, 1, 1, 5, 0.0f);
        this.leftleg = new ModelRenderer((ModelBase)this, 0, 22);
        this.leftleg.field_78809_i = true;
        this.leftleg.func_78793_a(2.0f, 12.0f, 0.0f);
        this.leftleg.func_78790_a(-2.0f, 0.0f, -2.0f, 4, 12, 4, 0.0f);
        this.goggleTL = new ModelRenderer((ModelBase)this, 36, 3);
        this.goggleTL.func_78793_a(0.0f, 0.0f, 0.0f);
        this.goggleTL.func_78790_a(1.0f, -8.5f, -5.0f, 3, 3, 1, 0.0f);
        this.goggleBandBR = new ModelRenderer((ModelBase)this, 36, 11);
        this.goggleBandBR.func_78793_a(0.0f, 0.0f, 0.0f);
        this.goggleBandBR.func_78790_a(-5.0f, -4.5f, -5.0f, 1, 1, 5, 0.0f);
        this.head.func_78792_a(this.goggleBR);
        this.head.func_78792_a(this.nose);
        this.head.func_78792_a(this.goggleBandbot);
        this.head.func_78792_a(this.goggleBL);
        this.head.func_78792_a(this.goggleTR);
        this.head.func_78792_a(this.goggleBandtop);
        this.head.func_78792_a(this.goggleBandTR);
        this.head.func_78792_a(this.goggleBandBL);
        this.head.func_78792_a(this.goggleBandTL);
        this.head.func_78792_a(this.goggleTL);
        this.head.func_78792_a(this.goggleBandBR);
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.body.func_78785_a(f5);
        this.rightleg.func_78785_a(f5);
        this.leftarm.func_78785_a(f5);
        this.rightarm.func_78785_a(f5);
        this.armsconnect.func_78785_a(f5);
        this.jacket.func_78785_a(f5);
        this.head.func_78785_a(f5);
        this.leftleg.func_78785_a(f5);
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.head.field_78796_g = netHeadYaw * ((float)Math.PI / 180);
        this.head.field_78795_f = headPitch * ((float)Math.PI / 180);
    }
}

