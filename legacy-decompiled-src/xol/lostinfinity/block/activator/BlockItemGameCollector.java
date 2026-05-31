/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.SoundType
 *  net.minecraft.block.material.Material
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.item.ItemEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.Item
 *  net.minecraft.item.BlockItem
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.util.Direction
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 */
package xol.lostinfinity.block.activator;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.init.TabsInit;

public class BlockItemGameCollector
extends Block {
    public BlockItemGameCollector(String name) {
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
        if (!worldIn.field_72995_K) {
            int crates = 0;
            for (int x = -4; x <= 4; ++x) {
                for (int z = -4; z <= 4; ++z) {
                    if (worldIn.func_180495_p(pos.func_177982_a(x, 3, z)).func_177230_c() != BlockInit.labyrinthLamp || worldIn.func_180495_p(pos.func_177982_a(x, 2, z)).func_177230_c() != BlockInit.itemChallengeCrate) continue;
                    ++crates;
                }
            }
            ItemStack held = playerIn.func_184614_ca();
            Item resultFromHold = this.resultMap(held.func_77973_b());
            if (crates == 4 && resultFromHold != null) {
                held.func_190918_g(1);
                ItemStack mapstack = new ItemStack(resultFromHold);
                mapstack.func_77982_d(new CompoundTag());
                mapstack.func_77978_p().func_74768_a("MapEntityType", worldIn.field_73012_v.nextInt(8));
                mapstack.func_77978_p().func_74768_a("MapEntityNum", 2 + worldIn.field_73012_v.nextInt(4));
                ItemEntity geoloc = new ItemEntity(worldIn, playerIn.field_70165_t, playerIn.field_70163_u, playerIn.field_70161_v, mapstack);
                geoloc.field_70159_w = 0.0;
                geoloc.field_70181_x = 0.0;
                geoloc.field_70179_y = 0.0;
                worldIn.func_72838_d((Entity)geoloc);
            }
            worldIn.func_184133_a(null, pos, SoundInit.MACHINE_CRAFT, SoundSource.MASTER, 1.0f, 1.0f);
        }
        return true;
    }

    private Item resultMap(Item held) {
        if (held == ItemInit.webbedIdol) {
            return ItemInit.ambitionMap;
        }
        if (held == ItemInit.conductiveBar) {
            return ItemInit.anticipationMap;
        }
        if (held == ItemInit.frostedLog) {
            return ItemInit.resolveMap;
        }
        if (held == ItemInit.relicOfTheMirage) {
            return ItemInit.perceptionMap;
        }
        if (held == ItemInit.jarOfBlood) {
            return ItemInit.crueltyMap;
        }
        return null;
    }
}

