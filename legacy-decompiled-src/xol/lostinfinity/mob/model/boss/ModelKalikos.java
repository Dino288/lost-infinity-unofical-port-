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

public class ModelKalikos
extends ModelBase {
    private final ModelRenderer bipedHead;
    private final ModelRenderer HatLayer_r1;
    private final ModelRenderer HatLayer_r2;
    private final ModelRenderer bipedBody;
    private final ModelRenderer BodyLayer_r1;
    private final ModelRenderer MouthTentacle1;
    private final ModelRenderer MouthTentacle4;
    private final ModelRenderer MouthTentacle2;
    private final ModelRenderer MouthTentacle3;
    private final ModelRenderer bipedLeftArm;
    private final ModelRenderer lefttentacle1;
    private final ModelRenderer lefttentacle2;
    private final ModelRenderer bipedRightArm;
    private final ModelRenderer righttentacle1;
    private final ModelRenderer righttentacle2;
    private final ModelRenderer bipedLeftLeg;
    private final ModelRenderer bipedRightLeg;

    public ModelKalikos() {
        this.field_78090_t = 64;
        this.field_78089_u = 64;
        this.bipedHead = new ModelRenderer((ModelBase)this);
        this.bipedHead.func_78793_a(0.0f, 0.0f, 0.0f);
        this.HatLayer_r1 = new ModelRenderer((ModelBase)this);
        this.HatLayer_r1.func_78793_a(-1.0f, -7.0f, 3.0f);
        this.bipedHead.func_78792_a(this.HatLayer_r1);
        this.setRotationAngle(this.HatLayer_r1, 0.0f, 0.2618f, 0.0f);
        this.HatLayer_r1.field_78804_l.add(new ModelBox(this.HatLayer_r1, 0, 0, -3.0f, -4.0f, -14.0f, 4, 8, 14, 0.0f, true));
        this.HatLayer_r1.field_78804_l.add(new ModelBox(this.HatLayer_r1, 15, 49, -11.0f, 2.0f, -14.0f, 8, 1, 14, 0.0f, true));
        this.HatLayer_r1.field_78804_l.add(new ModelBox(this.HatLayer_r1, 12, 33, -8.0f, -2.0f, -14.0f, 5, 1, 14, 0.0f, true));
        this.HatLayer_r2 = new ModelRenderer((ModelBase)this);
        this.HatLayer_r2.func_78793_a(1.0f, -7.0f, 3.0f);
        this.bipedHead.func_78792_a(this.HatLayer_r2);
        this.setRotationAngle(this.HatLayer_r2, 0.0f, -0.2618f, 0.0f);
        this.HatLayer_r2.field_78804_l.add(new ModelBox(this.HatLayer_r2, 12, 33, 3.0f, -2.0f, -14.0f, 5, 1, 14, 0.0f, false));
        this.HatLayer_r2.field_78804_l.add(new ModelBox(this.HatLayer_r2, 15, 49, 3.0f, 2.0f, -14.0f, 8, 1, 14, 0.0f, false));
        this.HatLayer_r2.field_78804_l.add(new ModelBox(this.HatLayer_r2, 0, 0, -1.0f, -4.0f, -14.0f, 4, 8, 14, 0.0f, false));
        this.bipedBody = new ModelRenderer((ModelBase)this);
        this.bipedBody.func_78793_a(0.0f, 0.0f, 0.0f);
        this.bipedBody.field_78804_l.add(new ModelBox(this.bipedBody, 40, 15, -4.0f, 1.0f, -1.0f, 8, 10, 4, 0.0f, false));
        this.bipedBody.field_78804_l.add(new ModelBox(this.bipedBody, 40, 0, -4.0f, -12.0f, 2.0f, 8, 10, 4, 0.0f, false));
        this.BodyLayer_r1 = new ModelRenderer((ModelBase)this);
        this.BodyLayer_r1.func_78793_a(2.0f, 0.0f, 3.0f);
        this.bipedBody.func_78792_a(this.BodyLayer_r1);
        this.setRotationAngle(this.BodyLayer_r1, -0.2182f, 0.0f, 0.0f);
        this.BodyLayer_r1.field_78804_l.add(new ModelBox(this.BodyLayer_r1, 30, 0, -5.0f, -3.0f, 0.0f, 2, 11, 2, 0.0f, false));
        this.BodyLayer_r1.field_78804_l.add(new ModelBox(this.BodyLayer_r1, 46, 40, -5.0f, -3.0f, 2.0f, 1, 14, 8, 0.0f, true));
        this.BodyLayer_r1.field_78804_l.add(new ModelBox(this.BodyLayer_r1, 46, 40, 0.0f, -3.0f, 2.0f, 1, 14, 8, 0.0f, false));
        this.BodyLayer_r1.field_78804_l.add(new ModelBox(this.BodyLayer_r1, 30, 0, -1.0f, -3.0f, 0.0f, 2, 11, 2, 0.0f, false));
        this.MouthTentacle1 = new ModelRenderer((ModelBase)this);
        this.MouthTentacle1.func_78793_a(1.0f, -7.0f, 0.0f);
        this.bipedBody.func_78792_a(this.MouthTentacle1);
        this.MouthTentacle1.field_78804_l.add(new ModelBox(this.MouthTentacle1, 22, 16, -1.0f, 0.0f, -11.0f, 2, 2, 14, -0.5f, false));
        this.MouthTentacle4 = new ModelRenderer((ModelBase)this);
        this.MouthTentacle4.func_78793_a(1.0f, -11.0f, 0.0f);
        this.bipedBody.func_78792_a(this.MouthTentacle4);
        this.MouthTentacle4.field_78804_l.add(new ModelBox(this.MouthTentacle4, 22, 16, -1.0f, 0.0f, -11.0f, 2, 2, 14, -0.5f, false));
        this.MouthTentacle2 = new ModelRenderer((ModelBase)this);
        this.MouthTentacle2.func_78793_a(-1.0f, -5.0f, 0.0f);
        this.bipedBody.func_78792_a(this.MouthTentacle2);
        this.MouthTentacle2.field_78804_l.add(new ModelBox(this.MouthTentacle2, 22, 16, -1.0f, 0.0f, -11.0f, 2, 2, 14, -0.5f, false));
        this.MouthTentacle3 = new ModelRenderer((ModelBase)this);
        this.MouthTentacle3.func_78793_a(-1.0f, -9.0f, 0.0f);
        this.bipedBody.func_78792_a(this.MouthTentacle3);
        this.MouthTentacle3.field_78804_l.add(new ModelBox(this.MouthTentacle3, 22, 16, -1.0f, 0.0f, -11.0f, 2, 2, 14, -0.5f, false));
        this.bipedLeftArm = new ModelRenderer((ModelBase)this);
        this.bipedLeftArm.func_78793_a(4.0f, 3.0f, 0.0f);
        this.bipedLeftArm.field_78804_l.add(new ModelBox(this.bipedLeftArm, 1, 32, 0.0f, -4.0f, -3.0f, 6, 8, 6, 0.0f, true));
        this.lefttentacle1 = new ModelRenderer((ModelBase)this);
        this.lefttentacle1.func_78793_a(4.0f, 3.0f, -1.0f);
        this.bipedLeftArm.func_78792_a(this.lefttentacle1);
        this.lefttentacle1.field_78804_l.add(new ModelBox(this.lefttentacle1, 9, 49, -1.0f, 0.0f, -1.0f, 2, 12, 2, 0.0f, true));
        this.lefttentacle2 = new ModelRenderer((ModelBase)this);
        this.lefttentacle2.func_78793_a(2.0f, 3.0f, 1.0f);
        this.bipedLeftArm.func_78792_a(this.lefttentacle2);
        this.lefttentacle2.field_78804_l.add(new ModelBox(this.lefttentacle2, 9, 49, -1.0f, 0.0f, -1.0f, 2, 12, 2, 0.0f, true));
        this.bipedRightArm = new ModelRenderer((ModelBase)this);
        this.bipedRightArm.func_78793_a(-4.0f, 3.0f, 0.0f);
        this.bipedRightArm.field_78804_l.add(new ModelBox(this.bipedRightArm, 1, 32, -6.0f, -4.0f, -3.0f, 6, 8, 6, 0.0f, false));
        this.righttentacle1 = new ModelRenderer((ModelBase)this);
        this.righttentacle1.func_78793_a(-4.0f, 3.0f, -1.0f);
        this.bipedRightArm.func_78792_a(this.righttentacle1);
        this.righttentacle1.field_78804_l.add(new ModelBox(this.righttentacle1, 9, 49, -1.0f, 0.0f, -1.0f, 2, 12, 2, 0.0f, false));
        this.righttentacle2 = new ModelRenderer((ModelBase)this);
        this.righttentacle2.func_78793_a(-2.0f, 3.0f, 1.0f);
        this.bipedRightArm.func_78792_a(this.righttentacle2);
        this.righttentacle2.field_78804_l.add(new ModelBox(this.righttentacle2, 9, 49, -1.0f, 0.0f, -1.0f, 2, 12, 2, 0.0f, false));
        this.bipedLeftLeg = new ModelRenderer((ModelBase)this);
        this.bipedLeftLeg.func_78793_a(1.9f, 11.0f, 1.0f);
        this.bipedLeftLeg.field_78804_l.add(new ModelBox(this.bipedLeftLeg, 37, 34, -2.0f, 3.0f, -2.0f, 4, 8, 4, 0.0f, true));
        this.bipedLeftLeg.field_78804_l.add(new ModelBox(this.bipedLeftLeg, 0, 49, -1.0f, 0.0f, -1.0f, 2, 13, 2, 0.0f, true));
        this.bipedRightLeg = new ModelRenderer((ModelBase)this);
        this.bipedRightLeg.func_78793_a(-1.9f, 11.0f, 1.0f);
        this.bipedRightLeg.field_78804_l.add(new ModelBox(this.bipedRightLeg, 37, 34, -2.0f, 3.0f, -2.0f, 4, 8, 4, 0.0f, false));
        this.bipedRightLeg.field_78804_l.add(new ModelBox(this.bipedRightLeg, 0, 49, -1.0f, 0.0f, -1.0f, 2, 13, 2, 0.0f, false));
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.bipedHead.func_78785_a(f5);
        this.bipedBody.func_78785_a(f5);
        this.bipedLeftArm.func_78785_a(f5);
        this.bipedRightArm.func_78785_a(f5);
        this.bipedLeftLeg.func_78785_a(f5);
        this.bipedRightLeg.func_78785_a(f5);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.bipedRightLeg.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f)) * 1.4f * limbSwingAmount * 0.5f;
        this.bipedLeftLeg.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f + (float)Math.PI)) * 1.4f * limbSwingAmount * 0.5f;
        this.bipedRightArm.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f + (float)Math.PI)) * 2.0f * limbSwingAmount * 0.5f;
        this.bipedLeftArm.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f)) * 2.0f * limbSwingAmount * 0.5f;
        this.MouthTentacle1.field_78795_f = 0.1f * Mth.func_76126_a((float)(ageInTicks * 0.1f));
        this.MouthTentacle2.field_78795_f = -0.1f * Mth.func_76126_a((float)(ageInTicks * 0.1f));
        this.MouthTentacle3.field_78795_f = 0.1f * Mth.func_76134_b((float)(ageInTicks * 0.1f));
        this.MouthTentacle4.field_78795_f = -0.1f * Mth.func_76134_b((float)(ageInTicks * 0.1f));
        this.MouthTentacle4.field_78796_g = 0.05f * Mth.func_76126_a((float)(ageInTicks * 0.075f));
        this.MouthTentacle3.field_78796_g = -0.05f * Mth.func_76126_a((float)(ageInTicks * 0.075f));
        this.MouthTentacle2.field_78796_g = 0.05f * Mth.func_76134_b((float)(ageInTicks * 0.075f));
        this.MouthTentacle1.field_78796_g = -0.05f * Mth.func_76134_b((float)(ageInTicks * 0.075f));
        this.lefttentacle1.field_78796_g = 0.1f * Mth.func_76126_a((float)(ageInTicks * 0.1f));
        this.lefttentacle1.field_78808_h = 0.1f * Mth.func_76126_a((float)(ageInTicks * 0.1f));
        this.lefttentacle2.field_78796_g = -0.1f * Mth.func_76126_a((float)(ageInTicks * 0.1f));
        this.lefttentacle2.field_78808_h = -0.1f * Mth.func_76126_a((float)(ageInTicks * 0.1f));
        this.righttentacle1.field_78796_g = this.lefttentacle1.field_78796_g;
        this.righttentacle1.field_78808_h = this.lefttentacle1.field_78808_h;
        this.righttentacle2.field_78796_g = this.lefttentacle2.field_78796_g;
        this.righttentacle2.field_78808_h = this.lefttentacle2.field_78808_h;
    }
}

