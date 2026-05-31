/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.model.ModelRenderer
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.math.Mth
 */
package xol.lostinfinity.mob.model.starforge;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;

public class ModelSpyker
extends ModelBase {
    public ModelRenderer legbl;
    public ModelRenderer legfl;
    public ModelRenderer legbr;
    public ModelRenderer legfr;
    public ModelRenderer head;
    public ModelRenderer body;
    public ModelRenderer spike2;
    public ModelRenderer spike;
    public ModelRenderer spike3;
    public ModelRenderer spike4;
    public ModelRenderer spike5;
    public ModelRenderer spike6;
    public ModelRenderer spike7;
    public ModelRenderer spike8;
    public ModelRenderer spike9;
    public ModelRenderer spike10;
    public ModelRenderer head2;
    public ModelRenderer head3;
    public ModelRenderer head4;
    public ModelRenderer head5;

    public ModelSpyker() {
        this.field_78090_t = 64;
        this.field_78089_u = 64;
        this.spike9 = new ModelRenderer((ModelBase)this, 0, 27);
        this.spike9.func_78793_a(0.0f, 11.0f, -3.0f);
        this.spike9.func_78790_a(-2.0f, -8.0f, -2.0f, 4, 16, 4, 0.0f);
        this.setRotateAngle(this.spike9, 0.0f, 0.0f, -0.87266463f);
        this.head = new ModelRenderer((ModelBase)this, 0, 0);
        this.head.func_78793_a(0.0f, 14.0f, -6.0f);
        this.head.func_78790_a(-4.0f, -4.0f, -6.0f, 8, 6, 4, 0.0f);
        this.spike2 = new ModelRenderer((ModelBase)this, 18, 27);
        this.spike2.func_78793_a(0.0f, 11.0f, 0.0f);
        this.spike2.func_78790_a(-1.0f, -12.0f, -1.0f, 2, 24, 2, 0.0f);
        this.spike8 = new ModelRenderer((ModelBase)this, 18, 27);
        this.spike8.func_78793_a(0.0f, 11.0f, 3.0f);
        this.spike8.func_78790_a(-1.0f, -12.0f, -1.0f, 2, 24, 2, 0.0f);
        this.setRotateAngle(this.spike8, 0.0f, 0.0f, 0.87266463f);
        this.legbl = new ModelRenderer((ModelBase)this, 0, 11);
        this.legbl.field_78809_i = true;
        this.legbl.func_78793_a(3.5f, 14.0f, 7.0f);
        this.legbl.func_78790_a(-2.0f, 0.0f, -2.0f, 4, 10, 4, 0.0f);
        this.legfl = new ModelRenderer((ModelBase)this, 0, 11);
        this.legfl.field_78809_i = true;
        this.legfl.func_78793_a(3.5f, 14.0f, -5.0f);
        this.legfl.func_78790_a(-2.0f, 0.0f, -2.0f, 4, 10, 4, 0.0f);
        this.legfr = new ModelRenderer((ModelBase)this, 0, 11);
        this.legfr.func_78793_a(-3.5f, 14.0f, -5.0f);
        this.legfr.func_78790_a(-2.0f, 0.0f, -2.0f, 4, 10, 4, 0.0f);
        this.head4 = new ModelRenderer((ModelBase)this, 28, 0);
        this.head4.func_78793_a(0.0f, 14.0f, -6.0f);
        this.head4.func_78790_a(-4.0f, -4.0f, -9.0f, 2, 2, 3, 0.0f);
        this.spike6 = new ModelRenderer((ModelBase)this, 0, 27);
        this.spike6.func_78793_a(0.0f, 11.0f, 1.5f);
        this.spike6.func_78790_a(-2.0f, -8.0f, -2.0f, 4, 16, 4, 0.0f);
        this.setRotateAngle(this.spike6, 0.0f, 0.0f, 0.43633232f);
        this.spike10 = new ModelRenderer((ModelBase)this, 18, 27);
        this.spike10.func_78793_a(0.0f, 11.0f, -3.0f);
        this.spike10.func_78790_a(-1.0f, -12.0f, -1.0f, 2, 24, 2, 0.0f);
        this.setRotateAngle(this.spike10, 0.0f, 0.0f, -0.87266463f);
        this.head3 = new ModelRenderer((ModelBase)this, 41, 0);
        this.head3.func_78793_a(0.0f, 14.0f, -6.0f);
        this.head3.func_78790_a(3.0f, -4.0f, -13.0f, 1, 1, 4, 0.0f);
        this.head2 = new ModelRenderer((ModelBase)this, 41, 0);
        this.head2.func_78793_a(0.0f, 14.0f, -6.0f);
        this.head2.func_78790_a(-4.0f, -4.0f, -13.0f, 1, 1, 4, 0.0f);
        this.spike = new ModelRenderer((ModelBase)this, 0, 27);
        this.spike.func_78793_a(0.0f, 11.0f, 0.0f);
        this.spike.func_78790_a(-2.0f, -8.0f, -2.0f, 4, 16, 4, 0.0f);
        this.spike5 = new ModelRenderer((ModelBase)this, 18, 27);
        this.spike5.func_78793_a(0.0f, 11.0f, 1.5f);
        this.spike5.func_78790_a(-1.0f, -12.0f, -1.0f, 2, 24, 2, 0.0f);
        this.setRotateAngle(this.spike5, 0.0f, 0.0f, 0.43633232f);
        this.head5 = new ModelRenderer((ModelBase)this, 28, 0);
        this.head5.func_78793_a(0.0f, 14.0f, -6.0f);
        this.head5.func_78790_a(2.0f, -4.0f, -9.0f, 2, 2, 3, 0.0f);
        this.spike3 = new ModelRenderer((ModelBase)this, 18, 27);
        this.spike3.func_78793_a(0.0f, 11.0f, -1.5f);
        this.spike3.func_78790_a(-1.0f, -12.0f, -1.0f, 2, 24, 2, 0.0f);
        this.setRotateAngle(this.spike3, 0.0f, 0.0f, -0.43633232f);
        this.spike4 = new ModelRenderer((ModelBase)this, 0, 27);
        this.spike4.func_78793_a(0.0f, 11.0f, -1.5f);
        this.spike4.func_78790_a(-2.0f, -8.0f, -2.0f, 4, 16, 4, 0.0f);
        this.setRotateAngle(this.spike4, 0.0f, 0.0f, -0.43633232f);
        this.legbr = new ModelRenderer((ModelBase)this, 0, 11);
        this.legbr.func_78793_a(-3.5f, 14.0f, 7.0f);
        this.legbr.func_78790_a(-2.0f, 0.0f, -2.0f, 4, 10, 4, 0.0f);
        this.body = new ModelRenderer((ModelBase)this, 28, 8);
        this.body.func_78793_a(0.0f, 9.5f, 1.0f);
        this.body.func_78790_a(-5.0f, -10.0f, -7.0f, 10, 16, 8, 0.0f);
        this.setRotateAngle(this.body, 1.5707964f, 0.0f, 0.0f);
        this.spike7 = new ModelRenderer((ModelBase)this, 0, 27);
        this.spike7.func_78793_a(0.0f, 11.0f, 3.0f);
        this.spike7.func_78790_a(-2.0f, -8.0f, -2.0f, 4, 16, 4, 0.0f);
        this.setRotateAngle(this.spike7, 0.0f, 0.0f, 0.87266463f);
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        GlStateManager.func_179147_l();
        GlStateManager.func_179112_b((int)770, (int)771);
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)0.9f);
        this.spike9.func_78785_a(f5);
        this.head.func_78785_a(f5);
        this.spike2.func_78785_a(f5);
        this.spike8.func_78785_a(f5);
        this.legbl.func_78785_a(f5);
        this.legfl.func_78785_a(f5);
        this.legfr.func_78785_a(f5);
        this.head4.func_78785_a(f5);
        this.spike6.func_78785_a(f5);
        this.spike10.func_78785_a(f5);
        this.head3.func_78785_a(f5);
        this.head2.func_78785_a(f5);
        this.spike.func_78785_a(f5);
        this.spike5.func_78785_a(f5);
        this.head5.func_78785_a(f5);
        this.spike3.func_78785_a(f5);
        this.spike4.func_78785_a(f5);
        this.legbr.func_78785_a(f5);
        this.body.func_78785_a(f5);
        this.spike7.func_78785_a(f5);
        GlStateManager.func_179084_k();
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.head.field_78795_f = headPitch * ((float)Math.PI / 180);
        this.head.field_78796_g = netHeadYaw * ((float)Math.PI / 180);
        this.head2.field_78795_f = headPitch * ((float)Math.PI / 180);
        this.head2.field_78796_g = netHeadYaw * ((float)Math.PI / 180);
        this.head3.field_78795_f = headPitch * ((float)Math.PI / 180);
        this.head3.field_78796_g = netHeadYaw * ((float)Math.PI / 180);
        this.head4.field_78795_f = headPitch * ((float)Math.PI / 180);
        this.head4.field_78796_g = netHeadYaw * ((float)Math.PI / 180);
        this.head5.field_78795_f = headPitch * ((float)Math.PI / 180);
        this.head5.field_78796_g = netHeadYaw * ((float)Math.PI / 180);
        this.legbr.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f)) * 1.4f * limbSwingAmount;
        this.legbl.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f + (float)Math.PI)) * 1.4f * limbSwingAmount;
        this.legfr.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f + (float)Math.PI)) * 1.4f * limbSwingAmount;
        this.legfl.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f)) * 1.4f * limbSwingAmount;
        this.spike.field_78808_h = Mth.func_76134_b((float)((float)((double)(ageInTicks * 0.05f) + 2.0943951023931953)));
        this.spike2.field_78808_h = Mth.func_76134_b((float)((float)((double)(ageInTicks * 0.05f) + 2.0943951023931953)));
        this.spike3.field_78808_h = Mth.func_76134_b((float)((float)((double)(ageInTicks * 0.05f) + Math.PI)));
        this.spike4.field_78808_h = Mth.func_76134_b((float)((float)((double)(ageInTicks * 0.05f) + Math.PI)));
        this.spike9.field_78808_h = Mth.func_76134_b((float)((float)((double)(ageInTicks * 0.05f) + 4.1887902047863905)));
        this.spike10.field_78808_h = Mth.func_76134_b((float)((float)((double)(ageInTicks * 0.05f) + 4.1887902047863905)));
        this.spike5.field_78808_h = Mth.func_76134_b((float)((float)((double)(ageInTicks * 0.05f) + 1.0471975511965976)));
        this.spike6.field_78808_h = Mth.func_76134_b((float)((float)((double)(ageInTicks * 0.05f) + 1.0471975511965976)));
        this.spike7.field_78808_h = Mth.func_76134_b((float)(ageInTicks * 0.05f));
        this.spike8.field_78808_h = Mth.func_76134_b((float)(ageInTicks * 0.05f));
    }
}

