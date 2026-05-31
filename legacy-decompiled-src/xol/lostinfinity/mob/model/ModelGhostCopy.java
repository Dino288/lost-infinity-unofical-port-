/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelPlayer
 *  net.minecraft.client.model.ModelRenderer
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.entity.Entity
 */
package xol.lostinfinity.mob.model;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.world.entity.Entity;
import xol.lostinfinity.mob.entity.misc.EntityGhostCopy;

public class ModelGhostCopy
extends ModelPlayer {
    public ModelGhostCopy() {
        super(1.0f, true);
    }

    public void func_78088_a(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        EntityGhostCopy ghost = (EntityGhostCopy)entityIn;
        float colors = ghost.getGhostColor();
        GlStateManager.func_179147_l();
        GlStateManager.func_179112_b((int)770, (int)771);
        GlStateManager.func_179131_c((float)colors, (float)colors, (float)colors, (float)ghost.getGhostAlpha());
        super.func_78088_a(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
        GlStateManager.func_179084_k();
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        EntityGhostCopy ghost = (EntityGhostCopy)entityIn;
        float angleModification = ageInTicks * 0.03f;
        this.field_78116_c.field_78795_f = ghost.getGhostAngle(0) * 1.5f + angleModification * (float)ghost.getMoveAdjustment(0);
        this.field_78116_c.field_78796_g = ghost.getGhostAngle(1) * 0.5f + angleModification * (float)ghost.getMoveAdjustment(1);
        this.field_78116_c.field_78808_h = ghost.getGhostAngle(2) * 1.5f + angleModification * (float)ghost.getMoveAdjustment(2);
        this.field_178724_i.field_78795_f = ghost.getGhostAngle(3) * 4.5f + angleModification * (float)ghost.getMoveAdjustment(3);
        this.field_178724_i.field_78796_g = ghost.getGhostAngle(4) * 4.5f + angleModification * (float)ghost.getMoveAdjustment(4);
        this.field_178724_i.field_78808_h = ghost.getGhostAngle(5) * 4.5f + angleModification * (float)ghost.getMoveAdjustment(5);
        this.field_178723_h.field_78795_f = this.field_178724_i.field_78795_f;
        this.field_178723_h.field_78796_g = -this.field_178724_i.field_78796_g;
        this.field_178723_h.field_78808_h = -this.field_178724_i.field_78808_h;
        this.field_178722_k.field_78795_f = ghost.getGhostAngle(6) * 1.5f + angleModification * (float)ghost.getMoveAdjustment(6);
        this.field_178722_k.field_78796_g = ghost.getGhostAngle(7) * 1.5f + angleModification * (float)ghost.getMoveAdjustment(7);
        this.field_178722_k.field_78808_h = ghost.getGhostAngle(8) * 1.5f + angleModification * (float)ghost.getMoveAdjustment(8);
        this.field_178721_j.field_78795_f = this.field_178722_k.field_78795_f;
        this.field_178721_j.field_78796_g = -this.field_178722_k.field_78796_g;
        this.field_178721_j.field_78808_h = -this.field_178722_k.field_78808_h;
    }
}

