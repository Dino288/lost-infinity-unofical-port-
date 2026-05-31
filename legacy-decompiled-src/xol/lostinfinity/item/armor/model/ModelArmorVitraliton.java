/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.model.ModelBox
 *  net.minecraft.client.model.ModelRenderer
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.Player
 */
package xol.lostinfinity.item.armor.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import xol.lostinfinity.item.armor.model.ModelLostArmor;

public class ModelArmorVitraliton
extends ModelLostArmor {
    private final ModelRenderer WingR;
    private final ModelRenderer WingR2_r1;
    private final ModelRenderer WingL;
    private final ModelRenderer WingL2_r1;

    public ModelArmorVitraliton() {
        this.field_78090_t = 128;
        this.field_78089_u = 64;
        this.field_78116_c.field_78804_l.add(new ModelBox(this.field_78116_c, 65, 0, -4.0f, -8.0f, -4.0f, 8, 8, 8, 0.5f, false));
        this.field_78116_c.field_78804_l.add(new ModelBox(this.field_78116_c, 108, 19, -5.0f, -7.5f, -5.0f, 1, 4, 8, 0.5f, false));
        this.field_78116_c.field_78804_l.add(new ModelBox(this.field_78116_c, 67, 20, -2.0f, -9.5f, -5.0f, 4, 1, 8, 0.5f, false));
        this.field_78116_c.field_78804_l.add(new ModelBox(this.field_78116_c, 93, 27, -3.0f, -7.5f, -5.0f, 6, 1, 1, 0.5f, false));
        this.field_78116_c.field_78804_l.add(new ModelBox(this.field_78116_c, 86, 22, 3.0f, -3.5f, -5.0f, 1, 3, 1, 0.0f, false));
        this.field_78116_c.field_78804_l.add(new ModelBox(this.field_78116_c, 123, 5, 2.0f, -9.5f, 4.0f, 1, 9, 1, 0.0f, false));
        this.field_78116_c.field_78804_l.add(new ModelBox(this.field_78116_c, 123, 5, -3.0f, -9.5f, 4.0f, 1, 9, 1, 0.0f, false));
        this.field_78116_c.field_78804_l.add(new ModelBox(this.field_78116_c, 105, 31, 2.0f, -10.5f, -4.0f, 1, 1, 9, 0.0f, false));
        this.field_78116_c.field_78804_l.add(new ModelBox(this.field_78116_c, 105, 31, -3.0f, -10.5f, -4.0f, 1, 1, 9, 0.0f, false));
        this.field_78116_c.field_78804_l.add(new ModelBox(this.field_78116_c, 86, 22, -4.0f, -3.5f, -5.0f, 1, 3, 1, 0.0f, false));
        this.field_78116_c.field_78804_l.add(new ModelBox(this.field_78116_c, 86, 22, -2.0f, -3.5f, -5.0f, 1, 3, 1, 0.0f, false));
        this.field_78116_c.field_78804_l.add(new ModelBox(this.field_78116_c, 86, 22, 1.0f, -3.5f, -5.0f, 1, 3, 1, 0.0f, false));
        this.field_78116_c.field_78804_l.add(new ModelBox(this.field_78116_c, 117, 10, 2.0f, -10.5f, -5.0f, 1, 3, 1, 0.0f, false));
        this.field_78116_c.field_78804_l.add(new ModelBox(this.field_78116_c, 117, 10, -3.0f, -10.5f, -5.0f, 1, 3, 1, 0.0f, false));
        this.field_78116_c.field_78804_l.add(new ModelBox(this.field_78116_c, 93, 23, -3.0f, -4.5f, -5.0f, 6, 1, 1, 0.5f, false));
        this.field_78116_c.field_78804_l.add(new ModelBox(this.field_78116_c, 108, 19, 4.0f, -7.5f, -5.0f, 1, 4, 8, 0.5f, true));
        this.field_78116_c.field_78804_l.add(new ModelBox(this.field_78116_c, 89, 8, -4.5f, -0.5f, -4.5f, 9, 1, 9, 0.3f, false));
        this.field_78115_e.field_78804_l.add(new ModelBox(this.field_78115_e, 16, 32, -4.0f, 0.0f, -2.0f, 8, 12, 4, 0.3f, false));
        this.field_78115_e.field_78804_l.add(new ModelBox(this.field_78115_e, 17, 50, -3.0f, 2.0f, -3.0f, 6, 8, 1, 0.3f, false));
        this.field_78115_e.field_78804_l.add(new ModelBox(this.field_78115_e, 29, 60, -4.0f, 9.0f, -4.0f, 8, 1, 2, 0.0f, false));
        this.field_78115_e.field_78804_l.add(new ModelBox(this.field_78115_e, 29, 60, -4.0f, 7.0f, -4.0f, 8, 1, 2, 0.0f, false));
        this.field_78115_e.field_78804_l.add(new ModelBox(this.field_78115_e, 29, 60, -4.0f, 5.0f, -4.0f, 8, 1, 2, 0.0f, false));
        this.field_78115_e.field_78804_l.add(new ModelBox(this.field_78115_e, 29, 60, -4.0f, 3.0f, -4.0f, 8, 1, 2, 0.0f, false));
        this.WingR = new ModelRenderer((ModelBase)this);
        this.WingR.func_78793_a(-3.0f, 3.0f, 3.0f);
        this.field_78115_e.func_78792_a(this.WingR);
        this.setRotationAngle(this.WingR, 0.0f, -0.3054f, 0.0f);
        this.WingR.field_78804_l.add(new ModelBox(this.WingR, 80, 53, -1.0f, -1.0f, -1.0f, 2, 2, 9, 0.3f, false));
        this.WingR.field_78804_l.add(new ModelBox(this.WingR, 67, 40, -0.5f, 3.0f, 2.5f, 1, 1, 6, 0.0f, false));
        this.WingR.field_78804_l.add(new ModelBox(this.WingR, 67, 40, -0.5f, 7.0f, 2.5f, 1, 1, 6, 0.0f, false));
        this.WingR.field_78804_l.add(new ModelBox(this.WingR, 67, 40, -0.5f, 11.0f, 2.5f, 1, 1, 6, 0.0f, false));
        this.WingR.field_78804_l.add(new ModelBox(this.WingR, 94, 34, -1.0f, -8.0f, 8.0f, 2, 24, 2, 0.4f, false));
        this.WingR.field_78804_l.add(new ModelBox(this.WingR, 104, 42, -1.0f, 1.0f, 1.0f, 1, 15, 7, 0.0f, false));
        this.WingR.field_78804_l.add(new ModelBox(this.WingR, 80, 51, -1.0f, -11.0f, 9.0f, 2, 3, 1, 0.0f, false));
        this.WingR.field_78804_l.add(new ModelBox(this.WingR, 79, 57, -1.5f, -1.5f, 6.0f, 3, 3, 1, 0.0f, false));
        this.WingR.field_78804_l.add(new ModelBox(this.WingR, 79, 57, -1.5f, -1.5f, 4.0f, 3, 3, 1, 0.0f, false));
        this.WingR.field_78804_l.add(new ModelBox(this.WingR, 79, 57, -1.5f, -1.5f, 2.0f, 3, 3, 1, 0.0f, false));
        this.WingR2_r1 = new ModelRenderer((ModelBase)this);
        this.WingR2_r1.func_78793_a(0.0f, -1.5f, 6.5f);
        this.WingR.func_78792_a(this.WingR2_r1);
        this.setRotationAngle(this.WingR2_r1, 0.8727f, 0.0f, 0.0f);
        this.WingR2_r1.field_78804_l.add(new ModelBox(this.WingR2_r1, 73, 39, -0.5f, -2.5f, -3.5f, 1, 1, 9, 0.3f, false));
        this.WingL = new ModelRenderer((ModelBase)this);
        this.WingL.func_78793_a(3.0f, 3.0f, 3.0f);
        this.field_78115_e.func_78792_a(this.WingL);
        this.setRotationAngle(this.WingL, 0.0f, 0.3054f, 0.0f);
        this.WingL.field_78804_l.add(new ModelBox(this.WingL, 80, 53, -1.0f, -1.0f, -1.0f, 2, 2, 9, 0.3f, true));
        this.WingL.field_78804_l.add(new ModelBox(this.WingL, 67, 40, -0.5f, 3.0f, 2.5f, 1, 1, 6, 0.0f, true));
        this.WingL.field_78804_l.add(new ModelBox(this.WingL, 67, 40, -0.5f, 7.0f, 2.5f, 1, 1, 6, 0.0f, true));
        this.WingL.field_78804_l.add(new ModelBox(this.WingL, 67, 40, -0.5f, 11.0f, 2.5f, 1, 1, 6, 0.0f, true));
        this.WingL.field_78804_l.add(new ModelBox(this.WingL, 94, 34, -1.0f, -8.0f, 8.0f, 2, 24, 2, 0.4f, true));
        this.WingL.field_78804_l.add(new ModelBox(this.WingL, 104, 42, 0.0f, 1.0f, 1.0f, 1, 15, 7, 0.0f, true));
        this.WingL.field_78804_l.add(new ModelBox(this.WingL, 80, 51, -1.0f, -11.0f, 9.0f, 2, 3, 1, 0.0f, true));
        this.WingL.field_78804_l.add(new ModelBox(this.WingL, 79, 57, -1.5f, -1.5f, 6.0f, 3, 3, 1, 0.0f, true));
        this.WingL.field_78804_l.add(new ModelBox(this.WingL, 79, 57, -1.5f, -1.5f, 4.0f, 3, 3, 1, 0.0f, true));
        this.WingL.field_78804_l.add(new ModelBox(this.WingL, 79, 57, -1.5f, -1.5f, 2.0f, 3, 3, 1, 0.0f, true));
        this.WingL2_r1 = new ModelRenderer((ModelBase)this);
        this.WingL2_r1.func_78793_a(0.0f, -1.5f, 6.5f);
        this.WingL.func_78792_a(this.WingL2_r1);
        this.setRotationAngle(this.WingL2_r1, 0.8727f, 0.0f, 0.0f);
        this.WingL2_r1.field_78804_l.add(new ModelBox(this.WingL2_r1, 73, 39, -0.5f, -2.5f, -3.5f, 1, 1, 9, 0.3f, true));
        this.field_178723_h.field_78804_l.add(new ModelBox(this.field_178723_h, 40, 32, -3.0f, -2.0f, -2.0f, 4, 8, 4, 0.25f, false));
        this.field_178723_h.field_78804_l.add(new ModelBox(this.field_178723_h, 61, 52, -3.0f, -5.0f, 3.5f, 1, 5, 1, 0.0f, true));
        this.field_178723_h.field_78804_l.add(new ModelBox(this.field_178723_h, 50, 52, -3.0f, -1.0f, -3.5f, 1, 1, 7, 0.0f, true));
        this.field_178723_h.field_78804_l.add(new ModelBox(this.field_178723_h, 50, 52, -3.0f, -5.0f, -3.5f, 1, 1, 7, 0.0f, true));
        this.field_178723_h.field_78804_l.add(new ModelBox(this.field_178723_h, 61, 52, -3.0f, -5.0f, -4.5f, 1, 5, 1, 0.0f, true));
        this.field_178723_h.field_78804_l.add(new ModelBox(this.field_178723_h, 40, 45, -4.0f, -3.0f, -2.5f, 3, 8, 5, 0.25f, true));
        this.field_178723_h.field_78804_l.add(new ModelBox(this.field_178723_h, 53, 41, -4.5f, -2.0f, -2.0f, 1, 4, 4, 0.25f, true));
        this.field_178724_i.field_78804_l.add(new ModelBox(this.field_178724_i, 40, 32, -1.0f, -2.0f, -2.0f, 4, 8, 4, 0.25f, false));
        this.field_178724_i.field_78804_l.add(new ModelBox(this.field_178724_i, 40, 45, 1.0f, -3.0f, -2.5f, 3, 8, 5, 0.25f, false));
        this.field_178724_i.field_78804_l.add(new ModelBox(this.field_178724_i, 50, 52, 2.0f, -5.0f, -3.5f, 1, 1, 7, 0.0f, false));
        this.field_178724_i.field_78804_l.add(new ModelBox(this.field_178724_i, 50, 52, 2.0f, -1.0f, -3.5f, 1, 1, 7, 0.0f, false));
        this.field_178724_i.field_78804_l.add(new ModelBox(this.field_178724_i, 61, 52, 2.0f, -5.0f, -4.5f, 1, 5, 1, 0.0f, false));
        this.field_178724_i.field_78804_l.add(new ModelBox(this.field_178724_i, 61, 52, 2.0f, -5.0f, 3.5f, 1, 5, 1, 0.0f, false));
        this.field_178724_i.field_78804_l.add(new ModelBox(this.field_178724_i, 53, 41, 3.5f, -2.0f, -2.0f, 1, 4, 4, 0.25f, false));
        this.field_178721_j.field_78804_l.add(new ModelBox(this.field_178721_j, 69, 50, -2.1f, 9.0f, -3.0f, 4, 1, 1, 0.0f, true));
        this.field_178721_j.field_78804_l.add(new ModelBox(this.field_178721_j, 69, 53, -1.6f, 1.0f, -2.5f, 3, 9, 1, 0.25f, true));
        this.field_178721_j.field_78804_l.add(new ModelBox(this.field_178721_j, 69, 50, -2.1f, 5.0f, -3.0f, 4, 1, 1, 0.0f, true));
        this.field_178721_j.field_78804_l.add(new ModelBox(this.field_178721_j, 69, 50, -2.1f, 1.0f, -3.0f, 4, 1, 1, 0.0f, true));
        this.field_178721_j.field_78804_l.add(new ModelBox(this.field_178721_j, 0, 32, -2.0f, 0.0f, -2.0f, 4, 12, 4, 0.25f, false));
        this.field_178722_k.field_78804_l.add(new ModelBox(this.field_178722_k, 0, 48, -2.0f, 0.0f, -2.0f, 4, 12, 4, 0.25f, false));
        this.field_178722_k.field_78804_l.add(new ModelBox(this.field_178722_k, 69, 53, -1.4f, 1.0f, -2.5f, 3, 9, 1, 0.25f, false));
        this.field_178722_k.field_78804_l.add(new ModelBox(this.field_178722_k, 69, 50, -1.9f, 9.0f, -3.0f, 4, 1, 1, 0.0f, false));
        this.field_178722_k.field_78804_l.add(new ModelBox(this.field_178722_k, 69, 50, -1.9f, 5.0f, -3.0f, 4, 1, 1, 0.0f, false));
        this.field_178722_k.field_78804_l.add(new ModelBox(this.field_178722_k, 69, 50, -1.9f, 1.0f, -3.0f, 4, 1, 1, 0.0f, false));
    }

    public void func_78088_a(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        super.func_78088_a(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    @Override
    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        super.func_78087_a(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
        if (entityIn instanceof Player) {
            this.WingR.field_78796_g = (float)((double)-0.6f - (double)0.6f * Math.sin(ageInTicks * 0.1f));
            this.WingL.field_78796_g = -this.WingR.field_78796_g;
        }
    }
}

