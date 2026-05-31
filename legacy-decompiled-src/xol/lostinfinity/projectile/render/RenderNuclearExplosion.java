/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.client.renderer.BufferBuilder
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.Tessellator
 *  net.minecraft.client.renderer.culling.ICamera
 *  net.minecraft.client.renderer.entity.Render
 *  net.minecraft.client.renderer.entity.RenderManager
 *  net.minecraft.client.renderer.vertex.DefaultVertexFormats
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.math.Mth
 *  org.lwjgl.util.vector.Quaternion
 */
package xol.lostinfinity.projectile.render;

import javax.annotation.Nullable;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.culling.ICamera;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import org.lwjgl.util.vector.Quaternion;
import xol.lostinfinity.mob.entity.misc.EntityNuclearExplosion;

public class RenderNuclearExplosion
extends Render<EntityNuclearExplosion> {
    private static final ResourceLocation TEXTURE_RING = new ResourceLocation("lostinfinity:textures/particles/nuclear_ring.png");
    private static final ResourceLocation TEXTURE_CORE = new ResourceLocation("lostinfinity:textures/particles/bomber_explosion.png");

    public RenderNuclearExplosion(RenderManager renderManager) {
        super(renderManager);
    }

    public boolean shouldRender(EntityNuclearExplosion livingEntity, ICamera camera, double camX, double camY, double camZ) {
        return true;
    }

    public void doRender(EntityNuclearExplosion entity, double x, double y, double z, float entityYaw, float partialTicks) {
        int animationTick = entity.getAnimationTick();
        Tessellator tessellator = Tessellator.func_178181_a();
        BufferBuilder bufferbuilder = tessellator.func_178180_c();
        GlStateManager.func_179129_p();
        GlStateManager.func_179141_d();
        GlStateManager.func_179140_f();
        GlStateManager.func_179147_l();
        GlStateManager.func_179092_a((int)516, (float)0.15f);
        GlStateManager.func_179112_b((int)770, (int)1);
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        GlStateManager.func_179094_E();
        GlStateManager.func_179137_b((double)x, (double)y, (double)z);
        this.func_110776_a(TEXTURE_CORE);
        float coreSize = 0.0f;
        if (animationTick < 150) {
            coreSize = ((float)animationTick + 6.0f * partialTicks) / 30.0f;
        } else if (animationTick < 155) {
            coreSize = (float)Mth.func_151238_b((double)0.0, (double)5.2, (double)(((float)(155 - animationTick) - partialTicks) / 5.0f));
        } else if (animationTick < 200) {
            coreSize = (float)Mth.func_151238_b((double)0.0, (double)360.0, (double)(((float)animationTick + partialTicks - 160.0f) / 40.0f));
            if (animationTick > 180) {
                GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)((float)(200 - animationTick) / 20.0f));
            }
        }
        if (coreSize > 0.0f) {
            bufferbuilder.func_181668_a(7, DefaultVertexFormats.field_181707_g);
            bufferbuilder.func_181662_b((double)(-coreSize), 0.0, (double)coreSize).func_187315_a(0.0, 1.0).func_181675_d();
            bufferbuilder.func_181662_b((double)(-coreSize), 0.0, (double)(-coreSize)).func_187315_a(0.0, 0.0).func_181675_d();
            bufferbuilder.func_181662_b((double)coreSize, 0.0, (double)(-coreSize)).func_187315_a(1.0, 0.0).func_181675_d();
            bufferbuilder.func_181662_b((double)coreSize, 0.0, (double)coreSize).func_187315_a(1.0, 1.0).func_181675_d();
            bufferbuilder.func_181662_b((double)(-coreSize), (double)coreSize, 0.0).func_187315_a(0.0, 1.0).func_181675_d();
            bufferbuilder.func_181662_b((double)(-coreSize), (double)(-coreSize), 0.0).func_187315_a(0.0, 0.0).func_181675_d();
            bufferbuilder.func_181662_b((double)coreSize, (double)(-coreSize), 0.0).func_187315_a(1.0, 0.0).func_181675_d();
            bufferbuilder.func_181662_b((double)coreSize, (double)coreSize, 0.0).func_187315_a(1.0, 1.0).func_181675_d();
            bufferbuilder.func_181662_b(0.0, (double)(-coreSize), (double)coreSize).func_187315_a(0.0, 1.0).func_181675_d();
            bufferbuilder.func_181662_b(0.0, (double)(-coreSize), (double)(-coreSize)).func_187315_a(0.0, 0.0).func_181675_d();
            bufferbuilder.func_181662_b(0.0, (double)coreSize, (double)(-coreSize)).func_187315_a(1.0, 0.0).func_181675_d();
            bufferbuilder.func_181662_b(0.0, (double)coreSize, (double)coreSize).func_187315_a(1.0, 1.0).func_181675_d();
            tessellator.func_78381_a();
        }
        this.func_110776_a(TEXTURE_RING);
        if (animationTick < 150) {
            int startRing;
            int ringWidth = 10;
            int ringCount = 6;
            int frequency = 5;
            float ratio = ((float)animationTick + partialTicks) % (float)frequency / (float)frequency;
            float ringSize = (float)Mth.func_151238_b((double)ringWidth, (double)0.0, (double)ratio);
            int rings = Math.min(ringCount - (animationTick - 120) / frequency, ringCount);
            for (int i = startRing = Math.max(ringCount - 1 - animationTick / frequency, 0); i < rings; ++i) {
                GlStateManager.func_179094_E();
                GlStateManager.func_187444_a((Quaternion)entity.getRotation(i));
                if (i >= ringCount - 2) {
                    GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)((ratio + (float)ringCount - (float)i - 1.0f) * 0.5f));
                }
                bufferbuilder.func_181668_a(7, DefaultVertexFormats.field_181707_g);
                bufferbuilder.func_181662_b((double)(-(ringSize + (float)(i * ringWidth))), 0.5, (double)(ringSize + (float)(i * ringWidth))).func_187315_a(0.0, 1.0).func_181675_d();
                bufferbuilder.func_181662_b((double)(-(ringSize + (float)(i * ringWidth))), 0.5, (double)(-(ringSize + (float)(i * ringWidth)))).func_187315_a(0.0, 0.0).func_181675_d();
                bufferbuilder.func_181662_b((double)(ringSize + (float)(i * ringWidth)), 0.5, (double)(-(ringSize + (float)(i * ringWidth)))).func_187315_a(1.0, 0.0).func_181675_d();
                bufferbuilder.func_181662_b((double)(ringSize + (float)(i * ringWidth)), 0.5, (double)(ringSize + (float)(i * ringWidth))).func_187315_a(1.0, 1.0).func_181675_d();
                tessellator.func_78381_a();
                GlStateManager.func_179121_F();
            }
        }
        GlStateManager.func_179121_F();
        GlStateManager.func_179118_c();
        GlStateManager.func_179145_e();
        GlStateManager.func_179089_o();
        GlStateManager.func_179084_k();
    }

    @Nullable
    protected ResourceLocation getEntityTexture(EntityNuclearExplosion entity) {
        return null;
    }
}

