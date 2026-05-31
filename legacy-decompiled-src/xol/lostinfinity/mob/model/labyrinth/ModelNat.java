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
package xol.lostinfinity.mob.model.labyrinth;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;

public class ModelNat
extends ModelBase {
    private final ModelRenderer Body;
    private final ModelRenderer WingL;
    private final ModelRenderer WingL2;
    private final ModelRenderer WingR;
    private final ModelRenderer WingR2;
    private final ModelRenderer Leg1;
    private final ModelRenderer Leg2;

    public ModelNat() {
        this.field_78090_t = 64;
        this.field_78089_u = 64;
        this.Body = new ModelRenderer((ModelBase)this);
        this.Body.func_78793_a(0.0f, 1.0f, 0.0f);
        this.Body.field_78804_l.add(new ModelBox(this.Body, 0, 36, -7.0f, -15.0f, -7.0f, 14, 14, 14, 0.0f, false));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 38, 10, 7.0f, -14.0f, -6.0f, 1, 12, 12, 0.0f, false));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 38, 10, -8.0f, -14.0f, -6.0f, 1, 12, 12, 0.0f, true));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 1, 23, -6.0f, -16.0f, -6.0f, 12, 1, 12, 0.0f, false));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 9, 10, -6.0f, -14.0f, -8.0f, 12, 12, 1, 0.0f, false));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 9, 10, -6.0f, -14.0f, 7.0f, 12, 12, 1, 0.0f, false));
        this.WingL = new ModelRenderer((ModelBase)this);
        this.WingL.func_78793_a(6.0f, -12.5f, 4.0f);
        this.Body.func_78792_a(this.WingL);
        this.setRotationAngle(this.WingL, 0.0f, -0.7854f, 0.0f);
        this.WingL.field_78804_l.add(new ModelBox(this.WingL, 8, 0, -1.0f, -0.5f, -4.0f, 20, 1, 8, 0.0f, false));
        this.WingL2 = new ModelRenderer((ModelBase)this);
        this.WingL2.func_78793_a(6.0f, -3.5f, 4.0f);
        this.Body.func_78792_a(this.WingL2);
        this.setRotationAngle(this.WingL2, 0.0f, -0.7854f, 0.0f);
        this.WingL2.field_78804_l.add(new ModelBox(this.WingL2, 8, 0, -1.0f, -0.5f, -4.0f, 20, 1, 8, 0.0f, false));
        this.WingR = new ModelRenderer((ModelBase)this);
        this.WingR.func_78793_a(-6.0f, -12.5f, 4.0f);
        this.Body.func_78792_a(this.WingR);
        this.setRotationAngle(this.WingR, 0.0f, 0.7854f, 0.0f);
        this.WingR.field_78804_l.add(new ModelBox(this.WingR, 8, 0, -19.0f, -0.5f, -4.0f, 20, 1, 8, 0.0f, true));
        this.WingR2 = new ModelRenderer((ModelBase)this);
        this.WingR2.func_78793_a(-6.0f, -3.5f, 4.0f);
        this.Body.func_78792_a(this.WingR2);
        this.setRotationAngle(this.WingR2, 0.0f, 0.7854f, 0.0f);
        this.WingR2.field_78804_l.add(new ModelBox(this.WingR2, 8, 0, -19.0f, -0.5f, -4.0f, 20, 1, 8, 0.0f, true));
        this.Leg1 = new ModelRenderer((ModelBase)this);
        this.Leg1.func_78793_a(5.0f, -2.0f, 0.0f);
        this.Body.func_78792_a(this.Leg1);
        this.Leg1.field_78804_l.add(new ModelBox(this.Leg1, 0, 8, -1.0f, 0.0f, -1.0f, 2, 24, 2, 0.0f, false));
        this.Leg2 = new ModelRenderer((ModelBase)this);
        this.Leg2.func_78793_a(-5.0f, -2.0f, 0.0f);
        this.Body.func_78792_a(this.Leg2);
        this.Leg2.field_78804_l.add(new ModelBox(this.Leg2, 0, 8, -1.0f, 0.0f, -1.0f, 2, 24, 2, 0.0f, true));
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
        this.Body.field_78808_h = 0.3f * Mth.func_76126_a((float)(ageInTicks * 0.05f));
        this.Leg2.field_78795_f = this.Leg1.field_78795_f = 0.45f + 0.3f * Mth.func_76126_a((float)(ageInTicks * 0.1f));
        this.WingL.field_78808_h = this.WingL.field_78795_f = 0.5f * Mth.func_76126_a((float)(ageInTicks * 0.4f));
        this.WingL2.field_78795_f = this.WingL.field_78795_f;
        this.WingL2.field_78808_h = this.WingL.field_78795_f;
        this.WingR.field_78795_f = this.WingL.field_78795_f;
        this.WingR.field_78808_h = -this.WingL.field_78795_f;
        this.WingR2.field_78795_f = this.WingL.field_78795_f;
        this.WingR2.field_78808_h = -this.WingL.field_78795_f;
    }
}

