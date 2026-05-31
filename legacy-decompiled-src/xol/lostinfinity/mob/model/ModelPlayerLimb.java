/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.model.ModelBiped
 *  net.minecraft.client.model.ModelRenderer
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.math.Mth
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.mob.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.mob.entity.misc.PlayerLimb;

@SideOnly(value=Side.CLIENT)
public class ModelPlayerLimb
extends ModelBiped {
    public ModelRenderer bipedLeftArmwear;
    public ModelRenderer bipedRightArmwear;
    public ModelRenderer bipedLeftLegwear;
    public ModelRenderer bipedRightLegwear;
    public ModelRenderer bipedBodyWear;
    private final boolean smallArms;

    public ModelPlayerLimb(float modelSize, boolean smallArmsIn) {
        super(modelSize, 0.0f, 64, 64);
        this.smallArms = smallArmsIn;
        if (smallArmsIn) {
            this.field_178724_i = new ModelRenderer((ModelBase)this, 32, 48);
            this.field_178724_i.func_78790_a(-1.0f, -2.0f, -2.0f, 3, 12, 4, modelSize);
            this.field_178724_i.func_78793_a(5.0f, 2.5f, 0.0f);
            this.field_178723_h = new ModelRenderer((ModelBase)this, 40, 16);
            this.field_178723_h.func_78790_a(-2.0f, -2.0f, -2.0f, 3, 12, 4, modelSize);
            this.field_178723_h.func_78793_a(-5.0f, 2.5f, 0.0f);
            this.bipedLeftArmwear = new ModelRenderer((ModelBase)this, 48, 48);
            this.bipedLeftArmwear.func_78790_a(-1.0f, -2.0f, -2.0f, 3, 12, 4, modelSize + 0.25f);
            this.bipedLeftArmwear.func_78793_a(5.0f, 2.5f, 0.0f);
            this.bipedRightArmwear = new ModelRenderer((ModelBase)this, 40, 32);
            this.bipedRightArmwear.func_78790_a(-2.0f, -2.0f, -2.0f, 3, 12, 4, modelSize + 0.25f);
            this.bipedRightArmwear.func_78793_a(-5.0f, 2.5f, 10.0f);
        } else {
            this.field_178724_i = new ModelRenderer((ModelBase)this, 32, 48);
            this.field_178724_i.func_78790_a(-1.0f, -2.0f, -2.0f, 4, 12, 4, modelSize);
            this.field_178724_i.func_78793_a(5.0f, 2.0f, 0.0f);
            this.bipedLeftArmwear = new ModelRenderer((ModelBase)this, 48, 48);
            this.bipedLeftArmwear.func_78790_a(-1.0f, -2.0f, -2.0f, 4, 12, 4, modelSize + 0.25f);
            this.bipedLeftArmwear.func_78793_a(5.0f, 2.0f, 0.0f);
            this.bipedRightArmwear = new ModelRenderer((ModelBase)this, 40, 32);
            this.bipedRightArmwear.func_78790_a(-3.0f, -2.0f, -2.0f, 4, 12, 4, modelSize + 0.25f);
            this.bipedRightArmwear.func_78793_a(-5.0f, 2.0f, 10.0f);
        }
        this.field_178722_k = new ModelRenderer((ModelBase)this, 16, 48);
        this.field_178722_k.func_78790_a(-2.0f, 0.0f, -2.0f, 4, 12, 4, modelSize);
        this.field_178722_k.func_78793_a(1.9f, 12.0f, 0.0f);
        this.bipedLeftLegwear = new ModelRenderer((ModelBase)this, 0, 48);
        this.bipedLeftLegwear.func_78790_a(-2.0f, 0.0f, -2.0f, 4, 12, 4, modelSize + 0.25f);
        this.bipedLeftLegwear.func_78793_a(1.9f, 12.0f, 0.0f);
        this.bipedRightLegwear = new ModelRenderer((ModelBase)this, 0, 32);
        this.bipedRightLegwear.func_78790_a(-2.0f, 0.0f, -2.0f, 4, 12, 4, modelSize + 0.25f);
        this.bipedRightLegwear.func_78793_a(-1.9f, 12.0f, 0.0f);
        this.bipedBodyWear = new ModelRenderer((ModelBase)this, 16, 32);
        this.bipedBodyWear.func_78790_a(-4.0f, 0.0f, -2.0f, 8, 12, 4, modelSize + 0.25f);
        this.bipedBodyWear.func_78793_a(0.0f, 0.0f, 0.0f);
    }

    public void func_78088_a(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        GlStateManager.func_179094_E();
        PlayerLimb entityLimb = (PlayerLimb)entityIn;
        int limbToRender = entityLimb.getLimb();
        switch (limbToRender) {
            case 0: {
                this.field_178724_i.func_78785_a(scale);
                break;
            }
            case 1: {
                this.field_178723_h.func_78785_a(scale);
                break;
            }
            case 2: {
                this.field_178722_k.func_78785_a(scale);
                this.bipedLeftLegwear.func_78785_a(scale);
                break;
            }
            case 3: {
                this.field_178721_j.func_78785_a(scale);
                this.bipedRightLegwear.func_78785_a(scale);
            }
        }
        GlStateManager.func_179121_F();
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        float spinSpeedX = 0.5f;
        float spinSpeedZ = 0.6f;
        PlayerLimb entityLimb = (PlayerLimb)entityIn;
        int limbToRender = entityLimb.getLimb();
        switch (limbToRender) {
            case 0: {
                this.field_178724_i.field_78795_f = Mth.func_76135_e((float)(ageInTicks * spinSpeedX));
                this.field_178724_i.field_78808_h = Mth.func_76135_e((float)(ageInTicks * spinSpeedZ));
                break;
            }
            case 1: {
                this.field_178723_h.field_78795_f = Mth.func_76135_e((float)(ageInTicks * spinSpeedX));
                this.field_178723_h.field_78808_h = Mth.func_76135_e((float)(ageInTicks * spinSpeedZ));
                break;
            }
            case 2: {
                this.field_178722_k.field_78795_f = Mth.func_76135_e((float)(ageInTicks * spinSpeedX));
                this.field_178722_k.field_78808_h = Mth.func_76135_e((float)(ageInTicks * spinSpeedZ));
                this.bipedLeftLegwear.field_78795_f = Mth.func_76135_e((float)(ageInTicks * spinSpeedX));
                this.bipedLeftLegwear.field_78808_h = Mth.func_76135_e((float)(ageInTicks * spinSpeedZ));
                break;
            }
            case 3: {
                this.field_178721_j.field_78795_f = Mth.func_76135_e((float)(ageInTicks * spinSpeedX));
                this.field_178721_j.field_78808_h = Mth.func_76135_e((float)(ageInTicks * spinSpeedZ));
                this.bipedRightLegwear.field_78795_f = Mth.func_76135_e((float)(ageInTicks * spinSpeedX));
                this.bipedRightLegwear.field_78808_h = Mth.func_76135_e((float)(ageInTicks * spinSpeedZ));
            }
        }
    }
}

