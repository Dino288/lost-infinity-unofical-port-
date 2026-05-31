/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.material.Material
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.Mob
 *  net.minecraft.entity.boss.EntityWither
 *  net.minecraft.entity.monster.EntityEvoker
 *  net.minecraft.entity.player.Player
 *  net.minecraft.init.Items
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.Direction
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraft.world.World
 */
package xol.lostinfinity.block.activator;

import net.minecraft.block.material.Material;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.monster.EntityEvoker;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import xol.lostinfinity.block.basic.BlockBasic;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.SoundInit;

public class BlockDeviationField
extends BlockBasic {
    public BlockDeviationField(String name) {
        super(name, Material.field_151576_e);
    }

    public boolean func_180639_a(Level worldIn, BlockPos pos, BlockState state, Player playerIn, InteractionHand hand, Direction facing, float hitX, float hitY, float hitZ) {
        if (!playerIn.func_70093_af()) {
            ItemStack heldstack = playerIn.func_184586_b(hand);
            if (heldstack.func_77973_b() == Items.field_151156_bN) {
                if (!worldIn.field_72995_K) {
                    for (Mob mob_die : worldIn.func_72872_a(Mob.class, this.getArenaAABB())) {
                        mob_die.func_70106_y();
                    }
                    EntityWither wither = new EntityWither(worldIn);
                    wither.func_70107_b(985.5, 63.0, 890.0);
                    worldIn.func_72838_d((Entity)wither);
                    playerIn.func_70634_a(985.5, 62.0, 906.0);
                    playerIn.func_145747_a((Component)new Component(TextFmt.getFormatting(TextFmt.Italic, TextFmt.Aqua) + "Looming Voice: A wither has been released. Deviate it, and show me what you are made of " + playerIn.func_70005_c_()));
                }
                heldstack.func_190918_g(1);
            } else if (heldstack.func_77973_b().equals(ItemInit.arenaCard)) {
                playerIn.func_184185_a(SoundInit.ARENA_TELEPORT, 3.0f, 1.0f);
                heldstack.func_190918_g(1);
                if (!worldIn.field_72995_K) {
                    playerIn.func_70634_a(985.5, 62.0, 927.0);
                }
            } else if (heldstack.func_77973_b().equals(Items.field_190929_cY)) {
                if (!worldIn.field_72995_K) {
                    for (Mob mob_die : worldIn.func_72872_a(Mob.class, this.getArenaAABB())) {
                        mob_die.func_70106_y();
                    }
                    EntityEvoker evoker = new EntityEvoker(worldIn);
                    evoker.func_70107_b(985.5, 63.0, 890.0);
                    worldIn.func_72838_d((Entity)evoker);
                    playerIn.func_70634_a(985.5, 62.0, 906.0);
                    playerIn.func_145747_a((Component)new Component(TextFmt.getFormatting(TextFmt.Italic, TextFmt.Aqua) + "Looming Voice: An evoker has been released. Deviate it, and show me what you are made of " + playerIn.func_70005_c_()));
                }
                heldstack.func_190918_g(1);
            }
        }
        return true;
    }

    private AABB getArenaAABB() {
        return new AABB(new BlockPos(958.0, 60.0, 877.0), new BlockPos(1012.0, 82.0, 924.0));
    }
}

