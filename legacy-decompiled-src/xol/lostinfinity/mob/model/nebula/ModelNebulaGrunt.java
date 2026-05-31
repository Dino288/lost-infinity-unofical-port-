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
package xol.lostinfinity.mob.model.nebula;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import xol.lostinfinity.mob.entity.nebula.EntityNebulaGrunt;

public class ModelNebulaGrunt
extends ModelBase {
    private final ModelRenderer GlowOrb;
    private final ModelRenderer Body;
    private final ModelRenderer Tendril1;
    private final ModelRenderer Tendril2;
    private final ModelRenderer Tendril3;
    private final ModelRenderer Tendril4;
    private final ModelRenderer Leg1;
    private final ModelRenderer Leg1P2;
    private final ModelRenderer Leg1P3;
    private final ModelRenderer Leg3;
    private final ModelRenderer Leg3P2;
    private final ModelRenderer Leg3P3;
    private final ModelRenderer Leg2;
    private final ModelRenderer Leg2P2;
    private final ModelRenderer Leg2P3;
    private final ModelRenderer Leg4;
    private final ModelRenderer Leg4P2;
    private final ModelRenderer Leg4P3;

    public ModelNebulaGrunt() {
        this.field_78090_t = 128;
        this.field_78089_u = 64;
        this.GlowOrb = new ModelRenderer((ModelBase)this);
        this.GlowOrb.func_78793_a(0.0f, -19.0f, 0.0f);
        this.GlowOrb.field_78804_l.add(new ModelBox(this.GlowOrb, 0, 0, -8.0f, -8.0f, -8.0f, 16, 16, 16, 0.0f, false));
        this.Body = new ModelRenderer((ModelBase)this);
        this.Body.func_78793_a(0.0f, 17.0f, 0.0f);
        this.Body.field_78804_l.add(new ModelBox(this.Body, 80, 49, -6.0f, -28.0f, -6.0f, 12, 3, 12, 0.0f, false));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 0, 40, -8.0f, -25.0f, -8.0f, 16, 8, 16, 0.0f, false));
        this.Tendril1 = new ModelRenderer((ModelBase)this);
        this.Tendril1.func_78793_a(0.0f, -18.0f, -6.0f);
        this.Body.func_78792_a(this.Tendril1);
        this.Tendril1.field_78804_l.add(new ModelBox(this.Tendril1, 70, 14, -1.0f, 0.0f, -1.0f, 2, 16, 2, 0.0f, false));
        this.Tendril1.field_78804_l.add(new ModelBox(this.Tendril1, 68, 4, -1.5f, 16.0f, -1.5f, 3, 3, 3, 0.0f, false));
        this.Tendril2 = new ModelRenderer((ModelBase)this);
        this.Tendril2.func_78793_a(-6.0f, -18.0f, 0.0f);
        this.Body.func_78792_a(this.Tendril2);
        this.Tendril2.field_78804_l.add(new ModelBox(this.Tendril2, 70, 14, -1.0f, 0.0f, -1.0f, 2, 16, 2, 0.0f, false));
        this.Tendril2.field_78804_l.add(new ModelBox(this.Tendril2, 68, 4, -1.5f, 16.0f, -1.5f, 3, 3, 3, 0.0f, false));
        this.Tendril3 = new ModelRenderer((ModelBase)this);
        this.Tendril3.func_78793_a(0.0f, -18.0f, 6.0f);
        this.Body.func_78792_a(this.Tendril3);
        this.Tendril3.field_78804_l.add(new ModelBox(this.Tendril3, 70, 14, -1.0f, 0.0f, -1.0f, 2, 16, 2, 0.0f, false));
        this.Tendril3.field_78804_l.add(new ModelBox(this.Tendril3, 68, 4, -1.5f, 16.0f, -1.5f, 3, 3, 3, 0.0f, false));
        this.Tendril4 = new ModelRenderer((ModelBase)this);
        this.Tendril4.func_78793_a(6.0f, -18.0f, 0.0f);
        this.Body.func_78792_a(this.Tendril4);
        this.Tendril4.field_78804_l.add(new ModelBox(this.Tendril4, 70, 14, -1.0f, 0.0f, -1.0f, 2, 16, 2, 0.0f, false));
        this.Tendril4.field_78804_l.add(new ModelBox(this.Tendril4, 68, 4, -1.5f, 16.0f, -1.5f, 3, 3, 3, 0.0f, false));
        this.Leg1 = new ModelRenderer((ModelBase)this);
        this.Leg1.func_78793_a(7.0f, -20.0f, 0.0f);
        this.Body.func_78792_a(this.Leg1);
        this.Leg1.field_78804_l.add(new ModelBox(this.Leg1, 88, 2, 0.0f, -2.0f, -5.0f, 10, 4, 10, 0.0f, false));
        this.Leg1P2 = new ModelRenderer((ModelBase)this);
        this.Leg1P2.func_78793_a(10.0f, 0.0f, 0.0f);
        this.Leg1.func_78792_a(this.Leg1P2);
        this.setRotationAngle(this.Leg1P2, 0.0f, 0.0f, 0.3491f);
        this.Leg1P2.field_78804_l.add(new ModelBox(this.Leg1P2, 88, 18, -1.0f, -2.0f, -5.0f, 10, 4, 10, -0.1f, false));
        this.Leg1P3 = new ModelRenderer((ModelBase)this);
        this.Leg1P3.func_78793_a(9.0f, 0.0f, 0.0f);
        this.Leg1P2.func_78792_a(this.Leg1P3);
        this.setRotationAngle(this.Leg1P3, 0.0f, 0.0f, 0.3491f);
        this.Leg1P3.field_78804_l.add(new ModelBox(this.Leg1P3, 88, 34, -1.0f, -2.0f, -5.0f, 10, 4, 10, -0.2f, false));
        this.Leg3 = new ModelRenderer((ModelBase)this);
        this.Leg3.func_78793_a(-8.0f, -20.0f, 0.0f);
        this.Body.func_78792_a(this.Leg3);
        this.setRotationAngle(this.Leg3, 0.0f, 3.1416f, 0.0f);
        this.Leg3.field_78804_l.add(new ModelBox(this.Leg3, 88, 2, 0.0f, -2.0f, -5.0f, 10, 4, 10, 0.0f, false));
        this.Leg3P2 = new ModelRenderer((ModelBase)this);
        this.Leg3P2.func_78793_a(10.0f, 0.0f, 0.0f);
        this.Leg3.func_78792_a(this.Leg3P2);
        this.setRotationAngle(this.Leg3P2, 0.0f, 0.0f, 0.3491f);
        this.Leg3P2.field_78804_l.add(new ModelBox(this.Leg3P2, 88, 18, -1.0f, -2.0f, -5.0f, 10, 4, 10, -0.1f, false));
        this.Leg3P3 = new ModelRenderer((ModelBase)this);
        this.Leg3P3.func_78793_a(9.0f, 0.0f, 0.0f);
        this.Leg3P2.func_78792_a(this.Leg3P3);
        this.setRotationAngle(this.Leg3P3, 0.0f, 0.0f, 0.3491f);
        this.Leg3P3.field_78804_l.add(new ModelBox(this.Leg3P3, 88, 34, -1.0f, -2.0f, -5.0f, 10, 4, 10, -0.2f, false));
        this.Leg2 = new ModelRenderer((ModelBase)this);
        this.Leg2.func_78793_a(0.0f, -20.0f, 8.0f);
        this.Body.func_78792_a(this.Leg2);
        this.setRotationAngle(this.Leg2, 0.0f, -1.5708f, 0.0f);
        this.Leg2.field_78804_l.add(new ModelBox(this.Leg2, 88, 2, 0.0f, -2.0f, -5.0f, 10, 4, 10, 0.0f, false));
        this.Leg2P2 = new ModelRenderer((ModelBase)this);
        this.Leg2P2.func_78793_a(10.0f, 0.0f, 0.0f);
        this.Leg2.func_78792_a(this.Leg2P2);
        this.setRotationAngle(this.Leg2P2, 0.0f, 0.0f, 0.3491f);
        this.Leg2P2.field_78804_l.add(new ModelBox(this.Leg2P2, 88, 18, -1.0f, -2.0f, -5.0f, 10, 4, 10, -0.1f, false));
        this.Leg2P3 = new ModelRenderer((ModelBase)this);
        this.Leg2P3.func_78793_a(9.0f, 0.0f, 0.0f);
        this.Leg2P2.func_78792_a(this.Leg2P3);
        this.setRotationAngle(this.Leg2P3, 0.0f, 0.0f, 0.3491f);
        this.Leg2P3.field_78804_l.add(new ModelBox(this.Leg2P3, 88, 34, -1.0f, -2.0f, -5.0f, 10, 4, 10, -0.2f, false));
        this.Leg4 = new ModelRenderer((ModelBase)this);
        this.Leg4.func_78793_a(0.0f, -20.0f, -8.0f);
        this.Body.func_78792_a(this.Leg4);
        this.setRotationAngle(this.Leg4, 0.0f, 1.5708f, 0.0f);
        this.Leg4.field_78804_l.add(new ModelBox(this.Leg4, 88, 2, 0.0f, -2.0f, -5.0f, 10, 4, 10, 0.0f, false));
        this.Leg4P2 = new ModelRenderer((ModelBase)this);
        this.Leg4P2.func_78793_a(10.0f, 0.0f, 0.0f);
        this.Leg4.func_78792_a(this.Leg4P2);
        this.setRotationAngle(this.Leg4P2, 0.0f, 0.0f, 0.3491f);
        this.Leg4P2.field_78804_l.add(new ModelBox(this.Leg4P2, 88, 18, -1.0f, -2.0f, -5.0f, 10, 4, 10, -0.1f, false));
        this.Leg4P3 = new ModelRenderer((ModelBase)this);
        this.Leg4P3.func_78793_a(9.0f, 0.0f, 0.0f);
        this.Leg4P2.func_78792_a(this.Leg4P3);
        this.setRotationAngle(this.Leg4P3, 0.0f, 0.0f, 0.3491f);
        this.Leg4P3.field_78804_l.add(new ModelBox(this.Leg4P3, 88, 34, -1.0f, -2.0f, -5.0f, 10, 4, 10, -0.2f, false));
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        EntityNebulaGrunt nebula = (EntityNebulaGrunt)entity;
        float baseAlpha = nebula.getModelAlpha();
        GlStateManager.func_179147_l();
        GlStateManager.func_179112_b((int)770, (int)771);
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)baseAlpha);
        this.Body.func_78785_a(f5);
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)(baseAlpha * 0.75f));
        this.GlowOrb.func_78785_a(f5);
        GlStateManager.func_179084_k();
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        float tendrilSpeed = 0.2f;
        float tendrilRange = 0.2f;
        float legSpeed = 0.1f;
        float legRange = 0.95f;
        float legSpeedMiddle = 0.05f;
        float legRangeMiddle = 0.3f;
        float legSpeedTip = 0.1f;
        float legRangeTip = 0.4f;
        this.Tendril1.field_78795_f = Mth.func_76134_b((float)(ageInTicks * tendrilSpeed)) * tendrilRange;
        this.Tendril2.field_78795_f = Mth.func_76126_a((float)(ageInTicks * tendrilSpeed)) * tendrilRange;
        this.Tendril3.field_78795_f = Mth.func_76134_b((float)((float)((double)(ageInTicks * tendrilSpeed) + Math.PI))) * tendrilRange;
        this.Tendril4.field_78795_f = Mth.func_76126_a((float)((float)((double)(ageInTicks * tendrilSpeed) + Math.PI))) * tendrilRange;
        this.Tendril1.field_78808_h = Mth.func_76134_b((float)(ageInTicks * tendrilSpeed)) * tendrilRange;
        this.Tendril2.field_78808_h = Mth.func_76126_a((float)(ageInTicks * tendrilSpeed)) * tendrilRange;
        this.Tendril3.field_78808_h = Mth.func_76134_b((float)((float)((double)(ageInTicks * tendrilSpeed) + Math.PI))) * tendrilRange;
        this.Tendril4.field_78808_h = Mth.func_76126_a((float)((float)((double)(ageInTicks * tendrilSpeed) + Math.PI))) * tendrilRange;
        this.Leg1.field_78808_h = Mth.func_76126_a((float)(ageInTicks * legSpeed)) * legRange;
        this.Leg2.field_78808_h = Mth.func_76126_a((float)((ageInTicks + 5.0f) * legSpeed)) * legRange;
        this.Leg3.field_78808_h = Mth.func_76126_a((float)((ageInTicks + 10.0f) * legSpeed)) * legRange;
        this.Leg4.field_78808_h = Mth.func_76126_a((float)((ageInTicks + 15.0f) * legSpeed)) * legRange;
        this.Leg1P2.field_78808_h = -Mth.func_76126_a((float)(ageInTicks * legSpeedMiddle)) * legRangeMiddle;
        this.Leg2P2.field_78808_h = -Mth.func_76126_a((float)((ageInTicks + 5.0f) * legSpeedMiddle)) * legRangeMiddle;
        this.Leg3P2.field_78808_h = -Mth.func_76126_a((float)((ageInTicks + 10.0f) * legSpeedMiddle)) * legRangeMiddle;
        this.Leg4P2.field_78808_h = -Mth.func_76126_a((float)((ageInTicks + 15.0f) * legSpeedMiddle)) * legRangeMiddle;
        this.Leg1P3.field_78808_h = Mth.func_76126_a((float)(ageInTicks * legSpeedTip)) * legRangeTip;
        this.Leg2P3.field_78808_h = Mth.func_76126_a((float)((ageInTicks + 5.0f) * legSpeedTip)) * legRangeTip;
        this.Leg3P3.field_78808_h = Mth.func_76126_a((float)((ageInTicks + 10.0f) * legSpeedTip)) * legRangeTip;
        this.Leg4P3.field_78808_h = Mth.func_76126_a((float)((ageInTicks + 15.0f) * legSpeedTip)) * legRangeTip;
    }
}

