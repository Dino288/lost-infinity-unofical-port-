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

public class ModelTentaclon
extends ModelBase {
    private final ModelRenderer Mouth1;
    private final ModelRenderer Mouth2;
    private final ModelRenderer Mouth3;
    private final ModelRenderer Mouth4;
    private final ModelRenderer Mouth5;
    private final ModelRenderer Mouth6;
    private final ModelRenderer Mouth7;
    private final ModelRenderer Mouth8;
    private final ModelRenderer Tentacle1;
    private final ModelRenderer body_r1;
    private final ModelRenderer Tentacle2;
    private final ModelRenderer body_r2;
    private final ModelRenderer Tentacle3;
    private final ModelRenderer body_r3;
    private final ModelRenderer Tentacle4;
    private final ModelRenderer body_r4;
    private final ModelRenderer Tentacle5;
    private final ModelRenderer body_r5;
    private final ModelRenderer Tentacle6;
    private final ModelRenderer body_r6;
    private final ModelRenderer bb_main;

    public ModelTentaclon() {
        this.field_78090_t = 128;
        this.field_78089_u = 64;
        this.Mouth1 = new ModelRenderer((ModelBase)this);
        this.Mouth1.func_78793_a(0.5f, 0.0f, 3.0f);
        this.setRotationAngle(this.Mouth1, -0.7854f, 0.0f, 0.0f);
        this.Mouth1.field_78804_l.add(new ModelBox(this.Mouth1, 13, 39, -4.5f, -6.0f, -11.0f, 8, 6, 12, 0.0f, false));
        this.Mouth1.field_78804_l.add(new ModelBox(this.Mouth1, 0, 50, 1.5f, -11.0f, -9.0f, 1, 5, 9, 0.0f, false));
        this.Mouth1.field_78804_l.add(new ModelBox(this.Mouth1, 0, 50, -3.5f, -11.0f, -9.0f, 1, 5, 9, 0.0f, true));
        this.Mouth1.field_78804_l.add(new ModelBox(this.Mouth1, 12, 44, -2.5f, -5.0f, -12.0f, 4, 4, 1, 0.0f, false));
        this.Mouth1.field_78804_l.add(new ModelBox(this.Mouth1, 2, 52, -3.5f, 0.0f, -10.0f, 1, 4, 1, 0.0f, false));
        this.Mouth1.field_78804_l.add(new ModelBox(this.Mouth1, 2, 52, 1.5f, 0.0f, -10.0f, 1, 4, 1, 0.0f, false));
        this.Mouth1.field_78804_l.add(new ModelBox(this.Mouth1, 2, 52, -1.0f, 0.0f, -10.0f, 1, 4, 1, 0.0f, false));
        this.Mouth2 = new ModelRenderer((ModelBase)this);
        this.Mouth2.func_78793_a(3.5f, 4.0f, 3.0f);
        this.setRotationAngle(this.Mouth2, -0.7854f, 0.0f, 1.5708f);
        this.Mouth2.field_78804_l.add(new ModelBox(this.Mouth2, 13, 39, -4.5f, -6.0f, -11.0f, 8, 6, 12, 0.0f, false));
        this.Mouth2.field_78804_l.add(new ModelBox(this.Mouth2, 0, 50, 1.5f, -11.0f, -9.0f, 1, 5, 9, 0.0f, false));
        this.Mouth2.field_78804_l.add(new ModelBox(this.Mouth2, 0, 50, -3.5f, -11.0f, -9.0f, 1, 5, 9, 0.0f, true));
        this.Mouth2.field_78804_l.add(new ModelBox(this.Mouth2, 12, 44, -2.5f, -5.0f, -12.0f, 4, 4, 1, 0.0f, false));
        this.Mouth2.field_78804_l.add(new ModelBox(this.Mouth2, 2, 52, -3.5f, 0.0f, -10.0f, 1, 4, 1, 0.0f, false));
        this.Mouth2.field_78804_l.add(new ModelBox(this.Mouth2, 2, 52, 1.5f, 0.0f, -10.0f, 1, 4, 1, 0.0f, false));
        this.Mouth2.field_78804_l.add(new ModelBox(this.Mouth2, 2, 52, -1.0f, 0.0f, -10.0f, 1, 4, 1, 0.0f, false));
        this.Mouth3 = new ModelRenderer((ModelBase)this);
        this.Mouth3.func_78793_a(-0.5f, 7.0f, 3.0f);
        this.setRotationAngle(this.Mouth3, -0.7854f, 0.0f, -3.1416f);
        this.Mouth3.field_78804_l.add(new ModelBox(this.Mouth3, 13, 39, -4.5f, -6.0f, -11.0f, 8, 6, 12, 0.0f, false));
        this.Mouth3.field_78804_l.add(new ModelBox(this.Mouth3, 0, 50, 1.5f, -11.0f, -9.0f, 1, 5, 9, 0.0f, false));
        this.Mouth3.field_78804_l.add(new ModelBox(this.Mouth3, 0, 50, -3.5f, -11.0f, -9.0f, 1, 5, 9, 0.0f, true));
        this.Mouth3.field_78804_l.add(new ModelBox(this.Mouth3, 12, 44, -2.5f, -5.0f, -12.0f, 4, 4, 1, 0.0f, false));
        this.Mouth3.field_78804_l.add(new ModelBox(this.Mouth3, 2, 52, -3.5f, 0.0f, -10.0f, 1, 4, 1, 0.0f, false));
        this.Mouth3.field_78804_l.add(new ModelBox(this.Mouth3, 2, 52, 1.5f, 0.0f, -10.0f, 1, 4, 1, 0.0f, false));
        this.Mouth3.field_78804_l.add(new ModelBox(this.Mouth3, 2, 52, -1.0f, 0.0f, -10.0f, 1, 4, 1, 0.0f, false));
        this.Mouth4 = new ModelRenderer((ModelBase)this);
        this.Mouth4.func_78793_a(-3.5f, 3.0f, 3.0f);
        this.setRotationAngle(this.Mouth4, -0.7854f, 0.0f, -1.5708f);
        this.Mouth4.field_78804_l.add(new ModelBox(this.Mouth4, 13, 39, -4.5f, -6.0f, -11.0f, 8, 6, 12, 0.0f, false));
        this.Mouth4.field_78804_l.add(new ModelBox(this.Mouth4, 0, 50, 1.5f, -11.0f, -9.0f, 1, 5, 9, 0.0f, false));
        this.Mouth4.field_78804_l.add(new ModelBox(this.Mouth4, 0, 50, -3.5f, -11.0f, -9.0f, 1, 5, 9, 0.0f, true));
        this.Mouth4.field_78804_l.add(new ModelBox(this.Mouth4, 12, 44, -2.5f, -5.0f, -12.0f, 4, 4, 1, 0.0f, false));
        this.Mouth4.field_78804_l.add(new ModelBox(this.Mouth4, 2, 52, -3.5f, 0.0f, -10.0f, 1, 4, 1, 0.0f, false));
        this.Mouth4.field_78804_l.add(new ModelBox(this.Mouth4, 2, 52, 1.5f, 0.0f, -10.0f, 1, 4, 1, 0.0f, false));
        this.Mouth4.field_78804_l.add(new ModelBox(this.Mouth4, 2, 52, -1.0f, 0.0f, -10.0f, 1, 4, 1, 0.0f, false));
        this.Mouth5 = new ModelRenderer((ModelBase)this);
        this.Mouth5.func_78793_a(3.5f, 1.0f, 3.0f);
        this.setRotationAngle(this.Mouth5, -1.5708f, 0.0f, 0.7854f);
        this.Mouth5.field_78804_l.add(new ModelBox(this.Mouth5, 13, 39, -4.5f, -6.0f, -11.0f, 8, 6, 12, 0.0f, false));
        this.Mouth5.field_78804_l.add(new ModelBox(this.Mouth5, 0, 50, 1.5f, -11.0f, -9.0f, 1, 5, 9, 0.0f, false));
        this.Mouth5.field_78804_l.add(new ModelBox(this.Mouth5, 0, 50, -3.5f, -11.0f, -9.0f, 1, 5, 9, 0.0f, true));
        this.Mouth5.field_78804_l.add(new ModelBox(this.Mouth5, 12, 44, -2.5f, -5.0f, -12.0f, 4, 4, 1, 0.0f, false));
        this.Mouth5.field_78804_l.add(new ModelBox(this.Mouth5, 2, 52, -3.5f, 0.0f, -10.0f, 1, 4, 1, 0.0f, false));
        this.Mouth5.field_78804_l.add(new ModelBox(this.Mouth5, 2, 52, 1.5f, 0.0f, -10.0f, 1, 4, 1, 0.0f, false));
        this.Mouth5.field_78804_l.add(new ModelBox(this.Mouth5, 2, 52, -1.0f, 0.0f, -10.0f, 1, 4, 1, 0.0f, false));
        this.Mouth6 = new ModelRenderer((ModelBase)this);
        this.Mouth6.func_78793_a(2.5f, 7.0f, 3.0f);
        this.setRotationAngle(this.Mouth6, -1.5708f, 0.0f, 2.3562f);
        this.Mouth6.field_78804_l.add(new ModelBox(this.Mouth6, 13, 39, -4.5f, -6.0f, -11.0f, 8, 6, 12, 0.0f, false));
        this.Mouth6.field_78804_l.add(new ModelBox(this.Mouth6, 0, 50, 1.5f, -11.0f, -9.0f, 1, 5, 9, 0.0f, false));
        this.Mouth6.field_78804_l.add(new ModelBox(this.Mouth6, 0, 50, -3.5f, -11.0f, -9.0f, 1, 5, 9, 0.0f, true));
        this.Mouth6.field_78804_l.add(new ModelBox(this.Mouth6, 12, 44, -2.5f, -5.0f, -12.0f, 4, 4, 1, 0.0f, false));
        this.Mouth6.field_78804_l.add(new ModelBox(this.Mouth6, 2, 52, -3.5f, 0.0f, -10.0f, 1, 4, 1, 0.0f, false));
        this.Mouth6.field_78804_l.add(new ModelBox(this.Mouth6, 2, 52, 1.5f, 0.0f, -10.0f, 1, 4, 1, 0.0f, false));
        this.Mouth6.field_78804_l.add(new ModelBox(this.Mouth6, 2, 52, -1.0f, 0.0f, -10.0f, 1, 4, 1, 0.0f, false));
        this.Mouth7 = new ModelRenderer((ModelBase)this);
        this.Mouth7.func_78793_a(-3.5f, 7.0f, 3.0f);
        this.setRotationAngle(this.Mouth7, -1.5708f, 0.0f, -2.3562f);
        this.Mouth7.field_78804_l.add(new ModelBox(this.Mouth7, 13, 39, -4.5f, -6.0f, -11.0f, 8, 6, 12, 0.0f, false));
        this.Mouth7.field_78804_l.add(new ModelBox(this.Mouth7, 0, 50, 1.5f, -11.0f, -9.0f, 1, 5, 9, 0.0f, false));
        this.Mouth7.field_78804_l.add(new ModelBox(this.Mouth7, 0, 50, -3.5f, -11.0f, -9.0f, 1, 5, 9, 0.0f, true));
        this.Mouth7.field_78804_l.add(new ModelBox(this.Mouth7, 12, 44, -2.5f, -5.0f, -12.0f, 4, 4, 1, 0.0f, false));
        this.Mouth7.field_78804_l.add(new ModelBox(this.Mouth7, 2, 52, -3.5f, 0.0f, -10.0f, 1, 4, 1, 0.0f, false));
        this.Mouth7.field_78804_l.add(new ModelBox(this.Mouth7, 2, 52, 1.5f, 0.0f, -10.0f, 1, 4, 1, 0.0f, false));
        this.Mouth7.field_78804_l.add(new ModelBox(this.Mouth7, 2, 52, -1.0f, 0.0f, -10.0f, 1, 4, 1, 0.0f, false));
        this.Mouth8 = new ModelRenderer((ModelBase)this);
        this.Mouth8.func_78793_a(-2.5f, 0.0f, 3.0f);
        this.setRotationAngle(this.Mouth8, -1.5708f, 0.0f, -0.7854f);
        this.Mouth8.field_78804_l.add(new ModelBox(this.Mouth8, 13, 39, -4.5f, -6.0f, -11.0f, 8, 6, 12, 0.0f, false));
        this.Mouth8.field_78804_l.add(new ModelBox(this.Mouth8, 0, 50, 1.5f, -11.0f, -9.0f, 1, 5, 9, 0.0f, false));
        this.Mouth8.field_78804_l.add(new ModelBox(this.Mouth8, 0, 50, -3.5f, -11.0f, -9.0f, 1, 5, 9, 0.0f, true));
        this.Mouth8.field_78804_l.add(new ModelBox(this.Mouth8, 12, 44, -2.5f, -5.0f, -12.0f, 4, 4, 1, 0.0f, false));
        this.Mouth8.field_78804_l.add(new ModelBox(this.Mouth8, 2, 52, -3.5f, 0.0f, -10.0f, 1, 4, 1, 0.0f, false));
        this.Mouth8.field_78804_l.add(new ModelBox(this.Mouth8, 2, 52, 1.5f, 0.0f, -10.0f, 1, 4, 1, 0.0f, false));
        this.Mouth8.field_78804_l.add(new ModelBox(this.Mouth8, 2, 52, -1.0f, 0.0f, -10.0f, 1, 4, 1, 0.0f, false));
        this.Tentacle1 = new ModelRenderer((ModelBase)this);
        this.Tentacle1.func_78793_a(4.0f, 8.0f, 17.5f);
        this.Tentacle1.field_78804_l.add(new ModelBox(this.Tentacle1, 66, 0, -3.0f, -3.0f, -0.5f, 6, 6, 25, -1.0f, false));
        this.body_r1 = new ModelRenderer((ModelBase)this);
        this.body_r1.func_78793_a(0.0f, 0.0f, 29.0f);
        this.Tentacle1.func_78792_a(this.body_r1);
        this.setRotationAngle(this.body_r1, -0.1745f, 0.0f, 0.0f);
        this.body_r1.field_78804_l.add(new ModelBox(this.body_r1, 66, 0, -3.0f, -2.0f, -7.5f, 6, 6, 25, -1.5f, false));
        this.Tentacle2 = new ModelRenderer((ModelBase)this);
        this.Tentacle2.func_78793_a(-5.0f, 8.0f, 17.5f);
        this.Tentacle2.field_78804_l.add(new ModelBox(this.Tentacle2, 66, 0, -3.0f, -3.0f, -0.5f, 6, 6, 25, -1.0f, false));
        this.body_r2 = new ModelRenderer((ModelBase)this);
        this.body_r2.func_78793_a(0.0f, 0.0f, 29.0f);
        this.Tentacle2.func_78792_a(this.body_r2);
        this.setRotationAngle(this.body_r2, -0.1745f, 0.0f, 0.0f);
        this.body_r2.field_78804_l.add(new ModelBox(this.body_r2, 66, 0, -3.0f, -2.0f, -7.5f, 6, 6, 25, -1.5f, false));
        this.Tentacle3 = new ModelRenderer((ModelBase)this);
        this.Tentacle3.func_78793_a(2.0f, 3.0f, 17.5f);
        this.Tentacle3.field_78804_l.add(new ModelBox(this.Tentacle3, 66, 0, -3.0f, -3.0f, -0.5f, 6, 6, 25, -1.0f, false));
        this.body_r3 = new ModelRenderer((ModelBase)this);
        this.body_r3.func_78793_a(0.0f, 0.0f, 29.0f);
        this.Tentacle3.func_78792_a(this.body_r3);
        this.setRotationAngle(this.body_r3, -0.1745f, 0.0f, 0.0f);
        this.body_r3.field_78804_l.add(new ModelBox(this.body_r3, 66, 0, -3.0f, -2.0f, -7.5f, 6, 6, 25, -1.5f, false));
        this.Tentacle4 = new ModelRenderer((ModelBase)this);
        this.Tentacle4.func_78793_a(-3.0f, 3.0f, 17.5f);
        this.Tentacle4.field_78804_l.add(new ModelBox(this.Tentacle4, 66, 0, -3.0f, -3.0f, -0.5f, 6, 6, 25, -1.0f, false));
        this.body_r4 = new ModelRenderer((ModelBase)this);
        this.body_r4.func_78793_a(0.0f, 0.0f, 29.0f);
        this.Tentacle4.func_78792_a(this.body_r4);
        this.setRotationAngle(this.body_r4, -0.1745f, 0.0f, 0.0f);
        this.body_r4.field_78804_l.add(new ModelBox(this.body_r4, 66, 0, -3.0f, -2.0f, -7.5f, 6, 6, 25, -1.5f, false));
        this.Tentacle5 = new ModelRenderer((ModelBase)this);
        this.Tentacle5.func_78793_a(-5.0f, -1.0f, 17.5f);
        this.setRotationAngle(this.Tentacle5, 0.0f, 0.0f, -3.1416f);
        this.Tentacle5.field_78804_l.add(new ModelBox(this.Tentacle5, 66, 33, -3.0f, -3.0f, -0.5f, 6, 6, 25, -1.0f, false));
        this.body_r5 = new ModelRenderer((ModelBase)this);
        this.body_r5.func_78793_a(0.0f, 0.0f, 29.0f);
        this.Tentacle5.func_78792_a(this.body_r5);
        this.setRotationAngle(this.body_r5, -0.1745f, 0.0f, 0.0f);
        this.body_r5.field_78804_l.add(new ModelBox(this.body_r5, 66, 33, -3.0f, -2.0f, -7.5f, 6, 6, 25, -1.5f, false));
        this.Tentacle6 = new ModelRenderer((ModelBase)this);
        this.Tentacle6.func_78793_a(5.0f, -1.0f, 17.5f);
        this.setRotationAngle(this.Tentacle6, 0.0f, 0.0f, -3.1416f);
        this.Tentacle6.field_78804_l.add(new ModelBox(this.Tentacle6, 66, 33, -3.0f, -3.0f, -0.5f, 6, 6, 25, -1.0f, false));
        this.body_r6 = new ModelRenderer((ModelBase)this);
        this.body_r6.func_78793_a(0.0f, 0.0f, 29.0f);
        this.Tentacle6.func_78792_a(this.body_r6);
        this.setRotationAngle(this.body_r6, -0.1745f, 0.0f, 0.0f);
        this.body_r6.field_78804_l.add(new ModelBox(this.body_r6, 66, 33, -3.0f, -2.0f, -7.5f, 6, 6, 25, -1.5f, false));
        this.bb_main = new ModelRenderer((ModelBase)this);
        this.bb_main.func_78793_a(0.0f, 24.0f, 0.0f);
        this.bb_main.field_78804_l.add(new ModelBox(this.bb_main, 0, 0, -8.0f, -28.0f, 2.0f, 16, 16, 16, 0.0f, false));
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.Mouth1.func_78785_a(f5);
        this.Mouth2.func_78785_a(f5);
        this.Mouth3.func_78785_a(f5);
        this.Mouth4.func_78785_a(f5);
        this.Mouth5.func_78785_a(f5);
        this.Mouth6.func_78785_a(f5);
        this.Mouth7.func_78785_a(f5);
        this.Mouth8.func_78785_a(f5);
        this.Tentacle1.func_78785_a(f5);
        this.Tentacle2.func_78785_a(f5);
        this.Tentacle3.func_78785_a(f5);
        this.Tentacle4.func_78785_a(f5);
        this.Tentacle5.func_78785_a(f5);
        this.Tentacle6.func_78785_a(f5);
        this.bb_main.func_78785_a(f5);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.Mouth2.field_78795_f = this.Mouth1.field_78795_f = -0.6f + 0.6f * Mth.func_76126_a((float)(ageInTicks * 0.1f));
        this.Mouth3.field_78795_f = this.Mouth1.field_78795_f;
        this.Mouth4.field_78795_f = this.Mouth1.field_78795_f;
        this.Mouth6.field_78795_f = this.Mouth5.field_78795_f = -0.6f - 0.6f * Mth.func_76126_a((float)(ageInTicks * 0.1f));
        this.Mouth7.field_78795_f = this.Mouth5.field_78795_f;
        this.Mouth8.field_78795_f = this.Mouth5.field_78795_f;
        this.Tentacle1.field_78795_f = 0.3f * Mth.func_76126_a((float)(ageInTicks * 0.075f));
        this.Tentacle1.field_78796_g = 0.2f + 0.2f * Mth.func_76126_a((float)(ageInTicks * 0.1f));
        this.Tentacle2.field_78795_f = this.Tentacle1.field_78795_f;
        this.Tentacle2.field_78796_g = -this.Tentacle1.field_78796_g;
        this.Tentacle3.field_78795_f = 0.4f * Mth.func_76134_b((float)(ageInTicks * 0.075f));
        this.Tentacle3.field_78796_g = 0.2f + 0.2f * Mth.func_76134_b((float)(ageInTicks * 0.1f));
        this.Tentacle4.field_78795_f = this.Tentacle3.field_78795_f;
        this.Tentacle4.field_78796_g = -this.Tentacle3.field_78796_g;
        this.Tentacle5.field_78795_f = -0.2f - 0.4f * Mth.func_76126_a((float)(ageInTicks * 0.075f));
        this.Tentacle5.field_78796_g = 0.2f - 0.2f * Mth.func_76126_a((float)(ageInTicks * 0.1f));
        this.Tentacle6.field_78795_f = this.Tentacle5.field_78795_f;
        this.Tentacle6.field_78796_g = -this.Tentacle5.field_78796_g;
    }
}

