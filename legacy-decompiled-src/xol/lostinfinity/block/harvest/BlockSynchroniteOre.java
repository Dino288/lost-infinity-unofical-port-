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
 *  net.minecraft.item.Item
 *  net.minecraft.util.Direction
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
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
import net.minecraft.world.item.Item;
import net.minecraft.core.Direction;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import xol.lostinfinity.block.basic.BlockBasic;
import xol.lostinfinity.block.basic.ISpecialHarvest;
import xol.lostinfinity.block.misc.BlockSynchroniteSignal;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.util.coordinates.GalaxyCoordinates;
import xol.lostinfinity.util.data.CustomParticleConfig;
import xol.lostinfinity.util.fx.IParticleSpawner;

public class BlockSynchroniteOre
extends BlockBasic
implements ISpecialHarvest {
    public static final IntegerProperty AMOUNT = IntegerProperty.func_177719_a((String)"amount", (int)0, (int)4);

    public BlockSynchroniteOre(String name) {
        super(name);
        this.func_149675_a(true);
        this.func_149711_c(2.0f);
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

    public void func_180650_b(Level world, BlockPos pos, BlockState state, Random rand) {
        if (!world.field_72995_K) {
            int range = 3;
            Iterable nearblocks = BlockPos.func_177980_a((BlockPos)pos.func_177982_a(-range, -range, -range), (BlockPos)pos.func_177982_a(range, range, range));
            for (BlockPos nearpos : nearblocks) {
                if (!(world.func_180495_p(nearpos).func_177230_c() instanceof BlockSynchroniteOre)) continue;
                int newMeta = 1 + rand.nextInt(4);
                world.func_175656_a(nearpos, this.func_176203_a(newMeta));
            }
        }
    }

    @Override
    public Item getHarvestResult(Level world, BlockPos pos) {
        switch (this.func_176201_c(world.func_180495_p(pos))) {
            case 1: {
                return ItemInit.synchroniteTypeA;
            }
            case 2: {
                return ItemInit.synchroniteTypeB;
            }
            case 3: {
                return ItemInit.synchroniteTypeC;
            }
            case 4: {
                return ItemInit.synchroniteTypeD;
            }
        }
        return ItemInit.synchroniteTypeA;
    }

    @Override
    public Item getToolNeeded() {
        return ItemInit.crystalPickaxe;
    }

    @Override
    public void worldHarvestEffect(Level world, BlockPos pos, Player harvester) {
        if (!world.field_72995_K) {
            world.func_175656_a(pos, this.func_176203_a(0));
        }
    }

    @Override
    public boolean isHarvestable(Level world, BlockPos pos, Player harvester) {
        int meta = this.func_176201_c(world.func_180495_p(pos));
        BlockState state = world.func_180495_p(GalaxyCoordinates.SynchroniteSignal());
        BlockSynchroniteSignal signal = (BlockSynchroniteSignal)state.func_177230_c();
        int requiredMeta = 1 + signal.func_176201_c(state);
        return meta != 0 && meta == requiredMeta;
    }

    @Override
    public void failedHarvest(Level world, BlockPos pos, Player harvester) {
        BlockState state;
        if (!world.field_72995_K && this.func_176201_c(state = world.func_180495_p(pos)) != 0) {
            world.func_72876_a(null, (double)pos.func_177958_n(), (double)pos.func_177956_o(), (double)pos.func_177952_p(), 3.0f, false);
            for (Player target : world.func_72872_a(Player.class, new AABB(pos).func_186662_g(5.0))) {
                harvester.func_70606_j(harvester.func_110143_aJ() - harvester.func_110138_aP() * 2.0f);
                target.func_145747_a((Component)new Component((Object)((Object)TextFmt.Red) + "A massive reaction occured from mining an asynchronous ore!"));
            }
            CustomParticleConfig config1 = new CustomParticleConfig();
            config1.createInstance().setParticle(ParticleInit.ION_BLAST).setSpread(6.0, 4.0, 6.0).setCount(5).setIgnoreRange(true);
            IParticleSpawner.spawnParticle(world, config1, (double)pos.func_177958_n(), (double)pos.func_177956_o(), (double)pos.func_177952_p());
            CustomParticleConfig config2 = new CustomParticleConfig();
            config2.createInstance().setParticle(ParticleInit.NUCLEAR_BLAST).setSpread(1.0, 1.0, 1.0).setCount(5).setIgnoreRange(true);
            IParticleSpawner.spawnParticle(world, config2, (double)pos.func_177958_n(), (double)pos.func_177956_o(), (double)pos.func_177952_p());
        }
    }
}

