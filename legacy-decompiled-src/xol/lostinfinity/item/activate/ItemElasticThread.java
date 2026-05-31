/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.block.Block
 *  net.minecraft.client.util.ITooltipFlag
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.tileentity.BlockEntity
 *  net.minecraft.util.InteractionResultHolder
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.EnumParticleTypes
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.item.activate;

import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.world.level.block.Block;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.sounds.SoundSource;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.block.misc.BlockVoidVacuum;
import xol.lostinfinity.block.tileentity.BlockEntityVoidVacuum;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.classify.ICustomRaytrace;
import xol.lostinfinity.util.data.CustomHitResult;

public class ItemElasticThread
extends Item
implements ICustomRaytrace {
    public ItemElasticThread(String regName) {
        this.setRegistryName(regName);
        this.func_77655_b(regName);
        this.func_77637_a(TabsInit.TAB_AUXMATS);
        this.func_77625_d(1);
        ItemInit.ITEMS.add(this);
    }

    public InteractionResultHolder<ItemStack> func_77659_a(Level worldIn, Player playerIn, InteractionHand handIn) {
        ItemStack stack = playerIn.func_184586_b(handIn);
        if (!worldIn.field_72995_K) {
            CustomHitResult trace_result = this.standardFXTrace(worldIn, (LivingEntity)playerIn, 2, EnumParticleTypes.SMOKE_NORMAL, LivingEntity.class);
            if (!stack.func_77942_o()) {
                stack.func_77982_d(new CompoundTag());
            }
            if (trace_result != null && trace_result.getResultEntity() != null) {
                LivingEntity stuck = (LivingEntity)trace_result.getResultEntity();
                if (stack.func_77978_p().func_74764_b("VacX")) {
                    BlockPos vacPos = new BlockPos(stack.func_77978_p().func_74769_h("VacX"), stack.func_77978_p().func_74769_h("VacY"), stack.func_77978_p().func_74769_h("VacZ"));
                    BlockEntity tile_entity = worldIn.func_175625_s(vacPos);
                    Block result_block = worldIn.func_180495_p(vacPos).func_177230_c();
                    if (result_block instanceof BlockVoidVacuum && tile_entity != null && tile_entity instanceof BlockEntityVoidVacuum) {
                        worldIn.func_184133_a(null, stuck.func_180425_c(), SoundInit.GENERIC_BOING, SoundSource.BLOCKS, 1.5f, 1.0f);
                        worldIn.func_184133_a(null, vacPos, SoundInit.GENERIC_BOING, SoundSource.BLOCKS, 1.5f, 1.0f);
                        BlockEntityVoidVacuum vacuum = (BlockEntityVoidVacuum)tile_entity;
                        vacuum.setTarget(stuck);
                        vacuum.setActive(true);
                        vacuum.resetPulled();
                        playerIn.func_184611_a(handIn, ItemStack.field_190927_a);
                    }
                } else {
                    stack.func_77978_p().func_186854_a("PlayerID", stuck.func_110124_au());
                    playerIn.func_145747_a((Component)new Component((Object)((Object)TextFmt.Green) + "You have stuck one end of the thread to " + stuck.func_70005_c_()));
                }
            }
        }
        return super.func_77659_a(worldIn, playerIn, handIn);
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Green) + "A very elastic and sticky thread.");
    }
}

