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
package xol.lostinfinity.mob.model.deviant;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;

public class ModelDeviantGuardian
extends ModelBase {
    private final ModelRenderer head;
    private final ModelRenderer arm1;
    private final ModelRenderer head_r1;
    private final ModelRenderer head_r2;
    private final ModelRenderer arm3;
    private final ModelRenderer head_r3;
    private final ModelRenderer head_r4;
    private final ModelRenderer arm4;
    private final ModelRenderer head_r5;
    private final ModelRenderer head_r6;
    private final ModelRenderer arm2;
    private final ModelRenderer head_r7;
    private final ModelRenderer head_r8;
    private final ModelRenderer eye;
    private final ModelRenderer tailpart0;
    private final ModelRenderer tailpart1;
    private final ModelRenderer tailpart2;
    private final ModelRenderer spikepart0;
    private final ModelRenderer spikepart1;
    private final ModelRenderer spikepart2;
    private final ModelRenderer spikepart3;
    private final ModelRenderer spikepart4;
    private final ModelRenderer spikepart5;
    private final ModelRenderer spikepart6;
    private final ModelRenderer spikepart7;
    private final ModelRenderer spikepart8;
    private final ModelRenderer spikepart9;
    private final ModelRenderer spikepart10;
    private final ModelRenderer spikepart11;
    private final ModelRenderer[] spinesX = new ModelRenderer[4];
    private final ModelRenderer[] spinesXY = new ModelRenderer[4];
    private final ModelRenderer[] spinesZ = new ModelRenderer[4];

    public ModelDeviantGuardian() {
        this.field_78090_t = 128;
        this.field_78089_u = 64;
        this.head = new ModelRenderer((ModelBase)this);
        this.head.func_78793_a(0.0f, 24.0f, 0.0f);
        this.head.field_78804_l.add(new ModelBox(this.head, 0, 0, -6.0f, -14.0f, -8.0f, 12, 12, 16, 0.0f, false));
        this.head.field_78804_l.add(new ModelBox(this.head, 0, 28, -8.0f, -14.0f, -6.0f, 2, 12, 12, 0.0f, false));
        this.head.field_78804_l.add(new ModelBox(this.head, 0, 28, 6.0f, -14.0f, -6.0f, 2, 12, 12, 0.0f, true));
        this.head.field_78804_l.add(new ModelBox(this.head, 16, 40, -6.0f, -16.0f, -6.0f, 12, 2, 12, 0.0f, true));
        this.head.field_78804_l.add(new ModelBox(this.head, 16, 40, -6.0f, -2.0f, -6.0f, 12, 2, 12, 0.0f, true));
        this.arm1 = new ModelRenderer((ModelBase)this);
        this.arm1.func_78793_a(5.0f, -13.0f, 8.0f);
        this.head.func_78792_a(this.arm1);
        this.head_r1 = new ModelRenderer((ModelBase)this);
        this.head_r1.func_78793_a(16.9856f, -14.2526f, -9.1844f);
        this.arm1.func_78792_a(this.head_r1);
        this.setRotationAngle(this.head_r1, 0.0f, 0.7854f, -0.6981f);
        this.head_r1.field_78804_l.add(new ModelBox(this.head_r1, 62, 27, -17.0f, 0.0f, -11.0f, 23, 2, 6, -0.2f, true));
        this.head_r1.field_78804_l.add(new ModelBox(this.head_r1, 65, 13, -9.0f, -3.0f, -6.0f, 16, 6, 6, -0.2f, true));
        this.head_r2 = new ModelRenderer((ModelBase)this);
        this.head_r2.func_78793_a(0.0f, 0.0f, 0.0f);
        this.arm1.func_78792_a(this.head_r2);
        this.setRotationAngle(this.head_r2, 0.0f, 0.3927f, -0.6981f);
        this.head_r2.field_78804_l.add(new ModelBox(this.head_r2, 59, 37, -2.0f, -3.0f, -3.0f, 2, 6, 6, 0.2f, true));
        this.head_r2.field_78804_l.add(new ModelBox(this.head_r2, 66, 0, 0.0f, -3.0f, -3.0f, 16, 6, 6, 0.0f, true));
        this.arm3 = new ModelRenderer((ModelBase)this);
        this.arm3.func_78793_a(2.0f, -6.0f, 8.0f);
        this.head.func_78792_a(this.arm3);
        this.setRotationAngle(this.arm3, 0.0f, 0.0f, -0.5236f);
        this.head_r3 = new ModelRenderer((ModelBase)this);
        this.head_r3.func_78793_a(16.9856f, 14.2526f, -9.1844f);
        this.arm3.func_78792_a(this.head_r3);
        this.setRotationAngle(this.head_r3, 0.0f, 0.7854f, 0.6981f);
        this.head_r3.field_78804_l.add(new ModelBox(this.head_r3, 62, 27, -17.0f, -2.0f, -11.0f, 23, 2, 6, -0.2f, true));
        this.head_r3.field_78804_l.add(new ModelBox(this.head_r3, 65, 13, -9.0f, -3.0f, -6.0f, 16, 6, 6, -0.2f, true));
        this.head_r4 = new ModelRenderer((ModelBase)this);
        this.head_r4.func_78793_a(0.0f, 0.0f, 0.0f);
        this.arm3.func_78792_a(this.head_r4);
        this.setRotationAngle(this.head_r4, 0.0f, 0.3927f, 0.6981f);
        this.head_r4.field_78804_l.add(new ModelBox(this.head_r4, 59, 37, -2.0f, -3.0f, -3.0f, 2, 6, 6, 0.2f, true));
        this.head_r4.field_78804_l.add(new ModelBox(this.head_r4, 66, 0, 0.0f, -3.0f, -3.0f, 16, 6, 6, 0.0f, true));
        this.arm4 = new ModelRenderer((ModelBase)this);
        this.arm4.func_78793_a(-2.0f, -6.0f, 8.0f);
        this.head.func_78792_a(this.arm4);
        this.setRotationAngle(this.arm4, 0.0f, 0.0f, 0.5236f);
        this.head_r5 = new ModelRenderer((ModelBase)this);
        this.head_r5.func_78793_a(-16.9856f, 14.2526f, -9.1844f);
        this.arm4.func_78792_a(this.head_r5);
        this.setRotationAngle(this.head_r5, 0.0f, -0.7854f, -0.6981f);
        this.head_r5.field_78804_l.add(new ModelBox(this.head_r5, 62, 27, -6.0f, -2.0f, -11.0f, 23, 2, 6, -0.2f, false));
        this.head_r5.field_78804_l.add(new ModelBox(this.head_r5, 65, 13, -7.0f, -3.0f, -6.0f, 16, 6, 6, -0.2f, false));
        this.head_r6 = new ModelRenderer((ModelBase)this);
        this.head_r6.func_78793_a(0.0f, 0.0f, 0.0f);
        this.arm4.func_78792_a(this.head_r6);
        this.setRotationAngle(this.head_r6, 0.0f, -0.3927f, -0.6981f);
        this.head_r6.field_78804_l.add(new ModelBox(this.head_r6, 59, 37, 0.0f, -3.0f, -3.0f, 2, 6, 6, 0.2f, false));
        this.head_r6.field_78804_l.add(new ModelBox(this.head_r6, 66, 0, -16.0f, -3.0f, -3.0f, 16, 6, 6, 0.0f, false));
        this.arm2 = new ModelRenderer((ModelBase)this);
        this.arm2.func_78793_a(-5.0f, -13.0f, 8.0f);
        this.head.func_78792_a(this.arm2);
        this.head_r7 = new ModelRenderer((ModelBase)this);
        this.head_r7.func_78793_a(-16.9856f, -14.2526f, -9.1844f);
        this.arm2.func_78792_a(this.head_r7);
        this.setRotationAngle(this.head_r7, 0.0f, -0.7854f, 0.6981f);
        this.head_r7.field_78804_l.add(new ModelBox(this.head_r7, 62, 27, -6.0f, 0.0f, -11.0f, 23, 2, 6, -0.2f, false));
        this.head_r7.field_78804_l.add(new ModelBox(this.head_r7, 65, 13, -7.0f, -3.0f, -6.0f, 16, 6, 6, -0.2f, false));
        this.head_r8 = new ModelRenderer((ModelBase)this);
        this.head_r8.func_78793_a(0.0f, 0.0f, 0.0f);
        this.arm2.func_78792_a(this.head_r8);
        this.setRotationAngle(this.head_r8, 0.0f, -0.3927f, 0.6981f);
        this.head_r8.field_78804_l.add(new ModelBox(this.head_r8, 59, 37, 0.0f, -3.0f, -3.0f, 2, 6, 6, 0.2f, false));
        this.head_r8.field_78804_l.add(new ModelBox(this.head_r8, 66, 0, -16.0f, -3.0f, -3.0f, 16, 6, 6, 0.0f, false));
        this.eye = new ModelRenderer((ModelBase)this);
        this.eye.func_78793_a(0.0f, -24.0f, 0.0f);
        this.head.func_78792_a(this.eye);
        this.eye.field_78804_l.add(new ModelBox(this.eye, 8, 0, -1.0f, 15.0f, -8.25f, 2, 2, 1, 0.0f, false));
        this.tailpart0 = new ModelRenderer((ModelBase)this);
        this.tailpart0.func_78793_a(0.0f, -24.0f, 0.0f);
        this.head.func_78792_a(this.tailpart0);
        this.tailpart0.field_78804_l.add(new ModelBox(this.tailpart0, 40, 0, -2.0f, 14.0f, 8.0f, 4, 4, 8, 0.0f, false));
        this.tailpart1 = new ModelRenderer((ModelBase)this);
        this.tailpart1.func_78793_a(0.0f, 16.0f, 15.0f);
        this.tailpart0.func_78792_a(this.tailpart1);
        this.tailpart1.field_78804_l.add(new ModelBox(this.tailpart1, 0, 54, -1.5f, -2.0f, 1.0f, 3, 3, 7, 0.0f, false));
        this.tailpart2 = new ModelRenderer((ModelBase)this);
        this.tailpart2.func_78793_a(0.0f, 0.0f, 7.0f);
        this.tailpart1.func_78792_a(this.tailpart2);
        this.tailpart2.field_78804_l.add(new ModelBox(this.tailpart2, 41, 32, -1.0f, -2.0f, 1.0f, 2, 2, 6, 0.0f, false));
        this.tailpart2.field_78804_l.add(new ModelBox(this.tailpart2, 25, 19, 0.0f, -5.5f, 4.0f, 1, 9, 9, 0.0f, false));
        this.spikepart0 = new ModelRenderer((ModelBase)this);
        this.spikepart0.func_78793_a(0.0f, -24.0f, 0.0f);
        this.head.func_78792_a(this.spikepart0);
        this.setRotationAngle(this.spikepart0, 0.0f, 0.0f, 0.7854f);
        this.spikepart0.field_78804_l.add(new ModelBox(this.spikepart0, 0, 0, 10.25f, -4.5f, -1.0f, 2, 9, 2, 0.0f, false));
        this.spikepart1 = new ModelRenderer((ModelBase)this);
        this.spikepart1.func_78793_a(0.0f, -24.0f, 0.0f);
        this.head.func_78792_a(this.spikepart1);
        this.setRotationAngle(this.spikepart1, 0.0f, 0.0f, -0.7854f);
        this.spikepart1.field_78804_l.add(new ModelBox(this.spikepart1, 0, 0, -12.25f, -4.5f, -1.0f, 2, 9, 2, 0.0f, false));
        this.spikepart2 = new ModelRenderer((ModelBase)this);
        this.spikepart2.func_78793_a(0.0f, -24.0f, 0.0f);
        this.head.func_78792_a(this.spikepart2);
        this.setRotationAngle(this.spikepart2, 0.7854f, 0.0f, 0.0f);
        this.spikepart2.field_78804_l.add(new ModelBox(this.spikepart2, 0, 0, -1.0f, -4.5f, -12.25f, 2, 9, 2, 0.0f, false));
        this.spikepart3 = new ModelRenderer((ModelBase)this);
        this.spikepart3.func_78793_a(0.0f, -24.0f, 0.0f);
        this.head.func_78792_a(this.spikepart3);
        this.setRotationAngle(this.spikepart3, -0.7854f, 0.0f, 0.0f);
        this.spikepart3.field_78804_l.add(new ModelBox(this.spikepart3, 0, 0, -1.0f, -4.5f, 10.5f, 2, 9, 2, 0.0f, false));
        this.spikepart4 = new ModelRenderer((ModelBase)this);
        this.spikepart4.func_78793_a(0.0f, -24.0f, 0.0f);
        this.head.func_78792_a(this.spikepart4);
        this.setRotationAngle(this.spikepart4, 0.0f, 0.0f, 2.3562f);
        this.spikepart4.field_78804_l.add(new ModelBox(this.spikepart4, 0, 0, 10.25f, -27.5f, -1.0f, 2, 9, 2, 0.0f, false));
        this.spikepart5 = new ModelRenderer((ModelBase)this);
        this.spikepart5.func_78793_a(0.0f, -24.0f, 0.0f);
        this.head.func_78792_a(this.spikepart5);
        this.setRotationAngle(this.spikepart5, 0.0f, 0.0f, -2.3562f);
        this.spikepart5.field_78804_l.add(new ModelBox(this.spikepart5, 0, 0, -12.25f, -27.5f, -1.0f, 2, 9, 2, 0.0f, false));
        this.spikepart6 = new ModelRenderer((ModelBase)this);
        this.spikepart6.func_78793_a(0.0f, -24.0f, 0.0f);
        this.head.func_78792_a(this.spikepart6);
        this.setRotationAngle(this.spikepart6, 2.3562f, 0.0f, 0.0f);
        this.spikepart6.field_78804_l.add(new ModelBox(this.spikepart6, 0, 0, -1.0f, -28.5f, -12.25f, 2, 9, 2, 0.0f, false));
        this.spikepart7 = new ModelRenderer((ModelBase)this);
        this.spikepart7.func_78793_a(0.0f, -24.0f, 0.0f);
        this.head.func_78792_a(this.spikepart7);
        this.setRotationAngle(this.spikepart7, -2.3562f, 0.0f, 0.0f);
        this.spikepart7.field_78804_l.add(new ModelBox(this.spikepart7, 0, 0, -1.0f, -27.5f, 10.25f, 2, 9, 2, 0.0f, false));
        this.spikepart8 = new ModelRenderer((ModelBase)this);
        this.spikepart8.func_78793_a(0.0f, -24.0f, 0.0f);
        this.head.func_78792_a(this.spikepart8);
        this.setRotationAngle(this.spikepart8, 1.5708f, -0.7854f, 0.0f);
        this.spikepart8.field_78804_l.add(new ModelBox(this.spikepart8, 0, 0, -1.0f, -17.5f, -17.0f, 2, 9, 2, 0.0f, false));
        this.spikepart9 = new ModelRenderer((ModelBase)this);
        this.spikepart9.func_78793_a(0.0f, -24.0f, 0.0f);
        this.head.func_78792_a(this.spikepart9);
        this.setRotationAngle(this.spikepart9, 1.5708f, 0.7854f, 0.0f);
        this.spikepart9.field_78804_l.add(new ModelBox(this.spikepart9, 0, 0, -1.0f, -17.5f, -17.0f, 2, 9, 2, 0.0f, false));
        this.spikepart10 = new ModelRenderer((ModelBase)this);
        this.spikepart10.func_78793_a(0.0f, -24.0f, 0.0f);
        this.head.func_78792_a(this.spikepart10);
        this.setRotationAngle(this.spikepart10, 1.5708f, -2.3562f, 0.0f);
        this.spikepart10.field_78804_l.add(new ModelBox(this.spikepart10, 0, 0, -1.0f, -17.5f, -17.0f, 2, 9, 2, 0.0f, false));
        this.spikepart11 = new ModelRenderer((ModelBase)this);
        this.spikepart11.func_78793_a(0.0f, -24.0f, 0.0f);
        this.head.func_78792_a(this.spikepart11);
        this.setRotationAngle(this.spikepart11, 1.5708f, 2.3562f, 0.0f);
        this.spikepart11.field_78804_l.add(new ModelBox(this.spikepart11, 0, 0, -1.0f, -17.5f, -17.0f, 2, 9, 2, 0.0f, false));
        this.spinesZ[0] = this.spikepart0;
        this.spinesZ[1] = this.spikepart1;
        this.spinesZ[2] = this.spikepart4;
        this.spinesZ[3] = this.spikepart5;
        this.spinesX[0] = this.spikepart2;
        this.spinesX[1] = this.spikepart3;
        this.spinesX[2] = this.spikepart6;
        this.spinesX[3] = this.spikepart7;
        this.spinesXY[0] = this.spikepart8;
        this.spinesXY[1] = this.spikepart9;
        this.spinesXY[2] = this.spikepart10;
        this.spinesXY[3] = this.spikepart11;
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.head.func_78785_a(f5);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.arm1.field_78795_f = 0.5f * Mth.func_76126_a((float)(ageInTicks * 0.1f));
        this.arm1.field_78796_g = 0.5f * Mth.func_76126_a((float)(ageInTicks * 0.1f));
        this.arm3.field_78795_f = -this.arm1.field_78795_f;
        this.arm3.field_78796_g = this.arm1.field_78796_g;
        this.arm2.field_78795_f = this.arm1.field_78795_f;
        this.arm2.field_78796_g = -this.arm1.field_78796_g;
        this.arm4.field_78795_f = -this.arm1.field_78795_f;
        this.arm4.field_78796_g = -this.arm1.field_78796_g;
        this.tailpart0.field_78796_g = 0.3f * Mth.func_76134_b((float)(ageInTicks * 0.1f));
        this.tailpart1.field_78796_g = 0.3f * Mth.func_76126_a((float)(ageInTicks * 0.2f));
        this.tailpart2.field_78796_g = 0.3f * Mth.func_76134_b((float)(ageInTicks * 0.3f));
        for (int i = 0; i < 4; ++i) {
            ModelRenderer spikez = this.spinesZ[i];
            ModelRenderer spikexy = this.spinesXY[i];
            ModelRenderer spikex = this.spinesX[i];
            spikez.field_78795_f = 0.25f * Mth.func_76126_a((float)((ageInTicks + (float)(i * 15)) * 0.1f));
            spikex.field_78796_g = 0.25f * Mth.func_76126_a((float)((ageInTicks + (float)(i * 15)) * 0.1f));
            spikexy.field_78808_h = 0.1f * Mth.func_76126_a((float)((ageInTicks + (float)(i * 15)) * 0.1f));
        }
    }
}

