/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.model.ModelRenderer
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.entity.Entity
 */
package xol.lostinfinity.mob.model.labyrinth;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.world.entity.Entity;

public class ModelGloop
extends ModelBase {
    public ModelRenderer eye;
    public ModelRenderer floater1;
    public ModelRenderer floater2;
    public ModelRenderer floater3;
    public ModelRenderer floater4;

    public ModelGloop() {
        this.field_78090_t = 32;
        this.field_78089_u = 32;
        this.floater2 = new ModelRenderer((ModelBase)this, 0, 0);
        this.floater2.func_78793_a(0.0f, 5.0f, 0.0f);
        this.floater2.func_78790_a(2.0f, 0.0f, -1.0f, 2, 2, 2, 0.0f);
        this.floater4 = new ModelRenderer((ModelBase)this, 0, 0);
        this.floater4.func_78793_a(0.0f, 5.0f, 0.0f);
        this.floater4.func_78790_a(-1.0f, 0.0f, 2.0f, 2, 2, 2, 0.0f);
        this.floater1 = new ModelRenderer((ModelBase)this, 0, 0);
        this.floater1.func_78793_a(0.0f, 5.0f, 0.0f);
        this.floater1.func_78790_a(-4.0f, 0.0f, -1.0f, 2, 2, 2, 0.0f);
        this.eye = new ModelRenderer((ModelBase)this, 0, 0);
        this.eye.func_78793_a(0.0f, 16.0f, 0.0f);
        this.eye.func_78790_a(-4.0f, -4.0f, -4.0f, 8, 8, 8, 0.0f);
        this.floater3 = new ModelRenderer((ModelBase)this, 0, 0);
        this.floater3.func_78793_a(0.0f, 5.0f, 0.0f);
        this.floater3.func_78790_a(-1.0f, 0.0f, -4.0f, 2, 2, 2, 0.0f);
        this.eye.func_78792_a(this.floater2);
        this.eye.func_78792_a(this.floater4);
        this.eye.func_78792_a(this.floater1);
        this.eye.func_78792_a(this.floater3);
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        GlStateManager.func_179147_l();
        GlStateManager.func_179112_b((int)770, (int)771);
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)0.8f);
        this.eye.func_78785_a(f5);
        GlStateManager.func_179084_k();
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.floater1.field_78796_g = ageInTicks * 0.6f;
        this.floater2.field_78796_g = ageInTicks * 0.6f;
        this.floater3.field_78796_g = ageInTicks * 0.6f;
        this.floater4.field_78796_g = ageInTicks * 0.6f;
    }
}

