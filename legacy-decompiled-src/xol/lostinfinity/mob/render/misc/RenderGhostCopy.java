/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.entity.RenderLiving
 *  net.minecraft.client.renderer.entity.RenderManager
 *  net.minecraft.util.ResourceLocation
 */
package xol.lostinfinity.mob.render.misc;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.resources.ResourceLocation;
import xol.lostinfinity.mob.entity.misc.EntityGhostCopy;
import xol.lostinfinity.mob.model.ModelGhostCopy;

public class RenderGhostCopy
extends RenderLiving<EntityGhostCopy> {
    public RenderGhostCopy(RenderManager manager) {
        super(manager, (ModelBase)new ModelGhostCopy(), 0.5f);
    }

    protected void preRenderCallback(EntityGhostCopy ghost, float partialTickTime) {
        float scale = ghost.getGhostScale();
        GlStateManager.func_179152_a((float)scale, (float)scale, (float)scale);
    }

    protected ResourceLocation getEntityTexture(EntityGhostCopy entity) {
        return entity.getSkinForMyCopy();
    }
}

