/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.model.ModelRenderer
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.math.Mth
 */
package xol.lostinfinity.mob.model.deviant;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;

public class ModelDeviantBlaze
extends ModelBase {
    public ModelRenderer rod1;
    public ModelRenderer head;
    public ModelRenderer rod1p2;
    public ModelRenderer rod2;
    public ModelRenderer rod3;
    public ModelRenderer rod4;
    public ModelRenderer rod2p2;
    public ModelRenderer rod3p2;
    public ModelRenderer rod4p2;
    public ModelRenderer vrod1;
    public ModelRenderer vrod2;
    public ModelRenderer vrod1p2;
    public ModelRenderer vrod2p2;
    public ModelRenderer head2;
    public ModelRenderer head3;

    public ModelDeviantBlaze() {
        this.field_78090_t = 64;
        this.field_78089_u = 32;
        this.rod4 = new ModelRenderer((ModelBase)this, 0, 16);
        this.rod4.func_78793_a(0.0f, 0.0f, 0.0f);
        this.rod4.func_78790_a(-6.0f, 5.0f, 4.0f, 2, 8, 2, 0.0f);
        this.rod1p2 = new ModelRenderer((ModelBase)this, 4, 22);
        this.rod1p2.func_78793_a(0.0f, 0.0f, 0.0f);
        this.rod1p2.func_78790_a(-8.0f, 9.0f, -8.0f, 6, 3, 6, 0.0f);
        this.rod4p2 = new ModelRenderer((ModelBase)this, 4, 22);
        this.rod4p2.func_78793_a(0.0f, 0.0f, 0.0f);
        this.rod4p2.func_78790_a(-8.0f, 9.0f, 2.0f, 6, 3, 6, 0.0f);
        this.head3 = new ModelRenderer((ModelBase)this, 26, 0);
        this.head3.func_78793_a(0.0f, 0.0f, 0.0f);
        this.head3.func_78790_a(1.0f, -7.0f, -4.0f, 3, 3, 3, 0.0f);
        this.rod1 = new ModelRenderer((ModelBase)this, 0, 16);
        this.rod1.func_78793_a(0.0f, 0.0f, 0.0f);
        this.rod1.func_78790_a(-6.0f, 5.0f, -6.0f, 2, 8, 2, 0.0f);
        this.vrod2 = new ModelRenderer((ModelBase)this, 32, 16);
        this.vrod2.func_78793_a(0.0f, 0.0f, 0.0f);
        this.vrod2.func_78790_a(-10.0f, -5.0f, -1.0f, 2, 10, 2, 0.0f);
        this.vrod2p2 = new ModelRenderer((ModelBase)this, 44, 16);
        this.vrod2p2.field_78809_i = true;
        this.vrod2p2.func_78793_a(0.0f, 0.0f, 0.0f);
        this.vrod2p2.func_78790_a(-16.0f, -5.0f, 0.0f, 6, 10, 1, 0.0f);
        this.head = new ModelRenderer((ModelBase)this, 0, 0);
        this.head.func_78793_a(0.0f, 0.0f, 0.0f);
        this.head.func_78790_a(-4.0f, -4.0f, -4.0f, 8, 8, 8, 0.0f);
        this.rod2 = new ModelRenderer((ModelBase)this, 0, 16);
        this.rod2.func_78793_a(0.0f, 0.0f, 0.0f);
        this.rod2.func_78790_a(4.0f, 5.0f, -6.0f, 2, 8, 2, 0.0f);
        this.vrod1p2 = new ModelRenderer((ModelBase)this, 44, 16);
        this.vrod1p2.func_78793_a(0.0f, 0.0f, 0.0f);
        this.vrod1p2.func_78790_a(10.0f, -5.0f, 0.0f, 6, 10, 1, 0.0f);
        this.rod3p2 = new ModelRenderer((ModelBase)this, 4, 22);
        this.rod3p2.func_78793_a(0.0f, 0.0f, 0.0f);
        this.rod3p2.func_78790_a(2.0f, 9.0f, 2.0f, 6, 3, 6, 0.0f);
        this.head2 = new ModelRenderer((ModelBase)this, 26, 0);
        this.head2.func_78793_a(0.0f, 0.0f, 0.0f);
        this.head2.func_78790_a(-4.0f, -7.0f, -4.0f, 3, 3, 3, 0.0f);
        this.rod3 = new ModelRenderer((ModelBase)this, 0, 16);
        this.rod3.func_78793_a(0.0f, 0.0f, 0.0f);
        this.rod3.func_78790_a(4.0f, 5.0f, 4.0f, 2, 8, 2, 0.0f);
        this.rod2p2 = new ModelRenderer((ModelBase)this, 4, 22);
        this.rod2p2.func_78793_a(0.0f, 0.0f, 0.0f);
        this.rod2p2.func_78790_a(2.0f, 9.0f, -8.0f, 6, 3, 6, 0.0f);
        this.vrod1 = new ModelRenderer((ModelBase)this, 32, 16);
        this.vrod1.func_78793_a(0.0f, 0.0f, 0.0f);
        this.vrod1.func_78790_a(8.0f, -5.0f, -1.0f, 2, 10, 2, 0.0f);
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.head2.func_78785_a(f5);
        this.vrod1.func_78785_a(f5);
        this.rod3p2.func_78785_a(f5);
        this.vrod1p2.func_78785_a(f5);
        this.rod4.func_78785_a(f5);
        this.vrod2p2.func_78785_a(f5);
        this.head3.func_78785_a(f5);
        this.rod1p2.func_78785_a(f5);
        this.rod2.func_78785_a(f5);
        this.head.func_78785_a(f5);
        this.rod3.func_78785_a(f5);
        this.rod1.func_78785_a(f5);
        this.vrod2.func_78785_a(f5);
        this.rod2p2.func_78785_a(f5);
        this.rod4p2.func_78785_a(f5);
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.vrod1.field_78808_h = ageInTicks * 0.13333334f;
        this.vrod1p2.field_78808_h = ageInTicks * 0.13333334f;
        this.vrod2.field_78808_h = ageInTicks * 0.13333334f;
        this.vrod2p2.field_78808_h = ageInTicks * 0.13333334f;
        this.rod1.field_78796_g = ageInTicks * -0.2f;
        this.rod1p2.field_78796_g = ageInTicks * -0.2f;
        this.rod1.field_78808_h = Mth.func_76134_b((float)(ageInTicks * 0.1f)) * (float)Math.PI * 0.17f;
        this.rod1p2.field_78808_h = Mth.func_76134_b((float)(ageInTicks * 0.1f)) * (float)Math.PI * 0.17f;
        this.rod2.field_78796_g = ageInTicks * 0.2f;
        this.rod2p2.field_78796_g = ageInTicks * 0.2f;
        this.rod2.field_78808_h = Mth.func_76134_b((float)(ageInTicks * 0.1f)) * (float)Math.PI * 0.17f;
        this.rod2p2.field_78808_h = Mth.func_76134_b((float)(ageInTicks * 0.1f)) * (float)Math.PI * 0.17f;
        this.rod3.field_78796_g = ageInTicks * -0.2f;
        this.rod3p2.field_78796_g = ageInTicks * -0.2f;
        this.rod3.field_78808_h = Mth.func_76126_a((float)(ageInTicks * 0.1f)) * (float)Math.PI * 0.17f;
        this.rod3p2.field_78808_h = Mth.func_76126_a((float)(ageInTicks * 0.1f)) * (float)Math.PI * 0.17f;
        this.rod4.field_78796_g = ageInTicks * 0.2f;
        this.rod4p2.field_78796_g = ageInTicks * 0.2f;
        this.rod4.field_78808_h = Mth.func_76126_a((float)(ageInTicks * 0.1f)) * (float)Math.PI * 0.17f;
        this.rod4p2.field_78808_h = Mth.func_76126_a((float)(ageInTicks * 0.1f)) * (float)Math.PI * 0.17f;
    }
}

