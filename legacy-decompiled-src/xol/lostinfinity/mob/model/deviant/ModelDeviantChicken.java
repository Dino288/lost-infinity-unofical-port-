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

public class ModelDeviantChicken
extends ModelBase {
    public ModelRenderer head2;
    public ModelRenderer wingr;
    public ModelRenderer head3;
    public ModelRenderer legl;
    public ModelRenderer wingl;
    public ModelRenderer head;
    public ModelRenderer body;
    public ModelRenderer legr;
    public ModelRenderer wingr2;
    public ModelRenderer wingl2;
    public ModelRenderer wingr3;
    public ModelRenderer wingl3;
    public ModelRenderer fin1;
    public ModelRenderer fin2;
    public ModelRenderer fin3;
    public ModelRenderer fin4;
    public ModelRenderer fin5;

    public ModelDeviantChicken() {
        this.field_78090_t = 64;
        this.field_78089_u = 32;
        this.wingr3 = new ModelRenderer((ModelBase)this, 33, 5);
        this.wingr3.field_78809_i = true;
        this.wingr3.func_78793_a(-4.0f, 7.0f, 0.0f);
        this.wingr3.func_78790_a(0.0f, 4.0f, 1.0f, 1, 8, 2, 0.0f);
        this.wingr = new ModelRenderer((ModelBase)this, 24, 13);
        this.wingr.func_78793_a(-4.0f, 7.0f, 0.0f);
        this.wingr.func_78790_a(0.0f, 0.0f, -3.0f, 1, 4, 6, 0.0f);
        this.head3 = new ModelRenderer((ModelBase)this, 14, 0);
        this.head3.func_78793_a(0.0f, 11.0f, -4.0f);
        this.head3.func_78790_a(-2.0f, -4.0f, -4.0f, 4, 2, 2, 0.0f);
        this.body = new ModelRenderer((ModelBase)this, 0, 9);
        this.body.func_78793_a(0.0f, 10.0f, 0.0f);
        this.body.func_78790_a(-3.0f, -4.0f, -3.0f, 6, 8, 6, 0.0f);
        this.setRotateAngle(this.body, 1.5707964f, 0.0f, 0.0f);
        this.fin3 = new ModelRenderer((ModelBase)this, 45, 15);
        this.fin3.func_78793_a(0.0f, 10.0f, 0.0f);
        this.fin3.func_78790_a(-1.5f, -1.8f, -2.7f, 1, 6, 6, 0.0f);
        this.setRotateAngle(this.fin3, 0.7853982f, 0.0f, 0.0f);
        this.wingl2 = new ModelRenderer((ModelBase)this, 33, 5);
        this.wingl2.func_78793_a(4.0f, 7.0f, 0.0f);
        this.wingl2.func_78790_a(-1.0f, 4.0f, -3.0f, 1, 8, 2, 0.0f);
        this.wingr2 = new ModelRenderer((ModelBase)this, 33, 5);
        this.wingr2.field_78809_i = true;
        this.wingr2.func_78793_a(-4.0f, 7.0f, 0.0f);
        this.wingr2.func_78790_a(0.0f, 4.0f, -3.0f, 1, 8, 2, 0.0f);
        this.fin1 = new ModelRenderer((ModelBase)this, 45, 15);
        this.fin1.func_78793_a(0.0f, 10.0f, 0.0f);
        this.fin1.func_78790_a(-2.5f, -3.8f, -1.8f, 1, 6, 6, 0.0f);
        this.setRotateAngle(this.fin1, 0.7853982f, 0.0f, 0.0f);
        this.wingl3 = new ModelRenderer((ModelBase)this, 33, 5);
        this.wingl3.func_78793_a(4.0f, 7.0f, 0.0f);
        this.wingl3.func_78790_a(-1.0f, 4.0f, 1.0f, 1, 8, 2, 0.0f);
        this.legr = new ModelRenderer((ModelBase)this, 45, 0);
        this.legr.func_78793_a(-2.0f, 13.0f, 1.0f);
        this.legr.func_78790_a(-1.0f, 0.0f, -3.0f, 3, 11, 3, 0.0f);
        this.fin4 = new ModelRenderer((ModelBase)this, 45, 15);
        this.fin4.func_78793_a(0.0f, 10.0f, 0.0f);
        this.fin4.func_78790_a(-0.5f, -3.8f, -2.7f, 1, 6, 6, 0.0f);
        this.setRotateAngle(this.fin4, 0.7853982f, 0.0f, 0.0f);
        this.head2 = new ModelRenderer((ModelBase)this, 14, 4);
        this.head2.func_78793_a(0.0f, 11.0f, -4.0f);
        this.head2.func_78790_a(-1.0f, -2.0f, -3.0f, 2, 2, 2, 0.0f);
        this.legl = new ModelRenderer((ModelBase)this, 45, 0);
        this.legl.func_78793_a(1.0f, 13.0f, 1.0f);
        this.legl.func_78790_a(-1.0f, 0.0f, -3.0f, 3, 11, 3, 0.0f);
        this.head = new ModelRenderer((ModelBase)this, 0, 0);
        this.head.func_78793_a(0.0f, 11.0f, -4.0f);
        this.head.func_78790_a(-2.0f, -6.0f, -2.0f, 4, 6, 3, 0.0f);
        this.wingl = new ModelRenderer((ModelBase)this, 24, 13);
        this.wingl.func_78793_a(4.0f, 7.0f, 0.0f);
        this.wingl.func_78790_a(-1.0f, 0.0f, -3.0f, 1, 4, 6, 0.0f);
        this.fin2 = new ModelRenderer((ModelBase)this, 45, 15);
        this.fin2.func_78793_a(0.0f, 10.0f, 0.0f);
        this.fin2.func_78790_a(0.5f, -1.8f, -2.7f, 1, 6, 6, 0.0f);
        this.setRotateAngle(this.fin2, 0.7853982f, 0.0f, 0.0f);
        this.fin5 = new ModelRenderer((ModelBase)this, 45, 15);
        this.fin5.func_78793_a(0.0f, 10.0f, 0.0f);
        this.fin5.func_78790_a(1.5f, -3.8f, -1.8f, 1, 6, 6, 0.0f);
        this.setRotateAngle(this.fin5, 0.7853982f, 0.0f, 0.0f);
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.wingr3.func_78785_a(f5);
        this.wingr.func_78785_a(f5);
        this.head3.func_78785_a(f5);
        this.body.func_78785_a(f5);
        this.fin3.func_78785_a(f5);
        this.wingl2.func_78785_a(f5);
        this.wingr2.func_78785_a(f5);
        this.fin1.func_78785_a(f5);
        this.wingl3.func_78785_a(f5);
        this.legr.func_78785_a(f5);
        this.fin4.func_78785_a(f5);
        this.head2.func_78785_a(f5);
        this.legl.func_78785_a(f5);
        this.head.func_78785_a(f5);
        this.wingl.func_78785_a(f5);
        this.fin2.func_78785_a(f5);
        this.fin5.func_78785_a(f5);
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.head.field_78795_f = headPitch * ((float)Math.PI / 180);
        this.head.field_78796_g = netHeadYaw * ((float)Math.PI / 180);
        this.head2.field_78795_f = this.head.field_78795_f;
        this.head2.field_78796_g = this.head.field_78796_g;
        this.head3.field_78795_f = this.head.field_78795_f;
        this.head3.field_78796_g = this.head.field_78796_g;
        this.body.field_78795_f = 1.5707964f;
        this.legr.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f)) * 1.4f * limbSwingAmount;
        this.legl.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f + (float)Math.PI)) * 1.4f * limbSwingAmount;
        this.wingl.field_78808_h = Mth.func_76134_b((float)(ageInTicks * 0.1f)) * (float)Math.PI * 0.05f - 0.5f;
        this.wingr.field_78808_h = -this.wingl.field_78808_h;
        this.wingl2.field_78808_h = Mth.func_76134_b((float)(ageInTicks * 0.1f)) * (float)Math.PI * 0.05f - 0.5f;
        this.wingr2.field_78808_h = -this.wingl.field_78808_h;
        this.wingl2.field_78808_h = Mth.func_76134_b((float)(ageInTicks * 0.1f)) * (float)Math.PI * 0.05f - 0.5f;
        this.wingr2.field_78808_h = -this.wingl.field_78808_h;
        this.wingl3.field_78808_h = Mth.func_76134_b((float)(ageInTicks * 0.1f)) * (float)Math.PI * 0.05f - 0.5f;
        this.wingr3.field_78808_h = -this.wingl.field_78808_h;
    }
}

