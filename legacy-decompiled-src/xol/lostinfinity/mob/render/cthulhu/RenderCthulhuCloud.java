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
package xol.lostinfinity.mob.render.cthulhu;

import javax.annotation.Nullable;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.resources.ResourceLocation;
import xol.lostinfinity.mob.entity.cthulhu.EntityCthulhuCloud;
import xol.lostinfinity.mob.model.cthulhu.ModelCthulhuCloud;

public class RenderCthulhuCloud
extends RenderLiving<EntityCthulhuCloud> {
    public RenderCthulhuCloud(RenderManager rendermanagerIn) {
        super(rendermanagerIn, (ModelBase)new ModelCthulhuCloud(), 0.0f);
    }

    @Nullable
    protected ResourceLocation getEntityTexture(EntityCthulhuCloud entity) {
        return null;
    }
}

