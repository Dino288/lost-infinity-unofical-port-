/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.material.Material
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.Direction
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.EnumParticleTypes
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3i
 *  net.minecraft.world.World
 *  net.minecraft.world.ServerLevel
 */
package xol.lostinfinity.block.activator;

import java.util.Random;
import net.minecraft.block.material.Material;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.world.level.Level;
import net.minecraft.server.level.ServerLevel;
import xol.lostinfinity.block.basic.BlockBasic;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.mob.entity.misc.EntityRhythmGameMerchant;

public class BlockRhythmGame
extends BlockBasic {
    private boolean hard_mode = false;
    private Vec3i dir;

    public BlockRhythmGame(String name, boolean hard) {
        super(name, Material.field_151573_f);
        this.func_149715_a(1.0f);
    }

    private boolean validInput(ItemStack stack) {
        return stack.func_77973_b().equals(ItemInit.timeTrigger);
    }

    public boolean func_180639_a(Level worldIn, BlockPos pos, BlockState state, Player playerIn, InteractionHand hand, Direction facing, float hitX, float hitY, float hitZ) {
        if (!playerIn.func_70093_af() && this.validInput(playerIn.func_184586_b(hand))) {
            if (!worldIn.field_72995_K) {
                Random rand = worldIn.field_73012_v;
                AABB checkBox = new AABB(pos.func_177982_a(-10, -10, -10), pos.func_177982_a(10, 10, 10));
                for (EntityRhythmGameMerchant merch : worldIn.func_72872_a(EntityRhythmGameMerchant.class, checkBox)) {
                    ((ServerLevel)worldIn).func_175739_a(EnumParticleTypes.PORTAL, merch.field_70165_t, merch.field_70163_u, merch.field_70161_v, 5, (-0.5 + rand.nextDouble()) * 3.0, 0.3, (-0.5 + rand.nextDouble()) * 3.0, (double)0.15f, new int[0]);
                    merch.func_70106_y();
                }
                worldIn.func_184133_a(null, pos, SoundEvents.field_187620_cL, SoundSource.MASTER, 1.0f, 1.0f);
                EntityRhythmGameMerchant newMerchant = new EntityRhythmGameMerchant(worldIn);
                BlockPos spawnPos = pos;
                newMerchant.func_70107_b(spawnPos.func_177958_n(), (double)spawnPos.func_177956_o() + 1.5, spawnPos.func_177952_p());
                ((ServerLevel)worldIn).func_175739_a(EnumParticleTypes.PORTAL, newMerchant.field_70165_t, newMerchant.field_70163_u, newMerchant.field_70161_v, 8, (-0.5 + rand.nextDouble()) * 3.0, 0.3, (-0.5 + rand.nextDouble()) * 3.0, (double)0.15f, new int[0]);
                worldIn.func_72838_d((Entity)newMerchant);
                newMerchant.genRhythmGame(pos.func_177982_a(0, -1, 0));
                newMerchant.startGame();
            }
            playerIn.func_184586_b(hand).func_190918_g(1);
        }
        return true;
    }
}

