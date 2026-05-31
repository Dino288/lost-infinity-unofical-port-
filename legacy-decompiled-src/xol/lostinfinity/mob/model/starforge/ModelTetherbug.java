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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import xol.lostinfinity.mob.entity.starforge.EntityTetherbug;

public class ModelTetherbug
extends ModelBase {
    private final ModelRenderer Body;
    private final ModelRenderer BackPlate;
    private final ModelRenderer BellyPlate;
    private final ModelRenderer Head;
    private final ModelRenderer Tooth1;
    private final ModelRenderer Tooth2;
    private final ModelRenderer Tooth3;
    private final ModelRenderer Tooth4;
    private final ModelRenderer Tooth5;
    private final ModelRenderer Tooth6;
    private final ModelRenderer Tooth7;
    private final ModelRenderer Tooth8;
    private final ModelRenderer Tooth9;
    private final ModelRenderer Tooth10;
    private final ModelRenderer Tooth11;
    private final ModelRenderer Tooth12;
    private final ModelRenderer Leg2;
    private final ModelRenderer Body_r1;
    private final ModelRenderer Body_r2;
    private final ModelRenderer Leg1;
    private final ModelRenderer Body_r3;
    private final ModelRenderer Body_r4;
    private final ModelRenderer Leg3;
    private final ModelRenderer Body_r5;
    private final ModelRenderer Body_r6;
    private final ModelRenderer Leg4;
    private final ModelRenderer Body_r7;
    private final ModelRenderer Body_r8;
    private List<ModelRenderer> teeth = new ArrayList<ModelRenderer>();

    public ModelTetherbug() {
        this.field_78090_t = 64;
        this.field_78089_u = 64;
        this.Body = new ModelRenderer((ModelBase)this);
        this.Body.func_78793_a(0.25f, 11.25f, 5.75f);
        this.Body.field_78804_l.add(new ModelBox(this.Body, 2, 2, -6.25f, 3.75f, -10.75f, 12, 5, 18, 0.0f, false));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 2, 2, -6.25f, 3.75f, -10.75f, 12, 5, 18, 0.0f, false));
        this.BackPlate = new ModelRenderer((ModelBase)this);
        this.BackPlate.func_78793_a(0.0f, 15.0f, 13.0f);
        this.BackPlate.field_78804_l.add(new ModelBox(this.BackPlate, 0, 29, -6.0f, -2.0f, -12.0f, 12, 2, 12, 0.0f, false));
        this.BackPlate.field_78804_l.add(new ModelBox(this.BackPlate, 0, 31, 3.0f, 0.0f, -11.0f, 2, 2, 2, 0.0f, false));
        this.BackPlate.field_78804_l.add(new ModelBox(this.BackPlate, 0, 31, 3.0f, 0.0f, -7.0f, 2, 2, 2, 0.0f, false));
        this.BackPlate.field_78804_l.add(new ModelBox(this.BackPlate, 0, 31, -5.0f, 0.0f, -11.0f, 2, 2, 2, 0.0f, false));
        this.BackPlate.field_78804_l.add(new ModelBox(this.BackPlate, 0, 31, -5.0f, 0.0f, -7.0f, 2, 2, 2, 0.0f, false));
        this.BackPlate.field_78804_l.add(new ModelBox(this.BackPlate, 0, 31, -1.0f, 0.0f, -11.0f, 2, 2, 2, 0.0f, false));
        this.BellyPlate = new ModelRenderer((ModelBase)this);
        this.BellyPlate.func_78793_a(0.0f, 20.0f, 13.0f);
        this.BellyPlate.field_78804_l.add(new ModelBox(this.BellyPlate, 0, 45, -6.0f, 0.0f, -12.0f, 12, 2, 12, 0.0f, false));
        this.BellyPlate.field_78804_l.add(new ModelBox(this.BellyPlate, 0, 47, 3.0f, -2.0f, -11.0f, 2, 2, 2, 0.0f, false));
        this.BellyPlate.field_78804_l.add(new ModelBox(this.BellyPlate, 0, 47, 3.0f, -2.0f, -7.0f, 2, 2, 2, 0.0f, false));
        this.BellyPlate.field_78804_l.add(new ModelBox(this.BellyPlate, 0, 47, -5.0f, -2.0f, -11.0f, 2, 2, 2, 0.0f, false));
        this.BellyPlate.field_78804_l.add(new ModelBox(this.BellyPlate, 0, 47, -5.0f, -2.0f, -7.0f, 2, 2, 2, 0.0f, false));
        this.BellyPlate.field_78804_l.add(new ModelBox(this.BellyPlate, 0, 47, -1.0f, -2.0f, -11.0f, 2, 2, 2, 0.0f, false));
        this.Head = new ModelRenderer((ModelBase)this);
        this.Head.func_78793_a(0.0f, 14.0f, -10.0f);
        this.Head.field_78804_l.add(new ModelBox(this.Head, 36, 26, -5.0f, -2.0f, 3.0f, 10, 10, 4, 0.0f, false));
        this.Head.field_78804_l.add(new ModelBox(this.Head, 51, 0, -5.0f, -2.0f, 1.0f, 1, 10, 2, 0.0f, true));
        this.Head.field_78804_l.add(new ModelBox(this.Head, 51, 0, 4.0f, -2.0f, 1.0f, 1, 10, 2, 0.0f, false));
        this.Head.field_78804_l.add(new ModelBox(this.Head, 44, 16, -4.0f, 7.0f, 1.0f, 8, 1, 2, 0.0f, false));
        this.Head.field_78804_l.add(new ModelBox(this.Head, 44, 12, -4.0f, -2.0f, 1.0f, 8, 1, 2, 0.0f, false));
        this.Tooth1 = new ModelRenderer((ModelBase)this);
        this.Tooth1.func_78793_a(2.0f, 7.0f, 2.0f);
        this.Head.func_78792_a(this.Tooth1);
        this.Tooth1.field_78804_l.add(new ModelBox(this.Tooth1, 44, 8, -0.5f, -1.5f, -0.5f, 1, 2, 1, 0.0f, false));
        this.Tooth2 = new ModelRenderer((ModelBase)this);
        this.Tooth2.func_78793_a(0.0f, 7.0f, 2.0f);
        this.Head.func_78792_a(this.Tooth2);
        this.Tooth2.field_78804_l.add(new ModelBox(this.Tooth2, 44, 8, -0.5f, -1.5f, -0.5f, 1, 2, 1, 0.0f, false));
        this.Tooth3 = new ModelRenderer((ModelBase)this);
        this.Tooth3.func_78793_a(-2.0f, 7.0f, 2.0f);
        this.Head.func_78792_a(this.Tooth3);
        this.Tooth3.field_78804_l.add(new ModelBox(this.Tooth3, 44, 8, -0.5f, -1.5f, -0.5f, 1, 2, 1, 0.0f, false));
        this.Tooth4 = new ModelRenderer((ModelBase)this);
        this.Tooth4.func_78793_a(-4.0f, 5.0f, 2.0f);
        this.Head.func_78792_a(this.Tooth4);
        this.setRotationAngle(this.Tooth4, 0.0f, 0.0f, 1.5708f);
        this.Tooth4.field_78804_l.add(new ModelBox(this.Tooth4, 44, 8, -0.5f, -1.5f, -0.5f, 1, 2, 1, 0.0f, false));
        this.Tooth5 = new ModelRenderer((ModelBase)this);
        this.Tooth5.func_78793_a(-4.0f, 3.0f, 2.0f);
        this.Head.func_78792_a(this.Tooth5);
        this.setRotationAngle(this.Tooth5, 0.0f, 0.0f, 1.5708f);
        this.Tooth5.field_78804_l.add(new ModelBox(this.Tooth5, 44, 8, -0.5f, -1.5f, -0.5f, 1, 2, 1, 0.0f, false));
        this.Tooth6 = new ModelRenderer((ModelBase)this);
        this.Tooth6.func_78793_a(-4.0f, 1.0f, 2.0f);
        this.Head.func_78792_a(this.Tooth6);
        this.setRotationAngle(this.Tooth6, 0.0f, 0.0f, 1.5708f);
        this.Tooth6.field_78804_l.add(new ModelBox(this.Tooth6, 44, 8, -0.5f, -1.5f, -0.5f, 1, 2, 1, 0.0f, false));
        this.Tooth7 = new ModelRenderer((ModelBase)this);
        this.Tooth7.func_78793_a(-2.0f, -1.0f, 2.0f);
        this.Head.func_78792_a(this.Tooth7);
        this.setRotationAngle(this.Tooth7, 0.0f, 0.0f, -3.1416f);
        this.Tooth7.field_78804_l.add(new ModelBox(this.Tooth7, 44, 8, -0.5f, -1.5f, -0.5f, 1, 2, 1, 0.0f, false));
        this.Tooth8 = new ModelRenderer((ModelBase)this);
        this.Tooth8.func_78793_a(0.0f, -1.0f, 2.0f);
        this.Head.func_78792_a(this.Tooth8);
        this.setRotationAngle(this.Tooth8, 0.0f, 0.0f, -3.1416f);
        this.Tooth8.field_78804_l.add(new ModelBox(this.Tooth8, 44, 8, -0.5f, -1.5f, -0.5f, 1, 2, 1, 0.0f, false));
        this.Tooth9 = new ModelRenderer((ModelBase)this);
        this.Tooth9.func_78793_a(2.0f, -1.0f, 2.0f);
        this.Head.func_78792_a(this.Tooth9);
        this.setRotationAngle(this.Tooth9, 0.0f, 0.0f, -3.1416f);
        this.Tooth9.field_78804_l.add(new ModelBox(this.Tooth9, 44, 8, -0.5f, -1.5f, -0.5f, 1, 2, 1, 0.0f, false));
        this.Tooth10 = new ModelRenderer((ModelBase)this);
        this.Tooth10.func_78793_a(4.0f, 1.0f, 2.0f);
        this.Head.func_78792_a(this.Tooth10);
        this.setRotationAngle(this.Tooth10, 0.0f, 0.0f, -1.5708f);
        this.Tooth10.field_78804_l.add(new ModelBox(this.Tooth10, 44, 8, -0.5f, -1.5f, -0.5f, 1, 2, 1, 0.0f, false));
        this.Tooth11 = new ModelRenderer((ModelBase)this);
        this.Tooth11.func_78793_a(4.0f, 3.0f, 2.0f);
        this.Head.func_78792_a(this.Tooth11);
        this.setRotationAngle(this.Tooth11, 0.0f, 0.0f, -1.5708f);
        this.Tooth11.field_78804_l.add(new ModelBox(this.Tooth11, 44, 8, -0.5f, -1.5f, -0.5f, 1, 2, 1, 0.0f, false));
        this.Tooth12 = new ModelRenderer((ModelBase)this);
        this.Tooth12.func_78793_a(4.0f, 5.0f, 2.0f);
        this.Head.func_78792_a(this.Tooth12);
        this.setRotationAngle(this.Tooth12, 0.0f, 0.0f, -1.5708f);
        this.Tooth12.field_78804_l.add(new ModelBox(this.Tooth12, 44, 8, -0.5f, -1.5f, -0.5f, 1, 2, 1, 0.0f, false));
        this.Leg2 = new ModelRenderer((ModelBase)this);
        this.Leg2.func_78793_a(5.5f, 18.5f, 5.0f);
        this.setRotationAngle(this.Leg2, 0.0f, 0.4363f, 0.0f);
        this.Body_r1 = new ModelRenderer((ModelBase)this);
        this.Body_r1.func_78793_a(3.0f, -1.0f, 0.0f);
        this.Leg2.func_78792_a(this.Body_r1);
        this.setRotationAngle(this.Body_r1, 0.0f, 0.0f, 0.4363f);
        this.Body_r1.field_78804_l.add(new ModelBox(this.Body_r1, 3, 8, 5.5f, -4.5f, -1.0f, 2, 10, 2, 0.0f, false));
        this.Body_r2 = new ModelRenderer((ModelBase)this);
        this.Body_r2.func_78793_a(3.0f, -1.0f, 0.0f);
        this.Leg2.func_78792_a(this.Body_r2);
        this.setRotationAngle(this.Body_r2, 0.0f, 0.0f, -0.2618f);
        this.Body_r2.field_78804_l.add(new ModelBox(this.Body_r2, 40, 46, -4.0f, -1.5f, -1.5f, 9, 2, 3, 0.0f, false));
        this.Body_r2.field_78804_l.add(new ModelBox(this.Body_r2, 13, 8, 5.0f, -4.5f, -0.5f, 1, 3, 1, 0.0f, false));
        this.Body_r2.field_78804_l.add(new ModelBox(this.Body_r2, 13, 8, 3.0f, -4.5f, -0.5f, 1, 3, 1, 0.0f, false));
        this.Body_r2.field_78804_l.add(new ModelBox(this.Body_r2, 13, 8, 7.0f, -4.5f, -0.5f, 1, 3, 1, 0.0f, false));
        this.Body_r2.field_78804_l.add(new ModelBox(this.Body_r2, 3, 1, 5.0f, -1.5f, -1.5f, 4, 3, 3, 0.0f, false));
        this.Leg1 = new ModelRenderer((ModelBase)this);
        this.Leg1.func_78793_a(5.5f, 18.5f, 10.0f);
        this.setRotationAngle(this.Leg1, 0.0f, -0.3491f, 0.0f);
        this.Body_r3 = new ModelRenderer((ModelBase)this);
        this.Body_r3.func_78793_a(3.0f, -1.0f, 0.0f);
        this.Leg1.func_78792_a(this.Body_r3);
        this.setRotationAngle(this.Body_r3, 0.0f, 0.0f, 0.4363f);
        this.Body_r3.field_78804_l.add(new ModelBox(this.Body_r3, 3, 8, 5.5f, -4.5f, -1.0f, 2, 10, 2, 0.0f, false));
        this.Body_r4 = new ModelRenderer((ModelBase)this);
        this.Body_r4.func_78793_a(3.0f, -1.0f, 0.0f);
        this.Leg1.func_78792_a(this.Body_r4);
        this.setRotationAngle(this.Body_r4, 0.0f, 0.0f, -0.2618f);
        this.Body_r4.field_78804_l.add(new ModelBox(this.Body_r4, 40, 46, -4.0f, -1.5f, -1.5f, 9, 2, 3, 0.0f, false));
        this.Body_r4.field_78804_l.add(new ModelBox(this.Body_r4, 13, 8, 5.0f, -4.5f, -0.5f, 1, 3, 1, 0.0f, false));
        this.Body_r4.field_78804_l.add(new ModelBox(this.Body_r4, 13, 8, 3.0f, -4.5f, -0.5f, 1, 3, 1, 0.0f, false));
        this.Body_r4.field_78804_l.add(new ModelBox(this.Body_r4, 13, 8, 7.0f, -4.5f, -0.5f, 1, 3, 1, 0.0f, false));
        this.Body_r4.field_78804_l.add(new ModelBox(this.Body_r4, 3, 1, 5.0f, -1.5f, -1.5f, 4, 3, 3, 0.0f, false));
        this.Leg3 = new ModelRenderer((ModelBase)this);
        this.Leg3.func_78793_a(-5.5f, 18.5f, 10.0f);
        this.setRotationAngle(this.Leg3, 0.0f, 0.3491f, 0.0f);
        this.Body_r5 = new ModelRenderer((ModelBase)this);
        this.Body_r5.func_78793_a(-3.0f, -1.0f, 0.0f);
        this.Leg3.func_78792_a(this.Body_r5);
        this.setRotationAngle(this.Body_r5, 0.0f, 0.0f, -0.4363f);
        this.Body_r5.field_78804_l.add(new ModelBox(this.Body_r5, 3, 8, -7.5f, -4.5f, -1.0f, 2, 10, 2, 0.0f, true));
        this.Body_r6 = new ModelRenderer((ModelBase)this);
        this.Body_r6.func_78793_a(-3.0f, -1.0f, 0.0f);
        this.Leg3.func_78792_a(this.Body_r6);
        this.setRotationAngle(this.Body_r6, 0.0f, 0.0f, 0.2618f);
        this.Body_r6.field_78804_l.add(new ModelBox(this.Body_r6, 40, 46, -5.0f, -1.5f, -1.5f, 9, 2, 3, 0.0f, true));
        this.Body_r6.field_78804_l.add(new ModelBox(this.Body_r6, 13, 8, -6.0f, -4.5f, -0.5f, 1, 3, 1, 0.0f, true));
        this.Body_r6.field_78804_l.add(new ModelBox(this.Body_r6, 13, 8, -4.0f, -4.5f, -0.5f, 1, 3, 1, 0.0f, true));
        this.Body_r6.field_78804_l.add(new ModelBox(this.Body_r6, 13, 8, -8.0f, -4.5f, -0.5f, 1, 3, 1, 0.0f, true));
        this.Body_r6.field_78804_l.add(new ModelBox(this.Body_r6, 3, 1, -9.0f, -1.5f, -1.5f, 4, 3, 3, 0.0f, true));
        this.Leg4 = new ModelRenderer((ModelBase)this);
        this.Leg4.func_78793_a(-5.5f, 18.5f, 5.0f);
        this.setRotationAngle(this.Leg4, 0.0f, -0.4363f, 0.0f);
        this.Body_r7 = new ModelRenderer((ModelBase)this);
        this.Body_r7.func_78793_a(-3.0f, -1.0f, 0.0f);
        this.Leg4.func_78792_a(this.Body_r7);
        this.setRotationAngle(this.Body_r7, 0.0f, 0.0f, -0.4363f);
        this.Body_r7.field_78804_l.add(new ModelBox(this.Body_r7, 3, 8, -7.5f, -4.5f, -1.0f, 2, 10, 2, 0.0f, true));
        this.Body_r8 = new ModelRenderer((ModelBase)this);
        this.Body_r8.func_78793_a(-3.0f, -1.0f, 0.0f);
        this.Leg4.func_78792_a(this.Body_r8);
        this.setRotationAngle(this.Body_r8, 0.0f, 0.0f, 0.2618f);
        this.Body_r8.field_78804_l.add(new ModelBox(this.Body_r8, 40, 46, -5.0f, -1.5f, -1.5f, 9, 2, 3, 0.0f, true));
        this.Body_r8.field_78804_l.add(new ModelBox(this.Body_r8, 13, 8, -6.0f, -4.5f, -0.5f, 1, 3, 1, 0.0f, true));
        this.Body_r8.field_78804_l.add(new ModelBox(this.Body_r8, 13, 8, -4.0f, -4.5f, -0.5f, 1, 3, 1, 0.0f, true));
        this.Body_r8.field_78804_l.add(new ModelBox(this.Body_r8, 13, 8, -8.0f, -4.5f, -0.5f, 1, 3, 1, 0.0f, true));
        this.Body_r8.field_78804_l.add(new ModelBox(this.Body_r8, 3, 1, -9.0f, -1.5f, -1.5f, 4, 3, 3, 0.0f, true));
        this.teeth.add(this.Tooth1);
        this.teeth.add(this.Tooth2);
        this.teeth.add(this.Tooth3);
        this.teeth.add(this.Tooth4);
        this.teeth.add(this.Tooth5);
        this.teeth.add(this.Tooth6);
        this.teeth.add(this.Tooth7);
        this.teeth.add(this.Tooth8);
        this.teeth.add(this.Tooth9);
        this.teeth.add(this.Tooth10);
        this.teeth.add(this.Tooth11);
        this.teeth.add(this.Tooth12);
        Collections.shuffle(this.teeth);
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.Body.func_78785_a(f5);
        this.BackPlate.func_78785_a(f5);
        this.BellyPlate.func_78785_a(f5);
        this.Head.func_78785_a(f5);
        this.Leg2.func_78785_a(f5);
        this.Leg1.func_78785_a(f5);
        this.Leg3.func_78785_a(f5);
        this.Leg4.func_78785_a(f5);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        for (int i = 0; i < this.teeth.size(); ++i) {
            ModelRenderer tooth = this.teeth.get(i);
            tooth.field_78795_f = 0.4f * Mth.func_76126_a((float)((ageInTicks + (float)(i * 5)) * 0.3f));
        }
        EntityTetherbug entity = (EntityTetherbug)entityIn;
        if (entity.getAngry()) {
            this.Leg1.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f + (float)Math.PI)) * 1.4f * limbSwingAmount * 0.5f;
            this.Leg1.field_78808_h = 0.5f * Mth.func_76134_b((float)(limbSwing * 0.6662f + (float)Math.PI)) * 1.4f * limbSwingAmount * 0.5f;
            this.Leg2.field_78795_f = Mth.func_76126_a((float)(limbSwing * 0.6662f + (float)Math.PI)) * 1.4f * limbSwingAmount * 0.5f;
            this.Leg2.field_78808_h = 0.5f * Mth.func_76126_a((float)(limbSwing * 0.6662f + (float)Math.PI)) * 1.4f * limbSwingAmount * 0.5f;
            this.Leg3.field_78795_f = this.Leg1.field_78795_f;
            this.Leg3.field_78808_h = -this.Leg1.field_78808_h;
            this.Leg4.field_78795_f = this.Leg2.field_78795_f;
            this.Leg4.field_78808_h = -this.Leg2.field_78808_h;
            this.BackPlate.field_78795_f = -0.3f + 0.3f * Mth.func_76126_a((float)(ageInTicks * 0.1f));
            this.BellyPlate.field_78795_f = -this.BackPlate.field_78795_f * 0.5f;
        } else {
            this.Leg1.field_78795_f = (float)Math.PI;
            this.Leg2.field_78795_f = (float)Math.PI;
            this.Leg3.field_78795_f = (float)Math.PI;
            this.Leg4.field_78795_f = (float)Math.PI;
            this.BackPlate.field_78795_f = 0.0f;
            this.BellyPlate.field_78795_f = 0.0f;
        }
    }
}

