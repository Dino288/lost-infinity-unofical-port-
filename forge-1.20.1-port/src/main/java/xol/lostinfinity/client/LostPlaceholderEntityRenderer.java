package xol.lostinfinity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class LostPlaceholderEntityRenderer extends EntityRenderer<Entity> {
    public LostPlaceholderEntityRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public void render(Entity entity, float yaw, float partialTick, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        ResourceLocation texture = getTextureLocation(entity);
        VertexConsumer vertices = buffer.getBuffer(RenderType.entityCutoutNoCull(texture));
        poseStack.pushPose();
        poseStack.translate(0.0D, 0.9D, 0.0D);
        poseStack.mulPose(this.entityRenderDispatcher.cameraOrientation());
        poseStack.mulPose(Axis.YP.rotationDegrees(180.0F));
        poseStack.scale(1.2F, 1.2F, 1.2F);
        PoseStack.Pose pose = poseStack.last();
        vertex(vertices, pose, -0.5F, -0.5F, 0.0F, 1.0F, packedLight);
        vertex(vertices, pose, 0.5F, -0.5F, 1.0F, 1.0F, packedLight);
        vertex(vertices, pose, 0.5F, 0.5F, 1.0F, 0.0F, packedLight);
        vertex(vertices, pose, -0.5F, 0.5F, 0.0F, 0.0F, packedLight);
        poseStack.popPose();
        super.render(entity, yaw, partialTick, poseStack, buffer, packedLight);
    }

    private static void vertex(VertexConsumer vertices, PoseStack.Pose pose, float x, float y, float u, float v, int packedLight) {
        vertices.vertex(pose.pose(), x, y, 0.0F)
                .color(255, 255, 255, 255)
                .uv(u, v)
                .overlayCoords(OverlayTexture.NO_OVERLAY)
                .uv2(packedLight)
                .normal(pose.normal(), 0.0F, 1.0F, 0.0F)
                .endVertex();
    }

    @Override
    public ResourceLocation getTextureLocation(Entity entity) {
        return LostEntityTextures.textureFor(entity);
    }
}
