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

public class ModelRockpest
extends ModelBase {
    public ModelRenderer armr;
    public ModelRenderer legr;
    public ModelRenderer head;
    public ModelRenderer body;
    public ModelRenderer arml;
    public ModelRenderer legl;
    public ModelRenderer arml2;
    public ModelRenderer armr2;
    public ModelRenderer head3;
    public ModelRenderer head2;
    public ModelRenderer head5;
    public ModelRenderer head4;

    public ModelRockpest() {
        this.field_78090_t = 64;
        this.field_78089_u = 32;
        this.arml = new ModelRenderer((ModelBase)this, 36, 10);
        this.arml.func_78793_a(5.5f, 15.5f, -1.5f);
        this.arml.func_78790_a(-1.0f, -0.5f, -2.0f, 8, 1, 4, 0.0f);
        this.head3 = new ModelRenderer((ModelBase)this, 20, 0);
        this.head3.func_78793_a(0.0f, 14.0f, -2.5f);
        this.head3.func_78790_a(0.5f, 0.0f, -5.0f, 1, 3, 1, 0.0f);
        this.head4 = new ModelRenderer((ModelBase)this, 25, 0);
        this.head4.func_78793_a(0.0f, 14.0f, -2.5f);
        this.head4.func_78790_a(-2.5f, -4.5f, -5.0f, 2, 2, 6, 0.0f);
        this.head2 = new ModelRenderer((ModelBase)this, 20, 0);
        this.head2.func_78793_a(0.0f, 14.0f, -2.5f);
        this.head2.func_78790_a(-1.5f, 0.0f, -5.0f, 1, 3, 1, 0.0f);
        this.body = new ModelRenderer((ModelBase)this, 16, 16);
        this.body.func_78793_a(0.0f, 14.0f, -2.0f);
        this.body.func_78790_a(-4.5f, 0.0f, -2.0f, 9, 6, 4, 0.0f);
        this.setRotateAngle(this.body, 0.34906584f, 0.0f, 0.0f);
        this.legr = new ModelRenderer((ModelBase)this, 0, 16);
        this.legr.func_78793_a(-1.9f, 19.0f, 0.1f);
        this.legr.func_78790_a(-2.0f, 0.0f, -2.0f, 4, 5, 4, 0.0f);
        this.armr = new ModelRenderer((ModelBase)this, 36, 10);
        this.armr.field_78809_i = true;
        this.armr.func_78793_a(-4.5f, 15.5f, -1.5f);
        this.armr.func_78790_a(-8.0f, -0.5f, -2.0f, 8, 1, 4, 0.0f);
        this.legl = new ModelRenderer((ModelBase)this, 0, 16);
        this.legl.field_78809_i = true;
        this.legl.func_78793_a(1.9f, 19.0f, 0.1f);
        this.legl.func_78790_a(-2.0f, 0.0f, -2.0f, 4, 5, 4, 0.0f);
        this.arml2 = new ModelRenderer((ModelBase)this, 36, 10);
        this.arml2.func_78793_a(5.5f, 17.5f, -0.5f);
        this.arml2.func_78790_a(-1.0f, -0.5f, -2.0f, 8, 1, 4, 0.0f);
        this.head = new ModelRenderer((ModelBase)this, 0, 0);
        this.head.func_78793_a(0.0f, 14.0f, -2.5f);
        this.head.func_78790_a(-3.0f, -4.0f, -4.5f, 6, 6, 6, 0.0f);
        this.armr2 = new ModelRenderer((ModelBase)this, 36, 10);
        this.armr2.field_78809_i = true;
        this.armr2.func_78793_a(-4.5f, 17.5f, -0.5f);
        this.armr2.func_78790_a(-8.0f, -0.5f, -2.0f, 8, 1, 4, 0.0f);
        this.head5 = new ModelRenderer((ModelBase)this, 25, 0);
        this.head5.func_78793_a(0.0f, 14.0f, -2.5f);
        this.head5.func_78790_a(0.5f, -4.5f, -5.0f, 2, 2, 6, 0.0f);
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.arml.func_78785_a(f5);
        this.head3.func_78785_a(f5);
        this.head4.func_78785_a(f5);
        this.head2.func_78785_a(f5);
        this.body.func_78785_a(f5);
        this.legr.func_78785_a(f5);
        this.armr.func_78785_a(f5);
        this.legl.func_78785_a(f5);
        this.arml2.func_78785_a(f5);
        this.head.func_78785_a(f5);
        this.armr2.func_78785_a(f5);
        this.head5.func_78785_a(f5);
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
        this.head3.field_78796_g = netHeadYaw * ((float)Math.PI / 180);
        this.head3.field_78795_f = headPitch * ((float)Math.PI / 180);
        this.head4.field_78796_g = netHeadYaw * ((float)Math.PI / 180);
        this.head4.field_78795_f = headPitch * ((float)Math.PI / 180);
        this.head5.field_78796_g = netHeadYaw * ((float)Math.PI / 180);
        this.head5.field_78795_f = headPitch * ((float)Math.PI / 180);
        this.legr.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f)) * 1.4f * limbSwingAmount * 0.5f;
        this.legl.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f + (float)Math.PI)) * 1.4f * limbSwingAmount * 0.5f;
        this.arml.field_78808_h = Mth.func_76134_b((float)(ageInTicks * (entityIn.field_70160_al ? 0.4f : 0.1f))) * (float)Math.PI * 0.15f;
        this.armr.field_78808_h = -this.arml.field_78808_h;
        this.arml2.field_78808_h = Mth.func_76134_b((float)(ageInTicks * (entityIn.field_70160_al ? 0.4f : 0.1f))) * (float)Math.PI * 0.15f;
        this.armr2.field_78808_h = -this.arml2.field_78808_h;
    }
}

