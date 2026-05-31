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

public class ModelHurler
extends ModelBase {
    public ModelRenderer legr;
    public ModelRenderer head;
    public ModelRenderer legl;
    public ModelRenderer head2;
    public ModelRenderer head3;
    public ModelRenderer head4;
    public ModelRenderer legr2;
    public ModelRenderer legl2;
    public ModelRenderer headfin1;
    public ModelRenderer headfin2;
    public ModelRenderer headfin3;
    public ModelRenderer headfin4;

    public ModelHurler() {
        this.field_78090_t = 64;
        this.field_78089_u = 64;
        this.head2 = new ModelRenderer((ModelBase)this, 0, 21);
        this.head2.func_78793_a(0.0f, 13.5f, 4.5f);
        this.head2.func_78790_a(-5.0f, -16.0f, 1.5f, 10, 7, 6, 0.0f);
        this.setRotateAngle(this.head2, 0.7853982f, 0.0f, 0.0f);
        this.legr2 = new ModelRenderer((ModelBase)this, 25, 46);
        this.legr2.func_78793_a(-6.5f, 12.0f, 5.0f);
        this.legr2.func_78790_a(-1.5f, 7.0f, -5.0f, 3, 5, 2, 0.0f);
        this.head4 = new ModelRenderer((ModelBase)this, 22, 35);
        this.head4.func_78793_a(0.0f, 13.5f, 4.5f);
        this.head4.func_78790_a(-2.5f, -21.5f, 5.5f, 5, 3, 5, 0.0f);
        this.setRotateAngle(this.head4, 1.0471976f, 0.0f, 0.0f);
        this.legr = new ModelRenderer((ModelBase)this, 0, 46);
        this.legr.func_78793_a(-6.5f, 12.0f, 5.0f);
        this.legr.func_78790_a(-3.0f, 0.0f, -3.0f, 6, 12, 6, 0.0f);
        this.headfin3 = new ModelRenderer((ModelBase)this, 44, 21);
        this.headfin3.func_78793_a(0.0f, 13.5f, 4.5f);
        this.headfin3.func_78790_a(-5.0f, -16.0f, 7.5f, 1, 7, 4, 0.0f);
        this.setRotateAngle(this.headfin3, 0.7853982f, 0.0f, 0.0f);
        this.head3 = new ModelRenderer((ModelBase)this, 0, 35);
        this.head3.func_78793_a(0.0f, 13.5f, 4.5f);
        this.head3.func_78790_a(-2.5f, -18.5f, 5.5f, 5, 5, 5, 0.0f);
        this.setRotateAngle(this.head3, 1.0471976f, 0.0f, 0.0f);
        this.legl2 = new ModelRenderer((ModelBase)this, 25, 46);
        this.legl2.field_78809_i = true;
        this.legl2.func_78793_a(6.5f, 12.0f, 5.0f);
        this.legl2.func_78790_a(-1.5f, 7.0f, -5.0f, 3, 5, 2, 0.0f);
        this.legl = new ModelRenderer((ModelBase)this, 0, 46);
        this.legl.field_78809_i = true;
        this.legl.func_78793_a(6.5f, 12.0f, 5.0f);
        this.legl.func_78790_a(-3.0f, 0.0f, -3.0f, 6, 12, 6, 0.0f);
        this.headfin4 = new ModelRenderer((ModelBase)this, 44, 21);
        this.headfin4.field_78809_i = true;
        this.headfin4.func_78793_a(0.0f, 13.5f, 4.5f);
        this.headfin4.func_78790_a(4.0f, -16.0f, 7.5f, 1, 7, 4, 0.0f);
        this.setRotateAngle(this.headfin4, 0.7853982f, 0.0f, 0.0f);
        this.headfin2 = new ModelRenderer((ModelBase)this, 47, 0);
        this.headfin2.field_78809_i = true;
        this.headfin2.func_78793_a(0.0f, 13.5f, 4.5f);
        this.headfin2.func_78790_a(6.0f, -12.0f, 4.0f, 1, 12, 5, 0.0f);
        this.setRotateAngle(this.headfin2, 0.34906584f, 0.0f, 0.0f);
        this.head = new ModelRenderer((ModelBase)this, 0, 0);
        this.head.func_78793_a(0.0f, 13.5f, 4.5f);
        this.head.func_78790_a(-7.0f, -12.0f, -4.0f, 14, 12, 8, 0.0f);
        this.setRotateAngle(this.head, 0.34906584f, 0.0f, 0.0f);
        this.headfin1 = new ModelRenderer((ModelBase)this, 47, 0);
        this.headfin1.func_78793_a(0.0f, 13.5f, 4.5f);
        this.headfin1.func_78790_a(-7.0f, -12.0f, 4.0f, 1, 12, 5, 0.0f);
        this.setRotateAngle(this.headfin1, 0.34906584f, 0.0f, 0.0f);
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.head2.func_78785_a(f5);
        this.legr2.func_78785_a(f5);
        this.head4.func_78785_a(f5);
        this.legr.func_78785_a(f5);
        this.headfin3.func_78785_a(f5);
        this.head3.func_78785_a(f5);
        this.legl2.func_78785_a(f5);
        this.legl.func_78785_a(f5);
        this.headfin4.func_78785_a(f5);
        this.headfin2.func_78785_a(f5);
        this.head.func_78785_a(f5);
        this.headfin1.func_78785_a(f5);
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.legr.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f)) * 1.4f * limbSwingAmount * 0.5f;
        this.legl.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f + (float)Math.PI)) * 1.4f * limbSwingAmount * 0.5f;
        this.legr2.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f)) * 1.4f * limbSwingAmount * 0.5f;
        this.legl2.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f + (float)Math.PI)) * 1.4f * limbSwingAmount * 0.5f;
        this.headfin1.field_78795_f = this.head.field_78795_f = Mth.func_76134_b((float)(ageInTicks * 0.15f)) * 0.2f + 0.34906584f;
        this.headfin2.field_78795_f = this.head.field_78795_f;
        this.headfin3.field_78795_f = this.head2.field_78795_f = this.head.field_78795_f + 0.43633f;
        this.headfin4.field_78795_f = this.head2.field_78795_f;
        this.head4.field_78795_f = this.head3.field_78795_f = this.head2.field_78795_f + 0.2618f;
    }
}

