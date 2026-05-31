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
package xol.lostinfinity.mob.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;

public class ModelXScreacher
extends ModelBase {
    private final ModelRenderer mouth;
    private final ModelRenderer body;
    private final ModelRenderer eyesocket1;
    private final ModelRenderer eye1;
    private final ModelRenderer eye2;
    private final ModelRenderer eyesocket2;
    private final ModelRenderer eyesocket3;
    private final ModelRenderer eyesocket4;
    private final ModelRenderer eye3;
    private final ModelRenderer eye4;
    private final ModelRenderer wingl1;
    private final ModelRenderer wingl2;
    private final ModelRenderer wingl3;
    private final ModelRenderer wingr3;
    private final ModelRenderer wingr2;
    private final ModelRenderer wingr1;
    private final ModelRenderer body3;
    private final ModelRenderer body2;

    public ModelXScreacher() {
        this.field_78090_t = 128;
        this.field_78089_u = 64;
        this.mouth = new ModelRenderer((ModelBase)this);
        this.mouth.func_78793_a(0.0f, 12.0f, -3.0f);
        this.mouth.field_78804_l.add(new ModelBox(this.mouth, 0, 32, -5.0f, -5.0f, -3.0f, 10, 10, 3, 0.0f, false));
        this.body = new ModelRenderer((ModelBase)this);
        this.body.func_78793_a(0.0f, 12.0f, -3.0f);
        this.body.field_78804_l.add(new ModelBox(this.body, 0, 0, -5.0f, -5.0f, 0.0f, 10, 10, 20, 0.0f, false));
        this.body.field_78804_l.add(new ModelBox(this.body, 20, 52, -5.0f, -6.0f, 4.0f, 10, 1, 11, 0.0f, false));
        this.body.field_78804_l.add(new ModelBox(this.body, 28, 45, -4.0f, -6.0f, 0.0f, 3, 1, 4, 0.0f, false));
        this.body.field_78804_l.add(new ModelBox(this.body, 28, 45, 1.0f, -6.0f, 0.0f, 3, 1, 4, 0.0f, false));
        this.body.field_78804_l.add(new ModelBox(this.body, 10, 1, -6.0f, -6.0f, 5.0f, 1, 2, 1, 0.0f, false));
        this.body.field_78804_l.add(new ModelBox(this.body, 10, 1, -6.0f, -6.0f, 13.0f, 1, 2, 1, 0.0f, false));
        this.body.field_78804_l.add(new ModelBox(this.body, 10, 1, 5.0f, -6.0f, 13.0f, 1, 2, 1, 0.0f, false));
        this.body.field_78804_l.add(new ModelBox(this.body, 10, 1, 5.0f, -6.0f, 5.0f, 1, 2, 1, 0.0f, false));
        this.body.field_78804_l.add(new ModelBox(this.body, 41, 14, 6.0f, -5.0f, 2.0f, 1, 1, 4, 0.0f, false));
        this.body.field_78804_l.add(new ModelBox(this.body, 0, 15, 5.0f, -5.0f, 1.0f, 4, 3, 1, 0.0f, false));
        this.body.field_78804_l.add(new ModelBox(this.body, 0, 15, -9.0f, -5.0f, 1.0f, 4, 3, 1, 0.0f, true));
        this.body.field_78804_l.add(new ModelBox(this.body, 0, 15, 5.0f, 2.0f, 1.0f, 4, 3, 1, 0.0f, false));
        this.body.field_78804_l.add(new ModelBox(this.body, 0, 15, -9.0f, 2.0f, 1.0f, 4, 3, 1, 0.0f, true));
        this.body.field_78804_l.add(new ModelBox(this.body, 41, 14, -7.0f, -5.0f, 2.0f, 1, 1, 4, 0.0f, true));
        this.body.field_78804_l.add(new ModelBox(this.body, 28, 32, -5.0f, -16.0f, 14.0f, 10, 10, 1, 0.0f, false));
        this.eyesocket1 = new ModelRenderer((ModelBase)this);
        this.eyesocket1.func_78793_a(-6.5f, 11.0f, -3.0f);
        this.eyesocket1.field_78804_l.add(new ModelBox(this.eyesocket1, 0, 7, -2.0f, -3.5f, 0.5f, 4, 4, 2, 0.0f, false));
        this.eye1 = new ModelRenderer((ModelBase)this);
        this.eye1.func_78793_a(6.5f, 11.0f, -3.0f);
        this.eye1.field_78804_l.add(new ModelBox(this.eye1, 0, 0, -1.5f, -3.0f, 0.0f, 3, 3, 1, 0.0f, false));
        this.eye2 = new ModelRenderer((ModelBase)this);
        this.eye2.func_78793_a(-6.5f, 11.0f, -3.0f);
        this.eye2.field_78804_l.add(new ModelBox(this.eye2, 0, 0, -1.5f, -3.0f, 0.0f, 3, 3, 1, 0.0f, false));
        this.eyesocket2 = new ModelRenderer((ModelBase)this);
        this.eyesocket2.func_78793_a(6.5f, 11.0f, -3.0f);
        this.eyesocket2.field_78804_l.add(new ModelBox(this.eyesocket2, 0, 7, -2.0f, -3.5f, 0.5f, 4, 4, 2, 0.0f, true));
        this.eyesocket3 = new ModelRenderer((ModelBase)this);
        this.eyesocket3.func_78793_a(6.5f, 16.0f, -3.0f);
        this.eyesocket3.field_78804_l.add(new ModelBox(this.eyesocket3, 0, 7, -2.0f, -3.5f, 0.5f, 4, 4, 2, 0.0f, true));
        this.eyesocket4 = new ModelRenderer((ModelBase)this);
        this.eyesocket4.func_78793_a(-6.5f, 16.0f, -3.0f);
        this.eyesocket4.field_78804_l.add(new ModelBox(this.eyesocket4, 0, 7, -2.0f, -3.5f, 0.5f, 4, 4, 2, 0.0f, false));
        this.eye3 = new ModelRenderer((ModelBase)this);
        this.eye3.func_78793_a(-6.5f, 16.0f, -3.0f);
        this.eye3.field_78804_l.add(new ModelBox(this.eye3, 0, 0, -1.5f, -3.0f, 0.0f, 3, 3, 1, 0.0f, false));
        this.eye4 = new ModelRenderer((ModelBase)this);
        this.eye4.func_78793_a(6.5f, 16.0f, -3.0f);
        this.eye4.field_78804_l.add(new ModelBox(this.eye4, 0, 0, -1.5f, -3.0f, 0.0f, 3, 3, 1, 0.0f, false));
        this.wingl1 = new ModelRenderer((ModelBase)this);
        this.wingl1.func_78793_a(4.5f, 15.0f, 5.0f);
        this.wingl1.field_78804_l.add(new ModelBox(this.wingl1, 51, 0, 0.0f, 0.0f, -5.0f, 12, 1, 16, 0.0f, false));
        this.wingl2 = new ModelRenderer((ModelBase)this);
        this.wingl2.func_78793_a(4.5f, 12.0f, 5.0f);
        this.wingl2.field_78804_l.add(new ModelBox(this.wingl2, 51, 20, 0.0f, 0.0f, -5.0f, 9, 1, 16, 0.0f, false));
        this.wingl3 = new ModelRenderer((ModelBase)this);
        this.wingl3.func_78793_a(4.5f, 9.0f, 5.0f);
        this.wingl3.field_78804_l.add(new ModelBox(this.wingl3, 52, 39, 0.0f, 0.0f, -5.0f, 6, 1, 16, 0.0f, false));
        this.wingr3 = new ModelRenderer((ModelBase)this);
        this.wingr3.func_78793_a(-4.5f, 9.0f, 5.0f);
        this.wingr3.field_78804_l.add(new ModelBox(this.wingr3, 52, 39, -6.0f, 0.0f, -5.0f, 6, 1, 16, 0.0f, true));
        this.wingr2 = new ModelRenderer((ModelBase)this);
        this.wingr2.func_78793_a(-4.5f, 12.0f, 5.0f);
        this.wingr2.field_78804_l.add(new ModelBox(this.wingr2, 51, 20, -9.0f, 0.0f, -5.0f, 9, 1, 16, 0.0f, true));
        this.wingr1 = new ModelRenderer((ModelBase)this);
        this.wingr1.func_78793_a(-4.5f, 15.0f, 5.0f);
        this.wingr1.field_78804_l.add(new ModelBox(this.wingr1, 51, 0, -12.0f, 0.0f, -5.0f, 12, 1, 16, 0.0f, true));
        this.body3 = new ModelRenderer((ModelBase)this);
        this.body3.func_78793_a(0.0f, 12.0f, -3.0f);
        this.body3.field_78804_l.add(new ModelBox(this.body3, 45, 1, -3.0f, -3.0f, 26.0f, 6, 8, 4, 0.0f, false));
        this.body2 = new ModelRenderer((ModelBase)this);
        this.body2.func_78793_a(0.0f, 12.0f, -3.0f);
        this.body2.field_78804_l.add(new ModelBox(this.body2, 0, 46, -4.0f, -4.0f, 20.0f, 8, 9, 6, 0.0f, false));
        this.body2.field_78804_l.add(new ModelBox(this.body2, 0, 46, 2.0f, -8.0f, 22.0f, 1, 4, 1, 0.0f, false));
        this.body2.field_78804_l.add(new ModelBox(this.body2, 45, 41, 2.0f, -9.0f, 15.0f, 1, 1, 8, 0.0f, false));
        this.body2.field_78804_l.add(new ModelBox(this.body2, 45, 41, -3.0f, -9.0f, 15.0f, 1, 1, 8, 0.0f, false));
        this.body2.field_78804_l.add(new ModelBox(this.body2, 107, 20, -6.0f, -5.0f, 14.0f, 1, 1, 6, 0.0f, false));
        this.body2.field_78804_l.add(new ModelBox(this.body2, 103, 35, -7.0f, -6.0f, 20.0f, 3, 3, 1, 0.0f, false));
        this.body2.field_78804_l.add(new ModelBox(this.body2, 103, 35, 4.0f, -6.0f, 20.0f, 3, 3, 1, 0.0f, false));
        this.body2.field_78804_l.add(new ModelBox(this.body2, 107, 20, 5.0f, -5.0f, 14.0f, 1, 1, 6, 0.0f, false));
        this.body2.field_78804_l.add(new ModelBox(this.body2, 0, 46, -3.0f, -8.0f, 22.0f, 1, 4, 1, 0.0f, false));
        this.body2.field_78804_l.add(new ModelBox(this.body2, 0, 46, -3.0f, -11.0f, 15.0f, 1, 4, 1, 0.1f, false));
        this.body2.field_78804_l.add(new ModelBox(this.body2, 0, 46, 2.0f, -11.0f, 15.0f, 1, 4, 1, 0.1f, false));
        this.body2.field_78804_l.add(new ModelBox(this.body2, 92, 3, -4.0f, -4.0f, 21.0f, 8, 9, 3, 0.2f, false));
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.mouth.func_78785_a(f5);
        this.body.func_78785_a(f5);
        this.eyesocket1.func_78785_a(f5);
        this.eye1.func_78785_a(f5);
        this.eye2.func_78785_a(f5);
        this.eyesocket2.func_78785_a(f5);
        this.eyesocket3.func_78785_a(f5);
        this.eyesocket4.func_78785_a(f5);
        this.eye3.func_78785_a(f5);
        this.eye4.func_78785_a(f5);
        this.wingl1.func_78785_a(f5);
        this.wingl2.func_78785_a(f5);
        this.wingl3.func_78785_a(f5);
        this.wingr3.func_78785_a(f5);
        this.wingr2.func_78785_a(f5);
        this.wingr1.func_78785_a(f5);
        this.body3.func_78785_a(f5);
        this.body2.func_78785_a(f5);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
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

