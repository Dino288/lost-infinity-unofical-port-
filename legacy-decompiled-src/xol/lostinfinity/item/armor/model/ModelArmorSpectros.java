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

public class ModelArmorSpectros
extends ModelLostArmor {
    private final ModelRenderer Rib8_r1;
    private final ModelRenderer Rib7_r1;
    private final ModelRenderer Rib6_r1;
    private final ModelRenderer Rib5_r1;
    private final ModelRenderer Rib4_r1;
    private final ModelRenderer Rib3_r1;
    private final ModelRenderer Rib2_r1;
    private final ModelRenderer Rib1_r1;
    private final ModelRenderer WingR;
    private final ModelRenderer wingr6_r1;
    private final ModelRenderer wingr4_r1;
    private final ModelRenderer wingr2_r1;
    private final ModelRenderer WingL;
    private final ModelRenderer wingl6_r1;
    private final ModelRenderer wingl4_r1;
    private final ModelRenderer wingl2_r1;
    private final ModelRenderer RPlate;
    private final ModelRenderer LSpike9_r1;
    private final ModelRenderer LSpike6_r1;
    private final ModelRenderer LSpike5_r1;
    private final ModelRenderer LSpike4_r1;
    private final ModelRenderer LPlate;
    private final ModelRenderer LSpike8_r1;
    private final ModelRenderer LSpike5_r2;
    private final ModelRenderer LSpike4_r2;
    private final ModelRenderer LSpike3_r1;

    public ModelArmorSpectros() {
        this.field_78090_t = 128;
        this.field_78089_u = 64;
        this.field_78116_c.field_78804_l.add(new ModelBox(this.field_78116_c, 64, 0, -4.0f, -8.0f, -4.0f, 8, 8, 8, 0.5f, false));
        this.field_78116_c.field_78804_l.add(new ModelBox(this.field_78116_c, 97, 11, -3.0f, -9.0f, -3.0f, 1, 1, 8, 0.5f, false));
        this.field_78116_c.field_78804_l.add(new ModelBox(this.field_78116_c, 97, 11, 2.0f, -9.0f, -3.0f, 1, 1, 8, 0.5f, false));
        this.field_78116_c.field_78804_l.add(new ModelBox(this.field_78116_c, 120, 1, 2.0f, -7.0f, 4.0f, 1, 6, 1, 0.5f, false));
        this.field_78116_c.field_78804_l.add(new ModelBox(this.field_78116_c, 120, 1, -3.0f, -7.0f, 4.0f, 1, 6, 1, 0.5f, false));
        this.field_78116_c.field_78804_l.add(new ModelBox(this.field_78116_c, 97, 0, -4.0f, -8.0f, -6.0f, 8, 8, 1, 0.5f, false));
        this.field_78115_e.field_78804_l.add(new ModelBox(this.field_78115_e, 16, 32, -4.0f, 0.0f, -2.0f, 8, 12, 4, 0.5f, false));
        this.field_78115_e.field_78804_l.add(new ModelBox(this.field_78115_e, 76, 48, -1.0f, 1.0f, -1.0f, 2, 10, 4, 0.5f, false));
        this.Rib8_r1 = new ModelRenderer((ModelBase)this);
        this.Rib8_r1.func_78793_a(3.0f, 4.0f, -2.5f);
        this.field_78115_e.func_78792_a(this.Rib8_r1);
        this.setRotateAngle(this.Rib8_r1, 0.0f, 0.0f, -0.2618f);
        this.Rib8_r1.field_78804_l.add(new ModelBox(this.Rib8_r1, 21, 51, -2.0f, -1.0f, -0.5f, 4, 2, 1, -0.25f, true));
        this.Rib7_r1 = new ModelRenderer((ModelBase)this);
        this.Rib7_r1.func_78793_a(3.0f, 6.0f, -2.5f);
        this.field_78115_e.func_78792_a(this.Rib7_r1);
        this.setRotateAngle(this.Rib7_r1, 0.0f, 0.0f, -0.2618f);
        this.Rib7_r1.field_78804_l.add(new ModelBox(this.Rib7_r1, 21, 51, -2.0f, -1.0f, -0.5f, 4, 2, 1, -0.25f, true));
        this.Rib6_r1 = new ModelRenderer((ModelBase)this);
        this.Rib6_r1.func_78793_a(3.0f, 8.0f, -2.5f);
        this.field_78115_e.func_78792_a(this.Rib6_r1);
        this.setRotateAngle(this.Rib6_r1, 0.0f, 0.0f, -0.2618f);
        this.Rib6_r1.field_78804_l.add(new ModelBox(this.Rib6_r1, 21, 51, -2.0f, -1.0f, -0.5f, 4, 2, 1, -0.25f, true));
        this.Rib5_r1 = new ModelRenderer((ModelBase)this);
        this.Rib5_r1.func_78793_a(3.0f, 10.0f, -2.5f);
        this.field_78115_e.func_78792_a(this.Rib5_r1);
        this.setRotateAngle(this.Rib5_r1, 0.0f, 0.0f, -0.2618f);
        this.Rib5_r1.field_78804_l.add(new ModelBox(this.Rib5_r1, 21, 51, -2.0f, -1.0f, -0.5f, 4, 2, 1, -0.25f, true));
        this.Rib4_r1 = new ModelRenderer((ModelBase)this);
        this.Rib4_r1.func_78793_a(-3.0f, 10.0f, -2.5f);
        this.field_78115_e.func_78792_a(this.Rib4_r1);
        this.setRotateAngle(this.Rib4_r1, 0.0f, 0.0f, 0.2618f);
        this.Rib4_r1.field_78804_l.add(new ModelBox(this.Rib4_r1, 21, 51, -2.0f, -1.0f, -0.5f, 4, 2, 1, -0.25f, false));
        this.Rib3_r1 = new ModelRenderer((ModelBase)this);
        this.Rib3_r1.func_78793_a(-3.0f, 8.0f, -2.5f);
        this.field_78115_e.func_78792_a(this.Rib3_r1);
        this.setRotateAngle(this.Rib3_r1, 0.0f, 0.0f, 0.2618f);
        this.Rib3_r1.field_78804_l.add(new ModelBox(this.Rib3_r1, 21, 51, -2.0f, -1.0f, -0.5f, 4, 2, 1, -0.25f, false));
        this.Rib2_r1 = new ModelRenderer((ModelBase)this);
        this.Rib2_r1.func_78793_a(-3.0f, 6.0f, -2.5f);
        this.field_78115_e.func_78792_a(this.Rib2_r1);
        this.setRotateAngle(this.Rib2_r1, 0.0f, 0.0f, 0.2618f);
        this.Rib2_r1.field_78804_l.add(new ModelBox(this.Rib2_r1, 21, 51, -2.0f, -1.0f, -0.5f, 4, 2, 1, -0.25f, false));
        this.Rib1_r1 = new ModelRenderer((ModelBase)this);
        this.Rib1_r1.func_78793_a(-3.0f, 4.0f, -2.5f);
        this.field_78115_e.func_78792_a(this.Rib1_r1);
        this.setRotateAngle(this.Rib1_r1, 0.0f, 0.0f, 0.2618f);
        this.Rib1_r1.field_78804_l.add(new ModelBox(this.Rib1_r1, 21, 51, -2.0f, -1.0f, -0.5f, 4, 2, 1, -0.25f, false));
        this.WingR = new ModelRenderer((ModelBase)this);
        this.WingR.func_78793_a(-2.0f, 3.5f, 2.5f);
        this.field_78115_e.func_78792_a(this.WingR);
        this.setRotateAngle(this.WingR, 0.0f, 0.3054f, 0.0f);
        this.WingR.field_78804_l.add(new ModelBox(this.WingR, 62, 44, -5.0f, -0.5f, -0.5f, 6, 1, 1, 0.5f, false));
        this.WingR.field_78804_l.add(new ModelBox(this.WingR, 62, 44, -5.0f, 2.5f, -0.5f, 6, 1, 1, 0.5f, false));
        this.WingR.field_78804_l.add(new ModelBox(this.WingR, 62, 44, -5.0f, 5.5f, -0.5f, 6, 1, 1, 0.5f, false));
        this.wingr6_r1 = new ModelRenderer((ModelBase)this);
        this.wingr6_r1.func_78793_a(0.0f, 6.0f, 0.0f);
        this.WingR.func_78792_a(this.wingr6_r1);
        this.setRotateAngle(this.wingr6_r1, 0.0f, 0.0f, -0.3491f);
        this.wingr6_r1.field_78804_l.add(new ModelBox(this.wingr6_r1, 78, 44, -10.0f, -2.5f, -0.5f, 6, 1, 1, 0.0f, false));
        this.wingr4_r1 = new ModelRenderer((ModelBase)this);
        this.wingr4_r1.func_78793_a(0.0f, 3.0f, 0.0f);
        this.WingR.func_78792_a(this.wingr4_r1);
        this.setRotateAngle(this.wingr4_r1, 0.0f, 0.0f, -0.3491f);
        this.wingr4_r1.field_78804_l.add(new ModelBox(this.wingr4_r1, 78, 44, -10.0f, -2.5f, -0.5f, 6, 1, 1, 0.0f, false));
        this.wingr2_r1 = new ModelRenderer((ModelBase)this);
        this.wingr2_r1.func_78793_a(0.0f, 0.0f, 0.0f);
        this.WingR.func_78792_a(this.wingr2_r1);
        this.setRotateAngle(this.wingr2_r1, 0.0f, 0.0f, -0.3491f);
        this.wingr2_r1.field_78804_l.add(new ModelBox(this.wingr2_r1, 78, 44, -10.0f, -2.5f, -0.5f, 6, 1, 1, 0.0f, false));
        this.WingL = new ModelRenderer((ModelBase)this);
        this.WingL.func_78793_a(2.0f, 3.5f, 2.5f);
        this.field_78115_e.func_78792_a(this.WingL);
        this.setRotateAngle(this.WingL, 0.0f, -0.3054f, 0.0f);
        this.WingL.field_78804_l.add(new ModelBox(this.WingL, 62, 44, -1.0f, -0.5f, -0.5f, 6, 1, 1, 0.5f, true));
        this.WingL.field_78804_l.add(new ModelBox(this.WingL, 62, 44, -1.0f, 2.5f, -0.5f, 6, 1, 1, 0.5f, true));
        this.WingL.field_78804_l.add(new ModelBox(this.WingL, 62, 44, -1.0f, 5.5f, -0.5f, 6, 1, 1, 0.5f, true));
        this.wingl6_r1 = new ModelRenderer((ModelBase)this);
        this.wingl6_r1.func_78793_a(0.0f, 6.0f, 0.0f);
        this.WingL.func_78792_a(this.wingl6_r1);
        this.setRotateAngle(this.wingl6_r1, 0.0f, 0.0f, 0.3491f);
        this.wingl6_r1.field_78804_l.add(new ModelBox(this.wingl6_r1, 78, 44, 4.0f, -2.5f, -0.5f, 6, 1, 1, 0.0f, true));
        this.wingl4_r1 = new ModelRenderer((ModelBase)this);
        this.wingl4_r1.func_78793_a(0.0f, 3.0f, 0.0f);
        this.WingL.func_78792_a(this.wingl4_r1);
        this.setRotateAngle(this.wingl4_r1, 0.0f, 0.0f, 0.3491f);
        this.wingl4_r1.field_78804_l.add(new ModelBox(this.wingl4_r1, 78, 44, 4.0f, -2.5f, -0.5f, 6, 1, 1, 0.0f, true));
        this.wingl2_r1 = new ModelRenderer((ModelBase)this);
        this.wingl2_r1.func_78793_a(0.0f, 0.0f, 0.0f);
        this.WingL.func_78792_a(this.wingl2_r1);
        this.setRotateAngle(this.wingl2_r1, 0.0f, 0.0f, 0.3491f);
        this.wingl2_r1.field_78804_l.add(new ModelBox(this.wingl2_r1, 78, 44, 4.0f, -2.5f, -0.5f, 6, 1, 1, 0.0f, true));
        this.field_178723_h.field_78804_l.add(new ModelBox(this.field_178723_h, 40, 32, -3.0f, 0.0f, -2.0f, 4, 8, 4, 0.25f, false));
        this.RPlate = new ModelRenderer((ModelBase)this);
        this.RPlate.func_78793_a(-5.7039f, -4.9898f, -1.75f);
        this.field_178723_h.func_78792_a(this.RPlate);
        this.RPlate.field_78804_l.add(new ModelBox(this.RPlate, 18, 57, 1.7039f, 2.9898f, -0.75f, 5, 2, 5, 0.25f, true));
        this.LSpike9_r1 = new ModelRenderer((ModelBase)this);
        this.LSpike9_r1.func_78793_a(0.1877f, 6.9254f, 0.25f);
        this.RPlate.func_78792_a(this.LSpike9_r1);
        this.setRotateAngle(this.LSpike9_r1, 0.0f, 0.0f, -0.0873f);
        this.LSpike9_r1.field_78804_l.add(new ModelBox(this.LSpike9_r1, 45, 58, 0.5f, 0.0f, 1.75f, 1, 4, 1, -0.25f, true));
        this.LSpike9_r1.field_78804_l.add(new ModelBox(this.LSpike9_r1, 45, 58, 0.5f, 0.0f, 0.25f, 1, 4, 1, -0.25f, true));
        this.LSpike6_r1 = new ModelRenderer((ModelBase)this);
        this.LSpike6_r1.func_78793_a(2.2943f, 3.2766f, -1.25f);
        this.RPlate.func_78792_a(this.LSpike6_r1);
        this.setRotateAngle(this.LSpike6_r1, 0.0f, 0.0f, 0.2618f);
        this.LSpike6_r1.field_78804_l.add(new ModelBox(this.LSpike6_r1, 40, 58, -0.5f, 0.2132f, 2.5f, 1, 4, 1, 0.25f, true));
        this.LSpike5_r1 = new ModelRenderer((ModelBase)this);
        this.LSpike5_r1.func_78793_a(1.0f, 0.0f, 0.0f);
        this.RPlate.func_78792_a(this.LSpike5_r1);
        this.setRotateAngle(this.LSpike5_r1, 0.0f, 0.0f, -0.2618f);
        this.LSpike5_r1.field_78804_l.add(new ModelBox(this.LSpike5_r1, 34, 56, -0.5f, -2.0f, 0.0f, 1, 4, 1, -0.75f, true));
        this.LSpike5_r1.field_78804_l.add(new ModelBox(this.LSpike5_r1, 34, 56, -0.5f, -2.0f, 2.5f, 1, 4, 1, -0.75f, true));
        this.LSpike4_r1 = new ModelRenderer((ModelBase)this);
        this.LSpike4_r1.func_78793_a(3.2943f, 3.2766f, -1.25f);
        this.RPlate.func_78792_a(this.LSpike4_r1);
        this.setRotateAngle(this.LSpike4_r1, 0.0f, 0.0f, -0.6109f);
        this.LSpike4_r1.field_78804_l.add(new ModelBox(this.LSpike4_r1, 34, 49, -0.5f, -3.0f, 1.25f, 1, 4, 1, 0.25f, true));
        this.LSpike4_r1.field_78804_l.add(new ModelBox(this.LSpike4_r1, 34, 49, -0.5f, -3.0f, 3.75f, 1, 4, 1, 0.25f, true));
        this.field_178724_i.field_78804_l.add(new ModelBox(this.field_178724_i, 40, 45, -1.0f, 0.0f, -2.0f, 4, 8, 4, 0.25f, false));
        this.LPlate = new ModelRenderer((ModelBase)this);
        this.LPlate.func_78793_a(5.7039f, -4.9898f, -1.75f);
        this.field_178724_i.func_78792_a(this.LPlate);
        this.LPlate.field_78804_l.add(new ModelBox(this.LPlate, 18, 57, -6.7039f, 2.9898f, -0.75f, 5, 2, 5, 0.25f, false));
        this.LSpike8_r1 = new ModelRenderer((ModelBase)this);
        this.LSpike8_r1.func_78793_a(-0.1877f, 6.9254f, 0.25f);
        this.LPlate.func_78792_a(this.LSpike8_r1);
        this.setRotateAngle(this.LSpike8_r1, 0.0f, 0.0f, 0.0873f);
        this.LSpike8_r1.field_78804_l.add(new ModelBox(this.LSpike8_r1, 45, 58, -1.5f, 0.0f, 1.75f, 1, 4, 1, -0.25f, false));
        this.LSpike8_r1.field_78804_l.add(new ModelBox(this.LSpike8_r1, 45, 58, -1.5f, 0.0f, 0.25f, 1, 4, 1, -0.25f, false));
        this.LSpike5_r2 = new ModelRenderer((ModelBase)this);
        this.LSpike5_r2.func_78793_a(-2.2943f, 3.2766f, -1.25f);
        this.LPlate.func_78792_a(this.LSpike5_r2);
        this.setRotateAngle(this.LSpike5_r2, 0.0f, 0.0f, -0.2618f);
        this.LSpike5_r2.field_78804_l.add(new ModelBox(this.LSpike5_r2, 40, 58, -0.5f, 0.2132f, 2.5f, 1, 4, 1, 0.25f, false));
        this.LSpike4_r2 = new ModelRenderer((ModelBase)this);
        this.LSpike4_r2.func_78793_a(-1.0f, 0.0f, 0.0f);
        this.LPlate.func_78792_a(this.LSpike4_r2);
        this.setRotateAngle(this.LSpike4_r2, 0.0f, 0.0f, 0.2618f);
        this.LSpike4_r2.field_78804_l.add(new ModelBox(this.LSpike4_r2, 34, 56, -0.5f, -2.0f, 0.0f, 1, 4, 1, -0.75f, false));
        this.LSpike4_r2.field_78804_l.add(new ModelBox(this.LSpike4_r2, 34, 56, -0.5f, -2.0f, 2.5f, 1, 4, 1, -0.75f, false));
        this.LSpike3_r1 = new ModelRenderer((ModelBase)this);
        this.LSpike3_r1.func_78793_a(-3.2943f, 3.2766f, -1.25f);
        this.LPlate.func_78792_a(this.LSpike3_r1);
        this.setRotateAngle(this.LSpike3_r1, 0.0f, 0.0f, 0.6109f);
        this.LSpike3_r1.field_78804_l.add(new ModelBox(this.LSpike3_r1, 34, 49, -0.5f, -3.0f, 1.25f, 1, 4, 1, 0.25f, false));
        this.LSpike3_r1.field_78804_l.add(new ModelBox(this.LSpike3_r1, 34, 49, -0.5f, -3.0f, 3.75f, 1, 4, 1, 0.25f, false));
        this.field_178721_j.field_78804_l.add(new ModelBox(this.field_178721_j, 0, 32, -2.0f, 0.0f, -2.0f, 4, 12, 4, 0.25f, false));
        this.field_178721_j.field_78804_l.add(new ModelBox(this.field_178721_j, 58, 50, -2.0f, 1.0f, -2.0f, 4, 8, 4, 0.4f, true));
        this.field_178722_k.field_78804_l.add(new ModelBox(this.field_178722_k, 0, 48, -2.0f, 0.0f, -2.0f, 4, 12, 4, 0.25f, false));
        this.field_178722_k.field_78804_l.add(new ModelBox(this.field_178722_k, 58, 50, -2.0f, 1.0f, -2.0f, 4, 8, 4, 0.4f, false));
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
            this.WingR.field_78808_h = (float)((double)-0.2f - 0.25 * Math.sin(ageInTicks * 0.1f));
            this.WingL.field_78808_h = -this.WingR.field_78808_h;
        }
    }
}

