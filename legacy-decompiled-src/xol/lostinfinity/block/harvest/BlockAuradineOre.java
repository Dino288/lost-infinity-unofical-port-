/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.properties.Property
 *  net.minecraft.block.properties.IntegerProperty
 *  net.minecraft.block.state.StateDefinition
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.Direction
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 */
package xol.lostinfinity.block.harvest;

import java.util.Random;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import xol.lostinfinity.block.basic.BlockBasic;
import xol.lostinfinity.block.basic.ISpecialHarvest;
import xol.lostinfinity.init.ItemInit;

public class BlockAuradineOre
extends BlockBasic
implements ISpecialHarvest {
    public static final IntegerProperty AMOUNT = IntegerProperty.func_177719_a((String)"amount", (int)0, (int)4);

    public BlockAuradineOre(String name) {
        super(name);
        this.func_149675_a(true);
    }

    public BlockState func_180642_a(Level worldIn, BlockPos pos, Direction facing, float hitX, float hitY, float hitZ, int meta, LivingEntity placer) {
        return this.func_176223_P().func_177226_a((Property)AMOUNT, (Comparable)Integer.valueOf(0));
    }

    public BlockState func_176203_a(int meta) {
        return this.func_176223_P().func_177226_a((Property)AMOUNT, (Comparable)Integer.valueOf(meta));
    }

    public int func_176201_c(BlockState state) {
        return (Integer)state.func_177229_b((Property)AMOUNT);
    }

    protected StateDefinition func_180661_e() {
        return new StateDefinition((Block)this, new Property[]{AMOUNT});
    }

    public boolean func_180639_a(Level worldIn, BlockPos pos, BlockState state, Player playerIn, InteractionHand hand, Direction facing, float hitX, float hitY, float hitZ) {
        ItemStack held = playerIn.func_184586_b(hand);
        if (held.func_77973_b() == ItemInit.chlorodivergentSolution) {
            int oreValue = this.func_176201_c(state);
            if (oreValue < 4 && !worldIn.field_72995_K) {
                Iterable nearblocks = BlockPos.func_177980_a((BlockPos)pos.func_177982_a(-7, -7, -7), (BlockPos)pos.func_177982_a(7, 7, 7));
                BlockPos nearestPos = null;
                for (BlockPos nearpos : nearblocks) {
                    BlockState nearState = worldIn.func_180495_p(nearpos);
                    if (!(nearState.func_177230_c() instanceof BlockAuradineOre)) continue;
                    int nearValue = this.func_176201_c(nearState);
                    if (nearpos.equals((Object)pos) || nearValue != oreValue || nearestPos != null && !(pos.func_185332_f(nearpos.func_177958_n(), nearpos.func_177956_o(), nearpos.func_177952_p()) < pos.func_185332_f(nearestPos.func_177958_n(), nearestPos.func_177956_o(), nearestPos.func_177952_p()))) continue;
                    nearestPos = nearpos;
                }
                if (nearestPos != null) {
                    worldIn.func_175656_a(nearestPos, this.func_176203_a(oreValue + 1));
                    worldIn.func_175656_a(pos, this.func_176203_a(0));
                }
                worldIn.func_184133_a(null, pos, SoundEvents.field_187884_fr, SoundSource.BLOCKS, 1.0f, 1.0f);
            }
            held.func_190918_g(1);
        }
        return true;
    }

    public void func_180650_b(Level world, BlockPos pos, BlockState state, Random rand) {
        int oreValue;
        if (!world.field_72995_K && (oreValue = this.func_176201_c(state)) > 0 && world.field_73012_v.nextInt(8) == 0) {
            world.func_175656_a(pos, this.func_176203_a(oreValue - 1));
        }
    }

    @Override
    public Item getHarvestResult(Level world, BlockPos pos) {
        return ItemInit.auradine;
    }

    @Override
    public Item getToolNeeded() {
        return ItemInit.crystalPickaxe;
    }

    @Override
    public void worldHarvestEffect(Level world, BlockPos pos, Player harvester) {
    }

    @Override
    public boolean isHarvestable(Level world, BlockPos pos, Player harvester) {
        return this.func_176201_c(world.func_180495_p(pos)) == 4;
    }

    @Override
    public void failedHarvest(Level world, BlockPos pos, Player harvester) {
    }
}

