/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.model.ModelRenderer
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.math.Mth
 */
package xol.lostinfinity.mob.model.boss;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import xol.lostinfinity.mob.entity.boss.EntityDarrio;

public class ModelDarrio
extends ModelBase {
    public ModelRenderer armr;
    public ModelRenderer legr;
    public ModelRenderer head;
    public ModelRenderer body;
    public ModelRenderer arml;
    public ModelRenderer legl;
    public ModelRenderer armr2;
    public ModelRenderer armr3;
    public ModelRenderer head2;
    public ModelRenderer head3;
    public ModelRenderer head5;
    public ModelRenderer head4;
    public ModelRenderer head6;
    public ModelRenderer head7;

    public ModelDarrio() {
        this.field_78090_t = 64;
        this.field_78089_u = 64;
        this.arml = new ModelRenderer((ModelBase)this, 40, 16);
        this.arml.field_78809_i = true;
        this.arml.func_78793_a(5.0f, 2.0f, 0.0f);
        this.arml.func_78790_a(-1.0f, -2.0f, -2.0f, 4, 12, 4, 0.0f);
        this.armr2 = new ModelRenderer((ModelBase)this, 25, 33);
        this.armr2.func_78793_a(-5.0f, 2.0f, 0.0f);
        this.armr2.func_78790_a(-2.0f, 6.0f, -1.0f, 2, 12, 2, 0.0f);
        this.armr = new ModelRenderer((ModelBase)this, 40, 33);
        this.armr.func_78793_a(-5.0f, 2.0f, 0.0f);
        this.armr.func_78790_a(-3.0f, -2.0f, -2.0f, 4, 8, 4, 0.0f);
        this.body = new ModelRenderer((ModelBase)this, 16, 16);
        this.body.func_78793_a(0.0f, 0.0f, 0.0f);
        this.body.func_78790_a(-4.0f, 0.0f, -2.0f, 8, 12, 4, 0.0f);
        this.head = new ModelRenderer((ModelBase)this, 0, 0);
        this.head.func_78793_a(0.0f, 0.0f, 0.0f);
        this.head.func_78790_a(-4.0f, -8.0f, -4.0f, 8, 8, 8, 0.0f);
        this.head5 = new ModelRenderer((ModelBase)this, 42, 6);
        this.head5.func_78793_a(0.0f, 0.0f, 0.0f);
        this.head5.func_78790_a(3.0f, -6.0f, -5.0f, 1, 6, 1, 0.0f);
        this.armr3 = new ModelRenderer((ModelBase)this, 23, 45);
        this.armr3.func_78793_a(-5.0f, 2.0f, 0.0f);
        this.armr3.func_78790_a(-3.0f, 13.0f, -6.0f, 2, 6, 12, 0.0f);
        this.head3 = new ModelRenderer((ModelBase)this, 33, 6);
        this.head3.func_78793_a(0.0f, 0.0f, 0.0f);
        this.head3.func_78790_a(-1.0f, -6.0f, -5.0f, 2, 3, 1, 0.0f);
        this.legr = new ModelRenderer((ModelBase)this, 0, 16);
        this.legr.func_78793_a(-1.9f, 12.0f, 0.1f);
        this.legr.func_78790_a(-2.0f, 0.0f, -2.0f, 4, 12, 4, 0.0f);
        this.head2 = new ModelRenderer((ModelBase)this, 26, 0);
        this.head2.func_78793_a(0.0f, 0.0f, 0.0f);
        this.head2.func_78790_a(-4.0f, -8.0f, -5.0f, 8, 2, 1, 0.0f);
        this.head6 = new ModelRenderer((ModelBase)this, 0, 36);
        this.head6.func_78793_a(0.0f, 0.0f, 0.0f);
        this.head6.func_78790_a(1.0f, -9.0f, -5.0f, 2, 1, 9, 0.0f);
        this.legl = new ModelRenderer((ModelBase)this, 0, 16);
        this.legl.field_78809_i = true;
        this.legl.func_78793_a(1.9f, 12.0f, 0.1f);
        this.legl.func_78790_a(-2.0f, 0.0f, -2.0f, 4, 12, 4, 0.0f);
        this.head4 = new ModelRenderer((ModelBase)this, 42, 6);
        this.head4.func_78793_a(0.0f, 0.0f, 0.0f);
        this.head4.func_78790_a(-4.0f, -6.0f, -5.0f, 1, 6, 1, 0.0f);
        this.head7 = new ModelRenderer((ModelBase)this, 0, 36);
        this.head7.func_78793_a(0.0f, 0.0f, 0.0f);
        this.head7.func_78790_a(-3.0f, -9.0f, -5.0f, 2, 1, 9, 0.0f);
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.arml.func_78785_a(f5);
        this.armr2.func_78785_a(f5);
        this.armr.func_78785_a(f5);
        this.body.func_78785_a(f5);
        this.head.func_78785_a(f5);
        this.head5.func_78785_a(f5);
        this.armr3.func_78785_a(f5);
        this.head3.func_78785_a(f5);
        this.legr.func_78785_a(f5);
        this.head2.func_78785_a(f5);
        this.head6.func_78785_a(f5);
        this.legl.func_78785_a(f5);
        this.head4.func_78785_a(f5);
        this.head7.func_78785_a(f5);
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
        this.legr.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f)) * 1.4f * limbSwingAmount * 0.5f;
        this.legl.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f + (float)Math.PI)) * 1.4f * limbSwingAmount * 0.5f;
        this.arml.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f)) * 2.0f * limbSwingAmount * 0.5f;
        float rotSpeed = 0.0f;
        if (((EntityDarrio)entityIn).isSpinning()) {
            rotSpeed = 0.8f;
        }
        this.armr2.field_78795_f = this.armr.field_78795_f = ageInTicks * rotSpeed;
        this.armr3.field_78795_f = this.armr.field_78795_f;
    }
}

