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

public class ModelArmorHeadguard
extends ModelLostArmor {
    public ModelRenderer helmet;
    public ModelRenderer helmetback;
    public ModelRenderer helmetfin;
    public ModelRenderer helmetfin2;
    public ModelRenderer helmetfin3;
    public ModelRenderer helmetfin4;
    public ModelRenderer helmetfin5;
    public ModelRenderer helmetfin6;
    public ModelRenderer helmetridge;

    public ModelArmorHeadguard() {
        this.field_78090_t = 64;
        this.field_78089_u = 64;
        this.helmetfin5 = new ModelRenderer((ModelBase)this, 54, 34);
        this.helmetfin5.func_78793_a(-4.0f, -8.5f, -4.0f);
        this.helmetfin5.func_78790_a(8.0f, -4.5f, 3.5f, 1, 3, 2, 0.0f);
        this.helmetfin6 = new ModelRenderer((ModelBase)this, 49, 47);
        this.helmetfin6.func_78793_a(-4.0f, -8.5f, -4.0f);
        this.helmetfin6.func_78790_a(8.0f, 4.5f, -0.5f, 1, 2, 3, 0.0f);
        this.helmetfin3 = new ModelRenderer((ModelBase)this, 38, 34);
        this.helmetfin3.func_78793_a(-4.0f, -8.5f, -4.0f);
        this.helmetfin3.func_78790_a(-1.0f, -1.5f, 2.5f, 1, 8, 3, 0.0f);
        this.helmetback = new ModelRenderer((ModelBase)this, 0, 47);
        this.helmetback.func_78793_a(-4.0f, -8.5f, -4.0f);
        this.helmetback.func_78790_a(-0.5f, 4.0f, 4.5f, 9, 4, 4, 0.0f);
        this.helmetfin = new ModelRenderer((ModelBase)this, 49, 47);
        this.helmetfin.func_78793_a(-4.0f, -8.5f, -4.0f);
        this.helmetfin.func_78790_a(-1.0f, 4.5f, -0.5f, 1, 2, 3, 0.0f);
        this.helmetfin4 = new ModelRenderer((ModelBase)this, 38, 34);
        this.helmetfin4.field_78809_i = true;
        this.helmetfin4.func_78793_a(-4.0f, -8.5f, -4.0f);
        this.helmetfin4.func_78790_a(8.0f, -1.5f, 2.5f, 1, 8, 3, 0.0f);
        this.helmetridge = new ModelRenderer((ModelBase)this, 0, 32);
        this.helmetridge.func_78793_a(-4.0f, -8.5f, -4.0f);
        this.helmetridge.func_78790_a(2.5f, -0.2f, -0.7f, 3, 5, 9, 0.0f);
        this.setRotateAngle(this.helmetridge, 0.0f, 0.004886922f, 0.0f);
        this.helmetfin2 = new ModelRenderer((ModelBase)this, 54, 34);
        this.helmetfin2.func_78793_a(-4.0f, -8.5f, -4.0f);
        this.helmetfin2.func_78790_a(-1.0f, -4.5f, 3.5f, 1, 3, 2, 0.0f);
        this.helmet = new ModelRenderer((ModelBase)this, 20, 50);
        this.helmet.func_78793_a(-4.0f, -8.5f, -4.0f);
        this.helmet.func_78790_a(-0.5f, 0.0f, -0.5f, 9, 4, 9, 0.0f);
        this.field_78116_c.func_78792_a(this.helmet);
        this.field_78116_c.func_78792_a(this.helmetback);
        this.field_78116_c.func_78792_a(this.helmetfin);
        this.field_78116_c.func_78792_a(this.helmetfin2);
        this.field_78116_c.func_78792_a(this.helmetfin3);
        this.field_78116_c.func_78792_a(this.helmetfin4);
        this.field_78116_c.func_78792_a(this.helmetfin5);
        this.field_78116_c.func_78792_a(this.helmetfin6);
        this.field_78116_c.func_78792_a(this.helmetridge);
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

