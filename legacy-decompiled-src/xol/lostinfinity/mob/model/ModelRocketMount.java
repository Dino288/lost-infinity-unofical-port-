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

public class ModelRocketMount
extends ModelBase {
    private final ModelRenderer Rocket;
    private final ModelRenderer fin_r1;
    private final ModelRenderer fin_r2;

    public ModelRocketMount() {
        this.field_78090_t = 64;
        this.field_78089_u = 64;
        this.Rocket = new ModelRenderer((ModelBase)this);
        this.Rocket.func_78793_a(0.0f, 19.0f, 1.0f);
        this.Rocket.field_78804_l.add(new ModelBox(this.Rocket, 0, 0, -5.0f, -5.0f, -10.0f, 10, 10, 20, 0.0f, false));
        this.Rocket.field_78804_l.add(new ModelBox(this.Rocket, 46, 5, 0.0f, -12.0f, 5.0f, 1, 7, 8, 0.0f, false));
        this.Rocket.field_78804_l.add(new ModelBox(this.Rocket, 42, 30, -5.0f, -5.0f, -9.0f, 10, 10, 1, 0.1f, false));
        this.Rocket.field_78804_l.add(new ModelBox(this.Rocket, 42, 41, -5.0f, -5.0f, -7.0f, 10, 10, 1, 0.1f, false));
        this.Rocket.field_78804_l.add(new ModelBox(this.Rocket, 42, 53, -5.0f, -5.0f, -5.0f, 10, 10, 1, 0.1f, false));
        this.Rocket.field_78804_l.add(new ModelBox(this.Rocket, 0, 0, -4.0f, -4.0f, -12.0f, 8, 8, 2, 0.0f, false));
        this.Rocket.field_78804_l.add(new ModelBox(this.Rocket, 0, 11, -3.0f, -3.0f, -14.0f, 6, 6, 2, 0.0f, false));
        this.Rocket.field_78804_l.add(new ModelBox(this.Rocket, 42, 0, -2.0f, -2.0f, -16.0f, 4, 4, 2, 0.0f, false));
        this.Rocket.field_78804_l.add(new ModelBox(this.Rocket, 55, 1, -1.0f, -1.0f, -18.0f, 2, 2, 2, 0.0f, false));
        this.Rocket.field_78804_l.add(new ModelBox(this.Rocket, 41, 7, -0.5f, -0.5f, -22.0f, 1, 1, 4, 0.0f, false));
        this.Rocket.field_78804_l.add(new ModelBox(this.Rocket, 0, 45, -5.0f, -5.0f, 14.0f, 10, 10, 4, 0.6f, false));
        this.Rocket.field_78804_l.add(new ModelBox(this.Rocket, 0, 31, -5.0f, -5.0f, 10.0f, 10, 10, 3, 0.5f, false));
        this.fin_r1 = new ModelRenderer((ModelBase)this);
        this.fin_r1.func_78793_a(0.5f, -8.0f, 8.5f);
        this.Rocket.func_78792_a(this.fin_r1);
        this.setRotationAngle(this.fin_r1, 0.0f, 0.0f, -2.3562f);
        this.fin_r1.field_78804_l.add(new ModelBox(this.fin_r1, 46, 5, -5.5f, -19.0f, -3.5f, 1, 7, 8, 0.0f, true));
        this.fin_r2 = new ModelRenderer((ModelBase)this);
        this.fin_r2.func_78793_a(-0.5f, -8.0f, 8.5f);
        this.Rocket.func_78792_a(this.fin_r2);
        this.setRotationAngle(this.fin_r2, 0.0f, 0.0f, 2.3562f);
        this.fin_r2.field_78804_l.add(new ModelBox(this.fin_r2, 46, 5, 4.5f, -19.0f, -3.5f, 1, 7, 8, 0.0f, false));
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.Rocket.func_78785_a(f5);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }
}

