/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraft.world.World
 */
package xol.lostinfinity.block.harvest;

import java.util.Random;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import xol.lostinfinity.block.basic.BlockBasic;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.ItemInit;

public class BlockIgneousPearlOre
extends BlockBasic {
    public BlockIgneousPearlOre(String name) {
        super(name);
        this.func_149711_c(3.0f);
        this.func_149752_b(5.0f);
    }

    public Item func_180660_a(BlockState state, Random rand, int fortune) {
        return ItemStack.field_190927_a.func_77973_b();
    }

    public void func_176206_d(Level worldIn, BlockPos pos, BlockState state) {
        Player player;
        if (!worldIn.field_72995_K && (player = worldIn.func_184137_a((double)pos.func_177958_n(), (double)pos.func_177956_o(), (double)pos.func_177952_p(), 3.0, false)) != null) {
            boolean found = false;
            for (int i = 0; i < player.field_71071_by.func_70302_i_(); ++i) {
                ItemStack playerStack = player.field_71071_by.func_70301_a(i);
                if (playerStack.func_77973_b() != ItemInit.pearlIgneous) continue;
                found = true;
                break;
            }
            if (found) {
                player.func_145747_a((Component)new Component((Object)((Object)TextFmt.Red) + "A strange magical property in the pearl prevents you from collecting another."));
            } else {
                player.func_191521_c(new ItemStack(ItemInit.pearlIgneous));
            }
        }
    }
}

