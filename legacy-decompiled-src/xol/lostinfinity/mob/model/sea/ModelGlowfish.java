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
package xol.lostinfinity.mob.model.sea;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;

public class ModelGlowfish
extends ModelBase {
    private final ModelRenderer BodyFront;
    private final ModelRenderer BodyMiddle;
    private final ModelRenderer FinLeft;
    private final ModelRenderer FinRight;
    private final ModelRenderer BodyEnd;
    private final ModelRenderer TailfinLeft;
    private final ModelRenderer TailfinRight;
    private final ModelRenderer BodyEnd2;
    private final ModelRenderer TailfinLeft2;
    private final ModelRenderer TailfinRight2;

    public ModelGlowfish() {
        this.field_78090_t = 128;
        this.field_78089_u = 64;
        this.BodyFront = new ModelRenderer((ModelBase)this);
        this.BodyFront.func_78793_a(0.0f, 17.0f, 0.0f);
        this.BodyFront.field_78804_l.add(new ModelBox(this.BodyFront, 0, 0, -2.0f, -5.0f, 2.0f, 4, 10, 2, 0.0f, false));
        this.BodyFront.field_78804_l.add(new ModelBox(this.BodyFront, 33, 1, -1.0f, -10.0f, 2.0f, 2, 5, 2, 0.0f, false));
        this.BodyFront.field_78804_l.add(new ModelBox(this.BodyFront, 42, 1, -1.0f, -12.0f, -1.0f, 2, 2, 5, 0.0f, false));
        this.BodyFront.field_78804_l.add(new ModelBox(this.BodyFront, 59, 1, -1.0f, 10.0f, -1.0f, 2, 2, 5, 0.0f, false));
        this.BodyFront.field_78804_l.add(new ModelBox(this.BodyFront, 33, 14, -1.0f, 5.0f, 2.0f, 2, 5, 2, 0.0f, false));
        this.BodyFront.field_78804_l.add(new ModelBox(this.BodyFront, 0, 13, -2.0f, -5.0f, -10.0f, 4, 10, 2, 0.0f, false));
        this.BodyFront.field_78804_l.add(new ModelBox(this.BodyFront, 14, 0, -2.0f, -7.0f, -8.0f, 4, 2, 10, 0.0f, false));
        this.BodyFront.field_78804_l.add(new ModelBox(this.BodyFront, 14, 13, -2.0f, 5.0f, -8.0f, 4, 2, 10, 0.0f, false));
        this.BodyFront.field_78804_l.add(new ModelBox(this.BodyFront, 0, 26, -0.5f, -4.5f, -7.5f, 1, 9, 9, 0.0f, false));
        this.BodyMiddle = new ModelRenderer((ModelBase)this);
        this.BodyMiddle.func_78793_a(0.0f, -1.0f, 4.0f);
        this.BodyFront.func_78792_a(this.BodyMiddle);
        this.BodyMiddle.field_78804_l.add(new ModelBox(this.BodyMiddle, 74, 29, -2.0f, -5.0f, 0.0f, 4, 12, 23, 0.0f, false));
        this.BodyMiddle.field_78804_l.add(new ModelBox(this.BodyMiddle, 28, 13, -1.0f, -10.0f, 1.0f, 1, 5, 21, 0.0f, false));
        this.FinLeft = new ModelRenderer((ModelBase)this);
        this.FinLeft.func_78793_a(2.0f, 0.5f, 8.0f);
        this.BodyMiddle.func_78792_a(this.FinLeft);
        this.FinLeft.field_78804_l.add(new ModelBox(this.FinLeft, 15, 41, 0.0f, -0.5f, -6.0f, 14, 1, 12, 0.0f, false));
        this.FinRight = new ModelRenderer((ModelBase)this);
        this.FinRight.func_78793_a(-2.0f, 0.5f, 8.0f);
        this.BodyMiddle.func_78792_a(this.FinRight);
        this.FinRight.field_78804_l.add(new ModelBox(this.FinRight, 15, 41, -14.0f, -0.5f, -6.0f, 14, 1, 12, 0.0f, true));
        this.BodyEnd = new ModelRenderer((ModelBase)this);
        this.BodyEnd.func_78793_a(0.0f, -2.0f, 23.0f);
        this.BodyMiddle.func_78792_a(this.BodyEnd);
        this.BodyEnd.field_78804_l.add(new ModelBox(this.BodyEnd, 57, 25, -1.5f, -2.0f, 0.0f, 3, 4, 16, 0.0f, false));
        this.TailfinLeft = new ModelRenderer((ModelBase)this);
        this.TailfinLeft.func_78793_a(1.0f, -0.5f, 8.0f);
        this.BodyEnd.func_78792_a(this.TailfinLeft);
        this.TailfinLeft.field_78804_l.add(new ModelBox(this.TailfinLeft, 36, 55, 0.0f, -0.5f, -4.0f, 10, 1, 8, 0.0f, false));
        this.TailfinRight = new ModelRenderer((ModelBase)this);
        this.TailfinRight.func_78793_a(-1.0f, -0.5f, 8.0f);
        this.BodyEnd.func_78792_a(this.TailfinRight);
        this.TailfinRight.field_78804_l.add(new ModelBox(this.TailfinRight, 36, 55, -10.0f, -0.5f, -4.0f, 10, 1, 8, 0.0f, true));
        this.BodyEnd2 = new ModelRenderer((ModelBase)this);
        this.BodyEnd2.func_78793_a(0.0f, 4.0f, 23.0f);
        this.BodyMiddle.func_78792_a(this.BodyEnd2);
        this.BodyEnd2.field_78804_l.add(new ModelBox(this.BodyEnd2, 87, 4, -1.5f, -2.0f, 0.0f, 3, 4, 16, 0.0f, false));
        this.TailfinLeft2 = new ModelRenderer((ModelBase)this);
        this.TailfinLeft2.func_78793_a(1.0f, -0.5f, 8.0f);
        this.BodyEnd2.func_78792_a(this.TailfinLeft2);
        this.TailfinLeft2.field_78804_l.add(new ModelBox(this.TailfinLeft2, 36, 55, 0.0f, -0.5f, -4.0f, 10, 1, 8, 0.0f, false));
        this.TailfinRight2 = new ModelRenderer((ModelBase)this);
        this.TailfinRight2.func_78793_a(-1.0f, -0.5f, 8.0f);
        this.BodyEnd2.func_78792_a(this.TailfinRight2);
        this.TailfinRight2.field_78804_l.add(new ModelBox(this.TailfinRight2, 36, 55, -10.0f, -0.5f, -4.0f, 10, 1, 8, 0.0f, true));
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.BodyFront.func_78785_a(f5);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        float tailSpeed = 0.15f;
        float tailRange = 0.5f;
        float frontFinSpeed = 0.15f;
        float frontFinRange = 0.4f;
        float rearFinSpeed = 0.65f;
        float rearFinRange = 0.3f;
        int ageOffset = 4;
        this.BodyEnd.field_78796_g = Mth.func_76134_b((float)(ageInTicks * tailSpeed)) * tailRange;
        this.BodyEnd2.field_78796_g = Mth.func_76134_b((float)(ageInTicks * tailSpeed)) * tailRange;
        this.BodyMiddle.field_78796_g = -Mth.func_76126_a((float)(ageInTicks * tailSpeed)) * tailRange;
        this.FinLeft.field_78808_h = Mth.func_76126_a((float)((ageInTicks + (float)ageOffset) * frontFinSpeed)) * frontFinRange;
        this.FinRight.field_78808_h = -Mth.func_76126_a((float)((ageInTicks + (float)ageOffset) * frontFinSpeed)) * frontFinRange;
        this.TailfinLeft.field_78808_h = Mth.func_76126_a((float)(ageInTicks * rearFinSpeed)) * rearFinRange;
        this.TailfinRight.field_78808_h = -Mth.func_76126_a((float)(ageInTicks * rearFinSpeed)) * rearFinRange;
        this.TailfinLeft2.field_78808_h = Mth.func_76134_b((float)(ageInTicks * rearFinSpeed)) * rearFinRange;
        this.TailfinRight2.field_78808_h = -Mth.func_76134_b((float)(ageInTicks * rearFinSpeed)) * rearFinRange;
    }
}

