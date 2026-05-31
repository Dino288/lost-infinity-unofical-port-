/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.model.ModelRenderer
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.entity.Entity
 */
package xol.lostinfinity.mob.model.cthulhu;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.world.entity.Entity;

public class ModelCthulhuHealingOrb
extends ModelBase {
    public ModelRenderer inside;
    public ModelRenderer spin;
    public ModelRenderer outside;

    public ModelCthulhuHealingOrb() {
        this.field_78090_t = 128;
        this.field_78089_u = 64;
        this.spin = new ModelRenderer((ModelBase)this, 66, 0);
        this.spin.func_78793_a(0.0f, 14.0f, 0.0f);
        this.spin.func_78790_a(-5.0f, -5.0f, -5.0f, 10, 10, 10, 0.0f);
        this.inside = new ModelRenderer((ModelBase)this, 0, 32);
        this.inside.func_78793_a(0.0f, 14.0f, 0.0f);
        this.inside.func_78790_a(-3.0f, -3.0f, -3.0f, 6, 6, 6, 0.0f);
        this.outside = new ModelRenderer((ModelBase)this, 0, 0);
        this.outside.func_78793_a(0.0f, 14.0f, 0.0f);
        this.outside.func_78790_a(-8.0f, -8.0f, -8.0f, 16, 16, 16, 0.0f);
    }

    public void func_78088_a(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        this.inside.func_78785_a(scale);
        this.spin.func_78785_a(scale);
        this.outside.func_78785_a(scale);
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.spin.field_78796_g = ageInTicks * 0.05f;
        this.inside.field_78796_g = ageInTicks * -0.02f;
        this.outside.field_78796_g = ageInTicks * -0.02f;
    }

    private void render(float scale) {
        this.inside.func_78785_a(scale);
        GlStateManager.func_179147_l();
        GlStateManager.func_179112_b((int)770, (int)771);
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)0.2f);
        this.spin.func_78785_a(scale);
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)0.6f);
        this.outside.func_78785_a(scale);
        GlStateManager.func_179084_k();
    }
}

