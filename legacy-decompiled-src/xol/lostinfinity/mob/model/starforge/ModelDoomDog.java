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
package xol.lostinfinity.mob.model.starforge;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;

public class ModelDoomDog
extends ModelBase {
    private final ModelRenderer head;
    private final ModelRenderer angler1;
    private final ModelRenderer angler1_r1;
    private final ModelRenderer angler2_r1;
    private final ModelRenderer angler4_r1;
    private final ModelRenderer angler2;
    private final ModelRenderer angler2_r2;
    private final ModelRenderer angler3_r1;
    private final ModelRenderer angler5_r1;
    private final ModelRenderer angler3;
    private final ModelRenderer angler3_r2;
    private final ModelRenderer angler4_r2;
    private final ModelRenderer angler6_r1;
    private final ModelRenderer mouth;
    private final ModelRenderer tooth4_r1;
    private final ModelRenderer body;
    private final ModelRenderer backcrystal_r1;
    private final ModelRenderer leg_front_left;
    private final ModelRenderer leg_front_left_r1;
    private final ModelRenderer leg_back_left;
    private final ModelRenderer leg_front_left_r2;
    private final ModelRenderer leg_front_right;
    private final ModelRenderer leg_front_left_r3;
    private final ModelRenderer leg_back_right;
    private final ModelRenderer leg_front_left_r4;

    public ModelDoomDog() {
        this.field_78090_t = 128;
        this.field_78089_u = 64;
        this.head = new ModelRenderer((ModelBase)this);
        this.head.func_78793_a(0.0f, 9.0f, -7.0f);
        this.head.field_78804_l.add(new ModelBox(this.head, 60, 7, -5.0f, -4.0f, -11.0f, 10, 5, 12, 0.0f, false));
        this.head.field_78804_l.add(new ModelBox(this.head, 92, 15, -3.0f, -6.0f, -11.0f, 6, 2, 12, 0.0f, false));
        this.angler1 = new ModelRenderer((ModelBase)this);
        this.angler1.func_78793_a(0.0f, -5.0f, -3.0f);
        this.head.func_78792_a(this.angler1);
        this.angler1.field_78804_l.add(new ModelBox(this.angler1, 95, 53, -1.0f, -5.5f, -10.0f, 2, 2, 3, -0.2f, false));
        this.angler1_r1 = new ModelRenderer((ModelBase)this);
        this.angler1_r1.func_78793_a(0.0f, -3.0f, -2.0f);
        this.angler1.func_78792_a(this.angler1_r1);
        this.setRotationAngle(this.angler1_r1, -0.5236f, 0.0f, 0.0f);
        this.angler1_r1.field_78804_l.add(new ModelBox(this.angler1_r1, 69, 52, -1.0f, 0.0f, -3.0f, 2, 2, 8, 0.0f, false));
        this.angler2_r1 = new ModelRenderer((ModelBase)this);
        this.angler2_r1.func_78793_a(0.0f, -3.0f, -2.0f);
        this.angler1.func_78792_a(this.angler2_r1);
        this.setRotationAngle(this.angler2_r1, -0.3491f, 0.0f, 0.0f);
        this.angler2_r1.field_78804_l.add(new ModelBox(this.angler2_r1, 82, 53, -1.0f, -0.5f, -6.0f, 2, 2, 3, -0.1f, false));
        this.angler4_r1 = new ModelRenderer((ModelBase)this);
        this.angler4_r1.func_78793_a(0.0f, -3.0f, -2.0f);
        this.angler1.func_78792_a(this.angler4_r1);
        this.setRotationAngle(this.angler4_r1, 0.3491f, 0.0f, 0.0f);
        this.angler4_r1.field_78804_l.add(new ModelBox(this.angler4_r1, 89, 47, -1.0f, -5.0f, -9.0f, 2, 2, 3, -0.3f, false));
        this.angler4_r1.field_78804_l.add(new ModelBox(this.angler4_r1, 107, 55, -2.0f, -6.0f, -12.0f, 4, 4, 4, -0.4f, false));
        this.angler2 = new ModelRenderer((ModelBase)this);
        this.angler2.func_78793_a(4.0f, -3.0f, -2.0f);
        this.head.func_78792_a(this.angler2);
        this.setRotationAngle(this.angler2, 0.0f, 0.0f, 0.9599f);
        this.angler2.field_78804_l.add(new ModelBox(this.angler2, 95, 53, -1.0f, -5.5f, -10.0f, 2, 2, 3, -0.2f, false));
        this.angler2_r2 = new ModelRenderer((ModelBase)this);
        this.angler2_r2.func_78793_a(0.0f, -3.0f, -2.0f);
        this.angler2.func_78792_a(this.angler2_r2);
        this.setRotationAngle(this.angler2_r2, -0.5236f, 0.0f, 0.0f);
        this.angler2_r2.field_78804_l.add(new ModelBox(this.angler2_r2, 69, 52, -1.0f, 0.0f, -3.0f, 2, 2, 8, 0.0f, false));
        this.angler3_r1 = new ModelRenderer((ModelBase)this);
        this.angler3_r1.func_78793_a(0.0f, -3.0f, -2.0f);
        this.angler2.func_78792_a(this.angler3_r1);
        this.setRotationAngle(this.angler3_r1, -0.3491f, 0.0f, 0.0f);
        this.angler3_r1.field_78804_l.add(new ModelBox(this.angler3_r1, 82, 53, -1.0f, -0.5f, -6.0f, 2, 2, 3, -0.1f, false));
        this.angler5_r1 = new ModelRenderer((ModelBase)this);
        this.angler5_r1.func_78793_a(0.0f, -3.0f, -2.0f);
        this.angler2.func_78792_a(this.angler5_r1);
        this.setRotationAngle(this.angler5_r1, 0.3491f, 0.0f, 0.0f);
        this.angler5_r1.field_78804_l.add(new ModelBox(this.angler5_r1, 89, 47, -1.0f, -5.0f, -9.0f, 2, 2, 3, -0.3f, false));
        this.angler5_r1.field_78804_l.add(new ModelBox(this.angler5_r1, 107, 55, -2.0f, -6.0f, -12.0f, 4, 4, 4, -0.4f, false));
        this.angler3 = new ModelRenderer((ModelBase)this);
        this.angler3.func_78793_a(-4.0f, -3.0f, -2.0f);
        this.head.func_78792_a(this.angler3);
        this.setRotationAngle(this.angler3, 0.0f, 0.0f, -0.9599f);
        this.angler3.field_78804_l.add(new ModelBox(this.angler3, 95, 53, -1.0f, -5.5f, -10.0f, 2, 2, 3, -0.2f, true));
        this.angler3_r2 = new ModelRenderer((ModelBase)this);
        this.angler3_r2.func_78793_a(0.0f, -3.0f, -2.0f);
        this.angler3.func_78792_a(this.angler3_r2);
        this.setRotationAngle(this.angler3_r2, -0.5236f, 0.0f, 0.0f);
        this.angler3_r2.field_78804_l.add(new ModelBox(this.angler3_r2, 69, 52, -1.0f, 0.0f, -3.0f, 2, 2, 8, 0.0f, true));
        this.angler4_r2 = new ModelRenderer((ModelBase)this);
        this.angler4_r2.func_78793_a(0.0f, -3.0f, -2.0f);
        this.angler3.func_78792_a(this.angler4_r2);
        this.setRotationAngle(this.angler4_r2, -0.3491f, 0.0f, 0.0f);
        this.angler4_r2.field_78804_l.add(new ModelBox(this.angler4_r2, 82, 53, -1.0f, -0.5f, -6.0f, 2, 2, 3, -0.1f, true));
        this.angler6_r1 = new ModelRenderer((ModelBase)this);
        this.angler6_r1.func_78793_a(0.0f, -3.0f, -2.0f);
        this.angler3.func_78792_a(this.angler6_r1);
        this.setRotationAngle(this.angler6_r1, 0.3491f, 0.0f, 0.0f);
        this.angler6_r1.field_78804_l.add(new ModelBox(this.angler6_r1, 89, 47, -1.0f, -5.0f, -9.0f, 2, 2, 3, -0.3f, true));
        this.angler6_r1.field_78804_l.add(new ModelBox(this.angler6_r1, 107, 55, -2.0f, -6.0f, -12.0f, 4, 4, 4, -0.4f, true));
        this.mouth = new ModelRenderer((ModelBase)this);
        this.mouth.func_78793_a(0.0f, 0.5f, -1.0f);
        this.head.func_78792_a(this.mouth);
        this.tooth4_r1 = new ModelRenderer((ModelBase)this);
        this.tooth4_r1.func_78793_a(0.0f, 0.0f, 0.0f);
        this.mouth.func_78792_a(this.tooth4_r1);
        this.setRotationAngle(this.tooth4_r1, 0.2182f, 0.0f, 0.0f);
        this.tooth4_r1.field_78804_l.add(new ModelBox(this.tooth4_r1, 99, 12, -0.5f, -1.5f, -10.1f, 1, 4, 1, 0.0f, false));
        this.tooth4_r1.field_78804_l.add(new ModelBox(this.tooth4_r1, 99, 12, -2.0f, -1.5f, -10.1f, 1, 4, 1, 0.0f, false));
        this.tooth4_r1.field_78804_l.add(new ModelBox(this.tooth4_r1, 99, 12, 1.0f, -1.5f, -10.1f, 1, 4, 1, 0.0f, false));
        this.tooth4_r1.field_78804_l.add(new ModelBox(this.tooth4_r1, 94, 11, 2.8f, -2.5f, -10.1f, 1, 5, 1, 0.0f, false));
        this.tooth4_r1.field_78804_l.add(new ModelBox(this.tooth4_r1, 74, 31, -4.0f, 0.5f, -10.0f, 8, 3, 12, 0.0f, false));
        this.tooth4_r1.field_78804_l.add(new ModelBox(this.tooth4_r1, 94, 11, -3.8f, -2.5f, -10.1f, 1, 5, 1, 0.0f, false));
        this.body = new ModelRenderer((ModelBase)this);
        this.body.func_78793_a(0.0f, 10.0f, -3.0f);
        this.body.field_78804_l.add(new ModelBox(this.body, 1, 1, -8.0f, -6.0f, -4.0f, 16, 14, 26, 0.02f, false));
        this.backcrystal_r1 = new ModelRenderer((ModelBase)this);
        this.backcrystal_r1.func_78793_a(0.0f, -9.0f, 3.0f);
        this.body.func_78792_a(this.backcrystal_r1);
        this.setRotationAngle(this.backcrystal_r1, 0.0f, 0.0f, 0.7854f);
        this.backcrystal_r1.field_78804_l.add(new ModelBox(this.backcrystal_r1, 1, 1, -1.0f, -1.0f, 12.0f, 6, 6, 6, 0.0f, false));
        this.backcrystal_r1.field_78804_l.add(new ModelBox(this.backcrystal_r1, 1, 1, -1.0f, -1.0f, 4.0f, 6, 6, 6, 0.0f, false));
        this.backcrystal_r1.field_78804_l.add(new ModelBox(this.backcrystal_r1, 1, 1, -1.0f, -1.0f, -4.0f, 6, 6, 6, 0.0f, false));
        this.leg_front_left = new ModelRenderer((ModelBase)this);
        this.leg_front_left.func_78793_a(8.0f, 9.0f, -3.0f);
        this.leg_front_left_r1 = new ModelRenderer((ModelBase)this);
        this.leg_front_left_r1.func_78793_a(-6.0f, 12.0f, 3.0f);
        this.leg_front_left.func_78792_a(this.leg_front_left_r1);
        this.setRotationAngle(this.leg_front_left_r1, 0.0f, 0.0f, -0.5236f);
        this.leg_front_left_r1.field_78804_l.add(new ModelBox(this.leg_front_left_r1, 23, 53, 7.0f, 6.0f, -2.0f, 1, 3, 1, 0.0f, false));
        this.leg_front_left_r1.field_78804_l.add(new ModelBox(this.leg_front_left_r1, 17, 45, 15.0f, 6.0f, -2.0f, 1, 7, 1, 0.0f, false));
        this.leg_front_left_r1.field_78804_l.add(new ModelBox(this.leg_front_left_r1, 17, 45, 15.0f, 6.0f, -5.0f, 1, 7, 1, 0.0f, false));
        this.leg_front_left_r1.field_78804_l.add(new ModelBox(this.leg_front_left_r1, 23, 53, 7.0f, 6.0f, -5.0f, 1, 3, 1, 0.0f, false));
        this.leg_front_left_r1.field_78804_l.add(new ModelBox(this.leg_front_left_r1, 2, 55, 7.0f, 3.0f, -5.0f, 7, 3, 4, 0.0f, false));
        this.leg_front_left_r1.field_78804_l.add(new ModelBox(this.leg_front_left_r1, 25, 54, 9.0f, -8.0f, -5.0f, 5, 4, 4, 0.0f, false));
        this.leg_front_left_r1.field_78804_l.add(new ModelBox(this.leg_front_left_r1, 44, 42, 14.0f, -8.0f, -6.0f, 6, 14, 6, 0.0f, false));
        this.leg_back_left = new ModelRenderer((ModelBase)this);
        this.leg_back_left.func_78793_a(8.0f, 9.0f, 15.0f);
        this.leg_front_left_r2 = new ModelRenderer((ModelBase)this);
        this.leg_front_left_r2.func_78793_a(-6.0f, 12.0f, 3.0f);
        this.leg_back_left.func_78792_a(this.leg_front_left_r2);
        this.setRotationAngle(this.leg_front_left_r2, 0.0f, 0.0f, -0.5236f);
        this.leg_front_left_r2.field_78804_l.add(new ModelBox(this.leg_front_left_r2, 23, 53, 7.0f, 6.0f, -2.0f, 1, 3, 1, 0.0f, false));
        this.leg_front_left_r2.field_78804_l.add(new ModelBox(this.leg_front_left_r2, 17, 45, 15.0f, 6.0f, -2.0f, 1, 7, 1, 0.0f, false));
        this.leg_front_left_r2.field_78804_l.add(new ModelBox(this.leg_front_left_r2, 17, 45, 15.0f, 6.0f, -5.0f, 1, 7, 1, 0.0f, false));
        this.leg_front_left_r2.field_78804_l.add(new ModelBox(this.leg_front_left_r2, 23, 53, 7.0f, 6.0f, -5.0f, 1, 3, 1, 0.0f, false));
        this.leg_front_left_r2.field_78804_l.add(new ModelBox(this.leg_front_left_r2, 2, 55, 7.0f, 3.0f, -5.0f, 7, 3, 4, 0.0f, false));
        this.leg_front_left_r2.field_78804_l.add(new ModelBox(this.leg_front_left_r2, 25, 54, 9.0f, -8.0f, -5.0f, 5, 4, 4, 0.0f, false));
        this.leg_front_left_r2.field_78804_l.add(new ModelBox(this.leg_front_left_r2, 44, 42, 14.0f, -8.0f, -6.0f, 6, 14, 6, 0.0f, false));
        this.leg_front_right = new ModelRenderer((ModelBase)this);
        this.leg_front_right.func_78793_a(-8.0f, 9.0f, -3.0f);
        this.leg_front_left_r3 = new ModelRenderer((ModelBase)this);
        this.leg_front_left_r3.func_78793_a(6.0f, 12.0f, 3.0f);
        this.leg_front_right.func_78792_a(this.leg_front_left_r3);
        this.setRotationAngle(this.leg_front_left_r3, 0.0f, 0.0f, 0.5236f);
        this.leg_front_left_r3.field_78804_l.add(new ModelBox(this.leg_front_left_r3, 23, 53, -8.0f, 6.0f, -2.0f, 1, 3, 1, 0.0f, true));
        this.leg_front_left_r3.field_78804_l.add(new ModelBox(this.leg_front_left_r3, 17, 45, -16.0f, 6.0f, -2.0f, 1, 7, 1, 0.0f, true));
        this.leg_front_left_r3.field_78804_l.add(new ModelBox(this.leg_front_left_r3, 17, 45, -16.0f, 6.0f, -5.0f, 1, 7, 1, 0.0f, true));
        this.leg_front_left_r3.field_78804_l.add(new ModelBox(this.leg_front_left_r3, 23, 53, -8.0f, 6.0f, -5.0f, 1, 3, 1, 0.0f, true));
        this.leg_front_left_r3.field_78804_l.add(new ModelBox(this.leg_front_left_r3, 2, 55, -14.0f, 3.0f, -5.0f, 7, 3, 4, 0.0f, true));
        this.leg_front_left_r3.field_78804_l.add(new ModelBox(this.leg_front_left_r3, 25, 54, -14.0f, -8.0f, -5.0f, 5, 4, 4, 0.0f, true));
        this.leg_front_left_r3.field_78804_l.add(new ModelBox(this.leg_front_left_r3, 44, 42, -20.0f, -8.0f, -6.0f, 6, 14, 6, 0.0f, true));
        this.leg_back_right = new ModelRenderer((ModelBase)this);
        this.leg_back_right.func_78793_a(-8.0f, 9.0f, 15.0f);
        this.leg_front_left_r4 = new ModelRenderer((ModelBase)this);
        this.leg_front_left_r4.func_78793_a(6.0f, 12.0f, 3.0f);
        this.leg_back_right.func_78792_a(this.leg_front_left_r4);
        this.setRotationAngle(this.leg_front_left_r4, 0.0f, 0.0f, 0.5236f);
        this.leg_front_left_r4.field_78804_l.add(new ModelBox(this.leg_front_left_r4, 23, 53, -8.0f, 6.0f, -2.0f, 1, 3, 1, 0.0f, true));
        this.leg_front_left_r4.field_78804_l.add(new ModelBox(this.leg_front_left_r4, 17, 45, -16.0f, 6.0f, -2.0f, 1, 7, 1, 0.0f, true));
        this.leg_front_left_r4.field_78804_l.add(new ModelBox(this.leg_front_left_r4, 17, 45, -16.0f, 6.0f, -5.0f, 1, 7, 1, 0.0f, true));
        this.leg_front_left_r4.field_78804_l.add(new ModelBox(this.leg_front_left_r4, 23, 53, -8.0f, 6.0f, -5.0f, 1, 3, 1, 0.0f, true));
        this.leg_front_left_r4.field_78804_l.add(new ModelBox(this.leg_front_left_r4, 2, 55, -14.0f, 3.0f, -5.0f, 7, 3, 4, 0.0f, true));
        this.leg_front_left_r4.field_78804_l.add(new ModelBox(this.leg_front_left_r4, 25, 54, -14.0f, -8.0f, -5.0f, 5, 4, 4, 0.0f, true));
        this.leg_front_left_r4.field_78804_l.add(new ModelBox(this.leg_front_left_r4, 44, 42, -20.0f, -8.0f, -6.0f, 6, 14, 6, 0.0f, true));
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        GlStateManager.func_179147_l();
        GlStateManager.func_179112_b((int)770, (int)771);
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)(0.8f + (float)Math.sin((double)f2 * 0.05)));
        this.head.func_78785_a(f5);
        this.body.func_78785_a(f5);
        this.leg_front_left.func_78785_a(f5);
        this.leg_back_left.func_78785_a(f5);
        this.leg_front_right.func_78785_a(f5);
        this.leg_back_right.func_78785_a(f5);
        GlStateManager.func_179084_k();
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.head.field_78796_g = netHeadYaw * ((float)Math.PI / 180);
        this.head.field_78795_f = headPitch * ((float)Math.PI / 180);
        this.mouth.field_78795_f = Mth.func_76134_b((float)(ageInTicks * 0.05f)) * 0.35f + 0.2f;
        this.leg_back_right.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.2662f)) * 0.5f * limbSwingAmount;
        this.leg_back_left.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.2662f + (float)Math.PI)) * 0.5f * limbSwingAmount;
        this.leg_front_right.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.2662f + (float)Math.PI)) * 0.5f * limbSwingAmount;
        this.leg_front_left.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.2662f)) * 0.5f * limbSwingAmount;
        this.angler1.field_78795_f = 0.15f * Mth.func_76126_a((float)(ageInTicks * 0.1f));
        this.angler2.field_78795_f = 0.15f * Mth.func_76126_a((float)((ageInTicks + 30.0f) * 0.1f));
        this.angler3.field_78795_f = 0.15f * Mth.func_76126_a((float)((ageInTicks + 60.0f) * 0.1f));
    }
}

