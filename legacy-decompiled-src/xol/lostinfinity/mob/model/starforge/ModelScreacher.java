/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.model.ModelRenderer
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.math.Mth
 */
package xol.lostinfinity.mob.model.starforge;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;

public class ModelScreacher
extends ModelBase {
    public ModelRenderer mouth;
    public ModelRenderer body;
    public ModelRenderer eyesocket1;
    public ModelRenderer eye1;
    public ModelRenderer eye2;
    public ModelRenderer eyesocket2;
    public ModelRenderer eyesocket3;
    public ModelRenderer eyesocket4;
    public ModelRenderer eye3;
    public ModelRenderer eye4;
    public ModelRenderer wingl1;
    public ModelRenderer wingl2;
    public ModelRenderer wingl3;
    public ModelRenderer wingr3;
    public ModelRenderer wingr2;
    public ModelRenderer wingr1;
    public ModelRenderer body3;
    public ModelRenderer body2;

    public ModelScreacher() {
        this.field_78090_t = 128;
        this.field_78089_u = 64;
        this.eye2 = new ModelRenderer((ModelBase)this, 0, 0);
        this.eye2.func_78793_a(-6.5f, 11.0f, -3.0f);
        this.eye2.func_78790_a(-1.5f, -3.0f, 0.0f, 3, 3, 1, 0.0f);
        this.eyesocket3 = new ModelRenderer((ModelBase)this, 0, 7);
        this.eyesocket3.field_78809_i = true;
        this.eyesocket3.func_78793_a(6.5f, 16.0f, -3.0f);
        this.eyesocket3.func_78790_a(-2.0f, -3.5f, 0.5f, 4, 4, 2, 0.0f);
        this.eye3 = new ModelRenderer((ModelBase)this, 0, 0);
        this.eye3.func_78793_a(-6.5f, 16.0f, -3.0f);
        this.eye3.func_78790_a(-1.5f, -3.0f, 0.0f, 3, 3, 1, 0.0f);
        this.wingl2 = new ModelRenderer((ModelBase)this, 64, 20);
        this.wingl2.func_78793_a(4.5f, 12.0f, 5.0f);
        this.wingl2.func_78790_a(0.0f, 0.0f, -5.0f, 9, 1, 16, 0.0f);
        this.body3 = new ModelRenderer((ModelBase)this, 30, 49);
        this.body3.func_78793_a(0.0f, 12.0f, -3.0f);
        this.body3.func_78790_a(-3.0f, -3.0f, 26.0f, 6, 8, 4, 0.0f);
        this.wingl1 = new ModelRenderer((ModelBase)this, 64, 0);
        this.wingl1.func_78793_a(4.5f, 15.0f, 5.0f);
        this.wingl1.func_78790_a(0.0f, 0.0f, -5.0f, 12, 1, 16, 0.0f);
        this.eyesocket2 = new ModelRenderer((ModelBase)this, 0, 7);
        this.eyesocket2.field_78809_i = true;
        this.eyesocket2.func_78793_a(6.5f, 11.0f, -3.0f);
        this.eyesocket2.func_78790_a(-2.0f, -3.5f, 0.5f, 4, 4, 2, 0.0f);
        this.eyesocket1 = new ModelRenderer((ModelBase)this, 0, 7);
        this.eyesocket1.func_78793_a(-6.5f, 11.0f, -3.0f);
        this.eyesocket1.func_78790_a(-2.0f, -3.5f, 0.5f, 4, 4, 2, 0.0f);
        this.body = new ModelRenderer((ModelBase)this, 0, 0);
        this.body.func_78793_a(0.0f, 12.0f, -3.0f);
        this.body.func_78790_a(-5.0f, -5.0f, 0.0f, 10, 10, 20, 0.0f);
        this.wingr1 = new ModelRenderer((ModelBase)this, 64, 0);
        this.wingr1.field_78809_i = true;
        this.wingr1.func_78793_a(-4.5f, 15.0f, 5.0f);
        this.wingr1.func_78790_a(-12.0f, 0.0f, -5.0f, 12, 1, 16, 0.0f);
        this.mouth = new ModelRenderer((ModelBase)this, 0, 32);
        this.mouth.func_78793_a(0.0f, 12.0f, -3.0f);
        this.mouth.func_78790_a(-5.0f, -5.0f, -3.0f, 10, 10, 3, 0.0f);
        this.wingr2 = new ModelRenderer((ModelBase)this, 64, 20);
        this.wingr2.field_78809_i = true;
        this.wingr2.func_78793_a(-4.5f, 12.0f, 5.0f);
        this.wingr2.func_78790_a(-9.0f, 0.0f, -5.0f, 9, 1, 16, 0.0f);
        this.eye1 = new ModelRenderer((ModelBase)this, 0, 0);
        this.eye1.func_78793_a(6.5f, 11.0f, -3.0f);
        this.eye1.func_78790_a(-1.5f, -3.0f, 0.0f, 3, 3, 1, 0.0f);
        this.wingl3 = new ModelRenderer((ModelBase)this, 64, 39);
        this.wingl3.func_78793_a(4.5f, 9.0f, 5.0f);
        this.wingl3.func_78790_a(0.0f, 0.0f, -5.0f, 6, 1, 16, 0.0f);
        this.wingr3 = new ModelRenderer((ModelBase)this, 64, 39);
        this.wingr3.field_78809_i = true;
        this.wingr3.func_78793_a(-4.5f, 9.0f, 5.0f);
        this.wingr3.func_78790_a(-6.0f, 0.0f, -5.0f, 6, 1, 16, 0.0f);
        this.eyesocket4 = new ModelRenderer((ModelBase)this, 0, 7);
        this.eyesocket4.func_78793_a(-6.5f, 16.0f, -3.0f);
        this.eyesocket4.func_78790_a(-2.0f, -3.5f, 0.5f, 4, 4, 2, 0.0f);
        this.eye4 = new ModelRenderer((ModelBase)this, 0, 0);
        this.eye4.func_78793_a(6.5f, 16.0f, -3.0f);
        this.eye4.func_78790_a(-1.5f, -3.0f, 0.0f, 3, 3, 1, 0.0f);
        this.body2 = new ModelRenderer((ModelBase)this, 0, 46);
        this.body2.func_78793_a(0.0f, 12.0f, -3.0f);
        this.body2.func_78790_a(-4.0f, -4.0f, 20.0f, 8, 9, 6, 0.0f);
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.eye2.func_78785_a(f5);
        this.eyesocket3.func_78785_a(f5);
        this.eye3.func_78785_a(f5);
        this.wingl2.func_78785_a(f5);
        this.body3.func_78785_a(f5);
        this.wingl1.func_78785_a(f5);
        this.eyesocket2.func_78785_a(f5);
        this.eyesocket1.func_78785_a(f5);
        this.body.func_78785_a(f5);
        this.wingr1.func_78785_a(f5);
        this.mouth.func_78785_a(f5);
        this.wingr2.func_78785_a(f5);
        this.eye1.func_78785_a(f5);
        this.wingl3.func_78785_a(f5);
        this.wingr3.func_78785_a(f5);
        this.eyesocket4.func_78785_a(f5);
        this.eye4.func_78785_a(f5);
        this.body2.func_78785_a(f5);
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.wingl1.field_78808_h = Mth.func_76134_b((float)(ageInTicks * 0.1f)) * (float)Math.PI * 0.15f;
        this.wingr1.field_78808_h = -this.wingl1.field_78808_h;
        this.wingl2.field_78808_h = Mth.func_76134_b((float)(ageInTicks * 0.1f)) * (float)Math.PI * 0.15f;
        this.wingr2.field_78808_h = -this.wingl1.field_78808_h;
        this.wingl3.field_78808_h = Mth.func_76134_b((float)(ageInTicks * 0.1f)) * (float)Math.PI * 0.15f;
        this.wingr3.field_78808_h = -this.wingl1.field_78808_h;
    }
}

