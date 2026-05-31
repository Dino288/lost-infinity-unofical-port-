/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.model.ModelBox
 *  net.minecraft.client.model.ModelRenderer
 *  net.minecraft.entity.Entity
 */
package xol.lostinfinity.mob.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.world.entity.Entity;

public class ModelSpecialBomb
extends ModelBase {
    private final ModelRenderer Core;

    public ModelSpecialBomb() {
        this.field_78090_t = 32;
        this.field_78089_u = 32;
        this.Core = new ModelRenderer((ModelBase)this);
        this.Core.func_78793_a(0.0f, 24.0f, 0.0f);
        this.Core.field_78804_l.add(new ModelBox(this.Core, 8, 7, -3.0f, -3.0f, -3.0f, 6, 6, 6, 0.0f, false));
        this.Core.field_78804_l.add(new ModelBox(this.Core, 0, 15, 3.0f, -2.0f, -2.0f, 1, 4, 4, 0.0f, false));
        this.Core.field_78804_l.add(new ModelBox(this.Core, 0, 0, -2.0f, -4.0f, -2.0f, 4, 1, 4, 0.0f, false));
        this.Core.field_78804_l.add(new ModelBox(this.Core, 0, 15, -4.0f, -2.0f, -2.0f, 1, 4, 4, 0.0f, false));
        this.Core.field_78804_l.add(new ModelBox(this.Core, 0, 6, -2.0f, -2.0f, -4.0f, 4, 4, 1, 0.0f, false));
        this.Core.field_78804_l.add(new ModelBox(this.Core, 0, 0, -2.0f, 3.0f, -2.0f, 4, 1, 4, 0.0f, false));
        this.Core.field_78804_l.add(new ModelBox(this.Core, 0, 6, -2.0f, -2.0f, 3.0f, 4, 4, 1, 0.0f, false));
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.Core.func_78785_a(f5);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
    }
}

