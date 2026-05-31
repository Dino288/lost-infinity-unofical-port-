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
 *  net.minecraft.util.Direction
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 */
package xol.lostinfinity.block.activator;

import java.util.Iterator;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import xol.lostinfinity.block.basic.BlockBasic;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.mob.entity.misc.EntityCellGameMerchant;

public class BlockCellContainer
extends BlockBasic {
    public static final IntegerProperty AMOUNT = IntegerProperty.func_177719_a((String)"amount", (int)0, (int)9);

    public BlockCellContainer(String name, int i) {
        super(name);
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
        block2: {
            int radius;
            AABB checkBox;
            Iterator iterator;
            if (worldIn.field_72995_K || !(iterator = worldIn.func_72872_a(EntityCellGameMerchant.class, checkBox = new AABB(pos.func_177982_a(-(radius = 9), -radius, -radius), pos.func_177982_a(radius, radius, radius))).iterator()).hasNext()) break block2;
            EntityCellGameMerchant merch = (EntityCellGameMerchant)((Object)iterator.next());
            if (playerIn.func_184586_b(hand).func_77973_b().equals(ItemInit.powerAnalyzer)) {
                merch.readPowerLevel(pos, worldIn, playerIn);
                merch.selectCell1(pos, worldIn, playerIn);
            } else {
                merch.selectCell2(pos, worldIn, playerIn);
            }
        }
        return true;
    }

    public BlockState getStateWithAmount(int amount) {
        return this.func_176223_P().func_177226_a((Property)AMOUNT, (Comparable)Integer.valueOf(amount));
    }
}

