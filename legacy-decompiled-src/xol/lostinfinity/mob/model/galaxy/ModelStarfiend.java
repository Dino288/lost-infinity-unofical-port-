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
package xol.lostinfinity.mob.model.galaxy;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;

public class ModelStarfiend
extends ModelBase {
    public ModelRenderer armr;
    public ModelRenderer legr;
    public ModelRenderer body;
    public ModelRenderer arml;
    public ModelRenderer legl;
    public ModelRenderer head1;
    public ModelRenderer head2;
    public ModelRenderer head3;
    public ModelRenderer head4;
    public ModelRenderer head5;
    public ModelRenderer body2;
    public ModelRenderer body3;
    public ModelRenderer armr2;
    public ModelRenderer arml2;
    public ModelRenderer legl2;
    public ModelRenderer legr2;
    public ModelRenderer star;
    public ModelRenderer star2;
    public ModelRenderer star3;

    public ModelStarfiend() {
        this.field_78090_t = 64;
        this.field_78089_u = 64;
        this.head2 = new ModelRenderer((ModelBase)this, 0, 0);
        this.head2.func_78793_a(0.0f, 0.0f, 0.0f);
        this.head2.func_78790_a(-3.5f, -7.0f, -3.5f, 2, 4, 2, 0.0f);
        this.setRotateAngle(this.head2, 0.5235988f, 0.0f, 0.0f);
        this.head5 = new ModelRenderer((ModelBase)this, 3, 0);
        this.head5.func_78793_a(0.0f, 0.0f, 0.0f);
        this.head5.func_78790_a(-4.0f, -3.0f, -4.0f, 8, 3, 8, 0.0f);
        this.setRotateAngle(this.head5, 0.5235988f, 0.0f, 0.0f);
        this.head1 = new ModelRenderer((ModelBase)this, 0, 0);
        this.head1.func_78793_a(0.0f, 0.0f, 0.0f);
        this.head1.func_78790_a(1.5f, -7.0f, 1.5f, 2, 4, 2, 0.0f);
        this.setRotateAngle(this.head1, 0.5235988f, 0.0f, 0.0f);
        this.body2 = new ModelRenderer((ModelBase)this, 16, 16);
        this.body2.field_78809_i = true;
        this.body2.func_78793_a(0.0f, -1.0f, 1.0f);
        this.body2.func_78790_a(2.5f, 4.0f, -2.0f, 2, 12, 4, 0.0f);
        this.setRotateAngle(this.body2, 0.2617994f, 0.0f, 0.0f);
        this.legr = new ModelRenderer((ModelBase)this, 0, 16);
        this.legr.func_78793_a(-3.0f, 12.0f, 4.0f);
        this.legr.func_78790_a(-2.0f, 0.0f, -2.0f, 4, 12, 4, 0.0f);
        this.arml = new ModelRenderer((ModelBase)this, 40, 0);
        this.arml.func_78793_a(7.0f, 2.0f, 1.5f);
        this.arml.func_78790_a(-1.0f, -2.0f, -2.0f, 4, 12, 4, 0.0f);
        this.star = new ModelRenderer((ModelBase)this, 16, 48);
        this.star.func_78793_a(0.0f, 8.0f, 2.5f);
        this.star.func_78790_a(-2.5f, -2.5f, -0.5f, 5, 5, 1, 0.0f);
        this.setRotateAngle(this.star, 0.34906584f, 0.0f, 0.0f);
        this.legr2 = new ModelRenderer((ModelBase)this, 0, 35);
        this.legr2.func_78793_a(-3.0f, 12.0f, 4.0f);
        this.legr2.func_78790_a(-2.0f, 9.0f, -8.0f, 4, 3, 6, 0.0f);
        this.legl = new ModelRenderer((ModelBase)this, 0, 16);
        this.legl.field_78809_i = true;
        this.legl.func_78793_a(3.0f, 12.0f, 4.0f);
        this.legl.func_78790_a(-2.0f, 0.0f, -2.0f, 4, 12, 4, 0.0f);
        this.head3 = new ModelRenderer((ModelBase)this, 0, 0);
        this.head3.field_78809_i = true;
        this.head3.func_78793_a(0.0f, 0.0f, 0.0f);
        this.head3.func_78790_a(1.5f, -7.0f, -3.5f, 2, 4, 2, 0.0f);
        this.setRotateAngle(this.head3, 0.5235988f, 0.0f, 0.0f);
        this.body3 = new ModelRenderer((ModelBase)this, 22, 35);
        this.body3.func_78793_a(0.0f, -1.0f, 1.0f);
        this.body3.func_78790_a(-6.0f, 0.0f, -2.5f, 12, 6, 5, 0.0f);
        this.setRotateAngle(this.body3, 0.2617994f, 0.0f, 0.0f);
        this.body = new ModelRenderer((ModelBase)this, 16, 16);
        this.body.func_78793_a(0.0f, -1.0f, 1.0f);
        this.body.func_78790_a(-4.5f, 4.0f, -2.0f, 2, 12, 4, 0.0f);
        this.setRotateAngle(this.body, 0.2617994f, 0.0f, 0.0f);
        this.star3 = new ModelRenderer((ModelBase)this, 16, 48);
        this.star3.func_78793_a(0.0f, 8.0f, 2.5f);
        this.star3.func_78790_a(-2.5f, -2.5f, -0.5f, 5, 5, 1, 0.0f);
        this.setRotateAngle(this.star3, 0.34906584f, 0.0f, 4.1887903f);
        this.arml2 = new ModelRenderer((ModelBase)this, 40, 16);
        this.arml2.field_78809_i = true;
        this.arml2.func_78793_a(7.0f, 2.0f, 1.5f);
        this.arml2.func_78790_a(-1.0f, 10.0f, -2.0f, 4, 12, 4, 0.0f);
        this.star2 = new ModelRenderer((ModelBase)this, 16, 48);
        this.star2.func_78793_a(0.0f, 8.0f, 2.5f);
        this.star2.func_78790_a(-2.5f, -2.5f, -0.5f, 5, 5, 1, 0.0f);
        this.setRotateAngle(this.star2, 0.34906584f, 0.0f, 2.0943952f);
        this.armr2 = new ModelRenderer((ModelBase)this, 40, 16);
        this.armr2.func_78793_a(-7.0f, 2.0f, 1.5f);
        this.armr2.func_78790_a(-3.0f, 10.0f, -2.0f, 4, 12, 4, 0.0f);
        this.legl2 = new ModelRenderer((ModelBase)this, 0, 35);
        this.legl2.field_78809_i = true;
        this.legl2.func_78793_a(3.0f, 12.0f, 4.0f);
        this.legl2.func_78790_a(-2.0f, 9.0f, -8.0f, 4, 3, 6, 0.0f);
        this.head4 = new ModelRenderer((ModelBase)this, 0, 0);
        this.head4.field_78809_i = true;
        this.head4.func_78793_a(0.0f, 0.0f, 0.0f);
        this.head4.func_78790_a(-3.5f, -7.0f, 1.5f, 2, 4, 2, 0.0f);
        this.setRotateAngle(this.head4, 0.5235988f, 0.0f, 0.0f);
        this.armr = new ModelRenderer((ModelBase)this, 40, 0);
        this.armr.func_78793_a(-7.0f, 2.0f, 1.5f);
        this.armr.func_78790_a(-3.0f, -2.0f, -2.0f, 4, 12, 4, 0.0f);
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.armr.func_78785_a(f5);
        this.arml.func_78785_a(f5);
        this.head2.func_78785_a(f5);
        this.head1.func_78785_a(f5);
        this.legl.func_78785_a(f5);
        this.legl2.func_78785_a(f5);
        this.legr2.func_78785_a(f5);
        this.body.func_78785_a(f5);
        this.head5.func_78785_a(f5);
        this.legr.func_78785_a(f5);
        this.body3.func_78785_a(f5);
        this.head3.func_78785_a(f5);
        this.head4.func_78785_a(f5);
        this.arml2.func_78785_a(f5);
        this.armr2.func_78785_a(f5);
        this.body2.func_78785_a(f5);
        GlStateManager.func_179147_l();
        GlStateManager.func_179112_b((int)770, (int)771);
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)(0.3f + 0.6f * Mth.func_76126_a((float)(f2 * 0.1f))));
        this.star.func_78785_a(f5);
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)(0.3f + 0.6f * Mth.func_76126_a((float)((f2 + 20.0f) * 0.1f))));
        this.star2.func_78785_a(f5);
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)(0.3f + 0.6f * Mth.func_76126_a((float)((f2 + 40.0f) * 0.1f))));
        this.star3.func_78785_a(f5);
        GlStateManager.func_179084_k();
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.head1.field_78796_g = netHeadYaw * ((float)Math.PI / 180);
        this.head1.field_78795_f = headPitch * ((float)Math.PI / 180) + 0.5235988f;
        this.head2.field_78796_g = netHeadYaw * ((float)Math.PI / 180);
        this.head2.field_78795_f = headPitch * ((float)Math.PI / 180) + 0.5235988f;
        this.head3.field_78796_g = netHeadYaw * ((float)Math.PI / 180);
        this.head3.field_78795_f = headPitch * ((float)Math.PI / 180) + 0.5235988f;
        this.head4.field_78796_g = netHeadYaw * ((float)Math.PI / 180);
        this.head4.field_78795_f = headPitch * ((float)Math.PI / 180) + 0.5235988f;
        this.head5.field_78796_g = netHeadYaw * ((float)Math.PI / 180);
        this.head5.field_78795_f = headPitch * ((float)Math.PI / 180) + 0.5235988f;
        this.star.field_78808_h = ageInTicks * 0.02f;
        this.star2.field_78808_h = ageInTicks * 0.02f + 2.09f;
        this.star3.field_78808_h = ageInTicks * 0.02f + 4.11879f;
        this.legr.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f)) * 1.4f * limbSwingAmount * 0.5f;
        this.legl.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f + (float)Math.PI)) * 1.4f * limbSwingAmount * 0.5f;
        this.legr2.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f)) * 1.4f * limbSwingAmount * 0.5f;
        this.legl2.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f + (float)Math.PI)) * 1.4f * limbSwingAmount * 0.5f;
        this.armr.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f + (float)Math.PI)) * 2.0f * limbSwingAmount * 0.5f;
        this.arml.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f)) * 2.0f * limbSwingAmount * 0.5f;
        this.armr2.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f + (float)Math.PI)) * 2.0f * limbSwingAmount * 0.5f;
        this.arml2.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f)) * 2.0f * limbSwingAmount * 0.5f;
    }
}

