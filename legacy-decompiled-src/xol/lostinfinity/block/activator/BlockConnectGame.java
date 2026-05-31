/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.SoundType
 *  net.minecraft.block.material.Material
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.item.Item
 *  net.minecraft.item.BlockItem
 *  net.minecraft.util.Direction
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.EnumParticleTypes
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 *  net.minecraft.world.ServerLevel
 */
package xol.lostinfinity.block.activator;

import java.util.Random;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.server.level.ServerLevel;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.mob.entity.misc.EntityConnectGameMerchant;

public class BlockConnectGame
extends Block {
    private boolean hard_mode = false;

    public BlockConnectGame(String name, boolean hard) {
        super(Material.field_151573_f);
        this.func_149663_c(name);
        this.setRegistryName(name);
        this.func_149711_c(3.0f);
        this.func_149647_a(TabsInit.TAB_BLOCKS);
        this.func_149672_a(SoundType.field_185851_d);
        this.func_149715_a(1.0f);
        this.hard_mode = hard;
        BlockInit.BLOCKS.add(this);
        ItemInit.ITEMS.add((Item)new BlockItem((Block)this).setRegistryName(this.getRegistryName()));
    }

    private boolean validInput(Item item) {
        return item.equals(ItemInit.frostedLog);
    }

    public boolean func_180639_a(Level worldIn, BlockPos pos, BlockState state, Player playerIn, InteractionHand hand, Direction facing, float hitX, float hitY, float hitZ) {
        if (!playerIn.func_70093_af() && this.validInput(playerIn.func_184586_b(hand).func_77973_b())) {
            if (!worldIn.field_72995_K) {
                Random rand = worldIn.field_73012_v;
                AABB checkBox = new AABB(pos.func_177982_a(-10, -10, -10), pos.func_177982_a(10, 10, 10));
                for (EntityConnectGameMerchant merch : worldIn.func_72872_a(EntityConnectGameMerchant.class, checkBox)) {
                    merch.clearTokens();
                    merch.func_70106_y();
                }
                worldIn.func_184133_a(null, pos, SoundEvents.field_187620_cL, SoundSource.MASTER, 1.0f, 1.0f);
                EntityConnectGameMerchant newMerchant = new EntityConnectGameMerchant(worldIn);
                newMerchant.func_70107_b(pos.func_177958_n(), (double)pos.func_177956_o() + 1.5, pos.func_177952_p());
                ((ServerLevel)worldIn).func_175739_a(EnumParticleTypes.PORTAL, newMerchant.field_70165_t, newMerchant.field_70163_u, newMerchant.field_70161_v, 8, (-0.5 + rand.nextDouble()) * 3.0, 0.3, (-0.5 + rand.nextDouble()) * 3.0, (double)0.15f, new int[0]);
                newMerchant.setButtonPositions(pos, 8, 8, 4);
                newMerchant.clearTokens();
                worldIn.func_72838_d((Entity)newMerchant);
            }
            playerIn.func_184586_b(hand).func_190918_g(1);
        }
        return true;
    }
}

