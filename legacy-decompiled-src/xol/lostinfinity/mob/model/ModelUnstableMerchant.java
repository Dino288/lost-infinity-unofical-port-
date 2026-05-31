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
package xol.lostinfinity.mob.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;

public class ModelUnstableMerchant
extends ModelBase {
    private final ModelRenderer body;
    private final ModelRenderer head;
    private final ModelRenderer brim;
    private final ModelRenderer nose;
    private final ModelRenderer arms;
    private final ModelRenderer RightLeg;
    private final ModelRenderer LeftLeg;

    public ModelUnstableMerchant() {
        this.field_78090_t = 64;
        this.field_78089_u = 64;
        this.body = new ModelRenderer((ModelBase)this);
        this.body.func_78793_a(0.0f, 24.0f, 0.0f);
        this.body.field_78804_l.add(new ModelBox(this.body, 16, 20, -4.0f, -24.0f, -3.0f, 8, 12, 6, 0.0f, false));
        this.body.field_78804_l.add(new ModelBox(this.body, 0, 38, -4.0f, -24.0f, -3.0f, 8, 18, 6, 0.5f, false));
        this.head = new ModelRenderer((ModelBase)this);
        this.head.func_78793_a(0.0f, -24.0f, 0.0f);
        this.body.func_78792_a(this.head);
        this.head.field_78804_l.add(new ModelBox(this.head, 0, 0, -4.0f, -10.0f, -4.0f, 8, 10, 8, 0.0f, false));
        this.head.field_78804_l.add(new ModelBox(this.head, 34, 8, -1.0f, -16.0f, -1.0f, 2, 6, 2, 0.0f, false));
        this.head.field_78804_l.add(new ModelBox(this.head, 24, 1, -1.5f, -19.0f, -1.5f, 3, 3, 3, 0.0f, false));
        this.head.field_78804_l.add(new ModelBox(this.head, 36, 2, -1.5f, -15.0f, -1.5f, 3, 1, 3, 0.0f, false));
        this.head.field_78804_l.add(new ModelBox(this.head, 36, 2, -1.5f, -13.0f, -1.5f, 3, 1, 3, 0.0f, false));
        this.head.field_78804_l.add(new ModelBox(this.head, 33, 7, -5.0f, -6.0f, -5.0f, 1, 2, 10, 0.0f, false));
        this.head.field_78804_l.add(new ModelBox(this.head, 46, 12, -4.0f, -5.0f, 4.0f, 8, 4, 1, 0.0f, false));
        this.head.field_78804_l.add(new ModelBox(this.head, 46, 7, -4.0f, -3.0f, -5.0f, 8, 3, 1, 0.0f, false));
        this.head.field_78804_l.add(new ModelBox(this.head, 2, 3, -4.0f, -6.0f, -5.0f, 1, 3, 1, 0.0f, false));
        this.head.field_78804_l.add(new ModelBox(this.head, 2, 3, 3.0f, -6.0f, -5.0f, 1, 3, 1, 0.0f, false));
        this.head.field_78804_l.add(new ModelBox(this.head, 49, 1, -3.0f, -3.0f, -6.0f, 6, 3, 1, 0.0f, false));
        this.head.field_78804_l.add(new ModelBox(this.head, 33, 7, 4.0f, -6.0f, -5.0f, 1, 2, 10, 0.0f, true));
        this.head.field_78804_l.add(new ModelBox(this.head, 33, 7, 4.0f, -2.0f, -5.0f, 1, 2, 10, 0.0f, false));
        this.head.field_78804_l.add(new ModelBox(this.head, 33, 7, -5.0f, -2.0f, -5.0f, 1, 2, 10, 0.0f, true));
        this.head.field_78804_l.add(new ModelBox(this.head, 0, 0, -4.0f, -10.0f, -4.0f, 8, 10, 8, 0.0f, false));
        this.brim = new ModelRenderer((ModelBase)this);
        this.brim.func_78793_a(0.0f, 0.0f, 0.0f);
        this.head.func_78792_a(this.brim);
        this.setRotationAngle(this.brim, -1.5708f, 0.0f, 0.0f);
        this.nose = new ModelRenderer((ModelBase)this);
        this.nose.func_78793_a(0.0f, -2.0f, 0.0f);
        this.head.func_78792_a(this.nose);
        this.arms = new ModelRenderer((ModelBase)this);
        this.arms.func_78793_a(0.0f, -22.0f, 0.0f);
        this.body.func_78792_a(this.arms);
        this.setRotationAngle(this.arms, -0.7854f, 0.0f, 0.0f);
        this.arms.field_78804_l.add(new ModelBox(this.arms, 40, 38, -4.0f, 2.0f, -2.0f, 8, 4, 4, 0.0f, false));
        this.arms.field_78804_l.add(new ModelBox(this.arms, 44, 22, -8.0f, -2.0f, -2.0f, 4, 8, 4, 0.0f, false));
        this.arms.field_78804_l.add(new ModelBox(this.arms, 44, 22, 4.0f, -2.0f, -2.0f, 4, 8, 4, 0.0f, true));
        this.RightLeg = new ModelRenderer((ModelBase)this);
        this.RightLeg.func_78793_a(-2.0f, -12.0f, 0.0f);
        this.body.func_78792_a(this.RightLeg);
        this.RightLeg.field_78804_l.add(new ModelBox(this.RightLeg, 0, 22, -2.0f, 0.0f, -2.0f, 4, 12, 4, 0.0f, false));
        this.LeftLeg = new ModelRenderer((ModelBase)this);
        this.LeftLeg.func_78793_a(2.0f, -12.0f, 0.0f);
        this.body.func_78792_a(this.LeftLeg);
        this.LeftLeg.field_78804_l.add(new ModelBox(this.LeftLeg, 0, 22, -2.0f, 0.0f, -2.0f, 4, 12, 4, 0.0f, true));
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.body.func_78785_a(f5);
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
    }
}

