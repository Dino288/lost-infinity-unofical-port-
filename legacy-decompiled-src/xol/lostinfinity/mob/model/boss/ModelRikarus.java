/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.model.ModelRenderer
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.math.Mth
 */
package xol.lostinfinity.mob.model.boss;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import xol.lostinfinity.mob.entity.boss.EntityRikarus;

public class ModelRikarus
extends ModelBase {
    public ModelRenderer leg1;
    public ModelRenderer head;
    public ModelRenderer body;
    public ModelRenderer hood;
    public ModelRenderer leg2;
    public ModelRenderer leg3;
    public ModelRenderer leg4;
    public ModelRenderer arm1;
    public ModelRenderer arm2;
    public ModelRenderer arm3;
    public ModelRenderer arm4;
    public ModelRenderer arm5;
    public ModelRenderer spin1;
    public ModelRenderer spin2;

    public ModelRikarus() {
        this.field_78090_t = 128;
        this.field_78089_u = 64;
        this.spin2 = new ModelRenderer((ModelBase)this, 78, 4);
        this.spin2.func_78793_a(0.0f, 8.0f, 0.0f);
        this.spin2.func_78790_a(7.0f, -3.0f, -3.0f, 6, 6, 6, 0.0f);
        this.head = new ModelRenderer((ModelBase)this, 0, 0);
        this.head.func_78793_a(0.0f, 0.0f, 0.0f);
        this.head.func_78790_a(-4.0f, -8.0f, -4.0f, 8, 8, 8, 0.0f);
        this.leg3 = new ModelRenderer((ModelBase)this, 0, 22);
        this.leg3.func_78793_a(0.0f, 12.0f, 0.0f);
        this.leg3.func_78790_a(3.0f, 2.0f, -2.0f, 4, 8, 4, 0.0f);
        this.leg1 = new ModelRenderer((ModelBase)this, 0, 22);
        this.leg1.func_78793_a(0.0f, 12.0f, 0.0f);
        this.leg1.func_78790_a(-2.0f, 2.0f, -7.0f, 4, 8, 4, 0.0f);
        this.leg2 = new ModelRenderer((ModelBase)this, 0, 22);
        this.leg2.func_78793_a(0.0f, 12.0f, 0.0f);
        this.leg2.func_78790_a(-2.0f, 2.0f, 3.0f, 4, 8, 4, 0.0f);
        this.hood = new ModelRenderer((ModelBase)this, 32, 0);
        this.hood.func_78793_a(0.0f, 0.0f, 0.0f);
        this.hood.func_78790_a(-4.5f, -8.5f, -4.5f, 9, 9, 9, 0.0f);
        this.arm5 = new ModelRenderer((ModelBase)this, 68, 18);
        this.arm5.func_78793_a(0.0f, 0.0f, 0.0f);
        this.arm5.func_78790_a(9.0f, 0.0f, 10.0f, 1, 4, 8, 0.0f);
        this.arm1 = new ModelRenderer((ModelBase)this, 46, 22);
        this.arm1.func_78793_a(0.0f, 0.0f, 0.0f);
        this.arm1.func_78790_a(-12.0f, 0.0f, -10.0f, 4, 4, 12, 0.0f);
        this.arm2 = new ModelRenderer((ModelBase)this, 81, 22);
        this.arm2.func_78793_a(0.0f, 0.0f, 0.0f);
        this.arm2.func_78790_a(8.0f, 0.0f, -2.0f, 4, 4, 12, 0.0f);
        this.arm3 = new ModelRenderer((ModelBase)this, 16, 42);
        this.arm3.func_78793_a(0.0f, 0.0f, 0.0f);
        this.arm3.func_78790_a(-8.0f, 1.0f, -1.0f, 16, 2, 2, 0.0f);
        this.leg4 = new ModelRenderer((ModelBase)this, 0, 22);
        this.leg4.func_78793_a(0.0f, 12.0f, 0.0f);
        this.leg4.func_78790_a(-7.0f, 2.0f, -2.0f, 4, 8, 4, 0.0f);
        this.arm4 = new ModelRenderer((ModelBase)this, 68, 18);
        this.arm4.func_78793_a(0.0f, 0.0f, 0.0f);
        this.arm4.func_78790_a(-11.0f, 0.0f, -18.0f, 1, 4, 8, 0.0f);
        this.body = new ModelRenderer((ModelBase)this, 16, 22);
        this.body.func_78793_a(0.0f, 0.0f, 0.0f);
        this.body.func_78790_a(-4.0f, 0.0f, -2.0f, 8, 12, 4, 0.0f);
        this.spin1 = new ModelRenderer((ModelBase)this, 78, 4);
        this.spin1.func_78793_a(0.0f, 8.0f, 0.0f);
        this.spin1.func_78790_a(-14.0f, -3.0f, -3.0f, 6, 6, 6, 0.0f);
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.head.func_78785_a(f5);
        this.leg3.func_78785_a(f5);
        this.leg1.func_78785_a(f5);
        this.leg2.func_78785_a(f5);
        this.hood.func_78785_a(f5);
        this.arm5.func_78785_a(f5);
        this.arm1.func_78785_a(f5);
        this.arm2.func_78785_a(f5);
        this.arm3.func_78785_a(f5);
        this.leg4.func_78785_a(f5);
        this.arm4.func_78785_a(f5);
        this.body.func_78785_a(f5);
        GlStateManager.func_179147_l();
        GlStateManager.func_179112_b((int)770, (int)771);
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)(0.5f + 0.3f * Mth.func_76126_a((float)(f2 * 0.3f))));
        this.spin2.func_78785_a(f5);
        this.spin1.func_78785_a(f5);
        GlStateManager.func_179084_k();
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        float rotSpeed = 0.2f;
        if (((EntityRikarus)entityIn).isSpinning()) {
            rotSpeed = 1.0f;
        }
        this.arm1.field_78796_g = ageInTicks * rotSpeed;
        this.arm2.field_78796_g = ageInTicks * rotSpeed;
        this.arm3.field_78796_g = ageInTicks * rotSpeed;
        this.arm4.field_78796_g = ageInTicks * rotSpeed;
        this.arm5.field_78796_g = ageInTicks * rotSpeed;
        this.leg1.field_78796_g = ageInTicks * 0.03f;
        this.leg2.field_78796_g = ageInTicks * 0.03f;
        this.leg3.field_78796_g = ageInTicks * 0.03f;
        this.leg4.field_78796_g = ageInTicks * 0.03f;
        this.leg1.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f)) * 1.4f * limbSwingAmount * 0.5f;
        this.leg2.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f)) * 1.4f * limbSwingAmount * 0.5f;
        this.leg3.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f)) * 1.4f * limbSwingAmount * 0.5f;
        this.leg4.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f)) * 1.4f * limbSwingAmount * 0.5f;
        this.head.field_78796_g = netHeadYaw * ((float)Math.PI / 180);
        this.head.field_78795_f = headPitch * ((float)Math.PI / 180);
        this.hood.field_78796_g = netHeadYaw * ((float)Math.PI / 180);
        this.hood.field_78795_f = headPitch * ((float)Math.PI / 180);
        byte form = ((EntityRikarus)entityIn).getForm();
        this.spin1.field_78796_g = ageInTicks * -(0.1f + (float)(form / 10));
        this.spin2.field_78796_g = ageInTicks * -(0.1f + (float)(form / 10));
    }
}

