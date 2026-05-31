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

public class ModelPickleMan
extends ModelBase {
    private final ModelRenderer Body;
    private final ModelRenderer Body_r1;
    private final ModelRenderer LeftArm;
    private final ModelRenderer LeftArm_r1;
    private final ModelRenderer LeftArm_r2;
    private final ModelRenderer LeftLeg;
    private final ModelRenderer RightLeg;
    private final ModelRenderer RightArm;
    private final ModelRenderer LeftArm_r3;
    private final ModelRenderer LeftArm_r4;

    public ModelPickleMan() {
        this.field_78090_t = 64;
        this.field_78089_u = 64;
        this.Body = new ModelRenderer((ModelBase)this);
        this.Body.func_78793_a(0.0f, -1.0f, 0.0f);
        this.Body.field_78804_l.add(new ModelBox(this.Body, 0, 0, -4.0f, -13.0f, -3.0f, 8, 12, 8, -0.1f, false));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 36, 0, -3.5f, -14.0f, -2.5f, 7, 2, 7, -0.1f, false));
        this.Body_r1 = new ModelRenderer((ModelBase)this);
        this.Body_r1.func_78793_a(0.0f, 3.0f, 0.0f);
        this.Body.func_78792_a(this.Body_r1);
        this.setRotationAngle(this.Body_r1, -0.1745f, 0.0f, 0.0f);
        this.Body_r1.field_78804_l.add(new ModelBox(this.Body_r1, 36, 9, -3.5f, 9.0f, -3.5f, 7, 1, 7, 0.0f, false));
        this.Body_r1.field_78804_l.add(new ModelBox(this.Body_r1, 0, 45, -4.0f, -4.0f, -3.9f, 8, 10, 7, 1.0f, false));
        this.Body_r1.field_78804_l.add(new ModelBox(this.Body_r1, 0, 21, -4.0f, -5.0f, -4.0f, 8, 14, 8, 0.0f, false));
        this.LeftArm = new ModelRenderer((ModelBase)this);
        this.LeftArm.func_78793_a(5.0f, -3.0f, 0.0f);
        this.LeftArm.field_78804_l.add(new ModelBox(this.LeftArm, 46, 25, -2.0f, -2.0f, -2.5f, 4, 3, 5, 0.0f, true));
        this.LeftArm_r1 = new ModelRenderer((ModelBase)this);
        this.LeftArm_r1.func_78793_a(0.5f, 4.0f, 0.0f);
        this.LeftArm.func_78792_a(this.LeftArm_r1);
        this.setRotationAngle(this.LeftArm_r1, -0.4363f, 0.0f, -0.7854f);
        this.LeftArm_r1.field_78804_l.add(new ModelBox(this.LeftArm_r1, 32, 52, 0.0f, 6.0f, 1.5f, 3, 9, 3, -0.3f, true));
        this.LeftArm_r2 = new ModelRenderer((ModelBase)this);
        this.LeftArm_r2.func_78793_a(0.5f, 4.0f, 0.0f);
        this.LeftArm.func_78792_a(this.LeftArm_r2);
        this.setRotationAngle(this.LeftArm_r2, 0.0f, 0.0f, -0.7854f);
        this.LeftArm_r2.field_78804_l.add(new ModelBox(this.LeftArm_r2, 52, 33, 0.0f, -4.0f, -1.5f, 3, 12, 3, 0.0f, true));
        this.LeftLeg = new ModelRenderer((ModelBase)this);
        this.LeftLeg.func_78793_a(2.9f, 9.0f, 0.0f);
        this.LeftLeg.field_78804_l.add(new ModelBox(this.LeftLeg, 24, 0, -1.0f, -1.0f, -1.5f, 3, 5, 3, 0.2f, true));
        this.LeftLeg.field_78804_l.add(new ModelBox(this.LeftLeg, 32, 17, -1.0f, 4.0f, -1.5f, 3, 11, 3, -0.2f, true));
        this.LeftLeg.field_78804_l.add(new ModelBox(this.LeftLeg, 44, 17, -1.0f, 14.0f, -6.5f, 3, 1, 7, 0.0f, true));
        this.RightLeg = new ModelRenderer((ModelBase)this);
        this.RightLeg.func_78793_a(-2.9f, 9.0f, 0.0f);
        this.RightLeg.field_78804_l.add(new ModelBox(this.RightLeg, 42, 46, -2.0f, -1.0f, -1.5f, 3, 5, 3, 0.2f, false));
        this.RightLeg.field_78804_l.add(new ModelBox(this.RightLeg, 52, 33, -2.0f, 4.0f, -1.5f, 3, 11, 3, -0.2f, false));
        this.RightLeg.field_78804_l.add(new ModelBox(this.RightLeg, 44, 17, -2.0f, 14.0f, -6.5f, 3, 1, 7, 0.0f, false));
        this.RightArm = new ModelRenderer((ModelBase)this);
        this.RightArm.func_78793_a(-5.0f, -3.0f, 0.0f);
        this.RightArm.field_78804_l.add(new ModelBox(this.RightArm, 46, 56, -2.0f, -2.0f, -2.5f, 4, 3, 5, 0.0f, false));
        this.LeftArm_r3 = new ModelRenderer((ModelBase)this);
        this.LeftArm_r3.func_78793_a(-0.5f, 4.0f, 0.0f);
        this.RightArm.func_78792_a(this.LeftArm_r3);
        this.setRotationAngle(this.LeftArm_r3, -0.4363f, 0.0f, 0.7854f);
        this.LeftArm_r3.field_78804_l.add(new ModelBox(this.LeftArm_r3, 32, 52, -3.0f, 6.0f, 1.5f, 3, 9, 3, -0.3f, false));
        this.LeftArm_r4 = new ModelRenderer((ModelBase)this);
        this.LeftArm_r4.func_78793_a(-0.5f, 4.0f, 0.0f);
        this.RightArm.func_78792_a(this.LeftArm_r4);
        this.setRotationAngle(this.LeftArm_r4, 0.0f, 0.0f, 0.7854f);
        this.LeftArm_r4.field_78804_l.add(new ModelBox(this.LeftArm_r4, 32, 31, -3.0f, -4.0f, -1.5f, 3, 12, 3, 0.0f, false));
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.Body.func_78785_a(f5);
        this.LeftArm.func_78785_a(f5);
        this.LeftLeg.func_78785_a(f5);
        this.RightLeg.func_78785_a(f5);
        this.RightArm.func_78785_a(f5);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.RightLeg.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f)) * 1.4f * limbSwingAmount * 0.5f;
        this.LeftLeg.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f + (float)Math.PI)) * 1.4f * limbSwingAmount * 0.5f;
        this.RightArm.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f + (float)Math.PI)) * 2.0f * limbSwingAmount * 0.5f;
        this.LeftArm.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f)) * 2.0f * limbSwingAmount * 0.5f;
    }
}

