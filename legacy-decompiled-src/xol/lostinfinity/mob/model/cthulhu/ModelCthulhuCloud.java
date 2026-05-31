/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.model.ModelRenderer
 *  net.minecraft.entity.Entity
 */
package xol.lostinfinity.mob.model.cthulhu;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.world.entity.Entity;

public class ModelCthulhuCloud
extends ModelBase {
    private final ModelRenderer main;

    public ModelCthulhuCloud() {
        this.field_78090_t = 64;
        this.field_78089_u = 64;
        this.main = new ModelRenderer((ModelBase)this);
        this.main.func_78793_a(0.0f, 24.0f, 0.0f);
    }

    public void func_78088_a(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        this.main.func_78785_a(scale);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }
}

