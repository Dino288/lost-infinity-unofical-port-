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
package xol.lostinfinity.mob.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;

public class ModelPlasmaExplosion
extends ModelBase {
    private final ModelRenderer Core;
    private final ModelRenderer ZWing;
    private final ModelRenderer XWing;

    public ModelPlasmaExplosion() {
        this.field_78090_t = 64;
        this.field_78089_u = 32;
        this.Core = new ModelRenderer((ModelBase)this);
        this.Core.func_78793_a(0.0f, 24.0f, 0.0f);
        this.Core.field_78804_l.add(new ModelBox(this.Core, 17, 0, -3.0f, -3.0f, -3.0f, 6, 6, 6, 0.0f, false));
        this.ZWing = new ModelRenderer((ModelBase)this);
        this.ZWing.func_78793_a(0.0f, 0.0f, 0.0f);
        this.Core.func_78792_a(this.ZWing);
        this.ZWing.field_78804_l.add(new ModelBox(this.ZWing, 0, 0, 6.0f, -2.0f, -2.0f, 4, 4, 4, 0.0f, false));
        this.ZWing.field_78804_l.add(new ModelBox(this.ZWing, 0, 0, -2.0f, -10.0f, -2.0f, 4, 4, 4, 0.0f, false));
        this.ZWing.field_78804_l.add(new ModelBox(this.ZWing, 0, 0, -2.0f, 6.0f, -2.0f, 4, 4, 4, 0.0f, false));
        this.ZWing.field_78804_l.add(new ModelBox(this.ZWing, 0, 0, -10.0f, -2.0f, -2.0f, 4, 4, 4, 0.0f, false));
        this.XWing = new ModelRenderer((ModelBase)this);
        this.XWing.func_78793_a(0.0f, 0.0f, 0.0f);
        this.Core.func_78792_a(this.XWing);
        this.XWing.field_78804_l.add(new ModelBox(this.XWing, 0, 9, -2.0f, -2.0f, 6.0f, 4, 4, 4, 0.0f, false));
        this.XWing.field_78804_l.add(new ModelBox(this.XWing, 0, 9, -2.0f, -10.0f, -2.0f, 4, 4, 4, 0.0f, false));
        this.XWing.field_78804_l.add(new ModelBox(this.XWing, 0, 9, -2.0f, 6.0f, -2.0f, 4, 4, 4, 0.0f, false));
        this.XWing.field_78804_l.add(new ModelBox(this.XWing, 0, 9, -2.0f, -2.0f, -10.0f, 4, 4, 4, 0.0f, false));
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        GlStateManager.func_179147_l();
        GlStateManager.func_179112_b((int)770, (int)771);
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)(0.75f + 0.15f * Mth.func_76126_a((float)(f2 * 0.3f))));
        this.Core.func_78785_a(f5);
        GlStateManager.func_179084_k();
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.Core.field_78796_g = ageInTicks * 0.3f;
        this.ZWing.field_78808_h = ageInTicks * 0.1f;
        this.XWing.field_78795_f = (float)(1.5707963267948966 + (double)(ageInTicks * 0.1f));
    }
}

