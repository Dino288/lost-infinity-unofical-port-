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

public class ModelSkybooster
extends ModelBase {
    private final ModelRenderer Platform;
    private final ModelRenderer Light1;
    private final ModelRenderer Light2;

    public ModelSkybooster() {
        this.field_78090_t = 64;
        this.field_78089_u = 64;
        this.Platform = new ModelRenderer((ModelBase)this);
        this.Platform.func_78793_a(0.0f, 24.0f, 0.0f);
        this.Platform.field_78804_l.add(new ModelBox(this.Platform, 0, 18, -8.0f, -1.0f, -8.0f, 16, 1, 16, 0.0f, false));
        this.Platform.field_78804_l.add(new ModelBox(this.Platform, 0, 0, -8.0f, -3.0f, -8.0f, 16, 1, 16, 0.0f, false));
        this.Platform.field_78804_l.add(new ModelBox(this.Platform, 1, 36, -7.5f, -2.0f, -7.5f, 15, 1, 15, 0.0f, false));
        this.Light1 = new ModelRenderer((ModelBase)this);
        this.Light1.func_78793_a(0.0f, 0.0f, 0.0f);
        this.Platform.func_78792_a(this.Light1);
        this.Light1.field_78804_l.add(new ModelBox(this.Light1, 0, 5, 4.5f, -3.5f, -7.5f, 3, 1, 3, 0.0f, false));
        this.Light1.field_78804_l.add(new ModelBox(this.Light1, 0, 0, 4.5f, -5.0f, -7.5f, 3, 1, 3, 0.0f, false));
        this.Light1.field_78804_l.add(new ModelBox(this.Light1, 0, 10, 5.0f, -4.0f, -7.0f, 2, 1, 2, 0.0f, false));
        this.Light2 = new ModelRenderer((ModelBase)this);
        this.Light2.func_78793_a(-12.0f, 0.0f, 12.0f);
        this.Platform.func_78792_a(this.Light2);
        this.Light2.field_78804_l.add(new ModelBox(this.Light2, 0, 5, 4.5f, -3.5f, -7.5f, 3, 1, 3, 0.0f, false));
        this.Light2.field_78804_l.add(new ModelBox(this.Light2, 0, 0, 4.5f, -5.0f, -7.5f, 3, 1, 3, 0.0f, false));
        this.Light2.field_78804_l.add(new ModelBox(this.Light2, 0, 10, 5.0f, -4.0f, -7.0f, 2, 1, 2, 0.0f, false));
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.Platform.func_78785_a(f5);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.Platform.field_78796_g = ageInTicks * 0.5f;
    }
}

