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
package xol.lostinfinity.mob.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;

public class ModelSandAttack
extends ModelBase {
    private final ModelRenderer CubeOutside;
    private final ModelRenderer CubeInside;

    public ModelSandAttack() {
        this.field_78090_t = 64;
        this.field_78089_u = 64;
        this.CubeOutside = new ModelRenderer((ModelBase)this);
        this.CubeOutside.func_78793_a(0.0f, 16.0f, 0.0f);
        this.CubeOutside.field_78804_l.add(new ModelBox(this.CubeOutside, 0, 32, -8.0f, -8.0f, -8.0f, 16, 16, 16, 0.1f, false));
        this.CubeInside = new ModelRenderer((ModelBase)this);
        this.CubeInside.func_78793_a(0.0f, 16.0f, 0.0f);
        this.CubeInside.field_78804_l.add(new ModelBox(this.CubeInside, 0, 0, -8.0f, -8.0f, -8.0f, 16, 16, 16, 0.0f, false));
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.CubeInside.func_78785_a(f5);
        GlStateManager.func_179147_l();
        GlStateManager.func_179112_b((int)770, (int)771);
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)(0.5f + 0.25f * Mth.func_76126_a((float)(f2 * 0.5f))));
        this.CubeOutside.func_78785_a(f5);
        GlStateManager.func_179084_k();
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.CubeInside.field_78796_g = ageInTicks * 0.02f;
        this.CubeOutside.field_78796_g = ageInTicks * 0.02f;
    }
}

