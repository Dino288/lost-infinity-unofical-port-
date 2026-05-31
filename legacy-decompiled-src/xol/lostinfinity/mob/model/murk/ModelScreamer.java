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

import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import xol.lostinfinity.mob.entity.murk.EntityScreamer;

public class ModelScreamer
extends ModelBase {
    private final ModelRenderer Body;
    private final ModelRenderer WingLeft;
    private final ModelRenderer WingRight;
    private final ModelRenderer Pincer1;
    private final ModelRenderer Body_r1;
    private final ModelRenderer Body_r2;
    private final ModelRenderer Pincer2;
    private final ModelRenderer Body_r3;
    private final ModelRenderer Body_r4;
    private final ModelRenderer Pincer3;
    private final ModelRenderer Body_r5;
    private final ModelRenderer Body_r6;
    private final ModelRenderer ArmLeft;
    private final ModelRenderer Body_r7;
    private final ModelRenderer Body_r8;
    private final ModelRenderer Body_r9;
    private final ModelRenderer ArmRight;
    private final ModelRenderer Body_r10;
    private final ModelRenderer Body_r11;
    private final ModelRenderer Body_r12;

    public ModelScreamer() {
        this.field_78090_t = 128;
        this.field_78089_u = 64;
        this.Body = new ModelRenderer((ModelBase)this);
        this.Body.func_78793_a(0.0f, 14.0f, 5.0f);
        this.Body.field_78804_l.add(new ModelBox(this.Body, 0, 0, -6.0f, -6.0f, -10.0f, 12, 9, 20, 0.0f, false));
        this.WingLeft = new ModelRenderer((ModelBase)this);
        this.WingLeft.func_78793_a(6.0f, 1.0f, 0.0f);
        this.Body.func_78792_a(this.WingLeft);
        this.WingLeft.field_78804_l.add(new ModelBox(this.WingLeft, 22, 43, 0.0f, 0.0f, -10.0f, 33, 1, 20, 0.0f, false));
        this.WingRight = new ModelRenderer((ModelBase)this);
        this.WingRight.func_78793_a(-6.0f, 1.0f, 0.0f);
        this.Body.func_78792_a(this.WingRight);
        this.WingRight.field_78804_l.add(new ModelBox(this.WingRight, 22, 43, -33.0f, 0.0f, -10.0f, 33, 1, 20, 0.0f, true));
        this.Pincer1 = new ModelRenderer((ModelBase)this);
        this.Pincer1.func_78793_a(0.0f, -6.0f, 5.0f);
        this.Body.func_78792_a(this.Pincer1);
        this.Pincer1.field_78804_l.add(new ModelBox(this.Pincer1, 96, 0, -4.0f, -9.0f, -4.0f, 8, 9, 8, 0.0f, false));
        this.Body_r1 = new ModelRenderer((ModelBase)this);
        this.Body_r1.func_78793_a(0.0f, -13.5f, 0.0f);
        this.Pincer1.func_78792_a(this.Body_r1);
        this.setRotationAngle(this.Body_r1, 0.5236f, 0.0f, 0.0f);
        this.Body_r1.field_78804_l.add(new ModelBox(this.Body_r1, 46, 0, -4.0f, -4.5f, -7.0f, 8, 11, 8, -0.2f, false));
        this.Body_r2 = new ModelRenderer((ModelBase)this);
        this.Body_r2.func_78793_a(0.0f, -5.5f, 0.0f);
        this.Pincer1.func_78792_a(this.Body_r2);
        this.setRotationAngle(this.Body_r2, 0.7854f, 0.0f, 0.0f);
        this.Body_r2.field_78804_l.add(new ModelBox(this.Body_r2, 118, 18, -4.0f, -32.0f, 6.0f, 3, 12, 2, -0.5f, false));
        this.Body_r2.field_78804_l.add(new ModelBox(this.Body_r2, 118, 18, 1.0f, -32.0f, 6.0f, 3, 12, 2, -0.5f, false));
        this.Body_r2.field_78804_l.add(new ModelBox(this.Body_r2, 71, 12, -4.0f, -21.0f, 0.0f, 8, 12, 8, -0.5f, false));
        this.Pincer2 = new ModelRenderer((ModelBase)this);
        this.Pincer2.func_78793_a(-3.0f, -3.0f, 4.0f);
        this.Body.func_78792_a(this.Pincer2);
        this.setRotationAngle(this.Pincer2, 0.0f, 0.0f, -0.9599f);
        this.Pincer2.field_78804_l.add(new ModelBox(this.Pincer2, 96, 0, -4.0f, -9.0f, -4.0f, 8, 9, 8, 0.0f, false));
        this.Body_r3 = new ModelRenderer((ModelBase)this);
        this.Body_r3.func_78793_a(0.0f, -13.5f, 0.0f);
        this.Pincer2.func_78792_a(this.Body_r3);
        this.setRotationAngle(this.Body_r3, 0.5236f, 0.0f, 0.0f);
        this.Body_r3.field_78804_l.add(new ModelBox(this.Body_r3, 46, 0, -4.0f, -4.5f, -7.0f, 8, 11, 8, -0.2f, false));
        this.Body_r4 = new ModelRenderer((ModelBase)this);
        this.Body_r4.func_78793_a(0.0f, -5.5f, 0.0f);
        this.Pincer2.func_78792_a(this.Body_r4);
        this.setRotationAngle(this.Body_r4, 0.7854f, 0.0f, 0.0f);
        this.Body_r4.field_78804_l.add(new ModelBox(this.Body_r4, 118, 18, -4.0f, -32.0f, 6.0f, 3, 12, 2, -0.5f, false));
        this.Body_r4.field_78804_l.add(new ModelBox(this.Body_r4, 118, 18, 1.0f, -32.0f, 6.0f, 3, 12, 2, -0.5f, false));
        this.Body_r4.field_78804_l.add(new ModelBox(this.Body_r4, 71, 12, -4.0f, -21.0f, 0.0f, 8, 12, 8, -0.5f, false));
        this.Pincer3 = new ModelRenderer((ModelBase)this);
        this.Pincer3.func_78793_a(3.0f, -3.0f, 4.0f);
        this.Body.func_78792_a(this.Pincer3);
        this.setRotationAngle(this.Pincer3, 0.0f, 0.0f, 0.9599f);
        this.Pincer3.field_78804_l.add(new ModelBox(this.Pincer3, 96, 0, -4.0f, -9.0f, -4.0f, 8, 9, 8, 0.0f, true));
        this.Body_r5 = new ModelRenderer((ModelBase)this);
        this.Body_r5.func_78793_a(0.0f, -13.5f, 0.0f);
        this.Pincer3.func_78792_a(this.Body_r5);
        this.setRotationAngle(this.Body_r5, 0.5236f, 0.0f, 0.0f);
        this.Body_r5.field_78804_l.add(new ModelBox(this.Body_r5, 46, 0, -4.0f, -4.5f, -7.0f, 8, 11, 8, -0.2f, true));
        this.Body_r6 = new ModelRenderer((ModelBase)this);
        this.Body_r6.func_78793_a(0.0f, -5.5f, 0.0f);
        this.Pincer3.func_78792_a(this.Body_r6);
        this.setRotationAngle(this.Body_r6, 0.7854f, 0.0f, 0.0f);
        this.Body_r6.field_78804_l.add(new ModelBox(this.Body_r6, 118, 18, 1.0f, -32.0f, 6.0f, 3, 12, 2, -0.5f, true));
        this.Body_r6.field_78804_l.add(new ModelBox(this.Body_r6, 118, 18, -4.0f, -32.0f, 6.0f, 3, 12, 2, -0.5f, true));
        this.Body_r6.field_78804_l.add(new ModelBox(this.Body_r6, 71, 12, -4.0f, -21.0f, 0.0f, 8, 12, 8, -0.5f, true));
        this.ArmLeft = new ModelRenderer((ModelBase)this);
        this.ArmLeft.func_78793_a(5.5f, 2.5f, 0.0f);
        this.Body.func_78792_a(this.ArmLeft);
        this.setRotationAngle(this.ArmLeft, -1.7453f, 0.0f, 0.6109f);
        this.Body_r7 = new ModelRenderer((ModelBase)this);
        this.Body_r7.func_78793_a(2.0f, -1.0f, 0.0f);
        this.ArmLeft.func_78792_a(this.Body_r7);
        this.setRotationAngle(this.Body_r7, 0.0f, 0.0f, -0.2182f);
        this.Body_r7.field_78804_l.add(new ModelBox(this.Body_r7, 0, 34, 8.0f, 0.5f, -1.0f, 3, 28, 2, 0.0f, false));
        this.Body_r8 = new ModelRenderer((ModelBase)this);
        this.Body_r8.func_78793_a(2.0f, -1.0f, 0.0f);
        this.ArmLeft.func_78792_a(this.Body_r8);
        this.setRotationAngle(this.Body_r8, 0.0f, 0.0f, 0.1745f);
        this.Body_r8.field_78804_l.add(new ModelBox(this.Body_r8, 11, 35, 5.0f, -2.5f, -1.0f, 3, 27, 2, 0.0f, false));
        this.Body_r9 = new ModelRenderer((ModelBase)this);
        this.Body_r9.func_78793_a(2.0f, -1.0f, 0.0f);
        this.ArmLeft.func_78792_a(this.Body_r9);
        this.setRotationAngle(this.Body_r9, 0.0f, 0.0f, -0.2618f);
        this.Body_r9.field_78804_l.add(new ModelBox(this.Body_r9, 15, 30, -4.0f, -1.5f, -1.5f, 9, 2, 3, 0.0f, false));
        this.Body_r9.field_78804_l.add(new ModelBox(this.Body_r9, 40, 29, 4.0f, -2.5f, -2.5f, 7, 4, 5, 0.0f, false));
        this.ArmRight = new ModelRenderer((ModelBase)this);
        this.ArmRight.func_78793_a(-4.5f, 2.5f, 0.0f);
        this.Body.func_78792_a(this.ArmRight);
        this.setRotationAngle(this.ArmRight, -1.7453f, 0.0f, -0.6109f);
        this.Body_r10 = new ModelRenderer((ModelBase)this);
        this.Body_r10.func_78793_a(-3.0f, -1.0f, 0.0f);
        this.ArmRight.func_78792_a(this.Body_r10);
        this.setRotationAngle(this.Body_r10, 0.0f, 0.0f, 0.2182f);
        this.Body_r10.field_78804_l.add(new ModelBox(this.Body_r10, 0, 34, -11.0f, 0.5f, -1.0f, 3, 28, 2, 0.0f, true));
        this.Body_r11 = new ModelRenderer((ModelBase)this);
        this.Body_r11.func_78793_a(-3.0f, -1.0f, 0.0f);
        this.ArmRight.func_78792_a(this.Body_r11);
        this.setRotationAngle(this.Body_r11, 0.0f, 0.0f, -0.1745f);
        this.Body_r11.field_78804_l.add(new ModelBox(this.Body_r11, 11, 35, -8.0f, -2.5f, -1.0f, 3, 27, 2, 0.0f, true));
        this.Body_r12 = new ModelRenderer((ModelBase)this);
        this.Body_r12.func_78793_a(-3.0f, -1.0f, 0.0f);
        this.ArmRight.func_78792_a(this.Body_r12);
        this.setRotationAngle(this.Body_r12, 0.0f, 0.0f, 0.2618f);
        this.Body_r12.field_78804_l.add(new ModelBox(this.Body_r12, 15, 30, -5.0f, -1.5f, -1.5f, 9, 2, 3, 0.0f, true));
        this.Body_r12.field_78804_l.add(new ModelBox(this.Body_r12, 40, 29, -11.0f, -2.5f, -2.5f, 7, 4, 5, 0.0f, true));
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.Body.func_78785_a(f5);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        float wingSpeed = 2.5f;
        float wingRange = 0.12f;
        float armSpeed = 0.15f;
        float armRangeZ = 0.1f;
        float armRangeY = 0.15f;
        float armInitial = 0.61f;
        float pincerInitial = 0.61f - this.Body.field_78795_f;
        this.WingLeft.field_78808_h = Mth.func_76134_b((float)(ageInTicks * wingSpeed)) * wingRange;
        this.WingRight.field_78808_h = Mth.func_76134_b((float)(ageInTicks * wingSpeed + (float)Math.PI)) * wingRange;
        this.ArmLeft.field_78808_h = Mth.func_76134_b((float)(ageInTicks * armSpeed)) * armRangeZ + armInitial;
        this.ArmRight.field_78808_h = Mth.func_76134_b((float)(ageInTicks * armSpeed + (float)Math.PI)) * armRangeZ - armInitial;
        this.ArmLeft.field_78796_g = Mth.func_76134_b((float)(ageInTicks * armSpeed)) * armRangeY;
        this.ArmRight.field_78796_g = Mth.func_76134_b((float)(ageInTicks * armSpeed + (float)Math.PI)) * armRangeY;
        int ageInTicksInt = (int)ageInTicks;
        EntityScreamer screamer = (EntityScreamer)entityIn;
        if (screamer.isPincerMoving()) {
            this.flexPincer(screamer);
            if (this.Pincer3.field_78795_f <= 0.0f) {
                screamer.setPincerMoving(false);
                screamer.setPincerMovingUp(false);
            } else if (this.Pincer3.field_78795_f >= pincerInitial) {
                screamer.setPincerMovingUp(true);
            }
        } else if (ageInTicksInt % 100 == 0 && ThreadLocalRandom.current().nextBoolean()) {
            screamer.setPincerMoving(true);
            this.flexPincer(screamer);
        }
        if (entityIn.field_70181_x > 0.0) {
            if (this.Body.field_78795_f > -0.4f) {
                this.Body.field_78795_f -= 0.05f;
            }
        } else if (entityIn.field_70181_x < 0.0) {
            if (this.Body.field_78795_f < 0.4f) {
                this.Body.field_78795_f += 0.05f;
            }
        } else if (this.Body.field_78795_f > 0.0f) {
            this.Body.field_78795_f -= 0.05f;
        } else if (this.Body.field_78795_f < 0.0f) {
            this.Body.field_78795_f += 0.05f;
        }
    }

    private void flexPincer(EntityScreamer entityIn) {
        if (entityIn.isPincerMovingUp()) {
            this.Pincer2.field_78795_f -= 0.003f;
            this.Pincer1.field_78795_f -= 0.003f;
            this.Pincer3.field_78795_f -= 0.003f;
        } else {
            this.Pincer2.field_78795_f += 0.005f;
            this.Pincer1.field_78795_f += 0.005f;
            this.Pincer3.field_78795_f += 0.005f;
        }
    }
}

