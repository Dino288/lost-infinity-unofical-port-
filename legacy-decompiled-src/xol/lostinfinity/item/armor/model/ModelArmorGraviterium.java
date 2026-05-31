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

public class ModelArmorGraviterium
extends ModelLostArmor {
    private final ModelRenderer Wing;
    private final ModelRenderer Wing_r1;
    private final ModelRenderer Wing_r2;
    private final ModelRenderer Wing_r3;
    private final ModelRenderer Wing_r4;
    private final ModelRenderer RLPlate;
    private final ModelRenderer LLPlate;

    public ModelArmorGraviterium() {
        this.field_78090_t = 128;
        this.field_78089_u = 64;
        this.field_78116_c.field_78804_l.add(new ModelBox(this.field_78116_c, 89, 2, -5.0f, -6.0f, -5.0f, 10, 4, 1, 0.5f, false));
        this.field_78116_c.field_78804_l.add(new ModelBox(this.field_78116_c, 106, 2, -5.0f, -6.0f, -3.0f, 1, 3, 8, 0.5f, false));
        this.field_78116_c.field_78804_l.add(new ModelBox(this.field_78116_c, 106, 2, 4.0f, -6.0f, -3.0f, 1, 3, 8, 0.5f, false));
        this.field_78116_c.field_78804_l.add(new ModelBox(this.field_78116_c, 97, 9, -1.0f, -9.0f, 3.0f, 2, 1, 2, 0.5f, false));
        this.field_78116_c.field_78804_l.add(new ModelBox(this.field_78116_c, 112, 13, -3.0f, -7.0f, 4.0f, 6, 5, 1, 0.5f, false));
        this.field_78116_c.field_78804_l.add(new ModelBox(this.field_78116_c, 96, 14, -2.0f, -9.0f, -2.0f, 4, 1, 4, 0.5f, false));
        this.field_78116_c.field_78804_l.add(new ModelBox(this.field_78116_c, 102, 20, -5.0f, -1.0f, -3.0f, 1, 1, 8, 0.5f, false));
        this.field_78116_c.field_78804_l.add(new ModelBox(this.field_78116_c, 102, 20, 4.0f, -1.0f, -3.0f, 1, 1, 8, 0.5f, false));
        this.field_78116_c.field_78804_l.add(new ModelBox(this.field_78116_c, 113, 19, -3.0f, -1.0f, 4.0f, 6, 1, 1, 0.5f, false));
        this.field_78116_c.field_78804_l.add(new ModelBox(this.field_78116_c, 88, 22, -4.0f, 0.0f, 2.0f, 8, 1, 2, 0.5f, false));
        this.field_78116_c.field_78804_l.add(new ModelBox(this.field_78116_c, 88, 22, -4.0f, 0.0f, -2.5f, 8, 1, 2, 0.5f, false));
        this.field_78115_e.field_78804_l.add(new ModelBox(this.field_78115_e, 16, 32, -4.0f, 0.0f, -2.0f, 8, 12, 4, 0.4f, false));
        this.field_78115_e.field_78804_l.add(new ModelBox(this.field_78115_e, 18, 50, -3.0f, 3.0f, -2.5f, 6, 2, 1, 0.4f, false));
        this.field_78115_e.field_78804_l.add(new ModelBox(this.field_78115_e, 18, 50, -3.0f, 9.0f, -2.5f, 6, 2, 1, 0.4f, false));
        this.field_78115_e.field_78804_l.add(new ModelBox(this.field_78115_e, 18, 61, -2.5f, 9.5f, -3.0f, 5, 1, 1, 0.4f, false));
        this.field_78115_e.field_78804_l.add(new ModelBox(this.field_78115_e, 18, 61, -2.5f, 3.5f, -3.0f, 5, 1, 1, 0.4f, false));
        this.field_78115_e.field_78804_l.add(new ModelBox(this.field_78115_e, 27, 52, -4.5f, 3.5f, -3.0f, 1, 1, 6, 0.4f, false));
        this.field_78115_e.field_78804_l.add(new ModelBox(this.field_78115_e, 27, 52, 3.5f, 3.5f, -3.0f, 1, 1, 6, 0.4f, false));
        this.field_78115_e.field_78804_l.add(new ModelBox(this.field_78115_e, 27, 52, 3.5f, 9.5f, -3.0f, 1, 1, 6, 0.4f, false));
        this.field_78115_e.field_78804_l.add(new ModelBox(this.field_78115_e, 27, 52, -4.5f, 9.5f, -3.0f, 1, 1, 6, 0.4f, false));
        this.field_78115_e.field_78804_l.add(new ModelBox(this.field_78115_e, 43, 55, -2.5f, 3.5f, 2.0f, 5, 7, 1, 0.4f, false));
        this.Wing = new ModelRenderer((ModelBase)this);
        this.Wing.func_78793_a(0.0f, 6.5f, 4.5f);
        this.field_78115_e.func_78792_a(this.Wing);
        this.Wing.field_78804_l.add(new ModelBox(this.Wing, 57, 59, -0.5f, -5.0f, 0.5f, 1, 3, 1, 0.4f, false));
        this.Wing.field_78804_l.add(new ModelBox(this.Wing, 71, 59, -0.5f, 2.0f, 0.5f, 1, 3, 1, 0.4f, false));
        this.Wing.field_78804_l.add(new ModelBox(this.Wing, 62, 59, -5.5f, -0.5f, 0.5f, 3, 1, 1, 0.4f, false));
        this.Wing.field_78804_l.add(new ModelBox(this.Wing, 62, 59, 2.5f, -0.5f, 0.5f, 3, 1, 1, 0.4f, true));
        this.Wing.field_78804_l.add(new ModelBox(this.Wing, 57, 54, -0.5f, -0.5f, -1.5f, 1, 1, 3, 0.4f, false));
        this.Wing.field_78804_l.add(new ModelBox(this.Wing, 57, 48, -2.0f, -2.0f, 0.0f, 4, 4, 1, 0.4f, false));
        this.Wing_r1 = new ModelRenderer((ModelBase)this);
        this.Wing_r1.func_78793_a(0.0f, -3.5f, 1.0f);
        this.Wing.func_78792_a(this.Wing_r1);
        this.setRotateAngle(this.Wing_r1, 0.0f, 0.0f, 2.3562f);
        this.Wing_r1.field_78804_l.add(new ModelBox(this.Wing_r1, 57, 59, 2.0f, -8.0f, -0.5f, 1, 3, 1, 0.4f, false));
        this.Wing_r2 = new ModelRenderer((ModelBase)this);
        this.Wing_r2.func_78793_a(0.0f, -3.5f, 1.0f);
        this.Wing.func_78792_a(this.Wing_r2);
        this.setRotateAngle(this.Wing_r2, 0.0f, 0.0f, -0.7854f);
        this.Wing_r2.field_78804_l.add(new ModelBox(this.Wing_r2, 57, 59, -3.0f, -3.0f, -0.5f, 1, 3, 1, 0.4f, false));
        this.Wing_r3 = new ModelRenderer((ModelBase)this);
        this.Wing_r3.func_78793_a(0.0f, -3.5f, 1.0f);
        this.Wing.func_78792_a(this.Wing_r3);
        this.setRotateAngle(this.Wing_r3, 0.0f, 0.0f, -2.3562f);
        this.Wing_r3.field_78804_l.add(new ModelBox(this.Wing_r3, 57, 59, -3.0f, -8.0f, -0.5f, 1, 3, 1, 0.4f, false));
        this.Wing_r4 = new ModelRenderer((ModelBase)this);
        this.Wing_r4.func_78793_a(0.0f, -3.5f, 1.0f);
        this.Wing.func_78792_a(this.Wing_r4);
        this.setRotateAngle(this.Wing_r4, 0.0f, 0.0f, 0.7854f);
        this.Wing_r4.field_78804_l.add(new ModelBox(this.Wing_r4, 57, 59, 2.0f, -3.0f, -0.5f, 1, 3, 1, 0.4f, false));
        this.field_178723_h.field_78804_l.add(new ModelBox(this.field_178723_h, 40, 32, -4.5f, -2.0f, -2.5f, 5, 3, 5, 0.25f, false));
        this.field_178723_h.field_78804_l.add(new ModelBox(this.field_178723_h, 76, 32, -4.0f, -2.5f, -3.0f, 1, 2, 6, 0.25f, false));
        this.field_178723_h.field_78804_l.add(new ModelBox(this.field_178723_h, 61, 32, -2.0f, -2.5f, -3.0f, 1, 2, 6, 0.25f, false));
        this.field_178724_i.field_78804_l.add(new ModelBox(this.field_178724_i, 40, 42, -1.0f, -2.0f, -2.0f, 4, 8, 4, 0.25f, false));
        this.field_178724_i.field_78804_l.add(new ModelBox(this.field_178724_i, 57, 41, 0.5f, -1.0f, -2.5f, 3, 1, 5, 0.25f, false));
        this.field_178724_i.field_78804_l.add(new ModelBox(this.field_178724_i, 74, 41, 0.5f, 1.0f, -2.5f, 3, 1, 5, 0.25f, false));
        this.field_178724_i.field_78804_l.add(new ModelBox(this.field_178724_i, 91, 41, 0.5f, 3.0f, -2.5f, 3, 1, 5, 0.25f, false));
        this.field_178721_j.field_78804_l.add(new ModelBox(this.field_178721_j, 0, 32, -2.0f, 0.0f, -2.0f, 4, 12, 4, 0.25f, true));
        this.RLPlate = new ModelRenderer((ModelBase)this);
        this.RLPlate.func_78793_a(1.9f, 12.0f, 0.0f);
        this.field_178721_j.func_78792_a(this.RLPlate);
        this.RLPlate.field_78804_l.add(new ModelBox(this.RLPlate, 70, 49, -4.5f, -11.0f, -2.5f, 4, 1, 5, 0.25f, false));
        this.RLPlate.field_78804_l.add(new ModelBox(this.RLPlate, 89, 49, -4.5f, -9.0f, -2.5f, 4, 1, 5, 0.25f, false));
        this.RLPlate.field_78804_l.add(new ModelBox(this.RLPlate, 108, 49, -4.5f, -7.0f, -2.5f, 4, 1, 5, 0.25f, false));
        this.RLPlate.field_78804_l.add(new ModelBox(this.RLPlate, 119, 57, -4.5f, -5.0f, -0.5f, 1, 4, 2, 0.25f, false));
        this.field_178722_k.field_78804_l.add(new ModelBox(this.field_178722_k, 0, 48, -2.0f, 0.0f, -2.0f, 4, 12, 4, 0.25f, false));
        this.LLPlate = new ModelRenderer((ModelBase)this);
        this.LLPlate.func_78793_a(-1.9f, 12.0f, 0.0f);
        this.field_178722_k.func_78792_a(this.LLPlate);
        this.LLPlate.field_78804_l.add(new ModelBox(this.LLPlate, 70, 49, 0.5f, -11.0f, -2.5f, 4, 1, 5, 0.25f, true));
        this.LLPlate.field_78804_l.add(new ModelBox(this.LLPlate, 89, 49, 0.5f, -9.0f, -2.5f, 4, 1, 5, 0.25f, true));
        this.LLPlate.field_78804_l.add(new ModelBox(this.LLPlate, 108, 49, 0.5f, -7.0f, -2.5f, 4, 1, 5, 0.25f, true));
        this.LLPlate.field_78804_l.add(new ModelBox(this.LLPlate, 119, 57, 3.5f, -5.0f, -0.5f, 1, 4, 2, 0.25f, true));
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
            this.Wing.field_78808_h = ageInTicks * 0.75f;
        }
    }
}

