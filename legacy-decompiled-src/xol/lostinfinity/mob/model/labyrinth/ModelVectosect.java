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
package xol.lostinfinity.mob.model.labyrinth;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;

public class ModelVectosect
extends ModelBase {
    private final ModelRenderer Body;
    private final ModelRenderer leg1;
    private final ModelRenderer cube_r1;
    private final ModelRenderer leg2;
    private final ModelRenderer cube_r2;
    private final ModelRenderer leg3;
    private final ModelRenderer cube_r3;
    private final ModelRenderer leg4;
    private final ModelRenderer cube_r4;
    private final ModelRenderer bubble;

    public ModelVectosect() {
        this.field_78090_t = 64;
        this.field_78089_u = 64;
        this.Body = new ModelRenderer((ModelBase)this);
        this.Body.func_78793_a(0.0f, 7.0f, 0.0f);
        this.Body.field_78804_l.add(new ModelBox(this.Body, 0, 0, -8.0f, 5.0f, -8.0f, 16, 2, 16, 0.0f, false));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 0, 19, -8.0f, 3.0f, -8.0f, 16, 3, 16, -0.2f, false));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 0, 19, -8.0f, 1.0f, -8.0f, 16, 3, 16, -0.6f, false));
        this.leg1 = new ModelRenderer((ModelBase)this);
        this.leg1.func_78793_a(0.0f, 7.0f, -6.0f);
        this.Body.func_78792_a(this.leg1);
        this.leg1.field_78804_l.add(new ModelBox(this.leg1, 0, 0, -1.0f, -1.0f, -1.0f, 2, 6, 2, 0.0f, false));
        this.cube_r1 = new ModelRenderer((ModelBase)this);
        this.cube_r1.func_78793_a(0.0f, 0.0f, 0.0f);
        this.leg1.func_78792_a(this.cube_r1);
        this.setRotationAngle(this.cube_r1, 0.3491f, 0.0f, 0.0f);
        this.cube_r1.field_78804_l.add(new ModelBox(this.cube_r1, 7, 7, -1.0f, 4.0f, -2.5f, 2, 6, 2, -0.25f, false));
        this.leg2 = new ModelRenderer((ModelBase)this);
        this.leg2.func_78793_a(0.0f, 7.0f, 6.0f);
        this.Body.func_78792_a(this.leg2);
        this.leg2.field_78804_l.add(new ModelBox(this.leg2, 0, 0, -1.0f, -1.0f, -1.0f, 2, 6, 2, 0.0f, false));
        this.cube_r2 = new ModelRenderer((ModelBase)this);
        this.cube_r2.func_78793_a(0.0f, 0.0f, 0.0f);
        this.leg2.func_78792_a(this.cube_r2);
        this.setRotationAngle(this.cube_r2, -0.3491f, 0.0f, 0.0f);
        this.cube_r2.field_78804_l.add(new ModelBox(this.cube_r2, 7, 7, -1.0f, 4.0f, 0.5f, 2, 6, 2, -0.25f, false));
        this.leg3 = new ModelRenderer((ModelBase)this);
        this.leg3.func_78793_a(6.0f, 7.0f, 0.0f);
        this.Body.func_78792_a(this.leg3);
        this.leg3.field_78804_l.add(new ModelBox(this.leg3, 0, 0, -1.0f, -1.0f, -1.0f, 2, 6, 2, 0.0f, false));
        this.cube_r3 = new ModelRenderer((ModelBase)this);
        this.cube_r3.func_78793_a(0.0f, 0.0f, 0.0f);
        this.leg3.func_78792_a(this.cube_r3);
        this.setRotationAngle(this.cube_r3, 0.0f, 0.0f, 0.3491f);
        this.cube_r3.field_78804_l.add(new ModelBox(this.cube_r3, 7, 7, 0.5f, 4.0f, -1.0f, 2, 6, 2, -0.25f, false));
        this.leg4 = new ModelRenderer((ModelBase)this);
        this.leg4.func_78793_a(-6.0f, 7.0f, 0.0f);
        this.Body.func_78792_a(this.leg4);
        this.leg4.field_78804_l.add(new ModelBox(this.leg4, 0, 0, -1.0f, -1.0f, -1.0f, 2, 6, 2, 0.0f, false));
        this.cube_r4 = new ModelRenderer((ModelBase)this);
        this.cube_r4.func_78793_a(0.0f, 0.0f, 0.0f);
        this.leg4.func_78792_a(this.cube_r4);
        this.setRotationAngle(this.cube_r4, 0.0f, 0.0f, -0.3491f);
        this.cube_r4.field_78804_l.add(new ModelBox(this.cube_r4, 7, 7, -2.5f, 4.0f, -1.0f, 2, 6, 2, -0.25f, false));
        this.bubble = new ModelRenderer((ModelBase)this);
        this.bubble.func_78793_a(0.0f, -2.0f, 0.0f);
        this.bubble.field_78804_l.add(new ModelBox(this.bubble, 0, 39, -5.0f, 7.0f, -5.0f, 10, 4, 10, 0.0f, false));
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.Body.func_78785_a(f5);
        GlStateManager.func_179147_l();
        GlStateManager.func_179112_b((int)770, (int)771);
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)0.75f);
        this.bubble.func_78785_a(f5);
        GlStateManager.func_179084_k();
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.Body.field_78796_g = ageInTicks * 0.2f;
        this.leg1.field_78795_f = 0.5f * Mth.func_76126_a((float)(ageInTicks * 0.2f));
        this.leg2.field_78795_f = -this.leg1.field_78795_f;
        this.leg3.field_78808_h = 0.5f * Mth.func_76126_a((float)(ageInTicks * 0.2f));
        this.leg4.field_78808_h = -this.leg3.field_78808_h;
    }
}

