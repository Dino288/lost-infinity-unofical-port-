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
package xol.lostinfinity.mob.model.murk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;

public class ModelScorpwing
extends ModelBase {
    private final ModelRenderer head;
    private final ModelRenderer FaceTendril1;
    private final ModelRenderer FaceTendril3;
    private final ModelRenderer FaceTendril4;
    private final ModelRenderer FaceTendril2;
    private final ModelRenderer body;
    private final ModelRenderer body_r1;
    private final ModelRenderer body_r2;
    private final ModelRenderer LeftLegs;
    private final ModelRenderer Leg1;
    private final ModelRenderer body_r3;
    private final ModelRenderer Leg2;
    private final ModelRenderer body_r4;
    private final ModelRenderer Leg3;
    private final ModelRenderer Leg4;
    private final ModelRenderer Leg5;
    private final ModelRenderer body_r5;
    private final ModelRenderer Leg6;
    private final ModelRenderer body_r6;
    private final ModelRenderer RightLegs;
    private final ModelRenderer Leg7;
    private final ModelRenderer body_r7;
    private final ModelRenderer Leg8;
    private final ModelRenderer body_r8;
    private final ModelRenderer Leg9;
    private final ModelRenderer Leg10;
    private final ModelRenderer Leg11;
    private final ModelRenderer body_r9;
    private final ModelRenderer Leg12;
    private final ModelRenderer body_r10;
    private final ModelRenderer leftWing;
    private final ModelRenderer leftWingMid;
    private final ModelRenderer leftWingTip;
    private final ModelRenderer rightWing;
    private final ModelRenderer rightWingMid;
    private final ModelRenderer rightWingTip;
    private List<ModelRenderer> leftBones = new ArrayList<ModelRenderer>();
    private List<ModelRenderer> rightBones = new ArrayList<ModelRenderer>();

    public ModelScorpwing() {
        this.field_78090_t = 64;
        this.field_78089_u = 64;
        this.head = new ModelRenderer((ModelBase)this);
        this.head.func_78793_a(0.0f, -4.0f, 1.0f);
        this.head.field_78804_l.add(new ModelBox(this.head, 0, 0, -4.0f, -5.0f, -3.0f, 8, 10, 6, 0.0f, false));
        this.FaceTendril1 = new ModelRenderer((ModelBase)this);
        this.FaceTendril1.func_78793_a(2.5f, 4.0f, -1.5f);
        this.head.func_78792_a(this.FaceTendril1);
        this.FaceTendril1.field_78804_l.add(new ModelBox(this.FaceTendril1, 32, 56, -0.5f, 0.0f, -0.5f, 1, 6, 1, 0.0f, false));
        this.FaceTendril3 = new ModelRenderer((ModelBase)this);
        this.FaceTendril3.func_78793_a(-1.5f, 4.0f, 0.5f);
        this.head.func_78792_a(this.FaceTendril3);
        this.FaceTendril3.field_78804_l.add(new ModelBox(this.FaceTendril3, 32, 56, -0.5f, 0.0f, -0.5f, 1, 6, 1, 0.0f, false));
        this.FaceTendril4 = new ModelRenderer((ModelBase)this);
        this.FaceTendril4.func_78793_a(1.5f, 4.0f, 0.5f);
        this.head.func_78792_a(this.FaceTendril4);
        this.FaceTendril4.field_78804_l.add(new ModelBox(this.FaceTendril4, 32, 56, -0.5f, 0.0f, -0.5f, 1, 6, 1, 0.0f, false));
        this.FaceTendril2 = new ModelRenderer((ModelBase)this);
        this.FaceTendril2.func_78793_a(-2.5f, 4.0f, -1.5f);
        this.head.func_78792_a(this.FaceTendril2);
        this.FaceTendril2.field_78804_l.add(new ModelBox(this.FaceTendril2, 32, 56, -0.5f, 0.0f, -0.5f, 1, 6, 1, 0.0f, false));
        this.body = new ModelRenderer((ModelBase)this);
        this.body.func_78793_a(0.0f, -9.0f, 0.0f);
        this.setRotationAngle(this.body, 0.5236f, 0.0f, 0.0f);
        this.body.field_78804_l.add(new ModelBox(this.body, 0, 17, -3.0f, 2.0f, -3.0f, 6, 18, 6, 0.0f, false));
        this.body_r1 = new ModelRenderer((ModelBase)this);
        this.body_r1.func_78793_a(0.0f, 10.0f, 0.0f);
        this.body.func_78792_a(this.body_r1);
        this.setRotationAngle(this.body_r1, -0.6109f, 0.0f, 0.0f);
        this.body_r1.field_78804_l.add(new ModelBox(this.body_r1, 26, 14, -2.0f, 19.0f, 5.0f, 4, 12, 4, -1.0f, false));
        this.body_r1.field_78804_l.add(new ModelBox(this.body_r1, 0, 42, -3.0f, 13.0f, 4.0f, 6, 8, 6, -0.2f, false));
        this.body_r2 = new ModelRenderer((ModelBase)this);
        this.body_r2.func_78793_a(0.0f, 10.0f, 0.0f);
        this.body.func_78792_a(this.body_r2);
        this.setRotationAngle(this.body_r2, -0.2618f, 0.0f, 0.0f);
        this.body_r2.field_78804_l.add(new ModelBox(this.body_r2, 40, 49, -3.0f, 8.0f, -1.0f, 6, 8, 6, -0.1f, false));
        this.LeftLegs = new ModelRenderer((ModelBase)this);
        this.LeftLegs.func_78793_a(3.0f, 23.0f, -1.5f);
        this.body.func_78792_a(this.LeftLegs);
        this.Leg1 = new ModelRenderer((ModelBase)this);
        this.Leg1.func_78793_a(0.0f, 0.0f, 0.0f);
        this.LeftLegs.func_78792_a(this.Leg1);
        this.body_r3 = new ModelRenderer((ModelBase)this);
        this.body_r3.func_78793_a(-3.0f, -13.0f, 1.5f);
        this.Leg1.func_78792_a(this.body_r3);
        this.setRotationAngle(this.body_r3, -0.2618f, 0.0f, 0.0f);
        this.body_r3.field_78804_l.add(new ModelBox(this.body_r3, 20, 43, 2.0f, 12.0f, 1.0f, 6, 2, 2, -0.5f, false));
        this.Leg2 = new ModelRenderer((ModelBase)this);
        this.Leg2.func_78793_a(0.0f, -3.0f, 1.0f);
        this.LeftLegs.func_78792_a(this.Leg2);
        this.body_r4 = new ModelRenderer((ModelBase)this);
        this.body_r4.func_78793_a(-3.0f, -13.0f, 1.5f);
        this.Leg2.func_78792_a(this.body_r4);
        this.setRotationAngle(this.body_r4, -0.2618f, 0.0f, 0.0f);
        this.body_r4.field_78804_l.add(new ModelBox(this.body_r4, 20, 43, 2.0f, 12.0f, 1.0f, 6, 2, 2, -0.5f, false));
        this.Leg3 = new ModelRenderer((ModelBase)this);
        this.Leg3.func_78793_a(0.0f, -6.0f, 1.0f);
        this.LeftLegs.func_78792_a(this.Leg3);
        this.Leg3.field_78804_l.add(new ModelBox(this.Leg3, 20, 43, -1.0f, -1.0f, -0.5f, 6, 2, 2, -0.5f, false));
        this.Leg4 = new ModelRenderer((ModelBase)this);
        this.Leg4.func_78793_a(0.0f, -9.0f, 1.0f);
        this.LeftLegs.func_78792_a(this.Leg4);
        this.Leg4.field_78804_l.add(new ModelBox(this.Leg4, 20, 43, -1.0f, -1.0f, -0.5f, 6, 2, 2, -0.5f, false));
        this.Leg5 = new ModelRenderer((ModelBase)this);
        this.Leg5.func_78793_a(-1.0f, 3.0f, -1.0f);
        this.LeftLegs.func_78792_a(this.Leg5);
        this.body_r5 = new ModelRenderer((ModelBase)this);
        this.body_r5.func_78793_a(-3.0f, -12.0f, 1.5f);
        this.Leg5.func_78792_a(this.body_r5);
        this.setRotationAngle(this.body_r5, -0.6981f, 0.0f, 0.0f);
        this.body_r5.field_78804_l.add(new ModelBox(this.body_r5, 20, 43, 2.0f, 9.0f, 6.0f, 6, 2, 2, -0.5f, false));
        this.Leg6 = new ModelRenderer((ModelBase)this);
        this.Leg6.func_78793_a(-1.0f, 6.0f, -3.0f);
        this.LeftLegs.func_78792_a(this.Leg6);
        this.body_r6 = new ModelRenderer((ModelBase)this);
        this.body_r6.func_78793_a(-3.0f, -12.0f, 1.5f);
        this.Leg6.func_78792_a(this.body_r6);
        this.setRotationAngle(this.body_r6, -0.6981f, 0.0f, 0.0f);
        this.body_r6.field_78804_l.add(new ModelBox(this.body_r6, 20, 43, 2.0f, 9.0f, 6.0f, 6, 2, 2, -0.5f, false));
        this.RightLegs = new ModelRenderer((ModelBase)this);
        this.RightLegs.func_78793_a(-3.0f, 23.0f, -1.5f);
        this.body.func_78792_a(this.RightLegs);
        this.Leg7 = new ModelRenderer((ModelBase)this);
        this.Leg7.func_78793_a(0.0f, 0.0f, 0.0f);
        this.RightLegs.func_78792_a(this.Leg7);
        this.body_r7 = new ModelRenderer((ModelBase)this);
        this.body_r7.func_78793_a(3.0f, -13.0f, 1.5f);
        this.Leg7.func_78792_a(this.body_r7);
        this.setRotationAngle(this.body_r7, -0.2618f, 0.0f, 0.0f);
        this.body_r7.field_78804_l.add(new ModelBox(this.body_r7, 20, 43, -8.0f, 12.0f, 1.0f, 6, 2, 2, -0.5f, true));
        this.Leg8 = new ModelRenderer((ModelBase)this);
        this.Leg8.func_78793_a(0.0f, -3.0f, 1.0f);
        this.RightLegs.func_78792_a(this.Leg8);
        this.body_r8 = new ModelRenderer((ModelBase)this);
        this.body_r8.func_78793_a(3.0f, -13.0f, 1.5f);
        this.Leg8.func_78792_a(this.body_r8);
        this.setRotationAngle(this.body_r8, -0.2618f, 0.0f, 0.0f);
        this.body_r8.field_78804_l.add(new ModelBox(this.body_r8, 20, 43, -8.0f, 12.0f, 1.0f, 6, 2, 2, -0.5f, true));
        this.Leg9 = new ModelRenderer((ModelBase)this);
        this.Leg9.func_78793_a(0.0f, -6.0f, 1.0f);
        this.RightLegs.func_78792_a(this.Leg9);
        this.Leg9.field_78804_l.add(new ModelBox(this.Leg9, 20, 43, -5.0f, -1.0f, -0.5f, 6, 2, 2, -0.5f, true));
        this.Leg10 = new ModelRenderer((ModelBase)this);
        this.Leg10.func_78793_a(0.0f, -9.0f, 1.0f);
        this.RightLegs.func_78792_a(this.Leg10);
        this.Leg10.field_78804_l.add(new ModelBox(this.Leg10, 20, 43, -5.0f, -1.0f, -0.5f, 6, 2, 2, -0.5f, true));
        this.Leg11 = new ModelRenderer((ModelBase)this);
        this.Leg11.func_78793_a(1.0f, 3.0f, -1.0f);
        this.RightLegs.func_78792_a(this.Leg11);
        this.body_r9 = new ModelRenderer((ModelBase)this);
        this.body_r9.func_78793_a(3.0f, -12.0f, 1.5f);
        this.Leg11.func_78792_a(this.body_r9);
        this.setRotationAngle(this.body_r9, -0.6981f, 0.0f, 0.0f);
        this.body_r9.field_78804_l.add(new ModelBox(this.body_r9, 20, 43, -8.0f, 9.0f, 6.0f, 6, 2, 2, -0.5f, true));
        this.Leg12 = new ModelRenderer((ModelBase)this);
        this.Leg12.func_78793_a(1.0f, 6.0f, -3.0f);
        this.RightLegs.func_78792_a(this.Leg12);
        this.body_r10 = new ModelRenderer((ModelBase)this);
        this.body_r10.func_78793_a(3.0f, -12.0f, 1.5f);
        this.Leg12.func_78792_a(this.body_r10);
        this.setRotationAngle(this.body_r10, -0.6981f, 0.0f, 0.0f);
        this.body_r10.field_78804_l.add(new ModelBox(this.body_r10, 20, 43, -8.0f, 9.0f, 6.0f, 6, 2, 2, -0.5f, true));
        this.leftWing = new ModelRenderer((ModelBase)this);
        this.leftWing.func_78793_a(2.0f, 11.0f, 1.0f);
        this.body.func_78792_a(this.leftWing);
        this.leftWing.field_78804_l.add(new ModelBox(this.leftWing, 42, 0, -1.0f, -8.0f, 1.5f, 10, 16, 1, 0.0f, true));
        this.leftWingMid = new ModelRenderer((ModelBase)this);
        this.leftWingMid.func_78793_a(8.0f, -1.0f, 2.0f);
        this.leftWing.func_78792_a(this.leftWingMid);
        this.leftWingMid.field_78804_l.add(new ModelBox(this.leftWingMid, 46, 18, 0.0f, -6.0f, -0.5f, 8, 12, 1, 0.0f, true));
        this.leftWingTip = new ModelRenderer((ModelBase)this);
        this.leftWingTip.func_78793_a(7.0f, 0.0f, 0.0f);
        this.leftWingMid.func_78792_a(this.leftWingTip);
        this.leftWingTip.field_78804_l.add(new ModelBox(this.leftWingTip, 38, 32, 0.0f, -5.0f, -0.5f, 12, 10, 1, 0.0f, true));
        this.rightWing = new ModelRenderer((ModelBase)this);
        this.rightWing.func_78793_a(-2.0f, 11.0f, 1.0f);
        this.body.func_78792_a(this.rightWing);
        this.rightWing.field_78804_l.add(new ModelBox(this.rightWing, 42, 0, -9.0f, -8.0f, 1.5f, 10, 16, 1, 0.0f, false));
        this.rightWingMid = new ModelRenderer((ModelBase)this);
        this.rightWingMid.func_78793_a(-8.0f, -1.0f, 2.0f);
        this.rightWing.func_78792_a(this.rightWingMid);
        this.rightWingMid.field_78804_l.add(new ModelBox(this.rightWingMid, 46, 18, -8.0f, -6.0f, -0.5f, 8, 12, 1, 0.0f, false));
        this.rightWingTip = new ModelRenderer((ModelBase)this);
        this.rightWingTip.func_78793_a(-7.0f, 0.0f, 0.0f);
        this.rightWingMid.func_78792_a(this.rightWingTip);
        this.rightWingTip.field_78804_l.add(new ModelBox(this.rightWingTip, 38, 32, -12.0f, -5.0f, -0.5f, 12, 10, 1, 0.0f, false));
        this.leftBones.add(this.Leg1);
        this.leftBones.add(this.Leg2);
        this.leftBones.add(this.Leg3);
        this.leftBones.add(this.Leg4);
        this.leftBones.add(this.Leg5);
        this.leftBones.add(this.Leg6);
        this.rightBones.add(this.Leg7);
        this.rightBones.add(this.Leg8);
        this.rightBones.add(this.Leg9);
        this.rightBones.add(this.Leg10);
        this.rightBones.add(this.Leg11);
        this.rightBones.add(this.Leg12);
        Collections.shuffle(this.leftBones);
        Collections.shuffle(this.rightBones);
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.head.func_78785_a(f5);
        this.body.func_78785_a(f5);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.body.field_78795_f = 0.7f + Mth.func_76134_b((float)(ageInTicks * 0.05f)) * 0.5f;
        this.leftWing.field_78796_g = Mth.func_76134_b((float)(ageInTicks * 0.1f)) * 0.5f;
        this.leftWingMid.field_78796_g = Mth.func_76134_b((float)(ageInTicks * 0.1f)) * 0.2f;
        this.leftWingTip.field_78796_g = Mth.func_76134_b((float)(ageInTicks * 0.1f)) * 0.1f;
        this.rightWing.field_78796_g = -this.leftWing.field_78796_g;
        this.rightWingMid.field_78796_g = -this.leftWingMid.field_78796_g;
        this.rightWingTip.field_78796_g = -this.leftWingTip.field_78796_g;
        for (int i = 0; i < this.leftBones.size(); ++i) {
            ModelRenderer leftseg = this.leftBones.get(i);
            ModelRenderer rightseg = this.rightBones.get(i);
            leftseg.field_78796_g = 0.45f + 0.25f * Mth.func_76126_a((float)(0.25f * (ageInTicks + (float)(i * 5))));
            rightseg.field_78796_g = -0.45f + 0.25f * Mth.func_76126_a((float)(0.25f * (ageInTicks + (float)(i * 5))));
        }
        this.FaceTendril1.field_78795_f = Mth.func_76134_b((float)(ageInTicks * 0.2f)) * 0.2f;
        this.FaceTendril2.field_78795_f = Mth.func_76126_a((float)(ageInTicks * 0.2f)) * 0.2f;
        this.FaceTendril3.field_78795_f = -Mth.func_76126_a((float)(ageInTicks * 0.2f)) * 0.2f;
        this.FaceTendril4.field_78795_f = -Mth.func_76134_b((float)(ageInTicks * 0.2f)) * 0.2f;
    }
}

