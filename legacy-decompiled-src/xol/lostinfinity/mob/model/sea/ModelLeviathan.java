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
package xol.lostinfinity.mob.model.sea;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import xol.lostinfinity.mob.entity.sea.leviathan.EntityLeviathanController;
import xol.lostinfinity.mob.entity.sea.leviathan.EntityLeviathanHead;
import xol.lostinfinity.mob.entity.sea.leviathan.EntityLeviathanSegment;
import xol.lostinfinity.mob.entity.sea.leviathan.EntityLeviathanTail;
import xol.lostinfinity.util.math.LMath;

public class ModelLeviathan
extends ModelBase {
    private final ModelRenderer Head;
    private final ModelRenderer JawTop;
    private final ModelRenderer GlowPin1;
    private final ModelRenderer GlowPin4;
    private final ModelRenderer GlowPin2;
    private final ModelRenderer GlowPin5;
    private final ModelRenderer GlowPin3;
    private final ModelRenderer GlowPin6;
    private final ModelRenderer JawBottom;
    private final ModelRenderer BodyNoFin;
    private final ModelRenderer BodyFin;
    private final ModelRenderer FinLeft;
    private final ModelRenderer FinRight;
    private final ModelRenderer BodyTail;
    private final ModelRenderer FinTop;
    private final ModelRenderer cube_r1;
    private final ModelRenderer cube_r2;
    private final ModelRenderer FinBottom;
    private final ModelRenderer cube_r3;
    private final ModelRenderer cube_r4;

    public ModelLeviathan() {
        this.field_78090_t = 128;
        this.field_78089_u = 64;
        this.Head = new ModelRenderer((ModelBase)this);
        this.Head.func_78793_a(0.0f, 16.0f, 0.0f);
        this.JawTop = new ModelRenderer((ModelBase)this);
        this.JawTop.func_78793_a(0.0f, 3.5f, 7.0f);
        this.Head.func_78792_a(this.JawTop);
        this.JawTop.field_78804_l.add(new ModelBox(this.JawTop, 78, 3, -6.0f, -7.0f, -13.0f, 12, 7, 13, 0.0f, false));
        this.JawTop.field_78804_l.add(new ModelBox(this.JawTop, 63, 28, -2.0f, -8.0f, -14.0f, 4, 7, 1, 0.0f, false));
        this.JawTop.field_78804_l.add(new ModelBox(this.JawTop, 41, 29, -2.0f, -8.0f, -13.0f, 4, 1, 12, 0.0f, false));
        this.JawTop.field_78804_l.add(new ModelBox(this.JawTop, 81, 3, -1.0f, -11.0f, -11.0f, 1, 3, 3, 0.0f, false));
        this.JawTop.field_78804_l.add(new ModelBox(this.JawTop, 81, 3, -1.0f, -11.0f, -5.0f, 1, 3, 3, 0.0f, false));
        this.JawTop.field_78804_l.add(new ModelBox(this.JawTop, 39, 36, 4.0f, 0.0f, -12.25f, 1, 3, 1, 0.0f, false));
        this.JawTop.field_78804_l.add(new ModelBox(this.JawTop, 39, 36, 2.0f, 0.0f, -12.25f, 1, 3, 1, 0.0f, false));
        this.JawTop.field_78804_l.add(new ModelBox(this.JawTop, 39, 36, -5.0f, 0.0f, -12.25f, 1, 3, 1, 0.0f, false));
        this.JawTop.field_78804_l.add(new ModelBox(this.JawTop, 39, 36, -3.0f, 0.0f, -12.25f, 1, 3, 1, 0.0f, false));
        this.GlowPin1 = new ModelRenderer((ModelBase)this);
        this.GlowPin1.func_78793_a(4.5f, -7.0f, -1.5f);
        this.JawTop.func_78792_a(this.GlowPin1);
        this.setRotationAngle(this.GlowPin1, -0.4363f, 0.4363f, 0.0f);
        this.GlowPin1.field_78804_l.add(new ModelBox(this.GlowPin1, 102, 27, -0.5f, -6.0f, -0.5f, 1, 8, 1, 0.0f, false));
        this.GlowPin1.field_78804_l.add(new ModelBox(this.GlowPin1, 119, 9, -1.0f, -10.0f, -1.0f, 2, 4, 2, 0.0f, false));
        this.GlowPin4 = new ModelRenderer((ModelBase)this);
        this.GlowPin4.func_78793_a(-4.5f, -7.0f, -1.5f);
        this.JawTop.func_78792_a(this.GlowPin4);
        this.setRotationAngle(this.GlowPin4, -0.4363f, -0.4363f, 0.0f);
        this.GlowPin4.field_78804_l.add(new ModelBox(this.GlowPin4, 102, 27, -0.5f, -6.0f, -0.5f, 1, 8, 1, 0.0f, true));
        this.GlowPin4.field_78804_l.add(new ModelBox(this.GlowPin4, 119, 9, -1.0f, -10.0f, -1.0f, 2, 4, 2, 0.0f, true));
        this.GlowPin2 = new ModelRenderer((ModelBase)this);
        this.GlowPin2.func_78793_a(3.5f, -7.0f, -6.5f);
        this.JawTop.func_78792_a(this.GlowPin2);
        this.setRotationAngle(this.GlowPin2, -0.4363f, 0.8727f, 0.0f);
        this.GlowPin2.field_78804_l.add(new ModelBox(this.GlowPin2, 102, 27, -0.5f, -6.0f, -0.5f, 1, 8, 1, 0.0f, false));
        this.GlowPin2.field_78804_l.add(new ModelBox(this.GlowPin2, 119, 9, -1.0f, -10.0f, -1.0f, 2, 4, 2, 0.0f, false));
        this.GlowPin5 = new ModelRenderer((ModelBase)this);
        this.GlowPin5.func_78793_a(-3.5f, -7.0f, -6.5f);
        this.JawTop.func_78792_a(this.GlowPin5);
        this.setRotationAngle(this.GlowPin5, -0.4363f, -0.8727f, 0.0f);
        this.GlowPin5.field_78804_l.add(new ModelBox(this.GlowPin5, 102, 27, -0.5f, -6.0f, -0.5f, 1, 8, 1, 0.0f, true));
        this.GlowPin5.field_78804_l.add(new ModelBox(this.GlowPin5, 119, 9, -1.0f, -10.0f, -1.0f, 2, 4, 2, 0.0f, true));
        this.GlowPin3 = new ModelRenderer((ModelBase)this);
        this.GlowPin3.func_78793_a(2.5f, -7.0f, -11.5f);
        this.JawTop.func_78792_a(this.GlowPin3);
        this.setRotationAngle(this.GlowPin3, -0.6109f, 1.2217f, 0.0f);
        this.GlowPin3.field_78804_l.add(new ModelBox(this.GlowPin3, 102, 27, -0.5f, -6.0f, -0.5f, 1, 8, 1, 0.0f, false));
        this.GlowPin3.field_78804_l.add(new ModelBox(this.GlowPin3, 119, 9, -1.0f, -10.0f, -1.0f, 2, 4, 2, 0.0f, false));
        this.GlowPin6 = new ModelRenderer((ModelBase)this);
        this.GlowPin6.func_78793_a(-2.5f, -7.0f, -11.5f);
        this.JawTop.func_78792_a(this.GlowPin6);
        this.setRotationAngle(this.GlowPin6, -0.6109f, -1.2217f, 0.0f);
        this.GlowPin6.field_78804_l.add(new ModelBox(this.GlowPin6, 102, 27, -0.5f, -6.0f, -0.5f, 1, 8, 1, 0.0f, true));
        this.GlowPin6.field_78804_l.add(new ModelBox(this.GlowPin6, 119, 9, -1.0f, -10.0f, -1.0f, 2, 4, 2, 0.0f, true));
        this.JawBottom = new ModelRenderer((ModelBase)this);
        this.JawBottom.func_78793_a(0.0f, 3.5f, 7.0f);
        this.Head.func_78792_a(this.JawBottom);
        this.setRotationAngle(this.JawBottom, 0.0f, 0.0f, 0.0f);
        this.JawBottom.field_78804_l.add(new ModelBox(this.JawBottom, 9, 51, -5.0f, 2.0f, -11.0f, 10, 2, 11, 0.0f, false));
        this.JawBottom.field_78804_l.add(new ModelBox(this.JawBottom, 62, 26, -6.0f, 0.0f, -12.0f, 12, 2, 12, 0.0f, false));
        this.JawBottom.field_78804_l.add(new ModelBox(this.JawBottom, 46, 37, 4.5f, -2.0f, -11.5f, 1, 2, 1, 0.0f, false));
        this.JawBottom.field_78804_l.add(new ModelBox(this.JawBottom, 46, 37, 4.5f, -2.0f, -9.5f, 1, 2, 1, 0.0f, false));
        this.JawBottom.field_78804_l.add(new ModelBox(this.JawBottom, 46, 37, 4.5f, -2.0f, -7.5f, 1, 2, 1, 0.0f, false));
        this.JawBottom.field_78804_l.add(new ModelBox(this.JawBottom, 46, 37, 4.5f, -2.0f, -5.5f, 1, 2, 1, 0.0f, false));
        this.JawBottom.field_78804_l.add(new ModelBox(this.JawBottom, 46, 37, -5.5f, -2.0f, -9.5f, 1, 2, 1, 0.0f, false));
        this.JawBottom.field_78804_l.add(new ModelBox(this.JawBottom, 46, 37, -5.5f, -2.0f, -7.5f, 1, 2, 1, 0.0f, false));
        this.JawBottom.field_78804_l.add(new ModelBox(this.JawBottom, 46, 37, -5.5f, -2.0f, -5.5f, 1, 2, 1, 0.0f, false));
        this.JawBottom.field_78804_l.add(new ModelBox(this.JawBottom, 46, 37, -5.5f, -2.0f, -11.5f, 1, 2, 1, 0.0f, false));
        this.JawBottom.field_78804_l.add(new ModelBox(this.JawBottom, 46, 37, -3.5f, -2.0f, -11.5f, 1, 2, 1, 0.0f, false));
        this.JawBottom.field_78804_l.add(new ModelBox(this.JawBottom, 46, 37, 2.5f, -2.0f, -11.5f, 1, 2, 1, 0.0f, false));
        this.BodyNoFin = new ModelRenderer((ModelBase)this);
        this.BodyNoFin.func_78793_a(0.0f, 16.0f, 0.0f);
        this.BodyNoFin.field_78804_l.add(new ModelBox(this.BodyNoFin, 0, 0, -8.0f, -4.5f, -8.0f, 16, 10, 16, 0.0f, false));
        this.BodyNoFin.field_78804_l.add(new ModelBox(this.BodyNoFin, 0, 0, 8.0f, -1.5f, -3.0f, 1, 4, 6, 0.0f, false));
        this.BodyNoFin.field_78804_l.add(new ModelBox(this.BodyNoFin, 0, 0, -9.0f, -1.5f, -3.0f, 1, 4, 6, 0.0f, true));
        this.BodyNoFin.field_78804_l.add(new ModelBox(this.BodyNoFin, 0, 49, 7.5f, -2.0f, -3.5f, 1, 5, 7, 0.0f, false));
        this.BodyNoFin.field_78804_l.add(new ModelBox(this.BodyNoFin, 0, 49, -8.5f, -2.0f, -3.5f, 1, 5, 7, 0.0f, true));
        this.BodyNoFin.field_78804_l.add(new ModelBox(this.BodyNoFin, 19, 27, -1.0f, -7.5f, -8.0f, 1, 3, 16, 0.0f, false));
        this.BodyNoFin.field_78804_l.add(new ModelBox(this.BodyNoFin, 0, 46, -7.0f, 5.5f, -8.0f, 14, 2, 16, 0.0f, false));
        this.BodyFin = new ModelRenderer((ModelBase)this);
        this.BodyFin.func_78793_a(0.0f, 16.0f, 0.0f);
        this.BodyFin.field_78804_l.add(new ModelBox(this.BodyFin, 0, 0, -8.0f, -4.5f, -8.0f, 16, 10, 16, 0.0f, false));
        this.BodyFin.field_78804_l.add(new ModelBox(this.BodyFin, 19, 27, -1.0f, -7.5f, -8.0f, 1, 3, 16, 0.0f, false));
        this.BodyFin.field_78804_l.add(new ModelBox(this.BodyFin, 0, 46, -7.0f, 5.5f, -8.0f, 14, 2, 16, 0.0f, false));
        this.FinLeft = new ModelRenderer((ModelBase)this);
        this.FinLeft.func_78793_a(8.0f, 0.5f, 0.0f);
        this.BodyFin.func_78792_a(this.FinLeft);
        this.FinLeft.field_78804_l.add(new ModelBox(this.FinLeft, 41, 26, -0.5f, -2.5f, -2.5f, 1, 5, 5, 0.0f, false));
        this.FinLeft.field_78804_l.add(new ModelBox(this.FinLeft, 75, 40, 0.0f, -1.5f, -1.5f, 6, 3, 3, 0.0f, false));
        this.FinLeft.field_78804_l.add(new ModelBox(this.FinLeft, 3, 44, 6.0f, -1.0f, -1.0f, 3, 2, 2, 0.0f, false));
        this.FinLeft.field_78804_l.add(new ModelBox(this.FinLeft, 0, 27, 6.0f, -7.0f, 0.0f, 16, 14, 1, 0.0f, false));
        this.FinRight = new ModelRenderer((ModelBase)this);
        this.FinRight.func_78793_a(-8.0f, 0.5f, 0.0f);
        this.BodyFin.func_78792_a(this.FinRight);
        this.FinRight.field_78804_l.add(new ModelBox(this.FinRight, 41, 26, -0.5f, -2.5f, -2.5f, 1, 5, 5, 0.0f, true));
        this.FinRight.field_78804_l.add(new ModelBox(this.FinRight, 75, 40, -6.0f, -1.5f, -1.5f, 6, 3, 3, 0.0f, true));
        this.FinRight.field_78804_l.add(new ModelBox(this.FinRight, 3, 44, -9.0f, -1.0f, -1.0f, 3, 2, 2, 0.0f, true));
        this.FinRight.field_78804_l.add(new ModelBox(this.FinRight, 0, 27, -22.0f, -7.0f, 0.0f, 16, 14, 1, 0.0f, true));
        this.BodyTail = new ModelRenderer((ModelBase)this);
        this.BodyTail.func_78793_a(0.0f, 16.0f, 0.0f);
        this.BodyTail.field_78804_l.add(new ModelBox(this.BodyTail, 45, 46, -8.0f, -4.5f, -15.0f, 16, 10, 6, 0.0f, false));
        this.BodyTail.field_78804_l.add(new ModelBox(this.BodyTail, 81, 3, -1.0f, -7.5f, -14.0f, 1, 3, 3, 0.0f, false));
        this.BodyTail.field_78804_l.add(new ModelBox(this.BodyTail, 81, 3, -1.0f, -6.5f, -8.0f, 1, 3, 3, 0.0f, false));
        this.BodyTail.field_78804_l.add(new ModelBox(this.BodyTail, 45, 46, -8.0f, -4.5f, -10.0f, 16, 10, 6, -0.5f, false));
        this.BodyTail.field_78804_l.add(new ModelBox(this.BodyTail, 45, 46, -8.0f, -4.5f, -6.0f, 16, 10, 6, -1.0f, false));
        this.BodyTail.field_78804_l.add(new ModelBox(this.BodyTail, 50, 0, -4.0f, -2.5f, -3.0f, 8, 5, 10, 0.0f, false));
        this.BodyTail.field_78804_l.add(new ModelBox(this.BodyTail, 64, 16, 1.0f, -1.5f, 7.0f, 2, 2, 8, 0.0f, false));
        this.BodyTail.field_78804_l.add(new ModelBox(this.BodyTail, 64, 16, -3.0f, -1.5f, 7.0f, 2, 2, 8, 0.0f, true));
        this.BodyTail.field_78804_l.add(new ModelBox(this.BodyTail, 84, 56, -7.0f, 5.5f, -15.0f, 14, 2, 6, 0.0f, false));
        this.BodyTail.field_78804_l.add(new ModelBox(this.BodyTail, 84, 56, -7.0f, 4.5f, -10.0f, 14, 2, 6, -0.5f, false));
        this.FinTop = new ModelRenderer((ModelBase)this);
        this.FinTop.func_78793_a(0.0f, -2.5f, -1.0f);
        this.BodyTail.func_78792_a(this.FinTop);
        this.cube_r1 = new ModelRenderer((ModelBase)this);
        this.cube_r1.func_78793_a(0.0f, -9.0f, 13.0f);
        this.FinTop.func_78792_a(this.cube_r1);
        this.setRotationAngle(this.cube_r1, 0.6109f, 0.0f, 0.0f);
        this.cube_r1.field_78804_l.add(new ModelBox(this.cube_r1, 94, 25, -1.0f, -7.0f, -7.0f, 1, 14, 16, 0.0f, false));
        this.cube_r2 = new ModelRenderer((ModelBase)this);
        this.cube_r2.func_78793_a(0.0f, -9.0f, 13.0f);
        this.FinTop.func_78792_a(this.cube_r2);
        this.setRotationAngle(this.cube_r2, 2.1817f, 0.0f, 0.0f);
        this.cube_r2.field_78804_l.add(new ModelBox(this.cube_r2, 120, 25, -1.0f, -16.0f, -1.0f, 2, 14, 2, 0.0f, false));
        this.FinBottom = new ModelRenderer((ModelBase)this);
        this.FinBottom.func_78793_a(0.0f, 2.5f, -1.0f);
        this.BodyTail.func_78792_a(this.FinBottom);
        this.cube_r3 = new ModelRenderer((ModelBase)this);
        this.cube_r3.func_78793_a(0.0f, -14.0f, 13.0f);
        this.FinBottom.func_78792_a(this.cube_r3);
        this.setRotationAngle(this.cube_r3, -2.1817f, 0.0f, 0.0f);
        this.cube_r3.field_78804_l.add(new ModelBox(this.cube_r3, 112, 25, -1.0f, -11.0f, 18.0f, 2, 14, 2, 0.0f, false));
        this.cube_r4 = new ModelRenderer((ModelBase)this);
        this.cube_r4.func_78793_a(0.0f, -14.0f, 13.0f);
        this.FinBottom.func_78792_a(this.cube_r4);
        this.setRotationAngle(this.cube_r4, -0.6109f, 0.0f, 0.0f);
        this.cube_r4.field_78804_l.add(new ModelBox(this.cube_r4, 94, 25, -1.0f, 12.0f, 6.0f, 1, 14, 16, 0.0f, false));
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.getModelRenderer(entity).func_78785_a(f5);
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        ModelRenderer modelRenderer = this.getModelRenderer(entityIn);
        modelRenderer.field_78795_f = headPitch * ((float)Math.PI / 180);
        EntityLeviathanSegment segment = (EntityLeviathanSegment)entityIn;
        if (modelRenderer == this.BodyFin) {
            this.FinLeft.field_78796_g = (float)Mth.func_151238_b((double)-0.5235987901687622, (double)-1.3962633609771729, (double)LMath.trig01(Mth.func_76126_a((float)(ageInTicks / 10.0f - (float)segment.getId() / 2.0f))));
            this.FinRight.field_78796_g = -this.FinLeft.field_78796_g;
        } else if (modelRenderer == this.Head) {
            switch (((EntityLeviathanController)segment.getRelay()).getLeviathanPhase()) {
                case BEAM: 
                case CHARGE: {
                    if (((EntityLeviathanController)segment.getRelay()).getLeviathanPhaseData() == 1) {
                        this.JawTop.field_78795_f = -0.7853982f;
                        this.JawBottom.field_78795_f = 0.7853982f;
                        break;
                    }
                    this.JawTop.field_78795_f = 0.0f;
                    this.JawBottom.field_78795_f = 0.0f;
                    break;
                }
                case VOLLEY: {
                    this.JawTop.field_78795_f = 0.0f;
                    this.JawBottom.field_78795_f = 0.0f;
                    break;
                }
                case TESLA: {
                    this.JawTop.field_78795_f = -0.17453292f;
                    this.JawBottom.field_78795_f = 0.43633232f;
                }
            }
        }
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    protected ModelRenderer getModelRenderer(Entity entity) {
        if (entity instanceof EntityLeviathanHead) {
            return this.Head;
        }
        if (entity instanceof EntityLeviathanTail) {
            return this.BodyTail;
        }
        if (entity instanceof EntityLeviathanSegment) {
            return ((EntityLeviathanSegment)entity).getId() % 2 == 0 ? this.BodyNoFin : this.BodyFin;
        }
        return this.BodyNoFin;
    }
}

