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

public class ModelDeviantSheep
extends ModelBase {
    private final ModelRenderer body2;
    private final ModelRenderer body;
    private final ModelRenderer head2;
    private final ModelRenderer head;
    private final ModelRenderer leg4;
    private final ModelRenderer leg0;
    private final ModelRenderer leg5;
    private final ModelRenderer leg1;
    private final ModelRenderer leg6;
    private final ModelRenderer leg2;
    private final ModelRenderer leg7;
    private final ModelRenderer leg3;

    public ModelDeviantSheep() {
        this.field_78090_t = 64;
        this.field_78089_u = 64;
        this.body2 = new ModelRenderer((ModelBase)this);
        this.body2.func_78793_a(0.0f, 6.0f, 2.0f);
        this.setRotationAngle(this.body2, -1.5708f, 0.0f, 0.0f);
        this.body2.field_78804_l.add(new ModelBox(this.body2, 28, 8, -4.0f, -7.0f, 1.0f, 8, 16, 6, 1.75f, true));
        this.body = new ModelRenderer((ModelBase)this);
        this.body.func_78793_a(0.0f, -2.0f, 9.0f);
        this.body2.func_78792_a(this.body);
        this.setRotationAngle(this.body, 3.1416f, 0.0f, 0.0f);
        this.body.field_78804_l.add(new ModelBox(this.body, 28, 40, -4.0f, -10.0f, 2.0f, 8, 16, 6, 0.0f, true));
        this.head2 = new ModelRenderer((ModelBase)this);
        this.head2.func_78793_a(0.0f, 11.0f, 1.0f);
        this.body2.func_78792_a(this.head2);
        this.setRotationAngle(this.head2, 1.1781f, 0.0f, 0.0f);
        this.head2.field_78804_l.add(new ModelBox(this.head2, 0, 0, -3.0f, -4.0f, -4.0f, 6, 6, 6, 0.6f, true));
        this.head = new ModelRenderer((ModelBase)this);
        this.head.func_78793_a(0.0f, -1.0f, -4.0f);
        this.head2.func_78792_a(this.head);
        this.setRotationAngle(this.head, 0.3927f, 0.0f, 0.0f);
        this.head.field_78804_l.add(new ModelBox(this.head, 0, 32, -3.0f, -3.0f, -7.0f, 6, 6, 8, 0.0f, true));
        this.leg4 = new ModelRenderer((ModelBase)this);
        this.leg4.func_78793_a(3.0f, 7.0f, 6.0f);
        this.body2.func_78792_a(this.leg4);
        this.setRotationAngle(this.leg4, 1.5708f, 0.0f, 0.0f);
        this.leg4.field_78804_l.add(new ModelBox(this.leg4, 0, 16, -2.0f, 0.0f, -2.0f, 4, 6, 4, 0.5f, true));
        this.leg0 = new ModelRenderer((ModelBase)this);
        this.leg0.func_78793_a(0.0f, 0.0f, 0.0f);
        this.leg4.func_78792_a(this.leg0);
        this.leg0.field_78804_l.add(new ModelBox(this.leg0, 0, 48, -2.0f, 0.0f, -2.0f, 4, 12, 4, 0.0f, true));
        this.leg5 = new ModelRenderer((ModelBase)this);
        this.leg5.func_78793_a(-3.0f, 7.0f, 6.0f);
        this.body2.func_78792_a(this.leg5);
        this.setRotationAngle(this.leg5, 1.5708f, 0.0f, 0.0f);
        this.leg5.field_78804_l.add(new ModelBox(this.leg5, 0, 16, -2.0f, 0.0f, -2.0f, 4, 6, 4, 0.5f, true));
        this.leg1 = new ModelRenderer((ModelBase)this);
        this.leg1.func_78793_a(0.0f, 0.0f, 0.0f);
        this.leg5.func_78792_a(this.leg1);
        this.leg1.field_78804_l.add(new ModelBox(this.leg1, 0, 48, -2.0f, 0.0f, -2.0f, 4, 12, 4, 0.0f, true));
        this.leg6 = new ModelRenderer((ModelBase)this);
        this.leg6.func_78793_a(3.0f, -5.0f, 6.0f);
        this.body2.func_78792_a(this.leg6);
        this.setRotationAngle(this.leg6, 1.5708f, 0.0f, 0.0f);
        this.leg6.field_78804_l.add(new ModelBox(this.leg6, 0, 16, -2.0f, 0.0f, -2.0f, 4, 6, 4, 0.5f, true));
        this.leg2 = new ModelRenderer((ModelBase)this);
        this.leg2.func_78793_a(0.0f, 0.0f, 0.0f);
        this.leg6.func_78792_a(this.leg2);
        this.leg2.field_78804_l.add(new ModelBox(this.leg2, 0, 48, -2.0f, 0.0f, -2.0f, 4, 12, 4, 0.0f, true));
        this.leg7 = new ModelRenderer((ModelBase)this);
        this.leg7.func_78793_a(-3.0f, -5.0f, 6.0f);
        this.body2.func_78792_a(this.leg7);
        this.setRotationAngle(this.leg7, 1.5708f, 0.0f, 0.0f);
        this.leg7.field_78804_l.add(new ModelBox(this.leg7, 0, 16, -2.0f, 0.0f, -2.0f, 4, 6, 4, 0.5f, true));
        this.leg3 = new ModelRenderer((ModelBase)this);
        this.leg3.func_78793_a(0.0f, 0.0f, 0.0f);
        this.leg7.func_78792_a(this.leg3);
        this.leg3.field_78804_l.add(new ModelBox(this.leg3, 0, 48, -2.0f, 0.0f, -2.0f, 4, 12, 4, 0.0f, true));
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.body2.func_78785_a(f5);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        float limbRange = 1.4f;
        float limbSpeed = 0.6662f;
        this.leg0.field_78795_f = Mth.func_76134_b((float)(limbSwing * limbSpeed)) * limbRange * limbSwingAmount;
        this.leg1.field_78795_f = Mth.func_76134_b((float)(limbSwing * limbSpeed + (float)Math.PI)) * limbRange * limbSwingAmount;
        this.leg2.field_78795_f = Mth.func_76134_b((float)(limbSwing * limbSpeed + (float)Math.PI)) * limbRange * limbSwingAmount;
        this.leg3.field_78795_f = Mth.func_76134_b((float)(limbSwing * limbSpeed)) * limbRange * limbSwingAmount;
        this.head.field_78796_g = netHeadYaw * ((float)Math.PI / 180);
        this.head.field_78795_f = headPitch * ((float)Math.PI / 180);
    }
}

