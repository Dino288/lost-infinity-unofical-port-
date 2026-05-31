/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.model.ModelBox
 *  net.minecraft.client.model.ModelRenderer
 *  net.minecraft.entity.Entity
 */
package xol.lostinfinity.mob.model.item;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.world.entity.Entity;

public class ModelInfinityTrident
extends ModelBase {
    private final ModelRenderer Trident;

    public ModelInfinityTrident() {
        this.field_78090_t = 64;
        this.field_78089_u = 64;
        this.Trident = new ModelRenderer((ModelBase)this);
        this.Trident.func_78793_a(0.0f, 23.0f, 5.0f);
        this.Trident.field_78804_l.add(new ModelBox(this.Trident, 0, 0, -2.0f, -2.0f, -14.0f, 4, 4, 28, -1.0f, false));
        this.Trident.field_78804_l.add(new ModelBox(this.Trident, 0, 43, -2.0f, -2.0f, 9.0f, 4, 4, 4, -0.75f, false));
        this.Trident.field_78804_l.add(new ModelBox(this.Trident, 16, 43, -2.0f, -2.0f, 5.0f, 4, 4, 4, -0.75f, false));
        this.Trident.field_78804_l.add(new ModelBox(this.Trident, 32, 43, -2.0f, -2.0f, 1.0f, 4, 4, 4, -0.75f, false));
        this.Trident.field_78804_l.add(new ModelBox(this.Trident, 48, 43, -2.0f, -2.0f, -3.0f, 4, 4, 4, -0.75f, false));
        this.Trident.field_78804_l.add(new ModelBox(this.Trident, 0, 0, -7.0f, -2.0f, 14.0f, 4, 4, 8, -1.0f, false));
        this.Trident.field_78804_l.add(new ModelBox(this.Trident, 36, 0, -2.0f, -2.0f, 14.0f, 4, 4, 10, -1.0f, false));
        this.Trident.field_78804_l.add(new ModelBox(this.Trident, 0, 0, 3.0f, -2.0f, 14.0f, 4, 4, 8, -1.0f, false));
        this.Trident.field_78804_l.add(new ModelBox(this.Trident, 0, 13, -6.0f, -1.0f, 20.0f, 2, 2, 4, -0.5f, false));
        this.Trident.field_78804_l.add(new ModelBox(this.Trident, 0, 13, -1.0f, -1.0f, 22.0f, 2, 2, 4, -0.5f, false));
        this.Trident.field_78804_l.add(new ModelBox(this.Trident, 0, 13, 4.0f, -1.0f, 20.0f, 2, 2, 4, -0.5f, false));
        this.Trident.field_78804_l.add(new ModelBox(this.Trident, 0, 33, -8.0f, -2.5f, 12.0f, 16, 5, 4, -1.0f, false));
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.Trident.func_78785_a(f5);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }
}

