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
package xol.lostinfinity.mob.model.starforge;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;

public class ModelLurcher
extends ModelBase {
    private final ModelRenderer Eye;
    private final ModelRenderer Body;
    private final ModelRenderer Tail1;
    private final ModelRenderer T1P2;
    private final ModelRenderer T1P3;
    private final ModelRenderer Tail2;
    private final ModelRenderer T2P2;
    private final ModelRenderer T2P3;
    private final ModelRenderer Tail3;
    private final ModelRenderer T3P2;
    private final ModelRenderer T3P3;
    private final ModelRenderer Tail4;
    private final ModelRenderer T4P2;
    private final ModelRenderer T4P3;

    public ModelLurcher() {
        this.field_78090_t = 64;
        this.field_78089_u = 64;
        this.Eye = new ModelRenderer((ModelBase)this);
        this.Eye.func_78793_a(0.0f, 17.5f, -6.0f);
        this.Eye.field_78804_l.add(new ModelBox(this.Eye, 35, 28, -4.0f, -4.0f, -1.0f, 8, 8, 3, 0.0f, false));
        this.Body = new ModelRenderer((ModelBase)this);
        this.Body.func_78793_a(0.0f, 17.5f, -1.0f);
        this.Body.field_78804_l.add(new ModelBox(this.Body, 0, 0, -6.0f, -6.0f, -5.0f, 12, 12, 10, 0.0f, false));
        this.Tail1 = new ModelRenderer((ModelBase)this);
        this.Tail1.func_78793_a(3.0f, 14.5f, 4.0f);
        this.Tail1.field_78804_l.add(new ModelBox(this.Tail1, 0, 23, -2.0f, -2.0f, -1.0f, 4, 4, 12, 0.0f, false));
        this.T1P2 = new ModelRenderer((ModelBase)this);
        this.T1P2.func_78793_a(0.0f, 0.0f, 11.0f);
        this.Tail1.func_78792_a(this.T1P2);
        this.T1P2.field_78804_l.add(new ModelBox(this.T1P2, 0, 23, -2.0f, -2.0f, -1.0f, 4, 4, 12, -0.2f, false));
        this.T1P3 = new ModelRenderer((ModelBase)this);
        this.T1P3.func_78793_a(0.0f, 0.0f, 11.0f);
        this.T1P2.func_78792_a(this.T1P3);
        this.T1P3.field_78804_l.add(new ModelBox(this.T1P3, 0, 40, -2.0f, -2.0f, -1.0f, 4, 4, 10, -0.4f, false));
        this.Tail2 = new ModelRenderer((ModelBase)this);
        this.Tail2.func_78793_a(-3.0f, 14.5f, 4.0f);
        this.Tail2.field_78804_l.add(new ModelBox(this.Tail2, 0, 23, -2.0f, -2.0f, -1.0f, 4, 4, 12, 0.0f, false));
        this.T2P2 = new ModelRenderer((ModelBase)this);
        this.T2P2.func_78793_a(0.0f, 0.0f, 11.0f);
        this.Tail2.func_78792_a(this.T2P2);
        this.T2P2.field_78804_l.add(new ModelBox(this.T2P2, 0, 23, -2.0f, -2.0f, -1.0f, 4, 4, 12, -0.2f, false));
        this.T2P3 = new ModelRenderer((ModelBase)this);
        this.T2P3.func_78793_a(0.0f, 0.0f, 11.0f);
        this.T2P2.func_78792_a(this.T2P3);
        this.T2P3.field_78804_l.add(new ModelBox(this.T2P3, 0, 40, -2.0f, -2.0f, -1.0f, 4, 4, 10, -0.4f, false));
        this.Tail3 = new ModelRenderer((ModelBase)this);
        this.Tail3.func_78793_a(3.0f, 20.5f, 4.0f);
        this.Tail3.field_78804_l.add(new ModelBox(this.Tail3, 0, 23, -2.0f, -2.0f, -1.0f, 4, 4, 12, 0.0f, false));
        this.T3P2 = new ModelRenderer((ModelBase)this);
        this.T3P2.func_78793_a(0.0f, 0.0f, 11.0f);
        this.Tail3.func_78792_a(this.T3P2);
        this.T3P2.field_78804_l.add(new ModelBox(this.T3P2, 0, 23, -2.0f, -2.0f, -1.0f, 4, 4, 12, -0.2f, false));
        this.T3P3 = new ModelRenderer((ModelBase)this);
        this.T3P3.func_78793_a(0.0f, 0.0f, 11.0f);
        this.T3P2.func_78792_a(this.T3P3);
        this.T3P3.field_78804_l.add(new ModelBox(this.T3P3, 0, 40, -2.0f, -2.0f, -1.0f, 4, 4, 10, -0.4f, false));
        this.Tail4 = new ModelRenderer((ModelBase)this);
        this.Tail4.func_78793_a(-3.0f, 20.5f, 4.0f);
        this.Tail4.field_78804_l.add(new ModelBox(this.Tail4, 0, 23, -2.0f, -2.0f, -1.0f, 4, 4, 12, 0.0f, false));
        this.T4P2 = new ModelRenderer((ModelBase)this);
        this.T4P2.func_78793_a(0.0f, 0.0f, 11.0f);
        this.Tail4.func_78792_a(this.T4P2);
        this.T4P2.field_78804_l.add(new ModelBox(this.T4P2, 0, 23, -2.0f, -2.0f, -1.0f, 4, 4, 12, -0.2f, false));
        this.T4P3 = new ModelRenderer((ModelBase)this);
        this.T4P3.func_78793_a(0.0f, 0.0f, 11.0f);
        this.T4P2.func_78792_a(this.T4P3);
        this.T4P3.field_78804_l.add(new ModelBox(this.T4P3, 0, 40, -2.0f, -2.0f, -1.0f, 4, 4, 10, -0.4f, false));
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.Eye.func_78785_a(f5);
        this.Body.func_78785_a(f5);
        this.Tail1.func_78785_a(f5);
        this.Tail2.func_78785_a(f5);
        this.Tail3.func_78785_a(f5);
        this.Tail4.func_78785_a(f5);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.Tail1.field_78796_g = 0.5f + 0.5f * Mth.func_76126_a((float)(ageInTicks * 0.1f));
        this.T1P2.field_78796_g = 0.5f + 0.4f * Mth.func_76126_a((float)(ageInTicks * 0.1f));
        this.T1P3.field_78796_g = 0.5f + 0.3f * Mth.func_76126_a((float)(ageInTicks * 0.1f));
        this.Tail1.field_78795_f = 0.2f + 0.2f * Mth.func_76126_a((float)(ageInTicks * 0.15f));
        this.T1P2.field_78795_f = 0.2f + 0.15f * Mth.func_76126_a((float)(ageInTicks * 0.15f));
        this.T1P3.field_78795_f = 0.2f + 0.1f * Mth.func_76126_a((float)(ageInTicks * 0.15f));
        this.Tail2.field_78796_g = -this.Tail1.field_78796_g;
        this.T2P2.field_78796_g = -this.T1P2.field_78796_g;
        this.T2P3.field_78796_g = -this.T1P3.field_78796_g;
        this.Tail2.field_78795_f = this.Tail1.field_78795_f;
        this.T2P2.field_78795_f = this.T1P2.field_78795_f;
        this.T2P3.field_78795_f = this.T1P3.field_78795_f;
        this.Tail3.field_78796_g = 0.5f - 0.5f * Mth.func_76126_a((float)(ageInTicks * 0.1f));
        this.T3P2.field_78796_g = 0.5f - 0.4f * Mth.func_76126_a((float)(ageInTicks * 0.1f));
        this.T3P3.field_78796_g = 0.5f - 0.3f * Mth.func_76126_a((float)(ageInTicks * 0.1f));
        this.Tail3.field_78795_f = -0.2f + 0.2f * Mth.func_76126_a((float)(ageInTicks * 0.15f));
        this.T3P2.field_78795_f = -0.2f + 0.15f * Mth.func_76126_a((float)(ageInTicks * 0.15f));
        this.T3P3.field_78795_f = -0.2f + 0.1f * Mth.func_76126_a((float)(ageInTicks * 0.15f));
        this.Tail4.field_78796_g = -this.Tail3.field_78796_g;
        this.T4P2.field_78796_g = -this.T3P2.field_78796_g;
        this.T4P3.field_78796_g = -this.T3P3.field_78796_g;
        this.Tail4.field_78795_f = this.Tail3.field_78795_f;
        this.T4P2.field_78795_f = this.T3P2.field_78795_f;
        this.T4P3.field_78795_f = this.T3P3.field_78795_f;
        this.Eye.field_78796_g = 0.15f * Mth.func_76126_a((float)(ageInTicks * 0.1f));
        this.Eye.field_78795_f = 0.15f * Mth.func_76134_b((float)(ageInTicks * 0.075f));
    }
}

