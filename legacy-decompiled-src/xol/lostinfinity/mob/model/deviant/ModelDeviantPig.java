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

public class ModelDeviantPig
extends ModelBase {
    private final ModelRenderer body;
    private final ModelRenderer body_r1;
    private final ModelRenderer head;
    private final ModelRenderer head_r1;
    private final ModelRenderer head_r2;
    private final ModelRenderer head_r3;
    private final ModelRenderer head_r4;
    private final ModelRenderer leg0;
    private final ModelRenderer leg1;
    private final ModelRenderer leg2;
    private final ModelRenderer leg22_r1;
    private final ModelRenderer leg3;
    private final ModelRenderer leg23_r1;

    public ModelDeviantPig() {
        this.field_78090_t = 64;
        this.field_78089_u = 32;
        this.body = new ModelRenderer((ModelBase)this);
        this.body.func_78793_a(0.0f, 10.3f, 2.0f);
        this.setRotationAngle(this.body, -0.1745f, 0.0f, 0.0f);
        this.body_r1 = new ModelRenderer((ModelBase)this);
        this.body_r1.func_78793_a(0.0f, 13.0f, -2.0f);
        this.body.func_78792_a(this.body_r1);
        this.setRotationAngle(this.body_r1, 1.5708f, 0.0f, 0.0f);
        this.body_r1.field_78804_l.add(new ModelBox(this.body_r1, 28, 8, -5.0f, -7.0f, 6.0f, 10, 16, 8, 0.0f, true));
        this.head = new ModelRenderer((ModelBase)this);
        this.head.func_78793_a(0.0f, 1.0f, -8.0f);
        this.body.func_78792_a(this.head);
        this.setRotationAngle(this.head, 0.1745f, 0.0f, 0.0f);
        this.head.field_78804_l.add(new ModelBox(this.head, 0, 0, -4.0f, -4.0f, -8.0f, 8, 8, 8, 0.0f, true));
        this.head.field_78804_l.add(new ModelBox(this.head, 16, 16, -2.0f, 0.0f, -9.0f, 4, 3, 1, 0.0f, true));
        this.head_r1 = new ModelRenderer((ModelBase)this);
        this.head_r1.func_78793_a(0.0f, 12.0f, 6.0f);
        this.head.func_78792_a(this.head_r1);
        this.setRotationAngle(this.head_r1, 0.3927f, 0.3927f, 0.0f);
        this.head_r1.field_78804_l.add(new ModelBox(this.head_r1, 10, 23, 1.0f, -15.0f, -14.0f, 2, 2, 7, 0.0f, false));
        this.head_r2 = new ModelRenderer((ModelBase)this);
        this.head_r2.func_78793_a(0.0f, 12.0f, 6.0f);
        this.head.func_78792_a(this.head_r2);
        this.setRotationAngle(this.head_r2, -0.3927f, 0.3927f, 0.0f);
        this.head_r2.field_78804_l.add(new ModelBox(this.head_r2, 13, 25, 1.5f, -1.0f, -24.0f, 1, 1, 5, 0.0f, false));
        this.head_r3 = new ModelRenderer((ModelBase)this);
        this.head_r3.func_78793_a(0.0f, 12.0f, 6.0f);
        this.head.func_78792_a(this.head_r3);
        this.setRotationAngle(this.head_r3, -0.3927f, -0.3927f, 0.0f);
        this.head_r3.field_78804_l.add(new ModelBox(this.head_r3, 13, 25, -2.5f, -1.0f, -24.0f, 1, 1, 5, 0.0f, true));
        this.head_r4 = new ModelRenderer((ModelBase)this);
        this.head_r4.func_78793_a(0.0f, 12.0f, 6.0f);
        this.head.func_78792_a(this.head_r4);
        this.setRotationAngle(this.head_r4, 0.3927f, -0.3927f, 0.0f);
        this.head_r4.field_78804_l.add(new ModelBox(this.head_r4, 10, 23, -3.0f, -15.0f, -14.0f, 2, 2, 7, 0.0f, true));
        this.leg0 = new ModelRenderer((ModelBase)this);
        this.leg0.func_78793_a(3.0f, 7.0f, 5.0f);
        this.body.func_78792_a(this.leg0);
        this.setRotationAngle(this.leg0, 0.1745f, 0.0f, 0.0f);
        this.leg0.field_78804_l.add(new ModelBox(this.leg0, 0, 16, -2.0f, 0.0f, -2.0f, 4, 6, 4, 0.0f, true));
        this.leg1 = new ModelRenderer((ModelBase)this);
        this.leg1.func_78793_a(-3.0f, 7.0f, 5.0f);
        this.body.func_78792_a(this.leg1);
        this.setRotationAngle(this.leg1, 0.1745f, 0.0f, 0.0f);
        this.leg1.field_78804_l.add(new ModelBox(this.leg1, 0, 16, -2.0f, 0.0f, -2.0f, 4, 6, 4, 0.0f, true));
        this.leg2 = new ModelRenderer((ModelBase)this);
        this.leg2.func_78793_a(3.0f, 7.0f, -7.0f);
        this.body.func_78792_a(this.leg2);
        this.setRotationAngle(this.leg2, 0.2182f, 0.0f, 0.0f);
        this.leg2.field_78804_l.add(new ModelBox(this.leg2, 0, 16, -2.0f, 2.0417f, -1.0882f, 4, 6, 4, 0.0f, true));
        this.leg22_r1 = new ModelRenderer((ModelBase)this);
        this.leg22_r1.func_78793_a(-3.0f, 6.0f, 5.0f);
        this.leg2.func_78792_a(this.leg22_r1);
        this.setRotationAngle(this.leg22_r1, 1.5724f, 0.0902f, -0.0423f);
        this.leg22_r1.field_78804_l.add(new ModelBox(this.leg22_r1, 10, 23, 2.75f, -4.75f, 3.0f, 2, 2, 7, 0.0f, true));
        this.leg3 = new ModelRenderer((ModelBase)this);
        this.leg3.func_78793_a(-3.0f, 7.0f, -7.0f);
        this.body.func_78792_a(this.leg3);
        this.setRotationAngle(this.leg3, 0.2182f, 0.0f, 0.0f);
        this.leg3.field_78804_l.add(new ModelBox(this.leg3, 0, 16, -2.0f, 2.0417f, -1.0882f, 4, 6, 4, 0.0f, true));
        this.leg23_r1 = new ModelRenderer((ModelBase)this);
        this.leg23_r1.func_78793_a(3.0f, 6.0f, 5.0f);
        this.leg3.func_78792_a(this.leg23_r1);
        this.setRotationAngle(this.leg23_r1, 1.5724f, -0.0902f, 0.0423f);
        this.leg23_r1.field_78804_l.add(new ModelBox(this.leg23_r1, 10, 23, -4.75f, -4.75f, 3.0f, 2, 2, 7, 0.0f, false));
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

