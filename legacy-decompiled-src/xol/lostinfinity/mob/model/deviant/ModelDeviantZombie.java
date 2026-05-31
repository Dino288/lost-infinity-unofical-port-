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

public class ModelDeviantZombie
extends ModelBase {
    public ModelRenderer armr;
    public ModelRenderer legr;
    public ModelRenderer head;
    public ModelRenderer body;
    public ModelRenderer arml;
    public ModelRenderer legl;
    public ModelRenderer body2;
    public ModelRenderer body3;
    public ModelRenderer arml2;
    public ModelRenderer armr2;
    public ModelRenderer head2;

    public ModelDeviantZombie() {
        this.field_78090_t = 64;
        this.field_78089_u = 64;
        this.arml2 = new ModelRenderer((ModelBase)this, 46, 28);
        this.arml2.field_78809_i = true;
        this.arml2.func_78793_a(5.0f, 2.0f, 0.5f);
        this.arml2.func_78790_a(2.0f, 10.0f, -2.0f, 1, 10, 4, 0.0f);
        this.body3 = new ModelRenderer((ModelBase)this, 36, 47);
        this.body3.func_78793_a(0.0f, 0.0f, 0.0f);
        this.body3.func_78790_a(-4.5f, 0.0f, -2.0f, 9, 12, 5, 0.0f);
        this.setRotateAngle(this.body3, 0.34906584f, 0.0f, 0.0f);
        this.armr2 = new ModelRenderer((ModelBase)this, 46, 28);
        this.armr2.func_78793_a(-5.0f, 2.0f, 0.5f);
        this.armr2.func_78790_a(-3.0f, 10.0f, -2.0f, 1, 10, 4, 0.0f);
        this.head2 = new ModelRenderer((ModelBase)this, 0, 46);
        this.head2.func_78793_a(0.0f, 1.0f, 0.0f);
        this.head2.func_78790_a(-4.5f, -8.5f, -4.5f, 9, 9, 9, 0.0f);
        this.legr = new ModelRenderer((ModelBase)this, 0, 16);
        this.legr.func_78793_a(-1.9f, 10.0f, 4.5f);
        this.legr.func_78790_a(-2.0f, 0.0f, -2.0f, 4, 14, 4, 0.0f);
        this.head = new ModelRenderer((ModelBase)this, 0, 0);
        this.head.func_78793_a(0.0f, 1.0f, 0.0f);
        this.head.func_78790_a(-4.0f, -8.0f, -4.0f, 8, 8, 8, 0.0f);
        this.legl = new ModelRenderer((ModelBase)this, 0, 16);
        this.legl.field_78809_i = true;
        this.legl.func_78793_a(1.9f, 10.0f, 4.5f);
        this.legl.func_78790_a(-2.0f, 0.0f, -2.0f, 4, 14, 4, 0.0f);
        this.body = new ModelRenderer((ModelBase)this, 16, 16);
        this.body.func_78793_a(0.0f, 0.0f, 0.0f);
        this.body.func_78790_a(-4.0f, 0.0f, -2.0f, 8, 12, 4, 0.0f);
        this.setRotateAngle(this.body, 0.34906584f, 0.0f, 0.0f);
        this.armr = new ModelRenderer((ModelBase)this, 48, 0);
        this.armr.func_78793_a(-5.0f, 2.0f, 0.5f);
        this.armr.func_78790_a(-3.0f, -2.0f, -2.0f, 4, 12, 4, 0.0f);
        this.body2 = new ModelRenderer((ModelBase)this, 27, 33);
        this.body2.func_78793_a(0.0f, 0.0f, 0.0f);
        this.body2.func_78790_a(-2.0f, 0.0f, 2.0f, 4, 12, 2, 0.0f);
        this.setRotateAngle(this.body2, 0.34906584f, 0.0f, 0.0f);
        this.arml = new ModelRenderer((ModelBase)this, 48, 0);
        this.arml.field_78809_i = true;
        this.arml.func_78793_a(5.0f, 2.0f, 0.5f);
        this.arml.func_78790_a(-1.0f, -2.0f, -2.0f, 4, 12, 4, 0.0f);
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.arml2.func_78785_a(f5);
        this.body3.func_78785_a(f5);
        this.armr2.func_78785_a(f5);
        this.head2.func_78785_a(f5);
        this.legr.func_78785_a(f5);
        this.head.func_78785_a(f5);
        this.legl.func_78785_a(f5);
        this.body.func_78785_a(f5);
        this.armr.func_78785_a(f5);
        this.body2.func_78785_a(f5);
        this.arml.func_78785_a(f5);
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.head.field_78796_g = netHeadYaw * ((float)Math.PI / 180);
        this.head.field_78795_f = headPitch * ((float)Math.PI / 180);
        this.head2.field_78796_g = netHeadYaw * ((float)Math.PI / 180);
        this.head2.field_78795_f = headPitch * ((float)Math.PI / 180);
        this.legr.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f)) * 1.4f * limbSwingAmount * 0.5f;
        this.legl.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f + (float)Math.PI)) * 1.4f * limbSwingAmount * 0.5f;
        this.armr2.field_78795_f = this.armr.field_78795_f = -((float)(1.5707963267948966 + (double)(Mth.func_76134_b((float)(ageInTicks * 0.1f)) * (float)Math.PI * 0.15f)));
        this.arml2.field_78795_f = this.arml.field_78795_f = -((float)(1.5707963267948966 + (double)(Mth.func_76134_b((float)((ageInTicks + 100.0f) * 0.1f)) * (float)Math.PI * 0.15f)));
    }
}

