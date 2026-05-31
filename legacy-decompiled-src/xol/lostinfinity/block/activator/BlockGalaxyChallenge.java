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
 *  net.minecraft.item.Item
 *  net.minecraft.item.BlockItem
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.Direction
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 */
package xol.lostinfinity.block.activator;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.mob.entity.starforge.EntityGalacticTerror;
import xol.lostinfinity.util.coordinates.GalaxyCoordinates;

public class BlockGalaxyChallenge
extends Block {
    public BlockGalaxyChallenge(String name) {
        super(Material.field_151573_f);
        this.func_149663_c(name);
        this.setRegistryName(name);
        this.func_149711_c(3.0f);
        this.func_149647_a(TabsInit.TAB_BLOCKS);
        this.func_149672_a(SoundType.field_185851_d);
        this.func_149715_a(1.0f);
        BlockInit.BLOCKS.add(this);
        ItemInit.ITEMS.add((Item)new BlockItem((Block)this).setRegistryName(this.getRegistryName()));
    }

    public boolean func_180639_a(Level worldIn, BlockPos pos, BlockState state, Player playerIn, InteractionHand hand, Direction facing, float hitX, float hitY, float hitZ) {
        ItemStack stack;
        if (!playerIn.func_70093_af() && (stack = playerIn.func_184586_b(hand)).func_77973_b() == ItemInit.galacticChallengeEmblem) {
            if (!worldIn.field_72995_K) {
                AABB teleport = GalaxyCoordinates.getShockArenaAABB();
                playerIn.func_70634_a(teleport.field_72340_a + 6.0, teleport.field_72338_b + 2.0, teleport.field_72339_c + 6.0);
                EntityGalacticTerror terror = new EntityGalacticTerror(worldIn);
                terror.func_70107_b(teleport.field_72336_d - 6.0, teleport.field_72338_b + 3.0, teleport.field_72334_f - 6.0);
                worldIn.func_72838_d((Entity)terror);
            }
            stack.func_190918_g(1);
        }
        return true;
    }
}

