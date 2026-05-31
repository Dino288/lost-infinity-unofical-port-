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

public class ModelShimmer
extends ModelBase {
    public ModelRenderer body;
    public ModelRenderer head;
    public ModelRenderer body2;
    public ModelRenderer body3;
    public ModelRenderer body4;
    public ModelRenderer legr1;
    public ModelRenderer legr2;
    public ModelRenderer legr3;
    public ModelRenderer legl1;
    public ModelRenderer legl3;
    public ModelRenderer legl2;
    public ModelRenderer body5;
    public ModelRenderer spine1;
    public ModelRenderer spine2;
    public ModelRenderer spine3;

    public ModelShimmer() {
        this.field_78090_t = 64;
        this.field_78089_u = 32;
        this.legl2 = new ModelRenderer((ModelBase)this, 32, 18);
        this.legl2.func_78793_a(5.0f, 18.0f, 2.0f);
        this.legl2.func_78790_a(-0.5f, 0.0f, -0.5f, 1, 4, 1, 0.0f);
        this.spine3 = new ModelRenderer((ModelBase)this, 35, 0);
        this.spine3.func_78793_a(0.0f, 17.0f, 5.5f);
        this.spine3.func_78790_a(-1.0f, -6.0f, -1.0f, 2, 6, 2, 0.0f);
        this.setRotateAngle(this.spine3, -0.61086524f, 0.0f, 0.0f);
        this.legr1 = new ModelRenderer((ModelBase)this, 32, 18);
        this.legr1.func_78793_a(-5.0f, 18.0f, 5.0f);
        this.legr1.func_78790_a(-0.5f, 0.0f, -0.5f, 1, 4, 1, 0.0f);
        this.body = new ModelRenderer((ModelBase)this, 0, 0);
        this.body.func_78793_a(0.0f, 15.0f, -3.0f);
        this.body.func_78790_a(-4.0f, 0.0f, 0.0f, 8, 4, 10, 0.0f);
        this.spine2 = new ModelRenderer((ModelBase)this, 35, 0);
        this.spine2.func_78793_a(0.0f, 16.0f, 2.0f);
        this.spine2.func_78790_a(-1.0f, -6.0f, -1.0f, 2, 6, 2, 0.0f);
        this.setRotateAngle(this.spine2, -0.61086524f, 0.0f, 0.0f);
        this.legl3 = new ModelRenderer((ModelBase)this, 32, 18);
        this.legl3.func_78793_a(5.0f, 18.0f, -1.0f);
        this.legl3.func_78790_a(-0.5f, 0.0f, -0.5f, 1, 4, 1, 0.0f);
        this.spine1 = new ModelRenderer((ModelBase)this, 35, 0);
        this.spine1.func_78793_a(0.0f, 15.0f, -1.5f);
        this.spine1.func_78790_a(-1.0f, -6.0f, -1.0f, 2, 6, 2, 0.0f);
        this.setRotateAngle(this.spine1, -0.61086524f, 0.0f, 0.0f);
        this.legl1 = new ModelRenderer((ModelBase)this, 32, 18);
        this.legl1.func_78793_a(5.0f, 18.0f, 5.0f);
        this.legl1.func_78790_a(-0.5f, 0.0f, -0.5f, 1, 4, 1, 0.0f);
        this.head = new ModelRenderer((ModelBase)this, 0, 24);
        this.head.func_78793_a(0.0f, 15.5f, -4.0f);
        this.head.func_78790_a(-2.0f, -2.0f, -1.0f, 4, 4, 2, 0.0f);
        this.body2 = new ModelRenderer((ModelBase)this, 0, 16);
        this.body2.func_78793_a(0.0f, 16.5f, -2.0f);
        this.body2.func_78790_a(-6.0f, 0.0f, 0.0f, 12, 2, 2, 0.0f);
        this.legr2 = new ModelRenderer((ModelBase)this, 32, 18);
        this.legr2.func_78793_a(-5.0f, 18.0f, 2.0f);
        this.legr2.func_78790_a(-0.5f, 0.0f, -0.5f, 1, 4, 1, 0.0f);
        this.body5 = new ModelRenderer((ModelBase)this, 35, 5);
        this.body5.func_78793_a(0.0f, 15.0f, -3.0f);
        this.body5.func_78790_a(-2.0f, -1.0f, 0.0f, 4, 1, 10, 0.0f);
        this.body3 = new ModelRenderer((ModelBase)this, 0, 16);
        this.body3.func_78793_a(0.0f, 16.5f, 1.0f);
        this.body3.func_78790_a(-6.0f, 0.0f, 0.0f, 12, 2, 2, 0.0f);
        this.body4 = new ModelRenderer((ModelBase)this, 0, 16);
        this.body4.func_78793_a(0.0f, 16.5f, 4.0f);
        this.body4.func_78790_a(-6.0f, 0.0f, 0.0f, 12, 2, 2, 0.0f);
        this.legr3 = new ModelRenderer((ModelBase)this, 32, 18);
        this.legr3.func_78793_a(-5.0f, 18.0f, -1.0f);
        this.legr3.func_78790_a(-0.5f, 0.0f, -0.5f, 1, 4, 1, 0.0f);
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        GlStateManager.func_179147_l();
        GlStateManager.func_179112_b((int)770, (int)771);
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)((float)Math.sin((double)f2 * 0.05)));
        this.legl2.func_78785_a(f5);
        this.spine3.func_78785_a(f5);
        this.legr1.func_78785_a(f5);
        this.body.func_78785_a(f5);
        this.spine2.func_78785_a(f5);
        this.legl3.func_78785_a(f5);
        this.spine1.func_78785_a(f5);
        this.legl1.func_78785_a(f5);
        this.head.func_78785_a(f5);
        this.body2.func_78785_a(f5);
        this.legr2.func_78785_a(f5);
        this.body5.func_78785_a(f5);
        this.body3.func_78785_a(f5);
        this.body4.func_78785_a(f5);
        this.legr3.func_78785_a(f5);
        GlStateManager.func_179084_k();
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.legl1.field_78808_h = Mth.func_76134_b((float)(ageInTicks * 0.3f)) * (float)Math.PI * 0.15f;
        this.legr1.field_78808_h = -this.legl1.field_78808_h;
        this.legl2.field_78808_h = Mth.func_76134_b((float)(ageInTicks * 0.3f)) * (float)Math.PI * 0.15f;
        this.legr2.field_78808_h = -this.legl2.field_78808_h;
        this.legl3.field_78808_h = Mth.func_76134_b((float)(ageInTicks * 0.3f)) * (float)Math.PI * 0.15f;
        this.legr3.field_78808_h = -this.legl3.field_78808_h;
        this.spine1.field_78795_f = Mth.func_76134_b((float)(ageInTicks * 0.1f)) * (float)Math.PI * 0.1f - 0.61086524f;
        this.spine2.field_78795_f = Mth.func_76134_b((float)(ageInTicks * 0.1f)) * (float)Math.PI * 0.1f - 0.61086524f;
        this.spine3.field_78795_f = Mth.func_76134_b((float)(ageInTicks * 0.1f)) * (float)Math.PI * 0.1f - 0.61086524f;
    }
}

