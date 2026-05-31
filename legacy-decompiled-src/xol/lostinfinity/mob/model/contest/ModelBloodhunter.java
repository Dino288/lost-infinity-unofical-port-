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
package xol.lostinfinity.mob.model.contest;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;

public class ModelBloodhunter
extends ModelBase {
    private final ModelRenderer bipedHead;
    private final ModelRenderer jaw_bottom;
    private final ModelRenderer bipedBody;
    private final ModelRenderer tail;
    private final ModelRenderer bipedRightLeg;
    private final ModelRenderer right_foot_bone;
    private final ModelRenderer bipedLeftLeg;
    private final ModelRenderer left_foot_bone;

    public ModelBloodhunter() {
        this.field_78090_t = 64;
        this.field_78089_u = 32;
        this.bipedHead = new ModelRenderer((ModelBase)this);
        this.bipedHead.func_78793_a(0.0f, 8.0f, -2.0f);
        this.bipedHead.field_78804_l.add(new ModelBox(this.bipedHead, 0, 0, -4.5f, -6.0f, -5.0f, 9, 6, 10, 0.1f, false));
        this.bipedHead.field_78804_l.add(new ModelBox(this.bipedHead, 40, 11, -2.5f, -5.0f, -5.5f, 5, 3, 1, 0.1f, false));
        this.bipedHead.field_78804_l.add(new ModelBox(this.bipedHead, 0, 0, -4.0f, -0.5f, -5.25f, 1, 2, 1, -0.25f, false));
        this.bipedHead.field_78804_l.add(new ModelBox(this.bipedHead, 0, 0, -3.0f, -0.5f, -5.25f, 1, 2, 1, -0.25f, false));
        this.bipedHead.field_78804_l.add(new ModelBox(this.bipedHead, 0, 0, 3.0f, -0.5f, -5.25f, 1, 2, 1, -0.25f, false));
        this.bipedHead.field_78804_l.add(new ModelBox(this.bipedHead, 0, 0, 2.0f, -0.5f, -5.25f, 1, 2, 1, -0.25f, false));
        this.bipedHead.field_78804_l.add(new ModelBox(this.bipedHead, 0, 0, 0.0f, -0.5f, -5.25f, 1, 2, 1, -0.25f, false));
        this.bipedHead.field_78804_l.add(new ModelBox(this.bipedHead, 0, 0, -1.0f, -0.5f, -5.25f, 1, 2, 1, -0.25f, false));
        this.bipedHead.field_78804_l.add(new ModelBox(this.bipedHead, 0, 0, -2.0f, -0.5f, -5.25f, 1, 2, 1, -0.25f, false));
        this.bipedHead.field_78804_l.add(new ModelBox(this.bipedHead, 0, 0, 1.0f, -0.5f, -5.25f, 1, 2, 1, -0.25f, false));
        this.jaw_bottom = new ModelRenderer((ModelBase)this);
        this.jaw_bottom.func_78793_a(0.0f, 1.0f, -2.0f);
        this.bipedHead.func_78792_a(this.jaw_bottom);
        this.setRotationAngle(this.jaw_bottom, 0.829f, 0.0f, 0.0f);
        this.jaw_bottom.field_78804_l.add(new ModelBox(this.jaw_bottom, 29, 3, -4.5f, -1.0f, -3.5f, 9, 2, 5, 0.0f, false));
        this.jaw_bottom.field_78804_l.add(new ModelBox(this.jaw_bottom, 29, 3, 3.5f, -2.5f, -3.5f, 1, 2, 1, -0.25f, false));
        this.jaw_bottom.field_78804_l.add(new ModelBox(this.jaw_bottom, 29, 3, 2.5f, -2.5f, -3.5f, 1, 2, 1, -0.25f, false));
        this.jaw_bottom.field_78804_l.add(new ModelBox(this.jaw_bottom, 29, 3, 1.5f, -2.5f, -3.5f, 1, 2, 1, -0.25f, false));
        this.jaw_bottom.field_78804_l.add(new ModelBox(this.jaw_bottom, 29, 3, -4.5f, -2.5f, -3.5f, 1, 2, 1, -0.25f, false));
        this.jaw_bottom.field_78804_l.add(new ModelBox(this.jaw_bottom, 29, 3, -3.5f, -2.5f, -3.5f, 1, 2, 1, -0.25f, false));
        this.jaw_bottom.field_78804_l.add(new ModelBox(this.jaw_bottom, 29, 3, -2.5f, -2.5f, -3.5f, 1, 2, 1, -0.25f, false));
        this.jaw_bottom.field_78804_l.add(new ModelBox(this.jaw_bottom, 29, 3, -1.5f, -2.5f, -3.5f, 1, 2, 1, -0.25f, false));
        this.jaw_bottom.field_78804_l.add(new ModelBox(this.jaw_bottom, 29, 3, 0.5f, -2.5f, -3.5f, 1, 2, 1, -0.25f, false));
        this.jaw_bottom.field_78804_l.add(new ModelBox(this.jaw_bottom, 29, 3, -0.5f, -2.5f, -3.5f, 1, 2, 1, -0.25f, false));
        this.bipedBody = new ModelRenderer((ModelBase)this);
        this.bipedBody.func_78793_a(0.0f, 0.0f, 0.0f);
        this.bipedBody.field_78804_l.add(new ModelBox(this.bipedBody, 18, 16, -4.0f, 8.0f, -4.0f, 8, 8, 8, 0.0f, false));
        this.tail = new ModelRenderer((ModelBase)this);
        this.tail.func_78793_a(0.0f, 11.5f, 4.5f);
        this.bipedBody.func_78792_a(this.tail);
        this.setRotationAngle(this.tail, 0.3491f, 0.0f, 0.0f);
        this.tail.field_78804_l.add(new ModelBox(this.tail, 51, 22, -2.0f, -0.5f, -1.5f, 4, 9, 1, 0.0f, false));
        this.tail.field_78804_l.add(new ModelBox(this.tail, 54, 16, 1.0f, 8.5f, -1.5f, 1, 3, 1, 0.0f, false));
        this.tail.field_78804_l.add(new ModelBox(this.tail, 54, 16, -2.0f, 8.5f, -1.5f, 1, 3, 1, 0.0f, false));
        this.bipedRightLeg = new ModelRenderer((ModelBase)this);
        this.bipedRightLeg.func_78793_a(-1.9f, 12.0f, 0.0f);
        this.bipedRightLeg.field_78804_l.add(new ModelBox(this.bipedRightLeg, 1, 17, -3.1f, 3.0f, -2.0f, 4, 9, 4, 0.0f, false));
        this.right_foot_bone = new ModelRenderer((ModelBase)this);
        this.right_foot_bone.func_78793_a(0.9f, 12.0f, 0.0f);
        this.bipedRightLeg.func_78792_a(this.right_foot_bone);
        this.right_foot_bone.field_78804_l.add(new ModelBox(this.right_foot_bone, 14, 17, -1.5f, -4.0f, -4.0f, 1, 1, 2, 0.0f, true));
        this.right_foot_bone.field_78804_l.add(new ModelBox(this.right_foot_bone, 1, 17, -1.5f, -3.0f, -4.0f, 1, 2, 1, 0.0f, true));
        this.right_foot_bone.field_78804_l.add(new ModelBox(this.right_foot_bone, 1, 17, -3.5f, -2.0f, -4.0f, 1, 2, 1, 0.0f, true));
        this.right_foot_bone.field_78804_l.add(new ModelBox(this.right_foot_bone, 14, 17, -3.5f, -3.0f, -4.0f, 1, 1, 2, 0.0f, true));
        this.bipedLeftLeg = new ModelRenderer((ModelBase)this);
        this.bipedLeftLeg.func_78793_a(2.9f, 12.0f, 0.0f);
        this.bipedLeftLeg.field_78804_l.add(new ModelBox(this.bipedLeftLeg, 1, 17, -1.9f, 3.0f, -2.0f, 4, 9, 4, 0.0f, false));
        this.left_foot_bone = new ModelRenderer((ModelBase)this);
        this.left_foot_bone.func_78793_a(-1.9f, 12.0f, 0.0f);
        this.bipedLeftLeg.func_78792_a(this.left_foot_bone);
        this.left_foot_bone.field_78804_l.add(new ModelBox(this.left_foot_bone, 14, 17, 0.5f, -4.0f, -4.0f, 1, 1, 2, 0.0f, false));
        this.left_foot_bone.field_78804_l.add(new ModelBox(this.left_foot_bone, 1, 17, 0.5f, -3.0f, -4.0f, 1, 2, 1, 0.0f, false));
        this.left_foot_bone.field_78804_l.add(new ModelBox(this.left_foot_bone, 1, 17, 2.5f, -2.0f, -4.0f, 1, 2, 1, 0.0f, false));
        this.left_foot_bone.field_78804_l.add(new ModelBox(this.left_foot_bone, 14, 17, 2.5f, -3.0f, -4.0f, 1, 1, 2, 0.0f, false));
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.bipedHead.func_78785_a(f5);
        this.bipedBody.func_78785_a(f5);
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
        this.jaw_bottom.field_78795_f = Mth.func_76134_b((float)(ageInTicks * 0.2f)) * 0.35f + 0.4f;
        this.tail.field_78795_f = Mth.func_76134_b((float)(ageInTicks * 0.1f)) * 0.25f + 0.3491f;
        this.bipedRightLeg.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f)) * 1.4f * limbSwingAmount * 0.5f;
        this.bipedLeftLeg.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f + (float)Math.PI)) * 1.4f * limbSwingAmount * 0.5f;
    }
}

