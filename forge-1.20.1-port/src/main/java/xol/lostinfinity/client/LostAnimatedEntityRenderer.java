package xol.lostinfinity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import java.util.Set;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class LostAnimatedEntityRenderer extends EntityRenderer<Entity> {
    private static final Set<String> SPIDERS = Set.of(
            "deviantspider", "deviantcavespider", "titanspider", "weaver", "tentacletrap", "scorpwing");
    private static final Set<String> FISH = Set.of(
            "longfin", "doublerang", "rayfish", "glowfish", "underfin", "eelshark", "ribshark", "crabulon",
            "leviathan", "sea_serpent", "torpedon", "whirlpool");
    private static final Set<String> FLYERS = Set.of(
            "deviantghast", "deviantevokervex", "deviantvex", "titanvex", "deviantskyworm", "deviantbat",
            "fungfly", "flapper", "giantflapper", "flashfly", "terrorfly", "skyre", "risingphantom",
            "spectre", "livorax", "galaxybeast", "galaxy_dragon", "cthulhu_cloud");
    private static final Set<String> CRYSTALS = Set.of(
            "galaxyspire", "laserspire", "trialobserver", "sentrycrystal", "atlascrystal", "deviantcrystal",
            "restorationcrystal", "essenceidol", "totemmoon", "totempylon", "cthulhu_turret", "celestial_statue");
    private static final Set<String> SLIMES = Set.of(
            "deviantslime", "deviantmagmacube", "titanmagmacube", "slimestrider", "deviantslimestrider",
            "gloop", "gloopmother", "glomite");
    private static final Set<String> QUADRUPEDS = Set.of(
            "deviantbear", "deviantcow", "deviantsheep", "devianthorse", "deviantpig", "deviantwolf",
            "deviant_wolf", "deviantocelote", "deviantmooshroom", "deviantllama", "titanllama", "doomdog",
            "rockslug", "giant_rockslug", "ravager", "ribrex", "chomper", "gnawer", "hypnosaur");

    public LostAnimatedEntityRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.shadowRadius = 0.45F;
    }

    @Override
    public void render(Entity entity, float yaw, float partialTick, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        String id = entity.getType().builtInRegistryHolder().key().location().getPath();
        if (!(entity instanceof LivingEntity) && !isProjectileLike(id)) {
            renderBillboard(entity, partialTick, poseStack, buffer, packedLight);
            super.render(entity, yaw, partialTick, poseStack, buffer, packedLight);
            return;
        }

        VertexConsumer vertices = buffer.getBuffer(RenderType.entityCutoutNoCull(getTextureLocation(entity)));
        poseStack.pushPose();
        poseStack.mulPose(Axis.YP.rotationDegrees(180.0F - yaw));
        float width = Math.max(0.4F, entity.getBbWidth());
        float height = Math.max(0.6F, entity.getBbHeight());
        float walk = entity.tickCount + partialTick;
        if (isProjectileLike(id)) {
            renderProjectileRig(poseStack, vertices, packedLight, width, height, walk, id);
        } else if (FISH.contains(id)) {
            renderFishRig(poseStack, vertices, packedLight, width, height, walk, id);
        } else if (SPIDERS.contains(id)) {
            renderSpiderRig(poseStack, vertices, packedLight, width, height, walk);
        } else if (FLYERS.contains(id) || id.contains("fly") || id.contains("wing")) {
            renderFlyingRig(poseStack, vertices, packedLight, width, height, walk, id);
        } else if (CRYSTALS.contains(id) || id.contains("spire") || id.contains("crystal") || id.contains("totem")) {
            renderCrystalRig(poseStack, vertices, packedLight, width, height, walk);
        } else if (SLIMES.contains(id) || id.contains("slime") || id.contains("gloop")) {
            renderSlimeRig(poseStack, vertices, packedLight, width, height, walk);
        } else if (QUADRUPEDS.contains(id)) {
            renderQuadrupedRig(poseStack, vertices, packedLight, width, height, walk);
        } else {
            renderHumanoidRig(poseStack, vertices, packedLight, width, height, walk, id);
        }
        poseStack.popPose();
        super.render(entity, yaw, partialTick, poseStack, buffer, packedLight);
    }

    private void renderHumanoidRig(PoseStack poseStack, VertexConsumer vertices, int light, float width, float height, float walk, String id) {
        float scale = Math.max(width / 0.9F, height / 2.0F);
        float armSwing = Mth.sin(walk * 0.35F) * 18.0F;
        poseStack.pushPose();
        poseStack.scale(scale, scale, scale);
        box(poseStack, vertices, light, 0.0F, 1.45F, 0.0F, 0.7F, 0.8F, 0.42F);
        box(poseStack, vertices, light, 0.0F, 2.05F, 0.0F, 0.48F, 0.48F, 0.48F);
        limb(poseStack, vertices, light, -0.47F, 1.45F, 0.0F, armSwing, 0.24F, 0.75F, 0.24F);
        limb(poseStack, vertices, light, 0.47F, 1.45F, 0.0F, -armSwing, 0.24F, 0.75F, 0.24F);
        limb(poseStack, vertices, light, -0.23F, 0.62F, 0.0F, -armSwing, 0.24F, 0.85F, 0.26F);
        limb(poseStack, vertices, light, 0.23F, 0.62F, 0.0F, armSwing, 0.24F, 0.85F, 0.26F);
        if (id.contains("titan") || id.contains("amalgam") || id.contains("golem")) {
            box(poseStack, vertices, light, 0.0F, 1.72F, -0.03F, 1.0F, 1.05F, 0.62F);
        }
        poseStack.popPose();
    }

    private void renderQuadrupedRig(PoseStack poseStack, VertexConsumer vertices, int light, float width, float height, float walk) {
        float scale = Math.max(width / 1.5F, height / 1.4F);
        float swing = Mth.sin(walk * 0.42F) * 16.0F;
        poseStack.pushPose();
        poseStack.scale(scale, scale, scale);
        box(poseStack, vertices, light, 0.0F, 0.85F, 0.0F, 1.35F, 0.72F, 0.72F);
        box(poseStack, vertices, light, 0.0F, 1.18F, -0.52F, 0.68F, 0.55F, 0.55F);
        limb(poseStack, vertices, light, -0.45F, 0.42F, -0.32F, swing, 0.22F, 0.75F, 0.22F);
        limb(poseStack, vertices, light, 0.45F, 0.42F, -0.32F, -swing, 0.22F, 0.75F, 0.22F);
        limb(poseStack, vertices, light, -0.45F, 0.42F, 0.32F, -swing, 0.22F, 0.75F, 0.22F);
        limb(poseStack, vertices, light, 0.45F, 0.42F, 0.32F, swing, 0.22F, 0.75F, 0.22F);
        poseStack.popPose();
    }

    private void renderSpiderRig(PoseStack poseStack, VertexConsumer vertices, int light, float width, float height, float walk) {
        float scale = Math.max(width / 2.3F, height / 0.9F);
        poseStack.pushPose();
        poseStack.scale(scale, scale, scale);
        box(poseStack, vertices, light, 0.0F, 0.75F, 0.1F, 1.25F, 0.55F, 1.05F);
        box(poseStack, vertices, light, 0.0F, 0.83F, -0.65F, 0.72F, 0.48F, 0.56F);
        for (int i = 0; i < 4; i++) {
            float z = -0.42F + i * 0.28F;
            float flap = Mth.sin(walk * 0.45F + i) * 20.0F;
            leg(poseStack, vertices, light, -0.68F, 0.72F, z, 55.0F + flap);
            leg(poseStack, vertices, light, 0.68F, 0.72F, z, -55.0F - flap);
        }
        poseStack.popPose();
    }

    private void renderFlyingRig(PoseStack poseStack, VertexConsumer vertices, int light, float width, float height, float walk, String id) {
        float scale = Math.max(width / 1.4F, height / 1.4F);
        float flap = Mth.sin(walk * 0.55F) * 32.0F;
        poseStack.pushPose();
        poseStack.scale(scale, scale, scale);
        box(poseStack, vertices, light, 0.0F, 0.95F, 0.0F, 0.9F, 0.9F, 0.72F);
        box(poseStack, vertices, light, 0.0F, 1.5F, -0.15F, 0.58F, 0.48F, 0.48F);
        wing(poseStack, vertices, light, -0.62F, 1.05F, 0.0F, 24.0F + flap);
        wing(poseStack, vertices, light, 0.62F, 1.05F, 0.0F, -24.0F - flap);
        if (id.contains("dragon") || id.contains("skyworm")) {
            box(poseStack, vertices, light, 0.0F, 0.75F, 0.85F, 0.45F, 0.35F, 1.2F);
        }
        poseStack.popPose();
    }

    private void renderFishRig(PoseStack poseStack, VertexConsumer vertices, int light, float width, float height, float walk, String id) {
        float scale = Math.max(width / 1.8F, height / 0.8F);
        float wave = Mth.sin(walk * 0.4F) * 18.0F;
        poseStack.pushPose();
        poseStack.scale(scale, scale, scale);
        box(poseStack, vertices, light, 0.0F, 0.8F, 0.0F, 1.25F, 0.55F, id.contains("serpent") || id.contains("leviathan") ? 1.8F : 0.9F);
        box(poseStack, vertices, light, 0.0F, 0.82F, -0.65F, 0.55F, 0.42F, 0.42F);
        tail(poseStack, vertices, light, 0.0F, 0.82F, 0.72F, wave);
        wing(poseStack, vertices, light, -0.72F, 0.84F, 0.0F, 68.0F);
        wing(poseStack, vertices, light, 0.72F, 0.84F, 0.0F, -68.0F);
        poseStack.popPose();
    }

    private void renderCrystalRig(PoseStack poseStack, VertexConsumer vertices, int light, float width, float height, float walk) {
        float scale = Math.max(width / 1.0F, height / 2.0F);
        poseStack.pushPose();
        poseStack.mulPose(Axis.YP.rotationDegrees(walk * 2.0F));
        poseStack.scale(scale, scale, scale);
        box(poseStack, vertices, light, 0.0F, 0.55F, 0.0F, 0.55F, 1.1F, 0.55F);
        box(poseStack, vertices, light, 0.0F, 1.35F, 0.0F, 0.9F, 0.45F, 0.9F);
        box(poseStack, vertices, light, 0.0F, 1.9F, 0.0F, 0.45F, 0.75F, 0.45F);
        poseStack.popPose();
    }

    private void renderSlimeRig(PoseStack poseStack, VertexConsumer vertices, int light, float width, float height, float walk) {
        float pulse = 1.0F + Mth.sin(walk * 0.25F) * 0.08F;
        poseStack.pushPose();
        poseStack.translate(0.0F, 0.04F * Mth.sin(walk * 0.25F), 0.0F);
        poseStack.scale(width * pulse, height * (2.0F - pulse), width * pulse);
        box(poseStack, vertices, light, 0.0F, 0.5F, 0.0F, 0.85F, 0.85F, 0.85F);
        poseStack.popPose();
    }

    private void renderProjectileRig(PoseStack poseStack, VertexConsumer vertices, int light, float width, float height, float walk, String id) {
        poseStack.pushPose();
        poseStack.mulPose(Axis.YP.rotationDegrees(walk * projectileSpin(id)));
        poseStack.mulPose(Axis.XP.rotationDegrees(walk * (id.contains("beam") || id.contains("laser") ? 0.0F : 12.0F)));
        float size = Math.max(0.18F, Math.max(width, height) * 0.8F);
        if (id.contains("laser") || id.contains("beam") || id.contains("bolt")) {
            box(poseStack, vertices, light, 0.0F, 0.15F, 0.0F, size * 0.42F, size * 0.42F, size * 2.8F);
            box(poseStack, vertices, light, 0.0F, 0.15F, 0.0F, size * 0.72F, size * 0.18F, size * 1.45F);
        } else if (id.contains("arrow") || id.contains("spear") || id.contains("trident") || id.contains("knife") || id.contains("slicer")) {
            box(poseStack, vertices, light, 0.0F, 0.15F, 0.0F, size * 0.35F, size * 0.35F, size * 2.15F);
            box(poseStack, vertices, light, 0.0F, 0.15F, size * 0.92F, size * 0.95F, size * 0.12F, size * 0.42F);
        } else if (id.contains("chain") || id.contains("grip") || id.contains("tether")) {
            for (int i = 0; i < 4; i++) {
                float offset = (i - 1.5F) * size * 0.44F;
                poseStack.pushPose();
                poseStack.translate(0.0F, 0.15F, offset);
                poseStack.mulPose(Axis.ZP.rotationDegrees(45.0F + walk * 8.0F));
                box(poseStack, vertices, light, 0.0F, 0.0F, 0.0F, size * 0.72F, size * 0.12F, size * 0.12F);
                box(poseStack, vertices, light, 0.0F, 0.0F, 0.0F, size * 0.12F, size * 0.72F, size * 0.12F);
                poseStack.popPose();
            }
        } else if (id.contains("meteor") || id.contains("comet") || id.contains("asteroid")) {
            box(poseStack, vertices, light, 0.0F, 0.15F, 0.0F, size * 1.25F, size * 1.25F, size * 1.25F);
            box(poseStack, vertices, light, 0.0F, 0.15F, size * 0.85F, size * 0.55F, size * 0.55F, size * 1.6F);
        } else if (id.contains("portal") || id.contains("rift") || id.contains("whirlpool")) {
            poseStack.mulPose(Axis.ZP.rotationDegrees(walk * 9.0F));
            box(poseStack, vertices, light, 0.0F, 0.15F, 0.0F, size * 1.4F, size * 0.16F, size * 1.4F);
            box(poseStack, vertices, light, 0.0F, 0.15F, 0.0F, size * 0.16F, size * 1.4F, size * 1.4F);
        } else if (id.contains("sonic") || id.contains("soundwave") || id.contains("echo")) {
            for (int i = 0; i < 3; i++) {
                float ring = size * (0.55F + i * 0.34F);
                box(poseStack, vertices, light, 0.0F, 0.15F, i * size * 0.24F, ring, size * 0.10F, ring);
            }
        } else {
            box(poseStack, vertices, light, 0.0F, 0.15F, 0.0F, size, size, size);
            if (id.contains("orb") || id.contains("star") || id.contains("galaxy") || id.contains("cosmic")) {
                poseStack.mulPose(Axis.ZP.rotationDegrees(45.0F));
                box(poseStack, vertices, light, 0.0F, 0.15F, 0.0F, size * 1.35F, size * 0.18F, size * 1.35F);
            }
        }
        poseStack.popPose();
    }

    private static float projectileSpin(String id) {
        if (id.contains("laser") || id.contains("beam")) {
            return 0.0F;
        }
        if (id.contains("portal") || id.contains("rift") || id.contains("orb") || id.contains("star")) {
            return 30.0F;
        }
        if (id.contains("arrow") || id.contains("knife") || id.contains("spear") || id.contains("trident")) {
            return 7.0F;
        }
        return 18.0F;
    }

    private void renderBillboard(Entity entity, float partialTick, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        VertexConsumer vertices = buffer.getBuffer(RenderType.entityCutoutNoCull(getTextureLocation(entity)));
        poseStack.pushPose();
        poseStack.translate(0.0D, 0.9D, 0.0D);
        poseStack.mulPose(this.entityRenderDispatcher.cameraOrientation());
        poseStack.mulPose(Axis.YP.rotationDegrees(180.0F));
        poseStack.scale(1.2F, 1.2F, 1.2F);
        PoseStack.Pose pose = poseStack.last();
        quad(vertices, pose, -0.5F, -0.5F, 0.5F, 0.5F, packedLight);
        poseStack.popPose();
    }

    private void limb(PoseStack poseStack, VertexConsumer vertices, int light, float x, float y, float z, float rotX, float sx, float sy, float sz) {
        poseStack.pushPose();
        poseStack.translate(x, y, z);
        poseStack.mulPose(Axis.XP.rotationDegrees(rotX));
        box(poseStack, vertices, light, 0.0F, -sy * 0.5F, 0.0F, sx, sy, sz);
        poseStack.popPose();
    }

    private void leg(PoseStack poseStack, VertexConsumer vertices, int light, float x, float y, float z, float rotZ) {
        poseStack.pushPose();
        poseStack.translate(x, y, z);
        poseStack.mulPose(Axis.ZP.rotationDegrees(rotZ));
        box(poseStack, vertices, light, 0.0F, 0.0F, 0.0F, 1.0F, 0.14F, 0.14F);
        poseStack.popPose();
    }

    private void wing(PoseStack poseStack, VertexConsumer vertices, int light, float x, float y, float z, float rotZ) {
        poseStack.pushPose();
        poseStack.translate(x, y, z);
        poseStack.mulPose(Axis.ZP.rotationDegrees(rotZ));
        box(poseStack, vertices, light, 0.0F, 0.0F, 0.0F, 0.9F, 0.08F, 0.55F);
        poseStack.popPose();
    }

    private void tail(PoseStack poseStack, VertexConsumer vertices, int light, float x, float y, float z, float rotY) {
        poseStack.pushPose();
        poseStack.translate(x, y, z);
        poseStack.mulPose(Axis.YP.rotationDegrees(rotY));
        box(poseStack, vertices, light, 0.0F, 0.0F, 0.0F, 0.55F, 0.45F, 0.16F);
        poseStack.popPose();
    }

    private static boolean isProjectileLike(String id) {
        return id.contains("shot") || id.contains("bullet") || id.contains("blast") || id.contains("bomb")
                || id.contains("laser") || id.contains("orb") || id.contains("meteor") || id.contains("pellet")
                || id.contains("arrow") || id.contains("bolt") || id.contains("beam") || id.contains("projectile")
                || id.contains("fireball") || id.contains("skull") || id.contains("missile");
    }

    private static void box(PoseStack poseStack, VertexConsumer vertices, int light, float cx, float cy, float cz, float sx, float sy, float sz) {
        float x0 = cx - sx * 0.5F;
        float x1 = cx + sx * 0.5F;
        float y0 = cy - sy * 0.5F;
        float y1 = cy + sy * 0.5F;
        float z0 = cz - sz * 0.5F;
        float z1 = cz + sz * 0.5F;
        PoseStack.Pose pose = poseStack.last();
        face(vertices, pose, x0, y0, z1, x1, y1, z1, 0.0F, 0.0F, 1.0F, light);
        face(vertices, pose, x1, y0, z0, x0, y1, z0, 0.0F, 0.0F, -1.0F, light);
        face(vertices, pose, x1, y0, z1, x1, y1, z0, 1.0F, 0.0F, 0.0F, light);
        face(vertices, pose, x0, y0, z0, x0, y1, z1, -1.0F, 0.0F, 0.0F, light);
        face(vertices, pose, x0, y1, z1, x1, y1, z0, 0.0F, 1.0F, 0.0F, light);
        face(vertices, pose, x0, y0, z0, x1, y0, z1, 0.0F, -1.0F, 0.0F, light);
    }

    private static void face(VertexConsumer vertices, PoseStack.Pose pose, float x0, float y0, float z0, float x1, float y1, float z1,
            float nx, float ny, float nz, int light) {
        vertex(vertices, pose, x0, y0, z0, 0.0F, 1.0F, nx, ny, nz, light);
        vertex(vertices, pose, x1, y0, z0, 1.0F, 1.0F, nx, ny, nz, light);
        vertex(vertices, pose, x1, y1, z1, 1.0F, 0.0F, nx, ny, nz, light);
        vertex(vertices, pose, x0, y1, z1, 0.0F, 0.0F, nx, ny, nz, light);
    }

    private static void quad(VertexConsumer vertices, PoseStack.Pose pose, float x0, float y0, float x1, float y1, int light) {
        vertex(vertices, pose, x0, y0, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F, 0.0F, light);
        vertex(vertices, pose, x1, y0, 0.0F, 1.0F, 1.0F, 0.0F, 1.0F, 0.0F, light);
        vertex(vertices, pose, x1, y1, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, light);
        vertex(vertices, pose, x0, y1, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, light);
    }

    private static void vertex(VertexConsumer vertices, PoseStack.Pose pose, float x, float y, float z, float u, float v,
            float nx, float ny, float nz, int light) {
        vertices.vertex(pose.pose(), x, y, z)
                .color(255, 255, 255, 255)
                .uv(u, v)
                .overlayCoords(OverlayTexture.NO_OVERLAY)
                .uv2(light)
                .normal(pose.normal(), nx, ny, nz)
                .endVertex();
    }

    @Override
    public ResourceLocation getTextureLocation(Entity entity) {
        return LostEntityTextures.textureFor(entity);
    }
}
