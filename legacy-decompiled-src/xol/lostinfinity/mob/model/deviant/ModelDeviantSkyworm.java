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

public class ModelDeviantSkyworm
extends ModelBase {
    public ModelRenderer s1;
    public ModelRenderer b1;
    public ModelRenderer b2;
    public ModelRenderer b3;
    public ModelRenderer s2;
    public ModelRenderer tailfin1;
    public ModelRenderer tailfin2;
    public ModelRenderer b1finl;
    public ModelRenderer b1finr;
    public ModelRenderer b2finl;
    public ModelRenderer b2finr;
    public ModelRenderer head;
    public ModelRenderer head2;
    public ModelRenderer head3;

    public ModelDeviantSkyworm() {
        this.field_78090_t = 128;
        this.field_78089_u = 32;
        this.b3 = new ModelRenderer((ModelBase)this, 69, 0);
        this.b3.func_78793_a(0.0f, 15.0f, 0.0f);
        this.b3.func_78790_a(-5.0f, -5.0f, 36.0f, 10, 10, 10, 0.0f);
        this.b1finl = new ModelRenderer((ModelBase)this, 40, 21);
        this.b1finl.func_78793_a(0.0f, 15.0f, 0.0f);
        this.b1finl.func_78790_a(5.0f, 0.0f, 0.0f, 10, 1, 10, 0.0f);
        this.head = new ModelRenderer((ModelBase)this, 85, 20);
        this.head.func_78793_a(0.0f, 15.0f, 0.0f);
        this.head.func_78790_a(-3.0f, -3.0f, -6.0f, 6, 6, 6, 0.0f);
        this.b1finr = new ModelRenderer((ModelBase)this, 40, 21);
        this.b1finr.field_78809_i = true;
        this.b1finr.func_78793_a(0.0f, 15.0f, 0.0f);
        this.b1finr.func_78790_a(-15.0f, 0.0f, 0.0f, 10, 1, 10, 0.0f);
        this.tailfin1 = new ModelRenderer((ModelBase)this, 0, 21);
        this.tailfin1.func_78793_a(0.0f, 13.0f, 46.0f);
        this.tailfin1.func_78790_a(-5.0f, 0.0f, 0.0f, 10, 1, 10, 0.0f);
        this.head2 = new ModelRenderer((ModelBase)this, 85, 21);
        this.head2.func_78793_a(0.0f, 15.0f, 0.0f);
        this.head2.func_78790_a(-2.0f, 3.0f, -6.0f, 1, 3, 1, 0.0f);
        this.b1 = new ModelRenderer((ModelBase)this, 0, 0);
        this.b1.func_78793_a(0.0f, 15.0f, 0.0f);
        this.b1.func_78790_a(-5.0f, -5.0f, 0.0f, 10, 10, 10, 0.0f);
        this.b2finl = new ModelRenderer((ModelBase)this, 40, 21);
        this.b2finl.func_78793_a(0.0f, 15.0f, 0.0f);
        this.b2finl.func_78790_a(5.0f, 0.0f, 18.0f, 10, 1, 10, 0.0f);
        this.tailfin2 = new ModelRenderer((ModelBase)this, 0, 21);
        this.tailfin2.func_78793_a(0.0f, 16.0f, 46.0f);
        this.tailfin2.func_78790_a(-5.0f, 0.0f, 0.0f, 10, 1, 10, 0.0f);
        this.head3 = new ModelRenderer((ModelBase)this, 85, 21);
        this.head3.func_78793_a(0.0f, 15.0f, 0.0f);
        this.head3.func_78790_a(1.0f, 3.0f, -6.0f, 1, 3, 1, 0.0f);
        this.b2 = new ModelRenderer((ModelBase)this, 0, 0);
        this.b2.func_78793_a(0.0f, 15.0f, 0.0f);
        this.b2.func_78790_a(-5.0f, -5.0f, 18.0f, 10, 10, 10, 0.0f);
        this.s1 = new ModelRenderer((ModelBase)this, 40, 0);
        this.s1.func_78793_a(0.0f, 15.0f, 0.0f);
        this.s1.func_78790_a(-3.0f, -3.0f, 10.0f, 6, 6, 8, 0.0f);
        this.s2 = new ModelRenderer((ModelBase)this, 40, 0);
        this.s2.func_78793_a(0.0f, 15.0f, 0.0f);
        this.s2.func_78790_a(-3.0f, -3.0f, 28.0f, 6, 6, 8, 0.0f);
        this.b2finr = new ModelRenderer((ModelBase)this, 40, 21);
        this.b2finr.field_78809_i = true;
        this.b2finr.func_78793_a(0.0f, 15.0f, 0.0f);
        this.b2finr.func_78790_a(-15.0f, 0.0f, 18.0f, 10, 1, 10, 0.0f);
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.head2.func_78785_a(f5);
        this.b2finr.func_78785_a(f5);
        this.head3.func_78785_a(f5);
        this.tailfin1.func_78785_a(f5);
        this.b2.func_78785_a(f5);
        this.head.func_78785_a(f5);
        this.s2.func_78785_a(f5);
        this.b3.func_78785_a(f5);
        this.b1.func_78785_a(f5);
        this.tailfin2.func_78785_a(f5);
        this.b1finr.func_78785_a(f5);
        this.b1finl.func_78785_a(f5);
        this.s1.func_78785_a(f5);
        this.b2finl.func_78785_a(f5);
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.b1.field_78808_h = ageInTicks * -0.05f;
        this.s1.field_78808_h = ageInTicks * -0.05f;
        this.b1finr.field_78808_h = ageInTicks * -0.05f;
        this.b1finl.field_78808_h = ageInTicks * -0.05f;
        this.b2.field_78808_h = ageInTicks * 0.05f;
        this.s2.field_78808_h = ageInTicks * 0.05f;
        this.b2finr.field_78808_h = ageInTicks * 0.05f;
        this.b2finl.field_78808_h = ageInTicks * 0.05f;
        this.tailfin2.field_78795_f = this.tailfin1.field_78795_f = Mth.func_76134_b((float)(ageInTicks * 0.1f)) * (float)Math.PI * 0.15f;
    }
}

