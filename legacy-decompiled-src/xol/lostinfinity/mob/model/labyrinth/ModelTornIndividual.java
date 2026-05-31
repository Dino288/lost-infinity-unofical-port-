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
package xol.lostinfinity.mob.model.labyrinth;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;

public class ModelTornIndividual
extends ModelBase {
    private final ModelRenderer Form1;
    private final ModelRenderer LeftLeg;
    private final ModelRenderer RightLeg;
    private final ModelRenderer LeftArm;
    private final ModelRenderer RightArm;
    private final ModelRenderer Head;
    private final ModelRenderer Body;
    private final ModelRenderer Form2;
    private final ModelRenderer LeftLeg2;
    private final ModelRenderer RightLeg2;
    private final ModelRenderer LeftArm2;
    private final ModelRenderer RightArm2;
    private final ModelRenderer Head2;
    private final ModelRenderer Body2;
    private final ModelRenderer Form3;
    private final ModelRenderer LeftLeg3;
    private final ModelRenderer RightLeg3;
    private final ModelRenderer LeftArm3;
    private final ModelRenderer RightArm3;
    private final ModelRenderer Head3;
    private final ModelRenderer Body3;
    private final ModelRenderer Form4;
    private final ModelRenderer LeftLeg4;
    private final ModelRenderer RightLeg4;
    private final ModelRenderer LeftArm4;
    private final ModelRenderer RightArm4;
    private final ModelRenderer Head4;
    private final ModelRenderer Body4;

    public ModelTornIndividual() {
        this.field_78090_t = 128;
        this.field_78089_u = 64;
        this.Form1 = new ModelRenderer((ModelBase)this);
        this.Form1.func_78793_a(0.0f, 0.0f, 0.0f);
        this.LeftLeg = new ModelRenderer((ModelBase)this);
        this.LeftLeg.func_78793_a(1.9f, 12.0f, 0.0f);
        this.Form1.func_78792_a(this.LeftLeg);
        this.LeftLeg.field_78804_l.add(new ModelBox(this.LeftLeg, 0, 16, -2.0f, 0.0f, -2.0f, 4, 12, 4, 0.0f, false));
        this.RightLeg = new ModelRenderer((ModelBase)this);
        this.RightLeg.func_78793_a(-1.9f, 12.0f, 0.0f);
        this.Form1.func_78792_a(this.RightLeg);
        this.RightLeg.field_78804_l.add(new ModelBox(this.RightLeg, 0, 16, -2.0f, 0.0f, -2.0f, 4, 12, 4, 0.0f, false));
        this.LeftArm = new ModelRenderer((ModelBase)this);
        this.LeftArm.func_78793_a(5.0f, 2.0f, 0.0f);
        this.Form1.func_78792_a(this.LeftArm);
        this.LeftArm.field_78804_l.add(new ModelBox(this.LeftArm, 40, 16, -1.0f, -2.0f, -2.0f, 4, 12, 4, 0.0f, false));
        this.RightArm = new ModelRenderer((ModelBase)this);
        this.RightArm.func_78793_a(-5.0f, 2.0f, 0.0f);
        this.Form1.func_78792_a(this.RightArm);
        this.RightArm.field_78804_l.add(new ModelBox(this.RightArm, 40, 16, -3.0f, -2.0f, -2.0f, 4, 12, 4, 0.0f, true));
        this.Head = new ModelRenderer((ModelBase)this);
        this.Head.func_78793_a(0.0f, 0.0f, 0.0f);
        this.Form1.func_78792_a(this.Head);
        this.Head.field_78804_l.add(new ModelBox(this.Head, 0, 0, -4.0f, -8.0f, -4.0f, 8, 8, 8, 0.0f, false));
        this.Body = new ModelRenderer((ModelBase)this);
        this.Body.func_78793_a(0.0f, 0.0f, 0.0f);
        this.Form1.func_78792_a(this.Body);
        this.Body.field_78804_l.add(new ModelBox(this.Body, 16, 16, -4.0f, 0.0f, -2.0f, 8, 12, 4, 0.0f, false));
        this.Form2 = new ModelRenderer((ModelBase)this);
        this.Form2.func_78793_a(0.0f, 0.0f, 0.0f);
        this.LeftLeg2 = new ModelRenderer((ModelBase)this);
        this.LeftLeg2.func_78793_a(1.9f, 12.0f, 0.0f);
        this.Form2.func_78792_a(this.LeftLeg2);
        this.LeftLeg2.field_78804_l.add(new ModelBox(this.LeftLeg2, 0, 48, -2.0f, 0.0f, -2.0f, 4, 12, 4, 0.05f, false));
        this.RightLeg2 = new ModelRenderer((ModelBase)this);
        this.RightLeg2.func_78793_a(-1.9f, 12.0f, 0.0f);
        this.Form2.func_78792_a(this.RightLeg2);
        this.RightLeg2.field_78804_l.add(new ModelBox(this.RightLeg2, 0, 48, -2.0f, 0.0f, -2.0f, 4, 12, 4, 0.05f, false));
        this.LeftArm2 = new ModelRenderer((ModelBase)this);
        this.LeftArm2.func_78793_a(5.0f, 2.0f, 0.0f);
        this.Form2.func_78792_a(this.LeftArm2);
        this.LeftArm2.field_78804_l.add(new ModelBox(this.LeftArm2, 40, 48, -1.0f, -2.0f, -2.0f, 4, 12, 4, 0.05f, false));
        this.RightArm2 = new ModelRenderer((ModelBase)this);
        this.RightArm2.func_78793_a(-5.0f, 2.0f, 0.0f);
        this.Form2.func_78792_a(this.RightArm2);
        this.RightArm2.field_78804_l.add(new ModelBox(this.RightArm2, 40, 48, -3.0f, -2.0f, -2.0f, 4, 12, 4, 0.05f, true));
        this.Head2 = new ModelRenderer((ModelBase)this);
        this.Head2.func_78793_a(0.0f, 0.0f, 0.0f);
        this.Form2.func_78792_a(this.Head2);
        this.Head2.field_78804_l.add(new ModelBox(this.Head2, 0, 32, -4.0f, -8.0f, -4.0f, 8, 8, 8, 0.05f, false));
        this.Body2 = new ModelRenderer((ModelBase)this);
        this.Body2.func_78793_a(0.0f, 0.0f, 0.0f);
        this.Form2.func_78792_a(this.Body2);
        this.Body2.field_78804_l.add(new ModelBox(this.Body2, 16, 48, -4.0f, 0.0f, -2.0f, 8, 12, 4, 0.05f, false));
        this.Form3 = new ModelRenderer((ModelBase)this);
        this.Form3.func_78793_a(0.0f, 0.0f, 0.0f);
        this.LeftLeg3 = new ModelRenderer((ModelBase)this);
        this.LeftLeg3.func_78793_a(1.9f, 12.0f, 0.0f);
        this.Form3.func_78792_a(this.LeftLeg3);
        this.LeftLeg3.field_78804_l.add(new ModelBox(this.LeftLeg3, 60, 16, -2.0f, 0.0f, -2.0f, 4, 12, 4, 0.1f, false));
        this.RightLeg3 = new ModelRenderer((ModelBase)this);
        this.RightLeg3.func_78793_a(-1.9f, 12.0f, 0.0f);
        this.Form3.func_78792_a(this.RightLeg3);
        this.RightLeg3.field_78804_l.add(new ModelBox(this.RightLeg3, 60, 16, -2.0f, 0.0f, -2.0f, 4, 12, 4, 0.1f, false));
        this.LeftArm3 = new ModelRenderer((ModelBase)this);
        this.LeftArm3.func_78793_a(5.0f, 2.0f, 0.0f);
        this.Form3.func_78792_a(this.LeftArm3);
        this.LeftArm3.field_78804_l.add(new ModelBox(this.LeftArm3, 100, 16, -1.0f, -2.0f, -2.0f, 4, 12, 4, 0.1f, false));
        this.RightArm3 = new ModelRenderer((ModelBase)this);
        this.RightArm3.func_78793_a(-5.0f, 2.0f, 0.0f);
        this.Form3.func_78792_a(this.RightArm3);
        this.RightArm3.field_78804_l.add(new ModelBox(this.RightArm3, 100, 16, -3.0f, -2.0f, -2.0f, 4, 12, 4, 0.1f, true));
        this.Head3 = new ModelRenderer((ModelBase)this);
        this.Head3.func_78793_a(0.0f, 0.0f, 0.0f);
        this.Form3.func_78792_a(this.Head3);
        this.Head3.field_78804_l.add(new ModelBox(this.Head3, 60, 0, -4.0f, -8.0f, -4.0f, 8, 8, 8, 0.1f, false));
        this.Body3 = new ModelRenderer((ModelBase)this);
        this.Body3.func_78793_a(0.0f, 0.0f, 0.0f);
        this.Form3.func_78792_a(this.Body3);
        this.Body3.field_78804_l.add(new ModelBox(this.Body3, 76, 16, -4.0f, 0.0f, -2.0f, 8, 12, 4, 0.1f, false));
        this.Form4 = new ModelRenderer((ModelBase)this);
        this.Form4.func_78793_a(0.0f, 0.0f, 0.0f);
        this.LeftLeg4 = new ModelRenderer((ModelBase)this);
        this.LeftLeg4.func_78793_a(1.9f, 12.0f, 0.0f);
        this.Form4.func_78792_a(this.LeftLeg4);
        this.LeftLeg4.field_78804_l.add(new ModelBox(this.LeftLeg4, 60, 48, -2.0f, 0.0f, -2.0f, 4, 12, 4, 0.15f, false));
        this.RightLeg4 = new ModelRenderer((ModelBase)this);
        this.RightLeg4.func_78793_a(-1.9f, 12.0f, 0.0f);
        this.Form4.func_78792_a(this.RightLeg4);
        this.RightLeg4.field_78804_l.add(new ModelBox(this.RightLeg4, 60, 48, -2.0f, 0.0f, -2.0f, 4, 12, 4, 0.15f, false));
        this.LeftArm4 = new ModelRenderer((ModelBase)this);
        this.LeftArm4.func_78793_a(5.0f, 2.0f, 0.0f);
        this.Form4.func_78792_a(this.LeftArm4);
        this.LeftArm4.field_78804_l.add(new ModelBox(this.LeftArm4, 100, 48, -1.0f, -2.0f, -2.0f, 4, 12, 4, 0.15f, false));
        this.RightArm4 = new ModelRenderer((ModelBase)this);
        this.RightArm4.func_78793_a(-5.0f, 2.0f, 0.0f);
        this.Form4.func_78792_a(this.RightArm4);
        this.RightArm4.field_78804_l.add(new ModelBox(this.RightArm4, 100, 48, -3.0f, -2.0f, -2.0f, 4, 12, 4, 0.15f, true));
        this.Head4 = new ModelRenderer((ModelBase)this);
        this.Head4.func_78793_a(0.0f, 0.0f, 0.0f);
        this.Form4.func_78792_a(this.Head4);
        this.Head4.field_78804_l.add(new ModelBox(this.Head4, 60, 32, -4.0f, -8.0f, -4.0f, 8, 8, 8, 0.15f, false));
        this.Body4 = new ModelRenderer((ModelBase)this);
        this.Body4.func_78793_a(0.0f, 0.0f, 0.0f);
        this.Form4.func_78792_a(this.Body4);
        this.Body4.field_78804_l.add(new ModelBox(this.Body4, 76, 48, -4.0f, 0.0f, -2.0f, 8, 12, 4, 0.15f, false));
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.Form1.func_78785_a(f5);
        GlStateManager.func_179147_l();
        GlStateManager.func_179112_b((int)770, (int)771);
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)(0.5f + 0.25f * Mth.func_76126_a((float)f2)));
        this.Form2.func_78785_a(f5);
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)(0.5f + 0.25f * Mth.func_76126_a((float)(f2 + 60.0f))));
        this.Form3.func_78785_a(f5);
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)(0.5f + 0.25f * Mth.func_76126_a((float)(f2 + 120.0f))));
        this.Form4.func_78785_a(f5);
        GlStateManager.func_179084_k();
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.Head.field_78796_g = netHeadYaw * ((float)Math.PI / 180);
        this.Head.field_78795_f = headPitch * ((float)Math.PI / 180);
        this.Head2.field_78796_g = this.Head.field_78796_g;
        this.Head2.field_78795_f = this.Head.field_78795_f;
        this.Head3.field_78796_g = this.Head.field_78796_g;
        this.Head3.field_78795_f = this.Head.field_78795_f;
        this.Head4.field_78796_g = this.Head.field_78796_g;
        this.Head4.field_78795_f = this.Head.field_78795_f;
        this.RightLeg2.field_78795_f = this.RightLeg.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f)) * 1.4f * limbSwingAmount * 0.5f;
        this.RightLeg3.field_78795_f = this.RightLeg.field_78795_f;
        this.RightLeg4.field_78795_f = this.RightLeg.field_78795_f;
        this.LeftLeg2.field_78795_f = this.LeftLeg.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f + (float)Math.PI)) * 1.4f * limbSwingAmount * 0.5f;
        this.LeftLeg3.field_78795_f = this.LeftLeg.field_78795_f;
        this.LeftLeg4.field_78795_f = this.LeftLeg.field_78795_f;
        this.RightArm2.field_78795_f = this.RightArm.field_78795_f = -((float)(1.5707963267948966 + (double)(Mth.func_76134_b((float)(ageInTicks * 0.1f)) * (float)Math.PI * 0.15f)));
        this.RightArm3.field_78795_f = this.RightArm.field_78795_f;
        this.RightArm4.field_78795_f = this.RightArm.field_78795_f;
        this.LeftArm2.field_78795_f = this.LeftArm.field_78795_f = -((float)(1.5707963267948966 + (double)(Mth.func_76134_b((float)((ageInTicks + 100.0f) * 0.1f)) * (float)Math.PI * 0.15f)));
        this.LeftArm3.field_78795_f = this.LeftArm.field_78795_f;
        this.LeftArm4.field_78795_f = this.LeftArm.field_78795_f;
        this.Form2.field_82906_o = 0.2f * (float)Math.abs(Math.sin(ageInTicks * 0.1f));
        this.Form3.field_82906_o = -0.2f * (float)Math.abs(Math.sin(ageInTicks * 0.1f));
        this.Form4.field_82908_p = 0.2f * (float)Math.sin(ageInTicks * 0.1f);
    }
}

