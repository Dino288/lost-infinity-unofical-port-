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
import xol.lostinfinity.mob.entity.starforge.EntityAcidback;

public class ModelAcidback
extends ModelBase {
    public ModelRenderer back;
    public ModelRenderer legbl;
    public ModelRenderer legfl;
    public ModelRenderer legbr;
    public ModelRenderer legfr;
    public ModelRenderer head;
    public ModelRenderer body;
    public ModelRenderer legml;
    public ModelRenderer legmr;
    public ModelRenderer antenna;
    public ModelRenderer antenna2;
    public ModelRenderer antenna3;
    public ModelRenderer antenna4;
    public ModelRenderer backinside;
    public ModelRenderer headbelow;

    public ModelAcidback() {
        this.field_78090_t = 128;
        this.field_78089_u = 64;
        this.antenna2 = new ModelRenderer((ModelBase)this, 32, 0);
        this.antenna2.func_78793_a(0.0f, 13.5f, -6.0f);
        this.antenna2.func_78790_a(-3.5f, -9.5f, -2.0f, 1, 6, 1, 0.0f);
        this.setRotateAngle(this.antenna2, 0.5235988f, 0.0f, 0.0f);
        this.legfr = new ModelRenderer((ModelBase)this, 0, 16);
        this.legfr.func_78793_a(-5.0f, 14.0f, -4.5f);
        this.legfr.func_78790_a(-1.0f, 0.0f, -1.0f, 2, 10, 2, 0.0f);
        this.antenna = new ModelRenderer((ModelBase)this, 32, 0);
        this.antenna.func_78793_a(0.0f, 13.5f, -6.0f);
        this.antenna.func_78790_a(2.5f, -9.5f, -2.0f, 1, 6, 1, 0.0f);
        this.setRotateAngle(this.antenna, 0.5235988f, 0.0f, 0.0f);
        this.legbl = new ModelRenderer((ModelBase)this, 0, 16);
        this.legbl.func_78793_a(5.0f, 14.0f, 10.5f);
        this.legbl.func_78790_a(-1.0f, 0.0f, -1.0f, 2, 10, 2, 0.0f);
        this.legbr = new ModelRenderer((ModelBase)this, 0, 16);
        this.legbr.func_78793_a(-5.0f, 14.0f, 10.5f);
        this.legbr.func_78790_a(-1.0f, 0.0f, -1.0f, 2, 10, 2, 0.0f);
        this.antenna4 = new ModelRenderer((ModelBase)this, 40, 0);
        this.antenna4.func_78793_a(0.0f, 13.5f, -6.0f);
        this.antenna4.func_78790_a(2.0f, -11.0f, -2.5f, 2, 2, 2, 0.0f);
        this.setRotateAngle(this.antenna4, 0.5235988f, 0.0f, 0.0f);
        this.head = new ModelRenderer((ModelBase)this, 0, 0);
        this.head.func_78793_a(0.0f, 13.5f, -6.0f);
        this.head.func_78790_a(-4.0f, -4.0f, -4.0f, 8, 8, 4, 0.0f);
        this.backinside = new ModelRenderer((ModelBase)this, 48, 40);
        this.backinside.func_78793_a(0.0f, 16.0f, 2.0f);
        this.backinside.func_78790_a(-3.5f, -7.0f, -5.5f, 7, 4, 15, 0.0f);
        this.legml = new ModelRenderer((ModelBase)this, 0, 16);
        this.legml.func_78793_a(5.0f, 14.0f, 3.0f);
        this.legml.func_78790_a(-1.0f, 0.0f, -1.0f, 2, 10, 2, 0.0f);
        this.legmr = new ModelRenderer((ModelBase)this, 0, 16);
        this.legmr.func_78793_a(-5.0f, 14.0f, 3.0f);
        this.legmr.func_78790_a(-1.0f, 0.0f, -1.0f, 2, 10, 2, 0.0f);
        this.antenna3 = new ModelRenderer((ModelBase)this, 40, 0);
        this.antenna3.func_78793_a(0.0f, 13.5f, -6.0f);
        this.antenna3.func_78790_a(-4.0f, -11.0f, -2.5f, 2, 2, 2, 0.0f);
        this.setRotateAngle(this.antenna3, 0.5235988f, 0.0f, 0.0f);
        this.back = new ModelRenderer((ModelBase)this, 42, 17);
        this.back.func_78793_a(0.0f, 16.0f, 2.0f);
        this.back.func_78790_a(-4.0f, -7.5f, -6.0f, 8, 4, 16, 0.0f);
        this.legfl = new ModelRenderer((ModelBase)this, 0, 16);
        this.legfl.func_78793_a(5.0f, 14.0f, -4.5f);
        this.legfl.func_78790_a(-1.0f, 0.0f, -1.0f, 2, 10, 2, 0.0f);
        this.headbelow = new ModelRenderer((ModelBase)this, 50, 0);
        this.headbelow.func_78793_a(0.0f, 13.5f, -6.0f);
        this.headbelow.func_78790_a(-4.0f, 4.0f, -4.0f, 8, 3, 4, 0.0f);
        this.body = new ModelRenderer((ModelBase)this, 0, 19);
        this.body.func_78793_a(0.0f, 16.0f, 2.0f);
        this.body.func_78790_a(-5.0f, -4.0f, -8.0f, 10, 6, 20, 0.0f);
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.antenna2.func_78785_a(f5);
        this.legfr.func_78785_a(f5);
        this.antenna.func_78785_a(f5);
        this.legbl.func_78785_a(f5);
        this.legbr.func_78785_a(f5);
        this.antenna4.func_78785_a(f5);
        this.head.func_78785_a(f5);
        this.backinside.func_78785_a(f5);
        this.legml.func_78785_a(f5);
        this.legmr.func_78785_a(f5);
        this.antenna3.func_78785_a(f5);
        EntityAcidback acidback = (EntityAcidback)entity;
        float back_transparency = 0.85f;
        if (acidback.isVolatile() && acidback.field_70173_aa % 6 < 3) {
            back_transparency = 0.2f;
        }
        GlStateManager.func_179147_l();
        GlStateManager.func_179112_b((int)770, (int)771);
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)back_transparency);
        this.back.func_78785_a(f5);
        GlStateManager.func_179084_k();
        this.legfl.func_78785_a(f5);
        this.headbelow.func_78785_a(f5);
        this.body.func_78785_a(f5);
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.head.field_78795_f = headPitch * ((float)Math.PI / 180);
        this.head.field_78796_g = netHeadYaw * ((float)Math.PI / 180);
        this.headbelow.field_78795_f = headPitch * ((float)Math.PI / 180);
        this.headbelow.field_78796_g = netHeadYaw * ((float)Math.PI / 180);
        this.antenna.field_78795_f = headPitch * ((float)Math.PI / 180) + 0.5235988f;
        this.antenna.field_78796_g = netHeadYaw * ((float)Math.PI / 180);
        this.antenna2.field_78795_f = headPitch * ((float)Math.PI / 180) + 0.5235988f;
        this.antenna2.field_78796_g = netHeadYaw * ((float)Math.PI / 180);
        this.antenna3.field_78795_f = headPitch * ((float)Math.PI / 180) + 0.5235988f;
        this.antenna3.field_78796_g = netHeadYaw * ((float)Math.PI / 180);
        this.antenna4.field_78795_f = headPitch * ((float)Math.PI / 180) + 0.5235988f;
        this.antenna4.field_78796_g = netHeadYaw * ((float)Math.PI / 180);
        this.legbr.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f)) * 1.4f * limbSwingAmount;
        this.legbl.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f + (float)Math.PI)) * 1.4f * limbSwingAmount;
        this.legfr.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f + (float)Math.PI)) * 1.4f * limbSwingAmount;
        this.legfl.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f)) * 1.4f * limbSwingAmount;
        this.legmr.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f + 1.5707964f)) * 1.4f * limbSwingAmount;
        this.legml.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f + 1.5707964f)) * 1.4f * limbSwingAmount;
    }
}

