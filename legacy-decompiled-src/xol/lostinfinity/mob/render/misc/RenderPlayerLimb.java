/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelBiped
 *  net.minecraft.client.renderer.entity.RenderBiped
 *  net.minecraft.client.renderer.entity.RenderManager
 *  net.minecraft.util.ResourceLocation
 */
package xol.lostinfinity.mob.render.misc;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.resources.ResourceLocation;
import xol.lostinfinity.mob.entity.misc.PlayerLimb;
import xol.lostinfinity.mob.model.ModelPlayerLimb;

public class RenderPlayerLimb
extends RenderBiped<PlayerLimb> {
    public RenderPlayerLimb(RenderManager renderManagerIn) {
        super(renderManagerIn, (ModelBiped)new ModelPlayerLimb(1.0f, true), 0.0f);
    }

    protected ResourceLocation getEntityTexture(PlayerLimb entity) {
        return entity.getSkin();
    }
}

