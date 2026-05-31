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
import xol.lostinfinity.mob.entity.starforge.EntityClyster;

public class ModelClyster
extends ModelBase {
    public ModelRenderer body;
    public ModelRenderer legbl;
    public ModelRenderer legfl;
    public ModelRenderer legbr;
    public ModelRenderer legfr;
    public ModelRenderer head1;
    public ModelRenderer head2;
    public ModelRenderer rot1;
    public ModelRenderer rot2;
    public ModelRenderer rot3;
    public ModelRenderer rot4;
    public ModelRenderer fin1;
    public ModelRenderer fin2;

    public ModelClyster() {
        this.field_78090_t = 64;
        this.field_78089_u = 64;
        this.head2 = new ModelRenderer((ModelBase)this, 0, 0);
        this.head2.field_78809_i = true;
        this.head2.func_78793_a(0.0f, 11.0f, -8.0f);
        this.head2.func_78790_a(2.0f, -4.0f, -3.0f, 2, 8, 6, 0.0f);
        this.rot4 = new ModelRenderer((ModelBase)this, 39, 27);
        this.rot4.field_78809_i = true;
        this.rot4.func_78793_a(0.0f, 11.0f, -8.0f);
        this.rot4.func_78790_a(-2.0f, -1.0f, -8.0f, 4, 2, 8, 0.0f);
        this.head1 = new ModelRenderer((ModelBase)this, 0, 0);
        this.head1.func_78793_a(0.0f, 11.0f, -8.0f);
        this.head1.func_78790_a(-4.0f, -4.0f, -3.0f, 2, 8, 6, 0.0f);
        this.legfr = new ModelRenderer((ModelBase)this, 0, 44);
        this.legfr.func_78793_a(-3.0f, 18.0f, -5.0f);
        this.legfr.func_78790_a(-2.0f, 0.0f, -2.0f, 4, 6, 4, 0.0f);
        this.fin2 = new ModelRenderer((ModelBase)this, 28, 39);
        this.fin2.func_78793_a(5.0f, 13.0f, -5.0f);
        this.fin2.func_78790_a(-0.5f, 0.0f, -4.0f, 1, 16, 8, 0.0f);
        this.setRotateAngle(this.fin2, 2.1816616f, 0.0f, 0.0f);
        this.body = new ModelRenderer((ModelBase)this, 28, 0);
        this.body.func_78793_a(0.0f, 11.0f, 2.0f);
        this.body.func_78790_a(-5.0f, -10.0f, -7.0f, 10, 16, 8, 0.0f);
        this.setRotateAngle(this.body, 1.5707964f, 0.0f, 0.0f);
        this.legbl = new ModelRenderer((ModelBase)this, 0, 44);
        this.legbl.func_78793_a(3.0f, 18.0f, 7.0f);
        this.legbl.func_78790_a(-2.0f, 0.0f, -2.0f, 4, 6, 4, 0.0f);
        this.rot1 = new ModelRenderer((ModelBase)this, 1, 17);
        this.rot1.field_78809_i = true;
        this.rot1.func_78793_a(0.0f, 11.0f, -8.0f);
        this.rot1.func_78790_a(-2.0f, -8.0f, -1.0f, 4, 8, 2, 0.0f);
        this.rot2 = new ModelRenderer((ModelBase)this, 1, 28);
        this.rot2.field_78809_i = true;
        this.rot2.func_78793_a(0.0f, 11.0f, -8.0f);
        this.rot2.func_78790_a(-2.0f, 0.0f, -1.0f, 4, 8, 2, 0.0f);
        this.fin1 = new ModelRenderer((ModelBase)this, 28, 39);
        this.fin1.func_78793_a(-5.0f, 13.0f, -5.0f);
        this.fin1.func_78790_a(-0.5f, 0.0f, -4.0f, 1, 16, 8, 0.0f);
        this.setRotateAngle(this.fin1, 2.1816616f, 0.0f, 0.0f);
        this.legfl = new ModelRenderer((ModelBase)this, 0, 44);
        this.legfl.func_78793_a(3.0f, 18.0f, -5.0f);
        this.legfl.func_78790_a(-2.0f, 0.0f, -2.0f, 4, 6, 4, 0.0f);
        this.legbr = new ModelRenderer((ModelBase)this, 0, 44);
        this.legbr.func_78793_a(-3.0f, 18.0f, 7.0f);
        this.legbr.func_78790_a(-2.0f, 0.0f, -2.0f, 4, 6, 4, 0.0f);
        this.rot3 = new ModelRenderer((ModelBase)this, 14, 27);
        this.rot3.field_78809_i = true;
        this.rot3.func_78793_a(0.0f, 11.0f, -8.0f);
        this.rot3.func_78790_a(-2.0f, -1.0f, 0.0f, 4, 2, 8, 0.0f);
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        GlStateManager.func_179147_l();
        GlStateManager.func_179112_b((int)770, (int)771);
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)0.9f);
        this.head2.func_78785_a(f5);
        this.rot4.func_78785_a(f5);
        this.head1.func_78785_a(f5);
        this.legfr.func_78785_a(f5);
        this.fin2.func_78785_a(f5);
        this.body.func_78785_a(f5);
        this.legbl.func_78785_a(f5);
        this.rot1.func_78785_a(f5);
        this.rot2.func_78785_a(f5);
        this.fin1.func_78785_a(f5);
        this.legfl.func_78785_a(f5);
        this.legbr.func_78785_a(f5);
        this.rot3.func_78785_a(f5);
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
        EntityClyster clyster = (EntityClyster)entityIn;
        this.rot2.field_78795_f = this.rot1.field_78795_f = ageInTicks * (clyster.getAngry() ? 0.6f : 0.1f);
        this.rot3.field_78795_f = this.rot1.field_78795_f;
        this.rot4.field_78795_f = this.rot1.field_78795_f;
        this.fin2.field_78795_f = this.fin1.field_78795_f = Mth.func_76134_b((float)(ageInTicks * 0.1f)) * 0.15f + 2.1816616f;
    }
}

