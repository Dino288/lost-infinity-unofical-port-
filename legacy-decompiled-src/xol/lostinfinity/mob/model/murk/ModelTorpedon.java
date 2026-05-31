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
import xol.lostinfinity.mob.entity.murk.EntityTorpedon;

public class ModelTorpedon
extends ModelBase {
    private final ModelRenderer Body;
    private final ModelRenderer MouthR;
    private final ModelRenderer MouthR2;
    private final ModelRenderer Tail1;
    private final ModelRenderer T1P2;
    private final ModelRenderer T1P3;

    public ModelTorpedon() {
        this.field_78090_t = 128;
        this.field_78089_u = 64;
        this.Body = new ModelRenderer((ModelBase)this);
        this.Body.func_78793_a(0.0f, 17.5f, 12.0f);
        this.Body.field_78804_l.add(new ModelBox(this.Body, 33, 0, -6.0f, -6.0f, -15.0f, 12, 1, 10, -0.05f, false));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 33, 12, -6.0f, 5.0f, -15.0f, 12, 1, 10, -0.05f, false));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 0, 42, -6.0f, -6.0f, -5.0f, 12, 12, 10, 0.0f, false));
        this.MouthR = new ModelRenderer((ModelBase)this);
        this.MouthR.func_78793_a(0.0f, 0.0f, -5.0f);
        this.Body.func_78792_a(this.MouthR);
        this.setRotationAngle(this.MouthR, 0.0f, -0.8727f, 0.0f);
        this.MouthR.field_78804_l.add(new ModelBox(this.MouthR, 0, 0, 0.0f, -5.5f, -10.0f, 6, 11, 10, 0.0f, false));
        this.MouthR.field_78804_l.add(new ModelBox(this.MouthR, 0, 22, 0.0f, -4.5f, -12.0f, 5, 9, 2, 0.0f, false));
        this.MouthR.field_78804_l.add(new ModelBox(this.MouthR, 15, 26, 0.0f, -3.5f, -14.0f, 4, 7, 2, 0.0f, false));
        this.MouthR.field_78804_l.add(new ModelBox(this.MouthR, 28, 28, 0.0f, -2.5f, -16.0f, 3, 5, 2, 0.0f, false));
        this.MouthR2 = new ModelRenderer((ModelBase)this);
        this.MouthR2.func_78793_a(0.0f, 0.0f, -5.0f);
        this.Body.func_78792_a(this.MouthR2);
        this.setRotationAngle(this.MouthR2, 0.0f, 0.8727f, 0.0f);
        this.MouthR2.field_78804_l.add(new ModelBox(this.MouthR2, 0, 0, -6.0f, -5.5f, -10.0f, 6, 11, 10, 0.0f, true));
        this.MouthR2.field_78804_l.add(new ModelBox(this.MouthR2, 0, 22, -5.0f, -4.5f, -12.0f, 5, 9, 2, 0.0f, true));
        this.MouthR2.field_78804_l.add(new ModelBox(this.MouthR2, 15, 26, -4.0f, -3.5f, -14.0f, 4, 7, 2, 0.0f, true));
        this.MouthR2.field_78804_l.add(new ModelBox(this.MouthR2, 28, 28, -3.0f, -2.5f, -16.0f, 3, 5, 2, 0.0f, true));
        this.Tail1 = new ModelRenderer((ModelBase)this);
        this.Tail1.func_78793_a(0.0f, 17.0f, 20.0f);
        this.Tail1.field_78804_l.add(new ModelBox(this.Tail1, 44, 40, -5.0f, -4.5f, -3.0f, 10, 10, 14, 0.0f, false));
        this.Tail1.field_78804_l.add(new ModelBox(this.Tail1, 83, 2, 0.0f, -14.5f, -3.0f, 1, 10, 14, 0.0f, false));
        this.Tail1.field_78804_l.add(new ModelBox(this.Tail1, 65, 13, 0.0f, 5.5f, -3.0f, 1, 10, 14, 0.0f, false));
        this.T1P2 = new ModelRenderer((ModelBase)this);
        this.T1P2.func_78793_a(0.0f, 0.0f, 12.0f);
        this.Tail1.func_78792_a(this.T1P2);
        this.T1P2.field_78804_l.add(new ModelBox(this.T1P2, 88, 27, -4.0f, -3.5f, -3.0f, 8, 8, 12, 0.0f, false));
        this.T1P2.field_78804_l.add(new ModelBox(this.T1P2, 31, 26, -12.0f, 0.5f, -3.0f, 8, 1, 12, 0.0f, false));
        this.T1P2.field_78804_l.add(new ModelBox(this.T1P2, 31, 26, 4.0f, 0.5f, -3.0f, 8, 1, 12, 0.0f, true));
        this.T1P3 = new ModelRenderer((ModelBase)this);
        this.T1P3.func_78793_a(0.0f, 0.0f, 7.0f);
        this.T1P2.func_78792_a(this.T1P3);
        this.T1P3.field_78804_l.add(new ModelBox(this.T1P3, 96, 48, -3.0f, -2.5f, 0.0f, 6, 6, 10, 0.0f, false));
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.Body.func_78785_a(f5);
        this.Tail1.func_78785_a(f5);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.Tail1.field_78808_h = ageInTicks * 0.05f;
        this.Tail1.field_78796_g = 0.5f * Mth.func_76126_a((float)(ageInTicks * 0.1f));
        this.T1P2.field_78796_g = 0.4f * Mth.func_76126_a((float)(ageInTicks * 0.1f));
        this.T1P2.field_78796_g = 0.3f * Mth.func_76126_a((float)(ageInTicks * 0.1f));
        this.T1P3.field_78796_g = 0.2f * Mth.func_76126_a((float)(ageInTicks * 0.1f));
        float mouthSpeed = 0.075f;
        EntityTorpedon torp = (EntityTorpedon)entityIn;
        if (torp.getAngry()) {
            mouthSpeed = 0.75f;
        }
        this.Body.field_78808_h = ageInTicks * -mouthSpeed;
        this.MouthR.field_78796_g = -0.3f + 0.3f * Mth.func_76126_a((float)(ageInTicks * 0.1f));
        this.MouthR2.field_78796_g = -this.MouthR.field_78796_g;
    }
}

