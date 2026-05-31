/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.renderer.BufferBuilder
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.Tessellator
 *  net.minecraft.client.renderer.entity.RenderLiving
 *  net.minecraft.client.renderer.entity.RenderManager
 *  net.minecraft.client.renderer.vertex.DefaultVertexFormats
 *  net.minecraft.entity.Mob
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.math.Rotations
 *  net.minecraft.util.math.Vec3
 */
package xol.lostinfinity.mob.render.cthulhu;

import javax.annotation.Nullable;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.world.entity.Mob;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.math.Rotations;
import net.minecraft.world.phys.Vec3;
import xol.lostinfinity.mob.entity.cthulhu.EntityCelestialStatue;
import xol.lostinfinity.mob.model.cthulhu.ModelCelestialStatue;
import xol.lostinfinity.util.math.LMath;

public class RenderCelestialStatue
extends RenderLiving<EntityCelestialStatue> {
    private static final ResourceLocation TEXTURE_BEAM = new ResourceLocation("lostinfinity", "textures/projectiles/cthulhu/celestial_beam.png");
    private static final ResourceLocation TEXTURE_PORTAL = new ResourceLocation("lostinfinity", "textures/projectiles/cthulhu/celestial_beam_portal.png");
    private static final ResourceLocation CEL_BLUE = new ResourceLocation("lostinfinity", "textures/entity/cthulhu/celestial_blue.png");
    private static final ResourceLocation CEL_PINK = new ResourceLocation("lostinfinity", "textures/entity/cthulhu/celestial_pink.png");
    private static final ResourceLocation CEL_PURPLE = new ResourceLocation("lostinfinity", "textures/entity/cthulhu/celestial_purple.png");
    private static final ResourceLocation CEL_RED = new ResourceLocation("lostinfinity", "textures/entity/cthulhu/celestial_red.png");

    public RenderCelestialStatue(RenderManager rendermanagerIn) {
        super(rendermanagerIn, (ModelBase)new ModelCelestialStatue(), 0.0f);
    }

    @Nullable
    protected ResourceLocation getEntityTexture(EntityCelestialStatue entity) {
        switch (entity.getType()) {
            case 0: {
                return CEL_RED;
            }
            case 1: {
                return CEL_PURPLE;
            }
            case 2: {
                return CEL_BLUE;
            }
            case 3: {
                return CEL_PINK;
            }
        }
        return CEL_RED;
    }

    public void doRender(EntityCelestialStatue entity, double x, double y, double z, float entityYaw, float partialTicks) {
        super.func_76986_a((Mob)entity, x, y, z, entityYaw, partialTicks);
        if (entity.getOwner() == null) {
            return;
        }
        GlStateManager.func_179129_p();
        GlStateManager.func_179094_E();
        GlStateManager.func_179137_b((double)x, (double)y, (double)z);
        Vec3 offset = entity.getBeamOriginOffset();
        GlStateManager.func_179137_b((double)offset.field_72450_a, (double)offset.field_72448_b, (double)offset.field_72449_c);
        offset = entity.func_174791_d().func_178787_e(offset).func_178788_d(entity.getOwner().func_174824_e(1.0f));
        Rotations rotations = LMath.toPitchYaw(offset);
        GlStateManager.func_179114_b((float)(rotations.func_179416_c() + 180.0f), (float)0.0f, (float)-1.0f, (float)0.0f);
        GlStateManager.func_179114_b((float)(-rotations.func_179415_b()), (float)1.0f, (float)0.0f, (float)0.0f);
        Tessellator tessellator = Tessellator.func_178181_a();
        BufferBuilder bufferbuilder = tessellator.func_178180_c();
        float size = 5.0f;
        double distance = LMath.fastLength(offset);
        this.func_110776_a(TEXTURE_BEAM);
        bufferbuilder.func_181668_a(7, DefaultVertexFormats.field_181707_g);
        bufferbuilder.func_181662_b(0.0, -0.5 * (double)size, 0.0).func_187315_a(1.0, 0.0).func_181675_d();
        bufferbuilder.func_181662_b(0.0, -0.5 * (double)size, distance).func_187315_a(0.0, 0.0).func_181675_d();
        bufferbuilder.func_181662_b(0.0, 0.5 * (double)size, distance).func_187315_a(0.0, 1.0).func_181675_d();
        bufferbuilder.func_181662_b(0.0, 0.5 * (double)size, 0.0).func_187315_a(1.0, 1.0).func_181675_d();
        bufferbuilder.func_181662_b(-0.5 * (double)size, 0.0, 0.0).func_187315_a(1.0, 0.0).func_181675_d();
        bufferbuilder.func_181662_b(-0.5 * (double)size, 0.0, distance).func_187315_a(0.0, 0.0).func_181675_d();
        bufferbuilder.func_181662_b(0.5 * (double)size, 0.0, distance).func_187315_a(0.0, 1.0).func_181675_d();
        bufferbuilder.func_181662_b(0.5 * (double)size, 0.0, 0.0).func_187315_a(1.0, 1.0).func_181675_d();
        tessellator.func_78381_a();
        this.func_110776_a(TEXTURE_PORTAL);
        bufferbuilder.func_181668_a(7, DefaultVertexFormats.field_181707_g);
        bufferbuilder.func_181662_b(1.5 * (double)size, -1.5 * (double)size, 0.0).func_187315_a(1.0, 0.0).func_181675_d();
        bufferbuilder.func_181662_b(-1.5 * (double)size, -1.5 * (double)size, 0.0).func_187315_a(0.0, 0.0).func_181675_d();
        bufferbuilder.func_181662_b(-1.5 * (double)size, 1.5 * (double)size, 0.0).func_187315_a(0.0, 1.0).func_181675_d();
        bufferbuilder.func_181662_b(1.5 * (double)size, 1.5 * (double)size, 0.0).func_187315_a(1.0, 1.0).func_181675_d();
        tessellator.func_78381_a();
        GlStateManager.func_179121_F();
        GlStateManager.func_179089_o();
    }

    protected void preRenderCallback(EntityCelestialStatue entitylivingbaseIn, float partialTickTime) {
        GlStateManager.func_179139_a((double)2.75, (double)2.75, (double)2.75);
    }
}

