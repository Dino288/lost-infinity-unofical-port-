/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelBiped
 *  net.minecraft.client.model.ModelRenderer
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.item.EntityArmorStand
 */
package xol.lostinfinity.item.armor.model;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.world.entity.Entity;
import net.minecraft.entity.item.EntityArmorStand;

public class ModelLostArmor
extends ModelBiped {
    public ModelLostArmor() {
        super(0.0f, 0.0f, 128, 64);
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        if (entityIn instanceof EntityArmorStand) {
            EntityArmorStand entityarmorstand = (EntityArmorStand)entityIn;
            this.field_78116_c.field_78795_f = (float)Math.PI / 180 * entityarmorstand.func_175418_s().func_179415_b();
            this.field_78116_c.field_78796_g = (float)Math.PI / 180 * entityarmorstand.func_175418_s().func_179416_c();
            this.field_78116_c.field_78808_h = (float)Math.PI / 180 * entityarmorstand.func_175418_s().func_179413_d();
            this.field_78116_c.func_78793_a(0.0f, 1.0f, 0.0f);
            this.field_78115_e.field_78795_f = (float)Math.PI / 180 * entityarmorstand.func_175408_t().func_179415_b();
            this.field_78115_e.field_78796_g = (float)Math.PI / 180 * entityarmorstand.func_175408_t().func_179416_c();
            this.field_78115_e.field_78808_h = (float)Math.PI / 180 * entityarmorstand.func_175408_t().func_179413_d();
            this.field_178724_i.field_78795_f = (float)Math.PI / 180 * entityarmorstand.func_175404_u().func_179415_b();
            this.field_178724_i.field_78796_g = (float)Math.PI / 180 * entityarmorstand.func_175404_u().func_179416_c();
            this.field_178724_i.field_78808_h = (float)Math.PI / 180 * entityarmorstand.func_175404_u().func_179413_d();
            this.field_178723_h.field_78795_f = (float)Math.PI / 180 * entityarmorstand.func_175411_v().func_179415_b();
            this.field_178723_h.field_78796_g = (float)Math.PI / 180 * entityarmorstand.func_175411_v().func_179416_c();
            this.field_178723_h.field_78808_h = (float)Math.PI / 180 * entityarmorstand.func_175411_v().func_179413_d();
            this.field_178722_k.field_78795_f = (float)Math.PI / 180 * entityarmorstand.func_175403_w().func_179415_b();
            this.field_178722_k.field_78796_g = (float)Math.PI / 180 * entityarmorstand.func_175403_w().func_179416_c();
            this.field_178722_k.field_78808_h = (float)Math.PI / 180 * entityarmorstand.func_175403_w().func_179413_d();
            this.field_178722_k.func_78793_a(1.9f, 11.0f, 0.0f);
            this.field_178721_j.field_78795_f = (float)Math.PI / 180 * entityarmorstand.func_175407_x().func_179415_b();
            this.field_178721_j.field_78796_g = (float)Math.PI / 180 * entityarmorstand.func_175407_x().func_179416_c();
            this.field_178721_j.field_78808_h = (float)Math.PI / 180 * entityarmorstand.func_175407_x().func_179413_d();
            this.field_178721_j.func_78793_a(-1.9f, 11.0f, 0.0f);
            ModelLostArmor.func_178685_a((ModelRenderer)this.field_78116_c, (ModelRenderer)this.field_178720_f);
        } else {
            super.func_78087_a(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
        }
    }
}

