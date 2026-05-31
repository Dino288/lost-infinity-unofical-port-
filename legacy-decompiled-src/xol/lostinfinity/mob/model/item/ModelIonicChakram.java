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

public class ModelIonicChakram
extends ModelBase {
    private final ModelRenderer Ring;
    private final ModelRenderer cube_r1;
    private final ModelRenderer cube_r2;
    private final ModelRenderer cube_r3;
    private final ModelRenderer cube_r4;
    private final ModelRenderer cube_r5;
    private final ModelRenderer cube_r6;
    private final ModelRenderer cube_r7;
    private final ModelRenderer cube_r8;
    private final ModelRenderer cube_r9;

    public ModelIonicChakram() {
        this.field_78090_t = 32;
        this.field_78089_u = 32;
        this.Ring = new ModelRenderer((ModelBase)this);
        this.Ring.func_78793_a(0.0f, 23.5f, 0.0f);
        this.setRotationAngle(this.Ring, 3.1416f, 0.0f, 0.0f);
        this.Ring.field_78804_l.add(new ModelBox(this.Ring, 0, 0, -5.0f, -1.5f, -11.0f, 10, 2, 3, 0.0f, false));
        this.Ring.field_78804_l.add(new ModelBox(this.Ring, 0, 0, -5.0f, -1.5f, 8.0f, 10, 2, 3, 0.0f, false));
        this.Ring.field_78804_l.add(new ModelBox(this.Ring, 13, 17, -3.0f, -1.0f, -13.0f, 6, 1, 2, 0.0f, false));
        this.Ring.field_78804_l.add(new ModelBox(this.Ring, 16, 26, -3.0f, -1.0f, 11.0f, 6, 1, 2, 0.0f, false));
        this.Ring.field_78804_l.add(new ModelBox(this.Ring, 0, 16, -2.0f, -1.0f, -15.0f, 4, 1, 2, 0.0f, false));
        this.Ring.field_78804_l.add(new ModelBox(this.Ring, 19, 11, -2.0f, -1.0f, 13.0f, 4, 1, 2, 0.0f, false));
        this.Ring.field_78804_l.add(new ModelBox(this.Ring, 0, 27, 1.0f, -1.0f, -17.0f, 1, 1, 2, 0.0f, false));
        this.Ring.field_78804_l.add(new ModelBox(this.Ring, 0, 23, 1.0f, -1.0f, 15.0f, 1, 1, 2, 0.0f, false));
        this.Ring.field_78804_l.add(new ModelBox(this.Ring, 0, 27, -2.0f, -1.0f, -17.0f, 1, 1, 2, 0.0f, false));
        this.Ring.field_78804_l.add(new ModelBox(this.Ring, 0, 23, -2.0f, -1.0f, 15.0f, 1, 1, 2, 0.0f, false));
        this.Ring.field_78804_l.add(new ModelBox(this.Ring, 0, 5, -8.0f, -0.5f, 1.0f, 6, 1, 2, 0.0f, false));
        this.Ring.field_78804_l.add(new ModelBox(this.Ring, 0, 5, 2.0f, -0.5f, -4.0f, 6, 1, 2, 0.0f, false));
        this.Ring.field_78804_l.add(new ModelBox(this.Ring, 0, 20, -11.0f, -1.5f, -5.0f, 3, 2, 10, 0.0f, false));
        this.Ring.field_78804_l.add(new ModelBox(this.Ring, 0, 20, 8.0f, -1.5f, -5.0f, 3, 2, 10, 0.0f, false));
        this.Ring.field_78804_l.add(new ModelBox(this.Ring, 20, 22, -6.0f, 0.5f, -4.0f, 3, 1, 3, 0.0f, false));
        this.Ring.field_78804_l.add(new ModelBox(this.Ring, 20, 22, 3.0f, 0.5f, 0.0f, 3, 1, 3, 0.0f, false));
        this.Ring.field_78804_l.add(new ModelBox(this.Ring, 19, 6, -6.0f, -2.5f, -4.0f, 3, 1, 3, 0.0f, false));
        this.Ring.field_78804_l.add(new ModelBox(this.Ring, 18, 20, -12.0f, -2.5f, -3.0f, 6, 1, 1, 0.0f, false));
        this.Ring.field_78804_l.add(new ModelBox(this.Ring, 18, 20, 6.0f, -2.5f, 1.0f, 6, 1, 1, 0.0f, false));
        this.Ring.field_78804_l.add(new ModelBox(this.Ring, 19, 22, 11.0f, -1.5f, 1.0f, 1, 2, 1, 0.0f, false));
        this.Ring.field_78804_l.add(new ModelBox(this.Ring, 19, 22, -12.0f, -1.5f, -3.0f, 1, 2, 1, 0.0f, false));
        this.Ring.field_78804_l.add(new ModelBox(this.Ring, 1, 20, -5.0f, -1.5f, -3.0f, 1, 2, 1, 0.0f, false));
        this.Ring.field_78804_l.add(new ModelBox(this.Ring, 1, 20, 4.0f, -1.5f, 1.0f, 1, 2, 1, 0.0f, false));
        this.Ring.field_78804_l.add(new ModelBox(this.Ring, 19, 6, 3.0f, -2.5f, 0.0f, 3, 1, 3, 0.0f, false));
        this.cube_r1 = new ModelRenderer((ModelBase)this);
        this.cube_r1.func_78793_a(0.0f, 0.0f, -0.5f);
        this.Ring.func_78792_a(this.cube_r1);
        this.setRotationAngle(this.cube_r1, 0.0f, -0.7854f, 0.0f);
        this.cube_r1.field_78804_l.add(new ModelBox(this.cube_r1, 0, 11, -4.0f, -1.6f, 8.5f, 8, 2, 3, 0.0f, true));
        this.cube_r2 = new ModelRenderer((ModelBase)this);
        this.cube_r2.func_78793_a(0.0f, 0.0f, -2.5f);
        this.Ring.func_78792_a(this.cube_r2);
        this.setRotationAngle(this.cube_r2, 0.0f, -0.7854f, 0.0f);
        this.cube_r2.field_78804_l.add(new ModelBox(this.cube_r2, 0, 11, -2.0f, -1.6f, -9.5f, 8, 2, 3, 0.0f, true));
        this.cube_r3 = new ModelRenderer((ModelBase)this);
        this.cube_r3.func_78793_a(0.0f, 0.0f, -0.5f);
        this.Ring.func_78792_a(this.cube_r3);
        this.setRotationAngle(this.cube_r3, 0.0f, 0.7854f, 0.0f);
        this.cube_r3.field_78804_l.add(new ModelBox(this.cube_r3, 0, 11, -4.0f, -1.6f, 8.5f, 8, 2, 3, 0.0f, false));
        this.cube_r4 = new ModelRenderer((ModelBase)this);
        this.cube_r4.func_78793_a(0.0f, 0.0f, -2.5f);
        this.Ring.func_78792_a(this.cube_r4);
        this.setRotationAngle(this.cube_r4, 0.0f, 0.7854f, 0.0f);
        this.cube_r4.field_78804_l.add(new ModelBox(this.cube_r4, 0, 11, -6.0f, -1.6f, -9.5f, 8, 2, 3, 0.0f, false));
        this.cube_r5 = new ModelRenderer((ModelBase)this);
        this.cube_r5.func_78793_a(0.0f, 0.0f, -1.5f);
        this.Ring.func_78792_a(this.cube_r5);
        this.setRotationAngle(this.cube_r5, 0.0f, 0.7854f, 0.0f);
        this.cube_r5.field_78804_l.add(new ModelBox(this.cube_r5, 0, 8, -5.0f, -0.6f, -0.5f, 8, 1, 2, 0.0f, false));
        this.cube_r6 = new ModelRenderer((ModelBase)this);
        this.cube_r6.func_78793_a(0.0f, 0.0f, -8.5f);
        this.Ring.func_78792_a(this.cube_r6);
        this.setRotationAngle(this.cube_r6, 0.0f, 0.7854f, 0.0f);
        this.cube_r6.field_78804_l.add(new ModelBox(this.cube_r6, 0, 23, -10.0f, -1.0f, 17.5f, 1, 1, 2, 0.0f, true));
        this.cube_r6.field_78804_l.add(new ModelBox(this.cube_r6, 0, 23, -7.0f, -1.0f, 17.5f, 1, 1, 2, 0.0f, true));
        this.cube_r6.field_78804_l.add(new ModelBox(this.cube_r6, 0, 23, -4.0f, -1.0f, 17.5f, 1, 1, 2, 0.0f, true));
        this.cube_r7 = new ModelRenderer((ModelBase)this);
        this.cube_r7.func_78793_a(0.0f, 0.0f, -8.5f);
        this.Ring.func_78792_a(this.cube_r7);
        this.setRotationAngle(this.cube_r7, 0.0f, -0.7854f, 0.0f);
        this.cube_r7.field_78804_l.add(new ModelBox(this.cube_r7, 0, 23, 9.0f, -1.0f, 17.5f, 1, 1, 2, 0.0f, false));
        this.cube_r7.field_78804_l.add(new ModelBox(this.cube_r7, 0, 23, 6.0f, -1.0f, 17.5f, 1, 1, 2, 0.0f, false));
        this.cube_r7.field_78804_l.add(new ModelBox(this.cube_r7, 0, 23, 3.0f, -1.0f, 17.5f, 1, 1, 2, 0.0f, false));
        this.cube_r8 = new ModelRenderer((ModelBase)this);
        this.cube_r8.func_78793_a(0.0f, 0.0f, -10.5f);
        this.Ring.func_78792_a(this.cube_r8);
        this.setRotationAngle(this.cube_r8, 0.0f, 0.7854f, 0.0f);
        this.cube_r8.field_78804_l.add(new ModelBox(this.cube_r8, 0, 27, -5.0f, -1.0f, -5.5f, 1, 1, 2, 0.0f, true));
        this.cube_r8.field_78804_l.add(new ModelBox(this.cube_r8, 0, 27, -8.0f, -1.0f, -5.5f, 1, 1, 2, 0.0f, true));
        this.cube_r8.field_78804_l.add(new ModelBox(this.cube_r8, 0, 27, -11.0f, -1.0f, -5.5f, 1, 1, 2, 0.0f, true));
        this.cube_r9 = new ModelRenderer((ModelBase)this);
        this.cube_r9.func_78793_a(0.0f, 0.0f, -10.5f);
        this.Ring.func_78792_a(this.cube_r9);
        this.setRotationAngle(this.cube_r9, 0.0f, -0.7854f, 0.0f);
        this.cube_r9.field_78804_l.add(new ModelBox(this.cube_r9, 0, 27, 4.0f, -1.0f, -5.5f, 1, 1, 2, 0.0f, false));
        this.cube_r9.field_78804_l.add(new ModelBox(this.cube_r9, 0, 27, 7.0f, -1.0f, -5.5f, 1, 1, 2, 0.0f, false));
        this.cube_r9.field_78804_l.add(new ModelBox(this.cube_r9, 0, 27, 10.0f, -1.0f, -5.5f, 1, 1, 2, 0.0f, false));
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.Ring.func_78785_a(f5);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }
}

