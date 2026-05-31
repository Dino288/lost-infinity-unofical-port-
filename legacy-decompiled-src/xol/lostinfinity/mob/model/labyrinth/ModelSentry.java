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

public class ModelSentry
extends ModelBase {
    private final ModelRenderer Leg4;
    private final ModelRenderer Body_r1;
    private final ModelRenderer Leg2;
    private final ModelRenderer Body_r2;
    private final ModelRenderer Leg3;
    private final ModelRenderer Body_r3;
    private final ModelRenderer Leg1;
    private final ModelRenderer Body_r4;
    private final ModelRenderer Body;
    private final ModelRenderer Tower;

    public ModelSentry() {
        this.field_78090_t = 64;
        this.field_78089_u = 64;
        this.Leg4 = new ModelRenderer((ModelBase)this);
        this.Leg4.func_78793_a(-5.5f, 18.5f, -1.0f);
        this.setRotationAngle(this.Leg4, 0.0f, -0.4363f, 0.0f);
        this.Body_r1 = new ModelRenderer((ModelBase)this);
        this.Body_r1.func_78793_a(-3.0f, -1.0f, 0.0f);
        this.Leg4.func_78792_a(this.Body_r1);
        this.setRotationAngle(this.Body_r1, 0.0f, 0.0f, 0.2618f);
        this.Body_r1.field_78804_l.add(new ModelBox(this.Body_r1, 10, 5, -8.5f, 0.5f, -1.0f, 2, 10, 2, 0.3f, true));
        this.Body_r1.field_78804_l.add(new ModelBox(this.Body_r1, 0, 7, -8.5f, 6.5f, -1.0f, 2, 4, 2, 0.0f, true));
        this.Body_r1.field_78804_l.add(new ModelBox(this.Body_r1, 0, 0, -8.5f, 1.5f, -1.0f, 2, 4, 2, 0.0f, true));
        this.Body_r1.field_78804_l.add(new ModelBox(this.Body_r1, 0, 24, -9.0f, -1.5f, -1.5f, 13, 2, 3, 0.0f, true));
        this.Leg2 = new ModelRenderer((ModelBase)this);
        this.Leg2.func_78793_a(5.5f, 18.5f, -1.0f);
        this.setRotationAngle(this.Leg2, 0.0f, 0.4363f, 0.0f);
        this.Body_r2 = new ModelRenderer((ModelBase)this);
        this.Body_r2.func_78793_a(3.0f, -1.0f, 0.0f);
        this.Leg2.func_78792_a(this.Body_r2);
        this.setRotationAngle(this.Body_r2, 0.0f, 0.0f, -0.2618f);
        this.Body_r2.field_78804_l.add(new ModelBox(this.Body_r2, 10, 5, 6.5f, 0.5f, -1.0f, 2, 10, 2, 0.3f, false));
        this.Body_r2.field_78804_l.add(new ModelBox(this.Body_r2, 0, 7, 6.5f, 6.5f, -1.0f, 2, 4, 2, 0.0f, false));
        this.Body_r2.field_78804_l.add(new ModelBox(this.Body_r2, 0, 0, 6.5f, 1.5f, -1.0f, 2, 4, 2, 0.0f, false));
        this.Body_r2.field_78804_l.add(new ModelBox(this.Body_r2, 0, 24, -4.0f, -1.5f, -1.5f, 13, 2, 3, 0.0f, false));
        this.Leg3 = new ModelRenderer((ModelBase)this);
        this.Leg3.func_78793_a(-5.5f, 18.5f, 10.0f);
        this.setRotationAngle(this.Leg3, 0.0f, 0.3491f, 0.0f);
        this.Body_r3 = new ModelRenderer((ModelBase)this);
        this.Body_r3.func_78793_a(-3.0f, -1.0f, 0.0f);
        this.Leg3.func_78792_a(this.Body_r3);
        this.setRotationAngle(this.Body_r3, 0.0f, 0.0f, 0.2618f);
        this.Body_r3.field_78804_l.add(new ModelBox(this.Body_r3, 10, 5, -8.5f, 0.5f, -1.0f, 2, 10, 2, 0.3f, true));
        this.Body_r3.field_78804_l.add(new ModelBox(this.Body_r3, 0, 7, -8.5f, 6.5f, -1.0f, 2, 4, 2, 0.0f, true));
        this.Body_r3.field_78804_l.add(new ModelBox(this.Body_r3, 0, 0, -8.5f, 1.5f, -1.0f, 2, 4, 2, 0.0f, true));
        this.Body_r3.field_78804_l.add(new ModelBox(this.Body_r3, 0, 24, -9.0f, -1.5f, -1.5f, 13, 2, 3, 0.0f, true));
        this.Leg1 = new ModelRenderer((ModelBase)this);
        this.Leg1.func_78793_a(5.5f, 18.5f, 10.0f);
        this.setRotationAngle(this.Leg1, 0.0f, -0.3491f, 0.0f);
        this.Body_r4 = new ModelRenderer((ModelBase)this);
        this.Body_r4.func_78793_a(3.0f, -1.0f, 0.0f);
        this.Leg1.func_78792_a(this.Body_r4);
        this.setRotationAngle(this.Body_r4, 0.0f, 0.0f, -0.2618f);
        this.Body_r4.field_78804_l.add(new ModelBox(this.Body_r4, 10, 5, 6.5f, 0.5f, -1.0f, 2, 10, 2, 0.3f, false));
        this.Body_r4.field_78804_l.add(new ModelBox(this.Body_r4, 0, 7, 6.5f, 6.5f, -1.0f, 2, 4, 2, 0.0f, false));
        this.Body_r4.field_78804_l.add(new ModelBox(this.Body_r4, 0, 0, 6.5f, 1.5f, -1.0f, 2, 4, 2, 0.0f, false));
        this.Body_r4.field_78804_l.add(new ModelBox(this.Body_r4, 0, 24, -4.0f, -1.5f, -1.5f, 13, 2, 3, 0.0f, false));
        this.Body = new ModelRenderer((ModelBase)this);
        this.Body.func_78793_a(0.0f, 17.0f, 4.0f);
        this.Body.field_78804_l.add(new ModelBox(this.Body, 2, 0, -6.0f, -2.0f, -9.0f, 12, 5, 18, 0.0f, false));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 0, 29, -5.0f, -4.0f, -5.0f, 10, 2, 10, 0.0f, false));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 2, 0, -6.0f, -2.0f, -9.0f, 12, 5, 18, 0.0f, false));
        this.Tower = new ModelRenderer((ModelBase)this);
        this.Tower.func_78793_a(0.0f, 12.0f, 4.0f);
        this.Tower.field_78804_l.add(new ModelBox(this.Tower, 0, 56, -6.0f, -1.0f, -3.0f, 12, 2, 6, 0.0f, false));
        this.Tower.field_78804_l.add(new ModelBox(this.Tower, 38, 26, -6.0f, -12.0f, 0.0f, 12, 11, 1, 0.0f, false));
        this.Tower.field_78804_l.add(new ModelBox(this.Tower, 0, 47, -6.0f, -14.0f, -3.0f, 12, 2, 6, 0.0f, false));
        this.Tower.field_78804_l.add(new ModelBox(this.Tower, 38, 43, 6.0f, -14.0f, -3.0f, 2, 15, 6, 0.0f, false));
        this.Tower.field_78804_l.add(new ModelBox(this.Tower, 38, 43, -8.0f, -14.0f, -3.0f, 2, 15, 6, 0.0f, true));
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.Leg4.func_78785_a(f5);
        this.Leg2.func_78785_a(f5);
        this.Leg3.func_78785_a(f5);
        this.Leg1.func_78785_a(f5);
        this.Body.func_78785_a(f5);
        this.Tower.func_78785_a(f5);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.Leg1.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f + (float)Math.PI)) * 1.4f * limbSwingAmount * 0.5f;
        this.Leg1.field_78808_h = 0.5f * Mth.func_76134_b((float)(limbSwing * 0.6662f + (float)Math.PI)) * 1.4f * limbSwingAmount * 0.5f;
        this.Leg2.field_78795_f = Mth.func_76126_a((float)(limbSwing * 0.6662f + (float)Math.PI)) * 1.4f * limbSwingAmount * 0.5f;
        this.Leg2.field_78808_h = 0.5f * Mth.func_76126_a((float)(limbSwing * 0.6662f + (float)Math.PI)) * 1.4f * limbSwingAmount * 0.5f;
        this.Leg3.field_78795_f = this.Leg1.field_78795_f;
        this.Leg3.field_78808_h = -this.Leg1.field_78808_h;
        this.Leg4.field_78795_f = this.Leg2.field_78795_f;
        this.Leg4.field_78808_h = -this.Leg2.field_78808_h;
        this.Tower.field_78796_g = ageInTicks * 0.1f;
    }
}

