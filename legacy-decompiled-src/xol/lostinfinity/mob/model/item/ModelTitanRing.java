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
package xol.lostinfinity.mob.model.item;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.world.entity.Entity;
import xol.lostinfinity.projectile.entity.EntityTitanRing;

public class ModelTitanRing
extends ModelBase {
    private final ModelRenderer Ring;
    private final ModelRenderer RingPiece1;
    private final ModelRenderer cube_r1;
    private final ModelRenderer RingPiece2;
    private final ModelRenderer cube_r2;
    private final ModelRenderer RingPiece3;
    private final ModelRenderer cube_r3;
    private final ModelRenderer RingPiece4;
    private final ModelRenderer cube_r4;

    public ModelTitanRing() {
        this.field_78090_t = 64;
        this.field_78089_u = 64;
        this.Ring = new ModelRenderer((ModelBase)this);
        this.Ring.func_78793_a(0.0f, 18.0f, 0.0f);
        this.setRotationAngle(this.Ring, 0.0f, 0.0f, -3.1416f);
        this.RingPiece1 = new ModelRenderer((ModelBase)this);
        this.RingPiece1.func_78793_a(0.0f, 0.0f, 0.0f);
        this.Ring.func_78792_a(this.RingPiece1);
        this.RingPiece1.field_78804_l.add(new ModelBox(this.RingPiece1, 0, 0, -8.0f, -3.0f, 12.0f, 16, 3, 4, 0.0f, false));
        this.RingPiece1.field_78804_l.add(new ModelBox(this.RingPiece1, 0, 9, 4.0f, -6.0f, 12.5f, 3, 3, 3, 0.0f, false));
        this.RingPiece1.field_78804_l.add(new ModelBox(this.RingPiece1, 0, 9, -7.0f, -6.0f, 12.5f, 3, 3, 3, 0.0f, false));
        this.RingPiece1.field_78804_l.add(new ModelBox(this.RingPiece1, 10, 8, -4.0f, -5.0f, 13.0f, 8, 1, 2, 0.0f, false));
        this.RingPiece1.field_78804_l.add(new ModelBox(this.RingPiece1, 50, 0, 4.0f, -2.0f, 16.0f, 2, 2, 2, 0.0f, false));
        this.RingPiece1.field_78804_l.add(new ModelBox(this.RingPiece1, 50, 0, -6.0f, -2.0f, 16.0f, 2, 2, 2, 0.0f, false));
        this.RingPiece1.field_78804_l.add(new ModelBox(this.RingPiece1, 57, 3, -5.5f, -1.5f, 18.0f, 1, 1, 2, 0.0f, false));
        this.RingPiece1.field_78804_l.add(new ModelBox(this.RingPiece1, 57, 3, -0.5f, -1.5f, 20.0f, 1, 1, 2, 0.0f, false));
        this.RingPiece1.field_78804_l.add(new ModelBox(this.RingPiece1, 57, 3, 4.5f, -1.5f, 18.0f, 1, 1, 2, 0.0f, false));
        this.RingPiece1.field_78804_l.add(new ModelBox(this.RingPiece1, 41, 1, -1.0f, -2.0f, 16.0f, 2, 2, 4, 0.0f, false));
        this.cube_r1 = new ModelRenderer((ModelBase)this);
        this.cube_r1.func_78793_a(0.0f, -1.5f, 14.0f);
        this.RingPiece1.func_78792_a(this.cube_r1);
        this.setRotationAngle(this.cube_r1, 0.0f, -0.7854f, 0.0f);
        this.cube_r1.field_78804_l.add(new ModelBox(this.cube_r1, 0, 16, -16.0f, -1.0f, 2.5f, 12, 2, 4, 0.0f, false));
        this.cube_r1.field_78804_l.add(new ModelBox(this.cube_r1, 29, 11, -13.0f, -1.5f, 2.0f, 1, 3, 5, 0.0f, false));
        this.cube_r1.field_78804_l.add(new ModelBox(this.cube_r1, 29, 11, -8.0f, -1.5f, 2.0f, 1, 3, 5, 0.0f, false));
        this.RingPiece2 = new ModelRenderer((ModelBase)this);
        this.RingPiece2.func_78793_a(0.0f, 0.0f, 0.0f);
        this.Ring.func_78792_a(this.RingPiece2);
        this.setRotationAngle(this.RingPiece2, 0.0f, -1.5708f, 0.0f);
        this.RingPiece2.field_78804_l.add(new ModelBox(this.RingPiece2, 0, 0, -8.0f, -3.0f, 12.0f, 16, 3, 4, 0.0f, false));
        this.RingPiece2.field_78804_l.add(new ModelBox(this.RingPiece2, 0, 9, 4.0f, -6.0f, 12.5f, 3, 3, 3, 0.0f, false));
        this.RingPiece2.field_78804_l.add(new ModelBox(this.RingPiece2, 0, 9, -7.0f, -6.0f, 12.5f, 3, 3, 3, 0.0f, false));
        this.RingPiece2.field_78804_l.add(new ModelBox(this.RingPiece2, 10, 8, -4.0f, -5.0f, 13.0f, 8, 1, 2, 0.0f, false));
        this.RingPiece2.field_78804_l.add(new ModelBox(this.RingPiece2, 50, 0, 4.0f, -2.0f, 16.0f, 2, 2, 2, 0.0f, false));
        this.RingPiece2.field_78804_l.add(new ModelBox(this.RingPiece2, 50, 0, -6.0f, -2.0f, 16.0f, 2, 2, 2, 0.0f, false));
        this.RingPiece2.field_78804_l.add(new ModelBox(this.RingPiece2, 57, 3, -5.5f, -1.5f, 18.0f, 1, 1, 2, 0.0f, false));
        this.RingPiece2.field_78804_l.add(new ModelBox(this.RingPiece2, 57, 3, -0.5f, -1.5f, 20.0f, 1, 1, 2, 0.0f, false));
        this.RingPiece2.field_78804_l.add(new ModelBox(this.RingPiece2, 57, 3, 4.5f, -1.5f, 18.0f, 1, 1, 2, 0.0f, false));
        this.RingPiece2.field_78804_l.add(new ModelBox(this.RingPiece2, 41, 1, -1.0f, -2.0f, 16.0f, 2, 2, 4, 0.0f, false));
        this.cube_r2 = new ModelRenderer((ModelBase)this);
        this.cube_r2.func_78793_a(0.0f, -1.5f, 14.0f);
        this.RingPiece2.func_78792_a(this.cube_r2);
        this.setRotationAngle(this.cube_r2, 0.0f, -0.7854f, 0.0f);
        this.cube_r2.field_78804_l.add(new ModelBox(this.cube_r2, 0, 16, -16.0f, -1.0f, 2.5f, 12, 2, 4, 0.0f, false));
        this.cube_r2.field_78804_l.add(new ModelBox(this.cube_r2, 29, 11, -13.0f, -1.5f, 2.0f, 1, 3, 5, 0.0f, false));
        this.cube_r2.field_78804_l.add(new ModelBox(this.cube_r2, 29, 11, -8.0f, -1.5f, 2.0f, 1, 3, 5, 0.0f, false));
        this.RingPiece3 = new ModelRenderer((ModelBase)this);
        this.RingPiece3.func_78793_a(0.0f, 0.0f, 0.0f);
        this.Ring.func_78792_a(this.RingPiece3);
        this.setRotationAngle(this.RingPiece3, 0.0f, 3.1416f, 0.0f);
        this.RingPiece3.field_78804_l.add(new ModelBox(this.RingPiece3, 0, 0, -8.0f, -3.0f, 12.0f, 16, 3, 4, 0.0f, false));
        this.RingPiece3.field_78804_l.add(new ModelBox(this.RingPiece3, 0, 9, 4.0f, -6.0f, 12.5f, 3, 3, 3, 0.0f, false));
        this.RingPiece3.field_78804_l.add(new ModelBox(this.RingPiece3, 0, 9, -7.0f, -6.0f, 12.5f, 3, 3, 3, 0.0f, false));
        this.RingPiece3.field_78804_l.add(new ModelBox(this.RingPiece3, 10, 8, -4.0f, -5.0f, 13.0f, 8, 1, 2, 0.0f, false));
        this.RingPiece3.field_78804_l.add(new ModelBox(this.RingPiece3, 50, 0, 4.0f, -2.0f, 16.0f, 2, 2, 2, 0.0f, false));
        this.RingPiece3.field_78804_l.add(new ModelBox(this.RingPiece3, 50, 0, -6.0f, -2.0f, 16.0f, 2, 2, 2, 0.0f, false));
        this.RingPiece3.field_78804_l.add(new ModelBox(this.RingPiece3, 57, 3, -5.5f, -1.5f, 18.0f, 1, 1, 2, 0.0f, false));
        this.RingPiece3.field_78804_l.add(new ModelBox(this.RingPiece3, 57, 3, -0.5f, -1.5f, 20.0f, 1, 1, 2, 0.0f, false));
        this.RingPiece3.field_78804_l.add(new ModelBox(this.RingPiece3, 57, 3, 4.5f, -1.5f, 18.0f, 1, 1, 2, 0.0f, false));
        this.RingPiece3.field_78804_l.add(new ModelBox(this.RingPiece3, 41, 1, -1.0f, -2.0f, 16.0f, 2, 2, 4, 0.0f, false));
        this.cube_r3 = new ModelRenderer((ModelBase)this);
        this.cube_r3.func_78793_a(0.0f, -1.5f, 14.0f);
        this.RingPiece3.func_78792_a(this.cube_r3);
        this.setRotationAngle(this.cube_r3, 0.0f, -0.7854f, 0.0f);
        this.cube_r3.field_78804_l.add(new ModelBox(this.cube_r3, 0, 16, -16.0f, -1.0f, 2.5f, 12, 2, 4, 0.0f, false));
        this.cube_r3.field_78804_l.add(new ModelBox(this.cube_r3, 29, 11, -13.0f, -1.5f, 2.0f, 1, 3, 5, 0.0f, false));
        this.cube_r3.field_78804_l.add(new ModelBox(this.cube_r3, 29, 11, -8.0f, -1.5f, 2.0f, 1, 3, 5, 0.0f, false));
        this.RingPiece4 = new ModelRenderer((ModelBase)this);
        this.RingPiece4.func_78793_a(0.0f, 0.0f, 0.0f);
        this.Ring.func_78792_a(this.RingPiece4);
        this.setRotationAngle(this.RingPiece4, 0.0f, 1.5708f, 0.0f);
        this.RingPiece4.field_78804_l.add(new ModelBox(this.RingPiece4, 0, 0, -8.0f, -3.0f, 12.0f, 16, 3, 4, 0.0f, false));
        this.RingPiece4.field_78804_l.add(new ModelBox(this.RingPiece4, 0, 9, 4.0f, -6.0f, 12.5f, 3, 3, 3, 0.0f, false));
        this.RingPiece4.field_78804_l.add(new ModelBox(this.RingPiece4, 0, 9, -7.0f, -6.0f, 12.5f, 3, 3, 3, 0.0f, false));
        this.RingPiece4.field_78804_l.add(new ModelBox(this.RingPiece4, 10, 8, -4.0f, -5.0f, 13.0f, 8, 1, 2, 0.0f, false));
        this.RingPiece4.field_78804_l.add(new ModelBox(this.RingPiece4, 50, 0, 4.0f, -2.0f, 16.0f, 2, 2, 2, 0.0f, false));
        this.RingPiece4.field_78804_l.add(new ModelBox(this.RingPiece4, 50, 0, -6.0f, -2.0f, 16.0f, 2, 2, 2, 0.0f, false));
        this.RingPiece4.field_78804_l.add(new ModelBox(this.RingPiece4, 57, 3, -5.5f, -1.5f, 18.0f, 1, 1, 2, 0.0f, false));
        this.RingPiece4.field_78804_l.add(new ModelBox(this.RingPiece4, 57, 3, -0.5f, -1.5f, 20.0f, 1, 1, 2, 0.0f, false));
        this.RingPiece4.field_78804_l.add(new ModelBox(this.RingPiece4, 57, 3, 4.5f, -1.5f, 18.0f, 1, 1, 2, 0.0f, false));
        this.RingPiece4.field_78804_l.add(new ModelBox(this.RingPiece4, 41, 1, -1.0f, -2.0f, 16.0f, 2, 2, 4, 0.0f, false));
        this.cube_r4 = new ModelRenderer((ModelBase)this);
        this.cube_r4.func_78793_a(0.0f, -1.5f, 14.0f);
        this.RingPiece4.func_78792_a(this.cube_r4);
        this.setRotationAngle(this.cube_r4, 0.0f, -0.7854f, 0.0f);
        this.cube_r4.field_78804_l.add(new ModelBox(this.cube_r4, 0, 16, -16.0f, -1.0f, 2.5f, 12, 2, 4, 0.0f, false));
        this.cube_r4.field_78804_l.add(new ModelBox(this.cube_r4, 29, 11, -13.0f, -1.5f, 2.0f, 1, 3, 5, 0.0f, false));
        this.cube_r4.field_78804_l.add(new ModelBox(this.cube_r4, 29, 11, -8.0f, -1.5f, 2.0f, 1, 3, 5, 0.0f, false));
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        EntityTitanRing ring = (EntityTitanRing)entity;
        GlStateManager.func_179147_l();
        GlStateManager.func_179112_b((int)770, (int)771);
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)ring.getAlpha());
        GlStateManager.func_179152_a((float)0.7f, (float)0.7f, (float)0.7f);
        this.Ring.func_78785_a(f5);
        GlStateManager.func_179084_k();
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }
}

