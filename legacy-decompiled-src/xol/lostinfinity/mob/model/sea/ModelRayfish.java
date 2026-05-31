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

public class ModelRayfish
extends ModelBase {
    private final ModelRenderer BodyFront;
    private final ModelRenderer BodyMiddle;
    private final ModelRenderer TopFin;
    private final ModelRenderer TopFin2;
    private final ModelRenderer TopFin3;
    private final ModelRenderer BottomFin;
    private final ModelRenderer BottomFin2;
    private final ModelRenderer BottomFin3;
    private final ModelRenderer TailFin1;
    private final ModelRenderer TailFin2;

    public ModelRayfish() {
        this.field_78090_t = 128;
        this.field_78089_u = 64;
        this.BodyFront = new ModelRenderer((ModelBase)this);
        this.BodyFront.func_78793_a(0.0f, 7.0f, -4.0f);
        this.BodyFront.field_78804_l.add(new ModelBox(this.BodyFront, 0, 29, -2.0f, -5.0f, -4.0f, 4, 10, 8, 0.0f, false));
        this.BodyMiddle = new ModelRenderer((ModelBase)this);
        this.BodyMiddle.func_78793_a(0.0f, -1.0f, 4.0f);
        this.BodyFront.func_78792_a(this.BodyMiddle);
        this.BodyMiddle.field_78804_l.add(new ModelBox(this.BodyMiddle, 29, 15, -2.0f, -5.0f, 0.0f, 4, 12, 21, 0.0f, false));
        this.TopFin = new ModelRenderer((ModelBase)this);
        this.TopFin.func_78793_a(0.0f, -3.0f, 3.0f);
        this.BodyMiddle.func_78792_a(this.TopFin);
        this.setRotationAngle(this.TopFin, 0.6981f, 0.0f, 0.0f);
        this.TopFin.field_78804_l.add(new ModelBox(this.TopFin, 68, 0, -2.0f, -3.0f, -1.0f, 4, 6, 14, -0.5f, false));
        this.TopFin2 = new ModelRenderer((ModelBase)this);
        this.TopFin2.func_78793_a(0.0f, 0.0f, 12.0f);
        this.TopFin.func_78792_a(this.TopFin2);
        this.setRotationAngle(this.TopFin2, -0.3491f, 0.0f, 0.0f);
        this.TopFin2.field_78804_l.add(new ModelBox(this.TopFin2, 92, 7, -2.0f, -3.0f, -1.0f, 4, 6, 14, -0.6f, false));
        this.TopFin3 = new ModelRenderer((ModelBase)this);
        this.TopFin3.func_78793_a(0.0f, 0.0f, 11.0f);
        this.TopFin2.func_78792_a(this.TopFin3);
        this.setRotationAngle(this.TopFin3, -0.3491f, 0.0f, 0.0f);
        this.TopFin3.field_78804_l.add(new ModelBox(this.TopFin3, 85, 28, -2.0f, -3.0f, -1.0f, 4, 6, 14, -0.7f, false));
        this.TopFin3.field_78804_l.add(new ModelBox(this.TopFin3, 0, 23, -1.0f, -7.0f, -1.0f, 1, 15, 26, 0.0f, false));
        this.BottomFin = new ModelRenderer((ModelBase)this);
        this.BottomFin.func_78793_a(0.0f, 5.0f, 3.0f);
        this.BodyMiddle.func_78792_a(this.BottomFin);
        this.setRotationAngle(this.BottomFin, -0.6981f, 0.0f, 0.0f);
        this.BottomFin.field_78804_l.add(new ModelBox(this.BottomFin, 68, 0, -2.0f, -3.0f, -1.0f, 4, 6, 14, -0.5f, false));
        this.BottomFin2 = new ModelRenderer((ModelBase)this);
        this.BottomFin2.func_78793_a(0.0f, 0.0f, 12.0f);
        this.BottomFin.func_78792_a(this.BottomFin2);
        this.setRotationAngle(this.BottomFin2, 0.3491f, 0.0f, 0.0f);
        this.BottomFin2.field_78804_l.add(new ModelBox(this.BottomFin2, 92, 7, -2.0f, -3.0f, -1.0f, 4, 6, 14, -0.6f, false));
        this.BottomFin3 = new ModelRenderer((ModelBase)this);
        this.BottomFin3.func_78793_a(0.0f, 0.0f, 11.0f);
        this.BottomFin2.func_78792_a(this.BottomFin3);
        this.setRotationAngle(this.BottomFin3, 0.3491f, 0.0f, 0.0f);
        this.BottomFin3.field_78804_l.add(new ModelBox(this.BottomFin3, 85, 28, -2.0f, -3.0f, -1.0f, 4, 6, 14, -0.7f, false));
        this.BottomFin3.field_78804_l.add(new ModelBox(this.BottomFin3, 55, 23, -1.0f, -7.0f, -1.0f, 1, 15, 26, 0.0f, false));
        this.TailFin1 = new ModelRenderer((ModelBase)this);
        this.TailFin1.func_78793_a(-0.5f, -2.0f, 21.0f);
        this.BodyMiddle.func_78792_a(this.TailFin1);
        this.TailFin1.field_78804_l.add(new ModelBox(this.TailFin1, 0, 2, -0.5f, -2.5f, 0.0f, 1, 5, 15, 0.0f, false));
        this.TailFin2 = new ModelRenderer((ModelBase)this);
        this.TailFin2.func_78793_a(-0.5f, 4.0f, 21.0f);
        this.BodyMiddle.func_78792_a(this.TailFin2);
        this.TailFin2.field_78804_l.add(new ModelBox(this.TailFin2, 0, 2, -0.5f, -2.5f, 0.0f, 1, 5, 15, 0.0f, false));
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
        float bodySpeed = 0.1f;
        float bodyRange = 0.15f;
        float smallFinSpeed = 0.3f;
        float smallFinRange = 0.3f;
        float bigFinSpeed = 0.05f;
        float bigFinRange = 0.45f;
        float swingScalar = 1.0E-4f;
        int ageOffsetSmallFin = 4;
        int ageOffsetBigFin = 12;
        if (limbSwing > 0.0f) {
            smallFinSpeed += limbSwing * swingScalar;
            bigFinSpeed += limbSwing * swingScalar;
        }
        this.BodyMiddle.field_78796_g = Mth.func_76126_a((float)(ageInTicks * bodySpeed)) * bodyRange;
        this.TailFin1.field_78796_g = Mth.func_76126_a((float)((ageInTicks + (float)ageOffsetSmallFin) * smallFinSpeed)) * smallFinRange;
        this.TailFin2.field_78796_g = -Mth.func_76126_a((float)(ageInTicks * smallFinSpeed)) * smallFinRange;
        this.TopFin.field_78796_g = Mth.func_76126_a((float)((ageInTicks + (float)ageOffsetBigFin) * bigFinSpeed)) * bigFinRange;
        this.TopFin2.field_78796_g = Mth.func_76126_a((float)((ageInTicks + (float)ageOffsetBigFin) * bigFinSpeed)) * bigFinRange;
        this.TopFin3.field_78796_g = Mth.func_76126_a((float)((ageInTicks + (float)ageOffsetBigFin) * bigFinSpeed)) * bigFinRange;
        this.BottomFin.field_78796_g = -Mth.func_76126_a((float)(ageInTicks * bigFinSpeed)) * bigFinRange;
        this.BottomFin2.field_78796_g = -Mth.func_76126_a((float)(ageInTicks * bigFinSpeed)) * bigFinRange;
        this.BottomFin3.field_78796_g = -Mth.func_76126_a((float)(ageInTicks * bigFinSpeed)) * bigFinRange;
    }
}

