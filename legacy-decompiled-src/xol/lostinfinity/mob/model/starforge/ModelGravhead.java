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
package xol.lostinfinity.mob.model.starforge;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;

public class ModelGravhead
extends ModelBase {
    public ModelRenderer legr;
    public ModelRenderer head;
    public ModelRenderer body;
    public ModelRenderer legl;
    public ModelRenderer headinside;
    public ModelRenderer ring1;
    public ModelRenderer ring2;
    public ModelRenderer ring3;

    public ModelGravhead() {
        this.field_78090_t = 64;
        this.field_78089_u = 64;
        this.headinside = new ModelRenderer((ModelBase)this, 34, 0);
        this.headinside.func_78793_a(0.0f, 18.0f, 0.0f);
        this.headinside.func_78790_a(-3.5f, -25.5f, -3.5f, 7, 7, 7, 0.0f);
        this.ring1 = new ModelRenderer((ModelBase)this, 31, 32);
        this.ring1.func_78793_a(0.0f, 18.0f, 0.0f);
        this.ring1.func_78790_a(-4.0f, -16.0f, -4.0f, 8, 3, 8, 0.0f);
        this.legl = new ModelRenderer((ModelBase)this, 0, 16);
        this.legl.field_78809_i = true;
        this.legl.func_78793_a(1.9f, 18.0f, 0.1f);
        this.legl.func_78790_a(-2.0f, 0.0f, -2.0f, 4, 6, 4, 0.0f);
        this.ring2 = new ModelRenderer((ModelBase)this, 31, 32);
        this.ring2.func_78793_a(0.0f, 18.0f, 0.0f);
        this.ring2.func_78790_a(-4.0f, -10.0f, -4.0f, 8, 3, 8, 0.0f);
        this.body = new ModelRenderer((ModelBase)this, 16, 16);
        this.body.func_78793_a(0.0f, 18.0f, 0.0f);
        this.body.func_78790_a(-2.0f, -18.0f, -2.0f, 4, 18, 4, 0.0f);
        this.legr = new ModelRenderer((ModelBase)this, 0, 16);
        this.legr.func_78793_a(-1.9f, 18.0f, 0.1f);
        this.legr.func_78790_a(-2.0f, 0.0f, -2.0f, 4, 6, 4, 0.0f);
        this.head = new ModelRenderer((ModelBase)this, 0, 0);
        this.head.func_78793_a(0.0f, 18.0f, 0.0f);
        this.head.func_78790_a(-4.0f, -26.0f, -4.0f, 8, 8, 8, 0.0f);
        this.ring3 = new ModelRenderer((ModelBase)this, 31, 32);
        this.ring3.func_78793_a(0.0f, 18.0f, 0.0f);
        this.ring3.func_78790_a(-4.0f, -4.0f, -4.0f, 8, 3, 8, 0.0f);
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        GlStateManager.func_179147_l();
        GlStateManager.func_179112_b((int)770, (int)771);
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)0.6f);
        this.headinside.func_78785_a(f5);
        GlStateManager.func_179084_k();
        this.ring1.func_78785_a(f5);
        this.legl.func_78785_a(f5);
        this.ring2.func_78785_a(f5);
        this.body.func_78785_a(f5);
        this.legr.func_78785_a(f5);
        this.head.func_78785_a(f5);
        this.ring3.func_78785_a(f5);
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        float rotSpeed = 0.1f;
        this.legr.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f)) * 1.4f * limbSwingAmount * 0.5f;
        this.legl.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f + (float)Math.PI)) * 1.4f * limbSwingAmount * 0.5f;
        if (ageInTicks % 100.0f < 30.0f) {
            rotSpeed = 1.0f;
            this.body.field_78796_g = ageInTicks;
            this.head.field_78796_g = ageInTicks;
            this.headinside.field_78796_g = ageInTicks;
            this.body.field_78795_f = 0.35f;
            this.head.field_78795_f = 0.35f;
            this.headinside.field_78795_f = 0.35f;
            this.ring1.field_78795_f = 0.35f;
            this.ring2.field_78795_f = 0.35f;
            this.ring3.field_78795_f = 0.35f;
        } else {
            this.body.field_78796_g = 0.0f;
            this.head.field_78796_g = 0.0f;
            this.headinside.field_78796_g = 0.0f;
            this.body.field_78795_f = 0.0f;
            this.head.field_78795_f = 0.0f;
            this.headinside.field_78795_f = 0.0f;
            this.ring1.field_78795_f = 0.0f;
            this.ring2.field_78795_f = 0.0f;
            this.ring3.field_78795_f = 0.0f;
        }
        this.ring1.field_78796_g = ageInTicks * rotSpeed;
        this.ring2.field_78796_g = ageInTicks * rotSpeed;
        this.ring3.field_78796_g = ageInTicks * rotSpeed;
    }
}

