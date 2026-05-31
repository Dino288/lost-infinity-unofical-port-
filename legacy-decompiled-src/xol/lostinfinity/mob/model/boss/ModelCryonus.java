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
package xol.lostinfinity.mob.model.boss;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;

public class ModelCryonus
extends ModelBase {
    private final ModelRenderer Head;
    private final ModelRenderer Body;
    private final ModelRenderer RightLeg;
    private final ModelRenderer LeftLeg;
    private final ModelRenderer RightArm;
    private final ModelRenderer Wand2;
    private final ModelRenderer LeftArm;

    public ModelCryonus() {
        this.field_78090_t = 64;
        this.field_78089_u = 64;
        this.Head = new ModelRenderer((ModelBase)this);
        this.Head.func_78793_a(0.0f, 0.0f, 0.0f);
        this.Head.field_78804_l.add(new ModelBox(this.Head, 0, 0, -4.0f, -12.0f, -4.0f, 8, 8, 8, 0.0f, false));
        this.Head.field_78804_l.add(new ModelBox(this.Head, 32, 0, -4.0f, -12.0f, -4.0f, 8, 8, 8, 0.2f, false));
        this.Body = new ModelRenderer((ModelBase)this);
        this.Body.func_78793_a(0.0f, 2.5f, 0.0f);
        this.Body.field_78804_l.add(new ModelBox(this.Body, 0, 16, -4.0f, -6.5f, -2.0f, 8, 14, 4, 0.0f, false));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 0, 35, -4.0f, -5.5f, -2.0f, 8, 22, 4, 0.2f, false));
        this.RightLeg = new ModelRenderer((ModelBase)this);
        this.RightLeg.func_78793_a(-1.9f, 9.5f, 0.0f);
        this.Body.func_78792_a(this.RightLeg);
        this.RightLeg.field_78804_l.add(new ModelBox(this.RightLeg, 25, 17, -2.0f, -2.0f, -1.5f, 3, 14, 3, 0.0f, false));
        this.RightLeg.field_78804_l.add(new ModelBox(this.RightLeg, 38, 18, -1.6f, -5.0f, -2.5f, 2, 8, 1, 0.0f, false));
        this.LeftLeg = new ModelRenderer((ModelBase)this);
        this.LeftLeg.func_78793_a(1.9f, 9.5f, 0.0f);
        this.Body.func_78792_a(this.LeftLeg);
        this.LeftLeg.field_78804_l.add(new ModelBox(this.LeftLeg, 25, 17, -1.0f, -2.0f, -1.5f, 3, 14, 3, 0.0f, true));
        this.LeftLeg.field_78804_l.add(new ModelBox(this.LeftLeg, 38, 18, -0.4f, -5.0f, -2.5f, 2, 8, 1, 0.0f, true));
        this.RightArm = new ModelRenderer((ModelBase)this);
        this.RightArm.func_78793_a(-5.0f, -2.0f, 0.0f);
        this.setRotationAngle(this.RightArm, 0.0f, 0.0f, 0.1745f);
        this.RightArm.field_78804_l.add(new ModelBox(this.RightArm, 52, 17, -2.0f, -2.0f, -1.5f, 3, 14, 3, 0.0f, false));
        this.Wand2 = new ModelRenderer((ModelBase)this);
        this.Wand2.func_78793_a(-0.5f, 16.0f, 0.0f);
        this.RightArm.func_78792_a(this.Wand2);
        this.Wand2.field_78804_l.add(new ModelBox(this.Wand2, 60, 35, -0.5f, -3.0f, -0.5f, 1, 1, 1, 0.0f, false));
        this.Wand2.field_78804_l.add(new ModelBox(this.Wand2, 60, 35, -0.5f, 2.0f, -0.5f, 1, 1, 1, 0.0f, false));
        this.Wand2.field_78804_l.add(new ModelBox(this.Wand2, 60, 35, -3.0f, -0.5f, -0.5f, 1, 1, 1, 0.0f, false));
        this.Wand2.field_78804_l.add(new ModelBox(this.Wand2, 60, 35, 2.0f, -0.5f, -0.5f, 1, 1, 1, 0.0f, false));
        this.Wand2.field_78804_l.add(new ModelBox(this.Wand2, 20, 42, -1.0f, -1.0f, -16.5f, 2, 2, 20, 0.0f, false));
        this.Wand2.field_78804_l.add(new ModelBox(this.Wand2, 45, 54, -2.0f, -2.0f, -20.5f, 4, 4, 4, 0.0f, false));
        this.Wand2.field_78804_l.add(new ModelBox(this.Wand2, 56, 41, -1.0f, -5.0f, -19.5f, 2, 10, 2, 0.0f, false));
        this.LeftArm = new ModelRenderer((ModelBase)this);
        this.LeftArm.func_78793_a(5.0f, -2.0f, 0.0f);
        this.setRotationAngle(this.LeftArm, 0.0f, 0.0f, -0.1745f);
        this.LeftArm.field_78804_l.add(new ModelBox(this.LeftArm, 52, 17, -1.0f, -2.0f, -1.5f, 3, 14, 3, 0.0f, true));
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.Head.func_78785_a(f5);
        this.Body.func_78785_a(f5);
        this.RightArm.func_78785_a(f5);
        this.LeftArm.func_78785_a(f5);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.Head.field_78796_g = netHeadYaw * ((float)Math.PI / 180);
        this.Head.field_78795_f = headPitch * ((float)Math.PI / 180);
        this.Body.field_78795_f = 0.35f + 0.1f * Mth.func_76126_a((float)(ageInTicks * 0.1f));
        this.LeftLeg.field_78795_f = 0.35f + 0.2f * Mth.func_76126_a((float)(ageInTicks * 0.3f));
        this.RightLeg.field_78795_f = 0.35f + 0.2f * Mth.func_76134_b((float)(ageInTicks * 0.3f));
        this.RightArm.field_78795_f = 0.3f * Mth.func_76126_a((float)(ageInTicks * 0.05f));
        this.LeftArm.field_78795_f = -0.3f * Mth.func_76126_a((float)(ageInTicks * 0.05f));
        this.Wand2.field_78808_h = ageInTicks * 0.1f;
    }
}

