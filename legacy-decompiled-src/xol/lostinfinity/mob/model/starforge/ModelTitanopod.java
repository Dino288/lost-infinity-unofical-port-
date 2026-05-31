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

public class ModelTitanopod
extends ModelBase {
    private final ModelRenderer GlowCube;
    private final ModelRenderer Body;
    private final ModelRenderer Eye;
    private final ModelRenderer Leg1;
    private final ModelRenderer Leg2;
    private final ModelRenderer Leg3;
    private final ModelRenderer Leg4;
    private final ModelRenderer Leg5;
    private final ModelRenderer Leg6;
    private final ModelRenderer Leg7;
    private final ModelRenderer Leg8;
    private final ModelRenderer Leg9;
    private final ModelRenderer Leg10;
    private List<ModelRenderer> leg_list = new ArrayList<ModelRenderer>();

    public ModelTitanopod() {
        this.field_78090_t = 128;
        this.field_78089_u = 64;
        this.GlowCube = new ModelRenderer((ModelBase)this);
        this.GlowCube.func_78793_a(0.0f, -2.0f, 0.0f);
        this.GlowCube.field_78804_l.add(new ModelBox(this.GlowCube, 0, 0, -8.0f, -24.0f, -8.0f, 16, 14, 16, 0.0f, false));
        this.GlowCube.field_78804_l.add(new ModelBox(this.GlowCube, 0, 0, -8.0f, -52.0f, -8.0f, 16, 14, 16, 0.0f, false));
        this.GlowCube.field_78804_l.add(new ModelBox(this.GlowCube, 57, 44, -5.0f, -64.0f, -5.0f, 10, 10, 10, 0.0f, false));
        this.Body = new ModelRenderer((ModelBase)this);
        this.Body.func_78793_a(0.0f, 7.0f, 0.0f);
        this.Body.field_78804_l.add(new ModelBox(this.Body, 0, 30, -8.0f, -19.0f, -8.0f, 16, 2, 16, 0.25f, false));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 0, 30, -8.0f, -47.0f, -8.0f, 16, 2, 16, 0.25f, false));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 0, 50, -6.0f, -63.0f, -6.0f, 12, 2, 12, 0.25f, false));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 64, 0, -8.0f, -37.0f, -8.0f, 16, 4, 16, 0.25f, false));
        this.Eye = new ModelRenderer((ModelBase)this);
        this.Eye.func_78793_a(0.0f, -41.0f, 0.0f);
        this.Body.func_78792_a(this.Eye);
        this.Eye.field_78804_l.add(new ModelBox(this.Eye, 48, 0, -4.0f, -4.0f, -4.0f, 8, 8, 8, 0.0f, false));
        this.Leg1 = new ModelRenderer((ModelBase)this);
        this.Leg1.func_78793_a(-6.0f, -10.0f, 0.0f);
        this.Leg1.field_78804_l.add(new ModelBox(this.Leg1, 109, 28, -1.0f, 0.0f, -1.0f, 2, 34, 2, 0.0f, false));
        this.Leg2 = new ModelRenderer((ModelBase)this);
        this.Leg2.func_78793_a(-1.0f, -10.0f, -5.0f);
        this.Leg2.field_78804_l.add(new ModelBox(this.Leg2, 109, 28, -1.0f, 0.0f, -1.0f, 2, 34, 2, 0.0f, false));
        this.Leg3 = new ModelRenderer((ModelBase)this);
        this.Leg3.func_78793_a(-5.0f, -10.0f, -6.0f);
        this.Leg3.field_78804_l.add(new ModelBox(this.Leg3, 120, 28, -1.0f, 0.0f, -1.0f, 2, 34, 2, 0.0f, false));
        this.Leg4 = new ModelRenderer((ModelBase)this);
        this.Leg4.func_78793_a(3.0f, -10.0f, -4.0f);
        this.Leg4.field_78804_l.add(new ModelBox(this.Leg4, 120, 28, -1.0f, 0.0f, -1.0f, 2, 34, 2, 0.0f, false));
        this.Leg5 = new ModelRenderer((ModelBase)this);
        this.Leg5.func_78793_a(6.0f, -10.0f, -6.0f);
        this.Leg5.field_78804_l.add(new ModelBox(this.Leg5, 109, 28, -1.0f, 0.0f, -1.0f, 2, 34, 2, 0.0f, false));
        this.Leg6 = new ModelRenderer((ModelBase)this);
        this.Leg6.func_78793_a(5.0f, -10.0f, 0.0f);
        this.Leg6.field_78804_l.add(new ModelBox(this.Leg6, 109, 28, -1.0f, 0.0f, -1.0f, 2, 34, 2, 0.0f, false));
        this.Leg7 = new ModelRenderer((ModelBase)this);
        this.Leg7.func_78793_a(0.0f, -10.0f, 2.0f);
        this.Leg7.field_78804_l.add(new ModelBox(this.Leg7, 120, 28, -1.0f, 0.0f, -1.0f, 2, 34, 2, 0.0f, false));
        this.Leg8 = new ModelRenderer((ModelBase)this);
        this.Leg8.func_78793_a(4.0f, -10.0f, 6.0f);
        this.Leg8.field_78804_l.add(new ModelBox(this.Leg8, 120, 28, -1.0f, 0.0f, -1.0f, 2, 34, 2, 0.0f, false));
        this.Leg9 = new ModelRenderer((ModelBase)this);
        this.Leg9.func_78793_a(-3.0f, -10.0f, 5.0f);
        this.Leg9.field_78804_l.add(new ModelBox(this.Leg9, 109, 28, -1.0f, 0.0f, -1.0f, 2, 34, 2, 0.0f, false));
        this.Leg10 = new ModelRenderer((ModelBase)this);
        this.Leg10.func_78793_a(-6.0f, -10.0f, 6.0f);
        this.Leg10.field_78804_l.add(new ModelBox(this.Leg10, 120, 28, -1.0f, 0.0f, -1.0f, 2, 34, 2, 0.0f, false));
        this.leg_list.add(this.Leg1);
        this.leg_list.add(this.Leg2);
        this.leg_list.add(this.Leg3);
        this.leg_list.add(this.Leg4);
        this.leg_list.add(this.Leg5);
        this.leg_list.add(this.Leg6);
        this.leg_list.add(this.Leg7);
        this.leg_list.add(this.Leg8);
        this.leg_list.add(this.Leg9);
        this.leg_list.add(this.Leg10);
        Collections.shuffle(this.leg_list);
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.Body.func_78785_a(f5);
        GlStateManager.func_179147_l();
        GlStateManager.func_179112_b((int)770, (int)771);
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)0.75f);
        this.GlowCube.func_78785_a(f5);
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)0.4f);
        this.Leg1.func_78785_a(f5);
        this.Leg2.func_78785_a(f5);
        this.Leg3.func_78785_a(f5);
        this.Leg4.func_78785_a(f5);
        this.Leg5.func_78785_a(f5);
        this.Leg6.func_78785_a(f5);
        this.Leg7.func_78785_a(f5);
        this.Leg8.func_78785_a(f5);
        this.Leg9.func_78785_a(f5);
        this.Leg10.func_78785_a(f5);
        GlStateManager.func_179084_k();
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        for (ModelRenderer legseg : this.leg_list) {
            legseg.field_78795_f = 0.3f * Mth.func_76126_a((float)((ageInTicks + (float)this.leg_list.indexOf(legseg)) * 0.1f));
            legseg.field_78808_h = 0.3f * Mth.func_76126_a((float)((ageInTicks + (float)this.leg_list.indexOf(legseg)) * 0.11f));
        }
        this.Eye.field_78796_g = netHeadYaw * ((float)Math.PI / 180);
        this.Eye.field_78795_f = headPitch * ((float)Math.PI / 180);
    }
}

