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
package xol.lostinfinity.mob.model.labyrinth;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import xol.lostinfinity.mob.entity.labyrinth.EntityStickler;

public class ModelStickler
extends ModelBase {
    private final ModelRenderer Body;
    private final ModelRenderer leg16;
    private final ModelRenderer leg15;
    private final ModelRenderer leg14;
    private final ModelRenderer leg13;
    private final ModelRenderer leg12;
    private final ModelRenderer leg11;
    private final ModelRenderer leg10;
    private final ModelRenderer leg9;
    private final ModelRenderer leg8;
    private final ModelRenderer leg7;
    private final ModelRenderer leg6;
    private final ModelRenderer leg5;
    private final ModelRenderer leg4;
    private final ModelRenderer leg3;
    private final ModelRenderer leg2;
    private final ModelRenderer leg1;
    private final ModelRenderer pustule;
    private List<ModelRenderer> leg_list = new ArrayList<ModelRenderer>();

    public ModelStickler() {
        this.field_78090_t = 64;
        this.field_78089_u = 32;
        this.Body = new ModelRenderer((ModelBase)this);
        this.Body.func_78793_a(0.0f, 16.0f, 0.0f);
        this.Body.field_78804_l.add(new ModelBox(this.Body, 0, 11, -4.0f, 2.0f, -4.0f, 8, 2, 8, 0.0f, false));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 25, 11, 3.5f, 3.0f, -1.0f, 1, 5, 2, 0.0f, false));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 25, 11, -4.5f, 3.0f, -1.0f, 1, 5, 2, 0.0f, false));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 32, 12, -3.5f, 7.0f, -1.0f, 7, 1, 2, 0.0f, false));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 33, 2, -3.0f, -2.0f, -3.0f, 6, 2, 6, 0.0f, false));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 25, 3, -1.0f, 0.0f, -1.0f, 2, 2, 2, 0.0f, false));
        this.leg16 = new ModelRenderer((ModelBase)this);
        this.leg16.func_78793_a(2.5f, -2.0f, -1.5f);
        this.Body.func_78792_a(this.leg16);
        this.leg16.field_78804_l.add(new ModelBox(this.leg16, 33, 2, -0.5f, -3.0f, -0.5f, 1, 4, 1, -0.3f, false));
        this.leg15 = new ModelRenderer((ModelBase)this);
        this.leg15.func_78793_a(2.5f, -2.0f, -0.5f);
        this.Body.func_78792_a(this.leg15);
        this.leg15.field_78804_l.add(new ModelBox(this.leg15, 33, 2, -0.5f, -3.0f, -0.5f, 1, 4, 1, -0.3f, false));
        this.leg14 = new ModelRenderer((ModelBase)this);
        this.leg14.func_78793_a(2.5f, -2.0f, 0.5f);
        this.Body.func_78792_a(this.leg14);
        this.leg14.field_78804_l.add(new ModelBox(this.leg14, 33, 2, -0.5f, -3.0f, -0.5f, 1, 4, 1, -0.3f, false));
        this.leg13 = new ModelRenderer((ModelBase)this);
        this.leg13.func_78793_a(2.5f, -2.0f, 1.5f);
        this.Body.func_78792_a(this.leg13);
        this.leg13.field_78804_l.add(new ModelBox(this.leg13, 33, 2, -0.5f, -3.0f, -0.5f, 1, 4, 1, -0.3f, false));
        this.leg12 = new ModelRenderer((ModelBase)this);
        this.leg12.func_78793_a(-1.5f, -2.0f, 2.5f);
        this.Body.func_78792_a(this.leg12);
        this.leg12.field_78804_l.add(new ModelBox(this.leg12, 33, 2, -0.5f, -3.0f, -0.5f, 1, 4, 1, -0.3f, false));
        this.leg11 = new ModelRenderer((ModelBase)this);
        this.leg11.func_78793_a(-0.5f, -2.0f, 2.5f);
        this.Body.func_78792_a(this.leg11);
        this.leg11.field_78804_l.add(new ModelBox(this.leg11, 33, 2, -0.5f, -3.0f, -0.5f, 1, 4, 1, -0.3f, false));
        this.leg10 = new ModelRenderer((ModelBase)this);
        this.leg10.func_78793_a(0.5f, -2.0f, 2.5f);
        this.Body.func_78792_a(this.leg10);
        this.leg10.field_78804_l.add(new ModelBox(this.leg10, 33, 2, -0.5f, -3.0f, -0.5f, 1, 4, 1, -0.3f, false));
        this.leg9 = new ModelRenderer((ModelBase)this);
        this.leg9.func_78793_a(1.5f, -2.0f, 2.5f);
        this.Body.func_78792_a(this.leg9);
        this.leg9.field_78804_l.add(new ModelBox(this.leg9, 33, 2, -0.5f, -3.0f, -0.5f, 1, 4, 1, -0.3f, false));
        this.leg8 = new ModelRenderer((ModelBase)this);
        this.leg8.func_78793_a(-2.5f, -2.0f, 1.5f);
        this.Body.func_78792_a(this.leg8);
        this.leg8.field_78804_l.add(new ModelBox(this.leg8, 33, 2, -0.5f, -3.0f, -0.5f, 1, 4, 1, -0.3f, false));
        this.leg7 = new ModelRenderer((ModelBase)this);
        this.leg7.func_78793_a(-2.5f, -2.0f, 0.5f);
        this.Body.func_78792_a(this.leg7);
        this.leg7.field_78804_l.add(new ModelBox(this.leg7, 33, 2, -0.5f, -3.0f, -0.5f, 1, 4, 1, -0.3f, false));
        this.leg6 = new ModelRenderer((ModelBase)this);
        this.leg6.func_78793_a(-2.5f, -2.0f, -0.5f);
        this.Body.func_78792_a(this.leg6);
        this.leg6.field_78804_l.add(new ModelBox(this.leg6, 33, 2, -0.5f, -3.0f, -0.5f, 1, 4, 1, -0.3f, false));
        this.leg5 = new ModelRenderer((ModelBase)this);
        this.leg5.func_78793_a(-2.5f, -2.0f, -1.5f);
        this.Body.func_78792_a(this.leg5);
        this.leg5.field_78804_l.add(new ModelBox(this.leg5, 33, 2, -0.5f, -3.0f, -0.5f, 1, 4, 1, -0.3f, false));
        this.leg4 = new ModelRenderer((ModelBase)this);
        this.leg4.func_78793_a(-1.5f, -2.0f, -2.5f);
        this.Body.func_78792_a(this.leg4);
        this.leg4.field_78804_l.add(new ModelBox(this.leg4, 33, 2, -0.5f, -3.0f, -0.5f, 1, 4, 1, -0.3f, false));
        this.leg3 = new ModelRenderer((ModelBase)this);
        this.leg3.func_78793_a(-0.5f, -2.0f, -2.5f);
        this.Body.func_78792_a(this.leg3);
        this.leg3.field_78804_l.add(new ModelBox(this.leg3, 33, 2, -0.5f, -3.0f, -0.5f, 1, 4, 1, -0.3f, false));
        this.leg2 = new ModelRenderer((ModelBase)this);
        this.leg2.func_78793_a(0.5f, -2.0f, -2.5f);
        this.Body.func_78792_a(this.leg2);
        this.leg2.field_78804_l.add(new ModelBox(this.leg2, 33, 2, -0.5f, -3.0f, -0.5f, 1, 4, 1, -0.3f, false));
        this.leg1 = new ModelRenderer((ModelBase)this);
        this.leg1.func_78793_a(1.5f, -2.0f, -2.5f);
        this.Body.func_78792_a(this.leg1);
        this.leg1.field_78804_l.add(new ModelBox(this.leg1, 33, 2, -0.5f, -3.0f, -0.5f, 1, 4, 1, -0.3f, false));
        this.pustule = new ModelRenderer((ModelBase)this);
        this.pustule.func_78793_a(0.0f, 3.0f, 0.0f);
        this.Body.func_78792_a(this.pustule);
        this.pustule.field_78804_l.add(new ModelBox(this.pustule, 0, 0, -3.5f, 1.0f, -3.5f, 7, 3, 7, 0.0f, false));
        this.leg_list.add(this.leg1);
        this.leg_list.add(this.leg2);
        this.leg_list.add(this.leg3);
        this.leg_list.add(this.leg4);
        this.leg_list.add(this.leg5);
        this.leg_list.add(this.leg6);
        this.leg_list.add(this.leg7);
        this.leg_list.add(this.leg8);
        this.leg_list.add(this.leg9);
        this.leg_list.add(this.leg10);
        this.leg_list.add(this.leg11);
        this.leg_list.add(this.leg12);
        this.leg_list.add(this.leg13);
        this.leg_list.add(this.leg14);
        this.leg_list.add(this.leg15);
        this.leg_list.add(this.leg16);
        Collections.shuffle(this.leg_list);
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.Body.func_78785_a(f5);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        for (ModelRenderer tendril : this.leg_list) {
            tendril.field_78795_f = 0.3f * Mth.func_76126_a((float)((ageInTicks + (float)this.leg_list.indexOf(tendril)) * 0.1f));
            tendril.field_78808_h = 0.3f * Mth.func_76126_a((float)((ageInTicks + (float)this.leg_list.indexOf(tendril)) * 0.11f));
        }
        EntityStickler stickler = (EntityStickler)entityIn;
        this.Body.field_78795_f = stickler.getAngry() ? (float)Math.PI : 0.0f;
    }
}

