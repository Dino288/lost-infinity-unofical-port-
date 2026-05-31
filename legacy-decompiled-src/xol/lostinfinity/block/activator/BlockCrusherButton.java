/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.item.ItemEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.Direction
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 */
package xol.lostinfinity.block.activator;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import xol.lostinfinity.block.basic.BlockBasic;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.util.coordinates.GalaxyCoordinates;
import xol.lostinfinity.util.damagesource.DeathMessage;

public class BlockCrusherButton
extends BlockBasic {
    public BlockCrusherButton(String name) {
        super(name);
    }

    public boolean func_180639_a(Level worldIn, BlockPos pos, BlockState state, Player playerIn, InteractionHand hand, Direction facing, float hitX, float hitY, float hitZ) {
        if (!worldIn.field_72995_K) {
            AABB crushBox = GalaxyCoordinates.crusherAABB();
            boolean crush = false;
            for (int i = (int)crushBox.field_72340_a; i <= (int)crushBox.field_72336_d; ++i) {
                for (int j = (int)crushBox.field_72338_b; j <= (int)crushBox.field_72337_e; ++j) {
                    for (int k = (int)crushBox.field_72339_c; k <= (int)crushBox.field_72334_f; ++k) {
                        BlockPos check = new BlockPos(i, j, k);
                        if (worldIn.func_175623_d(check) || crush) {
                            worldIn.func_175656_a(check, BlockInit.neosteelBeam.func_176223_P());
                            crush = true;
                            continue;
                        }
                        worldIn.func_175698_g(check);
                    }
                }
            }
            if (crush) {
                worldIn.func_184133_a(null, pos, SoundEvents.field_187689_f, SoundSource.MASTER, 1.0f, 0.9f);
                for (LivingEntity mob : worldIn.func_72872_a(LivingEntity.class, crushBox)) {
                    ItemEntity bones = new ItemEntity(worldIn, mob.field_70165_t, mob.field_70163_u + 0.4, mob.field_70161_v, new ItemStack(ItemInit.crushedBones));
                    bones.field_70159_w = 0.0;
                    bones.field_70181_x = 0.0;
                    bones.field_70179_y = 0.0;
                    worldIn.func_72838_d((Entity)bones);
                    mob.func_70606_j(0.0f);
                    if (!(mob instanceof Player)) continue;
                    DeathMessage.broadcastDeathMessage(mob.func_184102_h(), (Object)((Object)TextFmt.Red) + mob.func_70005_c_() + " was brutally crushed.");
                }
            }
        }
        return true;
    }
}

