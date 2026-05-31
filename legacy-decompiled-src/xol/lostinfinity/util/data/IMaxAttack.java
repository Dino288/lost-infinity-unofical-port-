/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.entity.player.ServerPlayer
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Mth
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraft.world.World
 *  net.minecraft.world.biome.Biome
 */
package xol.lostinfinity.util.data;

import java.util.List;
import java.util.Set;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.common.special.CommonMinionHandler;
import xol.lostinfinity.dimension.util.IDamageRestricted;
import xol.lostinfinity.init.ArmorInit;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.init.PotionInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.item.armor.ItemLostArmor;
import xol.lostinfinity.item.armor.ItemSpectrosArmor;
import xol.lostinfinity.item.armor.ItemSpectrosPrimeArmor;
import xol.lostinfinity.item.classify.IHitReactive;
import xol.lostinfinity.item.classify.IHotbarDeath;
import xol.lostinfinity.item.classify.IHotbarHit;
import xol.lostinfinity.item.classify.IMaxNullable;
import xol.lostinfinity.item.classify.IMaxReducible;
import xol.lostinfinity.item.classify.ItemSoulbound;
import xol.lostinfinity.mob.entity.base.EntityImmaterial;
import xol.lostinfinity.mob.entity.base.EntityMultiLivesTameable;
import xol.lostinfinity.mob.entity.base.EntityMultipleLives;
import xol.lostinfinity.mob.entity.base.EntityMultipleLivesMount;
import xol.lostinfinity.mob.entity.base.EntityMultipleLivesRelay;
import xol.lostinfinity.mob.entity.base.IConditionalDamage;
import xol.lostinfinity.mob.entity.classify.IEntityReactive;
import xol.lostinfinity.mob.entity.classify.IKnockbackImmunity;
import xol.lostinfinity.mob.entity.classify.IOwnerReactive;
import xol.lostinfinity.mob.entity.minion.EntityMinion;
import xol.lostinfinity.mob.entity.misc.EntityPickleMan;
import xol.lostinfinity.util.data.CustomDamageResult;
import xol.lostinfinity.util.data.CustomParticleConfig;
import xol.lostinfinity.util.fx.IParticleSpawner;
import xol.lostinfinity.util.player.PlayerManager;

public interface IMaxAttack {
    public static CustomDamageResult dealMaxHealth(Entity attacker, LivingEntity entity, int de) {
        return IMaxAttack.dealMaxHealth(attacker, entity, de, 1.0f, null);
    }

    public static CustomDamageResult dealMaxHealth(Entity attacker, LivingEntity entity, int de, float multiplier) {
        return IMaxAttack.dealMaxHealth(attacker, entity, de, multiplier, null);
    }

    public static CustomDamageResult dealMaxHealth(Entity attacker, LivingEntity entity, int de, List<String> damageClass) {
        return IMaxAttack.dealMaxHealth(attacker, entity, de, 1.0f, damageClass);
    }

    public static CustomDamageResult dealPotionDamage(LivingEntity target, float effective_damage) {
        return IMaxAttack.dealPotionDamage(target, effective_damage, null);
    }

    public static CustomDamageResult dealTrueDamage(Entity attacker, LivingEntity target, float effective_damage) {
        return IMaxAttack.dealTrueDamage(attacker, target, effective_damage, null);
    }

    public static CustomDamageResult dealTrueDamage(Entity attacker, LivingEntity target, float effective_damage, List<String> damageClass) {
        return IMaxAttack.dealTrueDamage(null, attacker, target, effective_damage, damageClass);
    }

    public static CustomDamageResult dealMaxHealth(Entity attacker, LivingEntity targetedEntity, int de, float multiplier, List<String> damageClass) {
        float effectiveDamage = multiplier * (targetedEntity.func_110138_aP() / (float)de);
        CustomDamageResult damageResult = new CustomDamageResult(attacker, targetedEntity);
        damageResult.addClassifications(damageClass);
        damageResult.setIntendedDamage(effectiveDamage);
        if (!targetedEntity.field_70170_p.field_72995_K) {
            Biome biome;
            boolean cannotDoDamage = false;
            if (targetedEntity instanceof EntityImmaterial) {
                cannotDoDamage = true;
                damageResult.setHitInvalid();
            }
            if (targetedEntity instanceof Player) {
                Player playerTarget = (Player)targetedEntity;
                if (playerTarget.func_184812_l_()) {
                    cannotDoDamage = true;
                    damageResult.setHitInvalid();
                } else {
                    for (EntityMinion minion : CommonMinionHandler.getMinions(targetedEntity.func_110124_au())) {
                        if (!(minion instanceof IOwnerReactive)) continue;
                        ((IOwnerReactive)((Object)minion)).maxHealthDamageEffect(attacker, damageResult);
                    }
                    cannotDoDamage = !damageResult.didSuccessfulHit();
                    for (int i = 0; i < playerTarget.field_71071_by.func_70302_i_(); ++i) {
                        ItemStack stack = playerTarget.field_71071_by.func_70301_a(i);
                        if (stack.func_77973_b() != ItemInit.essencePossessor) continue;
                        int attackerId = attacker.func_145782_y();
                        CompoundTag compound = stack.func_77978_p();
                        boolean hit = true;
                        if (attackerId == compound.func_74762_e("id1")) {
                            if (System.currentTimeMillis() < compound.func_74763_f("time1") + 30000L) {
                                hit = false;
                            }
                        } else if (attackerId == compound.func_74762_e("id2")) {
                            if (System.currentTimeMillis() < compound.func_74763_f("time2") + 30000L) {
                                hit = false;
                            }
                        } else if (attackerId == compound.func_74762_e("id3") && System.currentTimeMillis() < compound.func_74763_f("time3") + 30000L) {
                            hit = false;
                        }
                        if (hit) continue;
                        cannotDoDamage = true;
                        damageResult.setHitInvalid();
                        break;
                    }
                }
            }
            if (targetedEntity.field_70128_L || targetedEntity.func_110143_aJ() <= 0.0f) {
                cannotDoDamage = true;
                damageResult.setHitInvalid();
            }
            if ((biome = attacker.field_70170_p.func_180494_b(attacker.func_180425_c())) instanceof IDamageRestricted) {
                IDamageRestricted restrictedBiome = (IDamageRestricted)biome;
                if (damageClass == null || !damageClass.contains(restrictedBiome.allowedTypes())) {
                    cannotDoDamage = true;
                    damageResult.setHitMissed();
                }
            }
            if (targetedEntity.func_70644_a(PotionInit.OTHERWORLDLY) && (damageClass == null || !damageClass.contains("Darkborn"))) {
                cannotDoDamage = true;
                damageResult.setHitMissed();
            }
            if (!cannotDoDamage) {
                attacker.func_184185_a(SoundEvents.field_187718_dS, 2.0f, 3.0f);
                if (attacker instanceof LivingEntity) {
                    ((LivingEntity)attacker).func_130011_c((Entity)targetedEntity);
                }
                if (targetedEntity instanceof Player) {
                    effectiveDamage = IMaxAttack.performDamageReduction(damageResult, (Player)targetedEntity, effectiveDamage);
                }
                effectiveDamage = IMaxAttack.performTargetPotionChecks(damageResult, attacker, targetedEntity, effectiveDamage);
                if (attacker instanceof LivingEntity) {
                    effectiveDamage = IMaxAttack.performAttackerPotionChecks(damageResult, (LivingEntity)attacker, effectiveDamage);
                }
                if (effectiveDamage > 0.0f) {
                    if (targetedEntity instanceof Player && IMaxAttack.hookPlayerHitEffect(damageResult, attacker, (Player)targetedEntity, effectiveDamage)) {
                        return damageResult;
                    }
                    if (attacker instanceof Player && IMaxAttack.hookPlayerAttackEffect(damageResult, (Player)attacker, targetedEntity, de, multiplier, effectiveDamage)) {
                        return damageResult;
                    }
                    if (targetedEntity instanceof Player && targetedEntity.func_110143_aJ() - effectiveDamage <= 0.0f) {
                        Player playerTarget = (Player)targetedEntity;
                        for (int i = 0; i <= 8; ++i) {
                            IHotbarDeath hotbarItem;
                            boolean wasKilled;
                            ItemStack stack = playerTarget.field_71071_by.func_70301_a(i);
                            if (!(stack.func_77973_b() instanceof IHotbarDeath) || (wasKilled = (hotbarItem = (IHotbarDeath)stack.func_77973_b()).playedKilled(stack, playerTarget, attacker, effectiveDamage))) continue;
                            return damageResult;
                        }
                    }
                    IMaxAttack.dealTrueDamage(damageResult, attacker, targetedEntity, effectiveDamage, damageClass);
                }
            }
        }
        return damageResult;
    }

    public static CustomDamageResult dealPotionDamage(LivingEntity target, float effective_damage, List<String> damageClass) {
        CustomDamageResult damageResult = new CustomDamageResult(null, target);
        damageResult.setIntendedDamage(effective_damage);
        damageResult.addClassifications(damageClass);
        float newDamage = effective_damage;
        if (target.func_70644_a(PotionInit.POTION_AFFINITY)) {
            int amp = target.func_70660_b(PotionInit.POTION_AFFINITY).func_76458_c();
            newDamage = Math.max(0.0f, 0.9f - 0.1f * (float)amp);
            damageResult.addReduction(effective_damage - newDamage);
        }
        return IMaxAttack.dealTrueDamage(damageResult, null, target, newDamage, damageClass);
    }

    public static CustomDamageResult dealTrueDamage(CustomDamageResult incomingResult, Entity attacker, LivingEntity target, float effective_damage, List<String> damageClass) {
        CustomDamageResult damageResult = incomingResult;
        if (damageResult == null) {
            damageResult = new CustomDamageResult(attacker, (LivingEntity)target);
            damageResult.setIntendedDamage(effective_damage);
            damageResult.addClassifications(damageClass);
        }
        if (!target.field_70170_p.field_72995_K) {
            Biome biome;
            float postReducedDamage = effective_damage;
            if (target.field_70128_L || target.func_110143_aJ() <= 0.0f) {
                damageResult.setHitInvalid();
                postReducedDamage = 0.0f;
            } else if (target.func_70644_a(PotionInit.PROTECTED)) {
                damageResult.setHitMissed();
                postReducedDamage = 0.0f;
            } else if (target instanceof EntityImmaterial) {
                damageResult.setHitInvalid();
                postReducedDamage = 0.0f;
            } else if (target instanceof IConditionalDamage) {
                IConditionalDamage condEntity;
                if (attacker != null && !(condEntity = (IConditionalDamage)target).canBeDamaged(attacker)) {
                    damageResult.setHitMissed();
                    postReducedDamage = 0.0f;
                }
            } else if (target instanceof Player && ((Player)target).func_184812_l_()) {
                damageResult.setHitInvalid();
                postReducedDamage = 0.0f;
            }
            if (target.func_70644_a(PotionInit.PLANESPLIT)) {
                int level = target.func_70660_b(PotionInit.PLANESPLIT).func_76458_c();
                int randDodge = target.field_70170_p.field_73012_v.nextInt(100);
                if (randDodge <= 10 + 10 * level) {
                    damageResult.setHitMissed();
                    postReducedDamage = 0.0f;
                }
            }
            if (target.func_70644_a(PotionInit.SUPERCHARGED) && target.field_70170_p.field_73012_v.nextBoolean()) {
                damageResult.setHitMissed();
                postReducedDamage = 0.0f;
            }
            if (target.func_70644_a(PotionInit.FEARED) && attacker instanceof LivingEntity && ((LivingEntity)attacker).func_70644_a(PotionInit.TERRIFIED) && target.field_70170_p.field_73012_v.nextBoolean()) {
                damageResult.setHitMissed();
                postReducedDamage = 0.0f;
            }
            if ((biome = target.field_70170_p.func_180494_b(target.func_180425_c())) instanceof IDamageRestricted) {
                IDamageRestricted restrictedBiome = (IDamageRestricted)biome;
                if (damageClass == null || !damageClass.contains(restrictedBiome.allowedTypes())) {
                    damageResult.setHitMissed();
                    postReducedDamage = 0.0f;
                }
            }
            if (target.func_70644_a(PotionInit.OTHERWORLDLY) && (damageClass == null || !damageClass.contains("Darkborn"))) {
                damageResult.setHitMissed();
                postReducedDamage = 0.0f;
            }
            if (target instanceof IEntityReactive && attacker instanceof LivingEntity && (postReducedDamage = ((IEntityReactive)target).hitEffect((LivingEntity)attacker, postReducedDamage)) == 0.0f) {
                damageResult.setHitMissed();
            }
            if (postReducedDamage > 0.0f && target instanceof Player && (postReducedDamage = IMaxAttack.performTrueReduction(damageResult, (Player)target, attacker, effective_damage)) == 0.0f) {
                damageResult.setHitMissed();
            }
            if (target instanceof EntityMultipleLivesRelay) {
                target = ((EntityMultipleLivesRelay)target).getRelay();
            }
            if (target.func_184208_bv() instanceof EntityMultipleLivesMount) {
                target = (LivingEntity)target.func_184208_bv();
                ((EntityMultipleLivesMount)target).onDriverDamaged((Entity)target, damageResult);
            }
            if (target instanceof Player) {
                Set<EntityMinion> minions = CommonMinionHandler.getMinions(target.func_110124_au());
                for (EntityMinion minion : minions) {
                    if (!(minion instanceof IOwnerReactive)) continue;
                    ((IOwnerReactive)((Object)minion)).trueDamageEffect(attacker, damageResult);
                }
            }
            float newHp = target.func_110143_aJ() - postReducedDamage;
            damageResult.finishHitData(postReducedDamage, newHp);
            if (damageResult.didSuccessfulHit()) {
                if (damageResult.targetHealthChanged()) {
                    if (attacker != null) {
                        if (attacker instanceof LivingEntity) {
                            ((LivingEntity)attacker).func_130011_c((Entity)target);
                        }
                        double x = Mth.func_151237_a((double)(attacker.field_70159_w * 0.5), (double)-0.1, (double)0.1);
                        double y = 0.1;
                        double z = Mth.func_151237_a((double)(attacker.field_70179_y * 0.5), (double)-0.1, (double)0.1);
                        if (target instanceof IKnockbackImmunity) {
                            float res = 1.0f - ((IKnockbackImmunity)target).getKnockbackResistance(damageResult);
                            x *= (double)res;
                            y *= (double)res;
                            z *= (double)res;
                        }
                        target.func_70024_g(x, y, z);
                        target.field_70133_I = true;
                    }
                    if (!(target instanceof Player) && !damageResult.didTargetLoseLife()) {
                        target.func_70097_a(DamageSource.field_76376_m, 0.0f);
                    }
                }
                target.func_70606_j(newHp);
                if (target.func_110143_aJ() <= 0.0f) {
                    Object multiLifer;
                    boolean didKill = false;
                    if (target instanceof EntityMultiLivesTameable) {
                        multiLifer = (EntityMultiLivesTameable)((Object)target);
                        if (multiLifer.onFinalLife()) {
                            didKill = true;
                        }
                    } else if (target instanceof EntityMultipleLives) {
                        multiLifer = (EntityMultipleLives)target;
                        if (((EntityMultipleLives)multiLifer).onFinalLife()) {
                            didKill = true;
                        }
                    } else {
                        didKill = true;
                    }
                    if (attacker != null && attacker instanceof Player && didKill) {
                        IMaxAttack.hookPlayerKillEffect((Player)attacker, target);
                    }
                    if (target instanceof Player) {
                        if (!target.field_70170_p.func_82736_K().func_82766_b("keepInventory")) {
                            Player pl = (Player)target;
                            ItemSoulbound.removeSoulBound(pl);
                            pl.field_71071_by.func_70436_m();
                        }
                        if (attacker != null) {
                            target.func_184102_h().func_184103_al().func_148539_a((Component)new Component((Object)((Object)TextFmt.Gray) + target.func_70005_c_() + IMaxAttack.getRandomDeathMessage(target.field_70170_p) + attacker.func_70005_c_()));
                        }
                        target.func_70106_y();
                    } else {
                        target.func_70645_a(DamageSource.field_76376_m);
                    }
                }
            }
        }
        return damageResult;
    }

    public static boolean hookPlayerAttackEffect(CustomDamageResult result, Player attacker, LivingEntity targeted, int de, float multiplier, float effective_damage) {
        Level world = attacker.field_70170_p;
        if (PlayerManager.isPlayerWearingFullSet(attacker, ArmorInit.spectrosSet)) {
            ItemStack stack = attacker.field_71071_by.func_70301_a(39);
            ItemSpectrosArmor spectros = (ItemSpectrosArmor)stack.func_77973_b();
            spectros.spectreEffect(world, attacker, targeted, stack);
        } else if (PlayerManager.isPlayerWearingFullSet(attacker, ArmorInit.spectrosPrimeSet)) {
            ItemStack stack = attacker.field_71071_by.func_70301_a(39);
            ItemSpectrosPrimeArmor spectros = (ItemSpectrosPrimeArmor)stack.func_77973_b();
            spectros.spectreEffect(world, attacker, targeted, stack);
        } else if (PlayerManager.isPlayerWearingFullSet(attacker, ArmorInit.blightcystSet)) {
            if (!world.field_72995_K && !attacker.func_70644_a(PotionInit.NULLIFIED)) {
                float storedDamage;
                ItemStack helm = (ItemStack)attacker.field_71071_by.field_70460_b.get(3);
                if (!helm.func_77942_o()) {
                    helm.func_77982_d(new CompoundTag());
                }
                if ((storedDamage = helm.func_77978_p().func_74760_g("DamageStored")) == 0.0f) {
                    IMaxAttack.dealMaxHealth((Entity)targeted, (LivingEntity)attacker, 10, 3.0f);
                } else {
                    IMaxAttack.dealTrueDamage((Entity)attacker, targeted, storedDamage);
                    helm.func_77978_p().func_74776_a("DamageStored", 0.0f);
                }
            }
        } else if (PlayerManager.isPlayerWearingFullSet(attacker, ArmorInit.blightcystPrimeSet) && !world.field_72995_K && !attacker.func_70644_a(PotionInit.NULLIFIED)) {
            float storedDamage;
            ItemStack helm = (ItemStack)attacker.field_71071_by.field_70460_b.get(3);
            if (!helm.func_77942_o()) {
                helm.func_77982_d(new CompoundTag());
            }
            if ((storedDamage = helm.func_77978_p().func_74760_g("DamageStored")) > 0.0f) {
                IMaxAttack.dealTrueDamage((Entity)attacker, targeted, storedDamage);
                helm.func_77978_p().func_74776_a("DamageStored", 0.0f);
            }
        }
        return false;
    }

    public static float performTargetPotionChecks(CustomDamageResult result, Entity attacker, LivingEntity target, float damage) {
        int level;
        float newDmg = damage;
        if (target.func_70644_a(PotionInit.VULNERABILITY)) {
            level = target.func_70660_b(PotionInit.VULNERABILITY).func_76458_c();
            newDmg *= 1.2f + 0.2f * (float)level;
        }
        if (target.func_70644_a(PotionInit.RAMPAGING)) {
            level = 1 + target.func_70660_b(PotionInit.RAMPAGING).func_76458_c();
            float reduction = 1.0f - 0.06f * (float)level;
            newDmg *= reduction;
        }
        if (target.func_70644_a(PotionInit.IRONHEART)) {
            newDmg = 0.0f;
        }
        if (target.func_70644_a(PotionInit.SHATTERED)) {
            newDmg = 0.0f;
            level = target.func_70660_b(PotionInit.SHATTERED).func_76458_c();
            target.func_184596_c(PotionInit.SHATTERED);
            float multi = 1.0f + (float)level * 0.2f;
            IMaxAttack.dealTrueDamage(attacker, target, damage * multi);
        }
        return newDmg;
    }

    public static float performAttackerPotionChecks(CustomDamageResult result, LivingEntity attacker, float damage) {
        int level;
        float newDmg = damage;
        if (attacker.func_70644_a(PotionInit.ADRENALINE)) {
            level = attacker.func_70660_b(PotionInit.ADRENALINE).func_76458_c();
            newDmg *= 1.3f + 0.3f * (float)level;
        }
        if (attacker.func_70644_a(PotionInit.BLIGHTED)) {
            level = attacker.func_70660_b(PotionInit.BLIGHTED).func_76458_c();
            float reducer = Math.max(0.3f - 0.05f * (float)level, 0.0f);
            newDmg *= reducer;
        }
        if (attacker.func_70644_a(PotionInit.RAMPAGING)) {
            level = 1 + attacker.func_70660_b(PotionInit.RAMPAGING).func_76458_c();
            float increase = 1.0f + 0.05f * (float)level;
            newDmg *= increase;
        }
        return newDmg;
    }

    public static float performTrueReduction(CustomDamageResult result, Player playerIn, Entity attacker, float damage) {
        float newDamage = damage;
        if (PlayerManager.isPlayerWearingFullSet(playerIn, ArmorInit.bionicveggitronSet)) {
            for (EntityPickleMan near_pickle : playerIn.field_70170_p.func_72872_a(EntityPickleMan.class, playerIn.func_174813_aQ().func_186662_g(18.0))) {
                if (!near_pickle.func_184753_b().equals(playerIn.func_110124_au())) continue;
                near_pickle.func_70106_y();
                near_pickle.field_70170_p.func_184133_a(null, near_pickle.func_180425_c(), SoundInit.MAGIC_WEAPON_7, SoundSource.PLAYERS, 1.0f, 1.0f);
                CustomParticleConfig config1 = new CustomParticleConfig();
                config1.createInstance().setParticle(ParticleInit.GLOOM_BURST).setSpread(1.0, 1.0, 1.0).setCount(3).setIgnoreRange(true);
                IParticleSpawner.spawnParticle(near_pickle.field_70170_p, config1, near_pickle.field_70165_t, near_pickle.field_70163_u + (double)(near_pickle.field_70131_O / 2.0f), near_pickle.field_70161_v);
                result.addReduction(newDamage);
                newDamage = 0.0f;
                break;
            }
        } else if (PlayerManager.isPlayerWearingFullSet(playerIn, ArmorInit.vitralitonPrimeSet)) {
            if (playerIn.func_110143_aJ() == playerIn.func_110138_aP() && playerIn.field_70170_p.field_73012_v.nextInt(4) != 0) {
                newDamage = 0.0f;
                playerIn.field_70170_p.func_184133_a(null, playerIn.func_180425_c(), SoundInit.RAPID_DODGE, SoundSource.PLAYERS, 0.5f, 0.7f + playerIn.field_70170_p.field_73012_v.nextFloat() * 0.6f);
            }
        } else if (PlayerManager.isPlayerWearingFullSet(playerIn, ArmorInit.blightcystPrimeSet) && !playerIn.func_70644_a(PotionInit.NULLIFIED)) {
            ItemStack helm = (ItemStack)playerIn.field_71071_by.field_70460_b.get(3);
            if (playerIn.field_70170_p.field_73012_v.nextBoolean() && !helm.func_77942_o()) {
                helm.func_77982_d(new CompoundTag());
                float storedDamage = helm.func_77978_p().func_74760_g("DamageStored");
                helm.func_77978_p().func_74776_a("DamageStored", storedDamage += damage);
                newDamage = 0.0f;
            }
        }
        if (playerIn.func_70644_a(PotionInit.SUPERCHARGED)) {
            int amp = playerIn.func_70660_b(PotionInit.SUPERCHARGED).func_76458_c();
            if (damage / 2.0f > playerIn.func_110143_aJ() && amp > 0) {
                newDamage = 0.0f;
                playerIn.func_70606_j(playerIn.func_110138_aP());
                playerIn.func_184589_d(PotionInit.SUPERCHARGED);
                playerIn.func_70690_d(new PotionEffect(PotionInit.SUPERCHARGED, 72000, amp - 1));
                if (attacker instanceof Player) {
                    attacker.func_145747_a((Component)new Component("Super-Charged target has " + amp + " lives remaining"));
                }
            } else {
                newDamage = damage / 2.0f;
            }
        }
        float multiplier = 1.0f;
        for (int i = 0; i < 2; ++i) {
            ItemStack heldByTarget;
            ItemStack itemStack = heldByTarget = i == 0 ? playerIn.func_184614_ca() : playerIn.func_184592_cb();
            if (!(heldByTarget.func_77973_b() instanceof IMaxReducible)) continue;
            IMaxReducible reducible = (IMaxReducible)heldByTarget.func_77973_b();
            multiplier = reducible.reduceMaxDamage(playerIn, i == 0, newDamage, multiplier, heldByTarget);
        }
        multiplier = Math.max(multiplier, 0.2f);
        float return_damage = newDamage * multiplier;
        for (int i = 0; i < 2; ++i) {
            ItemStack heldByTarget;
            ItemStack itemStack = heldByTarget = i == 0 ? playerIn.func_184614_ca() : playerIn.func_184592_cb();
            if (!(heldByTarget.func_77973_b() instanceof IMaxNullable)) continue;
            IMaxNullable nullable = (IMaxNullable)heldByTarget.func_77973_b();
            return_damage = nullable.trueNullableReaction(playerIn, i == 0, damage, return_damage, heldByTarget, result);
            return_damage = nullable.nullableReaction(playerIn, i == 0, damage, return_damage, heldByTarget);
        }
        return return_damage;
    }

    public static float performDamageReduction(CustomDamageResult result, Player playerIn, float damage) {
        float multiplier = 1.0f;
        float originalDamage = damage;
        boolean hasPrime = false;
        for (ItemStack stack : playerIn.func_184193_aE()) {
            if (!(stack.func_77973_b() instanceof ItemLostArmor)) continue;
            multiplier -= 0.02f;
            if (!((ItemLostArmor)stack.func_77973_b()).isPrimeSet()) continue;
            hasPrime = true;
        }
        if (PlayerManager.isWearingAnySet(playerIn)) {
            multiplier = hasPrime ? (multiplier -= 0.22f) : (multiplier -= 0.07f);
        }
        for (int i = 0; i < 2; ++i) {
            ItemStack heldByTarget;
            ItemStack itemStack = heldByTarget = i == 0 ? playerIn.func_184614_ca() : playerIn.func_184592_cb();
            if (!(heldByTarget.func_77973_b() instanceof IMaxReducible)) continue;
            IMaxReducible reducible = (IMaxReducible)heldByTarget.func_77973_b();
            multiplier = reducible.reduceMaxDamage(playerIn, i == 0, originalDamage, multiplier, heldByTarget);
        }
        multiplier = Math.max(multiplier, 0.2f);
        float return_damage = originalDamage * multiplier;
        for (int i = 0; i < 2; ++i) {
            ItemStack heldByTarget;
            ItemStack itemStack = heldByTarget = i == 0 ? playerIn.func_184614_ca() : playerIn.func_184592_cb();
            if (!(heldByTarget.func_77973_b() instanceof IMaxNullable)) continue;
            IMaxNullable nullable = (IMaxNullable)heldByTarget.func_77973_b();
            return_damage = nullable.nullableReaction(playerIn, i == 0, damage, return_damage, heldByTarget);
        }
        return return_damage;
    }

    public static boolean hookPlayerHitEffect(CustomDamageResult result, Entity attacker, Player targeted, float effective_damage) {
        int i;
        float storedDamage;
        ItemStack helm;
        if (PlayerManager.isPlayerWearingFullSet(targeted, ArmorInit.plasmythicSet) && attacker instanceof LivingEntity && !((LivingEntity)attacker).func_70644_a(PotionInit.NULLIFIED)) {
            IMaxAttack.dealTrueDamage((Entity)targeted, (LivingEntity)attacker, effective_damage * 0.35f);
        }
        if (PlayerManager.isPlayerWearingFullSet(targeted, ArmorInit.blightcystSet)) {
            if (!targeted.func_70644_a(PotionInit.NULLIFIED)) {
                helm = (ItemStack)targeted.field_71071_by.field_70460_b.get(3);
                if (!helm.func_77942_o()) {
                    helm.func_77982_d(new CompoundTag());
                }
                storedDamage = helm.func_77978_p().func_74760_g("DamageStored");
                helm.func_77978_p().func_74776_a("DamageStored", storedDamage += effective_damage * 0.25f);
            }
        } else if (PlayerManager.isPlayerWearingFullSet(targeted, ArmorInit.blightcystPrimeSet) && !targeted.func_70644_a(PotionInit.NULLIFIED)) {
            helm = (ItemStack)targeted.field_71071_by.field_70460_b.get(3);
            if (!helm.func_77942_o()) {
                helm.func_77982_d(new CompoundTag());
            }
            storedDamage = helm.func_77978_p().func_74760_g("DamageStored");
            helm.func_77978_p().func_74776_a("DamageStored", storedDamage += effective_damage);
        }
        for (i = 0; i < 2; ++i) {
            ItemStack heldByTarget;
            ItemStack itemStack = heldByTarget = i == 0 ? targeted.func_184614_ca() : targeted.func_184592_cb();
            if (!(heldByTarget.func_77973_b() instanceof IHitReactive)) continue;
            IHitReactive reactiveItem = (IHitReactive)heldByTarget.func_77973_b();
            reactiveItem.hitReaction(targeted, attacker, effective_damage, heldByTarget);
        }
        for (i = 0; i <= 8; ++i) {
            ItemStack stack = targeted.field_71071_by.func_70301_a(i);
            if (!(stack.func_77973_b() instanceof IHotbarHit)) continue;
            IHotbarHit hotbarItem = (IHotbarHit)stack.func_77973_b();
            hotbarItem.hitReaction(targeted, attacker, result, stack);
        }
        if (attacker instanceof LivingEntity) {
            if (targeted.func_184592_cb().func_77973_b().equals(ItemInit.mirrorShield)) {
                IMaxAttack.dealTrueDamage((Entity)targeted, (LivingEntity)attacker, effective_damage);
            } else if (targeted.func_184592_cb().func_77973_b().equals(ItemInit.arcOfTheForbidden)) {
                IMaxAttack.dealTrueDamage((Entity)targeted, (LivingEntity)attacker, effective_damage * 0.7f);
            } else if (targeted.func_184592_cb().func_77973_b().equals(ItemInit.dualDefender)) {
                if (targeted.func_110143_aJ() == targeted.func_110138_aP()) {
                    IMaxAttack.dealTrueDamage((Entity)targeted, (LivingEntity)attacker, effective_damage * 0.25f);
                } else {
                    IMaxAttack.dealTrueDamage((Entity)targeted, (LivingEntity)attacker, effective_damage * 1.25f);
                }
            }
        }
        ItemStack vessel = null;
        for (int i2 = 0; i2 <= 8; ++i2) {
            ItemStack stack = targeted.field_71071_by.func_70301_a(i2);
            if (!stack.func_77973_b().equals(ItemInit.lifeVessel)) continue;
            vessel = stack;
            break;
        }
        if (vessel != null) {
            float charge;
            if (!vessel.func_77942_o()) {
                vessel.func_77982_d(new CompoundTag());
                vessel.func_77978_p().func_74776_a("charge", 0.0f);
            }
            if ((charge = vessel.func_77978_p().func_74760_g("charge")) != 100.0f) {
                if (vessel.func_77978_p().func_186855_b("target")) {
                    ServerPlayer vessel_bound_player = targeted.field_70170_p.func_73046_m().func_184103_al().func_177451_a(vessel.func_77978_p().func_186857_a("target"));
                    if (vessel_bound_player != null) {
                        if (!vessel_bound_player.field_70128_L) {
                            float newhp = vessel_bound_player.func_110143_aJ() - effective_damage;
                            if (newhp <= 0.0f) {
                                vessel.func_77978_p().func_82580_o("targetMost");
                                vessel.func_77978_p().func_82580_o("targetLeast");
                                targeted.field_70170_p.func_184133_a(null, new BlockPos(targeted.field_70165_t, targeted.field_70163_u, targeted.field_70161_v), SoundEvents.field_187561_bM, SoundSource.MASTER, 1.0f, 1.0f);
                            }
                            IMaxAttack.dealTrueDamage((Entity)targeted, (LivingEntity)vessel_bound_player, effective_damage);
                            return true;
                        }
                    } else {
                        vessel.func_77978_p().func_82580_o("targetMost");
                        vessel.func_77978_p().func_82580_o("targetLeast");
                    }
                } else if (!vessel.func_77978_p().func_186855_b("target")) {
                    float percentage = effective_damage / targeted.func_110138_aP() * 50.0f;
                    if ((percentage += charge) >= 100.0f) {
                        percentage = 100.0f;
                        targeted.field_70170_p.func_184133_a(null, new BlockPos(targeted.field_70165_t, targeted.field_70163_u, targeted.field_70161_v), SoundEvents.field_187754_de, SoundSource.MASTER, 1.0f, 1.0f);
                    }
                    vessel.func_77978_p().func_74776_a("charge", percentage);
                }
            }
        }
        return false;
    }

    public static void hookPlayerKillEffect(Player attacker, LivingEntity killed) {
        for (int i = 0; i <= 8; ++i) {
            int addcharge;
            ItemStack stack = attacker.field_71071_by.func_70301_a(i);
            if (!stack.func_77973_b().equals(ItemInit.containerOfCollectionEmpty)) continue;
            int n = addcharge = killed instanceof Player ? 50 : 1;
            if (!stack.func_77942_o()) {
                stack.func_77982_d(new CompoundTag());
                stack.func_77978_p().func_74768_a("charge", addcharge);
                continue;
            }
            int newcharges = stack.func_77978_p().func_74762_e("charge") + addcharge;
            if (newcharges >= 250) {
                ItemStack full_container = new ItemStack(ItemInit.containerOfCollectionFull, 1);
                attacker.field_71071_by.func_70299_a(i, full_container);
                continue;
            }
            stack.func_77978_p().func_74768_a("charge", newcharges);
        }
        if (killed.func_70644_a(PotionInit.SUPERCHARGED)) {
            killed.func_145779_a(ItemInit.containedLifeforce, 1);
        }
        if (attacker.func_70644_a(PotionInit.RAMPAGING)) {
            PotionEffect activePot = attacker.func_70660_b(PotionInit.RAMPAGING);
            int level = activePot.func_76458_c();
            int duration = activePot.func_76459_b();
            if (level < 9) {
                ++level;
            }
            SoundEvent sound = level < 2 ? SoundInit.RAMPAGE_1 : (level < 4 ? SoundInit.RAMPAGE_2 : (level < 6 ? SoundInit.RAMPAGE_3 : (level < 8 ? SoundInit.RAMPAGE_4 : SoundInit.RAMPAGE_5)));
            attacker.field_70170_p.func_184133_a(null, attacker.func_180425_c(), sound, SoundSource.PLAYERS, 1.25f, 1.0f);
            if ((duration += 300) > 1000) {
                duration = 1000;
            }
            attacker.func_70690_d(new PotionEffect(PotionInit.RAMPAGING, duration, level));
        }
        if (PlayerManager.isPlayerWearingFullSet(attacker, ArmorInit.bionicveggitronSet)) {
            Level world = attacker.field_70170_p;
            EntityPickleMan pickleman = new EntityPickleMan(world);
            pickleman.func_70107_b(killed.field_70165_t, killed.field_70163_u + 0.5, killed.field_70161_v);
            pickleman.func_193101_c(attacker);
            world.func_72838_d((Entity)pickleman);
            CustomParticleConfig config1 = new CustomParticleConfig();
            config1.createInstance().setParticle(ParticleInit.NATURE_MAGIC).setSpread(4.0, 1.0, 4.0).setCount(10).setIgnoreRange(true);
            IParticleSpawner.spawnParticle(world, config1, killed.field_70165_t, killed.field_70163_u + 0.5, killed.field_70161_v);
        }
    }

    public static String getRandomDeathMessage(Level w) {
        switch (w.field_73012_v.nextInt(17)) {
            case 0: {
                return " was brutally slain by ";
            }
            case 1: {
                return " had no chance fighting ";
            }
            case 2: {
                return " got completely dominated by ";
            }
            case 3: {
                return " was ripped apart by ";
            }
            case 4: {
                return " was humiliated by ";
            }
            case 5: {
                return " attempted to fight ";
            }
            case 6: {
                return " was far weaker than ";
            }
            case 7: {
                return " was no match for ";
            }
            case 8: {
                return " got wrecked by ";
            }
            case 9: {
                return " was shown who is the boss by ";
            }
            case 10: {
                return " is a joke compared to ";
            }
            case 11: {
                return " wishes they had a chance against ";
            }
            case 12: {
                return " tried and tried but still failed against ";
            }
            case 13: {
                return " got rolled by ";
            }
            case 14: {
                return " was a fool for attempting to fight ";
            }
            case 15: {
                return " was decimated by ";
            }
            case 16: {
                return " was split in half by ";
            }
        }
        return "";
    }
}

