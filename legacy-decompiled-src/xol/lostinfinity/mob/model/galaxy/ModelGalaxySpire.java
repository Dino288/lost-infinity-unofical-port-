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
package xol.lostinfinity.mob.model.galaxy;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;

public class ModelGalaxySpire
extends ModelBase {
    public ModelRenderer orb;
    public ModelRenderer base1;
    public ModelRenderer base2;
    public ModelRenderer base3;
    public ModelRenderer flap2;
    public ModelRenderer flap1;
    public ModelRenderer flap3;
    public ModelRenderer flap4;
    public ModelRenderer flap5;
    public ModelRenderer flap6;
    public ModelRenderer flap7;
    public ModelRenderer flap8;

    public ModelGalaxySpire() {
        this.field_78090_t = 128;
        this.field_78089_u = 64;
        this.flap3 = new ModelRenderer((ModelBase)this, 51, 2);
        this.flap3.func_78793_a(0.0f, 22.0f, -9.5f);
        this.flap3.func_78790_a(-4.0f, -10.0f, 0.0f, 8, 10, 1, 0.0f);
        this.setRotateAngle(this.flap3, 0.2617994f, 0.0f, 0.0f);
        this.flap6 = new ModelRenderer((ModelBase)this, 51, 2);
        this.flap6.func_78793_a(-7.0f, 12.5f, 0.0f);
        this.flap6.func_78790_a(-4.0f, -10.0f, 0.0f, 8, 10, 1, 0.0f);
        this.setRotateAngle(this.flap6, -0.5235988f, -1.5707964f, 0.0f);
        this.flap8 = new ModelRenderer((ModelBase)this, 51, 2);
        this.flap8.func_78793_a(-8.0f, 22.0f, 0.0f);
        this.flap8.func_78790_a(-4.0f, -10.0f, 0.0f, 8, 10, 1, 0.0f);
        this.setRotateAngle(this.flap8, -0.2617994f, -1.5707964f, 0.0f);
        this.base1 = new ModelRenderer((ModelBase)this, 55, 8);
        this.base1.func_78793_a(0.0f, 12.0f, 0.0f);
        this.base1.func_78790_a(-9.0f, 0.0f, -9.0f, 18, 10, 18, 0.0f);
        this.flap5 = new ModelRenderer((ModelBase)this, 51, 2);
        this.flap5.func_78793_a(8.0f, 12.5f, 0.0f);
        this.flap5.func_78790_a(-4.0f, -10.0f, 0.0f, 8, 10, 1, 0.0f);
        this.setRotateAngle(this.flap5, 0.5235988f, -1.5707964f, 0.0f);
        this.base3 = new ModelRenderer((ModelBase)this, 40, 39);
        this.base3.func_78793_a(0.0f, 22.0f, 0.0f);
        this.base3.func_78790_a(-11.0f, 0.0f, -11.0f, 22, 2, 22, 0.0f);
        this.flap2 = new ModelRenderer((ModelBase)this, 51, 2);
        this.flap2.func_78793_a(0.0f, 12.5f, 8.0f);
        this.flap2.func_78790_a(-4.0f, -10.0f, 0.0f, 8, 10, 1, 0.0f);
        this.setRotateAngle(this.flap2, -0.5235988f, 0.0f, 0.0f);
        this.flap7 = new ModelRenderer((ModelBase)this, 51, 2);
        this.flap7.func_78793_a(9.0f, 22.0f, 0.0f);
        this.flap7.func_78790_a(-4.0f, -10.0f, 0.0f, 8, 10, 1, 0.0f);
        this.setRotateAngle(this.flap7, 0.2617994f, -1.5707964f, 0.0f);
        this.flap4 = new ModelRenderer((ModelBase)this, 51, 2);
        this.flap4.func_78793_a(0.0f, 22.0f, 8.5f);
        this.flap4.func_78790_a(-4.0f, -10.0f, 0.0f, 8, 10, 1, 0.0f);
        this.setRotateAngle(this.flap4, -0.2617994f, 0.0f, 0.0f);
        this.base2 = new ModelRenderer((ModelBase)this, 0, 0);
        this.base2.func_78793_a(0.0f, 4.0f, 0.0f);
        this.base2.func_78790_a(-8.0f, 0.0f, -8.0f, 16, 8, 16, 0.0f);
        this.flap1 = new ModelRenderer((ModelBase)this, 51, 2);
        this.flap1.func_78793_a(0.0f, 12.5f, -9.0f);
        this.flap1.func_78790_a(-4.0f, -10.0f, 0.0f, 8, 10, 1, 0.0f);
        this.setRotateAngle(this.flap1, 0.5235988f, 0.0f, 0.0f);
        this.orb = new ModelRenderer((ModelBase)this, 0, 25);
        this.orb.func_78793_a(0.0f, -4.0f, 0.0f);
        this.orb.func_78790_a(-6.0f, -6.0f, -6.0f, 12, 12, 12, 0.0f);
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.base3.func_78785_a(f5);
        this.flap2.func_78785_a(f5);
        this.base1.func_78785_a(f5);
        this.flap3.func_78785_a(f5);
        GlStateManager.func_179147_l();
        GlStateManager.func_179112_b((int)770, (int)771);
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)(0.6f + 0.2f * Mth.func_76126_a((float)(f2 * 0.1f))));
        this.orb.func_78785_a(f5);
        GlStateManager.func_179084_k();
        this.flap5.func_78785_a(f5);
        this.flap1.func_78785_a(f5);
        this.flap4.func_78785_a(f5);
        this.base2.func_78785_a(f5);
        this.flap8.func_78785_a(f5);
        this.flap7.func_78785_a(f5);
        this.flap6.func_78785_a(f5);
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.orb.field_78796_g = ageInTicks * 0.02f;
        this.flap1.field_78795_f = Mth.func_76134_b((float)(ageInTicks * 0.1f)) * (float)Math.PI * 0.05f + 0.3f;
        this.flap2.field_78795_f = -1.0f * (Mth.func_76134_b((float)(ageInTicks * 0.1f)) * (float)Math.PI * 0.05f + 0.3f);
        this.flap3.field_78795_f = Mth.func_76134_b((float)(ageInTicks * 0.1f)) * (float)Math.PI * 0.1f + 0.5f;
        this.flap4.field_78795_f = -1.0f * (Mth.func_76134_b((float)(ageInTicks * 0.1f)) * (float)Math.PI * 0.1f + 0.5f);
        this.flap5.field_78808_h = Mth.func_76134_b((float)(ageInTicks * 0.1f)) * (float)Math.PI * 0.05f + 0.3f;
        this.flap7.field_78808_h = Mth.func_76134_b((float)(ageInTicks * 0.1f)) * (float)Math.PI * 0.1f + 0.5f;
        this.flap6.field_78808_h = -1.0f * (Mth.func_76134_b((float)(ageInTicks * 0.1f)) * (float)Math.PI * 0.05f + 0.3f);
        this.flap8.field_78808_h = -1.0f * (Mth.func_76134_b((float)(ageInTicks * 0.1f)) * (float)Math.PI * 0.1f + 0.5f);
    }
}

