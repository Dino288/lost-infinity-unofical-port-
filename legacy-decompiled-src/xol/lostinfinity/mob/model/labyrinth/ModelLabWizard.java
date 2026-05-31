/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.model.ModelRenderer
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.math.Mth
 */
package xol.lostinfinity.mob.model.labyrinth;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;

public class ModelLabWizard
extends ModelBase {
    public ModelRenderer armr;
    public ModelRenderer legr;
    public ModelRenderer head1;
    public ModelRenderer body;
    public ModelRenderer arml;
    public ModelRenderer legl;
    public ModelRenderer head2;
    public ModelRenderer head3;
    public ModelRenderer head4;
    public ModelRenderer body2;
    public ModelRenderer body3;
    public ModelRenderer staff1;
    public ModelRenderer staff2;
    public ModelRenderer staff3;

    public ModelLabWizard() {
        this.field_78090_t = 64;
        this.field_78089_u = 64;
        this.armr = new ModelRenderer((ModelBase)this, 48, 16);
        this.armr.func_78793_a(-6.0f, 3.0f, -2.0f);
        this.armr.func_78790_a(-3.0f, -2.0f, -2.0f, 4, 12, 4, 0.0f);
        this.head4 = new ModelRenderer((ModelBase)this, 48, 0);
        this.head4.func_78793_a(0.0f, -2.0f, -5.0f);
        this.head4.func_78790_a(-2.0f, 3.0f, -2.0f, 4, 4, 4, 0.0f);
        this.legr = new ModelRenderer((ModelBase)this, 0, 16);
        this.legr.func_78793_a(-2.5f, 12.0f, 0.1f);
        this.legr.func_78790_a(-2.0f, 0.0f, -2.0f, 4, 12, 4, 0.0f);
        this.staff1 = new ModelRenderer((ModelBase)this, 40, 34);
        this.staff1.func_78793_a(-6.0f, 3.0f, -2.0f);
        this.staff1.func_78790_a(-2.0f, -7.0f, -7.0f, 2, 16, 2, 0.0f);
        this.setRotateAngle(this.staff1, 0.6981317f, 0.0f, 0.0f);
        this.body = new ModelRenderer((ModelBase)this, 16, 16);
        this.body.func_78793_a(0.0f, 1.0f, -2.5f);
        this.body.func_78790_a(-5.0f, 0.0f, -2.0f, 10, 12, 4, 0.0f);
        this.setRotateAngle(this.body, 0.2617994f, 0.0f, 0.0f);
        this.legl = new ModelRenderer((ModelBase)this, 0, 16);
        this.legl.field_78809_i = true;
        this.legl.func_78793_a(2.5f, 12.0f, 0.1f);
        this.legl.func_78790_a(-2.0f, 0.0f, -2.0f, 4, 12, 4, 0.0f);
        this.head3 = new ModelRenderer((ModelBase)this, 16, 0);
        this.head3.func_78793_a(0.0f, -2.0f, -5.0f);
        this.head3.func_78790_a(-2.0f, -7.0f, -2.0f, 4, 4, 4, 0.0f);
        this.staff3 = new ModelRenderer((ModelBase)this, 50, 34);
        this.staff3.func_78793_a(-6.0f, 3.0f, -2.0f);
        this.staff3.func_78790_a(-2.0f, -10.0f, -7.0f, 2, 1, 2, 0.0f);
        this.setRotateAngle(this.staff3, 0.6981317f, 0.0f, 0.0f);
        this.staff2 = new ModelRenderer((ModelBase)this, 50, 34);
        this.staff2.func_78793_a(-6.0f, 3.0f, -2.0f);
        this.staff2.func_78790_a(-2.0f, -8.5f, -7.0f, 2, 1, 2, 0.0f);
        this.setRotateAngle(this.staff2, 0.6981317f, 0.0f, 0.0f);
        this.body2 = new ModelRenderer((ModelBase)this, 16, 34);
        this.body2.func_78793_a(0.0f, 1.0f, -2.5f);
        this.body2.func_78790_a(-3.0f, -4.0f, -1.0f, 2, 4, 2, 0.0f);
        this.setRotateAngle(this.body2, 0.2617994f, 0.0f, 0.0f);
        this.arml = new ModelRenderer((ModelBase)this, 48, 16);
        this.arml.field_78809_i = true;
        this.arml.func_78793_a(6.0f, 3.0f, -2.0f);
        this.arml.func_78790_a(-1.0f, -2.0f, -2.0f, 4, 12, 4, 0.0f);
        this.head1 = new ModelRenderer((ModelBase)this, 0, 0);
        this.head1.func_78793_a(0.0f, -2.0f, -5.0f);
        this.head1.func_78790_a(-7.0f, -2.0f, -2.0f, 4, 4, 4, 0.0f);
        this.head2 = new ModelRenderer((ModelBase)this, 32, 0);
        this.head2.func_78793_a(0.0f, -2.0f, -5.0f);
        this.head2.func_78790_a(3.0f, -2.0f, -2.0f, 4, 4, 4, 0.0f);
        this.body3 = new ModelRenderer((ModelBase)this, 16, 34);
        this.body3.func_78793_a(0.0f, 1.0f, -2.5f);
        this.body3.func_78790_a(1.0f, -4.0f, -1.0f, 2, 4, 2, 0.0f);
        this.setRotateAngle(this.body3, 0.2617994f, 0.0f, 0.0f);
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.armr.func_78785_a(f5);
        this.head4.func_78785_a(f5);
        this.legr.func_78785_a(f5);
        this.staff1.func_78785_a(f5);
        this.body.func_78785_a(f5);
        this.legl.func_78785_a(f5);
        this.head3.func_78785_a(f5);
        this.staff3.func_78785_a(f5);
        this.staff2.func_78785_a(f5);
        this.body2.func_78785_a(f5);
        this.arml.func_78785_a(f5);
        this.head1.func_78785_a(f5);
        this.head2.func_78785_a(f5);
        this.body3.func_78785_a(f5);
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.head1.field_78808_h = ageInTicks * 0.13333334f;
        this.head2.field_78808_h = ageInTicks * 0.13333334f;
        this.head3.field_78808_h = ageInTicks * 0.13333334f;
        this.head4.field_78808_h = ageInTicks * 0.13333334f;
        this.legr.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f)) * 1.4f * limbSwingAmount * 0.5f;
        this.legl.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f + (float)Math.PI)) * 1.4f * limbSwingAmount * 0.5f;
        this.armr.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f + (float)Math.PI)) * 2.0f * limbSwingAmount * 0.5f;
        this.staff1.field_78795_f = 0.6981317f + Mth.func_76134_b((float)(limbSwing * 0.6662f + (float)Math.PI)) * 2.0f * limbSwingAmount * 0.5f;
        this.staff2.field_78795_f = 0.6981317f + Mth.func_76134_b((float)(limbSwing * 0.6662f + (float)Math.PI)) * 2.0f * limbSwingAmount * 0.5f;
        this.staff3.field_78795_f = 0.6981317f + Mth.func_76134_b((float)(limbSwing * 0.6662f + (float)Math.PI)) * 2.0f * limbSwingAmount * 0.5f;
        this.arml.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f)) * 2.0f * limbSwingAmount * 0.5f;
    }
}

