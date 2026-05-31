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

public class ModelAvengerHammer
extends ModelBase {
    private final ModelRenderer Hammer;

    public ModelAvengerHammer() {
        this.field_78090_t = 128;
        this.field_78089_u = 128;
        this.Hammer = new ModelRenderer((ModelBase)this);
        this.Hammer.func_78793_a(0.0f, 17.5f, 0.0f);
        this.setRotationAngle(this.Hammer, 0.0f, 0.0f, 1.5708f);
        this.Hammer.field_78804_l.add(new ModelBox(this.Hammer, 0, 0, -2.0f, -1.5f, -2.0f, 4, 19, 4, 0.0f, false));
        this.Hammer.field_78804_l.add(new ModelBox(this.Hammer, 75, 63, -3.0f, -1.5f, -5.0f, 6, 2, 10, 0.0f, false));
        this.Hammer.field_78804_l.add(new ModelBox(this.Hammer, 58, 59, -3.0f, 9.5f, -2.0f, 1, 4, 4, 0.0f, false));
        this.Hammer.field_78804_l.add(new ModelBox(this.Hammer, 58, 59, 2.0f, 9.5f, -2.0f, 1, 4, 4, 0.0f, false));
        this.Hammer.field_78804_l.add(new ModelBox(this.Hammer, 53, 69, -2.5f, 1.5f, -2.5f, 5, 1, 5, 0.0f, false));
        this.Hammer.field_78804_l.add(new ModelBox(this.Hammer, 53, 69, -2.5f, 3.5f, -2.5f, 5, 1, 5, 0.0f, false));
        this.Hammer.field_78804_l.add(new ModelBox(this.Hammer, 45, 7, -10.5f, -17.0f, -15.5f, 9, 19, 31, -4.0f, false));
        this.Hammer.field_78804_l.add(new ModelBox(this.Hammer, 45, 7, 1.5f, -17.0f, -15.5f, 9, 19, 31, -4.0f, false));
        this.Hammer.field_78804_l.add(new ModelBox(this.Hammer, 0, 0, -6.0f, -13.5f, -12.0f, 12, 12, 24, 0.0f, false));
        this.Hammer.field_78804_l.add(new ModelBox(this.Hammer, 0, 37, 4.0f, -14.0f, -12.5f, 1, 13, 25, 0.0f, false));
        this.Hammer.field_78804_l.add(new ModelBox(this.Hammer, 0, 37, -5.0f, -14.0f, -12.5f, 1, 13, 25, 0.0f, false));
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.Hammer.func_78785_a(f5);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }
}

