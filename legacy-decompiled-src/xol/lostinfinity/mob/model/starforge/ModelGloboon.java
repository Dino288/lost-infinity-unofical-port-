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
import xol.lostinfinity.mob.entity.starforge.EntityGloboon;

public class ModelGloboon
extends ModelBase {
    private final ModelRenderer GlowCube;
    private final ModelRenderer Body;
    private final ModelRenderer Leg1;
    private final ModelRenderer Leg2;
    private final ModelRenderer Leg3;
    private final ModelRenderer Leg4;
    private final ModelRenderer Leg5;
    private final ModelRenderer Leg6;
    private final ModelRenderer Leg7;
    private final ModelRenderer Leg8;
    private final ModelRenderer Leg9;
    private final ModelRenderer Leg10;

    public ModelGloboon() {
        this.field_78090_t = 64;
        this.field_78089_u = 64;
        this.GlowCube = new ModelRenderer((ModelBase)this);
        this.GlowCube.func_78793_a(0.0f, -2.0f, 0.0f);
        this.GlowCube.field_78804_l.add(new ModelBox(this.GlowCube, 0, 0, -8.0f, -7.0f, -8.0f, 16, 14, 16, 0.0f, false));
        this.Body = new ModelRenderer((ModelBase)this);
        this.Body.func_78793_a(0.0f, 7.0f, 0.0f);
        this.Body.field_78804_l.add(new ModelBox(this.Body, 0, 35, -8.0f, -2.0f, -8.0f, 16, 2, 16, 0.25f, false));
        this.Leg1 = new ModelRenderer((ModelBase)this);
        this.Leg1.func_78793_a(-6.0f, 7.5f, 0.0f);
        this.Leg1.field_78804_l.add(new ModelBox(this.Leg1, 0, 32, -1.0f, -0.5f, -1.0f, 2, 17, 2, 0.0f, false));
        this.Leg2 = new ModelRenderer((ModelBase)this);
        this.Leg2.func_78793_a(-1.0f, 7.5f, -5.0f);
        this.Leg2.field_78804_l.add(new ModelBox(this.Leg2, 0, 32, -1.0f, -0.5f, -1.0f, 2, 17, 2, 0.0f, false));
        this.Leg3 = new ModelRenderer((ModelBase)this);
        this.Leg3.func_78793_a(-5.0f, 7.5f, -6.0f);
        this.Leg3.field_78804_l.add(new ModelBox(this.Leg3, 50, 31, -1.0f, -0.5f, -1.0f, 2, 17, 2, 0.0f, false));
        this.Leg4 = new ModelRenderer((ModelBase)this);
        this.Leg4.func_78793_a(3.0f, 7.5f, -4.0f);
        this.Leg4.field_78804_l.add(new ModelBox(this.Leg4, 50, 31, -1.0f, -0.5f, -1.0f, 2, 17, 2, 0.0f, false));
        this.Leg5 = new ModelRenderer((ModelBase)this);
        this.Leg5.func_78793_a(6.0f, 7.5f, -6.0f);
        this.Leg5.field_78804_l.add(new ModelBox(this.Leg5, 0, 32, -1.0f, -0.5f, -1.0f, 2, 17, 2, 0.0f, false));
        this.Leg6 = new ModelRenderer((ModelBase)this);
        this.Leg6.func_78793_a(5.0f, 7.5f, 0.0f);
        this.Leg6.field_78804_l.add(new ModelBox(this.Leg6, 0, 32, -1.0f, -0.5f, -1.0f, 2, 17, 2, 0.0f, false));
        this.Leg7 = new ModelRenderer((ModelBase)this);
        this.Leg7.func_78793_a(0.0f, 7.5f, 2.0f);
        this.Leg7.field_78804_l.add(new ModelBox(this.Leg7, 50, 31, -1.0f, -0.5f, -1.0f, 2, 17, 2, 0.0f, false));
        this.Leg8 = new ModelRenderer((ModelBase)this);
        this.Leg8.func_78793_a(4.0f, 7.5f, 6.0f);
        this.Leg8.field_78804_l.add(new ModelBox(this.Leg8, 50, 31, -1.0f, -0.5f, -1.0f, 2, 17, 2, 0.0f, false));
        this.Leg9 = new ModelRenderer((ModelBase)this);
        this.Leg9.func_78793_a(-3.0f, 7.5f, 5.0f);
        this.Leg9.field_78804_l.add(new ModelBox(this.Leg9, 0, 32, -1.0f, -0.5f, -1.0f, 2, 17, 2, 0.0f, false));
        this.Leg10 = new ModelRenderer((ModelBase)this);
        this.Leg10.func_78793_a(-6.0f, 7.5f, 6.0f);
        this.Leg10.field_78804_l.add(new ModelBox(this.Leg10, 50, 31, -1.0f, -0.5f, -1.0f, 2, 17, 2, 0.0f, false));
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.Body.func_78785_a(f5);
        GlStateManager.func_179147_l();
        GlStateManager.func_179112_b((int)770, (int)771);
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)0.75f);
        this.GlowCube.func_78785_a(f5);
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)0.25f);
        this.Leg1.func_78785_a(f5);
        this.Leg2.func_78785_a(f5);
        this.Leg3.func_78785_a(f5);
        this.Leg4.func_78785_a(f5);
        this.Leg5.func_78785_a(f5);
        this.Leg6.func_78785_a(f5);
        this.Leg7.func_78785_a(f5);
        this.Leg8.func_78785_a(f5);
        this.Leg9.func_78785_a(f5);
        this.Leg10.func_78785_a(f5);
        GlStateManager.func_179084_k();
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        EntityGloboon globoon = (EntityGloboon)entityIn;
        this.Leg1.field_78795_f = 0.3f * Mth.func_76126_a((float)((ageInTicks + (float)globoon.getLegOffset(0)) * 0.1f));
        this.Leg1.field_78808_h = 0.3f * Mth.func_76126_a((float)((ageInTicks + (float)globoon.getLegOffset(0)) * 0.11f));
        this.Leg2.field_78795_f = 0.3f * Mth.func_76126_a((float)((ageInTicks + (float)globoon.getLegOffset(1)) * 0.1f));
        this.Leg2.field_78808_h = 0.3f * Mth.func_76126_a((float)((ageInTicks + (float)globoon.getLegOffset(1)) * 0.11f));
        this.Leg3.field_78795_f = 0.3f * Mth.func_76126_a((float)((ageInTicks + (float)globoon.getLegOffset(2)) * 0.1f));
        this.Leg3.field_78808_h = 0.3f * Mth.func_76126_a((float)((ageInTicks + (float)globoon.getLegOffset(2)) * 0.11f));
        this.Leg4.field_78795_f = 0.3f * Mth.func_76126_a((float)((ageInTicks + (float)globoon.getLegOffset(3)) * 0.1f));
        this.Leg4.field_78808_h = 0.3f * Mth.func_76126_a((float)((ageInTicks + (float)globoon.getLegOffset(3)) * 0.11f));
        this.Leg5.field_78795_f = 0.3f * Mth.func_76126_a((float)((ageInTicks + (float)globoon.getLegOffset(4)) * 0.1f));
        this.Leg5.field_78808_h = 0.3f * Mth.func_76126_a((float)((ageInTicks + (float)globoon.getLegOffset(4)) * 0.11f));
        this.Leg6.field_78795_f = 0.3f * Mth.func_76126_a((float)((ageInTicks + (float)globoon.getLegOffset(5)) * 0.1f));
        this.Leg6.field_78808_h = 0.3f * Mth.func_76126_a((float)((ageInTicks + (float)globoon.getLegOffset(5)) * 0.11f));
        this.Leg7.field_78795_f = 0.3f * Mth.func_76126_a((float)((ageInTicks + (float)globoon.getLegOffset(6)) * 0.1f));
        this.Leg7.field_78808_h = 0.3f * Mth.func_76126_a((float)((ageInTicks + (float)globoon.getLegOffset(6)) * 0.11f));
        this.Leg8.field_78795_f = 0.3f * Mth.func_76126_a((float)((ageInTicks + (float)globoon.getLegOffset(7)) * 0.1f));
        this.Leg8.field_78808_h = 0.3f * Mth.func_76126_a((float)((ageInTicks + (float)globoon.getLegOffset(7)) * 0.11f));
        this.Leg9.field_78795_f = 0.3f * Mth.func_76126_a((float)((ageInTicks + (float)globoon.getLegOffset(8)) * 0.1f));
        this.Leg9.field_78808_h = 0.3f * Mth.func_76126_a((float)((ageInTicks + (float)globoon.getLegOffset(8)) * 0.11f));
        this.Leg10.field_78795_f = 0.3f * Mth.func_76126_a((float)((ageInTicks + (float)globoon.getLegOffset(9)) * 0.1f));
        this.Leg10.field_78808_h = 0.3f * Mth.func_76126_a((float)((ageInTicks + (float)globoon.getLegOffset(9)) * 0.11f));
    }
}

