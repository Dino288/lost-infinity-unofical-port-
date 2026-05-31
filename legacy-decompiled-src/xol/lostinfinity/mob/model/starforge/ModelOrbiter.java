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

public class ModelOrbiter
extends ModelBase {
    private final ModelRenderer Body;
    private final ModelRenderer Orbit;
    private final ModelRenderer Orbit2;
    private final ModelRenderer Body2;

    public ModelOrbiter() {
        this.field_78090_t = 128;
        this.field_78089_u = 64;
        this.Body = new ModelRenderer((ModelBase)this);
        this.Body.func_78793_a(0.0f, 5.0f, 0.0f);
        this.Body.field_78804_l.add(new ModelBox(this.Body, 0, 36, -7.0f, -6.0f, -7.0f, 14, 14, 14, 0.0f, false));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 38, 10, 7.0f, -5.0f, -6.0f, 1, 12, 12, 0.0f, false));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 38, 10, -8.0f, -5.0f, -6.0f, 1, 12, 12, 0.0f, false));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 1, 23, -6.0f, -7.0f, -6.0f, 12, 1, 12, 0.0f, false));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 1, 23, -6.0f, 8.0f, -6.0f, 12, 1, 12, 0.0f, false));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 0, 10, -6.0f, -5.0f, -8.0f, 12, 12, 1, 0.0f, false));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 0, 10, -6.0f, -5.0f, 7.0f, 12, 12, 1, 0.0f, false));
        this.Orbit = new ModelRenderer((ModelBase)this);
        this.Orbit.func_78793_a(0.0f, 5.0f, 0.0f);
        this.Orbit.field_78804_l.add(new ModelBox(this.Orbit, 0, 0, -11.0f, -12.0f, -1.0f, 22, 2, 2, 0.0f, false));
        this.Orbit.field_78804_l.add(new ModelBox(this.Orbit, 56, 40, 11.0f, -10.0f, -1.0f, 2, 22, 2, 0.0f, false));
        this.Orbit.field_78804_l.add(new ModelBox(this.Orbit, 56, 40, -13.0f, -10.0f, -1.0f, 2, 22, 2, 0.0f, true));
        this.Orbit.field_78804_l.add(new ModelBox(this.Orbit, 0, 5, -11.0f, 12.0f, -1.0f, 22, 2, 2, 0.0f, false));
        this.Orbit2 = new ModelRenderer((ModelBase)this);
        this.Orbit2.func_78793_a(0.0f, 5.0f, 0.0f);
        this.Orbit2.field_78804_l.add(new ModelBox(this.Orbit2, 64, 0, -11.0f, -12.0f, -1.0f, 22, 2, 2, 0.25f, false));
        this.Orbit2.field_78804_l.add(new ModelBox(this.Orbit2, 120, 40, 11.0f, -10.0f, -1.0f, 2, 22, 2, 0.25f, false));
        this.Orbit2.field_78804_l.add(new ModelBox(this.Orbit2, 120, 40, -13.0f, -10.0f, -1.0f, 2, 22, 2, 0.25f, true));
        this.Orbit2.field_78804_l.add(new ModelBox(this.Orbit2, 64, 5, -11.0f, 12.0f, -1.0f, 22, 2, 2, 0.25f, false));
        this.Body2 = new ModelRenderer((ModelBase)this);
        this.Body2.func_78793_a(0.0f, 5.0f, 0.0f);
        this.Body2.field_78804_l.add(new ModelBox(this.Body2, 64, 36, -7.0f, -6.0f, -7.0f, 14, 14, 14, 0.2f, false));
        this.Body2.field_78804_l.add(new ModelBox(this.Body2, 102, 10, 7.0f, -5.0f, -6.0f, 1, 12, 12, 0.2f, false));
        this.Body2.field_78804_l.add(new ModelBox(this.Body2, 102, 10, -8.0f, -5.0f, -6.0f, 1, 12, 12, 0.2f, false));
        this.Body2.field_78804_l.add(new ModelBox(this.Body2, 65, 23, -6.0f, -7.0f, -6.0f, 12, 1, 12, 0.2f, false));
        this.Body2.field_78804_l.add(new ModelBox(this.Body2, 65, 23, -6.0f, 8.0f, -6.0f, 12, 1, 12, 0.2f, false));
        this.Body2.field_78804_l.add(new ModelBox(this.Body2, 64, 10, -6.0f, -5.0f, -8.0f, 12, 12, 1, 0.2f, false));
        this.Body2.field_78804_l.add(new ModelBox(this.Body2, 64, 10, -6.0f, -5.0f, 7.0f, 12, 12, 1, 0.2f, false));
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.Body.func_78785_a(f5);
        this.Orbit.func_78785_a(f5);
        GlStateManager.func_179147_l();
        GlStateManager.func_179112_b((int)770, (int)771);
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)(0.5f + 0.5f * Mth.func_76126_a((float)(f2 * 0.1f))));
        this.Orbit2.func_78785_a(f5);
        this.Body2.func_78785_a(f5);
        GlStateManager.func_179084_k();
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.Orbit.field_78796_g = ageInTicks * 0.2f;
        this.Orbit.field_78795_f = Mth.func_76126_a((float)(ageInTicks * 0.1f));
        this.Orbit.field_78808_h = Mth.func_76134_b((float)(ageInTicks * 0.15f));
        this.Orbit2.field_78796_g = this.Orbit.field_78796_g;
        this.Orbit2.field_78795_f = this.Orbit.field_78795_f;
        this.Orbit2.field_78808_h = this.Orbit.field_78808_h;
        this.Body.field_78796_g = Mth.func_76126_a((float)(ageInTicks * 0.05f));
        this.Body.field_78808_h = 0.35f * Mth.func_76126_a((float)(ageInTicks * 0.05f));
        this.Body2.field_78796_g = this.Body.field_78796_g;
        this.Body2.field_78808_h = this.Body.field_78808_h;
    }
}

