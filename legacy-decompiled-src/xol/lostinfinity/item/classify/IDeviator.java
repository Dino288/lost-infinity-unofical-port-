/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.Mob
 *  net.minecraft.entity.boss.EntityWither
 *  net.minecraft.entity.monster.EntityBlaze
 *  net.minecraft.entity.monster.EntityCaveSpider
 *  net.minecraft.entity.monster.EntityCreeper
 *  net.minecraft.entity.monster.EntityEnderman
 *  net.minecraft.entity.monster.EntityEvoker
 *  net.minecraft.entity.monster.EntityGhast
 *  net.minecraft.entity.monster.EntityGuardian
 *  net.minecraft.entity.monster.EntityHusk
 *  net.minecraft.entity.monster.EntityIronGolem
 *  net.minecraft.entity.monster.EntityMagmaCube
 *  net.minecraft.entity.monster.EntityPigZombie
 *  net.minecraft.entity.monster.EntityPolarBear
 *  net.minecraft.entity.monster.EntitySkeleton
 *  net.minecraft.entity.monster.EntitySlime
 *  net.minecraft.entity.monster.EntitySnowman
 *  net.minecraft.entity.monster.EntitySpider
 *  net.minecraft.entity.monster.EntityStray
 *  net.minecraft.entity.monster.EntityVex
 *  net.minecraft.entity.monster.EntityWitch
 *  net.minecraft.entity.monster.EntityWitherSkeleton
 *  net.minecraft.entity.monster.EntityZombie
 *  net.minecraft.entity.passive.EntityBat
 *  net.minecraft.entity.passive.EntityChicken
 *  net.minecraft.entity.passive.EntityCow
 *  net.minecraft.entity.passive.EntityHorse
 *  net.minecraft.entity.passive.EntityLlama
 *  net.minecraft.entity.passive.EntityMooshroom
 *  net.minecraft.entity.passive.EntityOcelot
 *  net.minecraft.entity.passive.EntityPig
 *  net.minecraft.entity.passive.EntitySheep
 *  net.minecraft.entity.passive.EntitySquid
 *  net.minecraft.entity.passive.EntityWolf
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.EnumParticleTypes
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraft.world.World
 */
package xol.lostinfinity.item.classify;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityCaveSpider;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityEvoker;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityGuardian;
import net.minecraft.entity.monster.EntityHusk;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntityPolarBear;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.monster.EntitySnowman;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityStray;
import net.minecraft.entity.monster.EntityVex;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.monster.EntityWitherSkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityLlama;
import net.minecraft.entity.passive.EntityMooshroom;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.DimensionInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.entity.base.EntityDeviantMob;
import xol.lostinfinity.mob.entity.base.EntityDeviantPrime;
import xol.lostinfinity.mob.entity.boss.EntityDeviantWither;
import xol.lostinfinity.mob.entity.deviant.EntityDeviantBat;
import xol.lostinfinity.mob.entity.deviant.EntityDeviantBear;
import xol.lostinfinity.mob.entity.deviant.EntityDeviantBlaze;
import xol.lostinfinity.mob.entity.deviant.EntityDeviantCaveSpider;
import xol.lostinfinity.mob.entity.deviant.EntityDeviantChicken;
import xol.lostinfinity.mob.entity.deviant.EntityDeviantCow;
import xol.lostinfinity.mob.entity.deviant.EntityDeviantCreeper;
import xol.lostinfinity.mob.entity.deviant.EntityDeviantDimTrader;
import xol.lostinfinity.mob.entity.deviant.EntityDeviantEnderman;
import xol.lostinfinity.mob.entity.deviant.EntityDeviantEvoker;
import xol.lostinfinity.mob.entity.deviant.EntityDeviantGhast;
import xol.lostinfinity.mob.entity.deviant.EntityDeviantGolem;
import xol.lostinfinity.mob.entity.deviant.EntityDeviantGuardian;
import xol.lostinfinity.mob.entity.deviant.EntityDeviantHorse;
import xol.lostinfinity.mob.entity.deviant.EntityDeviantHusk;
import xol.lostinfinity.mob.entity.deviant.EntityDeviantLlama;
import xol.lostinfinity.mob.entity.deviant.EntityDeviantMagmacube;
import xol.lostinfinity.mob.entity.deviant.EntityDeviantMooshroom;
import xol.lostinfinity.mob.entity.deviant.EntityDeviantOcelote;
import xol.lostinfinity.mob.entity.deviant.EntityDeviantPig;
import xol.lostinfinity.mob.entity.deviant.EntityDeviantPiglin;
import xol.lostinfinity.mob.entity.deviant.EntityDeviantSheep;
import xol.lostinfinity.mob.entity.deviant.EntityDeviantSkeleton;
import xol.lostinfinity.mob.entity.deviant.EntityDeviantSlime;
import xol.lostinfinity.mob.entity.deviant.EntityDeviantSlimeStrider;
import xol.lostinfinity.mob.entity.deviant.EntityDeviantSnowman;
import xol.lostinfinity.mob.entity.deviant.EntityDeviantSpider;
import xol.lostinfinity.mob.entity.deviant.EntityDeviantSquid;
import xol.lostinfinity.mob.entity.deviant.EntityDeviantStray;
import xol.lostinfinity.mob.entity.deviant.EntityDeviantVex;
import xol.lostinfinity.mob.entity.deviant.EntityDeviantWitch;
import xol.lostinfinity.mob.entity.deviant.EntityDeviantWitherSkeleton;
import xol.lostinfinity.mob.entity.deviant.EntityDeviantWolf;
import xol.lostinfinity.mob.entity.deviant.EntityDeviantZombie;
import xol.lostinfinity.mob.entity.misc.EntityDimensionalMerchant;
import xol.lostinfinity.mob.entity.misc.EntitySlimeStrider;

public interface IDeviator {
    default public boolean deviateCreature(ItemStack stack, Player attacker, Entity target) {
        boolean flag = false;
        if (!attacker.field_70170_p.field_72995_K) {
            EntityDeviantMob newEntity = IDeviator.getDeviant(attacker.field_70170_p, target);
            if (newEntity != null) {
                newEntity.func_70107_b(target.field_70165_t, target.field_70163_u, target.field_70161_v);
                target.func_70106_y();
                attacker.field_70170_p.func_72838_d((Entity)newEntity);
                IDeviator.pushPlayersAway(attacker.field_70170_p, (Entity)((Mob)target), attacker);
                flag = true;
            }
        } else {
            for (int i = 0; i < 12; ++i) {
                attacker.field_70170_p.func_175688_a(EnumParticleTypes.SPELL_MOB, target.field_70165_t + (attacker.field_70170_p.field_73012_v.nextDouble() - 0.5) * (double)target.field_70130_N * 2.0, target.field_70163_u + attacker.field_70170_p.field_73012_v.nextDouble() * (double)target.field_70131_O * 2.0 - 0.25, target.field_70161_v + (attacker.field_70170_p.field_73012_v.nextDouble() - 0.5) * (double)target.field_70130_N * 2.0, (attacker.field_70170_p.field_73012_v.nextDouble() - 0.5) * 2.0, -attacker.field_70170_p.field_73012_v.nextDouble(), (attacker.field_70170_p.field_73012_v.nextDouble() - 0.5) * 2.0, new int[0]);
            }
        }
        return flag;
    }

    default public boolean superMutateCreature(ItemStack stack, Player attacker, Entity target) {
        boolean flag = false;
        if (target instanceof EntityDeviantMob) {
            EntityDeviantMob deviant = (EntityDeviantMob)target;
            if (deviant.getMutation() == 0) {
                if (!attacker.field_70170_p.field_72995_K) {
                    deviant.setMutation(1);
                    deviant.updateSupermutationAI();
                }
                flag = true;
            }
        } else if (target instanceof EntityDeviantPrime && !attacker.field_70170_p.field_72995_K) {
            attacker.func_145747_a((Component)new Component((Object)((Object)TextFmt.Red) + "The deviant resists the power from the supermutation rod."));
            target.func_184185_a(SoundInit.MIRRORZOMBIE_REFLECT, 3.0f, 1.0f);
        }
        if (flag) {
            if (attacker.field_70170_p.field_72995_K) {
                for (int i = 0; i < 12; ++i) {
                    attacker.field_70170_p.func_175688_a(EnumParticleTypes.LAVA, target.field_70165_t + (attacker.field_70170_p.field_73012_v.nextDouble() - 0.5) * (double)target.field_70130_N, target.field_70163_u + attacker.field_70170_p.field_73012_v.nextDouble() * (double)target.field_70131_O - 0.25, target.field_70161_v + (attacker.field_70170_p.field_73012_v.nextDouble() - 0.5) * (double)target.field_70130_N, (attacker.field_70170_p.field_73012_v.nextDouble() - 0.5) * 2.0, -attacker.field_70170_p.field_73012_v.nextDouble(), (attacker.field_70170_p.field_73012_v.nextDouble() - 0.5) * 2.0, new int[0]);
                }
            } else {
                target.func_184185_a(SoundInit.SUPERMUTATION, 3.0f, 1.0f);
            }
        }
        return flag;
    }

    default public boolean ultimatumMutation(ItemStack stack, Player attacker, Entity target) {
        boolean flag = false;
        if (attacker.field_70170_p.field_73011_w.func_186058_p() == DimensionInit.celestialVoid) {
            if (target instanceof EntityWither) {
                if (!attacker.field_70170_p.field_72995_K) {
                    EntityDeviantWither deviant_replacement = new EntityDeviantWither(attacker.field_70170_p);
                    deviant_replacement.func_70107_b(target.field_70165_t, target.field_70163_u, target.field_70161_v);
                    target.func_70106_y();
                    attacker.field_70170_p.func_72838_d((Entity)deviant_replacement);
                    IDeviator.pushPlayersAway(attacker.field_70170_p, (Entity)((Mob)target), attacker);
                    target.func_184185_a(SoundInit.DEVIATION, 3.0f, 1.0f);
                }
                flag = true;
            } else if (target instanceof EntityEvoker) {
                if (!attacker.field_70170_p.field_72995_K) {
                    EntityDeviantEvoker deviant_replacement = new EntityDeviantEvoker(attacker.field_70170_p);
                    deviant_replacement.func_70107_b(target.field_70165_t, target.field_70163_u, target.field_70161_v);
                    target.func_70106_y();
                    attacker.field_70170_p.func_72838_d((Entity)deviant_replacement);
                    IDeviator.pushPlayersAway(attacker.field_70170_p, (Entity)((Mob)target), attacker);
                    target.func_184185_a(SoundInit.DEVIATION, 3.0f, 1.0f);
                }
                flag = true;
            }
        }
        return flag;
    }

    public static void pushPlayersAway(Level worldIn, Entity creature, Player playerIn) {
        creature.func_184185_a(SoundInit.DEVIATION, 2.0f, 1.0f);
        for (Player e : worldIn.func_72872_a(Player.class, creature.func_174813_aQ().func_72314_b(4.0, 4.0, 4.0))) {
            e.func_70024_g(Math.signum(creature.field_70165_t - e.field_70165_t) * -0.89, 0.35, Math.signum(creature.field_70161_v - e.field_70161_v) * -0.89);
            e.field_70133_I = true;
        }
    }

    public static EntityDeviantMob getDeviant(Level world, Entity entity) {
        if (entity instanceof EntityPolarBear) {
            return new EntityDeviantBear(world);
        }
        if (entity instanceof EntityWolf) {
            return new EntityDeviantWolf(world);
        }
        if (entity instanceof EntityHorse) {
            return new EntityDeviantHorse(world);
        }
        if (entity instanceof EntityPig) {
            return new EntityDeviantPig(world);
        }
        if (entity instanceof EntitySheep) {
            return new EntityDeviantSheep(world);
        }
        if (entity instanceof EntityHusk) {
            return new EntityDeviantHusk(world);
        }
        if (entity instanceof EntityBlaze) {
            return new EntityDeviantBlaze(world);
        }
        if (entity instanceof EntityChicken) {
            return new EntityDeviantChicken(world);
        }
        if (entity instanceof EntityWitherSkeleton) {
            return new EntityDeviantWitherSkeleton(world);
        }
        if (entity instanceof EntityMooshroom) {
            return new EntityDeviantMooshroom(world);
        }
        if (entity instanceof EntityCow) {
            return new EntityDeviantCow(world);
        }
        if (entity instanceof EntityOcelot) {
            return new EntityDeviantOcelote(world);
        }
        if (entity instanceof EntityCreeper) {
            return new EntityDeviantCreeper(world);
        }
        if (entity instanceof EntityGuardian) {
            return new EntityDeviantGuardian(world);
        }
        if (entity instanceof EntityGhast) {
            return new EntityDeviantGhast(world);
        }
        if (entity instanceof EntityEnderman) {
            return new EntityDeviantEnderman(world);
        }
        if (entity instanceof EntityLlama) {
            return new EntityDeviantLlama(world);
        }
        if (entity instanceof EntityMagmaCube) {
            return new EntityDeviantMagmacube(world);
        }
        if (entity instanceof EntityPigZombie) {
            return new EntityDeviantPiglin(world);
        }
        if (entity instanceof EntitySkeleton) {
            return new EntityDeviantSkeleton(world);
        }
        if (entity instanceof EntitySlime) {
            return new EntityDeviantSlime(world);
        }
        if (entity instanceof EntitySquid) {
            return new EntityDeviantSquid(world);
        }
        if (entity instanceof EntitySlimeStrider) {
            return new EntityDeviantSlimeStrider(world);
        }
        if (entity instanceof EntitySnowman) {
            return new EntityDeviantSnowman(world);
        }
        if (entity instanceof EntityCaveSpider) {
            return new EntityDeviantCaveSpider(world);
        }
        if (entity instanceof EntitySpider) {
            return new EntityDeviantSpider(world);
        }
        if (entity instanceof EntityStray) {
            return new EntityDeviantStray(world);
        }
        if (entity instanceof EntityVex) {
            return new EntityDeviantVex(world);
        }
        if (entity instanceof EntityWitch) {
            return new EntityDeviantWitch(world);
        }
        if (entity instanceof EntityZombie) {
            return new EntityDeviantZombie(world);
        }
        if (entity instanceof EntityIronGolem) {
            return new EntityDeviantGolem(world);
        }
        if (entity instanceof EntityBat) {
            return new EntityDeviantBat(world);
        }
        if (entity instanceof EntityDimensionalMerchant) {
            return new EntityDeviantDimTrader(world);
        }
        return null;
    }
}

