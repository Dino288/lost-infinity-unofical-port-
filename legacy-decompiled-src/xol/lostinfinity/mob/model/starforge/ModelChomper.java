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

public class ModelChomper
extends ModelBase {
    public ModelRenderer armr;
    public ModelRenderer legr;
    public ModelRenderer headR;
    public ModelRenderer body;
    public ModelRenderer arml;
    public ModelRenderer legl;
    public ModelRenderer headL;
    public ModelRenderer headR2;
    public ModelRenderer headL2;
    public ModelRenderer body2;
    public ModelRenderer armr2;
    public ModelRenderer arml2;

    public ModelChomper() {
        this.field_78090_t = 64;
        this.field_78089_u = 64;
        this.headL = new ModelRenderer((ModelBase)this, 0, 0);
        this.headL.field_78809_i = true;
        this.headL.func_78793_a(0.5f, 0.5f, 0.0f);
        this.headL.func_78790_a(0.0f, -12.0f, -4.0f, 4, 12, 8, 0.0f);
        this.setRotateAngle(this.headL, 0.0f, 0.0f, 0.2617994f);
        this.body2 = new ModelRenderer((ModelBase)this, 0, 40);
        this.body2.func_78793_a(0.0f, 0.0f, 0.0f);
        this.body2.func_78790_a(-6.0f, 0.0f, -2.5f, 12, 5, 5, 0.0f);
        this.headR = new ModelRenderer((ModelBase)this, 0, 0);
        this.headR.func_78793_a(-0.5f, 0.5f, 0.1f);
        this.headR.func_78790_a(-4.0f, -12.0f, -4.0f, 4, 12, 8, 0.0f);
        this.setRotateAngle(this.headR, 0.0f, 0.0f, -0.2617994f);
        this.arml2 = new ModelRenderer((ModelBase)this, 22, 45);
        this.arml2.func_78793_a(6.0f, 2.0f, 0.0f);
        this.arml2.func_78790_a(-1.0f, 13.0f, -1.0f, 1, 4, 14, 0.0f);
        this.legl = new ModelRenderer((ModelBase)this, 0, 22);
        this.legl.field_78809_i = true;
        this.legl.func_78793_a(1.9f, 12.0f, 0.1f);
        this.legl.func_78790_a(-2.0f, 0.0f, -2.0f, 4, 12, 4, 0.0f);
        this.arml = new ModelRenderer((ModelBase)this, 40, 40);
        this.arml.field_78809_i = true;
        this.arml.func_78793_a(6.0f, 2.0f, 0.0f);
        this.arml.func_78790_a(-1.0f, 0.0f, -1.0f, 2, 15, 2, 0.0f);
        this.body = new ModelRenderer((ModelBase)this, 16, 22);
        this.body.func_78793_a(0.0f, 0.0f, 0.0f);
        this.body.func_78790_a(-4.0f, 0.0f, -2.0f, 8, 12, 4, 0.0f);
        this.armr2 = new ModelRenderer((ModelBase)this, 22, 45);
        this.armr2.func_78793_a(-6.0f, 2.0f, 0.0f);
        this.armr2.func_78790_a(-1.0f, 13.0f, -1.0f, 1, 4, 14, 0.0f);
        this.headL2 = new ModelRenderer((ModelBase)this, 32, 0);
        this.headL2.field_78809_i = true;
        this.headL2.func_78793_a(0.5f, 0.5f, 0.0f);
        this.headL2.func_78790_a(-3.0f, -12.0f, -4.0f, 3, 12, 8, 0.0f);
        this.setRotateAngle(this.headL2, 0.0f, 0.0f, 0.2617994f);
        this.armr = new ModelRenderer((ModelBase)this, 40, 40);
        this.armr.func_78793_a(-6.0f, 2.0f, 0.0f);
        this.armr.func_78790_a(-1.0f, 0.0f, -1.0f, 2, 15, 2, 0.0f);
        this.legr = new ModelRenderer((ModelBase)this, 0, 22);
        this.legr.func_78793_a(-1.9f, 12.0f, 0.1f);
        this.legr.func_78790_a(-2.0f, 0.0f, -2.0f, 4, 12, 4, 0.0f);
        this.headR2 = new ModelRenderer((ModelBase)this, 32, 0);
        this.headR2.func_78793_a(-0.5f, 0.5f, 0.1f);
        this.headR2.func_78790_a(0.0f, -12.0f, -4.0f, 3, 12, 8, 0.0f);
        this.setRotateAngle(this.headR2, 0.0f, 0.0f, -0.2617994f);
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.headL.func_78785_a(f5);
        this.body2.func_78785_a(f5);
        this.headR.func_78785_a(f5);
        this.arml2.func_78785_a(f5);
        this.legl.func_78785_a(f5);
        this.arml.func_78785_a(f5);
        this.body.func_78785_a(f5);
        this.armr2.func_78785_a(f5);
        this.headL2.func_78785_a(f5);
        this.armr.func_78785_a(f5);
        this.legr.func_78785_a(f5);
        this.headR2.func_78785_a(f5);
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.headL2.field_78808_h = this.headL.field_78808_h = Mth.func_76134_b((float)(ageInTicks * 0.1f)) * 0.3f + 0.3617994f;
        this.headR.field_78808_h = -this.headL.field_78808_h;
        this.headR2.field_78808_h = -this.headL.field_78808_h;
        this.legr.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f)) * 1.4f * limbSwingAmount * 0.5f;
        this.legl.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f + (float)Math.PI)) * 1.4f * limbSwingAmount * 0.5f;
        this.armr2.field_78795_f = this.armr.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f + (float)Math.PI)) * 2.0f * limbSwingAmount * 0.5f;
        this.arml2.field_78795_f = this.arml.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f)) * 2.0f * limbSwingAmount * 0.5f;
    }
}

