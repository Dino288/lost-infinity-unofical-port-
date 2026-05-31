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

public class ModelSkycrab
extends ModelBase {
    private final ModelRenderer RotGroup1;
    private final ModelRenderer smallteeth;
    private final ModelRenderer Leg5;
    private final ModelRenderer cube_r1;
    private final ModelRenderer Leg6;
    private final ModelRenderer cube_r2;
    private final ModelRenderer Leg7;
    private final ModelRenderer cube_r3;
    private final ModelRenderer Leg8;
    private final ModelRenderer cube_r4;
    private final ModelRenderer Leg1;
    private final ModelRenderer cube_r5;
    private final ModelRenderer Leg3;
    private final ModelRenderer cube_r6;
    private final ModelRenderer Leg4;
    private final ModelRenderer cube_r7;
    private final ModelRenderer Leg2;
    private final ModelRenderer cube_r8;
    private final ModelRenderer RotGroup2;

    public ModelSkycrab() {
        this.field_78090_t = 256;
        this.field_78089_u = 128;
        this.RotGroup1 = new ModelRenderer((ModelBase)this);
        this.RotGroup1.func_78793_a(0.0f, 7.0f, 0.0f);
        this.RotGroup1.field_78804_l.add(new ModelBox(this.RotGroup1, 0, 38, -16.0f, -7.0f, -16.0f, 32, 6, 32, 0.0f, false));
        this.RotGroup1.field_78804_l.add(new ModelBox(this.RotGroup1, 48, 88, 9.0f, -1.0f, -16.0f, 7, 2, 32, 0.0f, false));
        this.RotGroup1.field_78804_l.add(new ModelBox(this.RotGroup1, 96, 90, -9.0f, -1.0f, -16.0f, 18, 2, 7, 0.0f, false));
        this.RotGroup1.field_78804_l.add(new ModelBox(this.RotGroup1, 96, 79, -9.0f, -1.0f, 9.0f, 18, 2, 7, 0.0f, false));
        this.RotGroup1.field_78804_l.add(new ModelBox(this.RotGroup1, 0, 92, -16.0f, -1.0f, -16.0f, 7, 2, 32, 0.0f, false));
        this.RotGroup1.field_78804_l.add(new ModelBox(this.RotGroup1, 34, 78, -5.0f, -1.0f, -5.0f, 10, 2, 10, 0.0f, false));
        this.RotGroup1.field_78804_l.add(new ModelBox(this.RotGroup1, 0, 78, -4.0f, 1.0f, -4.0f, 8, 1, 8, 0.0f, false));
        this.RotGroup1.field_78804_l.add(new ModelBox(this.RotGroup1, 0, 0, -16.0f, -14.0f, -16.0f, 32, 4, 32, 0.0f, false));
        this.smallteeth = new ModelRenderer((ModelBase)this);
        this.smallteeth.func_78793_a(-8.0f, 4.0f, 8.0f);
        this.RotGroup1.func_78792_a(this.smallteeth);
        this.smallteeth.field_78804_l.add(new ModelBox(this.smallteeth, 0, 78, 3.0f, -3.0f, -6.0f, 1, 2, 1, 0.0f, false));
        this.smallteeth.field_78804_l.add(new ModelBox(this.smallteeth, 0, 78, 3.0f, -3.0f, -8.5f, 1, 2, 1, 0.0f, false));
        this.smallteeth.field_78804_l.add(new ModelBox(this.smallteeth, 0, 78, 3.0f, -3.0f, -11.0f, 1, 2, 1, 0.0f, false));
        this.smallteeth.field_78804_l.add(new ModelBox(this.smallteeth, 0, 78, 5.0f, -3.0f, -13.0f, 1, 2, 1, 0.0f, false));
        this.smallteeth.field_78804_l.add(new ModelBox(this.smallteeth, 0, 78, 7.5f, -3.0f, -13.0f, 1, 2, 1, 0.0f, false));
        this.smallteeth.field_78804_l.add(new ModelBox(this.smallteeth, 0, 78, 10.0f, -3.0f, -13.0f, 1, 2, 1, 0.0f, false));
        this.smallteeth.field_78804_l.add(new ModelBox(this.smallteeth, 0, 78, 12.0f, -3.0f, -11.0f, 1, 2, 1, 0.0f, false));
        this.smallteeth.field_78804_l.add(new ModelBox(this.smallteeth, 0, 78, 12.0f, -3.0f, -8.5f, 1, 2, 1, 0.0f, false));
        this.smallteeth.field_78804_l.add(new ModelBox(this.smallteeth, 0, 78, 12.0f, -3.0f, -6.0f, 1, 2, 1, 0.0f, false));
        this.smallteeth.field_78804_l.add(new ModelBox(this.smallteeth, 0, 78, 10.0f, -3.0f, -4.0f, 1, 2, 1, 0.0f, false));
        this.smallteeth.field_78804_l.add(new ModelBox(this.smallteeth, 0, 78, 7.5f, -3.0f, -4.0f, 1, 2, 1, 0.0f, false));
        this.smallteeth.field_78804_l.add(new ModelBox(this.smallteeth, 0, 78, 5.0f, -3.0f, -4.0f, 1, 2, 1, 0.0f, false));
        this.Leg5 = new ModelRenderer((ModelBase)this);
        this.Leg5.func_78793_a(4.0f, 1.0f, -12.0f);
        this.RotGroup1.func_78792_a(this.Leg5);
        this.setRotationAngle(this.Leg5, -1.5708f, 1.5708f, -1.5708f);
        this.Leg5.field_78804_l.add(new ModelBox(this.Leg5, 0, 50, -3.0f, -1.0f, -3.0f, 6, 11, 6, 0.0f, false));
        this.Leg5.field_78804_l.add(new ModelBox(this.Leg5, 98, 13, -9.0f, -2.0f, -1.0f, 8, 17, 1, 0.0f, false));
        this.cube_r1 = new ModelRenderer((ModelBase)this);
        this.cube_r1.func_78793_a(0.5f, 15.5f, 0.0f);
        this.Leg5.func_78792_a(this.cube_r1);
        this.setRotationAngle(this.cube_r1, 0.0f, 0.0f, 0.6109f);
        this.cube_r1.field_78804_l.add(new ModelBox(this.cube_r1, 98, 51, -6.5f, -6.5f, -2.5f, 5, 11, 5, 0.0f, false));
        this.Leg6 = new ModelRenderer((ModelBase)this);
        this.Leg6.func_78793_a(-4.0f, 1.0f, -12.0f);
        this.RotGroup1.func_78792_a(this.Leg6);
        this.setRotationAngle(this.Leg6, -1.5708f, 1.5708f, -1.5708f);
        this.Leg6.field_78804_l.add(new ModelBox(this.Leg6, 0, 50, -3.0f, -1.0f, -3.0f, 6, 11, 6, 0.0f, false));
        this.Leg6.field_78804_l.add(new ModelBox(this.Leg6, 98, 13, -9.0f, -2.0f, -1.0f, 8, 17, 1, 0.0f, false));
        this.cube_r2 = new ModelRenderer((ModelBase)this);
        this.cube_r2.func_78793_a(0.5f, 15.5f, 0.0f);
        this.Leg6.func_78792_a(this.cube_r2);
        this.setRotationAngle(this.cube_r2, 0.0f, 0.0f, 0.6109f);
        this.cube_r2.field_78804_l.add(new ModelBox(this.cube_r2, 98, 51, -6.5f, -6.5f, -2.5f, 5, 11, 5, 0.0f, false));
        this.Leg7 = new ModelRenderer((ModelBase)this);
        this.Leg7.func_78793_a(-4.0f, 1.0f, 12.0f);
        this.RotGroup1.func_78792_a(this.Leg7);
        this.setRotationAngle(this.Leg7, 1.5708f, -1.5708f, -1.5708f);
        this.Leg7.field_78804_l.add(new ModelBox(this.Leg7, 0, 50, -3.0f, -1.0f, -3.0f, 6, 11, 6, 0.0f, false));
        this.Leg7.field_78804_l.add(new ModelBox(this.Leg7, 98, 13, -9.0f, -2.0f, 0.0f, 8, 17, 1, 0.0f, false));
        this.cube_r3 = new ModelRenderer((ModelBase)this);
        this.cube_r3.func_78793_a(0.5f, 15.5f, 0.0f);
        this.Leg7.func_78792_a(this.cube_r3);
        this.setRotationAngle(this.cube_r3, 0.0f, 0.0f, 0.6109f);
        this.cube_r3.field_78804_l.add(new ModelBox(this.cube_r3, 98, 51, -6.5f, -6.5f, -2.5f, 5, 11, 5, 0.0f, false));
        this.Leg8 = new ModelRenderer((ModelBase)this);
        this.Leg8.func_78793_a(4.0f, 1.0f, 12.0f);
        this.RotGroup1.func_78792_a(this.Leg8);
        this.setRotationAngle(this.Leg8, 1.5708f, -1.5708f, -1.5708f);
        this.Leg8.field_78804_l.add(new ModelBox(this.Leg8, 0, 50, -3.0f, -1.0f, -3.0f, 6, 11, 6, 0.0f, false));
        this.Leg8.field_78804_l.add(new ModelBox(this.Leg8, 98, 13, -9.0f, -2.0f, 0.0f, 8, 17, 1, 0.0f, false));
        this.cube_r4 = new ModelRenderer((ModelBase)this);
        this.cube_r4.func_78793_a(0.5f, 15.5f, 0.0f);
        this.Leg8.func_78792_a(this.cube_r4);
        this.setRotationAngle(this.cube_r4, 0.0f, 0.0f, 0.6109f);
        this.cube_r4.field_78804_l.add(new ModelBox(this.cube_r4, 98, 51, -6.5f, -6.5f, -2.5f, 5, 11, 5, 0.0f, false));
        this.Leg1 = new ModelRenderer((ModelBase)this);
        this.Leg1.func_78793_a(12.0f, 1.0f, -4.0f);
        this.RotGroup1.func_78792_a(this.Leg1);
        this.Leg1.field_78804_l.add(new ModelBox(this.Leg1, 0, 50, -3.0f, -1.0f, -3.0f, 6, 11, 6, 0.0f, false));
        this.Leg1.field_78804_l.add(new ModelBox(this.Leg1, 98, 13, -9.0f, -2.0f, -1.0f, 8, 17, 1, 0.0f, false));
        this.cube_r5 = new ModelRenderer((ModelBase)this);
        this.cube_r5.func_78793_a(0.5f, 15.5f, 0.0f);
        this.Leg1.func_78792_a(this.cube_r5);
        this.setRotationAngle(this.cube_r5, 0.0f, 0.0f, 0.6109f);
        this.cube_r5.field_78804_l.add(new ModelBox(this.cube_r5, 98, 51, -6.5f, -6.5f, -2.5f, 5, 11, 5, 0.0f, false));
        this.Leg3 = new ModelRenderer((ModelBase)this);
        this.Leg3.func_78793_a(-12.0f, 1.0f, -4.0f);
        this.RotGroup1.func_78792_a(this.Leg3);
        this.Leg3.field_78804_l.add(new ModelBox(this.Leg3, 0, 50, -3.0f, -1.0f, -3.0f, 6, 11, 6, 0.0f, true));
        this.Leg3.field_78804_l.add(new ModelBox(this.Leg3, 98, 13, 1.0f, -2.0f, -1.0f, 8, 17, 1, 0.0f, true));
        this.cube_r6 = new ModelRenderer((ModelBase)this);
        this.cube_r6.func_78793_a(-0.5f, 15.5f, 0.0f);
        this.Leg3.func_78792_a(this.cube_r6);
        this.setRotationAngle(this.cube_r6, 0.0f, 0.0f, -0.6109f);
        this.cube_r6.field_78804_l.add(new ModelBox(this.cube_r6, 98, 51, 1.5f, -6.5f, -2.5f, 5, 11, 5, 0.0f, true));
        this.Leg4 = new ModelRenderer((ModelBase)this);
        this.Leg4.func_78793_a(-12.0f, 1.0f, 4.0f);
        this.RotGroup1.func_78792_a(this.Leg4);
        this.Leg4.field_78804_l.add(new ModelBox(this.Leg4, 0, 50, -3.0f, -1.0f, -3.0f, 6, 11, 6, 0.0f, true));
        this.Leg4.field_78804_l.add(new ModelBox(this.Leg4, 98, 13, 1.0f, -2.0f, -1.0f, 8, 17, 1, 0.0f, true));
        this.cube_r7 = new ModelRenderer((ModelBase)this);
        this.cube_r7.func_78793_a(-0.5f, 15.5f, 0.0f);
        this.Leg4.func_78792_a(this.cube_r7);
        this.setRotationAngle(this.cube_r7, 0.0f, 0.0f, -0.6109f);
        this.cube_r7.field_78804_l.add(new ModelBox(this.cube_r7, 98, 51, 1.5f, -6.5f, -2.5f, 5, 11, 5, 0.0f, true));
        this.Leg2 = new ModelRenderer((ModelBase)this);
        this.Leg2.func_78793_a(12.0f, 1.0f, 4.0f);
        this.RotGroup1.func_78792_a(this.Leg2);
        this.Leg2.field_78804_l.add(new ModelBox(this.Leg2, 0, 50, -3.0f, -1.0f, -3.0f, 6, 11, 6, 0.0f, false));
        this.Leg2.field_78804_l.add(new ModelBox(this.Leg2, 98, 13, -9.0f, -2.0f, -1.0f, 8, 17, 1, 0.0f, false));
        this.cube_r8 = new ModelRenderer((ModelBase)this);
        this.cube_r8.func_78793_a(0.5f, 15.5f, 0.0f);
        this.Leg2.func_78792_a(this.cube_r8);
        this.setRotationAngle(this.cube_r8, 0.0f, 0.0f, 0.6109f);
        this.cube_r8.field_78804_l.add(new ModelBox(this.cube_r8, 98, 51, -6.5f, -6.5f, -2.5f, 5, 11, 5, 0.0f, false));
        this.RotGroup2 = new ModelRenderer((ModelBase)this);
        this.RotGroup2.func_78793_a(0.0f, 14.0f, 0.0f);
        this.RotGroup2.field_78804_l.add(new ModelBox(this.RotGroup2, 144, 5, -14.0f, -17.0f, -14.0f, 28, 3, 28, 0.0f, false));
        this.RotGroup2.field_78804_l.add(new ModelBox(this.RotGroup2, 144, 38, -14.0f, -25.0f, -14.0f, 28, 4, 28, 0.0f, false));
        this.RotGroup2.field_78804_l.add(new ModelBox(this.RotGroup2, 160, 72, -12.0f, -29.0f, -12.0f, 24, 4, 24, 0.0f, false));
        this.RotGroup2.field_78804_l.add(new ModelBox(this.RotGroup2, 129, 82, -1.0f, -43.0f, -12.0f, 1, 14, 24, 0.0f, false));
        this.RotGroup2.field_78804_l.add(new ModelBox(this.RotGroup2, 182, 105, -12.0f, -43.0f, -1.0f, 24, 14, 1, 0.0f, false));
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.RotGroup1.func_78785_a(f5);
        this.RotGroup2.func_78785_a(f5);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.RotGroup2.field_78796_g = ageInTicks * 0.05f;
        this.RotGroup1.field_78796_g = ageInTicks * -0.025f;
        this.Leg2.field_78808_h = this.Leg1.field_78808_h = -0.35f + 0.35f * Mth.func_76126_a((float)(ageInTicks * 0.1f));
        this.Leg3.field_78808_h = -this.Leg1.field_78808_h;
        this.Leg4.field_78808_h = -this.Leg1.field_78808_h;
        this.Leg6.field_78796_g = this.Leg5.field_78796_g = (float)(1.220796332755361 + (double)(0.35f * Mth.func_76126_a((float)(ageInTicks * 0.1f))));
        this.Leg7.field_78796_g = -this.Leg5.field_78796_g;
        this.Leg8.field_78796_g = -this.Leg5.field_78796_g;
    }
}

