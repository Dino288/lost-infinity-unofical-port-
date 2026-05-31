/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.model.ModelBox
 *  net.minecraft.client.model.ModelRenderer
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.entity.Entity
 */
package xol.lostinfinity.mob.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.world.entity.Entity;

public class ModelTotem
extends ModelBase {
    private final ModelRenderer OrbInner;
    private final ModelRenderer Orb;
    private final ModelRenderer Body;
    private final ModelRenderer bone_r1;
    private final ModelRenderer bone_r2;
    private final ModelRenderer bone_r3;
    private final ModelRenderer bone_r4;
    private final ModelRenderer OrbRing;

    public ModelTotem() {
        this.field_78090_t = 64;
        this.field_78089_u = 64;
        this.OrbInner = new ModelRenderer((ModelBase)this);
        this.OrbInner.func_78793_a(0.0f, 2.0f, 0.0f);
        this.OrbInner.field_78804_l.add(new ModelBox(this.OrbInner, 32, 24, -6.0f, -2.0f, -2.0f, 12, 4, 4, 0.0f, false));
        this.OrbInner.field_78804_l.add(new ModelBox(this.OrbInner, 52, 33, 4.0f, -2.5f, -2.5f, 1, 5, 5, 0.0f, false));
        this.OrbInner.field_78804_l.add(new ModelBox(this.OrbInner, 52, 33, 2.0f, -2.5f, -2.5f, 1, 5, 5, 0.0f, false));
        this.OrbInner.field_78804_l.add(new ModelBox(this.OrbInner, 52, 33, 0.0f, -2.5f, -2.5f, 1, 5, 5, 0.0f, false));
        this.OrbInner.field_78804_l.add(new ModelBox(this.OrbInner, 52, 33, -2.0f, -2.5f, -2.5f, 1, 5, 5, 0.0f, false));
        this.Orb = new ModelRenderer((ModelBase)this);
        this.Orb.func_78793_a(0.0f, 2.0f, 0.0f);
        this.Orb.field_78804_l.add(new ModelBox(this.Orb, 16, 40, -6.0f, -6.0f, -6.0f, 12, 12, 12, 0.0f, false));
        this.Body = new ModelRenderer((ModelBase)this);
        this.Body.func_78793_a(0.0f, 19.0f, 1.0f);
        this.Body.field_78804_l.add(new ModelBox(this.Body, 1, 0, -3.0f, -11.0f, -4.0f, 6, 16, 6, 0.0f, false));
        this.bone_r1 = new ModelRenderer((ModelBase)this);
        this.bone_r1.func_78793_a(6.5f, -11.0f, -1.0f);
        this.Body.func_78792_a(this.bone_r1);
        this.setRotationAngle(this.bone_r1, 0.0f, 0.0f, -0.4363f);
        this.bone_r1.field_78804_l.add(new ModelBox(this.bone_r1, 41, 0, -4.5f, -1.0f, -3.0f, 1, 17, 6, -0.1f, true));
        this.bone_r2 = new ModelRenderer((ModelBase)this);
        this.bone_r2.func_78793_a(0.0f, -10.5f, 2.5f);
        this.Body.func_78792_a(this.bone_r2);
        this.setRotationAngle(this.bone_r2, 0.4363f, 0.0f, 0.0f);
        this.bone_r2.field_78804_l.add(new ModelBox(this.bone_r2, 26, 4, -3.0f, 0.5f, -1.5f, 6, 17, 1, -0.1f, false));
        this.bone_r3 = new ModelRenderer((ModelBase)this);
        this.bone_r3.func_78793_a(0.0f, -10.5f, -4.5f);
        this.Body.func_78792_a(this.bone_r3);
        this.setRotationAngle(this.bone_r3, -0.4363f, 0.0f, 0.0f);
        this.bone_r3.field_78804_l.add(new ModelBox(this.bone_r3, 26, 4, -3.0f, 0.5f, 0.5f, 6, 17, 1, -0.1f, false));
        this.bone_r4 = new ModelRenderer((ModelBase)this);
        this.bone_r4.func_78793_a(-6.5f, -11.0f, -1.0f);
        this.Body.func_78792_a(this.bone_r4);
        this.setRotationAngle(this.bone_r4, 0.0f, 0.0f, 0.4363f);
        this.bone_r4.field_78804_l.add(new ModelBox(this.bone_r4, 41, 0, 3.5f, -1.0f, -3.0f, 1, 17, 6, -0.1f, false));
        this.OrbRing = new ModelRenderer((ModelBase)this);
        this.OrbRing.func_78793_a(0.0f, 0.0f, 0.0f);
        this.OrbRing.field_78804_l.add(new ModelBox(this.OrbRing, 18, 29, -12.0f, 4.0f, -4.0f, 2, 2, 8, 0.0f, false));
        this.OrbRing.field_78804_l.add(new ModelBox(this.OrbRing, 0, 36, 10.0f, -2.0f, -4.0f, 2, 8, 8, 0.0f, false));
        this.OrbRing.field_78804_l.add(new ModelBox(this.OrbRing, 0, 23, 9.0f, -1.0f, -3.0f, 4, 6, 6, 0.0f, false));
        this.OrbRing.field_78804_l.add(new ModelBox(this.OrbRing, 56, 10, -12.0f, 0.0f, -3.0f, 2, 4, 2, 0.0f, false));
        this.OrbRing.field_78804_l.add(new ModelBox(this.OrbRing, 56, 0, -12.0f, -2.0f, 1.0f, 2, 6, 2, 0.0f, false));
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.OrbInner.func_78785_a(f5);
        GlStateManager.func_179147_l();
        GlStateManager.func_179112_b((int)770, (int)771);
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)0.5f);
        this.Orb.func_78785_a(f5);
        GlStateManager.func_179084_k();
        this.Body.func_78785_a(f5);
        this.OrbRing.func_78785_a(f5);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.OrbInner.field_78796_g = this.Orb.field_78796_g = ageInTicks * 0.05f;
        this.OrbRing.field_78796_g = ageInTicks * 0.2f;
    }
}

