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
package xol.lostinfinity.mob.model.deviant;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import xol.lostinfinity.mob.entity.deviant.EntityDeviantWolf;

public class ModelDeviantWolf
extends ModelBase {
    private final ModelRenderer head;
    private final ModelRenderer head_r1;
    private final ModelRenderer head_r2;
    private final ModelRenderer body;
    private final ModelRenderer WingL;
    private final ModelRenderer WingR;
    private final ModelRenderer upperBody;
    private final ModelRenderer leg0;
    private final ModelRenderer leg1;
    private final ModelRenderer leg2;
    private final ModelRenderer leg3;
    private final ModelRenderer tail;
    private final ModelRenderer tail_r1;

    public ModelDeviantWolf() {
        this.field_78090_t = 64;
        this.field_78089_u = 64;
        this.head = new ModelRenderer((ModelBase)this);
        this.head.func_78793_a(-1.0f, 13.5f, -7.0f);
        this.head.field_78804_l.add(new ModelBox(this.head, 0, 0, -3.0f, -3.0f, -2.0f, 6, 6, 4, 0.0f, false));
        this.head.field_78804_l.add(new ModelBox(this.head, 0, 18, -3.0f, -5.0f, 0.0f, 2, 2, 1, 0.0f, false));
        this.head.field_78804_l.add(new ModelBox(this.head, 0, 18, 1.0f, -5.0f, 0.0f, 2, 2, 1, 0.0f, false));
        this.head.field_78804_l.add(new ModelBox(this.head, 0, 10, -1.5f, -0.0156f, -5.0f, 3, 3, 4, 0.0f, false));
        this.head_r1 = new ModelRenderer((ModelBase)this);
        this.head_r1.func_78793_a(2.0f, 7.0f, -1.5f);
        this.head.func_78792_a(this.head_r1);
        this.setRotationAngle(this.head_r1, 0.4363f, 0.0f, 0.0f);
        this.head_r1.field_78804_l.add(new ModelBox(this.head_r1, 44, 0, -0.5f, -2.5f, 0.0f, 1, 4, 1, -0.1f, false));
        this.head_r1.field_78804_l.add(new ModelBox(this.head_r1, 44, 0, -4.5f, -2.5f, 0.0f, 1, 4, 1, -0.1f, false));
        this.head_r2 = new ModelRenderer((ModelBase)this);
        this.head_r2.func_78793_a(2.0f, 2.0f, -2.5f);
        this.head.func_78792_a(this.head_r2);
        this.setRotationAngle(this.head_r2, 0.1745f, 0.0f, 0.0f);
        this.head_r2.field_78804_l.add(new ModelBox(this.head_r2, 21, 0, -0.5f, -1.0f, -0.5f, 1, 4, 1, 0.0f, false));
        this.head_r2.field_78804_l.add(new ModelBox(this.head_r2, 21, 0, -4.5f, -1.0f, -0.5f, 1, 4, 1, 0.0f, false));
        this.body = new ModelRenderer((ModelBase)this);
        this.body.func_78793_a(0.0f, 14.0f, 2.0f);
        this.setRotationAngle(this.body, 1.5708f, 0.0f, 0.0f);
        this.body.field_78804_l.add(new ModelBox(this.body, 18, 17, -4.0f, -2.0f, -3.0f, 6, 9, 6, 0.0f, false));
        this.body.field_78804_l.add(new ModelBox(this.body, 52, 18, -1.0f, -2.0f, 3.0f, 1, 9, 5, 0.0f, false));
        this.WingL = new ModelRenderer((ModelBase)this);
        this.WingL.func_78793_a(2.5f, -1.5f, 0.0f);
        this.body.func_78792_a(this.WingL);
        this.setRotationAngle(this.WingL, 0.0f, 0.0f, -0.3491f);
        this.WingL.field_78804_l.add(new ModelBox(this.WingL, 14, 35, -0.5f, 7.5f, -2.0f, 1, 2, 1, -0.2f, false));
        this.WingL.field_78804_l.add(new ModelBox(this.WingL, 9, 34, -0.5f, 7.5f, 0.0f, 1, 3, 1, -0.2f, false));
        this.WingL.field_78804_l.add(new ModelBox(this.WingL, 0, 33, -0.5f, 7.5f, 2.0f, 1, 4, 1, -0.2f, false));
        this.WingL.field_78804_l.add(new ModelBox(this.WingL, 0, 33, -0.5f, -1.5f, -3.0f, 1, 10, 6, -0.1f, false));
        this.WingR = new ModelRenderer((ModelBase)this);
        this.WingR.func_78793_a(-2.5f, -1.5f, 0.0f);
        this.body.func_78792_a(this.WingR);
        this.setRotationAngle(this.WingR, 0.0f, 0.0f, 0.3491f);
        this.WingR.field_78804_l.add(new ModelBox(this.WingR, 14, 35, -0.5f, 7.5f, -2.0f, 1, 2, 1, -0.2f, true));
        this.WingR.field_78804_l.add(new ModelBox(this.WingR, 9, 34, -0.5f, 7.5f, 0.0f, 1, 3, 1, -0.2f, true));
        this.WingR.field_78804_l.add(new ModelBox(this.WingR, 0, 33, -0.5f, 7.5f, 2.0f, 1, 4, 1, -0.2f, true));
        this.WingR.field_78804_l.add(new ModelBox(this.WingR, 0, 33, -0.5f, -1.5f, -3.0f, 1, 10, 6, -0.1f, true));
        this.upperBody = new ModelRenderer((ModelBase)this);
        this.upperBody.func_78793_a(-1.0f, 14.0f, 2.0f);
        this.setRotationAngle(this.upperBody, -1.5708f, 0.0f, 0.0f);
        this.upperBody.field_78804_l.add(new ModelBox(this.upperBody, 20, 0, -4.0f, 2.0f, -4.0f, 8, 6, 7, 0.0f, false));
        this.upperBody.field_78804_l.add(new ModelBox(this.upperBody, 45, 11, 0.0f, 2.0f, -9.0f, 1, 6, 5, 0.0f, false));
        this.leg0 = new ModelRenderer((ModelBase)this);
        this.leg0.func_78793_a(-2.5f, 16.0f, 7.0f);
        this.leg0.field_78804_l.add(new ModelBox(this.leg0, 0, 22, -1.0f, 0.0f, -1.0f, 2, 8, 2, 0.0f, false));
        this.leg1 = new ModelRenderer((ModelBase)this);
        this.leg1.func_78793_a(0.5f, 16.0f, 7.0f);
        this.leg1.field_78804_l.add(new ModelBox(this.leg1, 0, 22, -1.0f, 0.0f, -1.0f, 2, 8, 2, 0.0f, false));
        this.leg2 = new ModelRenderer((ModelBase)this);
        this.leg2.func_78793_a(-2.5f, 16.0f, -4.0f);
        this.leg2.field_78804_l.add(new ModelBox(this.leg2, 0, 22, -1.0f, 0.0f, -1.0f, 2, 8, 2, 0.0f, false));
        this.leg3 = new ModelRenderer((ModelBase)this);
        this.leg3.func_78793_a(0.5f, 16.0f, -4.0f);
        this.leg3.field_78804_l.add(new ModelBox(this.leg3, 0, 22, -1.0f, 0.0f, -1.0f, 2, 8, 2, 0.0f, false));
        this.tail = new ModelRenderer((ModelBase)this);
        this.tail.func_78793_a(-1.0f, 12.0f, 8.0f);
        this.setRotationAngle(this.tail, 0.9599f, 0.0f, 0.0f);
        this.tail.field_78804_l.add(new ModelBox(this.tail, 9, 22, -1.0f, 0.0f, -1.0f, 2, 8, 2, 0.0f, false));
        this.tail.field_78804_l.add(new ModelBox(this.tail, 52, 0, 0.0f, 0.0f, 1.0f, 1, 8, 5, 0.0f, false));
        this.tail_r1 = new ModelRenderer((ModelBase)this);
        this.tail_r1.func_78793_a(-1.5f, 10.0f, 0.0f);
        this.tail.func_78792_a(this.tail_r1);
        this.setRotationAngle(this.tail_r1, -0.3491f, 0.0f, 0.0f);
        this.tail_r1.field_78804_l.add(new ModelBox(this.tail_r1, 16, 14, -0.5f, -3.0f, -2.0f, 1, 6, 2, 0.0f, true));
        this.tail_r1.field_78804_l.add(new ModelBox(this.tail_r1, 16, 14, 2.5f, -3.0f, -2.0f, 1, 6, 2, 0.0f, false));
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.head.field_82906_o = 0.0f;
        this.body.field_82906_o = 0.0f;
        this.upperBody.field_82906_o = 0.0f;
        this.leg0.field_82906_o = 0.0f;
        this.leg1.field_82906_o = 0.0f;
        this.leg2.field_82906_o = 0.0f;
        this.leg3.field_82906_o = 0.0f;
        this.tail.field_82906_o = 0.0f;
        this.head.func_78785_a(f5);
        this.body.func_78785_a(f5);
        this.upperBody.func_78785_a(f5);
        this.leg0.func_78785_a(f5);
        this.leg1.func_78785_a(f5);
        this.leg2.func_78785_a(f5);
        this.leg3.func_78785_a(f5);
        this.tail.func_78785_a(f5);
        EntityDeviantWolf wolf = (EntityDeviantWolf)entity;
        if (wolf.isShimmering()) {
            GlStateManager.func_179147_l();
            GlStateManager.func_179112_b((int)770, (int)771);
            for (int i = -2; i <= 2; ++i) {
                GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)(0.6f - 0.2f * (float)Math.abs(i) + 0.1f * Mth.func_76126_a((float)f2)));
                if (i == 0) continue;
                this.head.field_82906_o = i;
                this.body.field_82906_o = i;
                this.upperBody.field_82906_o = i;
                this.leg0.field_82906_o = i;
                this.leg1.field_82906_o = i;
                this.leg2.field_82906_o = i;
                this.leg3.field_82906_o = i;
                this.tail.field_82906_o = i;
                this.head.func_78785_a(f5);
                this.body.func_78785_a(f5);
                this.upperBody.func_78785_a(f5);
                this.leg0.func_78785_a(f5);
                this.leg1.func_78785_a(f5);
                this.leg2.func_78785_a(f5);
                this.leg3.func_78785_a(f5);
                this.tail.func_78785_a(f5);
            }
            GlStateManager.func_179084_k();
        }
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        float limbRange = 1.4f;
        float limbSpeed = 0.6662f;
        this.leg0.field_78795_f = Mth.func_76134_b((float)(limbSwing * limbSpeed)) * limbRange * limbSwingAmount;
        this.leg1.field_78795_f = Mth.func_76134_b((float)(limbSwing * limbSpeed + (float)Math.PI)) * limbRange * limbSwingAmount;
        this.leg2.field_78795_f = Mth.func_76134_b((float)(limbSwing * limbSpeed + (float)Math.PI)) * limbRange * limbSwingAmount;
        this.leg3.field_78795_f = Mth.func_76134_b((float)(limbSwing * limbSpeed)) * limbRange * limbSwingAmount;
        this.head.field_78796_g = netHeadYaw * ((float)Math.PI / 180);
        this.head.field_78795_f = headPitch * ((float)Math.PI / 180);
    }
}

