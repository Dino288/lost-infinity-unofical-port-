/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.AbstractClientPlayer
 *  net.minecraft.client.entity.PlayerSP
 *  net.minecraft.client.network.NetworkPlayerInfo
 *  net.minecraft.client.renderer.BufferBuilder
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.RenderHelper
 *  net.minecraft.client.renderer.Tessellator
 *  net.minecraft.client.renderer.vertex.DefaultVertexFormats
 *  net.minecraft.entity.player.Player
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.math.Mth
 *  net.minecraft.util.math.Vec3
 *  net.minecraftforge.client.event.RenderWorldLastEvent
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 */
package xol.lostinfinity.client.screen;

import java.util.HashSet;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.entity.PlayerSP;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionHand;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.util.math.LMath;

public class HeadHunterVision {
    public static final Map<UUID, Vec3> oorPlayer = new ConcurrentHashMap<UUID, Vec3>();
    private static final ResourceLocation BULLSEYE = new ResourceLocation("lostinfinity:textures/gui/bullseye.png");
    private static final int DISTANCE = 160000;
    private final Minecraft mc = Minecraft.func_71410_x();

    @SubscribeEvent
    public void onPostRender(RenderWorldLastEvent event) {
        if (this.mc.field_71439_g.func_184586_b(InteractionHand.MAIN_HAND).func_77973_b() == ItemInit.headHunter || this.mc.field_71439_g.func_184586_b(InteractionHand.OFF_HAND).func_77973_b() == ItemInit.headHunter) {
            HashSet<UUID> rendered = new HashSet<UUID>();
            for (Player player : this.mc.field_71441_e.field_73010_i) {
                double dist;
                if (player == this.mc.field_71439_g || !((dist = player.func_174791_d().func_72436_e(this.mc.field_71439_g.func_174791_d())) <= 160000.0)) continue;
                this.onTickRender(player, dist);
                rendered.add(player.func_110124_au());
            }
            if (this.mc.func_147114_u() == null) {
                return;
            }
            for (UUID uuid : oorPlayer.keySet()) {
                if (rendered.contains(uuid)) continue;
                NetworkPlayerInfo info = this.mc.func_147114_u().func_175102_a(uuid);
                if (info == null) {
                    oorPlayer.remove(uuid);
                    continue;
                }
                Vec3 pos = oorPlayer.get(uuid);
                double dist = this.mc.field_71439_g.func_174791_d().func_72436_e(pos);
                if (!(dist <= 160000.0)) continue;
                this.onTickRender(info.func_178837_g(), pos.field_72450_a, pos.field_72448_b, pos.field_72449_c, dist);
            }
        } else {
            oorPlayer.clear();
        }
    }

    private void onTickRender(Player other, double dist) {
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        double partialTicks = this.mc.func_184121_ak();
        double dX = Mth.func_151238_b((double)other.field_70142_S, (double)other.field_70165_t, (double)partialTicks);
        double dY = Mth.func_151238_b((double)other.field_70137_T, (double)other.field_70163_u, (double)partialTicks);
        double dZ = Mth.func_151238_b((double)other.field_70136_U, (double)other.field_70161_v, (double)partialTicks);
        this.onTickRender(((AbstractClientPlayer)other).func_110306_p(), dX, dY, dZ, dist);
    }

    private void onTickRender(ResourceLocation skin, double dX, double dY, double dZ, double dist) {
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        double partialTicks = this.mc.func_184121_ak();
        PlayerSP camera = this.mc.field_71439_g;
        double cX = Mth.func_151238_b((double)camera.field_70142_S, (double)camera.field_70165_t, (double)partialTicks);
        double cY = Mth.func_151238_b((double)camera.field_70137_T, (double)camera.field_70163_u, (double)partialTicks);
        double cZ = Mth.func_151238_b((double)camera.field_70136_U, (double)camera.field_70161_v, (double)partialTicks);
        double yaw = LMath.degreeLerp(camera.field_70758_at, camera.field_70759_as, partialTicks);
        double pitch = LMath.degreeLerp(camera.field_70127_C, camera.field_70125_A, partialTicks);
        Vec3 normalized = LMath.fastNormalize(new Vec3(dX - cX, dY - cY, dZ - cZ)).func_186678_a(5.0);
        double r = Mth.func_151238_b((double)0.5, (double)1.0, (double)(1.0 - dist / 160000.0));
        this.initialize(normalized.field_72450_a, normalized.field_72448_b + (double)camera.func_70047_e(), normalized.field_72449_c, (float)yaw, (float)pitch);
        if (skin != null) {
            this.drawPlayerFace(skin, 0.5 * r, 0.5 * r);
        }
        this.drawBullseye(0.5 * r, 0.5 * r, r);
        this.cleanup();
    }

    private void initialize(double x, double y, double z, float cameraYaw, float cameraPitch) {
        GlStateManager.func_179094_E();
        GlStateManager.func_179137_b((double)x, (double)y, (double)z);
        GlStateManager.func_179114_b((float)(-cameraYaw), (float)0.0f, (float)1.0f, (float)0.0f);
        GlStateManager.func_179114_b((float)cameraPitch, (float)1.0f, (float)0.0f, (float)0.0f);
        GlStateManager.func_179097_i();
        RenderHelper.func_74518_a();
    }

    private void cleanup() {
        RenderHelper.func_74519_b();
        GlStateManager.func_179126_j();
        GlStateManager.func_179121_F();
    }

    private void drawPlayerFace(ResourceLocation playerSkin, double width, double height) {
        float widthScale = 0.015625f;
        float heightScale = 0.015625f;
        double growX = 0.0625 * width;
        double growY = 0.0625 * height;
        this.mc.func_110434_K().func_110577_a(playerSkin);
        Tessellator tessellator = Tessellator.func_178181_a();
        BufferBuilder bufferbuilder = tessellator.func_178180_c();
        bufferbuilder.func_181668_a(7, DefaultVertexFormats.field_181707_g);
        bufferbuilder.func_181662_b(-width * 0.5, height * 0.5, 0.0).func_187315_a((double)(16.0f * widthScale), (double)(8.0f * heightScale)).func_181675_d();
        bufferbuilder.func_181662_b(width * 0.5, height * 0.5, 0.0).func_187315_a((double)(8.0f * widthScale), (double)(8.0f * heightScale)).func_181675_d();
        bufferbuilder.func_181662_b(width * 0.5, -height * 0.5, 0.0).func_187315_a((double)(8.0f * widthScale), (double)(16.0f * heightScale)).func_181675_d();
        bufferbuilder.func_181662_b(-width * 0.5, -height * 0.5, 0.0).func_187315_a((double)(16.0f * widthScale), (double)(16.0f * heightScale)).func_181675_d();
        tessellator.func_78381_a();
        bufferbuilder.func_181668_a(7, DefaultVertexFormats.field_181707_g);
        bufferbuilder.func_181662_b(-width * 0.5 - growX, height * 0.5 + growY, 0.0).func_187315_a((double)(48.0f * widthScale), (double)(8.0f * heightScale)).func_181675_d();
        bufferbuilder.func_181662_b(width * 0.5 + growX, height * 0.5 + growY, 0.0).func_187315_a((double)(40.0f * widthScale), (double)(8.0f * heightScale)).func_181675_d();
        bufferbuilder.func_181662_b(width * 0.5 + growX, -height * 0.5 - growY, 0.0).func_187315_a((double)(40.0f * widthScale), (double)(16.0f * heightScale)).func_181675_d();
        bufferbuilder.func_181662_b(-width * 0.5 - growX, -height * 0.5 - growY, 0.0).func_187315_a((double)(48.0f * widthScale), (double)(16.0f * heightScale)).func_181675_d();
        tessellator.func_78381_a();
    }

    private void drawBullseye(double width, double height, double size) {
        this.mc.func_110434_K().func_110577_a(BULLSEYE);
        Tessellator tessellator = Tessellator.func_178181_a();
        BufferBuilder bufferbuilder = tessellator.func_178180_c();
        double growX = 0.0625 * width + 0.4 * size;
        double growY = 0.0625 * height + 0.4 * size;
        bufferbuilder.func_181668_a(7, DefaultVertexFormats.field_181707_g);
        bufferbuilder.func_181662_b(-width * 0.5 - growX, height * 0.5 + growY, 0.0).func_187315_a(1.0, 0.0).func_181675_d();
        bufferbuilder.func_181662_b(width * 0.5 + growX, height * 0.5 + growY, 0.0).func_187315_a(0.0, 0.0).func_181675_d();
        bufferbuilder.func_181662_b(width * 0.5 + growX, -height * 0.5 - growY, 0.0).func_187315_a(0.0, 1.0).func_181675_d();
        bufferbuilder.func_181662_b(-width * 0.5 - growX, -height * 0.5 - growY, 0.0).func_187315_a(1.0, 1.0).func_181675_d();
        tessellator.func_78381_a();
    }
}

