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

public class ModelBarul
extends ModelBase {
    private final ModelRenderer Head;
    private final ModelRenderer Body;
    private final ModelRenderer LeftArm;
    private final ModelRenderer LeftLeg;
    private final ModelRenderer RightLeg;
    private final ModelRenderer RightArm;
    private final ModelRenderer Tail;
    private final ModelRenderer Body_r1;
    private final ModelRenderer Body_r2;
    private final ModelRenderer Tail2;
    private final ModelRenderer Body_r3;
    private final ModelRenderer Body_r4;
    private final ModelRenderer Tail3;
    private final ModelRenderer Body_r5;
    private final ModelRenderer Body_r6;

    public ModelBarul() {
        this.field_78090_t = 128;
        this.field_78089_u = 64;
        this.Head = new ModelRenderer((ModelBase)this);
        this.Head.func_78793_a(0.0f, -7.0f, 0.0f);
        this.Head.field_78804_l.add(new ModelBox(this.Head, 0, 0, -4.0f, -12.0f, -4.0f, 8, 8, 8, 0.0f, false));
        this.Head.field_78804_l.add(new ModelBox(this.Head, 32, 0, -4.0f, -12.0f, -4.0f, 8, 8, 8, 0.2f, false));
        this.Head.field_78804_l.add(new ModelBox(this.Head, 39, 17, -1.0f, -16.0f, -4.0f, 2, 4, 8, 0.1f, false));
        this.Body = new ModelRenderer((ModelBase)this);
        this.Body.func_78793_a(0.0f, 2.5f, 0.0f);
        this.Body.field_78804_l.add(new ModelBox(this.Body, 0, 16, -6.0f, -13.5f, -3.0f, 12, 10, 6, 0.0f, false));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 0, 33, -5.0f, -4.5f, -3.0f, 10, 10, 6, -0.2f, false));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 34, 33, -5.0f, -4.5f, -3.0f, 10, 10, 6, -0.1f, false));
        this.LeftArm = new ModelRenderer((ModelBase)this);
        this.LeftArm.func_78793_a(8.0f, -10.0f, 0.0f);
        this.LeftArm.field_78804_l.add(new ModelBox(this.LeftArm, 67, 0, -2.0f, 0.0f, -2.5f, 5, 12, 5, 0.1f, true));
        this.LeftArm.field_78804_l.add(new ModelBox(this.LeftArm, 89, 3, -1.5f, 11.0f, -2.0f, 4, 10, 4, 0.0f, true));
        this.LeftLeg = new ModelRenderer((ModelBase)this);
        this.LeftLeg.func_78793_a(2.9f, 6.0f, 0.0f);
        this.LeftLeg.field_78804_l.add(new ModelBox(this.LeftLeg, 68, 18, -2.0f, 0.0f, -2.5f, 5, 18, 5, 0.0f, true));
        this.LeftLeg.field_78804_l.add(new ModelBox(this.LeftLeg, 93, 25, -1.0f, 14.0f, -3.5f, 3, 3, 1, 0.0f, true));
        this.LeftLeg.field_78804_l.add(new ModelBox(this.LeftLeg, 93, 25, -1.0f, 9.0f, -3.5f, 3, 3, 1, 0.0f, true));
        this.LeftLeg.field_78804_l.add(new ModelBox(this.LeftLeg, 93, 25, -1.0f, 4.0f, -3.5f, 3, 3, 1, 0.0f, true));
        this.LeftLeg.field_78804_l.add(new ModelBox(this.LeftLeg, 95, 22, 0.0f, 5.0f, -4.5f, 1, 1, 1, 0.0f, true));
        this.LeftLeg.field_78804_l.add(new ModelBox(this.LeftLeg, 95, 22, 0.0f, 10.0f, -4.5f, 1, 1, 1, 0.0f, true));
        this.LeftLeg.field_78804_l.add(new ModelBox(this.LeftLeg, 95, 22, 0.0f, 15.0f, -4.5f, 1, 1, 1, 0.0f, true));
        this.RightLeg = new ModelRenderer((ModelBase)this);
        this.RightLeg.func_78793_a(-2.9f, 6.0f, 0.0f);
        this.RightLeg.field_78804_l.add(new ModelBox(this.RightLeg, 68, 18, -3.0f, 0.0f, -2.5f, 5, 18, 5, 0.0f, false));
        this.RightLeg.field_78804_l.add(new ModelBox(this.RightLeg, 93, 25, -2.0f, 14.0f, -3.5f, 3, 3, 1, 0.0f, false));
        this.RightLeg.field_78804_l.add(new ModelBox(this.RightLeg, 93, 25, -2.0f, 9.0f, -3.5f, 3, 3, 1, 0.0f, false));
        this.RightLeg.field_78804_l.add(new ModelBox(this.RightLeg, 93, 25, -2.0f, 4.0f, -3.5f, 3, 3, 1, 0.0f, false));
        this.RightLeg.field_78804_l.add(new ModelBox(this.RightLeg, 95, 22, -1.0f, 5.0f, -4.5f, 1, 1, 1, 0.0f, false));
        this.RightLeg.field_78804_l.add(new ModelBox(this.RightLeg, 95, 22, -1.0f, 10.0f, -4.5f, 1, 1, 1, 0.0f, false));
        this.RightLeg.field_78804_l.add(new ModelBox(this.RightLeg, 95, 22, -1.0f, 15.0f, -4.5f, 1, 1, 1, 0.0f, false));
        this.RightArm = new ModelRenderer((ModelBase)this);
        this.RightArm.func_78793_a(-8.0f, -10.0f, 0.0f);
        this.RightArm.field_78804_l.add(new ModelBox(this.RightArm, 67, 0, -3.0f, 0.0f, -2.5f, 5, 12, 5, 0.1f, false));
        this.RightArm.field_78804_l.add(new ModelBox(this.RightArm, 89, 3, -2.5f, 11.0f, -2.0f, 4, 10, 4, 0.0f, false));
        this.RightArm.field_78804_l.add(new ModelBox(this.RightArm, 93, 5, -1.5f, 18.0f, -16.0f, 2, 2, 14, 0.0f, false));
        this.RightArm.field_78804_l.add(new ModelBox(this.RightArm, 95, 22, -4.5f, 15.0f, -24.0f, 8, 8, 8, 0.0f, false));
        this.Tail = new ModelRenderer((ModelBase)this);
        this.Tail.func_78793_a(0.0f, 7.0f, 2.0f);
        this.setRotationAngle(this.Tail, -0.5236f, 0.0f, 0.0f);
        this.Tail.field_78804_l.add(new ModelBox(this.Tail, 67, 42, -2.0f, -12.0f, -2.0f, 4, 12, 4, 0.0f, false));
        this.Body_r1 = new ModelRenderer((ModelBase)this);
        this.Body_r1.func_78793_a(0.0f, -18.0f, 0.0f);
        this.Tail.func_78792_a(this.Body_r1);
        this.setRotationAngle(this.Body_r1, 0.4363f, 0.0f, 0.0f);
        this.Body_r1.field_78804_l.add(new ModelBox(this.Body_r1, 105, 42, -2.0f, -16.0f, -3.0f, 4, 12, 4, -0.3f, false));
        this.Body_r2 = new ModelRenderer((ModelBase)this);
        this.Body_r2.func_78793_a(0.0f, -18.0f, 0.0f);
        this.Tail.func_78792_a(this.Body_r2);
        this.setRotationAngle(this.Body_r2, 0.2618f, 0.0f, 0.0f);
        this.Body_r2.field_78804_l.add(new ModelBox(this.Body_r2, 86, 42, -2.0f, -5.0f, -4.0f, 4, 12, 4, -0.2f, false));
        this.Tail2 = new ModelRenderer((ModelBase)this);
        this.Tail2.func_78793_a(-3.0f, 7.0f, 2.0f);
        this.setRotationAngle(this.Tail2, -0.5236f, 0.0f, -0.5236f);
        this.Tail2.field_78804_l.add(new ModelBox(this.Tail2, 67, 42, -2.0f, -12.0f, -2.0f, 4, 12, 4, 0.0f, false));
        this.Body_r3 = new ModelRenderer((ModelBase)this);
        this.Body_r3.func_78793_a(0.0f, -18.0f, 0.0f);
        this.Tail2.func_78792_a(this.Body_r3);
        this.setRotationAngle(this.Body_r3, 0.4363f, 0.0f, 0.0f);
        this.Body_r3.field_78804_l.add(new ModelBox(this.Body_r3, 105, 42, -2.0f, -16.0f, -3.0f, 4, 12, 4, -0.3f, false));
        this.Body_r4 = new ModelRenderer((ModelBase)this);
        this.Body_r4.func_78793_a(0.0f, -18.0f, 0.0f);
        this.Tail2.func_78792_a(this.Body_r4);
        this.setRotationAngle(this.Body_r4, 0.2618f, 0.0f, 0.0f);
        this.Body_r4.field_78804_l.add(new ModelBox(this.Body_r4, 86, 42, -2.0f, -5.0f, -4.0f, 4, 12, 4, -0.2f, false));
        this.Tail3 = new ModelRenderer((ModelBase)this);
        this.Tail3.func_78793_a(3.0f, 7.0f, 2.0f);
        this.setRotationAngle(this.Tail3, -0.5236f, 0.0f, 0.5236f);
        this.Tail3.field_78804_l.add(new ModelBox(this.Tail3, 67, 42, -2.0f, -12.0f, -2.0f, 4, 12, 4, 0.0f, true));
        this.Body_r5 = new ModelRenderer((ModelBase)this);
        this.Body_r5.func_78793_a(0.0f, -18.0f, 0.0f);
        this.Tail3.func_78792_a(this.Body_r5);
        this.setRotationAngle(this.Body_r5, 0.4363f, 0.0f, 0.0f);
        this.Body_r5.field_78804_l.add(new ModelBox(this.Body_r5, 105, 42, -2.0f, -16.0f, -3.0f, 4, 12, 4, -0.3f, true));
        this.Body_r6 = new ModelRenderer((ModelBase)this);
        this.Body_r6.func_78793_a(0.0f, -18.0f, 0.0f);
        this.Tail3.func_78792_a(this.Body_r6);
        this.setRotationAngle(this.Body_r6, 0.2618f, 0.0f, 0.0f);
        this.Body_r6.field_78804_l.add(new ModelBox(this.Body_r6, 86, 42, -2.0f, -5.0f, -4.0f, 4, 12, 4, -0.2f, true));
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.Head.func_78785_a(f5);
        this.Body.func_78785_a(f5);
        this.LeftArm.func_78785_a(f5);
        this.LeftLeg.func_78785_a(f5);
        this.RightLeg.func_78785_a(f5);
        this.RightArm.func_78785_a(f5);
        this.Tail.func_78785_a(f5);
        this.Tail2.func_78785_a(f5);
        this.Tail3.func_78785_a(f5);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.Head.field_78796_g = netHeadYaw * ((float)Math.PI / 180);
        this.Head.field_78795_f = headPitch * ((float)Math.PI / 180);
        this.RightLeg.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f)) * limbSwingAmount * 0.5f;
        this.LeftLeg.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f + (float)Math.PI)) * limbSwingAmount * 0.5f;
        this.LeftArm.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f)) * 2.0f * limbSwingAmount * 0.5f;
        this.RightArm.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f + (float)Math.PI)) * 2.0f * limbSwingAmount * 0.5f;
        this.Tail.field_78795_f = -0.55f + 0.1f * Mth.func_76126_a((float)(ageInTicks * 0.1f));
        this.Tail2.field_78795_f = -0.55f - 0.1f * Mth.func_76126_a((float)(ageInTicks * 0.1f));
        this.Tail3.field_78795_f = -0.55f + 0.1f * Mth.func_76134_b((float)(ageInTicks * 0.1f));
    }
}

