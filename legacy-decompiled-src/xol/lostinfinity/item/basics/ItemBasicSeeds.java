/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.advancements.CriteriaTriggers
 *  net.minecraft.block.Block
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.client.util.ITooltipFlag
 *  net.minecraft.entity.player.Player
 *  net.minecraft.entity.player.ServerPlayer
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.EnumInteractionResultHolder
 *  net.minecraft.util.Direction
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.IBlockAccess
 *  net.minecraft.world.World
 *  net.minecraftforge.common.EnumPlantType
 *  net.minecraftforge.common.IPlantable
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.item.basics;

import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.world.entity.player.Player;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.util.EnumInteractionResultHolder;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.core.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.basics.ItemBasic;

public class ItemBasicSeeds
extends ItemBasic
implements IPlantable {
    Block cropBlock = null;
    Block soilBlock = null;
    private String customDescription = "";

    public ItemBasicSeeds(String name) {
        super(name, TabsInit.TAB_AUXMATS);
    }

    public void setDescription(String string) {
        this.customDescription = string;
    }

    public void setCropAndSoil(Block b1, Block b2) {
        this.cropBlock = b1;
        this.soilBlock = b2;
    }

    public EnumInteractionResultHolder func_180614_a(Player player, Level worldIn, BlockPos pos, InteractionHand hand, Direction facing, float hitX, float hitY, float hitZ) {
        ItemStack itemstack = player.func_184586_b(hand);
        BlockState state = worldIn.func_180495_p(pos);
        if (facing == Direction.UP && player.func_175151_a(pos.func_177972_a(facing), facing, itemstack) && state.func_177230_c() == this.soilBlock && worldIn.func_175623_d(pos.func_177984_a())) {
            worldIn.func_175656_a(pos.func_177984_a(), this.cropBlock.func_176223_P());
            if (player instanceof ServerPlayer) {
                CriteriaTriggers.field_193137_x.func_193173_a((ServerPlayer)player, pos.func_177984_a(), itemstack);
            }
            itemstack.func_190918_g(1);
            return EnumInteractionResultHolder.SUCCESS;
        }
        return EnumInteractionResultHolder.FAIL;
    }

    public EnumPlantType getPlantType(IBlockAccess world, BlockPos pos) {
        return EnumPlantType.Crop;
    }

    public BlockState getPlant(IBlockAccess world, BlockPos pos) {
        return this.cropBlock.func_176223_P();
    }

    public Block getSoilBlock() {
        return this.soilBlock;
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        if (this.customDescription.isEmpty()) {
            tooltip.add((Object)((Object)TextFmt.Italic) + "These seem like they will be very difficult to plant.");
        } else {
            tooltip.add(this.customDescription);
        }
    }
}

