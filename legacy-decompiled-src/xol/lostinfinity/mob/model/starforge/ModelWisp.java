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

public class ModelWisp
extends ModelBase {
    private final ModelRenderer Cube;
    private final ModelRenderer Body;

    public ModelWisp() {
        this.field_78090_t = 64;
        this.field_78089_u = 64;
        this.Cube = new ModelRenderer((ModelBase)this);
        this.Cube.func_78793_a(0.0f, 16.0f, 0.0f);
        this.Cube.field_78804_l.add(new ModelBox(this.Cube, 0, 32, -8.0f, -8.0f, -8.0f, 16, 16, 16, 0.0f, false));
        this.Body = new ModelRenderer((ModelBase)this);
        this.Body.func_78793_a(0.0f, 15.0f, 0.0f);
        this.Body.field_78804_l.add(new ModelBox(this.Body, 0, 0, -3.0f, -3.0f, -3.0f, 6, 6, 6, 0.0f, false));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 25, 0, -2.0f, -5.0f, -2.0f, 4, 10, 4, 0.0f, false));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 0, 13, -5.0f, 0.5f, -1.0f, 10, 2, 2, 0.0f, false));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 0, 18, -7.0f, -2.5f, -1.0f, 14, 2, 2, 0.0f, false));
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.Body.func_78785_a(f5);
        GlStateManager.func_179147_l();
        GlStateManager.func_179112_b((int)770, (int)771);
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)0.5f);
        this.Cube.func_78785_a(f5);
        GlStateManager.func_179084_k();
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.Cube.field_78796_g = ageInTicks * 0.1f;
        this.Body.field_78795_f = ageInTicks * 0.05f;
        this.Body.field_78808_h = 3.0f * Mth.func_76126_a((float)(ageInTicks * 0.02f));
    }
}

