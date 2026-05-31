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

public class ModelDeviantStray
extends ModelBase {
    public ModelRenderer armr;
    public ModelRenderer legr;
    public ModelRenderer head;
    public ModelRenderer body;
    public ModelRenderer arml;
    public ModelRenderer legl;
    public ModelRenderer armrcase1;
    public ModelRenderer armrcase2;
    public ModelRenderer staff1;
    public ModelRenderer staff2;
    public ModelRenderer legrcase1;
    public ModelRenderer legrcase2;
    public ModelRenderer headcase1;
    public ModelRenderer headcase2;
    public ModelRenderer bodycase1;
    public ModelRenderer bodycase2;
    public ModelRenderer armlcase1;
    public ModelRenderer armlcase2;
    public ModelRenderer leglcase1;
    public ModelRenderer leglcase2;

    public ModelDeviantStray() {
        this.field_78090_t = 128;
        this.field_78089_u = 64;
        this.armrcase1 = new ModelRenderer((ModelBase)this, 100, 16);
        this.armrcase1.func_78793_a(0.0f, 0.0f, 0.0f);
        this.armrcase1.func_78790_a(-1.5f, -2.1f, -1.5f, 3, 12, 3, 0.0f);
        this.staff1 = new ModelRenderer((ModelBase)this, 86, 46);
        this.staff1.func_78793_a(0.0f, 0.0f, 0.0f);
        this.staff1.func_78790_a(-1.5f, 7.0f, -14.0f, 2, 2, 14, 0.0f);
        this.bodycase1 = new ModelRenderer((ModelBase)this, 64, 18);
        this.bodycase1.func_78793_a(-4.5f, -0.5f, -2.5f);
        this.bodycase1.func_78790_a(0.0f, 0.0f, 0.0f, 9, 13, 5, 0.0f);
        this.leglcase2 = new ModelRenderer((ModelBase)this, 42, 34);
        this.leglcase2.func_78793_a(0.0f, 0.0f, 0.0f);
        this.leglcase2.func_78790_a(-2.0f, 0.0f, -2.0f, 4, 12, 4, 0.0f);
        this.headcase1 = new ModelRenderer((ModelBase)this, 0, 17);
        this.headcase1.func_78793_a(-4.5f, -9.0f, -4.5f);
        this.headcase1.func_78790_a(0.0f, 0.0f, 0.0f, 9, 9, 9, 0.0f);
        this.armr = new ModelRenderer((ModelBase)this, 100, 0);
        this.armr.func_78793_a(-6.0f, 2.0f, 0.0f);
        this.armr.func_78790_a(-1.0f, -2.0f, -1.0f, 2, 12, 2, 0.0f);
        this.setRotateAngle(this.armr, 0.0f, 0.0f, 0.10000736f);
        this.body = new ModelRenderer((ModelBase)this, 64, 0);
        this.body.func_78793_a(0.0f, 0.0f, 0.0f);
        this.body.func_78790_a(-4.0f, 0.0f, -2.0f, 8, 12, 4, 0.0f);
        this.head = new ModelRenderer((ModelBase)this, 0, 0);
        this.head.func_78793_a(0.0f, 0.0f, 0.0f);
        this.head.func_78790_a(-4.0f, -8.0f, -4.0f, 8, 8, 8, 0.0f);
        this.leglcase1 = new ModelRenderer((ModelBase)this, 42, 16);
        this.leglcase1.func_78793_a(0.0f, 0.0f, 0.0f);
        this.leglcase1.func_78790_a(-1.5f, 0.0f, -1.5f, 3, 12, 3, 0.0f);
        this.armrcase2 = new ModelRenderer((ModelBase)this, 110, 33);
        this.armrcase2.func_78793_a(0.0f, 0.0f, 0.0f);
        this.armrcase2.func_78790_a(-2.0f, -2.2f, -2.0f, 4, 12, 4, 0.0f);
        this.bodycase2 = new ModelRenderer((ModelBase)this, 64, 38);
        this.bodycase2.func_78793_a(-5.0f, -1.0f, -3.0f);
        this.bodycase2.func_78790_a(0.0f, 0.0f, 0.0f, 10, 14, 6, 0.0f);
        this.arml = new ModelRenderer((ModelBase)this, 100, 0);
        this.arml.field_78809_i = true;
        this.arml.func_78793_a(6.0f, 2.0f, 0.0f);
        this.arml.func_78790_a(-1.0f, -2.0f, -1.0f, 2, 12, 2, 0.0f);
        this.setRotateAngle(this.arml, 0.0f, 0.0f, -0.10000736f);
        this.headcase2 = new ModelRenderer((ModelBase)this, 0, 37);
        this.headcase2.func_78793_a(-5.0f, -10.0f, -5.0f);
        this.headcase2.func_78790_a(0.0f, 0.0f, 0.0f, 10, 10, 10, 0.0f);
        this.legr = new ModelRenderer((ModelBase)this, 42, 0);
        this.legr.func_78793_a(-2.0f, 12.0f, 0.1f);
        this.legr.func_78790_a(-1.0f, 0.0f, -1.0f, 2, 12, 2, 0.0f);
        this.legl = new ModelRenderer((ModelBase)this, 42, 0);
        this.legl.field_78809_i = true;
        this.legl.func_78793_a(2.0f, 12.0f, 0.1f);
        this.legl.func_78790_a(-1.0f, 0.0f, -1.0f, 2, 12, 2, 0.0f);
        this.armlcase1 = new ModelRenderer((ModelBase)this, 100, 16);
        this.armlcase1.func_78793_a(0.0f, 0.0f, 0.0f);
        this.armlcase1.func_78790_a(-1.5f, -2.1f, -1.5f, 3, 12, 3, 0.0f);
        this.armlcase2 = new ModelRenderer((ModelBase)this, 110, 33);
        this.armlcase2.func_78793_a(0.0f, 0.0f, 0.0f);
        this.armlcase2.func_78790_a(-2.0f, -2.2f, -2.0f, 4, 12, 4, 0.0f);
        this.legrcase2 = new ModelRenderer((ModelBase)this, 42, 34);
        this.legrcase2.func_78793_a(0.0f, 0.0f, 0.0f);
        this.legrcase2.func_78790_a(-2.0f, 0.0f, -2.0f, 4, 12, 4, 0.0f);
        this.staff2 = new ModelRenderer((ModelBase)this, 42, 52);
        this.staff2.func_78793_a(-0.5f, 8.0f, -16.0f);
        this.staff2.func_78790_a(-2.5f, -2.5f, -2.5f, 5, 5, 5, 0.0f);
        this.legrcase1 = new ModelRenderer((ModelBase)this, 42, 16);
        this.legrcase1.func_78793_a(0.0f, 0.0f, 0.0f);
        this.legrcase1.func_78790_a(-1.5f, 0.0f, -1.5f, 3, 12, 3, 0.0f);
        this.armr.func_78792_a(this.armrcase1);
        this.armr.func_78792_a(this.staff1);
        this.body.func_78792_a(this.bodycase1);
        this.legl.func_78792_a(this.leglcase2);
        this.head.func_78792_a(this.headcase1);
        this.legl.func_78792_a(this.leglcase1);
        this.armr.func_78792_a(this.armrcase2);
        this.body.func_78792_a(this.bodycase2);
        this.head.func_78792_a(this.headcase2);
        this.arml.func_78792_a(this.armlcase1);
        this.arml.func_78792_a(this.armlcase2);
        this.legr.func_78792_a(this.legrcase2);
        this.armr.func_78792_a(this.staff2);
        this.legr.func_78792_a(this.legrcase1);
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.armr.func_78785_a(f5);
        this.body.func_78785_a(f5);
        this.head.func_78785_a(f5);
        this.arml.func_78785_a(f5);
        this.legr.func_78785_a(f5);
        this.legl.func_78785_a(f5);
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.head.field_78796_g = netHeadYaw * ((float)Math.PI / 180);
        this.head.field_78795_f = headPitch * ((float)Math.PI / 180);
        this.legr.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f)) * 1.4f * limbSwingAmount * 0.5f;
        this.legl.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f + (float)Math.PI)) * 1.4f * limbSwingAmount * 0.5f;
        this.armr.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f + (float)Math.PI)) * 2.0f * limbSwingAmount * 0.5f;
        this.arml.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f)) * 2.0f * limbSwingAmount * 0.5f;
        this.staff2.field_78808_h = ageInTicks * 0.2f;
    }
}

