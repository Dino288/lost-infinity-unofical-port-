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

public class ModelDeviantHusk
extends ModelBase {
    private final ModelRenderer Body;
    private final ModelRenderer Body_r1;
    private final ModelRenderer head;
    private final ModelRenderer LeftArm;
    private final ModelRenderer RightLeg;
    private final ModelRenderer LeftLeg;
    private final ModelRenderer RightArm;
    private final ModelRenderer mask;

    public ModelDeviantHusk() {
        this.field_78090_t = 64;
        this.field_78089_u = 64;
        this.Body = new ModelRenderer((ModelBase)this);
        this.Body.func_78793_a(0.0f, 0.0f, 0.0f);
        this.Body_r1 = new ModelRenderer((ModelBase)this);
        this.Body_r1.func_78793_a(0.0f, 24.0f, 0.0f);
        this.Body.func_78792_a(this.Body_r1);
        this.setRotationAngle(this.Body_r1, 0.1745f, 0.0f, 0.0f);
        this.Body_r1.field_78804_l.add(new ModelBox(this.Body_r1, 0, 49, 0.0f, -20.0f, 3.0f, 3, 3, 4, -0.5f, false));
        this.Body_r1.field_78804_l.add(new ModelBox(this.Body_r1, 0, 41, -4.0f, -23.0f, 3.0f, 3, 3, 4, -0.5f, false));
        this.Body_r1.field_78804_l.add(new ModelBox(this.Body_r1, 0, 33, -2.0f, -16.0f, 3.0f, 3, 3, 4, -0.5f, false));
        this.Body_r1.field_78804_l.add(new ModelBox(this.Body_r1, 16, 16, -4.0f, -24.0f, 0.0f, 8, 12, 4, 0.1f, false));
        this.head = new ModelRenderer((ModelBase)this);
        this.head.func_78793_a(0.0f, 0.0f, -2.0f);
        this.head.field_78804_l.add(new ModelBox(this.head, 0, 0, -4.0f, -8.0f, -4.0f, 8, 8, 8, 0.0f, false));
        this.LeftArm = new ModelRenderer((ModelBase)this);
        this.LeftArm.func_78793_a(5.0f, 2.0f, -1.0f);
        this.LeftArm.field_78804_l.add(new ModelBox(this.LeftArm, 40, 16, -1.0f, -2.0f, -2.0f, 4, 12, 4, 0.0f, true));
        this.LeftArm.field_78804_l.add(new ModelBox(this.LeftArm, 54, 46, 0.0f, -5.0f, 2.0f, 1, 12, 4, 0.0f, false));
        this.LeftArm.field_78804_l.add(new ModelBox(this.LeftArm, 21, 42, 1.0f, 0.0f, -2.0f, 1, 12, 8, 0.0f, false));
        this.LeftArm.field_78804_l.add(new ModelBox(this.LeftArm, 21, 42, -1.0f, 0.0f, -2.0f, 1, 12, 8, 0.0f, false));
        this.LeftArm.field_78804_l.add(new ModelBox(this.LeftArm, 40, 33, -1.0f, 10.0f, -2.0f, 4, 12, 4, 0.0f, false));
        this.RightLeg = new ModelRenderer((ModelBase)this);
        this.RightLeg.func_78793_a(-1.9f, 12.0f, 0.0f);
        this.RightLeg.field_78804_l.add(new ModelBox(this.RightLeg, 0, 16, -2.0f, 0.0f, -2.0f, 4, 12, 4, 0.0f, false));
        this.LeftLeg = new ModelRenderer((ModelBase)this);
        this.LeftLeg.func_78793_a(1.9f, 12.0f, 0.0f);
        this.LeftLeg.field_78804_l.add(new ModelBox(this.LeftLeg, 0, 16, -2.0f, 0.0f, -2.0f, 4, 12, 4, 0.0f, true));
        this.RightArm = new ModelRenderer((ModelBase)this);
        this.RightArm.func_78793_a(-5.0f, 2.0f, -1.0f);
        this.RightArm.field_78804_l.add(new ModelBox(this.RightArm, 40, 16, -3.0f, -2.0f, -2.0f, 4, 12, 4, 0.0f, false));
        this.RightArm.field_78804_l.add(new ModelBox(this.RightArm, 54, 46, -1.0f, -5.0f, 2.0f, 1, 12, 4, 0.0f, true));
        this.RightArm.field_78804_l.add(new ModelBox(this.RightArm, 21, 42, -2.0f, 0.0f, -2.0f, 1, 12, 8, 0.0f, true));
        this.RightArm.field_78804_l.add(new ModelBox(this.RightArm, 21, 42, 0.0f, 0.0f, -2.0f, 1, 12, 8, 0.0f, true));
        this.RightArm.field_78804_l.add(new ModelBox(this.RightArm, 40, 33, -3.0f, 10.0f, -2.0f, 4, 12, 4, 0.0f, true));
        this.mask = new ModelRenderer((ModelBase)this);
        this.mask.func_78793_a(0.0f, 0.0f, -2.0f);
        this.mask.field_78804_l.add(new ModelBox(this.mask, 32, 0, -4.0f, -8.0f, -4.0f, 8, 8, 8, 0.3f, false));
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.Body.func_78785_a(f5);
        this.head.func_78785_a(f5);
        this.LeftArm.func_78785_a(f5);
        this.RightLeg.func_78785_a(f5);
        this.LeftLeg.func_78785_a(f5);
        this.RightArm.func_78785_a(f5);
        GlStateManager.func_179147_l();
        GlStateManager.func_179112_b((int)770, (int)771);
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)(0.5f + 0.25f * Mth.func_76126_a((float)(f2 * 0.3f))));
        this.mask.func_78785_a(f5);
        GlStateManager.func_179084_k();
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        float limbRange = 1.4f;
        float limbSpeed = 0.6662f;
        this.LeftArm.field_78795_f = Mth.func_76134_b((float)(limbSwing * limbSpeed)) * limbRange * limbSwingAmount;
        this.RightArm.field_78795_f = Mth.func_76134_b((float)(limbSwing * limbSpeed + (float)Math.PI)) * limbRange * limbSwingAmount;
        this.LeftLeg.field_78795_f = Mth.func_76134_b((float)(limbSwing * limbSpeed + (float)Math.PI)) * limbRange * limbSwingAmount;
        this.RightLeg.field_78795_f = Mth.func_76134_b((float)(limbSwing * limbSpeed)) * limbRange * limbSwingAmount;
        this.head.field_78796_g = netHeadYaw * ((float)Math.PI / 180);
        this.mask.field_78796_g = netHeadYaw * ((float)Math.PI / 180);
        this.head.field_78795_f = headPitch * ((float)Math.PI / 180);
        this.mask.field_78795_f = headPitch * ((float)Math.PI / 180);
    }
}

