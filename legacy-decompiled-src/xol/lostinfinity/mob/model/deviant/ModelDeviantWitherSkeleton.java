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

public class ModelDeviantWitherSkeleton
extends ModelBase {
    private final ModelRenderer waist;
    private final ModelRenderer Body;
    private final ModelRenderer head;
    private final ModelRenderer RightLeg;
    private final ModelRenderer LeftLeg;
    private final ModelRenderer RightArm;
    private final ModelRenderer LeftArm;
    private final ModelRenderer LeftArm2;
    private final ModelRenderer RightArm2;

    public ModelDeviantWitherSkeleton() {
        this.field_78090_t = 64;
        this.field_78089_u = 32;
        this.waist = new ModelRenderer((ModelBase)this);
        this.waist.func_78793_a(0.0f, 12.0f, 0.0f);
        this.Body = new ModelRenderer((ModelBase)this);
        this.Body.func_78793_a(0.0f, -12.0f, 0.0f);
        this.waist.func_78792_a(this.Body);
        this.Body.field_78804_l.add(new ModelBox(this.Body, 8, 16, -4.0f, 0.0f, -2.0f, 8, 12, 4, 0.0f, false));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 32, 0, -6.0f, 0.0f, 2.0f, 12, 8, 4, 0.0f, false));
        this.head = new ModelRenderer((ModelBase)this);
        this.head.func_78793_a(0.0f, 0.0f, 0.0f);
        this.head.field_78804_l.add(new ModelBox(this.head, 0, 0, -4.0f, -8.0f, -4.0f, 8, 8, 8, 0.0f, false));
        this.head.field_78804_l.add(new ModelBox(this.head, 33, 12, 3.0f, -16.0f, -3.0f, 1, 8, 6, 0.0f, false));
        this.head.field_78804_l.add(new ModelBox(this.head, 33, 12, -4.0f, -16.0f, -3.0f, 1, 8, 6, 0.0f, true));
        this.RightLeg = new ModelRenderer((ModelBase)this);
        this.RightLeg.func_78793_a(-2.0f, 12.0f, 0.0f);
        this.RightLeg.field_78804_l.add(new ModelBox(this.RightLeg, 0, 16, -1.0f, 0.0f, -1.0f, 2, 12, 2, 0.0f, false));
        this.LeftLeg = new ModelRenderer((ModelBase)this);
        this.LeftLeg.func_78793_a(2.0f, 12.0f, 0.0f);
        this.LeftLeg.field_78804_l.add(new ModelBox(this.LeftLeg, 0, 16, -1.0f, 0.0f, -1.0f, 2, 12, 2, 0.0f, true));
        this.RightArm = new ModelRenderer((ModelBase)this);
        this.RightArm.func_78793_a(-5.0f, 2.0f, 0.0f);
        this.setRotationAngle(this.RightArm, 0.0f, 0.0f, 0.4363f);
        this.RightArm.field_78804_l.add(new ModelBox(this.RightArm, 56, 12, -1.0f, -2.0f, -1.0f, 2, 12, 2, 0.0f, false));
        this.RightArm.field_78804_l.add(new ModelBox(this.RightArm, 33, 12, -1.5f, 4.0f, -15.0f, 1, 6, 14, 0.0f, false));
        this.LeftArm = new ModelRenderer((ModelBase)this);
        this.LeftArm.func_78793_a(5.0f, 2.0f, 0.0f);
        this.setRotationAngle(this.LeftArm, 0.0f, 0.0f, -0.4363f);
        this.LeftArm.field_78804_l.add(new ModelBox(this.LeftArm, 56, 12, -1.0f, -2.0f, -1.0f, 2, 12, 2, 0.0f, true));
        this.LeftArm.field_78804_l.add(new ModelBox(this.LeftArm, 33, 12, 0.5f, 4.0f, -15.0f, 1, 6, 14, 0.0f, true));
        this.LeftArm2 = new ModelRenderer((ModelBase)this);
        this.LeftArm2.func_78793_a(7.0f, 2.0f, 4.0f);
        this.setRotationAngle(this.LeftArm2, 0.0f, 0.0f, -1.1345f);
        this.LeftArm2.field_78804_l.add(new ModelBox(this.LeftArm2, 56, 12, -1.0f, -2.0f, -1.0f, 2, 12, 2, 0.0f, true));
        this.LeftArm2.field_78804_l.add(new ModelBox(this.LeftArm2, 33, 12, 0.5f, 4.0f, -15.0f, 1, 6, 14, 0.0f, true));
        this.RightArm2 = new ModelRenderer((ModelBase)this);
        this.RightArm2.func_78793_a(-7.0f, 2.0f, 4.0f);
        this.setRotationAngle(this.RightArm2, 0.0f, 0.0f, 1.1345f);
        this.RightArm2.field_78804_l.add(new ModelBox(this.RightArm2, 56, 12, -1.0f, -2.0f, -1.0f, 2, 12, 2, 0.0f, false));
        this.RightArm2.field_78804_l.add(new ModelBox(this.RightArm2, 33, 12, -1.5f, 4.0f, -15.0f, 1, 6, 14, 0.0f, false));
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.waist.func_78785_a(f5);
        this.head.func_78785_a(f5);
        this.RightLeg.func_78785_a(f5);
        this.LeftLeg.func_78785_a(f5);
        this.RightArm.func_78785_a(f5);
        this.LeftArm.func_78785_a(f5);
        this.LeftArm2.func_78785_a(f5);
        this.RightArm2.func_78785_a(f5);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.head.field_78796_g = netHeadYaw * ((float)Math.PI / 180);
        this.head.field_78795_f = headPitch * ((float)Math.PI / 180);
        this.RightLeg.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f)) * 1.4f * limbSwingAmount * 0.5f;
        this.LeftLeg.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f + (float)Math.PI)) * 1.4f * limbSwingAmount * 0.5f;
        this.RightArm.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f + (float)Math.PI)) * 2.0f * limbSwingAmount * 0.5f;
        this.LeftArm.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f)) * 2.0f * limbSwingAmount * 0.5f;
        this.RightArm2.field_78795_f = Mth.func_76126_a((float)(limbSwing * 0.6662f + (float)Math.PI)) * 2.0f * limbSwingAmount * 0.5f;
        this.LeftArm2.field_78795_f = Mth.func_76126_a((float)(limbSwing * 0.6662f)) * 2.0f * limbSwingAmount * 0.5f;
    }
}

