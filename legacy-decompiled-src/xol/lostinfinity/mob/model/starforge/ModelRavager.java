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
import xol.lostinfinity.mob.entity.starforge.EntityRavager;

public class ModelRavager
extends ModelBase {
    private final ModelRenderer Form1;
    private final ModelRenderer LeftLeg;
    private final ModelRenderer RightLeg;
    private final ModelRenderer LeftArm;
    private final ModelRenderer RightArm;
    private final ModelRenderer Head;
    private final ModelRenderer SpikedTendril4;
    private final ModelRenderer SpikedTendril3;
    private final ModelRenderer SpikedTendril2;
    private final ModelRenderer SpikedTendril1;
    private final ModelRenderer HeadBR;
    private final ModelRenderer HeadTR;
    private final ModelRenderer HeadTL;
    private final ModelRenderer HeadBL;
    private final ModelRenderer Body;
    private final ModelRenderer Body_r1;

    public ModelRavager() {
        this.field_78090_t = 64;
        this.field_78089_u = 64;
        this.Form1 = new ModelRenderer((ModelBase)this);
        this.Form1.func_78793_a(0.0f, 0.0f, 0.0f);
        this.LeftLeg = new ModelRenderer((ModelBase)this);
        this.LeftLeg.func_78793_a(1.9f, 12.0f, 4.0f);
        this.Form1.func_78792_a(this.LeftLeg);
        this.LeftLeg.field_78804_l.add(new ModelBox(this.LeftLeg, 0, 16, -2.0f, 0.0f, -2.0f, 4, 12, 4, 0.0f, true));
        this.RightLeg = new ModelRenderer((ModelBase)this);
        this.RightLeg.func_78793_a(-1.9f, 12.0f, 4.0f);
        this.Form1.func_78792_a(this.RightLeg);
        this.RightLeg.field_78804_l.add(new ModelBox(this.RightLeg, 0, 16, -2.0f, 0.0f, -2.0f, 4, 12, 4, 0.0f, false));
        this.LeftArm = new ModelRenderer((ModelBase)this);
        this.LeftArm.func_78793_a(5.0f, 3.0f, 2.0f);
        this.Form1.func_78792_a(this.LeftArm);
        this.LeftArm.field_78804_l.add(new ModelBox(this.LeftArm, 40, 16, -1.0f, 0.0f, -3.0f, 4, 16, 4, 0.0f, false));
        this.RightArm = new ModelRenderer((ModelBase)this);
        this.RightArm.func_78793_a(-5.0f, 4.0f, 1.0f);
        this.Form1.func_78792_a(this.RightArm);
        this.RightArm.field_78804_l.add(new ModelBox(this.RightArm, 40, 16, -3.0f, -1.0f, -2.0f, 4, 16, 4, 0.0f, true));
        this.Head = new ModelRenderer((ModelBase)this);
        this.Head.func_78793_a(0.0f, -1.0f, 0.0f);
        this.Form1.func_78792_a(this.Head);
        this.SpikedTendril4 = new ModelRenderer((ModelBase)this);
        this.SpikedTendril4.func_78793_a(-2.5f, -5.5f, 3.0f);
        this.Head.func_78792_a(this.SpikedTendril4);
        this.SpikedTendril4.field_78804_l.add(new ModelBox(this.SpikedTendril4, 38, 37, -0.5f, -0.5f, -10.0f, 1, 1, 11, 0.0f, false));
        this.SpikedTendril4.field_78804_l.add(new ModelBox(this.SpikedTendril4, 42, 43, -0.5f, -1.5f, -7.0f, 1, 2, 1, -0.25f, false));
        this.SpikedTendril4.field_78804_l.add(new ModelBox(this.SpikedTendril4, 42, 43, -0.5f, -1.5f, -9.0f, 1, 2, 1, -0.25f, false));
        this.SpikedTendril4.field_78804_l.add(new ModelBox(this.SpikedTendril4, 42, 43, -0.5f, -1.5f, -5.0f, 1, 2, 1, -0.25f, false));
        this.SpikedTendril4.field_78804_l.add(new ModelBox(this.SpikedTendril4, 42, 43, -0.5f, -0.5f, -6.0f, 1, 2, 1, -0.25f, false));
        this.SpikedTendril4.field_78804_l.add(new ModelBox(this.SpikedTendril4, 42, 43, -0.5f, -0.5f, -8.0f, 1, 2, 1, -0.25f, false));
        this.SpikedTendril4.field_78804_l.add(new ModelBox(this.SpikedTendril4, 42, 40, -1.5f, -0.5f, -9.5f, 2, 1, 1, -0.25f, false));
        this.SpikedTendril4.field_78804_l.add(new ModelBox(this.SpikedTendril4, 42, 40, -1.5f, -0.5f, -7.5f, 2, 1, 1, -0.25f, false));
        this.SpikedTendril4.field_78804_l.add(new ModelBox(this.SpikedTendril4, 42, 40, -1.5f, -0.5f, -5.5f, 2, 1, 1, -0.25f, false));
        this.SpikedTendril4.field_78804_l.add(new ModelBox(this.SpikedTendril4, 42, 40, -0.5f, -0.5f, -6.5f, 2, 1, 1, -0.25f, false));
        this.SpikedTendril4.field_78804_l.add(new ModelBox(this.SpikedTendril4, 42, 40, -0.5f, -0.5f, -8.5f, 2, 1, 1, -0.25f, false));
        this.SpikedTendril4.field_78804_l.add(new ModelBox(this.SpikedTendril4, 42, 43, -0.5f, -0.5f, -10.0f, 1, 2, 1, -0.25f, false));
        this.SpikedTendril3 = new ModelRenderer((ModelBase)this);
        this.SpikedTendril3.func_78793_a(2.5f, -5.5f, 3.0f);
        this.Head.func_78792_a(this.SpikedTendril3);
        this.SpikedTendril3.field_78804_l.add(new ModelBox(this.SpikedTendril3, 38, 37, -0.5f, -0.5f, -10.0f, 1, 1, 11, 0.0f, false));
        this.SpikedTendril3.field_78804_l.add(new ModelBox(this.SpikedTendril3, 42, 43, -0.5f, -1.5f, -7.0f, 1, 2, 1, -0.25f, false));
        this.SpikedTendril3.field_78804_l.add(new ModelBox(this.SpikedTendril3, 42, 43, -0.5f, -1.5f, -9.0f, 1, 2, 1, -0.25f, false));
        this.SpikedTendril3.field_78804_l.add(new ModelBox(this.SpikedTendril3, 42, 43, -0.5f, -1.5f, -5.0f, 1, 2, 1, -0.25f, false));
        this.SpikedTendril3.field_78804_l.add(new ModelBox(this.SpikedTendril3, 42, 43, -0.5f, -0.5f, -6.0f, 1, 2, 1, -0.25f, false));
        this.SpikedTendril3.field_78804_l.add(new ModelBox(this.SpikedTendril3, 42, 43, -0.5f, -0.5f, -8.0f, 1, 2, 1, -0.25f, false));
        this.SpikedTendril3.field_78804_l.add(new ModelBox(this.SpikedTendril3, 42, 40, -1.5f, -0.5f, -9.5f, 2, 1, 1, -0.25f, false));
        this.SpikedTendril3.field_78804_l.add(new ModelBox(this.SpikedTendril3, 42, 40, -1.5f, -0.5f, -7.5f, 2, 1, 1, -0.25f, false));
        this.SpikedTendril3.field_78804_l.add(new ModelBox(this.SpikedTendril3, 42, 40, -1.5f, -0.5f, -5.5f, 2, 1, 1, -0.25f, false));
        this.SpikedTendril3.field_78804_l.add(new ModelBox(this.SpikedTendril3, 42, 40, -0.5f, -0.5f, -6.5f, 2, 1, 1, -0.25f, false));
        this.SpikedTendril3.field_78804_l.add(new ModelBox(this.SpikedTendril3, 42, 40, -0.5f, -0.5f, -8.5f, 2, 1, 1, -0.25f, false));
        this.SpikedTendril3.field_78804_l.add(new ModelBox(this.SpikedTendril3, 42, 43, -0.5f, -0.5f, -10.0f, 1, 2, 1, -0.25f, false));
        this.SpikedTendril2 = new ModelRenderer((ModelBase)this);
        this.SpikedTendril2.func_78793_a(2.5f, -2.5f, 3.0f);
        this.Head.func_78792_a(this.SpikedTendril2);
        this.SpikedTendril2.field_78804_l.add(new ModelBox(this.SpikedTendril2, 38, 37, -0.5f, -0.5f, -10.0f, 1, 1, 11, 0.0f, false));
        this.SpikedTendril2.field_78804_l.add(new ModelBox(this.SpikedTendril2, 42, 43, -0.5f, -1.5f, -7.0f, 1, 2, 1, -0.25f, false));
        this.SpikedTendril2.field_78804_l.add(new ModelBox(this.SpikedTendril2, 42, 43, -0.5f, -1.5f, -9.0f, 1, 2, 1, -0.25f, false));
        this.SpikedTendril2.field_78804_l.add(new ModelBox(this.SpikedTendril2, 42, 43, -0.5f, -1.5f, -5.0f, 1, 2, 1, -0.25f, false));
        this.SpikedTendril2.field_78804_l.add(new ModelBox(this.SpikedTendril2, 42, 43, -0.5f, -0.5f, -6.0f, 1, 2, 1, -0.25f, false));
        this.SpikedTendril2.field_78804_l.add(new ModelBox(this.SpikedTendril2, 42, 43, -0.5f, -0.5f, -8.0f, 1, 2, 1, -0.25f, false));
        this.SpikedTendril2.field_78804_l.add(new ModelBox(this.SpikedTendril2, 42, 40, -1.5f, -0.5f, -9.5f, 2, 1, 1, -0.25f, false));
        this.SpikedTendril2.field_78804_l.add(new ModelBox(this.SpikedTendril2, 42, 40, -1.5f, -0.5f, -7.5f, 2, 1, 1, -0.25f, false));
        this.SpikedTendril2.field_78804_l.add(new ModelBox(this.SpikedTendril2, 42, 40, -1.5f, -0.5f, -5.5f, 2, 1, 1, -0.25f, false));
        this.SpikedTendril2.field_78804_l.add(new ModelBox(this.SpikedTendril2, 42, 40, -0.5f, -0.5f, -6.5f, 2, 1, 1, -0.25f, false));
        this.SpikedTendril2.field_78804_l.add(new ModelBox(this.SpikedTendril2, 42, 40, -0.5f, -0.5f, -8.5f, 2, 1, 1, -0.25f, false));
        this.SpikedTendril2.field_78804_l.add(new ModelBox(this.SpikedTendril2, 42, 43, -0.5f, -0.5f, -10.0f, 1, 2, 1, -0.25f, false));
        this.SpikedTendril1 = new ModelRenderer((ModelBase)this);
        this.SpikedTendril1.func_78793_a(-2.5f, -2.5f, 3.0f);
        this.Head.func_78792_a(this.SpikedTendril1);
        this.SpikedTendril1.field_78804_l.add(new ModelBox(this.SpikedTendril1, 38, 37, -0.5f, -0.5f, -10.0f, 1, 1, 11, 0.0f, false));
        this.SpikedTendril1.field_78804_l.add(new ModelBox(this.SpikedTendril1, 42, 43, -0.5f, -1.5f, -7.0f, 1, 2, 1, -0.25f, false));
        this.SpikedTendril1.field_78804_l.add(new ModelBox(this.SpikedTendril1, 42, 43, -0.5f, -1.5f, -9.0f, 1, 2, 1, -0.25f, false));
        this.SpikedTendril1.field_78804_l.add(new ModelBox(this.SpikedTendril1, 42, 43, -0.5f, -1.5f, -5.0f, 1, 2, 1, -0.25f, false));
        this.SpikedTendril1.field_78804_l.add(new ModelBox(this.SpikedTendril1, 42, 43, -0.5f, -0.5f, -6.0f, 1, 2, 1, -0.25f, false));
        this.SpikedTendril1.field_78804_l.add(new ModelBox(this.SpikedTendril1, 42, 43, -0.5f, -0.5f, -8.0f, 1, 2, 1, -0.25f, false));
        this.SpikedTendril1.field_78804_l.add(new ModelBox(this.SpikedTendril1, 42, 40, -1.5f, -0.5f, -9.5f, 2, 1, 1, -0.25f, false));
        this.SpikedTendril1.field_78804_l.add(new ModelBox(this.SpikedTendril1, 42, 40, -1.5f, -0.5f, -7.5f, 2, 1, 1, -0.25f, false));
        this.SpikedTendril1.field_78804_l.add(new ModelBox(this.SpikedTendril1, 42, 40, -1.5f, -0.5f, -5.5f, 2, 1, 1, -0.25f, false));
        this.SpikedTendril1.field_78804_l.add(new ModelBox(this.SpikedTendril1, 42, 40, -0.5f, -0.5f, -6.5f, 2, 1, 1, -0.25f, false));
        this.SpikedTendril1.field_78804_l.add(new ModelBox(this.SpikedTendril1, 42, 40, -0.5f, -0.5f, -8.5f, 2, 1, 1, -0.25f, false));
        this.SpikedTendril1.field_78804_l.add(new ModelBox(this.SpikedTendril1, 42, 43, -0.5f, -0.5f, -10.0f, 1, 2, 1, -0.25f, false));
        this.HeadBR = new ModelRenderer((ModelBase)this);
        this.HeadBR.func_78793_a(0.0f, -4.0f, 4.0f);
        this.Head.func_78792_a(this.HeadBR);
        this.HeadBR.field_78804_l.add(new ModelBox(this.HeadBR, 0, 0, -4.0f, 0.0f, -12.0f, 4, 4, 12, 0.0f, false));
        this.HeadTR = new ModelRenderer((ModelBase)this);
        this.HeadTR.func_78793_a(0.0f, -4.0f, 4.0f);
        this.Head.func_78792_a(this.HeadTR);
        this.HeadTR.field_78804_l.add(new ModelBox(this.HeadTR, 33, 0, -4.0f, -4.0f, -12.0f, 4, 4, 12, 0.0f, false));
        this.HeadTL = new ModelRenderer((ModelBase)this);
        this.HeadTL.func_78793_a(0.0f, -4.0f, 4.0f);
        this.Head.func_78792_a(this.HeadTL);
        this.HeadTL.field_78804_l.add(new ModelBox(this.HeadTL, 33, 0, 0.0f, -4.0f, -12.0f, 4, 4, 12, 0.0f, true));
        this.HeadBL = new ModelRenderer((ModelBase)this);
        this.HeadBL.func_78793_a(0.0f, -4.0f, 4.0f);
        this.Head.func_78792_a(this.HeadBL);
        this.HeadBL.field_78804_l.add(new ModelBox(this.HeadBL, 0, 0, 0.0f, 0.0f, -12.0f, 4, 4, 12, 0.0f, true));
        this.Body = new ModelRenderer((ModelBase)this);
        this.Body.func_78793_a(0.0f, 0.0f, 0.0f);
        this.Form1.func_78792_a(this.Body);
        this.Body.field_78804_l.add(new ModelBox(this.Body, 17, 33, -4.0f, -9.0f, 4.0f, 8, 10, 3, 0.2f, false));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 16, 47, -4.0f, 0.0f, 2.0f, 8, 4, 4, 0.0f, false));
        this.Body_r1 = new ModelRenderer((ModelBase)this);
        this.Body_r1.func_78793_a(0.0f, 7.0f, 0.0f);
        this.Body.func_78792_a(this.Body_r1);
        this.setRotationAngle(this.Body_r1, 0.3491f, 0.0f, 0.0f);
        this.Body_r1.field_78804_l.add(new ModelBox(this.Body_r1, 16, 16, -4.0f, -5.0f, 0.0f, 8, 12, 4, 0.2f, false));
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.Form1.func_78785_a(f5);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.Head.field_78795_f = headPitch * ((float)Math.PI / 180);
        this.RightLeg.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f)) * 1.4f * limbSwingAmount * 0.5f;
        this.LeftLeg.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f + (float)Math.PI)) * 1.4f * limbSwingAmount * 0.5f;
        this.LeftArm.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f)) * 2.0f * limbSwingAmount * 0.5f;
        this.RightArm.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f + (float)Math.PI)) * 2.0f * limbSwingAmount * 0.5f;
        EntityRavager entity = (EntityRavager)entityIn;
        if (entity.getAngry()) {
            this.HeadBR.field_78795_f = Mth.func_76134_b((float)(ageInTicks * 0.1f)) * 0.25f + 0.5f;
            this.HeadBR.field_78808_h = Mth.func_76134_b((float)(ageInTicks * 0.1f)) * 0.25f + 0.5f;
            this.SpikedTendril1.field_78795_f = Mth.func_76134_b((float)(ageInTicks * 0.1f)) * 0.1f;
            this.SpikedTendril2.field_78795_f = Mth.func_76134_b((float)((ageInTicks + 2.0f) * 0.1f)) * 0.1f;
            this.SpikedTendril3.field_78795_f = Mth.func_76126_a((float)(ageInTicks * 0.1f)) * 0.1f;
            this.SpikedTendril4.field_78795_f = Mth.func_76126_a((float)((ageInTicks + 2.0f) * 0.1f)) * 0.1f;
        } else {
            this.HeadBR.field_78795_f = 0.0f;
            this.HeadBR.field_78808_h = 0.0f;
            this.SpikedTendril1.field_78795_f = 0.0f;
            this.SpikedTendril2.field_78795_f = 0.0f;
            this.SpikedTendril3.field_78795_f = 0.0f;
            this.SpikedTendril4.field_78795_f = 0.0f;
        }
        this.HeadTR.field_78795_f = -this.HeadBR.field_78795_f;
        this.HeadTR.field_78808_h = -this.HeadBR.field_78808_h;
        this.HeadTL.field_78795_f = -this.HeadBR.field_78795_f;
        this.HeadTL.field_78808_h = this.HeadBR.field_78808_h;
        this.HeadBL.field_78795_f = this.HeadBR.field_78795_f;
        this.HeadBL.field_78808_h = -this.HeadBR.field_78808_h;
    }
}

