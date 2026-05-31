/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.entity.RenderLiving
 *  net.minecraft.client.renderer.entity.RenderManager
 *  net.minecraft.util.ResourceLocation
 */
package xol.lostinfinity.mob.render.cthulhu;

import javax.annotation.Nullable;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.resources.ResourceLocation;
import xol.lostinfinity.mob.entity.cthulhu.EntityCthulhuHealingOrb;
import xol.lostinfinity.mob.model.cthulhu.ModelCthulhuHealingOrb;

public class RenderCthulhuHealingOrb
extends RenderLiving<EntityCthulhuHealingOrb> {
    public static final ResourceLocation TEXTURE = new ResourceLocation("lostinfinity:textures/entity/cthulhu/healing_orb.png");

    public RenderCthulhuHealingOrb(RenderManager rendermanagerIn) {
        super(rendermanagerIn, (ModelBase)new ModelCthulhuHealingOrb(), 0.0f);
    }

    @Nullable
    public ResourceLocation getEntityTexture(EntityCthulhuHealingOrb entity) {
        return TEXTURE;
    }

    protected void preRenderCallback(EntityCthulhuHealingOrb entitylivingbaseIn, float partialTickTime) {
        GlStateManager.func_179152_a((float)5.0f, (float)5.0f, (float)5.0f);
    }
}

