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

public class ModelDeviantVex
extends ModelBase {
    public ModelRenderer wingl;
    public ModelRenderer armr;
    public ModelRenderer head;
    public ModelRenderer body;
    public ModelRenderer arml;
    public ModelRenderer wingr;
    public ModelRenderer head2;
    public ModelRenderer wingl2;
    public ModelRenderer wingr2;
    public ModelRenderer armr2;
    public ModelRenderer armr3;
    public ModelRenderer body2;

    public ModelDeviantVex() {
        this.field_78090_t = 64;
        this.field_78089_u = 64;
        this.head = new ModelRenderer((ModelBase)this, 0, 0);
        this.head.func_78793_a(0.0f, 0.0f, 0.0f);
        this.head.func_78790_a(-4.0f, -8.0f, -4.0f, 8, 8, 8, 0.0f);
        this.arml = new ModelRenderer((ModelBase)this, 44, 16);
        this.arml.field_78809_i = true;
        this.arml.func_78793_a(5.0f, 2.0f, 0.0f);
        this.arml.func_78790_a(-1.0f, -2.0f, -2.0f, 4, 12, 4, 0.0f);
        this.setRotateAngle(this.arml, 0.0f, 0.0f, -0.10000736f);
        this.body2 = new ModelRenderer((ModelBase)this, 0, 38);
        this.body2.func_78793_a(0.0f, -0.5f, -1.0f);
        this.body2.func_78790_a(-3.5f, 19.5f, -1.5f, 7, 4, 3, 0.0f);
        this.setRotateAngle(this.body2, 0.34906584f, 0.0f, 0.0f);
        this.wingr = new ModelRenderer((ModelBase)this, 0, 18);
        this.wingr.func_78793_a(0.0f, 1.0f, 0.0f);
        this.wingr.func_78790_a(-20.0f, 0.0f, 0.0f, 20, 10, 1, 0.0f);
        this.setRotateAngle(this.wingr, 0.43633232f, 0.62831855f, 0.0f);
        this.head2 = new ModelRenderer((ModelBase)this, 34, 2);
        this.head2.func_78793_a(0.0f, 0.0f, 0.0f);
        this.head2.func_78790_a(-4.0f, -8.0f, -4.5f, 8, 8, 1, -0.2f);
        this.wingl2 = new ModelRenderer((ModelBase)this, 0, 30);
        this.wingl2.field_78809_i = true;
        this.wingl2.func_78793_a(0.0f, 11.0f, 3.0f);
        this.wingl2.func_78790_a(0.0f, 0.0f, 0.0f, 20, 6, 1, 0.0f);
        this.setRotateAngle(this.wingl2, 0.43633232f, -0.62831855f, 0.0f);
        this.wingr2 = new ModelRenderer((ModelBase)this, 0, 30);
        this.wingr2.func_78793_a(0.0f, 11.0f, 3.0f);
        this.wingr2.func_78790_a(-20.0f, 0.0f, 0.0f, 20, 6, 1, 0.0f);
        this.setRotateAngle(this.wingr2, 0.43633232f, 0.62831855f, 0.0f);
        this.armr2 = new ModelRenderer((ModelBase)this, 0, 45);
        this.armr2.func_78793_a(-5.0f, 2.0f, 0.0f);
        this.armr2.func_78790_a(-2.0f, 7.0f, -18.0f, 2, 2, 16, 0.0f);
        this.setRotateAngle(this.armr2, 0.0f, 0.0f, 0.10000736f);
        this.body = new ModelRenderer((ModelBase)this, 39, 36);
        this.body.func_78793_a(0.0f, -0.5f, -1.0f);
        this.body.func_78790_a(-4.0f, 0.0f, -2.0f, 8, 23, 4, 0.0f);
        this.setRotateAngle(this.body, 0.34906584f, 0.0f, 0.0f);
        this.armr3 = new ModelRenderer((ModelBase)this, 20, 39);
        this.armr3.func_78793_a(-5.0f, 2.0f, 0.0f);
        this.armr3.func_78790_a(-2.0f, 1.0f, -18.0f, 1, 6, 8, 0.0f);
        this.setRotateAngle(this.armr3, 0.0f, 0.0f, 0.10000736f);
        this.wingl = new ModelRenderer((ModelBase)this, 0, 18);
        this.wingl.field_78809_i = true;
        this.wingl.func_78793_a(0.0f, 1.0f, 0.0f);
        this.wingl.func_78790_a(0.0f, 0.0f, 0.0f, 20, 10, 1, 0.0f);
        this.setRotateAngle(this.wingl, 0.43633232f, -0.62831855f, 0.0f);
        this.armr = new ModelRenderer((ModelBase)this, 44, 16);
        this.armr.func_78793_a(-5.0f, 2.0f, 0.0f);
        this.armr.func_78790_a(-3.0f, -2.0f, -2.0f, 4, 12, 4, 0.0f);
        this.setRotateAngle(this.armr, 0.0f, 0.0f, 0.10000736f);
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.head.func_78785_a(f5);
        this.arml.func_78785_a(f5);
        GlStateManager.func_179147_l();
        GlStateManager.func_179112_b((int)770, (int)771);
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)0.7f);
        this.body2.func_78785_a(f5);
        GlStateManager.func_179084_k();
        this.wingr.func_78785_a(f5);
        if (f2 % 6.0f >= 3.0f) {
            this.head2.func_78785_a(f5);
        }
        this.wingl2.func_78785_a(f5);
        this.wingr2.func_78785_a(f5);
        this.armr2.func_78785_a(f5);
        this.body.func_78785_a(f5);
        this.armr3.func_78785_a(f5);
        this.wingl.func_78785_a(f5);
        this.armr.func_78785_a(f5);
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.head.field_78796_g = netHeadYaw * ((float)Math.PI / 180);
        this.head.field_78795_f = headPitch * ((float)Math.PI / 180);
        this.head2.field_78796_g = netHeadYaw * ((float)Math.PI / 180);
        this.head2.field_78795_f = headPitch * ((float)Math.PI / 180);
        this.armr2.field_78795_f = this.armr.field_78795_f = -(Mth.func_76134_b((float)(ageInTicks * 0.1f)) * (float)Math.PI * 0.15f);
        this.armr3.field_78795_f = this.armr.field_78795_f;
        this.arml.field_78795_f = -this.armr.field_78795_f;
        this.wingl2.field_78796_g = this.wingl.field_78796_g = -((float)(0.7853981633974483 + (double)(Mth.func_76134_b((float)(ageInTicks * 0.4f)) * (float)Math.PI * 0.15f)));
        this.wingr.field_78796_g = -this.wingl.field_78796_g;
        this.wingr2.field_78796_g = -this.wingl.field_78796_g;
    }
}

