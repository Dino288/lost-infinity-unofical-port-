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
import xol.lostinfinity.mob.entity.cthulhu.EntityCthulhuTurret;
import xol.lostinfinity.mob.model.boss.ModelRestorationCrystal;

public class RenderCthulhuTurret
extends RenderLiving<EntityCthulhuTurret> {
    private static final ResourceLocation TEXTURE = new ResourceLocation("lostinfinity", "textures/entity/cthulhu/turret.png");

    public RenderCthulhuTurret(RenderManager rendermanagerIn) {
        super(rendermanagerIn, (ModelBase)new ModelRestorationCrystal(), 2.5f);
    }

    @Nullable
    protected ResourceLocation getEntityTexture(EntityCthulhuTurret entity) {
        return TEXTURE;
    }
}

