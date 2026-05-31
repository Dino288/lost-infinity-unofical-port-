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

public class ModelDeviantSquid
extends ModelBase {
    private final ModelRenderer body;
    private final ModelRenderer tentacle1;
    private final ModelRenderer tentacle2;
    private final ModelRenderer tentacle3;
    private final ModelRenderer tentacle4;
    private final ModelRenderer tentacle5;
    private final ModelRenderer tentacle6;
    private final ModelRenderer tentacle7;
    private final ModelRenderer tentacle8;

    public ModelDeviantSquid() {
        this.field_78090_t = 64;
        this.field_78089_u = 64;
        this.body = new ModelRenderer((ModelBase)this);
        this.body.func_78793_a(0.0f, -1.0f, 0.0f);
        this.body.field_78804_l.add(new ModelBox(this.body, 0, 0, -6.0f, -8.0f, -6.0f, 12, 16, 12, 0.0f, false));
        this.body.field_78804_l.add(new ModelBox(this.body, 0, 31, 4.0f, -13.0f, -8.0f, 1, 15, 18, 0.0f, false));
        this.body.field_78804_l.add(new ModelBox(this.body, 0, 31, -5.0f, -13.0f, -8.0f, 1, 15, 18, 0.0f, true));
        this.tentacle1 = new ModelRenderer((ModelBase)this);
        this.tentacle1.func_78793_a(5.0f, 6.0f, 0.0f);
        this.setRotationAngle(this.tentacle1, 0.0f, 1.5708f, 0.0f);
        this.tentacle1.field_78804_l.add(new ModelBox(this.tentacle1, 48, 0, -1.0f, 0.0f, -1.0f, 2, 18, 2, 0.0f, false));
        this.tentacle1.field_78804_l.add(new ModelBox(this.tentacle1, 39, 39, 0.0f, 0.0f, 1.0f, 1, 18, 7, 0.0f, false));
        this.tentacle2 = new ModelRenderer((ModelBase)this);
        this.tentacle2.func_78793_a(3.5f, 6.0f, 3.5f);
        this.setRotationAngle(this.tentacle2, 0.0f, 0.7854f, 0.0f);
        this.tentacle2.field_78804_l.add(new ModelBox(this.tentacle2, 48, 0, -1.0f, 0.0f, -1.0f, 2, 18, 2, 0.0f, false));
        this.tentacle2.field_78804_l.add(new ModelBox(this.tentacle2, 48, 21, 0.0f, 0.0f, 1.0f, 1, 18, 7, 0.0f, false));
        this.tentacle3 = new ModelRenderer((ModelBase)this);
        this.tentacle3.func_78793_a(0.0f, 6.0f, 5.0f);
        this.tentacle3.field_78804_l.add(new ModelBox(this.tentacle3, 48, 0, -1.0f, 0.0f, -1.0f, 2, 18, 2, 0.0f, false));
        this.tentacle3.field_78804_l.add(new ModelBox(this.tentacle3, 39, 39, 0.0f, 0.0f, 1.0f, 1, 18, 7, 0.0f, false));
        this.tentacle4 = new ModelRenderer((ModelBase)this);
        this.tentacle4.func_78793_a(-3.5f, 6.0f, 3.5f);
        this.setRotationAngle(this.tentacle4, 0.0f, -0.7854f, 0.0f);
        this.tentacle4.field_78804_l.add(new ModelBox(this.tentacle4, 48, 0, -1.0f, 0.0f, -1.0f, 2, 18, 2, 0.0f, false));
        this.tentacle4.field_78804_l.add(new ModelBox(this.tentacle4, 48, 21, 0.0f, 0.0f, 1.0f, 1, 18, 7, 0.0f, false));
        this.tentacle5 = new ModelRenderer((ModelBase)this);
        this.tentacle5.func_78793_a(-5.0f, 6.0f, 0.0f);
        this.setRotationAngle(this.tentacle5, 0.0f, -1.5708f, 0.0f);
        this.tentacle5.field_78804_l.add(new ModelBox(this.tentacle5, 48, 0, -1.0f, 0.0f, -1.0f, 2, 18, 2, 0.0f, false));
        this.tentacle5.field_78804_l.add(new ModelBox(this.tentacle5, 39, 39, 0.0f, 0.0f, 1.0f, 1, 18, 7, 0.0f, false));
        this.tentacle6 = new ModelRenderer((ModelBase)this);
        this.tentacle6.func_78793_a(-3.5f, 6.0f, -3.5f);
        this.setRotationAngle(this.tentacle6, 0.0f, -2.3562f, 0.0f);
        this.tentacle6.field_78804_l.add(new ModelBox(this.tentacle6, 48, 0, -1.0f, 0.0f, -1.0f, 2, 18, 2, 0.0f, false));
        this.tentacle6.field_78804_l.add(new ModelBox(this.tentacle6, 48, 21, 0.0f, 0.0f, 1.0f, 1, 18, 7, 0.0f, false));
        this.tentacle7 = new ModelRenderer((ModelBase)this);
        this.tentacle7.func_78793_a(0.0f, 6.0f, -5.0f);
        this.setRotationAngle(this.tentacle7, 0.0f, -3.1416f, 0.0f);
        this.tentacle7.field_78804_l.add(new ModelBox(this.tentacle7, 48, 0, -1.0f, 0.0f, -1.0f, 2, 18, 2, 0.0f, false));
        this.tentacle7.field_78804_l.add(new ModelBox(this.tentacle7, 39, 39, 0.0f, 0.0f, 1.0f, 1, 18, 7, 0.0f, false));
        this.tentacle8 = new ModelRenderer((ModelBase)this);
        this.tentacle8.func_78793_a(3.5f, 6.0f, -3.5f);
        this.setRotationAngle(this.tentacle8, 0.0f, -3.927f, 0.0f);
        this.tentacle8.field_78804_l.add(new ModelBox(this.tentacle8, 48, 0, -1.0f, 0.0f, -1.0f, 2, 18, 2, 0.0f, false));
        this.tentacle8.field_78804_l.add(new ModelBox(this.tentacle8, 48, 21, 0.0f, 0.0f, 1.0f, 1, 18, 7, 0.0f, false));
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.body.func_78785_a(f5);
        this.tentacle1.func_78785_a(f5);
        this.tentacle2.func_78785_a(f5);
        this.tentacle3.func_78785_a(f5);
        this.tentacle4.func_78785_a(f5);
        this.tentacle5.func_78785_a(f5);
        this.tentacle6.func_78785_a(f5);
        this.tentacle7.func_78785_a(f5);
        this.tentacle8.func_78785_a(f5);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.tentacle2.field_78795_f = this.tentacle1.field_78795_f = 0.7f + 0.7f * Mth.func_76126_a((float)(ageInTicks * 0.1f));
        this.tentacle3.field_78795_f = this.tentacle1.field_78795_f;
        this.tentacle4.field_78795_f = this.tentacle1.field_78795_f;
        this.tentacle5.field_78795_f = this.tentacle1.field_78795_f;
        this.tentacle6.field_78795_f = this.tentacle1.field_78795_f;
        this.tentacle7.field_78795_f = this.tentacle1.field_78795_f;
        this.tentacle8.field_78795_f = this.tentacle1.field_78795_f;
    }
}

