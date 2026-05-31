/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.renderer.entity.RenderLiving
 *  net.minecraft.client.renderer.entity.RenderManager
 *  net.minecraft.util.ResourceLocation
 */
package xol.lostinfinity.mob.render.fungal;

import javax.annotation.Nullable;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.resources.ResourceLocation;
import xol.lostinfinity.mob.entity.fungal.EntityShroomite;
import xol.lostinfinity.mob.model.fungal.ModelShroomite;

public class RenderShroomite
extends RenderLiving<EntityShroomite> {
    public static final ResourceLocation TEXTURES = new ResourceLocation("lostinfinity:textures/entity/fungal/shroomite.png");

    public RenderShroomite(RenderManager rendermanagerIn) {
        super(rendermanagerIn, (ModelBase)new ModelShroomite(), 0.0f);
    }

    @Nullable
    protected ResourceLocation getEntityTexture(EntityShroomite entity) {
        return TEXTURES;
    }
}

