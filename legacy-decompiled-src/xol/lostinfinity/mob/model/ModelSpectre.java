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
package xol.lostinfinity.mob.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;

public class ModelSpectre
extends ModelBase {
    private final ModelRenderer Head;
    private final ModelRenderer Body;
    private final ModelRenderer BodyBlock_r1;
    private final ModelRenderer RightArm;
    private final ModelRenderer RArm3_r1;
    private final ModelRenderer RArm2_r1;
    private final ModelRenderer LeftArm;
    private final ModelRenderer LArm3_r1;
    private final ModelRenderer LArm2_r1;
    private final ModelRenderer WingR;
    private final ModelRenderer wingr3_r1;
    private final ModelRenderer wingr2_r1;
    private final ModelRenderer WingL;
    private final ModelRenderer wingl3_r1;
    private final ModelRenderer wingl2_r1;

    public ModelSpectre() {
        this.field_78090_t = 128;
        this.field_78089_u = 64;
        this.Head = new ModelRenderer((ModelBase)this);
        this.Head.func_78793_a(0.0f, 5.0f, 0.0f);
        this.Head.field_78804_l.add(new ModelBox(this.Head, 0, 0, -4.0f, -8.0f, -4.0f, 8, 8, 8, 0.0f, false));
        this.Head.field_78804_l.add(new ModelBox(this.Head, 32, 0, -4.0f, -8.0f, -4.0f, 8, 8, 8, 0.4f, false));
        this.Body = new ModelRenderer((ModelBase)this);
        this.Body.func_78793_a(0.0f, 16.0f, 0.0f);
        this.BodyBlock_r1 = new ModelRenderer((ModelBase)this);
        this.BodyBlock_r1.func_78793_a(0.0f, 0.0f, 0.0f);
        this.Body.func_78792_a(this.BodyBlock_r1);
        this.setRotationAngle(this.BodyBlock_r1, 0.2618f, 0.0f, 0.0f);
        this.BodyBlock_r1.field_78804_l.add(new ModelBox(this.BodyBlock_r1, 33, 18, -5.0f, -11.0f, 0.0f, 10, 18, 6, 0.4f, false));
        this.BodyBlock_r1.field_78804_l.add(new ModelBox(this.BodyBlock_r1, 69, 0, -2.5f, -7.5f, 7.0f, 4, 12, 2, 0.4f, false));
        this.BodyBlock_r1.field_78804_l.add(new ModelBox(this.BodyBlock_r1, 33, 18, -5.0f, -11.0f, 0.0f, 10, 18, 6, 0.4f, false));
        this.BodyBlock_r1.field_78804_l.add(new ModelBox(this.BodyBlock_r1, 0, 18, -5.0f, -11.0f, 0.0f, 10, 18, 6, 0.0f, false));
        this.RightArm = new ModelRenderer((ModelBase)this);
        this.RightArm.func_78793_a(-7.0f, 7.0f, 1.5f);
        this.RightArm.field_78804_l.add(new ModelBox(this.RightArm, 0, 51, -2.0f, -2.0f, -6.5f, 4, 4, 7, 0.0f, false));
        this.RArm3_r1 = new ModelRenderer((ModelBase)this);
        this.RArm3_r1.func_78793_a(0.0f, 0.8873f, -11.9091f);
        this.RightArm.func_78792_a(this.RArm3_r1);
        this.setRotationAngle(this.RArm3_r1, 0.3491f, 0.0f, 0.0f);
        this.RArm3_r1.field_78804_l.add(new ModelBox(this.RArm3_r1, 42, 51, -2.0f, -1.3873f, -2.5f, 4, 4, 5, -0.2f, false));
        this.RArm2_r1 = new ModelRenderer((ModelBase)this);
        this.RArm2_r1.func_78793_a(0.0f, 0.0f, -9.0f);
        this.RightArm.func_78792_a(this.RArm2_r1);
        this.setRotationAngle(this.RArm2_r1, 0.1309f, 0.0f, 0.0f);
        this.RArm2_r1.field_78804_l.add(new ModelBox(this.RArm2_r1, 23, 51, -2.0f, -1.5f, -1.5f, 4, 4, 5, -0.1f, false));
        this.LeftArm = new ModelRenderer((ModelBase)this);
        this.LeftArm.func_78793_a(7.0f, 7.0f, 1.5f);
        this.LeftArm.field_78804_l.add(new ModelBox(this.LeftArm, 0, 51, -2.0f, -2.0f, -6.5f, 4, 4, 7, 0.0f, false));
        this.LArm3_r1 = new ModelRenderer((ModelBase)this);
        this.LArm3_r1.func_78793_a(0.0f, 0.8873f, -11.9091f);
        this.LeftArm.func_78792_a(this.LArm3_r1);
        this.setRotationAngle(this.LArm3_r1, 0.3491f, 0.0f, 0.0f);
        this.LArm3_r1.field_78804_l.add(new ModelBox(this.LArm3_r1, 42, 51, -2.0f, -1.3873f, -2.5f, 4, 4, 5, -0.2f, false));
        this.LArm2_r1 = new ModelRenderer((ModelBase)this);
        this.LArm2_r1.func_78793_a(0.0f, 0.0f, -9.0f);
        this.LeftArm.func_78792_a(this.LArm2_r1);
        this.setRotationAngle(this.LArm2_r1, 0.1309f, 0.0f, 0.0f);
        this.LArm2_r1.field_78804_l.add(new ModelBox(this.LArm2_r1, 23, 51, -2.0f, -1.5f, -1.5f, 4, 4, 5, -0.1f, false));
        this.WingR = new ModelRenderer((ModelBase)this);
        this.WingR.func_78793_a(-1.5f, 6.5f, 7.0f);
        this.setRotationAngle(this.WingR, 0.2618f, 0.0f, 0.0f);
        this.WingR.field_78804_l.add(new ModelBox(this.WingR, 96, 49, -0.5f, -0.5f, -1.0f, 1, 1, 12, 0.0f, false));
        this.WingR.field_78804_l.add(new ModelBox(this.WingR, 68, 39, 0.0f, 0.5f, -1.0f, 1, 11, 12, 0.0f, false));
        this.wingr3_r1 = new ModelRenderer((ModelBase)this);
        this.wingr3_r1.func_78793_a(-2.0f, 0.0f, 2.0f);
        this.WingR.func_78792_a(this.wingr3_r1);
        this.setRotationAngle(this.wingr3_r1, -0.5236f, 0.0f, 0.0f);
        this.wingr3_r1.field_78804_l.add(new ModelBox(this.wingr3_r1, 98, 51, 1.5f, 5.5f, -1.0f, 1, 1, 10, 0.0f, false));
        this.wingr2_r1 = new ModelRenderer((ModelBase)this);
        this.wingr2_r1.func_78793_a(-2.0f, 0.0f, 2.0f);
        this.WingR.func_78792_a(this.wingr2_r1);
        this.setRotationAngle(this.wingr2_r1, -0.2618f, 0.0f, 0.0f);
        this.wingr2_r1.field_78804_l.add(new ModelBox(this.wingr2_r1, 96, 49, 1.5f, 2.5f, -3.0f, 1, 1, 12, 0.0f, false));
        this.WingL = new ModelRenderer((ModelBase)this);
        this.WingL.func_78793_a(0.5f, 6.5f, 7.0f);
        this.setRotationAngle(this.WingL, 0.2618f, 0.0f, 0.0f);
        this.WingL.field_78804_l.add(new ModelBox(this.WingL, 96, 49, -0.5f, -0.5f, -1.0f, 1, 1, 12, 0.0f, true));
        this.WingL.field_78804_l.add(new ModelBox(this.WingL, 68, 39, -1.0f, 0.5f, -1.0f, 1, 11, 12, 0.0f, true));
        this.wingl3_r1 = new ModelRenderer((ModelBase)this);
        this.wingl3_r1.func_78793_a(3.0f, 0.0f, 2.0f);
        this.WingL.func_78792_a(this.wingl3_r1);
        this.setRotationAngle(this.wingl3_r1, -0.5236f, 0.0f, 0.0f);
        this.wingl3_r1.field_78804_l.add(new ModelBox(this.wingl3_r1, 98, 51, -3.5f, 5.5f, -1.0f, 1, 1, 10, 0.0f, true));
        this.wingl2_r1 = new ModelRenderer((ModelBase)this);
        this.wingl2_r1.func_78793_a(3.0f, 0.0f, 2.0f);
        this.WingL.func_78792_a(this.wingl2_r1);
        this.setRotationAngle(this.wingl2_r1, -0.2618f, 0.0f, 0.0f);
        this.wingl2_r1.field_78804_l.add(new ModelBox(this.wingl2_r1, 96, 49, -3.5f, 2.5f, -3.0f, 1, 1, 12, 0.0f, true));
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.Head.func_78785_a(f5);
        this.Body.func_78785_a(f5);
        this.RightArm.func_78785_a(f5);
        this.LeftArm.func_78785_a(f5);
        this.WingR.func_78785_a(f5);
        this.WingL.func_78785_a(f5);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.RightArm.field_78795_f = -(Mth.func_76134_b((float)(ageInTicks * 0.1f)) * (float)Math.PI * 0.15f);
        this.LeftArm.field_78795_f = -(Mth.func_76134_b((float)((ageInTicks + 100.0f) * 0.1f)) * (float)Math.PI * 0.15f);
        this.Head.field_78796_g = netHeadYaw * ((float)Math.PI / 180);
        this.Head.field_78795_f = headPitch * ((float)Math.PI / 180);
        this.WingR.field_78796_g = (float)(-0.7853981633974483 - (double)0.7f * Math.cos(ageInTicks * 0.6f));
        this.WingL.field_78796_g = -this.WingR.field_78796_g;
    }
}

