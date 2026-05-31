/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.model.ModelBox
 *  net.minecraft.client.model.ModelRenderer
 *  net.minecraft.entity.Entity
 */
package xol.lostinfinity.item.armor.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.world.entity.Entity;
import xol.lostinfinity.item.armor.model.ModelLostArmor;

public class ModelTestArmor
extends ModelLostArmor {
    private final ModelRenderer HatLayer_r1;
    private final ModelRenderer LeftArmLayer_r1;

    public ModelTestArmor() {
        this.field_78090_t = 128;
        this.field_78089_u = 64;
        this.field_78116_c = new ModelRenderer((ModelBase)this);
        this.field_78116_c.func_78793_a(0.0f, 0.0f, 0.0f);
        this.field_78116_c.field_78804_l.add(new ModelBox(this.field_78116_c, 64, 0, -4.0f, -8.0f, -4.0f, 8, 8, 8, 0.5f, false));
        this.HatLayer_r1 = new ModelRenderer((ModelBase)this);
        this.HatLayer_r1.func_78793_a(0.0f, 24.0f, 0.0f);
        this.field_78116_c.func_78792_a(this.HatLayer_r1);
        this.setRotateAngle(this.HatLayer_r1, -0.3927f, 0.0f, 0.0f);
        this.HatLayer_r1.field_78804_l.add(new ModelBox(this.HatLayer_r1, 64, 0, 5.0f, -34.0f, -15.0f, 1, 8, 8, 0.5f, false));
        this.field_78115_e = new ModelRenderer((ModelBase)this);
        this.field_78115_e.func_78793_a(0.0f, 0.0f, 0.0f);
        this.field_78115_e.field_78804_l.add(new ModelBox(this.field_78115_e, 16, 32, -4.0f, 0.0f, -2.0f, 8, 12, 4, 0.25f, false));
        this.field_178723_h = new ModelRenderer((ModelBase)this);
        this.field_178723_h.func_78793_a(-5.0f, 2.0f, 0.0f);
        this.field_178723_h.field_78804_l.add(new ModelBox(this.field_178723_h, 40, 32, -3.0f, -2.0f, -2.0f, 4, 12, 4, 0.25f, false));
        this.field_178724_i = new ModelRenderer((ModelBase)this);
        this.field_178724_i.func_78793_a(5.0f, 2.0f, 0.0f);
        this.field_178724_i.field_78804_l.add(new ModelBox(this.field_178724_i, 40, 48, -1.0f, -2.0f, -2.0f, 4, 12, 4, 0.25f, false));
        this.LeftArmLayer_r1 = new ModelRenderer((ModelBase)this);
        this.LeftArmLayer_r1.func_78793_a(-5.0f, 22.0f, 0.0f);
        this.field_178724_i.func_78792_a(this.LeftArmLayer_r1);
        this.setRotateAngle(this.LeftArmLayer_r1, -0.4363f, 0.0f, 0.0f);
        this.LeftArmLayer_r1.field_78804_l.add(new ModelBox(this.LeftArmLayer_r1, 40, 48, 8.0f, -24.0f, -10.0f, 1, 12, 4, 0.25f, false));
        this.field_178721_j = new ModelRenderer((ModelBase)this);
        this.field_178721_j.func_78793_a(-1.9f, 12.0f, 0.0f);
        this.field_178721_j.field_78804_l.add(new ModelBox(this.field_178721_j, 0, 32, -2.0f, 0.0f, -2.0f, 4, 12, 4, 0.25f, false));
        this.field_178722_k = new ModelRenderer((ModelBase)this);
        this.field_178722_k.func_78793_a(1.9f, 12.0f, 0.0f);
        this.field_178722_k.field_78804_l.add(new ModelBox(this.field_178722_k, 0, 48, -2.0f, 0.0f, -2.0f, 4, 12, 4, 0.25f, false));
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

