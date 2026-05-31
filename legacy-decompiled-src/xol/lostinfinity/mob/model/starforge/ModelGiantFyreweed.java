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

public class ModelGiantFyreweed
extends ModelBase {
    private final ModelRenderer root;
    private final ModelRenderer vine1;
    private final ModelRenderer bulb;
    private final ModelRenderer vine2;
    private final ModelRenderer bulb2;
    private final ModelRenderer bulb3;
    private final ModelRenderer bulb4;
    private final ModelRenderer bulb5;
    private final ModelRenderer bulb6;
    private final ModelRenderer sidebulb1;
    private final ModelRenderer sidebulb2;
    private final ModelRenderer sidebulb3;
    private final ModelRenderer sidebulb4;

    public ModelGiantFyreweed() {
        this.field_78090_t = 64;
        this.field_78089_u = 64;
        this.root = new ModelRenderer((ModelBase)this);
        this.root.func_78793_a(0.0f, -2.0f, 0.0f);
        this.vine1 = new ModelRenderer((ModelBase)this);
        this.vine1.func_78793_a(0.0f, -3.0f, 0.0f);
        this.root.func_78792_a(this.vine1);
        this.vine1.field_78804_l.add(new ModelBox(this.vine1, 0, 0, -4.0f, 0.0f, 0.0f, 8, 16, 1, 0.0f, false));
        this.bulb = new ModelRenderer((ModelBase)this);
        this.bulb.func_78793_a(0.0f, -3.0f, 0.0f);
        this.root.func_78792_a(this.bulb);
        this.bulb.field_78804_l.add(new ModelBox(this.bulb, 0, 39, -6.0f, 16.0f, -6.0f, 12, 12, 12, 0.0f, false));
        this.vine2 = new ModelRenderer((ModelBase)this);
        this.vine2.func_78793_a(0.0f, -3.0f, 0.0f);
        this.root.func_78792_a(this.vine2);
        this.vine2.field_78804_l.add(new ModelBox(this.vine2, 43, 0, 0.0f, 0.0f, -4.0f, 1, 16, 8, 0.0f, false));
        this.bulb2 = new ModelRenderer((ModelBase)this);
        this.bulb2.func_78793_a(0.0f, -3.0f, 0.0f);
        this.root.func_78792_a(this.bulb2);
        this.bulb2.field_78804_l.add(new ModelBox(this.bulb2, 10, 17, -5.0f, 17.0f, -5.0f, 10, 10, 10, 0.0f, false));
        this.bulb3 = new ModelRenderer((ModelBase)this);
        this.bulb3.func_78793_a(0.0f, -3.0f, 0.0f);
        this.root.func_78792_a(this.bulb3);
        this.bulb3.field_78804_l.add(new ModelBox(this.bulb3, 0, 39, 3.0f, 14.0f, -6.0f, 3, 2, 3, 0.0f, false));
        this.bulb4 = new ModelRenderer((ModelBase)this);
        this.bulb4.func_78793_a(0.0f, -3.0f, 0.0f);
        this.root.func_78792_a(this.bulb4);
        this.bulb4.field_78804_l.add(new ModelBox(this.bulb4, 0, 39, -6.0f, 14.0f, -6.0f, 3, 2, 3, 0.0f, false));
        this.bulb5 = new ModelRenderer((ModelBase)this);
        this.bulb5.func_78793_a(0.0f, -3.0f, 0.0f);
        this.root.func_78792_a(this.bulb5);
        this.bulb5.field_78804_l.add(new ModelBox(this.bulb5, 0, 39, -6.0f, 14.0f, 3.0f, 3, 2, 3, 0.0f, false));
        this.bulb6 = new ModelRenderer((ModelBase)this);
        this.bulb6.func_78793_a(0.0f, -3.0f, 0.0f);
        this.root.func_78792_a(this.bulb6);
        this.bulb6.field_78804_l.add(new ModelBox(this.bulb6, 0, 39, 3.0f, 14.0f, 3.0f, 3, 2, 3, 0.0f, false));
        this.sidebulb1 = new ModelRenderer((ModelBase)this);
        this.sidebulb1.func_78793_a(3.0f, 0.0f, 0.0f);
        this.root.func_78792_a(this.sidebulb1);
        this.setRotationAngle(this.sidebulb1, 0.0f, 0.0f, -0.6109f);
        this.sidebulb1.field_78804_l.add(new ModelBox(this.sidebulb1, 40, 37, -3.0f, 7.0f, -3.1f, 6, 8, 6, 0.0f, false));
        this.sidebulb1.field_78804_l.add(new ModelBox(this.sidebulb1, 22, 9, -2.0f, 10.0f, -2.1f, 4, 4, 4, 0.0f, false));
        this.sidebulb1.field_78804_l.add(new ModelBox(this.sidebulb1, 43, 0, -1.0f, -3.0f, -4.1f, 1, 10, 8, 0.0f, false));
        this.sidebulb1.field_78804_l.add(new ModelBox(this.sidebulb1, 0, 0, -4.0f, -3.0f, -0.1f, 8, 10, 1, 0.0f, false));
        this.sidebulb2 = new ModelRenderer((ModelBase)this);
        this.sidebulb2.func_78793_a(-3.0f, 0.0f, 0.0f);
        this.root.func_78792_a(this.sidebulb2);
        this.setRotationAngle(this.sidebulb2, 0.0f, 0.0f, 0.6109f);
        this.sidebulb2.field_78804_l.add(new ModelBox(this.sidebulb2, 40, 37, -3.0f, 7.0f, -2.9f, 6, 8, 6, 0.0f, true));
        this.sidebulb2.field_78804_l.add(new ModelBox(this.sidebulb2, 22, 9, -2.0f, 10.0f, -1.9f, 4, 4, 4, 0.0f, true));
        this.sidebulb2.field_78804_l.add(new ModelBox(this.sidebulb2, 43, 0, 0.0f, -3.0f, -3.9f, 1, 10, 8, 0.0f, true));
        this.sidebulb2.field_78804_l.add(new ModelBox(this.sidebulb2, 0, 0, -4.0f, -3.0f, 0.1f, 8, 10, 1, 0.0f, true));
        this.sidebulb3 = new ModelRenderer((ModelBase)this);
        this.sidebulb3.func_78793_a(0.0f, 0.0f, 1.0f);
        this.root.func_78792_a(this.sidebulb3);
        this.setRotationAngle(this.sidebulb3, 0.6109f, 0.0f, 0.0f);
        this.sidebulb3.field_78804_l.add(new ModelBox(this.sidebulb3, 40, 37, -2.9f, 7.0f, -3.0f, 6, 8, 6, 0.0f, true));
        this.sidebulb3.field_78804_l.add(new ModelBox(this.sidebulb3, 22, 1, -1.9f, 10.0f, -2.0f, 4, 4, 4, 0.0f, true));
        this.sidebulb3.field_78804_l.add(new ModelBox(this.sidebulb3, 43, 0, 0.1f, -3.0f, -4.0f, 1, 10, 8, 0.0f, true));
        this.sidebulb3.field_78804_l.add(new ModelBox(this.sidebulb3, 0, 0, -3.9f, -3.0f, 0.0f, 8, 10, 1, 0.0f, true));
        this.sidebulb4 = new ModelRenderer((ModelBase)this);
        this.sidebulb4.func_78793_a(1.0f, 0.0f, -2.0f);
        this.root.func_78792_a(this.sidebulb4);
        this.setRotationAngle(this.sidebulb4, -0.6109f, 0.0f, 0.0f);
        this.sidebulb4.field_78804_l.add(new ModelBox(this.sidebulb4, 40, 37, -3.1f, 7.0f, -3.0f, 6, 8, 6, 0.0f, true));
        this.sidebulb4.field_78804_l.add(new ModelBox(this.sidebulb4, 22, 1, -2.1f, 10.0f, -2.0f, 4, 4, 4, 0.0f, true));
        this.sidebulb4.field_78804_l.add(new ModelBox(this.sidebulb4, 43, 0, -0.1f, -3.0f, -4.0f, 1, 10, 8, 0.0f, true));
        this.sidebulb4.field_78804_l.add(new ModelBox(this.sidebulb4, 0, 0, -4.1f, -3.0f, 0.0f, 8, 10, 1, 0.0f, true));
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.root.func_78785_a(f5);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.root.field_78795_f = Mth.func_76134_b((float)(ageInTicks * 0.05f)) * (float)Math.PI * 0.1f;
        this.root.field_78808_h = Mth.func_76134_b((float)(ageInTicks * 0.03f)) * (float)Math.PI * 0.1f;
        this.sidebulb1.field_78808_h = -0.8109f + 0.2f * Mth.func_76134_b((float)(ageInTicks * 0.1f));
        this.sidebulb2.field_78808_h = 0.8109f + 0.2f * Mth.func_76134_b((float)((ageInTicks + 50.0f) * 0.1f));
        this.sidebulb3.field_78795_f = -0.8109f + 0.2f * Mth.func_76134_b((float)((ageInTicks + 100.0f) * 0.1f));
        this.sidebulb4.field_78795_f = 0.8109f + 0.2f * Mth.func_76134_b((float)((ageInTicks + 150.0f) * 0.1f));
    }
}

