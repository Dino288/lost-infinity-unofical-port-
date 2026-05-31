/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelBox
 *  net.minecraft.client.model.ModelRenderer
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.ResourceLocation
 */
package xol.lostinfinity.mob.model.cthulhu;

import net.minecraft.client.model.ModelBox;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import xol.lostinfinity.mob.model.cthulhu.AnimatedModelBase;
import xol.lostinfinity.util.animation.model.IXolModel;
import xol.lostinfinity.util.animation.model.ModelRenderer;

public class ModelCthulhu
extends AnimatedModelBase {
    private static final ResourceLocation ANIMATION = new ResourceLocation("lostinfinity", "animation/cthulhu/cthulhu.json");
    private final ModelRenderer Body_1;
    private final ModelRenderer Body_2;
    private final ModelRenderer Wing_Left_1;
    private final ModelRenderer Wing_Left_2;
    private final ModelRenderer Wing_Right_1;
    private final ModelRenderer Wing_Right_2;
    private final ModelRenderer Arm_Left_1;
    private final ModelRenderer Arm_Left_2;
    private final ModelRenderer Finger_Left_1;
    private final ModelRenderer Finger_Left_2;
    private final ModelRenderer Finger_Left_3;
    private final ModelRenderer Finger_Left_4;
    private final ModelRenderer Arm_Right_1;
    private final ModelRenderer Arm_Right_2;
    private final ModelRenderer Finger_Right_1;
    private final ModelRenderer Finger_Right_2;
    private final ModelRenderer Finger_Right_3;
    private final ModelRenderer Finger_Right_4;
    private final ModelRenderer Body_3;
    private final ModelRenderer Tentacles_Left_1;
    private final ModelRenderer Tentacles_Right_1;
    private final ModelRenderer Head_1;
    private final ModelRenderer head3_r1;
    private final ModelRenderer Head_Tentacle_Left_1;
    private final ModelRenderer Head_Tentacle_Left_2;
    private final ModelRenderer Head_Tentacle_Left_3;
    private final ModelRenderer Head_Tentacle_Left_4;
    private final ModelRenderer Head_Tentacle_Right_3;
    private final ModelRenderer Head_Tentacle_Right_4;
    private final ModelRenderer Head_Tentacle_Right_1;
    private final ModelRenderer Head_Tentacle_Right_2;

    public ModelCthulhu() {
        this.field_78090_t = 512;
        this.field_78089_u = 1024;
        this.Body_1 = new ModelRenderer(this);
        this.Body_1.func_78793_a(0.0f, 29.0f, 0.0f);
        this.Body_1.field_78804_l.add(new ModelBox((net.minecraft.client.model.ModelRenderer)this.Body_1, 0, 400, -32.0f, -71.0f, -30.0f, 64, 71, 49, 0.0f, false));
        this.Body_2 = new ModelRenderer(this);
        this.Body_2.func_78793_a(0.0f, -64.0f, 0.0f);
        this.Body_1.func_78792_a(this.Body_2);
        this.setRotationAngle(this.Body_2, 0.2618f, 0.0f, 0.0f);
        this.Body_2.field_78804_l.add(new ModelBox((net.minecraft.client.model.ModelRenderer)this.Body_2, 0, 526, -42.0f, -72.0f, -34.0f, 84, 72, 72, 0.0f, false));
        this.Wing_Left_1 = new ModelRenderer(this);
        this.Wing_Left_1.func_78793_a(18.0f, -57.0f, 29.0f);
        this.Body_2.func_78792_a(this.Wing_Left_1);
        this.setRotationAngle(this.Wing_Left_1, -0.1317f, 0.0387f, 0.4271f);
        this.Wing_Left_1.field_78804_l.add(new ModelBox((net.minecraft.client.model.ModelRenderer)this.Wing_Left_1, 424, 579, -11.0f, -141.0f, -14.0f, 22, 149, 22, 0.0f, false));
        this.Wing_Left_2 = new ModelRenderer(this);
        this.Wing_Left_2.func_78793_a(1.0f, -133.0f, 0.0f);
        this.Wing_Left_1.func_78792_a(this.Wing_Left_2);
        this.setRotationAngle(this.Wing_Left_2, -1.8442f, 0.1969f, 0.2179f);
        this.Wing_Left_2.field_78804_l.add(new ModelBox((net.minecraft.client.model.ModelRenderer)this.Wing_Left_2, 440, 379, -9.0f, -167.0f, -11.0f, 18, 175, 16, 0.0f, false));
        this.Wing_Left_2.field_78804_l.add(new ModelBox((net.minecraft.client.model.ModelRenderer)this.Wing_Left_2, 0, 0, 0.25f, -199.0f, -8.0f, 0, 249, 142, 0.0f, false));
        this.Wing_Right_1 = new ModelRenderer(this);
        this.Wing_Right_1.func_78793_a(-18.0f, -57.0f, 29.0f);
        this.Body_2.func_78792_a(this.Wing_Right_1);
        this.setRotationAngle(this.Wing_Right_1, -0.1317f, -0.0387f, -0.4271f);
        this.Wing_Right_1.field_78804_l.add(new ModelBox((net.minecraft.client.model.ModelRenderer)this.Wing_Right_1, 424, 579, -11.0f, -141.0f, -14.0f, 22, 149, 22, 0.0f, true));
        this.Wing_Right_2 = new ModelRenderer(this);
        this.Wing_Right_2.func_78793_a(-1.0f, -133.0f, 0.0f);
        this.Wing_Right_1.func_78792_a(this.Wing_Right_2);
        this.setRotationAngle(this.Wing_Right_2, -1.8442f, -0.1969f, -0.2179f);
        this.Wing_Right_2.field_78804_l.add(new ModelBox((net.minecraft.client.model.ModelRenderer)this.Wing_Right_2, 440, 379, -9.0f, -167.0f, -11.0f, 18, 175, 16, 0.0f, true));
        this.Wing_Right_2.field_78804_l.add(new ModelBox((net.minecraft.client.model.ModelRenderer)this.Wing_Right_2, 0, 0, -0.25f, -199.0f, -8.0f, 0, 249, 142, 0.0f, true));
        this.Arm_Left_1 = new ModelRenderer(this);
        this.Arm_Left_1.func_78793_a(41.0f, -62.0f, 27.0f);
        this.Body_2.func_78792_a(this.Arm_Left_1);
        this.Arm_Left_1.field_78804_l.add(new ModelBox((net.minecraft.client.model.ModelRenderer)this.Arm_Left_1, 0, 796, -7.636f, -17.2797f, -21.4969f, 84, 32, 32, 0.0f, false));
        this.Arm_Left_2 = new ModelRenderer(this);
        this.Arm_Left_2.func_78793_a(70.364f, -2.2797f, -4.4969f);
        this.Arm_Left_1.func_78792_a(this.Arm_Left_2);
        this.Arm_Left_2.field_78804_l.add(new ModelBox((net.minecraft.client.model.ModelRenderer)this.Arm_Left_2, 0, 870, 1.0f, -22.0f, -24.0f, 108, 46, 46, 0.0f, false));
        this.Arm_Left_2.field_78804_l.add(new ModelBox((net.minecraft.client.model.ModelRenderer)this.Arm_Left_2, 221, 761, 5.0f, -48.0f, -17.0f, 86, 26, 33, 0.0f, false));
        this.Finger_Left_1 = new ModelRenderer(this);
        this.Finger_Left_1.func_78793_a(105.0f, -17.0f, -18.0f);
        this.Arm_Left_2.func_78792_a(this.Finger_Left_1);
        this.Finger_Left_1.field_78804_l.add(new ModelBox((net.minecraft.client.model.ModelRenderer)this.Finger_Left_1, 256, 719, -5.0f, -8.0f, -7.0f, 54, 14, 14, 0.0f, false));
        this.Finger_Left_1.field_78804_l.add(new ModelBox((net.minecraft.client.model.ModelRenderer)this.Finger_Left_1, 2, 973, 21.0f, -18.0f, 0.25f, 74, 43, 0, 0.0f, false));
        this.Finger_Left_2 = new ModelRenderer(this);
        this.Finger_Left_2.func_78793_a(105.0f, -17.0f, -1.0f);
        this.Arm_Left_2.func_78792_a(this.Finger_Left_2);
        this.Finger_Left_2.field_78804_l.add(new ModelBox((net.minecraft.client.model.ModelRenderer)this.Finger_Left_2, 256, 719, -5.0f, -8.0f, -7.0f, 54, 14, 14, 0.0f, false));
        this.Finger_Left_2.field_78804_l.add(new ModelBox((net.minecraft.client.model.ModelRenderer)this.Finger_Left_2, 2, 973, 21.0f, -18.0f, 0.25f, 74, 43, 0, 0.0f, false));
        this.Finger_Left_3 = new ModelRenderer(this);
        this.Finger_Left_3.func_78793_a(105.0f, -17.0f, 16.0f);
        this.Arm_Left_2.func_78792_a(this.Finger_Left_3);
        this.Finger_Left_3.field_78804_l.add(new ModelBox((net.minecraft.client.model.ModelRenderer)this.Finger_Left_3, 256, 719, -5.0f, -8.0f, -7.0f, 54, 14, 14, 0.0f, false));
        this.Finger_Left_3.field_78804_l.add(new ModelBox((net.minecraft.client.model.ModelRenderer)this.Finger_Left_3, 2, 973, 21.0f, -18.0f, 0.25f, 74, 43, 0, 0.0f, false));
        this.Finger_Left_4 = new ModelRenderer(this);
        this.Finger_Left_4.func_78793_a(98.0f, 10.0f, -31.0f);
        this.Arm_Left_2.func_78792_a(this.Finger_Left_4);
        this.Finger_Left_4.field_78804_l.add(new ModelBox((net.minecraft.client.model.ModelRenderer)this.Finger_Left_4, 256, 719, -5.0f, -8.0f, -7.0f, 54, 14, 14, 0.0f, false));
        this.Finger_Left_4.field_78804_l.add(new ModelBox((net.minecraft.client.model.ModelRenderer)this.Finger_Left_4, 2, 973, 21.0f, -18.0f, 0.25f, 74, 43, 0, 0.0f, false));
        this.Arm_Right_1 = new ModelRenderer(this);
        this.Arm_Right_1.func_78793_a(-41.0f, -62.0f, 27.0f);
        this.Body_2.func_78792_a(this.Arm_Right_1);
        this.Arm_Right_1.field_78804_l.add(new ModelBox((net.minecraft.client.model.ModelRenderer)this.Arm_Right_1, 0, 796, -76.364f, -17.2797f, -21.4969f, 84, 32, 32, 0.0f, true));
        this.Arm_Right_2 = new ModelRenderer(this);
        this.Arm_Right_2.func_78793_a(-70.364f, -2.2797f, -4.4969f);
        this.Arm_Right_1.func_78792_a(this.Arm_Right_2);
        this.Arm_Right_2.field_78804_l.add(new ModelBox((net.minecraft.client.model.ModelRenderer)this.Arm_Right_2, 0, 870, -109.0f, -22.0f, -24.0f, 108, 46, 46, 0.0f, true));
        this.Arm_Right_2.field_78804_l.add(new ModelBox((net.minecraft.client.model.ModelRenderer)this.Arm_Right_2, 221, 761, -91.0f, -48.0f, -17.0f, 86, 26, 33, 0.0f, true));
        this.Finger_Right_1 = new ModelRenderer(this);
        this.Finger_Right_1.func_78793_a(-105.0f, -17.0f, -18.0f);
        this.Arm_Right_2.func_78792_a(this.Finger_Right_1);
        this.Finger_Right_1.field_78804_l.add(new ModelBox((net.minecraft.client.model.ModelRenderer)this.Finger_Right_1, 256, 719, -49.0f, -8.0f, -7.0f, 54, 14, 14, 0.0f, true));
        this.Finger_Right_1.field_78804_l.add(new ModelBox((net.minecraft.client.model.ModelRenderer)this.Finger_Right_1, 2, 973, -95.0f, -18.0f, 0.25f, 74, 43, 0, 0.0f, true));
        this.Finger_Right_2 = new ModelRenderer(this);
        this.Finger_Right_2.func_78793_a(-105.0f, -17.0f, -1.0f);
        this.Arm_Right_2.func_78792_a(this.Finger_Right_2);
        this.Finger_Right_2.field_78804_l.add(new ModelBox((net.minecraft.client.model.ModelRenderer)this.Finger_Right_2, 256, 719, -49.0f, -8.0f, -7.0f, 54, 14, 14, 0.0f, true));
        this.Finger_Right_2.field_78804_l.add(new ModelBox((net.minecraft.client.model.ModelRenderer)this.Finger_Right_2, 2, 973, -95.0f, -18.0f, 0.25f, 74, 43, 0, 0.0f, true));
        this.Finger_Right_3 = new ModelRenderer(this);
        this.Finger_Right_3.func_78793_a(-105.0f, -17.0f, 16.0f);
        this.Arm_Right_2.func_78792_a(this.Finger_Right_3);
        this.Finger_Right_3.field_78804_l.add(new ModelBox((net.minecraft.client.model.ModelRenderer)this.Finger_Right_3, 256, 719, -49.0f, -8.0f, -7.0f, 54, 14, 14, 0.0f, true));
        this.Finger_Right_3.field_78804_l.add(new ModelBox((net.minecraft.client.model.ModelRenderer)this.Finger_Right_3, 2, 973, -95.0f, -18.0f, 0.25f, 74, 43, 0, 0.0f, true));
        this.Finger_Right_4 = new ModelRenderer(this);
        this.Finger_Right_4.func_78793_a(-98.0f, 10.0f, -31.0f);
        this.Arm_Right_2.func_78792_a(this.Finger_Right_4);
        this.Finger_Right_4.field_78804_l.add(new ModelBox((net.minecraft.client.model.ModelRenderer)this.Finger_Right_4, 256, 719, -49.0f, -8.0f, -7.0f, 54, 14, 14, 0.0f, true));
        this.Finger_Right_4.field_78804_l.add(new ModelBox((net.minecraft.client.model.ModelRenderer)this.Finger_Right_4, 2, 973, -95.0f, -18.0f, 0.25f, 74, 43, 0, 0.0f, true));
        this.Body_3 = new ModelRenderer(this);
        this.Body_3.func_78793_a(0.0f, -59.75f, 2.25f);
        this.Body_2.func_78792_a(this.Body_3);
        this.setRotationAngle(this.Body_3, 0.3927f, 0.0f, 0.0f);
        this.Body_3.field_78804_l.add(new ModelBox((net.minecraft.client.model.ModelRenderer)this.Body_3, 0, 680, -34.0f, -48.0f, -31.0f, 68, 48, 53, 0.0f, false));
        this.Tentacles_Left_1 = new ModelRenderer(this);
        this.Tentacles_Left_1.func_78793_a(32.0f, -48.0f, -6.0f);
        this.Body_3.func_78792_a(this.Tentacles_Left_1);
        this.setRotationAngle(this.Tentacles_Left_1, 0.0f, 0.0f, 0.7854f);
        this.Tentacles_Left_1.field_78804_l.add(new ModelBox((net.minecraft.client.model.ModelRenderer)this.Tentacles_Left_1, 254, 489, 0.0f, -48.0f, -25.0f, 0, 48, 53, 0.0f, false));
        this.Tentacles_Right_1 = new ModelRenderer(this);
        this.Tentacles_Right_1.func_78793_a(-32.0f, -48.0f, -6.0f);
        this.Body_3.func_78792_a(this.Tentacles_Right_1);
        this.setRotationAngle(this.Tentacles_Right_1, 0.0f, 0.0f, -0.7854f);
        this.Tentacles_Right_1.field_78804_l.add(new ModelBox((net.minecraft.client.model.ModelRenderer)this.Tentacles_Right_1, 254, 489, 0.0f, -48.0f, -25.0f, 0, 48, 53, 0.0f, true));
        this.Head_1 = new ModelRenderer(this);
        this.Head_1.func_78793_a(0.0f, -39.0f, -25.0f);
        this.Body_3.func_78792_a(this.Head_1);
        this.setRotationAngle(this.Head_1, 0.7854f, 0.0f, 0.0f);
        this.Head_1.field_78804_l.add(new ModelBox((net.minecraft.client.model.ModelRenderer)this.Head_1, 275, 829, -19.0f, -19.0f, -37.0f, 38, 20, 62, 0.0f, false));
        this.head3_r1 = new ModelRenderer(this);
        this.head3_r1.func_78793_a(0.0f, -19.0f, -37.0f);
        this.Head_1.func_78792_a(this.head3_r1);
        this.setRotationAngle(this.head3_r1, 0.3927f, 0.0f, 0.0f);
        this.head3_r1.field_78804_l.add(new ModelBox((net.minecraft.client.model.ModelRenderer)this.head3_r1, 333, 650, -9.0f, 0.0f, -30.0f, 18, 10, 11, 0.0f, false));
        this.head3_r1.field_78804_l.add(new ModelBox((net.minecraft.client.model.ModelRenderer)this.head3_r1, 333, 617, -9.0f, 0.0f, -19.0f, 18, 10, 19, 0.0f, false));
        this.Head_Tentacle_Left_1 = new ModelRenderer(this);
        this.Head_Tentacle_Left_1.func_78793_a(17.0f, -10.0f, -16.0f);
        this.Head_1.func_78792_a(this.Head_Tentacle_Left_1);
        this.setRotationAngle(this.Head_Tentacle_Left_1, 0.0f, 0.7854f, 0.0f);
        this.Head_Tentacle_Left_1.field_78804_l.add(new ModelBox((net.minecraft.client.model.ModelRenderer)this.Head_Tentacle_Left_1, 205, 689, -3.0f, -5.0f, -6.0f, 25, 12, 12, 0.0f, false));
        this.Head_Tentacle_Left_2 = new ModelRenderer(this);
        this.Head_Tentacle_Left_2.func_78793_a(22.0f, 0.0f, 0.0f);
        this.Head_Tentacle_Left_1.func_78792_a(this.Head_Tentacle_Left_2);
        this.setRotationAngle(this.Head_Tentacle_Left_2, 0.1388f, 0.2383f, 0.3561f);
        this.Head_Tentacle_Left_2.field_78804_l.add(new ModelBox((net.minecraft.client.model.ModelRenderer)this.Head_Tentacle_Left_2, 289, 691, -6.0f, -3.0f, -4.0f, 34, 8, 8, 0.0f, false));
        this.Head_Tentacle_Left_3 = new ModelRenderer(this);
        this.Head_Tentacle_Left_3.func_78793_a(13.0f, -7.0f, -30.0f);
        this.Head_1.func_78792_a(this.Head_Tentacle_Left_3);
        this.setRotationAngle(this.Head_Tentacle_Left_3, 0.2074f, 1.169f, 0.2248f);
        this.Head_Tentacle_Left_3.field_78804_l.add(new ModelBox((net.minecraft.client.model.ModelRenderer)this.Head_Tentacle_Left_3, 205, 689, -3.0f, -5.0f, -6.0f, 25, 12, 12, 0.0f, false));
        this.Head_Tentacle_Left_4 = new ModelRenderer(this);
        this.Head_Tentacle_Left_4.func_78793_a(22.0f, 0.0f, 0.0f);
        this.Head_Tentacle_Left_3.func_78792_a(this.Head_Tentacle_Left_4);
        this.setRotationAngle(this.Head_Tentacle_Left_4, 0.1189f, 0.2437f, 0.3123f);
        this.Head_Tentacle_Left_4.field_78804_l.add(new ModelBox((net.minecraft.client.model.ModelRenderer)this.Head_Tentacle_Left_4, 289, 691, -6.0f, -3.0f, -4.0f, 34, 8, 8, 0.0f, false));
        this.Head_Tentacle_Right_3 = new ModelRenderer(this);
        this.Head_Tentacle_Right_3.func_78793_a(-13.0f, -7.0f, -30.0f);
        this.Head_1.func_78792_a(this.Head_Tentacle_Right_3);
        this.setRotationAngle(this.Head_Tentacle_Right_3, 0.2074f, -1.169f, -0.2248f);
        this.Head_Tentacle_Right_3.field_78804_l.add(new ModelBox((net.minecraft.client.model.ModelRenderer)this.Head_Tentacle_Right_3, 205, 689, -22.0f, -5.0f, -6.0f, 25, 12, 12, 0.0f, true));
        this.Head_Tentacle_Right_4 = new ModelRenderer(this);
        this.Head_Tentacle_Right_4.func_78793_a(-22.0f, 0.0f, 0.0f);
        this.Head_Tentacle_Right_3.func_78792_a(this.Head_Tentacle_Right_4);
        this.setRotationAngle(this.Head_Tentacle_Right_4, 0.1351f, -0.2382f, -0.3564f);
        this.Head_Tentacle_Right_4.field_78804_l.add(new ModelBox((net.minecraft.client.model.ModelRenderer)this.Head_Tentacle_Right_4, 289, 691, -28.0f, -3.0f, -4.0f, 34, 8, 8, 0.0f, true));
        this.Head_Tentacle_Right_1 = new ModelRenderer(this);
        this.Head_Tentacle_Right_1.func_78793_a(-17.0f, -10.0f, -16.0f);
        this.Head_1.func_78792_a(this.Head_Tentacle_Right_1);
        this.setRotationAngle(this.Head_Tentacle_Right_1, 0.0f, -0.7854f, 0.0f);
        this.Head_Tentacle_Right_1.field_78804_l.add(new ModelBox((net.minecraft.client.model.ModelRenderer)this.Head_Tentacle_Right_1, 205, 689, -22.0f, -5.0f, -6.0f, 25, 12, 12, 0.0f, true));
        this.Head_Tentacle_Right_2 = new ModelRenderer(this);
        this.Head_Tentacle_Right_2.func_78793_a(-22.0f, 0.0f, 0.0f);
        this.Head_Tentacle_Right_1.func_78792_a(this.Head_Tentacle_Right_2);
        this.setRotationAngle(this.Head_Tentacle_Right_2, 0.1351f, -0.2382f, -0.3564f);
        this.Head_Tentacle_Right_2.field_78804_l.add(new ModelBox((net.minecraft.client.model.ModelRenderer)this.Head_Tentacle_Right_2, 289, 691, -28.0f, -3.0f, -4.0f, 34, 8, 8, 0.0f, true));
        IXolModel.initializeModel(this);
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.animate(entity);
        this.Body_1.func_78785_a(f5);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    @Override
    public ResourceLocation getAnimationJson() {
        return ANIMATION;
    }
}

