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

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import xol.lostinfinity.mob.entity.murk.EntityWhisper;

public class ModelWhisper
extends ModelBase {
    private final ModelRenderer Body;
    private final ModelRenderer Leg1;
    private final ModelRenderer Body_r1;
    private final ModelRenderer Body_r2;
    private final ModelRenderer Body_r3;
    private final ModelRenderer Leg2;
    private final ModelRenderer Body_r4;
    private final ModelRenderer Body_r5;
    private final ModelRenderer Body_r6;
    private final ModelRenderer Leg3;
    private final ModelRenderer Body_r7;
    private final ModelRenderer Body_r8;
    private final ModelRenderer Body_r9;
    private final ModelRenderer Leg4;
    private final ModelRenderer Body_r10;
    private final ModelRenderer Body_r11;
    private final ModelRenderer Body_r12;

    public ModelWhisper() {
        this.field_78090_t = 64;
        this.field_78089_u = 64;
        this.Body = new ModelRenderer((ModelBase)this);
        this.Body.func_78793_a(0.25f, 11.25f, 5.75f);
        this.Body.field_78804_l.add(new ModelBox(this.Body, 0, 0, -6.25f, -12.25f, -10.75f, 12, 9, 20, 0.0f, false));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 22, 38, -6.25f, -6.25f, -10.75f, 12, 4, 9, -0.1f, false));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 22, 51, -6.25f, -6.25f, 0.25f, 12, 4, 9, -0.1f, false));
        this.Leg1 = new ModelRenderer((ModelBase)this);
        this.Leg1.func_78793_a(4.5f, 0.5f, -2.0f);
        this.setRotationAngle(this.Leg1, 0.0f, 0.3491f, 0.0f);
        this.Body_r1 = new ModelRenderer((ModelBase)this);
        this.Body_r1.func_78793_a(3.0f, -1.0f, 0.0f);
        this.Leg1.func_78792_a(this.Body_r1);
        this.setRotationAngle(this.Body_r1, 0.0f, 0.0f, -0.2182f);
        this.Body_r1.field_78804_l.add(new ModelBox(this.Body_r1, 0, 34, 8.0f, 0.5f, -1.0f, 3, 28, 2, 0.0f, false));
        this.Body_r2 = new ModelRenderer((ModelBase)this);
        this.Body_r2.func_78793_a(3.0f, -1.0f, 0.0f);
        this.Leg1.func_78792_a(this.Body_r2);
        this.setRotationAngle(this.Body_r2, 0.0f, 0.0f, 0.1745f);
        this.Body_r2.field_78804_l.add(new ModelBox(this.Body_r2, 11, 35, 5.0f, -2.5f, -1.0f, 3, 27, 2, 0.0f, false));
        this.Body_r3 = new ModelRenderer((ModelBase)this);
        this.Body_r3.func_78793_a(3.0f, -1.0f, 0.0f);
        this.Leg1.func_78792_a(this.Body_r3);
        this.setRotationAngle(this.Body_r3, 0.0f, 0.0f, -0.2618f);
        this.Body_r3.field_78804_l.add(new ModelBox(this.Body_r3, 15, 30, -4.0f, -1.5f, -1.5f, 9, 2, 3, 0.0f, false));
        this.Body_r3.field_78804_l.add(new ModelBox(this.Body_r3, 40, 29, 4.0f, -2.5f, -2.5f, 7, 4, 5, 0.0f, false));
        this.Leg2 = new ModelRenderer((ModelBase)this);
        this.Leg2.func_78793_a(-4.5f, 0.5f, -2.0f);
        this.setRotationAngle(this.Leg2, 0.0f, -0.3491f, 0.0f);
        this.Body_r4 = new ModelRenderer((ModelBase)this);
        this.Body_r4.func_78793_a(-3.0f, -1.0f, 0.0f);
        this.Leg2.func_78792_a(this.Body_r4);
        this.setRotationAngle(this.Body_r4, 0.0f, 0.0f, 0.2182f);
        this.Body_r4.field_78804_l.add(new ModelBox(this.Body_r4, 0, 34, -11.0f, 0.5f, -1.0f, 3, 28, 2, 0.0f, true));
        this.Body_r5 = new ModelRenderer((ModelBase)this);
        this.Body_r5.func_78793_a(-3.0f, -1.0f, 0.0f);
        this.Leg2.func_78792_a(this.Body_r5);
        this.setRotationAngle(this.Body_r5, 0.0f, 0.0f, -0.1745f);
        this.Body_r5.field_78804_l.add(new ModelBox(this.Body_r5, 11, 35, -8.0f, -2.5f, -1.0f, 3, 27, 2, 0.0f, true));
        this.Body_r6 = new ModelRenderer((ModelBase)this);
        this.Body_r6.func_78793_a(-3.0f, -1.0f, 0.0f);
        this.Leg2.func_78792_a(this.Body_r6);
        this.setRotationAngle(this.Body_r6, 0.0f, 0.0f, 0.2618f);
        this.Body_r6.field_78804_l.add(new ModelBox(this.Body_r6, 15, 30, -5.0f, -1.5f, -1.5f, 9, 2, 3, 0.0f, true));
        this.Body_r6.field_78804_l.add(new ModelBox(this.Body_r6, 40, 29, -11.0f, -2.5f, -2.5f, 7, 4, 5, 0.0f, true));
        this.Leg3 = new ModelRenderer((ModelBase)this);
        this.Leg3.func_78793_a(4.5f, 0.5f, 12.0f);
        this.setRotationAngle(this.Leg3, 0.0f, -0.3491f, 0.0f);
        this.Body_r7 = new ModelRenderer((ModelBase)this);
        this.Body_r7.func_78793_a(3.0f, -1.0f, 0.0f);
        this.Leg3.func_78792_a(this.Body_r7);
        this.setRotationAngle(this.Body_r7, 0.0f, 0.0f, -0.2182f);
        this.Body_r7.field_78804_l.add(new ModelBox(this.Body_r7, 0, 34, 8.0f, 0.5f, -1.0f, 3, 28, 2, 0.0f, false));
        this.Body_r8 = new ModelRenderer((ModelBase)this);
        this.Body_r8.func_78793_a(3.0f, -1.0f, 0.0f);
        this.Leg3.func_78792_a(this.Body_r8);
        this.setRotationAngle(this.Body_r8, 0.0f, 0.0f, 0.1745f);
        this.Body_r8.field_78804_l.add(new ModelBox(this.Body_r8, 11, 35, 5.0f, -2.5f, -1.0f, 3, 27, 2, 0.0f, false));
        this.Body_r9 = new ModelRenderer((ModelBase)this);
        this.Body_r9.func_78793_a(3.0f, -1.0f, 0.0f);
        this.Leg3.func_78792_a(this.Body_r9);
        this.setRotationAngle(this.Body_r9, 0.0f, 0.0f, -0.2618f);
        this.Body_r9.field_78804_l.add(new ModelBox(this.Body_r9, 15, 30, -4.0f, -1.5f, -1.5f, 9, 2, 3, 0.0f, false));
        this.Body_r9.field_78804_l.add(new ModelBox(this.Body_r9, 40, 29, 4.0f, -2.5f, -2.5f, 7, 4, 5, 0.0f, false));
        this.Leg4 = new ModelRenderer((ModelBase)this);
        this.Leg4.func_78793_a(-4.5f, 0.5f, 12.0f);
        this.setRotationAngle(this.Leg4, 0.0f, 0.3491f, 0.0f);
        this.Body_r10 = new ModelRenderer((ModelBase)this);
        this.Body_r10.func_78793_a(-3.0f, -1.0f, 0.0f);
        this.Leg4.func_78792_a(this.Body_r10);
        this.setRotationAngle(this.Body_r10, 0.0f, 0.0f, 0.2182f);
        this.Body_r10.field_78804_l.add(new ModelBox(this.Body_r10, 0, 34, -11.0f, 0.5f, -1.0f, 3, 28, 2, 0.0f, true));
        this.Body_r11 = new ModelRenderer((ModelBase)this);
        this.Body_r11.func_78793_a(-3.0f, -1.0f, 0.0f);
        this.Leg4.func_78792_a(this.Body_r11);
        this.setRotationAngle(this.Body_r11, 0.0f, 0.0f, -0.1745f);
        this.Body_r11.field_78804_l.add(new ModelBox(this.Body_r11, 11, 35, -8.0f, -2.5f, -1.0f, 3, 27, 2, 0.0f, true));
        this.Body_r12 = new ModelRenderer((ModelBase)this);
        this.Body_r12.func_78793_a(-3.0f, -1.0f, 0.0f);
        this.Leg4.func_78792_a(this.Body_r12);
        this.setRotationAngle(this.Body_r12, 0.0f, 0.0f, 0.2618f);
        this.Body_r12.field_78804_l.add(new ModelBox(this.Body_r12, 15, 30, -5.0f, -1.5f, -1.5f, 9, 2, 3, 0.0f, true));
        this.Body_r12.field_78804_l.add(new ModelBox(this.Body_r12, 40, 29, -11.0f, -2.5f, -2.5f, 7, 4, 5, 0.0f, true));
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.Body.func_78785_a(f5);
        this.Leg1.func_78785_a(f5);
        this.Leg2.func_78785_a(f5);
        this.Leg3.func_78785_a(f5);
        this.Leg4.func_78785_a(f5);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        EntityWhisper whisper = (EntityWhisper)entityIn;
        if (whisper.isSacrificed()) {
            float shakeSpeed = 2.5f;
            float shakeRange = 0.15f;
            this.Leg1.field_78795_f = Mth.func_76134_b((float)(ageInTicks * shakeSpeed)) * shakeRange;
            this.Leg1.field_78796_g = Mth.func_76126_a((float)(ageInTicks * shakeSpeed)) * shakeRange;
            this.Leg1.field_78808_h = Mth.func_76134_b((float)(ageInTicks * shakeSpeed)) * shakeRange;
            this.Leg2.field_78795_f = Mth.func_76134_b((float)(ageInTicks * shakeSpeed)) * shakeRange;
            this.Leg2.field_78796_g = Mth.func_76126_a((float)(ageInTicks * shakeSpeed)) * shakeRange;
            this.Leg2.field_78808_h = Mth.func_76134_b((float)(ageInTicks * shakeSpeed)) * shakeRange;
            this.Leg3.field_78795_f = Mth.func_76134_b((float)(ageInTicks * shakeSpeed)) * shakeRange;
            this.Leg3.field_78796_g = Mth.func_76126_a((float)(ageInTicks * shakeSpeed)) * shakeRange;
            this.Leg3.field_78808_h = Mth.func_76134_b((float)(ageInTicks * shakeSpeed)) * shakeRange;
            this.Leg4.field_78795_f = Mth.func_76134_b((float)(ageInTicks * shakeSpeed)) * shakeRange;
            this.Leg4.field_78796_g = Mth.func_76126_a((float)(ageInTicks * shakeSpeed)) * shakeRange;
            this.Leg4.field_78808_h = Mth.func_76134_b((float)(ageInTicks * shakeSpeed)) * shakeRange;
            return;
        }
        this.Body.field_78795_f = -Mth.func_76126_a((float)(limbSwing * 0.1662f + (float)Math.PI)) * limbSwingAmount * 0.3f;
        this.Leg3.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.3662f + (float)Math.PI)) * limbSwingAmount * 0.5f;
        this.Leg3.field_78808_h = 0.8f * Mth.func_76134_b((float)(limbSwing * 0.2662f + (float)Math.PI)) * limbSwingAmount * 0.5f;
        this.Leg1.field_78795_f = Mth.func_76126_a((float)(limbSwing * 0.3662f + (float)Math.PI)) * limbSwingAmount * 0.5f;
        this.Leg1.field_78808_h = 0.8f * Mth.func_76126_a((float)(limbSwing * 0.2662f + (float)Math.PI)) * limbSwingAmount * 0.5f;
        this.Leg4.field_78795_f = this.Leg3.field_78795_f;
        this.Leg4.field_78808_h = -this.Leg3.field_78808_h;
        this.Leg2.field_78795_f = this.Leg1.field_78795_f;
        this.Leg2.field_78808_h = -this.Leg1.field_78808_h;
    }
}

