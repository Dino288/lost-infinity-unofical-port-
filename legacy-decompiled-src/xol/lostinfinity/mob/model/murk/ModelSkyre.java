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
package xol.lostinfinity.mob.model.murk;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;

public class ModelSkyre
extends ModelBase {
    private final ModelRenderer GlowCube;
    private final ModelRenderer cube_r1;
    private final ModelRenderer Body;
    private final ModelRenderer cube_r2;
    private final ModelRenderer Mouth1;
    private final ModelRenderer cube_r3;
    private final ModelRenderer cube_r4;
    private final ModelRenderer cube_r5;
    private final ModelRenderer cube_r6;
    private final ModelRenderer Mouth2;
    private final ModelRenderer cube_r7;
    private final ModelRenderer cube_r8;
    private final ModelRenderer cube_r9;

    public ModelSkyre() {
        this.field_78090_t = 128;
        this.field_78089_u = 64;
        this.GlowCube = new ModelRenderer((ModelBase)this);
        this.GlowCube.func_78793_a(0.0f, -2.0f, 0.0f);
        this.GlowCube.field_78804_l.add(new ModelBox(this.GlowCube, 0, 0, -8.0f, -32.0f, -8.0f, 16, 14, 16, 8.0f, false));
        this.GlowCube.field_78804_l.add(new ModelBox(this.GlowCube, 33, 0, -2.0f, -10.0f, -16.0f, 4, 1, 32, 0.0f, false));
        this.cube_r1 = new ModelRenderer((ModelBase)this);
        this.cube_r1.func_78793_a(0.0f, -9.5f, 0.0f);
        this.GlowCube.func_78792_a(this.cube_r1);
        this.setRotationAngle(this.cube_r1, 0.0f, -1.5708f, 0.0f);
        this.cube_r1.field_78804_l.add(new ModelBox(this.cube_r1, 33, 0, -2.0f, -0.5f, -16.0f, 4, 1, 32, 0.0f, false));
        this.cube_r1.field_78804_l.add(new ModelBox(this.cube_r1, 90, 49, 9.0f, -0.5f, -15.0f, 6, 1, 6, 0.0f, false));
        this.cube_r1.field_78804_l.add(new ModelBox(this.cube_r1, 90, 49, -15.0f, -0.5f, -15.0f, 6, 1, 6, 0.0f, false));
        this.cube_r1.field_78804_l.add(new ModelBox(this.cube_r1, 90, 49, -15.0f, -0.5f, 9.0f, 6, 1, 6, 0.0f, false));
        this.cube_r1.field_78804_l.add(new ModelBox(this.cube_r1, 90, 49, 9.0f, -0.5f, 9.0f, 6, 1, 6, 0.0f, false));
        this.Body = new ModelRenderer((ModelBase)this);
        this.Body.func_78793_a(0.0f, -12.0f, 0.0f);
        this.Body.field_78804_l.add(new ModelBox(this.Body, 0, 44, -8.0f, 0.0f, -8.0f, 16, 2, 16, 0.0f, false));
        this.Mouth1 = new ModelRenderer((ModelBase)this);
        this.Mouth1.func_78793_a(0.0f, 1.5f, -5.5f);
        this.Body.func_78792_a(this.Mouth1);
        this.setRotationAngle(this.Mouth1, -0.2618f, 0.0f, 0.0f);
        this.Mouth1.field_78804_l.add(new ModelBox(this.Mouth1, 49, 35, -7.0f, -0.5f, -1.5f, 14, 19, 5, 0.0f, false));
        this.Mouth1.field_78804_l.add(new ModelBox(this.Mouth1, 108, 0, -4.0f, 0.5f, 3.5f, 8, 33, 2, 0.0f, false));
        this.Mouth1.field_78804_l.add(new ModelBox(this.Mouth1, 50, 8, -3.0f, 26.5f, 3.5f, 6, 6, 1, 0.0f, false));
        this.Mouth1.field_78804_l.add(new ModelBox(this.Mouth1, 50, 8, -3.0f, 15.5f, 3.5f, 6, 6, 1, 0.0f, false));
        this.Mouth1.field_78804_l.add(new ModelBox(this.Mouth1, 50, 8, -3.0f, 4.5f, 3.5f, 6, 6, 1, 0.0f, false));
        this.Mouth1.field_78804_l.add(new ModelBox(this.Mouth1, 16, 33, -6.0f, 18.5f, -0.5f, 12, 6, 4, 0.0f, false));
        this.Mouth1.field_78804_l.add(new ModelBox(this.Mouth1, 89, 38, -5.0f, 24.5f, 0.5f, 10, 6, 3, 0.0f, false));
        this.Mouth1.field_78804_l.add(new ModelBox(this.Mouth1, 75, 12, -4.0f, 30.5f, 0.5f, 8, 4, 3, 0.0f, false));
        this.cube_r2 = new ModelRenderer((ModelBase)this);
        this.cube_r2.func_78793_a(0.0f, 8.5f, -3.5f);
        this.Mouth1.func_78792_a(this.cube_r2);
        this.setRotationAngle(this.cube_r2, 1.0908f, 0.0f, 0.0f);
        this.cube_r2.field_78804_l.add(new ModelBox(this.cube_r2, 0, 42, -0.5f, 4.0f, -24.0f, 1, 1, 4, 0.0f, false));
        this.cube_r3 = new ModelRenderer((ModelBase)this);
        this.cube_r3.func_78793_a(0.0f, 8.5f, -3.5f);
        this.Mouth1.func_78792_a(this.cube_r3);
        this.setRotationAngle(this.cube_r3, 0.8727f, 0.0f, 0.0f);
        this.cube_r3.field_78804_l.add(new ModelBox(this.cube_r3, 0, 50, -1.0f, 8.0f, -19.0f, 2, 2, 6, 0.0f, false));
        this.cube_r3.field_78804_l.add(new ModelBox(this.cube_r3, 0, 50, -1.0f, -4.0f, -14.0f, 2, 2, 6, 0.0f, false));
        this.cube_r4 = new ModelRenderer((ModelBase)this);
        this.cube_r4.func_78793_a(0.0f, 8.5f, -3.5f);
        this.Mouth1.func_78792_a(this.cube_r4);
        this.setRotationAngle(this.cube_r4, 0.5672f, 0.0f, 0.0f);
        this.cube_r4.field_78804_l.add(new ModelBox(this.cube_r4, 74, 20, -2.0f, 11.0f, -10.0f, 4, 4, 7, 0.0f, false));
        this.cube_r4.field_78804_l.add(new ModelBox(this.cube_r4, 74, 20, -2.0f, -2.0f, -9.0f, 4, 4, 7, 0.0f, false));
        this.cube_r5 = new ModelRenderer((ModelBase)this);
        this.cube_r5.func_78793_a(0.0f, 8.5f, -3.5f);
        this.Mouth1.func_78792_a(this.cube_r5);
        this.setRotationAngle(this.cube_r5, 0.3054f, 0.0f, 0.0f);
        this.cube_r5.field_78804_l.add(new ModelBox(this.cube_r5, 74, 0, -3.0f, -2.0f, -3.0f, 6, 6, 6, 0.0f, false));
        this.Mouth2 = new ModelRenderer((ModelBase)this);
        this.Mouth2.func_78793_a(0.0f, 1.5f, 5.5f);
        this.Body.func_78792_a(this.Mouth2);
        this.setRotationAngle(this.Mouth2, -0.2618f, 3.1416f, 0.0f);
        this.Mouth2.field_78804_l.add(new ModelBox(this.Mouth2, 49, 35, -7.0f, -0.5f, -1.5f, 14, 19, 5, 0.0f, false));
        this.Mouth2.field_78804_l.add(new ModelBox(this.Mouth2, 108, 0, -4.0f, 0.5f, 3.5f, 8, 33, 2, 0.0f, false));
        this.Mouth2.field_78804_l.add(new ModelBox(this.Mouth2, 50, 8, -3.0f, 26.5f, 3.5f, 6, 6, 1, 0.0f, false));
        this.Mouth2.field_78804_l.add(new ModelBox(this.Mouth2, 50, 8, -3.0f, 15.5f, 3.5f, 6, 6, 1, 0.0f, false));
        this.Mouth2.field_78804_l.add(new ModelBox(this.Mouth2, 50, 8, -3.0f, 4.5f, 3.5f, 6, 6, 1, 0.0f, false));
        this.Mouth2.field_78804_l.add(new ModelBox(this.Mouth2, 16, 33, -6.0f, 18.5f, -0.5f, 12, 6, 4, 0.0f, false));
        this.Mouth2.field_78804_l.add(new ModelBox(this.Mouth2, 89, 38, -5.0f, 24.5f, 0.5f, 10, 6, 3, 0.0f, false));
        this.Mouth2.field_78804_l.add(new ModelBox(this.Mouth2, 75, 12, -4.0f, 30.5f, 0.5f, 8, 4, 3, 0.0f, false));
        this.cube_r6 = new ModelRenderer((ModelBase)this);
        this.cube_r6.func_78793_a(0.0f, 8.5f, -3.5f);
        this.Mouth2.func_78792_a(this.cube_r6);
        this.setRotationAngle(this.cube_r6, 1.0908f, 0.0f, 0.0f);
        this.cube_r6.field_78804_l.add(new ModelBox(this.cube_r6, 0, 42, -0.5f, 4.0f, -24.0f, 1, 1, 4, 0.0f, false));
        this.cube_r7 = new ModelRenderer((ModelBase)this);
        this.cube_r7.func_78793_a(0.0f, 8.5f, -3.5f);
        this.Mouth2.func_78792_a(this.cube_r7);
        this.setRotationAngle(this.cube_r7, 0.8727f, 0.0f, 0.0f);
        this.cube_r7.field_78804_l.add(new ModelBox(this.cube_r7, 0, 50, -1.0f, 8.0f, -19.0f, 2, 2, 6, 0.0f, false));
        this.cube_r7.field_78804_l.add(new ModelBox(this.cube_r7, 0, 50, -1.0f, -4.0f, -14.0f, 2, 2, 6, 0.0f, false));
        this.cube_r8 = new ModelRenderer((ModelBase)this);
        this.cube_r8.func_78793_a(0.0f, 8.5f, -3.5f);
        this.Mouth2.func_78792_a(this.cube_r8);
        this.setRotationAngle(this.cube_r8, 0.5672f, 0.0f, 0.0f);
        this.cube_r8.field_78804_l.add(new ModelBox(this.cube_r8, 74, 20, -2.0f, 11.0f, -10.0f, 4, 4, 7, 0.0f, false));
        this.cube_r8.field_78804_l.add(new ModelBox(this.cube_r8, 74, 20, -2.0f, -2.0f, -9.0f, 4, 4, 7, 0.0f, false));
        this.cube_r9 = new ModelRenderer((ModelBase)this);
        this.cube_r9.func_78793_a(0.0f, 8.5f, -3.5f);
        this.Mouth2.func_78792_a(this.cube_r9);
        this.setRotationAngle(this.cube_r9, 0.3054f, 0.0f, 0.0f);
        this.cube_r9.field_78804_l.add(new ModelBox(this.cube_r9, 74, 0, -3.0f, -2.0f, -3.0f, 6, 6, 6, 0.0f, false));
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.GlowCube.func_78785_a(f5);
        this.Body.func_78785_a(f5);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.Mouth2.field_78795_f = this.Mouth1.field_78795_f = -0.7f + 0.7f * Mth.func_76126_a((float)(ageInTicks * 0.1f));
        this.Body.field_78796_g = ageInTicks * 0.05f;
    }
}

