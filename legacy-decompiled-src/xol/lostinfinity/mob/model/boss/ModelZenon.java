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

public class ModelZenon
extends ModelBase {
    private final ModelRenderer Body;
    private final ModelRenderer head;
    private final ModelRenderer head_r1;
    private final ModelRenderer head_r2;
    private final ModelRenderer head_r3;
    private final ModelRenderer head_r4;
    private final ModelRenderer head_r5;
    private final ModelRenderer RightArm;
    private final ModelRenderer RightLeg;
    private final ModelRenderer LeftLeg;
    private final ModelRenderer LeftArm;

    public ModelZenon() {
        this.field_78090_t = 64;
        this.field_78089_u = 64;
        this.Body = new ModelRenderer((ModelBase)this);
        this.Body.func_78793_a(0.0f, 0.0f, 0.0f);
        this.Body.field_78804_l.add(new ModelBox(this.Body, 16, 16, -4.0f, 2.0f, -2.0f, 8, 6, 4, 0.0f, false));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 49, 55, -3.0f, -5.0f, -5.0f, 6, 6, 1, 0.0f, false));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 32, 36, -2.0f, -4.0f, -5.5f, 4, 4, 1, 0.0f, false));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 41, 59, 3.0f, 0.0f, -6.0f, 1, 1, 4, 0.0f, false));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 25, 54, 3.0f, -5.0f, -6.0f, 1, 1, 4, 0.0f, false));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 25, 54, -4.0f, -5.0f, -6.0f, 1, 1, 4, 0.0f, false));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 41, 59, -4.0f, 0.0f, -6.0f, 1, 1, 4, 0.0f, false));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 17, 27, 1.0f, 2.0f, -3.0f, 2, 6, 1, 0.0f, false));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 17, 27, -3.0f, 2.0f, -3.0f, 2, 6, 1, 0.0f, false));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 1, 37, -6.0f, -6.0f, -3.0f, 12, 8, 6, 0.0f, false));
        this.head = new ModelRenderer((ModelBase)this);
        this.head.func_78793_a(0.0f, -6.0f, 0.0f);
        this.head.field_78804_l.add(new ModelBox(this.head, 0, 0, -4.0f, -9.0f, -4.0f, 8, 8, 8, 0.0f, false));
        this.head.field_78804_l.add(new ModelBox(this.head, 0, 52, -4.0f, -4.0f, -4.0f, 8, 4, 8, 0.2f, false));
        this.head_r1 = new ModelRenderer((ModelBase)this);
        this.head_r1.func_78793_a(0.0f, 0.0f, 0.0f);
        this.head.func_78792_a(this.head_r1);
        this.setRotationAngle(this.head_r1, -0.2182f, -0.7854f, 0.0f);
        this.head_r1.field_78804_l.add(new ModelBox(this.head_r1, 37, 51, -1.0f, -9.0f, 4.5f, 2, 8, 1, 0.0f, true));
        this.head_r2 = new ModelRenderer((ModelBase)this);
        this.head_r2.func_78793_a(0.0f, 0.0f, 0.0f);
        this.head.func_78792_a(this.head_r2);
        this.setRotationAngle(this.head_r2, -0.2182f, 0.7854f, 0.0f);
        this.head_r2.field_78804_l.add(new ModelBox(this.head_r2, 37, 51, -1.0f, -9.0f, 4.5f, 2, 8, 1, 0.0f, false));
        this.head_r3 = new ModelRenderer((ModelBase)this);
        this.head_r3.func_78793_a(0.0f, 0.0f, 0.0f);
        this.head.func_78792_a(this.head_r3);
        this.setRotationAngle(this.head_r3, -0.2182f, 1.5708f, 0.0f);
        this.head_r3.field_78804_l.add(new ModelBox(this.head_r3, 37, 51, -1.0f, -9.0f, 3.5f, 2, 8, 1, 0.0f, true));
        this.head_r4 = new ModelRenderer((ModelBase)this);
        this.head_r4.func_78793_a(0.0f, 0.0f, 0.0f);
        this.head.func_78792_a(this.head_r4);
        this.setRotationAngle(this.head_r4, -0.2182f, -1.5708f, 0.0f);
        this.head_r4.field_78804_l.add(new ModelBox(this.head_r4, 37, 51, -1.0f, -9.0f, 3.5f, 2, 8, 1, 0.0f, false));
        this.head_r5 = new ModelRenderer((ModelBase)this);
        this.head_r5.func_78793_a(0.0f, 0.0f, 0.0f);
        this.head.func_78792_a(this.head_r5);
        this.setRotationAngle(this.head_r5, -0.2182f, 0.0f, 0.0f);
        this.head_r5.field_78804_l.add(new ModelBox(this.head_r5, 37, 51, -1.0f, -9.0f, 3.5f, 2, 8, 1, 0.0f, false));
        this.RightArm = new ModelRenderer((ModelBase)this);
        this.RightArm.func_78793_a(-6.0f, -3.0f, 0.0f);
        this.RightArm.field_78804_l.add(new ModelBox(this.RightArm, 37, 0, -6.0f, -2.0f, -3.0f, 6, 12, 6, 0.0f, true));
        this.RightArm.field_78804_l.add(new ModelBox(this.RightArm, 44, 37, -5.5f, 10.0f, -2.5f, 5, 8, 5, 0.0f, false));
        this.RightArm.field_78804_l.add(new ModelBox(this.RightArm, 32, 20, -7.0f, 18.0f, -4.0f, 8, 8, 8, 0.0f, false));
        this.RightLeg = new ModelRenderer((ModelBase)this);
        this.RightLeg.func_78793_a(-1.9f, 8.0f, 0.0f);
        this.RightLeg.field_78804_l.add(new ModelBox(this.RightLeg, 0, 16, -2.0f, 0.0f, -2.0f, 4, 16, 4, 0.0f, false));
        this.LeftLeg = new ModelRenderer((ModelBase)this);
        this.LeftLeg.func_78793_a(1.9f, 8.0f, 0.0f);
        this.LeftLeg.field_78804_l.add(new ModelBox(this.LeftLeg, 0, 16, -2.0f, 0.0f, -2.0f, 4, 16, 4, 0.0f, true));
        this.LeftArm = new ModelRenderer((ModelBase)this);
        this.LeftArm.func_78793_a(6.0f, -3.0f, 0.0f);
        this.LeftArm.field_78804_l.add(new ModelBox(this.LeftArm, 37, 0, 0.0f, -2.0f, -3.0f, 6, 12, 6, 0.0f, false));
        this.LeftArm.field_78804_l.add(new ModelBox(this.LeftArm, 44, 37, 0.5f, 10.0f, -2.5f, 5, 8, 5, 0.0f, true));
        this.LeftArm.field_78804_l.add(new ModelBox(this.LeftArm, 32, 20, -1.0f, 18.0f, -4.0f, 8, 8, 8, 0.0f, true));
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.Body.func_78785_a(f5);
        this.head.func_78785_a(f5);
        this.RightArm.func_78785_a(f5);
        this.RightLeg.func_78785_a(f5);
        this.LeftLeg.func_78785_a(f5);
        this.LeftArm.func_78785_a(f5);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        float limbRange = 1.2f;
        float limbSpeed = 0.5662f;
        this.LeftArm.field_78795_f = Mth.func_76134_b((float)(limbSwing * limbSpeed)) * limbRange * limbSwingAmount;
        this.RightArm.field_78795_f = Mth.func_76134_b((float)(limbSwing * limbSpeed + (float)Math.PI)) * limbRange * limbSwingAmount;
        this.LeftLeg.field_78795_f = Mth.func_76134_b((float)(limbSwing * limbSpeed + (float)Math.PI)) * limbRange * limbSwingAmount;
        this.RightLeg.field_78795_f = Mth.func_76134_b((float)(limbSwing * limbSpeed)) * limbRange * limbSwingAmount;
        this.head.field_78796_g = netHeadYaw * ((float)Math.PI / 180);
        this.head.field_78795_f = headPitch * ((float)Math.PI / 180);
    }
}

