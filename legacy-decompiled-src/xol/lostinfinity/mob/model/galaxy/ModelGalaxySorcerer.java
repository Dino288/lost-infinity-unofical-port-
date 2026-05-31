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
package xol.lostinfinity.mob.model.galaxy;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;

public class ModelGalaxySorcerer
extends ModelBase {
    public ModelRenderer head;
    public ModelRenderer body2;
    public ModelRenderer arml;
    public ModelRenderer head2;
    public ModelRenderer head3;
    public ModelRenderer head4;
    public ModelRenderer head5;
    public ModelRenderer body;
    public ModelRenderer body3;
    public ModelRenderer armr;
    public ModelRenderer tentacle1;
    public ModelRenderer tentacle2;
    public ModelRenderer tentacle3;
    public ModelRenderer tentacle4;
    public ModelRenderer tentacle5;
    public ModelRenderer bodyinside;
    public ModelRenderer globe;

    public ModelGalaxySorcerer() {
        this.field_78090_t = 64;
        this.field_78089_u = 64;
        this.tentacle4 = new ModelRenderer((ModelBase)this, 0, 24);
        this.tentacle4.func_78793_a(2.5f, 12.0f, 1.0f);
        this.tentacle4.func_78790_a(-0.5f, 0.0f, -0.5f, 1, 8, 1, 0.0f);
        this.head5 = new ModelRenderer((ModelBase)this, 53, 0);
        this.head5.func_78793_a(0.0f, -0.5f, 0.0f);
        this.head5.func_78790_a(-4.0f, -5.0f, -4.0f, 1, 5, 2, 0.0f);
        this.body2 = new ModelRenderer((ModelBase)this, 34, 46);
        this.body2.field_78809_i = true;
        this.body2.func_78793_a(0.0f, 0.0f, 0.0f);
        this.body2.func_78790_a(2.0f, 0.0f, 2.0f, 1, 12, 4, 0.0f);
        this.head = new ModelRenderer((ModelBase)this, 0, 0);
        this.head.func_78793_a(0.0f, -0.5f, 0.0f);
        this.head.func_78790_a(-3.0f, -8.5f, -4.5f, 6, 9, 9, 0.0f);
        this.tentacle5 = new ModelRenderer((ModelBase)this, 0, 24);
        this.tentacle5.func_78793_a(0.0f, 12.0f, -1.0f);
        this.tentacle5.func_78790_a(-1.25f, 0.0f, -0.5f, 1, 8, 1, 0.0f);
        this.head3 = new ModelRenderer((ModelBase)this, 32, 0);
        this.head3.func_78793_a(0.0f, -0.5f, 0.0f);
        this.head3.func_78790_a(-4.0f, -8.0f, -4.0f, 1, 3, 8, 0.0f);
        this.tentacle2 = new ModelRenderer((ModelBase)this, 0, 24);
        this.tentacle2.func_78793_a(-2.5f, 12.0f, 1.0f);
        this.tentacle2.func_78790_a(-0.5f, 0.0f, -0.5f, 1, 8, 1, 0.0f);
        this.tentacle1 = new ModelRenderer((ModelBase)this, 0, 24);
        this.tentacle1.func_78793_a(0.0f, 12.0f, -1.0f);
        this.tentacle1.func_78790_a(1.25f, 0.0f, -0.5f, 1, 8, 1, 0.0f);
        this.body3 = new ModelRenderer((ModelBase)this, 34, 46);
        this.body3.func_78793_a(0.0f, 0.0f, 0.0f);
        this.body3.func_78790_a(-3.0f, 0.0f, 2.0f, 1, 12, 4, 0.0f);
        this.globe = new ModelRenderer((ModelBase)this, 36, 33);
        this.globe.func_78793_a(-6.0f, -1.0f, -9.5f);
        this.globe.func_78790_a(-3.0f, -3.0f, -3.0f, 6, 6, 6, 0.0f);
        this.bodyinside = new ModelRenderer((ModelBase)this, 7, 40);
        this.bodyinside.func_78793_a(0.0f, 0.0f, 0.0f);
        this.bodyinside.func_78790_a(-3.5f, 0.5f, -1.5f, 7, 11, 3, 0.0f);
        this.armr = new ModelRenderer((ModelBase)this, 40, 16);
        this.armr.func_78793_a(-5.0f, 2.0f, 0.0f);
        this.armr.func_78790_a(-3.0f, -2.0f, -2.0f, 4, 12, 4, 0.0f);
        this.setRotateAngle(this.armr, -1.2217305f, 0.0f, 0.0f);
        this.tentacle3 = new ModelRenderer((ModelBase)this, 0, 24);
        this.tentacle3.func_78793_a(0.0f, 12.0f, 1.0f);
        this.tentacle3.func_78790_a(-0.5f, 0.0f, -0.5f, 1, 8, 1, 0.0f);
        this.arml = new ModelRenderer((ModelBase)this, 40, 16);
        this.arml.field_78809_i = true;
        this.arml.func_78793_a(5.0f, 2.0f, 0.0f);
        this.arml.func_78790_a(-1.0f, -2.0f, -2.0f, 4, 12, 4, 0.0f);
        this.head2 = new ModelRenderer((ModelBase)this, 32, 0);
        this.head2.func_78793_a(0.0f, -0.5f, 0.0f);
        this.head2.func_78790_a(3.0f, -8.0f, -4.0f, 1, 3, 8, 0.0f);
        this.body = new ModelRenderer((ModelBase)this, 6, 20);
        this.body.func_78793_a(0.0f, 0.0f, 0.0f);
        this.body.func_78790_a(-4.0f, 0.0f, -2.0f, 8, 12, 4, 0.0f);
        this.head4 = new ModelRenderer((ModelBase)this, 53, 0);
        this.head4.func_78793_a(0.0f, -0.5f, 0.0f);
        this.head4.func_78790_a(3.0f, -5.0f, -4.0f, 1, 5, 2, 0.0f);
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        GlStateManager.func_179147_l();
        GlStateManager.func_179112_b((int)770, (int)771);
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)(0.6f + 0.2f * Mth.func_76126_a((float)(f2 * 0.1f))));
        this.tentacle4.func_78785_a(f5);
        this.tentacle5.func_78785_a(f5);
        this.tentacle2.func_78785_a(f5);
        this.bodyinside.func_78785_a(f5);
        this.globe.func_78785_a(f5);
        this.tentacle1.func_78785_a(f5);
        this.tentacle3.func_78785_a(f5);
        GlStateManager.func_179084_k();
        this.head5.func_78785_a(f5);
        this.body2.func_78785_a(f5);
        this.head.func_78785_a(f5);
        this.head3.func_78785_a(f5);
        this.body3.func_78785_a(f5);
        this.armr.func_78785_a(f5);
        this.arml.func_78785_a(f5);
        this.head2.func_78785_a(f5);
        this.body.func_78785_a(f5);
        this.head4.func_78785_a(f5);
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.tentacle1.field_78795_f = Mth.func_76134_b((float)(ageInTicks * 0.1f)) * (float)Math.PI * 0.05f + 0.55f;
        this.tentacle2.field_78795_f = Mth.func_76134_b((float)(ageInTicks * 0.1f)) * (float)Math.PI * 0.05f + 0.55f;
        this.tentacle3.field_78795_f = Mth.func_76134_b((float)(ageInTicks * 0.1f)) * (float)Math.PI * 0.05f + 0.55f;
        this.tentacle4.field_78795_f = Mth.func_76134_b((float)(ageInTicks * 0.1f)) * (float)Math.PI * 0.05f + 0.55f;
        this.tentacle5.field_78795_f = Mth.func_76134_b((float)(ageInTicks * 0.1f)) * (float)Math.PI * 0.05f + 0.55f;
        this.head.field_78796_g = netHeadYaw * ((float)Math.PI / 180);
        this.head.field_78795_f = headPitch * ((float)Math.PI / 180);
        this.head2.field_78796_g = netHeadYaw * ((float)Math.PI / 180);
        this.head2.field_78795_f = headPitch * ((float)Math.PI / 180);
        this.head3.field_78796_g = netHeadYaw * ((float)Math.PI / 180);
        this.head3.field_78795_f = headPitch * ((float)Math.PI / 180);
        this.head4.field_78796_g = netHeadYaw * ((float)Math.PI / 180);
        this.head4.field_78795_f = headPitch * ((float)Math.PI / 180);
        this.head5.field_78796_g = netHeadYaw * ((float)Math.PI / 180);
        this.head5.field_78795_f = headPitch * ((float)Math.PI / 180);
        this.arml.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f)) * 2.0f * limbSwingAmount * 0.5f;
        this.globe.field_78796_g = ageInTicks * 0.02f;
    }
}

