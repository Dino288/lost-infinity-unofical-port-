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

public class ModelElara
extends ModelBase {
    public ModelRenderer armR;
    public ModelRenderer legR;
    public ModelRenderer head;
    public ModelRenderer body;
    public ModelRenderer armL;
    public ModelRenderer legL;
    public ModelRenderer armR2;
    public ModelRenderer armL2;
    public ModelRenderer armR3;
    public ModelRenderer armL3;
    public ModelRenderer body2;
    public ModelRenderer body3;
    public ModelRenderer body4;
    public ModelRenderer hplate1;
    public ModelRenderer hplate2;
    public ModelRenderer vplate1;
    public ModelRenderer vplate2;
    public ModelRenderer wingL;
    public ModelRenderer wingR;
    public ModelRenderer wingconnector;
    public ModelRenderer vplate3;
    public ModelRenderer bodyhplate;
    public ModelRenderer wep1;
    public ModelRenderer wep2;
    public ModelRenderer hair;

    public ModelElara() {
        this.field_78090_t = 128;
        this.field_78089_u = 64;
        this.vplate1 = new ModelRenderer((ModelBase)this, 16, 48);
        this.vplate1.field_78809_i = true;
        this.vplate1.func_78793_a(-4.8f, -2.0f, 0.0f);
        this.vplate1.func_78790_a(-0.5f, -3.0f, -3.0f, 1, 6, 6, 0.0f);
        this.wep1 = new ModelRenderer((ModelBase)this, 74, 39);
        this.wep1.func_78793_a(-7.0f, -1.0f, 0.0f);
        this.wep1.func_78790_a(-3.1f, 13.0f, -18.0f, 1, 1, 22, 0.0f);
        this.setRotateAngle(this.wep1, 0.0f, 0.0f, 0.20943952f);
        this.bodyhplate = new ModelRenderer((ModelBase)this, 0, 37);
        this.bodyhplate.field_78809_i = true;
        this.bodyhplate.func_78793_a(0.0f, 4.0f, 0.1f);
        this.bodyhplate.func_78790_a(-1.5f, -1.3f, -1.5f, 3, 1, 3, 0.0f);
        this.hplate2 = new ModelRenderer((ModelBase)this, 0, 46);
        this.hplate2.func_78793_a(-3.0f, 12.0f, 0.1f);
        this.hplate2.func_78790_a(-2.5f, -1.3f, -2.5f, 5, 1, 5, 0.0f);
        this.armR3 = new ModelRenderer((ModelBase)this, 42, 29);
        this.armR3.func_78793_a(-7.0f, -1.0f, 0.0f);
        this.armR3.func_78790_a(-4.2f, 10.0f, -1.5f, 3, 5, 3, 0.0f);
        this.setRotateAngle(this.armR3, 0.0f, 0.0f, 0.20943952f);
        this.armL3 = new ModelRenderer((ModelBase)this, 42, 29);
        this.armL3.field_78809_i = true;
        this.armL3.func_78793_a(7.0f, -1.0f, 0.0f);
        this.armL3.func_78790_a(1.2f, 10.0f, -1.5f, 3, 5, 3, 0.0f);
        this.setRotateAngle(this.armL3, 0.0f, 0.0f, -0.20943952f);
        this.wingconnector = new ModelRenderer((ModelBase)this, 63, 10);
        this.wingconnector.field_78809_i = true;
        this.wingconnector.func_78793_a(0.0f, -4.0f, 3.0f);
        this.wingconnector.func_78790_a(-4.0f, 0.0f, 0.0f, 8, 4, 4, 0.0f);
        this.head = new ModelRenderer((ModelBase)this, 0, 0);
        this.head.func_78793_a(0.0f, -4.0f, 0.0f);
        this.head.func_78790_a(-4.0f, -8.0f, -4.0f, 8, 8, 8, 0.0f);
        this.body4 = new ModelRenderer((ModelBase)this, 16, 40);
        this.body4.field_78809_i = true;
        this.body4.func_78793_a(0.0f, -3.0f, 0.0f);
        this.body4.func_78790_a(-4.0f, 10.0f, -2.0f, 8, 2, 4, 0.0f);
        this.body3 = new ModelRenderer((ModelBase)this, 16, 32);
        this.body3.field_78809_i = true;
        this.body3.func_78793_a(0.0f, -3.0f, 0.0f);
        this.body3.func_78790_a(-4.0f, 0.0f, -2.0f, 8, 2, 4, 0.0f);
        this.wep2 = new ModelRenderer((ModelBase)this, 99, 42);
        this.wep2.func_78793_a(-7.0f, -1.0f, 0.0f);
        this.wep2.func_78790_a(-5.5f, 10.4f, -21.0f, 6, 6, 6, 0.0f);
        this.setRotateAngle(this.wep2, 0.0f, 0.0f, 0.20943952f);
        this.armR = new ModelRenderer((ModelBase)this, 40, 0);
        this.armR.func_78793_a(-7.0f, -1.0f, 0.0f);
        this.armR.func_78790_a(-5.0f, -2.0f, -3.0f, 6, 5, 6, 0.0f);
        this.setRotateAngle(this.armR, 0.0f, 0.0f, 0.34906584f);
        this.armR2 = new ModelRenderer((ModelBase)this, 40, 16);
        this.armR2.func_78793_a(-7.0f, -1.0f, 0.0f);
        this.armR2.func_78790_a(-4.0f, 2.5f, -2.0f, 4, 8, 4, 0.0f);
        this.setRotateAngle(this.armR2, 0.0f, 0.0f, 0.27925268f);
        this.legL = new ModelRenderer((ModelBase)this, 0, 16);
        this.legL.field_78809_i = true;
        this.legL.func_78793_a(3.0f, 12.0f, 0.1f);
        this.legL.func_78790_a(-2.0f, 0.0f, -2.0f, 4, 12, 4, 0.0f);
        this.vplate2 = new ModelRenderer((ModelBase)this, 16, 48);
        this.vplate2.field_78809_i = true;
        this.vplate2.func_78793_a(4.8f, -2.0f, 0.0f);
        this.vplate2.func_78790_a(-0.5f, -3.0f, -3.0f, 1, 6, 6, 0.0f);
        this.legR = new ModelRenderer((ModelBase)this, 0, 16);
        this.legR.func_78793_a(-3.0f, 12.0f, 0.1f);
        this.legR.func_78790_a(-2.0f, 0.0f, -2.0f, 4, 12, 4, 0.0f);
        this.hair = new ModelRenderer((ModelBase)this, 89, 0);
        this.hair.func_78793_a(0.0f, -4.0f, 0.0f);
        this.hair.func_78790_a(-4.5f, -8.3f, -4.3f, 9, 17, 10, 0.0f);
        this.hplate1 = new ModelRenderer((ModelBase)this, 0, 46);
        this.hplate1.field_78809_i = true;
        this.hplate1.func_78793_a(3.0f, 12.0f, 0.1f);
        this.hplate1.func_78790_a(-2.5f, -1.3f, -2.5f, 5, 1, 5, 0.0f);
        this.wingL = new ModelRenderer((ModelBase)this, 60, 28);
        this.wingL.field_78809_i = true;
        this.wingL.func_78793_a(1.0f, -7.0f, 5.0f);
        this.wingL.func_78790_a(0.0f, -7.5f, -0.5f, 16, 30, 1, 0.0f);
        this.setRotateAngle(this.wingL, 0.0f, -0.61086524f, 0.0f);
        this.body2 = new ModelRenderer((ModelBase)this, 16, 16);
        this.body2.field_78809_i = true;
        this.body2.func_78793_a(0.0f, -3.0f, 0.0f);
        this.body2.func_78790_a(2.0f, 2.0f, -2.0f, 2, 8, 4, 0.0f);
        this.armL2 = new ModelRenderer((ModelBase)this, 40, 16);
        this.armL2.field_78809_i = true;
        this.armL2.func_78793_a(7.0f, -1.0f, 0.0f);
        this.armL2.func_78790_a(0.0f, 2.5f, -2.0f, 4, 8, 4, 0.0f);
        this.setRotateAngle(this.armL2, 0.0f, 0.0f, -0.27925268f);
        this.wingR = new ModelRenderer((ModelBase)this, 60, 28);
        this.wingR.field_78809_i = true;
        this.wingR.func_78793_a(-1.0f, -7.0f, 5.0f);
        this.wingR.func_78790_a(0.0f, -7.5f, -0.5f, 16, 30, 1, 0.0f);
        this.setRotateAngle(this.wingR, 0.0f, -2.5307274f, 0.0f);
        this.vplate3 = new ModelRenderer((ModelBase)this, 33, 48);
        this.vplate3.field_78809_i = true;
        this.vplate3.func_78793_a(0.0f, 3.0f, 0.0f);
        this.vplate3.func_78790_a(-0.5f, -3.0f, -3.0f, 1, 6, 6, 0.0f);
        this.armL = new ModelRenderer((ModelBase)this, 40, 0);
        this.armL.field_78809_i = true;
        this.armL.func_78793_a(7.0f, -1.0f, 0.0f);
        this.armL.func_78790_a(-1.0f, -2.0f, -3.0f, 6, 5, 6, 0.0f);
        this.setRotateAngle(this.armL, 0.0f, 0.0f, -0.34906584f);
        this.body = new ModelRenderer((ModelBase)this, 16, 16);
        this.body.func_78793_a(0.0f, -3.0f, 0.0f);
        this.body.func_78790_a(-4.0f, 2.0f, -2.0f, 2, 8, 4, 0.0f);
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.vplate1.func_78785_a(f5);
        this.wep1.func_78785_a(f5);
        this.bodyhplate.func_78785_a(f5);
        this.hplate2.func_78785_a(f5);
        this.armR3.func_78785_a(f5);
        this.armL3.func_78785_a(f5);
        this.wingconnector.func_78785_a(f5);
        this.head.func_78785_a(f5);
        this.body4.func_78785_a(f5);
        this.body3.func_78785_a(f5);
        this.wep2.func_78785_a(f5);
        this.armR.func_78785_a(f5);
        this.armR2.func_78785_a(f5);
        this.legL.func_78785_a(f5);
        this.vplate2.func_78785_a(f5);
        this.legR.func_78785_a(f5);
        this.hair.func_78785_a(f5);
        this.hplate1.func_78785_a(f5);
        this.wingL.func_78785_a(f5);
        this.body2.func_78785_a(f5);
        this.armL2.func_78785_a(f5);
        this.wingR.func_78785_a(f5);
        this.vplate3.func_78785_a(f5);
        this.armL.func_78785_a(f5);
        this.body.func_78785_a(f5);
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.head.field_78796_g = netHeadYaw * ((float)Math.PI / 180);
        this.head.field_78795_f = headPitch * ((float)Math.PI / 180);
        this.hair.field_78796_g = netHeadYaw * ((float)Math.PI / 180);
        this.hair.field_78795_f = headPitch * ((float)Math.PI / 180);
        this.legR.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f)) * 1.4f * limbSwingAmount * 0.5f;
        this.legL.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f + (float)Math.PI)) * 1.4f * limbSwingAmount * 0.5f;
        this.hplate1.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f)) * 1.4f * limbSwingAmount * 0.5f;
        this.hplate2.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f + (float)Math.PI)) * 1.4f * limbSwingAmount * 0.5f;
        this.hplate1.field_78796_g = ageInTicks * 0.05f;
        this.hplate2.field_78796_g = ageInTicks * -0.05f;
        this.bodyhplate.field_78796_g = ageInTicks * -0.3f;
        this.vplate3.field_78795_f = ageInTicks * -0.2f;
        this.vplate2.field_78795_f = ageInTicks * 0.05f;
        this.vplate1.field_78795_f = ageInTicks * 0.05f;
        this.armR.field_78808_h = Mth.func_76134_b((float)(ageInTicks * 0.1f)) * (float)Math.PI * 0.05f + 0.34906584f;
        this.armR2.field_78808_h = Mth.func_76134_b((float)(ageInTicks * 0.1f)) * (float)Math.PI * 0.05f + 0.27925268f;
        this.armR3.field_78808_h = Mth.func_76134_b((float)(ageInTicks * 0.1f)) * (float)Math.PI * 0.05f + 0.20943952f;
        this.wep1.field_78808_h = Mth.func_76134_b((float)(ageInTicks * 0.1f)) * (float)Math.PI * 0.05f + 0.20943952f;
        this.wep2.field_78808_h = Mth.func_76134_b((float)(ageInTicks * 0.1f)) * (float)Math.PI * 0.05f + 0.20943952f;
        this.armL.field_78808_h = -this.armR.field_78808_h;
        this.armL2.field_78808_h = -this.armR2.field_78808_h;
        this.armL3.field_78808_h = -this.armR3.field_78808_h;
        this.armR.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f + (float)Math.PI)) * 2.0f * limbSwingAmount * 0.5f;
        this.armR2.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f + (float)Math.PI)) * 2.0f * limbSwingAmount * 0.5f;
        this.armR3.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f + (float)Math.PI)) * 2.0f * limbSwingAmount * 0.5f;
        this.wep1.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f + (float)Math.PI)) * 2.0f * limbSwingAmount * 0.5f;
        this.wep2.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f + (float)Math.PI)) * 2.0f * limbSwingAmount * 0.5f;
        this.armL.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f)) * 2.0f * limbSwingAmount * 0.5f;
        this.armL2.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f)) * 2.0f * limbSwingAmount * 0.5f;
        this.armL3.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f)) * 2.0f * limbSwingAmount * 0.5f;
        this.wingL.field_78796_g = Mth.func_76134_b((float)(ageInTicks * 0.1f)) * (float)Math.PI * 0.17f - 0.7f;
        this.wingR.field_78796_g = 3.14f - this.wingL.field_78796_g;
    }
}

