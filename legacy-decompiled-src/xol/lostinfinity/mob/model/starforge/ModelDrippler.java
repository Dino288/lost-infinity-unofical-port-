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

public class ModelDrippler
extends ModelBase {
    private final ModelRenderer Sac;
    private final ModelRenderer Body;
    private final ModelRenderer eyeL;
    private final ModelRenderer eyeR;
    private final ModelRenderer WingR;
    private final ModelRenderer cube_r1;
    private final ModelRenderer WingL;
    private final ModelRenderer cube_r2;

    public ModelDrippler() {
        this.field_78090_t = 128;
        this.field_78089_u = 64;
        this.Sac = new ModelRenderer((ModelBase)this);
        this.Sac.func_78793_a(0.0f, 17.0f, 5.0f);
        this.Sac.field_78804_l.add(new ModelBox(this.Sac, 0, 49, -4.0f, -6.0f, -2.0f, 8, 3, 9, 0.0f, false));
        this.Body = new ModelRenderer((ModelBase)this);
        this.Body.func_78793_a(0.0f, 7.0f, 0.0f);
        this.Body.field_78804_l.add(new ModelBox(this.Body, 0, 14, -6.0f, 7.0f, -3.0f, 12, 6, 16, 0.0f, false));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 0, 37, -8.0f, 3.0f, -2.0f, 16, 6, 5, 0.0f, false));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 33, 0, -12.5f, 5.5f, -4.0f, 7, 7, 5, 0.0f, true));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 38, 39, -8.5f, 8.5f, 1.0f, 3, 3, 10, 0.0f, true));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 38, 39, 5.5f, 8.5f, 1.0f, 3, 3, 10, 0.0f, false));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 33, 0, 5.5f, 5.5f, -4.0f, 7, 7, 5, 0.0f, false));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 0, 0, -5.0f, 2.0f, -8.0f, 10, 8, 6, 0.0f, false));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 41, 15, 4.0f, 2.0f, -2.0f, 1, 8, 6, 0.0f, false));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 41, 15, -5.0f, 2.0f, -2.0f, 1, 8, 6, 0.0f, true));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 37, 54, -3.0f, 5.0f, 4.0f, 6, 2, 7, 0.0f, false));
        this.eyeL = new ModelRenderer((ModelBase)this);
        this.eyeL.func_78793_a(9.0f, 16.0f, -4.0f);
        this.eyeL.field_78804_l.add(new ModelBox(this.eyeL, 0, 15, -3.0f, -3.0f, -1.0f, 6, 6, 2, 0.0f, false));
        this.eyeR = new ModelRenderer((ModelBase)this);
        this.eyeR.func_78793_a(-9.0f, 16.0f, -4.0f);
        this.eyeR.field_78804_l.add(new ModelBox(this.eyeR, 0, 15, -3.0f, -3.0f, -1.0f, 6, 6, 2, 0.0f, true));
        this.WingR = new ModelRenderer((ModelBase)this);
        this.WingR.func_78793_a(-5.5f, 15.0f, 7.0f);
        this.WingR.field_78804_l.add(new ModelBox(this.WingR, 53, 6, -18.5f, 0.0f, -5.0f, 19, 1, 10, 0.0f, true));
        this.WingR.field_78804_l.add(new ModelBox(this.WingR, 58, 6, -18.5f, 1.0f, -5.0f, 1, 7, 1, 0.0f, true));
        this.WingR.field_78804_l.add(new ModelBox(this.WingR, 58, 6, -18.5f, 1.0f, 4.0f, 1, 7, 1, 0.0f, true));
        this.WingR.field_78804_l.add(new ModelBox(this.WingR, 58, 6, -18.5f, 1.0f, 2.0f, 1, 7, 1, 0.0f, true));
        this.WingR.field_78804_l.add(new ModelBox(this.WingR, 58, 6, -18.5f, 1.0f, -3.0f, 1, 7, 1, 0.0f, true));
        this.WingR.field_78804_l.add(new ModelBox(this.WingR, 64, 2, -17.5f, -0.5f, -4.0f, 18, 1, 1, 0.0f, true));
        this.WingR.field_78804_l.add(new ModelBox(this.WingR, 64, 2, -17.5f, -0.5f, 1.0f, 18, 1, 1, 0.0f, true));
        this.WingR.field_78804_l.add(new ModelBox(this.WingR, 64, 2, -17.5f, -0.5f, -2.0f, 18, 1, 1, 0.0f, true));
        this.WingR.field_78804_l.add(new ModelBox(this.WingR, 64, 2, -17.5f, -0.5f, 3.0f, 18, 1, 1, 0.0f, true));
        this.cube_r1 = new ModelRenderer((ModelBase)this);
        this.cube_r1.func_78793_a(-18.0f, 1.5f, 0.0f);
        this.WingR.func_78792_a(this.cube_r1);
        this.setRotationAngle(this.cube_r1, 0.0f, 0.0f, -1.1345f);
        this.cube_r1.field_78804_l.add(new ModelBox(this.cube_r1, 66, 19, 1.5f, 15.5f, -1.0f, 5, 1, 2, 0.0f, true));
        this.cube_r1.field_78804_l.add(new ModelBox(this.cube_r1, 59, 19, 0.5f, 0.5f, -1.0f, 1, 16, 2, 0.0f, true));
        this.WingL = new ModelRenderer((ModelBase)this);
        this.WingL.func_78793_a(5.5f, 15.0f, 7.0f);
        this.WingL.field_78804_l.add(new ModelBox(this.WingL, 53, 6, -0.5f, 0.0f, -5.0f, 19, 1, 10, 0.0f, false));
        this.WingL.field_78804_l.add(new ModelBox(this.WingL, 58, 6, 17.5f, 1.0f, -5.0f, 1, 7, 1, 0.0f, false));
        this.WingL.field_78804_l.add(new ModelBox(this.WingL, 58, 6, 17.5f, 1.0f, 4.0f, 1, 7, 1, 0.0f, false));
        this.WingL.field_78804_l.add(new ModelBox(this.WingL, 58, 6, 17.5f, 1.0f, 2.0f, 1, 7, 1, 0.0f, false));
        this.WingL.field_78804_l.add(new ModelBox(this.WingL, 58, 6, 17.5f, 1.0f, -3.0f, 1, 7, 1, 0.0f, false));
        this.WingL.field_78804_l.add(new ModelBox(this.WingL, 64, 2, -0.5f, -0.5f, -4.0f, 18, 1, 1, 0.0f, false));
        this.WingL.field_78804_l.add(new ModelBox(this.WingL, 64, 2, -0.5f, -0.5f, 1.0f, 18, 1, 1, 0.0f, false));
        this.WingL.field_78804_l.add(new ModelBox(this.WingL, 64, 2, -0.5f, -0.5f, -2.0f, 18, 1, 1, 0.0f, false));
        this.WingL.field_78804_l.add(new ModelBox(this.WingL, 64, 2, -0.5f, -0.5f, 3.0f, 18, 1, 1, 0.0f, false));
        this.cube_r2 = new ModelRenderer((ModelBase)this);
        this.cube_r2.func_78793_a(18.0f, 1.5f, 0.0f);
        this.WingL.func_78792_a(this.cube_r2);
        this.setRotationAngle(this.cube_r2, 0.0f, 0.0f, 1.1345f);
        this.cube_r2.field_78804_l.add(new ModelBox(this.cube_r2, 66, 19, -6.5f, 15.5f, -1.0f, 5, 1, 2, 0.0f, false));
        this.cube_r2.field_78804_l.add(new ModelBox(this.cube_r2, 59, 19, -1.5f, 0.5f, -1.0f, 1, 16, 2, 0.0f, false));
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.Sac.func_78785_a(f5);
        this.Body.func_78785_a(f5);
        this.eyeL.func_78785_a(f5);
        this.eyeR.func_78785_a(f5);
        this.WingR.func_78785_a(f5);
        this.WingL.func_78785_a(f5);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.WingL.field_78808_h = -0.3f + 0.6f * Mth.func_76126_a((float)(ageInTicks * 0.3f));
        this.WingR.field_78808_h = -this.WingL.field_78808_h;
        this.eyeL.field_78796_g = 0.2f * Mth.func_76126_a((float)(ageInTicks * 0.1f));
        this.eyeL.field_78795_f = 0.2f * Mth.func_76134_b((float)(ageInTicks * 0.075f));
        this.eyeR.field_78796_g = this.eyeL.field_78796_g;
        this.eyeR.field_78795_f = this.eyeL.field_78795_f;
    }
}

