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

public class ModelRibrex
extends ModelBase {
    public ModelRenderer legr;
    public ModelRenderer body;
    public ModelRenderer legl;
    public ModelRenderer bodyrib3;
    public ModelRenderer bodyrib1;
    public ModelRenderer bodyrib2;
    public ModelRenderer rib2;
    public ModelRenderer rib3;
    public ModelRenderer rib1;
    public ModelRenderer rib1_1;
    public ModelRenderer rib2_1;
    public ModelRenderer rib3_1;
    public ModelRenderer ribarmR1;
    public ModelRenderer ribarmR2;
    public ModelRenderer ribarmR3;
    public ModelRenderer ribarmL1;
    public ModelRenderer ribarmL2;
    public ModelRenderer ribarmL3;

    public ModelRibrex() {
        this.field_78090_t = 64;
        this.field_78089_u = 32;
        this.rib1 = new ModelRenderer((ModelBase)this, 35, 0);
        this.rib1.func_78793_a(-5.0f, 4.0f, 0.0f);
        this.rib1.func_78790_a(-3.0f, -2.0f, -2.0f, 2, 6, 2, 0.0f);
        this.setRotateAngle(this.rib1, -1.2217305f, 0.0f, 0.0f);
        this.legl = new ModelRenderer((ModelBase)this, 0, 0);
        this.legl.field_78809_i = true;
        this.legl.func_78793_a(2.5f, 12.0f, 4.0f);
        this.legl.func_78790_a(-2.0f, 0.0f, -2.0f, 4, 12, 4, 0.0f);
        this.legr = new ModelRenderer((ModelBase)this, 0, 0);
        this.legr.func_78793_a(-2.5f, 12.0f, 4.0f);
        this.legr.func_78790_a(-2.0f, 0.0f, -2.0f, 4, 12, 4, 0.0f);
        this.rib3_1 = new ModelRenderer((ModelBase)this, 35, 0);
        this.rib3_1.func_78793_a(9.0f, 11.5f, 3.0f);
        this.rib3_1.func_78790_a(-3.0f, -2.0f, -2.0f, 2, 6, 2, 0.0f);
        this.setRotateAngle(this.rib3_1, -1.2217305f, 0.0f, 0.0f);
        this.ribarmR3 = new ModelRenderer((ModelBase)this, 35, 10);
        this.ribarmR3.func_78793_a(-7.0f, 11.5f, -1.0f);
        this.ribarmR3.func_78790_a(-0.5f, -0.5f, 0.0f, 1, 6, 1, 0.0f);
        this.setRotateAngle(this.ribarmR3, -1.2217305f, 0.0f, 0.0f);
        this.ribarmR1 = new ModelRenderer((ModelBase)this, 35, 10);
        this.ribarmR1.func_78793_a(-7.0f, 4.0f, -4.5f);
        this.ribarmR1.func_78790_a(-0.5f, -0.5f, 0.0f, 1, 6, 1, 0.0f);
        this.setRotateAngle(this.ribarmR1, -1.2217305f, 0.0f, 0.0f);
        this.ribarmL1 = new ModelRenderer((ModelBase)this, 35, 10);
        this.ribarmL1.func_78793_a(7.0f, 4.0f, -4.5f);
        this.ribarmL1.func_78790_a(-0.5f, -0.5f, 0.0f, 1, 6, 1, 0.0f);
        this.setRotateAngle(this.ribarmL1, -1.2217305f, 0.0f, 0.0f);
        this.bodyrib2 = new ModelRenderer((ModelBase)this, 0, 18);
        this.bodyrib2.func_78793_a(0.0f, 6.5f, 2.0f);
        this.bodyrib2.func_78790_a(-6.0f, -1.5f, -1.5f, 12, 3, 3, 0.0f);
        this.setRotateAngle(this.bodyrib2, 0.34906584f, 0.0f, 0.0f);
        this.rib3 = new ModelRenderer((ModelBase)this, 35, 0);
        this.rib3.func_78793_a(-5.0f, 11.5f, 3.0f);
        this.rib3.func_78790_a(-3.0f, -2.0f, -2.0f, 2, 6, 2, 0.0f);
        this.setRotateAngle(this.rib3, -1.2217305f, 0.0f, 0.0f);
        this.bodyrib3 = new ModelRenderer((ModelBase)this, 0, 18);
        this.bodyrib3.func_78793_a(0.0f, 10.0f, 3.5f);
        this.bodyrib3.func_78790_a(-6.0f, -1.5f, -1.5f, 12, 3, 3, 0.0f);
        this.setRotateAngle(this.bodyrib3, 0.34906584f, 0.0f, 0.0f);
        this.body = new ModelRenderer((ModelBase)this, 16, 0);
        this.body.func_78793_a(0.0f, 1.0f, 0.0f);
        this.body.func_78790_a(-2.0f, 0.0f, -2.0f, 4, 12, 4, 0.0f);
        this.setRotateAngle(this.body, 0.34906584f, 0.0f, 0.0f);
        this.rib2 = new ModelRenderer((ModelBase)this, 35, 0);
        this.rib2.func_78793_a(-5.0f, 7.5f, 1.5f);
        this.rib2.func_78790_a(-3.0f, -2.0f, -2.0f, 2, 6, 2, 0.0f);
        this.setRotateAngle(this.rib2, -1.2217305f, 0.0f, 0.0f);
        this.ribarmL2 = new ModelRenderer((ModelBase)this, 35, 10);
        this.ribarmL2.func_78793_a(7.0f, 7.5f, -3.0f);
        this.ribarmL2.func_78790_a(-0.5f, -0.5f, 0.0f, 1, 6, 1, 0.0f);
        this.setRotateAngle(this.ribarmL2, -1.2217305f, 0.0f, 0.0f);
        this.bodyrib1 = new ModelRenderer((ModelBase)this, 0, 18);
        this.bodyrib1.func_78793_a(0.0f, 2.8f, 0.5f);
        this.bodyrib1.func_78790_a(-6.0f, -1.5f, -1.5f, 12, 3, 3, 0.0f);
        this.setRotateAngle(this.bodyrib1, 0.34906584f, 0.0f, 0.0f);
        this.rib1_1 = new ModelRenderer((ModelBase)this, 35, 0);
        this.rib1_1.func_78793_a(9.0f, 4.0f, 0.0f);
        this.rib1_1.func_78790_a(-3.0f, -2.0f, -2.0f, 2, 6, 2, 0.0f);
        this.setRotateAngle(this.rib1_1, -1.2217305f, 0.0f, 0.0f);
        this.rib2_1 = new ModelRenderer((ModelBase)this, 35, 0);
        this.rib2_1.func_78793_a(9.0f, 7.5f, 1.5f);
        this.rib2_1.func_78790_a(-3.0f, -2.0f, -2.0f, 2, 6, 2, 0.0f);
        this.setRotateAngle(this.rib2_1, -1.2217305f, 0.0f, 0.0f);
        this.ribarmL3 = new ModelRenderer((ModelBase)this, 35, 10);
        this.ribarmL3.func_78793_a(7.0f, 11.5f, -1.0f);
        this.ribarmL3.func_78790_a(-0.5f, -0.5f, 0.0f, 1, 6, 1, 0.0f);
        this.setRotateAngle(this.ribarmL3, -1.2217305f, 0.0f, 0.0f);
        this.ribarmR2 = new ModelRenderer((ModelBase)this, 35, 10);
        this.ribarmR2.func_78793_a(-7.0f, 7.5f, -3.0f);
        this.ribarmR2.func_78790_a(-0.5f, -0.5f, 0.0f, 1, 6, 1, 0.0f);
        this.setRotateAngle(this.ribarmR2, -1.2217305f, 0.0f, 0.0f);
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.rib1.func_78785_a(f5);
        this.legl.func_78785_a(f5);
        this.legr.func_78785_a(f5);
        this.rib3_1.func_78785_a(f5);
        this.ribarmR3.func_78785_a(f5);
        this.ribarmR1.func_78785_a(f5);
        this.ribarmL1.func_78785_a(f5);
        this.bodyrib2.func_78785_a(f5);
        this.rib3.func_78785_a(f5);
        this.bodyrib3.func_78785_a(f5);
        this.body.func_78785_a(f5);
        this.rib2.func_78785_a(f5);
        this.ribarmL2.func_78785_a(f5);
        this.bodyrib1.func_78785_a(f5);
        this.rib1_1.func_78785_a(f5);
        this.rib2_1.func_78785_a(f5);
        this.ribarmL3.func_78785_a(f5);
        this.ribarmR2.func_78785_a(f5);
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.ribarmR3.field_78796_g = Mth.func_76134_b((float)(ageInTicks * 0.2f)) * 0.5f - 0.4f;
        this.ribarmR2.field_78796_g = Mth.func_76134_b((float)((ageInTicks + 5.0f) * 0.2f)) * 0.5f - 0.4f;
        this.ribarmR1.field_78796_g = Mth.func_76134_b((float)((ageInTicks + 2.5f) * 0.2f)) * 0.5f - 0.4f;
        this.ribarmL1.field_78796_g = -this.ribarmR3.field_78796_g;
        this.ribarmL2.field_78796_g = -this.ribarmR2.field_78796_g;
        this.ribarmL3.field_78796_g = -this.ribarmR1.field_78796_g;
        this.legr.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f)) * 1.4f * limbSwingAmount * 0.5f;
        this.legl.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f + (float)Math.PI)) * 1.4f * limbSwingAmount * 0.5f;
    }
}

