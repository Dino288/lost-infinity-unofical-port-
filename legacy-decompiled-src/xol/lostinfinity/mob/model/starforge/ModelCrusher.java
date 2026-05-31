/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.model.ModelBox
 *  net.minecraft.client.model.ModelRenderer
 *  net.minecraft.entity.Entity
 */
package xol.lostinfinity.mob.model.starforge;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.world.entity.Entity;

public class ModelCrusher
extends ModelBase {
    private final ModelRenderer body;
    private final ModelRenderer spiral;

    public ModelCrusher() {
        this.field_78090_t = 128;
        this.field_78089_u = 64;
        this.body = new ModelRenderer((ModelBase)this);
        this.body.func_78793_a(0.0f, -2.0f, 0.0f);
        this.body.field_78804_l.add(new ModelBox(this.body, 0, 0, -8.0f, 23.0f, -8.0f, 16, 2, 16, 0.0f, false));
        this.body.field_78804_l.add(new ModelBox(this.body, 44, 19, 2.0f, 25.0f, -7.0f, 5, 1, 5, 0.0f, false));
        this.body.field_78804_l.add(new ModelBox(this.body, 44, 19, 2.0f, 25.0f, 2.0f, 5, 1, 5, 0.0f, false));
        this.body.field_78804_l.add(new ModelBox(this.body, 44, 19, -7.0f, 25.0f, 2.0f, 5, 1, 5, 0.0f, false));
        this.body.field_78804_l.add(new ModelBox(this.body, 0, 18, -7.0f, 21.0f, -7.0f, 14, 2, 14, 0.0f, false));
        this.body.field_78804_l.add(new ModelBox(this.body, 0, 34, -3.0f, 7.0f, -3.0f, 6, 14, 6, 0.0f, false));
        this.body.field_78804_l.add(new ModelBox(this.body, 0, 6, -2.0f, 3.0f, -2.0f, 4, 4, 4, 0.0f, false));
        this.body.field_78804_l.add(new ModelBox(this.body, 44, 19, -7.0f, 25.0f, -7.0f, 5, 1, 5, 0.0f, false));
        this.body.field_78804_l.add(new ModelBox(this.body, 64, 0, -8.0f, -15.0f, -8.0f, 16, 2, 16, 0.0f, false));
        this.body.field_78804_l.add(new ModelBox(this.body, 108, 19, 2.0f, -16.0f, -7.0f, 5, 1, 5, 0.0f, false));
        this.body.field_78804_l.add(new ModelBox(this.body, 108, 19, 2.0f, -16.0f, 2.0f, 5, 1, 5, 0.0f, false));
        this.body.field_78804_l.add(new ModelBox(this.body, 64, 18, -7.0f, -13.0f, -7.0f, 14, 2, 14, 0.0f, false));
        this.body.field_78804_l.add(new ModelBox(this.body, 108, 19, -7.0f, -16.0f, 2.0f, 5, 1, 5, 0.0f, false));
        this.body.field_78804_l.add(new ModelBox(this.body, 64, 34, -3.0f, -11.0f, -3.0f, 6, 14, 6, 0.0f, false));
        this.body.field_78804_l.add(new ModelBox(this.body, 108, 19, -7.0f, -16.0f, -7.0f, 5, 1, 5, 0.0f, false));
        this.spiral = new ModelRenderer((ModelBase)this);
        this.spiral.func_78793_a(0.0f, 12.0f, 0.0f);
        this.spiral.field_78804_l.add(new ModelBox(this.spiral, 26, 36, 5.0f, 1.0f, 5.0f, 2, 6, 2, 0.0f, false));
        this.spiral.field_78804_l.add(new ModelBox(this.spiral, 26, 46, -7.0f, -1.0f, 5.0f, 14, 2, 2, 0.0f, false));
        this.spiral.field_78804_l.add(new ModelBox(this.spiral, 26, 52, -7.0f, -5.0f, -7.0f, 14, 2, 2, 0.0f, false));
        this.spiral.field_78804_l.add(new ModelBox(this.spiral, 26, 52, -7.0f, -15.0f, 5.0f, 14, 2, 2, 0.0f, true));
        this.spiral.field_78804_l.add(new ModelBox(this.spiral, 26, 46, -7.0f, -19.0f, -7.0f, 14, 2, 2, 0.0f, false));
        this.spiral.field_78804_l.add(new ModelBox(this.spiral, 45, 46, 5.0f, -17.0f, -7.0f, 2, 2, 14, 0.0f, false));
        this.spiral.field_78804_l.add(new ModelBox(this.spiral, 45, 46, -7.0f, -3.0f, -7.0f, 2, 2, 14, 0.0f, false));
        this.spiral.field_78804_l.add(new ModelBox(this.spiral, 36, 36, -7.0f, -25.0f, -7.0f, 2, 6, 2, 0.0f, false));
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.body.func_78785_a(f5);
        this.spiral.func_78785_a(f5);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.spiral.field_78796_g = ageInTicks * 0.1f;
    }
}

