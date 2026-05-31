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

public class ModelDuskerQueen
extends ModelBase {
    private final ModelRenderer body0;
    private final ModelRenderer leg0;
    private final ModelRenderer leg1;
    private final ModelRenderer leg2;
    private final ModelRenderer leg3;
    private final ModelRenderer leg4;
    private final ModelRenderer leg5;
    private final ModelRenderer leg6;
    private final ModelRenderer leg7;
    private final ModelRenderer eye1;
    private final ModelRenderer eye2;
    private final ModelRenderer eye3;
    private final ModelRenderer eye4;
    private final ModelRenderer eye5;
    private final ModelRenderer Mouth;

    public ModelDuskerQueen() {
        this.field_78090_t = 128;
        this.field_78089_u = 32;
        this.body0 = new ModelRenderer((ModelBase)this);
        this.body0.func_78793_a(0.0f, 20.0f, 0.0f);
        this.body0.field_78804_l.add(new ModelBox(this.body0, 0, 6, -8.0f, -4.0f, -6.0f, 16, 5, 20, 0.0f, false));
        this.body0.field_78804_l.add(new ModelBox(this.body0, 74, 0, -8.0f, -10.0f, 0.0f, 16, 6, 11, 0.0f, false));
        this.body0.field_78804_l.add(new ModelBox(this.body0, 65, 0, 2.0f, -14.0f, 2.0f, 6, 4, 4, 0.0f, false));
        this.body0.field_78804_l.add(new ModelBox(this.body0, 53, 13, 1.0f, -18.0f, 5.0f, 6, 8, 4, 0.0f, false));
        this.body0.field_78804_l.add(new ModelBox(this.body0, 53, 13, -7.0f, -18.0f, 5.0f, 6, 8, 4, 0.0f, true));
        this.body0.field_78804_l.add(new ModelBox(this.body0, 65, 0, -8.0f, -14.0f, 2.0f, 6, 4, 4, 0.0f, true));
        this.body0.field_78804_l.add(new ModelBox(this.body0, 52, 5, -2.0f, -13.0f, 0.0f, 4, 3, 4, 0.0f, true));
        this.leg0 = new ModelRenderer((ModelBase)this);
        this.leg0.func_78793_a(-8.0f, 19.0f, 11.0f);
        this.setRotationAngle(this.leg0, 0.0f, 0.7854f, -0.4363f);
        this.leg0.field_78804_l.add(new ModelBox(this.leg0, 20, 0, -15.0f, -1.0f, -1.0f, 16, 2, 2, 0.0f, true));
        this.leg1 = new ModelRenderer((ModelBase)this);
        this.leg1.func_78793_a(8.0f, 19.0f, 11.0f);
        this.setRotationAngle(this.leg1, 0.0f, -0.7854f, 0.4363f);
        this.leg1.field_78804_l.add(new ModelBox(this.leg1, 20, 0, -1.0f, -1.0f, -1.0f, 16, 2, 2, 0.0f, false));
        this.leg2 = new ModelRenderer((ModelBase)this);
        this.leg2.func_78793_a(-8.0f, 19.0f, 6.0f);
        this.setRotationAngle(this.leg2, 0.0f, 0.2618f, -0.4363f);
        this.leg2.field_78804_l.add(new ModelBox(this.leg2, 20, 0, -15.0f, -1.0f, -1.0f, 16, 2, 2, 0.0f, true));
        this.leg3 = new ModelRenderer((ModelBase)this);
        this.leg3.func_78793_a(8.0f, 19.0f, 6.0f);
        this.setRotationAngle(this.leg3, 0.0f, -0.2618f, 0.4363f);
        this.leg3.field_78804_l.add(new ModelBox(this.leg3, 20, 0, -1.0f, -1.0f, -1.0f, 16, 2, 2, 0.0f, false));
        this.leg4 = new ModelRenderer((ModelBase)this);
        this.leg4.func_78793_a(-8.0f, 19.0f, 2.0f);
        this.setRotationAngle(this.leg4, 0.0f, -0.2618f, -0.4363f);
        this.leg4.field_78804_l.add(new ModelBox(this.leg4, 20, 0, -15.0f, -1.0f, -1.0f, 16, 2, 2, 0.0f, true));
        this.leg5 = new ModelRenderer((ModelBase)this);
        this.leg5.func_78793_a(8.0f, 19.0f, 2.0f);
        this.setRotationAngle(this.leg5, 0.0f, 0.2618f, 0.4363f);
        this.leg5.field_78804_l.add(new ModelBox(this.leg5, 20, 0, -1.0f, -1.0f, -1.0f, 16, 2, 2, 0.0f, false));
        this.leg6 = new ModelRenderer((ModelBase)this);
        this.leg6.func_78793_a(-8.0f, 19.0f, -1.0f);
        this.setRotationAngle(this.leg6, 0.0f, -0.7854f, -0.4363f);
        this.leg6.field_78804_l.add(new ModelBox(this.leg6, 20, 0, -15.0f, -1.0f, -1.0f, 16, 2, 2, 0.0f, true));
        this.leg7 = new ModelRenderer((ModelBase)this);
        this.leg7.func_78793_a(8.0f, 19.0f, -1.0f);
        this.setRotationAngle(this.leg7, 0.0f, 0.7854f, 0.4363f);
        this.leg7.field_78804_l.add(new ModelBox(this.leg7, 20, 0, -1.0f, -1.0f, -1.0f, 16, 2, 2, 0.0f, false));
        this.eye1 = new ModelRenderer((ModelBase)this);
        this.eye1.func_78793_a(0.0f, 10.0f, -1.0f);
        this.eye1.field_78804_l.add(new ModelBox(this.eye1, 0, 0, -3.0f, -3.0f, -2.0f, 6, 6, 4, -1.0f, false));
        this.eye1.field_78804_l.add(new ModelBox(this.eye1, 0, 10, -2.5f, -2.5f, -2.5f, 5, 5, 3, -1.0f, false));
        this.eye2 = new ModelRenderer((ModelBase)this);
        this.eye2.func_78793_a(-5.0f, 8.0f, 1.0f);
        this.eye2.field_78804_l.add(new ModelBox(this.eye2, 0, 0, -3.0f, -3.0f, -2.0f, 6, 6, 4, -1.0f, false));
        this.eye2.field_78804_l.add(new ModelBox(this.eye2, 0, 10, -2.5f, -2.5f, -2.5f, 5, 5, 3, -1.0f, false));
        this.eye3 = new ModelRenderer((ModelBase)this);
        this.eye3.func_78793_a(5.0f, 8.0f, 1.0f);
        this.eye3.field_78804_l.add(new ModelBox(this.eye3, 0, 0, -3.0f, -3.0f, -2.0f, 6, 6, 4, -1.0f, false));
        this.eye3.field_78804_l.add(new ModelBox(this.eye3, 0, 10, -2.5f, -2.5f, -2.5f, 5, 5, 3, -1.0f, false));
        this.eye4 = new ModelRenderer((ModelBase)this);
        this.eye4.func_78793_a(3.0f, 4.0f, 4.0f);
        this.eye4.field_78804_l.add(new ModelBox(this.eye4, 0, 0, -3.0f, -3.0f, -2.0f, 6, 6, 4, -1.0f, false));
        this.eye4.field_78804_l.add(new ModelBox(this.eye4, 0, 10, -2.5f, -2.5f, -2.5f, 5, 5, 3, -1.0f, false));
        this.eye5 = new ModelRenderer((ModelBase)this);
        this.eye5.func_78793_a(-3.0f, 4.0f, 4.0f);
        this.eye5.field_78804_l.add(new ModelBox(this.eye5, 0, 0, -3.0f, -3.0f, -2.0f, 6, 6, 4, -1.0f, false));
        this.eye5.field_78804_l.add(new ModelBox(this.eye5, 0, 10, -2.5f, -2.5f, -2.5f, 5, 5, 3, -1.0f, false));
        this.Mouth = new ModelRenderer((ModelBase)this);
        this.Mouth.func_78793_a(0.0f, 16.0f, 0.0f);
        this.setRotationAngle(this.Mouth, -0.6109f, 0.0f, 0.0f);
        this.Mouth.field_78804_l.add(new ModelBox(this.Mouth, 80, 18, -8.0f, -2.0f, -6.0f, 16, 2, 6, 0.1f, false));
        this.Mouth.field_78804_l.add(new ModelBox(this.Mouth, 80, 18, 6.0f, 0.0f, -5.5f, 1, 3, 1, 0.1f, false));
        this.Mouth.field_78804_l.add(new ModelBox(this.Mouth, 80, 18, 3.0f, 0.0f, -5.5f, 1, 3, 1, 0.1f, false));
        this.Mouth.field_78804_l.add(new ModelBox(this.Mouth, 80, 18, -7.0f, 0.0f, -5.5f, 1, 3, 1, 0.1f, false));
        this.Mouth.field_78804_l.add(new ModelBox(this.Mouth, 80, 18, -4.0f, 0.0f, -5.5f, 1, 3, 1, 0.1f, false));
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.body0.func_78785_a(f5);
        this.leg0.func_78785_a(f5);
        this.leg1.func_78785_a(f5);
        this.leg2.func_78785_a(f5);
        this.leg3.func_78785_a(f5);
        this.leg4.func_78785_a(f5);
        this.leg5.func_78785_a(f5);
        this.leg6.func_78785_a(f5);
        this.leg7.func_78785_a(f5);
        this.eye1.func_78785_a(f5);
        this.eye2.func_78785_a(f5);
        this.eye3.func_78785_a(f5);
        this.eye4.func_78785_a(f5);
        this.eye5.func_78785_a(f5);
        this.Mouth.func_78785_a(f5);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.Mouth.field_78795_f = -0.45f + 0.4f * Mth.func_76126_a((float)(ageInTicks * 0.1f));
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
    }
}

