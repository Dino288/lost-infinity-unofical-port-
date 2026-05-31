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

public class ModelSightwalker
extends ModelBase {
    private final ModelRenderer Body;
    private final ModelRenderer head;
    private final ModelRenderer LeftLeg;
    private final ModelRenderer LeftLeg_r1;
    private final ModelRenderer LeftLeg_r2;
    private final ModelRenderer RightLeg;
    private final ModelRenderer LeftLeg_r3;
    private final ModelRenderer LeftLeg_r4;

    public ModelSightwalker() {
        this.field_78090_t = 64;
        this.field_78089_u = 32;
        this.Body = new ModelRenderer((ModelBase)this);
        this.Body.func_78793_a(0.0f, 0.0f, 0.0f);
        this.Body.field_78804_l.add(new ModelBox(this.Body, 0, 16, -6.0f, -17.5f, -4.5f, 3, 7, 9, 0.0f, true));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 0, 16, 3.0f, -17.5f, -4.5f, 3, 7, 9, 0.0f, false));
        this.head = new ModelRenderer((ModelBase)this);
        this.head.func_78793_a(0.0f, 0.0f, 0.0f);
        this.head.field_78804_l.add(new ModelBox(this.head, 0, 0, -4.0f, -19.0f, -4.0f, 8, 8, 8, 0.0f, false));
        this.LeftLeg = new ModelRenderer((ModelBase)this);
        this.LeftLeg.func_78793_a(4.9f, -16.0f, 0.0f);
        this.LeftLeg.field_78804_l.add(new ModelBox(this.LeftLeg, 38, 15, 2.6f, 27.0f, -1.5f, 3, 14, 3, -0.3f, true));
        this.LeftLeg.field_78804_l.add(new ModelBox(this.LeftLeg, 48, 6, 2.1f, 39.0f, -2.0f, 4, 1, 4, -0.3f, true));
        this.LeftLeg.field_78804_l.add(new ModelBox(this.LeftLeg, 48, 6, 2.1f, 33.0f, -2.0f, 4, 1, 4, -0.3f, true));
        this.LeftLeg_r1 = new ModelRenderer((ModelBase)this);
        this.LeftLeg_r1.func_78793_a(1.6f, 17.0f, 0.0f);
        this.LeftLeg.func_78792_a(this.LeftLeg_r1);
        this.setRotationAngle(this.LeftLeg_r1, 0.0f, 0.0f, -0.0873f);
        this.LeftLeg_r1.field_78804_l.add(new ModelBox(this.LeftLeg_r1, 48, 0, -0.5f, 2.0f, -2.0f, 4, 1, 4, -0.15f, true));
        this.LeftLeg_r1.field_78804_l.add(new ModelBox(this.LeftLeg_r1, 48, 0, -0.5f, -4.0f, -2.0f, 4, 1, 4, -0.15f, true));
        this.LeftLeg_r1.field_78804_l.add(new ModelBox(this.LeftLeg_r1, 48, 0, -0.5f, 7.0f, -2.0f, 4, 1, 4, -0.15f, true));
        this.LeftLeg_r1.field_78804_l.add(new ModelBox(this.LeftLeg_r1, 52, 11, 0.0f, -7.0f, -1.5f, 3, 18, 3, -0.15f, true));
        this.LeftLeg_r2 = new ModelRenderer((ModelBase)this);
        this.LeftLeg_r2.func_78793_a(2.5f, 6.0f, 0.0f);
        this.LeftLeg.func_78792_a(this.LeftLeg_r2);
        this.setRotationAngle(this.LeftLeg_r2, 0.0f, 0.0f, -0.2618f);
        this.LeftLeg_r2.field_78804_l.add(new ModelBox(this.LeftLeg_r2, 35, 3, -3.0f, 1.0f, -2.0f, 4, 1, 4, 0.0f, true));
        this.LeftLeg_r2.field_78804_l.add(new ModelBox(this.LeftLeg_r2, 25, 17, -2.5f, -7.0f, -1.5f, 3, 12, 3, 0.0f, true));
        this.RightLeg = new ModelRenderer((ModelBase)this);
        this.RightLeg.func_78793_a(-4.9f, -16.0f, 0.0f);
        this.RightLeg.field_78804_l.add(new ModelBox(this.RightLeg, 38, 15, -5.6f, 27.0f, -1.5f, 3, 14, 3, -0.3f, false));
        this.RightLeg.field_78804_l.add(new ModelBox(this.RightLeg, 48, 6, -6.1f, 39.0f, -2.0f, 4, 1, 4, -0.3f, false));
        this.RightLeg.field_78804_l.add(new ModelBox(this.RightLeg, 48, 6, -6.1f, 33.0f, -2.0f, 4, 1, 4, -0.3f, false));
        this.LeftLeg_r3 = new ModelRenderer((ModelBase)this);
        this.LeftLeg_r3.func_78793_a(-1.6f, 17.0f, 0.0f);
        this.RightLeg.func_78792_a(this.LeftLeg_r3);
        this.setRotationAngle(this.LeftLeg_r3, 0.0f, 0.0f, 0.0873f);
        this.LeftLeg_r3.field_78804_l.add(new ModelBox(this.LeftLeg_r3, 48, 0, -3.5f, 2.0f, -2.0f, 4, 1, 4, -0.15f, false));
        this.LeftLeg_r3.field_78804_l.add(new ModelBox(this.LeftLeg_r3, 48, 0, -3.5f, -4.0f, -2.0f, 4, 1, 4, -0.15f, false));
        this.LeftLeg_r3.field_78804_l.add(new ModelBox(this.LeftLeg_r3, 48, 0, -3.5f, 7.0f, -2.0f, 4, 1, 4, -0.15f, false));
        this.LeftLeg_r3.field_78804_l.add(new ModelBox(this.LeftLeg_r3, 52, 11, -3.0f, -7.0f, -1.5f, 3, 18, 3, -0.15f, false));
        this.LeftLeg_r4 = new ModelRenderer((ModelBase)this);
        this.LeftLeg_r4.func_78793_a(-2.5f, 6.0f, 0.0f);
        this.RightLeg.func_78792_a(this.LeftLeg_r4);
        this.setRotationAngle(this.LeftLeg_r4, 0.0f, 0.0f, 0.2618f);
        this.LeftLeg_r4.field_78804_l.add(new ModelBox(this.LeftLeg_r4, 35, 3, -1.0f, 1.0f, -2.0f, 4, 1, 4, 0.0f, false));
        this.LeftLeg_r4.field_78804_l.add(new ModelBox(this.LeftLeg_r4, 25, 17, -0.5f, -7.0f, -1.5f, 3, 12, 3, 0.0f, false));
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.Body.func_78785_a(f5);
        this.head.func_78785_a(f5);
        this.LeftLeg.func_78785_a(f5);
        this.RightLeg.func_78785_a(f5);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.LeftLeg.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.9662f + (float)Math.PI)) * 0.5f * limbSwingAmount * 0.5f;
        this.LeftLeg.field_78808_h = 0.5f * Mth.func_76134_b((float)(limbSwing * 0.9662f + (float)Math.PI)) * 1.1f * limbSwingAmount * 0.5f;
        this.RightLeg.field_78795_f = Mth.func_76126_a((float)(limbSwing * 0.9662f + (float)Math.PI)) * 0.5f * limbSwingAmount * 0.5f;
        this.RightLeg.field_78808_h = 0.5f * Mth.func_76126_a((float)(limbSwing * 0.9662f + (float)Math.PI)) * 1.1f * limbSwingAmount * 0.5f;
    }
}

