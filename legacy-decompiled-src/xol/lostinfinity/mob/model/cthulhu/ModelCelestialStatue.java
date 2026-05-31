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

public class ModelCelestialStatue
extends AnimatedModelBase {
    private static final ResourceLocation ANIMATION = new ResourceLocation("lostinfinity", "animation/cthulhu/celestial_statue.json");
    private final ModelRenderer Body_1;
    private final ModelRenderer Body_2;
    private final ModelRenderer Head;
    private final ModelRenderer Armleft_Shoulder;
    private final ModelRenderer Armleft_1;
    private final ModelRenderer Armleft_2;
    private final ModelRenderer Armleft_3;
    private final ModelRenderer Finger_Left_1;
    private final ModelRenderer Finger_Left_2;
    private final ModelRenderer Finger_Left_3;
    private final ModelRenderer Finger_Left_4;
    private final ModelRenderer Finger_Left_5;
    private final ModelRenderer Armright_Shoulder;
    private final ModelRenderer Armright_1;
    private final ModelRenderer Armright_2;
    private final ModelRenderer Armright_3;
    private final ModelRenderer Finger_Right_1;
    private final ModelRenderer Finger_Right_2;
    private final ModelRenderer Finger_Right_3;
    private final ModelRenderer Finger_Right_4;
    private final ModelRenderer Finger_Right_5;
    private final ModelRenderer Leg_Left_1;
    private final ModelRenderer Leg_Left_2;
    private final ModelRenderer Leg_Left_3;
    private final ModelRenderer Leg_Right_1;
    private final ModelRenderer Leg_Right_2;
    private final ModelRenderer Leg_Right_3;

    public ModelCelestialStatue() {
        this.field_78090_t = 512;
        this.field_78089_u = 512;
        this.Body_1 = new ModelRenderer(this);
        this.Body_1.func_78793_a(0.0f, -15.0f, 0.0f);
        this.Body_1.field_78804_l.add(new ModelBox((net.minecraft.client.model.ModelRenderer)this.Body_1, 0, 103, -21.0f, -101.0f, -15.0f, 42, 34, 32, 0.0f, false));
        this.Body_2 = new ModelRenderer(this);
        this.Body_2.func_78793_a(0.0f, -100.25f, 0.0f);
        this.Body_1.func_78792_a(this.Body_2);
        this.Body_2.field_78804_l.add(new ModelBox((net.minecraft.client.model.ModelRenderer)this.Body_2, 0, 0, -29.5f, -57.75f, -15.0f, 59, 57, 32, 0.0f, false));
        this.Body_2.field_78804_l.add(new ModelBox((net.minecraft.client.model.ModelRenderer)this.Body_2, 103, 183, -15.5f, -61.75f, -11.0f, 31, 10, 26, 0.0f, false));
        this.Head = new ModelRenderer(this);
        this.Head.func_78793_a(0.0f, -61.75f, 0.0f);
        this.Body_2.func_78792_a(this.Head);
        this.Head.field_78804_l.add(new ModelBox((net.minecraft.client.model.ModelRenderer)this.Head, 155, 99, -16.5f, -40.0f, -19.0f, 33, 40, 40, 0.0f, false));
        this.Armleft_Shoulder = new ModelRenderer(this);
        this.Armleft_Shoulder.func_78793_a(49.0f, -45.75f, 0.0f);
        this.Body_2.func_78792_a(this.Armleft_Shoulder);
        this.setRotationAngle(this.Armleft_Shoulder, 0.0f, 0.0f, -1.3526f);
        this.Armleft_Shoulder.field_78804_l.add(new ModelBox((net.minecraft.client.model.ModelRenderer)this.Armleft_Shoulder, 73, 227, -15.706f, -38.4944f, -21.0f, 24, 52, 45, 0.0f, false));
        this.Armleft_1 = new ModelRenderer(this);
        this.Armleft_1.func_78793_a(-12.75f, 2.5254f, 2.0f);
        this.Armleft_Shoulder.func_78792_a(this.Armleft_1);
        this.setRotationAngle(this.Armleft_1, 0.0f, 0.0f, -1.789f);
        this.Armleft_1.field_78804_l.add(new ModelBox((net.minecraft.client.model.ModelRenderer)this.Armleft_1, 327, 11, -5.0f, -30.5f, -5.0f, 10, 35, 10, 0.0f, false));
        this.Armleft_1.field_78804_l.add(new ModelBox((net.minecraft.client.model.ModelRenderer)this.Armleft_1, 194, 35, -9.0f, -30.5f, -9.0f, 18, 35, 18, 0.0f, false));
        this.Armleft_2 = new ModelRenderer(this);
        this.Armleft_2.func_78793_a(-0.2985f, -29.9152f, 0.0f);
        this.Armleft_1.func_78792_a(this.Armleft_2);
        this.Armleft_2.field_78804_l.add(new ModelBox((net.minecraft.client.model.ModelRenderer)this.Armleft_2, 271, 64, -12.706f, -42.4944f, -13.0f, 26, 44, 26, 0.0f, false));
        this.Armleft_3 = new ModelRenderer(this);
        this.Armleft_3.func_78793_a(0.0f, -40.0f, 0.0f);
        this.Armleft_2.func_78792_a(this.Armleft_3);
        this.setRotationAngle(this.Armleft_3, 0.0f, 1.5708f, 0.0f);
        this.Armleft_3.field_78804_l.add(new ModelBox((net.minecraft.client.model.ModelRenderer)this.Armleft_3, 354, 153, -5.706f, -36.4944f, -7.0f, 12, 44, 14, 0.0f, false));
        this.Armleft_3.field_78804_l.add(new ModelBox((net.minecraft.client.model.ModelRenderer)this.Armleft_3, 227, 185, -8.706f, -37.4944f, -10.0f, 18, 44, 20, 0.0f, false));
        this.Finger_Left_1 = new ModelRenderer(this);
        this.Finger_Left_1.func_78793_a(-4.0f, -36.0f, -5.0f);
        this.Armleft_3.func_78792_a(this.Finger_Left_1);
        this.Finger_Left_1.field_78804_l.add(new ModelBox((net.minecraft.client.model.ModelRenderer)this.Finger_Left_1, 122, 99, -1.706f, -19.4944f, -3.0f, 4, 22, 6, 0.0f, false));
        this.Finger_Left_2 = new ModelRenderer(this);
        this.Finger_Left_2.func_78793_a(1.0f, -36.0f, -5.0f);
        this.Armleft_3.func_78792_a(this.Finger_Left_2);
        this.Finger_Left_2.field_78804_l.add(new ModelBox((net.minecraft.client.model.ModelRenderer)this.Finger_Left_2, 201, 234, -1.706f, -23.4944f, -3.0f, 4, 26, 6, 0.0f, false));
        this.Finger_Left_3 = new ModelRenderer(this);
        this.Finger_Left_3.func_78793_a(6.0f, -36.0f, -5.0f);
        this.Armleft_3.func_78792_a(this.Finger_Left_3);
        this.Finger_Left_3.field_78804_l.add(new ModelBox((net.minecraft.client.model.ModelRenderer)this.Finger_Left_3, 175, 237, -1.706f, -21.4944f, -3.0f, 4, 24, 6, 0.0f, false));
        this.Finger_Left_4 = new ModelRenderer(this);
        this.Finger_Left_4.func_78793_a(10.0f, -31.0f, -5.0f);
        this.Armleft_3.func_78792_a(this.Finger_Left_4);
        this.Finger_Left_4.field_78804_l.add(new ModelBox((net.minecraft.client.model.ModelRenderer)this.Finger_Left_4, 99, 173, -0.706f, -16.4944f, -3.0f, 4, 20, 6, 0.0f, false));
        this.Finger_Left_5 = new ModelRenderer(this);
        this.Finger_Left_5.func_78793_a(-8.0f, -35.0f, -5.0f);
        this.Armleft_3.func_78792_a(this.Finger_Left_5);
        this.Finger_Left_5.field_78804_l.add(new ModelBox((net.minecraft.client.model.ModelRenderer)this.Finger_Left_5, 97, 243, -1.706f, -16.4944f, -3.0f, 3, 18, 6, 0.0f, false));
        this.Armright_Shoulder = new ModelRenderer(this);
        this.Armright_Shoulder.func_78793_a(-49.0f, -45.75f, 0.0f);
        this.Body_2.func_78792_a(this.Armright_Shoulder);
        this.setRotationAngle(this.Armright_Shoulder, 0.0f, 0.0f, 1.3526f);
        this.Armright_Shoulder.field_78804_l.add(new ModelBox((net.minecraft.client.model.ModelRenderer)this.Armright_Shoulder, 73, 227, -8.294f, -38.4944f, -21.0f, 24, 52, 45, 0.0f, true));
        this.Armright_1 = new ModelRenderer(this);
        this.Armright_1.func_78793_a(11.7737f, 2.309f, 2.0f);
        this.Armright_Shoulder.func_78792_a(this.Armright_1);
        this.setRotationAngle(this.Armright_1, 0.0f, 0.0f, 1.789f);
        this.Armright_1.field_78804_l.add(new ModelBox((net.minecraft.client.model.ModelRenderer)this.Armright_1, 327, 11, -5.0f, -31.5f, -5.0f, 10, 35, 10, 0.0f, true));
        this.Armright_1.field_78804_l.add(new ModelBox((net.minecraft.client.model.ModelRenderer)this.Armright_1, 194, 34, -9.0f, -31.5f, -9.0f, 18, 35, 18, 0.0f, true));
        this.Armright_2 = new ModelRenderer(this);
        this.Armright_2.func_78793_a(0.2985f, -30.9152f, 0.0f);
        this.Armright_1.func_78792_a(this.Armright_2);
        this.Armright_2.field_78804_l.add(new ModelBox((net.minecraft.client.model.ModelRenderer)this.Armright_2, 271, 64, -13.294f, -42.4944f, -13.0f, 26, 44, 26, 0.0f, true));
        this.Armright_3 = new ModelRenderer(this);
        this.Armright_3.func_78793_a(0.0f, -40.0f, 0.0f);
        this.Armright_2.func_78792_a(this.Armright_3);
        this.setRotationAngle(this.Armright_3, 0.0f, -1.5708f, 0.0f);
        this.Armright_3.field_78804_l.add(new ModelBox((net.minecraft.client.model.ModelRenderer)this.Armright_3, 354, 153, -6.294f, -36.4944f, -7.0f, 12, 44, 14, 0.0f, true));
        this.Armright_3.field_78804_l.add(new ModelBox((net.minecraft.client.model.ModelRenderer)this.Armright_3, 227, 185, -9.294f, -37.4944f, -10.0f, 18, 44, 20, 0.0f, true));
        this.Finger_Right_1 = new ModelRenderer(this);
        this.Finger_Right_1.func_78793_a(4.0f, -36.0f, -5.0f);
        this.Armright_3.func_78792_a(this.Finger_Right_1);
        this.Finger_Right_1.field_78804_l.add(new ModelBox((net.minecraft.client.model.ModelRenderer)this.Finger_Right_1, 122, 99, -2.294f, -19.4944f, -3.0f, 4, 22, 6, 0.0f, true));
        this.Finger_Right_2 = new ModelRenderer(this);
        this.Finger_Right_2.func_78793_a(-1.0f, -36.0f, -5.0f);
        this.Armright_3.func_78792_a(this.Finger_Right_2);
        this.Finger_Right_2.field_78804_l.add(new ModelBox((net.minecraft.client.model.ModelRenderer)this.Finger_Right_2, 201, 234, -2.294f, -23.4944f, -3.0f, 4, 26, 6, 0.0f, true));
        this.Finger_Right_3 = new ModelRenderer(this);
        this.Finger_Right_3.func_78793_a(-6.0f, -36.0f, -5.0f);
        this.Armright_3.func_78792_a(this.Finger_Right_3);
        this.Finger_Right_3.field_78804_l.add(new ModelBox((net.minecraft.client.model.ModelRenderer)this.Finger_Right_3, 175, 237, -2.294f, -21.4944f, -3.0f, 4, 24, 6, 0.0f, true));
        this.Finger_Right_4 = new ModelRenderer(this);
        this.Finger_Right_4.func_78793_a(-10.0f, -31.0f, -5.0f);
        this.Armright_3.func_78792_a(this.Finger_Right_4);
        this.Finger_Right_4.field_78804_l.add(new ModelBox((net.minecraft.client.model.ModelRenderer)this.Finger_Right_4, 99, 173, -3.294f, -16.4944f, -3.0f, 4, 20, 6, 0.0f, true));
        this.Finger_Right_5 = new ModelRenderer(this);
        this.Finger_Right_5.func_78793_a(8.0f, -35.0f, -5.0f);
        this.Armright_3.func_78792_a(this.Finger_Right_5);
        this.Finger_Right_5.field_78804_l.add(new ModelBox((net.minecraft.client.model.ModelRenderer)this.Finger_Right_5, 97, 243, -1.294f, -16.4944f, -3.0f, 3, 18, 6, 0.0f, true));
        this.Leg_Left_1 = new ModelRenderer(this);
        this.Leg_Left_1.func_78793_a(21.0f, -71.0f, 2.0f);
        this.Body_1.func_78792_a(this.Leg_Left_1);
        this.Leg_Left_1.field_78804_l.add(new ModelBox((net.minecraft.client.model.ModelRenderer)this.Leg_Left_1, 0, 174, -18.0f, -10.0f, -13.0f, 21, 48, 26, 0.0f, true));
        this.Leg_Left_2 = new ModelRenderer(this);
        this.Leg_Left_2.func_78793_a(-7.0f, 38.0f, 0.0f);
        this.Leg_Left_1.func_78792_a(this.Leg_Left_2);
        this.Leg_Left_2.field_78804_l.add(new ModelBox((net.minecraft.client.model.ModelRenderer)this.Leg_Left_2, 309, 141, -5.0f, -4.0f, -5.0f, 10, 57, 10, 0.0f, true));
        this.Leg_Left_2.field_78804_l.add(new ModelBox((net.minecraft.client.model.ModelRenderer)this.Leg_Left_2, 0, 254, -8.0f, -4.0f, -8.0f, 16, 57, 16, 0.0f, true));
        this.Leg_Left_3 = new ModelRenderer(this);
        this.Leg_Left_3.func_78793_a(0.0f, 51.0f, 0.0f);
        this.Leg_Left_2.func_78792_a(this.Leg_Left_3);
        this.Leg_Left_3.field_78804_l.add(new ModelBox((net.minecraft.client.model.ModelRenderer)this.Leg_Left_3, 270, 82, -12.0f, -1.0f, -16.0f, 24, 22, 30, 0.0f, true));
        this.Leg_Right_1 = new ModelRenderer(this);
        this.Leg_Right_1.func_78793_a(-21.0f, -71.0f, 2.0f);
        this.Body_1.func_78792_a(this.Leg_Right_1);
        this.Leg_Right_1.field_78804_l.add(new ModelBox((net.minecraft.client.model.ModelRenderer)this.Leg_Right_1, 0, 174, -3.0f, -10.0f, -13.0f, 21, 48, 26, 0.0f, false));
        this.Leg_Right_2 = new ModelRenderer(this);
        this.Leg_Right_2.func_78793_a(7.0f, 38.0f, 0.0f);
        this.Leg_Right_1.func_78792_a(this.Leg_Right_2);
        this.Leg_Right_2.field_78804_l.add(new ModelBox((net.minecraft.client.model.ModelRenderer)this.Leg_Right_2, 309, 141, -5.0f, -4.0f, -5.0f, 10, 57, 10, 0.0f, false));
        this.Leg_Right_2.field_78804_l.add(new ModelBox((net.minecraft.client.model.ModelRenderer)this.Leg_Right_2, 0, 254, -8.0f, -4.0f, -8.0f, 16, 57, 16, 0.0f, false));
        this.Leg_Right_3 = new ModelRenderer(this);
        this.Leg_Right_3.func_78793_a(0.0f, 51.0f, 0.0f);
        this.Leg_Right_2.func_78792_a(this.Leg_Right_3);
        this.Leg_Right_3.field_78804_l.add(new ModelBox((net.minecraft.client.model.ModelRenderer)this.Leg_Right_3, 270, 82, -12.0f, -1.0f, -16.0f, 24, 22, 30, 0.0f, false));
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

