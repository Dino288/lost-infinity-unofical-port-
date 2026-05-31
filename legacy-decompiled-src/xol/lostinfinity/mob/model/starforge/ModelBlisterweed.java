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

public class ModelBlisterweed
extends ModelBase {
    private final ModelRenderer Plant;
    private final ModelRenderer Bulb4;
    private final ModelRenderer bone_r1;
    private final ModelRenderer Bulb3;
    private final ModelRenderer bone_r2;
    private final ModelRenderer Bulb2;
    private final ModelRenderer bone_r3;
    private final ModelRenderer Bulb1;
    private final ModelRenderer bone_r4;
    private final ModelRenderer Orb;
    private final ModelRenderer OrbInner;
    private final ModelRenderer OrbInner2;
    private final ModelRenderer Body;

    public ModelBlisterweed() {
        this.field_78090_t = 64;
        this.field_78089_u = 64;
        this.Plant = new ModelRenderer((ModelBase)this);
        this.Plant.func_78793_a(0.0f, -12.0f, 0.0f);
        this.Bulb4 = new ModelRenderer((ModelBase)this);
        this.Bulb4.func_78793_a(0.0f, 26.0f, -6.0f);
        this.Plant.func_78792_a(this.Bulb4);
        this.setRotationAngle(this.Bulb4, 0.0f, 1.5708f, 0.0f);
        this.Bulb4.field_78804_l.add(new ModelBox(this.Bulb4, 34, 53, 2.0f, 4.0f, -2.0f, 4, 4, 4, 0.0f, false));
        this.bone_r1 = new ModelRenderer((ModelBase)this);
        this.bone_r1.func_78793_a(5.0f, 1.0f, 0.0f);
        this.Bulb4.func_78792_a(this.bone_r1);
        this.setRotationAngle(this.bone_r1, 0.0f, 0.0f, -0.7854f);
        this.bone_r1.field_78804_l.add(new ModelBox(this.bone_r1, 51, 52, -2.0f, -5.0f, -1.0f, 4, 8, 1, 0.0f, false));
        this.bone_r1.field_78804_l.add(new ModelBox(this.bone_r1, 25, 51, -4.0f, -5.0f, -1.0f, 2, 8, 2, 0.0f, false));
        this.Bulb3 = new ModelRenderer((ModelBase)this);
        this.Bulb3.func_78793_a(-6.0f, 26.0f, 0.0f);
        this.Plant.func_78792_a(this.Bulb3);
        this.setRotationAngle(this.Bulb3, 0.0f, 3.1416f, 0.0f);
        this.Bulb3.field_78804_l.add(new ModelBox(this.Bulb3, 34, 53, 2.0f, 4.0f, -2.0f, 4, 4, 4, 0.0f, false));
        this.bone_r2 = new ModelRenderer((ModelBase)this);
        this.bone_r2.func_78793_a(5.0f, 1.0f, 0.0f);
        this.Bulb3.func_78792_a(this.bone_r2);
        this.setRotationAngle(this.bone_r2, 0.0f, 0.0f, -0.7854f);
        this.bone_r2.field_78804_l.add(new ModelBox(this.bone_r2, 51, 52, -2.0f, -5.0f, -1.0f, 4, 8, 1, 0.0f, false));
        this.bone_r2.field_78804_l.add(new ModelBox(this.bone_r2, 25, 51, -4.0f, -5.0f, -1.0f, 2, 8, 2, 0.0f, false));
        this.Bulb2 = new ModelRenderer((ModelBase)this);
        this.Bulb2.func_78793_a(0.0f, 26.0f, 6.0f);
        this.Plant.func_78792_a(this.Bulb2);
        this.setRotationAngle(this.Bulb2, 0.0f, -1.5708f, 0.0f);
        this.Bulb2.field_78804_l.add(new ModelBox(this.Bulb2, 34, 53, 2.0f, 4.0f, -2.0f, 4, 4, 4, 0.0f, false));
        this.bone_r3 = new ModelRenderer((ModelBase)this);
        this.bone_r3.func_78793_a(5.0f, 1.0f, 0.0f);
        this.Bulb2.func_78792_a(this.bone_r3);
        this.setRotationAngle(this.bone_r3, 0.0f, 0.0f, -0.7854f);
        this.bone_r3.field_78804_l.add(new ModelBox(this.bone_r3, 51, 52, -2.0f, -5.0f, -1.0f, 4, 8, 1, 0.0f, false));
        this.bone_r3.field_78804_l.add(new ModelBox(this.bone_r3, 25, 51, -4.0f, -5.0f, -1.0f, 2, 8, 2, 0.0f, false));
        this.Bulb1 = new ModelRenderer((ModelBase)this);
        this.Bulb1.func_78793_a(6.0f, 26.0f, 0.0f);
        this.Plant.func_78792_a(this.Bulb1);
        this.Bulb1.field_78804_l.add(new ModelBox(this.Bulb1, 34, 53, 2.0f, 4.0f, -2.0f, 4, 4, 4, 0.0f, false));
        this.bone_r4 = new ModelRenderer((ModelBase)this);
        this.bone_r4.func_78793_a(5.0f, 1.0f, 0.0f);
        this.Bulb1.func_78792_a(this.bone_r4);
        this.setRotationAngle(this.bone_r4, 0.0f, 0.0f, -0.7854f);
        this.bone_r4.field_78804_l.add(new ModelBox(this.bone_r4, 51, 52, -2.0f, -5.0f, -1.0f, 4, 8, 1, 0.0f, false));
        this.bone_r4.field_78804_l.add(new ModelBox(this.bone_r4, 25, 51, -4.0f, -5.0f, -1.0f, 2, 8, 2, 0.0f, false));
        this.Orb = new ModelRenderer((ModelBase)this);
        this.Orb.func_78793_a(0.0f, 30.0f, 0.0f);
        this.Plant.func_78792_a(this.Orb);
        this.Orb.field_78804_l.add(new ModelBox(this.Orb, 16, 26, -6.0f, -6.0f, -6.0f, 12, 12, 12, 0.0f, false));
        this.OrbInner = new ModelRenderer((ModelBase)this);
        this.OrbInner.func_78793_a(0.0f, 30.0f, 0.0f);
        this.Plant.func_78792_a(this.OrbInner);
        this.OrbInner.field_78804_l.add(new ModelBox(this.OrbInner, 16, 26, -6.0f, -6.0f, -6.0f, 12, 12, 12, -2.0f, false));
        this.OrbInner2 = new ModelRenderer((ModelBase)this);
        this.OrbInner2.func_78793_a(-3.0f, 27.0f, 3.0f);
        this.Plant.func_78792_a(this.OrbInner2);
        this.OrbInner2.field_78804_l.add(new ModelBox(this.OrbInner2, 0, 51, 0.0f, 0.0f, -6.0f, 6, 6, 6, -1.0f, false));
        this.Body = new ModelRenderer((ModelBase)this);
        this.Body.func_78793_a(0.25f, 12.0f, 0.25f);
        this.Plant.func_78792_a(this.Body);
        this.Body.field_78804_l.add(new ModelBox(this.Body, 0, 0, -0.25f, -12.0f, -6.25f, 1, 24, 12, 0.0f, false));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 28, 0, -6.25f, -12.0f, -0.25f, 12, 24, 1, 0.0f, false));
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.Plant.func_78785_a(f5);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.Plant.field_78795_f = Mth.func_76134_b((float)(ageInTicks * 0.05f)) * (float)Math.PI * 0.1f;
        this.Plant.field_78808_h = Mth.func_76134_b((float)(ageInTicks * 0.03f)) * (float)Math.PI * 0.1f;
    }
}

