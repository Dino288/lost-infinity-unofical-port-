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
import java.util.Collections;
import java.util.List;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;

public class ModelFlutterbee
extends ModelBase {
    private final ModelRenderer WingR;
    private final ModelRenderer WingL;
    private final ModelRenderer Body;
    private final ModelRenderer Head;
    private final ModelRenderer cube_r1;
    private final ModelRenderer WingL2;
    private final ModelRenderer WingR2;
    private final ModelRenderer Leg1;
    private final ModelRenderer Leg2;
    private final ModelRenderer Leg3;
    private final ModelRenderer Leg4;
    private final ModelRenderer Leg5;
    private final ModelRenderer Leg6;
    private List<ModelRenderer> legs = new ArrayList<ModelRenderer>();

    public ModelFlutterbee() {
        this.field_78090_t = 128;
        this.field_78089_u = 64;
        this.WingR = new ModelRenderer((ModelBase)this);
        this.WingR.func_78793_a(-8.0f, 13.5f, 13.0f);
        this.WingR.field_78804_l.add(new ModelBox(this.WingR, 56, 27, -20.0f, -0.5f, -8.0f, 20, 1, 16, 0.0f, true));
        this.WingL = new ModelRenderer((ModelBase)this);
        this.WingL.func_78793_a(8.0f, 13.5f, 13.0f);
        this.WingL.field_78804_l.add(new ModelBox(this.WingL, 56, 27, 0.0f, -0.5f, -8.0f, 20, 1, 16, 0.0f, false));
        this.Body = new ModelRenderer((ModelBase)this);
        this.Body.func_78793_a(0.0f, 7.0f, 0.0f);
        this.Body.field_78804_l.add(new ModelBox(this.Body, 0, 11, -6.0f, 7.0f, -3.0f, 12, 10, 8, 0.0f, false));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 42, 11, -7.0f, 4.0f, 21.0f, 14, 12, 2, 0.0f, false));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 0, 30, -8.0f, 3.0f, 5.0f, 16, 14, 16, 0.0f, false));
        this.Head = new ModelRenderer((ModelBase)this);
        this.Head.func_78793_a(0.0f, 15.0f, -3.0f);
        this.Head.field_78804_l.add(new ModelBox(this.Head, 0, 0, -7.0f, -9.0f, -5.0f, 6, 6, 4, 0.0f, false));
        this.Head.field_78804_l.add(new ModelBox(this.Head, 0, 0, 1.0f, -9.0f, -5.0f, 6, 6, 4, 0.0f, false));
        this.cube_r1 = new ModelRenderer((ModelBase)this);
        this.cube_r1.func_78793_a(-4.0f, -6.0f, 1.0f);
        this.Head.func_78792_a(this.cube_r1);
        this.setRotationAngle(this.cube_r1, -0.3491f, 0.0f, 0.0f);
        this.cube_r1.field_78804_l.add(new ModelBox(this.cube_r1, 38, 5, 1.0f, 2.0f, 3.0f, 2, 3, 2, 0.0f, false));
        this.cube_r1.field_78804_l.add(new ModelBox(this.cube_r1, 38, 5, 5.0f, 2.0f, 3.0f, 2, 3, 2, 0.0f, false));
        this.cube_r1.field_78804_l.add(new ModelBox(this.cube_r1, 32, 0, -1.0f, 0.0f, 3.0f, 10, 2, 2, 0.0f, false));
        this.cube_r1.field_78804_l.add(new ModelBox(this.cube_r1, 21, 0, 7.0f, 0.0f, -3.0f, 2, 2, 6, 0.0f, false));
        this.cube_r1.field_78804_l.add(new ModelBox(this.cube_r1, 21, 0, -1.0f, 0.0f, -3.0f, 2, 2, 6, 0.0f, false));
        this.WingL2 = new ModelRenderer((ModelBase)this);
        this.WingL2.func_78793_a(8.0f, 19.5f, 13.0f);
        this.WingL2.field_78804_l.add(new ModelBox(this.WingL2, 56, 27, 0.0f, -0.5f, -8.0f, 20, 1, 16, 0.0f, false));
        this.WingR2 = new ModelRenderer((ModelBase)this);
        this.WingR2.func_78793_a(-8.0f, 19.5f, 13.0f);
        this.WingR2.field_78804_l.add(new ModelBox(this.WingR2, 56, 27, -20.0f, -0.5f, -8.0f, 20, 1, 16, 0.0f, true));
        this.Leg1 = new ModelRenderer((ModelBase)this);
        this.Leg1.func_78793_a(5.0f, 24.0f, 10.0f);
        this.setRotationAngle(this.Leg1, 0.3491f, 0.0f, 0.0f);
        this.Leg1.field_78804_l.add(new ModelBox(this.Leg1, 63, 0, -1.0f, -1.0f, -1.0f, 2, 6, 2, 0.0f, false));
        this.Leg2 = new ModelRenderer((ModelBase)this);
        this.Leg2.func_78793_a(-5.0f, 24.0f, 10.0f);
        this.setRotationAngle(this.Leg2, 0.3491f, 0.0f, 0.0f);
        this.Leg2.field_78804_l.add(new ModelBox(this.Leg2, 63, 0, -1.0f, -1.0f, -1.0f, 2, 6, 2, 0.0f, false));
        this.Leg3 = new ModelRenderer((ModelBase)this);
        this.Leg3.func_78793_a(-5.0f, 24.0f, 15.0f);
        this.setRotationAngle(this.Leg3, 0.3491f, 0.0f, 0.0f);
        this.Leg3.field_78804_l.add(new ModelBox(this.Leg3, 63, 0, -1.0f, -1.0f, -1.0f, 2, 6, 2, 0.0f, false));
        this.Leg4 = new ModelRenderer((ModelBase)this);
        this.Leg4.func_78793_a(5.0f, 24.0f, 15.0f);
        this.setRotationAngle(this.Leg4, 0.3491f, 0.0f, 0.0f);
        this.Leg4.field_78804_l.add(new ModelBox(this.Leg4, 63, 0, -1.0f, -1.0f, -1.0f, 2, 6, 2, 0.0f, false));
        this.Leg5 = new ModelRenderer((ModelBase)this);
        this.Leg5.func_78793_a(5.0f, 24.0f, 20.0f);
        this.setRotationAngle(this.Leg5, 0.3491f, 0.0f, 0.0f);
        this.Leg5.field_78804_l.add(new ModelBox(this.Leg5, 63, 0, -1.0f, -1.0f, -1.0f, 2, 6, 2, 0.0f, false));
        this.Leg6 = new ModelRenderer((ModelBase)this);
        this.Leg6.func_78793_a(-5.0f, 24.0f, 20.0f);
        this.setRotationAngle(this.Leg6, 0.3491f, 0.0f, 0.0f);
        this.Leg6.field_78804_l.add(new ModelBox(this.Leg6, 63, 0, -1.0f, -1.0f, -1.0f, 2, 6, 2, 0.0f, false));
        this.legs.add(this.Leg1);
        this.legs.add(this.Leg2);
        this.legs.add(this.Leg3);
        this.legs.add(this.Leg4);
        this.legs.add(this.Leg5);
        this.legs.add(this.Leg6);
        Collections.shuffle(this.legs);
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        GlStateManager.func_179147_l();
        GlStateManager.func_179112_b((int)770, (int)771);
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)0.85f);
        this.WingR.func_78785_a(f5);
        this.WingL.func_78785_a(f5);
        this.WingL2.func_78785_a(f5);
        this.WingR2.func_78785_a(f5);
        GlStateManager.func_179084_k();
        this.Body.func_78785_a(f5);
        this.Head.func_78785_a(f5);
        this.Leg1.func_78785_a(f5);
        this.Leg2.func_78785_a(f5);
        this.Leg3.func_78785_a(f5);
        this.Leg4.func_78785_a(f5);
        this.Leg5.func_78785_a(f5);
        this.Leg6.func_78785_a(f5);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.WingL2.field_78808_h = this.WingL.field_78808_h = Mth.func_76134_b((float)(ageInTicks * 1.5f)) * (float)Math.PI * 0.15f;
        this.WingR.field_78808_h = -this.WingL.field_78808_h;
        this.WingR2.field_78808_h = -this.WingL.field_78808_h;
        for (int i = 0; i < this.legs.size(); ++i) {
            ModelRenderer indiv_leg = this.legs.get(i);
            indiv_leg.field_78795_f = 0.3491f + 0.2f * Mth.func_76126_a((float)(0.3f * (ageInTicks + (float)(i * 15))));
        }
    }
}

