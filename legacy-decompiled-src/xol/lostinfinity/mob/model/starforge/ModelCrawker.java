/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.model.ModelRenderer
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.math.Mth
 */
package xol.lostinfinity.mob.model.starforge;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import xol.lostinfinity.mob.entity.starforge.EntityCrawker;

public class ModelCrawker
extends ModelBase {
    public ModelRenderer body;
    public ModelRenderer legbl;
    public ModelRenderer legfl;
    public ModelRenderer legbr;
    public ModelRenderer legfr;
    public ModelRenderer eye1;
    public ModelRenderer eye2;
    public ModelRenderer eye1p2;
    public ModelRenderer eye2p2;
    public ModelRenderer body2;
    public ModelRenderer body3;
    public ModelRenderer body4;
    public ModelRenderer body5;
    public ModelRenderer body6;
    public ModelRenderer body7;

    public ModelCrawker() {
        this.field_78090_t = 64;
        this.field_78089_u = 64;
        this.eye1 = new ModelRenderer((ModelBase)this, 32, 26);
        this.eye1.func_78793_a(0.0f, 14.0f, -6.5f);
        this.eye1.func_78790_a(-4.0f, -5.0f, -4.0f, 8, 5, 4, 0.0f);
        this.body3 = new ModelRenderer((ModelBase)this, 0, 0);
        this.body3.func_78793_a(0.0f, 10.5f, 6.0f);
        this.body3.func_78790_a(-3.0f, -1.0f, -3.0f, 6, 1, 6, 0.0f);
        this.body7 = new ModelRenderer((ModelBase)this, 0, 9);
        this.body7.func_78793_a(-5.5f, 13.5f, 6.0f);
        this.body7.func_78790_a(0.0f, -3.0f, -3.0f, 1, 6, 6, 0.0f);
        this.legfl = new ModelRenderer((ModelBase)this, 0, 32);
        this.legfl.func_78793_a(3.0f, 18.0f, -5.0f);
        this.legfl.func_78790_a(-2.0f, 0.0f, -2.0f, 4, 6, 4, 0.0f);
        this.eye2 = new ModelRenderer((ModelBase)this, 32, 45);
        this.eye2.func_78793_a(0.0f, 14.0f, -6.5f);
        this.eye2.func_78790_a(-4.0f, 0.0f, -4.0f, 8, 5, 4, 0.0f);
        this.body2 = new ModelRenderer((ModelBase)this, 0, 0);
        this.body2.func_78793_a(0.0f, 10.5f, -1.0f);
        this.body2.func_78790_a(-3.0f, -1.0f, -3.0f, 6, 1, 6, 0.0f);
        this.body5 = new ModelRenderer((ModelBase)this, 0, 9);
        this.body5.func_78793_a(4.5f, 13.5f, 6.0f);
        this.body5.func_78790_a(0.0f, -3.0f, -3.0f, 1, 6, 6, 0.0f);
        this.body = new ModelRenderer((ModelBase)this, 28, 0);
        this.body.func_78793_a(0.0f, 11.0f, 3.5f);
        this.body.func_78790_a(-5.0f, -10.0f, -7.0f, 10, 16, 8, 0.0f);
        this.setRotateAngle(this.body, 1.5707964f, 0.0f, 0.0f);
        this.legbl = new ModelRenderer((ModelBase)this, 0, 32);
        this.legbl.func_78793_a(3.0f, 18.0f, 8.5f);
        this.legbl.func_78790_a(-2.0f, 0.0f, -2.0f, 4, 6, 4, 0.0f);
        this.body4 = new ModelRenderer((ModelBase)this, 0, 9);
        this.body4.func_78793_a(4.5f, 13.5f, -1.0f);
        this.body4.func_78790_a(0.0f, -3.0f, -3.0f, 1, 6, 6, 0.0f);
        this.eye1p2 = new ModelRenderer((ModelBase)this, 32, 37);
        this.eye1p2.func_78793_a(0.0f, 14.0f, -6.4f);
        this.eye1p2.func_78790_a(-3.5f, 0.0f, -3.8f, 7, 1, 4, 0.0f);
        this.legfr = new ModelRenderer((ModelBase)this, 0, 32);
        this.legfr.func_78793_a(-3.0f, 18.0f, -5.0f);
        this.legfr.func_78790_a(-2.0f, 0.0f, -2.0f, 4, 6, 4, 0.0f);
        this.body6 = new ModelRenderer((ModelBase)this, 0, 9);
        this.body6.func_78793_a(-5.5f, 13.5f, -1.0f);
        this.body6.func_78790_a(0.0f, -3.0f, -3.0f, 1, 6, 6, 0.0f);
        this.legbr = new ModelRenderer((ModelBase)this, 0, 32);
        this.legbr.func_78793_a(-3.0f, 18.0f, 8.5f);
        this.legbr.func_78790_a(-2.0f, 0.0f, -2.0f, 4, 6, 4, 0.0f);
        this.eye2p2 = new ModelRenderer((ModelBase)this, 32, 37);
        this.eye2p2.func_78793_a(0.0f, 14.0f, -6.4f);
        this.eye2p2.func_78790_a(-3.5f, -1.0f, -3.8f, 7, 1, 4, 0.0f);
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.eye1.func_78785_a(f5);
        this.body3.func_78785_a(f5);
        this.body7.func_78785_a(f5);
        this.legfl.func_78785_a(f5);
        this.eye2.func_78785_a(f5);
        this.body2.func_78785_a(f5);
        this.body5.func_78785_a(f5);
        this.body.func_78785_a(f5);
        this.legbl.func_78785_a(f5);
        this.body4.func_78785_a(f5);
        this.eye1p2.func_78785_a(f5);
        this.legfr.func_78785_a(f5);
        this.body6.func_78785_a(f5);
        this.legbr.func_78785_a(f5);
        this.eye2p2.func_78785_a(f5);
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
        EntityCrawker craw = (EntityCrawker)entityIn;
        if (craw.getAttackTime() != -1) {
            int newCount = craw.field_70173_aa - craw.getAttackTime();
            this.eye1p2.field_78795_f = this.eye1.field_78795_f = -0.5235988f + Mth.func_76134_b((float)((float)newCount * 0.5f)) * 0.5f;
            this.eye2.field_78795_f = -this.eye1.field_78795_f;
            this.eye2p2.field_78795_f = -this.eye1.field_78795_f;
        } else {
            this.eye1.field_78795_f = 0.0f;
            this.eye1p2.field_78795_f = 0.0f;
            this.eye2.field_78795_f = 0.0f;
            this.eye2p2.field_78795_f = 0.0f;
        }
    }
}

