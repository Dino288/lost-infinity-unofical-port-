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
package xol.lostinfinity.mob.model.sea;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;

public class ModelOctobrella
extends ModelBase {
    private final ModelRenderer GlowCube;
    private final ModelRenderer Head;
    private final ModelRenderer Body;
    private final ModelRenderer Leg1;
    private final ModelRenderer Leg1P2;
    private final ModelRenderer Leg1P3;
    private final ModelRenderer Leg5;
    private final ModelRenderer Leg5P2;
    private final ModelRenderer Leg5P3;
    private final ModelRenderer Leg2;
    private final ModelRenderer Leg2P2;
    private final ModelRenderer Leg2P3;
    private final ModelRenderer Leg4;
    private final ModelRenderer Leg4P2;
    private final ModelRenderer Leg4P3;
    private final ModelRenderer Leg6;
    private final ModelRenderer Leg6P2;
    private final ModelRenderer Leg6P3;
    private final ModelRenderer Leg8;
    private final ModelRenderer Leg8P2;
    private final ModelRenderer Leg8P3;
    private final ModelRenderer Leg3;
    private final ModelRenderer Leg3P2;
    private final ModelRenderer Leg3P3;
    private final ModelRenderer Leg7;
    private final ModelRenderer Leg7P2;
    private final ModelRenderer Leg7P3;

    public ModelOctobrella() {
        this.field_78090_t = 128;
        this.field_78089_u = 64;
        this.GlowCube = new ModelRenderer((ModelBase)this);
        this.GlowCube.func_78793_a(0.0f, 16.0f, 0.0f);
        this.GlowCube.field_78804_l.add(new ModelBox(this.GlowCube, 0, 0, -8.0f, -8.0f, -8.0f, 16, 16, 16, 0.0f, false));
        this.Head = new ModelRenderer((ModelBase)this);
        this.Head.func_78793_a(-3.0f, 15.0f, 3.0f);
        this.Head.field_78804_l.add(new ModelBox(this.Head, 65, 12, -2.0f, -3.0f, -8.0f, 10, 10, 10, 0.0f, false));
        this.Head.field_78804_l.add(new ModelBox(this.Head, 3, 6, 8.0f, -1.0f, -7.0f, 1, 4, 4, 0.0f, false));
        this.Head.field_78804_l.add(new ModelBox(this.Head, 3, 6, -3.0f, -1.0f, -7.0f, 1, 4, 4, 0.0f, true));
        this.Body = new ModelRenderer((ModelBase)this);
        this.Body.func_78793_a(0.0f, 17.0f, 0.0f);
        this.Body.field_78804_l.add(new ModelBox(this.Body, 57, 0, -2.0f, -17.0f, -2.0f, 4, 12, 4, 0.0f, false));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 0, 40, -8.0f, -25.0f, -8.0f, 16, 8, 16, 0.0f, false));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 80, 49, -6.0f, -28.0f, -6.0f, 12, 3, 12, 0.0f, false));
        this.Leg1 = new ModelRenderer((ModelBase)this);
        this.Leg1.func_78793_a(7.0f, -20.0f, 0.0f);
        this.Body.func_78792_a(this.Leg1);
        this.Leg1.field_78804_l.add(new ModelBox(this.Leg1, 75, 2, 0.0f, -2.0f, -2.0f, 10, 4, 4, 0.0f, false));
        this.Leg1P2 = new ModelRenderer((ModelBase)this);
        this.Leg1P2.func_78793_a(10.0f, 0.0f, 0.0f);
        this.Leg1.func_78792_a(this.Leg1P2);
        this.setRotationAngle(this.Leg1P2, 0.0f, 0.0f, 0.3491f);
        this.Leg1P2.field_78804_l.add(new ModelBox(this.Leg1P2, 97, 12, -1.0f, -2.0f, -2.0f, 10, 4, 4, -0.1f, false));
        this.Leg1P3 = new ModelRenderer((ModelBase)this);
        this.Leg1P3.func_78793_a(9.0f, 0.0f, 0.0f);
        this.Leg1P2.func_78792_a(this.Leg1P3);
        this.setRotationAngle(this.Leg1P3, 0.0f, 0.0f, 0.3491f);
        this.Leg1P3.field_78804_l.add(new ModelBox(this.Leg1P3, 97, 12, -1.0f, -2.0f, -2.0f, 10, 4, 4, -0.2f, false));
        this.Leg5 = new ModelRenderer((ModelBase)this);
        this.Leg5.func_78793_a(-7.0f, -20.0f, 0.0f);
        this.Body.func_78792_a(this.Leg5);
        this.setRotationAngle(this.Leg5, 0.0f, 3.1416f, 0.0f);
        this.Leg5.field_78804_l.add(new ModelBox(this.Leg5, 75, 2, 0.0f, -2.0f, -2.0f, 10, 4, 4, 0.0f, false));
        this.Leg5P2 = new ModelRenderer((ModelBase)this);
        this.Leg5P2.func_78793_a(10.0f, 0.0f, 0.0f);
        this.Leg5.func_78792_a(this.Leg5P2);
        this.setRotationAngle(this.Leg5P2, 0.0f, 0.0f, 0.3491f);
        this.Leg5P2.field_78804_l.add(new ModelBox(this.Leg5P2, 97, 12, -1.0f, -2.0f, -2.0f, 10, 4, 4, -0.1f, false));
        this.Leg5P3 = new ModelRenderer((ModelBase)this);
        this.Leg5P3.func_78793_a(9.0f, 0.0f, 0.0f);
        this.Leg5P2.func_78792_a(this.Leg5P3);
        this.setRotationAngle(this.Leg5P3, 0.0f, 0.0f, 0.3491f);
        this.Leg5P3.field_78804_l.add(new ModelBox(this.Leg5P3, 97, 12, -1.0f, -2.0f, -2.0f, 10, 4, 4, -0.2f, false));
        this.Leg2 = new ModelRenderer((ModelBase)this);
        this.Leg2.func_78793_a(5.0f, -20.0f, 5.0f);
        this.Body.func_78792_a(this.Leg2);
        this.setRotationAngle(this.Leg2, 0.0f, -0.7854f, 0.0f);
        this.Leg2.field_78804_l.add(new ModelBox(this.Leg2, 75, 2, 0.0f, -2.0f, -2.0f, 10, 4, 4, 0.0f, false));
        this.Leg2P2 = new ModelRenderer((ModelBase)this);
        this.Leg2P2.func_78793_a(10.0f, 0.0f, 0.0f);
        this.Leg2.func_78792_a(this.Leg2P2);
        this.setRotationAngle(this.Leg2P2, 0.0f, 0.0f, 0.3491f);
        this.Leg2P2.field_78804_l.add(new ModelBox(this.Leg2P2, 97, 12, -1.0f, -2.0f, -2.0f, 10, 4, 4, -0.1f, false));
        this.Leg2P3 = new ModelRenderer((ModelBase)this);
        this.Leg2P3.func_78793_a(9.0f, 0.0f, 0.0f);
        this.Leg2P2.func_78792_a(this.Leg2P3);
        this.setRotationAngle(this.Leg2P3, 0.0f, 0.0f, 0.3491f);
        this.Leg2P3.field_78804_l.add(new ModelBox(this.Leg2P3, 97, 12, -1.0f, -2.0f, -2.0f, 10, 4, 4, -0.2f, false));
        this.Leg4 = new ModelRenderer((ModelBase)this);
        this.Leg4.func_78793_a(-5.0f, -20.0f, 5.0f);
        this.Body.func_78792_a(this.Leg4);
        this.setRotationAngle(this.Leg4, 0.0f, -2.3562f, 0.0f);
        this.Leg4.field_78804_l.add(new ModelBox(this.Leg4, 75, 2, 0.0f, -2.0f, -2.0f, 10, 4, 4, 0.0f, false));
        this.Leg4P2 = new ModelRenderer((ModelBase)this);
        this.Leg4P2.func_78793_a(10.0f, 0.0f, 0.0f);
        this.Leg4.func_78792_a(this.Leg4P2);
        this.setRotationAngle(this.Leg4P2, 0.0f, 0.0f, 0.3491f);
        this.Leg4P2.field_78804_l.add(new ModelBox(this.Leg4P2, 97, 12, -1.0f, -2.0f, -2.0f, 10, 4, 4, -0.1f, false));
        this.Leg4P3 = new ModelRenderer((ModelBase)this);
        this.Leg4P3.func_78793_a(9.0f, 0.0f, 0.0f);
        this.Leg4P2.func_78792_a(this.Leg4P3);
        this.setRotationAngle(this.Leg4P3, 0.0f, 0.0f, 0.3491f);
        this.Leg4P3.field_78804_l.add(new ModelBox(this.Leg4P3, 97, 12, -1.0f, -2.0f, -2.0f, 10, 4, 4, -0.2f, false));
        this.Leg6 = new ModelRenderer((ModelBase)this);
        this.Leg6.func_78793_a(-5.0f, -20.0f, -5.0f);
        this.Body.func_78792_a(this.Leg6);
        this.setRotationAngle(this.Leg6, 0.0f, 2.3562f, 0.0f);
        this.Leg6.field_78804_l.add(new ModelBox(this.Leg6, 75, 2, 0.0f, -2.0f, -2.0f, 10, 4, 4, 0.0f, false));
        this.Leg6P2 = new ModelRenderer((ModelBase)this);
        this.Leg6P2.func_78793_a(10.0f, 0.0f, 0.0f);
        this.Leg6.func_78792_a(this.Leg6P2);
        this.setRotationAngle(this.Leg6P2, 0.0f, 0.0f, 0.3491f);
        this.Leg6P2.field_78804_l.add(new ModelBox(this.Leg6P2, 97, 12, -1.0f, -2.0f, -2.0f, 10, 4, 4, -0.1f, false));
        this.Leg6P3 = new ModelRenderer((ModelBase)this);
        this.Leg6P3.func_78793_a(9.0f, 0.0f, 0.0f);
        this.Leg6P2.func_78792_a(this.Leg6P3);
        this.setRotationAngle(this.Leg6P3, 0.0f, 0.0f, 0.3491f);
        this.Leg6P3.field_78804_l.add(new ModelBox(this.Leg6P3, 97, 12, -1.0f, -2.0f, -2.0f, 10, 4, 4, -0.2f, false));
        this.Leg8 = new ModelRenderer((ModelBase)this);
        this.Leg8.func_78793_a(5.0f, -20.0f, -5.0f);
        this.Body.func_78792_a(this.Leg8);
        this.setRotationAngle(this.Leg8, 0.0f, 0.7854f, 0.0f);
        this.Leg8.field_78804_l.add(new ModelBox(this.Leg8, 75, 2, 0.0f, -2.0f, -2.0f, 10, 4, 4, 0.0f, false));
        this.Leg8P2 = new ModelRenderer((ModelBase)this);
        this.Leg8P2.func_78793_a(10.0f, 0.0f, 0.0f);
        this.Leg8.func_78792_a(this.Leg8P2);
        this.setRotationAngle(this.Leg8P2, 0.0f, 0.0f, 0.3491f);
        this.Leg8P2.field_78804_l.add(new ModelBox(this.Leg8P2, 97, 12, -1.0f, -2.0f, -2.0f, 10, 4, 4, -0.1f, false));
        this.Leg8P3 = new ModelRenderer((ModelBase)this);
        this.Leg8P3.func_78793_a(9.0f, 0.0f, 0.0f);
        this.Leg8P2.func_78792_a(this.Leg8P3);
        this.setRotationAngle(this.Leg8P3, 0.0f, 0.0f, 0.3491f);
        this.Leg8P3.field_78804_l.add(new ModelBox(this.Leg8P3, 97, 12, -1.0f, -2.0f, -2.0f, 10, 4, 4, -0.2f, false));
        this.Leg3 = new ModelRenderer((ModelBase)this);
        this.Leg3.func_78793_a(0.0f, -20.0f, 7.0f);
        this.Body.func_78792_a(this.Leg3);
        this.setRotationAngle(this.Leg3, 0.0f, -1.5708f, 0.0f);
        this.Leg3.field_78804_l.add(new ModelBox(this.Leg3, 75, 2, 0.0f, -2.0f, -2.0f, 10, 4, 4, 0.0f, false));
        this.Leg3P2 = new ModelRenderer((ModelBase)this);
        this.Leg3P2.func_78793_a(10.0f, 0.0f, 0.0f);
        this.Leg3.func_78792_a(this.Leg3P2);
        this.setRotationAngle(this.Leg3P2, 0.0f, 0.0f, 0.3491f);
        this.Leg3P2.field_78804_l.add(new ModelBox(this.Leg3P2, 97, 12, -1.0f, -2.0f, -2.0f, 10, 4, 4, -0.1f, false));
        this.Leg3P3 = new ModelRenderer((ModelBase)this);
        this.Leg3P3.func_78793_a(9.0f, 0.0f, 0.0f);
        this.Leg3P2.func_78792_a(this.Leg3P3);
        this.setRotationAngle(this.Leg3P3, 0.0f, 0.0f, 0.3491f);
        this.Leg3P3.field_78804_l.add(new ModelBox(this.Leg3P3, 97, 12, -1.0f, -2.0f, -2.0f, 10, 4, 4, -0.2f, false));
        this.Leg7 = new ModelRenderer((ModelBase)this);
        this.Leg7.func_78793_a(0.0f, -20.0f, -7.0f);
        this.Body.func_78792_a(this.Leg7);
        this.setRotationAngle(this.Leg7, 0.0f, 1.5708f, 0.0f);
        this.Leg7.field_78804_l.add(new ModelBox(this.Leg7, 75, 2, 0.0f, -2.0f, -2.0f, 10, 4, 4, 0.0f, false));
        this.Leg7P2 = new ModelRenderer((ModelBase)this);
        this.Leg7P2.func_78793_a(10.0f, 0.0f, 0.0f);
        this.Leg7.func_78792_a(this.Leg7P2);
        this.setRotationAngle(this.Leg7P2, 0.0f, 0.0f, 0.3491f);
        this.Leg7P2.field_78804_l.add(new ModelBox(this.Leg7P2, 97, 12, -1.0f, -2.0f, -2.0f, 10, 4, 4, -0.1f, false));
        this.Leg7P3 = new ModelRenderer((ModelBase)this);
        this.Leg7P3.func_78793_a(9.0f, 0.0f, 0.0f);
        this.Leg7P2.func_78792_a(this.Leg7P3);
        this.setRotationAngle(this.Leg7P3, 0.0f, 0.0f, 0.3491f);
        this.Leg7P3.field_78804_l.add(new ModelBox(this.Leg7P3, 97, 12, -1.0f, -2.0f, -2.0f, 10, 4, 4, -0.2f, false));
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.Head.func_78785_a(f5);
        this.Body.func_78785_a(f5);
        GlStateManager.func_179147_l();
        GlStateManager.func_179112_b((int)770, (int)771);
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)0.75f);
        this.GlowCube.func_78785_a(f5);
        GlStateManager.func_179084_k();
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        float tentacleSpeed = 0.1f;
        float tentacleRange = 0.95f;
        float tentacleSpeedMiddle = 0.05f;
        float tentacleRangeMiddle = 0.3f;
        float tentacleSpeedTip = 0.1f;
        float tentacleRangeTip = 0.4f;
        float cubeSpeed = 0.04f;
        float swingScalar = 5.0E-5f;
        if (limbSwing > 0.0f) {
            tentacleSpeed += limbSwing * swingScalar;
            tentacleSpeedMiddle += limbSwing * swingScalar;
            tentacleSpeedTip += limbSwing * swingScalar;
        }
        this.Leg1.field_78808_h = Mth.func_76126_a((float)(ageInTicks * tentacleSpeed)) * tentacleRange;
        this.Leg2.field_78808_h = Mth.func_76126_a((float)((ageInTicks + 5.0f) * tentacleSpeed)) * tentacleRange;
        this.Leg3.field_78808_h = Mth.func_76126_a((float)((ageInTicks + 10.0f) * tentacleSpeed)) * tentacleRange;
        this.Leg4.field_78808_h = Mth.func_76126_a((float)((ageInTicks + 15.0f) * tentacleSpeed)) * tentacleRange;
        this.Leg5.field_78808_h = -Mth.func_76126_a((float)((ageInTicks + 20.0f) * tentacleSpeed)) * tentacleRange;
        this.Leg6.field_78808_h = -Mth.func_76126_a((float)((ageInTicks + 25.0f) * tentacleSpeed)) * tentacleRange;
        this.Leg7.field_78808_h = -Mth.func_76126_a((float)((ageInTicks + 30.0f) * tentacleSpeed)) * tentacleRange;
        this.Leg8.field_78808_h = -Mth.func_76126_a((float)((ageInTicks + 35.0f) * tentacleSpeed)) * tentacleRange;
        this.Leg1P2.field_78808_h = -Mth.func_76126_a((float)(ageInTicks * tentacleSpeedMiddle)) * tentacleRangeMiddle;
        this.Leg2P2.field_78808_h = -Mth.func_76126_a((float)((ageInTicks + 5.0f) * tentacleSpeedMiddle)) * tentacleRangeMiddle;
        this.Leg3P2.field_78808_h = -Mth.func_76126_a((float)((ageInTicks + 10.0f) * tentacleSpeedMiddle)) * tentacleRangeMiddle;
        this.Leg4P2.field_78808_h = -Mth.func_76126_a((float)((ageInTicks + 15.0f) * tentacleSpeedMiddle)) * tentacleRangeMiddle;
        this.Leg5P2.field_78808_h = Mth.func_76126_a((float)((ageInTicks + 20.0f) * tentacleSpeedMiddle)) * tentacleRangeMiddle;
        this.Leg6P2.field_78808_h = Mth.func_76126_a((float)((ageInTicks + 25.0f) * tentacleSpeedMiddle)) * tentacleRangeMiddle;
        this.Leg7P2.field_78808_h = Mth.func_76126_a((float)((ageInTicks + 30.0f) * tentacleSpeedMiddle)) * tentacleRangeMiddle;
        this.Leg8P2.field_78808_h = Mth.func_76126_a((float)((ageInTicks + 35.0f) * tentacleSpeedMiddle)) * tentacleRangeMiddle;
        this.Leg1P3.field_78808_h = Mth.func_76126_a((float)(ageInTicks * tentacleSpeedTip)) * tentacleRangeTip;
        this.Leg2P3.field_78808_h = Mth.func_76126_a((float)((ageInTicks + 5.0f) * tentacleSpeedTip)) * tentacleRangeTip;
        this.Leg3P3.field_78808_h = Mth.func_76126_a((float)((ageInTicks + 10.0f) * tentacleSpeedTip)) * tentacleRangeTip;
        this.Leg4P3.field_78808_h = Mth.func_76126_a((float)((ageInTicks + 15.0f) * tentacleSpeedTip)) * tentacleRangeTip;
        this.Leg5P3.field_78808_h = -Mth.func_76126_a((float)((ageInTicks + 20.0f) * tentacleSpeedTip)) * tentacleRangeTip;
        this.Leg6P3.field_78808_h = -Mth.func_76126_a((float)((ageInTicks + 25.0f) * tentacleSpeedTip)) * tentacleRangeTip;
        this.Leg7P3.field_78808_h = -Mth.func_76126_a((float)((ageInTicks + 30.0f) * tentacleSpeedTip)) * tentacleRangeTip;
        this.Leg8P3.field_78808_h = -Mth.func_76126_a((float)((ageInTicks + 35.0f) * tentacleSpeedTip)) * tentacleRangeTip;
        this.GlowCube.field_78796_g = Mth.func_76126_a((float)(ageInTicks * cubeSpeed));
    }
}

