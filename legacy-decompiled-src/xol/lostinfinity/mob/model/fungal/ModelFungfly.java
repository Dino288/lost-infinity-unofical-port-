/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.model.ModelBox
 *  net.minecraft.client.model.ModelRenderer
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.math.Mth
 */
package xol.lostinfinity.mob.model.fungal;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;

public class ModelFungfly
extends ModelBase {
    private final ModelRenderer WingL;
    private final ModelRenderer Body;
    private final ModelRenderer WingR;

    public ModelFungfly() {
        this.field_78090_t = 64;
        this.field_78089_u = 64;
        this.WingL = new ModelRenderer((ModelBase)this);
        this.WingL.func_78793_a(8.0f, 15.5f, -5.0f);
        this.WingL.field_78804_l.add(new ModelBox(this.WingL, 0, 31, 0.0f, -0.5f, -2.0f, 20, 1, 12, 0.0f, false));
        this.Body = new ModelRenderer((ModelBase)this);
        this.Body.func_78793_a(0.0f, 7.0f, 0.0f);
        this.Body.field_78804_l.add(new ModelBox(this.Body, 0, 0, -8.0f, 3.0f, -8.0f, 16, 14, 16, 0.0f, false));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 0, 0, -2.0f, -3.0f, -2.0f, 4, 6, 4, 0.0f, false));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 0, 44, -6.0f, -11.0f, -6.0f, 12, 8, 12, 0.0f, false));
        this.WingR = new ModelRenderer((ModelBase)this);
        this.WingR.func_78793_a(-8.0f, 15.5f, -5.0f);
        this.WingR.field_78804_l.add(new ModelBox(this.WingR, 0, 31, -20.0f, -0.5f, -2.0f, 20, 1, 12, 0.0f, true));
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.WingL.func_78785_a(f5);
        this.Body.func_78785_a(f5);
        this.WingR.func_78785_a(f5);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.WingL.field_78808_h = Mth.func_76134_b((float)(ageInTicks * 1.5f)) * (float)Math.PI * 0.15f;
        this.WingR.field_78808_h = -this.WingL.field_78808_h;
    }
}

