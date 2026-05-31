/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.renderer.entity.RenderLiving
 *  net.minecraft.client.renderer.entity.RenderManager
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.util.ResourceLocation
 */
package xol.lostinfinity.mob.render.labyrinth;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.resources.ResourceLocation;
import xol.lostinfinity.mob.entity.labyrinth.EntitySentry;
import xol.lostinfinity.mob.model.labyrinth.ModelSentry;

public class RenderSentry
extends RenderLiving<EntitySentry> {
    public static final ResourceLocation TEXTURES = new ResourceLocation("lostinfinity:textures/entity/labyrinth/sentry.png");
    public static final ResourceLocation ANIM1 = new ResourceLocation("lostinfinity:textures/entity/labyrinth/sentry_2.png");
    public static final ResourceLocation ANIM2 = new ResourceLocation("lostinfinity:textures/entity/labyrinth/sentry_3.png");
    public static final ResourceLocation ANIM3 = new ResourceLocation("lostinfinity:textures/entity/labyrinth/sentry_4.png");
    public static final ResourceLocation ANIM4 = new ResourceLocation("lostinfinity:textures/entity/labyrinth/sentry_5.png");
    public static final ResourceLocation ANIM5 = new ResourceLocation("lostinfinity:textures/entity/labyrinth/sentry_5.png");

    public RenderSentry(RenderManager manager) {
        super(manager, (ModelBase)new ModelSentry(), 0.5f);
    }

    protected ResourceLocation getEntityTexture(EntitySentry entity) {
        switch (entity.field_70173_aa % 20) {
            case 0: {
                return ANIM1;
            }
            case 1: {
                return ANIM2;
            }
            case 2: {
                return ANIM3;
            }
            case 3: {
                return ANIM4;
            }
            case 4: {
                return ANIM5;
            }
        }
        return TEXTURES;
    }

    protected void applyRotations(EntitySentry entityLiving, float p1, float rotationYaw, float partialTicks) {
        super.func_77043_a((LivingEntity)entityLiving, p1, rotationYaw, partialTicks);
    }
}

