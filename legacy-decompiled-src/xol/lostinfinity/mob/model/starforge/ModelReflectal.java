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
import xol.lostinfinity.mob.entity.starforge.EntityReflectal;

public class ModelReflectal
extends ModelBase {
    public ModelRenderer legbl;
    public ModelRenderer legfl;
    public ModelRenderer legbr;
    public ModelRenderer legfr;
    public ModelRenderer head;
    public ModelRenderer horn1;
    public ModelRenderer horn2;
    public ModelRenderer headbar1;
    public ModelRenderer headbar2;
    public ModelRenderer headbar3;
    public ModelRenderer headbar4;
    public ModelRenderer body;
    public ModelRenderer flap2;
    public ModelRenderer flap1;

    public ModelReflectal() {
        this.field_78090_t = 64;
        this.field_78089_u = 64;
        this.headbar1 = new ModelRenderer((ModelBase)this, 26, 0);
        this.headbar1.func_78793_a(0.0f, 12.0f, -6.0f);
        this.headbar1.func_78790_a(-3.5f, 5.0f, -2.5f, 1, 1, 4, 0.0f);
        this.setRotateAngle(this.headbar1, -0.34906584f, 0.0f, 0.0f);
        this.legfl = new ModelRenderer((ModelBase)this, 0, 36);
        this.legfl.field_78809_i = true;
        this.legfl.func_78793_a(3.5f, 18.0f, -5.0f);
        this.legfl.func_78790_a(-2.0f, 0.0f, -2.0f, 4, 6, 4, 0.0f);
        this.headbar2 = new ModelRenderer((ModelBase)this, 26, 0);
        this.headbar2.func_78793_a(0.0f, 12.0f, -6.0f);
        this.headbar2.func_78790_a(2.5f, 5.0f, -2.5f, 1, 1, 4, 0.0f);
        this.setRotateAngle(this.headbar2, -0.34906584f, 0.0f, 0.0f);
        this.body = new ModelRenderer((ModelBase)this, 28, 8);
        this.body.func_78793_a(0.0f, 9.5f, 1.0f);
        this.body.func_78790_a(-5.0f, -10.0f, -7.0f, 10, 16, 8, 0.0f);
        this.setRotateAngle(this.body, 1.8325957f, 0.0f, 0.0f);
        this.flap1 = new ModelRenderer((ModelBase)this, 28, 35);
        this.flap1.func_78793_a(-2.5f, 8.9f, -2.0f);
        this.flap1.func_78790_a(-2.0f, 0.0f, 0.0f, 4, 1, 12, 0.0f);
        this.setRotateAngle(this.flap1, 0.2617994f, 0.0f, 0.0f);
        this.flap2 = new ModelRenderer((ModelBase)this, 28, 35);
        this.flap2.func_78793_a(2.5f, 8.9f, -2.0f);
        this.flap2.func_78790_a(-2.0f, 0.0f, 0.0f, 4, 1, 12, 0.0f);
        this.setRotateAngle(this.flap2, 0.2617994f, 0.0f, 0.0f);
        this.horn2 = new ModelRenderer((ModelBase)this, 0, 50);
        this.horn2.field_78809_i = true;
        this.horn2.func_78793_a(0.0f, 12.0f, -6.0f);
        this.horn2.func_78790_a(0.5f, -3.5f, -9.0f, 3, 3, 3, 0.0f);
        this.setRotateAngle(this.horn2, -0.34906584f, 0.0f, 0.0f);
        this.headbar3 = new ModelRenderer((ModelBase)this, 26, 0);
        this.headbar3.func_78793_a(0.0f, 12.0f, -6.0f);
        this.headbar3.func_78790_a(2.5f, -3.0f, -2.0f, 1, 1, 4, 0.0f);
        this.setRotateAngle(this.headbar3, -0.34906584f, 0.0f, 0.0f);
        this.legfr = new ModelRenderer((ModelBase)this, 0, 36);
        this.legfr.func_78793_a(-3.5f, 18.0f, -5.0f);
        this.legfr.func_78790_a(-2.0f, 0.0f, -2.0f, 4, 6, 4, 0.0f);
        this.head = new ModelRenderer((ModelBase)this, 0, 0);
        this.head.func_78793_a(0.0f, 12.0f, -6.0f);
        this.head.func_78790_a(-4.0f, -4.0f, -6.0f, 8, 12, 4, 0.0f);
        this.setRotateAngle(this.head, -0.34906584f, 0.0f, 0.0f);
        this.horn1 = new ModelRenderer((ModelBase)this, 0, 50);
        this.horn1.func_78793_a(0.0f, 12.0f, -6.0f);
        this.horn1.func_78790_a(-3.5f, -3.5f, -9.0f, 3, 3, 3, 0.0f);
        this.setRotateAngle(this.horn1, -0.34906584f, 0.0f, 0.0f);
        this.legbl = new ModelRenderer((ModelBase)this, 0, 19);
        this.legbl.field_78809_i = true;
        this.legbl.func_78793_a(3.5f, 14.0f, 7.0f);
        this.legbl.func_78790_a(-2.0f, 0.0f, -2.0f, 4, 10, 4, 0.0f);
        this.legbr = new ModelRenderer((ModelBase)this, 0, 19);
        this.legbr.func_78793_a(-3.5f, 14.0f, 7.0f);
        this.legbr.func_78790_a(-2.0f, 0.0f, -2.0f, 4, 10, 4, 0.0f);
        this.headbar4 = new ModelRenderer((ModelBase)this, 26, 0);
        this.headbar4.func_78793_a(0.0f, 12.0f, -6.0f);
        this.headbar4.func_78790_a(-3.5f, -3.0f, -2.0f, 1, 1, 4, 0.0f);
        this.setRotateAngle(this.headbar4, -0.34906584f, 0.0f, 0.0f);
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        GlStateManager.func_179147_l();
        GlStateManager.func_179112_b((int)770, (int)771);
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)0.9f);
        this.headbar1.func_78785_a(f5);
        this.legfl.func_78785_a(f5);
        this.headbar2.func_78785_a(f5);
        this.body.func_78785_a(f5);
        this.flap1.func_78785_a(f5);
        this.flap2.func_78785_a(f5);
        this.horn2.func_78785_a(f5);
        this.headbar3.func_78785_a(f5);
        this.legfr.func_78785_a(f5);
        this.head.func_78785_a(f5);
        this.horn1.func_78785_a(f5);
        this.legbl.func_78785_a(f5);
        this.legbr.func_78785_a(f5);
        this.headbar4.func_78785_a(f5);
        GlStateManager.func_179084_k();
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.legbr.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f)) * 1.4f * limbSwingAmount;
        this.legbl.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f + (float)Math.PI)) * 1.4f * limbSwingAmount;
        this.legfr.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f + (float)Math.PI)) * 1.4f * limbSwingAmount;
        this.legfl.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f)) * 1.4f * limbSwingAmount;
        EntityReflectal entity = (EntityReflectal)entityIn;
        float additive = entity.getDefending() ? 0.5f + Mth.func_76126_a((float)(ageInTicks * 2.0f)) * 0.25f : 0.0f;
        this.flap1.field_78795_f = 0.2617994f + additive;
        this.flap2.field_78795_f = 0.2617994f + additive;
    }
}

