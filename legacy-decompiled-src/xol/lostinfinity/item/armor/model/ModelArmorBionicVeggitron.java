/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.model.ModelBox
 *  net.minecraft.client.model.ModelRenderer
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.util.math.Mth
 */
package xol.lostinfinity.item.armor.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.util.Mth;
import xol.lostinfinity.item.armor.model.ModelLostArmor;

public class ModelArmorBionicVeggitron
extends ModelLostArmor {
    private final ModelRenderer BodyLayer_r1;
    private final ModelRenderer BodyLayer_r2;
    private final ModelRenderer WingL;
    private final ModelRenderer WingLSub;
    private final ModelRenderer WingR;
    private final ModelRenderer WingRSub;

    public ModelArmorBionicVeggitron() {
        this.field_78090_t = 128;
        this.field_78089_u = 64;
        this.field_78116_c.field_78804_l.add(new ModelBox(this.field_78116_c, 64, 0, -4.0f, -8.0f, -4.0f, 8, 8, 8, 0.6f, false));
        this.field_78116_c.field_78804_l.add(new ModelBox(this.field_78116_c, 118, 20, -2.0f, -7.0f, -5.0f, 4, 4, 1, 0.0f, false));
        this.field_78116_c.field_78804_l.add(new ModelBox(this.field_78116_c, 103, 21, -3.0f, -8.0f, -5.5f, 6, 1, 1, 0.0f, false));
        this.field_78116_c.field_78804_l.add(new ModelBox(this.field_78116_c, 122, 28, 3.0f, -7.0f, -5.5f, 2, 1, 1, 0.0f, false));
        this.field_78116_c.field_78804_l.add(new ModelBox(this.field_78116_c, 112, 27, 4.0f, -7.0f, -4.5f, 1, 1, 7, 0.0f, false));
        this.field_78116_c.field_78804_l.add(new ModelBox(this.field_78116_c, 88, 21, 4.0f, -4.0f, -4.5f, 1, 1, 7, 0.0f, false));
        this.field_78116_c.field_78804_l.add(new ModelBox(this.field_78116_c, 122, 31, 3.0f, -4.0f, -5.5f, 2, 1, 1, 0.0f, false));
        this.field_78116_c.field_78804_l.add(new ModelBox(this.field_78116_c, 122, 28, -5.0f, -7.0f, -5.5f, 2, 1, 1, 0.0f, true));
        this.field_78116_c.field_78804_l.add(new ModelBox(this.field_78116_c, 112, 27, -5.0f, -7.0f, -4.5f, 1, 1, 7, 0.0f, true));
        this.field_78116_c.field_78804_l.add(new ModelBox(this.field_78116_c, 88, 21, -5.0f, -4.0f, -4.5f, 1, 1, 7, 0.0f, true));
        this.field_78116_c.field_78804_l.add(new ModelBox(this.field_78116_c, 122, 31, -5.0f, -4.0f, -5.5f, 2, 1, 1, 0.0f, true));
        this.field_78116_c.field_78804_l.add(new ModelBox(this.field_78116_c, 103, 24, -3.0f, -3.0f, -5.5f, 6, 1, 1, 0.0f, false));
        this.field_78116_c.field_78804_l.add(new ModelBox(this.field_78116_c, 98, 21, 2.0f, -7.0f, -5.5f, 1, 4, 1, 0.0f, false));
        this.field_78116_c.field_78804_l.add(new ModelBox(this.field_78116_c, 98, 21, -3.0f, -7.0f, -5.5f, 1, 4, 1, 0.0f, true));
        this.field_78116_c.field_78804_l.add(new ModelBox(this.field_78116_c, 96, 10, -4.0f, -9.5f, -4.0f, 8, 1, 8, 0.4f, false));
        this.field_78116_c.field_78804_l.add(new ModelBox(this.field_78116_c, 96, 0, -4.0f, -10.5f, -4.0f, 8, 1, 8, 0.1f, false));
        this.BodyLayer_r1 = new ModelRenderer((ModelBase)this);
        this.BodyLayer_r1.func_78793_a(0.0f, 14.0f, 0.0f);
        this.field_78115_e.func_78792_a(this.BodyLayer_r1);
        this.setRotationAngle(this.BodyLayer_r1, -0.1745f, 0.0f, 0.0f);
        this.BodyLayer_r1.field_78804_l.add(new ModelBox(this.BodyLayer_r1, 85, 43, -2.5f, -5.0f, 1.3f, 5, 2, 2, -0.5f, false));
        this.BodyLayer_r1.field_78804_l.add(new ModelBox(this.BodyLayer_r1, 116, 38, -2.0f, -7.0f, 1.2f, 4, 6, 2, -0.5f, false));
        this.BodyLayer_r1.field_78804_l.add(new ModelBox(this.BodyLayer_r1, 16, 36, -4.0f, -6.0f, -6.0f, 8, 4, 8, 0.3f, false));
        this.BodyLayer_r2 = new ModelRenderer((ModelBase)this);
        this.BodyLayer_r2.func_78793_a(0.0f, 4.0f, 0.0f);
        this.field_78115_e.func_78792_a(this.BodyLayer_r2);
        this.setRotationAngle(this.BodyLayer_r2, -0.0873f, 0.0f, 0.0f);
        this.BodyLayer_r2.field_78804_l.add(new ModelBox(this.BodyLayer_r2, 85, 43, -2.5f, -4.0f, 2.8f, 5, 2, 2, -0.5f, false));
        this.BodyLayer_r2.field_78804_l.add(new ModelBox(this.BodyLayer_r2, 85, 43, -2.5f, -1.0f, 2.8f, 5, 2, 2, -0.5f, false));
        this.BodyLayer_r2.field_78804_l.add(new ModelBox(this.BodyLayer_r2, 98, 34, 3.5f, -4.0f, -5.0f, 2, 2, 7, -0.5f, true));
        this.BodyLayer_r2.field_78804_l.add(new ModelBox(this.BodyLayer_r2, 82, 17, 1.5f, -4.0f, -6.0f, 4, 2, 2, -0.5f, true));
        this.BodyLayer_r2.field_78804_l.add(new ModelBox(this.BodyLayer_r2, 98, 34, 3.5f, 2.0f, -5.0f, 2, 2, 7, -0.5f, true));
        this.BodyLayer_r2.field_78804_l.add(new ModelBox(this.BodyLayer_r2, 98, 34, 3.5f, -1.0f, -5.0f, 2, 2, 7, -0.5f, true));
        this.BodyLayer_r2.field_78804_l.add(new ModelBox(this.BodyLayer_r2, 82, 17, 1.5f, -1.0f, -6.0f, 4, 2, 2, -0.5f, true));
        this.BodyLayer_r2.field_78804_l.add(new ModelBox(this.BodyLayer_r2, 104, 28, 0.5f, 2.0f, -6.0f, 5, 2, 2, -0.5f, true));
        this.BodyLayer_r2.field_78804_l.add(new ModelBox(this.BodyLayer_r2, 98, 34, -5.5f, 2.0f, -5.0f, 2, 2, 7, -0.5f, false));
        this.BodyLayer_r2.field_78804_l.add(new ModelBox(this.BodyLayer_r2, 98, 34, -5.5f, -1.0f, -5.0f, 2, 2, 7, -0.5f, false));
        this.BodyLayer_r2.field_78804_l.add(new ModelBox(this.BodyLayer_r2, 98, 34, -5.5f, -4.0f, -5.0f, 2, 2, 7, -0.5f, false));
        this.BodyLayer_r2.field_78804_l.add(new ModelBox(this.BodyLayer_r2, 82, 17, -5.5f, -4.0f, -6.0f, 4, 2, 2, -0.5f, false));
        this.BodyLayer_r2.field_78804_l.add(new ModelBox(this.BodyLayer_r2, 82, 17, -5.5f, -1.0f, -6.0f, 4, 2, 2, -0.5f, false));
        this.BodyLayer_r2.field_78804_l.add(new ModelBox(this.BodyLayer_r2, 104, 28, -5.5f, 2.0f, -6.0f, 5, 2, 2, -0.5f, false));
        this.BodyLayer_r2.field_78804_l.add(new ModelBox(this.BodyLayer_r2, 85, 43, -2.5f, 2.0f, 2.8f, 5, 2, 2, -0.5f, false));
        this.BodyLayer_r2.field_78804_l.add(new ModelBox(this.BodyLayer_r2, 116, 47, -2.0f, -5.1f, 2.7f, 4, 10, 2, -0.5f, false));
        this.BodyLayer_r2.field_78804_l.add(new ModelBox(this.BodyLayer_r2, 16, 48, -4.0f, -4.0f, -4.5f, 8, 8, 8, 0.5f, false));
        this.WingL = new ModelRenderer((ModelBase)this);
        this.WingL.func_78793_a(3.0f, 1.0f, 3.0f);
        this.field_78115_e.func_78792_a(this.WingL);
        this.WingL.field_78804_l.add(new ModelBox(this.WingL, 68, 18, -1.5f, -1.0f, 3.0f, 2, 2, 3, 0.2f, false));
        this.WingL.field_78804_l.add(new ModelBox(this.WingL, 68, 25, -1.5f, -1.0f, 0.0f, 2, 2, 3, 0.5f, false));
        this.WingLSub = new ModelRenderer((ModelBase)this);
        this.WingLSub.func_78793_a(0.0f, 0.0f, 7.0f);
        this.WingL.func_78792_a(this.WingLSub);
        this.WingLSub.field_78804_l.add(new ModelBox(this.WingLSub, 64, 16, -0.5f, -5.0f, 1.0f, 1, 10, 16, 0.0f, false));
        this.WingLSub.field_78804_l.add(new ModelBox(this.WingLSub, 86, 49, -0.5f, 0.0f, -8.0f, 1, 5, 9, 0.0f, false));
        this.WingLSub.field_78804_l.add(new ModelBox(this.WingLSub, 88, 45, -1.5f, -6.0f, -1.0f, 2, 1, 18, 0.0f, false));
        this.WingLSub.field_78804_l.add(new ModelBox(this.WingLSub, 97, 48, -1.5f, -5.0f, -1.0f, 2, 6, 2, 0.0f, false));
        this.WingR = new ModelRenderer((ModelBase)this);
        this.WingR.func_78793_a(-3.0f, 1.0f, 3.0f);
        this.field_78115_e.func_78792_a(this.WingR);
        this.WingR.field_78804_l.add(new ModelBox(this.WingR, 68, 18, -0.5f, -1.0f, 3.0f, 2, 2, 3, 0.2f, true));
        this.WingR.field_78804_l.add(new ModelBox(this.WingR, 68, 25, -0.5f, -1.0f, 0.0f, 2, 2, 3, 0.5f, true));
        this.WingRSub = new ModelRenderer((ModelBase)this);
        this.WingRSub.func_78793_a(0.0f, 0.0f, 7.0f);
        this.WingR.func_78792_a(this.WingRSub);
        this.WingRSub.field_78804_l.add(new ModelBox(this.WingRSub, 64, 16, -0.5f, -5.0f, 1.0f, 1, 10, 16, 0.0f, true));
        this.WingRSub.field_78804_l.add(new ModelBox(this.WingRSub, 86, 49, -0.5f, 0.0f, -8.0f, 1, 5, 9, 0.0f, true));
        this.WingRSub.field_78804_l.add(new ModelBox(this.WingRSub, 88, 45, -0.5f, -6.0f, -1.0f, 2, 1, 18, 0.0f, true));
        this.WingRSub.field_78804_l.add(new ModelBox(this.WingRSub, 97, 48, -0.5f, -5.0f, -1.0f, 2, 6, 2, 0.0f, true));
        this.field_178722_k.field_78804_l.add(new ModelBox(this.field_178722_k, 0, 48, -2.0f, 0.0f, -2.0f, 4, 12, 4, 0.25f, false));
        this.field_178722_k.field_78804_l.add(new ModelBox(this.field_178722_k, 0, 36, -1.8f, 6.0f, -2.2f, 4, 5, 4, 0.25f, false));
        this.field_178722_k.field_78804_l.add(new ModelBox(this.field_178722_k, 42, 39, -2.0f, 2.0f, -3.0f, 4, 3, 1, 0.24f, false));
        this.field_178722_k.field_78804_l.add(new ModelBox(this.field_178722_k, 41, 50, -2.0f, -1.0f, -4.0f, 4, 3, 2, 0.23f, false));
        this.field_178721_j.field_78804_l.add(new ModelBox(this.field_178721_j, 0, 48, -2.0f, 0.0f, -2.0f, 4, 12, 4, 0.25f, true));
        this.field_178721_j.field_78804_l.add(new ModelBox(this.field_178721_j, 0, 36, -2.2f, 6.0f, -2.2f, 4, 5, 4, 0.25f, true));
        this.field_178721_j.field_78804_l.add(new ModelBox(this.field_178721_j, 42, 39, -2.0f, 2.0f, -3.0f, 4, 3, 1, 0.24f, true));
        this.field_178721_j.field_78804_l.add(new ModelBox(this.field_178721_j, 41, 50, -2.0f, -1.0f, -4.0f, 4, 3, 2, 0.23f, true));
        this.field_178724_i.field_78804_l.add(new ModelBox(this.field_178724_i, 69, 55, -1.0f, 3.0f, -2.0f, 4, 5, 4, 0.25f, false));
        this.field_178724_i.field_78804_l.add(new ModelBox(this.field_178724_i, 73, 46, -0.8f, 3.5f, -2.0f, 4, 4, 4, 0.3f, false));
        this.field_178724_i.field_78804_l.add(new ModelBox(this.field_178724_i, 48, 54, -1.0f, -2.5f, -2.5f, 5, 5, 5, 0.25f, false));
        this.field_178724_i.field_78804_l.add(new ModelBox(this.field_178724_i, 54, 42, 0.5f, -2.7f, -3.0f, 3, 5, 6, 0.25f, false));
        this.field_178723_h.field_78804_l.add(new ModelBox(this.field_178723_h, 69, 55, -3.0f, 3.0f, -2.0f, 4, 5, 4, 0.25f, true));
        this.field_178723_h.field_78804_l.add(new ModelBox(this.field_178723_h, 73, 46, -3.2f, 3.5f, -2.0f, 4, 4, 4, 0.3f, true));
        this.field_178723_h.field_78804_l.add(new ModelBox(this.field_178723_h, 48, 54, -4.0f, -2.5f, -2.5f, 5, 5, 5, 0.25f, true));
        this.field_178723_h.field_78804_l.add(new ModelBox(this.field_178723_h, 68, 43, -5.0f, -3.2f, 1.5f, 6, 1, 1, -0.25f, true));
        this.field_178723_h.field_78804_l.add(new ModelBox(this.field_178723_h, 68, 43, -5.0f, -3.2f, -2.5f, 6, 1, 1, -0.25f, true));
        this.field_178723_h.field_78804_l.add(new ModelBox(this.field_178723_h, 68, 43, -5.0f, -3.2f, -1.5f, 6, 1, 1, -0.25f, true));
        this.field_178723_h.field_78804_l.add(new ModelBox(this.field_178723_h, 68, 43, -5.0f, -3.2f, 0.5f, 6, 1, 1, -0.25f, true));
        this.field_178723_h.field_78804_l.add(new ModelBox(this.field_178723_h, 68, 43, -5.0f, -3.2f, -0.5f, 6, 1, 1, -0.25f, true));
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
            this.WingR.field_78796_g = -0.75f - 0.75f * Mth.func_76134_b((float)(ageInTicks * 0.4f));
            this.WingR.field_78795_f = 0.1f + 0.4f * Mth.func_76134_b((float)(ageInTicks * 0.1f));
            this.WingRSub.field_78795_f = 0.25f * Mth.func_76126_a((float)(ageInTicks * 0.3f));
            this.WingL.field_78796_g = -this.WingR.field_78796_g;
            this.WingL.field_78795_f = this.WingR.field_78795_f;
            this.WingLSub.field_78795_f = this.WingRSub.field_78795_f;
        }
    }
}

