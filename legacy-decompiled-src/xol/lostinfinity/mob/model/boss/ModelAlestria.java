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

public class ModelAlestria
extends ModelBase {
    public ModelRenderer armr;
    public ModelRenderer legr;
    public ModelRenderer head;
    public ModelRenderer body;
    public ModelRenderer arml;
    public ModelRenderer legl;
    public ModelRenderer armr2;
    public ModelRenderer head2;
    public ModelRenderer head3;
    public ModelRenderer armr3;
    public ModelRenderer armr4;
    public ModelRenderer armr5;

    public ModelAlestria() {
        this.field_78090_t = 64;
        this.field_78089_u = 64;
        this.arml = new ModelRenderer((ModelBase)this, 40, 16);
        this.arml.field_78809_i = true;
        this.arml.func_78793_a(5.0f, 2.0f, 0.0f);
        this.arml.func_78790_a(-1.0f, -2.0f, -2.0f, 4, 12, 4, 0.0f);
        this.legl = new ModelRenderer((ModelBase)this, 0, 16);
        this.legl.field_78809_i = true;
        this.legl.func_78793_a(1.9f, 12.0f, 0.1f);
        this.legl.func_78790_a(-2.0f, 0.0f, -2.0f, 4, 12, 4, 0.0f);
        this.armr = new ModelRenderer((ModelBase)this, 40, 16);
        this.armr.func_78793_a(-5.0f, 2.0f, 0.0f);
        this.armr.func_78790_a(-3.0f, -2.0f, -2.0f, 4, 12, 4, 0.0f);
        this.body = new ModelRenderer((ModelBase)this, 16, 16);
        this.body.func_78793_a(0.0f, 0.0f, 0.0f);
        this.body.func_78790_a(-4.0f, 0.0f, -2.0f, 8, 12, 4, 0.0f);
        this.head2 = new ModelRenderer((ModelBase)this, 32, 0);
        this.head2.func_78793_a(0.0f, 0.0f, 0.0f);
        this.head2.func_78790_a(-4.0f, -11.0f, -4.0f, 3, 3, 3, 0.0f);
        this.legr = new ModelRenderer((ModelBase)this, 0, 16);
        this.legr.func_78793_a(-1.9f, 12.0f, 0.1f);
        this.legr.func_78790_a(-2.0f, 0.0f, -2.0f, 4, 12, 4, 0.0f);
        this.armr4 = new ModelRenderer((ModelBase)this, 39, 34);
        this.armr4.func_78793_a(-1.0f, -17.0f, -6.0f);
        this.armr4.func_78790_a(3.0f, 0.0f, -2.0f, 4, 4, 4, 0.0f);
        this.head3 = new ModelRenderer((ModelBase)this, 32, 0);
        this.head3.func_78793_a(0.0f, 0.0f, 0.0f);
        this.head3.func_78790_a(1.0f, -11.0f, -4.0f, 3, 3, 3, 0.0f);
        this.armr2 = new ModelRenderer((ModelBase)this, 56, 16);
        this.armr2.func_78793_a(-5.0f, 2.0f, 0.0f);
        this.armr2.func_78790_a(-2.0f, -18.0f, -7.0f, 2, 38, 2, 0.0f);
        this.setRotateAngle(this.armr2, 0.5235988f, 0.0f, 0.0f);
        this.head = new ModelRenderer((ModelBase)this, 0, 0);
        this.head.func_78793_a(0.0f, 0.0f, 0.0f);
        this.head.func_78790_a(-4.0f, -8.0f, -4.0f, 8, 8, 8, 0.0f);
        this.armr3 = new ModelRenderer((ModelBase)this, 39, 34);
        this.armr3.func_78793_a(-1.0f, -16.0f, -6.0f);
        this.armr3.func_78790_a(-7.0f, 3.0f, -2.0f, 4, 4, 4, 0.0f);
        this.armr5 = new ModelRenderer((ModelBase)this, 22, 34);
        this.armr5.func_78793_a(-1.0f, -15.0f, -6.0f);
        this.armr5.func_78790_a(-2.0f, 10.0f, -2.0f, 4, 2, 4, 0.0f);
        this.armr2.func_78792_a(this.armr4);
        this.armr2.func_78792_a(this.armr3);
        this.armr2.func_78792_a(this.armr5);
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.arml.func_78785_a(f5);
        this.legl.func_78785_a(f5);
        this.armr.func_78785_a(f5);
        this.body.func_78785_a(f5);
        this.head2.func_78785_a(f5);
        this.legr.func_78785_a(f5);
        this.head3.func_78785_a(f5);
        this.armr2.func_78785_a(f5);
        this.head.func_78785_a(f5);
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.head.field_78796_g = netHeadYaw * ((float)Math.PI / 180);
        this.head.field_78795_f = headPitch * ((float)Math.PI / 180);
        this.legr.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f)) * 1.4f * limbSwingAmount * 0.5f;
        this.legl.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f + (float)Math.PI)) * 1.4f * limbSwingAmount * 0.5f;
        this.arml.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f)) * 2.0f * limbSwingAmount * 0.5f;
        this.armr.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f + (float)Math.PI)) * 2.0f * limbSwingAmount * 0.5f;
        this.armr2.field_78795_f = 0.5235988f + this.armr.field_78795_f;
        this.armr3.field_78796_g = -ageInTicks * 0.1f;
        this.armr4.field_78796_g = ageInTicks * 0.1f;
        this.armr5.field_78796_g = ageInTicks * 0.5f;
    }
}

