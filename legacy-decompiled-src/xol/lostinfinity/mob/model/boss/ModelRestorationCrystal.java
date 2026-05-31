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

public class ModelRestorationCrystal
extends ModelBase {
    public ModelRenderer shape1;
    public ModelRenderer crys1;
    public ModelRenderer crys2;
    public ModelRenderer crys3;
    public ModelRenderer crys4;
    public ModelRenderer shape2;
    public ModelRenderer shape3;

    public ModelRestorationCrystal() {
        this.field_78090_t = 64;
        this.field_78089_u = 64;
        this.shape3 = new ModelRenderer((ModelBase)this, 0, 34);
        this.shape3.func_78793_a(0.0f, 8.0f, 0.0f);
        this.shape3.func_78790_a(-3.0f, 0.0f, -3.0f, 6, 4, 6, 0.0f);
        this.crys4 = new ModelRenderer((ModelBase)this, 0, 0);
        this.crys4.func_78793_a(0.0f, 16.0f, 0.0f);
        this.crys4.func_78790_a(4.0f, -13.0f, -8.0f, 4, 8, 4, 0.0f);
        this.crys2 = new ModelRenderer((ModelBase)this, 0, 0);
        this.crys2.func_78793_a(0.0f, 16.0f, 0.0f);
        this.crys2.func_78790_a(-8.0f, -13.0f, 4.0f, 4, 8, 4, 0.0f);
        this.shape2 = new ModelRenderer((ModelBase)this, 0, 20);
        this.shape2.func_78793_a(0.0f, 12.0f, 0.0f);
        this.shape2.func_78790_a(-4.0f, 0.0f, -4.0f, 8, 4, 8, 0.0f);
        this.crys1 = new ModelRenderer((ModelBase)this, 0, 0);
        this.crys1.func_78793_a(0.0f, 16.0f, 0.0f);
        this.crys1.func_78790_a(-8.0f, -13.0f, -8.0f, 4, 8, 4, 0.0f);
        this.crys3 = new ModelRenderer((ModelBase)this, 0, 0);
        this.crys3.func_78793_a(0.0f, 16.0f, 0.0f);
        this.crys3.func_78790_a(4.0f, -13.0f, 4.0f, 4, 8, 4, 0.0f);
        this.shape1 = new ModelRenderer((ModelBase)this, 0, 0);
        this.shape1.func_78793_a(0.0f, 16.0f, 0.0f);
        this.shape1.func_78790_a(-8.0f, 0.0f, -8.0f, 16, 2, 16, 0.0f);
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        GlStateManager.func_179147_l();
        GlStateManager.func_179112_b((int)770, (int)771);
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)(0.6f + 0.2f * Mth.func_76126_a((float)(f2 * 0.1f))));
        this.crys4.func_78785_a(f5);
        this.crys2.func_78785_a(f5);
        this.crys1.func_78785_a(f5);
        this.crys3.func_78785_a(f5);
        GlStateManager.func_179084_k();
        this.shape2.func_78785_a(f5);
        this.shape1.func_78785_a(f5);
        this.shape3.func_78785_a(f5);
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.crys1.field_78796_g = ageInTicks * 0.03f;
        this.crys2.field_78796_g = ageInTicks * 0.03f;
        this.crys3.field_78796_g = ageInTicks * 0.03f;
        this.crys4.field_78796_g = ageInTicks * 0.03f;
        this.shape1.field_78796_g = ageInTicks * -0.01f;
        this.shape2.field_78796_g = ageInTicks * 0.02f;
        this.shape3.field_78796_g = ageInTicks * -0.03f;
    }
}

