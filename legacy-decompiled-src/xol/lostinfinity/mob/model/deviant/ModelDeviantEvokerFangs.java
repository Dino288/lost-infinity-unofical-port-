/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.model.ModelRenderer
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.math.Mth
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.mob.model.deviant;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(value=Side.CLIENT)
public class ModelDeviantEvokerFangs
extends ModelBase {
    private final ModelRenderer base = new ModelRenderer((ModelBase)this, 0, 0);
    private final ModelRenderer upperJaw;
    private final ModelRenderer lowerJaw;

    public ModelDeviantEvokerFangs() {
        this.base.func_78793_a(-5.0f, 22.0f, -5.0f);
        this.base.func_78789_a(0.0f, 0.0f, 0.0f, 10, 12, 10);
        this.upperJaw = new ModelRenderer((ModelBase)this, 40, 0);
        this.upperJaw.func_78793_a(1.5f, 22.0f, -4.0f);
        this.upperJaw.func_78789_a(0.0f, 0.0f, 0.0f, 4, 14, 8);
        this.lowerJaw = new ModelRenderer((ModelBase)this, 40, 0);
        this.lowerJaw.func_78793_a(-1.5f, 22.0f, 4.0f);
        this.lowerJaw.func_78789_a(0.0f, 0.0f, 0.0f, 4, 14, 8);
    }

    public void func_78088_a(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        float f = limbSwing * 2.0f;
        if (f > 1.0f) {
            f = 1.0f;
        }
        f = 1.0f - f * f * f;
        this.upperJaw.field_78808_h = (float)Math.PI - f * 0.35f * (float)Math.PI;
        this.lowerJaw.field_78808_h = (float)Math.PI + f * 0.35f * (float)Math.PI;
        this.lowerJaw.field_78796_g = (float)Math.PI;
        float f1 = (limbSwing + Mth.func_76126_a((float)(limbSwing * 2.7f))) * 0.6f * 12.0f;
        this.lowerJaw.field_78797_d = this.upperJaw.field_78797_d = 24.0f - f1;
        this.base.field_78797_d = this.upperJaw.field_78797_d;
        this.base.func_78785_a(scale);
        this.upperJaw.func_78785_a(scale);
        this.lowerJaw.func_78785_a(scale);
    }
}

