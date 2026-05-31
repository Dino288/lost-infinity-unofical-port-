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

public class ModelNightshyre
extends ModelBase {
    private final ModelRenderer Body;
    private final ModelRenderer cube_r1;
    private final ModelRenderer wing1;
    private final ModelRenderer rotator1;
    private final ModelRenderer wing2;
    private final ModelRenderer rotator2;
    private final ModelRenderer Head;
    private final ModelRenderer horn1;
    private final ModelRenderer cube_r2;
    private final ModelRenderer cube_r3;
    private final ModelRenderer horn2;
    private final ModelRenderer cube_r4;
    private final ModelRenderer cube_r5;

    public ModelNightshyre() {
        this.field_78090_t = 64;
        this.field_78089_u = 64;
        this.Body = new ModelRenderer((ModelBase)this);
        this.Body.func_78793_a(0.0f, 7.0f, 0.0f);
        this.Body.field_78804_l.add(new ModelBox(this.Body, 0, 14, -6.0f, 7.0f, -3.0f, 12, 6, 16, 0.0f, false));
        this.cube_r1 = new ModelRenderer((ModelBase)this);
        this.cube_r1.func_78793_a(2.5f, 4.0f, 10.0f);
        this.Body.func_78792_a(this.cube_r1);
        this.setRotationAngle(this.cube_r1, 0.6981f, 0.0f, 0.0f);
        this.cube_r1.field_78804_l.add(new ModelBox(this.cube_r1, 0, 40, -7.5f, -5.0f, -11.0f, 1, 6, 18, 0.0f, false));
        this.cube_r1.field_78804_l.add(new ModelBox(this.cube_r1, 21, 43, -3.0f, -2.0f, -7.0f, 1, 3, 11, 0.0f, false));
        this.cube_r1.field_78804_l.add(new ModelBox(this.cube_r1, 21, 43, -5.5f, 0.0f, -5.0f, 1, 3, 11, 0.0f, false));
        this.cube_r1.field_78804_l.add(new ModelBox(this.cube_r1, 21, 43, -0.5f, 0.0f, -5.0f, 1, 3, 11, 0.0f, false));
        this.cube_r1.field_78804_l.add(new ModelBox(this.cube_r1, 0, 40, 1.5f, -5.0f, -11.0f, 1, 6, 18, 0.0f, false));
        this.wing1 = new ModelRenderer((ModelBase)this);
        this.wing1.func_78793_a(0.0f, 10.0f, 5.0f);
        this.Body.func_78792_a(this.wing1);
        this.wing1.field_78804_l.add(new ModelBox(this.wing1, 0, 21, -8.0f, -2.0f, -3.0f, 2, 3, 6, 0.0f, false));
        this.wing1.field_78804_l.add(new ModelBox(this.wing1, 42, 37, -15.0f, -2.0f, -5.0f, 9, 3, 2, 0.0f, false));
        this.wing1.field_78804_l.add(new ModelBox(this.wing1, 42, 43, -15.0f, -2.0f, 3.0f, 9, 3, 2, 0.0f, false));
        this.wing1.field_78804_l.add(new ModelBox(this.wing1, 40, 21, -15.0f, -2.0f, -3.0f, 2, 3, 6, 0.0f, false));
        this.rotator1 = new ModelRenderer((ModelBase)this);
        this.rotator1.func_78793_a(-10.5f, 0.5f, 0.0f);
        this.wing1.func_78792_a(this.rotator1);
        this.rotator1.field_78804_l.add(new ModelBox(this.rotator1, 51, 23, -3.0f, -0.5f, -1.0f, 2, 1, 2, -0.4f, false));
        this.rotator1.field_78804_l.add(new ModelBox(this.rotator1, 51, 23, -1.0f, -0.5f, -3.0f, 2, 1, 2, -0.4f, false));
        this.rotator1.field_78804_l.add(new ModelBox(this.rotator1, 51, 23, -1.0f, -0.5f, 1.0f, 2, 1, 2, -0.4f, false));
        this.rotator1.field_78804_l.add(new ModelBox(this.rotator1, 51, 23, 1.0f, -0.5f, -1.0f, 2, 1, 2, -0.4f, false));
        this.wing2 = new ModelRenderer((ModelBase)this);
        this.wing2.func_78793_a(0.0f, 10.0f, 5.0f);
        this.Body.func_78792_a(this.wing2);
        this.wing2.field_78804_l.add(new ModelBox(this.wing2, 0, 21, 6.0f, -2.0f, -3.0f, 2, 3, 6, 0.0f, true));
        this.wing2.field_78804_l.add(new ModelBox(this.wing2, 42, 37, 6.0f, -2.0f, -5.0f, 9, 3, 2, 0.0f, true));
        this.wing2.field_78804_l.add(new ModelBox(this.wing2, 42, 43, 6.0f, -2.0f, 3.0f, 9, 3, 2, 0.0f, true));
        this.wing2.field_78804_l.add(new ModelBox(this.wing2, 40, 21, 13.0f, -2.0f, -3.0f, 2, 3, 6, 0.0f, true));
        this.rotator2 = new ModelRenderer((ModelBase)this);
        this.rotator2.func_78793_a(10.5f, 0.5f, 0.0f);
        this.wing2.func_78792_a(this.rotator2);
        this.rotator2.field_78804_l.add(new ModelBox(this.rotator2, 51, 23, 1.0f, -0.5f, -1.0f, 2, 1, 2, -0.4f, true));
        this.rotator2.field_78804_l.add(new ModelBox(this.rotator2, 51, 23, -1.0f, -0.5f, -3.0f, 2, 1, 2, -0.4f, true));
        this.rotator2.field_78804_l.add(new ModelBox(this.rotator2, 51, 23, -1.0f, -0.5f, 1.0f, 2, 1, 2, -0.4f, true));
        this.rotator2.field_78804_l.add(new ModelBox(this.rotator2, 51, 23, -3.0f, -0.5f, -1.0f, 2, 1, 2, -0.4f, true));
        this.Head = new ModelRenderer((ModelBase)this);
        this.Head.func_78793_a(0.0f, 17.0f, -3.0f);
        this.Head.field_78804_l.add(new ModelBox(this.Head, 0, 0, -5.0f, -4.0f, -5.0f, 10, 8, 6, 0.0f, false));
        this.horn1 = new ModelRenderer((ModelBase)this);
        this.horn1.func_78793_a(3.0f, -7.0f, -1.0f);
        this.Head.func_78792_a(this.horn1);
        this.cube_r2 = new ModelRenderer((ModelBase)this);
        this.cube_r2.func_78793_a(0.0f, 0.0f, 0.0f);
        this.horn1.func_78792_a(this.cube_r2);
        this.setRotationAngle(this.cube_r2, -0.5236f, 0.0f, 0.0f);
        this.cube_r2.field_78804_l.add(new ModelBox(this.cube_r2, 33, 0, -1.0f, -3.0f, -1.0f, 2, 8, 2, -0.5f, false));
        this.cube_r3 = new ModelRenderer((ModelBase)this);
        this.cube_r3.func_78793_a(0.0f, 0.0f, 0.0f);
        this.horn1.func_78792_a(this.cube_r3);
        this.setRotationAngle(this.cube_r3, -1.0036f, 0.0f, 0.0f);
        this.cube_r3.field_78804_l.add(new ModelBox(this.cube_r3, 42, 1, -1.0f, -5.0f, -11.0f, 1, 8, 10, 0.0f, false));
        this.cube_r3.field_78804_l.add(new ModelBox(this.cube_r3, 42, 0, -1.0f, -5.0f, -2.0f, 2, 8, 2, -0.4f, false));
        this.horn2 = new ModelRenderer((ModelBase)this);
        this.horn2.func_78793_a(-3.0f, -7.0f, -1.0f);
        this.Head.func_78792_a(this.horn2);
        this.cube_r4 = new ModelRenderer((ModelBase)this);
        this.cube_r4.func_78793_a(0.0f, 0.0f, 0.0f);
        this.horn2.func_78792_a(this.cube_r4);
        this.setRotationAngle(this.cube_r4, -0.5236f, 0.0f, 0.0f);
        this.cube_r4.field_78804_l.add(new ModelBox(this.cube_r4, 33, 0, -1.0f, -3.0f, -1.0f, 2, 8, 2, -0.5f, false));
        this.cube_r5 = new ModelRenderer((ModelBase)this);
        this.cube_r5.func_78793_a(0.0f, 0.0f, 0.0f);
        this.horn2.func_78792_a(this.cube_r5);
        this.setRotationAngle(this.cube_r5, -1.0036f, 0.0f, 0.0f);
        this.cube_r5.field_78804_l.add(new ModelBox(this.cube_r5, 42, 1, -1.0f, -5.0f, -11.0f, 1, 8, 10, 0.0f, false));
        this.cube_r5.field_78804_l.add(new ModelBox(this.cube_r5, 42, 0, -1.0f, -5.0f, -2.0f, 2, 8, 2, -0.4f, false));
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.Body.func_78785_a(f5);
        this.Head.func_78785_a(f5);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.Head.field_78796_g = netHeadYaw * ((float)Math.PI / 180);
        this.Head.field_78795_f = headPitch * ((float)Math.PI / 180);
        this.rotator1.field_78796_g = ageInTicks * 0.2f;
        this.rotator2.field_78796_g = ageInTicks * -0.2f;
    }
}

