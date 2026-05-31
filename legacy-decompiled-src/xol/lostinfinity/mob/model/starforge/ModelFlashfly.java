/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.model.ModelBox
 *  net.minecraft.client.model.ModelRenderer
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.math.Mth
 */
package xol.lostinfinity.mob.model.starforge;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;

public class ModelFlashfly
extends ModelBase {
    private final ModelRenderer Wing1;
    private final ModelRenderer Body;
    private final ModelRenderer Wing2;
    private final ModelRenderer Wing3;
    private final ModelRenderer Wing4;

    public ModelFlashfly() {
        this.field_78090_t = 64;
        this.field_78089_u = 64;
        this.Wing1 = new ModelRenderer((ModelBase)this);
        this.Wing1.func_78793_a(8.0f, 17.0f, -10.5f);
        this.Wing1.field_78804_l.add(new ModelBox(this.Wing1, 1, 33, 0.0f, -6.0f, -0.5f, 20, 12, 1, 0.0f, true));
        this.Body = new ModelRenderer((ModelBase)this);
        this.Body.func_78793_a(0.0f, 7.0f, 0.0f);
        this.Body.field_78804_l.add(new ModelBox(this.Body, 2, 49, -6.0f, 5.0f, -14.0f, 12, 10, 2, 0.0f, false));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 0, 0, -8.0f, 3.0f, -12.0f, 16, 14, 16, 0.0f, false));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 32, 35, 7.0f, 3.0f, 4.0f, 1, 14, 15, 0.0f, false));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 32, 35, -8.0f, 3.0f, 4.0f, 1, 14, 15, 0.0f, true));
        this.Wing2 = new ModelRenderer((ModelBase)this);
        this.Wing2.func_78793_a(0.0f, 10.0f, -10.5f);
        this.setRotationAngle(this.Wing2, 0.0f, 0.0f, -1.5708f);
        this.Wing2.field_78804_l.add(new ModelBox(this.Wing2, 1, 33, 0.0f, -6.0f, -0.5f, 20, 12, 1, 0.0f, true));
        this.Wing3 = new ModelRenderer((ModelBase)this);
        this.Wing3.func_78793_a(-8.0f, 17.0f, -10.5f);
        this.setRotationAngle(this.Wing3, 0.0f, 0.0f, -3.1416f);
        this.Wing3.field_78804_l.add(new ModelBox(this.Wing3, 1, 33, 0.0f, -6.0f, -0.5f, 20, 12, 1, 0.0f, true));
        this.Wing4 = new ModelRenderer((ModelBase)this);
        this.Wing4.func_78793_a(0.0f, 24.0f, -10.5f);
        this.setRotationAngle(this.Wing4, 0.0f, 0.0f, 1.5708f);
        this.Wing4.field_78804_l.add(new ModelBox(this.Wing4, 1, 33, 0.0f, -6.0f, -0.5f, 20, 12, 1, 0.0f, true));
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.Wing1.func_78785_a(f5);
        this.Body.func_78785_a(f5);
        this.Wing2.func_78785_a(f5);
        this.Wing3.func_78785_a(f5);
        this.Wing4.func_78785_a(f5);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.Wing2.field_78796_g = this.Wing1.field_78796_g = -0.75f + 0.75f * Mth.func_76126_a((float)(ageInTicks * 0.2f));
        this.Wing3.field_78796_g = this.Wing1.field_78796_g;
        this.Wing4.field_78796_g = this.Wing1.field_78796_g;
    }
}

