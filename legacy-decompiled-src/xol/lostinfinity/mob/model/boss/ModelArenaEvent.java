/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.model.ModelRenderer
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.entity.Entity
 */
package xol.lostinfinity.mob.model.boss;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.world.entity.Entity;

public class ModelArenaEvent
extends ModelBase {
    public ModelRenderer bar2p1;
    public ModelRenderer bar1p2;
    public ModelRenderer bar1p3;
    public ModelRenderer bar1p1;
    public ModelRenderer bar2p2;
    public ModelRenderer bar2p3;
    public ModelRenderer bar3p1;
    public ModelRenderer bar3p2;
    public ModelRenderer bar3p3;

    public ModelArenaEvent() {
        this.field_78090_t = 64;
        this.field_78089_u = 64;
        this.bar2p1 = new ModelRenderer((ModelBase)this, 0, 38);
        this.bar2p1.func_78793_a(0.0f, 0.0f, 0.0f);
        this.bar2p1.func_78790_a(-11.0f, -2.0f, -2.0f, 22, 4, 4, 0.0f);
        this.bar1p1 = new ModelRenderer((ModelBase)this, 0, 0);
        this.bar1p1.func_78793_a(0.0f, 0.0f, 0.0f);
        this.bar1p1.func_78790_a(-2.0f, -16.0f, -2.0f, 4, 32, 4, 0.0f);
        this.bar2p2 = new ModelRenderer((ModelBase)this, 0, 48);
        this.bar2p2.func_78793_a(0.0f, 0.0f, 0.0f);
        this.bar2p2.func_78790_a(-17.0f, -3.0f, -3.0f, 6, 6, 6, 0.0f);
        this.bar1p2 = new ModelRenderer((ModelBase)this, 18, 0);
        this.bar1p2.func_78793_a(0.0f, 0.0f, 0.0f);
        this.bar1p2.func_78790_a(-3.0f, -22.0f, -3.0f, 6, 6, 6, 0.0f);
        this.bar2p3 = new ModelRenderer((ModelBase)this, 0, 48);
        this.bar2p3.func_78793_a(0.0f, 0.0f, 0.0f);
        this.bar2p3.func_78790_a(11.0f, -3.0f, -3.0f, 6, 6, 6, 0.0f);
        this.bar3p1 = new ModelRenderer((ModelBase)this, 18, 14);
        this.bar3p1.func_78793_a(0.0f, 0.0f, 0.0f);
        this.bar3p1.func_78790_a(-2.0f, -2.0f, -6.0f, 4, 4, 12, 0.0f);
        this.bar1p3 = new ModelRenderer((ModelBase)this, 18, 0);
        this.bar1p3.func_78793_a(0.0f, 0.0f, 0.0f);
        this.bar1p3.func_78790_a(-3.0f, 16.0f, -3.0f, 6, 6, 6, 0.0f);
        this.bar3p2 = new ModelRenderer((ModelBase)this, 27, 48);
        this.bar3p2.func_78793_a(0.0f, 0.0f, 0.0f);
        this.bar3p2.func_78790_a(-3.0f, -3.0f, -12.0f, 6, 6, 6, 0.0f);
        this.bar3p3 = new ModelRenderer((ModelBase)this, 27, 48);
        this.bar3p3.func_78793_a(0.0f, 0.0f, 0.0f);
        this.bar3p3.func_78790_a(-3.0f, -3.0f, 6.0f, 6, 6, 6, 0.0f);
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        GlStateManager.func_179147_l();
        GlStateManager.func_179112_b((int)770, (int)771);
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)0.75f);
        this.bar2p1.func_78785_a(f5);
        GlStateManager.func_179084_k();
        GlStateManager.func_179147_l();
        GlStateManager.func_179112_b((int)770, (int)771);
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)0.75f);
        this.bar1p1.func_78785_a(f5);
        GlStateManager.func_179084_k();
        GlStateManager.func_179147_l();
        GlStateManager.func_179112_b((int)770, (int)771);
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)0.75f);
        this.bar2p2.func_78785_a(f5);
        GlStateManager.func_179084_k();
        GlStateManager.func_179147_l();
        GlStateManager.func_179112_b((int)770, (int)771);
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)0.75f);
        this.bar1p2.func_78785_a(f5);
        GlStateManager.func_179084_k();
        GlStateManager.func_179147_l();
        GlStateManager.func_179112_b((int)770, (int)771);
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)0.75f);
        this.bar2p3.func_78785_a(f5);
        GlStateManager.func_179084_k();
        GlStateManager.func_179147_l();
        GlStateManager.func_179112_b((int)770, (int)771);
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)0.75f);
        this.bar3p1.func_78785_a(f5);
        GlStateManager.func_179084_k();
        GlStateManager.func_179147_l();
        GlStateManager.func_179112_b((int)770, (int)771);
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)0.75f);
        this.bar1p3.func_78785_a(f5);
        GlStateManager.func_179084_k();
        GlStateManager.func_179147_l();
        GlStateManager.func_179112_b((int)770, (int)771);
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)0.75f);
        this.bar3p2.func_78785_a(f5);
        GlStateManager.func_179084_k();
        GlStateManager.func_179147_l();
        GlStateManager.func_179112_b((int)770, (int)771);
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)0.75f);
        this.bar3p3.func_78785_a(f5);
        GlStateManager.func_179084_k();
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.bar1p1.field_78795_f = ageInTicks * 0.1f;
        this.bar1p2.field_78795_f = ageInTicks * 0.1f;
        this.bar1p3.field_78795_f = ageInTicks * 0.1f;
        this.bar2p1.field_78808_h = ageInTicks * 0.2f;
        this.bar2p2.field_78808_h = ageInTicks * 0.2f;
        this.bar2p3.field_78808_h = ageInTicks * 0.2f;
        this.bar3p1.field_78796_g = ageInTicks * 0.3f;
        this.bar3p2.field_78796_g = ageInTicks * 0.3f;
        this.bar3p3.field_78796_g = ageInTicks * 0.3f;
    }
}

