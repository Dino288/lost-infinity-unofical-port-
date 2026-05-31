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
package xol.lostinfinity.mob.model.murk;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;

public class ModelDoomsday
extends ModelBase {
    private final ModelRenderer Head2;
    private final ModelRenderer Head;
    private final ModelRenderer Body;
    private final ModelRenderer Strand1;
    private final ModelRenderer Strand8;
    private final ModelRenderer Strand9;
    private final ModelRenderer Strand10;
    private final ModelRenderer Strand11;
    private final ModelRenderer Strand7;
    private final ModelRenderer Strand4;
    private final ModelRenderer Strand5;
    private final ModelRenderer Strand6;
    private final ModelRenderer Strand2;
    private final ModelRenderer Strand3;
    private final ModelRenderer LeftArm;
    private final ModelRenderer LeftArm2;
    private final ModelRenderer LeftArm3;
    private final ModelRenderer LeftArm4;
    private final ModelRenderer RightArm;
    private final ModelRenderer RightArm2;
    private final ModelRenderer RightArm3;
    private final ModelRenderer RightArm4;

    public ModelDoomsday() {
        this.field_78090_t = 64;
        this.field_78089_u = 64;
        this.Head2 = new ModelRenderer((ModelBase)this);
        this.Head2.func_78793_a(0.0f, -2.0f, 0.0f);
        this.Head2.field_78804_l.add(new ModelBox(this.Head2, 32, 17, -4.0f, -13.0f, -4.0f, 8, 9, 8, 0.1f, false));
        this.Head = new ModelRenderer((ModelBase)this);
        this.Head.func_78793_a(0.0f, -2.0f, 0.0f);
        this.Head.field_78804_l.add(new ModelBox(this.Head, 0, 0, -4.0f, -13.0f, -4.0f, 8, 9, 8, 0.0f, false));
        this.Head.field_78804_l.add(new ModelBox(this.Head, 32, 0, -4.0f, -13.0f, -4.0f, 8, 9, 8, 0.2f, false));
        this.Head.field_78804_l.add(new ModelBox(this.Head, 36, 34, -3.5f, -15.0f, -3.5f, 7, 2, 7, 0.0f, false));
        this.Head.field_78804_l.add(new ModelBox(this.Head, 13, 47, -3.0f, -17.0f, -3.0f, 6, 2, 6, 0.0f, false));
        this.Head.field_78804_l.add(new ModelBox(this.Head, 32, 45, -2.5f, -19.0f, -2.5f, 5, 2, 5, 0.0f, false));
        this.Body = new ModelRenderer((ModelBase)this);
        this.Body.func_78793_a(0.0f, -0.5f, 0.0f);
        this.Body.field_78804_l.add(new ModelBox(this.Body, 0, 17, -4.0f, 0.5f, -3.0f, 8, 14, 6, 0.0f, false));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 0, 38, -5.0f, -2.5f, -3.0f, 10, 3, 6, 0.3f, false));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 14, 55, -6.0f, -5.5f, -3.0f, 12, 3, 6, 0.5f, false));
        this.Strand1 = new ModelRenderer((ModelBase)this);
        this.Strand1.func_78793_a(-2.5f, 15.0f, 3.0f);
        this.Body.func_78792_a(this.Strand1);
        this.Strand1.field_78804_l.add(new ModelBox(this.Strand1, 0, 52, -1.0f, -1.5f, -0.5f, 2, 11, 1, 0.0f, false));
        this.Strand8 = new ModelRenderer((ModelBase)this);
        this.Strand8.func_78793_a(-4.0f, 15.0f, 1.5f);
        this.Body.func_78792_a(this.Strand8);
        this.Strand8.field_78804_l.add(new ModelBox(this.Strand8, 7, 51, -0.5f, -1.5f, -1.0f, 1, 11, 2, 0.0f, false));
        this.Strand9 = new ModelRenderer((ModelBase)this);
        this.Strand9.func_78793_a(4.0f, 15.0f, 1.5f);
        this.Body.func_78792_a(this.Strand9);
        this.Strand9.field_78804_l.add(new ModelBox(this.Strand9, 7, 51, -0.5f, -1.5f, -1.0f, 1, 11, 2, 0.0f, true));
        this.Strand10 = new ModelRenderer((ModelBase)this);
        this.Strand10.func_78793_a(-4.0f, 15.0f, -1.5f);
        this.Body.func_78792_a(this.Strand10);
        this.Strand10.field_78804_l.add(new ModelBox(this.Strand10, 7, 51, -0.5f, -1.5f, -1.0f, 1, 11, 2, 0.0f, false));
        this.Strand11 = new ModelRenderer((ModelBase)this);
        this.Strand11.func_78793_a(4.0f, 15.0f, -1.5f);
        this.Body.func_78792_a(this.Strand11);
        this.Strand11.field_78804_l.add(new ModelBox(this.Strand11, 7, 51, -0.5f, -1.5f, -1.0f, 1, 11, 2, 0.0f, true));
        this.Strand7 = new ModelRenderer((ModelBase)this);
        this.Strand7.func_78793_a(-3.5f, 14.0f, -2.0f);
        this.Body.func_78792_a(this.Strand7);
        this.setRotationAngle(this.Strand7, 0.0f, -1.5708f, 0.0f);
        this.Strand4 = new ModelRenderer((ModelBase)this);
        this.Strand4.func_78793_a(-2.5f, 15.0f, -3.0f);
        this.Body.func_78792_a(this.Strand4);
        this.setRotationAngle(this.Strand4, 0.0f, 3.1416f, 0.0f);
        this.Strand4.field_78804_l.add(new ModelBox(this.Strand4, 0, 52, -1.0f, -1.5f, -0.5f, 2, 11, 1, 0.0f, false));
        this.Strand5 = new ModelRenderer((ModelBase)this);
        this.Strand5.func_78793_a(2.5f, 15.0f, -3.0f);
        this.Body.func_78792_a(this.Strand5);
        this.setRotationAngle(this.Strand5, 0.0f, 3.1416f, 0.0f);
        this.Strand5.field_78804_l.add(new ModelBox(this.Strand5, 0, 52, -1.0f, -1.5f, -0.5f, 2, 11, 1, 0.0f, false));
        this.Strand6 = new ModelRenderer((ModelBase)this);
        this.Strand6.func_78793_a(-0.5f, 15.0f, -3.0f);
        this.Body.func_78792_a(this.Strand6);
        this.setRotationAngle(this.Strand6, 0.0f, 3.1416f, 0.0f);
        this.Strand6.field_78804_l.add(new ModelBox(this.Strand6, 0, 52, -1.5f, -1.5f, -0.5f, 2, 11, 1, 0.0f, false));
        this.Strand2 = new ModelRenderer((ModelBase)this);
        this.Strand2.func_78793_a(0.0f, 15.0f, 3.0f);
        this.Body.func_78792_a(this.Strand2);
        this.Strand2.field_78804_l.add(new ModelBox(this.Strand2, 0, 52, -1.0f, -1.5f, -0.5f, 2, 11, 1, 0.0f, false));
        this.Strand3 = new ModelRenderer((ModelBase)this);
        this.Strand3.func_78793_a(2.5f, 15.0f, 3.0f);
        this.Body.func_78792_a(this.Strand3);
        this.Strand3.field_78804_l.add(new ModelBox(this.Strand3, 0, 52, -1.0f, -1.5f, -0.5f, 2, 11, 1, 0.0f, false));
        this.LeftArm = new ModelRenderer((ModelBase)this);
        this.LeftArm.func_78793_a(5.0f, -4.0f, 0.0f);
        this.setRotationAngle(this.LeftArm, -1.1345f, 0.3491f, -0.1745f);
        this.LeftArm.field_78804_l.add(new ModelBox(this.LeftArm, 52, 43, 0.0f, 2.0f, -1.5f, 3, 18, 3, -0.75f, true));
        this.LeftArm.field_78804_l.add(new ModelBox(this.LeftArm, 29, 17, 0.8f, 17.0f, -2.5f, 1, 5, 3, -0.75f, true));
        this.LeftArm.field_78804_l.add(new ModelBox(this.LeftArm, 29, 17, 0.8f, 17.0f, -0.5f, 1, 5, 3, -0.75f, true));
        this.LeftArm.field_78804_l.add(new ModelBox(this.LeftArm, 29, 34, 0.0f, -1.0f, -1.5f, 3, 4, 3, 0.5f, true));
        this.LeftArm2 = new ModelRenderer((ModelBase)this);
        this.LeftArm2.func_78793_a(4.0f, -3.0f, 4.0f);
        this.setRotationAngle(this.LeftArm2, 0.0f, 1.5708f, -2.3562f);
        this.LeftArm2.field_78804_l.add(new ModelBox(this.LeftArm2, 52, 43, 0.0f, 2.0f, -1.5f, 3, 18, 3, -0.75f, true));
        this.LeftArm2.field_78804_l.add(new ModelBox(this.LeftArm2, 29, 17, 0.8f, 17.0f, -2.5f, 1, 5, 3, -0.75f, true));
        this.LeftArm2.field_78804_l.add(new ModelBox(this.LeftArm2, 29, 17, 0.8f, 17.0f, -0.5f, 1, 5, 3, -0.75f, true));
        this.LeftArm2.field_78804_l.add(new ModelBox(this.LeftArm2, 29, 34, 0.0f, -1.0f, -1.5f, 3, 4, 3, 0.5f, true));
        this.LeftArm3 = new ModelRenderer((ModelBase)this);
        this.LeftArm3.func_78793_a(3.0f, -1.0f, 3.0f);
        this.setRotationAngle(this.LeftArm3, 0.0f, 1.5708f, -1.5708f);
        this.LeftArm3.field_78804_l.add(new ModelBox(this.LeftArm3, 52, 43, 0.0f, 2.0f, -1.5f, 3, 18, 3, -0.75f, true));
        this.LeftArm3.field_78804_l.add(new ModelBox(this.LeftArm3, 29, 17, 0.8f, 17.0f, -2.5f, 1, 5, 3, -0.75f, true));
        this.LeftArm3.field_78804_l.add(new ModelBox(this.LeftArm3, 29, 17, 0.8f, 17.0f, -0.5f, 1, 5, 3, -0.75f, true));
        this.LeftArm3.field_78804_l.add(new ModelBox(this.LeftArm3, 29, 34, 0.0f, -1.0f, -1.5f, 3, 4, 3, 0.5f, true));
        this.LeftArm4 = new ModelRenderer((ModelBase)this);
        this.LeftArm4.func_78793_a(2.0f, 0.0f, 4.0f);
        this.setRotationAngle(this.LeftArm4, 0.0f, 1.5708f, -1.0472f);
        this.LeftArm4.field_78804_l.add(new ModelBox(this.LeftArm4, 52, 43, 0.0f, 2.0f, -1.5f, 3, 18, 3, -0.75f, true));
        this.LeftArm4.field_78804_l.add(new ModelBox(this.LeftArm4, 29, 17, 0.8f, 17.0f, -2.5f, 1, 5, 3, -0.75f, true));
        this.LeftArm4.field_78804_l.add(new ModelBox(this.LeftArm4, 29, 17, 0.8f, 17.0f, -0.5f, 1, 5, 3, -0.75f, true));
        this.LeftArm4.field_78804_l.add(new ModelBox(this.LeftArm4, 29, 34, 0.0f, -1.0f, -1.5f, 3, 4, 3, 0.5f, true));
        this.RightArm = new ModelRenderer((ModelBase)this);
        this.RightArm.func_78793_a(-5.0f, -4.0f, 0.0f);
        this.setRotationAngle(this.RightArm, -1.1345f, -0.3491f, 0.1745f);
        this.RightArm.field_78804_l.add(new ModelBox(this.RightArm, 52, 43, -3.0f, 2.0f, -1.5f, 3, 18, 3, -0.75f, false));
        this.RightArm.field_78804_l.add(new ModelBox(this.RightArm, 29, 17, -1.8f, 17.0f, -2.5f, 1, 5, 3, -0.75f, false));
        this.RightArm.field_78804_l.add(new ModelBox(this.RightArm, 29, 17, -1.8f, 17.0f, -0.5f, 1, 5, 3, -0.75f, false));
        this.RightArm.field_78804_l.add(new ModelBox(this.RightArm, 29, 34, -3.0f, -1.0f, -1.5f, 3, 4, 3, 0.5f, false));
        this.RightArm2 = new ModelRenderer((ModelBase)this);
        this.RightArm2.func_78793_a(-4.0f, -3.0f, 4.0f);
        this.setRotationAngle(this.RightArm2, 0.0f, -1.5708f, 2.3562f);
        this.RightArm2.field_78804_l.add(new ModelBox(this.RightArm2, 52, 43, -3.0f, 2.0f, -1.5f, 3, 18, 3, -0.75f, false));
        this.RightArm2.field_78804_l.add(new ModelBox(this.RightArm2, 29, 17, -1.8f, 17.0f, -2.5f, 1, 5, 3, -0.75f, false));
        this.RightArm2.field_78804_l.add(new ModelBox(this.RightArm2, 29, 17, -1.8f, 17.0f, -0.5f, 1, 5, 3, -0.75f, false));
        this.RightArm2.field_78804_l.add(new ModelBox(this.RightArm2, 29, 34, -3.0f, -1.0f, -1.5f, 3, 4, 3, 0.5f, false));
        this.RightArm3 = new ModelRenderer((ModelBase)this);
        this.RightArm3.func_78793_a(-3.0f, -1.0f, 3.0f);
        this.setRotationAngle(this.RightArm3, 0.0f, -1.5708f, 1.5708f);
        this.RightArm3.field_78804_l.add(new ModelBox(this.RightArm3, 52, 43, -3.0f, 2.0f, -1.5f, 3, 18, 3, -0.75f, false));
        this.RightArm3.field_78804_l.add(new ModelBox(this.RightArm3, 29, 17, -1.8f, 17.0f, -2.5f, 1, 5, 3, -0.75f, false));
        this.RightArm3.field_78804_l.add(new ModelBox(this.RightArm3, 29, 17, -1.8f, 17.0f, -0.5f, 1, 5, 3, -0.75f, false));
        this.RightArm3.field_78804_l.add(new ModelBox(this.RightArm3, 29, 34, -3.0f, -1.0f, -1.5f, 3, 4, 3, 0.5f, false));
        this.RightArm4 = new ModelRenderer((ModelBase)this);
        this.RightArm4.func_78793_a(-2.0f, 0.0f, 4.0f);
        this.setRotationAngle(this.RightArm4, 0.0f, -1.5708f, 1.0472f);
        this.RightArm4.field_78804_l.add(new ModelBox(this.RightArm4, 52, 43, -3.0f, 2.0f, -1.5f, 3, 18, 3, -0.75f, false));
        this.RightArm4.field_78804_l.add(new ModelBox(this.RightArm4, 29, 17, -1.8f, 17.0f, -2.5f, 1, 5, 3, -0.75f, false));
        this.RightArm4.field_78804_l.add(new ModelBox(this.RightArm4, 29, 17, -1.8f, 17.0f, -0.5f, 1, 5, 3, -0.75f, false));
        this.RightArm4.field_78804_l.add(new ModelBox(this.RightArm4, 29, 34, -3.0f, -1.0f, -1.5f, 3, 4, 3, 0.5f, false));
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.Body.func_78785_a(f5);
        this.Head.func_78785_a(f5);
        this.LeftArm.func_78785_a(f5);
        this.LeftArm2.func_78785_a(f5);
        this.LeftArm3.func_78785_a(f5);
        this.LeftArm4.func_78785_a(f5);
        this.RightArm.func_78785_a(f5);
        this.RightArm2.func_78785_a(f5);
        this.RightArm3.func_78785_a(f5);
        this.RightArm4.func_78785_a(f5);
        GlStateManager.func_179147_l();
        GlStateManager.func_179112_b((int)770, (int)771);
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)(0.5f + 0.5f * Mth.func_76126_a((float)(f2 * 0.1f))));
        this.Head2.func_78785_a(f5);
        GlStateManager.func_179084_k();
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.Body.field_78795_f = 0.3f + Mth.func_76134_b((float)(ageInTicks * 0.05f)) * 0.2f;
        this.Head.field_78796_g = netHeadYaw * ((float)Math.PI / 180);
        this.Head2.field_78795_f = this.Head.field_78795_f = headPitch * ((float)Math.PI / 180) + this.Body.field_78795_f / 2.0f;
        this.Head2.field_78796_g = this.Head.field_78796_g;
        this.Strand1.field_78795_f = 0.1f + Mth.func_76134_b((float)(ageInTicks * 0.1f)) * 0.1f;
        this.Strand2.field_78795_f = 0.1f + Mth.func_76134_b((float)((ageInTicks + 10.0f) * 0.1f)) * 0.1f;
        this.Strand3.field_78795_f = 0.1f + Mth.func_76134_b((float)((ageInTicks + 20.0f) * 0.1f)) * 0.1f;
        this.Strand4.field_78795_f = 0.1f + Mth.func_76134_b((float)((ageInTicks + 30.0f) * 0.1f)) * 0.1f;
        this.Strand5.field_78795_f = 0.1f + Mth.func_76134_b((float)((ageInTicks + 40.0f) * 0.1f)) * 0.1f;
        this.Strand6.field_78795_f = 0.1f + Mth.func_76134_b((float)((ageInTicks + 50.0f) * 0.1f)) * 0.1f;
        this.Strand7.field_78808_h = 0.1f + Mth.func_76134_b((float)(ageInTicks * 0.1f)) * 0.1f;
        this.Strand8.field_78808_h = 0.1f + Mth.func_76134_b((float)((ageInTicks + 15.0f) * 0.1f)) * 0.1f;
        this.Strand9.field_78808_h = 0.1f + Mth.func_76134_b((float)((ageInTicks + 30.0f) * 0.1f)) * 0.1f;
        this.Strand10.field_78808_h = 0.1f + Mth.func_76134_b((float)((ageInTicks + 45.0f) * 0.1f)) * 0.1f;
        this.LeftArm.field_78796_g = 0.3491f + Mth.func_76126_a((float)(ageInTicks * 0.08f)) * 0.07f;
        this.RightArm.field_78796_g = -this.LeftArm.field_78796_g;
        this.LeftArm2.field_78808_h = -2.3562f + Mth.func_76126_a((float)(ageInTicks * 0.11f)) * 0.1f;
        this.LeftArm3.field_78808_h = -1.5708f - Mth.func_76126_a((float)(ageInTicks * 0.11f)) * 0.1f;
        this.LeftArm4.field_78808_h = -1.0472f + Mth.func_76134_b((float)(ageInTicks * 0.11f)) * 0.1f;
        this.RightArm2.field_78808_h = -this.LeftArm2.field_78808_h;
        this.RightArm3.field_78808_h = -this.LeftArm3.field_78808_h;
        this.RightArm4.field_78808_h = -this.LeftArm4.field_78808_h;
    }
}

