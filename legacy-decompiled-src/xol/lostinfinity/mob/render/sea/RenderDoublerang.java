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
import xol.lostinfinity.mob.entity.sea.EntityDoublerang;
import xol.lostinfinity.mob.model.sea.ModelDoublerang;

public class RenderDoublerang
extends RenderLiving<EntityDoublerang> {
    public RenderDoublerang(RenderManager rendermanagerIn) {
        super(rendermanagerIn, (ModelBase)new ModelDoublerang(), 0.5f);
    }

    @Nullable
    protected ResourceLocation getEntityTexture(EntityDoublerang entity) {
        int variant = entity.getVisualStyle();
        switch (variant) {
            case 0: {
                return new ResourceLocation("lostinfinity:textures/entity/sea/doublerang1.png");
            }
            case 1: {
                return new ResourceLocation("lostinfinity:textures/entity/sea/doublerang2.png");
            }
            case 2: {
                return new ResourceLocation("lostinfinity:textures/entity/sea/doublerang3.png");
            }
            case 3: {
                return new ResourceLocation("lostinfinity:textures/entity/sea/doublerang4.png");
            }
        }
        return new ResourceLocation("lostinfinity:textures/entity/sea/doublerang1.png");
    }
}

