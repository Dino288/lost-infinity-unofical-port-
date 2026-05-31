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

public class ModelDeviantHorse
extends ModelBase {
    private final ModelRenderer Body;
    private final ModelRenderer TailA;
    private final ModelRenderer Leg1A;
    private final ModelRenderer Leg2A;
    private final ModelRenderer Leg4A;
    private final ModelRenderer Leg4A2;
    private final ModelRenderer Leg3A;
    private final ModelRenderer Leg3A2;
    private final ModelRenderer Neck;
    private final ModelRenderer Head;
    private final ModelRenderer UMouth;
    private final ModelRenderer Ear1;
    private final ModelRenderer Ear2;
    private final ModelRenderer Mane;

    public ModelDeviantHorse() {
        this.field_78090_t = 64;
        this.field_78089_u = 64;
        this.Body = new ModelRenderer((ModelBase)this);
        this.Body.func_78793_a(0.0f, 11.0f, 9.0f);
        this.setRotationAngle(this.Body, -0.3927f, 0.0f, 0.0f);
        this.Body.field_78804_l.add(new ModelBox(this.Body, 0, 32, -5.0f, -8.0f, -20.0f, 10, 10, 22, 0.0f, true));
        this.TailA = new ModelRenderer((ModelBase)this);
        this.TailA.func_78793_a(0.0f, -7.0f, 2.0f);
        this.Body.func_78792_a(this.TailA);
        this.setRotationAngle(this.TailA, 0.5236f, 0.0f, 0.0f);
        this.TailA.field_78804_l.add(new ModelBox(this.TailA, 42, 36, -1.5f, 0.0f, -2.0f, 3, 14, 4, 0.0f, true));
        this.Leg1A = new ModelRenderer((ModelBase)this);
        this.Leg1A.func_78793_a(-3.0f, 2.0f, 0.0f);
        this.Body.func_78792_a(this.Leg1A);
        this.setRotationAngle(this.Leg1A, 0.5236f, 0.0f, 0.0f);
        this.Leg1A.field_78804_l.add(new ModelBox(this.Leg1A, 48, 21, -2.0f, 0.0f, -2.0f, 4, 11, 4, 0.0f, false));
        this.Leg2A = new ModelRenderer((ModelBase)this);
        this.Leg2A.func_78793_a(3.0f, 2.0f, 0.0f);
        this.Body.func_78792_a(this.Leg2A);
        this.setRotationAngle(this.Leg2A, 0.3491f, 0.0f, 0.0f);
        this.Leg2A.field_78804_l.add(new ModelBox(this.Leg2A, 48, 21, -2.0f, 0.0f, -2.0f, 4, 11, 4, 0.0f, true));
        this.Leg4A = new ModelRenderer((ModelBase)this);
        this.Leg4A.func_78793_a(3.0f, 2.0f, -18.0f);
        this.Body.func_78792_a(this.Leg4A);
        this.setRotationAngle(this.Leg4A, -1.1421f, -0.4011f, -0.1766f);
        this.Leg4A.field_78804_l.add(new ModelBox(this.Leg4A, 48, 21, -2.0f, 0.0f, -2.0f, 4, 11, 4, 0.0f, true));
        this.Leg4A2 = new ModelRenderer((ModelBase)this);
        this.Leg4A2.func_78793_a(0.0f, 9.0f, 0.0f);
        this.Leg4A.func_78792_a(this.Leg4A2);
        this.setRotationAngle(this.Leg4A2, 1.3838f, -0.0143f, 0.0116f);
        this.Leg4A2.field_78804_l.add(new ModelBox(this.Leg4A2, 54, 0, -1.0f, 1.0f, -1.0f, 2, 18, 3, 0.0f, true));
        this.Leg3A = new ModelRenderer((ModelBase)this);
        this.Leg3A.func_78793_a(-3.0f, 2.0f, -18.0f);
        this.Body.func_78792_a(this.Leg3A);
        this.setRotationAngle(this.Leg3A, -1.1421f, 0.4011f, 0.1766f);
        this.Leg3A.field_78804_l.add(new ModelBox(this.Leg3A, 48, 21, -2.0f, 0.0f, -2.0f, 4, 11, 4, 0.0f, false));
        this.Leg3A2 = new ModelRenderer((ModelBase)this);
        this.Leg3A2.func_78793_a(0.0f, 9.0f, 0.0f);
        this.Leg3A.func_78792_a(this.Leg3A2);
        this.setRotationAngle(this.Leg3A2, 1.3838f, 0.0143f, -0.0116f);
        this.Leg3A2.field_78804_l.add(new ModelBox(this.Leg3A2, 54, 0, -1.0f, 1.0f, -1.0f, 2, 18, 3, 0.0f, false));
        this.Neck = new ModelRenderer((ModelBase)this);
        this.Neck.func_78793_a(0.0f, -4.0f, -17.0f);
        this.Body.func_78792_a(this.Neck);
        this.setRotationAngle(this.Neck, 1.1781f, 0.0f, 0.0f);
        this.Neck.field_78804_l.add(new ModelBox(this.Neck, 0, 35, -2.0f, -11.0f, -3.0f, 4, 12, 7, 0.0f, true));
        this.Head = new ModelRenderer((ModelBase)this);
        this.Head.func_78793_a(0.0f, -11.0f, 3.0f);
        this.Neck.func_78792_a(this.Head);
        this.setRotationAngle(this.Head, 0.0436f, 0.0f, 0.0f);
        this.Head.field_78804_l.add(new ModelBox(this.Head, 0, 13, -3.0f, -4.9019f, -5.8301f, 6, 5, 7, 0.0f, true));
        this.UMouth = new ModelRenderer((ModelBase)this);
        this.UMouth.func_78793_a(0.0f, 0.0f, 0.0f);
        this.Head.func_78792_a(this.UMouth);
        this.UMouth.field_78804_l.add(new ModelBox(this.UMouth, 0, 25, -2.0f, -4.9019f, -10.8301f, 4, 5, 5, 0.0f, true));
        this.Ear1 = new ModelRenderer((ModelBase)this);
        this.Ear1.func_78793_a(1.0f, 11.0f, 3.0f);
        this.Head.func_78792_a(this.Ear1);
        this.setRotationAngle(this.Ear1, 0.1309f, 0.0f, 0.0873f);
        this.Ear1.field_78804_l.add(new ModelBox(this.Ear1, 19, 16, -1.5234f, -18.8473f, -1.4011f, 2, 3, 1, 0.0f, false));
        this.Ear2 = new ModelRenderer((ModelBase)this);
        this.Ear2.func_78793_a(-1.0f, 11.0f, 3.0f);
        this.Head.func_78792_a(this.Ear2);
        this.setRotationAngle(this.Ear2, 0.1309f, 0.0f, -0.0873f);
        this.Ear2.field_78804_l.add(new ModelBox(this.Ear2, 19, 16, -0.4766f, -18.8473f, -1.4011f, 2, 3, 1, 0.0f, true));
        this.Mane = new ModelRenderer((ModelBase)this);
        this.Mane.func_78793_a(0.0f, 0.0f, 0.0f);
        this.Neck.func_78792_a(this.Mane);
        this.Mane.field_78804_l.add(new ModelBox(this.Mane, 56, 36, -1.0f, -16.0f, 4.0f, 2, 16, 2, 0.0f, true));
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
        float limbRange = 1.4f;
        float limbSpeed = 0.6662f;
        this.Leg1A.field_78795_f = Mth.func_76134_b((float)(limbSwing * limbSpeed)) * limbRange * limbSwingAmount;
        this.Leg2A.field_78795_f = Mth.func_76134_b((float)(limbSwing * limbSpeed + (float)Math.PI)) * limbRange * limbSwingAmount;
        this.Neck.field_78795_f = 1.1781f + 0.3f * Mth.func_76126_a((float)(0.05f * ageInTicks));
        this.Leg4A.field_78795_f = -1.3838f + Mth.func_76126_a((float)(limbSwing * 0.6662f + (float)Math.PI)) * 1.4f * limbSwingAmount * 0.5f;
        this.Leg4A.field_78808_h = 0.5f * Mth.func_76126_a((float)(limbSwing * 0.6662f + (float)Math.PI)) * 1.4f * limbSwingAmount * 0.5f;
        this.Leg3A.field_78795_f = this.Leg4A.field_78795_f;
        this.Leg3A.field_78808_h = -this.Leg4A.field_78808_h;
    }
}

