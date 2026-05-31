/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.model.ModelBox
 *  net.minecraft.client.model.ModelRenderer
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.math.Mth
 */
package xol.lostinfinity.mob.model;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import xol.lostinfinity.mob.entity.misc.EntityRisingPhantom;

public class ModelRisingPhantom
extends ModelBase {
    private final ModelRenderer Body;
    private final ModelRenderer BodyBlock_r1;
    private final ModelRenderer Head;
    private final ModelRenderer LeftArm;
    private final ModelRenderer LArm3_r1;
    private final ModelRenderer LArm2_r1;
    private final ModelRenderer RightArm;
    private final ModelRenderer LArm4_r1;
    private final ModelRenderer LArm3_r2;
    private final ModelRenderer Tentacle1;
    private final ModelRenderer BodyBlock_r2;
    private final ModelRenderer Tentacle2;
    private final ModelRenderer BodyBlock_r3;
    private final ModelRenderer Tentacle3;
    private final ModelRenderer BodyBlock_r4;

    public ModelRisingPhantom() {
        this.field_78090_t = 128;
        this.field_78089_u = 64;
        this.Body = new ModelRenderer((ModelBase)this);
        this.Body.func_78793_a(0.0f, 10.0f, 0.0f);
        this.BodyBlock_r1 = new ModelRenderer((ModelBase)this);
        this.BodyBlock_r1.func_78793_a(0.0f, 0.0f, 0.0f);
        this.Body.func_78792_a(this.BodyBlock_r1);
        this.setRotationAngle(this.BodyBlock_r1, 0.2618f, 0.0f, 0.0f);
        this.BodyBlock_r1.field_78804_l.add(new ModelBox(this.BodyBlock_r1, 33, 18, -5.0f, -11.0f, 0.0f, 10, 12, 6, 0.4f, false));
        this.BodyBlock_r1.field_78804_l.add(new ModelBox(this.BodyBlock_r1, 0, 18, -5.0f, -11.0f, 0.0f, 10, 16, 6, 0.0f, false));
        this.Head = new ModelRenderer((ModelBase)this);
        this.Head.func_78793_a(0.0f, -11.0f, 0.0f);
        this.Body.func_78792_a(this.Head);
        this.Head.field_78804_l.add(new ModelBox(this.Head, 0, 0, -4.0f, -8.0f, -4.0f, 8, 8, 8, 0.0f, false));
        this.Head.field_78804_l.add(new ModelBox(this.Head, 32, 0, -4.0f, -8.0f, -4.0f, 8, 8, 8, 0.4f, false));
        this.LeftArm = new ModelRenderer((ModelBase)this);
        this.LeftArm.func_78793_a(6.0f, -10.0f, 2.5f);
        this.Body.func_78792_a(this.LeftArm);
        this.LArm3_r1 = new ModelRenderer((ModelBase)this);
        this.LArm3_r1.func_78793_a(0.0f, 0.0f, -9.0f);
        this.LeftArm.func_78792_a(this.LArm3_r1);
        this.setRotationAngle(this.LArm3_r1, 0.6981f, -0.0873f, 0.0f);
        this.LArm3_r1.field_78804_l.add(new ModelBox(this.LArm3_r1, 43, 51, 3.0f, -2.5f, -9.5f, 4, 4, 5, 0.0f, false));
        this.LArm3_r1.field_78804_l.add(new ModelBox(this.LArm3_r1, 23, 51, 3.0f, -2.5f, -4.5f, 4, 4, 5, 0.0f, false));
        this.LArm2_r1 = new ModelRenderer((ModelBase)this);
        this.LArm2_r1.func_78793_a(0.0f, 0.0f, 0.0f);
        this.LeftArm.func_78792_a(this.LArm2_r1);
        this.setRotationAngle(this.LArm2_r1, 0.6981f, -0.5236f, 0.0f);
        this.LArm2_r1.field_78804_l.add(new ModelBox(this.LArm2_r1, 62, 52, -2.0f, -6.0f, -10.5f, 4, 8, 4, 0.0f, false));
        this.LArm2_r1.field_78804_l.add(new ModelBox(this.LArm2_r1, 0, 51, -2.0f, -2.0f, -6.5f, 4, 4, 7, 0.0f, false));
        this.RightArm = new ModelRenderer((ModelBase)this);
        this.RightArm.func_78793_a(-6.0f, -10.0f, 2.5f);
        this.Body.func_78792_a(this.RightArm);
        this.LArm4_r1 = new ModelRenderer((ModelBase)this);
        this.LArm4_r1.func_78793_a(0.0f, 0.0f, -9.0f);
        this.RightArm.func_78792_a(this.LArm4_r1);
        this.setRotationAngle(this.LArm4_r1, 0.6981f, 0.0873f, 0.0f);
        this.LArm4_r1.field_78804_l.add(new ModelBox(this.LArm4_r1, 43, 51, -7.0f, -2.5f, -9.5f, 4, 4, 5, 0.0f, true));
        this.LArm4_r1.field_78804_l.add(new ModelBox(this.LArm4_r1, 23, 51, -7.0f, -2.5f, -4.5f, 4, 4, 5, 0.0f, true));
        this.LArm3_r2 = new ModelRenderer((ModelBase)this);
        this.LArm3_r2.func_78793_a(0.0f, 0.0f, 0.0f);
        this.RightArm.func_78792_a(this.LArm3_r2);
        this.setRotationAngle(this.LArm3_r2, 0.6981f, 0.5236f, 0.0f);
        this.LArm3_r2.field_78804_l.add(new ModelBox(this.LArm3_r2, 62, 52, -2.0f, -6.0f, -10.5f, 4, 8, 4, 0.0f, true));
        this.LArm3_r2.field_78804_l.add(new ModelBox(this.LArm3_r2, 0, 51, -2.0f, -2.0f, -6.5f, 4, 4, 7, 0.0f, true));
        this.Tentacle1 = new ModelRenderer((ModelBase)this);
        this.Tentacle1.func_78793_a(3.5f, 3.0f, 5.0f);
        this.Body.func_78792_a(this.Tentacle1);
        this.BodyBlock_r2 = new ModelRenderer((ModelBase)this);
        this.BodyBlock_r2.func_78793_a(-3.5f, -4.0f, -5.0f);
        this.Tentacle1.func_78792_a(this.BodyBlock_r2);
        this.setRotationAngle(this.BodyBlock_r2, 0.2618f, 0.0f, 0.0f);
        this.BodyBlock_r2.field_78804_l.add(new ModelBox(this.BodyBlock_r2, 67, 19, 1.0f, 3.0f, 1.0f, 5, 12, 5, -1.5f, false));
        this.Tentacle2 = new ModelRenderer((ModelBase)this);
        this.Tentacle2.func_78793_a(-3.5f, 3.0f, 5.0f);
        this.Body.func_78792_a(this.Tentacle2);
        this.BodyBlock_r3 = new ModelRenderer((ModelBase)this);
        this.BodyBlock_r3.func_78793_a(-3.5f, -4.0f, -5.0f);
        this.Tentacle2.func_78792_a(this.BodyBlock_r3);
        this.setRotationAngle(this.BodyBlock_r3, 0.2618f, 0.0f, 0.0f);
        this.BodyBlock_r3.field_78804_l.add(new ModelBox(this.BodyBlock_r3, 67, 19, 1.0f, 3.0f, 1.0f, 5, 12, 5, -1.5f, false));
        this.Tentacle3 = new ModelRenderer((ModelBase)this);
        this.Tentacle3.func_78793_a(-0.5f, 4.0f, 3.0f);
        this.Body.func_78792_a(this.Tentacle3);
        this.BodyBlock_r4 = new ModelRenderer((ModelBase)this);
        this.BodyBlock_r4.func_78793_a(-3.5f, -4.0f, -5.0f);
        this.Tentacle3.func_78792_a(this.BodyBlock_r4);
        this.setRotationAngle(this.BodyBlock_r4, 0.2618f, 0.0f, 0.0f);
        this.BodyBlock_r4.field_78804_l.add(new ModelBox(this.BodyBlock_r4, 67, 19, 1.5f, 3.0f, 1.0f, 5, 12, 5, -1.5f, false));
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        GlStateManager.func_179147_l();
        GlStateManager.func_179092_a((int)516, (float)0.0f);
        GlStateManager.func_179112_b((int)770, (int)771);
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)this.getAlpha(entity, Minecraft.func_71410_x().func_184121_ak()));
        this.Body.func_78785_a(f5);
        GlStateManager.func_179084_k();
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        EntityRisingPhantom phantom = (EntityRisingPhantom)entityIn;
        this.Head.field_78795_f = (float)(1.5707963267948966 - (double)phantom.getFaceRotation());
        float bodySin = Mth.func_76126_a((float)(ageInTicks / 10.0f));
        float bodyCos = Mth.func_76134_b((float)(ageInTicks / 10.0f));
        this.Body.field_78800_c = -bodyCos * 8.0f;
        this.Body.field_78808_h = bodySin * 0.34906584f;
        float armCos = Mth.func_76134_b((float)((ageInTicks - 5.0f) / 10.0f));
        this.RightArm.field_78795_f = this.Head.field_78795_f;
        this.LeftArm.field_78795_f = this.Head.field_78795_f;
        this.LeftArm.field_78808_h = this.RightArm.field_78808_h = armCos * 0.34906584f;
        this.Tentacle1.field_78795_f = 0.4f * Mth.func_76126_a((float)(ageInTicks * 0.1f));
        this.Tentacle2.field_78795_f = -0.4f * Mth.func_76126_a((float)(ageInTicks * 0.1f));
        this.Tentacle3.field_78795_f = 0.4f * Mth.func_76134_b((float)(ageInTicks * 0.1f));
    }

    private float getAlpha(Entity phantom, float partialTickTime) {
        float alpha = (float)(Mth.func_151238_b((double)(phantom.field_70173_aa - 1), (double)phantom.field_70173_aa, (double)partialTickTime) / 20.0);
        if (phantom.field_70173_aa < 20) {
            return Math.min(1.0f, alpha) * 0.9f;
        }
        if (phantom.field_70173_aa > 60) {
            return Math.min(1.0f, 4.0f - alpha) * 0.9f;
        }
        return 0.9f;
    }
}

