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

public class ModelArmorVampyreon
extends ModelLostArmor {
    private final ModelRenderer wingR;
    private final ModelRenderer WingR3_r1;
    private final ModelRenderer WingR2_r1;
    private final ModelRenderer wingL;
    private final ModelRenderer WingL3_r1;
    private final ModelRenderer WingL2_r1;
    private final ModelRenderer LeftArmLayer_r1;
    private final ModelRenderer LeftArmLayer_r2;
    private final ModelRenderer RightBoot;
    private final ModelRenderer LeftBoot;

    public ModelArmorVampyreon() {
        this.field_78090_t = 128;
        this.field_78089_u = 64;
        this.field_78116_c.field_78804_l.add(new ModelBox(this.field_78116_c, 66, 0, -4.0f, -8.0f, -4.0f, 8, 8, 8, 0.5f, false));
        this.field_78116_c.field_78804_l.add(new ModelBox(this.field_78116_c, 50, 52, -2.25f, -1.0f, -5.0f, 1, 2, 4, 0.0f, false));
        this.field_78116_c.field_78804_l.add(new ModelBox(this.field_78116_c, 72, 50, -3.25f, -9.0f, -5.0f, 1, 3, 4, 0.0f, false));
        this.field_78116_c.field_78804_l.add(new ModelBox(this.field_78116_c, 111, 34, -5.0f, -4.0f, -3.0f, 1, 2, 6, 0.0f, false));
        this.field_78116_c.field_78804_l.add(new ModelBox(this.field_78116_c, 111, 34, 4.0f, -4.0f, -3.0f, 1, 2, 6, 0.0f, false));
        this.field_78116_c.field_78804_l.add(new ModelBox(this.field_78116_c, 111, 23, -5.0f, -8.0f, -1.0f, 1, 4, 4, 0.0f, false));
        this.field_78116_c.field_78804_l.add(new ModelBox(this.field_78116_c, 111, 23, 4.0f, -8.0f, -1.0f, 1, 4, 4, 0.0f, true));
        this.field_78116_c.field_78804_l.add(new ModelBox(this.field_78116_c, 72, 50, 2.75f, -9.0f, -5.0f, 1, 3, 4, 0.0f, false));
        this.field_78116_c.field_78804_l.add(new ModelBox(this.field_78116_c, 106, 2, 2.5f, -11.0f, -1.0f, 1, 9, 9, 0.0f, false));
        this.field_78116_c.field_78804_l.add(new ModelBox(this.field_78116_c, 106, 2, -3.0f, -11.0f, -1.0f, 1, 9, 9, 0.0f, true));
        this.field_78116_c.field_78804_l.add(new ModelBox(this.field_78116_c, 65, 41, -1.25f, -9.0f, -5.0f, 3, 3, 4, 0.0f, false));
        this.field_78116_c.field_78804_l.add(new ModelBox(this.field_78116_c, 50, 52, 1.25f, -1.0f, -5.0f, 1, 2, 4, 0.0f, false));
        this.field_78116_c.field_78804_l.add(new ModelBox(this.field_78116_c, 61, 52, -0.5f, -1.5f, -4.8f, 1, 1, 4, 0.0f, false));
        this.field_78115_e.field_78804_l.add(new ModelBox(this.field_78115_e, 38, 32, -4.0f, 0.0f, -2.0f, 8, 12, 4, 0.4f, false));
        this.field_78115_e.field_78804_l.add(new ModelBox(this.field_78115_e, 18, 52, -2.5f, 3.0f, -3.5f, 5, 5, 2, 0.25f, false));
        this.field_78115_e.field_78804_l.add(new ModelBox(this.field_78115_e, 18, 40, -3.5f, 2.0f, -3.0f, 7, 7, 2, 0.25f, false));
        this.wingR = new ModelRenderer((ModelBase)this);
        this.wingR.func_78793_a(-3.25f, 1.0f, 2.75f);
        this.field_78115_e.func_78792_a(this.wingR);
        this.setRotateAngle(this.wingR, 0.3491f, 0.0f, 0.0f);
        this.wingR.field_78804_l.add(new ModelBox(this.wingR, 67, 17, -0.75f, -1.0f, -1.75f, 1, 1, 11, 0.0f, false));
        this.wingR.field_78804_l.add(new ModelBox(this.wingR, 79, 17, -0.25f, 0.0f, -2.75f, 1, 13, 15, 0.0f, false));
        this.WingR3_r1 = new ModelRenderer((ModelBase)this);
        this.WingR3_r1.func_78793_a(-0.25f, 0.5f, 3.75f);
        this.wingR.func_78792_a(this.WingR3_r1);
        this.setRotateAngle(this.WingR3_r1, -0.5236f, 0.0f, 0.0f);
        this.WingR3_r1.field_78804_l.add(new ModelBox(this.WingR3_r1, 67, 17, -0.5f, 3.5f, -5.5f, 1, 1, 11, 0.0f, false));
        this.WingR2_r1 = new ModelRenderer((ModelBase)this);
        this.WingR2_r1.func_78793_a(-0.25f, 0.5f, 3.75f);
        this.wingR.func_78792_a(this.WingR2_r1);
        this.setRotateAngle(this.WingR2_r1, -0.2618f, 0.0f, 0.0f);
        this.WingR2_r1.field_78804_l.add(new ModelBox(this.WingR2_r1, 67, 17, -0.5f, 0.5f, -5.5f, 1, 1, 11, 0.0f, false));
        this.wingL = new ModelRenderer((ModelBase)this);
        this.wingL.func_78793_a(3.25f, 1.0f, 2.75f);
        this.field_78115_e.func_78792_a(this.wingL);
        this.setRotateAngle(this.wingL, 0.3491f, 0.0f, 0.0f);
        this.wingL.field_78804_l.add(new ModelBox(this.wingL, 67, 17, -0.25f, -1.0f, -1.75f, 1, 1, 11, 0.0f, true));
        this.wingL.field_78804_l.add(new ModelBox(this.wingL, 79, 17, -0.75f, 0.0f, -2.75f, 1, 13, 15, 0.0f, true));
        this.WingL3_r1 = new ModelRenderer((ModelBase)this);
        this.WingL3_r1.func_78793_a(0.25f, 0.5f, 3.75f);
        this.wingL.func_78792_a(this.WingL3_r1);
        this.setRotateAngle(this.WingL3_r1, -0.5236f, 0.0f, 0.0f);
        this.WingL3_r1.field_78804_l.add(new ModelBox(this.WingL3_r1, 67, 17, -0.5f, 3.5f, -5.5f, 1, 1, 11, 0.0f, true));
        this.WingL2_r1 = new ModelRenderer((ModelBase)this);
        this.WingL2_r1.func_78793_a(0.25f, 0.5f, 3.75f);
        this.wingL.func_78792_a(this.WingL2_r1);
        this.setRotateAngle(this.WingL2_r1, -0.2618f, 0.0f, 0.0f);
        this.WingL2_r1.field_78804_l.add(new ModelBox(this.WingL2_r1, 67, 17, -0.5f, 0.5f, -5.5f, 1, 1, 11, 0.0f, true));
        this.field_178723_h.field_78804_l.add(new ModelBox(this.field_178723_h, 101, 50, -3.0f, -2.0f, -2.0f, 4, 4, 4, 0.5f, false));
        this.field_178723_h.field_78804_l.add(new ModelBox(this.field_178723_h, 91, 50, -4.0f, -2.0f, -2.25f, 1, 10, 1, 0.0f, false));
        this.field_178723_h.field_78804_l.add(new ModelBox(this.field_178723_h, 91, 50, -4.0f, -2.0f, 1.25f, 1, 10, 1, 0.0f, false));
        this.field_178724_i.field_78804_l.add(new ModelBox(this.field_178724_i, 101, 50, -1.0f, -2.0f, -2.0f, 4, 4, 4, 0.5f, false));
        this.field_178724_i.field_78804_l.add(new ModelBox(this.field_178724_i, 116, 50, 3.5f, -1.5f, 1.5f, 3, 1, 1, 0.0f, false));
        this.field_178724_i.field_78804_l.add(new ModelBox(this.field_178724_i, 116, 50, 3.5f, 0.5f, 1.5f, 3, 1, 1, 0.0f, false));
        this.field_178724_i.field_78804_l.add(new ModelBox(this.field_178724_i, 116, 50, 3.5f, -1.5f, -2.5f, 3, 1, 1, 0.0f, false));
        this.field_178724_i.field_78804_l.add(new ModelBox(this.field_178724_i, 116, 50, 3.5f, 0.5f, -2.5f, 3, 1, 1, 0.0f, false));
        this.LeftArmLayer_r1 = new ModelRenderer((ModelBase)this);
        this.LeftArmLayer_r1.func_78793_a(5.0f, -2.0f, 2.0f);
        this.field_178724_i.func_78792_a(this.LeftArmLayer_r1);
        this.setRotateAngle(this.LeftArmLayer_r1, 0.0f, 0.0f, -1.5708f);
        this.LeftArmLayer_r1.field_78804_l.add(new ModelBox(this.LeftArmLayer_r1, 116, 50, 0.5f, -3.5f, -4.5f, 3, 1, 1, 0.0f, false));
        this.LeftArmLayer_r1.field_78804_l.add(new ModelBox(this.LeftArmLayer_r1, 116, 50, 0.5f, -3.5f, -0.5f, 3, 1, 1, 0.0f, false));
        this.LeftArmLayer_r2 = new ModelRenderer((ModelBase)this);
        this.LeftArmLayer_r2.func_78793_a(5.0f, -2.0f, -2.0f);
        this.field_178724_i.func_78792_a(this.LeftArmLayer_r2);
        this.setRotateAngle(this.LeftArmLayer_r2, 0.0f, 0.0f, -0.7854f);
        this.LeftArmLayer_r2.field_78804_l.add(new ModelBox(this.LeftArmLayer_r2, 116, 50, -1.5f, -2.0f, 3.0f, 3, 1, 1, 0.0f, false));
        this.LeftArmLayer_r2.field_78804_l.add(new ModelBox(this.LeftArmLayer_r2, 116, 50, -1.5f, -2.0f, 0.0f, 3, 1, 1, 0.0f, false));
        this.field_178721_j.field_78804_l.add(new ModelBox(this.field_178721_j, 0, 32, -2.0f, 0.0f, -2.0f, 4, 12, 4, 0.25f, false));
        this.RightBoot = new ModelRenderer((ModelBase)this);
        this.RightBoot.func_78793_a(1.9f, 12.0f, 0.0f);
        this.field_178721_j.func_78792_a(this.RightBoot);
        this.RightBoot.field_78804_l.add(new ModelBox(this.RightBoot, 36, 50, -3.9f, -8.5f, 2.0f, 1, 5, 5, 0.25f, false));
        this.RightBoot.field_78804_l.add(new ModelBox(this.RightBoot, 68, 32, -2.9f, -6.0f, 3.0f, 2, 6, 2, 0.25f, false));
        this.RightBoot.field_78804_l.add(new ModelBox(this.RightBoot, 0, 54, -2.9f, -7.5f, 2.0f, 2, 1, 3, 0.25f, false));
        this.field_178722_k.field_78804_l.add(new ModelBox(this.field_178722_k, 0, 32, -2.0f, 0.0f, -2.0f, 4, 12, 4, 0.25f, false));
        this.LeftBoot = new ModelRenderer((ModelBase)this);
        this.LeftBoot.func_78793_a(-1.9f, 12.0f, 0.0f);
        this.field_178722_k.func_78792_a(this.LeftBoot);
        this.LeftBoot.field_78804_l.add(new ModelBox(this.LeftBoot, 36, 50, 2.9f, -8.5f, 2.0f, 1, 5, 5, 0.25f, true));
        this.LeftBoot.field_78804_l.add(new ModelBox(this.LeftBoot, 68, 32, 0.9f, -6.0f, 3.0f, 2, 6, 2, 0.25f, true));
        this.LeftBoot.field_78804_l.add(new ModelBox(this.LeftBoot, 0, 54, 0.9f, -7.5f, 2.0f, 2, 1, 3, 0.25f, true));
    }

    public void func_78088_a(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        super.func_78088_a(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    @Override
    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        super.func_78087_a(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
        if (entityIn instanceof Player) {
            this.wingR.field_78796_g = (float)(-0.5235987755982988 - 0.5 * Math.cos(ageInTicks * 0.6f));
            this.wingR.field_78795_f = (float)(0.5235987755982988 + (double)0.3f * Math.cos(ageInTicks * 0.2f));
            this.wingL.field_78796_g = -this.wingR.field_78796_g;
            this.wingL.field_78795_f = this.wingR.field_78795_f;
        }
    }
}

