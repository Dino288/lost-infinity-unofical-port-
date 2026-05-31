/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.model.ModelBox
 *  net.minecraft.client.model.ModelRenderer
 *  net.minecraft.entity.Entity
 */
package xol.lostinfinity.mob.model.minion;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.world.entity.Entity;

public class ModelBombDrone
extends ModelBase {
    private final ModelRenderer Drone;
    private final ModelRenderer Rotor1;
    private final ModelRenderer Rotor3;
    private final ModelRenderer Rotor2;
    private final ModelRenderer Rotor4;

    public ModelBombDrone() {
        this.field_78090_t = 64;
        this.field_78089_u = 64;
        this.Drone = new ModelRenderer((ModelBase)this);
        this.Drone.func_78793_a(0.0f, 15.0f, 0.0f);
        this.Drone.field_78804_l.add(new ModelBox(this.Drone, 0, 0, -8.0f, 2.0f, -8.0f, 16, 3, 16, 0.0f, false));
        this.Drone.field_78804_l.add(new ModelBox(this.Drone, 0, 36, 2.0f, 5.0f, -7.0f, 5, 3, 5, 0.5f, false));
        this.Drone.field_78804_l.add(new ModelBox(this.Drone, 0, 36, -7.0f, 5.0f, -7.0f, 5, 3, 5, 0.5f, false));
        this.Drone.field_78804_l.add(new ModelBox(this.Drone, 0, 36, -7.0f, 5.0f, 2.0f, 5, 3, 5, 0.5f, false));
        this.Drone.field_78804_l.add(new ModelBox(this.Drone, 0, 36, 2.0f, 5.0f, 2.0f, 5, 3, 5, 0.5f, false));
        this.Drone.field_78804_l.add(new ModelBox(this.Drone, 38, 29, -0.5f, -4.9f, -6.0f, 1, 7, 12, 0.0f, false));
        this.Drone.field_78804_l.add(new ModelBox(this.Drone, 0, 19, -5.0f, -4.0f, -5.0f, 10, 6, 10, 0.0f, false));
        this.Drone.field_78804_l.add(new ModelBox(this.Drone, 0, 45, -5.0f, 1.0f, -5.0f, 10, 1, 10, 0.2f, false));
        this.Drone.field_78804_l.add(new ModelBox(this.Drone, 31, 20, -6.0f, -5.0f, -0.5f, 12, 7, 1, 0.0f, false));
        this.Rotor1 = new ModelRenderer((ModelBase)this);
        this.Rotor1.func_78793_a(4.5f, 7.0f, -4.5f);
        this.Drone.func_78792_a(this.Rotor1);
        this.Rotor1.field_78804_l.add(new ModelBox(this.Rotor1, 0, 0, -0.5f, -2.0f, -0.5f, 1, 4, 1, 0.0f, false));
        this.Rotor1.field_78804_l.add(new ModelBox(this.Rotor1, 5, 0, 0.5f, 0.5f, -0.5f, 2, 1, 1, 0.0f, false));
        this.Rotor1.field_78804_l.add(new ModelBox(this.Rotor1, 5, 6, -0.5f, 0.5f, -2.5f, 1, 1, 2, 0.0f, false));
        this.Rotor1.field_78804_l.add(new ModelBox(this.Rotor1, 5, 10, -0.5f, 0.5f, 0.5f, 1, 1, 2, 0.0f, false));
        this.Rotor1.field_78804_l.add(new ModelBox(this.Rotor1, 5, 3, -2.5f, 0.5f, -0.5f, 2, 1, 1, 0.0f, false));
        this.Rotor3 = new ModelRenderer((ModelBase)this);
        this.Rotor3.func_78793_a(4.5f, 7.0f, 4.5f);
        this.Drone.func_78792_a(this.Rotor3);
        this.Rotor3.field_78804_l.add(new ModelBox(this.Rotor3, 0, 0, -0.5f, -2.0f, -0.5f, 1, 4, 1, 0.0f, false));
        this.Rotor3.field_78804_l.add(new ModelBox(this.Rotor3, 5, 0, 0.5f, 0.5f, -0.5f, 2, 1, 1, 0.0f, false));
        this.Rotor3.field_78804_l.add(new ModelBox(this.Rotor3, 5, 6, -0.5f, 0.5f, -2.5f, 1, 1, 2, 0.0f, false));
        this.Rotor3.field_78804_l.add(new ModelBox(this.Rotor3, 5, 10, -0.5f, 0.5f, 0.5f, 1, 1, 2, 0.0f, false));
        this.Rotor3.field_78804_l.add(new ModelBox(this.Rotor3, 5, 3, -2.5f, 0.5f, -0.5f, 2, 1, 1, 0.0f, false));
        this.Rotor2 = new ModelRenderer((ModelBase)this);
        this.Rotor2.func_78793_a(-4.5f, 7.0f, -4.5f);
        this.Drone.func_78792_a(this.Rotor2);
        this.Rotor2.field_78804_l.add(new ModelBox(this.Rotor2, 0, 0, -0.5f, -2.0f, -0.5f, 1, 4, 1, 0.0f, false));
        this.Rotor2.field_78804_l.add(new ModelBox(this.Rotor2, 5, 0, 0.5f, 0.5f, -0.5f, 2, 1, 1, 0.0f, false));
        this.Rotor2.field_78804_l.add(new ModelBox(this.Rotor2, 5, 6, -0.5f, 0.5f, -2.5f, 1, 1, 2, 0.0f, false));
        this.Rotor2.field_78804_l.add(new ModelBox(this.Rotor2, 5, 10, -0.5f, 0.5f, 0.5f, 1, 1, 2, 0.0f, false));
        this.Rotor2.field_78804_l.add(new ModelBox(this.Rotor2, 5, 3, -2.5f, 0.5f, -0.5f, 2, 1, 1, 0.0f, false));
        this.Rotor4 = new ModelRenderer((ModelBase)this);
        this.Rotor4.func_78793_a(-4.5f, 7.0f, 4.5f);
        this.Drone.func_78792_a(this.Rotor4);
        this.Rotor4.field_78804_l.add(new ModelBox(this.Rotor4, 0, 0, -0.5f, -2.0f, -0.5f, 1, 4, 1, 0.0f, false));
        this.Rotor4.field_78804_l.add(new ModelBox(this.Rotor4, 5, 0, 0.5f, 0.5f, -0.5f, 2, 1, 1, 0.0f, false));
        this.Rotor4.field_78804_l.add(new ModelBox(this.Rotor4, 5, 6, -0.5f, 0.5f, -2.5f, 1, 1, 2, 0.0f, false));
        this.Rotor4.field_78804_l.add(new ModelBox(this.Rotor4, 5, 10, -0.5f, 0.5f, 0.5f, 1, 1, 2, 0.0f, false));
        this.Rotor4.field_78804_l.add(new ModelBox(this.Rotor4, 5, 3, -2.5f, 0.5f, -0.5f, 2, 1, 1, 0.0f, false));
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.Drone.func_78785_a(f5);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.Rotor1.field_78796_g = ageInTicks * 0.6f;
        this.Rotor2.field_78796_g = ageInTicks * 0.6f;
        this.Rotor3.field_78796_g = ageInTicks * 0.6f;
        this.Rotor4.field_78796_g = ageInTicks * 0.6f;
    }
}

