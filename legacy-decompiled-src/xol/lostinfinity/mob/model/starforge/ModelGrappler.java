/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.model.ModelRenderer
 *  net.minecraft.entity.Entity
 */
package xol.lostinfinity.mob.model.starforge;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.world.entity.Entity;

public class ModelGrappler
extends ModelBase {
    public ModelRenderer eye;
    public ModelRenderer leg1;
    public ModelRenderer leg2;
    public ModelRenderer leg3;
    public ModelRenderer leg6;
    public ModelRenderer leg5;
    public ModelRenderer leg4;
    public ModelRenderer leg8;
    public ModelRenderer leg9;
    public ModelRenderer leg7;
    public ModelRenderer eye2;

    public ModelGrappler() {
        this.field_78090_t = 64;
        this.field_78089_u = 32;
        this.leg2 = new ModelRenderer((ModelBase)this, 32, 0);
        this.leg2.func_78793_a(0.0f, 0.0f, 0.0f);
        this.leg2.func_78790_a(-3.0f, -7.0f, -3.0f, 6, 2, 6, 0.0f);
        this.leg3 = new ModelRenderer((ModelBase)this, 34, 22);
        this.leg3.func_78793_a(0.0f, 0.0f, 0.0f);
        this.leg3.func_78790_a(-2.0f, 8.0f, -4.0f, 4, 2, 6, 0.0f);
        this.leg8 = new ModelRenderer((ModelBase)this, 0, 17);
        this.leg8.func_78793_a(0.0f, 0.0f, 0.0f);
        this.leg8.func_78790_a(-1.5f, 4.5f, -2.5f, 3, 3, 5, 0.0f);
        this.leg6 = new ModelRenderer((ModelBase)this, 22, 27);
        this.leg6.func_78793_a(0.0f, 0.0f, 0.0f);
        this.leg6.func_78790_a(-3.0f, 9.0f, -6.0f, 1, 1, 3, 0.0f);
        this.leg1 = new ModelRenderer((ModelBase)this, 34, 9);
        this.leg1.func_78793_a(0.0f, 0.0f, 0.0f);
        this.leg1.func_78790_a(-2.0f, 0.0f, -2.0f, 4, 8, 4, 0.0f);
        this.leg4 = new ModelRenderer((ModelBase)this, 33, 23);
        this.leg4.func_78793_a(0.0f, 0.0f, 0.0f);
        this.leg4.func_78790_a(0.5f, 9.0f, -6.0f, 1, 1, 2, 0.0f);
        this.leg9 = new ModelRenderer((ModelBase)this, 0, 25);
        this.leg9.func_78793_a(0.0f, 0.0f, 0.0f);
        this.leg9.func_78790_a(-2.5f, 1.0f, -1.5f, 5, 3, 3, 0.0f);
        this.eye2 = new ModelRenderer((ModelBase)this, 18, 18);
        this.eye2.func_78793_a(0.0f, 0.0f, 0.0f);
        this.eye2.func_78790_a(-3.0f, -7.0f, -4.5f, 6, 6, 1, 0.0f);
        this.leg5 = new ModelRenderer((ModelBase)this, 33, 23);
        this.leg5.func_78793_a(0.0f, 0.0f, 0.0f);
        this.leg5.func_78790_a(-1.5f, 9.0f, -6.0f, 1, 1, 2, 0.0f);
        this.eye = new ModelRenderer((ModelBase)this, 0, 0);
        this.eye.func_78793_a(0.0f, 14.0f, 0.0f);
        this.eye.func_78790_a(-4.0f, -8.0f, -4.0f, 8, 8, 8, 0.0f);
        this.leg7 = new ModelRenderer((ModelBase)this, 22, 27);
        this.leg7.func_78793_a(0.0f, 0.0f, 0.0f);
        this.leg7.func_78790_a(2.0f, 9.0f, -6.0f, 1, 1, 3, 0.0f);
        this.eye.func_78792_a(this.leg2);
        this.eye.func_78792_a(this.leg3);
        this.eye.func_78792_a(this.leg8);
        this.eye.func_78792_a(this.leg6);
        this.eye.func_78792_a(this.leg1);
        this.eye.func_78792_a(this.leg4);
        this.eye.func_78792_a(this.leg9);
        this.eye.func_78792_a(this.eye2);
        this.eye.func_78792_a(this.leg5);
        this.eye.func_78792_a(this.leg7);
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.eye.func_78785_a(f5);
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        double x = entityIn.field_70159_w;
        double y = entityIn.field_70181_x;
        double z = entityIn.field_70179_y;
        double x_angle = Math.acos(x / Math.sqrt(x * x + y * y + z * z));
        double y_angle = Math.acos(y / Math.sqrt(x * x + y * y + z * z));
        double z_angle = Math.acos(z / Math.sqrt(x * x + y * y + z * z));
        this.eye.field_78808_h = (float)z_angle;
        this.eye.field_78795_f = (float)(y_angle + 1.5707963267948966);
        this.eye.field_78796_g = (float)x_angle;
    }
}

