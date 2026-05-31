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
package xol.lostinfinity.mob.model.deviant;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;

public class ModelDeviantBat
extends ModelBase {
    private final ModelRenderer head;
    private final ModelRenderer rightEar;
    private final ModelRenderer leftEar;
    private final ModelRenderer body;
    private final ModelRenderer rightWing;
    private final ModelRenderer rightWingTip;
    private final ModelRenderer leftWing;
    private final ModelRenderer leftWingTip;
    private final ModelRenderer leftWing2;
    private final ModelRenderer leftWingTip2;
    private final ModelRenderer leftWing3;
    private final ModelRenderer leftWingTip3;
    private final ModelRenderer rightWing3;
    private final ModelRenderer rightWingTip3;
    private final ModelRenderer rightWing2;
    private final ModelRenderer rightWingTip2;

    public ModelDeviantBat() {
        this.field_78090_t = 64;
        this.field_78089_u = 64;
        this.head = new ModelRenderer((ModelBase)this);
        this.head.func_78793_a(0.0f, 0.0f, 0.0f);
        this.head.field_78804_l.add(new ModelBox(this.head, 0, 0, -3.0f, -3.0f, -3.0f, 6, 6, 6, 0.0f, false));
        this.rightEar = new ModelRenderer((ModelBase)this);
        this.rightEar.func_78793_a(0.0f, 0.0f, 0.0f);
        this.head.func_78792_a(this.rightEar);
        this.rightEar.field_78804_l.add(new ModelBox(this.rightEar, 24, 0, -4.0f, -6.0f, -2.0f, 3, 4, 1, 0.0f, false));
        this.leftEar = new ModelRenderer((ModelBase)this);
        this.leftEar.func_78793_a(0.0f, 0.0f, 0.0f);
        this.head.func_78792_a(this.leftEar);
        this.leftEar.field_78804_l.add(new ModelBox(this.leftEar, 24, 0, 1.0f, -6.0f, -2.0f, 3, 4, 1, 0.0f, true));
        this.body = new ModelRenderer((ModelBase)this);
        this.body.func_78793_a(0.0f, 0.0f, 0.0f);
        this.setRotationAngle(this.body, 0.5236f, 0.0f, 0.0f);
        this.body.field_78804_l.add(new ModelBox(this.body, 0, 16, -3.0f, 4.0f, -3.0f, 6, 12, 6, 0.0f, false));
        this.body.field_78804_l.add(new ModelBox(this.body, 46, 22, 1.0f, 14.0f, 3.0f, 2, 2, 5, 0.0f, false));
        this.body.field_78804_l.add(new ModelBox(this.body, 46, 22, -3.0f, 14.0f, 3.0f, 2, 2, 5, 0.0f, false));
        this.body.field_78804_l.add(new ModelBox(this.body, 46, 22, -3.0f, 6.0f, 3.0f, 2, 2, 5, 0.0f, false));
        this.body.field_78804_l.add(new ModelBox(this.body, 46, 22, 1.0f, 6.0f, 3.0f, 2, 2, 5, 0.0f, false));
        this.body.field_78804_l.add(new ModelBox(this.body, 30, 33, -7.0f, -3.0f, 5.1f, 14, 28, 3, 0.0f, false));
        this.body.field_78804_l.add(new ModelBox(this.body, 0, 34, -5.0f, 16.0f, 0.0f, 10, 16, 1, 0.0f, false));
        this.rightWing = new ModelRenderer((ModelBase)this);
        this.rightWing.func_78793_a(0.0f, 0.0f, 0.0f);
        this.body.func_78792_a(this.rightWing);
        this.rightWing.field_78804_l.add(new ModelBox(this.rightWing, 42, 0, -12.0f, 1.0f, 1.5f, 10, 16, 1, 0.0f, false));
        this.rightWingTip = new ModelRenderer((ModelBase)this);
        this.rightWingTip.func_78793_a(-12.0f, 1.0f, 1.5f);
        this.rightWing.func_78792_a(this.rightWingTip);
        this.rightWingTip.field_78804_l.add(new ModelBox(this.rightWingTip, 24, 16, -8.0f, 1.0f, 0.0f, 8, 12, 1, 0.0f, false));
        this.rightWingTip.field_78804_l.add(new ModelBox(this.rightWingTip, 32, 6, -12.0f, 9.0f, 0.0f, 4, 2, 1, 0.0f, false));
        this.rightWingTip.field_78804_l.add(new ModelBox(this.rightWingTip, 28, 9, -14.0f, 5.0f, 0.0f, 6, 2, 1, 0.0f, false));
        this.rightWingTip.field_78804_l.add(new ModelBox(this.rightWingTip, 24, 12, -16.0f, 1.0f, 0.0f, 8, 2, 1, 0.0f, false));
        this.leftWing = new ModelRenderer((ModelBase)this);
        this.leftWing.func_78793_a(0.0f, 0.0f, 0.0f);
        this.body.func_78792_a(this.leftWing);
        this.leftWing.field_78804_l.add(new ModelBox(this.leftWing, 42, 0, 2.0f, 1.0f, 1.5f, 10, 16, 1, 0.0f, true));
        this.leftWingTip = new ModelRenderer((ModelBase)this);
        this.leftWingTip.func_78793_a(12.0f, 1.0f, 1.5f);
        this.leftWing.func_78792_a(this.leftWingTip);
        this.leftWingTip.field_78804_l.add(new ModelBox(this.leftWingTip, 24, 16, 0.0f, 1.0f, 0.0f, 8, 12, 1, 0.0f, true));
        this.leftWingTip.field_78804_l.add(new ModelBox(this.leftWingTip, 24, 12, 8.0f, 1.0f, 0.0f, 8, 2, 1, 0.0f, true));
        this.leftWingTip.field_78804_l.add(new ModelBox(this.leftWingTip, 28, 9, 8.0f, 5.0f, 0.0f, 6, 2, 1, 0.0f, true));
        this.leftWingTip.field_78804_l.add(new ModelBox(this.leftWingTip, 32, 6, 8.0f, 9.0f, 0.0f, 4, 2, 1, 0.0f, true));
        this.leftWing2 = new ModelRenderer((ModelBase)this);
        this.leftWing2.func_78793_a(0.0f, -4.0f, 8.0f);
        this.body.func_78792_a(this.leftWing2);
        this.setRotationAngle(this.leftWing2, 0.0f, 0.0f, -0.3491f);
        this.leftWing2.field_78804_l.add(new ModelBox(this.leftWing2, 42, 0, 2.0f, 1.0f, -0.5f, 10, 16, 1, 0.0f, true));
        this.leftWingTip2 = new ModelRenderer((ModelBase)this);
        this.leftWingTip2.func_78793_a(12.0f, 1.0f, -0.5f);
        this.leftWing2.func_78792_a(this.leftWingTip2);
        this.leftWingTip2.field_78804_l.add(new ModelBox(this.leftWingTip2, 24, 16, 0.0f, 1.0f, 0.0f, 8, 12, 1, 0.0f, true));
        this.leftWingTip2.field_78804_l.add(new ModelBox(this.leftWingTip2, 24, 12, 8.0f, 1.0f, 0.0f, 8, 2, 1, 0.0f, true));
        this.leftWingTip2.field_78804_l.add(new ModelBox(this.leftWingTip2, 28, 9, 8.0f, 5.0f, 0.0f, 6, 2, 1, 0.0f, true));
        this.leftWingTip2.field_78804_l.add(new ModelBox(this.leftWingTip2, 32, 6, 8.0f, 9.0f, 0.0f, 4, 2, 1, 0.0f, true));
        this.leftWing3 = new ModelRenderer((ModelBase)this);
        this.leftWing3.func_78793_a(9.0f, 9.0f, 8.0f);
        this.body.func_78792_a(this.leftWing3);
        this.setRotationAngle(this.leftWing3, 0.0f, 0.0f, 0.6109f);
        this.leftWing3.field_78804_l.add(new ModelBox(this.leftWing3, 42, 0, 2.0f, 1.0f, -0.5f, 10, 16, 1, 0.0f, true));
        this.leftWingTip3 = new ModelRenderer((ModelBase)this);
        this.leftWingTip3.func_78793_a(12.0f, 1.0f, -0.5f);
        this.leftWing3.func_78792_a(this.leftWingTip3);
        this.leftWingTip3.field_78804_l.add(new ModelBox(this.leftWingTip3, 24, 16, 0.0f, 1.0f, 0.0f, 8, 12, 1, 0.0f, true));
        this.leftWingTip3.field_78804_l.add(new ModelBox(this.leftWingTip3, 24, 12, 8.0f, 1.0f, 0.0f, 8, 2, 1, 0.0f, true));
        this.leftWingTip3.field_78804_l.add(new ModelBox(this.leftWingTip3, 28, 9, 8.0f, 5.0f, 0.0f, 6, 2, 1, 0.0f, true));
        this.leftWingTip3.field_78804_l.add(new ModelBox(this.leftWingTip3, 32, 6, 8.0f, 9.0f, 0.0f, 4, 2, 1, 0.0f, true));
        this.rightWing3 = new ModelRenderer((ModelBase)this);
        this.rightWing3.func_78793_a(-9.0f, 9.0f, 8.0f);
        this.body.func_78792_a(this.rightWing3);
        this.setRotationAngle(this.rightWing3, 0.0f, 0.0f, -0.6109f);
        this.rightWing3.field_78804_l.add(new ModelBox(this.rightWing3, 42, 0, -12.0f, 1.0f, -0.5f, 10, 16, 1, 0.0f, false));
        this.rightWingTip3 = new ModelRenderer((ModelBase)this);
        this.rightWingTip3.func_78793_a(-12.0f, 1.0f, -0.5f);
        this.rightWing3.func_78792_a(this.rightWingTip3);
        this.rightWingTip3.field_78804_l.add(new ModelBox(this.rightWingTip3, 24, 16, -8.0f, 1.0f, 0.0f, 8, 12, 1, 0.0f, false));
        this.rightWingTip3.field_78804_l.add(new ModelBox(this.rightWingTip3, 24, 12, -16.0f, 1.0f, 0.0f, 8, 2, 1, 0.0f, false));
        this.rightWingTip3.field_78804_l.add(new ModelBox(this.rightWingTip3, 28, 9, -14.0f, 5.0f, 0.0f, 6, 2, 1, 0.0f, false));
        this.rightWingTip3.field_78804_l.add(new ModelBox(this.rightWingTip3, 32, 6, -12.0f, 9.0f, 0.0f, 4, 2, 1, 0.0f, false));
        this.rightWing2 = new ModelRenderer((ModelBase)this);
        this.rightWing2.func_78793_a(0.0f, -4.0f, 8.0f);
        this.body.func_78792_a(this.rightWing2);
        this.setRotationAngle(this.rightWing2, 0.0f, 0.0f, 0.3491f);
        this.rightWing2.field_78804_l.add(new ModelBox(this.rightWing2, 42, 0, -12.0f, 1.0f, -0.5f, 10, 16, 1, 0.0f, false));
        this.rightWingTip2 = new ModelRenderer((ModelBase)this);
        this.rightWingTip2.func_78793_a(-12.0f, 1.0f, -0.5f);
        this.rightWing2.func_78792_a(this.rightWingTip2);
        this.rightWingTip2.field_78804_l.add(new ModelBox(this.rightWingTip2, 24, 16, -8.0f, 1.0f, 0.0f, 8, 12, 1, 0.0f, false));
        this.rightWingTip2.field_78804_l.add(new ModelBox(this.rightWingTip2, 24, 12, -16.0f, 1.0f, 0.0f, 8, 2, 1, 0.0f, false));
        this.rightWingTip2.field_78804_l.add(new ModelBox(this.rightWingTip2, 28, 9, -14.0f, 5.0f, 0.0f, 6, 2, 1, 0.0f, false));
        this.rightWingTip2.field_78804_l.add(new ModelBox(this.rightWingTip2, 32, 6, -12.0f, 9.0f, 0.0f, 4, 2, 1, 0.0f, false));
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
        this.head.field_78796_g = netHeadYaw * ((float)Math.PI / 180);
        this.head.field_78795_f = headPitch * ((float)Math.PI / 180);
        this.rightWing.field_78796_g = -0.4f + 0.4f * Mth.func_76126_a((float)(ageInTicks * 0.4f));
        this.rightWing2.field_78796_g = -0.4f + 0.4f * Mth.func_76134_b((float)(ageInTicks * 0.4f));
        this.rightWing3.field_78796_g = -0.4f + 0.4f * Mth.func_76134_b((float)(ageInTicks * 0.4f));
        this.leftWing.field_78796_g = -this.rightWing.field_78796_g;
        this.leftWing2.field_78796_g = -this.rightWing2.field_78796_g;
        this.leftWing3.field_78796_g = -this.rightWing3.field_78796_g;
    }
}

