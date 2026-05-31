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
package xol.lostinfinity.mob.model.boss;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;

public class ModelAzross
extends ModelBase {
    private final ModelRenderer bipedHead;
    private final ModelRenderer bipedBody;
    private final ModelRenderer BodyLayer_r1;
    private final ModelRenderer BodyLayer_r2;
    private final ModelRenderer BodyLayer_r3;
    private final ModelRenderer BodyLayer_r4;
    private final ModelRenderer BodyLayer_r5;
    private final ModelRenderer BodyLayer_r6;
    private final ModelRenderer bipedRightArm;
    private final ModelRenderer right_arm_bone;
    private final ModelRenderer bipedLeftArm;
    private final ModelRenderer left_arm_bone;
    private final ModelRenderer bipedRightLeg;
    private final ModelRenderer right_leg_bone;
    private final ModelRenderer bipedLeftLeg;
    private final ModelRenderer left_leg_bone;

    public ModelAzross() {
        this.field_78090_t = 64;
        this.field_78089_u = 64;
        this.bipedHead = new ModelRenderer((ModelBase)this);
        this.bipedHead.func_78793_a(0.0f, 0.0f, 0.0f);
        this.bipedHead.field_78804_l.add(new ModelBox(this.bipedHead, 0, 0, -4.0f, -8.0f, -3.0f, 8, 8, 6, 0.0f, false));
        this.bipedHead.field_78804_l.add(new ModelBox(this.bipedHead, 28, 0, -4.0f, -8.0f, -4.0f, 8, 6, 1, 0.0f, false));
        this.bipedHead.field_78804_l.add(new ModelBox(this.bipedHead, 29, 8, -5.0f, -7.5f, -4.5f, 1, 1, 7, 0.0f, false));
        this.bipedHead.field_78804_l.add(new ModelBox(this.bipedHead, 29, 8, 4.0f, -7.5f, -4.5f, 1, 1, 7, 0.0f, false));
        this.bipedHead.field_78804_l.add(new ModelBox(this.bipedHead, 29, 7, -4.0f, -7.5f, -4.5f, 2, 1, 1, 0.0f, false));
        this.bipedHead.field_78804_l.add(new ModelBox(this.bipedHead, 29, 10, -3.5f, -6.3f, -4.25f, 2, 1, 1, 0.0f, false));
        this.bipedHead.field_78804_l.add(new ModelBox(this.bipedHead, 29, 10, 1.5f, -6.3f, -4.25f, 2, 1, 1, 0.0f, true));
        this.bipedHead.field_78804_l.add(new ModelBox(this.bipedHead, 29, 10, 1.0f, -4.7f, -4.25f, 2, 1, 1, 0.0f, true));
        this.bipedHead.field_78804_l.add(new ModelBox(this.bipedHead, 29, 10, -3.0f, -4.7f, -4.25f, 2, 1, 1, 0.0f, false));
        this.bipedHead.field_78804_l.add(new ModelBox(this.bipedHead, 29, 7, 2.0f, -7.5f, -4.5f, 2, 1, 1, 0.0f, false));
        this.bipedHead.field_78804_l.add(new ModelBox(this.bipedHead, 29, 7, 2.0f, -3.5f, -4.5f, 2, 1, 1, 0.0f, false));
        this.bipedHead.field_78804_l.add(new ModelBox(this.bipedHead, 29, 8, 4.0f, -3.5f, -4.5f, 1, 1, 7, 0.0f, false));
        this.bipedHead.field_78804_l.add(new ModelBox(this.bipedHead, 29, 7, -4.0f, -3.5f, -4.5f, 2, 1, 1, 0.0f, false));
        this.bipedHead.field_78804_l.add(new ModelBox(this.bipedHead, 29, 8, -5.0f, -3.5f, -4.5f, 1, 1, 7, 0.0f, false));
        this.bipedBody = new ModelRenderer((ModelBase)this);
        this.bipedBody.func_78793_a(0.0f, 0.0f, 0.0f);
        this.bipedBody.field_78804_l.add(new ModelBox(this.bipedBody, 17, 21, -4.0f, 1.0f, -1.0f, 8, 10, 3, 0.0f, false));
        this.bipedBody.field_78804_l.add(new ModelBox(this.bipedBody, 0, 34, -3.0f, 1.0f, 2.0f, 6, 10, 1, 0.0f, false));
        this.bipedBody.field_78804_l.add(new ModelBox(this.bipedBody, 15, 43, -4.0f, 11.0f, -2.0f, 8, 1, 4, 0.0f, false));
        this.bipedBody.field_78804_l.add(new ModelBox(this.bipedBody, 15, 36, -4.0f, 0.0f, -2.0f, 8, 1, 4, 0.0f, false));
        this.BodyLayer_r1 = new ModelRenderer((ModelBase)this);
        this.BodyLayer_r1.func_78793_a(-2.5f, 6.5f, -1.5f);
        this.bipedBody.func_78792_a(this.BodyLayer_r1);
        this.setRotationAngle(this.BodyLayer_r1, 0.0f, 0.0f, 0.1745f);
        this.BodyLayer_r1.field_78804_l.add(new ModelBox(this.BodyLayer_r1, 4, 46, -1.5f, -0.5f, 0.0f, 3, 1, 1, 0.0f, false));
        this.BodyLayer_r2 = new ModelRenderer((ModelBase)this);
        this.BodyLayer_r2.func_78793_a(2.5f, 6.5f, -1.5f);
        this.bipedBody.func_78792_a(this.BodyLayer_r2);
        this.setRotationAngle(this.BodyLayer_r2, 0.0f, 0.0f, -0.1745f);
        this.BodyLayer_r2.field_78804_l.add(new ModelBox(this.BodyLayer_r2, 4, 46, -1.5f, -0.5f, 0.0f, 3, 1, 1, 0.0f, true));
        this.BodyLayer_r3 = new ModelRenderer((ModelBase)this);
        this.BodyLayer_r3.func_78793_a(-2.5f, 4.5f, -1.5f);
        this.bipedBody.func_78792_a(this.BodyLayer_r3);
        this.setRotationAngle(this.BodyLayer_r3, 0.0f, 0.0f, 0.1745f);
        this.BodyLayer_r3.field_78804_l.add(new ModelBox(this.BodyLayer_r3, 4, 46, -1.5f, -0.5f, 0.0f, 3, 1, 1, 0.0f, false));
        this.BodyLayer_r4 = new ModelRenderer((ModelBase)this);
        this.BodyLayer_r4.func_78793_a(2.5f, 4.5f, -1.5f);
        this.bipedBody.func_78792_a(this.BodyLayer_r4);
        this.setRotationAngle(this.BodyLayer_r4, 0.0f, 0.0f, -0.1745f);
        this.BodyLayer_r4.field_78804_l.add(new ModelBox(this.BodyLayer_r4, 4, 46, -1.5f, -0.5f, 0.0f, 3, 1, 1, 0.0f, true));
        this.BodyLayer_r5 = new ModelRenderer((ModelBase)this);
        this.BodyLayer_r5.func_78793_a(2.5f, 2.5f, -1.5f);
        this.bipedBody.func_78792_a(this.BodyLayer_r5);
        this.setRotationAngle(this.BodyLayer_r5, 0.0f, 0.0f, -0.1745f);
        this.BodyLayer_r5.field_78804_l.add(new ModelBox(this.BodyLayer_r5, 4, 46, -1.5f, -0.5f, 0.0f, 3, 1, 1, 0.0f, true));
        this.BodyLayer_r6 = new ModelRenderer((ModelBase)this);
        this.BodyLayer_r6.func_78793_a(-2.5f, 2.5f, -1.5f);
        this.bipedBody.func_78792_a(this.BodyLayer_r6);
        this.setRotationAngle(this.BodyLayer_r6, 0.0f, 0.0f, 0.1745f);
        this.BodyLayer_r6.field_78804_l.add(new ModelBox(this.BodyLayer_r6, 4, 46, -1.5f, -0.5f, 0.0f, 3, 1, 1, 0.0f, false));
        this.bipedRightArm = new ModelRenderer((ModelBase)this);
        this.bipedRightArm.func_78793_a(-5.0f, 2.0f, 0.0f);
        this.bipedRightArm.field_78804_l.add(new ModelBox(this.bipedRightArm, 40, 20, -3.0f, -2.0f, -2.0f, 4, 8, 4, 0.0f, false));
        this.right_arm_bone = new ModelRenderer((ModelBase)this);
        this.right_arm_bone.func_78793_a(5.0f, 22.0f, 0.0f);
        this.bipedRightArm.func_78792_a(this.right_arm_bone);
        this.right_arm_bone.field_78804_l.add(new ModelBox(this.right_arm_bone, 40, 33, -8.0f, -16.0f, -2.0f, 2, 4, 4, 0.0f, false));
        this.right_arm_bone.field_78804_l.add(new ModelBox(this.right_arm_bone, 53, 34, -5.5f, -16.0f, -1.5f, 1, 6, 1, 0.0f, true));
        this.right_arm_bone.field_78804_l.add(new ModelBox(this.right_arm_bone, 53, 42, -9.5f, -11.0f, -1.5f, 1, 6, 1, 0.0f, false));
        this.right_arm_bone.field_78804_l.add(new ModelBox(this.right_arm_bone, 53, 42, -9.5f, -11.0f, 0.5f, 1, 6, 1, 0.0f, false));
        this.right_arm_bone.field_78804_l.add(new ModelBox(this.right_arm_bone, 40, 43, -8.5f, -11.0f, -1.5f, 3, 1, 1, 0.0f, false));
        this.right_arm_bone.field_78804_l.add(new ModelBox(this.right_arm_bone, 40, 43, -8.5f, -11.0f, 0.5f, 3, 1, 1, 0.0f, false));
        this.right_arm_bone.field_78804_l.add(new ModelBox(this.right_arm_bone, 53, 34, -5.5f, -16.0f, 0.5f, 1, 6, 1, 0.0f, true));
        this.bipedLeftArm = new ModelRenderer((ModelBase)this);
        this.bipedLeftArm.func_78793_a(5.0f, 2.0f, 0.0f);
        this.bipedLeftArm.field_78804_l.add(new ModelBox(this.bipedLeftArm, 40, 20, -1.0f, -2.0f, -2.0f, 4, 8, 4, 0.0f, true));
        this.left_arm_bone = new ModelRenderer((ModelBase)this);
        this.left_arm_bone.func_78793_a(-5.0f, 22.0f, 0.0f);
        this.bipedLeftArm.func_78792_a(this.left_arm_bone);
        this.left_arm_bone.field_78804_l.add(new ModelBox(this.left_arm_bone, 40, 33, 6.0f, -16.0f, -2.0f, 2, 4, 4, 0.0f, true));
        this.left_arm_bone.field_78804_l.add(new ModelBox(this.left_arm_bone, 53, 34, 4.5f, -16.0f, -1.5f, 1, 6, 1, 0.0f, true));
        this.left_arm_bone.field_78804_l.add(new ModelBox(this.left_arm_bone, 53, 42, 8.5f, -11.0f, -1.5f, 1, 6, 1, 0.0f, true));
        this.left_arm_bone.field_78804_l.add(new ModelBox(this.left_arm_bone, 53, 42, 8.5f, -11.0f, 0.5f, 1, 6, 1, 0.0f, true));
        this.left_arm_bone.field_78804_l.add(new ModelBox(this.left_arm_bone, 40, 43, 5.5f, -11.0f, -1.5f, 3, 1, 1, 0.0f, true));
        this.left_arm_bone.field_78804_l.add(new ModelBox(this.left_arm_bone, 40, 43, 5.5f, -11.0f, 0.5f, 3, 1, 1, 0.0f, true));
        this.left_arm_bone.field_78804_l.add(new ModelBox(this.left_arm_bone, 53, 34, 4.5f, -16.0f, 0.5f, 1, 6, 1, 0.0f, true));
        this.bipedRightLeg = new ModelRenderer((ModelBase)this);
        this.bipedRightLeg.func_78793_a(-1.9f, 12.0f, 0.0f);
        this.bipedRightLeg.field_78804_l.add(new ModelBox(this.bipedRightLeg, 0, 20, -2.0f, 0.0f, -2.0f, 4, 8, 4, 0.0f, false));
        this.right_leg_bone = new ModelRenderer((ModelBase)this);
        this.right_leg_bone.func_78793_a(1.9f, 12.0f, 0.0f);
        this.bipedRightLeg.func_78792_a(this.right_leg_bone);
        this.right_leg_bone.field_78804_l.add(new ModelBox(this.right_leg_bone, 13, 18, -3.9f, -4.0f, 1.0f, 1, 4, 1, 0.0f, false));
        this.right_leg_bone.field_78804_l.add(new ModelBox(this.right_leg_bone, 13, 18, -3.9f, -4.0f, -2.0f, 1, 4, 1, 0.0f, false));
        this.right_leg_bone.field_78804_l.add(new ModelBox(this.right_leg_bone, 13, 18, -0.9f, -4.0f, -2.0f, 1, 4, 1, 0.0f, false));
        this.right_leg_bone.field_78804_l.add(new ModelBox(this.right_leg_bone, 13, 18, -0.9f, -4.0f, 1.0f, 1, 4, 1, 0.0f, false));
        this.bipedLeftLeg = new ModelRenderer((ModelBase)this);
        this.bipedLeftLeg.func_78793_a(1.9f, 12.0f, 0.0f);
        this.bipedLeftLeg.field_78804_l.add(new ModelBox(this.bipedLeftLeg, 0, 20, -2.0f, 0.0f, -2.0f, 4, 8, 4, 0.0f, true));
        this.left_leg_bone = new ModelRenderer((ModelBase)this);
        this.left_leg_bone.func_78793_a(-1.9f, 12.0f, 0.0f);
        this.bipedLeftLeg.func_78792_a(this.left_leg_bone);
        this.left_leg_bone.field_78804_l.add(new ModelBox(this.left_leg_bone, 13, 18, 2.9f, -4.0f, 1.0f, 1, 4, 1, 0.0f, true));
        this.left_leg_bone.field_78804_l.add(new ModelBox(this.left_leg_bone, 13, 18, 2.9f, -4.0f, -2.0f, 1, 4, 1, 0.0f, true));
        this.left_leg_bone.field_78804_l.add(new ModelBox(this.left_leg_bone, 13, 18, -0.1f, -4.0f, -2.0f, 1, 4, 1, 0.0f, true));
        this.left_leg_bone.field_78804_l.add(new ModelBox(this.left_leg_bone, 13, 18, -0.1f, -4.0f, 1.0f, 1, 4, 1, 0.0f, true));
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.bipedHead.func_78785_a(f5);
        this.bipedBody.func_78785_a(f5);
        this.bipedRightArm.func_78785_a(f5);
        this.bipedLeftArm.func_78785_a(f5);
        this.bipedRightLeg.func_78785_a(f5);
        this.bipedLeftLeg.func_78785_a(f5);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.bipedHead.field_78796_g = netHeadYaw * ((float)Math.PI / 180);
        this.bipedHead.field_78795_f = headPitch * ((float)Math.PI / 180);
        this.bipedRightLeg.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f)) * 1.4f * limbSwingAmount * 0.5f;
        this.bipedLeftLeg.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f + (float)Math.PI)) * 1.4f * limbSwingAmount * 0.5f;
        this.bipedRightArm.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f + (float)Math.PI)) * 2.0f * limbSwingAmount * 0.5f;
        this.bipedLeftArm.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f)) * 2.0f * limbSwingAmount * 0.5f;
    }
}

