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
import xol.lostinfinity.mob.entity.misc.EntityTentacleTrap;

public class ModelTentacleTrap
extends ModelBase {
    private final ModelRenderer Tentacles;
    private final ModelRenderer Tentacle2;
    private final ModelRenderer body_r1;
    private final ModelRenderer Tentacle;
    private final ModelRenderer body_r2;
    private final ModelRenderer Tentacle3;
    private final ModelRenderer body_r3;

    public ModelTentacleTrap() {
        this.field_78090_t = 64;
        this.field_78089_u = 32;
        this.Tentacles = new ModelRenderer((ModelBase)this);
        this.Tentacles.func_78793_a(0.0f, 24.0f, 0.0f);
        this.Tentacle2 = new ModelRenderer((ModelBase)this);
        this.Tentacle2.func_78793_a(8.0f, 5.0f, 7.5f);
        this.Tentacles.func_78792_a(this.Tentacle2);
        this.setRotationAngle(this.Tentacle2, 1.5708f, -2.0944f, 0.0f);
        this.Tentacle2.field_78804_l.add(new ModelBox(this.Tentacle2, 1, 0, -3.0f, -3.0f, -0.5f, 6, 6, 25, -1.0f, false));
        this.body_r1 = new ModelRenderer((ModelBase)this);
        this.body_r1.func_78793_a(0.0f, 0.0f, 29.0f);
        this.Tentacle2.func_78792_a(this.body_r1);
        this.setRotationAngle(this.body_r1, -0.1745f, 0.0f, 0.0f);
        this.body_r1.field_78804_l.add(new ModelBox(this.body_r1, 1, 0, -3.0f, -2.0f, -7.5f, 6, 6, 25, -1.5f, false));
        this.Tentacle = new ModelRenderer((ModelBase)this);
        this.Tentacle.func_78793_a(0.0f, 5.0f, -7.5f);
        this.Tentacles.func_78792_a(this.Tentacle);
        this.setRotationAngle(this.Tentacle, 1.5708f, 0.0f, 0.0f);
        this.Tentacle.field_78804_l.add(new ModelBox(this.Tentacle, 1, 0, -3.0f, -3.0f, -0.5f, 6, 6, 25, -1.0f, false));
        this.body_r2 = new ModelRenderer((ModelBase)this);
        this.body_r2.func_78793_a(0.0f, 0.0f, 29.0f);
        this.Tentacle.func_78792_a(this.body_r2);
        this.setRotationAngle(this.body_r2, -0.1745f, 0.0f, 0.0f);
        this.body_r2.field_78804_l.add(new ModelBox(this.body_r2, 1, 0, -3.0f, -2.0f, -7.5f, 6, 6, 25, -1.5f, false));
        this.Tentacle3 = new ModelRenderer((ModelBase)this);
        this.Tentacle3.func_78793_a(-7.0f, 5.0f, 7.5f);
        this.Tentacles.func_78792_a(this.Tentacle3);
        this.setRotationAngle(this.Tentacle3, 1.5708f, 2.0944f, 0.0f);
        this.Tentacle3.field_78804_l.add(new ModelBox(this.Tentacle3, 1, 0, -3.0f, -3.0f, -0.5f, 6, 6, 25, -1.0f, false));
        this.body_r3 = new ModelRenderer((ModelBase)this);
        this.body_r3.func_78793_a(0.0f, 0.0f, 29.0f);
        this.Tentacle3.func_78792_a(this.body_r3);
        this.setRotationAngle(this.body_r3, -0.1745f, 0.0f, 0.0f);
        this.body_r3.field_78804_l.add(new ModelBox(this.body_r3, 1, 0, -3.0f, -2.0f, -7.5f, 6, 6, 25, -1.5f, false));
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.Tentacles.func_78785_a(f5);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        float angle;
        EntityTentacleTrap trap = (EntityTentacleTrap)entityIn;
        this.Tentacle.field_78795_f = angle = trap.getTentacleAngle();
        this.Tentacle2.field_78795_f = angle;
        this.Tentacle3.field_78795_f = angle;
        this.Tentacles.field_78796_g = angle * 2.0f;
    }
}

