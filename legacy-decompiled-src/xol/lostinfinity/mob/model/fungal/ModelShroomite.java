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
import xol.lostinfinity.mob.entity.fungal.EntityShroomite;

public class ModelShroomite
extends ModelBase {
    private final ModelRenderer Body_1;
    private final ModelRenderer Leg_Left_1;
    private final ModelRenderer Leg_Right_1;
    private final ModelRenderer Cap_1;

    public ModelShroomite() {
        this.field_78090_t = 64;
        this.field_78089_u = 32;
        this.Body_1 = new ModelRenderer((ModelBase)this);
        this.Body_1.func_78793_a(0.0f, 14.0f, 0.0f);
        this.Body_1.field_78804_l.add(new ModelBox(this.Body_1, 0, 18, -3.0f, -1.0f, -3.0f, 6, 6, 6, 0.0f, false));
        this.Leg_Left_1 = new ModelRenderer((ModelBase)this);
        this.Leg_Left_1.func_78793_a(-1.75f, 4.0f, 0.0f);
        this.Body_1.func_78792_a(this.Leg_Left_1);
        this.Leg_Left_1.field_78804_l.add(new ModelBox(this.Leg_Left_1, 26, 22, -1.25f, 1.0f, -1.5f, 3, 5, 3, 0.0f, false));
        this.Leg_Right_1 = new ModelRenderer((ModelBase)this);
        this.Leg_Right_1.func_78793_a(1.75f, 4.0f, 0.0f);
        this.Body_1.func_78792_a(this.Leg_Right_1);
        this.Leg_Right_1.field_78804_l.add(new ModelBox(this.Leg_Right_1, 26, 22, -1.75f, 1.0f, -1.5f, 3, 5, 3, 0.0f, true));
        this.Cap_1 = new ModelRenderer((ModelBase)this);
        this.Cap_1.func_78793_a(0.0f, -6.0f, 0.0f);
        this.Body_1.func_78792_a(this.Cap_1);
        this.Cap_1.field_78804_l.add(new ModelBox(this.Cap_1, 0, 0, -6.0f, 0.0f, -6.0f, 12, 5, 12, 0.0f, false));
        this.Cap_1.field_78804_l.add(new ModelBox(this.Cap_1, 36, 23, -3.5f, 5.0f, -3.5f, 7, 2, 7, 0.0f, false));
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.Body_1.func_78785_a(f5);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        super.func_78087_a(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
        this.Leg_Left_1.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f)) * 0.8f * limbSwingAmount;
        this.Leg_Right_1.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f + (float)Math.PI)) * 0.8f * limbSwingAmount;
        this.Body_1.func_78793_a(0.0f, 14.0f, 0.0f);
        EntityShroomite shroomite = (EntityShroomite)entityIn;
        if (shroomite.isBurrowed()) {
            this.Body_1.func_78793_a(0.0f, 12.5f, 0.0f);
        }
    }
}

