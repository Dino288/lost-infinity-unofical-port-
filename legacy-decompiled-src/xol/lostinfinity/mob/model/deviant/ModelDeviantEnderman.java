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

public class ModelDeviantEnderman
extends ModelBase {
    public ModelRenderer rightarm;
    public ModelRenderer rightleg;
    public ModelRenderer head;
    public ModelRenderer body;
    public ModelRenderer leftarm;
    public ModelRenderer leftleg;
    public ModelRenderer head2;
    public ModelRenderer body_1;
    public ModelRenderer crown;
    public ModelRenderer horn1;
    public ModelRenderer horn2;

    public ModelDeviantEnderman() {
        this.field_78090_t = 128;
        this.field_78089_u = 64;
        this.leftarm = new ModelRenderer((ModelBase)this, 56, 0);
        this.leftarm.field_78809_i = true;
        this.leftarm.func_78793_a(5.0f, -12.0f, 0.0f);
        this.leftarm.func_78790_a(-1.0f, -2.0f, -1.0f, 2, 30, 2, 0.0f);
        this.setRotateAngle(this.leftarm, 0.0f, 0.0f, -0.10000736f);
        this.crown = new ModelRenderer((ModelBase)this, 14, 32);
        this.crown.func_78793_a(0.0f, -13.0f, -0.0f);
        this.crown.func_78790_a(-4.0f, -11.0f, -4.0f, 8, 3, 8, 0.0f);
        this.body = new ModelRenderer((ModelBase)this, 65, 0);
        this.body.func_78793_a(0.0f, -14.0f, -0.0f);
        this.body.func_78790_a(-3.0f, 0.0f, 0.0f, 6, 29, 12, 0.0f);
        this.body_1 = new ModelRenderer((ModelBase)this, 32, 16);
        this.body_1.func_78793_a(0.0f, -14.0f, -0.0f);
        this.body_1.func_78790_a(-4.0f, 0.0f, -2.0f, 8, 12, 4, 0.0f);
        this.head = new ModelRenderer((ModelBase)this, 0, 0);
        this.head.func_78793_a(0.0f, -13.0f, -0.0f);
        this.head.func_78790_a(-4.0f, -8.0f, -4.0f, 8, 8, 8, 0.0f);
        this.horn1 = new ModelRenderer((ModelBase)this, 0, 34);
        this.horn1.func_78793_a(0.0f, -13.0f, -0.0f);
        this.horn1.func_78790_a(-5.0f, -12.0f, -2.0f, 3, 6, 3, 0.0f);
        this.head2 = new ModelRenderer((ModelBase)this, 0, 16);
        this.head2.func_78793_a(0.0f, -13.0f, -0.0f);
        this.head2.func_78790_a(-4.0f, -8.0f, -4.0f, 8, 8, 8, -0.5f);
        this.rightarm = new ModelRenderer((ModelBase)this, 56, 0);
        this.rightarm.func_78793_a(-5.0f, -12.0f, 0.0f);
        this.rightarm.func_78790_a(-1.0f, -2.0f, -1.0f, 2, 30, 2, 0.0f);
        this.setRotateAngle(this.rightarm, 0.0f, 0.0f, 0.10000736f);
        this.rightleg = new ModelRenderer((ModelBase)this, 56, 0);
        this.rightleg.func_78793_a(-2.0f, -5.0f, 0.0f);
        this.rightleg.func_78790_a(-1.0f, 0.0f, -1.0f, 2, 30, 2, 0.0f);
        this.leftleg = new ModelRenderer((ModelBase)this, 56, 0);
        this.leftleg.field_78809_i = true;
        this.leftleg.func_78793_a(2.0f, -5.0f, 0.0f);
        this.leftleg.func_78790_a(-1.0f, 0.0f, -1.0f, 2, 30, 2, 0.0f);
        this.horn2 = new ModelRenderer((ModelBase)this, 0, 34);
        this.horn2.func_78793_a(0.0f, -13.0f, -0.0f);
        this.horn2.func_78790_a(2.0f, -12.0f, -2.0f, 3, 6, 3, 0.0f);
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.leftarm.func_78785_a(f5);
        this.crown.func_78785_a(f5);
        this.body.func_78785_a(f5);
        this.body_1.func_78785_a(f5);
        this.head.func_78785_a(f5);
        this.horn1.func_78785_a(f5);
        this.head2.func_78785_a(f5);
        this.rightarm.func_78785_a(f5);
        this.rightleg.func_78785_a(f5);
        this.leftleg.func_78785_a(f5);
        this.horn2.func_78785_a(f5);
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.head.field_78796_g = netHeadYaw * ((float)Math.PI / 180);
        this.head.field_78795_f = headPitch * ((float)Math.PI / 180);
        this.crown.field_78796_g = netHeadYaw * ((float)Math.PI / 180);
        this.crown.field_78795_f = headPitch * ((float)Math.PI / 180);
        this.horn1.field_78796_g = netHeadYaw * ((float)Math.PI / 180);
        this.horn1.field_78795_f = headPitch * ((float)Math.PI / 180);
        this.horn2.field_78796_g = netHeadYaw * ((float)Math.PI / 180);
        this.horn2.field_78795_f = headPitch * ((float)Math.PI / 180);
        this.rightleg.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f)) * 1.4f * limbSwingAmount * 0.5f;
        this.leftleg.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f + (float)Math.PI)) * 1.4f * limbSwingAmount * 0.5f;
        this.rightarm.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f + (float)Math.PI)) * 2.0f * limbSwingAmount * 0.5f;
        this.leftarm.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f)) * 2.0f * limbSwingAmount * 0.5f;
        this.body.field_78795_f = Mth.func_76134_b((float)(ageInTicks * 0.1f)) * (float)Math.PI * 0.05f + 0.3f;
    }
}

