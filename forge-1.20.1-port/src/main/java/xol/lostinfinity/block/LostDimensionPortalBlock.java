package xol.lostinfinity.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import xol.lostinfinity.dimension.LostDimensionTeleporter;

public class LostDimensionPortalBlock extends Block {
    private final String targetDimension;

    public LostDimensionPortalBlock(BlockBehaviour.Properties properties, String targetDimension) {
        super(properties);
        this.targetDimension = targetDimension;
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (!level.isClientSide() && player instanceof ServerPlayer serverPlayer) {
            LostDimensionTeleporter.teleport(serverPlayer, targetDimension);
        }
        return InteractionResult.sidedSuccess(level.isClientSide());
    }
}
