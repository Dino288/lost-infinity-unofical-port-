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
package xol.lostinfinity.mob.model.sea;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;

public class ModelRibshark
extends ModelBase {
    private final ModelRenderer Body;
    private final ModelRenderer cube_r1;
    private final ModelRenderer MiddleBody;
    private final ModelRenderer cube_r2;
    private final ModelRenderer cube_r3;
    private final ModelRenderer FinL;
    private final ModelRenderer FinL2;
    private final ModelRenderer TailEnd;
    private final ModelRenderer cube_r4;
    private final ModelRenderer cube_r5;

    public ModelRibshark() {
        this.field_78090_t = 64;
        this.field_78089_u = 64;
        this.Body = new ModelRenderer((ModelBase)this);
        this.Body.func_78793_a(2.0f, 24.0f, 9.0f);
        this.Body.field_78804_l.add(new ModelBox(this.Body, 39, 37, -4.25f, -4.0f, -18.25f, 5, 3, 4, 0.0f, true));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 7, 10, -5.25f, -8.0f, -14.25f, 7, 7, 5, 0.0f, false));
        this.cube_r1 = new ModelRenderer((ModelBase)this);
        this.cube_r1.func_78793_a(-1.8f, -5.25f, -16.725f);
        this.Body.func_78792_a(this.cube_r1);
        this.setRotationAngle(this.cube_r1, 0.1745f, 0.0f, 0.0f);
        this.cube_r1.field_78804_l.add(new ModelBox(this.cube_r1, 0, 31, -3.0f, -2.5f, -3.0f, 6, 5, 6, 0.0f, false));
        this.MiddleBody = new ModelRenderer((ModelBase)this);
        this.MiddleBody.func_78793_a(-2.0f, -4.5f, -3.5f);
        this.Body.func_78792_a(this.MiddleBody);
        this.MiddleBody.field_78804_l.add(new ModelBox(this.MiddleBody, 11, 1, -2.25f, -2.5f, 5.25f, 5, 4, 4, 0.0f, true));
        this.MiddleBody.field_78804_l.add(new ModelBox(this.MiddleBody, 56, 1, -4.25f, -4.0f, 3.25f, 2, 8, 2, 0.0f, false));
        this.MiddleBody.field_78804_l.add(new ModelBox(this.MiddleBody, 26, 0, -2.25f, -4.0f, -6.75f, 4, 2, 12, 0.0f, false));
        this.MiddleBody.field_78804_l.add(new ModelBox(this.MiddleBody, 26, 0, -2.3f, 2.0f, 3.25f, 4, 2, 2, 0.0f, true));
        this.MiddleBody.field_78804_l.add(new ModelBox(this.MiddleBody, 56, 1, -4.25f, -4.0f, 0.25f, 2, 8, 2, 0.0f, true));
        this.MiddleBody.field_78804_l.add(new ModelBox(this.MiddleBody, 26, 0, -2.3f, 2.0f, 0.25f, 4, 2, 2, 0.0f, true));
        this.MiddleBody.field_78804_l.add(new ModelBox(this.MiddleBody, 56, 1, -4.25f, -4.0f, -2.75f, 2, 8, 2, 0.0f, false));
        this.MiddleBody.field_78804_l.add(new ModelBox(this.MiddleBody, 26, 0, -2.3f, 2.0f, -2.75f, 4, 2, 2, 0.0f, true));
        this.MiddleBody.field_78804_l.add(new ModelBox(this.MiddleBody, 56, 1, -4.25f, -4.0f, -5.75f, 2, 8, 2, 0.0f, true));
        this.MiddleBody.field_78804_l.add(new ModelBox(this.MiddleBody, 56, 1, 2.25f, -4.0f, -5.75f, 2, 8, 2, 0.0f, false));
        this.MiddleBody.field_78804_l.add(new ModelBox(this.MiddleBody, 56, 1, 2.25f, -4.0f, -2.75f, 2, 8, 2, 0.0f, true));
        this.MiddleBody.field_78804_l.add(new ModelBox(this.MiddleBody, 56, 1, 2.25f, -4.0f, 0.25f, 2, 8, 2, 0.0f, false));
        this.MiddleBody.field_78804_l.add(new ModelBox(this.MiddleBody, 56, 1, 2.25f, -4.0f, 3.25f, 2, 8, 2, 0.0f, true));
        this.MiddleBody.field_78804_l.add(new ModelBox(this.MiddleBody, 26, 0, -2.3f, 2.0f, -5.75f, 4, 2, 2, 0.0f, true));
        this.cube_r2 = new ModelRenderer((ModelBase)this);
        this.cube_r2.func_78793_a(-0.25f, -4.8558f, -0.2031f);
        this.MiddleBody.func_78792_a(this.cube_r2);
        this.setRotationAngle(this.cube_r2, -0.2618f, 0.0f, 0.0f);
        this.cube_r2.field_78804_l.add(new ModelBox(this.cube_r2, 0, 1, -0.5f, -4.5f, -2.0f, 1, 9, 4, -0.1f, true));
        this.cube_r3 = new ModelRenderer((ModelBase)this);
        this.cube_r3.func_78793_a(-0.25f, -6.1627f, 0.912f);
        this.MiddleBody.func_78792_a(this.cube_r3);
        this.setRotationAngle(this.cube_r3, -0.6109f, 0.0f, 0.0f);
        this.cube_r3.field_78804_l.add(new ModelBox(this.cube_r3, 54, 27, -0.5f, -3.5f, -4.0f, 1, 9, 4, 0.0f, false));
        this.FinL = new ModelRenderer((ModelBase)this);
        this.FinL.func_78793_a(4.5f, 2.0f, -0.5f);
        this.MiddleBody.func_78792_a(this.FinL);
        this.setRotationAngle(this.FinL, 0.3491f, -1.5708f, 0.0f);
        this.FinL.field_78804_l.add(new ModelBox(this.FinL, 20, 28, -2.5f, -0.5f, -5.0f, 5, 1, 6, 0.0f, true));
        this.FinL2 = new ModelRenderer((ModelBase)this);
        this.FinL2.func_78793_a(-4.5f, 2.0f, -0.5f);
        this.MiddleBody.func_78792_a(this.FinL2);
        this.setRotationAngle(this.FinL2, 0.3491f, 1.5708f, 0.0f);
        this.FinL2.field_78804_l.add(new ModelBox(this.FinL2, 20, 28, -2.5f, -0.5f, -5.0f, 5, 1, 6, 0.0f, false));
        this.TailEnd = new ModelRenderer((ModelBase)this);
        this.TailEnd.func_78793_a(-0.75f, 0.0f, 8.75f);
        this.MiddleBody.func_78792_a(this.TailEnd);
        this.TailEnd.field_78804_l.add(new ModelBox(this.TailEnd, 46, 19, -1.25f, -2.0f, -0.5f, 4, 3, 4, 0.0f, false));
        this.TailEnd.field_78804_l.add(new ModelBox(this.TailEnd, 10, 24, -0.75f, -1.5f, 3.5f, 3, 2, 4, 0.0f, false));
        this.TailEnd.field_78804_l.add(new ModelBox(this.TailEnd, 35, 15, -0.25f, -1.0f, 7.5f, 2, 2, 5, 0.0f, false));
        this.cube_r4 = new ModelRenderer((ModelBase)this);
        this.cube_r4.func_78793_a(1.25f, 2.0f, 14.25f);
        this.TailEnd.func_78792_a(this.cube_r4);
        this.setRotationAngle(this.cube_r4, -0.6981f, 0.0f, 0.0f);
        this.cube_r4.field_78804_l.add(new ModelBox(this.cube_r4, 37, 23, -1.05f, -1.0f, -3.5f, 1, 4, 5, 0.0f, false));
        this.cube_r5 = new ModelRenderer((ModelBase)this);
        this.cube_r5.func_78793_a(1.0f, -0.5f, 12.75f);
        this.TailEnd.func_78792_a(this.cube_r5);
        this.setRotationAngle(this.cube_r5, 0.7854f, 0.0f, 0.0f);
        this.cube_r5.field_78804_l.add(new ModelBox(this.cube_r5, 25, 16, -0.75f, -3.0f, -1.5f, 1, 4, 7, 0.0f, false));
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.Body.func_78785_a(f5);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        float bodySpeed = 0.3f;
        float bodyRange = 0.3f;
        this.MiddleBody.field_78796_g = Mth.func_76134_b((float)(ageInTicks * bodySpeed)) * bodyRange;
        this.TailEnd.field_78796_g = Mth.func_76126_a((float)(ageInTicks * bodySpeed)) * bodyRange;
    }
}

