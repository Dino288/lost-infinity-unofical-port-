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

public class ModelSnapper
extends ModelBase {
    private final ModelRenderer Body;
    private final ModelRenderer Mouth1;
    private final ModelRenderer Mouth2;
    private final ModelRenderer Mouth3;
    private final ModelRenderer Mouth4;
    private final ModelRenderer Leg2;
    private final ModelRenderer Body_r1;
    private final ModelRenderer Body_r2;
    private final ModelRenderer Leg1;
    private final ModelRenderer Body_r3;
    private final ModelRenderer Body_r4;
    private final ModelRenderer Leg3;
    private final ModelRenderer Body_r5;
    private final ModelRenderer Body_r6;
    private final ModelRenderer Leg4;
    private final ModelRenderer Body_r7;
    private final ModelRenderer Body_r8;

    public ModelSnapper() {
        this.field_78090_t = 64;
        this.field_78089_u = 64;
        this.Body = new ModelRenderer((ModelBase)this);
        this.Body.func_78793_a(0.0f, 17.5f, 0.0f);
        this.Body.field_78804_l.add(new ModelBox(this.Body, 0, 0, -8.0f, -2.5f, -8.0f, 16, 5, 16, 0.0f, false));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 0, 22, -3.0f, -5.5f, -3.0f, 6, 3, 6, 0.2f, false));
        this.Mouth1 = new ModelRenderer((ModelBase)this);
        this.Mouth1.func_78793_a(0.0f, -5.5f, -3.0f);
        this.Body.func_78792_a(this.Mouth1);
        this.Mouth1.field_78804_l.add(new ModelBox(this.Mouth1, 25, 22, -3.0f, -10.4645f, -0.5355f, 6, 11, 1, 0.0f, false));
        this.Mouth1.field_78804_l.add(new ModelBox(this.Mouth1, 0, 8, 1.0f, -9.4645f, 0.4645f, 1, 1, 4, 0.0f, false));
        this.Mouth1.field_78804_l.add(new ModelBox(this.Mouth1, 0, 8, -2.0f, -9.4645f, 0.4645f, 1, 1, 4, 0.0f, false));
        this.Mouth2 = new ModelRenderer((ModelBase)this);
        this.Mouth2.func_78793_a(3.0f, -5.5f, 0.0f);
        this.Body.func_78792_a(this.Mouth2);
        this.setRotationAngle(this.Mouth2, 0.0f, -1.5708f, 0.0f);
        this.Mouth2.field_78804_l.add(new ModelBox(this.Mouth2, 25, 22, -3.0f, -10.4645f, -0.5355f, 6, 11, 1, 0.0f, false));
        this.Mouth2.field_78804_l.add(new ModelBox(this.Mouth2, 0, 8, 1.0f, -9.4645f, 0.4645f, 1, 1, 4, 0.0f, false));
        this.Mouth2.field_78804_l.add(new ModelBox(this.Mouth2, 0, 8, -2.0f, -9.4645f, 0.4645f, 1, 1, 4, 0.0f, false));
        this.Mouth3 = new ModelRenderer((ModelBase)this);
        this.Mouth3.func_78793_a(0.0f, -5.5f, 3.0f);
        this.Body.func_78792_a(this.Mouth3);
        this.setRotationAngle(this.Mouth3, 0.0f, 3.1416f, 0.0f);
        this.Mouth3.field_78804_l.add(new ModelBox(this.Mouth3, 25, 22, -3.0f, -10.4645f, -0.5355f, 6, 11, 1, 0.0f, false));
        this.Mouth3.field_78804_l.add(new ModelBox(this.Mouth3, 0, 8, 1.0f, -9.4645f, 0.4645f, 1, 1, 4, 0.0f, false));
        this.Mouth3.field_78804_l.add(new ModelBox(this.Mouth3, 0, 8, -2.0f, -9.4645f, 0.4645f, 1, 1, 4, 0.0f, false));
        this.Mouth4 = new ModelRenderer((ModelBase)this);
        this.Mouth4.func_78793_a(-3.0f, -5.5f, 0.0f);
        this.Body.func_78792_a(this.Mouth4);
        this.setRotationAngle(this.Mouth4, 0.0f, 1.5708f, 0.0f);
        this.Mouth4.field_78804_l.add(new ModelBox(this.Mouth4, 25, 22, -3.0f, -10.4645f, -0.5355f, 6, 11, 1, 0.0f, false));
        this.Mouth4.field_78804_l.add(new ModelBox(this.Mouth4, 0, 8, 1.0f, -9.4645f, 0.4645f, 1, 1, 4, 0.0f, false));
        this.Mouth4.field_78804_l.add(new ModelBox(this.Mouth4, 0, 8, -2.0f, -9.4645f, 0.4645f, 1, 1, 4, 0.0f, false));
        this.Leg2 = new ModelRenderer((ModelBase)this);
        this.Leg2.func_78793_a(5.5f, 18.5f, -5.0f);
        this.setRotationAngle(this.Leg2, 0.0f, 0.4363f, 0.0f);
        this.Body_r1 = new ModelRenderer((ModelBase)this);
        this.Body_r1.func_78793_a(3.0f, -1.0f, 0.0f);
        this.Leg2.func_78792_a(this.Body_r1);
        this.setRotationAngle(this.Body_r1, 0.0f, 0.0f, 0.4363f);
        this.Body_r1.field_78804_l.add(new ModelBox(this.Body_r1, 53, 3, 5.5f, -4.5f, -1.0f, 2, 10, 2, 0.0f, false));
        this.Body_r2 = new ModelRenderer((ModelBase)this);
        this.Body_r2.func_78793_a(3.0f, -1.0f, 0.0f);
        this.Leg2.func_78792_a(this.Body_r2);
        this.setRotationAngle(this.Body_r2, 0.0f, 0.0f, -0.2618f);
        this.Body_r2.field_78804_l.add(new ModelBox(this.Body_r2, 40, 22, -4.0f, -1.5f, -1.5f, 9, 2, 3, 0.0f, false));
        this.Body_r2.field_78804_l.add(new ModelBox(this.Body_r2, 0, 1, 5.0f, -1.5f, -1.5f, 4, 3, 3, 0.0f, false));
        this.Leg1 = new ModelRenderer((ModelBase)this);
        this.Leg1.func_78793_a(5.5f, 18.5f, 5.0f);
        this.setRotationAngle(this.Leg1, 0.0f, -0.3491f, 0.0f);
        this.Body_r3 = new ModelRenderer((ModelBase)this);
        this.Body_r3.func_78793_a(3.0f, -1.0f, 0.0f);
        this.Leg1.func_78792_a(this.Body_r3);
        this.setRotationAngle(this.Body_r3, 0.0f, 0.0f, 0.4363f);
        this.Body_r3.field_78804_l.add(new ModelBox(this.Body_r3, 53, 3, 5.5f, -4.5f, -1.0f, 2, 10, 2, 0.0f, false));
        this.Body_r4 = new ModelRenderer((ModelBase)this);
        this.Body_r4.func_78793_a(3.0f, -1.0f, 0.0f);
        this.Leg1.func_78792_a(this.Body_r4);
        this.setRotationAngle(this.Body_r4, 0.0f, 0.0f, -0.2618f);
        this.Body_r4.field_78804_l.add(new ModelBox(this.Body_r4, 40, 22, -4.0f, -1.5f, -1.5f, 9, 2, 3, 0.0f, false));
        this.Body_r4.field_78804_l.add(new ModelBox(this.Body_r4, 0, 1, 5.0f, -1.5f, -1.5f, 4, 3, 3, 0.0f, false));
        this.Leg3 = new ModelRenderer((ModelBase)this);
        this.Leg3.func_78793_a(-5.5f, 18.5f, 5.0f);
        this.setRotationAngle(this.Leg3, 0.0f, 0.3491f, 0.0f);
        this.Body_r5 = new ModelRenderer((ModelBase)this);
        this.Body_r5.func_78793_a(-3.0f, -1.0f, 0.0f);
        this.Leg3.func_78792_a(this.Body_r5);
        this.setRotationAngle(this.Body_r5, 0.0f, 0.0f, -0.4363f);
        this.Body_r5.field_78804_l.add(new ModelBox(this.Body_r5, 53, 3, -7.5f, -4.5f, -1.0f, 2, 10, 2, 0.0f, true));
        this.Body_r6 = new ModelRenderer((ModelBase)this);
        this.Body_r6.func_78793_a(-3.0f, -1.0f, 0.0f);
        this.Leg3.func_78792_a(this.Body_r6);
        this.setRotationAngle(this.Body_r6, 0.0f, 0.0f, 0.2618f);
        this.Body_r6.field_78804_l.add(new ModelBox(this.Body_r6, 40, 22, -5.0f, -1.5f, -1.5f, 9, 2, 3, 0.0f, true));
        this.Body_r6.field_78804_l.add(new ModelBox(this.Body_r6, 0, 1, -9.0f, -1.5f, -1.5f, 4, 3, 3, 0.0f, true));
        this.Leg4 = new ModelRenderer((ModelBase)this);
        this.Leg4.func_78793_a(-5.5f, 18.5f, -5.0f);
        this.setRotationAngle(this.Leg4, 0.0f, -0.4363f, 0.0f);
        this.Body_r7 = new ModelRenderer((ModelBase)this);
        this.Body_r7.func_78793_a(-3.0f, -1.0f, 0.0f);
        this.Leg4.func_78792_a(this.Body_r7);
        this.setRotationAngle(this.Body_r7, 0.0f, 0.0f, -0.4363f);
        this.Body_r7.field_78804_l.add(new ModelBox(this.Body_r7, 53, 3, -7.5f, -4.5f, -1.0f, 2, 10, 2, 0.0f, true));
        this.Body_r8 = new ModelRenderer((ModelBase)this);
        this.Body_r8.func_78793_a(-3.0f, -1.0f, 0.0f);
        this.Leg4.func_78792_a(this.Body_r8);
        this.setRotationAngle(this.Body_r8, 0.0f, 0.0f, 0.2618f);
        this.Body_r8.field_78804_l.add(new ModelBox(this.Body_r8, 40, 22, -5.0f, -1.5f, -1.5f, 9, 2, 3, 0.0f, true));
        this.Body_r8.field_78804_l.add(new ModelBox(this.Body_r8, 0, 1, -9.0f, -1.5f, -1.5f, 4, 3, 3, 0.0f, true));
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.Body.func_78785_a(f5);
        this.Leg2.func_78785_a(f5);
        this.Leg1.func_78785_a(f5);
        this.Leg3.func_78785_a(f5);
        this.Leg4.func_78785_a(f5);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.Leg1.field_78795_f = Mth.func_76134_b((float)(limbSwing * 1.5f + (float)Math.PI)) * limbSwingAmount * 0.7f;
        this.Leg1.field_78808_h = 0.8f * Mth.func_76134_b((float)(limbSwing * 0.9f + (float)Math.PI)) * limbSwingAmount * 0.7f;
        this.Leg2.field_78795_f = Mth.func_76126_a((float)(limbSwing * 1.5f + (float)Math.PI)) * limbSwingAmount * 0.7f;
        this.Leg2.field_78808_h = 0.8f * Mth.func_76126_a((float)(limbSwing * 0.9f + (float)Math.PI)) * limbSwingAmount * 0.7f;
        this.Leg3.field_78795_f = this.Leg1.field_78795_f;
        this.Leg3.field_78808_h = -this.Leg1.field_78808_h;
        this.Leg4.field_78795_f = this.Leg2.field_78795_f;
        this.Leg4.field_78808_h = -this.Leg2.field_78808_h;
        this.Mouth2.field_78795_f = this.Mouth1.field_78795_f = 0.75f + 0.65f * Mth.func_76126_a((float)(ageInTicks * 0.1f));
        this.Mouth3.field_78795_f = this.Mouth1.field_78795_f;
        this.Mouth4.field_78795_f = this.Mouth1.field_78795_f;
    }
}

