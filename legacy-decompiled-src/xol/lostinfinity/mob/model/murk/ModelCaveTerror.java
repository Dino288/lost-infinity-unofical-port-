/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.model.ModelBox
 *  net.minecraft.client.model.ModelRenderer
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.math.Mth
 */
package xol.lostinfinity.mob.model.murk;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;

public class ModelCaveTerror
extends ModelBase {
    private final ModelRenderer Body;
    private final ModelRenderer Body_r1;
    private final ModelRenderer RightArm;
    private final ModelRenderer LeftArm;
    private final ModelRenderer spine1;
    private final ModelRenderer Body_r2;
    private final ModelRenderer spine2;
    private final ModelRenderer Body_r3;
    private final ModelRenderer spine3;
    private final ModelRenderer Body_r4;
    private final ModelRenderer spine4;
    private final ModelRenderer Body_r5;
    private final ModelRenderer spine5;
    private final ModelRenderer Body_r6;
    private final ModelRenderer spine6;
    private final ModelRenderer Body_r7;
    private final ModelRenderer Head;
    private final ModelRenderer LeftLeg;
    private final ModelRenderer LeftLeg_r1;
    private final ModelRenderer RightLeg;
    private final ModelRenderer LeftLeg_r2;

    public ModelCaveTerror() {
        this.field_78090_t = 64;
        this.field_78089_u = 32;
        this.Body = new ModelRenderer((ModelBase)this);
        this.Body.func_78793_a(0.0f, 7.5f, 0.0f);
        this.Body_r1 = new ModelRenderer((ModelBase)this);
        this.Body_r1.func_78793_a(0.0f, -6.0f, 0.0f);
        this.Body.func_78792_a(this.Body_r1);
        this.setRotationAngle(this.Body_r1, 0.4363f, 0.0f, 0.0f);
        this.Body_r1.field_78804_l.add(new ModelBox(this.Body_r1, 0, 16, -4.0f, -4.5f, -4.0f, 8, 11, 4, 0.0f, false));
        this.RightArm = new ModelRenderer((ModelBase)this);
        this.RightArm.func_78793_a(-5.0f, -6.5f, -4.0f);
        this.Body.func_78792_a(this.RightArm);
        this.setRotationAngle(this.RightArm, 0.0f, 0.0f, 0.1745f);
        this.RightArm.field_78804_l.add(new ModelBox(this.RightArm, 52, 13, -2.0f, -2.0f, -1.5f, 3, 14, 3, 0.0f, true));
        this.RightArm.field_78804_l.add(new ModelBox(this.RightArm, 25, 3, 1.0f, 11.0f, -1.5f, 3, 1, 1, 0.0f, false));
        this.RightArm.field_78804_l.add(new ModelBox(this.RightArm, 25, 3, 1.0f, 11.0f, 0.5f, 3, 1, 1, 0.0f, false));
        this.LeftArm = new ModelRenderer((ModelBase)this);
        this.LeftArm.func_78793_a(5.0f, -6.5f, -4.0f);
        this.Body.func_78792_a(this.LeftArm);
        this.setRotationAngle(this.LeftArm, 0.0f, 0.0f, -0.1745f);
        this.LeftArm.field_78804_l.add(new ModelBox(this.LeftArm, 52, 13, -1.0f, -2.0f, -1.5f, 3, 14, 3, 0.0f, false));
        this.LeftArm.field_78804_l.add(new ModelBox(this.LeftArm, 25, 3, -4.0f, 11.0f, -1.5f, 3, 1, 1, 0.0f, true));
        this.LeftArm.field_78804_l.add(new ModelBox(this.LeftArm, 25, 3, -4.0f, 11.0f, 0.5f, 3, 1, 1, 0.0f, true));
        this.spine1 = new ModelRenderer((ModelBase)this);
        this.spine1.func_78793_a(2.5f, -0.83f, 1.2546f);
        this.Body.func_78792_a(this.spine1);
        this.Body_r2 = new ModelRenderer((ModelBase)this);
        this.Body_r2.func_78793_a(0.0f, 0.0f, 0.0f);
        this.spine1.func_78792_a(this.Body_r2);
        this.setRotationAngle(this.Body_r2, 0.4363f, 0.0f, 0.0f);
        this.Body_r2.field_78804_l.add(new ModelBox(this.Body_r2, 34, 17, -0.5f, -0.5f, -1.0f, 1, 1, 14, 0.0f, false));
        this.spine2 = new ModelRenderer((ModelBase)this);
        this.spine2.func_78793_a(-2.5f, -0.83f, 1.2546f);
        this.Body.func_78792_a(this.spine2);
        this.Body_r3 = new ModelRenderer((ModelBase)this);
        this.Body_r3.func_78793_a(0.0f, 0.0f, 0.0f);
        this.spine2.func_78792_a(this.Body_r3);
        this.setRotationAngle(this.Body_r3, 0.4363f, 0.0f, 0.0f);
        this.Body_r3.field_78804_l.add(new ModelBox(this.Body_r3, 34, 17, -0.5f, -0.5f, -1.0f, 1, 1, 14, 0.0f, false));
        this.spine3 = new ModelRenderer((ModelBase)this);
        this.spine3.func_78793_a(-1.5f, -2.83f, 0.2546f);
        this.Body.func_78792_a(this.spine3);
        this.Body_r4 = new ModelRenderer((ModelBase)this);
        this.Body_r4.func_78793_a(0.0f, 0.0f, 0.0f);
        this.spine3.func_78792_a(this.Body_r4);
        this.setRotationAngle(this.Body_r4, 0.4363f, 0.0f, 0.0f);
        this.Body_r4.field_78804_l.add(new ModelBox(this.Body_r4, 34, 17, -0.5f, -0.5f, -1.0f, 1, 1, 14, 0.0f, false));
        this.spine4 = new ModelRenderer((ModelBase)this);
        this.spine4.func_78793_a(1.5f, -2.83f, 0.2546f);
        this.Body.func_78792_a(this.spine4);
        this.Body_r5 = new ModelRenderer((ModelBase)this);
        this.Body_r5.func_78793_a(0.0f, 0.0f, 0.0f);
        this.spine4.func_78792_a(this.Body_r5);
        this.setRotationAngle(this.Body_r5, 0.4363f, 0.0f, 0.0f);
        this.Body_r5.field_78804_l.add(new ModelBox(this.Body_r5, 34, 17, -0.5f, -0.5f, -1.0f, 1, 1, 14, 0.0f, false));
        this.spine5 = new ModelRenderer((ModelBase)this);
        this.spine5.func_78793_a(2.5f, -4.83f, -0.7454f);
        this.Body.func_78792_a(this.spine5);
        this.Body_r6 = new ModelRenderer((ModelBase)this);
        this.Body_r6.func_78793_a(0.0f, 0.0f, 0.0f);
        this.spine5.func_78792_a(this.Body_r6);
        this.setRotationAngle(this.Body_r6, 0.4363f, 0.0f, 0.0f);
        this.Body_r6.field_78804_l.add(new ModelBox(this.Body_r6, 34, 17, -0.5f, -0.5f, -1.0f, 1, 1, 14, 0.0f, false));
        this.spine6 = new ModelRenderer((ModelBase)this);
        this.spine6.func_78793_a(-2.5f, -4.83f, -0.7454f);
        this.Body.func_78792_a(this.spine6);
        this.Body_r7 = new ModelRenderer((ModelBase)this);
        this.Body_r7.func_78793_a(0.0f, 0.0f, 0.0f);
        this.spine6.func_78792_a(this.Body_r7);
        this.setRotationAngle(this.Body_r7, 0.4363f, 0.0f, 0.0f);
        this.Body_r7.field_78804_l.add(new ModelBox(this.Body_r7, 34, 17, -0.5f, -0.5f, -1.0f, 1, 1, 14, 0.0f, false));
        this.Head = new ModelRenderer((ModelBase)this);
        this.Head.func_78793_a(0.0f, -7.5f, -4.0f);
        this.Body.func_78792_a(this.Head);
        this.Head.field_78804_l.add(new ModelBox(this.Head, 0, 0, -4.0f, -8.0f, -4.0f, 8, 8, 8, -0.1f, false));
        this.Head.field_78804_l.add(new ModelBox(this.Head, 33, 0, -4.0f, -8.0f, -4.3f, 8, 8, 1, -0.2f, false));
        this.LeftLeg = new ModelRenderer((ModelBase)this);
        this.LeftLeg.func_78793_a(1.9f, 7.0f, 0.0f);
        this.LeftLeg.field_78804_l.add(new ModelBox(this.LeftLeg, 35, 9, -1.0f, 0.0f, -1.5f, 3, 6, 3, 0.0f, true));
        this.LeftLeg_r1 = new ModelRenderer((ModelBase)this);
        this.LeftLeg_r1.func_78793_a(0.5f, 7.5f, 0.0f);
        this.LeftLeg.func_78792_a(this.LeftLeg_r1);
        this.setRotationAngle(this.LeftLeg_r1, 0.0f, 0.6109f, 0.0f);
        this.LeftLeg_r1.field_78804_l.add(new ModelBox(this.LeftLeg_r1, 52, 1, -1.5f, 1.5f, 4.5f, 3, 8, 3, 0.0f, true));
        this.LeftLeg_r1.field_78804_l.add(new ModelBox(this.LeftLeg_r1, 24, 19, -1.5f, -1.5f, -1.5f, 3, 3, 9, 0.0f, true));
        this.RightLeg = new ModelRenderer((ModelBase)this);
        this.RightLeg.func_78793_a(-1.9f, 7.0f, 0.0f);
        this.RightLeg.field_78804_l.add(new ModelBox(this.RightLeg, 35, 9, -2.0f, 0.0f, -1.5f, 3, 6, 3, 0.0f, false));
        this.LeftLeg_r2 = new ModelRenderer((ModelBase)this);
        this.LeftLeg_r2.func_78793_a(-0.5f, 7.5f, 0.0f);
        this.RightLeg.func_78792_a(this.LeftLeg_r2);
        this.setRotationAngle(this.LeftLeg_r2, 0.0f, -0.6109f, 0.0f);
        this.LeftLeg_r2.field_78804_l.add(new ModelBox(this.LeftLeg_r2, 52, 1, -1.5f, 1.5f, 4.5f, 3, 8, 3, 0.0f, false));
        this.LeftLeg_r2.field_78804_l.add(new ModelBox(this.LeftLeg_r2, 24, 19, -1.5f, -1.5f, -1.5f, 3, 3, 9, 0.0f, false));
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        GlStateManager.func_179147_l();
        GlStateManager.func_179112_b((int)770, (int)771);
        float ageVar = f2 * 0.2f;
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)(0.5f + 0.4f * (float)Math.sin(ageVar)));
        this.Body.func_78785_a(f5);
        this.LeftLeg.func_78785_a(f5);
        this.RightLeg.func_78785_a(f5);
        GlStateManager.func_179084_k();
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.LeftLeg.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.3662f + (float)Math.PI)) * limbSwingAmount * 0.5f;
        this.LeftLeg.field_78808_h = 0.8f * Mth.func_76134_b((float)(limbSwing * 0.2662f + (float)Math.PI)) * limbSwingAmount * 0.5f;
        this.RightLeg.field_78795_f = this.LeftLeg.field_78795_f;
        this.RightLeg.field_78808_h = -this.LeftLeg.field_78808_h;
        this.LeftArm.field_78808_h = -0.2f + 0.2f * Mth.func_76126_a((float)(ageInTicks * 0.2f));
        this.RightArm.field_78808_h = -this.LeftArm.field_78808_h;
        this.Body.field_78795_f = 0.6f + 0.6f * Mth.func_76126_a((float)(ageInTicks * 0.1f));
        this.Head.field_78796_g = netHeadYaw * ((float)Math.PI / 180);
        this.Head.field_78795_f = headPitch * ((float)Math.PI / 180) - this.Body.field_78795_f;
        this.spine2.field_78795_f = this.spine1.field_78795_f = 0.3f * Mth.func_76126_a((float)(ageInTicks * 0.05f));
        this.spine3.field_78795_f = this.spine1.field_78795_f;
        this.spine4.field_78795_f = this.spine1.field_78795_f;
        this.spine5.field_78795_f = this.spine1.field_78795_f;
        this.spine6.field_78795_f = this.spine1.field_78795_f;
        this.spine1.field_78796_g = 0.55f + 0.3f * Mth.func_76126_a((float)(ageInTicks * 0.15f));
        this.spine4.field_78796_g = 0.55f + 0.3f * Mth.func_76134_b((float)(ageInTicks * 0.15f));
        this.spine5.field_78796_g = 0.55f - 0.3f * Mth.func_76126_a((float)(ageInTicks * 0.15f));
        this.spine2.field_78796_g = -this.spine1.field_78796_g;
        this.spine3.field_78796_g = -this.spine4.field_78796_g;
        this.spine6.field_78796_g = -this.spine5.field_78796_g;
    }
}

