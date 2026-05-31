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
package xol.lostinfinity.mob.model.starforge;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;

public class ModelTerrorFly
extends ModelBase {
    private final ModelRenderer Body;
    private final ModelRenderer AntennaL;
    private final ModelRenderer AntennaR;
    private final ModelRenderer MouthL;
    private final ModelRenderer MouthR;
    private final ModelRenderer WingR;
    private final ModelRenderer WingL;
    private final ModelRenderer WingL2;
    private final ModelRenderer WingR2;

    public ModelTerrorFly() {
        this.field_78090_t = 128;
        this.field_78089_u = 64;
        this.Body = new ModelRenderer((ModelBase)this);
        this.Body.func_78793_a(0.0f, 7.0f, 0.0f);
        this.Body.field_78804_l.add(new ModelBox(this.Body, 0, 0, -5.0f, 5.0f, -12.0f, 10, 10, 4, 0.0f, false));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 0, 36, -7.0f, 4.0f, -8.0f, 14, 8, 20, 0.0f, false));
        this.AntennaL = new ModelRenderer((ModelBase)this);
        this.AntennaL.func_78793_a(3.0f, 6.0f, -10.0f);
        this.Body.func_78792_a(this.AntennaL);
        this.AntennaL.field_78804_l.add(new ModelBox(this.AntennaL, 1, 16, -1.0f, -6.0f, -1.0f, 2, 6, 2, 0.0f, false));
        this.AntennaL.field_78804_l.add(new ModelBox(this.AntennaL, 10, 16, -1.0f, -8.0f, -1.0f, 6, 2, 2, 0.0f, false));
        this.AntennaL.field_78804_l.add(new ModelBox(this.AntennaL, 10, 20, 5.0f, -8.5f, -1.5f, 3, 3, 3, 0.0f, false));
        this.AntennaR = new ModelRenderer((ModelBase)this);
        this.AntennaR.func_78793_a(-3.0f, 6.0f, -10.0f);
        this.Body.func_78792_a(this.AntennaR);
        this.AntennaR.field_78804_l.add(new ModelBox(this.AntennaR, 1, 16, -1.0f, -6.0f, -1.0f, 2, 6, 2, 0.0f, true));
        this.AntennaR.field_78804_l.add(new ModelBox(this.AntennaR, 10, 16, -5.0f, -8.0f, -1.0f, 6, 2, 2, 0.0f, true));
        this.AntennaR.field_78804_l.add(new ModelBox(this.AntennaR, 10, 20, -8.0f, -8.5f, -1.5f, 3, 3, 3, 0.0f, true));
        this.MouthL = new ModelRenderer((ModelBase)this);
        this.MouthL.func_78793_a(7.0f, 12.0f, 2.0f);
        this.Body.func_78792_a(this.MouthL);
        this.MouthL.field_78804_l.add(new ModelBox(this.MouthL, 10, 6, -7.0f, 0.0f, -10.0f, 7, 6, 20, 0.0f, false));
        this.MouthL.field_78804_l.add(new ModelBox(this.MouthL, 45, 23, -8.1f, 4.0f, -9.0f, 8, 1, 1, 0.0f, false));
        this.MouthL.field_78804_l.add(new ModelBox(this.MouthL, 45, 23, -8.1f, 4.0f, -7.0f, 8, 1, 1, 0.0f, false));
        this.MouthL.field_78804_l.add(new ModelBox(this.MouthL, 45, 23, -8.1f, 4.0f, -5.0f, 8, 1, 1, 0.0f, false));
        this.MouthL.field_78804_l.add(new ModelBox(this.MouthL, 45, 23, -8.1f, 4.0f, -3.0f, 8, 1, 1, 0.0f, false));
        this.MouthL.field_78804_l.add(new ModelBox(this.MouthL, 45, 23, -8.1f, 4.0f, -1.0f, 8, 1, 1, 0.0f, false));
        this.MouthL.field_78804_l.add(new ModelBox(this.MouthL, 45, 23, -8.1f, 4.0f, 1.0f, 8, 1, 1, 0.0f, false));
        this.MouthL.field_78804_l.add(new ModelBox(this.MouthL, 45, 23, -8.1f, 4.0f, 3.0f, 8, 1, 1, 0.0f, false));
        this.MouthL.field_78804_l.add(new ModelBox(this.MouthL, 45, 23, -8.1f, 4.0f, 5.0f, 8, 1, 1, 0.0f, false));
        this.MouthL.field_78804_l.add(new ModelBox(this.MouthL, 45, 23, -8.1f, 4.0f, 7.0f, 8, 1, 1, 0.0f, false));
        this.MouthR = new ModelRenderer((ModelBase)this);
        this.MouthR.func_78793_a(-7.0f, 12.0f, 2.0f);
        this.Body.func_78792_a(this.MouthR);
        this.MouthR.field_78804_l.add(new ModelBox(this.MouthR, 10, 6, 0.0f, 0.0f, -10.0f, 7, 6, 20, 0.0f, true));
        this.MouthR.field_78804_l.add(new ModelBox(this.MouthR, 45, 23, 0.1f, 4.0f, -8.0f, 8, 1, 1, 0.0f, true));
        this.MouthR.field_78804_l.add(new ModelBox(this.MouthR, 45, 23, 0.1f, 4.0f, -6.0f, 8, 1, 1, 0.0f, true));
        this.MouthR.field_78804_l.add(new ModelBox(this.MouthR, 45, 23, 0.1f, 4.0f, -4.0f, 8, 1, 1, 0.0f, true));
        this.MouthR.field_78804_l.add(new ModelBox(this.MouthR, 45, 23, 0.1f, 4.0f, -2.0f, 8, 1, 1, 0.0f, true));
        this.MouthR.field_78804_l.add(new ModelBox(this.MouthR, 45, 23, 0.1f, 4.0f, 0.0f, 8, 1, 1, 0.0f, true));
        this.MouthR.field_78804_l.add(new ModelBox(this.MouthR, 45, 23, 0.1f, 4.0f, 2.0f, 8, 1, 1, 0.0f, true));
        this.MouthR.field_78804_l.add(new ModelBox(this.MouthR, 45, 23, 0.1f, 4.0f, 4.0f, 8, 1, 1, 0.0f, true));
        this.MouthR.field_78804_l.add(new ModelBox(this.MouthR, 45, 23, 0.1f, 4.0f, 6.0f, 8, 1, 1, 0.0f, true));
        this.MouthR.field_78804_l.add(new ModelBox(this.MouthR, 45, 23, 0.1f, 4.0f, 8.0f, 8, 1, 1, 0.0f, true));
        this.WingR = new ModelRenderer((ModelBase)this);
        this.WingR.func_78793_a(-5.0f, 13.5f, -2.0f);
        this.setRotationAngle(this.WingR, 0.0f, -0.4363f, 0.0f);
        this.WingR.field_78804_l.add(new ModelBox(this.WingR, 56, 37, -20.0f, -3.5f, -4.0f, 20, 8, 8, 0.0f, true));
        this.WingL = new ModelRenderer((ModelBase)this);
        this.WingL.func_78793_a(5.0f, 13.5f, -2.0f);
        this.setRotationAngle(this.WingL, 0.0f, 0.4363f, 0.0f);
        this.WingL.field_78804_l.add(new ModelBox(this.WingL, 56, 37, 0.0f, -3.5f, -4.0f, 20, 8, 8, 0.0f, false));
        this.WingL2 = new ModelRenderer((ModelBase)this);
        this.WingL2.func_78793_a(5.0f, 13.5f, 6.0f);
        this.setRotationAngle(this.WingL2, 0.0f, -0.4363f, 0.0f);
        this.WingL2.field_78804_l.add(new ModelBox(this.WingL2, 56, 37, 0.0f, -3.5f, -4.0f, 20, 8, 8, 0.0f, false));
        this.WingR2 = new ModelRenderer((ModelBase)this);
        this.WingR2.func_78793_a(-5.0f, 13.5f, 6.0f);
        this.setRotationAngle(this.WingR2, 0.0f, 0.4363f, 0.0f);
        this.WingR2.field_78804_l.add(new ModelBox(this.WingR2, 56, 37, -20.0f, -3.5f, -4.0f, 20, 8, 8, 0.0f, true));
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.Body.func_78785_a(f5);
        this.WingR.func_78785_a(f5);
        this.WingL.func_78785_a(f5);
        this.WingL2.func_78785_a(f5);
        this.WingR2.func_78785_a(f5);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.WingL.field_78808_h = Mth.func_76134_b((float)(ageInTicks * 0.7f)) * 0.5f;
        this.WingL2.field_78808_h = Mth.func_76126_a((float)(ageInTicks * 0.7f)) * 0.5f;
        this.WingR.field_78808_h = -this.WingL.field_78808_h;
        this.WingR2.field_78808_h = -this.WingL2.field_78808_h;
        this.MouthL.field_78808_h = -0.5f + 0.5f * Mth.func_76126_a((float)(ageInTicks * 0.2f));
        this.MouthR.field_78808_h = -this.MouthL.field_78808_h;
        this.AntennaL.field_78808_h = 0.15f + 0.3f * Mth.func_76126_a((float)(0.2f * ageInTicks));
        this.AntennaL.field_78796_g = 0.15f + 0.3f * Mth.func_76134_b((float)(0.15f * ageInTicks));
        this.AntennaR.field_78808_h = -this.AntennaL.field_78808_h;
        this.AntennaR.field_78796_g = -this.AntennaL.field_78796_g;
    }
}

