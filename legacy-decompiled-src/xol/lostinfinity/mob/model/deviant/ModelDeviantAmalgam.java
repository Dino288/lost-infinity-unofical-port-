/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.model.ModelRenderer
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.math.Mth
 */
package xol.lostinfinity.mob.model.deviant;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import xol.lostinfinity.mob.entity.deviant.EntityDeviantAmalgam;

public class ModelDeviantAmalgam
extends ModelBase {
    public ModelRenderer rightarm;
    public ModelRenderer head;
    public ModelRenderer leftarm;
    public ModelRenderer body;
    public ModelRenderer staff1;
    public ModelRenderer staff2;
    public ModelRenderer headoutside;
    public ModelRenderer backfins;
    public ModelRenderer legflt;
    public ModelRenderer legflm;
    public ModelRenderer legfl;
    public ModelRenderer legfrt;
    public ModelRenderer legfrm;
    public ModelRenderer legfr;

    public ModelDeviantAmalgam() {
        this.field_78090_t = 128;
        this.field_78089_u = 64;
        this.legflt = new ModelRenderer((ModelBase)this, 80, 0);
        this.legflt.field_78809_i = true;
        this.legflt.func_78793_a(8.0f, 13.0f, -2.0f);
        this.legflt.func_78790_a(-6.0f, -2.0f, -2.0f, 8, 2, 4, 0.0f);
        this.setRotateAngle(this.legflt, 0.0f, 0.7853982f, 0.0f);
        this.rightarm = new ModelRenderer((ModelBase)this, 40, 0);
        this.rightarm.func_78793_a(-5.0f, 2.0f, 0.0f);
        this.rightarm.func_78790_a(-1.0f, 0.0f, -1.0f, 2, 17, 2, 0.0f);
        this.setRotateAngle(this.rightarm, 0.0f, 0.0f, 0.43633232f);
        this.staff2 = new ModelRenderer((ModelBase)this, 38, 50);
        this.staff2.func_78793_a(-5.0f, 2.0f, 0.0f);
        this.staff2.func_78790_a(-3.0f, -9.0f, -12.0f, 6, 6, 6, 0.0f);
        this.setRotateAngle(this.staff2, 0.61086524f, 0.0f, 0.43633232f);
        this.legfrt = new ModelRenderer((ModelBase)this, 80, 0);
        this.legfrt.func_78793_a(-8.0f, 13.0f, -2.0f);
        this.legfrt.func_78790_a(-2.0f, -2.0f, -2.0f, 8, 2, 4, 0.0f);
        this.setRotateAngle(this.legfrt, 0.0f, -0.7853982f, 0.0f);
        this.legfrm = new ModelRenderer((ModelBase)this, 90, 16);
        this.legfrm.func_78793_a(-8.0f, 13.0f, -2.0f);
        this.legfrm.func_78790_a(-1.0f, 0.0f, -1.0f, 2, 2, 2, 0.0f);
        this.legflm = new ModelRenderer((ModelBase)this, 90, 16);
        this.legflm.func_78793_a(8.0f, 13.0f, -2.0f);
        this.legflm.func_78790_a(-1.0f, 0.0f, -1.0f, 2, 2, 2, 0.0f);
        this.backfins = new ModelRenderer((ModelBase)this, 50, 0);
        this.backfins.func_78793_a(0.0f, 2.0f, -0.0f);
        this.backfins.func_78790_a(-3.0f, 0.0f, 0.0f, 6, 18, 12, 0.0f);
        this.legfr = new ModelRenderer((ModelBase)this, 100, 16);
        this.legfr.func_78793_a(-8.0f, 13.0f, -2.0f);
        this.legfr.func_78790_a(-2.0f, 2.0f, -2.0f, 4, 9, 4, 0.0f);
        this.headoutside = new ModelRenderer((ModelBase)this, 0, 18);
        this.headoutside.func_78793_a(0.0f, 0.0f, 0.0f);
        this.headoutside.func_78790_a(-4.5f, -8.5f, -4.5f, 9, 9, 9, 0.0f);
        this.head = new ModelRenderer((ModelBase)this, 0, 0);
        this.head.func_78793_a(0.0f, 0.0f, 0.0f);
        this.head.func_78790_a(-4.0f, -8.0f, -4.0f, 8, 8, 8, 0.0f);
        this.body = new ModelRenderer((ModelBase)this, 10, 38);
        this.body.func_78793_a(0.0f, 0.0f, 0.0f);
        this.body.func_78790_a(-5.0f, 0.0f, -2.0f, 10, 14, 4, 0.0f);
        this.legfl = new ModelRenderer((ModelBase)this, 100, 16);
        this.legfl.func_78793_a(8.0f, 13.0f, -2.0f);
        this.legfl.func_78790_a(-2.0f, 2.0f, -2.0f, 4, 9, 4, 0.0f);
        this.staff1 = new ModelRenderer((ModelBase)this, 58, 35);
        this.staff1.func_78793_a(-5.0f, 2.0f, 0.0f);
        this.staff1.func_78790_a(-0.5f, -3.0f, -9.0f, 1, 18, 1, 0.0f);
        this.setRotateAngle(this.staff1, 0.61086524f, 0.0f, 0.43633232f);
        this.leftarm = new ModelRenderer((ModelBase)this, 40, 0);
        this.leftarm.field_78809_i = true;
        this.leftarm.func_78793_a(5.0f, 2.0f, 0.0f);
        this.leftarm.func_78790_a(-1.0f, 0.0f, -1.0f, 2, 16, 2, 0.0f);
        this.setRotateAngle(this.leftarm, 0.0f, 0.0f, -0.43633232f);
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.leftarm.func_78785_a(f5);
        this.backfins.func_78785_a(f5);
        this.legflt.func_78785_a(f5);
        this.legfrt.func_78785_a(f5);
        boolean cageVis = ((EntityDeviantAmalgam)entity).getCageVisible();
        if (cageVis) {
            this.headoutside.func_78785_a(f5);
        }
        this.legflm.func_78785_a(f5);
        this.head.func_78785_a(f5);
        this.body.func_78785_a(f5);
        this.legfl.func_78785_a(f5);
        this.rightarm.func_78785_a(f5);
        this.legfr.func_78785_a(f5);
        this.staff2.func_78785_a(f5);
        this.legfrm.func_78785_a(f5);
        this.staff1.func_78785_a(f5);
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.backfins.field_78795_f = Mth.func_76134_b((float)(ageInTicks * 0.1f)) * (float)Math.PI * 0.05f + 0.3f;
        this.head.field_78796_g = netHeadYaw * ((float)Math.PI / 180);
        this.head.field_78795_f = headPitch * ((float)Math.PI / 180);
        this.headoutside.field_78796_g = netHeadYaw * ((float)Math.PI / 180);
        this.headoutside.field_78795_f = headPitch * ((float)Math.PI / 180);
        float f8 = Math.abs(Mth.func_76126_a((float)(limbSwing * 0.6662f + (float)Math.PI)) * 0.4f) * limbSwingAmount;
        this.legfl.field_78808_h = -0.58119464f + f8;
        this.legflt.field_78808_h = -0.58119464f + f8;
        this.legflm.field_78808_h = -0.58119464f + f8;
        this.legfr.field_78808_h = -1.0f * (-0.58119464f + f8);
        this.legfrt.field_78808_h = -1.0f * (-0.58119464f + f8);
        this.legfrm.field_78808_h = -1.0f * (-0.58119464f + f8);
        this.legfl.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.1162f)) * 0.9f * limbSwingAmount;
        this.legflt.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.1162f)) * 0.9f * limbSwingAmount;
        this.legflm.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.1162f)) * 0.9f * limbSwingAmount;
        this.legfr.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.1162f)) * 0.9f * limbSwingAmount;
        this.legfrt.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.1162f)) * 0.9f * limbSwingAmount;
        this.legfrm.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.1162f)) * 0.9f * limbSwingAmount;
    }
}

