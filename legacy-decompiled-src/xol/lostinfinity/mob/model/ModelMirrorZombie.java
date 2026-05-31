/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.model.ModelRenderer
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.math.Mth
 */
package xol.lostinfinity.mob.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;

public class ModelMirrorZombie
extends ModelBase {
    public ModelRenderer armr;
    public ModelRenderer legr;
    public ModelRenderer head;
    public ModelRenderer body;
    public ModelRenderer arml;
    public ModelRenderer legl;
    public ModelRenderer head2;
    public ModelRenderer head3;
    public ModelRenderer head4;
    public ModelRenderer head5;
    public ModelRenderer head6;
    public ModelRenderer head7;
    public ModelRenderer head8;
    public ModelRenderer head9;
    public ModelRenderer head10;
    public ModelRenderer head11;
    public ModelRenderer head12;
    public ModelRenderer armr2;
    public ModelRenderer armr3;
    public ModelRenderer armr4;
    public ModelRenderer arml2;
    public ModelRenderer arml3;
    public ModelRenderer arml4;

    public ModelMirrorZombie() {
        this.field_78090_t = 64;
        this.field_78089_u = 64;
        this.armr = new ModelRenderer((ModelBase)this, 40, 16);
        this.armr.func_78793_a(-5.0f, 2.0f, 0.0f);
        this.armr.func_78790_a(-3.0f, -2.0f, -2.0f, 4, 12, 4, 0.0f);
        this.setRotateAngle(this.armr, -1.3962634f, -0.10000736f, 0.10000736f);
        this.head3 = new ModelRenderer((ModelBase)this, 27, 0);
        this.head3.func_78793_a(0.0f, 0.0f, 0.0f);
        this.head3.func_78790_a(-6.0f, -7.5f, -0.5f, 12, 1, 1, 0.0f);
        this.setRotateAngle(this.head3, 0.0f, 0.0f, 0.08726646f);
        this.head10 = new ModelRenderer((ModelBase)this, 0, 0);
        this.head10.func_78793_a(0.0f, 0.0f, 0.0f);
        this.head10.func_78790_a(2.0f, -9.5f, -1.0f, 1, 3, 1, 0.0f);
        this.head11 = new ModelRenderer((ModelBase)this, 0, 0);
        this.head11.func_78793_a(0.0f, 0.0f, 0.0f);
        this.head11.func_78790_a(0.0f, -10.0f, -2.0f, 1, 3, 1, 0.0f);
        this.head4 = new ModelRenderer((ModelBase)this, 27, 0);
        this.head4.func_78793_a(0.0f, 0.0f, 0.0f);
        this.head4.func_78790_a(-6.0f, -7.5f, -3.5f, 12, 1, 1, 0.0f);
        this.setRotateAngle(this.head4, 0.0f, 0.0f, 0.12217305f);
        this.legl = new ModelRenderer((ModelBase)this, 0, 16);
        this.legl.field_78809_i = true;
        this.legl.func_78793_a(1.9f, 12.0f, 0.1f);
        this.legl.func_78790_a(-2.0f, 0.0f, -2.0f, 4, 12, 4, 0.0f);
        this.head2 = new ModelRenderer((ModelBase)this, 27, 0);
        this.head2.func_78793_a(0.0f, 0.0f, 0.0f);
        this.head2.func_78790_a(-6.0f, -7.5f, 2.5f, 12, 1, 1, 0.0f);
        this.setRotateAngle(this.head2, 0.0f, 0.0f, -0.06981317f);
        this.arml4 = new ModelRenderer((ModelBase)this, 40, 36);
        this.arml4.field_78809_i = true;
        this.arml4.func_78793_a(5.0f, 2.0f, 0.0f);
        this.arml4.func_78790_a(0.0f, 7.0f, -3.0f, 1, 1, 6, 0.0f);
        this.setRotateAngle(this.arml4, -1.3962634f, 0.10000736f, -0.10000736f);
        this.legr = new ModelRenderer((ModelBase)this, 0, 16);
        this.legr.func_78793_a(-1.9f, 12.0f, 0.1f);
        this.legr.func_78790_a(-2.0f, 0.0f, -2.0f, 4, 12, 4, 0.0f);
        this.head7 = new ModelRenderer((ModelBase)this, 27, 0);
        this.head7.func_78793_a(0.0f, 0.0f, 0.0f);
        this.head7.func_78790_a(-6.0f, -3.5f, 2.5f, 12, 1, 1, 0.0f);
        this.setRotateAngle(this.head7, 0.0f, 0.0f, 0.05235988f);
        this.arml = new ModelRenderer((ModelBase)this, 40, 16);
        this.arml.field_78809_i = true;
        this.arml.func_78793_a(5.0f, 2.0f, 0.0f);
        this.arml.func_78790_a(-1.0f, -2.0f, -2.0f, 4, 12, 4, 0.0f);
        this.setRotateAngle(this.arml, -1.3962634f, 0.10000736f, -0.10000736f);
        this.armr2 = new ModelRenderer((ModelBase)this, 40, 36);
        this.armr2.func_78793_a(-5.0f, 2.0f, 0.0f);
        this.armr2.func_78790_a(-2.5f, -1.0f, -3.0f, 1, 1, 6, 0.0f);
        this.setRotateAngle(this.armr2, -1.3962634f, -0.10000736f, 0.10000736f);
        this.armr3 = new ModelRenderer((ModelBase)this, 40, 36);
        this.armr3.func_78793_a(-5.0f, 2.0f, 0.0f);
        this.armr3.func_78790_a(-1.0f, 3.0f, -3.0f, 1, 1, 6, 0.0f);
        this.setRotateAngle(this.armr3, -1.3962634f, -0.10000736f, 0.10000736f);
        this.head8 = new ModelRenderer((ModelBase)this, 0, 0);
        this.head8.func_78793_a(0.0f, 0.0f, 0.0f);
        this.head8.func_78790_a(-3.0f, -9.5f, -3.0f, 1, 3, 1, 0.0f);
        this.head5 = new ModelRenderer((ModelBase)this, 27, 0);
        this.head5.func_78793_a(0.0f, 0.0f, 0.0f);
        this.head5.func_78790_a(-6.0f, -3.5f, -3.5f, 12, 1, 1, 0.0f);
        this.setRotateAngle(this.head5, 0.0f, 0.0f, -0.17453292f);
        this.arml2 = new ModelRenderer((ModelBase)this, 40, 36);
        this.arml2.field_78809_i = true;
        this.arml2.func_78793_a(5.0f, 2.0f, 0.0f);
        this.arml2.func_78790_a(0.5f, -1.0f, -3.0f, 1, 1, 6, 0.0f);
        this.setRotateAngle(this.arml2, -1.3962634f, 0.10000736f, -0.10000736f);
        this.head9 = new ModelRenderer((ModelBase)this, 0, 0);
        this.head9.func_78793_a(0.0f, 0.0f, 0.0f);
        this.head9.func_78790_a(-2.5f, -10.0f, 2.0f, 1, 3, 1, 0.0f);
        this.body = new ModelRenderer((ModelBase)this, 16, 16);
        this.body.func_78793_a(0.0f, 0.0f, 0.0f);
        this.body.func_78790_a(-4.0f, 0.0f, -2.0f, 8, 12, 4, 0.0f);
        this.arml3 = new ModelRenderer((ModelBase)this, 40, 36);
        this.arml3.field_78809_i = true;
        this.arml3.func_78793_a(5.0f, 2.0f, 0.0f);
        this.arml3.func_78790_a(1.5f, 3.0f, -3.0f, 1, 1, 6, 0.0f);
        this.setRotateAngle(this.arml3, -1.3962634f, 0.10000736f, -0.10000736f);
        this.armr4 = new ModelRenderer((ModelBase)this, 40, 36);
        this.armr4.func_78793_a(-5.0f, 2.0f, 0.0f);
        this.armr4.func_78790_a(-1.5f, 6.0f, -3.0f, 1, 1, 6, 0.0f);
        this.setRotateAngle(this.armr4, -1.3962634f, -0.10000736f, 0.10000736f);
        this.head = new ModelRenderer((ModelBase)this, 0, 0);
        this.head.func_78793_a(0.0f, 0.0f, 0.0f);
        this.head.func_78790_a(-4.0f, -8.0f, -4.0f, 8, 8, 8, 0.0f);
        this.head6 = new ModelRenderer((ModelBase)this, 27, 0);
        this.head6.func_78793_a(0.0f, 0.0f, 0.0f);
        this.head6.func_78790_a(-6.0f, -3.5f, -0.5f, 12, 1, 1, 0.0f);
        this.setRotateAngle(this.head6, 0.0f, 0.0f, -0.06981317f);
        this.head12 = new ModelRenderer((ModelBase)this, 0, 0);
        this.head12.func_78793_a(0.0f, 0.0f, 0.0f);
        this.head12.func_78790_a(2.5f, -10.0f, 2.0f, 1, 3, 1, 0.0f);
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.armr.func_78785_a(f5);
        this.head3.func_78785_a(f5);
        this.head10.func_78785_a(f5);
        this.head11.func_78785_a(f5);
        this.head4.func_78785_a(f5);
        this.legl.func_78785_a(f5);
        this.head2.func_78785_a(f5);
        this.arml4.func_78785_a(f5);
        this.legr.func_78785_a(f5);
        this.head7.func_78785_a(f5);
        this.arml.func_78785_a(f5);
        this.armr2.func_78785_a(f5);
        this.armr3.func_78785_a(f5);
        this.head8.func_78785_a(f5);
        this.head5.func_78785_a(f5);
        this.arml2.func_78785_a(f5);
        this.head9.func_78785_a(f5);
        this.body.func_78785_a(f5);
        this.arml3.func_78785_a(f5);
        this.armr4.func_78785_a(f5);
        this.head.func_78785_a(f5);
        this.head6.func_78785_a(f5);
        this.head12.func_78785_a(f5);
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
        this.head6.field_78796_g = netHeadYaw * ((float)Math.PI / 180);
        this.head6.field_78795_f = headPitch * ((float)Math.PI / 180);
        this.head7.field_78796_g = netHeadYaw * ((float)Math.PI / 180);
        this.head7.field_78795_f = headPitch * ((float)Math.PI / 180);
        this.head8.field_78796_g = netHeadYaw * ((float)Math.PI / 180);
        this.head8.field_78795_f = headPitch * ((float)Math.PI / 180);
        this.head9.field_78796_g = netHeadYaw * ((float)Math.PI / 180);
        this.head9.field_78795_f = headPitch * ((float)Math.PI / 180);
        this.head10.field_78796_g = netHeadYaw * ((float)Math.PI / 180);
        this.head10.field_78795_f = headPitch * ((float)Math.PI / 180);
        this.head11.field_78796_g = netHeadYaw * ((float)Math.PI / 180);
        this.head11.field_78795_f = headPitch * ((float)Math.PI / 180);
        this.head12.field_78796_g = netHeadYaw * ((float)Math.PI / 180);
        this.head12.field_78795_f = headPitch * ((float)Math.PI / 180);
        this.legr.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f)) * 1.4f * limbSwingAmount * 0.5f;
        this.legl.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f + (float)Math.PI)) * 1.4f * limbSwingAmount * 0.5f;
    }
}

