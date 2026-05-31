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
 *  net.minecraft.util.math.Vec3
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
import net.minecraft.world.phys.Vec3;
import xol.lostinfinity.mob.entity.sea.leviathan.EntityLeviathanSegment;
import xol.lostinfinity.projectile.entity.EntityLeviathanBreath;
import xol.lostinfinity.util.math.LMath;

public class RenderLeviathanBreath
extends Render<EntityLeviathanBreath> {
    public static final ResourceLocation TEXTURE_LASER_BEAM = new ResourceLocation("lostinfinity:textures/particles/laser_beam_bright.png");

    public RenderLeviathanBreath(RenderManager renderManager) {
        super(renderManager);
    }

    public void doRender(EntityLeviathanBreath entity, double x, double y, double z, float entityYaw, float partialTicks) {
        Vec3 dir = entity.getDirection(partialTicks);
        if (dir == null) {
            return;
        }
        this.func_110776_a(TEXTURE_LASER_BEAM);
        Tessellator tessellator = Tessellator.func_178181_a();
        BufferBuilder bufferbuilder = tessellator.func_178180_c();
        GlStateManager.func_179129_p();
        GlStateManager.func_179141_d();
        GlStateManager.func_179140_f();
        GlStateManager.func_179147_l();
        GlStateManager.func_179092_a((int)516, (float)0.15f);
        GlStateManager.func_179112_b((int)1, (int)1);
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        bufferbuilder.func_181668_a(7, DefaultVertexFormats.field_181707_g);
        float segment = entity.getOwnerSize() * 0.75f * 0.5f;
        EntityLeviathanSegment head = entity.getOwner().segments[0];
        float pitch = head.field_70125_A;
        float yaw = head.field_70177_z;
        Vec3 normDir = LMath.fastNormalize(dir);
        Vec3 rotate = new Vec3(0.0, (double)segment, 0.0).func_178789_a(pitch * ((float)Math.PI / 180)).func_178785_b(yaw * ((float)Math.PI / 180));
        bufferbuilder.func_181662_b(x - normDir.field_72450_a + rotate.field_72450_a, y - normDir.field_72448_b + rotate.field_72448_b, z - normDir.field_72449_c + rotate.field_72449_c).func_187315_a(0.0, 1.0).func_181675_d();
        bufferbuilder.func_181662_b(x - normDir.field_72450_a - rotate.field_72450_a, y - normDir.field_72448_b - rotate.field_72448_b, z - normDir.field_72449_c - rotate.field_72449_c).func_187315_a(0.0, 0.0).func_181675_d();
        bufferbuilder.func_181662_b(x + dir.field_72450_a - rotate.field_72450_a, y + dir.field_72448_b - rotate.field_72448_b, z + dir.field_72449_c - rotate.field_72449_c).func_187315_a(1.0, 0.0).func_181675_d();
        bufferbuilder.func_181662_b(x + dir.field_72450_a + rotate.field_72450_a, y + dir.field_72448_b + rotate.field_72448_b, z + dir.field_72449_c + rotate.field_72449_c).func_187315_a(1.0, 1.0).func_181675_d();
        tessellator.func_78381_a();
        GlStateManager.func_179118_c();
        GlStateManager.func_179145_e();
        GlStateManager.func_179089_o();
        GlStateManager.func_179084_k();
    }

    public boolean shouldRender(EntityLeviathanBreath livingEntity, ICamera camera, double camX, double camY, double camZ) {
        return true;
    }

    @Nullable
    protected ResourceLocation getEntityTexture(EntityLeviathanBreath entity) {
        return TEXTURE_LASER_BEAM;
    }
}

