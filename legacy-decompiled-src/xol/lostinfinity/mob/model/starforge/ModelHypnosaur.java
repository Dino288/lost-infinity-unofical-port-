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
import xol.lostinfinity.mob.entity.starforge.EntityHypnosaur;

public class ModelHypnosaur
extends ModelBase {
    public ModelRenderer body;
    public ModelRenderer legbl;
    public ModelRenderer legfl;
    public ModelRenderer legbr;
    public ModelRenderer legfr;
    public ModelRenderer headbar;
    public ModelRenderer headcage1;
    public ModelRenderer headcage2;
    public ModelRenderer headeye1;
    public ModelRenderer headeye2;
    public ModelRenderer bodycage;

    public ModelHypnosaur() {
        this.field_78090_t = 64;
        this.field_78089_u = 64;
        this.legfr = new ModelRenderer((ModelBase)this, 0, 32);
        this.legfr.func_78793_a(-3.0f, 18.0f, -5.0f);
        this.legfr.func_78790_a(-2.0f, 0.0f, -2.0f, 4, 6, 4, 0.0f);
        this.headeye1 = new ModelRenderer((ModelBase)this, 0, 21);
        this.headeye1.func_78793_a(0.0f, 12.5f, -6.5f);
        this.headeye1.func_78790_a(-11.3f, -2.0f, -4.0f, 4, 4, 4, 0.0f);
        this.legbl = new ModelRenderer((ModelBase)this, 0, 32);
        this.legbl.func_78793_a(3.0f, 18.0f, 7.0f);
        this.legbl.func_78790_a(-2.0f, 0.0f, -2.0f, 4, 6, 4, 0.0f);
        this.legfl = new ModelRenderer((ModelBase)this, 0, 32);
        this.legfl.func_78793_a(3.0f, 18.0f, -5.0f);
        this.legfl.func_78790_a(-2.0f, 0.0f, -2.0f, 4, 6, 4, 0.0f);
        this.headeye2 = new ModelRenderer((ModelBase)this, 0, 21);
        this.headeye2.func_78793_a(0.0f, 12.5f, -6.5f);
        this.headeye2.func_78790_a(7.3f, -2.0f, -4.0f, 4, 4, 4, 0.0f);
        this.legbr = new ModelRenderer((ModelBase)this, 0, 32);
        this.legbr.func_78793_a(-3.0f, 18.0f, 7.0f);
        this.legbr.func_78790_a(-2.0f, 0.0f, -2.0f, 4, 6, 4, 0.0f);
        this.headcage1 = new ModelRenderer((ModelBase)this, 0, 9);
        this.headcage1.func_78793_a(0.0f, 12.5f, -6.5f);
        this.headcage1.func_78790_a(-11.8f, -2.5f, -4.5f, 5, 5, 5, 0.0f);
        this.body = new ModelRenderer((ModelBase)this, 28, 8);
        this.body.func_78793_a(0.0f, 11.0f, 2.0f);
        this.body.func_78790_a(-5.0f, -10.0f, -7.0f, 10, 16, 8, 0.0f);
        this.setRotateAngle(this.body, 1.5707964f, 0.0f, 0.0f);
        this.headbar = new ModelRenderer((ModelBase)this, 0, 0);
        this.headbar.func_78793_a(0.0f, 12.5f, -6.5f);
        this.headbar.func_78790_a(-7.0f, -2.0f, -4.0f, 14, 4, 4, 0.0f);
        this.bodycage = new ModelRenderer((ModelBase)this, 14, 34);
        this.bodycage.func_78793_a(0.0f, 11.0f, 2.0f);
        this.bodycage.func_78790_a(-5.5f, -1.5f, -7.0f, 11, 5, 12, 0.0f);
        this.headcage2 = new ModelRenderer((ModelBase)this, 0, 9);
        this.headcage2.func_78793_a(0.0f, 12.5f, -6.5f);
        this.headcage2.func_78790_a(6.8f, -2.5f, -4.5f, 5, 5, 5, 0.0f);
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.legfr.func_78785_a(f5);
        this.headeye1.func_78785_a(f5);
        this.legbl.func_78785_a(f5);
        this.legfl.func_78785_a(f5);
        this.headeye2.func_78785_a(f5);
        this.legbr.func_78785_a(f5);
        this.headcage1.func_78785_a(f5);
        this.body.func_78785_a(f5);
        this.headbar.func_78785_a(f5);
        this.bodycage.func_78785_a(f5);
        this.headcage2.func_78785_a(f5);
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
        EntityHypnosaur entity = (EntityHypnosaur)entityIn;
        if (entity.getAngry()) {
            this.headcage1.field_78808_h = this.headbar.field_78808_h = Mth.func_76134_b((float)(ageInTicks * 0.1f)) * (float)Math.PI * 0.15f;
            this.headcage2.field_78808_h = this.headbar.field_78808_h;
            this.headeye1.field_78808_h = this.headbar.field_78808_h;
            this.headeye2.field_78808_h = this.headbar.field_78808_h;
        }
    }
}

