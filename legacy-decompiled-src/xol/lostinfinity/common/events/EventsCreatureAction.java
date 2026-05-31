/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.Mob
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.item.ItemEntity
 *  net.minecraft.entity.monster.Monster
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.ItemStack
 *  net.minecraft.potion.Potion
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Mth
 *  net.minecraft.util.math.Vec3
 *  net.minecraft.util.math.Vec3i
 *  net.minecraftforge.event.entity.living.LivingDeathEvent
 *  net.minecraftforge.event.entity.living.LivingDropsEvent
 *  net.minecraftforge.event.entity.living.LivingEvent$LivingUpdateEvent
 *  net.minecraftforge.event.entity.living.LivingHealEvent
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 */
package xol.lostinfinity.common.events;

import java.util.ArrayList;
import java.util.Random;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import net.minecraft.core.Vec3i;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingHealEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import xol.lostinfinity.block.basic.ITetherable;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.DimensionInit;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.init.PotionInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.item.classify.IHealReactive;
import xol.lostinfinity.item.classify.ITransfusionEffect;
import xol.lostinfinity.mob.entity.base.EntityDeviantMob;
import xol.lostinfinity.mob.entity.base.EntityFloatingDeviant;
import xol.lostinfinity.mob.entity.base.EntityMultiLivesTameable;
import xol.lostinfinity.mob.entity.base.EntityMultipleLives;
import xol.lostinfinity.mob.entity.cthulhu.EntityCthulhu;
import xol.lostinfinity.mob.entity.misc.EntityGhostCopy;
import xol.lostinfinity.mob.entity.misc.EntityStarfiend;
import xol.lostinfinity.projectile.entity.EntityEnergyBurst;
import xol.lostinfinity.util.PotionBasic;
import xol.lostinfinity.util.damagesource.DeathMessage;
import xol.lostinfinity.util.data.CustomParticleConfig;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.fx.IParticleSpawner;

public class EventsCreatureAction
implements IMaxAttack {
    @SubscribeEvent
    public void deviantDropEvent(LivingDropsEvent event) {
        if ((event.getMob() instanceof EntityDeviantMob || event.getMob() instanceof EntityFloatingDeviant) && event.getMob().field_70170_p.field_73011_w.func_186058_p() == DimensionInit.celestialVoid) {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public void onEntityHeal(LivingHealEvent event) {
        LivingEntity entity = event.getMob();
        if (!entity.field_70170_p.field_72995_K) {
            if (entity instanceof Player) {
                Player player = (Player)entity;
                ItemStack main = player.func_184614_ca();
                ItemStack off = player.func_184592_cb();
                ItemStack reactive = null;
                if (main.func_77973_b() instanceof IHealReactive) {
                    reactive = main;
                } else if (off.func_77973_b() instanceof IHealReactive) {
                    reactive = off;
                }
                if (reactive != null) {
                    float newHeal = ((IHealReactive)reactive.func_77973_b()).itemHealReaction(player, event.getAmount(), reactive);
                    event.setAmount(newHeal);
                }
            }
            if (entity.func_70644_a(PotionInit.BLOOD_TOXIN)) {
                if (entity.func_110143_aJ() > 0.0f && !entity.field_70128_L) {
                    int level = entity.func_70660_b(PotionInit.BLOOD_TOXIN).func_76458_c();
                    float changedAmount = event.getAmount() * (0.0f + 0.2f * (float)level);
                    IMaxAttack.dealPotionDamage(entity, changedAmount);
                    if (entity.func_110143_aJ() <= 0.0f && entity instanceof Player) {
                        DeathMessage.broadcastDeathMessage(entity.func_184102_h(), (Object)((Object)TextFmt.Red) + entity.func_70005_c_() + " died of toxins.");
                    }
                }
                event.setCanceled(true);
            }
            if (entity.func_70644_a(PotionInit.PLANESPLIT)) {
                float entityHP = entity.func_110143_aJ();
                int level = entity.func_70660_b(PotionInit.PLANESPLIT).func_76458_c();
                float hpCap = entity.func_110138_aP() * (0.9f - 0.1f * (float)level);
                if (entityHP + event.getAmount() > hpCap) {
                    event.setAmount(hpCap - entityHP);
                }
            }
        }
    }

    @SubscribeEvent
    public void onTickEvent(LivingEvent.LivingUpdateEvent event) {
        int level;
        ItemStack offhand;
        int level2;
        LivingEntity entity = event.getMob();
        if (entity.func_70644_a(PotionInit.LAST_BREATH) && !entity.field_70170_p.field_72995_K && entity.field_70173_aa % 10 == 0) {
            level2 = entity.func_70660_b(PotionInit.LAST_BREATH).func_76458_c();
            float entityMaxHp = entity.func_110138_aP();
            IMaxAttack.dealPotionDamage(entity, entityMaxHp / (float)(20 - 2 * level2));
            if (entity.func_110143_aJ() <= 0.0f && entity instanceof Player) {
                DeathMessage.broadcastDeathMessage(entity.func_184102_h(), (Object)((Object)TextFmt.Red) + entity.func_70005_c_() + " took their final breath.");
            }
        }
        if (entity.func_70644_a(PotionInit.TRANSFUSION) && !entity.field_70170_p.field_72995_K) {
            int amplifier = entity.func_70660_b(PotionInit.TRANSFUSION).func_76458_c();
            for (LivingEntity nearPlayer : entity.field_70170_p.func_72872_a(LivingEntity.class, new AABB(entity.func_180425_c()).func_186662_g((double)(2 + amplifier * 3)))) {
                ITransfusionEffect transfusible;
                if (nearPlayer.func_110124_au().equals(entity.func_110124_au()) || nearPlayer.func_70644_a(PotionInit.TRANSFUSION) || nearPlayer.func_70651_bq().size() <= 0) continue;
                ArrayList<Potion> toRemove = new ArrayList<Potion>();
                for (PotionEffect effect : nearPlayer.func_70651_bq()) {
                    Potion potion = effect.func_188419_a();
                    if ((!(potion instanceof PotionBasic) || ((PotionBasic)potion).negativeLostEffect()) && (potion instanceof PotionBasic || potion.func_76398_f())) continue;
                    toRemove.add(effect.func_188419_a());
                    entity.func_70690_d(effect);
                }
                for (Potion potion : toRemove) {
                    nearPlayer.func_184589_d(potion);
                }
                if (!(entity instanceof Player)) continue;
                ItemStack mainHand = entity.func_184614_ca();
                ItemStack offhand2 = entity.func_184592_cb();
                if (mainHand.func_77973_b() instanceof ITransfusionEffect) {
                    transfusible = (ITransfusionEffect)mainHand.func_77973_b();
                    transfusible.transfuse((Player)entity, nearPlayer, InteractionHand.MAIN_HAND, mainHand, toRemove);
                }
                if (!(offhand2.func_77973_b() instanceof ITransfusionEffect)) continue;
                transfusible = (ITransfusionEffect)offhand2.func_77973_b();
                transfusible.transfuse((Player)entity, nearPlayer, InteractionHand.OFF_HAND, offhand2, toRemove);
            }
        }
        if (entity.func_70644_a(PotionInit.NITROUS) && entity.field_70173_aa % 20 == 0 && !entity.field_70170_p.field_72995_K) {
            level2 = entity.func_70660_b(PotionInit.NITROUS).func_76458_c();
            for (LivingEntity near_entity : entity.field_70170_p.func_72872_a(LivingEntity.class, entity.func_174813_aQ().func_186662_g(7.0))) {
                boolean canDealTrue;
                if (near_entity.func_110124_au().equals(entity.func_110124_au())) continue;
                boolean bl = canDealTrue = level2 >= 1;
                if (canDealTrue && near_entity.func_70032_d((Entity)entity) < 3.0f) {
                    IMaxAttack.dealTrueDamage((Entity)entity, near_entity, near_entity.func_110138_aP() * 0.75f);
                    continue;
                }
                IMaxAttack.dealMaxHealth((Entity)entity, near_entity, 4, 3.0f);
            }
            entity.field_70170_p.func_184133_a(null, entity.func_180425_c(), SoundInit.GENERIC_WEAPON_11, SoundSource.PLAYERS, 0.5f, 0.7f + 0.6f * entity.field_70170_p.field_73012_v.nextFloat());
            float angle = 0.0f;
            while ((double)angle <= Math.PI * 2) {
                double velocity_x = 10.0 * Math.cos(angle);
                double velocity_z = 10.0 * Math.sin(angle);
                CustomParticleConfig config1 = new CustomParticleConfig();
                config1.createInstance().setParticle(ParticleInit.FLAME_LARGE).setSpread(1.0, 0.0, 1.0).setSpeed(0.3, 0.0, 0.3).setVelSpread(1.0, 0.0, 1.0).setCount(9).setIgnoreRange(true);
                IParticleSpawner.spawnParticle(entity.field_70170_p, config1, entity.field_70165_t + velocity_x / 2.0, entity.field_70163_u + 1.0, entity.field_70161_v + velocity_z / 2.0);
                angle = (float)((double)angle + 0.39269908169872414);
            }
        }
        if (entity.func_70644_a(PotionInit.PLANESPLIT) && !entity.field_70170_p.field_72995_K) {
            level2 = entity.func_70660_b(PotionInit.PLANESPLIT).func_76458_c();
            float hpCap = entity.func_110138_aP() * (0.9f - 0.1f * (float)level2);
            if (entity.func_110143_aJ() > hpCap + 0.1f) {
                entity.func_70606_j(hpCap);
            }
            if (entity.field_70173_aa % 3 == 0 && entity instanceof Player) {
                Player player = (Player)entity;
                Random rand = player.field_70170_p.field_73012_v;
                float rYaw = player.field_70177_z * ((float)Math.PI / 180);
                float x = -Mth.func_76126_a((float)rYaw);
                float z = Mth.func_76134_b((float)rYaw);
                Vec3 look = player.func_174791_d().func_178788_d(new Vec3((double)x * 2.5, 0.0, (double)z * 2.5).func_178785_b(-0.7f + 1.4f * rand.nextFloat()));
                EntityGhostCopy ghost = new EntityGhostCopy(player.field_70170_p);
                ghost.setCopiedPlay(player);
                ghost.func_70107_b(look.field_72450_a, player.field_70163_u + 0.5, look.field_72449_c);
                player.field_70170_p.func_72838_d((Entity)ghost);
                if (entity.field_70173_aa % 18 == 0) {
                    switch (rand.nextInt(4)) {
                        case 0: {
                            player.field_70170_p.func_184133_a(null, player.func_180425_c(), SoundInit.APPARITION_1, SoundSource.PLAYERS, 0.5f, 0.9f + rand.nextFloat() * 0.2f);
                            break;
                        }
                        case 1: {
                            player.field_70170_p.func_184133_a(null, player.func_180425_c(), SoundInit.APPARITION_2, SoundSource.PLAYERS, 0.5f, 0.9f + rand.nextFloat() * 0.2f);
                            break;
                        }
                        case 2: {
                            player.field_70170_p.func_184133_a(null, player.func_180425_c(), SoundInit.APPARITION_3, SoundSource.PLAYERS, 0.5f, 0.9f + rand.nextFloat() * 0.2f);
                            break;
                        }
                        case 3: {
                            player.field_70170_p.func_184133_a(null, player.func_180425_c(), SoundInit.APPARITION_4, SoundSource.PLAYERS, 0.5f, 0.9f + rand.nextFloat() * 0.2f);
                        }
                    }
                }
            }
        }
        if (entity.func_70644_a(PotionInit.INTANGIBLE) && !entity.field_70170_p.field_72995_K && !(offhand = entity.func_184592_cb()).func_190926_b()) {
            ItemStack droppedCopy = offhand.func_77946_l();
            ItemEntity stolenItem = new ItemEntity(entity.field_70170_p, entity.field_70165_t, entity.field_70163_u + 1.0, entity.field_70161_v, droppedCopy);
            stolenItem.field_70159_w = 0.0;
            stolenItem.field_70181_x = 0.0;
            stolenItem.field_70179_y = 0.0;
            entity.field_70170_p.func_72838_d((Entity)stolenItem);
            entity.func_184611_a(InteractionHand.OFF_HAND, ItemStack.field_190927_a);
        }
        if (entity.func_70644_a(PotionInit.GRAVITATIONAL)) {
            int level3 = entity.func_70660_b(PotionInit.GRAVITATIONAL).func_76458_c();
            double force = 0.05 + 0.05 * (double)level3;
            int size = 3 + level3 * 5;
            for (LivingEntity near_entity : entity.field_70170_p.func_72872_a(LivingEntity.class, entity.func_174813_aQ().func_72314_b((double)size, (double)size, (double)size))) {
                if (near_entity.func_110124_au().equals(entity.func_110124_au())) continue;
                near_entity.func_70024_g(Math.signum(entity.field_70165_t - near_entity.field_70165_t) * force, Math.signum(entity.field_70163_u - near_entity.field_70163_u) * force, Math.signum(entity.field_70161_v - near_entity.field_70161_v) * force);
                near_entity.field_70133_I = true;
            }
        }
        if (entity.func_70644_a(PotionInit.ULTRAHEAVY)) {
            int level4 = entity.func_70660_b(PotionInit.ULTRAHEAVY).func_76458_c();
            if (entity.field_70181_x > (double)0.7f) {
                entity.func_70024_g(0.0, -(0.5 + 0.2 * (double)level4), 0.0);
            }
        }
        if (entity.func_70644_a(PotionInit.UNLEASHING)) {
            int level5 = entity.func_70660_b(PotionInit.UNLEASHING).func_76458_c();
            int duration = entity.func_70660_b(PotionInit.UNLEASHING).func_76459_b();
            if (!entity.field_70170_p.field_72995_K) {
                if (entity.field_70173_aa % 60 == 0) {
                    entity.func_70690_d(new PotionEffect(PotionInit.UNLEASHING, duration, Math.min(level5 + 1, 9)));
                }
                if (entity.field_70173_aa % (21 - level5 * 2) == 0) {
                    EntityEnergyBurst shot = new EntityEnergyBurst(entity.field_70170_p, entity);
                    shot.setThrower(entity);
                    shot.shootNoVel((Entity)entity, entity.field_70125_A, entity.field_70177_z, 0.0f, 2.0f, 0.0f);
                    entity.field_70170_p.func_72838_d((Entity)shot);
                    entity.field_70170_p.func_184133_a(null, entity.func_180425_c(), SoundInit.LASER_WEAPON_7, SoundSource.PLAYERS, 0.4f, 0.8f + entity.field_70170_p.field_73012_v.nextFloat() * 0.4f);
                }
            }
        }
        if (entity.func_70644_a(PotionInit.CONTAGIOUS) && !entity.field_70170_p.field_72995_K && entity.func_70644_a(PotionInit.PLAGUE) && (level = entity.func_70660_b(PotionInit.PLAGUE).func_76458_c()) < 4 && entity.field_70173_aa % 100 == 0) {
            int duration = entity.func_70660_b(PotionInit.PLAGUE).func_76459_b();
            entity.func_70690_d(new PotionEffect(PotionInit.PLAGUE, duration, level + 1));
        }
        if (entity.func_70644_a(PotionInit.RACING_HEART) && !entity.field_70170_p.field_72995_K) {
            int duration = entity.func_70660_b(PotionInit.RACING_HEART).func_76459_b();
            if (duration <= 1) {
                if (entity.func_110143_aJ() < entity.func_110138_aP() / 2.0f && !entity.field_70128_L) {
                    entity.func_70106_y();
                    if (entity instanceof Player) {
                        DeathMessage.broadcastDeathMessage(entity.func_184102_h(), (Object)((Object)TextFmt.Red) + entity.func_70005_c_() + " had a heart attack.");
                    }
                }
            } else if (entity.field_70173_aa % 5 == 0) {
                entity.func_70691_i(entity.func_110138_aP() * 0.1f);
            }
        }
        if (entity.func_70644_a(PotionInit.SUPERCHARGED) && !entity.field_70170_p.field_72995_K && entity.field_70173_aa % 5 == 0) {
            entity.func_70691_i(entity.func_110138_aP() * 0.1f);
        }
        if (entity.func_70644_a(PotionInit.TERRIFIED) && !entity.field_70170_p.field_72995_K && entity instanceof Mob) {
            double radius = 8.0;
            for (LivingEntity near : entity.field_70170_p.func_72872_a(LivingEntity.class, new AABB(entity.func_180425_c()).func_186662_g(radius))) {
                if (!near.func_70644_a(PotionInit.FEARED)) continue;
                Vec3 dir = entity.func_174791_d().func_178788_d(near.func_174791_d()).func_72432_b();
                entity.func_70024_g(dir.field_72450_a / 10.0, dir.field_72448_b / 10.0 + 0.1, dir.field_72449_c / 10.0);
                entity.field_70133_I = true;
            }
        }
        if (entity.func_70644_a(PotionInit.TETHERED) && !entity.field_70170_p.field_72995_K) {
            this.tether(event);
        }
        if (entity.func_70644_a(PotionInit.PLAGUE) && !entity.field_70170_p.field_72995_K) {
            level = entity.func_70660_b(PotionInit.PLAGUE).func_76458_c();
            float entityMaxHp = entity.func_110138_aP();
            int tickDiv = Math.max(2, 50 - 5 * level);
            if (entity.field_70173_aa % tickDiv == 0) {
                IMaxAttack.dealPotionDamage(entity, entityMaxHp / 3.0f);
                if (entity.func_110143_aJ() <= 0.0f) {
                    this.doContagion(entity, level);
                    if (entity instanceof Player) {
                        DeathMessage.broadcastDeathMessage(entity.func_184102_h(), (Object)((Object)TextFmt.Dark_Green) + entity.func_70005_c_() + " has succumbed to the plague.");
                    }
                }
            }
        }
        if (entity.func_70644_a(PotionInit.MIASMA) && !entity.field_70170_p.field_72995_K) {
            double radius = 5 + entity.func_70660_b(PotionInit.MIASMA).func_76458_c() * 3;
            for (Monster nearEntity : entity.field_70170_p.func_72872_a(Monster.class, new AABB(entity.func_180425_c()).func_186662_g(radius))) {
                LivingEntity target;
                if (nearEntity.func_110124_au().equals(entity.func_110124_au()) || (target = nearEntity.func_70638_az()) == null || !target.func_110124_au().equals(entity.func_110124_au())) continue;
                LivingEntity nearest = null;
                double minDist = 99.0;
                for (LivingEntity near : entity.field_70170_p.func_72872_a(LivingEntity.class, new AABB(nearEntity.func_180425_c()).func_186662_g(radius))) {
                    double dist;
                    if (near.func_110124_au().equals(entity.func_110124_au()) || near.func_110124_au().equals(nearEntity.func_110124_au()) || !((dist = (double)near.func_70032_d((Entity)nearEntity)) < minDist)) continue;
                    minDist = dist;
                    nearest = near;
                }
                nearEntity.func_70624_b(nearest);
                CustomParticleConfig config1 = new CustomParticleConfig();
                config1.createInstance().setParticle(ParticleInit.MIASMA).setSpread(4.0, 1.0, 4.0).setCount(5).setIgnoreRange(true);
                IParticleSpawner.spawnParticle(entity.field_70170_p, config1, nearEntity.field_70165_t, nearEntity.field_70163_u + (double)(nearEntity.field_70131_O / 2.0f), nearEntity.field_70161_v);
                entity.field_70170_p.func_184133_a(null, nearEntity.func_180425_c(), SoundInit.MIND_CONTROL_POTION, SoundSource.PLAYERS, 1.5f, 0.7f + entity.field_70170_p.field_73012_v.nextFloat() * 0.6f);
            }
        }
    }

    private void tether(LivingEvent.LivingUpdateEvent event) {
        int radius = 7;
        double pullSpeed = 0.4;
        BlockPos logPos = this.getNearestLog(event, radius);
        if (logPos != null) {
            double x = event.getEntity().field_70165_t;
            double y = event.getEntity().field_70163_u;
            double z = event.getEntity().field_70161_v;
            double diffX = (double)logPos.func_177958_n() - x;
            double diffY = (double)logPos.func_177956_o() - y;
            double diffZ = (double)logPos.func_177952_p() - z;
            Vec3 dir = new Vec3(diffX, diffY, diffZ);
            dir.func_72432_b();
            event.getEntity().field_70159_w = dir.field_72450_a * pullSpeed;
            event.getEntity().field_70181_x = dir.field_72448_b * pullSpeed;
            event.getEntity().field_70179_y = dir.field_72449_c * pullSpeed;
            event.getEntity().field_70133_I = true;
        }
    }

    private BlockPos getNearestLog(LivingEvent.LivingUpdateEvent event, int radius) {
        double minDist = 99.0;
        BlockPos nearest = null;
        BlockPos entityPos = event.getEntity().func_180425_c();
        for (int x = entityPos.func_177958_n() - radius; x <= entityPos.func_177958_n() + radius; ++x) {
            for (int y = entityPos.func_177956_o() - radius; y <= entityPos.func_177956_o() + radius; ++y) {
                for (int z = entityPos.func_177952_p() - radius; z <= entityPos.func_177952_p() + radius; ++z) {
                    double dist;
                    BlockPos pos = new BlockPos(x, y, z);
                    BlockState state = event.getEntity().field_70170_p.func_180495_p(pos);
                    if (!(state.func_177230_c() instanceof ITetherable) || !((dist = pos.func_185332_f(entityPos.func_177958_n(), entityPos.func_177956_o(), entityPos.func_177952_p())) <= minDist)) continue;
                    minDist = dist;
                    nearest = new BlockPos((Vec3i)pos);
                }
            }
        }
        return nearest;
    }

    private void doContagion(LivingEntity entity, int level) {
        if (entity.func_70644_a(PotionInit.CONTAGIOUS)) {
            for (LivingEntity near_pl : entity.field_70170_p.func_72872_a(LivingEntity.class, entity.func_174813_aQ().func_72314_b(10.0, 4.0, 10.0))) {
                near_pl.func_70690_d(new PotionEffect(PotionInit.PLAGUE, 300, level));
                near_pl.func_70690_d(new PotionEffect(PotionInit.CONTAGIOUS, 300, level));
            }
            CustomParticleConfig config1 = new CustomParticleConfig();
            config1.createInstance().setParticle(ParticleInit.GLOOM_BURST).setSpread(1.0, 1.0, 1.0).setCount(3).setIgnoreRange(true);
            IParticleSpawner.spawnParticle(entity.field_70170_p, config1, entity.field_70165_t, entity.field_70163_u + (double)(entity.field_70131_O / 2.0f), entity.field_70161_v);
            entity.field_70170_p.func_184133_a(null, entity.func_180425_c(), SoundInit.MAGIC_WEAPON_7, SoundSource.PLAYERS, 1.0f, 1.0f);
            entity.func_70674_bp();
        }
    }

    @SubscribeEvent
    public void onEntityDeath(LivingDeathEvent event) {
        if (!(event.getEntity() instanceof Player)) {
            if (event.getEntity() instanceof EntityStarfiend) {
                EntityStarfiend fiend = (EntityStarfiend)event.getEntity();
                if (fiend.getScaleType() != 9) {
                    fiend.setScaleType((byte)(fiend.getScaleType() + 1));
                    fiend.func_70606_j(Float.MAX_VALUE);
                    event.setCanceled(true);
                }
            } else if (event.getEntity() instanceof EntityMultipleLives) {
                EntityMultipleLives creature = (EntityMultipleLives)event.getEntity();
                if (!creature.onFinalLife()) {
                    creature.takewayLife();
                    creature.func_70606_j(Float.MAX_VALUE);
                    event.setCanceled(true);
                } else {
                    EntityCthulhu cthulhu;
                    EntityDeviantMob deviant;
                    boolean flag = true;
                    if (creature instanceof EntityDeviantMob && (deviant = (EntityDeviantMob)creature).getMutation() != 0 && !deviant.atMaxMutation()) {
                        flag = false;
                        deviant.updateSupermutationAI();
                        deviant.func_70606_j(Float.MAX_VALUE);
                        deviant.increaseMutation();
                        deviant.setLivesCount(0);
                        event.setCanceled(true);
                    }
                    if (creature instanceof EntityCthulhu && !(cthulhu = (EntityCthulhu)creature).isEssenceCharged()) {
                        flag = false;
                        cthulhu.func_70606_j(Float.MAX_VALUE);
                        cthulhu.setLivesCount(cthulhu.numberOfLives());
                        event.setCanceled(true);
                    }
                    if (flag && !creature.didDeathAction()) {
                        creature.trueDeathAction();
                        creature.deathActionComplete();
                    }
                }
            } else if (event.getEntity() instanceof EntityMultiLivesTameable) {
                EntityMultiLivesTameable creature = (EntityMultiLivesTameable)event.getEntity();
                if (!creature.onFinalLife()) {
                    creature.takewayLife();
                    creature.func_70606_j(Float.MAX_VALUE);
                    event.setCanceled(true);
                } else if (!creature.didDeathAction()) {
                    creature.trueDeathAction();
                    creature.deathActionComplete();
                }
            }
        }
    }
}

