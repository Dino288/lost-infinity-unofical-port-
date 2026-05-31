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
import xol.lostinfinity.mob.entity.starforge.EntityGalacticTerror;

public class ModelGalacticTerror
extends ModelBase {
    private final ModelRenderer Body;
    private final ModelRenderer MouthL;
    private final ModelRenderer cube_r1;
    private final ModelRenderer MouthR;
    private final ModelRenderer cube_r2;
    private final ModelRenderer Tail1;
    private final ModelRenderer Tail2;
    private final ModelRenderer Tail3;
    private final ModelRenderer Tail4;

    public ModelGalacticTerror() {
        this.field_78090_t = 128;
        this.field_78089_u = 64;
        this.Body = new ModelRenderer((ModelBase)this);
        this.Body.func_78793_a(0.0f, 14.0f, 11.0f);
        this.Body.field_78804_l.add(new ModelBox(this.Body, 0, 25, -6.0f, -1.5f, -8.0f, 12, 9, 16, 0.0f, false));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 103, 24, -3.0f, -2.5f, -7.0f, 6, 1, 6, 0.0f, false));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 103, 32, -3.0f, -2.5f, 1.0f, 6, 1, 6, 0.0f, false));
        this.MouthL = new ModelRenderer((ModelBase)this);
        this.MouthL.func_78793_a(0.0f, 14.0f, 3.0f);
        this.setRotationAngle(this.MouthL, 0.0f, -0.5672f, 0.0f);
        this.MouthL.field_78804_l.add(new ModelBox(this.MouthL, 0, 0, 0.0f, -1.0f, -16.0f, 6, 8, 16, 0.0f, false));
        this.MouthL.field_78804_l.add(new ModelBox(this.MouthL, 0, 0, -0.1f, 5.0f, -15.0f, 6, 1, 1, 0.0f, false));
        this.MouthL.field_78804_l.add(new ModelBox(this.MouthL, 0, 0, -0.1f, 3.0f, -15.0f, 6, 1, 1, 0.0f, false));
        this.MouthL.field_78804_l.add(new ModelBox(this.MouthL, 0, 0, -0.1f, 1.0f, -15.0f, 6, 1, 1, 0.0f, false));
        this.cube_r1 = new ModelRenderer((ModelBase)this);
        this.cube_r1.func_78793_a(-2.1f, 1.5f, -14.5f);
        this.MouthL.func_78792_a(this.cube_r1);
        this.setRotationAngle(this.cube_r1, 0.0f, 0.6109f, 0.0f);
        this.cube_r1.field_78804_l.add(new ModelBox(this.cube_r1, 0, 4, -2.0f, -0.5f, 0.5f, 4, 1, 1, -0.1f, false));
        this.cube_r1.field_78804_l.add(new ModelBox(this.cube_r1, 0, 4, -2.0f, 1.5f, 0.5f, 4, 1, 1, -0.1f, false));
        this.cube_r1.field_78804_l.add(new ModelBox(this.cube_r1, 0, 4, -2.0f, 3.5f, 0.5f, 4, 1, 1, -0.1f, false));
        this.MouthR = new ModelRenderer((ModelBase)this);
        this.MouthR.func_78793_a(0.0f, 14.0f, 3.0f);
        this.setRotationAngle(this.MouthR, 0.0f, 0.6109f, 0.0f);
        this.MouthR.field_78804_l.add(new ModelBox(this.MouthR, 0, 0, -6.0f, -1.0f, -16.0f, 6, 8, 16, 0.0f, true));
        this.MouthR.field_78804_l.add(new ModelBox(this.MouthR, 0, 0, -5.9f, 4.0f, -15.0f, 6, 1, 1, 0.0f, true));
        this.MouthR.field_78804_l.add(new ModelBox(this.MouthR, 0, 0, -5.9f, 2.0f, -15.0f, 6, 1, 1, 0.0f, true));
        this.MouthR.field_78804_l.add(new ModelBox(this.MouthR, 0, 0, -5.9f, 0.0f, -15.0f, 6, 1, 1, 0.0f, true));
        this.cube_r2 = new ModelRenderer((ModelBase)this);
        this.cube_r2.func_78793_a(2.1f, 0.5f, -14.5f);
        this.MouthR.func_78792_a(this.cube_r2);
        this.setRotationAngle(this.cube_r2, 0.0f, -0.6109f, 0.0f);
        this.cube_r2.field_78804_l.add(new ModelBox(this.cube_r2, 0, 4, -2.0f, -0.5f, 0.5f, 4, 1, 1, -0.1f, true));
        this.cube_r2.field_78804_l.add(new ModelBox(this.cube_r2, 0, 4, -2.0f, 1.5f, 0.5f, 4, 1, 1, -0.1f, true));
        this.cube_r2.field_78804_l.add(new ModelBox(this.cube_r2, 0, 4, -2.0f, 3.5f, 0.5f, 4, 1, 1, -0.1f, true));
        this.Tail1 = new ModelRenderer((ModelBase)this);
        this.Tail1.func_78793_a(0.0f, 17.0f, 20.0f);
        this.Tail1.field_78804_l.add(new ModelBox(this.Tail1, 46, 0, -5.0f, -3.5f, -3.0f, 10, 7, 14, 0.0f, false));
        this.Tail1.field_78804_l.add(new ModelBox(this.Tail1, 109, 40, -2.0f, -4.5f, 0.0f, 4, 1, 4, 0.0f, false));
        this.Tail1.field_78804_l.add(new ModelBox(this.Tail1, 109, 46, -2.0f, -4.5f, 6.0f, 4, 1, 4, 0.0f, false));
        this.Tail2 = new ModelRenderer((ModelBase)this);
        this.Tail2.func_78793_a(0.0f, 0.0f, 12.0f);
        this.Tail1.func_78792_a(this.Tail2);
        this.Tail2.field_78804_l.add(new ModelBox(this.Tail2, 46, 21, -4.0f, -2.5f, -3.0f, 8, 5, 12, 0.0f, false));
        this.Tail2.field_78804_l.add(new ModelBox(this.Tail2, 113, 52, -1.0f, -3.5f, 0.0f, 2, 1, 2, 0.0f, false));
        this.Tail2.field_78804_l.add(new ModelBox(this.Tail2, 113, 56, -1.0f, -3.5f, 3.0f, 2, 1, 2, 0.0f, false));
        this.Tail2.field_78804_l.add(new ModelBox(this.Tail2, 113, 56, -1.0f, -3.5f, 6.0f, 2, 1, 2, 0.0f, false));
        this.Tail3 = new ModelRenderer((ModelBase)this);
        this.Tail3.func_78793_a(0.0f, 0.0f, 7.0f);
        this.Tail2.func_78792_a(this.Tail3);
        this.Tail3.field_78804_l.add(new ModelBox(this.Tail3, 57, 40, -3.0f, -1.5f, 0.0f, 6, 3, 10, 0.0f, false));
        this.Tail4 = new ModelRenderer((ModelBase)this);
        this.Tail4.func_78793_a(0.0f, 0.0f, 5.0f);
        this.Tail3.func_78792_a(this.Tail4);
        this.Tail4.field_78804_l.add(new ModelBox(this.Tail4, 97, 0, 1.0f, -6.5f, 2.0f, 1, 12, 10, 0.0f, false));
        this.Tail4.field_78804_l.add(new ModelBox(this.Tail4, 97, 0, -2.0f, -6.5f, 2.0f, 1, 12, 10, 0.0f, false));
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        float alpha = 1.0f;
        if (entity instanceof EntityGalacticTerror) {
            EntityGalacticTerror terror = (EntityGalacticTerror)entity;
            alpha = terror.getRenderAlpha();
        }
        GlStateManager.func_179147_l();
        GlStateManager.func_179112_b((int)770, (int)771);
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)alpha);
        this.Body.func_78785_a(f5);
        this.MouthL.func_78785_a(f5);
        this.MouthR.func_78785_a(f5);
        this.Tail1.func_78785_a(f5);
        GlStateManager.func_179084_k();
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.MouthL.field_78796_g = -0.7f + 0.7f * Mth.func_76126_a((float)(ageInTicks * 0.1f));
        this.MouthR.field_78796_g = -this.MouthL.field_78796_g;
        this.Tail1.field_78796_g = 0.5f * Mth.func_76126_a((float)(ageInTicks * 0.1f));
        this.Tail2.field_78796_g = 0.4f * Mth.func_76126_a((float)(ageInTicks * 0.1f));
        this.Tail3.field_78796_g = 0.3f * Mth.func_76126_a((float)(ageInTicks * 0.1f));
        this.Tail4.field_78796_g = 0.2f * Mth.func_76126_a((float)(ageInTicks * 0.1f));
    }
}

