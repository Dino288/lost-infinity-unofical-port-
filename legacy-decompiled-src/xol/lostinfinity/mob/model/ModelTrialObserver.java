/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.model.ModelRenderer
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.math.Mth
 */
package xol.lostinfinity.mob.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;

public class ModelTrialObserver
extends ModelBase {
    public ModelRenderer eye;
    public ModelRenderer p2;
    public ModelRenderer p3;

    public ModelTrialObserver() {
        this.field_78090_t = 64;
        this.field_78089_u = 64;
        this.p2 = new ModelRenderer((ModelBase)this, 0, 42);
        this.p2.func_78793_a(0.0f, 16.0f, 0.0f);
        this.p2.func_78790_a(-6.0f, -13.0f, -6.0f, 12, 2, 12, 0.0f);
        this.eye = new ModelRenderer((ModelBase)this, 0, 0);
        this.eye.func_78793_a(0.0f, 16.0f, 0.0f);
        this.eye.func_78790_a(-6.0f, -6.0f, -6.0f, 12, 6, 12, 0.0f);
        this.p3 = new ModelRenderer((ModelBase)this, 0, 21);
        this.p3.func_78793_a(0.0f, 16.0f, 0.0f);
        this.p3.func_78790_a(-7.0f, -11.0f, -7.0f, 14, 5, 14, 0.0f);
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.p2.func_78785_a(f5);
        this.eye.func_78785_a(f5);
        this.p3.func_78785_a(f5);
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.p2.field_78808_h = Mth.func_76134_b((float)(ageInTicks * 0.05f)) * (float)Math.PI * 0.1f;
        this.p3.field_78808_h = Mth.func_76134_b((float)(ageInTicks * 0.05f)) * (float)Math.PI * 0.1f;
        this.eye.field_78808_h = Mth.func_76134_b((float)(ageInTicks * 0.05f)) * (float)Math.PI * 0.1f;
        this.p2.field_78796_g = Mth.func_76126_a((float)(ageInTicks * 0.03f)) * (float)Math.PI * 0.1f;
        this.p3.field_78796_g = Mth.func_76126_a((float)(ageInTicks * 0.03f)) * (float)Math.PI * 0.1f;
        this.eye.field_78796_g = Mth.func_76126_a((float)(ageInTicks * 0.03f)) * (float)Math.PI * 0.1f;
    }
}

