/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.util.Direction
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.EnumParticleTypes
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 *  net.minecraft.world.ServerLevel
 */
package xol.lostinfinity.block.activator;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.server.level.ServerLevel;
import xol.lostinfinity.block.basic.BlockBasic;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.mob.entity.misc.EntityLightGame;

public class BlockLightSwitchGame
extends BlockBasic {
    public BlockLightSwitchGame(String name) {
        super(name);
    }

    public boolean func_180639_a(Level worldIn, BlockPos pos, BlockState state, Player playerIn, InteractionHand hand, Direction facing, float hitX, float hitY, float hitZ) {
        if (!worldIn.field_72995_K) {
            AABB checkBox = new AABB(pos.func_177982_a(-10, -10, -10), pos.func_177982_a(10, 10, 10));
            for (EntityLightGame merch : worldIn.func_72872_a(EntityLightGame.class, checkBox)) {
                ((ServerLevel)worldIn).func_175739_a(EnumParticleTypes.PORTAL, merch.field_70165_t, merch.field_70163_u, merch.field_70161_v, 5, (-0.5 + worldIn.field_73012_v.nextDouble()) * 3.0, 0.3, (-0.5 + worldIn.field_73012_v.nextDouble()) * 3.0, (double)0.15f, new int[0]);
                merch.func_70106_y();
            }
            BlockPos refPos = pos.func_177982_a(0, 1, 0);
            int radius = 8;
            ArrayList<BlockPos> switches = new ArrayList<BlockPos>();
            ArrayList<BlockPos> lights = new ArrayList<BlockPos>();
            for (int i = -radius; i <= radius; ++i) {
                for (int j = -radius; j <= radius; ++j) {
                    Block block = worldIn.func_180495_p(refPos.func_177982_a(i, 0, j)).func_177230_c();
                    if (block == BlockInit.switchableLightOff || block == BlockInit.switchableLightOn) {
                        lights.add(refPos.func_177982_a(i, 0, j));
                        continue;
                    }
                    if (block != BlockInit.lightSwitchOff && block != BlockInit.lightSwitchOn) continue;
                    switches.add(refPos.func_177982_a(i, 0, j));
                }
            }
            List gameEntities = worldIn.func_72872_a(EntityLightGame.class, new AABB(-8.0, 0.0, -8.0, 8.0, 8.0, 8.0));
            for (EntityLightGame entity : gameEntities) {
                entity.func_70106_y();
            }
            EntityLightGame lightGame = new EntityLightGame(worldIn, lights, switches);
            BlockPos entityPos = pos.func_177982_a(-1, 1, -1);
            lightGame.func_70107_b(entityPos.func_177958_n(), entityPos.func_177956_o(), entityPos.func_177952_p());
            worldIn.func_72838_d((Entity)lightGame);
        }
        return true;
    }
}

