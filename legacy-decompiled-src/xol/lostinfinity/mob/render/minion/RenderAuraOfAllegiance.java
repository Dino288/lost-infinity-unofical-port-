/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.entity.RenderManager
 *  net.minecraft.util.ResourceLocation
 */
package xol.lostinfinity.mob.render.minion;

import javax.annotation.Nullable;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.resources.ResourceLocation;
import xol.lostinfinity.mob.entity.minion.EntityAuraOfAllegiance;
import xol.lostinfinity.mob.model.minion.ModelAuraOfAllegiance;
import xol.lostinfinity.mob.render.minion.RenderMinion;

public class RenderAuraOfAllegiance
extends RenderMinion<EntityAuraOfAllegiance> {
    public static final ResourceLocation[] STONES = new ResourceLocation[]{new ResourceLocation("lostinfinity:textures/stone/cube_resolve.png"), new ResourceLocation("lostinfinity:textures/stone/cube_dread.png"), new ResourceLocation("lostinfinity:textures/stone/cube_ingenuity.png"), new ResourceLocation("lostinfinity:textures/stone/cube_aspiration.png"), new ResourceLocation("lostinfinity:textures/stone/cube_misdirection.png"), new ResourceLocation("lostinfinity:textures/stone/cube_ambition.png")};

    public RenderAuraOfAllegiance(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelAuraOfAllegiance(), 0.0f);
    }

    protected void preRenderCallback(EntityAuraOfAllegiance entitylivingbaseIn, float partialTickTime) {
        GlStateManager.func_179152_a((float)0.25f, (float)0.25f, (float)0.25f);
    }

    @Nullable
    protected ResourceLocation getEntityTexture(EntityAuraOfAllegiance entity) {
        return STONES[0];
    }
}

