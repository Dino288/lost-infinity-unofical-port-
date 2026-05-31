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

public class ModelMinimite
extends ModelBase {
    private final ModelRenderer head;
    private final ModelRenderer pincerL;
    private final ModelRenderer pincerR;
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
    private final ModelRenderer shieldL;
    private final ModelRenderer body3_r1;
    private final ModelRenderer shieldR;
    private final ModelRenderer body4_r1;

    public ModelMinimite() {
        this.field_78090_t = 64;
        this.field_78089_u = 64;
        this.head = new ModelRenderer((ModelBase)this);
        this.head.func_78793_a(0.0f, 15.0f, -3.0f);
        this.head.field_78804_l.add(new ModelBox(this.head, 32, 4, -4.0f, -4.0f, -6.0f, 8, 8, 6, 0.0f, false));
        this.pincerL = new ModelRenderer((ModelBase)this);
        this.pincerL.func_78793_a(3.0f, 2.0f, -3.5f);
        this.head.func_78792_a(this.pincerL);
        this.pincerL.field_78804_l.add(new ModelBox(this.pincerL, 42, 22, -2.0f, -1.0f, -5.5f, 4, 2, 7, 0.0f, false));
        this.pincerR = new ModelRenderer((ModelBase)this);
        this.pincerR.func_78793_a(-3.0f, 2.0f, -3.5f);
        this.head.func_78792_a(this.pincerR);
        this.pincerR.field_78804_l.add(new ModelBox(this.pincerR, 42, 22, -2.0f, -1.0f, -5.5f, 4, 2, 7, 0.0f, true));
        this.body0 = new ModelRenderer((ModelBase)this);
        this.body0.func_78793_a(0.0f, 15.0f, 0.0f);
        this.body0.field_78804_l.add(new ModelBox(this.body0, 0, 4, -4.0f, -3.0f, -3.0f, 8, 6, 16, 0.0f, false));
        this.body1 = new ModelRenderer((ModelBase)this);
        this.body1.func_78793_a(0.0f, 15.0f, 9.0f);
        this.leg0 = new ModelRenderer((ModelBase)this);
        this.leg0.func_78793_a(-4.0f, 15.0f, 11.0f);
        this.setRotationAngle(this.leg0, 0.0f, 0.7854f, -0.7854f);
        this.leg0.field_78804_l.add(new ModelBox(this.leg0, 18, 0, -15.0f, -1.0f, -1.0f, 16, 2, 2, 0.0f, true));
        this.leg1 = new ModelRenderer((ModelBase)this);
        this.leg1.func_78793_a(4.0f, 15.0f, 11.0f);
        this.setRotationAngle(this.leg1, 0.0f, -0.7854f, 0.7854f);
        this.leg1.field_78804_l.add(new ModelBox(this.leg1, 18, 0, -1.0f, -1.0f, -1.0f, 16, 2, 2, 0.0f, false));
        this.leg2 = new ModelRenderer((ModelBase)this);
        this.leg2.func_78793_a(-4.0f, 15.0f, 6.0f);
        this.setRotationAngle(this.leg2, 0.0f, 0.2618f, -0.6109f);
        this.leg2.field_78804_l.add(new ModelBox(this.leg2, 18, 0, -15.0f, -1.0f, -1.0f, 16, 2, 2, 0.0f, true));
        this.leg3 = new ModelRenderer((ModelBase)this);
        this.leg3.func_78793_a(4.0f, 15.0f, 6.0f);
        this.setRotationAngle(this.leg3, 0.0f, -0.2618f, 0.6109f);
        this.leg3.field_78804_l.add(new ModelBox(this.leg3, 18, 0, -1.0f, -1.0f, -1.0f, 16, 2, 2, 0.0f, false));
        this.leg4 = new ModelRenderer((ModelBase)this);
        this.leg4.func_78793_a(-4.0f, 15.0f, 2.0f);
        this.setRotationAngle(this.leg4, 0.0f, -0.2618f, -0.6109f);
        this.leg4.field_78804_l.add(new ModelBox(this.leg4, 18, 0, -15.0f, -1.0f, -1.0f, 16, 2, 2, 0.0f, true));
        this.leg5 = new ModelRenderer((ModelBase)this);
        this.leg5.func_78793_a(4.0f, 15.0f, 2.0f);
        this.setRotationAngle(this.leg5, 0.0f, 0.2618f, 0.6109f);
        this.leg5.field_78804_l.add(new ModelBox(this.leg5, 18, 0, -1.0f, -1.0f, -1.0f, 16, 2, 2, 0.0f, false));
        this.leg6 = new ModelRenderer((ModelBase)this);
        this.leg6.func_78793_a(-4.0f, 15.0f, -1.0f);
        this.setRotationAngle(this.leg6, 0.0f, -0.7854f, -0.7854f);
        this.leg6.field_78804_l.add(new ModelBox(this.leg6, 18, 0, -15.0f, -1.0f, -1.0f, 16, 2, 2, 0.0f, true));
        this.leg7 = new ModelRenderer((ModelBase)this);
        this.leg7.func_78793_a(4.0f, 15.0f, -1.0f);
        this.setRotationAngle(this.leg7, 0.0f, 0.7854f, 0.7854f);
        this.leg7.field_78804_l.add(new ModelBox(this.leg7, 18, 0, -1.0f, -1.0f, -1.0f, 16, 2, 2, 0.0f, false));
        this.shieldL = new ModelRenderer((ModelBase)this);
        this.shieldL.func_78793_a(5.0f, 9.0f, 5.0f);
        this.body3_r1 = new ModelRenderer((ModelBase)this);
        this.body3_r1.func_78793_a(0.0f, 0.0f, 0.0f);
        this.shieldL.func_78792_a(this.body3_r1);
        this.setRotationAngle(this.body3_r1, 0.0f, 0.0f, 0.4363f);
        this.body3_r1.field_78804_l.add(new ModelBox(this.body3_r1, 0, 27, -2.0f, 1.0f, -7.0f, 3, 5, 3, 0.0f, false));
        this.body3_r1.field_78804_l.add(new ModelBox(this.body3_r1, 0, 27, -2.0f, 1.0f, 3.0f, 3, 5, 3, 0.0f, false));
        this.body3_r1.field_78804_l.add(new ModelBox(this.body3_r1, 8, 36, 4.0f, -5.0f, -1.0f, 1, 4, 1, 0.0f, false));
        this.body3_r1.field_78804_l.add(new ModelBox(this.body3_r1, 13, 36, 4.0f, -6.0f, 2.0f, 1, 5, 1, 0.0f, false));
        this.body3_r1.field_78804_l.add(new ModelBox(this.body3_r1, 13, 35, 4.0f, -7.0f, 5.0f, 1, 6, 1, 0.0f, false));
        this.body3_r1.field_78804_l.add(new ModelBox(this.body3_r1, 13, 27, -2.0f, -7.0f, 5.0f, 1, 6, 1, 0.0f, false));
        this.body3_r1.field_78804_l.add(new ModelBox(this.body3_r1, 13, 36, -2.0f, -6.0f, 2.0f, 1, 5, 1, 0.0f, false));
        this.body3_r1.field_78804_l.add(new ModelBox(this.body3_r1, 8, 36, -2.0f, -5.0f, -1.0f, 1, 4, 1, 0.0f, false));
        this.body3_r1.field_78804_l.add(new ModelBox(this.body3_r1, 3, 37, -2.0f, -4.0f, -4.0f, 1, 3, 1, 0.0f, false));
        this.body3_r1.field_78804_l.add(new ModelBox(this.body3_r1, 3, 37, -2.0f, -4.0f, -7.0f, 1, 3, 1, 0.0f, false));
        this.body3_r1.field_78804_l.add(new ModelBox(this.body3_r1, 3, 37, 4.0f, -4.0f, -4.0f, 1, 3, 1, 0.0f, false));
        this.body3_r1.field_78804_l.add(new ModelBox(this.body3_r1, 3, 37, 4.0f, -4.0f, -7.0f, 1, 3, 1, 0.0f, false));
        this.body3_r1.field_78804_l.add(new ModelBox(this.body3_r1, 3, 28, -3.0f, -1.0f, -8.0f, 9, 2, 15, 0.0f, false));
        this.shieldR = new ModelRenderer((ModelBase)this);
        this.shieldR.func_78793_a(-5.0f, 9.0f, 5.0f);
        this.body4_r1 = new ModelRenderer((ModelBase)this);
        this.body4_r1.func_78793_a(0.0f, 0.0f, 0.0f);
        this.shieldR.func_78792_a(this.body4_r1);
        this.setRotationAngle(this.body4_r1, 0.0f, 0.0f, -0.4363f);
        this.body4_r1.field_78804_l.add(new ModelBox(this.body4_r1, 0, 27, -1.0f, 1.0f, -7.0f, 3, 5, 3, 0.0f, true));
        this.body4_r1.field_78804_l.add(new ModelBox(this.body4_r1, 0, 27, -1.0f, 1.0f, 3.0f, 3, 5, 3, 0.0f, true));
        this.body4_r1.field_78804_l.add(new ModelBox(this.body4_r1, 8, 36, -5.0f, -5.0f, -1.0f, 1, 4, 1, 0.0f, true));
        this.body4_r1.field_78804_l.add(new ModelBox(this.body4_r1, 13, 36, -5.0f, -6.0f, 2.0f, 1, 5, 1, 0.0f, true));
        this.body4_r1.field_78804_l.add(new ModelBox(this.body4_r1, 13, 35, -5.0f, -7.0f, 5.0f, 1, 6, 1, 0.0f, true));
        this.body4_r1.field_78804_l.add(new ModelBox(this.body4_r1, 13, 27, 1.0f, -7.0f, 5.0f, 1, 6, 1, 0.0f, true));
        this.body4_r1.field_78804_l.add(new ModelBox(this.body4_r1, 13, 36, 1.0f, -6.0f, 2.0f, 1, 5, 1, 0.0f, true));
        this.body4_r1.field_78804_l.add(new ModelBox(this.body4_r1, 8, 36, 1.0f, -5.0f, -1.0f, 1, 4, 1, 0.0f, true));
        this.body4_r1.field_78804_l.add(new ModelBox(this.body4_r1, 3, 37, 1.0f, -4.0f, -4.0f, 1, 3, 1, 0.0f, true));
        this.body4_r1.field_78804_l.add(new ModelBox(this.body4_r1, 3, 37, 1.0f, -4.0f, -7.0f, 1, 3, 1, 0.0f, true));
        this.body4_r1.field_78804_l.add(new ModelBox(this.body4_r1, 3, 37, -5.0f, -4.0f, -4.0f, 1, 3, 1, 0.0f, true));
        this.body4_r1.field_78804_l.add(new ModelBox(this.body4_r1, 3, 37, -5.0f, -4.0f, -7.0f, 1, 3, 1, 0.0f, true));
        this.body4_r1.field_78804_l.add(new ModelBox(this.body4_r1, 3, 28, -6.0f, -1.0f, -8.0f, 9, 2, 15, 0.0f, true));
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
        this.shieldL.func_78785_a(f5);
        this.shieldR.func_78785_a(f5);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
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
        this.head.field_78796_g = netHeadYaw * ((float)Math.PI / 180);
        this.head.field_78795_f = headPitch * ((float)Math.PI / 180);
        this.pincerL.field_78796_g = 0.1f * Mth.func_76126_a((float)(ageInTicks * 0.2f));
        this.pincerR.field_78796_g = -this.pincerL.field_78796_g;
    }
}

