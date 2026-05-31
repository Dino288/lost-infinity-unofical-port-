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
import xol.lostinfinity.mob.entity.sea.EntityLongfin;
import xol.lostinfinity.mob.model.sea.ModelLongfin;

public class RenderLongfin
extends RenderLiving<EntityLongfin> {
    public RenderLongfin(RenderManager rendermanagerIn) {
        super(rendermanagerIn, (ModelBase)new ModelLongfin(), 0.5f);
    }

    @Nullable
    protected ResourceLocation getEntityTexture(EntityLongfin entity) {
        int variant = entity.getVisualStyle();
        switch (variant) {
            case 0: {
                return new ResourceLocation("lostinfinity:textures/entity/sea/longfin1.png");
            }
            case 1: {
                return new ResourceLocation("lostinfinity:textures/entity/sea/longfin2.png");
            }
            case 2: {
                return new ResourceLocation("lostinfinity:textures/entity/sea/longfin3.png");
            }
            case 3: {
                return new ResourceLocation("lostinfinity:textures/entity/sea/longfin4.png");
            }
        }
        return new ResourceLocation("lostinfinity:textures/entity/sea/longfin1.png");
    }
}

