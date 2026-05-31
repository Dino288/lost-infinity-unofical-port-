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

public class ModelCrabulon
extends ModelBase {
    private final ModelRenderer GlowOrb;
    private final ModelRenderer Body;
    private final ModelRenderer Leg1;
    private final ModelRenderer Leg1Sub;
    private final ModelRenderer Leg1Sub2;
    private final ModelRenderer Leg3;
    private final ModelRenderer Leg1Sub5;
    private final ModelRenderer Leg1Sub6;
    private final ModelRenderer Leg8;
    private final ModelRenderer Leg1Sub15;
    private final ModelRenderer Leg1Sub16;
    private final ModelRenderer Leg7;
    private final ModelRenderer Leg1Sub13;
    private final ModelRenderer Leg1Sub14;
    private final ModelRenderer Leg2;
    private final ModelRenderer Leg1Sub3;
    private final ModelRenderer Leg1Sub4;
    private final ModelRenderer Leg4;
    private final ModelRenderer Leg1Sub7;
    private final ModelRenderer Leg1Sub8;
    private final ModelRenderer Leg5;
    private final ModelRenderer Leg1Sub9;
    private final ModelRenderer Leg1Sub10;
    private final ModelRenderer Leg6;
    private final ModelRenderer Leg1Sub11;
    private final ModelRenderer Leg1Sub12;

    public ModelCrabulon() {
        this.field_78090_t = 128;
        this.field_78089_u = 64;
        this.GlowOrb = new ModelRenderer((ModelBase)this);
        this.GlowOrb.func_78793_a(0.0f, -19.0f, 0.0f);
        this.GlowOrb.field_78804_l.add(new ModelBox(this.GlowOrb, 0, 0, -8.0f, 9.0f, -8.0f, 16, 16, 16, 0.0f, false));
        this.Body = new ModelRenderer((ModelBase)this);
        this.Body.func_78793_a(0.0f, 17.0f, 0.0f);
        this.Body.field_78804_l.add(new ModelBox(this.Body, 80, 49, -6.0f, -11.0f, -6.0f, 12, 3, 12, 0.0f, false));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 71, 49, 1.0f, -26.0f, -2.0f, 5, 5, 5, 0.0f, false));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 71, 49, -6.0f, -21.0f, -2.0f, 5, 5, 5, 0.0f, false));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 50, 47, -5.0f, -16.0f, -1.0f, 3, 5, 3, 0.0f, false));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 2, 42, 2.0f, -21.0f, -1.0f, 3, 10, 3, 0.0f, false));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 0, 40, -8.0f, -8.0f, -8.0f, 16, 8, 16, 0.0f, false));
        this.Leg1 = new ModelRenderer((ModelBase)this);
        this.Leg1.func_78793_a(0.0f, -3.0f, -7.0f);
        this.Body.func_78792_a(this.Leg1);
        this.Leg1.field_78804_l.add(new ModelBox(this.Leg1, 92, 6, -4.0f, -2.0f, -10.0f, 8, 4, 10, 0.0f, false));
        this.Leg1Sub = new ModelRenderer((ModelBase)this);
        this.Leg1Sub.func_78793_a(2.5f, 0.5f, -10.0f);
        this.Leg1.func_78792_a(this.Leg1Sub);
        this.setRotationAngle(this.Leg1Sub, 0.2618f, 0.0f, 0.0f);
        this.Leg1Sub.field_78804_l.add(new ModelBox(this.Leg1Sub, 71, 21, -1.5f, -1.5f, -9.0f, 3, 3, 10, -0.1f, false));
        this.Leg1Sub.field_78804_l.add(new ModelBox(this.Leg1Sub, 71, 21, -6.5f, -1.5f, -9.0f, 3, 3, 10, -0.1f, false));
        this.Leg1Sub2 = new ModelRenderer((ModelBase)this);
        this.Leg1Sub2.func_78793_a(0.0f, 0.5f, -9.0f);
        this.Leg1Sub.func_78792_a(this.Leg1Sub2);
        this.setRotationAngle(this.Leg1Sub2, 0.4363f, 0.0f, 0.0f);
        this.Leg1Sub2.field_78804_l.add(new ModelBox(this.Leg1Sub2, 102, 23, -1.5f, -2.0f, -9.0f, 3, 3, 10, -0.2f, false));
        this.Leg1Sub2.field_78804_l.add(new ModelBox(this.Leg1Sub2, 102, 23, -6.5f, -2.0f, -9.0f, 3, 3, 10, -0.2f, false));
        this.Leg3 = new ModelRenderer((ModelBase)this);
        this.Leg3.func_78793_a(7.0f, -3.0f, 1.0f);
        this.Body.func_78792_a(this.Leg3);
        this.setRotationAngle(this.Leg3, 0.0f, -1.5708f, 0.0f);
        this.Leg3.field_78804_l.add(new ModelBox(this.Leg3, 92, 6, -4.0f, -2.0f, -10.0f, 8, 4, 10, 0.0f, false));
        this.Leg1Sub5 = new ModelRenderer((ModelBase)this);
        this.Leg1Sub5.func_78793_a(2.5f, 0.5f, -10.0f);
        this.Leg3.func_78792_a(this.Leg1Sub5);
        this.setRotationAngle(this.Leg1Sub5, 0.2618f, 0.0f, 0.0f);
        this.Leg1Sub5.field_78804_l.add(new ModelBox(this.Leg1Sub5, 71, 21, -1.5f, -1.5f, -9.0f, 3, 3, 10, -0.1f, false));
        this.Leg1Sub5.field_78804_l.add(new ModelBox(this.Leg1Sub5, 71, 21, -6.5f, -1.5f, -9.0f, 3, 3, 10, -0.1f, false));
        this.Leg1Sub6 = new ModelRenderer((ModelBase)this);
        this.Leg1Sub6.func_78793_a(0.0f, 0.5f, -9.0f);
        this.Leg1Sub5.func_78792_a(this.Leg1Sub6);
        this.setRotationAngle(this.Leg1Sub6, 0.4363f, 0.0f, 0.0f);
        this.Leg1Sub6.field_78804_l.add(new ModelBox(this.Leg1Sub6, 102, 23, -1.5f, -2.0f, -9.0f, 3, 3, 10, -0.2f, false));
        this.Leg1Sub6.field_78804_l.add(new ModelBox(this.Leg1Sub6, 102, 23, -6.5f, -2.0f, -9.0f, 3, 3, 10, -0.2f, false));
        this.Leg8 = new ModelRenderer((ModelBase)this);
        this.Leg8.func_78793_a(-7.0f, -3.0f, 1.0f);
        this.Body.func_78792_a(this.Leg8);
        this.setRotationAngle(this.Leg8, 0.0f, 1.5708f, 0.0f);
        this.Leg8.field_78804_l.add(new ModelBox(this.Leg8, 92, 6, -4.0f, -2.0f, -10.0f, 8, 4, 10, 0.0f, false));
        this.Leg1Sub15 = new ModelRenderer((ModelBase)this);
        this.Leg1Sub15.func_78793_a(2.5f, 0.5f, -10.0f);
        this.Leg8.func_78792_a(this.Leg1Sub15);
        this.setRotationAngle(this.Leg1Sub15, 0.2618f, 0.0f, 0.0f);
        this.Leg1Sub15.field_78804_l.add(new ModelBox(this.Leg1Sub15, 71, 21, -1.5f, -1.5f, -9.0f, 3, 3, 10, -0.1f, false));
        this.Leg1Sub15.field_78804_l.add(new ModelBox(this.Leg1Sub15, 71, 21, -6.5f, -1.5f, -9.0f, 3, 3, 10, -0.1f, false));
        this.Leg1Sub16 = new ModelRenderer((ModelBase)this);
        this.Leg1Sub16.func_78793_a(0.0f, 0.5f, -9.0f);
        this.Leg1Sub15.func_78792_a(this.Leg1Sub16);
        this.setRotationAngle(this.Leg1Sub16, 0.4363f, 0.0f, 0.0f);
        this.Leg1Sub16.field_78804_l.add(new ModelBox(this.Leg1Sub16, 102, 23, -1.5f, -2.0f, -9.0f, 3, 3, 10, -0.2f, false));
        this.Leg1Sub16.field_78804_l.add(new ModelBox(this.Leg1Sub16, 102, 23, -6.5f, -2.0f, -9.0f, 3, 3, 10, -0.2f, false));
        this.Leg7 = new ModelRenderer((ModelBase)this);
        this.Leg7.func_78793_a(0.0f, -3.0f, 7.0f);
        this.Body.func_78792_a(this.Leg7);
        this.setRotationAngle(this.Leg7, 0.0f, 3.1416f, 0.0f);
        this.Leg7.field_78804_l.add(new ModelBox(this.Leg7, 92, 6, -4.0f, -2.0f, -10.0f, 8, 4, 10, 0.0f, false));
        this.Leg1Sub13 = new ModelRenderer((ModelBase)this);
        this.Leg1Sub13.func_78793_a(2.5f, 0.5f, -10.0f);
        this.Leg7.func_78792_a(this.Leg1Sub13);
        this.setRotationAngle(this.Leg1Sub13, 0.2618f, 0.0f, 0.0f);
        this.Leg1Sub13.field_78804_l.add(new ModelBox(this.Leg1Sub13, 71, 21, -1.5f, -1.5f, -9.0f, 3, 3, 10, -0.1f, false));
        this.Leg1Sub13.field_78804_l.add(new ModelBox(this.Leg1Sub13, 71, 21, -6.5f, -1.5f, -9.0f, 3, 3, 10, -0.1f, false));
        this.Leg1Sub14 = new ModelRenderer((ModelBase)this);
        this.Leg1Sub14.func_78793_a(0.0f, 0.5f, -9.0f);
        this.Leg1Sub13.func_78792_a(this.Leg1Sub14);
        this.setRotationAngle(this.Leg1Sub14, 0.4363f, 0.0f, 0.0f);
        this.Leg1Sub14.field_78804_l.add(new ModelBox(this.Leg1Sub14, 102, 23, -1.5f, -2.0f, -9.0f, 3, 3, 10, -0.2f, false));
        this.Leg1Sub14.field_78804_l.add(new ModelBox(this.Leg1Sub14, 102, 23, -6.5f, -2.0f, -9.0f, 3, 3, 10, -0.2f, false));
        this.Leg2 = new ModelRenderer((ModelBase)this);
        this.Leg2.func_78793_a(5.0f, -4.0f, -5.0f);
        this.Body.func_78792_a(this.Leg2);
        this.setRotationAngle(this.Leg2, 0.0f, -0.7854f, 0.0f);
        this.Leg2.field_78804_l.add(new ModelBox(this.Leg2, 92, 6, -4.0f, -2.0f, -10.0f, 8, 4, 10, 0.0f, false));
        this.Leg1Sub3 = new ModelRenderer((ModelBase)this);
        this.Leg1Sub3.func_78793_a(2.5f, 0.5f, -10.0f);
        this.Leg2.func_78792_a(this.Leg1Sub3);
        this.setRotationAngle(this.Leg1Sub3, 0.2618f, 0.0f, 0.0f);
        this.Leg1Sub3.field_78804_l.add(new ModelBox(this.Leg1Sub3, 71, 21, -1.5f, -1.5f, -9.0f, 3, 3, 10, -0.1f, false));
        this.Leg1Sub3.field_78804_l.add(new ModelBox(this.Leg1Sub3, 71, 21, -6.5f, -1.5f, -9.0f, 3, 3, 10, -0.1f, false));
        this.Leg1Sub4 = new ModelRenderer((ModelBase)this);
        this.Leg1Sub4.func_78793_a(0.0f, 0.5f, -9.0f);
        this.Leg1Sub3.func_78792_a(this.Leg1Sub4);
        this.setRotationAngle(this.Leg1Sub4, 0.4363f, 0.0f, 0.0f);
        this.Leg1Sub4.field_78804_l.add(new ModelBox(this.Leg1Sub4, 102, 23, -1.5f, -2.0f, -9.0f, 3, 3, 10, -0.2f, false));
        this.Leg1Sub4.field_78804_l.add(new ModelBox(this.Leg1Sub4, 102, 23, -6.5f, -2.0f, -9.0f, 3, 3, 10, -0.2f, false));
        this.Leg4 = new ModelRenderer((ModelBase)this);
        this.Leg4.func_78793_a(5.0f, -4.0f, 5.0f);
        this.Body.func_78792_a(this.Leg4);
        this.setRotationAngle(this.Leg4, 0.0f, -2.3562f, 0.0f);
        this.Leg4.field_78804_l.add(new ModelBox(this.Leg4, 92, 6, -4.0f, -2.0f, -10.0f, 8, 4, 10, 0.0f, false));
        this.Leg1Sub7 = new ModelRenderer((ModelBase)this);
        this.Leg1Sub7.func_78793_a(2.5f, 0.5f, -10.0f);
        this.Leg4.func_78792_a(this.Leg1Sub7);
        this.setRotationAngle(this.Leg1Sub7, 0.2618f, 0.0f, 0.0f);
        this.Leg1Sub7.field_78804_l.add(new ModelBox(this.Leg1Sub7, 71, 21, -1.5f, -1.5f, -9.0f, 3, 3, 10, -0.1f, false));
        this.Leg1Sub7.field_78804_l.add(new ModelBox(this.Leg1Sub7, 71, 21, -6.5f, -1.5f, -9.0f, 3, 3, 10, -0.1f, false));
        this.Leg1Sub8 = new ModelRenderer((ModelBase)this);
        this.Leg1Sub8.func_78793_a(0.0f, 0.5f, -9.0f);
        this.Leg1Sub7.func_78792_a(this.Leg1Sub8);
        this.setRotationAngle(this.Leg1Sub8, 0.4363f, 0.0f, 0.0f);
        this.Leg1Sub8.field_78804_l.add(new ModelBox(this.Leg1Sub8, 102, 23, -1.5f, -2.0f, -9.0f, 3, 3, 10, -0.2f, false));
        this.Leg1Sub8.field_78804_l.add(new ModelBox(this.Leg1Sub8, 102, 23, -6.5f, -2.0f, -9.0f, 3, 3, 10, -0.2f, false));
        this.Leg5 = new ModelRenderer((ModelBase)this);
        this.Leg5.func_78793_a(-5.0f, -4.0f, 5.0f);
        this.Body.func_78792_a(this.Leg5);
        this.setRotationAngle(this.Leg5, 0.0f, 2.3562f, 0.0f);
        this.Leg5.field_78804_l.add(new ModelBox(this.Leg5, 92, 6, -4.0f, -2.0f, -10.0f, 8, 4, 10, 0.0f, false));
        this.Leg1Sub9 = new ModelRenderer((ModelBase)this);
        this.Leg1Sub9.func_78793_a(2.5f, 0.5f, -10.0f);
        this.Leg5.func_78792_a(this.Leg1Sub9);
        this.setRotationAngle(this.Leg1Sub9, 0.2618f, 0.0f, 0.0f);
        this.Leg1Sub9.field_78804_l.add(new ModelBox(this.Leg1Sub9, 71, 21, -1.5f, -1.5f, -9.0f, 3, 3, 10, -0.1f, false));
        this.Leg1Sub9.field_78804_l.add(new ModelBox(this.Leg1Sub9, 71, 21, -6.5f, -1.5f, -9.0f, 3, 3, 10, -0.1f, false));
        this.Leg1Sub10 = new ModelRenderer((ModelBase)this);
        this.Leg1Sub10.func_78793_a(0.0f, 0.5f, -9.0f);
        this.Leg1Sub9.func_78792_a(this.Leg1Sub10);
        this.setRotationAngle(this.Leg1Sub10, 0.4363f, 0.0f, 0.0f);
        this.Leg1Sub10.field_78804_l.add(new ModelBox(this.Leg1Sub10, 102, 23, -1.5f, -2.0f, -9.0f, 3, 3, 10, -0.2f, false));
        this.Leg1Sub10.field_78804_l.add(new ModelBox(this.Leg1Sub10, 102, 23, -6.5f, -2.0f, -9.0f, 3, 3, 10, -0.2f, false));
        this.Leg6 = new ModelRenderer((ModelBase)this);
        this.Leg6.func_78793_a(-5.0f, -4.0f, -5.0f);
        this.Body.func_78792_a(this.Leg6);
        this.setRotationAngle(this.Leg6, 0.0f, 0.7854f, 0.0f);
        this.Leg6.field_78804_l.add(new ModelBox(this.Leg6, 92, 6, -4.0f, -2.0f, -10.0f, 8, 4, 10, 0.0f, false));
        this.Leg1Sub11 = new ModelRenderer((ModelBase)this);
        this.Leg1Sub11.func_78793_a(2.5f, 0.5f, -10.0f);
        this.Leg6.func_78792_a(this.Leg1Sub11);
        this.setRotationAngle(this.Leg1Sub11, 0.2618f, 0.0f, 0.0f);
        this.Leg1Sub11.field_78804_l.add(new ModelBox(this.Leg1Sub11, 71, 21, -1.5f, -1.5f, -9.0f, 3, 3, 10, -0.1f, false));
        this.Leg1Sub11.field_78804_l.add(new ModelBox(this.Leg1Sub11, 71, 21, -6.5f, -1.5f, -9.0f, 3, 3, 10, -0.1f, false));
        this.Leg1Sub12 = new ModelRenderer((ModelBase)this);
        this.Leg1Sub12.func_78793_a(0.0f, 0.5f, -9.0f);
        this.Leg1Sub11.func_78792_a(this.Leg1Sub12);
        this.setRotationAngle(this.Leg1Sub12, 0.4363f, 0.0f, 0.0f);
        this.Leg1Sub12.field_78804_l.add(new ModelBox(this.Leg1Sub12, 102, 23, -1.5f, -2.0f, -9.0f, 3, 3, 10, -0.2f, false));
        this.Leg1Sub12.field_78804_l.add(new ModelBox(this.Leg1Sub12, 102, 23, -6.5f, -2.0f, -9.0f, 3, 3, 10, -0.2f, false));
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.Body.func_78785_a(f5);
        GlStateManager.func_179147_l();
        GlStateManager.func_179112_b((int)770, (int)771);
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)0.75f);
        this.GlowOrb.func_78785_a(f5);
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
        this.Leg1.field_78795_f = Mth.func_76126_a((float)(ageInTicks * tentacleSpeed)) * tentacleRange;
        this.Leg3.field_78795_f = Mth.func_76126_a((float)((ageInTicks + 5.0f) * tentacleSpeed)) * tentacleRange;
        this.Leg8.field_78795_f = Mth.func_76126_a((float)((ageInTicks + 10.0f) * tentacleSpeed)) * tentacleRange;
        this.Leg7.field_78795_f = Mth.func_76126_a((float)((ageInTicks + 15.0f) * tentacleSpeed)) * tentacleRange;
        this.Leg2.field_78795_f = -Mth.func_76126_a((float)((ageInTicks + 20.0f) * tentacleSpeed)) * tentacleRange;
        this.Leg4.field_78795_f = -Mth.func_76126_a((float)((ageInTicks + 25.0f) * tentacleSpeed)) * tentacleRange;
        this.Leg5.field_78795_f = -Mth.func_76126_a((float)((ageInTicks + 30.0f) * tentacleSpeed)) * tentacleRange;
        this.Leg6.field_78795_f = -Mth.func_76126_a((float)((ageInTicks + 35.0f) * tentacleSpeed)) * tentacleRange;
        this.Leg1Sub.field_78795_f = -Mth.func_76126_a((float)(ageInTicks * tentacleSpeedMiddle)) * tentacleRangeMiddle;
        this.Leg1Sub5.field_78795_f = -Mth.func_76126_a((float)((ageInTicks + 5.0f) * tentacleSpeedMiddle)) * tentacleRangeMiddle;
        this.Leg1Sub15.field_78795_f = -Mth.func_76126_a((float)((ageInTicks + 10.0f) * tentacleSpeedMiddle)) * tentacleRangeMiddle;
        this.Leg1Sub13.field_78795_f = -Mth.func_76126_a((float)((ageInTicks + 15.0f) * tentacleSpeedMiddle)) * tentacleRangeMiddle;
        this.Leg1Sub3.field_78795_f = Mth.func_76126_a((float)((ageInTicks + 20.0f) * tentacleSpeedMiddle)) * tentacleRangeMiddle;
        this.Leg1Sub7.field_78795_f = Mth.func_76126_a((float)((ageInTicks + 25.0f) * tentacleSpeedMiddle)) * tentacleRangeMiddle;
        this.Leg1Sub9.field_78795_f = Mth.func_76126_a((float)((ageInTicks + 30.0f) * tentacleSpeedMiddle)) * tentacleRangeMiddle;
        this.Leg1Sub11.field_78795_f = Mth.func_76126_a((float)((ageInTicks + 35.0f) * tentacleSpeedMiddle)) * tentacleRangeMiddle;
        this.Leg1Sub2.field_78795_f = Mth.func_76126_a((float)(ageInTicks * tentacleSpeedTip)) * tentacleRangeTip;
        this.Leg1Sub6.field_78795_f = Mth.func_76126_a((float)((ageInTicks + 5.0f) * tentacleSpeedTip)) * tentacleRangeTip;
        this.Leg1Sub16.field_78795_f = Mth.func_76126_a((float)((ageInTicks + 10.0f) * tentacleSpeedTip)) * tentacleRangeTip;
        this.Leg1Sub14.field_78795_f = Mth.func_76126_a((float)((ageInTicks + 15.0f) * tentacleSpeedTip)) * tentacleRangeTip;
        this.Leg1Sub4.field_78795_f = -Mth.func_76126_a((float)((ageInTicks + 20.0f) * tentacleSpeedTip)) * tentacleRangeTip;
        this.Leg1Sub8.field_78795_f = -Mth.func_76126_a((float)((ageInTicks + 25.0f) * tentacleSpeedTip)) * tentacleRangeTip;
        this.Leg1Sub10.field_78795_f = -Mth.func_76126_a((float)((ageInTicks + 30.0f) * tentacleSpeedTip)) * tentacleRangeTip;
        this.Leg1Sub12.field_78795_f = -Mth.func_76126_a((float)((ageInTicks + 35.0f) * tentacleSpeedTip)) * tentacleRangeTip;
        this.GlowOrb.field_78796_g = Mth.func_76126_a((float)(ageInTicks * cubeSpeed));
    }
}

