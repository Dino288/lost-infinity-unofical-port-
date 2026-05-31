/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.model.ModelRenderer
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.math.Mth
 */
package xol.lostinfinity.mob.model.deviant;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;

public class ModelDeviantSnowman
extends ModelBase {
    public ModelRenderer bodytop;
    public ModelRenderer arml;
    public ModelRenderer head;
    public ModelRenderer armr;
    public ModelRenderer bodybot;
    public ModelRenderer arml2;
    public ModelRenderer arml3;
    public ModelRenderer armr2;
    public ModelRenderer armr3;
    public ModelRenderer bodytop2;
    public ModelRenderer bodytop3;
    public ModelRenderer bodybot2;
    public ModelRenderer bodybot3;
    public ModelRenderer bodytopinside;

    public ModelDeviantSnowman() {
        this.field_78090_t = 64;
        this.field_78089_u = 64;
        this.head = new ModelRenderer((ModelBase)this, 0, 0);
        this.head.func_78793_a(0.0f, 4.0f, 0.0f);
        this.head.func_78790_a(-4.0f, -8.0f, -4.0f, 8, 8, 8, -0.5f);
        this.arml = new ModelRenderer((ModelBase)this, 32, 0);
        this.arml.field_78809_i = true;
        this.arml.func_78793_a(5.0f, 9.0f, 0.0f);
        this.arml.func_78790_a(-1.0f, 0.0f, -1.0f, 12, 2, 2, -0.5f);
        this.arml2 = new ModelRenderer((ModelBase)this, 32, 0);
        this.arml2.field_78809_i = true;
        this.arml2.func_78793_a(5.0f, 6.0f, -1.5f);
        this.arml2.func_78790_a(-1.0f, 0.0f, -1.0f, 12, 2, 2, -0.5f);
        this.bodybot3 = new ModelRenderer((ModelBase)this, 47, 5);
        this.bodybot3.func_78793_a(0.0f, 16.0f, 0.0f);
        this.bodybot3.func_78790_a(8.0f, -2.0f, -2.0f, 4, 4, 4, -0.5f);
        this.armr = new ModelRenderer((ModelBase)this, 32, 0);
        this.armr.field_78809_i = true;
        this.armr.func_78793_a(-5.0f, 9.0f, 0.0f);
        this.armr.func_78790_a(-1.0f, 0.0f, -1.0f, 12, 2, 2, -0.5f);
        this.setRotateAngle(this.armr, 0.0f, (float)Math.PI, 0.0f);
        this.arml3 = new ModelRenderer((ModelBase)this, 32, 0);
        this.arml3.field_78809_i = true;
        this.arml3.func_78793_a(5.0f, 4.0f, 1.5f);
        this.arml3.func_78790_a(-1.0f, 0.0f, -1.0f, 12, 2, 2, -0.5f);
        this.bodytopinside = new ModelRenderer((ModelBase)this, 36, 36);
        this.bodytopinside.func_78793_a(0.0f, 13.0f, 0.0f);
        this.bodytopinside.func_78790_a(-3.5f, 6.5f, -3.5f, 7, 7, 7, -0.5f);
        this.armr2 = new ModelRenderer((ModelBase)this, 32, 0);
        this.armr2.field_78809_i = true;
        this.armr2.func_78793_a(-5.0f, 6.0f, -1.5f);
        this.armr2.func_78790_a(-1.0f, 0.0f, -1.0f, 12, 2, 2, -0.5f);
        this.setRotateAngle(this.armr2, 0.0f, (float)Math.PI, 0.0f);
        this.bodytop = new ModelRenderer((ModelBase)this, 0, 16);
        this.bodytop.func_78793_a(0.0f, 13.0f, 0.0f);
        this.bodytop.func_78790_a(-5.0f, -10.0f, -5.0f, 10, 10, 10, -0.5f);
        this.armr3 = new ModelRenderer((ModelBase)this, 32, 0);
        this.armr3.field_78809_i = true;
        this.armr3.func_78793_a(-5.0f, 4.0f, 1.5f);
        this.armr3.func_78790_a(-1.0f, 0.0f, -1.0f, 12, 2, 2, -0.5f);
        this.setRotateAngle(this.armr3, 0.0f, (float)Math.PI, 0.0f);
        this.bodybot2 = new ModelRenderer((ModelBase)this, 47, 5);
        this.bodybot2.func_78793_a(0.0f, 16.0f, 0.0f);
        this.bodybot2.func_78790_a(-12.0f, -2.0f, -2.0f, 4, 4, 4, -0.5f);
        this.bodybot = new ModelRenderer((ModelBase)this, 0, 39);
        this.bodybot.func_78793_a(0.0f, 24.0f, 0.0f);
        this.bodybot.func_78790_a(-6.0f, -12.0f, -6.0f, 12, 12, 12, -0.5f);
        this.bodytop2 = new ModelRenderer((ModelBase)this, 33, 5);
        this.bodytop2.func_78793_a(0.0f, 13.0f, 0.0f);
        this.bodytop2.func_78790_a(-4.0f, -10.0f, 4.0f, 2, 10, 10, -0.5f);
        this.bodytop3 = new ModelRenderer((ModelBase)this, 33, 5);
        this.bodytop3.field_78809_i = true;
        this.bodytop3.func_78793_a(0.0f, 13.0f, 0.0f);
        this.bodytop3.func_78790_a(3.0f, -10.0f, 4.0f, 2, 10, 10, -0.5f);
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.bodytop2.func_78785_a(f5);
        this.bodytop3.func_78785_a(f5);
        this.armr.func_78785_a(f5);
        this.bodytop.func_78785_a(f5);
        this.bodybot.func_78785_a(f5);
        this.arml3.func_78785_a(f5);
        this.head.func_78785_a(f5);
        this.arml.func_78785_a(f5);
        this.armr3.func_78785_a(f5);
        this.bodytopinside.func_78785_a(f5);
        this.bodybot3.func_78785_a(f5);
        this.bodybot2.func_78785_a(f5);
        this.armr2.func_78785_a(f5);
        this.arml2.func_78785_a(f5);
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.armr.field_78808_h = Mth.func_76134_b((float)(ageInTicks * 0.5f)) * (float)Math.PI * 0.15f;
        this.arml.field_78808_h = -this.armr.field_78808_h;
        this.armr2.field_78808_h = Mth.func_76134_b((float)((ageInTicks + 10.0f) * 0.5f)) * (float)Math.PI * 0.15f;
        this.arml2.field_78808_h = -this.armr2.field_78808_h;
        this.armr3.field_78808_h = Mth.func_76134_b((float)((ageInTicks + 20.0f) * 0.5f)) * (float)Math.PI * 0.15f;
        this.arml3.field_78808_h = -this.armr3.field_78808_h;
        this.head.field_78796_g = netHeadYaw * ((float)Math.PI / 180);
        this.head.field_78795_f = headPitch * ((float)Math.PI / 180);
        this.bodybot3.field_78796_g = ageInTicks * -0.2f;
        this.bodybot2.field_78796_g = ageInTicks * -0.2f;
        this.bodytopinside.field_78796_g = ageInTicks * 0.2f;
        this.bodybot3.field_78808_h = Mth.func_76134_b((float)(ageInTicks * 0.1f)) * (float)Math.PI * 0.15f;
        this.bodybot2.field_78808_h = Mth.func_76134_b((float)(ageInTicks * 0.1f)) * (float)Math.PI * 0.15f;
    }
}

