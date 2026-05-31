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

public class ModelDeviantSkeleton
extends ModelBase {
    public ModelRenderer rightarm;
    public ModelRenderer rightleg;
    public ModelRenderer head;
    public ModelRenderer leftarm;
    public ModelRenderer leftleg;
    public ModelRenderer leftarmt;
    public ModelRenderer rightarmt;
    public ModelRenderer leftarmb;
    public ModelRenderer rightarmb;
    public ModelRenderer body;
    public ModelRenderer spinebase;
    public ModelRenderer spine;
    public ModelRenderer spine2;
    public ModelRenderer spine3;
    public ModelRenderer spine4;
    public ModelRenderer staff1;
    public ModelRenderer staff2;

    public ModelDeviantSkeleton() {
        this.field_78090_t = 64;
        this.field_78089_u = 64;
        this.rightarmt = new ModelRenderer((ModelBase)this, 40, 0);
        this.rightarmt.func_78793_a(-6.0f, 2.0f, 0.0f);
        this.rightarmt.func_78790_a(-4.0f, -2.0f, -3.0f, 6, 6, 6, 0.0f);
        this.setRotateAngle(this.rightarmt, 0.0f, 0.0f, 0.10000736f);
        this.spine4 = new ModelRenderer((ModelBase)this, 26, 34);
        this.spine4.field_78809_i = true;
        this.spine4.func_78793_a(-3.0f, 2.0f, 7.0f);
        this.spine4.func_78790_a(-1.5f, -14.0f, -2.0f, 1, 8, 4, 0.0f);
        this.setRotateAngle(this.spine4, 0.61086524f, 0.61086524f, 0.0f);
        this.rightleg = new ModelRenderer((ModelBase)this, 0, 16);
        this.rightleg.func_78793_a(-2.0f, 12.0f, 0.1f);
        this.rightleg.func_78790_a(-1.0f, 0.0f, -1.0f, 2, 12, 2, 0.0f);
        this.head = new ModelRenderer((ModelBase)this, 0, 0);
        this.head.func_78793_a(0.0f, 0.0f, 0.0f);
        this.head.func_78790_a(-4.0f, -8.0f, -4.0f, 8, 8, 8, 0.0f);
        this.leftarmt = new ModelRenderer((ModelBase)this, 40, 0);
        this.leftarmt.field_78809_i = true;
        this.leftarmt.func_78793_a(6.0f, 2.0f, 0.0f);
        this.leftarmt.func_78790_a(-2.0f, -2.0f, -3.0f, 6, 6, 6, 0.0f);
        this.setRotateAngle(this.leftarmt, 0.0f, 0.0f, -0.10000736f);
        this.body = new ModelRenderer((ModelBase)this, 16, 16);
        this.body.func_78793_a(0.0f, 0.0f, 0.0f);
        this.body.func_78790_a(-4.0f, 0.0f, -2.0f, 8, 12, 4, 0.0f);
        this.rightarmb = new ModelRenderer((ModelBase)this, 50, 16);
        this.rightarmb.func_78793_a(-6.0f, 2.0f, 0.0f);
        this.rightarmb.func_78790_a(-3.0f, 4.0f, -1.0f, 1, 8, 2, 0.0f);
        this.setRotateAngle(this.rightarmb, 0.0f, 0.0f, 0.10000736f);
        this.staff2 = new ModelRenderer((ModelBase)this, 35, 48);
        this.staff2.func_78793_a(-6.0f, 2.0f, 0.0f);
        this.staff2.func_78790_a(-3.0f, -9.0f, -12.0f, 6, 6, 6, 0.0f);
        this.setRotateAngle(this.staff2, 0.61086524f, 0.0f, 0.10000736f);
        this.leftarmb = new ModelRenderer((ModelBase)this, 50, 16);
        this.leftarmb.field_78809_i = true;
        this.leftarmb.func_78793_a(6.0f, 2.0f, 0.0f);
        this.leftarmb.func_78790_a(2.0f, 4.0f, -1.0f, 1, 8, 2, 0.0f);
        this.setRotateAngle(this.leftarmb, 0.0f, 0.0f, -0.10000736f);
        this.leftarm = new ModelRenderer((ModelBase)this, 40, 16);
        this.leftarm.field_78809_i = true;
        this.leftarm.func_78793_a(6.0f, 2.0f, 0.0f);
        this.leftarm.func_78790_a(-1.0f, 4.0f, -1.0f, 2, 12, 2, 0.0f);
        this.setRotateAngle(this.leftarm, 0.0f, 0.0f, -0.10000736f);
        this.spine = new ModelRenderer((ModelBase)this, 40, 34);
        this.spine.func_78793_a(3.0f, 2.0f, 7.0f);
        this.spine.func_78790_a(-1.5f, -6.0f, -2.0f, 3, 8, 4, 0.0f);
        this.setRotateAngle(this.spine, 0.61086524f, -0.61086524f, 0.0f);
        this.spine3 = new ModelRenderer((ModelBase)this, 40, 34);
        this.spine3.func_78793_a(-3.0f, 2.0f, 7.0f);
        this.spine3.func_78790_a(-1.5f, -6.0f, -2.0f, 3, 8, 4, 0.0f);
        this.setRotateAngle(this.spine3, 0.61086524f, 0.61086524f, 0.0f);
        this.spinebase = new ModelRenderer((ModelBase)this, 0, 34);
        this.spinebase.func_78793_a(0.0f, 0.5f, 5.0f);
        this.spinebase.func_78790_a(-3.0f, 0.0f, -2.0f, 6, 11, 6, 0.0f);
        this.rightarm = new ModelRenderer((ModelBase)this, 40, 16);
        this.rightarm.func_78793_a(-6.0f, 2.0f, 0.0f);
        this.rightarm.func_78790_a(-1.0f, 4.0f, -1.0f, 2, 12, 2, 0.0f);
        this.setRotateAngle(this.rightarm, 0.0f, 0.0f, 0.10000736f);
        this.spine2 = new ModelRenderer((ModelBase)this, 26, 34);
        this.spine2.func_78793_a(3.0f, 2.0f, 7.0f);
        this.spine2.func_78790_a(0.5f, -14.0f, -2.0f, 1, 8, 4, 0.0f);
        this.setRotateAngle(this.spine2, 0.61086524f, -0.61086524f, 0.0f);
        this.staff1 = new ModelRenderer((ModelBase)this, 58, 23);
        this.staff1.func_78793_a(-6.0f, 2.0f, 0.0f);
        this.staff1.func_78790_a(-0.5f, -3.0f, -9.0f, 1, 18, 1, 0.0f);
        this.setRotateAngle(this.staff1, 0.61086524f, 0.0f, 0.10000736f);
        this.leftleg = new ModelRenderer((ModelBase)this, 0, 16);
        this.leftleg.field_78809_i = true;
        this.leftleg.func_78793_a(2.0f, 12.0f, 0.1f);
        this.leftleg.func_78790_a(-1.0f, 0.0f, -1.0f, 2, 12, 2, 0.0f);
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.rightarmt.func_78785_a(f5);
        this.spine4.func_78785_a(f5);
        this.rightleg.func_78785_a(f5);
        this.head.func_78785_a(f5);
        this.leftarmt.func_78785_a(f5);
        this.body.func_78785_a(f5);
        this.rightarmb.func_78785_a(f5);
        this.staff2.func_78785_a(f5);
        this.leftarmb.func_78785_a(f5);
        this.leftarm.func_78785_a(f5);
        this.spine.func_78785_a(f5);
        this.spine3.func_78785_a(f5);
        this.spinebase.func_78785_a(f5);
        this.rightarm.func_78785_a(f5);
        this.spine2.func_78785_a(f5);
        this.staff1.func_78785_a(f5);
        this.leftleg.func_78785_a(f5);
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.head.field_78796_g = netHeadYaw * ((float)Math.PI / 180);
        this.head.field_78795_f = headPitch * ((float)Math.PI / 180);
        this.rightleg.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f)) * 1.4f * limbSwingAmount * 0.5f;
        this.leftleg.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f + (float)Math.PI)) * 1.4f * limbSwingAmount * 0.5f;
    }
}

