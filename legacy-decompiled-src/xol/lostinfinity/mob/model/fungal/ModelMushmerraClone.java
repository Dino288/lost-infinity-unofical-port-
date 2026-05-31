/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.model.ModelBox
 *  net.minecraft.client.model.ModelRenderer
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.math.Mth
 */
package xol.lostinfinity.mob.model.fungal;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import xol.lostinfinity.mob.entity.fungal.EntityMushmerraClone;

public class ModelMushmerraClone
extends ModelBase {
    private final ModelRenderer Body_1;
    private final ModelRenderer body2_r1;
    private final ModelRenderer Neck_1;
    private final ModelRenderer neck2_r1;
    private final ModelRenderer Head_1;
    private final ModelRenderer head2_r1;
    private final ModelRenderer Body_2;
    private final ModelRenderer Leg_Left_1;
    private final ModelRenderer Leg_Right_1;
    private final ModelRenderer Arm_Left_1;
    private final ModelRenderer Arm_Right_1;
    private final ModelRenderer armright3_r1;

    public ModelMushmerraClone() {
        this.field_78090_t = 128;
        this.field_78089_u = 64;
        this.Body_1 = new ModelRenderer((ModelBase)this);
        this.Body_1.func_78793_a(0.0f, 6.0f, -2.0f);
        this.setRotationAngle(this.Body_1, 0.3927f, 0.0f, 0.0f);
        this.Body_1.field_78804_l.add(new ModelBox(this.Body_1, 0, 0, -6.0f, -7.0f, -6.0f, 12, 12, 12, 0.0f, false));
        this.body2_r1 = new ModelRenderer((ModelBase)this);
        this.body2_r1.func_78793_a(0.0f, 12.0f, 0.0f);
        this.Body_1.func_78792_a(this.body2_r1);
        this.setRotationAngle(this.body2_r1, -0.3927f, 0.0f, 0.0f);
        this.body2_r1.field_78804_l.add(new ModelBox(this.body2_r1, 50, 0, 0.0f, -27.0f, -13.0f, 0, 12, 12, 0.0f, false));
        this.Neck_1 = new ModelRenderer((ModelBase)this);
        this.Neck_1.func_78793_a(0.0f, -3.0f, -6.0f);
        this.Body_1.func_78792_a(this.Neck_1);
        this.Neck_1.field_78804_l.add(new ModelBox(this.Neck_1, 11, 25, -2.0f, -2.0f, -9.0f, 4, 4, 9, 0.0f, false));
        this.neck2_r1 = new ModelRenderer((ModelBase)this);
        this.neck2_r1.func_78793_a(0.0f, 15.0f, 6.0f);
        this.Neck_1.func_78792_a(this.neck2_r1);
        this.setRotationAngle(this.neck2_r1, -1.5708f, 0.0f, 0.0f);
        this.neck2_r1.field_78804_l.add(new ModelBox(this.neck2_r1, 30, 31, -2.0f, 11.0f, -26.0f, 4, 4, 9, 0.0f, false));
        this.Head_1 = new ModelRenderer((ModelBase)this);
        this.Head_1.func_78793_a(0.0f, -11.0f, -7.0f);
        this.Neck_1.func_78792_a(this.Head_1);
        this.head2_r1 = new ModelRenderer((ModelBase)this);
        this.head2_r1.func_78793_a(0.0f, 26.0f, 13.0f);
        this.Head_1.func_78792_a(this.head2_r1);
        this.setRotationAngle(this.head2_r1, -1.5708f, 0.0f, 0.0f);
        this.head2_r1.field_78804_l.add(new ModelBox(this.head2_r1, 0, 48, -4.0f, 6.0f, -34.0f, 8, 12, 4, 0.0f, false));
        this.head2_r1.field_78804_l.add(new ModelBox(this.head2_r1, 12, 39, -2.0f, 11.0f, -30.0f, 4, 4, 4, 0.0f, false));
        this.Body_2 = new ModelRenderer((ModelBase)this);
        this.Body_2.func_78793_a(0.0f, -1.0f, 3.0f);
        this.Body_1.func_78792_a(this.Body_2);
        this.setRotationAngle(this.Body_2, -0.7854f, 0.0f, 0.0f);
        this.Body_2.field_78804_l.add(new ModelBox(this.Body_2, 64, 14, -3.0f, -4.0f, 0.0f, 6, 8, 12, 0.0f, false));
        this.Body_2.field_78804_l.add(new ModelBox(this.Body_2, 37, -11, 0.0f, -12.0f, 0.0f, 0, 8, 12, 0.0f, false));
        this.Leg_Left_1 = new ModelRenderer((ModelBase)this);
        this.Leg_Left_1.func_78793_a(3.0f, 1.0f, 9.0f);
        this.Body_2.func_78792_a(this.Leg_Left_1);
        this.setRotationAngle(this.Leg_Left_1, 0.3927f, 0.0f, 0.0f);
        this.Leg_Left_1.field_78804_l.add(new ModelBox(this.Leg_Left_1, 114, 34, 0.0f, -3.0f, -2.0f, 3, 19, 4, 0.0f, false));
        this.Leg_Right_1 = new ModelRenderer((ModelBase)this);
        this.Leg_Right_1.func_78793_a(-3.0f, 1.0f, 9.0f);
        this.Body_2.func_78792_a(this.Leg_Right_1);
        this.setRotationAngle(this.Leg_Right_1, 0.3927f, 0.0f, 0.0f);
        this.Leg_Right_1.field_78804_l.add(new ModelBox(this.Leg_Right_1, 114, 34, -3.0f, -3.0f, -2.0f, 3, 19, 4, 0.0f, true));
        this.Arm_Left_1 = new ModelRenderer((ModelBase)this);
        this.Arm_Left_1.func_78793_a(6.0f, -5.0f, -1.0f);
        this.Body_1.func_78792_a(this.Arm_Left_1);
        this.setRotationAngle(this.Arm_Left_1, -0.3927f, 0.0f, 0.0f);
        this.Arm_Left_1.field_78804_l.add(new ModelBox(this.Arm_Left_1, 110, 0, 0.0f, -5.0f, -3.0f, 4, 27, 5, 0.0f, false));
        this.Arm_Right_1 = new ModelRenderer((ModelBase)this);
        this.Arm_Right_1.func_78793_a(-6.0f, -5.0f, -1.0f);
        this.Body_1.func_78792_a(this.Arm_Right_1);
        this.setRotationAngle(this.Arm_Right_1, -0.3927f, 0.0f, 0.0f);
        this.Arm_Right_1.field_78804_l.add(new ModelBox(this.Arm_Right_1, 110, 0, -4.0f, -5.0f, -3.0f, 4, 27, 5, 0.0f, true));
        this.Arm_Right_1.field_78804_l.add(new ModelBox(this.Arm_Right_1, 0, 0, -2.0f, -10.0f, -2.0f, 0, 5, 4, 0.0f, true));
        this.armright3_r1 = new ModelRenderer((ModelBase)this);
        this.armright3_r1.func_78793_a(6.0f, 17.0f, 1.0f);
        this.Arm_Right_1.func_78792_a(this.armright3_r1);
        this.setRotationAngle(this.armright3_r1, 0.0f, -1.5708f, 0.0f);
        this.armright3_r1.field_78804_l.add(new ModelBox(this.armright3_r1, 0, 0, -1.0f, -27.0f, 6.0f, 0, 5, 4, 0.0f, true));
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        EntityMushmerraClone entityMushmerraClone = (EntityMushmerraClone)entity;
        float alpha = entityMushmerraClone.getAlpha();
        GlStateManager.func_179147_l();
        GlStateManager.func_179112_b((int)770, (int)771);
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)alpha);
        this.Body_1.func_78785_a(f5);
        GlStateManager.func_179084_k();
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        float armInitial = -0.3926991f;
        float legInitial = 0.3926991f;
        this.Body_1.field_78796_g = netHeadYaw * ((float)Math.PI / 180);
        this.Neck_1.field_78795_f = headPitch * ((float)Math.PI / 180);
        this.Arm_Right_1.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f)) * 1.05f * limbSwingAmount + armInitial;
        this.Arm_Left_1.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f + (float)Math.PI)) * 1.05f * limbSwingAmount + armInitial;
        this.Leg_Right_1.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f)) * 1.05f * limbSwingAmount + legInitial;
        this.Leg_Left_1.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f + (float)Math.PI)) * 1.05f * limbSwingAmount + legInitial;
    }
}

