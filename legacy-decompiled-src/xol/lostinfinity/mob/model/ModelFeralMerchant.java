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
package xol.lostinfinity.mob.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;

public class ModelFeralMerchant
extends ModelBase {
    private final ModelRenderer body;
    private final ModelRenderer head;
    private final ModelRenderer lower_mouth;
    private final ModelRenderer upper_mouth;
    private final ModelRenderer RightArm;
    private final ModelRenderer arms_r1;
    private final ModelRenderer LeftArm;
    private final ModelRenderer arms_r2;
    private final ModelRenderer RightLeg;
    private final ModelRenderer LeftLeg;

    public ModelFeralMerchant() {
        this.field_78090_t = 64;
        this.field_78089_u = 64;
        this.body = new ModelRenderer((ModelBase)this);
        this.body.func_78793_a(0.0f, 24.0f, 0.0f);
        this.body.field_78804_l.add(new ModelBox(this.body, 16, 20, -4.0f, -24.0f, -3.0f, 8, 12, 6, 0.0f, false));
        this.body.field_78804_l.add(new ModelBox(this.body, 0, 38, -4.0f, -24.0f, -3.0f, 8, 18, 6, 0.5f, false));
        this.head = new ModelRenderer((ModelBase)this);
        this.head.func_78793_a(0.0f, -24.0f, 0.0f);
        this.body.func_78792_a(this.head);
        this.head.field_78804_l.add(new ModelBox(this.head, 30, 8, -1.0f, -16.0f, -1.0f, 2, 6, 2, 0.0f, false));
        this.head.field_78804_l.add(new ModelBox(this.head, 24, 1, -1.5f, -19.0f, -1.5f, 3, 3, 3, 0.0f, false));
        this.head.field_78804_l.add(new ModelBox(this.head, 37, 1, -1.5f, -15.0f, -1.5f, 3, 1, 3, 0.0f, false));
        this.head.field_78804_l.add(new ModelBox(this.head, 37, 1, -1.5f, -13.0f, -1.5f, 3, 1, 3, 0.0f, false));
        this.head.field_78804_l.add(new ModelBox(this.head, 39, 6, -4.0f, -10.0f, 0.0f, 8, 10, 4, 0.0f, false));
        this.lower_mouth = new ModelRenderer((ModelBase)this);
        this.lower_mouth.func_78793_a(0.0f, -3.0f, -1.0f);
        this.head.func_78792_a(this.lower_mouth);
        this.lower_mouth.field_78804_l.add(new ModelBox(this.lower_mouth, 0, 11, -4.0f, -1.0f, -3.0f, 8, 4, 4, -0.1f, false));
        this.lower_mouth.field_78804_l.add(new ModelBox(this.lower_mouth, 0, 11, 2.0f, -2.0f, -2.7f, 1, 2, 1, -0.1f, false));
        this.lower_mouth.field_78804_l.add(new ModelBox(this.lower_mouth, 0, 11, 1.0f, -2.0f, -2.7f, 1, 2, 1, -0.1f, false));
        this.lower_mouth.field_78804_l.add(new ModelBox(this.lower_mouth, 0, 11, -3.0f, -2.0f, -2.7f, 1, 2, 1, -0.1f, false));
        this.lower_mouth.field_78804_l.add(new ModelBox(this.lower_mouth, 0, 11, -2.0f, -2.0f, -2.7f, 1, 2, 1, -0.1f, false));
        this.lower_mouth.field_78804_l.add(new ModelBox(this.lower_mouth, 0, 11, -1.0f, -2.0f, -2.7f, 1, 2, 1, -0.1f, false));
        this.lower_mouth.field_78804_l.add(new ModelBox(this.lower_mouth, 0, 11, 0.0f, -2.0f, -2.7f, 1, 2, 1, -0.1f, false));
        this.upper_mouth = new ModelRenderer((ModelBase)this);
        this.upper_mouth.func_78793_a(0.0f, -5.0f, 0.0f);
        this.head.func_78792_a(this.upper_mouth);
        this.upper_mouth.field_78804_l.add(new ModelBox(this.upper_mouth, 0, 0, -4.0f, -5.0f, -4.0f, 8, 6, 4, -0.05f, false));
        this.upper_mouth.field_78804_l.add(new ModelBox(this.upper_mouth, 0, 0, 2.5f, 0.0f, -3.7f, 1, 2, 1, -0.05f, false));
        this.upper_mouth.field_78804_l.add(new ModelBox(this.upper_mouth, 0, 0, -3.5f, 0.0f, -3.7f, 1, 2, 1, -0.05f, false));
        this.upper_mouth.field_78804_l.add(new ModelBox(this.upper_mouth, 0, 0, -1.5f, 0.0f, -3.7f, 1, 2, 1, -0.05f, false));
        this.upper_mouth.field_78804_l.add(new ModelBox(this.upper_mouth, 0, 0, 0.5f, 0.0f, -3.7f, 1, 2, 1, -0.05f, false));
        this.RightArm = new ModelRenderer((ModelBase)this);
        this.RightArm.func_78793_a(-4.0f, -23.0f, 0.0f);
        this.body.func_78792_a(this.RightArm);
        this.RightArm.field_78804_l.add(new ModelBox(this.RightArm, 44, 22, -4.0f, -1.0f, -2.0f, 4, 8, 4, 0.0f, false));
        this.arms_r1 = new ModelRenderer((ModelBase)this);
        this.arms_r1.func_78793_a(-1.0f, 1.0f, 0.0f);
        this.RightArm.func_78792_a(this.arms_r1);
        this.setRotationAngle(this.arms_r1, 0.1745f, 0.0f, 0.0f);
        this.arms_r1.field_78804_l.add(new ModelBox(this.arms_r1, 45, 47, -2.5f, 13.0f, -2.5f, 3, 6, 3, 0.0f, false));
        this.arms_r1.field_78804_l.add(new ModelBox(this.arms_r1, 45, 35, -2.5f, 5.0f, -2.5f, 3, 8, 3, 0.0f, false));
        this.LeftArm = new ModelRenderer((ModelBase)this);
        this.LeftArm.func_78793_a(4.0f, -23.0f, 0.0f);
        this.body.func_78792_a(this.LeftArm);
        this.LeftArm.field_78804_l.add(new ModelBox(this.LeftArm, 44, 22, 0.0f, -1.0f, -2.0f, 4, 8, 4, 0.0f, true));
        this.arms_r2 = new ModelRenderer((ModelBase)this);
        this.arms_r2.func_78793_a(1.0f, 1.0f, 0.0f);
        this.LeftArm.func_78792_a(this.arms_r2);
        this.setRotationAngle(this.arms_r2, 0.1745f, 0.0f, 0.0f);
        this.arms_r2.field_78804_l.add(new ModelBox(this.arms_r2, 45, 47, -0.5f, 13.0f, -2.5f, 3, 6, 3, 0.0f, true));
        this.arms_r2.field_78804_l.add(new ModelBox(this.arms_r2, 45, 35, -0.5f, 5.0f, -2.5f, 3, 8, 3, 0.0f, true));
        this.RightLeg = new ModelRenderer((ModelBase)this);
        this.RightLeg.func_78793_a(-2.0f, -12.0f, 0.0f);
        this.body.func_78792_a(this.RightLeg);
        this.RightLeg.field_78804_l.add(new ModelBox(this.RightLeg, 0, 22, -2.0f, 0.0f, -2.0f, 4, 12, 4, 0.0f, false));
        this.LeftLeg = new ModelRenderer((ModelBase)this);
        this.LeftLeg.func_78793_a(2.0f, -12.0f, 0.0f);
        this.body.func_78792_a(this.LeftLeg);
        this.LeftLeg.field_78804_l.add(new ModelBox(this.LeftLeg, 0, 22, -2.0f, 0.0f, -2.0f, 4, 12, 4, 0.0f, true));
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.body.func_78785_a(f5);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.lower_mouth.field_78795_f = 0.35f - 0.35f * Mth.func_76126_a((float)(ageInTicks * 0.3f));
        this.upper_mouth.field_78795_f = -this.lower_mouth.field_78795_f * 0.5f;
        this.head.field_78796_g = netHeadYaw * ((float)Math.PI / 180);
        this.head.field_78795_f = headPitch * ((float)Math.PI / 180);
        this.RightLeg.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f)) * 1.4f * limbSwingAmount * 0.5f;
        this.LeftLeg.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f + (float)Math.PI)) * 1.4f * limbSwingAmount * 0.5f;
        this.RightArm.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f + (float)Math.PI)) * 2.0f * limbSwingAmount * 0.5f;
        this.LeftArm.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f)) * 2.0f * limbSwingAmount * 0.5f;
    }
}

