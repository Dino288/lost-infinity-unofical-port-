/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.model.ModelBox
 *  net.minecraft.client.model.ModelRenderer
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.math.Mth
 */
package xol.lostinfinity.mob.model.starforge;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import xol.lostinfinity.mob.entity.starforge.EntityGrubber;

public class ModelGrubber
extends ModelBase {
    private final ModelRenderer head;
    private final ModelRenderer HeadCageRight;
    private final ModelRenderer HeadCageLeft;
    private final ModelRenderer body0;
    private final ModelRenderer body1;
    private final ModelRenderer leg0;
    private final ModelRenderer leg1;
    private final ModelRenderer leg2;
    private final ModelRenderer leg3;
    private final ModelRenderer leg4;
    private final ModelRenderer leg5;
    private final ModelRenderer leg6;
    private final ModelRenderer leg7;

    public ModelGrubber() {
        this.field_78090_t = 64;
        this.field_78089_u = 64;
        this.head = new ModelRenderer((ModelBase)this);
        this.head.func_78793_a(0.0f, 15.0f, -3.0f);
        this.head.field_78804_l.add(new ModelBox(this.head, 40, 5, -4.0f, -4.0f, -4.0f, 8, 8, 4, 0.0f, false));
        this.head.field_78804_l.add(new ModelBox(this.head, 32, 30, -5.0f, -3.0f, -2.0f, 1, 1, 15, 0.0f, false));
        this.head.field_78804_l.add(new ModelBox(this.head, 32, 30, 4.0f, -3.0f, -2.0f, 1, 1, 15, 0.0f, false));
        this.head.field_78804_l.add(new ModelBox(this.head, 32, 30, 4.0f, 0.0f, -2.0f, 1, 1, 15, 0.0f, false));
        this.head.field_78804_l.add(new ModelBox(this.head, 32, 30, -5.0f, 0.0f, -2.0f, 1, 1, 15, 0.0f, false));
        this.head.field_78804_l.add(new ModelBox(this.head, 1, 12, -3.0f, -3.0f, -5.0f, 6, 6, 1, 0.0f, false));
        this.HeadCageRight = new ModelRenderer((ModelBase)this);
        this.HeadCageRight.func_78793_a(-4.0f, 0.0f, -4.0f);
        this.head.func_78792_a(this.HeadCageRight);
        this.HeadCageRight.field_78804_l.add(new ModelBox(this.HeadCageRight, 1, 0, 0.0f, -4.0f, -3.0f, 4, 8, 3, 0.0f, true));
        this.HeadCageLeft = new ModelRenderer((ModelBase)this);
        this.HeadCageLeft.func_78793_a(4.0f, 0.0f, -4.0f);
        this.head.func_78792_a(this.HeadCageLeft);
        this.HeadCageLeft.field_78804_l.add(new ModelBox(this.HeadCageLeft, 1, 0, -4.0f, -4.0f, -3.0f, 4, 8, 3, 0.0f, false));
        this.body0 = new ModelRenderer((ModelBase)this);
        this.body0.func_78793_a(0.0f, 20.0f, 0.0f);
        this.body0.field_78804_l.add(new ModelBox(this.body0, 0, 4, -5.0f, -3.0f, -3.0f, 10, 6, 20, 0.0f, false));
        this.body0.field_78804_l.add(new ModelBox(this.body0, 0, 32, -4.0f, -19.0f, -1.0f, 8, 16, 16, 0.0f, false));
        this.body1 = new ModelRenderer((ModelBase)this);
        this.body1.func_78793_a(0.0f, 15.0f, 9.0f);
        this.leg0 = new ModelRenderer((ModelBase)this);
        this.leg0.func_78793_a(-4.0f, 19.0f, 11.0f);
        this.setRotationAngle(this.leg0, 0.0f, 0.7854f, -0.4363f);
        this.leg0.field_78804_l.add(new ModelBox(this.leg0, 18, 0, -15.0f, -1.0f, -1.0f, 16, 2, 2, 0.0f, true));
        this.leg1 = new ModelRenderer((ModelBase)this);
        this.leg1.func_78793_a(4.0f, 19.0f, 11.0f);
        this.setRotationAngle(this.leg1, 0.0f, -0.7854f, 0.4363f);
        this.leg1.field_78804_l.add(new ModelBox(this.leg1, 18, 0, -1.0f, -1.0f, -1.0f, 16, 2, 2, 0.0f, false));
        this.leg2 = new ModelRenderer((ModelBase)this);
        this.leg2.func_78793_a(-4.0f, 19.0f, 6.0f);
        this.setRotationAngle(this.leg2, 0.0f, 0.2618f, -0.4363f);
        this.leg2.field_78804_l.add(new ModelBox(this.leg2, 18, 0, -15.0f, -1.0f, -1.0f, 16, 2, 2, 0.0f, true));
        this.leg3 = new ModelRenderer((ModelBase)this);
        this.leg3.func_78793_a(4.0f, 19.0f, 6.0f);
        this.setRotationAngle(this.leg3, 0.0f, -0.2618f, 0.4363f);
        this.leg3.field_78804_l.add(new ModelBox(this.leg3, 18, 0, -1.0f, -1.0f, -1.0f, 16, 2, 2, 0.0f, false));
        this.leg4 = new ModelRenderer((ModelBase)this);
        this.leg4.func_78793_a(-4.0f, 19.0f, 2.0f);
        this.setRotationAngle(this.leg4, 0.0f, -0.2618f, -0.4363f);
        this.leg4.field_78804_l.add(new ModelBox(this.leg4, 18, 0, -15.0f, -1.0f, -1.0f, 16, 2, 2, 0.0f, true));
        this.leg5 = new ModelRenderer((ModelBase)this);
        this.leg5.func_78793_a(4.0f, 19.0f, 2.0f);
        this.setRotationAngle(this.leg5, 0.0f, 0.2618f, 0.4363f);
        this.leg5.field_78804_l.add(new ModelBox(this.leg5, 18, 0, -1.0f, -1.0f, -1.0f, 16, 2, 2, 0.0f, false));
        this.leg6 = new ModelRenderer((ModelBase)this);
        this.leg6.func_78793_a(-4.0f, 19.0f, -1.0f);
        this.setRotationAngle(this.leg6, 0.0f, -0.7854f, -0.4363f);
        this.leg6.field_78804_l.add(new ModelBox(this.leg6, 18, 0, -15.0f, -1.0f, -1.0f, 16, 2, 2, 0.0f, true));
        this.leg7 = new ModelRenderer((ModelBase)this);
        this.leg7.func_78793_a(4.0f, 19.0f, -1.0f);
        this.setRotationAngle(this.leg7, 0.0f, 0.7854f, 0.4363f);
        this.leg7.field_78804_l.add(new ModelBox(this.leg7, 18, 0, -1.0f, -1.0f, -1.0f, 16, 2, 2, 0.0f, false));
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.head.func_78785_a(f5);
        this.body0.func_78785_a(f5);
        this.body1.func_78785_a(f5);
        this.leg0.func_78785_a(f5);
        this.leg1.func_78785_a(f5);
        this.leg2.func_78785_a(f5);
        this.leg3.func_78785_a(f5);
        this.leg4.func_78785_a(f5);
        this.leg5.func_78785_a(f5);
        this.leg6.func_78785_a(f5);
        this.leg7.func_78785_a(f5);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        EntityGrubber grubber = (EntityGrubber)entityIn;
        if (grubber.isAwake()) {
            this.leg7.field_78808_h = 0.7853982f;
            this.leg6.field_78808_h = -0.7853982f;
            this.leg5.field_78808_h = 0.58119464f;
            this.leg4.field_78808_h = -0.58119464f;
            this.leg3.field_78808_h = 0.58119464f;
            this.leg2.field_78808_h = -0.58119464f;
            this.leg1.field_78808_h = 0.7853982f;
            this.leg0.field_78808_h = -0.7853982f;
            this.leg7.field_78796_g = 0.7853982f;
            this.leg6.field_78796_g = -0.7853982f;
            this.leg5.field_78796_g = 0.3926991f;
            this.leg4.field_78796_g = -0.3926991f;
            this.leg3.field_78796_g = -0.3926991f;
            this.leg2.field_78796_g = 0.3926991f;
            this.leg1.field_78796_g = -0.7853982f;
            this.leg0.field_78796_g = 0.7853982f;
            float f3 = -(Mth.func_76134_b((float)(limbSwing * 0.6662f * 2.0f + 0.0f)) * 0.4f) * limbSwingAmount;
            float f4 = -(Mth.func_76134_b((float)(limbSwing * 0.6662f * 2.0f + (float)Math.PI)) * 0.4f) * limbSwingAmount;
            float f5 = -(Mth.func_76134_b((float)(limbSwing * 0.6662f * 2.0f + 1.5707964f)) * 0.4f) * limbSwingAmount;
            float f6 = -(Mth.func_76134_b((float)(limbSwing * 0.6662f * 2.0f + 4.712389f)) * 0.4f) * limbSwingAmount;
            float f7 = Math.abs(Mth.func_76126_a((float)(limbSwing * 0.6662f + 0.0f)) * 0.4f) * limbSwingAmount;
            float f8 = Math.abs(Mth.func_76126_a((float)(limbSwing * 0.6662f + (float)Math.PI)) * 0.4f) * limbSwingAmount;
            float f9 = Math.abs(Mth.func_76126_a((float)(limbSwing * 0.6662f + 1.5707964f)) * 0.4f) * limbSwingAmount;
            float f10 = Math.abs(Mth.func_76126_a((float)(limbSwing * 0.6662f + 4.712389f)) * 0.4f) * limbSwingAmount;
            this.leg7.field_78796_g += f3;
            this.leg6.field_78796_g += -f3;
            this.leg5.field_78796_g += f4;
            this.leg4.field_78796_g += -f4;
            this.leg3.field_78796_g += f5;
            this.leg2.field_78796_g += -f5;
            this.leg1.field_78796_g += f6;
            this.leg0.field_78796_g += -f6;
            this.leg7.field_78808_h += f7;
            this.leg6.field_78808_h += -f7;
            this.leg5.field_78808_h += f8;
            this.leg4.field_78808_h += -f8;
            this.leg3.field_78808_h += f9;
            this.leg2.field_78808_h += -f9;
            this.leg1.field_78808_h += f10;
            this.leg0.field_78808_h += -f10;
        } else {
            this.leg3.field_78796_g = this.leg1.field_78796_g = 0.7f;
            this.leg5.field_78796_g = this.leg1.field_78796_g;
            this.leg7.field_78796_g = this.leg1.field_78796_g;
            this.leg0.field_78796_g = -this.leg1.field_78796_g;
            this.leg2.field_78796_g = -this.leg1.field_78796_g;
            this.leg4.field_78796_g = -this.leg1.field_78796_g;
            this.leg6.field_78796_g = -this.leg1.field_78796_g;
        }
        this.HeadCageRight.field_78796_g = grubber.getEyeCoverRot();
        this.HeadCageLeft.field_78796_g = -this.HeadCageRight.field_78796_g;
    }
}

