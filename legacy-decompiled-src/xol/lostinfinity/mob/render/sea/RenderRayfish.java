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
package xol.lostinfinity.mob.render.sea;

import javax.annotation.Nullable;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.resources.ResourceLocation;
import xol.lostinfinity.mob.entity.sea.EntityRayfish;
import xol.lostinfinity.mob.model.sea.ModelRayfish;

public class RenderRayfish
extends RenderLiving<EntityRayfish> {
    public RenderRayfish(RenderManager rendermanagerIn) {
        super(rendermanagerIn, (ModelBase)new ModelRayfish(), 0.5f);
    }

    @Nullable
    protected ResourceLocation getEntityTexture(EntityRayfish entity) {
        int variant = entity.getVisualStyle();
        switch (variant) {
            case 0: {
                return new ResourceLocation("lostinfinity:textures/entity/sea/rayfish1.png");
            }
            case 1: {
                return new ResourceLocation("lostinfinity:textures/entity/sea/rayfish2.png");
            }
            case 2: {
                return new ResourceLocation("lostinfinity:textures/entity/sea/rayfish3.png");
            }
            case 3: {
                return new ResourceLocation("lostinfinity:textures/entity/sea/rayfish4.png");
            }
        }
        return new ResourceLocation("lostinfinity:textures/entity/sea/rayfish1.png");
    }
}

