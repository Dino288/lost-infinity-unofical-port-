/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.model.ModelRenderer
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.math.Mth
 */
package xol.lostinfinity.mob.model.minion;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import xol.lostinfinity.mob.entity.minion.EntityAuraOfAllegiance;
import xol.lostinfinity.mob.render.minion.RenderAuraOfAllegiance;

public class ModelAuraOfAllegiance
extends ModelBase {
    public ModelRenderer inside;
    public ModelRenderer spin;
    public ModelRenderer outside;

    public ModelAuraOfAllegiance() {
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
        EntityAuraOfAllegiance aura = (EntityAuraOfAllegiance)entity;
        int lives = aura.getLives();
        if (lives <= 0) {
            return;
        }
        float offset = ageInTicks * 5.0f * ((float)Math.PI / 180);
        float angle = 360.0f / (float)lives * ((float)Math.PI / 180);
        for (int i = 0; i < lives; ++i) {
            Minecraft.func_71410_x().func_110434_K().func_110577_a(RenderAuraOfAllegiance.STONES[i]);
            float x = Mth.func_76126_a((float)(angle * (float)i + offset)) * 3.0f;
            float z = Mth.func_76134_b((float)(angle * (float)i + offset)) * 3.0f;
            this.inside.field_82906_o = x;
            this.inside.field_82907_q = z;
            this.spin.field_82906_o = x;
            this.spin.field_82907_q = z;
            this.outside.field_82906_o = x;
            this.outside.field_82907_q = z;
            this.render(scale);
        }
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

