/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.material.Material
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.item.ItemEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.init.Blocks
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.Direction
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3i
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraft.world.World
 */
package xol.lostinfinity.block.activator;

import net.minecraft.block.material.Material;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import xol.lostinfinity.block.basic.BlockBasic;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.ItemInit;

public class BlockStarforgeInput
extends BlockBasic {
    public BlockStarforgeInput(String name) {
        super(name, Material.field_151576_e);
    }

    public boolean func_180639_a(Level worldIn, BlockPos pos, BlockState state, Player playerIn, InteractionHand hand, Direction facing, float hitX, float hitY, float hitZ) {
        if (!playerIn.func_70093_af()) {
            int xpos = 13;
            int freeX = 0;
            boolean freespot = false;
            for (xpos = 13; xpos <= 15; ++xpos) {
                BlockPos checkPos = new BlockPos((Vec3i)pos.func_177982_a(xpos, 9, -5));
                BlockState checkState = worldIn.func_180495_p(checkPos);
                if (!checkState.func_177230_c().equals(Blocks.field_150356_k) && !checkState.func_177230_c().equals(Blocks.field_150353_l)) continue;
                freespot = true;
                freeX = xpos;
            }
            if (freespot) {
                Item resultFromHeld = this.returnItem(playerIn.func_184586_b(hand).func_77973_b());
                if (resultFromHeld != null) {
                    worldIn.func_184133_a(null, pos, SoundEvents.field_187652_bv, SoundSource.MASTER, 2.0f, worldIn.field_73012_v.nextFloat() + 0.5f);
                    if (!worldIn.field_72995_K) {
                        BlockPos dropPos = new BlockPos((Vec3i)pos.func_177963_a(6.5, 4.0, -6.0));
                        ItemEntity dropIngot = new ItemEntity(worldIn, (double)dropPos.func_177958_n(), (double)dropPos.func_177956_o(), (double)dropPos.func_177952_p(), new ItemStack(resultFromHeld));
                        dropIngot.field_70159_w = 0.0;
                        dropIngot.field_70181_x = 0.0;
                        dropIngot.field_70179_y = 0.0;
                        worldIn.func_72838_d((Entity)dropIngot);
                        if (worldIn.field_73012_v.nextInt(8) == 0) {
                            worldIn.func_175656_a(pos.func_177982_a(freeX, 9, -5), BlockInit.slagDeposit.func_176223_P());
                        }
                    }
                    playerIn.func_184586_b(hand).func_190918_g(1);
                }
            } else if (!worldIn.field_72995_K) {
                playerIn.func_145747_a((Component)new Component((Object)((Object)TextFmt.Red) + "The forge is clogged. Clear it out with carbonic acid."));
            }
        }
        return true;
    }

    private Item returnItem(Item held) {
        if (held.equals(ItemInit.emberium)) {
            return ItemInit.emberiumIngot;
        }
        if (held.equals(ItemInit.noxerium)) {
            return ItemInit.noxeriumIngot;
        }
        if (held.equals(ItemInit.incadium)) {
            return ItemInit.incadiumIngot;
        }
        if (held.equals(ItemInit.hextorium)) {
            return ItemInit.hextoriumIngot;
        }
        if (held.equals(ItemInit.kylaxium)) {
            return ItemInit.kylaxiumIngot;
        }
        if (held.equals(ItemInit.vellorium)) {
            return ItemInit.velloriumIngot;
        }
        if (held.equals(ItemInit.xerovium)) {
            return ItemInit.xeroviumIngot;
        }
        if (held.equals(ItemInit.phytrosium)) {
            return ItemInit.phytrosiumIngot;
        }
        if (held.equals(ItemInit.detherium)) {
            return ItemInit.detheriumIngot;
        }
        if (held.equals(ItemInit.olysium)) {
            return ItemInit.olysiumIngot;
        }
        if (held.equals(ItemInit.astrallium)) {
            return ItemInit.astralliumIngot;
        }
        if (held.equals(ItemInit.crystonium)) {
            return ItemInit.crystoniumIngot;
        }
        return null;
    }
}

