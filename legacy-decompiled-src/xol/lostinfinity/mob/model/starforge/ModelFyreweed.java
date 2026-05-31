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

public class ModelFyreweed
extends ModelBase {
    public ModelRenderer vine1;
    public ModelRenderer bulb;
    public ModelRenderer vine2;
    public ModelRenderer bulb2;
    public ModelRenderer bulb3;
    public ModelRenderer bulb4;
    public ModelRenderer bulb5;
    public ModelRenderer bulb6;

    public ModelFyreweed() {
        this.field_78090_t = 64;
        this.field_78089_u = 64;
        this.bulb = new ModelRenderer((ModelBase)this, 0, 39);
        this.bulb.func_78793_a(0.0f, -5.0f, 0.0f);
        this.bulb.func_78790_a(-6.0f, 16.0f, -6.0f, 12, 12, 12, 0.0f);
        this.bulb5 = new ModelRenderer((ModelBase)this, 0, 39);
        this.bulb5.func_78793_a(0.0f, -5.0f, 0.0f);
        this.bulb5.func_78790_a(3.0f, 14.0f, 3.0f, 3, 2, 3, 0.0f);
        this.bulb3 = new ModelRenderer((ModelBase)this, 0, 39);
        this.bulb3.func_78793_a(0.0f, -5.0f, 0.0f);
        this.bulb3.func_78790_a(-6.0f, 14.0f, -6.0f, 3, 2, 3, 0.0f);
        this.bulb4 = new ModelRenderer((ModelBase)this, 0, 39);
        this.bulb4.func_78793_a(0.0f, -5.0f, 0.0f);
        this.bulb4.func_78790_a(3.0f, 14.0f, -6.0f, 3, 2, 3, 0.0f);
        this.vine1 = new ModelRenderer((ModelBase)this, 0, 0);
        this.vine1.func_78793_a(0.0f, -5.0f, 0.0f);
        this.vine1.func_78790_a(-4.0f, 0.0f, 0.0f, 8, 16, 1, 0.0f);
        this.bulb2 = new ModelRenderer((ModelBase)this, 10, 17);
        this.bulb2.func_78793_a(0.0f, -5.0f, 0.0f);
        this.bulb2.func_78790_a(-5.0f, 17.0f, -5.0f, 10, 10, 10, 0.0f);
        this.bulb6 = new ModelRenderer((ModelBase)this, 0, 39);
        this.bulb6.func_78793_a(0.0f, -5.0f, 0.0f);
        this.bulb6.func_78790_a(-6.0f, 14.0f, 3.0f, 3, 2, 3, 0.0f);
        this.vine2 = new ModelRenderer((ModelBase)this, 43, 0);
        this.vine2.func_78793_a(0.0f, -5.0f, 0.0f);
        this.vine2.func_78790_a(-1.0f, 0.0f, -4.0f, 1, 16, 8, 0.0f);
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.bulb.func_78785_a(f5);
        this.bulb5.func_78785_a(f5);
        this.bulb3.func_78785_a(f5);
        this.bulb4.func_78785_a(f5);
        this.vine1.func_78785_a(f5);
        GlStateManager.func_179147_l();
        GlStateManager.func_179112_b((int)770, (int)771);
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)0.75f);
        this.bulb2.func_78785_a(f5);
        GlStateManager.func_179084_k();
        this.bulb6.func_78785_a(f5);
        this.vine2.func_78785_a(f5);
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.bulb.field_78795_f = Mth.func_76134_b((float)(ageInTicks * 0.05f)) * (float)Math.PI * 0.1f;
        this.bulb.field_78808_h = Mth.func_76134_b((float)(ageInTicks * 0.03f)) * (float)Math.PI * 0.1f;
        this.bulb6.field_78795_f = this.bulb.field_78795_f;
        this.bulb6.field_78808_h = this.bulb.field_78808_h;
        this.bulb5.field_78795_f = this.bulb.field_78795_f;
        this.bulb5.field_78808_h = this.bulb.field_78808_h;
        this.bulb4.field_78795_f = this.bulb.field_78795_f;
        this.bulb4.field_78808_h = this.bulb.field_78808_h;
        this.bulb3.field_78795_f = this.bulb.field_78795_f;
        this.bulb3.field_78808_h = this.bulb.field_78808_h;
        this.bulb2.field_78795_f = this.bulb.field_78795_f;
        this.bulb2.field_78808_h = this.bulb.field_78808_h;
        this.vine1.field_78795_f = this.bulb.field_78795_f;
        this.vine1.field_78808_h = this.bulb.field_78808_h;
        this.vine2.field_78795_f = this.bulb.field_78795_f;
        this.vine2.field_78808_h = this.bulb.field_78808_h;
    }
}

