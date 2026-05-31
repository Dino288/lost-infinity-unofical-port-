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
package xol.lostinfinity.mob.model.starforge;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;

public class ModelFlutterfyre
extends ModelBase {
    public ModelRenderer body;
    public ModelRenderer wingL;
    public ModelRenderer wingR;
    public ModelRenderer head;
    public ModelRenderer head2;
    public ModelRenderer head3;
    public ModelRenderer head4;
    public ModelRenderer head5;
    public ModelRenderer tail1;
    public ModelRenderer tail2;
    public ModelRenderer tail3;
    public ModelRenderer tail4;
    public ModelRenderer tail5;
    public ModelRenderer tail6;
    public ModelRenderer body2;
    public ModelRenderer bodylight;

    public ModelFlutterfyre() {
        this.field_78090_t = 64;
        this.field_78089_u = 32;
        this.tail4 = new ModelRenderer((ModelBase)this, 45, 0);
        this.tail4.func_78793_a(-2.5f, 16.0f, 5.0f);
        this.tail4.func_78790_a(-1.0f, -1.5f, 1.0f, 1, 3, 6, 0.0f);
        this.tail6 = new ModelRenderer((ModelBase)this, 45, 0);
        this.tail6.func_78793_a(0.0f, 17.5f, 5.0f);
        this.tail6.func_78790_a(-1.0f, -1.5f, 1.0f, 1, 3, 6, 0.0f);
        this.wingR = new ModelRenderer((ModelBase)this, 0, 13);
        this.wingR.field_78809_i = true;
        this.wingR.func_78793_a(-3.3f, 14.5f, 1.0f);
        this.wingR.func_78790_a(-9.0f, 0.0f, -3.5f, 9, 1, 7, 0.0f);
        this.body = new ModelRenderer((ModelBase)this, 0, 0);
        this.body.func_78793_a(0.0f, 15.0f, -3.0f);
        this.body.func_78790_a(-4.0f, 0.0f, 0.0f, 8, 4, 8, 0.0f);
        this.tail1 = new ModelRenderer((ModelBase)this, 32, 0);
        this.tail1.func_78793_a(-2.5f, 16.0f, 5.0f);
        this.tail1.func_78790_a(-0.5f, -0.5f, 0.0f, 1, 1, 5, 0.0f);
        this.head4 = new ModelRenderer((ModelBase)this, 14, 26);
        this.head4.func_78793_a(0.0f, 15.5f, -3.5f);
        this.head4.func_78790_a(-2.5f, -6.0f, -1.5f, 2, 2, 2, 0.0f);
        this.tail2 = new ModelRenderer((ModelBase)this, 32, 0);
        this.tail2.func_78793_a(2.5f, 16.0f, 5.0f);
        this.tail2.func_78790_a(-0.5f, -0.5f, 0.0f, 1, 1, 5, 0.0f);
        this.tail3 = new ModelRenderer((ModelBase)this, 32, 0);
        this.tail3.func_78793_a(0.0f, 17.5f, 5.0f);
        this.tail3.func_78790_a(-0.5f, -0.5f, 0.0f, 1, 1, 5, 0.0f);
        this.bodylight = new ModelRenderer((ModelBase)this, 30, 23);
        this.bodylight.func_78793_a(0.0f, 15.0f, -3.0f);
        this.bodylight.func_78790_a(-3.5f, 3.5f, 0.5f, 7, 1, 7, 0.0f);
        this.head3 = new ModelRenderer((ModelBase)this, 14, 22);
        this.head3.func_78793_a(0.0f, 15.5f, -3.5f);
        this.head3.func_78790_a(1.0f, -4.0f, -1.0f, 1, 2, 1, 0.0f);
        this.head = new ModelRenderer((ModelBase)this, 0, 24);
        this.head.func_78793_a(0.0f, 15.5f, -3.5f);
        this.head.func_78790_a(-2.0f, -2.0f, -1.0f, 4, 4, 2, 0.0f);
        this.head5 = new ModelRenderer((ModelBase)this, 14, 26);
        this.head5.func_78793_a(0.0f, 15.5f, -3.5f);
        this.head5.func_78790_a(0.5f, -6.0f, -1.5f, 2, 2, 2, 0.0f);
        this.tail5 = new ModelRenderer((ModelBase)this, 45, 0);
        this.tail5.func_78793_a(2.5f, 16.0f, 5.0f);
        this.tail5.func_78790_a(-1.0f, -1.5f, 1.0f, 1, 3, 6, 0.0f);
        this.wingL = new ModelRenderer((ModelBase)this, 0, 13);
        this.wingL.func_78793_a(3.3f, 14.5f, 1.0f);
        this.wingL.func_78790_a(0.0f, 0.0f, -3.5f, 9, 1, 7, 0.0f);
        this.head2 = new ModelRenderer((ModelBase)this, 14, 22);
        this.head2.func_78793_a(0.0f, 15.5f, -3.5f);
        this.head2.func_78790_a(-2.0f, -4.0f, -1.0f, 1, 2, 1, 0.0f);
        this.body2 = new ModelRenderer((ModelBase)this, 30, 10);
        this.body2.func_78793_a(0.0f, 15.0f, -3.0f);
        this.body2.func_78790_a(-4.0f, 4.0f, 0.0f, 8, 1, 8, 0.0f);
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.tail4.func_78785_a(f5);
        this.tail6.func_78785_a(f5);
        this.wingR.func_78785_a(f5);
        this.body.func_78785_a(f5);
        this.tail1.func_78785_a(f5);
        this.head4.func_78785_a(f5);
        this.tail2.func_78785_a(f5);
        this.tail3.func_78785_a(f5);
        GlStateManager.func_179147_l();
        GlStateManager.func_179112_b((int)770, (int)771);
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)0.8f);
        this.bodylight.func_78785_a(f5);
        GlStateManager.func_179084_k();
        this.head3.func_78785_a(f5);
        this.head.func_78785_a(f5);
        this.head5.func_78785_a(f5);
        this.tail5.func_78785_a(f5);
        this.wingL.func_78785_a(f5);
        this.head2.func_78785_a(f5);
        this.body2.func_78785_a(f5);
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.wingL.field_78808_h = Mth.func_76134_b((float)(ageInTicks * 1.5f)) * (float)Math.PI * 0.15f;
        this.wingR.field_78808_h = -this.wingL.field_78808_h;
        this.tail2.field_78795_f = this.tail1.field_78795_f = Mth.func_76134_b((float)(ageInTicks * 0.1f)) * (float)Math.PI * 0.05f;
        this.tail3.field_78795_f = this.tail1.field_78795_f;
        this.tail4.field_78795_f = this.tail1.field_78795_f;
        this.tail5.field_78795_f = this.tail1.field_78795_f;
        this.tail6.field_78795_f = this.tail1.field_78795_f;
    }
}

