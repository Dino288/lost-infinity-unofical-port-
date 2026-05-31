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

public class ModelDeviantEvoker
extends ModelBase {
    private final ModelRenderer body;
    private final ModelRenderer head;
    private final ModelRenderer nose;
    private final ModelRenderer leg0;
    private final ModelRenderer arms;
    private final ModelRenderer leg1;
    private final ModelRenderer rightarm;
    private final ModelRenderer rightarm2;
    private final ModelRenderer leftarm;
    private final ModelRenderer leftarm2;

    public ModelDeviantEvoker() {
        this.field_78090_t = 64;
        this.field_78089_u = 64;
        this.body = new ModelRenderer((ModelBase)this);
        this.body.func_78793_a(0.0f, 0.0f, 0.0f);
        this.body.field_78804_l.add(new ModelBox(this.body, 16, 20, -4.0f, 0.0f, -3.0f, 8, 12, 6, 0.0f, true));
        this.body.field_78804_l.add(new ModelBox(this.body, 0, 38, -4.0f, 0.0f, -3.0f, 8, 18, 6, 0.5f, true));
        this.head = new ModelRenderer((ModelBase)this);
        this.head.func_78793_a(0.0f, 0.0f, 0.0f);
        this.body.func_78792_a(this.head);
        this.head.field_78804_l.add(new ModelBox(this.head, 0, 0, -4.0f, -10.0f, -4.0f, 8, 10, 8, 0.0f, true));
        this.nose = new ModelRenderer((ModelBase)this);
        this.nose.func_78793_a(0.0f, -2.0f, 0.0f);
        this.head.func_78792_a(this.nose);
        this.nose.field_78804_l.add(new ModelBox(this.nose, 24, 0, -1.0f, -1.0f, -6.0f, 2, 4, 2, 0.0f, true));
        this.leg0 = new ModelRenderer((ModelBase)this);
        this.leg0.func_78793_a(2.0f, 12.0f, 0.0f);
        this.body.func_78792_a(this.leg0);
        this.leg0.field_78804_l.add(new ModelBox(this.leg0, 0, 22, -2.0f, 0.0f, -2.0f, 4, 12, 4, 0.0f, true));
        this.arms = new ModelRenderer((ModelBase)this);
        this.arms.func_78793_a(0.0f, 2.0f, 0.0f);
        this.body.func_78792_a(this.arms);
        this.setRotationAngle(this.arms, -0.5236f, 0.0f, 0.0f);
        this.arms.field_78804_l.add(new ModelBox(this.arms, 40, 38, -4.0f, 2.0f, -2.0f, 8, 4, 4, 0.0f, true));
        this.arms.field_78804_l.add(new ModelBox(this.arms, 44, 22, 4.0f, -2.0f, -2.0f, 4, 8, 4, 0.0f, true));
        this.arms.field_78804_l.add(new ModelBox(this.arms, 44, 22, -8.0f, -2.0f, -2.0f, 4, 8, 4, 0.0f, true));
        this.leg1 = new ModelRenderer((ModelBase)this);
        this.leg1.func_78793_a(-2.0f, 12.0f, 0.0f);
        this.body.func_78792_a(this.leg1);
        this.leg1.field_78804_l.add(new ModelBox(this.leg1, 0, 22, -2.0f, 0.0f, -2.0f, 4, 12, 4, 0.0f, false));
        this.rightarm = new ModelRenderer((ModelBase)this);
        this.rightarm.func_78793_a(5.0f, 2.0f, 0.0f);
        this.body.func_78792_a(this.rightarm);
        this.setRotationAngle(this.rightarm, 0.0f, 0.0f, -1.8762f);
        this.rightarm.field_78804_l.add(new ModelBox(this.rightarm, 40, 46, -1.0f, -2.0f, -2.0f, 4, 12, 4, 0.0f, true));
        this.rightarm2 = new ModelRenderer((ModelBase)this);
        this.rightarm2.func_78793_a(5.0f, 6.0f, 0.0f);
        this.body.func_78792_a(this.rightarm2);
        this.setRotationAngle(this.rightarm2, 0.0f, 0.0f, -1.0472f);
        this.rightarm2.field_78804_l.add(new ModelBox(this.rightarm2, 40, 46, -1.0f, -2.0f, -2.0f, 4, 12, 4, 0.0f, true));
        this.leftarm = new ModelRenderer((ModelBase)this);
        this.leftarm.func_78793_a(-5.0f, 2.0f, 0.0f);
        this.body.func_78792_a(this.leftarm);
        this.setRotationAngle(this.leftarm, 0.0f, 0.0f, 1.9199f);
        this.leftarm.field_78804_l.add(new ModelBox(this.leftarm, 40, 46, -3.0f, -2.0f, -2.0f, 4, 12, 4, 0.0f, false));
        this.leftarm2 = new ModelRenderer((ModelBase)this);
        this.leftarm2.func_78793_a(-5.0f, 6.0f, 0.0f);
        this.body.func_78792_a(this.leftarm2);
        this.setRotationAngle(this.leftarm2, 0.0f, 0.0f, 0.8727f);
        this.leftarm2.field_78804_l.add(new ModelBox(this.leftarm2, 40, 46, -3.0f, -2.0f, -2.0f, 4, 12, 4, 0.0f, false));
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
        this.leg0.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f)) * 1.4f * limbSwingAmount * 0.5f;
        this.leg1.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f + (float)Math.PI)) * 1.4f * limbSwingAmount * 0.5f;
        this.leftarm.field_78796_g = 0.3f * Mth.func_76126_a((float)(ageInTicks * 0.2f));
        this.leftarm.field_78808_h = 1.9199f + 0.3f * Mth.func_76126_a((float)(ageInTicks * 0.2f));
        this.leftarm2.field_78796_g = -0.3f * Mth.func_76126_a((float)(ageInTicks * 0.2f));
        this.leftarm2.field_78808_h = 0.8727f - 0.3f * Mth.func_76126_a((float)(ageInTicks * 0.2f));
        this.rightarm.field_78796_g = 0.3f * Mth.func_76126_a((float)(ageInTicks * 0.2f));
        this.rightarm.field_78808_h = -1.8762f + 0.3f * Mth.func_76126_a((float)(ageInTicks * 0.2f));
        this.rightarm2.field_78796_g = -0.3f * Mth.func_76126_a((float)(ageInTicks * 0.2f));
        this.rightarm2.field_78808_h = -1.0472f - 0.3f * Mth.func_76126_a((float)(ageInTicks * 0.2f));
    }
}

