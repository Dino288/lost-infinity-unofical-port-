/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelPlayer
 *  net.minecraft.client.model.ModelRenderer
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.InteractionHandSide
 */
package xol.lostinfinity.mob.model;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.InteractionHandSide;
import xol.lostinfinity.mob.entity.misc.EntityMultiverseGhost;

public class ModelMultiverseGhost
extends ModelPlayer {
    public ModelMultiverseGhost() {
        super(0.0f, true);
    }

    public void func_78088_a(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        GlStateManager.func_179147_l();
        GlStateManager.func_179112_b((int)770, (int)771);
        GlStateManager.func_179131_c((float)0.75f, (float)0.75f, (float)0.75f, (float)0.75f);
        super.func_78088_a(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
        GlStateManager.func_179084_k();
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        super.func_78087_a(0.0f, 0.0f, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
        EntityMultiverseGhost ghost = (EntityMultiverseGhost)entityIn;
        ghost.getPose().applyPose(this);
    }

    public void func_187073_a(float scale, InteractionHandSide side) {
        super.func_187073_a(scale, side);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }
}

