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

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;

public class ModelAugmenticon
extends ModelBase {
    private final ModelRenderer Body;
    private final ModelRenderer head;
    private final ModelRenderer RightArm;
    private final ModelRenderer RightArm_r1;
    private final ModelRenderer LeftArm;
    private final ModelRenderer LeftArm_r1;
    private final ModelRenderer RightLeg;
    private final ModelRenderer RightLeg_r1;
    private final ModelRenderer LeftLeg;
    private final ModelRenderer LeftLeg_r1;
    private final ModelRenderer bb_main;

    public ModelAugmenticon() {
        this.field_78090_t = 128;
        this.field_78089_u = 64;
        this.Body = new ModelRenderer((ModelBase)this);
        this.Body.func_78793_a(0.0f, 0.0f, 0.0f);
        this.Body.field_78804_l.add(new ModelBox(this.Body, 16, 16, -4.0f, -2.0f, -2.0f, 8, 12, 4, -0.9f, false));
        this.head = new ModelRenderer((ModelBase)this);
        this.head.func_78793_a(0.0f, 0.0f, 0.0f);
        this.head.field_78804_l.add(new ModelBox(this.head, 0, 0, -4.0f, -8.0f, -4.0f, 8, 8, 8, -0.85f, false));
        this.RightArm = new ModelRenderer((ModelBase)this);
        this.RightArm.func_78793_a(-5.0f, 2.0f, 0.0f);
        this.RightArm_r1 = new ModelRenderer((ModelBase)this);
        this.RightArm_r1.func_78793_a(2.0f, -2.0f, 0.0f);
        this.RightArm.func_78792_a(this.RightArm_r1);
        this.setRotationAngle(this.RightArm_r1, 0.0f, 0.0f, 0.5236f);
        this.RightArm_r1.field_78804_l.add(new ModelBox(this.RightArm_r1, 40, 16, -3.0f, -2.0f, -2.0f, 4, 12, 4, -0.85f, false));
        this.LeftArm = new ModelRenderer((ModelBase)this);
        this.LeftArm.func_78793_a(5.0f, 2.0f, 0.0f);
        this.LeftArm_r1 = new ModelRenderer((ModelBase)this);
        this.LeftArm_r1.func_78793_a(-2.0f, -2.0f, 0.0f);
        this.LeftArm.func_78792_a(this.LeftArm_r1);
        this.setRotationAngle(this.LeftArm_r1, 0.0f, 0.0f, -0.5236f);
        this.LeftArm_r1.field_78804_l.add(new ModelBox(this.LeftArm_r1, 40, 16, -1.0f, -2.0f, -2.0f, 4, 12, 4, -0.85f, true));
        this.RightLeg = new ModelRenderer((ModelBase)this);
        this.RightLeg.func_78793_a(-1.9f, 12.0f, 0.0f);
        this.RightLeg_r1 = new ModelRenderer((ModelBase)this);
        this.RightLeg_r1.func_78793_a(0.0f, -3.0f, 0.0f);
        this.RightLeg.func_78792_a(this.RightLeg_r1);
        this.setRotationAngle(this.RightLeg_r1, 0.0f, 0.0f, 0.0873f);
        this.RightLeg_r1.field_78804_l.add(new ModelBox(this.RightLeg_r1, 0, 16, -2.0f, -1.0f, -2.0f, 4, 12, 4, -0.85f, false));
        this.LeftLeg = new ModelRenderer((ModelBase)this);
        this.LeftLeg.func_78793_a(1.9f, 12.0f, 0.0f);
        this.LeftLeg_r1 = new ModelRenderer((ModelBase)this);
        this.LeftLeg_r1.func_78793_a(0.0f, -3.0f, 0.0f);
        this.LeftLeg.func_78792_a(this.LeftLeg_r1);
        this.setRotationAngle(this.LeftLeg_r1, 0.0f, 0.0f, -0.0873f);
        this.LeftLeg_r1.field_78804_l.add(new ModelBox(this.LeftLeg_r1, 0, 16, -2.0f, -1.0f, -2.0f, 4, 12, 4, -0.85f, true));
        this.bb_main = new ModelRenderer((ModelBase)this);
        this.bb_main.func_78793_a(0.0f, 24.0f, 0.0f);
        this.bb_main.field_78804_l.add(new ModelBox(this.bb_main, 32, 16, -12.0f, -28.0f, -12.0f, 24, 24, 24, 4.0f, false));
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.Body.func_78785_a(f5);
        this.head.func_78785_a(f5);
        this.RightArm.func_78785_a(f5);
        this.LeftArm.func_78785_a(f5);
        this.RightLeg.func_78785_a(f5);
        this.LeftLeg.func_78785_a(f5);
        GlStateManager.func_179147_l();
        GlStateManager.func_179112_b((int)770, (int)771);
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)0.75f);
        this.bb_main.func_78785_a(f5);
        GlStateManager.func_179084_k();
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.RightArm.field_78808_h = Mth.func_76134_b((float)(ageInTicks * 0.1f)) * 0.1f + 0.15799388f;
        this.LeftArm.field_78808_h = -this.RightArm.field_78808_h;
        this.RightLeg.field_78808_h = Mth.func_76126_a((float)(ageInTicks * 0.1f)) * 0.2f + 0.25799388f;
        this.LeftLeg.field_78808_h = -this.RightLeg.field_78808_h;
    }
}

