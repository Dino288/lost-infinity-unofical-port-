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
import xol.lostinfinity.mob.entity.fungal.EntityMushmerra;
import xol.lostinfinity.mob.model.fungal.ModelMushmerra;

public class RenderMushmerra
extends RenderLiving<EntityMushmerra> {
    public static final ResourceLocation TEXTURES = new ResourceLocation("lostinfinity:textures/entity/fungal/mushmerra.png");

    public RenderMushmerra(RenderManager rendermanagerIn) {
        super(rendermanagerIn, (ModelBase)new ModelMushmerra(), 0.0f);
    }

    @Nullable
    protected ResourceLocation getEntityTexture(EntityMushmerra entity) {
        return TEXTURES;
    }
}

