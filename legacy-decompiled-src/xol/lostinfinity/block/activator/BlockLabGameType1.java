/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.material.Material
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.Item
 *  net.minecraft.util.Direction
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraft.world.World
 */
package xol.lostinfinity.block.activator;

import net.minecraft.block.material.Material;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import xol.lostinfinity.block.basic.BlockBasic;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.entity.labyrinth.EntityAspect;

public class BlockLabGameType1
extends BlockBasic {
    public BlockLabGameType1(String name) {
        super(name, Material.field_151576_e);
    }

    public boolean func_180639_a(Level worldIn, BlockPos pos, BlockState state, Player playerIn, InteractionHand hand, Direction facing, float hitX, float hitY, float hitZ) {
        Item mapItem;
        if (!playerIn.func_70093_af() && !playerIn.func_184586_b(hand).func_190926_b() && (mapItem = this.canStartGame(playerIn.func_184586_b(hand).func_77973_b())) != null) {
            if (!worldIn.field_72995_K) {
                EntityAspect aspect = new EntityAspect(worldIn);
                aspect.func_70107_b(pos.func_177958_n(), (double)pos.func_177956_o() + 9.0, pos.func_177952_p());
                aspect.setMapDrop(mapItem);
                worldIn.func_72838_d((Entity)aspect);
            } else {
                playerIn.func_145747_a((Component)new Component((Object)((Object)TextFmt.Dark_Aqua) + "The Echo: So you wish to play a game " + playerIn.func_70005_c_() + "?"));
                playerIn.func_145747_a((Component)new Component((Object)((Object)TextFmt.Gray) + "You have 2 minutes to kill the aspect above you."));
            }
            worldIn.func_184134_a(playerIn.field_70165_t, playerIn.field_70163_u, playerIn.field_70161_v, SoundInit.LAB_GAME_BEGIN, SoundSource.MASTER, 2.0f, 1.0f, false);
            playerIn.func_184586_b(hand).func_190918_g(1);
        }
        return true;
    }

    private Item canStartGame(Item held) {
        if (held.equals(ItemInit.deviantString)) {
            return ItemInit.ingenuityMap;
        }
        if (held.equals(ItemInit.perfectPearl)) {
            return ItemInit.dualityMap;
        }
        if (held.equals(ItemInit.deviantGunpowder)) {
            return ItemInit.corruptionMap;
        }
        if (held.equals(ItemInit.deviantBearHide)) {
            return ItemInit.aspirationMap;
        }
        if (held.equals(ItemInit.reflectiveShard)) {
            return ItemInit.misdirectionMap;
        }
        if (held.equals(ItemInit.deviantGhastTear)) {
            return ItemInit.vengeanceMap;
        }
        return null;
    }
}

