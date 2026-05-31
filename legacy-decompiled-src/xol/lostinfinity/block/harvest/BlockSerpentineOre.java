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
 *  net.minecraft.util.Direction
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraft.world.World
 */
package xol.lostinfinity.block.harvest;

import java.util.ArrayList;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.Item;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import xol.lostinfinity.block.basic.BlockBasicLight;
import xol.lostinfinity.block.basic.ISpecialHarvest;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.SoundInit;

public class BlockSerpentineOre
extends BlockBasicLight
implements ISpecialHarvest {
    public static final IntegerProperty AMOUNT = IntegerProperty.func_177719_a((String)"amount", (int)0, (int)2);

    public BlockSerpentineOre(String name) {
        super(name);
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

    public BlockState getStateWithAmount(int amount) {
        return this.func_176223_P().func_177226_a((Property)AMOUNT, (Comparable)Integer.valueOf(amount));
    }

    @Override
    public boolean isHarvestable(Level world, BlockPos pos, Player harvester) {
        return this.func_176201_c(world.func_180495_p(pos)) == 2;
    }

    @Override
    public void failedHarvest(Level world, BlockPos pos, Player harvester) {
    }

    @Override
    public Item getHarvestResult(Level world, BlockPos pos) {
        return ItemInit.serpentineCrystal;
    }

    @Override
    public Item getToolNeeded() {
        return ItemInit.crystalPickaxe;
    }

    @Override
    public void worldHarvestEffect(Level world, BlockPos pos, Player harvester) {
        if (!world.field_72995_K) {
            this.reset(world, pos);
        }
    }

    private boolean validInput(Item item) {
        return item.equals(ItemInit.ultravioletSolution);
    }

    public boolean func_180639_a(Level worldIn, BlockPos pos, BlockState state, Player playerIn, InteractionHand hand, Direction facing, float hitX, float hitY, float hitZ) {
        if (!playerIn.func_70093_af() && this.validInput(playerIn.func_184586_b(hand).func_77973_b()) && !worldIn.field_72995_K) {
            if (state.equals(this.getStateWithAmount(1))) {
                worldIn.func_175656_a(pos, this.getStateWithAmount(2));
                playerIn.func_184586_b(hand).func_190918_g(1);
                worldIn.func_184133_a(null, pos, SoundInit.GLOW_BOMB, SoundSource.BLOCKS, 1.0f, 1.0f);
                return true;
            }
            if (state.equals(this.getStateWithAmount(2))) {
                return true;
            }
            playerIn.func_184586_b(hand).func_190918_g(1);
            worldIn.func_184133_a(null, pos, SoundEvents.field_187620_cL, SoundSource.BLOCKS, 1.0f, 0.8f + worldIn.field_73012_v.nextFloat() * 0.4f);
            int radius = 20;
            boolean found = this.findOreRadius(worldIn, pos, radius);
            if (!found) {
                this.reset(worldIn, pos);
                this.findOreRadius(worldIn, pos, radius);
            }
        }
        return true;
    }

    private boolean findOreRadius(Level worldIn, BlockPos pos, int radius) {
        boolean found = false;
        for (int i = -radius; i <= radius; ++i) {
            for (int j = -radius; j <= radius; ++j) {
                BlockPos checkPos = new BlockPos(pos.func_177958_n() + i, pos.func_177956_o(), pos.func_177952_p() + j);
                BlockState checkState = worldIn.func_180495_p(checkPos);
                if (!checkState.equals(this.getStateWithAmount(1))) continue;
                int dist = (int)pos.func_185332_f(checkPos.func_177958_n(), checkPos.func_177956_o(), checkPos.func_177952_p()) + worldIn.field_73012_v.nextInt(3);
                for (Player player : worldIn.func_72872_a(Player.class, new AABB(pos.func_177982_a(-15, -15, -15), pos.func_177982_a(15, 15, 15)))) {
                    String message = String.format("The level of shine indicates the ore is within a radius of %d", dist);
                    player.func_145747_a((Component)new Component(TextFmt.getFormatting(TextFmt.Bold, TextFmt.Green) + message));
                    found = true;
                }
            }
        }
        return found;
    }

    private ArrayList<BlockPos> setBlockNeighbours(Level world, BlockPos pos, ArrayList<BlockPos> visited) {
        ArrayList<BlockPos> reset = new ArrayList<BlockPos>();
        if (world.func_180495_p(pos).equals(this.getStateWithAmount(2))) {
            world.func_175656_a(pos, this.getStateWithAmount(0));
            reset.add(pos);
        } else if (world.func_180495_p(pos).equals(this.getStateWithAmount(0))) {
            reset.add(pos);
        } else {
            return null;
        }
        ArrayList<BlockPos> neighbours = new ArrayList<BlockPos>();
        visited.add(pos);
        neighbours.add(pos.func_177982_a(0, 0, 1));
        neighbours.add(pos.func_177982_a(0, 0, -1));
        neighbours.add(pos.func_177982_a(1, 0, 0));
        neighbours.add(pos.func_177982_a(-1, 0, 0));
        neighbours.add(pos.func_177982_a(-1, 0, 1));
        neighbours.add(pos.func_177982_a(-1, 0, -1));
        neighbours.add(pos.func_177982_a(1, 0, 1));
        neighbours.add(pos.func_177982_a(1, 0, -1));
        for (BlockPos neighbour : neighbours) {
            ArrayList<BlockPos> moreNeighbours;
            if (visited.contains(neighbour) || (moreNeighbours = this.setBlockNeighbours(world, neighbour, visited)) == null) continue;
            for (BlockPos n : moreNeighbours) {
                reset.add(n);
            }
        }
        return reset;
    }

    private void reset(Level world, BlockPos pos) {
        ArrayList<Object> blocks = new ArrayList();
        ArrayList<BlockPos> visited = new ArrayList<BlockPos>();
        blocks = this.setBlockNeighbours(world, pos, visited);
        int randDecoy = world.field_73012_v.nextInt(blocks.size());
        world.func_175656_a((BlockPos)blocks.get(randDecoy), this.getStateWithAmount(1));
    }
}

