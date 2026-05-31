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
import xol.lostinfinity.mob.entity.sea.EntityOctobrella;
import xol.lostinfinity.mob.model.sea.ModelOctobrella;

public class RenderOctobrella
extends RenderLiving<EntityOctobrella> {
    public RenderOctobrella(RenderManager rendermanagerIn) {
        super(rendermanagerIn, (ModelBase)new ModelOctobrella(), 0.5f);
    }

    @Nullable
    protected ResourceLocation getEntityTexture(EntityOctobrella entity) {
        int variant = entity.getVisualStyle();
        switch (variant) {
            case 0: {
                return new ResourceLocation("lostinfinity:textures/entity/sea/octobrella1.png");
            }
            case 1: {
                return new ResourceLocation("lostinfinity:textures/entity/sea/octobrella2.png");
            }
            case 2: {
                return new ResourceLocation("lostinfinity:textures/entity/sea/octobrella3.png");
            }
            case 3: {
                return new ResourceLocation("lostinfinity:textures/entity/sea/octobrella4.png");
            }
        }
        return new ResourceLocation("lostinfinity:textures/entity/sea/octobrella1.png");
    }
}

