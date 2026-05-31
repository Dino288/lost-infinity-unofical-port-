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

public class ModelFlapper
extends ModelBase {
    public ModelRenderer body;
    public ModelRenderer wingL;
    public ModelRenderer wingR;
    public ModelRenderer head;
    public ModelRenderer head2;
    public ModelRenderer body2;
    public ModelRenderer body3;

    public ModelFlapper() {
        this.field_78090_t = 64;
        this.field_78089_u = 32;
        this.head = new ModelRenderer((ModelBase)this, 0, 22);
        this.head.func_78793_a(0.0f, 17.0f, -3.5f);
        this.head.func_78790_a(-3.0f, -3.0f, -1.0f, 6, 6, 2, 0.0f);
        this.wingL = new ModelRenderer((ModelBase)this, 0, 13);
        this.wingL.func_78793_a(3.5f, 14.5f, 1.0f);
        this.wingL.func_78790_a(0.0f, 0.0f, -3.5f, 16, 1, 7, 0.0f);
        this.wingR = new ModelRenderer((ModelBase)this, 0, 13);
        this.wingR.field_78809_i = true;
        this.wingR.func_78793_a(-3.3f, 14.5f, 1.0f);
        this.wingR.func_78790_a(-16.0f, 0.0f, -3.5f, 16, 1, 7, 0.0f);
        this.body2 = new ModelRenderer((ModelBase)this, 48, 0);
        this.body2.func_78793_a(0.0f, 11.0f, -1.5f);
        this.body2.func_78790_a(-1.5f, 0.0f, -1.5f, 3, 4, 3, 0.0f);
        this.body = new ModelRenderer((ModelBase)this, 0, 0);
        this.body.func_78793_a(0.0f, 15.0f, -3.0f);
        this.body.func_78790_a(-4.0f, 0.0f, 0.0f, 8, 4, 8, 0.0f);
        this.head2 = new ModelRenderer((ModelBase)this, 18, 22);
        this.head2.func_78793_a(0.0f, 17.0f, -3.5f);
        this.head2.func_78790_a(-3.0f, -3.0f, -4.0f, 6, 6, 3, 0.0f);
        this.body3 = new ModelRenderer((ModelBase)this, 48, 0);
        this.body3.func_78793_a(0.0f, 12.0f, 2.5f);
        this.body3.func_78790_a(-1.5f, 0.0f, -1.5f, 3, 4, 3, 0.0f);
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.head.func_78785_a(f5);
        this.wingL.func_78785_a(f5);
        this.wingR.func_78785_a(f5);
        this.body2.func_78785_a(f5);
        this.body.func_78785_a(f5);
        this.head2.func_78785_a(f5);
        this.body3.func_78785_a(f5);
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.wingL.field_78808_h = Mth.func_76134_b((float)(ageInTicks * 0.3f)) * (float)Math.PI * 0.35f;
        this.wingR.field_78808_h = -this.wingL.field_78808_h;
    }
}

