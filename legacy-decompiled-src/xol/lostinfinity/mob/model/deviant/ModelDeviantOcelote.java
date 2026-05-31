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

public class ModelDeviantOcelote
extends ModelBase {
    private final ModelRenderer body;
    private final ModelRenderer belly;
    private final ModelRenderer WingL;
    private final ModelRenderer WingR;
    private final ModelRenderer head;
    private final ModelRenderer mouth;
    private final ModelRenderer tail;
    private final ModelRenderer tail2;
    private final ModelRenderer tail3;
    private final ModelRenderer tail4;
    private final ModelRenderer tail5;
    private final ModelRenderer tail6;
    private final ModelRenderer backLegL;
    private final ModelRenderer backLegR;
    private final ModelRenderer frontLegL;
    private final ModelRenderer frontLegR;

    public ModelDeviantOcelote() {
        this.field_78090_t = 64;
        this.field_78089_u = 32;
        this.body = new ModelRenderer((ModelBase)this);
        this.body.func_78793_a(0.0f, 17.0f, 1.0f);
        this.belly = new ModelRenderer((ModelBase)this);
        this.belly.func_78793_a(0.0f, 0.0f, 0.0f);
        this.body.func_78792_a(this.belly);
        this.setRotationAngle(this.belly, 1.5708f, 0.0f, 0.0f);
        this.belly.field_78804_l.add(new ModelBox(this.belly, 20, 0, -2.0f, -8.0f, -3.0f, 4, 16, 6, 0.0f, false));
        this.WingL = new ModelRenderer((ModelBase)this);
        this.WingL.func_78793_a(2.0f, -3.5f, 2.25f);
        this.belly.func_78792_a(this.WingL);
        this.WingL.field_78804_l.add(new ModelBox(this.WingL, 16, 22, 0.0f, -1.0f, 0.25f, 14, 2, 1, 0.0f, false));
        this.WingL.field_78804_l.add(new ModelBox(this.WingL, 11, 25, 0.0f, -0.5f, -5.75f, 14, 1, 6, 0.0f, false));
        this.WingR = new ModelRenderer((ModelBase)this);
        this.WingR.func_78793_a(-2.0f, -3.5f, 2.25f);
        this.belly.func_78792_a(this.WingR);
        this.WingR.field_78804_l.add(new ModelBox(this.WingR, 16, 22, -14.0f, -1.0f, 0.25f, 14, 2, 1, 0.0f, true));
        this.WingR.field_78804_l.add(new ModelBox(this.WingR, 11, 25, -14.0f, -0.5f, -5.75f, 14, 1, 6, 0.0f, true));
        this.head = new ModelRenderer((ModelBase)this);
        this.head.func_78793_a(0.0f, -2.0f, -10.0f);
        this.body.func_78792_a(this.head);
        this.head.field_78804_l.add(new ModelBox(this.head, 0, 0, -2.5f, -2.0f, -3.0f, 5, 4, 5, 0.0f, false));
        this.head.field_78804_l.add(new ModelBox(this.head, 0, 24, -1.5f, -0.0156f, -4.0f, 3, 2, 2, 0.0f, false));
        this.head.field_78804_l.add(new ModelBox(this.head, 0, 10, -2.0f, -3.0f, 0.0f, 1, 1, 2, 0.0f, false));
        this.head.field_78804_l.add(new ModelBox(this.head, 6, 10, 1.0f, -3.0f, 0.0f, 1, 1, 2, 0.0f, false));
        this.mouth = new ModelRenderer((ModelBase)this);
        this.mouth.func_78793_a(0.0f, 2.0f, 2.0f);
        this.head.func_78792_a(this.mouth);
        this.setRotationAngle(this.mouth, 0.5236f, 0.0f, 0.0f);
        this.mouth.field_78804_l.add(new ModelBox(this.mouth, 44, 15, -2.5f, 0.0f, -5.0f, 5, 1, 5, 0.0f, false));
        this.mouth.field_78804_l.add(new ModelBox(this.mouth, 44, 15, -2.0f, -2.0f, -4.5f, 1, 2, 1, 0.0f, false));
        this.mouth.field_78804_l.add(new ModelBox(this.mouth, 44, 15, 1.0f, -2.0f, -4.5f, 1, 2, 1, 0.0f, false));
        this.tail = new ModelRenderer((ModelBase)this);
        this.tail.func_78793_a(0.0f, -2.0f, 7.0f);
        this.body.func_78792_a(this.tail);
        this.setRotationAngle(this.tail, 0.7854f, 0.0f, 0.0f);
        this.tail.field_78804_l.add(new ModelBox(this.tail, 0, 15, -0.5f, 0.0f, 0.0f, 1, 8, 1, 0.0f, false));
        this.tail2 = new ModelRenderer((ModelBase)this);
        this.tail2.func_78793_a(0.0f, 8.0f, 0.0f);
        this.tail.func_78792_a(this.tail2);
        this.setRotationAngle(this.tail2, 0.7854f, 0.0f, 0.0f);
        this.tail2.field_78804_l.add(new ModelBox(this.tail2, 4, 15, -0.5f, 0.0f, 0.0f, 1, 8, 1, 0.0f, false));
        this.tail3 = new ModelRenderer((ModelBase)this);
        this.tail3.func_78793_a(1.0f, -1.0f, 7.0f);
        this.body.func_78792_a(this.tail3);
        this.setRotationAngle(this.tail3, 0.7854f, 0.5236f, 0.0f);
        this.tail3.field_78804_l.add(new ModelBox(this.tail3, 0, 15, -0.5f, 0.0f, 0.0f, 1, 8, 1, 0.0f, false));
        this.tail4 = new ModelRenderer((ModelBase)this);
        this.tail4.func_78793_a(0.0f, 8.0f, 0.0f);
        this.tail3.func_78792_a(this.tail4);
        this.setRotationAngle(this.tail4, 0.7854f, 0.0f, 0.0f);
        this.tail4.field_78804_l.add(new ModelBox(this.tail4, 4, 15, -0.5f, 0.0f, 0.0f, 1, 8, 1, 0.0f, false));
        this.tail5 = new ModelRenderer((ModelBase)this);
        this.tail5.func_78793_a(-1.0f, -1.0f, 7.0f);
        this.body.func_78792_a(this.tail5);
        this.setRotationAngle(this.tail5, 0.7854f, -0.5236f, 0.0f);
        this.tail5.field_78804_l.add(new ModelBox(this.tail5, 0, 15, -0.5f, 0.0f, 0.0f, 1, 8, 1, 0.0f, true));
        this.tail6 = new ModelRenderer((ModelBase)this);
        this.tail6.func_78793_a(0.0f, 8.0f, 0.0f);
        this.tail5.func_78792_a(this.tail6);
        this.setRotationAngle(this.tail6, 0.7854f, 0.0f, 0.0f);
        this.tail6.field_78804_l.add(new ModelBox(this.tail6, 4, 15, -0.5f, 0.0f, 0.0f, 1, 8, 1, 0.0f, true));
        this.backLegL = new ModelRenderer((ModelBase)this);
        this.backLegL.func_78793_a(1.1f, 1.0f, 6.0f);
        this.body.func_78792_a(this.backLegL);
        this.backLegL.field_78804_l.add(new ModelBox(this.backLegL, 8, 13, -1.0f, 0.0f, -1.0f, 2, 6, 2, 0.0f, false));
        this.backLegR = new ModelRenderer((ModelBase)this);
        this.backLegR.func_78793_a(-1.1f, 1.0f, 6.0f);
        this.body.func_78792_a(this.backLegR);
        this.backLegR.field_78804_l.add(new ModelBox(this.backLegR, 8, 13, -1.0f, 0.0f, -1.0f, 2, 6, 2, 0.0f, false));
        this.frontLegL = new ModelRenderer((ModelBase)this);
        this.frontLegL.func_78793_a(1.2f, -3.0f, -5.0f);
        this.body.func_78792_a(this.frontLegL);
        this.frontLegL.field_78804_l.add(new ModelBox(this.frontLegL, 40, 0, -1.0f, -0.2f, -1.0f, 2, 10, 2, 0.0f, false));
        this.frontLegR = new ModelRenderer((ModelBase)this);
        this.frontLegR.func_78793_a(-1.2f, -3.0f, -5.0f);
        this.body.func_78792_a(this.frontLegR);
        this.frontLegR.field_78804_l.add(new ModelBox(this.frontLegR, 40, 0, -1.0f, -0.2f, -1.0f, 2, 10, 2, 0.0f, false));
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
        this.WingL.field_78808_h = 0.45f + 0.45f * Mth.func_76126_a((float)(ageInTicks * 0.2f));
        this.WingL.field_78796_g = -0.2f + 0.25f * Mth.func_76126_a((float)(ageInTicks * 0.1f));
        this.WingR.field_78808_h = -this.WingL.field_78808_h;
        this.WingR.field_78796_g = -this.WingL.field_78796_g;
        this.tail.field_78795_f = 1.25f + 0.3f * Mth.func_76126_a((float)(ageInTicks * 0.2f));
        this.tail2.field_78795_f = 0.1f + 0.3f * Mth.func_76126_a((float)(ageInTicks * 0.1f));
        this.tail3.field_78795_f = 1.25f - 0.3f * Mth.func_76126_a((float)(ageInTicks * 0.2f));
        this.tail4.field_78795_f = 0.1f + 0.3f * Mth.func_76126_a((float)(ageInTicks * 0.1f));
        this.tail5.field_78795_f = 1.25f + 0.3f * Mth.func_76134_b((float)(ageInTicks * 0.2f));
        this.tail6.field_78795_f = 0.1f + 0.3f * Mth.func_76126_a((float)(ageInTicks * 0.1f));
        this.backLegL.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f)) * limbSwingAmount;
        this.backLegR.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f + (float)Math.PI)) * limbSwingAmount;
        this.frontLegL.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f + (float)Math.PI)) * limbSwingAmount;
        this.frontLegR.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f)) * limbSwingAmount;
        this.mouth.field_78795_f = 0.35f + 0.35f * Mth.func_76126_a((float)(ageInTicks * 0.05f));
    }
}

