/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.model.ModelRenderer
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.entity.Entity
 */
package xol.lostinfinity.mob.model.deviant;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.world.entity.Entity;

public class ModelDeviantSlime
extends ModelBase {
    public ModelRenderer outer;
    public ModelRenderer middle;
    public ModelRenderer inner;
    public ModelRenderer eye1;
    public ModelRenderer eye2;
    public ModelRenderer eye3;
    public ModelRenderer mouth;

    public ModelDeviantSlime() {
        this.field_78090_t = 64;
        this.field_78089_u = 64;
        this.inner = new ModelRenderer((ModelBase)this, 0, 46);
        this.inner.func_78793_a(0.0f, 24.0f, 0.0f);
        this.inner.func_78790_a(-4.0f, -10.0f, -4.0f, 8, 8, 8, 0.0f);
        this.eye2 = new ModelRenderer((ModelBase)this, 42, 49);
        this.eye2.func_78793_a(0.0f, 24.0f, 0.0f);
        this.eye2.func_78790_a(1.5f, -8.5f, -4.5f, 2, 2, 2, 0.0f);
        this.outer = new ModelRenderer((ModelBase)this, 0, 0);
        this.outer.func_78793_a(0.0f, 24.0f, 0.0f);
        this.outer.func_78790_a(-6.0f, -12.0f, -6.0f, 12, 12, 12, 0.0f);
        this.mouth = new ModelRenderer((ModelBase)this, 42, 56);
        this.mouth.func_78793_a(0.0f, 24.0f, 0.0f);
        this.mouth.func_78790_a(0.5f, -5.0f, -4.5f, 1, 1, 1, 0.0f);
        this.middle = new ModelRenderer((ModelBase)this, 0, 25);
        this.middle.func_78793_a(0.0f, 24.0f, 0.0f);
        this.middle.func_78790_a(-5.0f, -11.0f, -5.0f, 10, 10, 10, 0.0f);
        this.eye1 = new ModelRenderer((ModelBase)this, 42, 49);
        this.eye1.func_78793_a(0.0f, 24.0f, 0.0f);
        this.eye1.func_78790_a(-3.5f, -8.5f, -4.5f, 2, 2, 2, 0.0f);
        this.eye3 = new ModelRenderer((ModelBase)this, 42, 49);
        this.eye3.func_78793_a(0.0f, 24.0f, 0.0f);
        this.eye3.func_78790_a(-1.0f, -9.5f, -4.5f, 2, 2, 2, 0.0f);
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.eye1.func_78785_a(f5);
        this.eye2.func_78785_a(f5);
        this.eye3.func_78785_a(f5);
        this.mouth.func_78785_a(f5);
        GlStateManager.func_179147_l();
        GlStateManager.func_179112_b((int)770, (int)771);
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)0.8f);
        this.inner.func_78785_a(f5);
        GlStateManager.func_179084_k();
        GlStateManager.func_179147_l();
        GlStateManager.func_179112_b((int)770, (int)771);
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)0.65f);
        this.middle.func_78785_a(f5);
        GlStateManager.func_179084_k();
        GlStateManager.func_179147_l();
        GlStateManager.func_179112_b((int)770, (int)771);
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)0.45f);
        this.outer.func_78785_a(f5);
        GlStateManager.func_179084_k();
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }
}

