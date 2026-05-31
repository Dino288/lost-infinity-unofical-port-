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
import xol.lostinfinity.mob.entity.misc.EntityBaseCannon;

public class ModelCannon
extends ModelBase {
    private final ModelRenderer Cannon;
    private final ModelRenderer Pivot;
    private final ModelRenderer Stand;
    private final ModelRenderer bone_r1;

    public ModelCannon() {
        this.field_78090_t = 64;
        this.field_78089_u = 64;
        this.Cannon = new ModelRenderer((ModelBase)this);
        this.Cannon.func_78793_a(0.0f, 5.0f, -1.0f);
        this.setRotationAngle(this.Cannon, -0.6109f, 0.0f, 0.0f);
        this.Cannon.field_78804_l.add(new ModelBox(this.Cannon, 0, 0, -3.0f, -3.0f, -10.0f, 6, 6, 22, 0.0f, false));
        this.Cannon.field_78804_l.add(new ModelBox(this.Cannon, 40, 9, -4.0f, -4.0f, 12.0f, 8, 8, 4, 0.0f, false));
        this.Cannon.field_78804_l.add(new ModelBox(this.Cannon, 42, 0, 3.0f, -2.0f, 4.0f, 1, 1, 8, 0.0f, false));
        this.Cannon.field_78804_l.add(new ModelBox(this.Cannon, 42, 0, 3.0f, 1.0f, 4.0f, 1, 1, 8, 0.0f, false));
        this.Cannon.field_78804_l.add(new ModelBox(this.Cannon, 48, 43, -3.5f, -3.5f, -5.0f, 7, 7, 1, 0.0f, false));
        this.Cannon.field_78804_l.add(new ModelBox(this.Cannon, 31, 43, -3.5f, -3.5f, -3.0f, 7, 7, 1, 0.0f, false));
        this.Cannon.field_78804_l.add(new ModelBox(this.Cannon, 48, 52, -3.5f, -3.5f, -7.0f, 7, 7, 1, 0.0f, false));
        this.Cannon.field_78804_l.add(new ModelBox(this.Cannon, 0, 12, -3.0f, -3.0f, -13.0f, 6, 6, 3, 0.0f, false));
        this.Pivot = new ModelRenderer((ModelBase)this);
        this.Pivot.func_78793_a(0.0f, 16.0f, 0.0f);
        this.Pivot.field_78804_l.add(new ModelBox(this.Pivot, 0, 45, -1.5f, -8.0f, -1.5f, 3, 6, 3, 0.0f, false));
        this.Pivot.field_78804_l.add(new ModelBox(this.Pivot, 18, 49, -0.5f, -10.0f, -4.5f, 1, 6, 1, 0.0f, false));
        this.Pivot.field_78804_l.add(new ModelBox(this.Pivot, 23, 52, 0.5f, -5.0f, -4.5f, 1, 1, 3, 0.0f, false));
        this.Pivot.field_78804_l.add(new ModelBox(this.Pivot, 23, 52, -1.5f, -5.0f, -4.5f, 1, 1, 3, 0.0f, false));
        this.Stand = new ModelRenderer((ModelBase)this);
        this.Stand.func_78793_a(0.0f, 19.0f, 1.0f);
        this.Stand.field_78804_l.add(new ModelBox(this.Stand, 0, 30, -2.0f, -5.0f, -3.0f, 4, 10, 4, 0.0f, false));
        this.Stand.field_78804_l.add(new ModelBox(this.Stand, 17, 34, -8.0f, 3.0f, 5.0f, 16, 2, 2, 0.0f, false));
        this.Stand.field_78804_l.add(new ModelBox(this.Stand, 22, 39, -6.0f, 3.5f, -2.0f, 12, 1, 2, 0.0f, false));
        this.Stand.field_78804_l.add(new ModelBox(this.Stand, 14, 29, -8.0f, 3.0f, -9.0f, 16, 2, 2, 0.0f, false));
        this.Stand.field_78804_l.add(new ModelBox(this.Stand, 1, 45, 6.0f, 3.0f, -7.0f, 2, 2, 12, 0.0f, false));
        this.Stand.field_78804_l.add(new ModelBox(this.Stand, 1, 45, -8.0f, 3.0f, -7.0f, 2, 2, 12, 0.0f, true));
        this.bone_r1 = new ModelRenderer((ModelBase)this);
        this.bone_r1.func_78793_a(0.0f, 4.5f, -1.0f);
        this.Stand.func_78792_a(this.bone_r1);
        this.setRotationAngle(this.bone_r1, 0.0f, -1.5708f, 0.0f);
        this.bone_r1.field_78804_l.add(new ModelBox(this.bone_r1, 22, 39, -6.0f, -1.0f, -1.0f, 12, 1, 2, 0.0f, false));
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.Cannon.func_78785_a(f5);
        this.Pivot.func_78785_a(f5);
        this.Stand.func_78785_a(f5);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        float rot;
        EntityBaseCannon cannon = (EntityBaseCannon)entityIn;
        this.Cannon.field_78796_g = rot = cannon.getRotation();
        this.Pivot.field_78796_g = rot;
    }
}

