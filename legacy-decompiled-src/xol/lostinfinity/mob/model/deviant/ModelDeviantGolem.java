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
package xol.lostinfinity.mob.model.deviant;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;

public class ModelDeviantGolem
extends ModelBase {
    private final ModelRenderer body2;
    private final ModelRenderer legl;
    private final ModelRenderer legr;
    private final ModelRenderer arml;
    private final ModelRenderer armr;
    private final ModelRenderer head;
    private final ModelRenderer heart;
    private final ModelRenderer wingr;
    private final ModelRenderer wingl;

    public ModelDeviantGolem() {
        this.field_78090_t = 128;
        this.field_78089_u = 128;
        this.body2 = new ModelRenderer((ModelBase)this);
        this.body2.func_78793_a(0.0f, 24.0f, 0.0f);
        this.body2.field_78804_l.add(new ModelBox(this.body2, 0, 22, -9.0f, -33.0f, -6.0f, 18, 12, 11, 0.0f, false));
        this.body2.field_78804_l.add(new ModelBox(this.body2, 0, 47, -4.5f, -21.0f, -3.0f, 9, 5, 6, 0.5f, false));
        this.legl = new ModelRenderer((ModelBase)this);
        this.legl.func_78793_a(5.0f, 11.0f, 0.0f);
        this.legl.field_78804_l.add(new ModelBox(this.legl, 60, 0, -3.5f, -3.0f, -3.0f, 6, 16, 5, 0.0f, true));
        this.legl.field_78804_l.add(new ModelBox(this.legl, 91, 16, -3.5f, 11.0f, -9.0f, 2, 2, 6, 0.0f, true));
        this.legl.field_78804_l.add(new ModelBox(this.legl, 91, 16, 0.5f, 11.0f, -9.0f, 2, 2, 6, 0.0f, true));
        this.legr = new ModelRenderer((ModelBase)this);
        this.legr.func_78793_a(-4.0f, 11.0f, 0.0f);
        this.legr.field_78804_l.add(new ModelBox(this.legr, 37, 0, -3.5f, -3.0f, -3.0f, 6, 16, 5, 0.0f, false));
        this.legr.field_78804_l.add(new ModelBox(this.legr, 91, 16, 0.5f, 11.0f, -9.0f, 2, 2, 6, 0.0f, false));
        this.legr.field_78804_l.add(new ModelBox(this.legr, 91, 16, -3.5f, 11.0f, -9.0f, 2, 2, 6, 0.0f, false));
        this.arml = new ModelRenderer((ModelBase)this);
        this.arml.func_78793_a(0.0f, -7.0f, 0.0f);
        this.arml.field_78804_l.add(new ModelBox(this.arml, 60, 58, 9.0f, -2.5f, -3.0f, 4, 30, 6, 0.0f, false));
        this.arml.field_78804_l.add(new ModelBox(this.arml, 81, 58, 10.0f, -2.5f, 3.0f, 1, 30, 6, 0.0f, true));
        this.armr = new ModelRenderer((ModelBase)this);
        this.armr.func_78793_a(0.0f, -7.0f, 0.0f);
        this.armr.field_78804_l.add(new ModelBox(this.armr, 60, 21, -13.0f, -2.5f, -3.0f, 4, 30, 6, 0.0f, false));
        this.armr.field_78804_l.add(new ModelBox(this.armr, 81, 21, -11.0f, -2.5f, 3.0f, 1, 30, 6, 0.0f, false));
        this.head = new ModelRenderer((ModelBase)this);
        this.head.func_78793_a(0.0f, -7.0f, -2.0f);
        this.head.field_78804_l.add(new ModelBox(this.head, 0, 0, -4.0f, -12.0f, -5.5f, 8, 10, 8, 0.0f, false));
        this.head.field_78804_l.add(new ModelBox(this.head, 83, 1, -4.0f, -12.0f, 2.5f, 8, 6, 8, 0.0f, false));
        this.head.field_78804_l.add(new ModelBox(this.head, 24, 0, -1.0f, -5.0f, -7.5f, 2, 4, 2, 0.0f, false));
        this.head.field_78804_l.add(new ModelBox(this.head, 1, 0, 2.0f, -3.0f, -6.0f, 1, 4, 1, 0.0f, false));
        this.head.field_78804_l.add(new ModelBox(this.head, 1, 0, -4.5f, -3.0f, -5.0f, 1, 4, 1, 0.0f, false));
        this.head.field_78804_l.add(new ModelBox(this.head, 1, 0, 3.5f, -3.0f, -5.0f, 1, 4, 1, 0.0f, false));
        this.head.field_78804_l.add(new ModelBox(this.head, 1, 0, -3.0f, -3.0f, -6.0f, 1, 4, 1, 0.0f, false));
        this.heart = new ModelRenderer((ModelBase)this);
        this.heart.func_78793_a(0.0f, -3.0f, 0.0f);
        this.heart.field_78804_l.add(new ModelBox(this.heart, 32, 46, -3.0f, -3.0f, -3.0f, 6, 6, 6, 0.0f, false));
        this.wingr = new ModelRenderer((ModelBase)this);
        this.wingr.func_78793_a(0.0f, 24.0f, 0.0f);
        this.wingr.field_78804_l.add(new ModelBox(this.wingr, 0, 59, -6.0f, -35.0f, 4.0f, 1, 30, 13, 0.0f, true));
        this.wingl = new ModelRenderer((ModelBase)this);
        this.wingl.func_78793_a(0.0f, 24.0f, 0.0f);
        this.wingl.field_78804_l.add(new ModelBox(this.wingl, 0, 59, 5.0f, -35.0f, 4.0f, 1, 30, 13, 0.0f, false));
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.body2.func_78785_a(f5);
        this.legl.func_78785_a(f5);
        this.legr.func_78785_a(f5);
        this.arml.func_78785_a(f5);
        this.armr.func_78785_a(f5);
        this.head.func_78785_a(f5);
        this.heart.func_78785_a(f5);
        this.wingr.func_78785_a(f5);
        this.wingl.func_78785_a(f5);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.head.field_78796_g = netHeadYaw * ((float)Math.PI / 180);
        this.head.field_78795_f = headPitch * ((float)Math.PI / 180);
        this.legl.field_78795_f = -1.5f * this.triangleWave(limbSwing, 13.0f) * limbSwingAmount;
        this.legr.field_78795_f = 1.5f * this.triangleWave(limbSwing, 13.0f) * limbSwingAmount;
        this.heart.field_78808_h = ageInTicks * 0.1f;
        this.heart.field_78796_g = Mth.func_76126_a((float)(ageInTicks * 0.05f));
        this.wingl.field_78796_g = Mth.func_76134_b((float)(ageInTicks * 0.1f)) * 0.1f;
        this.wingr.field_78796_g = -this.wingl.field_78796_g;
    }

    private float triangleWave(float p_78172_1_, float p_78172_2_) {
        return (Math.abs(p_78172_1_ % p_78172_2_ - p_78172_2_ * 0.5f) - p_78172_2_ * 0.25f) / (p_78172_2_ * 0.25f);
    }
}

