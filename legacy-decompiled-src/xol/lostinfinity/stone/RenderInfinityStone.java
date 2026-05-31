/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.entity.RenderLiving
 *  net.minecraft.client.renderer.entity.RenderManager
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.util.ResourceLocation
 */
package xol.lostinfinity.stone;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.resources.ResourceLocation;
import xol.lostinfinity.stone.EntityInfinityStone;
import xol.lostinfinity.stone.model.ModelInfinityCube;

public class RenderInfinityStone
extends RenderLiving<EntityInfinityStone> {
    public static final ResourceLocation OCEAN = new ResourceLocation("lostinfinity:textures/stone/cube_duality.png");
    public static final ResourceLocation MOUNTAIN = new ResourceLocation("lostinfinity:textures/stone/cube_aspiration.png");
    public static final ResourceLocation BADLANDS = new ResourceLocation("lostinfinity:textures/stone/cube_corruption.png");
    public static final ResourceLocation INGENUITY = new ResourceLocation("lostinfinity:textures/stone/cube_ingenuity.png");
    public static final ResourceLocation MISDIRECTION = new ResourceLocation("lostinfinity:textures/stone/cube_misdirection.png");
    public static final ResourceLocation VENGEANCE = new ResourceLocation("lostinfinity:textures/stone/cube_vengeance.png");
    public static final ResourceLocation RETROSPECTION = new ResourceLocation("lostinfinity:textures/stone/cube_retrospection.png");
    public static final ResourceLocation DREAD = new ResourceLocation("lostinfinity:textures/stone/cube_dread.png");
    public static final ResourceLocation ANXIETY = new ResourceLocation("lostinfinity:textures/stone/cube_anxiety.png");
    public static final ResourceLocation IMPOSITION = new ResourceLocation("lostinfinity:textures/stone/cube_imposition.png");
    public static final ResourceLocation AMBITION = new ResourceLocation("lostinfinity:textures/stone/cube_ambition.png");
    public static final ResourceLocation PERCEPTION = new ResourceLocation("lostinfinity:textures/stone/cube_perception.png");
    public static final ResourceLocation ANTICIPATION = new ResourceLocation("lostinfinity:textures/stone/cube_anticipation.png");
    public static final ResourceLocation RESOLVE = new ResourceLocation("lostinfinity:textures/stone/cube_resolve.png");
    public static final ResourceLocation CRUELTY = new ResourceLocation("lostinfinity:textures/stone/cube_cruelty.png");
    private float scale = 0.25f;

    public RenderInfinityStone(RenderManager manager) {
        super(manager, (ModelBase)new ModelInfinityCube(), 0.25f);
        this.field_76989_e = 0.25f;
    }

    protected void preRenderCallback(EntityInfinityStone entitylivingbaseIn, float partialTickTime) {
        GlStateManager.func_179152_a((float)this.scale, (float)this.scale, (float)this.scale);
    }

    protected ResourceLocation getEntityTexture(EntityInfinityStone entity) {
        switch (entity.getStoneNum()) {
            case 0: {
                return OCEAN;
            }
            case 1: {
                return MOUNTAIN;
            }
            case 2: {
                return BADLANDS;
            }
            case 3: {
                return INGENUITY;
            }
            case 4: {
                return MISDIRECTION;
            }
            case 5: {
                return VENGEANCE;
            }
            case 6: {
                return RETROSPECTION;
            }
            case 7: {
                return DREAD;
            }
            case 8: {
                return ANXIETY;
            }
            case 9: {
                return IMPOSITION;
            }
            case 10: {
                return AMBITION;
            }
            case 11: {
                return PERCEPTION;
            }
            case 12: {
                return ANTICIPATION;
            }
            case 13: {
                return RESOLVE;
            }
            case 14: {
                return CRUELTY;
            }
        }
        return OCEAN;
    }

    protected void applyRotations(EntityInfinityStone entityLiving, float p1, float rotationYaw, float partialTicks) {
        super.func_77043_a((LivingEntity)entityLiving, p1, rotationYaw, partialTicks);
    }
}

