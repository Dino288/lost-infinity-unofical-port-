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

public class ModelHanger
extends ModelBase {
    public ModelRenderer legfr;
    public ModelRenderer head;
    public ModelRenderer body;
    public ModelRenderer legbr;
    public ModelRenderer legbl;
    public ModelRenderer legfl;
    public ModelRenderer body3;
    public ModelRenderer body2;
    public ModelRenderer body4;
    public ModelRenderer legbrt;
    public ModelRenderer legfrt;
    public ModelRenderer legblt;
    public ModelRenderer legflt;

    public ModelHanger() {
        this.field_78090_t = 64;
        this.field_78089_u = 64;
        this.legbrt = new ModelRenderer((ModelBase)this, 0, 16);
        this.legbrt.func_78793_a(-3.0f, -2.0f, 2.0f);
        this.legbrt.func_78790_a(-1.0f, 0.0f, -1.0f, 2, 12, 2, 0.0f);
        this.setRotateAngle(this.legbrt, 0.0f, 0.0f, 2.7925267f);
        this.body3 = new ModelRenderer((ModelBase)this, 40, 16);
        this.body3.func_78793_a(0.0f, -2.5f, 3.5f);
        this.body3.func_78790_a(-1.5f, 0.0f, -1.5f, 3, 15, 3, 0.0f);
        this.legfr = new ModelRenderer((ModelBase)this, 0, 16);
        this.legfr.func_78793_a(-3.0f, 12.0f, -2.0f);
        this.legfr.func_78790_a(-1.0f, 0.0f, -1.0f, 2, 12, 2, 0.0f);
        this.setRotateAngle(this.legfr, 0.0f, 0.0f, 0.34906584f);
        this.legblt = new ModelRenderer((ModelBase)this, 0, 16);
        this.legblt.func_78793_a(3.0f, -2.0f, 2.0f);
        this.legblt.func_78790_a(-1.0f, 0.0f, -1.0f, 2, 12, 2, 0.0f);
        this.setRotateAngle(this.legblt, 0.0f, 0.0f, -2.7925267f);
        this.body4 = new ModelRenderer((ModelBase)this, 34, 43);
        this.body4.func_78793_a(0.0f, -1.5f, 3.5f);
        this.body4.func_78790_a(-5.5f, 0.0f, -1.4f, 11, 13, 3, 0.0f);
        this.legflt = new ModelRenderer((ModelBase)this, 0, 16);
        this.legflt.func_78793_a(3.0f, -2.0f, -2.0f);
        this.legflt.func_78790_a(-1.0f, 0.0f, -1.0f, 2, 12, 2, 0.0f);
        this.setRotateAngle(this.legflt, 0.0f, 0.0f, -2.7925267f);
        this.legfrt = new ModelRenderer((ModelBase)this, 0, 16);
        this.legfrt.func_78793_a(-3.0f, -2.0f, -2.0f);
        this.legfrt.func_78790_a(-1.0f, 0.0f, -1.0f, 2, 12, 2, 0.0f);
        this.setRotateAngle(this.legfrt, 0.0f, 0.0f, 2.7925267f);
        this.body2 = new ModelRenderer((ModelBase)this, 9, 16);
        this.body2.func_78793_a(0.0f, -3.0f, 0.0f);
        this.body2.func_78790_a(-4.0f, 0.0f, -3.5f, 8, 3, 7, 0.0f);
        this.head = new ModelRenderer((ModelBase)this, 0, 0);
        this.head.func_78793_a(0.0f, 5.0f, 0.0f);
        this.head.func_78790_a(-4.0f, -4.0f, -4.0f, 8, 8, 8, 0.0f);
        this.legfl = new ModelRenderer((ModelBase)this, 0, 16);
        this.legfl.func_78793_a(3.0f, 12.0f, -2.0f);
        this.legfl.func_78790_a(-1.0f, 0.0f, -1.0f, 2, 12, 2, 0.0f);
        this.setRotateAngle(this.legfl, 0.0f, 0.0f, -0.34906584f);
        this.body = new ModelRenderer((ModelBase)this, 9, 30);
        this.body.func_78793_a(0.0f, 10.0f, 0.0f);
        this.body.func_78790_a(-4.0f, 0.0f, -3.5f, 8, 3, 7, 0.0f);
        this.legbr = new ModelRenderer((ModelBase)this, 0, 16);
        this.legbr.func_78793_a(-3.0f, 12.0f, 2.0f);
        this.legbr.func_78790_a(-1.0f, 0.0f, -1.0f, 2, 12, 2, 0.0f);
        this.setRotateAngle(this.legbr, 0.0f, 0.0f, 0.34906584f);
        this.legbl = new ModelRenderer((ModelBase)this, 0, 16);
        this.legbl.func_78793_a(3.0f, 12.0f, 2.0f);
        this.legbl.func_78790_a(-1.0f, 0.0f, -1.0f, 2, 12, 2, 0.0f);
        this.setRotateAngle(this.legbl, 0.0f, 0.0f, -0.34906584f);
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.legbrt.func_78785_a(f5);
        this.body3.func_78785_a(f5);
        this.legfr.func_78785_a(f5);
        this.legblt.func_78785_a(f5);
        this.body4.func_78785_a(f5);
        this.legflt.func_78785_a(f5);
        this.legfrt.func_78785_a(f5);
        this.body2.func_78785_a(f5);
        this.head.func_78785_a(f5);
        this.legfl.func_78785_a(f5);
        this.body.func_78785_a(f5);
        this.legbr.func_78785_a(f5);
        this.legbl.func_78785_a(f5);
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.head.field_78795_f = headPitch * ((float)Math.PI / 180);
        this.head.field_78796_g = netHeadYaw * ((float)Math.PI / 180);
        this.legbr.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f)) * 1.4f * limbSwingAmount;
        this.legbl.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f + (float)Math.PI)) * 1.4f * limbSwingAmount;
        this.legfr.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f + (float)Math.PI)) * 1.4f * limbSwingAmount;
        this.legfl.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f)) * 1.4f * limbSwingAmount;
        this.legbrt.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f)) * 1.4f * limbSwingAmount;
        this.legblt.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f + (float)Math.PI)) * 1.4f * limbSwingAmount;
        this.legfrt.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f + (float)Math.PI)) * 1.4f * limbSwingAmount;
        this.legflt.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f)) * 1.4f * limbSwingAmount;
    }
}

