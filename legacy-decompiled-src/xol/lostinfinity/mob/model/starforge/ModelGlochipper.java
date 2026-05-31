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

public class ModelGlochipper
extends ModelBase {
    private final ModelRenderer body;
    private final ModelRenderer mainbody_r1;
    private final ModelRenderer mainbody_r2;
    private final ModelRenderer wing_right;
    private final ModelRenderer cube_r1;
    private final ModelRenderer wing_left;
    private final ModelRenderer cube_r2;
    private final ModelRenderer leg_right;
    private final ModelRenderer cube_r3;
    private final ModelRenderer leg_left;
    private final ModelRenderer cube_r4;
    private final ModelRenderer arm_right;
    private final ModelRenderer cube_r5;
    private final ModelRenderer arm_right2;
    private final ModelRenderer cube_r6;
    private final ModelRenderer arm_left;
    private final ModelRenderer cube_r7;
    private final ModelRenderer arm_left2;
    private final ModelRenderer cube_r8;
    private final ModelRenderer head;

    public ModelGlochipper() {
        this.field_78090_t = 32;
        this.field_78089_u = 16;
        this.body = new ModelRenderer((ModelBase)this);
        this.body.func_78793_a(0.0f, 18.0f, 1.5f);
        this.mainbody_r1 = new ModelRenderer((ModelBase)this);
        this.mainbody_r1.func_78793_a(-1.0f, -2.0f, 2.0f);
        this.body.func_78792_a(this.mainbody_r1);
        this.setRotationAngle(this.mainbody_r1, 0.4363f, 0.0f, 0.0f);
        this.mainbody_r1.field_78804_l.add(new ModelBox(this.mainbody_r1, 20, 0, -1.0f, -2.0f, -1.5f, 4, 6, 2, 0.0f, false));
        this.mainbody_r2 = new ModelRenderer((ModelBase)this);
        this.mainbody_r2.func_78793_a(0.0f, 0.0f, 0.0f);
        this.body.func_78792_a(this.mainbody_r2);
        this.setRotationAngle(this.mainbody_r2, 0.4363f, 0.0f, 0.0f);
        this.mainbody_r2.field_78804_l.add(new ModelBox(this.mainbody_r2, 5, 5, -3.0f, -4.0f, -1.5f, 6, 8, 3, 0.0f, false));
        this.wing_right = new ModelRenderer((ModelBase)this);
        this.wing_right.func_78793_a(-1.0f, -2.0f, 2.0f);
        this.body.func_78792_a(this.wing_right);
        this.cube_r1 = new ModelRenderer((ModelBase)this);
        this.cube_r1.func_78793_a(0.0f, 0.0f, 0.0f);
        this.wing_right.func_78792_a(this.cube_r1);
        this.setRotationAngle(this.cube_r1, 0.4363f, 0.0f, 0.0f);
        this.cube_r1.field_78804_l.add(new ModelBox(this.cube_r1, 24, 9, -4.0f, -1.0f, 0.5f, 3, 3, 1, 0.9f, false));
        this.wing_left = new ModelRenderer((ModelBase)this);
        this.wing_left.func_78793_a(1.0f, -2.0f, 2.0f);
        this.body.func_78792_a(this.wing_left);
        this.cube_r2 = new ModelRenderer((ModelBase)this);
        this.cube_r2.func_78793_a(0.0f, 0.0f, 0.0f);
        this.wing_left.func_78792_a(this.cube_r2);
        this.setRotationAngle(this.cube_r2, 0.4363f, 0.0f, 0.0f);
        this.cube_r2.field_78804_l.add(new ModelBox(this.cube_r2, 24, 9, 1.0f, -1.0f, 0.5f, 3, 3, 1, 0.9f, true));
        this.leg_right = new ModelRenderer((ModelBase)this);
        this.leg_right.func_78793_a(-2.5f, 21.0f, 2.5f);
        this.leg_right.field_78804_l.add(new ModelBox(this.leg_right, 0, 5, -2.5f, -1.0f, -0.5f, 1, 4, 1, -0.25f, false));
        this.cube_r3 = new ModelRenderer((ModelBase)this);
        this.cube_r3.func_78793_a(-2.0f, 0.0f, 0.0f);
        this.leg_right.func_78792_a(this.cube_r3);
        this.setRotationAngle(this.cube_r3, 0.0f, 0.0f, -1.0908f);
        this.cube_r3.field_78804_l.add(new ModelBox(this.cube_r3, 0, 5, 0.0f, -1.0f, -0.5f, 1, 3, 1, -0.1f, false));
        this.leg_left = new ModelRenderer((ModelBase)this);
        this.leg_left.func_78793_a(2.5f, 21.0f, 2.5f);
        this.leg_left.field_78804_l.add(new ModelBox(this.leg_left, 0, 5, 1.5f, -1.0f, -0.5f, 1, 4, 1, -0.25f, true));
        this.cube_r4 = new ModelRenderer((ModelBase)this);
        this.cube_r4.func_78793_a(2.0f, 0.0f, 0.0f);
        this.leg_left.func_78792_a(this.cube_r4);
        this.setRotationAngle(this.cube_r4, 0.0f, 0.0f, 1.0908f);
        this.cube_r4.field_78804_l.add(new ModelBox(this.cube_r4, 0, 5, -1.0f, -1.0f, -0.5f, 1, 3, 1, -0.1f, true));
        this.arm_right = new ModelRenderer((ModelBase)this);
        this.arm_right.func_78793_a(-2.5f, 16.0f, 0.5f);
        this.setRotationAngle(this.arm_right, -0.7854f, 0.0f, 0.0f);
        this.arm_right.field_78804_l.add(new ModelBox(this.arm_right, 0, 11, -2.5f, -1.0f, -0.5f, 1, 4, 1, -0.25f, false));
        this.cube_r5 = new ModelRenderer((ModelBase)this);
        this.cube_r5.func_78793_a(-2.0f, 0.0f, 0.0f);
        this.arm_right.func_78792_a(this.cube_r5);
        this.setRotationAngle(this.cube_r5, 0.0f, 0.0f, -1.0908f);
        this.cube_r5.field_78804_l.add(new ModelBox(this.cube_r5, 0, 11, 0.0f, -1.0f, -0.5f, 1, 3, 1, -0.1f, false));
        this.arm_right2 = new ModelRenderer((ModelBase)this);
        this.arm_right2.func_78793_a(-2.5f, 18.0f, 1.5f);
        this.setRotationAngle(this.arm_right2, -0.7854f, 0.0f, 0.0f);
        this.arm_right2.field_78804_l.add(new ModelBox(this.arm_right2, 0, 11, -2.5f, -1.0f, -0.5f, 1, 4, 1, -0.25f, false));
        this.cube_r6 = new ModelRenderer((ModelBase)this);
        this.cube_r6.func_78793_a(-2.0f, 0.0f, 0.0f);
        this.arm_right2.func_78792_a(this.cube_r6);
        this.setRotationAngle(this.cube_r6, 0.0f, 0.0f, -1.0908f);
        this.cube_r6.field_78804_l.add(new ModelBox(this.cube_r6, 0, 11, 0.0f, -1.0f, -0.5f, 1, 3, 1, -0.1f, false));
        this.arm_left = new ModelRenderer((ModelBase)this);
        this.arm_left.func_78793_a(2.5f, 16.0f, 0.5f);
        this.setRotationAngle(this.arm_left, -0.7854f, 0.0f, 0.0f);
        this.arm_left.field_78804_l.add(new ModelBox(this.arm_left, 0, 11, 1.5f, -1.0f, -0.5f, 1, 4, 1, -0.25f, true));
        this.cube_r7 = new ModelRenderer((ModelBase)this);
        this.cube_r7.func_78793_a(2.0f, 0.0f, 0.0f);
        this.arm_left.func_78792_a(this.cube_r7);
        this.setRotationAngle(this.cube_r7, 0.0f, 0.0f, 1.0908f);
        this.cube_r7.field_78804_l.add(new ModelBox(this.cube_r7, 0, 11, -1.0f, -1.0f, -0.5f, 1, 3, 1, -0.1f, true));
        this.arm_left2 = new ModelRenderer((ModelBase)this);
        this.arm_left2.func_78793_a(2.5f, 18.0f, 1.5f);
        this.setRotationAngle(this.arm_left2, -0.7854f, 0.0f, 0.0f);
        this.arm_left2.field_78804_l.add(new ModelBox(this.arm_left2, 0, 11, 1.5f, -1.0f, -0.5f, 1, 4, 1, -0.25f, true));
        this.cube_r8 = new ModelRenderer((ModelBase)this);
        this.cube_r8.func_78793_a(2.0f, 0.0f, 0.0f);
        this.arm_left2.func_78792_a(this.cube_r8);
        this.setRotationAngle(this.cube_r8, 0.0f, 0.0f, 1.0908f);
        this.cube_r8.field_78804_l.add(new ModelBox(this.cube_r8, 0, 11, -1.0f, -1.0f, -0.5f, 1, 3, 1, -0.1f, true));
        this.head = new ModelRenderer((ModelBase)this);
        this.head.func_78793_a(0.0f, 15.0f, 0.0f);
        this.head.field_78804_l.add(new ModelBox(this.head, 0, 0, -2.0f, -2.0f, -2.5f, 4, 2, 3, 0.0f, false));
        this.head.field_78804_l.add(new ModelBox(this.head, 14, 0, 0.0f, -1.0f, -2.5f, 1, 2, 1, -0.35f, false));
        this.head.field_78804_l.add(new ModelBox(this.head, 14, 0, -1.0f, -1.0f, -2.5f, 1, 2, 1, -0.35f, false));
        this.head.field_78804_l.add(new ModelBox(this.head, 14, 0, -1.0f, -1.0f, -2.5f, 1, 2, 1, -0.35f, false));
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.body.func_78785_a(f5);
        this.leg_right.func_78785_a(f5);
        this.leg_left.func_78785_a(f5);
        this.arm_right.func_78785_a(f5);
        this.arm_right2.func_78785_a(f5);
        this.arm_left.func_78785_a(f5);
        this.arm_left2.func_78785_a(f5);
        this.head.func_78785_a(f5);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.head.field_78796_g = netHeadYaw * ((float)Math.PI / 180);
        this.head.field_78795_f = headPitch * ((float)Math.PI / 180);
        this.wing_left.field_78796_g = Mth.func_76134_b((float)(ageInTicks * 2.0f)) * (float)Math.PI * 0.15f;
        this.wing_right.field_78796_g = -this.wing_left.field_78796_g;
        this.wing_left.field_78795_f = -0.436f;
        this.wing_right.field_78795_f = -0.436f;
        this.arm_right2.field_78795_f = this.arm_right.field_78795_f = Mth.func_76134_b((float)(ageInTicks * 0.3f)) * 0.15f - 0.55f;
        this.arm_left.field_78795_f = this.arm_right.field_78795_f;
        this.arm_left2.field_78795_f = this.arm_right.field_78795_f;
    }
}

