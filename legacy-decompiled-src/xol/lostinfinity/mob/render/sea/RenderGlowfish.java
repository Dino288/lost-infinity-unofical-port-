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
import xol.lostinfinity.mob.entity.sea.EntityGlowfish;
import xol.lostinfinity.mob.model.sea.ModelGlowfish;

public class RenderGlowfish
extends RenderLiving<EntityGlowfish> {
    public RenderGlowfish(RenderManager rendermanagerIn) {
        super(rendermanagerIn, (ModelBase)new ModelGlowfish(), 0.5f);
    }

    @Nullable
    protected ResourceLocation getEntityTexture(EntityGlowfish entity) {
        int variant = entity.getVisualStyle();
        switch (variant) {
            case 0: {
                return new ResourceLocation("lostinfinity:textures/entity/sea/glowfish1.png");
            }
            case 1: {
                return new ResourceLocation("lostinfinity:textures/entity/sea/glowfish2.png");
            }
            case 2: {
                return new ResourceLocation("lostinfinity:textures/entity/sea/glowfish3.png");
            }
            case 3: {
                return new ResourceLocation("lostinfinity:textures/entity/sea/glowfish4.png");
            }
        }
        return new ResourceLocation("lostinfinity:textures/entity/sea/glowfish1.png");
    }
}

