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

public class ModelDusker
extends ModelBase {
    public ModelRenderer legr;
    public ModelRenderer head;
    public ModelRenderer body;
    public ModelRenderer legl;
    public ModelRenderer legr2;
    public ModelRenderer legl2;
    public ModelRenderer body2;
    public ModelRenderer body3;

    public ModelDusker() {
        this.field_78090_t = 64;
        this.field_78089_u = 32;
        this.legr = new ModelRenderer((ModelBase)this, 0, 16);
        this.legr.func_78793_a(-3.0f, 17.5f, -2.5f);
        this.legr.func_78790_a(-1.0f, 0.0f, -1.0f, 2, 12, 2, 0.0f);
        this.setRotateAngle(this.legr, 0.0f, 0.0f, 0.9599311f);
        this.legr2 = new ModelRenderer((ModelBase)this, 0, 16);
        this.legr2.func_78793_a(-3.0f, 17.5f, 2.5f);
        this.legr2.func_78790_a(-1.0f, 0.0f, -1.0f, 2, 12, 2, 0.0f);
        this.setRotateAngle(this.legr2, 0.0f, 0.0f, 0.9599311f);
        this.legl2 = new ModelRenderer((ModelBase)this, 0, 16);
        this.legl2.field_78809_i = true;
        this.legl2.func_78793_a(3.0f, 17.5f, 2.5f);
        this.legl2.func_78790_a(-1.0f, 0.0f, -1.0f, 2, 12, 2, 0.0f);
        this.setRotateAngle(this.legl2, -0.0f, 0.0f, -0.9599311f);
        this.head = new ModelRenderer((ModelBase)this, 0, 0);
        this.head.func_78793_a(0.0f, 16.0f, -2.0f);
        this.head.func_78790_a(-3.0f, -5.0f, -2.0f, 6, 5, 4, 0.0f);
        this.legl = new ModelRenderer((ModelBase)this, 0, 16);
        this.legl.field_78809_i = true;
        this.legl.func_78793_a(3.0f, 17.5f, -2.5f);
        this.legl.func_78790_a(-1.0f, 0.0f, -1.0f, 2, 12, 2, 0.0f);
        this.setRotateAngle(this.legl, -0.0f, 0.0f, -0.9599311f);
        this.body = new ModelRenderer((ModelBase)this, 9, 16);
        this.body.func_78793_a(0.0f, 16.0f, 0.0f);
        this.body.func_78790_a(-4.0f, 0.0f, -5.0f, 8, 4, 10, 0.0f);
        this.body3 = new ModelRenderer((ModelBase)this, 36, 19);
        this.body3.func_78793_a(0.0f, 16.0f, -1.0f);
        this.body3.func_78790_a(-3.5f, -4.0f, 3.5f, 7, 4, 2, 0.0f);
        this.body2 = new ModelRenderer((ModelBase)this, 33, 0);
        this.body2.func_78793_a(0.0f, 16.0f, -1.0f);
        this.body2.func_78790_a(-3.5f, -5.5f, -1.5f, 7, 6, 5, 0.0f);
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.legr.func_78785_a(f5);
        this.legr2.func_78785_a(f5);
        this.legl2.func_78785_a(f5);
        this.head.func_78785_a(f5);
        this.legl.func_78785_a(f5);
        this.body.func_78785_a(f5);
        this.body3.func_78785_a(f5);
        this.body2.func_78785_a(f5);
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.legr2.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f)) * 1.4f * limbSwingAmount;
        this.legl2.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f + (float)Math.PI)) * 1.4f * limbSwingAmount;
        this.legr.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f + (float)Math.PI)) * 1.4f * limbSwingAmount;
        this.legl.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f)) * 1.4f * limbSwingAmount;
    }
}

