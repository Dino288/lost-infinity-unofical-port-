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

public class ModelDeviantLlama
extends ModelBase {
    public ModelRenderer body;
    public ModelRenderer legbl;
    public ModelRenderer legfl;
    public ModelRenderer legbr;
    public ModelRenderer legfr;
    public ModelRenderer nose;
    public ModelRenderer neck;
    public ModelRenderer ear1;
    public ModelRenderer ear2;
    public ModelRenderer neck2;
    public ModelRenderer flapr;
    public ModelRenderer flapl;
    public ModelRenderer ear2p2;
    public ModelRenderer ear1p2;
    public ModelRenderer mouth1;
    public ModelRenderer mouth2;

    public ModelDeviantLlama() {
        this.field_78090_t = 128;
        this.field_78089_u = 64;
        this.neck2 = new ModelRenderer((ModelBase)this, 75, 2);
        this.neck2.func_78793_a(0.0f, 7.0f, -6.0f);
        this.neck2.func_78790_a(-1.0f, -16.0f, 0.0f, 1, 18, 13, 0.0f);
        this.mouth1 = new ModelRenderer((ModelBase)this, 0, 40);
        this.mouth1.func_78793_a(0.0f, -10.0f, -5.0f);
        this.mouth1.func_78790_a(-2.0f, 0.0f, -5.0f, 4, 2, 5, 0.0f);
        this.legfl = new ModelRenderer((ModelBase)this, 29, 29);
        this.legfl.field_78809_i = true;
        this.legfl.func_78793_a(3.5f, 10.0f, -5.0f);
        this.legfl.func_78790_a(-2.0f, 0.0f, -2.0f, 4, 14, 4, 0.0f);
        this.ear2p2 = new ModelRenderer((ModelBase)this, 17, 47);
        this.ear2p2.func_78793_a(0.0f, 7.0f, -6.0f);
        this.ear2p2.func_78790_a(1.0f, -21.0f, -4.0f, 3, 2, 6, 0.0f);
        this.ear1p2 = new ModelRenderer((ModelBase)this, 17, 47);
        this.ear1p2.field_78809_i = true;
        this.ear1p2.func_78793_a(0.0f, 7.0f, -6.0f);
        this.ear1p2.func_78790_a(-4.0f, -21.0f, -4.0f, 3, 2, 6, 0.0f);
        this.neck = new ModelRenderer((ModelBase)this, 0, 14);
        this.neck.func_78793_a(0.0f, 7.0f, -6.0f);
        this.neck.func_78790_a(-4.0f, -16.0f, -6.0f, 8, 18, 6, 0.0f);
        this.legfr = new ModelRenderer((ModelBase)this, 29, 29);
        this.legfr.func_78793_a(-3.5f, 10.0f, -5.0f);
        this.legfr.func_78790_a(-2.0f, 0.0f, -2.0f, 4, 14, 4, 0.0f);
        this.flapr = new ModelRenderer((ModelBase)this, 50, 32);
        this.flapr.func_78793_a(-6.0f, 6.5f, -7.0f);
        this.flapr.func_78790_a(-1.0f, -4.0f, 0.0f, 1, 8, 14, 0.0f);
        this.legbr = new ModelRenderer((ModelBase)this, 29, 29);
        this.legbr.func_78793_a(-3.5f, 10.0f, 6.0f);
        this.legbr.func_78790_a(-2.0f, 0.0f, -2.0f, 4, 14, 4, 0.0f);
        this.ear2 = new ModelRenderer((ModelBase)this, 0, 57);
        this.ear2.field_78809_i = true;
        this.ear2.func_78793_a(0.0f, 7.0f, -6.0f);
        this.ear2.func_78790_a(1.0f, -19.0f, -4.0f, 3, 3, 2, 0.0f);
        this.mouth2 = new ModelRenderer((ModelBase)this, 0, 49);
        this.mouth2.func_78793_a(0.0f, -10.0f, -5.0f);
        this.mouth2.func_78790_a(-1.5f, -2.0f, -4.8f, 3, 2, 4, 0.0f);
        this.body = new ModelRenderer((ModelBase)this, 29, 0);
        this.body.func_78793_a(0.0f, 5.0f, 2.0f);
        this.body.func_78790_a(-6.0f, -10.0f, -7.0f, 12, 18, 10, 0.0f);
        this.setRotateAngle(this.body, 1.5707964f, 0.0f, 0.0f);
        this.legbl = new ModelRenderer((ModelBase)this, 29, 29);
        this.legbl.field_78809_i = true;
        this.legbl.func_78793_a(3.5f, 10.0f, 6.0f);
        this.legbl.func_78790_a(-2.0f, 0.0f, -2.0f, 4, 14, 4, 0.0f);
        this.ear1 = new ModelRenderer((ModelBase)this, 0, 57);
        this.ear1.func_78793_a(0.0f, 7.0f, -6.0f);
        this.ear1.func_78790_a(-4.0f, -19.0f, -4.0f, 3, 3, 2, 0.0f);
        this.flapl = new ModelRenderer((ModelBase)this, 50, 32);
        this.flapl.field_78809_i = true;
        this.flapl.func_78793_a(6.0f, 6.5f, -7.0f);
        this.flapl.func_78790_a(0.0f, -4.0f, 0.0f, 1, 8, 14, 0.0f);
        this.nose = new ModelRenderer((ModelBase)this, 0, 0);
        this.nose.func_78793_a(0.0f, 7.0f, -6.0f);
        this.nose.func_78790_a(-2.0f, -14.0f, -10.0f, 4, 4, 9, 0.0f);
        this.nose.func_78792_a(this.mouth1);
        this.nose.func_78792_a(this.mouth2);
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.neck2.func_78785_a(f5);
        this.legfl.func_78785_a(f5);
        this.ear2p2.func_78785_a(f5);
        this.ear1p2.func_78785_a(f5);
        this.neck.func_78785_a(f5);
        this.legfr.func_78785_a(f5);
        this.flapr.func_78785_a(f5);
        this.legbr.func_78785_a(f5);
        this.ear2.func_78785_a(f5);
        this.body.func_78785_a(f5);
        this.legbl.func_78785_a(f5);
        this.ear1.func_78785_a(f5);
        this.flapl.func_78785_a(f5);
        this.nose.func_78785_a(f5);
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.legbr.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f)) * 1.4f * limbSwingAmount;
        this.legbl.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f + (float)Math.PI)) * 1.4f * limbSwingAmount;
        this.legfr.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f + (float)Math.PI)) * 1.4f * limbSwingAmount;
        this.legfl.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f)) * 1.4f * limbSwingAmount;
        this.neck2.field_78795_f = this.neck.field_78795_f = -((float)(-0.3141592653589793 + (double)(Mth.func_76134_b((float)(ageInTicks * 0.1f)) * (float)Math.PI * 0.1f)));
        this.nose.field_78795_f = this.neck.field_78795_f;
        this.ear1.field_78795_f = this.neck.field_78795_f;
        this.ear2.field_78795_f = this.neck.field_78795_f;
        this.ear1p2.field_78795_f = this.neck.field_78795_f;
        this.ear2p2.field_78795_f = this.neck.field_78795_f;
        this.mouth2.field_78795_f = this.mouth1.field_78795_f = -1.0f * (-0.5235988f + Mth.func_76134_b((float)(ageInTicks * 0.5f)) * 0.5f);
        this.flapl.field_78796_g = (float)((double)(0.5f * Mth.func_76134_b((float)(ageInTicks * 0.1f))) + 0.5235987755982988);
        this.flapr.field_78796_g = -this.flapl.field_78796_g;
    }
}

