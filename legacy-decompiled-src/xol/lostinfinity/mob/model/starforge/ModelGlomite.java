/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.model.ModelBox
 *  net.minecraft.client.model.ModelRenderer
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.math.Mth
 */
package xol.lostinfinity.mob.model.starforge;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;

public class ModelGlomite
extends ModelBase {
    private final ModelRenderer Leg4;
    private final ModelRenderer Body_r1;
    private final ModelRenderer Leg2;
    private final ModelRenderer Body_r2;
    private final ModelRenderer Leg3;
    private final ModelRenderer Body_r3;
    private final ModelRenderer Leg1;
    private final ModelRenderer Body_r4;
    private final ModelRenderer Body2;
    private final ModelRenderer Body_r5;
    private final ModelRenderer Bulbs;
    private final ModelRenderer Body_r6;

    public ModelGlomite() {
        this.field_78090_t = 64;
        this.field_78089_u = 64;
        this.Leg4 = new ModelRenderer((ModelBase)this);
        this.Leg4.func_78793_a(-5.5f, 18.5f, -1.0f);
        this.setRotationAngle(this.Leg4, 0.0f, -0.4363f, 0.0f);
        this.Body_r1 = new ModelRenderer((ModelBase)this);
        this.Body_r1.func_78793_a(-3.0f, -1.0f, 0.0f);
        this.Leg4.func_78792_a(this.Body_r1);
        this.setRotationAngle(this.Body_r1, 0.0f, 0.0f, 0.2618f);
        this.Body_r1.field_78804_l.add(new ModelBox(this.Body_r1, 12, 13, -8.5f, 5.5f, -1.0f, 1, 4, 2, 0.0f, true));
        this.Body_r1.field_78804_l.add(new ModelBox(this.Body_r1, 3, 13, -8.5f, 1.5f, -1.0f, 2, 4, 2, 0.0f, true));
        this.Body_r1.field_78804_l.add(new ModelBox(this.Body_r1, 40, 43, -5.0f, -1.5f, -1.5f, 9, 2, 3, 0.0f, true));
        this.Body_r1.field_78804_l.add(new ModelBox(this.Body_r1, 3, 6, -9.0f, -1.5f, -1.5f, 4, 3, 3, 0.0f, true));
        this.Leg2 = new ModelRenderer((ModelBase)this);
        this.Leg2.func_78793_a(5.5f, 18.5f, -1.0f);
        this.setRotationAngle(this.Leg2, 0.0f, 0.4363f, 0.0f);
        this.Body_r2 = new ModelRenderer((ModelBase)this);
        this.Body_r2.func_78793_a(3.0f, -1.0f, 0.0f);
        this.Leg2.func_78792_a(this.Body_r2);
        this.setRotationAngle(this.Body_r2, 0.0f, 0.0f, -0.2618f);
        this.Body_r2.field_78804_l.add(new ModelBox(this.Body_r2, 12, 13, 7.5f, 5.5f, -1.0f, 1, 4, 2, 0.0f, false));
        this.Body_r2.field_78804_l.add(new ModelBox(this.Body_r2, 3, 13, 6.5f, 1.5f, -1.0f, 2, 4, 2, 0.0f, false));
        this.Body_r2.field_78804_l.add(new ModelBox(this.Body_r2, 40, 43, -4.0f, -1.5f, -1.5f, 9, 2, 3, 0.0f, false));
        this.Body_r2.field_78804_l.add(new ModelBox(this.Body_r2, 3, 6, 5.0f, -1.5f, -1.5f, 4, 3, 3, 0.0f, false));
        this.Leg3 = new ModelRenderer((ModelBase)this);
        this.Leg3.func_78793_a(-5.5f, 18.5f, 10.0f);
        this.setRotationAngle(this.Leg3, 0.0f, 0.3491f, 0.0f);
        this.Body_r3 = new ModelRenderer((ModelBase)this);
        this.Body_r3.func_78793_a(-3.0f, -1.0f, 0.0f);
        this.Leg3.func_78792_a(this.Body_r3);
        this.setRotationAngle(this.Body_r3, 0.0f, 0.0f, 0.2618f);
        this.Body_r3.field_78804_l.add(new ModelBox(this.Body_r3, 12, 13, -8.5f, 5.5f, -1.0f, 1, 4, 2, 0.0f, true));
        this.Body_r3.field_78804_l.add(new ModelBox(this.Body_r3, 3, 13, -8.5f, 1.5f, -1.0f, 2, 4, 2, 0.0f, true));
        this.Body_r3.field_78804_l.add(new ModelBox(this.Body_r3, 40, 43, -5.0f, -1.5f, -1.5f, 9, 2, 3, 0.0f, true));
        this.Body_r3.field_78804_l.add(new ModelBox(this.Body_r3, 3, 6, -9.0f, -1.5f, -1.5f, 4, 3, 3, 0.0f, true));
        this.Leg1 = new ModelRenderer((ModelBase)this);
        this.Leg1.func_78793_a(5.5f, 18.5f, 10.0f);
        this.setRotationAngle(this.Leg1, 0.0f, -0.3491f, 0.0f);
        this.Body_r4 = new ModelRenderer((ModelBase)this);
        this.Body_r4.func_78793_a(3.0f, -1.0f, 0.0f);
        this.Leg1.func_78792_a(this.Body_r4);
        this.setRotationAngle(this.Body_r4, 0.0f, 0.0f, -0.2618f);
        this.Body_r4.field_78804_l.add(new ModelBox(this.Body_r4, 12, 13, 7.5f, 5.5f, -1.0f, 1, 4, 2, 0.0f, false));
        this.Body_r4.field_78804_l.add(new ModelBox(this.Body_r4, 3, 13, 6.5f, 1.5f, -1.0f, 2, 4, 2, 0.0f, false));
        this.Body_r4.field_78804_l.add(new ModelBox(this.Body_r4, 40, 43, -4.0f, -1.5f, -1.5f, 9, 2, 3, 0.0f, false));
        this.Body_r4.field_78804_l.add(new ModelBox(this.Body_r4, 3, 6, 5.0f, -1.5f, -1.5f, 4, 3, 3, 0.0f, false));
        this.Body2 = new ModelRenderer((ModelBase)this);
        this.Body2.func_78793_a(0.25f, 11.25f, 5.75f);
        this.Body2.field_78804_l.add(new ModelBox(this.Body2, 2, 2, -6.25f, 3.75f, -10.75f, 12, 5, 18, 0.0f, false));
        this.Body2.field_78804_l.add(new ModelBox(this.Body2, 2, 2, -6.25f, 3.75f, -10.75f, 12, 5, 18, 0.0f, false));
        this.Body2.field_78804_l.add(new ModelBox(this.Body2, 0, 48, -6.25f, 0.75f, 1.75f, 5, 3, 5, 0.0f, false));
        this.Body2.field_78804_l.add(new ModelBox(this.Body2, 0, 48, 0.75f, 0.75f, 1.75f, 5, 3, 5, 0.0f, false));
        this.Body2.field_78804_l.add(new ModelBox(this.Body2, 20, 44, 0.75f, 1.75f, -4.25f, 5, 2, 5, 0.0f, false));
        this.Body2.field_78804_l.add(new ModelBox(this.Body2, 20, 44, -6.25f, 1.75f, -4.25f, 5, 2, 5, 0.0f, false));
        this.Body_r5 = new ModelRenderer((ModelBase)this);
        this.Body_r5.func_78793_a(-0.25f, 2.75f, -15.75f);
        this.Body2.func_78792_a(this.Body_r5);
        this.setRotationAngle(this.Body_r5, -0.5236f, 0.0f, 0.0f);
        this.Body_r5.field_78804_l.add(new ModelBox(this.Body_r5, 45, 14, -5.0f, -6.0f, 7.0f, 1, 1, 4, 0.0f, false));
        this.Body_r5.field_78804_l.add(new ModelBox(this.Body_r5, 45, 14, 4.0f, -6.0f, 7.0f, 1, 1, 4, 0.0f, false));
        this.Body_r5.field_78804_l.add(new ModelBox(this.Body_r5, 0, 26, -5.0f, -7.0f, 3.0f, 10, 10, 4, 0.0f, false));
        this.Bulbs = new ModelRenderer((ModelBase)this);
        this.Bulbs.func_78793_a(0.0f, 14.0f, -10.0f);
        this.Bulbs.field_78804_l.add(new ModelBox(this.Bulbs, 1, 41, -5.5f, -3.0f, 12.0f, 4, 2, 4, 0.0f, false));
        this.Bulbs.field_78804_l.add(new ModelBox(this.Bulbs, 1, 41, -5.5f, -4.0f, 18.0f, 4, 2, 4, 0.0f, false));
        this.Bulbs.field_78804_l.add(new ModelBox(this.Bulbs, 1, 41, 1.5f, -4.0f, 18.0f, 4, 2, 4, 0.0f, false));
        this.Bulbs.field_78804_l.add(new ModelBox(this.Bulbs, 1, 41, 1.5f, -3.0f, 12.0f, 4, 2, 4, 0.0f, false));
        this.Body_r6 = new ModelRenderer((ModelBase)this);
        this.Body_r6.func_78793_a(0.0f, 0.0f, 0.0f);
        this.Bulbs.func_78792_a(this.Body_r6);
        this.setRotationAngle(this.Body_r6, -0.5236f, 0.0f, 0.0f);
        this.Body_r6.field_78804_l.add(new ModelBox(this.Body_r6, 30, 26, -5.0f, -7.0f, -2.0f, 10, 10, 6, -0.5f, false));
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.Leg4.func_78785_a(f5);
        this.Leg2.func_78785_a(f5);
        this.Leg3.func_78785_a(f5);
        this.Leg1.func_78785_a(f5);
        this.Body2.func_78785_a(f5);
        GlStateManager.func_179147_l();
        GlStateManager.func_179112_b((int)770, (int)771);
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)0.75f);
        this.Bulbs.func_78785_a(f5);
        GlStateManager.func_179084_k();
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.Leg1.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f + (float)Math.PI)) * 1.4f * limbSwingAmount * 0.5f;
        this.Leg1.field_78808_h = 0.5f * Mth.func_76134_b((float)(limbSwing * 0.6662f + (float)Math.PI)) * 1.4f * limbSwingAmount * 0.5f;
        this.Leg2.field_78795_f = Mth.func_76126_a((float)(limbSwing * 0.6662f + (float)Math.PI)) * 1.4f * limbSwingAmount * 0.5f;
        this.Leg2.field_78808_h = 0.5f * Mth.func_76126_a((float)(limbSwing * 0.6662f + (float)Math.PI)) * 1.4f * limbSwingAmount * 0.5f;
        this.Leg3.field_78795_f = this.Leg1.field_78795_f;
        this.Leg3.field_78808_h = -this.Leg1.field_78808_h;
        this.Leg4.field_78795_f = this.Leg2.field_78795_f;
        this.Leg4.field_78808_h = -this.Leg2.field_78808_h;
    }
}

