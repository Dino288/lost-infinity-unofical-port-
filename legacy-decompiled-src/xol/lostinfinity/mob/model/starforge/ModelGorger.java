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
package xol.lostinfinity.mob.model.starforge;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;

public class ModelGorger
extends ModelBase {
    private final ModelRenderer Body;
    private final ModelRenderer MouthL;
    private final ModelRenderer MouthR;
    private final ModelRenderer LeafL;
    private final ModelRenderer LeafR;

    public ModelGorger() {
        this.field_78090_t = 128;
        this.field_78089_u = 128;
        this.Body = new ModelRenderer((ModelBase)this);
        this.Body.func_78793_a(0.0f, 1.0f, 0.0f);
        this.Body.field_78804_l.add(new ModelBox(this.Body, 0, 0, -12.0f, 4.0f, -12.0f, 24, 8, 24, 0.0f, false));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 48, 61, -10.0f, 2.0f, -10.0f, 20, 2, 20, 0.0f, false));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 0, 72, -8.0f, -2.0f, -8.0f, 16, 4, 16, 0.0f, false));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 100, 34, -3.0f, -12.0f, -3.0f, 6, 10, 6, 0.0f, false));
        this.MouthL = new ModelRenderer((ModelBase)this);
        this.MouthL.func_78793_a(6.0f, 10.0f, 0.0f);
        this.MouthL.field_78804_l.add(new ModelBox(this.MouthL, 4, 33, 4.0f, -1.0f, -12.0f, 2, 14, 24, -0.1f, false));
        this.MouthL.field_78804_l.add(new ModelBox(this.MouthL, 0, 40, -6.0f, -1.0f, -12.0f, 11, 14, 2, -0.15f, false));
        this.MouthL.field_78804_l.add(new ModelBox(this.MouthL, 61, 36, -3.0f, 11.0f, -10.5f, 8, 2, 21, -0.2f, false));
        this.MouthL.field_78804_l.add(new ModelBox(this.MouthL, 99, 52, -6.0f, 8.0f, -9.5f, 11, 2, 2, 0.0f, false));
        this.MouthL.field_78804_l.add(new ModelBox(this.MouthL, 99, 52, -6.0f, 8.0f, -5.5f, 11, 2, 2, 0.0f, false));
        this.MouthL.field_78804_l.add(new ModelBox(this.MouthL, 99, 52, -6.0f, 8.0f, 7.5f, 11, 2, 2, 0.0f, false));
        this.MouthL.field_78804_l.add(new ModelBox(this.MouthL, 99, 52, -6.0f, 8.0f, 3.5f, 11, 2, 2, 0.0f, false));
        this.MouthL.field_78804_l.add(new ModelBox(this.MouthL, 99, 52, -6.0f, 8.0f, 0.5f, 11, 2, 2, 0.0f, false));
        this.MouthL.field_78804_l.add(new ModelBox(this.MouthL, 99, 52, -6.0f, 8.0f, -2.5f, 11, 2, 2, 0.0f, false));
        this.MouthL.field_78804_l.add(new ModelBox(this.MouthL, 38, 40, -6.0f, -1.0f, 10.0f, 11, 14, 2, -0.15f, false));
        this.MouthR = new ModelRenderer((ModelBase)this);
        this.MouthR.func_78793_a(-6.0f, 10.0f, 0.0f);
        this.MouthR.field_78804_l.add(new ModelBox(this.MouthR, 4, 33, -6.0f, -1.0f, -12.0f, 2, 14, 24, -0.1f, true));
        this.MouthR.field_78804_l.add(new ModelBox(this.MouthR, 0, 40, -5.0f, -1.0f, -12.0f, 11, 14, 2, -0.15f, true));
        this.MouthR.field_78804_l.add(new ModelBox(this.MouthR, 61, 36, -5.0f, 11.0f, -10.5f, 8, 2, 21, -0.2f, true));
        this.MouthR.field_78804_l.add(new ModelBox(this.MouthR, 99, 52, -5.0f, 8.0f, -9.5f, 11, 2, 2, 0.0f, true));
        this.MouthR.field_78804_l.add(new ModelBox(this.MouthR, 99, 52, -5.0f, 8.0f, -5.5f, 11, 2, 2, 0.0f, true));
        this.MouthR.field_78804_l.add(new ModelBox(this.MouthR, 99, 52, -5.0f, 8.0f, 7.5f, 11, 2, 2, 0.0f, true));
        this.MouthR.field_78804_l.add(new ModelBox(this.MouthR, 99, 52, -5.0f, 8.0f, 3.5f, 11, 2, 2, 0.0f, true));
        this.MouthR.field_78804_l.add(new ModelBox(this.MouthR, 99, 52, -5.0f, 8.0f, 0.5f, 11, 2, 2, 0.0f, true));
        this.MouthR.field_78804_l.add(new ModelBox(this.MouthR, 99, 52, -5.0f, 8.0f, -2.5f, 11, 2, 2, 0.0f, true));
        this.MouthR.field_78804_l.add(new ModelBox(this.MouthR, 38, 40, -5.0f, -1.0f, 10.0f, 11, 14, 2, -0.15f, true));
        this.LeafL = new ModelRenderer((ModelBase)this);
        this.LeafL.func_78793_a(1.0f, -9.5f, 0.0f);
        this.LeafL.field_78804_l.add(new ModelBox(this.LeafL, 52, 85, -1.0f, -0.5f, -7.0f, 24, 1, 14, 0.0f, false));
        this.LeafR = new ModelRenderer((ModelBase)this);
        this.LeafR.func_78793_a(-1.0f, -9.5f, 0.0f);
        this.LeafR.field_78804_l.add(new ModelBox(this.LeafR, 52, 85, -23.0f, -0.5f, -7.0f, 24, 1, 14, 0.0f, true));
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.Body.func_78785_a(f5);
        this.MouthL.func_78785_a(f5);
        this.MouthR.func_78785_a(f5);
        this.LeafL.func_78785_a(f5);
        this.LeafR.func_78785_a(f5);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.MouthL.field_78808_h = -0.35f + 0.35f * Mth.func_76126_a((float)(ageInTicks * 0.1f));
        this.MouthR.field_78808_h = -this.MouthL.field_78808_h;
        this.LeafL.field_78808_h = 0.5f * Mth.func_76126_a((float)(ageInTicks * 0.2f));
        this.LeafR.field_78808_h = -this.LeafL.field_78808_h;
    }
}

