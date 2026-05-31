/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.model.ModelRenderer
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.math.Mth
 */
package xol.lostinfinity.mob.model.starforge;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;

public class ModelPhaser
extends ModelBase {
    public ModelRenderer legr;
    public ModelRenderer bodyR;
    public ModelRenderer legl;
    public ModelRenderer bodyL;
    public ModelRenderer bodyR2;
    public ModelRenderer bodyL2;
    public ModelRenderer legr2;
    public ModelRenderer legl2;
    public ModelRenderer headR2;
    public ModelRenderer headL2;
    public ModelRenderer headL;
    public ModelRenderer headR;
    public ModelRenderer headL3;
    public ModelRenderer headR3;

    public ModelPhaser() {
        this.field_78090_t = 64;
        this.field_78089_u = 64;
        this.legr = new ModelRenderer((ModelBase)this, 0, 16);
        this.legr.func_78793_a(-1.9f, 12.0f, 0.1f);
        this.legr.func_78790_a(-2.0f, 0.0f, 0.0f, 4, 13, 2, 0.0f);
        this.setRotateAngle(this.legr, 0.0f, 0.0f, 0.5235988f);
        this.legl2 = new ModelRenderer((ModelBase)this, 24, 55);
        this.legl2.func_78793_a(1.9f, 12.0f, 0.1f);
        this.legl2.func_78790_a(-2.0f, 11.0f, -6.0f, 4, 2, 6, 0.0f);
        this.setRotateAngle(this.legl2, -0.0f, 0.0f, -0.5235988f);
        this.headL2 = new ModelRenderer((ModelBase)this, 25, 0);
        this.headL2.func_78793_a(10.0f, 3.0f, 0.0f);
        this.headL2.func_78790_a(-1.5f, -3.0f, -3.5f, 3, 3, 2, 0.0f);
        this.bodyL2 = new ModelRenderer((ModelBase)this, 16, 45);
        this.bodyL2.func_78793_a(-1.0f, 2.5f, 0.0f);
        this.bodyL2.func_78790_a(2.0f, -1.5f, -2.0f, 10, 4, 4, 0.0f);
        this.headR2 = new ModelRenderer((ModelBase)this, 31, 16);
        this.headR2.func_78793_a(-10.0f, 3.0f, 0.0f);
        this.headR2.func_78790_a(-1.5f, -3.0f, -3.5f, 3, 3, 2, 0.0f);
        this.bodyL = new ModelRenderer((ModelBase)this, 37, 16);
        this.bodyL.func_78793_a(0.0f, 1.5f, 0.0f);
        this.bodyL.func_78790_a(0.0f, 0.0f, -3.0f, 4, 12, 6, 0.0f);
        this.bodyR = new ModelRenderer((ModelBase)this, 16, 16);
        this.bodyR.func_78793_a(0.0f, 1.5f, 0.0f);
        this.bodyR.func_78790_a(-4.0f, 0.0f, -3.0f, 4, 12, 6, 0.0f);
        this.legl = new ModelRenderer((ModelBase)this, 0, 35);
        this.legl.func_78793_a(1.9f, 12.0f, 0.1f);
        this.legl.func_78790_a(-2.0f, 0.0f, 0.0f, 4, 13, 2, 0.0f);
        this.setRotateAngle(this.legl, -0.0f, 0.0f, -0.5235988f);
        this.headR = new ModelRenderer((ModelBase)this, 0, 0);
        this.headR.func_78793_a(-10.0f, 3.0f, 0.0f);
        this.headR.func_78790_a(-4.0f, 0.0f, -4.0f, 8, 8, 8, 0.0f);
        this.bodyR2 = new ModelRenderer((ModelBase)this, 16, 35);
        this.bodyR2.func_78793_a(-1.0f, 2.5f, 0.0f);
        this.bodyR2.func_78790_a(-10.0f, -1.5f, -2.0f, 10, 4, 4, 0.0f);
        this.legr2 = new ModelRenderer((ModelBase)this, 0, 55);
        this.legr2.func_78793_a(-1.9f, 12.0f, 0.1f);
        this.legr2.func_78790_a(-2.0f, 11.0f, -6.0f, 4, 2, 6, 0.0f);
        this.setRotateAngle(this.legr2, 0.0f, 0.0f, 0.5235988f);
        this.headL3 = new ModelRenderer((ModelBase)this, 45, 52);
        this.headL3.func_78793_a(0.0f, 4.0f, -3.5f);
        this.headL3.func_78790_a(-3.0f, -3.0f, 0.0f, 6, 6, 1, 0.0f);
        this.headR3 = new ModelRenderer((ModelBase)this, 45, 37);
        this.headR3.func_78793_a(0.0f, 4.0f, -3.5f);
        this.headR3.func_78790_a(-3.0f, -3.0f, 0.0f, 6, 6, 1, 0.0f);
        this.setRotateAngle(this.headR3, 0.0f, 0.15707964f, 0.0f);
        this.headL = new ModelRenderer((ModelBase)this, 32, 0);
        this.headL.func_78793_a(10.0f, 3.0f, 0.0f);
        this.headL.func_78790_a(-4.0f, 0.0f, -4.0f, 8, 8, 8, 0.0f);
        this.headL.func_78792_a(this.headL3);
        this.headR.func_78792_a(this.headR3);
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        GlStateManager.func_179147_l();
        GlStateManager.func_179112_b((int)770, (int)771);
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)(0.75f + (float)Math.sin((double)f2 * 0.05)));
        this.legr.func_78785_a(f5);
        this.headR2.func_78785_a(f5);
        this.bodyR.func_78785_a(f5);
        this.headR.func_78785_a(f5);
        this.bodyR2.func_78785_a(f5);
        this.legr2.func_78785_a(f5);
        GlStateManager.func_179084_k();
        GlStateManager.func_179147_l();
        GlStateManager.func_179112_b((int)770, (int)771);
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)(0.75f + (float)Math.sin((double)f2 * 0.05 + Math.PI)));
        this.legl2.func_78785_a(f5);
        this.headL2.func_78785_a(f5);
        this.bodyL2.func_78785_a(f5);
        this.bodyL.func_78785_a(f5);
        this.legl.func_78785_a(f5);
        this.headL.func_78785_a(f5);
        GlStateManager.func_179084_k();
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.headR.field_78795_f = headPitch * ((float)Math.PI / 180);
        this.headR.field_78796_g = netHeadYaw * ((float)Math.PI / 180);
        this.headR2.field_78795_f = headPitch * ((float)Math.PI / 180);
        this.headR2.field_78796_g = netHeadYaw * ((float)Math.PI / 180);
        this.headL.field_78795_f = headPitch * ((float)Math.PI / 180);
        this.headL.field_78796_g = netHeadYaw * ((float)Math.PI / 180);
        this.headL2.field_78795_f = headPitch * ((float)Math.PI / 180);
        this.headL2.field_78796_g = netHeadYaw * ((float)Math.PI / 180);
        this.headR3.field_78808_h = ageInTicks * 0.5f;
        this.headL3.field_78808_h = ageInTicks * -0.5f;
        this.legr.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f)) * 1.4f * limbSwingAmount;
        this.legl.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f + (float)Math.PI)) * 1.4f * limbSwingAmount;
        this.legr2.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f)) * 1.4f * limbSwingAmount;
        this.legl2.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f + (float)Math.PI)) * 1.4f * limbSwingAmount;
    }
}

