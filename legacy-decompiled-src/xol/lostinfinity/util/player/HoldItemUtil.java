/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.entity.projectile.EntityArrow
 *  net.minecraft.entity.projectile.EntityFireball
 *  net.minecraft.entity.projectile.EntityShulkerBullet
 *  net.minecraft.entity.projectile.EntityThrowable
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.util.EnumParticleTypes
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 */
package xol.lostinfinity.util.player;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.entity.projectile.EntityShulkerBullet;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.sounds.SoundSource;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.projectile.entity.EntityCelestialFire;

public class HoldItemUtil {
    public static void axiomProtection(Player playerIn) {
        Level world = playerIn.field_70170_p;
        for (Entity proj : world.func_72872_a(Entity.class, playerIn.func_174813_aQ().func_72314_b(10.0, 5.0, 10.0))) {
            if (!(proj instanceof EntityThrowable) && !(proj instanceof EntityArrow) && !(proj instanceof EntityFireball) && !(proj instanceof EntityShulkerBullet)) continue;
            if (playerIn.func_184614_ca().func_77973_b().equals(ItemInit.axiomCelestarium)) {
                ItemStack stack = playerIn.func_184614_ca();
                if (!stack.func_77942_o()) {
                    stack.func_77982_d(new CompoundTag());
                    stack.func_77978_p().func_74768_a("Charge", 0);
                }
                if (proj instanceof EntityCelestialFire) continue;
                stack.func_77978_p().func_74768_a("Charge", Math.min(stack.func_77978_p().func_74762_e("Charge") + 1, 25));
            }
            HoldItemUtil.vaporizeProjectile(world, proj);
        }
    }

    private static void vaporizeProjectile(Level world, Entity projectile) {
        world.func_184133_a(null, new BlockPos(projectile.field_70165_t, projectile.field_70163_u, projectile.field_70161_v), SoundInit.ITEM_AXIOMAVORUM, SoundSource.MASTER, 2.0f, 1.0f);
        if (!world.field_72995_K) {
            projectile.func_70106_y();
        } else {
            for (int i = 0; i < 2; ++i) {
                world.func_175688_a(EnumParticleTypes.LAVA, projectile.field_70165_t, projectile.field_70163_u, projectile.field_70161_v, (world.field_73012_v.nextDouble() - 0.5) * 2.0, -world.field_73012_v.nextDouble(), (world.field_73012_v.nextDouble() - 0.5) * 2.0, new int[0]);
            }
        }
    }
}

