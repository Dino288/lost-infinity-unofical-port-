/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.model.ModelBox
 *  net.minecraft.client.model.ModelRenderer
 *  net.minecraft.entity.Entity
 */
package xol.lostinfinity.mob.model.boss;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.world.entity.Entity;

public class ModelWitherSkullling
extends ModelBase {
    private final ModelRenderer Body;
    private final ModelRenderer BackConnector_r1;
    private final ModelRenderer bb_main;

    public ModelWitherSkullling() {
        this.field_78090_t = 32;
        this.field_78089_u = 32;
        this.Body = new ModelRenderer((ModelBase)this);
        this.Body.func_78793_a(0.0f, 5.0f, 0.0f);
        this.BackConnector_r1 = new ModelRenderer((ModelBase)this);
        this.BackConnector_r1.func_78793_a(0.0f, 0.0f, 0.0f);
        this.Body.func_78792_a(this.BackConnector_r1);
        this.setRotationAngle(this.BackConnector_r1, 0.6109f, 0.0f, 0.0f);
        this.BackConnector_r1.field_78804_l.add(new ModelBox(this.BackConnector_r1, 0, 16, 1.5f, -1.0f, -0.5f, 6, 12, 1, 0.0f, true));
        this.BackConnector_r1.field_78804_l.add(new ModelBox(this.BackConnector_r1, 0, 16, -7.5f, -1.0f, -0.5f, 6, 12, 1, 0.0f, false));
        this.BackConnector_r1.field_78804_l.add(new ModelBox(this.BackConnector_r1, 17, 16, -1.5f, -1.0f, -1.5f, 3, 12, 3, 0.0f, false));
        this.bb_main = new ModelRenderer((ModelBase)this);
        this.bb_main.func_78793_a(0.0f, 24.0f, 0.0f);
        this.bb_main.field_78804_l.add(new ModelBox(this.bb_main, 0, 0, -4.0f, -27.0f, -4.0f, 8, 8, 8, 0.0f, false));
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.Body.func_78785_a(f5);
        this.bb_main.func_78785_a(f5);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.Body.field_78795_f = (float)((double)0.1f + (double)0.2f * Math.sin(ageInTicks * 0.2f));
    }
}

