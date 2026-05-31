/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.renderer.culling.ICamera
 *  net.minecraft.client.renderer.entity.RenderLiving
 *  net.minecraft.client.renderer.entity.RenderManager
 *  net.minecraft.util.ResourceLocation
 */
package xol.lostinfinity.mob.render.mount;

import javax.annotation.Nullable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.culling.ICamera;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.resources.ResourceLocation;
import xol.lostinfinity.mob.entity.minion.EntityBombDrone;
import xol.lostinfinity.mob.model.minion.ModelBombDrone;

public class RenderBombDrone
extends RenderLiving<EntityBombDrone> {
    private static final ResourceLocation TEXTURES = new ResourceLocation("lostinfinity:textures/entity/bomb_drone.png");
    private static final ResourceLocation TEXTURES_ALT = new ResourceLocation("lostinfinity:textures/entity/bomb_drone_alt.png");

    public RenderBombDrone(RenderManager rendermanagerIn) {
        super(rendermanagerIn, (ModelBase)new ModelBombDrone(), 0.5f);
    }

    @Nullable
    protected ResourceLocation getEntityTexture(EntityBombDrone entity) {
        if (entity.field_70173_aa % 10 < 5) {
            return TEXTURES_ALT;
        }
        return TEXTURES;
    }

    public boolean shouldRender(EntityBombDrone livingEntity, ICamera camera, double camX, double camY, double camZ) {
        boolean flag1 = livingEntity.getOwner() != Minecraft.func_71410_x().field_71439_g;
        boolean flag2 = Minecraft.func_71410_x().field_71474_y.field_74320_O != 0;
        return flag1 || flag2;
    }
}

