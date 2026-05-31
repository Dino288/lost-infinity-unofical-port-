package xol.lostinfinity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import xol.lostinfinity.LostInfinity;
import xol.lostinfinity.registry.ModItems;

public class LostPlaceholderEntityRenderer extends EntityRenderer<Entity> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(LostInfinity.MODID, "textures/items/xerovium_ingot.png");
    private final ItemRenderer itemRenderer;

    public LostPlaceholderEntityRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.itemRenderer = context.getItemRenderer();
    }

    @Override
    public void render(Entity entity, float yaw, float partialTick, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        poseStack.pushPose();
        poseStack.translate(0.0D, 0.25D, 0.0D);
        poseStack.scale(0.9F, 0.9F, 0.9F);
        ItemStack stack = ModItems.ALL_ITEMS.get(0).get().getDefaultInstance();
        this.itemRenderer.renderStatic(stack, ItemDisplayContext.GROUND, packedLight, 0, poseStack, buffer, entity.level(), entity.getId());
        poseStack.popPose();
        super.render(entity, yaw, partialTick, poseStack, buffer, packedLight);
    }

    @Override
    public ResourceLocation getTextureLocation(Entity entity) {
        return TEXTURE;
    }
}
