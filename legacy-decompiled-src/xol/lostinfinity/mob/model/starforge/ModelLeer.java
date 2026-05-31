/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.model.ModelBox
 *  net.minecraft.client.model.ModelRenderer
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.math.Mth
 */
package xol.lostinfinity.mob.model.starforge;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import xol.lostinfinity.mob.entity.starforge.EntityLeer;

public class ModelLeer
extends ModelBase {
    private final ModelRenderer Body;
    private final ModelRenderer cube_r1;
    private final ModelRenderer ArmLeft1;
    private final ModelRenderer cube_r2;
    private final ModelRenderer ArmLeft2;
    private final ModelRenderer cube_r3;
    private final ModelRenderer ArmRight1;
    private final ModelRenderer cube_r4;
    private final ModelRenderer ArmRight2;
    private final ModelRenderer cube_r5;
    private final ModelRenderer Tendril1;
    private final ModelRenderer Tendril2;
    private final ModelRenderer Tendril3;
    private final ModelRenderer Tendril4;
    private List<ModelRenderer> tendrils = new ArrayList<ModelRenderer>();

    public ModelLeer() {
        this.field_78090_t = 64;
        this.field_78089_u = 32;
        this.Body = new ModelRenderer((ModelBase)this);
        this.Body.func_78793_a(0.0f, 7.0f, 0.0f);
        this.Body.field_78804_l.add(new ModelBox(this.Body, 0, 0, -5.0f, -8.0f, 0.0f, 10, 14, 4, 0.0f, false));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 28, 17, -3.0f, -8.0f, 4.0f, 6, 14, 1, 0.0f, false));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 44, 12, 3.0f, 4.0f, 2.0f, 3, 1, 3, 0.0f, false));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 44, 12, 3.0f, 0.0f, 2.0f, 3, 1, 3, 0.0f, false));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 44, 12, 3.0f, -4.0f, 2.0f, 3, 1, 3, 0.0f, false));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 44, 12, -6.0f, -4.0f, 2.0f, 3, 1, 3, 0.0f, true));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 44, 12, -6.0f, 0.0f, 2.0f, 3, 1, 3, 0.0f, true));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 44, 12, -6.0f, 4.0f, 2.0f, 3, 1, 3, 0.0f, true));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 38, 0, -4.0f, -9.0f, -4.0f, 2, 2, 8, 0.0f, false));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 38, 0, 2.0f, -9.0f, -4.0f, 2, 2, 8, 0.0f, false));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 29, 0, 1.0f, -10.0f, -6.0f, 4, 4, 2, 0.0f, false));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 29, 0, -5.0f, -10.0f, -6.0f, 4, 4, 2, 0.0f, true));
        this.cube_r1 = new ModelRenderer((ModelBase)this);
        this.cube_r1.func_78793_a(0.0f, 11.0f, 0.5f);
        this.Body.func_78792_a(this.cube_r1);
        this.setRotationAngle(this.cube_r1, -0.3491f, 0.0f, 0.0f);
        this.cube_r1.field_78804_l.add(new ModelBox(this.cube_r1, 42, 17, -5.0f, -7.0f, -0.5f, 10, 14, 1, -0.1f, false));
        this.ArmLeft1 = new ModelRenderer((ModelBase)this);
        this.ArmLeft1.func_78793_a(5.0f, 9.5f, 2.0f);
        this.setRotationAngle(this.ArmLeft1, 0.0f, 0.6109f, 0.0f);
        this.ArmLeft1.field_78804_l.add(new ModelBox(this.ArmLeft1, 0, 19, -1.0f, -1.5f, -1.5f, 8, 3, 3, 0.0f, false));
        this.cube_r2 = new ModelRenderer((ModelBase)this);
        this.cube_r2.func_78793_a(8.5f, 0.5f, -0.5f);
        this.ArmLeft1.func_78792_a(this.cube_r2);
        this.setRotationAngle(this.cube_r2, 0.0f, 0.3491f, 0.0f);
        this.cube_r2.field_78804_l.add(new ModelBox(this.cube_r2, 30, 12, 0.5f, -2.5f, 0.0f, 5, 1, 1, 0.0f, false));
        this.cube_r2.field_78804_l.add(new ModelBox(this.cube_r2, 30, 12, 0.5f, 0.5f, 0.0f, 5, 1, 1, 0.0f, false));
        this.cube_r2.field_78804_l.add(new ModelBox(this.cube_r2, 0, 28, -2.5f, -1.5f, -1.0f, 5, 2, 2, 0.0f, false));
        this.ArmLeft2 = new ModelRenderer((ModelBase)this);
        this.ArmLeft2.func_78793_a(5.0f, 5.5f, 2.0f);
        this.ArmLeft2.field_78804_l.add(new ModelBox(this.ArmLeft2, 0, 19, -1.0f, -1.5f, -1.5f, 8, 3, 3, 0.0f, false));
        this.cube_r3 = new ModelRenderer((ModelBase)this);
        this.cube_r3.func_78793_a(8.5f, 0.5f, -0.5f);
        this.ArmLeft2.func_78792_a(this.cube_r3);
        this.setRotationAngle(this.cube_r3, 0.0f, 0.3491f, 0.0f);
        this.cube_r3.field_78804_l.add(new ModelBox(this.cube_r3, 30, 12, 0.5f, -2.5f, 0.0f, 5, 1, 1, 0.0f, false));
        this.cube_r3.field_78804_l.add(new ModelBox(this.cube_r3, 30, 12, 0.5f, 0.5f, 0.0f, 5, 1, 1, 0.0f, false));
        this.cube_r3.field_78804_l.add(new ModelBox(this.cube_r3, 0, 28, -2.5f, -1.5f, -1.0f, 5, 2, 2, 0.0f, false));
        this.ArmRight1 = new ModelRenderer((ModelBase)this);
        this.ArmRight1.func_78793_a(-5.0f, 9.5f, 2.0f);
        this.setRotationAngle(this.ArmRight1, 0.0f, -0.6109f, 0.0f);
        this.ArmRight1.field_78804_l.add(new ModelBox(this.ArmRight1, 0, 19, -7.0f, -1.5f, -1.5f, 8, 3, 3, 0.0f, true));
        this.cube_r4 = new ModelRenderer((ModelBase)this);
        this.cube_r4.func_78793_a(-8.5f, 0.5f, -0.5f);
        this.ArmRight1.func_78792_a(this.cube_r4);
        this.setRotationAngle(this.cube_r4, 0.0f, -0.3491f, 0.0f);
        this.cube_r4.field_78804_l.add(new ModelBox(this.cube_r4, 30, 12, -5.5f, -2.5f, 0.0f, 5, 1, 1, 0.0f, true));
        this.cube_r4.field_78804_l.add(new ModelBox(this.cube_r4, 30, 12, -5.5f, 0.5f, 0.0f, 5, 1, 1, 0.0f, true));
        this.cube_r4.field_78804_l.add(new ModelBox(this.cube_r4, 0, 28, -2.5f, -1.5f, -1.0f, 5, 2, 2, 0.0f, true));
        this.ArmRight2 = new ModelRenderer((ModelBase)this);
        this.ArmRight2.func_78793_a(-5.0f, 5.5f, 2.0f);
        this.ArmRight2.field_78804_l.add(new ModelBox(this.ArmRight2, 0, 19, -7.0f, -1.5f, -1.5f, 8, 3, 3, 0.0f, true));
        this.cube_r5 = new ModelRenderer((ModelBase)this);
        this.cube_r5.func_78793_a(-8.5f, 0.5f, -0.5f);
        this.ArmRight2.func_78792_a(this.cube_r5);
        this.setRotationAngle(this.cube_r5, 0.0f, -0.3491f, 0.0f);
        this.cube_r5.field_78804_l.add(new ModelBox(this.cube_r5, 30, 12, -5.5f, -2.5f, 0.0f, 5, 1, 1, 0.0f, true));
        this.cube_r5.field_78804_l.add(new ModelBox(this.cube_r5, 30, 12, -5.5f, 0.5f, 0.0f, 5, 1, 1, 0.0f, true));
        this.cube_r5.field_78804_l.add(new ModelBox(this.cube_r5, 0, 28, -2.5f, -1.5f, -1.0f, 5, 2, 2, 0.0f, true));
        this.Tendril1 = new ModelRenderer((ModelBase)this);
        this.Tendril1.func_78793_a(-4.5f, 1.0f, -4.5f);
        this.Tendril1.field_78804_l.add(new ModelBox(this.Tendril1, 59, 2, -0.5f, 0.0f, -0.5f, 1, 6, 1, 0.0f, true));
        this.Tendril2 = new ModelRenderer((ModelBase)this);
        this.Tendril2.func_78793_a(-1.5f, 1.0f, -4.5f);
        this.Tendril2.field_78804_l.add(new ModelBox(this.Tendril2, 59, 2, -0.5f, 0.0f, -0.5f, 1, 6, 1, 0.0f, true));
        this.Tendril3 = new ModelRenderer((ModelBase)this);
        this.Tendril3.func_78793_a(1.5f, 1.0f, -4.5f);
        this.Tendril3.field_78804_l.add(new ModelBox(this.Tendril3, 59, 2, -0.5f, 0.0f, -0.5f, 1, 6, 1, 0.0f, true));
        this.Tendril4 = new ModelRenderer((ModelBase)this);
        this.Tendril4.func_78793_a(4.5f, 1.0f, -4.5f);
        this.Tendril4.field_78804_l.add(new ModelBox(this.Tendril4, 59, 2, -0.5f, 0.0f, -0.5f, 1, 6, 1, 0.0f, true));
        this.tendrils.add(this.Tendril1);
        this.tendrils.add(this.Tendril2);
        this.tendrils.add(this.Tendril3);
        this.tendrils.add(this.Tendril4);
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        EntityLeer leer = (EntityLeer)entity;
        float renderAlph = leer.getAlpha();
        GlStateManager.func_179147_l();
        GlStateManager.func_179112_b((int)770, (int)771);
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)renderAlph);
        this.Body.func_78785_a(f5);
        this.ArmLeft1.func_78785_a(f5);
        this.ArmLeft2.func_78785_a(f5);
        this.ArmRight1.func_78785_a(f5);
        this.ArmRight2.func_78785_a(f5);
        this.Tendril1.func_78785_a(f5);
        this.Tendril2.func_78785_a(f5);
        this.Tendril3.func_78785_a(f5);
        this.Tendril4.func_78785_a(f5);
        GlStateManager.func_179084_k();
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        for (ModelRenderer tend : this.tendrils) {
            tend.field_78795_f = 0.3f * Mth.func_76126_a((float)((ageInTicks + (float)(this.tendrils.indexOf(tend) * 10)) * 0.1f));
        }
        this.ArmLeft1.field_78796_g = 1.2f + 0.5f * Mth.func_76126_a((float)(ageInTicks * 0.1f));
        this.ArmLeft2.field_78796_g = 1.2f - 0.5f * Mth.func_76126_a((float)(ageInTicks * 0.1f));
        this.ArmRight1.field_78796_g = -this.ArmLeft1.field_78796_g;
        this.ArmRight2.field_78796_g = -this.ArmLeft2.field_78796_g;
    }
}

