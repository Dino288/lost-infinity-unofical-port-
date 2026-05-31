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
import xol.lostinfinity.mob.entity.misc.EntityBaseRift;

public class ModelRift
extends ModelBase {
    private final ModelRenderer Planes;
    private final ModelRenderer cube_r1;

    public ModelRift() {
        this.field_78090_t = 64;
        this.field_78089_u = 64;
        this.Planes = new ModelRenderer((ModelBase)this);
        this.Planes.func_78793_a(0.0f, 22.5f, 0.5f);
        this.Planes.field_78804_l.add(new ModelBox(this.Planes, 0, 0, -11.0f, -31.5f, -0.5f, 22, 63, 1, 0.0f, false));
        this.cube_r1 = new ModelRenderer((ModelBase)this);
        this.cube_r1.func_78793_a(0.0f, 0.0f, 0.0f);
        this.Planes.func_78792_a(this.cube_r1);
        this.setRotationAngle(this.cube_r1, 0.0f, -1.0472f, 0.0f);
        this.cube_r1.field_78804_l.add(new ModelBox(this.cube_r1, 0, 0, -11.0f, -31.5f, -0.5f, 22, 63, 1, 0.0f, false));
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        GlStateManager.func_179147_l();
        GlStateManager.func_179112_b((int)770, (int)771);
        EntityBaseRift rift = (EntityBaseRift)entity;
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)rift.getAlpha());
        this.Planes.func_78785_a(f5);
        GlStateManager.func_179084_k();
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.Planes.field_78795_f = 1.5707964f + 0.25f * Mth.func_76126_a((float)(ageInTicks * 0.01f));
        this.Planes.field_78796_g = this.Planes.field_78808_h = 0.1f * Mth.func_76126_a((float)(ageInTicks * 0.025f));
        this.cube_r1.field_78796_g = -1.0472f + 0.3f * Mth.func_76126_a((float)(ageInTicks * 0.05f));
    }
}

