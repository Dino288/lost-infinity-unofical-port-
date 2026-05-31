/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.model.ModelRenderer
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.math.Mth
 */
package xol.lostinfinity.mob.model.labyrinth;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import xol.lostinfinity.mob.entity.labyrinth.EntityClinger;

public class ModelClinger
extends ModelBase {
    public ModelRenderer head;
    public ModelRenderer arm_t1;
    public ModelRenderer arm_r1;
    public ModelRenderer arm_r3;
    public ModelRenderer arm_l1;
    public ModelRenderer arm_l3;
    public ModelRenderer eye1;
    public ModelRenderer eye2;
    public ModelRenderer eye3;
    public ModelRenderer eye4;
    public ModelRenderer arm_t2;
    public ModelRenderer arm_r2;
    public ModelRenderer arm_r4;
    public ModelRenderer arm_l2;
    public ModelRenderer arm_l4;

    public ModelClinger() {
        this.field_78090_t = 64;
        this.field_78089_u = 32;
        this.arm_r4 = new ModelRenderer((ModelBase)this, 15, 17);
        this.arm_r4.func_78793_a(0.0f, 0.0f, 0.0f);
        this.arm_r4.func_78790_a(-1.0f, -8.5f, 2.0f, 2, 4, 2, 0.0f);
        this.setRotateAngle(this.arm_r4, 0.5235988f, 0.0f, 0.0f);
        this.eye4 = new ModelRenderer((ModelBase)this, 32, 0);
        this.eye4.func_78793_a(0.0f, 14.0f, 0.0f);
        this.eye4.func_78790_a(1.0f, -1.5f, -4.5f, 3, 3, 1, -0.4f);
        this.arm_r1 = new ModelRenderer((ModelBase)this, 0, 17);
        this.arm_r1.func_78793_a(4.0f, 11.0f, -1.0f);
        this.arm_r1.func_78790_a(-1.5f, -6.0f, -1.5f, 3, 8, 3, 0.0f);
        this.setRotateAngle(this.arm_r1, 0.5235988f, 0.0f, 1.0471976f);
        this.arm_l2 = new ModelRenderer((ModelBase)this, 15, 17);
        this.arm_l2.func_78793_a(0.0f, 0.0f, 0.0f);
        this.arm_l2.func_78790_a(-1.0f, -8.5f, 2.0f, 2, 4, 2, 0.0f);
        this.setRotateAngle(this.arm_l2, 0.5235988f, 0.0f, 0.0f);
        this.arm_l1 = new ModelRenderer((ModelBase)this, 0, 17);
        this.arm_l1.func_78793_a(-4.0f, 11.0f, -1.0f);
        this.arm_l1.func_78790_a(-1.5f, -6.0f, -1.5f, 3, 8, 3, 0.0f);
        this.setRotateAngle(this.arm_l1, 0.5235988f, 0.0f, -1.0471976f);
        this.arm_l3 = new ModelRenderer((ModelBase)this, 0, 17);
        this.arm_l3.func_78793_a(-4.0f, 15.5f, -1.0f);
        this.arm_l3.func_78790_a(-1.5f, -6.0f, -1.5f, 3, 8, 3, 0.0f);
        this.setRotateAngle(this.arm_l3, 0.5235988f, 0.0f, -2.0943952f);
        this.eye3 = new ModelRenderer((ModelBase)this, 32, 0);
        this.eye3.func_78793_a(0.0f, 14.0f, 0.0f);
        this.eye3.func_78790_a(-4.0f, -1.5f, -4.5f, 3, 3, 1, -0.4f);
        this.arm_r2 = new ModelRenderer((ModelBase)this, 15, 17);
        this.arm_r2.func_78793_a(0.0f, 0.0f, 0.0f);
        this.arm_r2.func_78790_a(-1.0f, -8.5f, 2.0f, 2, 4, 2, 0.0f);
        this.setRotateAngle(this.arm_r2, 0.5235988f, 0.0f, 0.0f);
        this.arm_t1 = new ModelRenderer((ModelBase)this, 0, 17);
        this.arm_t1.func_78793_a(0.0f, 9.5f, -1.0f);
        this.arm_t1.func_78790_a(-1.5f, -6.0f, -1.5f, 3, 8, 3, 0.0f);
        this.setRotateAngle(this.arm_t1, 0.5235988f, 0.0f, 0.0f);
        this.arm_l4 = new ModelRenderer((ModelBase)this, 15, 17);
        this.arm_l4.func_78793_a(0.0f, 0.0f, 0.0f);
        this.arm_l4.func_78790_a(-1.0f, -8.5f, 2.0f, 2, 4, 2, 0.0f);
        this.setRotateAngle(this.arm_l4, 0.5235988f, 0.0f, 0.0f);
        this.eye1 = new ModelRenderer((ModelBase)this, 32, 0);
        this.eye1.func_78793_a(0.0f, 14.0f, 0.0f);
        this.eye1.func_78790_a(-1.5f, -4.0f, -4.5f, 3, 3, 1, -0.4f);
        this.arm_r3 = new ModelRenderer((ModelBase)this, 0, 17);
        this.arm_r3.func_78793_a(4.0f, 15.5f, -1.0f);
        this.arm_r3.func_78790_a(-1.5f, -6.0f, -1.5f, 3, 8, 3, 0.0f);
        this.setRotateAngle(this.arm_r3, 0.5235988f, 0.0f, 2.0943952f);
        this.arm_t2 = new ModelRenderer((ModelBase)this, 15, 17);
        this.arm_t2.func_78793_a(0.0f, 0.0f, 0.0f);
        this.arm_t2.func_78790_a(-1.0f, -8.5f, 2.0f, 2, 4, 2, 0.0f);
        this.setRotateAngle(this.arm_t2, 0.5235988f, 0.0f, 0.0f);
        this.head = new ModelRenderer((ModelBase)this, 0, 0);
        this.head.func_78793_a(0.0f, 14.0f, 0.0f);
        this.head.func_78790_a(-4.0f, -4.0f, -4.0f, 8, 8, 8, 0.0f);
        this.eye2 = new ModelRenderer((ModelBase)this, 32, 0);
        this.eye2.func_78793_a(0.0f, 14.0f, 0.0f);
        this.eye2.func_78790_a(-1.5f, 1.0f, -4.5f, 3, 3, 1, -0.4f);
        this.arm_r3.func_78792_a(this.arm_r4);
        this.arm_l1.func_78792_a(this.arm_l2);
        this.arm_r1.func_78792_a(this.arm_r2);
        this.arm_l3.func_78792_a(this.arm_l4);
        this.arm_t1.func_78792_a(this.arm_t2);
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.eye4.func_78785_a(f5);
        this.arm_r1.func_78785_a(f5);
        this.arm_l1.func_78785_a(f5);
        this.arm_l3.func_78785_a(f5);
        this.eye3.func_78785_a(f5);
        this.arm_t1.func_78785_a(f5);
        this.eye1.func_78785_a(f5);
        this.arm_r3.func_78785_a(f5);
        this.head.func_78785_a(f5);
        this.eye2.func_78785_a(f5);
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.eye1.field_78808_h = ageInTicks * 0.2f;
        this.eye2.field_78808_h = ageInTicks * 0.2f;
        this.eye3.field_78808_h = ageInTicks * 0.2f;
        this.eye4.field_78808_h = ageInTicks * 0.2f;
        EntityClinger clinger = (EntityClinger)entityIn;
        this.arm_t1.field_78795_f = clinger.getAngry() ? 0.5235988f + Mth.func_76134_b((float)(ageInTicks * 0.35f)) * 0.5f : 1.62f;
        this.arm_r1.field_78795_f = this.arm_t1.field_78795_f;
        this.arm_r3.field_78795_f = this.arm_t1.field_78795_f;
        this.arm_l1.field_78795_f = this.arm_t1.field_78795_f;
        this.arm_l3.field_78795_f = this.arm_t1.field_78795_f;
    }
}

