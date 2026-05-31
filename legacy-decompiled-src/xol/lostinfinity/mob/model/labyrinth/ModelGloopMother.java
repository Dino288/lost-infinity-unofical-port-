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

public class ModelGloopMother
extends ModelBase {
    public ModelRenderer bottom;
    public ModelRenderer middle;
    public ModelRenderer top1;
    public ModelRenderer top2;
    public ModelRenderer top3;
    public ModelRenderer top4;

    public ModelGloopMother() {
        this.field_78090_t = 64;
        this.field_78089_u = 64;
        this.middle = new ModelRenderer((ModelBase)this, 0, 21);
        this.middle.func_78793_a(0.0f, 20.0f, 0.0f);
        this.middle.func_78790_a(-7.0f, -6.0f, -7.0f, 14, 6, 14, 0.0f);
        this.top1 = new ModelRenderer((ModelBase)this, 0, 42);
        this.top1.func_78793_a(0.0f, 20.0f, 0.0f);
        this.top1.func_78790_a(-7.0f, -12.0f, -7.0f, 6, 6, 6, 0.0f);
        this.top2 = new ModelRenderer((ModelBase)this, 0, 42);
        this.top2.func_78793_a(0.0f, 20.0f, 0.0f);
        this.top2.func_78790_a(1.0f, -12.0f, -7.0f, 6, 6, 6, 0.0f);
        this.bottom = new ModelRenderer((ModelBase)this, 0, 0);
        this.bottom.func_78793_a(0.0f, 20.0f, 0.0f);
        this.bottom.func_78790_a(-8.0f, 0.0f, -8.0f, 16, 4, 16, 0.0f);
        this.top4 = new ModelRenderer((ModelBase)this, 0, 42);
        this.top4.func_78793_a(0.0f, 20.0f, 0.0f);
        this.top4.func_78790_a(-7.0f, -12.0f, 1.0f, 6, 6, 6, 0.0f);
        this.top3 = new ModelRenderer((ModelBase)this, 0, 42);
        this.top3.func_78793_a(0.0f, 20.0f, 0.0f);
        this.top3.func_78790_a(1.0f, -12.0f, 1.0f, 6, 6, 6, 0.0f);
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        GlStateManager.func_179147_l();
        GlStateManager.func_179112_b((int)770, (int)771);
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)0.8f);
        this.middle.func_78785_a(f5);
        this.top1.func_78785_a(f5);
        this.top2.func_78785_a(f5);
        this.bottom.func_78785_a(f5);
        this.top4.func_78785_a(f5);
        this.top3.func_78785_a(f5);
        GlStateManager.func_179084_k();
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
    }
}

