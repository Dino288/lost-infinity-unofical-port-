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
package xol.lostinfinity.mob.model.boss;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;

public class ModelLivorax
extends ModelBase {
    private final ModelRenderer Body;
    private final ModelRenderer Face;
    private final ModelRenderer WingLT;
    private final ModelRenderer WingRT;
    private final ModelRenderer WingLB;
    private final ModelRenderer WingRB;

    public ModelLivorax() {
        this.field_78090_t = 128;
        this.field_78089_u = 64;
        this.Body = new ModelRenderer((ModelBase)this);
        this.Body.func_78793_a(0.0f, 7.0f, 0.0f);
        this.Body.field_78804_l.add(new ModelBox(this.Body, 0, 0, -8.0f, -5.0f, -4.0f, 16, 16, 8, 0.0f, false));
        this.Face = new ModelRenderer((ModelBase)this);
        this.Face.func_78793_a(0.0f, 3.0f, -5.0f);
        this.Body.func_78792_a(this.Face);
        this.Face.field_78804_l.add(new ModelBox(this.Face, 0, 32, -10.0f, -10.0f, -6.0f, 20, 20, 12, -4.0f, false));
        this.WingLT = new ModelRenderer((ModelBase)this);
        this.WingLT.func_78793_a(7.0f, 3.0f, 0.0f);
        this.WingLT.field_78804_l.add(new ModelBox(this.WingLT, 51, 0, -2.0f, -3.0f, -3.0f, 14, 6, 6, 0.0f, false));
        this.WingLT.field_78804_l.add(new ModelBox(this.WingLT, 56, 14, 12.0f, -2.0f, -2.0f, 8, 4, 4, 0.0f, false));
        this.WingLT.field_78804_l.add(new ModelBox(this.WingLT, 54, 26, 4.0f, -8.0f, 0.0f, 26, 16, 1, 0.0f, false));
        this.WingRT = new ModelRenderer((ModelBase)this);
        this.WingRT.func_78793_a(-7.0f, 3.0f, 0.0f);
        this.WingRT.field_78804_l.add(new ModelBox(this.WingRT, 51, 0, -12.0f, -3.0f, -3.0f, 14, 6, 6, 0.0f, true));
        this.WingRT.field_78804_l.add(new ModelBox(this.WingRT, 56, 14, -20.0f, -2.0f, -2.0f, 8, 4, 4, 0.0f, true));
        this.WingRT.field_78804_l.add(new ModelBox(this.WingRT, 54, 26, -30.0f, -8.0f, 0.0f, 26, 16, 1, 0.0f, true));
        this.WingLB = new ModelRenderer((ModelBase)this);
        this.WingLB.func_78793_a(7.0f, 18.0f, 0.0f);
        this.WingLB.field_78804_l.add(new ModelBox(this.WingLB, 51, 0, -2.0f, -3.0f, -3.0f, 14, 6, 6, 0.0f, false));
        this.WingLB.field_78804_l.add(new ModelBox(this.WingLB, 56, 14, 12.0f, -2.0f, -2.0f, 8, 4, 4, 0.0f, false));
        this.WingLB.field_78804_l.add(new ModelBox(this.WingLB, 54, 26, 4.0f, -8.0f, 0.0f, 26, 16, 1, 0.0f, false));
        this.WingRB = new ModelRenderer((ModelBase)this);
        this.WingRB.func_78793_a(-7.0f, 18.0f, 0.0f);
        this.WingRB.field_78804_l.add(new ModelBox(this.WingRB, 51, 0, -12.0f, -3.0f, -3.0f, 14, 6, 6, 0.0f, true));
        this.WingRB.field_78804_l.add(new ModelBox(this.WingRB, 56, 14, -20.0f, -2.0f, -2.0f, 8, 4, 4, 0.0f, true));
        this.WingRB.field_78804_l.add(new ModelBox(this.WingRB, 54, 26, -30.0f, -8.0f, 0.0f, 26, 16, 1, 0.0f, true));
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.Body.func_78785_a(f5);
        this.WingLT.func_78785_a(f5);
        this.WingRT.func_78785_a(f5);
        this.WingLB.func_78785_a(f5);
        this.WingRB.func_78785_a(f5);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.WingLT.field_78808_h = -0.6f + 0.3f * Mth.func_76126_a((float)(ageInTicks * 0.2f));
        this.WingLB.field_78808_h = -this.WingLT.field_78808_h;
        this.WingRB.field_78808_h = this.WingLT.field_78808_h;
        this.WingRT.field_78808_h = -this.WingLT.field_78808_h;
        this.WingLT.field_78796_g = 0.8f * Mth.func_76126_a((float)(ageInTicks * 0.3f));
        this.WingRT.field_78796_g = -this.WingLT.field_78796_g;
        this.WingLB.field_78796_g = this.WingLT.field_78796_g;
        this.WingRB.field_78796_g = -this.WingLT.field_78796_g;
        this.Face.field_78796_g = 0.15f * Mth.func_76126_a((float)(ageInTicks * 0.1f));
        this.Face.field_78795_f = 0.15f * Mth.func_76134_b((float)(ageInTicks * 0.075f));
    }
}

