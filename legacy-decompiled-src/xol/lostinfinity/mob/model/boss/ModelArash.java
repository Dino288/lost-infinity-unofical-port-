/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.model.ModelRenderer
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.math.Mth
 */
package xol.lostinfinity.mob.model.boss;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;

public class ModelArash
extends ModelBase {
    public ModelRenderer rightarm;
    public ModelRenderer rightleg;
    public ModelRenderer headglass;
    public ModelRenderer body;
    public ModelRenderer leftarm;
    public ModelRenderer leftleg;
    public ModelRenderer bodyupper;
    public ModelRenderer leftarmt;
    public ModelRenderer rightarmt;
    public ModelRenderer rightlegt;
    public ModelRenderer leftlegt;
    public ModelRenderer headbase;
    public ModelRenderer head;
    public ModelRenderer headbar1;
    public ModelRenderer headbar2;
    public ModelRenderer headbar3;
    public ModelRenderer headbar4;
    public ModelRenderer headbar1p2;
    public ModelRenderer headbar2p2;
    public ModelRenderer headbar4p2;
    public ModelRenderer headbar3p2;
    public ModelRenderer leftarmpipe1;
    public ModelRenderer leftarmpipe2;
    public ModelRenderer rightarmpipe1;
    public ModelRenderer rightarmpipe2;
    public ModelRenderer bodyupperpipe;
    public ModelRenderer bodyupperplate;
    public ModelRenderer sword1;
    public ModelRenderer sword2;
    public ModelRenderer sword3;

    public ModelArash() {
        this.field_78090_t = 128;
        this.field_78089_u = 64;
        this.bodyupperplate = new ModelRenderer((ModelBase)this, 0, 55);
        this.bodyupperplate.func_78793_a(0.0f, 0.0f, 0.0f);
        this.bodyupperplate.func_78790_a(-3.0f, -1.0f, -5.5f, 6, 6, 2, 0.0f);
        this.leftleg = new ModelRenderer((ModelBase)this, 0, 16);
        this.leftleg.field_78809_i = true;
        this.leftleg.func_78793_a(3.5f, 12.0f, 0.1f);
        this.leftleg.func_78790_a(-3.0f, 0.0f, -3.0f, 6, 12, 6, 0.0f);
        this.leftarmpipe2 = new ModelRenderer((ModelBase)this, 58, 48);
        this.leftarmpipe2.func_78793_a(9.0f, 0.0f, 0.0f);
        this.leftarmpipe2.func_78790_a(-2.0f, -5.0f, 1.0f, 7, 6, 1, 0.0f);
        this.headbar3 = new ModelRenderer((ModelBase)this, 80, 0);
        this.headbar3.func_78793_a(0.0f, -3.0f, 0.0f);
        this.headbar3.func_78790_a(3.0f, -6.0f, -5.0f, 2, 1, 1, 0.0f);
        this.headbar4 = new ModelRenderer((ModelBase)this, 80, 0);
        this.headbar4.func_78793_a(0.0f, -3.0f, 0.0f);
        this.headbar4.func_78790_a(3.0f, -3.0f, -5.0f, 2, 1, 1, 0.0f);
        this.headbar2p2 = new ModelRenderer((ModelBase)this, 80, 0);
        this.headbar2p2.func_78793_a(0.0f, -3.0f, 0.0f);
        this.headbar2p2.func_78790_a(-5.0f, -2.5f, -4.0f, 1, 1, 6, 0.0f);
        this.bodyupper = new ModelRenderer((ModelBase)this, 16, 32);
        this.bodyupper.func_78793_a(0.0f, 0.0f, 0.0f);
        this.bodyupper.func_78790_a(-6.0f, -2.0f, -4.0f, 12, 6, 8, 0.0f);
        this.headbase = new ModelRenderer((ModelBase)this, 33, 0);
        this.headbase.func_78793_a(0.0f, -3.0f, 0.0f);
        this.headbase.func_78790_a(-5.0f, 0.0f, -5.0f, 10, 1, 10, 0.0f);
        this.rightleg = new ModelRenderer((ModelBase)this, 0, 16);
        this.rightleg.func_78793_a(-3.5f, 12.0f, 0.1f);
        this.rightleg.func_78790_a(-3.0f, 0.0f, -3.0f, 6, 12, 6, 0.0f);
        this.leftarmt = new ModelRenderer((ModelBase)this, 58, 34);
        this.leftarmt.field_78809_i = true;
        this.leftarmt.func_78793_a(9.0f, 0.0f, 0.0f);
        this.leftarmt.func_78790_a(-3.0f, -4.0f, -3.0f, 7, 6, 6, 0.0f);
        this.rightarmpipe2 = new ModelRenderer((ModelBase)this, 58, 48);
        this.rightarmpipe2.field_78809_i = true;
        this.rightarmpipe2.func_78793_a(-9.0f, 0.0f, 0.0f);
        this.rightarmpipe2.func_78790_a(-5.0f, -5.0f, 1.0f, 7, 6, 1, 0.0f);
        this.rightlegt = new ModelRenderer((ModelBase)this, 0, 36);
        this.rightlegt.func_78793_a(-3.5f, 12.0f, 0.1f);
        this.rightlegt.func_78790_a(-2.0f, -6.0f, -3.0f, 2, 6, 4, 0.0f);
        this.headbar3p2 = new ModelRenderer((ModelBase)this, 80, 0);
        this.headbar3p2.func_78793_a(0.0f, -3.0f, 0.0f);
        this.headbar3p2.func_78790_a(4.0f, -5.5f, -4.0f, 1, 1, 6, 0.0f);
        this.headbar4p2 = new ModelRenderer((ModelBase)this, 80, 0);
        this.headbar4p2.func_78793_a(0.0f, -3.0f, 0.0f);
        this.headbar4p2.func_78790_a(4.0f, -2.5f, -4.0f, 1, 1, 6, 0.0f);
        this.headbar2 = new ModelRenderer((ModelBase)this, 80, 0);
        this.headbar2.func_78793_a(0.0f, -3.0f, 0.0f);
        this.headbar2.func_78790_a(-5.0f, -3.0f, -5.0f, 2, 1, 1, 0.0f);
        this.leftarmpipe1 = new ModelRenderer((ModelBase)this, 58, 48);
        this.leftarmpipe1.func_78793_a(9.0f, 0.0f, 0.0f);
        this.leftarmpipe1.func_78790_a(-2.0f, -5.0f, -2.0f, 7, 6, 1, 0.0f);
        this.headbar1 = new ModelRenderer((ModelBase)this, 80, 0);
        this.headbar1.func_78793_a(0.0f, -3.0f, 0.0f);
        this.headbar1.func_78790_a(-5.0f, -6.0f, -5.0f, 2, 1, 1, 0.0f);
        this.headbar1p2 = new ModelRenderer((ModelBase)this, 80, 0);
        this.headbar1p2.func_78793_a(0.0f, -3.0f, 0.0f);
        this.headbar1p2.func_78790_a(-5.0f, -5.5f, -4.0f, 1, 1, 6, 0.0f);
        this.sword3 = new ModelRenderer((ModelBase)this, 91, 18);
        this.sword3.func_78793_a(-9.0f, 0.0f, 0.0f);
        this.sword3.func_78790_a(-3.0f, -5.0f, -9.0f, 4, 6, 4, 0.0f);
        this.setRotateAngle(this.sword3, 0.5235988f, 0.0f, 0.0f);
        this.leftarm = new ModelRenderer((ModelBase)this, 58, 16);
        this.leftarm.field_78809_i = true;
        this.leftarm.func_78793_a(9.0f, 0.0f, 0.0f);
        this.leftarm.func_78790_a(-1.0f, 2.0f, -2.0f, 4, 12, 4, 0.0f);
        this.bodyupperpipe = new ModelRenderer((ModelBase)this, 16, 48);
        this.bodyupperpipe.func_78793_a(0.0f, 0.0f, 0.0f);
        this.bodyupperpipe.func_78790_a(-7.0f, 2.0f, -5.0f, 14, 1, 6, 0.0f);
        this.rightarm = new ModelRenderer((ModelBase)this, 58, 16);
        this.rightarm.func_78793_a(-9.0f, 0.0f, 0.0f);
        this.rightarm.func_78790_a(-3.0f, 2.0f, -2.0f, 4, 12, 4, 0.0f);
        this.body = new ModelRenderer((ModelBase)this, 26, 16);
        this.body.func_78793_a(0.0f, 0.0f, 0.0f);
        this.body.func_78790_a(-4.0f, 4.0f, -3.0f, 8, 8, 6, 0.0f);
        this.sword1 = new ModelRenderer((ModelBase)this, 80, 16);
        this.sword1.func_78793_a(-9.0f, 0.0f, 0.0f);
        this.sword1.func_78790_a(-2.0f, -6.0f, -8.0f, 2, 20, 2, 0.0f);
        this.setRotateAngle(this.sword1, 0.5235988f, 0.0f, 0.0f);
        this.head = new ModelRenderer((ModelBase)this, 0, 0);
        this.head.func_78793_a(0.0f, -3.0f, 0.0f);
        this.head.func_78790_a(-4.0f, -8.0f, -4.0f, 8, 8, 8, 0.0f);
        this.sword2 = new ModelRenderer((ModelBase)this, 80, 9);
        this.sword2.func_78793_a(-9.0f, 0.0f, 0.0f);
        this.sword2.func_78790_a(-3.0f, -9.0f, -9.0f, 4, 3, 4, 0.0f);
        this.setRotateAngle(this.sword2, 0.5235988f, 0.0f, 0.0f);
        this.rightarmpipe1 = new ModelRenderer((ModelBase)this, 58, 48);
        this.rightarmpipe1.field_78809_i = true;
        this.rightarmpipe1.func_78793_a(-9.0f, 0.0f, 0.0f);
        this.rightarmpipe1.func_78790_a(-5.0f, -5.0f, -2.0f, 7, 6, 1, 0.0f);
        this.leftlegt = new ModelRenderer((ModelBase)this, 0, 36);
        this.leftlegt.field_78809_i = true;
        this.leftlegt.func_78793_a(3.5f, 12.0f, 0.1f);
        this.leftlegt.func_78790_a(0.0f, -6.0f, -3.0f, 2, 6, 4, 0.0f);
        this.headglass = new ModelRenderer((ModelBase)this, 65, 0);
        this.headglass.func_78793_a(0.0f, -3.0f, 0.0f);
        this.headglass.func_78790_a(-3.0f, -7.0f, -5.0f, 6, 6, 1, 0.0f);
        this.rightarmt = new ModelRenderer((ModelBase)this, 58, 34);
        this.rightarmt.func_78793_a(-9.0f, 0.0f, 0.0f);
        this.rightarmt.func_78790_a(-4.0f, -4.0f, -3.0f, 7, 6, 6, 0.0f);
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.bodyupperplate.func_78785_a(f5);
        this.leftleg.func_78785_a(f5);
        this.leftarmpipe2.func_78785_a(f5);
        this.headbar3.func_78785_a(f5);
        this.headbar4.func_78785_a(f5);
        this.headbar2p2.func_78785_a(f5);
        this.bodyupper.func_78785_a(f5);
        this.headbase.func_78785_a(f5);
        this.rightleg.func_78785_a(f5);
        this.leftarmt.func_78785_a(f5);
        this.rightarmpipe2.func_78785_a(f5);
        this.rightlegt.func_78785_a(f5);
        this.headbar3p2.func_78785_a(f5);
        this.headbar4p2.func_78785_a(f5);
        this.headbar2.func_78785_a(f5);
        this.leftarmpipe1.func_78785_a(f5);
        this.headbar1.func_78785_a(f5);
        this.headbar1p2.func_78785_a(f5);
        GlStateManager.func_179147_l();
        GlStateManager.func_179112_b((int)770, (int)771);
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)0.99f);
        this.sword3.func_78785_a(f5);
        GlStateManager.func_179084_k();
        this.leftarm.func_78785_a(f5);
        this.bodyupperpipe.func_78785_a(f5);
        this.rightarm.func_78785_a(f5);
        this.body.func_78785_a(f5);
        GlStateManager.func_179147_l();
        GlStateManager.func_179112_b((int)770, (int)771);
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)0.99f);
        this.sword1.func_78785_a(f5);
        GlStateManager.func_179084_k();
        this.head.func_78785_a(f5);
        GlStateManager.func_179147_l();
        GlStateManager.func_179112_b((int)770, (int)771);
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)0.99f);
        this.sword2.func_78785_a(f5);
        GlStateManager.func_179084_k();
        this.rightarmpipe1.func_78785_a(f5);
        this.leftlegt.func_78785_a(f5);
        this.headglass.func_78785_a(f5);
        this.rightarmt.func_78785_a(f5);
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.rightleg.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f)) * 1.4f * limbSwingAmount * 0.5f;
        this.leftleg.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f + (float)Math.PI)) * 1.4f * limbSwingAmount * 0.5f;
        this.rightlegt.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f)) * 1.4f * limbSwingAmount * 0.5f;
        this.leftlegt.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f + (float)Math.PI)) * 1.4f * limbSwingAmount * 0.5f;
        this.head.field_78796_g = netHeadYaw * ((float)Math.PI / 180);
        this.head.field_78795_f = headPitch * ((float)Math.PI / 180);
        this.headglass.field_78796_g = netHeadYaw * ((float)Math.PI / 180);
        this.headglass.field_78795_f = headPitch * ((float)Math.PI / 180);
        this.headbase.field_78796_g = netHeadYaw * ((float)Math.PI / 180);
        this.headbase.field_78795_f = headPitch * ((float)Math.PI / 180);
        this.headbar1.field_78796_g = netHeadYaw * ((float)Math.PI / 180);
        this.headbar1.field_78795_f = headPitch * ((float)Math.PI / 180);
        this.headbar2.field_78796_g = netHeadYaw * ((float)Math.PI / 180);
        this.headbar2.field_78795_f = headPitch * ((float)Math.PI / 180);
        this.headbar3.field_78796_g = netHeadYaw * ((float)Math.PI / 180);
        this.headbar3.field_78795_f = headPitch * ((float)Math.PI / 180);
        this.headbar4.field_78796_g = netHeadYaw * ((float)Math.PI / 180);
        this.headbar4.field_78795_f = headPitch * ((float)Math.PI / 180);
        this.headbar1p2.field_78796_g = netHeadYaw * ((float)Math.PI / 180);
        this.headbar1p2.field_78795_f = headPitch * ((float)Math.PI / 180);
        this.headbar2p2.field_78796_g = netHeadYaw * ((float)Math.PI / 180);
        this.headbar2p2.field_78795_f = headPitch * ((float)Math.PI / 180);
        this.headbar3p2.field_78796_g = netHeadYaw * ((float)Math.PI / 180);
        this.headbar3p2.field_78795_f = headPitch * ((float)Math.PI / 180);
        this.headbar4p2.field_78796_g = netHeadYaw * ((float)Math.PI / 180);
        this.headbar4p2.field_78795_f = headPitch * ((float)Math.PI / 180);
        this.rightarm.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f + (float)Math.PI)) * 2.0f * limbSwingAmount * 0.5f;
        this.leftarm.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f)) * 2.0f * limbSwingAmount * 0.5f;
        this.rightarmt.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f + (float)Math.PI)) * 2.0f * limbSwingAmount * 0.5f;
        this.leftarmt.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f)) * 2.0f * limbSwingAmount * 0.5f;
        this.rightarmpipe1.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f + (float)Math.PI)) * 2.0f * limbSwingAmount * 0.5f;
        this.leftarmpipe1.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f)) * 2.0f * limbSwingAmount * 0.5f;
        this.rightarmpipe2.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f + (float)Math.PI)) * 2.0f * limbSwingAmount * 0.5f;
        this.leftarmpipe2.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f)) * 2.0f * limbSwingAmount * 0.5f;
        this.sword1.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f + (float)Math.PI)) * 2.0f * limbSwingAmount * 0.5f + 0.5235988f;
        this.sword2.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f + (float)Math.PI)) * 2.0f * limbSwingAmount * 0.5f + 0.5235988f;
        this.sword3.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f + (float)Math.PI)) * 2.0f * limbSwingAmount * 0.5f + 0.5235988f;
    }
}

