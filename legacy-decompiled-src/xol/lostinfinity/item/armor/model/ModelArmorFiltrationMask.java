/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.model.ModelRenderer
 *  net.minecraft.entity.Entity
 */
package xol.lostinfinity.item.armor.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.world.entity.Entity;
import xol.lostinfinity.item.armor.model.ModelLostArmor;

public class ModelArmorFiltrationMask
extends ModelLostArmor {
    public ModelRenderer head3;
    public ModelRenderer head2;
    public ModelRenderer head11;
    public ModelRenderer head5;
    public ModelRenderer head6;
    public ModelRenderer head7;
    public ModelRenderer head13;
    public ModelRenderer head8;
    public ModelRenderer head10;
    public ModelRenderer head4;
    public ModelRenderer head12;
    public ModelRenderer head9;
    public ModelRenderer head14;
    public ModelRenderer head18;
    public ModelRenderer head17;
    public ModelRenderer head15;
    public ModelRenderer head16;

    public ModelArmorFiltrationMask() {
        this.field_78090_t = 64;
        this.field_78089_u = 64;
        this.head3 = new ModelRenderer((ModelBase)this, 0, 41);
        this.head3.func_78793_a(-4.0f, -8.0f, -4.0f);
        this.head3.func_78790_a(2.0f, 5.0f, -1.5f, 4, 1, 2, 0.0f);
        this.head14 = new ModelRenderer((ModelBase)this, 51, 52);
        this.head14.func_78793_a(0.0f, 0.0f, 0.0f);
        this.head14.func_78790_a(-4.5f, -5.2f, 4.2f, 3, 1, 1, 0.0f);
        this.head13 = new ModelRenderer((ModelBase)this, 51, 52);
        this.head13.func_78793_a(0.0f, 0.0f, 0.0f);
        this.head13.func_78790_a(-4.5f, -6.7f, 4.2f, 3, 1, 1, 0.0f);
        this.head4 = new ModelRenderer((ModelBase)this, 0, 48);
        this.head4.func_78793_a(-4.0f, -8.0f, -4.0f);
        this.head4.func_78790_a(8.0f, 5.5f, -1.5f, 2, 2, 6, 0.0f);
        this.head12 = new ModelRenderer((ModelBase)this, 39, 51);
        this.head12.func_78793_a(-4.0f, -8.0f, -4.0f);
        this.head12.func_78790_a(-1.0f, 1.5f, 3.0f, 1, 2, 6, 0.0f);
        this.head11 = new ModelRenderer((ModelBase)this, 39, 51);
        this.head11.func_78793_a(-4.0f, -8.0f, -4.0f);
        this.head11.func_78790_a(8.0f, 1.5f, 3.0f, 1, 2, 6, 0.0f);
        this.head6 = new ModelRenderer((ModelBase)this, 13, 44);
        this.head6.func_78793_a(-4.0f, -8.0f, -4.0f);
        this.head6.func_78790_a(-2.5f, 4.7f, 4.5f, 3, 3, 3, 0.0f);
        this.head7 = new ModelRenderer((ModelBase)this, 13, 44);
        this.head7.func_78793_a(-4.0f, -8.0f, -4.0f);
        this.head7.func_78790_a(7.5f, 4.7f, 4.5f, 3, 3, 3, 0.0f);
        this.head8 = new ModelRenderer((ModelBase)this, 10, 52);
        this.head8.func_78793_a(0.0f, 0.0f, 0.0f);
        this.head8.func_78790_a(-1.5f, -8.5f, -2.5f, 3, 1, 7, 0.0f);
        this.head5 = new ModelRenderer((ModelBase)this, 0, 48);
        this.head5.func_78793_a(-4.0f, -8.0f, -4.0f);
        this.head5.func_78790_a(-2.0f, 5.5f, -1.5f, 2, 2, 6, 0.0f);
        this.head2 = new ModelRenderer((ModelBase)this, 0, 35);
        this.head2.func_78793_a(-4.0f, -8.0f, -4.0f);
        this.head2.func_78790_a(-1.0f, 6.0f, -2.0f, 10, 2, 2, 0.0f);
        this.head10 = new ModelRenderer((ModelBase)this, 29, 45);
        this.head10.func_78793_a(0.0f, 0.0f, 0.0f);
        this.head10.func_78790_a(-5.0f, -3.0f, 3.5f, 10, 2, 1, 0.0f);
        this.head16 = new ModelRenderer((ModelBase)this, 37, 51);
        this.head16.func_78793_a(-4.0f, -8.0f, -4.0f);
        this.head16.func_78790_a(-1.0f, 1.5f, 1.0f, 1, 1, 2, 0.0f);
        this.head15 = new ModelRenderer((ModelBase)this, 37, 51);
        this.head15.func_78793_a(-4.0f, -8.0f, -4.0f);
        this.head15.func_78790_a(8.0f, 1.5f, 1.0f, 1, 1, 2, 0.0f);
        this.head9 = new ModelRenderer((ModelBase)this, 26, 52);
        this.head9.func_78793_a(0.0f, 0.0f, 0.0f);
        this.head9.func_78790_a(-2.0f, -7.5f, 4.0f, 4, 5, 1, 0.0f);
        this.head18 = new ModelRenderer((ModelBase)this, 51, 52);
        this.head18.func_78793_a(0.0f, 0.0f, 0.0f);
        this.head18.func_78790_a(1.5f, -6.7f, 4.2f, 3, 1, 1, 0.0f);
        this.head17 = new ModelRenderer((ModelBase)this, 51, 52);
        this.head17.func_78793_a(0.0f, 0.0f, 0.0f);
        this.head17.func_78790_a(1.5f, -5.2f, 4.2f, 3, 1, 1, 0.0f);
        this.field_78116_c.func_78792_a(this.head2);
        this.field_78116_c.func_78792_a(this.head3);
        this.field_78116_c.func_78792_a(this.head4);
        this.field_78116_c.func_78792_a(this.head5);
        this.field_78116_c.func_78792_a(this.head6);
        this.field_78116_c.func_78792_a(this.head7);
        this.field_78116_c.func_78792_a(this.head8);
        this.field_78116_c.func_78792_a(this.head9);
        this.field_78116_c.func_78792_a(this.head10);
        this.field_78116_c.func_78792_a(this.head11);
        this.field_78116_c.func_78792_a(this.head12);
        this.field_78116_c.func_78792_a(this.head13);
        this.field_78116_c.func_78792_a(this.head14);
        this.field_78116_c.func_78792_a(this.head15);
        this.field_78116_c.func_78792_a(this.head16);
        this.field_78116_c.func_78792_a(this.head17);
        this.field_78116_c.func_78792_a(this.head18);
    }

    public void func_78088_a(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        super.func_78088_a(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }
}

