/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.model.ModelRenderer
 *  net.minecraft.entity.Entity
 */
package xol.lostinfinity.mob.model.deviant;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.world.entity.Entity;

public class ModelDeviantShulker
extends ModelBase {
    public ModelRenderer head;
    public ModelRenderer bot;
    public ModelRenderer top;
    public ModelRenderer headbar;
    public ModelRenderer finr;
    public ModelRenderer finl;

    public ModelDeviantShulker() {
        this.field_78090_t = 128;
        this.field_78089_u = 64;
        this.top = new ModelRenderer((ModelBase)this, 0, 0);
        this.top.func_78793_a(0.0f, 10.0f, 0.0f);
        this.top.func_78790_a(-8.0f, -15.0f, -8.0f, 16, 12, 16, 0.0f);
        this.finr = new ModelRenderer((ModelBase)this, 75, 0);
        this.finr.field_78809_i = true;
        this.finr.func_78793_a(0.0f, 10.0f, 0.0f);
        this.finr.func_78790_a(-13.0f, -10.0f, -10.0f, 1, 20, 20, 0.0f);
        this.headbar = new ModelRenderer((ModelBase)this, 28, 56);
        this.headbar.func_78793_a(0.0f, 10.0f, 0.0f);
        this.headbar.func_78790_a(-12.0f, -1.0f, -1.5f, 24, 2, 2, 0.0f);
        this.head = new ModelRenderer((ModelBase)this, 0, 52);
        this.head.func_78793_a(0.0f, 10.0f, 0.0f);
        this.head.func_78790_a(-3.0f, -3.0f, -3.0f, 6, 6, 6, 0.0f);
        this.finl = new ModelRenderer((ModelBase)this, 75, 0);
        this.finl.func_78793_a(0.0f, 10.0f, 0.0f);
        this.finl.func_78790_a(12.0f, -10.0f, -10.0f, 1, 20, 20, 0.0f);
        this.bot = new ModelRenderer((ModelBase)this, 0, 28);
        this.bot.func_78793_a(0.0f, 10.0f, 0.0f);
        this.bot.func_78790_a(-8.0f, 3.0f, -8.0f, 16, 8, 16, 0.0f);
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.top.func_78785_a(f5);
        this.finr.func_78785_a(f5);
        this.headbar.func_78785_a(f5);
        this.head.func_78785_a(f5);
        this.finl.func_78785_a(f5);
        this.bot.func_78785_a(f5);
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.finl.field_78795_f = ageInTicks * 0.3f;
        this.finr.field_78795_f = ageInTicks * 0.3f;
        this.headbar.field_78795_f = ageInTicks * 0.3f;
    }
}

