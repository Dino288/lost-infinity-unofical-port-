/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.model.ModelRenderer
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.math.Mth
 */
package xol.lostinfinity.mob.model.labyrinth;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;

public class ModelCyclos
extends ModelBase {
    public ModelRenderer armr;
    public ModelRenderer legr;
    public ModelRenderer head;
    public ModelRenderer body;
    public ModelRenderer arml;
    public ModelRenderer legl;
    public ModelRenderer eye;
    public ModelRenderer heada1p1;
    public ModelRenderer heada2p1;
    public ModelRenderer heada1p2;
    public ModelRenderer heada2p2;

    public ModelCyclos() {
        this.field_78090_t = 64;
        this.field_78089_u = 64;
        this.heada1p1 = new ModelRenderer((ModelBase)this, 32, 0);
        this.heada1p1.func_78793_a(0.0f, -1.5f, 3.0f);
        this.heada1p1.func_78790_a(-1.0f, -4.0f, -1.0f, 2, 4, 2, 0.0f);
        this.setRotateAngle(this.heada1p1, -0.5235988f, 0.0f, 0.0f);
        this.arml = new ModelRenderer((ModelBase)this, 47, 16);
        this.arml.field_78809_i = true;
        this.arml.func_78793_a(4.0f, 6.0f, 0.0f);
        this.arml.func_78790_a(-1.0f, -2.0f, -2.0f, 4, 12, 4, 0.0f);
        this.setRotateAngle(this.arml, 0.0f, 0.0f, -0.2617994f);
        this.heada1p2 = new ModelRenderer((ModelBase)this, 50, 0);
        this.heada1p2.func_78793_a(0.0f, -3.0f, 0.0f);
        this.heada1p2.func_78790_a(-0.5f, -4.0f, -0.5f, 1, 4, 1, 0.0f);
        this.setRotateAngle(this.heada1p2, 0.08726646f, 0.015583298f, 0.0f);
        this.armr = new ModelRenderer((ModelBase)this, 47, 16);
        this.armr.func_78793_a(-4.0f, 6.0f, 0.0f);
        this.armr.func_78790_a(-3.0f, -2.0f, -2.0f, 4, 12, 4, 0.0f);
        this.setRotateAngle(this.armr, 0.0f, 0.0f, 0.2617994f);
        this.legr = new ModelRenderer((ModelBase)this, 0, 16);
        this.legr.func_78793_a(-1.9f, 16.0f, 0.1f);
        this.legr.func_78790_a(-2.0f, 0.0f, -2.0f, 4, 8, 4, 0.0f);
        this.eye = new ModelRenderer((ModelBase)this, 44, 8);
        this.eye.func_78793_a(0.0f, 0.0f, 0.0f);
        this.eye.func_78790_a(-2.0f, -2.5f, -2.0f, 4, 1, 4, 0.0f);
        this.heada2p1 = new ModelRenderer((ModelBase)this, 32, 0);
        this.heada2p1.func_78793_a(0.0f, -1.5f, -3.0f);
        this.heada2p1.func_78790_a(-1.0f, -4.0f, -1.0f, 2, 4, 2, 0.0f);
        this.setRotateAngle(this.heada2p1, 0.5235988f, 0.0f, 0.0f);
        this.head = new ModelRenderer((ModelBase)this, 0, 0);
        this.head.func_78793_a(0.0f, 4.0f, 0.0f);
        this.head.func_78790_a(-4.0f, -2.0f, -4.0f, 8, 2, 8, 0.0f);
        this.body = new ModelRenderer((ModelBase)this, 16, 16);
        this.body.func_78793_a(0.0f, 4.0f, 0.0f);
        this.body.func_78790_a(-4.0f, 0.0f, -3.0f, 8, 12, 6, 0.0f);
        this.legl = new ModelRenderer((ModelBase)this, 0, 16);
        this.legl.field_78809_i = true;
        this.legl.func_78793_a(1.9f, 16.0f, 0.1f);
        this.legl.func_78790_a(-2.0f, 0.0f, -2.0f, 4, 8, 4, 0.0f);
        this.heada2p2 = new ModelRenderer((ModelBase)this, 50, 0);
        this.heada2p2.func_78793_a(0.0f, -3.0f, 0.0f);
        this.heada2p2.func_78790_a(-0.5f, -4.0f, -0.5f, 1, 4, 1, 0.0f);
        this.setRotateAngle(this.heada2p2, -0.08726646f, 0.0155334305f, 0.0f);
        this.head.func_78792_a(this.heada1p1);
        this.heada1p1.func_78792_a(this.heada1p2);
        this.head.func_78792_a(this.eye);
        this.head.func_78792_a(this.heada2p1);
        this.heada2p1.func_78792_a(this.heada2p2);
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.arml.func_78785_a(f5);
        this.armr.func_78785_a(f5);
        this.legr.func_78785_a(f5);
        this.head.func_78785_a(f5);
        this.body.func_78785_a(f5);
        this.legl.func_78785_a(f5);
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.legr.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f)) * 1.4f * limbSwingAmount * 0.5f;
        this.legl.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f + (float)Math.PI)) * 1.4f * limbSwingAmount * 0.5f;
        this.armr.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f + (float)Math.PI)) * 2.0f * limbSwingAmount * 0.5f;
        this.arml.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f)) * 2.0f * limbSwingAmount * 0.5f;
        float rot = 0.1f;
        if (ageInTicks % 120.0f < 50.0f) {
            rot = 0.75f;
        }
        this.head.field_78796_g = ageInTicks * rot;
    }
}

