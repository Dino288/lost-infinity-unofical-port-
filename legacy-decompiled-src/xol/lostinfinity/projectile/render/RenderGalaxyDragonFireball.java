/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.client.renderer.BufferBuilder
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.Tessellator
 *  net.minecraft.client.renderer.entity.Render
 *  net.minecraft.client.renderer.entity.RenderManager
 *  net.minecraft.client.renderer.vertex.DefaultVertexFormats
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.ResourceLocation
 */
package xol.lostinfinity.projectile.render;

import javax.annotation.Nullable;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import xol.lostinfinity.projectile.entity.EntityGalaxyDragonFireball;

public class RenderGalaxyDragonFireball
extends Render<EntityGalaxyDragonFireball> {
    private static final ResourceLocation FLAME_0 = new ResourceLocation("lostinfinity:textures/projectiles/cosmic_flame_0.png");
    private static final ResourceLocation FLAME_1 = new ResourceLocation("lostinfinity:textures/projectiles/cosmic_flame_1.png");

    public RenderGalaxyDragonFireball(RenderManager renderManager) {
        super(renderManager);
    }

    public void func_76979_b(Entity entityIn, double x, double y, double z, float yaw, float partialTicks) {
        if (this.field_76990_c.field_78733_k != null) {
            this.renderEntityOnFire(entityIn, x, y, z, partialTicks);
        }
    }

    @Nullable
    protected ResourceLocation getEntityTexture(EntityGalaxyDragonFireball entity) {
        return null;
    }

    private void renderEntityOnFire(Entity entity, double x, double y, double z, float partialTicks) {
        GlStateManager.func_179140_f();
        GlStateManager.func_179094_E();
        GlStateManager.func_179109_b((float)((float)x), (float)((float)y), (float)((float)z));
        float flameSize = entity.field_70130_N * 1.4f;
        GlStateManager.func_179152_a((float)flameSize, (float)flameSize, (float)flameSize);
        Tessellator tessellator = Tessellator.func_178181_a();
        BufferBuilder bufferbuilder = tessellator.func_178180_c();
        float vertexX = 0.5f;
        float flameCount = entity.field_70131_O / flameSize;
        float yOffset = (float)(entity.field_70163_u - entity.func_174813_aQ().field_72338_b);
        GlStateManager.func_179114_b((float)(-this.field_76990_c.field_78735_i), (float)0.0f, (float)1.0f, (float)0.0f);
        GlStateManager.func_179109_b((float)0.0f, (float)0.0f, (float)(-0.3f + (float)((int)flameCount) * 0.02f));
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        float vertexZ = 0.0f;
        int i = 0;
        bufferbuilder.func_181668_a(7, DefaultVertexFormats.field_181707_g);
        while (flameCount > 0.0f) {
            this.func_110776_a(i % 2 == 0 ? FLAME_0 : FLAME_1);
            float minX = 0.0f;
            float minY = (float)(entity.field_70173_aa % 32) / 32.0f;
            float maxX = 1.0f;
            float maxY = minY + 0.03125f;
            if (i / 2 % 2 == 0) {
                float f10 = maxX;
                maxX = minX;
                minX = f10;
            }
            bufferbuilder.func_181662_b((double)(vertexX - 0.0f), (double)(0.0f - yOffset), (double)vertexZ).func_187315_a((double)maxX, (double)maxY).func_181675_d();
            bufferbuilder.func_181662_b((double)(-vertexX - 0.0f), (double)(0.0f - yOffset), (double)vertexZ).func_187315_a((double)minX, (double)maxY).func_181675_d();
            bufferbuilder.func_181662_b((double)(-vertexX - 0.0f), (double)(1.4f - yOffset), (double)vertexZ).func_187315_a((double)minX, (double)minY).func_181675_d();
            bufferbuilder.func_181662_b((double)(vertexX - 0.0f), (double)(1.4f - yOffset), (double)vertexZ).func_187315_a((double)maxX, (double)minY).func_181675_d();
            flameCount -= 0.45f;
            yOffset -= 0.45f;
            vertexX *= 0.9f;
            vertexZ += 0.03f;
            ++i;
        }
        tessellator.func_78381_a();
        GlStateManager.func_179121_F();
        GlStateManager.func_179145_e();
    }
}

