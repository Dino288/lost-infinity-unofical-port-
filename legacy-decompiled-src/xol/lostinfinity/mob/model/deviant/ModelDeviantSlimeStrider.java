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
package xol.lostinfinity.mob.model.deviant;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;

public class ModelDeviantSlimeStrider
extends ModelBase {
    public ModelRenderer head2;
    public ModelRenderer head1;
    public ModelRenderer body;
    public ModelRenderer armr2;
    public ModelRenderer armr3;
    public ModelRenderer armr4;
    public ModelRenderer armr5;
    public ModelRenderer armr7;
    public ModelRenderer armr6;
    public ModelRenderer armr8;
    public ModelRenderer armr1;
    public ModelRenderer arml1;
    public ModelRenderer arml2;
    public ModelRenderer arml3;
    public ModelRenderer arml5;
    public ModelRenderer arml7;
    public ModelRenderer arml4;
    public ModelRenderer arml6;
    public ModelRenderer arml8;
    public ModelRenderer tail1;
    public ModelRenderer tail2;
    public ModelRenderer tail3;
    public ModelRenderer arml9;
    public ModelRenderer arml10;
    public ModelRenderer arml11;
    public ModelRenderer arml12;
    public ModelRenderer armr9;
    public ModelRenderer armr10;
    public ModelRenderer armr11;
    public ModelRenderer armr12;
    public ModelRenderer body2;

    public ModelDeviantSlimeStrider() {
        this.field_78090_t = 64;
        this.field_78089_u = 64;
        this.arml3 = new ModelRenderer((ModelBase)this, 0, 32);
        this.arml3.func_78793_a(3.0f, 20.5f, 5.5f);
        this.arml3.func_78790_a(0.0f, -1.0f, -1.0f, 3, 2, 2, 0.0f);
        this.arml1 = new ModelRenderer((ModelBase)this, 0, 32);
        this.arml1.func_78793_a(3.0f, 20.5f, -0.5f);
        this.arml1.func_78790_a(0.0f, -1.0f, -1.0f, 3, 2, 2, 0.0f);
        this.armr2 = new ModelRenderer((ModelBase)this, 0, 38);
        this.armr2.func_78793_a(-3.0f, 20.5f, -0.5f);
        this.armr2.func_78790_a(-8.0f, -1.5f, -2.5f, 5, 3, 5, 0.0f);
        this.arml11 = new ModelRenderer((ModelBase)this, 32, 48);
        this.arml11.func_78793_a(3.0f, 20.5f, 11.5f);
        this.arml11.func_78790_a(3.0f, -4.5f, -2.5f, 1, 3, 5, 0.0f);
        this.arml8 = new ModelRenderer((ModelBase)this, 0, 38);
        this.arml8.func_78793_a(3.0f, 20.5f, 17.5f);
        this.arml8.func_78790_a(3.0f, -1.5f, -2.5f, 5, 3, 5, 0.0f);
        this.arml6 = new ModelRenderer((ModelBase)this, 0, 38);
        this.arml6.func_78793_a(3.0f, 20.5f, 11.5f);
        this.arml6.func_78790_a(3.0f, -1.5f, -2.5f, 5, 3, 5, 0.0f);
        this.armr3 = new ModelRenderer((ModelBase)this, 0, 32);
        this.armr3.func_78793_a(-3.0f, 20.5f, 5.5f);
        this.armr3.func_78790_a(-3.0f, -1.0f, -1.0f, 3, 2, 2, 0.0f);
        this.armr11 = new ModelRenderer((ModelBase)this, 0, 48);
        this.armr11.func_78793_a(-3.0f, 20.5f, 11.5f);
        this.armr11.func_78790_a(-4.0f, -4.5f, -2.5f, 1, 3, 5, 0.0f);
        this.armr12 = new ModelRenderer((ModelBase)this, 0, 48);
        this.armr12.func_78793_a(-3.0f, 20.5f, 17.5f);
        this.armr12.func_78790_a(-4.0f, -4.5f, -2.5f, 1, 3, 5, 0.0f);
        this.armr6 = new ModelRenderer((ModelBase)this, 0, 38);
        this.armr6.func_78793_a(-3.0f, 20.5f, 11.5f);
        this.armr6.func_78790_a(-8.0f, -1.5f, -2.5f, 5, 3, 5, 0.0f);
        this.tail3 = new ModelRenderer((ModelBase)this, 35, 40);
        this.tail3.func_78793_a(0.0f, 19.0f, -2.0f);
        this.tail3.func_78790_a(-4.0f, 1.5f, 25.0f, 8, 1, 1, 0.0f);
        this.armr9 = new ModelRenderer((ModelBase)this, 0, 48);
        this.armr9.func_78793_a(-3.0f, 20.5f, -0.5f);
        this.armr9.func_78790_a(-4.0f, -4.5f, -2.5f, 1, 3, 5, 0.0f);
        this.armr5 = new ModelRenderer((ModelBase)this, 0, 32);
        this.armr5.func_78793_a(-3.0f, 20.5f, 11.5f);
        this.armr5.func_78790_a(-3.0f, -1.0f, -1.0f, 3, 2, 2, 0.0f);
        this.head2 = new ModelRenderer((ModelBase)this, 0, 0);
        this.head2.field_78809_i = true;
        this.head2.func_78793_a(3.2f, 19.0f, -2.0f);
        this.head2.func_78790_a(-3.0f, -1.5f, -8.5f, 4, 6, 8, 0.0f);
        this.arml2 = new ModelRenderer((ModelBase)this, 0, 38);
        this.arml2.func_78793_a(3.0f, 20.5f, -0.5f);
        this.arml2.func_78790_a(3.0f, -1.5f, -2.5f, 5, 3, 5, 0.0f);
        this.armr4 = new ModelRenderer((ModelBase)this, 0, 38);
        this.armr4.func_78793_a(-3.0f, 20.5f, 5.5f);
        this.armr4.func_78790_a(-8.0f, -1.5f, -2.5f, 5, 3, 5, 0.0f);
        this.arml4 = new ModelRenderer((ModelBase)this, 0, 38);
        this.arml4.func_78793_a(3.0f, 20.5f, 5.5f);
        this.arml4.func_78790_a(3.0f, -1.5f, -2.5f, 5, 3, 5, 0.0f);
        this.arml12 = new ModelRenderer((ModelBase)this, 32, 48);
        this.arml12.func_78793_a(3.0f, 20.5f, 17.5f);
        this.arml12.func_78790_a(3.0f, -4.5f, -2.5f, 1, 3, 5, 0.0f);
        this.armr7 = new ModelRenderer((ModelBase)this, 0, 32);
        this.armr7.func_78793_a(-3.0f, 20.5f, 17.5f);
        this.armr7.func_78790_a(-3.0f, -1.0f, -1.0f, 3, 2, 2, 0.0f);
        this.arml5 = new ModelRenderer((ModelBase)this, 0, 32);
        this.arml5.func_78793_a(3.0f, 20.5f, 11.5f);
        this.arml5.func_78790_a(0.0f, -1.0f, -1.0f, 3, 2, 2, 0.0f);
        this.arml7 = new ModelRenderer((ModelBase)this, 0, 32);
        this.arml7.func_78793_a(3.0f, 20.5f, 17.5f);
        this.arml7.func_78790_a(0.0f, -1.0f, -1.0f, 3, 2, 2, 0.0f);
        this.tail2 = new ModelRenderer((ModelBase)this, 35, 40);
        this.tail2.func_78793_a(0.0f, 19.0f, -2.0f);
        this.tail2.func_78790_a(-4.0f, 1.5f, 22.5f, 8, 1, 1, 0.0f);
        this.arml10 = new ModelRenderer((ModelBase)this, 32, 48);
        this.arml10.func_78793_a(3.0f, 20.5f, 5.5f);
        this.arml10.func_78790_a(3.0f, -4.5f, -2.5f, 1, 3, 5, 0.0f);
        this.armr10 = new ModelRenderer((ModelBase)this, 0, 48);
        this.armr10.func_78793_a(-3.0f, 20.5f, 5.5f);
        this.armr10.func_78790_a(-4.0f, -4.5f, -2.5f, 1, 3, 5, 0.0f);
        this.body = new ModelRenderer((ModelBase)this, 7, 38);
        this.body.func_78793_a(0.0f, 19.0f, -2.0f);
        this.body.func_78790_a(-1.0f, -4.0f, -0.5f, 1, 4, 22, 0.0f);
        this.armr1 = new ModelRenderer((ModelBase)this, 0, 32);
        this.armr1.func_78793_a(-3.0f, 20.5f, -0.5f);
        this.armr1.func_78790_a(-3.0f, -1.0f, -1.0f, 3, 2, 2, 0.0f);
        this.body2 = new ModelRenderer((ModelBase)this, 6, 0);
        this.body2.func_78793_a(0.0f, 19.0f, -2.0f);
        this.body2.func_78790_a(-3.0f, 0.0f, -0.5f, 6, 4, 22, 0.0f);
        this.tail1 = new ModelRenderer((ModelBase)this, 18, 28);
        this.tail1.func_78793_a(0.0f, 19.0f, -2.0f);
        this.tail1.func_78790_a(-2.0f, 0.5f, 21.5f, 4, 3, 6, 0.0f);
        this.arml9 = new ModelRenderer((ModelBase)this, 32, 48);
        this.arml9.func_78793_a(3.0f, 20.5f, -0.5f);
        this.arml9.func_78790_a(3.0f, -4.5f, -2.5f, 1, 3, 5, 0.0f);
        this.head1 = new ModelRenderer((ModelBase)this, 0, 0);
        this.head1.func_78793_a(-1.0f, 19.0f, -2.0f);
        this.head1.func_78790_a(-3.0f, -1.5f, -8.5f, 4, 6, 8, 0.0f);
        this.armr8 = new ModelRenderer((ModelBase)this, 0, 38);
        this.armr8.func_78793_a(-3.0f, 20.5f, 17.5f);
        this.armr8.func_78790_a(-8.0f, -1.5f, -2.5f, 5, 3, 5, 0.0f);
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        GlStateManager.func_179147_l();
        GlStateManager.func_179112_b((int)770, (int)771);
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)0.85f);
        this.arml3.func_78785_a(f5);
        this.arml1.func_78785_a(f5);
        this.armr2.func_78785_a(f5);
        this.arml11.func_78785_a(f5);
        this.arml8.func_78785_a(f5);
        this.arml6.func_78785_a(f5);
        this.armr3.func_78785_a(f5);
        this.armr11.func_78785_a(f5);
        this.armr12.func_78785_a(f5);
        this.armr6.func_78785_a(f5);
        this.tail3.func_78785_a(f5);
        this.armr9.func_78785_a(f5);
        this.armr5.func_78785_a(f5);
        this.head2.func_78785_a(f5);
        this.arml2.func_78785_a(f5);
        this.armr4.func_78785_a(f5);
        this.arml4.func_78785_a(f5);
        this.arml12.func_78785_a(f5);
        this.armr7.func_78785_a(f5);
        this.arml5.func_78785_a(f5);
        this.arml7.func_78785_a(f5);
        this.tail2.func_78785_a(f5);
        this.arml10.func_78785_a(f5);
        this.armr10.func_78785_a(f5);
        this.body.func_78785_a(f5);
        this.armr1.func_78785_a(f5);
        this.body2.func_78785_a(f5);
        this.tail1.func_78785_a(f5);
        this.arml9.func_78785_a(f5);
        this.head1.func_78785_a(f5);
        this.armr8.func_78785_a(f5);
        GlStateManager.func_179084_k();
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        float f8 = Math.abs(Mth.func_76126_a((float)(limbSwing * 0.6662f + (float)Math.PI)) * 0.4f) * limbSwingAmount;
        this.arml1.field_78808_h = 0.58119464f + f8;
        this.arml2.field_78808_h = 0.58119464f + f8;
        this.arml3.field_78808_h = 0.58119464f + f8;
        this.arml4.field_78808_h = 0.58119464f + f8;
        this.arml5.field_78808_h = 0.58119464f + f8;
        this.arml6.field_78808_h = 0.58119464f + f8;
        this.arml7.field_78808_h = 0.58119464f + f8;
        this.arml8.field_78808_h = 0.58119464f + f8;
        this.arml9.field_78808_h = 0.58119464f + f8;
        this.arml10.field_78808_h = 0.58119464f + f8;
        this.arml11.field_78808_h = 0.58119464f + f8;
        this.arml12.field_78808_h = 0.58119464f + f8;
        this.armr1.field_78808_h = -this.arml1.field_78808_h;
        this.armr2.field_78808_h = -this.arml1.field_78808_h;
        this.armr3.field_78808_h = -this.arml1.field_78808_h;
        this.armr4.field_78808_h = -this.arml1.field_78808_h;
        this.armr5.field_78808_h = -this.arml1.field_78808_h;
        this.armr6.field_78808_h = -this.arml1.field_78808_h;
        this.armr7.field_78808_h = -this.arml1.field_78808_h;
        this.armr8.field_78808_h = -this.arml1.field_78808_h;
        this.armr9.field_78808_h = -this.arml1.field_78808_h;
        this.armr10.field_78808_h = -this.arml1.field_78808_h;
        this.armr11.field_78808_h = -this.arml1.field_78808_h;
        this.armr12.field_78808_h = -this.arml1.field_78808_h;
        this.arml1.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.1162f)) * 0.9f * limbSwingAmount;
        this.arml2.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.1162f)) * 0.9f * limbSwingAmount;
        this.arml3.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.1162f)) * 0.9f * limbSwingAmount;
        this.arml4.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.1162f)) * 0.9f * limbSwingAmount;
        this.arml5.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.1162f)) * 0.9f * limbSwingAmount;
        this.arml6.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.1162f)) * 0.9f * limbSwingAmount;
        this.arml7.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.1162f)) * 0.9f * limbSwingAmount;
        this.arml8.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.1162f)) * 0.9f * limbSwingAmount;
        this.arml9.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.1162f)) * 0.9f * limbSwingAmount;
        this.arml10.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.1162f)) * 0.9f * limbSwingAmount;
        this.arml11.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.1162f)) * 0.9f * limbSwingAmount;
        this.arml12.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.1162f)) * 0.9f * limbSwingAmount;
        this.armr1.field_78795_f = -this.arml1.field_78795_f;
        this.armr2.field_78795_f = -this.arml1.field_78795_f;
        this.armr3.field_78795_f = -this.arml1.field_78795_f;
        this.armr4.field_78795_f = -this.arml1.field_78795_f;
        this.armr5.field_78795_f = -this.arml1.field_78795_f;
        this.armr6.field_78795_f = -this.arml1.field_78795_f;
        this.armr7.field_78795_f = -this.arml1.field_78795_f;
        this.armr8.field_78795_f = -this.arml1.field_78795_f;
        this.armr9.field_78795_f = -this.arml1.field_78795_f;
        this.armr10.field_78795_f = -this.arml1.field_78795_f;
        this.armr11.field_78795_f = -this.arml1.field_78795_f;
        this.armr12.field_78795_f = -this.arml1.field_78795_f;
        this.head1.field_78796_g = Mth.func_76134_b((float)(ageInTicks * 0.1f)) * (float)Math.PI * 0.03f + 0.1f;
        this.head2.field_78796_g = -this.head1.field_78796_g;
    }
}

