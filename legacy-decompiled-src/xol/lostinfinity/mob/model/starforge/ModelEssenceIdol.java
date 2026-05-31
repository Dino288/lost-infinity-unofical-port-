/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.model.ModelBox
 *  net.minecraft.client.model.ModelRenderer
 *  net.minecraft.entity.Entity
 */
package xol.lostinfinity.mob.model.starforge;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.world.entity.Entity;

public class ModelEssenceIdol
extends ModelBase {
    private final ModelRenderer bottom;
    private final ModelRenderer top;
    private final ModelRenderer cube_r1;
    private final ModelRenderer cube_r2;
    private final ModelRenderer bb_main;

    public ModelEssenceIdol() {
        this.field_78090_t = 64;
        this.field_78089_u = 32;
        this.bottom = new ModelRenderer((ModelBase)this);
        this.bottom.func_78793_a(0.0f, 24.0f, 0.0f);
        this.bottom.field_78804_l.add(new ModelBox(this.bottom, 16, 0, -8.0f, -7.0f, -2.0f, 4, 8, 4, -0.5f, false));
        this.bottom.field_78804_l.add(new ModelBox(this.bottom, 0, 24, -6.0f, -7.0f, -2.0f, 12, 4, 4, -1.0f, false));
        this.bottom.field_78804_l.add(new ModelBox(this.bottom, 32, 16, -2.0f, -7.0f, -6.0f, 4, 4, 12, -1.0f, false));
        this.bottom.field_78804_l.add(new ModelBox(this.bottom, 16, 0, 4.0f, -7.0f, -2.0f, 4, 8, 4, -0.5f, false));
        this.bottom.field_78804_l.add(new ModelBox(this.bottom, 16, 0, -2.0f, -7.0f, 4.0f, 4, 8, 4, -0.5f, false));
        this.bottom.field_78804_l.add(new ModelBox(this.bottom, 16, 0, -2.0f, -7.0f, -8.0f, 4, 8, 4, -0.5f, false));
        this.top = new ModelRenderer((ModelBase)this);
        this.top.func_78793_a(0.0f, 1.0f, 0.0f);
        this.top.field_78804_l.add(new ModelBox(this.top, 16, 12, -2.0f, -2.0f, -9.0f, 4, 6, 4, -0.2f, false));
        this.top.field_78804_l.add(new ModelBox(this.top, 34, 13, -1.5f, -4.5f, -8.5f, 1, 3, 1, -0.2f, false));
        this.top.field_78804_l.add(new ModelBox(this.top, 34, 13, 0.5f, -4.5f, -8.5f, 1, 3, 1, -0.2f, false));
        this.cube_r1 = new ModelRenderer((ModelBase)this);
        this.cube_r1.func_78793_a(0.0f, 1.0f, -7.0f);
        this.top.func_78792_a(this.cube_r1);
        this.setRotationAngle(this.cube_r1, 1.1345f, 0.0f, 0.0f);
        this.cube_r1.field_78804_l.add(new ModelBox(this.cube_r1, 28, 18, -2.0f, 4.0f, -6.0f, 4, 6, 4, -0.6f, false));
        this.cube_r2 = new ModelRenderer((ModelBase)this);
        this.cube_r2.func_78793_a(0.0f, 1.0f, -7.0f);
        this.top.func_78792_a(this.cube_r2);
        this.setRotationAngle(this.cube_r2, 0.6109f, 0.0f, 0.0f);
        this.cube_r2.field_78804_l.add(new ModelBox(this.cube_r2, 28, 18, -2.0f, 1.0f, -3.0f, 4, 6, 4, -0.4f, false));
        this.bb_main = new ModelRenderer((ModelBase)this);
        this.bb_main.func_78793_a(0.0f, 24.0f, 0.0f);
        this.bb_main.field_78804_l.add(new ModelBox(this.bb_main, 0, 0, -2.0f, -19.0f, -2.0f, 4, 16, 4, 0.0f, false));
        this.bb_main.field_78804_l.add(new ModelBox(this.bb_main, 33, 0, -3.0f, -26.0f, -3.0f, 6, 6, 6, 0.0f, false));
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.bottom.func_78785_a(f5);
        this.top.func_78785_a(f5);
        this.bb_main.func_78785_a(f5);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.bottom.field_78796_g = ageInTicks * 0.1f;
        this.top.field_78796_g = ageInTicks * -0.2f;
    }
}

