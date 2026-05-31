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

public class ModelArmorPlasmythic
extends ModelLostArmor {
    private final ModelRenderer LSP2_r1;
    private final ModelRenderer LeftHorn_r1;
    private final ModelRenderer MiddleHorn_r1;
    private final ModelRenderer PlateStrap4_r1;
    private final ModelRenderer PlateStrap3_r1;
    private final ModelRenderer PlateStrap1_r1;
    private final ModelRenderer WingR;
    private final ModelRenderer WingR4_r1;
    private final ModelRenderer WingR2_r1;
    private final ModelRenderer WingR2;
    private final ModelRenderer WingR5_r1;
    private final ModelRenderer WingR3_r1;
    private final ModelRenderer WingL;
    private final ModelRenderer WingL4_r1;
    private final ModelRenderer WingL2_r1;
    private final ModelRenderer WingL2;
    private final ModelRenderer WingL5_r1;
    private final ModelRenderer WingL3_r1;
    private final ModelRenderer RightArmGem_r1;
    private final ModelRenderer LeftArmGem_r1;
    private final ModelRenderer LeftLegLayer_r1;

    public ModelArmorPlasmythic() {
        this.field_78090_t = 128;
        this.field_78089_u = 64;
        this.field_78116_c.field_78804_l.add(new ModelBox(this.field_78116_c, 64, 0, -4.0f, -8.0f, -4.0f, 8, 8, 8, 0.5f, false));
        this.field_78116_c.field_78804_l.add(new ModelBox(this.field_78116_c, 99, 0, -3.5f, -10.0f, -4.5f, 7, 9, 6, 0.5f, false));
        this.field_78116_c.field_78804_l.add(new ModelBox(this.field_78116_c, 112, 16, -3.0f, -9.5f, -5.2f, 6, 8, 1, 0.5f, false));
        this.field_78116_c.field_78804_l.add(new ModelBox(this.field_78116_c, 106, 29, -5.0f, -7.7f, -3.9f, 1, 3, 9, 0.5f, false));
        this.field_78116_c.field_78804_l.add(new ModelBox(this.field_78116_c, 95, 25, -5.5f, -7.3f, -3.4f, 1, 2, 8, 0.5f, false));
        this.field_78116_c.field_78804_l.add(new ModelBox(this.field_78116_c, 95, 25, 4.5f, -7.3f, -3.4f, 1, 2, 8, 0.5f, false));
        this.field_78116_c.field_78804_l.add(new ModelBox(this.field_78116_c, 106, 29, 4.0f, -7.7f, -3.9f, 1, 3, 9, 0.5f, false));
        this.LSP2_r1 = new ModelRenderer((ModelBase)this);
        this.LSP2_r1.func_78793_a(0.0f, -6.0f, 0.0f);
        this.field_78116_c.func_78792_a(this.LSP2_r1);
        this.setRotationAngle(this.LSP2_r1, -0.4363f, 0.0f, 0.0f);
        this.LSP2_r1.field_78804_l.add(new ModelBox(this.LSP2_r1, 84, 29, 3.25f, 1.3f, 0.0f, 1, 3, 7, 0.5f, false));
        this.LSP2_r1.field_78804_l.add(new ModelBox(this.LSP2_r1, 72, 25, 3.8f, 1.8f, 0.5f, 1, 2, 6, 0.5f, false));
        this.LSP2_r1.field_78804_l.add(new ModelBox(this.LSP2_r1, 72, 25, -4.8f, 1.8f, 0.5f, 1, 2, 6, 0.5f, false));
        this.LSP2_r1.field_78804_l.add(new ModelBox(this.LSP2_r1, 84, 29, -4.25f, 1.3f, 0.0f, 1, 3, 7, 0.5f, false));
        this.LeftHorn_r1 = new ModelRenderer((ModelBase)this);
        this.LeftHorn_r1.func_78793_a(0.0f, -8.0f, 0.0f);
        this.field_78116_c.func_78792_a(this.LeftHorn_r1);
        this.setRotationAngle(this.LeftHorn_r1, 0.8727f, 0.0f, 0.0f);
        this.LeftHorn_r1.field_78804_l.add(new ModelBox(this.LeftHorn_r1, 95, 16, 3.5f, -2.0f, -2.0f, 1, 2, 6, 0.5f, false));
        this.LeftHorn_r1.field_78804_l.add(new ModelBox(this.LeftHorn_r1, 95, 16, -4.5f, -2.0f, -2.0f, 1, 2, 6, 0.5f, false));
        this.MiddleHorn_r1 = new ModelRenderer((ModelBase)this);
        this.MiddleHorn_r1.func_78793_a(0.0f, -0.8584f, -9.8396f);
        this.field_78116_c.func_78792_a(this.MiddleHorn_r1);
        this.setRotationAngle(this.MiddleHorn_r1, 3.1416f, 0.0f, 0.0f);
        this.MiddleHorn_r1.field_78804_l.add(new ModelBox(this.MiddleHorn_r1, 71, 17, -2.0f, -1.5f, -11.0f, 4, 1, 6, 0.5f, false));
        this.field_78115_e.field_78804_l.add(new ModelBox(this.field_78115_e, 16, 32, -4.0f, 0.0f, -2.0f, 8, 12, 4, 0.4f, false));
        this.field_78115_e.field_78804_l.add(new ModelBox(this.field_78115_e, 28, 49, -2.0f, 1.0f, -3.0f, 4, 10, 3, 0.4f, false));
        this.field_78115_e.field_78804_l.add(new ModelBox(this.field_78115_e, 43, 56, -1.5f, 1.5f, -3.5f, 3, 3, 3, 0.4f, false));
        this.field_78115_e.field_78804_l.add(new ModelBox(this.field_78115_e, 43, 56, -1.5f, 7.5f, -3.5f, 3, 3, 3, 0.4f, true));
        this.PlateStrap4_r1 = new ModelRenderer((ModelBase)this);
        this.PlateStrap4_r1.func_78793_a(0.0f, 11.0f, 0.0f);
        this.field_78115_e.func_78792_a(this.PlateStrap4_r1);
        this.setRotationAngle(this.PlateStrap4_r1, 0.0f, 0.0f, 1.0472f);
        this.PlateStrap4_r1.field_78804_l.add(new ModelBox(this.PlateStrap4_r1, 28, 49, -7.0f, -9.0f, -2.8f, 2, 4, 4, 0.4f, false));
        this.PlateStrap4_r1.field_78804_l.add(new ModelBox(this.PlateStrap4_r1, 28, 49, -5.0f, -1.0f, -2.8f, 2, 4, 4, 0.4f, false));
        this.PlateStrap3_r1 = new ModelRenderer((ModelBase)this);
        this.PlateStrap3_r1.func_78793_a(0.0f, 11.0f, 0.0f);
        this.field_78115_e.func_78792_a(this.PlateStrap3_r1);
        this.setRotationAngle(this.PlateStrap3_r1, 0.0f, 0.0f, 2.0944f);
        this.PlateStrap3_r1.field_78804_l.add(new ModelBox(this.PlateStrap3_r1, 28, 49, -5.0f, -3.0f, -2.8f, 2, 4, 4, 0.4f, false));
        this.PlateStrap1_r1 = new ModelRenderer((ModelBase)this);
        this.PlateStrap1_r1.func_78793_a(0.0f, 11.0f, 0.0f);
        this.field_78115_e.func_78792_a(this.PlateStrap1_r1);
        this.setRotationAngle(this.PlateStrap1_r1, 0.0f, 0.0f, -1.0472f);
        this.PlateStrap1_r1.field_78804_l.add(new ModelBox(this.PlateStrap1_r1, 28, 49, 5.0f, -9.0f, -2.8f, 2, 4, 4, 0.4f, false));
        this.WingR = new ModelRenderer((ModelBase)this);
        this.WingR.func_78793_a(-2.0f, 2.0f, 3.5f);
        this.field_78115_e.func_78792_a(this.WingR);
        this.setRotationAngle(this.WingR, 0.3491f, 0.0f, 0.0f);
        this.WingR4_r1 = new ModelRenderer((ModelBase)this);
        this.WingR4_r1.func_78793_a(0.0f, 7.0f, -3.0f);
        this.WingR.func_78792_a(this.WingR4_r1);
        this.setRotationAngle(this.WingR4_r1, 0.0f, 0.0f, 0.0f);
        this.WingR4_r1.field_78804_l.add(new ModelBox(this.WingR4_r1, 121, 44, -0.5f, -8.0f, 12.5f, 1, 6, 1, 0.2f, false));
        this.WingR4_r1.field_78804_l.add(new ModelBox(this.WingR4_r1, 121, 44, -0.5f, -8.0f, 6.5f, 1, 6, 1, 0.2f, false));
        this.WingR4_r1.field_78804_l.add(new ModelBox(this.WingR4_r1, 93, 45, -0.5f, -9.0f, -0.5f, 1, 1, 16, 0.4f, false));
        this.WingR2_r1 = new ModelRenderer((ModelBase)this);
        this.WingR2_r1.func_78793_a(0.4f, 0.5f, 1.8f);
        this.WingR.func_78792_a(this.WingR2_r1);
        this.setRotationAngle(this.WingR2_r1, -1.5708f, 0.0f, 0.0f);
        this.WingR2_r1.field_78804_l.add(new ModelBox(this.WingR2_r1, 57, 24, -0.5f, -10.5f, -2.5f, 1, 15, 9, -0.25f, false));
        this.WingR2 = new ModelRenderer((ModelBase)this);
        this.WingR2.func_78793_a(-2.0f, 9.0f, 3.5f);
        this.field_78115_e.func_78792_a(this.WingR2);
        this.setRotationAngle(this.WingR2, -0.3491f, 0.0f, 0.0f);
        this.WingR5_r1 = new ModelRenderer((ModelBase)this);
        this.WingR5_r1.func_78793_a(0.0f, 7.0f, -3.0f);
        this.WingR2.func_78792_a(this.WingR5_r1);
        this.setRotationAngle(this.WingR5_r1, 0.0f, 0.0f, 0.0f);
        this.WingR5_r1.field_78804_l.add(new ModelBox(this.WingR5_r1, 121, 44, -0.5f, -8.0f, 12.5f, 1, 6, 1, 0.2f, false));
        this.WingR5_r1.field_78804_l.add(new ModelBox(this.WingR5_r1, 121, 44, -0.5f, -8.0f, 6.5f, 1, 6, 1, 0.2f, false));
        this.WingR5_r1.field_78804_l.add(new ModelBox(this.WingR5_r1, 93, 45, -0.5f, -9.0f, -0.5f, 1, 1, 16, 0.4f, false));
        this.WingR3_r1 = new ModelRenderer((ModelBase)this);
        this.WingR3_r1.func_78793_a(0.4f, 0.5f, 1.8f);
        this.WingR2.func_78792_a(this.WingR3_r1);
        this.setRotationAngle(this.WingR3_r1, -1.5708f, 0.0f, 0.0f);
        this.WingR3_r1.field_78804_l.add(new ModelBox(this.WingR3_r1, 57, 24, -0.5f, -10.5f, -2.5f, 1, 15, 9, -0.25f, false));
        this.WingL = new ModelRenderer((ModelBase)this);
        this.WingL.func_78793_a(2.0f, 2.0f, 3.5f);
        this.field_78115_e.func_78792_a(this.WingL);
        this.setRotationAngle(this.WingL, 0.3491f, 0.0f, 0.0f);
        this.WingL4_r1 = new ModelRenderer((ModelBase)this);
        this.WingL4_r1.func_78793_a(0.0f, 7.0f, -3.0f);
        this.WingL.func_78792_a(this.WingL4_r1);
        this.setRotationAngle(this.WingL4_r1, 0.0f, 0.0f, 0.0f);
        this.WingL4_r1.field_78804_l.add(new ModelBox(this.WingL4_r1, 121, 44, -0.5f, -8.0f, 12.5f, 1, 6, 1, 0.2f, true));
        this.WingL4_r1.field_78804_l.add(new ModelBox(this.WingL4_r1, 121, 44, -0.5f, -8.0f, 6.5f, 1, 6, 1, 0.2f, true));
        this.WingL4_r1.field_78804_l.add(new ModelBox(this.WingL4_r1, 93, 45, -0.5f, -9.0f, -0.5f, 1, 1, 16, 0.4f, true));
        this.WingL2_r1 = new ModelRenderer((ModelBase)this);
        this.WingL2_r1.func_78793_a(-0.4f, 0.5f, 1.8f);
        this.WingL.func_78792_a(this.WingL2_r1);
        this.setRotationAngle(this.WingL2_r1, -1.5708f, 0.0f, 0.0f);
        this.WingL2_r1.field_78804_l.add(new ModelBox(this.WingL2_r1, 57, 24, -0.5f, -10.5f, -2.5f, 1, 15, 9, -0.25f, true));
        this.WingL2 = new ModelRenderer((ModelBase)this);
        this.WingL2.func_78793_a(2.0f, 9.0f, 3.5f);
        this.field_78115_e.func_78792_a(this.WingL2);
        this.setRotationAngle(this.WingL2, -0.3491f, 0.0f, 0.0f);
        this.WingL5_r1 = new ModelRenderer((ModelBase)this);
        this.WingL5_r1.func_78793_a(0.0f, 7.0f, -3.0f);
        this.WingL2.func_78792_a(this.WingL5_r1);
        this.setRotationAngle(this.WingL5_r1, 0.0f, 0.0f, 0.0f);
        this.WingL5_r1.field_78804_l.add(new ModelBox(this.WingL5_r1, 121, 44, -0.5f, -8.0f, 12.5f, 1, 6, 1, 0.2f, true));
        this.WingL5_r1.field_78804_l.add(new ModelBox(this.WingL5_r1, 121, 44, -0.5f, -8.0f, 6.5f, 1, 6, 1, 0.2f, true));
        this.WingL5_r1.field_78804_l.add(new ModelBox(this.WingL5_r1, 93, 45, -0.5f, -9.0f, -0.5f, 1, 1, 16, 0.4f, true));
        this.WingL3_r1 = new ModelRenderer((ModelBase)this);
        this.WingL3_r1.func_78793_a(-0.4f, 0.5f, 1.8f);
        this.WingL2.func_78792_a(this.WingL3_r1);
        this.setRotationAngle(this.WingL3_r1, -1.5708f, 0.0f, 0.0f);
        this.WingL3_r1.field_78804_l.add(new ModelBox(this.WingL3_r1, 57, 24, -0.5f, -10.5f, -2.5f, 1, 15, 9, -0.25f, true));
        this.field_178723_h.field_78804_l.add(new ModelBox(this.field_178723_h, 40, 32, -3.0f, -2.0f, -2.0f, 4, 7, 4, 0.25f, false));
        this.RightArmGem_r1 = new ModelRenderer((ModelBase)this);
        this.RightArmGem_r1.func_78793_a(5.0f, 22.0f, 0.0f);
        this.field_178723_h.func_78792_a(this.RightArmGem_r1);
        this.setRotationAngle(this.RightArmGem_r1, 0.0f, 0.0f, 0.0f);
        this.RightArmGem_r1.field_78804_l.add(new ModelBox(this.RightArmGem_r1, 72, 52, -7.5f, -24.0f, -3.1f, 3, 6, 1, 0.25f, false));
        this.RightArmGem_r1.field_78804_l.add(new ModelBox(this.RightArmGem_r1, 43, 45, -9.0f, -26.0f, -1.5f, 4, 6, 3, 0.25f, false));
        this.field_178724_i.field_78804_l.add(new ModelBox(this.field_178724_i, 40, 32, -1.0f, -2.0f, -2.0f, 4, 7, 4, 0.25f, false));
        this.LeftArmGem_r1 = new ModelRenderer((ModelBase)this);
        this.LeftArmGem_r1.func_78793_a(-5.0f, 22.0f, 0.0f);
        this.field_178724_i.func_78792_a(this.LeftArmGem_r1);
        this.setRotationAngle(this.LeftArmGem_r1, 0.0f, 0.0f, 0.0f);
        this.LeftArmGem_r1.field_78804_l.add(new ModelBox(this.LeftArmGem_r1, 72, 52, 4.5f, -24.0f, -3.1f, 3, 6, 1, 0.25f, false));
        this.LeftArmGem_r1.field_78804_l.add(new ModelBox(this.LeftArmGem_r1, 43, 45, 5.0f, -26.0f, -1.5f, 4, 6, 3, 0.25f, true));
        this.field_178721_j.field_78804_l.add(new ModelBox(this.field_178721_j, 0, 32, -2.0f, 0.0f, -2.0f, 4, 12, 4, 0.25f, false));
        this.field_178721_j.field_78804_l.add(new ModelBox(this.field_178721_j, 72, 52, -1.6f, 1.0f, -2.5f, 3, 6, 1, 0.25f, false));
        this.field_178721_j.field_78804_l.add(new ModelBox(this.field_178721_j, 72, 43, -2.3f, 3.5f, -1.5f, 1, 3, 5, 0.25f, false));
        this.field_178721_j.field_78804_l.add(new ModelBox(this.field_178721_j, 72, 43, -2.3f, 7.5f, -0.5f, 1, 3, 5, 0.25f, false));
        this.field_178722_k.field_78804_l.add(new ModelBox(this.field_178722_k, 72, 52, -1.4f, 1.0f, -2.5f, 3, 6, 1, 0.25f, false));
        this.field_178722_k.field_78804_l.add(new ModelBox(this.field_178722_k, 72, 43, 1.3f, 3.5f, -1.5f, 1, 3, 5, 0.25f, false));
        this.field_178722_k.field_78804_l.add(new ModelBox(this.field_178722_k, 72, 43, 1.3f, 7.5f, -0.5f, 1, 3, 5, 0.25f, false));
        this.LeftLegLayer_r1 = new ModelRenderer((ModelBase)this);
        this.LeftLegLayer_r1.func_78793_a(-1.9f, 12.0f, 0.0f);
        this.field_178722_k.func_78792_a(this.LeftLegLayer_r1);
        this.setRotationAngle(this.LeftLegLayer_r1, 0.0f, 0.0f, 0.0f);
        this.LeftLegLayer_r1.field_78804_l.add(new ModelBox(this.LeftLegLayer_r1, 0, 48, -0.1f, -12.0f, -2.0f, 4, 12, 4, 0.25f, false));
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
            this.WingR.field_78796_g = (float)(-0.5235987755982988 - 0.5 * Math.cos(ageInTicks * 0.6f));
            this.WingR.field_78795_f = (float)(0.5235987755982988 + (double)0.3f * Math.cos(ageInTicks * 0.2f));
            this.WingL.field_78796_g = -this.WingR.field_78796_g;
            this.WingL.field_78795_f = this.WingR.field_78795_f;
            this.WingL2.field_78795_f = this.WingR2.field_78795_f = (float)(-0.5235987755982988 - (double)0.3f * Math.cos(ageInTicks * 0.2f));
            this.WingR2.field_78796_g = this.WingR.field_78796_g;
            this.WingL2.field_78796_g = this.WingL.field_78796_g;
        }
    }
}

