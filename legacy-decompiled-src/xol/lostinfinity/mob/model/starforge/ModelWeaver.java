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

public class ModelWeaver
extends ModelBase {
    private final ModelRenderer Body;
    private final ModelRenderer Body_r1;
    private final ModelRenderer Body_r2;
    private final ModelRenderer Leg1;
    private final ModelRenderer Body_r3;
    private final ModelRenderer Body_r4;
    private final ModelRenderer Leg2;
    private final ModelRenderer Body_r5;
    private final ModelRenderer Body_r6;
    private final ModelRenderer Leg3;
    private final ModelRenderer Body_r7;
    private final ModelRenderer Body_r8;
    private final ModelRenderer Leg4;
    private final ModelRenderer Body_r9;
    private final ModelRenderer Body_r10;
    private final ModelRenderer ArmL;
    private final ModelRenderer Body_r11;
    private final ModelRenderer ArmR;
    private final ModelRenderer Body_r12;
    private final ModelRenderer ArmL2;
    private final ModelRenderer Body_r13;
    private final ModelRenderer ArmR2;
    private final ModelRenderer Body_r14;
    private final ModelRenderer Head;
    private final ModelRenderer Body_r15;

    public ModelWeaver() {
        this.field_78090_t = 64;
        this.field_78089_u = 64;
        this.Body = new ModelRenderer((ModelBase)this);
        this.Body.func_78793_a(0.25f, 11.25f, 5.75f);
        this.Body.field_78804_l.add(new ModelBox(this.Body, 0, 0, -6.25f, -13.25f, -10.75f, 12, 5, 18, 0.0f, false));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 48, 41, -2.25f, -23.25f, -10.75f, 4, 10, 4, 0.0f, false));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 44, 5, -1.25f, -23.25f, -6.75f, 2, 10, 2, 0.0f, false));
        this.Body_r1 = new ModelRenderer((ModelBase)this);
        this.Body_r1.func_78793_a(-0.75f, -20.25f, 1.75f);
        this.Body.func_78792_a(this.Body_r1);
        this.setRotationAngle(this.Body_r1, 0.8727f, -0.3491f, 0.0f);
        this.Body_r1.field_78804_l.add(new ModelBox(this.Body_r1, 55, 1, -3.5f, -7.0f, -4.5f, 1, 14, 1, 0.0f, true));
        this.Body_r2 = new ModelRenderer((ModelBase)this);
        this.Body_r2.func_78793_a(0.25f, -20.25f, 1.75f);
        this.Body.func_78792_a(this.Body_r2);
        this.setRotationAngle(this.Body_r2, 0.8727f, 0.3491f, 0.0f);
        this.Body_r2.field_78804_l.add(new ModelBox(this.Body_r2, 55, 1, 2.5f, -7.0f, -4.5f, 1, 14, 1, 0.0f, false));
        this.Leg1 = new ModelRenderer((ModelBase)this);
        this.Leg1.func_78793_a(4.5f, 0.5f, 10.0f);
        this.setRotationAngle(this.Leg1, 0.0f, -0.8727f, 0.0f);
        this.Body_r3 = new ModelRenderer((ModelBase)this);
        this.Body_r3.func_78793_a(3.0f, -1.0f, 0.0f);
        this.Leg1.func_78792_a(this.Body_r3);
        this.setRotationAngle(this.Body_r3, 0.0f, 0.0f, 0.1745f);
        this.Body_r3.field_78804_l.add(new ModelBox(this.Body_r3, 0, 37, 8.0f, 10.5f, -1.0f, 6, 3, 2, 0.0f, false));
        this.Body_r3.field_78804_l.add(new ModelBox(this.Body_r3, 0, 51, 12.0f, 13.5f, -0.5f, 2, 10, 1, 0.0f, false));
        this.Body_r3.field_78804_l.add(new ModelBox(this.Body_r3, 0, 0, 5.0f, -2.5f, -1.0f, 3, 16, 2, 0.0f, false));
        this.Body_r4 = new ModelRenderer((ModelBase)this);
        this.Body_r4.func_78793_a(3.0f, -1.0f, 0.0f);
        this.Leg1.func_78792_a(this.Body_r4);
        this.setRotationAngle(this.Body_r4, 0.0f, 0.0f, -0.2618f);
        this.Body_r4.field_78804_l.add(new ModelBox(this.Body_r4, 15, 40, -4.0f, -1.5f, -1.5f, 9, 2, 3, 0.0f, false));
        this.Body_r4.field_78804_l.add(new ModelBox(this.Body_r4, 7, 58, 6.0f, -4.5f, -0.5f, 1, 3, 1, 0.0f, false));
        this.Body_r4.field_78804_l.add(new ModelBox(this.Body_r4, 7, 52, 8.0f, -5.5f, -1.5f, 1, 4, 1, 0.0f, false));
        this.Body_r4.field_78804_l.add(new ModelBox(this.Body_r4, 7, 52, 8.0f, -5.5f, 0.5f, 1, 4, 1, 0.0f, false));
        this.Body_r4.field_78804_l.add(new ModelBox(this.Body_r4, 0, 30, 5.0f, -1.5f, -1.5f, 4, 3, 3, 0.0f, false));
        this.Leg2 = new ModelRenderer((ModelBase)this);
        this.Leg2.func_78793_a(4.5f, 0.5f, 0.0f);
        this.Body_r5 = new ModelRenderer((ModelBase)this);
        this.Body_r5.func_78793_a(3.0f, -1.0f, 0.0f);
        this.Leg2.func_78792_a(this.Body_r5);
        this.setRotationAngle(this.Body_r5, 0.0f, 0.0f, 0.1745f);
        this.Body_r5.field_78804_l.add(new ModelBox(this.Body_r5, 0, 37, 8.0f, 10.5f, -1.0f, 6, 3, 2, 0.0f, false));
        this.Body_r5.field_78804_l.add(new ModelBox(this.Body_r5, 0, 51, 12.0f, 13.5f, -0.5f, 2, 10, 1, 0.0f, false));
        this.Body_r5.field_78804_l.add(new ModelBox(this.Body_r5, 0, 0, 5.0f, -2.5f, -1.0f, 3, 16, 2, 0.0f, false));
        this.Body_r6 = new ModelRenderer((ModelBase)this);
        this.Body_r6.func_78793_a(3.0f, -1.0f, 0.0f);
        this.Leg2.func_78792_a(this.Body_r6);
        this.setRotationAngle(this.Body_r6, 0.0f, 0.0f, -0.2618f);
        this.Body_r6.field_78804_l.add(new ModelBox(this.Body_r6, 0, 24, -4.0f, -1.5f, -1.5f, 9, 2, 3, 0.0f, false));
        this.Body_r6.field_78804_l.add(new ModelBox(this.Body_r6, 7, 58, 6.0f, -4.5f, -0.5f, 1, 3, 1, 0.0f, false));
        this.Body_r6.field_78804_l.add(new ModelBox(this.Body_r6, 7, 52, 8.0f, -5.5f, -1.5f, 1, 4, 1, 0.0f, false));
        this.Body_r6.field_78804_l.add(new ModelBox(this.Body_r6, 7, 52, 8.0f, -5.5f, 0.5f, 1, 4, 1, 0.0f, false));
        this.Body_r6.field_78804_l.add(new ModelBox(this.Body_r6, 0, 30, 5.0f, -1.5f, -1.5f, 4, 3, 3, 0.0f, false));
        this.Leg3 = new ModelRenderer((ModelBase)this);
        this.Leg3.func_78793_a(-4.5f, 0.5f, 10.0f);
        this.setRotationAngle(this.Leg3, 0.0f, 0.8727f, 0.0f);
        this.Body_r7 = new ModelRenderer((ModelBase)this);
        this.Body_r7.func_78793_a(-3.0f, -1.0f, 0.0f);
        this.Leg3.func_78792_a(this.Body_r7);
        this.setRotationAngle(this.Body_r7, 0.0f, 0.0f, -0.1745f);
        this.Body_r7.field_78804_l.add(new ModelBox(this.Body_r7, 0, 37, -14.0f, 10.5f, -1.0f, 6, 3, 2, 0.0f, true));
        this.Body_r7.field_78804_l.add(new ModelBox(this.Body_r7, 0, 51, -14.0f, 13.5f, -0.5f, 2, 10, 1, 0.0f, true));
        this.Body_r7.field_78804_l.add(new ModelBox(this.Body_r7, 0, 0, -8.0f, -2.5f, -1.0f, 3, 16, 2, 0.0f, true));
        this.Body_r8 = new ModelRenderer((ModelBase)this);
        this.Body_r8.func_78793_a(-3.0f, -1.0f, 0.0f);
        this.Leg3.func_78792_a(this.Body_r8);
        this.setRotationAngle(this.Body_r8, 0.0f, 0.0f, 0.2618f);
        this.Body_r8.field_78804_l.add(new ModelBox(this.Body_r8, 15, 40, -5.0f, -1.5f, -1.5f, 9, 2, 3, 0.0f, true));
        this.Body_r8.field_78804_l.add(new ModelBox(this.Body_r8, 7, 58, -7.0f, -4.5f, -0.5f, 1, 3, 1, 0.0f, true));
        this.Body_r8.field_78804_l.add(new ModelBox(this.Body_r8, 7, 52, -9.0f, -5.5f, -1.5f, 1, 4, 1, 0.0f, true));
        this.Body_r8.field_78804_l.add(new ModelBox(this.Body_r8, 7, 52, -9.0f, -5.5f, 0.5f, 1, 4, 1, 0.0f, true));
        this.Body_r8.field_78804_l.add(new ModelBox(this.Body_r8, 0, 30, -9.0f, -1.5f, -1.5f, 4, 3, 3, 0.0f, true));
        this.Leg4 = new ModelRenderer((ModelBase)this);
        this.Leg4.func_78793_a(-4.5f, 0.5f, 0.0f);
        this.Body_r9 = new ModelRenderer((ModelBase)this);
        this.Body_r9.func_78793_a(-3.0f, -1.0f, 0.0f);
        this.Leg4.func_78792_a(this.Body_r9);
        this.setRotationAngle(this.Body_r9, 0.0f, 0.0f, -0.1745f);
        this.Body_r9.field_78804_l.add(new ModelBox(this.Body_r9, 0, 37, -14.0f, 10.5f, -1.0f, 6, 3, 2, 0.0f, true));
        this.Body_r9.field_78804_l.add(new ModelBox(this.Body_r9, 0, 51, -14.0f, 13.5f, -0.5f, 2, 10, 1, 0.0f, true));
        this.Body_r9.field_78804_l.add(new ModelBox(this.Body_r9, 0, 0, -8.0f, -2.5f, -1.0f, 3, 16, 2, 0.0f, true));
        this.Body_r10 = new ModelRenderer((ModelBase)this);
        this.Body_r10.func_78793_a(-3.0f, -1.0f, 0.0f);
        this.Leg4.func_78792_a(this.Body_r10);
        this.setRotationAngle(this.Body_r10, 0.0f, 0.0f, 0.2618f);
        this.Body_r10.field_78804_l.add(new ModelBox(this.Body_r10, 0, 24, -5.0f, -1.5f, -1.5f, 9, 2, 3, 0.0f, true));
        this.Body_r10.field_78804_l.add(new ModelBox(this.Body_r10, 7, 58, -7.0f, -4.5f, -0.5f, 1, 3, 1, 0.0f, true));
        this.Body_r10.field_78804_l.add(new ModelBox(this.Body_r10, 7, 52, -9.0f, -5.5f, -1.5f, 1, 4, 1, 0.0f, true));
        this.Body_r10.field_78804_l.add(new ModelBox(this.Body_r10, 7, 52, -9.0f, -5.5f, 0.5f, 1, 4, 1, 0.0f, true));
        this.Body_r10.field_78804_l.add(new ModelBox(this.Body_r10, 0, 30, -9.0f, -1.5f, -1.5f, 4, 3, 3, 0.0f, true));
        this.ArmL = new ModelRenderer((ModelBase)this);
        this.ArmL.func_78793_a(5.0f, 1.5f, -2.5f);
        this.Body_r11 = new ModelRenderer((ModelBase)this);
        this.Body_r11.func_78793_a(0.0f, 0.0f, 0.0f);
        this.ArmL.func_78792_a(this.Body_r11);
        this.setRotationAngle(this.Body_r11, 0.0f, 0.0f, 0.7854f);
        this.Body_r11.field_78804_l.add(new ModelBox(this.Body_r11, 0, 43, 7.5f, -0.5f, -0.25f, 1, 5, 1, 0.0f, false));
        this.Body_r11.field_78804_l.add(new ModelBox(this.Body_r11, 0, 43, 7.5f, -0.5f, -1.75f, 1, 5, 1, 0.0f, false));
        this.Body_r11.field_78804_l.add(new ModelBox(this.Body_r11, 8, 45, 0.0f, -1.5f, -2.0f, 8, 3, 3, 0.0f, false));
        this.ArmR = new ModelRenderer((ModelBase)this);
        this.ArmR.func_78793_a(-5.0f, 1.5f, -2.5f);
        this.Body_r12 = new ModelRenderer((ModelBase)this);
        this.Body_r12.func_78793_a(0.0f, 0.0f, 0.0f);
        this.ArmR.func_78792_a(this.Body_r12);
        this.setRotationAngle(this.Body_r12, 0.0f, 0.0f, -0.7854f);
        this.Body_r12.field_78804_l.add(new ModelBox(this.Body_r12, 0, 43, -8.5f, -0.5f, -0.25f, 1, 5, 1, 0.0f, true));
        this.Body_r12.field_78804_l.add(new ModelBox(this.Body_r12, 0, 43, -8.5f, -0.5f, -1.75f, 1, 5, 1, 0.0f, true));
        this.Body_r12.field_78804_l.add(new ModelBox(this.Body_r12, 8, 45, -8.0f, -1.5f, -2.0f, 8, 3, 3, 0.0f, true));
        this.ArmL2 = new ModelRenderer((ModelBase)this);
        this.ArmL2.func_78793_a(1.0f, -4.5f, -2.5f);
        this.setRotationAngle(this.ArmL2, -1.5708f, 0.0f, -0.3054f);
        this.Body_r13 = new ModelRenderer((ModelBase)this);
        this.Body_r13.func_78793_a(0.0f, 0.0f, 0.0f);
        this.ArmL2.func_78792_a(this.Body_r13);
        this.setRotationAngle(this.Body_r13, 0.0f, 0.0f, 0.7854f);
        this.Body_r13.field_78804_l.add(new ModelBox(this.Body_r13, 0, 43, 7.5f, -0.5f, -0.25f, 1, 5, 1, 0.0f, false));
        this.Body_r13.field_78804_l.add(new ModelBox(this.Body_r13, 0, 43, 7.5f, -0.5f, -1.75f, 1, 5, 1, 0.0f, false));
        this.Body_r13.field_78804_l.add(new ModelBox(this.Body_r13, 8, 45, 0.0f, -1.5f, -2.0f, 8, 3, 3, 0.0f, false));
        this.ArmR2 = new ModelRenderer((ModelBase)this);
        this.ArmR2.func_78793_a(-1.0f, -4.5f, -2.5f);
        this.setRotationAngle(this.ArmR2, -1.5708f, 0.0f, 0.3054f);
        this.Body_r14 = new ModelRenderer((ModelBase)this);
        this.Body_r14.func_78793_a(0.0f, 0.0f, 0.0f);
        this.ArmR2.func_78792_a(this.Body_r14);
        this.setRotationAngle(this.Body_r14, 0.0f, 0.0f, -0.7854f);
        this.Body_r14.field_78804_l.add(new ModelBox(this.Body_r14, 0, 43, -8.5f, -0.5f, -0.25f, 1, 5, 1, 0.0f, true));
        this.Body_r14.field_78804_l.add(new ModelBox(this.Body_r14, 0, 43, -8.5f, -0.5f, -1.75f, 1, 5, 1, 0.0f, true));
        this.Body_r14.field_78804_l.add(new ModelBox(this.Body_r14, 8, 45, -8.0f, -1.5f, -2.0f, 8, 3, 3, 0.0f, true));
        this.Head = new ModelRenderer((ModelBase)this);
        this.Head.func_78793_a(0.0f, -12.0f, -4.0f);
        this.Head.field_78804_l.add(new ModelBox(this.Head, 27, 24, -5.0f, -6.0f, -2.0f, 10, 6, 2, 0.0f, false));
        this.Head.field_78804_l.add(new ModelBox(this.Head, 36, 33, -5.0f, -6.0f, -2.5f, 10, 6, 1, 0.0f, false));
        this.Head.field_78804_l.add(new ModelBox(this.Head, 45, 56, -3.0f, -4.0f, 0.0f, 6, 4, 3, 0.0f, false));
        this.Head.field_78804_l.add(new ModelBox(this.Head, 15, 34, -11.0f, -6.0f, -2.0f, 6, 2, 2, 0.0f, true));
        this.Head.field_78804_l.add(new ModelBox(this.Head, 15, 34, 5.0f, -6.0f, -2.0f, 6, 2, 2, 0.0f, false));
        this.Head.field_78804_l.add(new ModelBox(this.Head, 15, 31, 5.0f, -2.0f, -2.0f, 4, 1, 1, 0.0f, false));
        this.Head.field_78804_l.add(new ModelBox(this.Head, 15, 31, -9.0f, -2.0f, -2.0f, 4, 1, 1, 0.0f, true));
        this.Body_r15 = new ModelRenderer((ModelBase)this);
        this.Body_r15.func_78793_a(0.0f, -4.5f, 0.0f);
        this.Head.func_78792_a(this.Body_r15);
        this.setRotationAngle(this.Body_r15, 0.2618f, 0.0f, 0.0f);
        this.Body_r15.field_78804_l.add(new ModelBox(this.Body_r15, 0, 51, -8.0f, 0.5f, 0.0f, 16, 1, 12, 0.0f, false));
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.Body.func_78785_a(f5);
        this.Leg1.func_78785_a(f5);
        this.Leg2.func_78785_a(f5);
        this.Leg3.func_78785_a(f5);
        this.Leg4.func_78785_a(f5);
        this.ArmL.func_78785_a(f5);
        this.ArmR.func_78785_a(f5);
        this.ArmL2.func_78785_a(f5);
        this.ArmR2.func_78785_a(f5);
        this.Head.func_78785_a(f5);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.Head.field_78796_g = netHeadYaw * ((float)Math.PI / 180);
        this.Head.field_78795_f = headPitch * ((float)Math.PI / 180);
        this.Leg1.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.5662f + (float)Math.PI)) * limbSwingAmount * 0.5f;
        this.Leg1.field_78808_h = 0.8f * Mth.func_76134_b((float)(limbSwing * 0.3662f + (float)Math.PI)) * limbSwingAmount * 0.5f;
        this.Leg2.field_78795_f = Mth.func_76126_a((float)(limbSwing * 0.5662f + (float)Math.PI)) * limbSwingAmount * 0.5f;
        this.Leg2.field_78808_h = 0.8f * Mth.func_76126_a((float)(limbSwing * 0.3662f + (float)Math.PI)) * limbSwingAmount * 0.5f;
        this.Leg3.field_78795_f = this.Leg1.field_78795_f;
        this.Leg3.field_78808_h = -this.Leg1.field_78808_h;
        this.Leg4.field_78795_f = this.Leg2.field_78795_f;
        this.Leg4.field_78808_h = -this.Leg2.field_78808_h;
        this.ArmL.field_78808_h = 0.7f * Mth.func_76126_a((float)(ageInTicks * 0.05f));
        this.ArmL2.field_78796_g = 0.4f * Mth.func_76126_a((float)(ageInTicks * 0.1f));
        this.ArmR.field_78808_h = -this.ArmL.field_78808_h;
        this.ArmR2.field_78796_g = -this.ArmL2.field_78796_g;
    }
}

