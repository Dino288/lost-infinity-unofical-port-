/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.init.Blocks
 *  net.minecraft.init.MobEffects
 *  net.minecraft.item.ItemStack
 *  net.minecraft.potion.Potion
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.util.math.Mth
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraft.world.DimensionType
 *  net.minecraftforge.common.BiomeDictionary
 *  net.minecraftforge.common.BiomeDictionary$Type
 */
package xol.lostinfinity.dimension.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.world.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.Mth;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.DimensionType;
import net.minecraftforge.common.BiomeDictionary;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.dimension.util.DimensionActivator;
import xol.lostinfinity.dimension.util.DimensionEffect;
import xol.lostinfinity.init.ArmorInit;
import xol.lostinfinity.init.DimensionInit;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.init.PotionInit;
import xol.lostinfinity.util.player.PlayerManager;

public class DimensionEffectRegistry {
    private static final Map<DimensionType, DimensionEffect> DIMENSION_EFFECTS = new HashMap<DimensionType, DimensionEffect>();

    public static void dimensionEffect(DimensionType type, DimensionEffect effect) {
        DIMENSION_EFFECTS.put(type, effect);
    }

    public static void tickPlayerDimensionEffects(Player player) {
        DimensionType type = player.field_70170_p.field_73011_w.func_186058_p();
        DimensionEffect effect = DIMENSION_EFFECTS.getOrDefault(type, null);
        if (effect != null) {
            effect.tickPlayerInDimension(player);
        }
    }

    public static double randomCoordinate(Random rand) {
        return (-0.5 + rand.nextDouble()) * 10000.0;
    }

    public static void registerDimensionEffects() {
        DimensionEffectRegistry.dimensionEffect(DimensionType.OVERWORLD, new DimensionEffect(){

            @Override
            public void tickPlayerInDimension(Player player) {
                ItemStack held;
                if (player.field_70170_p.func_180495_p(player.func_180425_c().func_177982_a(0, 2, 0)).func_177230_c().equals(Blocks.field_150353_l)) {
                    ItemStack held2 = player.func_184614_ca();
                    if (held2.func_77973_b().equals(ItemInit.forgeFirePickaxe)) {
                        DimensionActivator.transferEntityWithCoords((Entity)player, DimensionInit.nonexistence, 24.0, 110.0, 17.0);
                    }
                } else if (player.field_70170_p.func_180495_p(player.func_180425_c().func_177982_a(0, 2, 0)).func_177230_c().equals(Blocks.field_150355_j) && (held = player.func_184614_ca()).func_77973_b().equals(ItemInit.seaboundCompass) && player.field_70181_x <= -1.0 && BiomeDictionary.getBiomes((BiomeDictionary.Type)BiomeDictionary.Type.OCEAN).contains(player.field_70170_p.func_180494_b(player.func_180425_c()))) {
                    DimensionActivator.transferEntityWithCoords((Entity)player, DimensionInit.shadowSea, DimensionEffectRegistry.randomCoordinate(player.field_70170_p.field_73012_v), 160.0, DimensionEffectRegistry.randomCoordinate(player.field_70170_p.field_73012_v));
                }
            }
        });
        DimensionEffectRegistry.dimensionEffect(DimensionInit.celestialVoid, new DimensionEffect(){

            @Override
            public void tickPlayerInDimension(Player player) {
                ItemStack helm;
                if (player.field_70165_t < 700.0 && player.field_70165_t > -50.0 && (helm = player.field_71071_by.func_70301_a(39)).func_77973_b() != ArmorInit.celestialHeadguard && !PlayerManager.isWearingAnySet(player) && !player.field_70170_p.field_72995_K) {
                    DimensionActivator.transferEntity((Entity)player, DimensionType.OVERWORLD);
                    player.func_145747_a((Component)new Component((Object)((Object)TextFmt.Aqua) + "Challengers must wear a Celestial Headguard."));
                }
                if (!player.field_70170_p.field_72995_K && !player.func_70644_a(Potion.func_188412_a((int)23))) {
                    player.func_70690_d(new PotionEffect(Potion.func_188412_a((int)23), 601, 0, true, false));
                }
                if (!player.field_70170_p.field_72995_K && !player.func_184812_l_() && player.field_71075_bZ.field_75100_b) {
                    player.func_70606_j(0.5f);
                    if (player.field_70173_aa % 40 == 0) {
                        player.func_145747_a((Component)new Component((Object)((Object)TextFmt.Dark_Purple) + "Flight damages your lungs due to the lack of atmosphere."));
                    }
                }
            }
        });
        DimensionEffectRegistry.dimensionEffect(DimensionInit.nonexistence, new DimensionEffect(){

            @Override
            public void tickPlayerInDimension(Player player) {
                if (player.func_70644_a(MobEffects.field_76439_r) && !player.func_184812_l_()) {
                    if (player.func_110143_aJ() > 0.0f) {
                        player.func_70606_j(0.5f);
                    }
                    if (player.field_70173_aa % 30 == 0 && !player.field_70170_p.field_72995_K) {
                        player.func_145747_a((Component)new Component((Object)((Object)TextFmt.Red) + "Nightvision causes your eyes to burn from fumes in the air. You feel severely weakened."));
                    }
                }
                boolean hasLostArmor = PlayerManager.isWearingAnySet(player);
                ItemStack helm = player.field_71071_by.func_70301_a(39);
                if (!(helm.func_77973_b().equals(ArmorInit.filtrationMask) || hasLostArmor || player.field_70170_p.field_72995_K || player.func_184812_l_() || !(player.func_110143_aJ() > 0.0f))) {
                    player.func_70606_j(0.0f);
                    player.func_145747_a((Component)new Component((Object)((Object)TextFmt.Yellow) + "Toxic fumes quickly fill your airways."));
                }
            }
        });
        DimensionEffectRegistry.dimensionEffect(DimensionInit.cartographerRealmMid, new DimensionEffect(){

            @Override
            public void tickPlayerInDimension(Player player) {
                if (!player.field_70170_p.field_72995_K && player.field_70173_aa % 80 == 0 && !player.func_184812_l_() && player.func_184614_ca().func_77973_b() != ItemInit.synchronizer && player.func_184614_ca().func_77973_b() != ItemInit.synchronizer && player.func_184614_ca().func_77973_b() != ItemInit.advancedSynchronizer && player.func_184614_ca().func_77973_b() != ItemInit.advancedSynchronizer) {
                    DimensionEffectRegistry.dimensionalTear(player);
                }
            }
        });
        DimensionEffectRegistry.dimensionEffect(DimensionInit.cartographerRealmBot, new DimensionEffect(){

            @Override
            public void tickPlayerInDimension(Player player) {
                if (!player.field_70170_p.field_72995_K && player.field_70173_aa % 40 == 0 && !player.func_184812_l_() && player.func_184614_ca().func_77973_b() != ItemInit.advancedSynchronizer && player.func_184614_ca().func_77973_b() != ItemInit.advancedSynchronizer) {
                    DimensionEffectRegistry.dimensionalTear(player);
                }
            }
        });
        DimensionEffectRegistry.dimensionEffect(DimensionInit.grandmasterOutpost, new DimensionEffect(){

            @Override
            public void tickPlayerInDimension(Player player) {
                if (player.field_70173_aa % 20 == 0) {
                    player.func_71024_bL().func_75122_a(20, 20.0f);
                }
            }
        });
        DimensionEffectRegistry.dimensionEffect(DimensionInit.infiniteMurk, new DimensionEffect(){

            @Override
            public void tickPlayerInDimension(Player player) {
                if (player.field_70170_p.field_72995_K && player == Minecraft.func_71410_x().field_71439_g) {
                    for (int i = 0; i < 5; ++i) {
                        Random random = player.field_70170_p.field_73012_v;
                        double xpos = player.field_70165_t - 75.0 + random.nextDouble() * 150.0;
                        double zpos = player.field_70161_v - 75.0 + random.nextDouble() * 150.0;
                        double ypos = (double)(player.field_70170_p.func_189649_b(Mth.func_76128_c((double)xpos), Mth.func_76128_c((double)zpos)) - 2) + random.nextDouble() * 8.0;
                        player.field_70170_p.func_175688_a(ParticleInit.MURK, xpos, ypos, zpos, 0.0, 0.0, 0.0, new int[0]);
                    }
                }
            }
        });
        DimensionEffectRegistry.dimensionEffect(DimensionInit.shadowSea, new DimensionEffect(){

            @Override
            public void tickPlayerInDimension(Player player) {
                if (player.field_70170_p.field_72995_K && player == Minecraft.func_71410_x().field_71439_g) {
                    for (int i = 0; i < 5; ++i) {
                        Random random = player.field_70170_p.field_73012_v;
                        double xpos = player.field_70165_t - 75.0 + random.nextDouble() * 150.0;
                        double zpos = player.field_70161_v - 75.0 + random.nextDouble() * 150.0;
                        double ypos = player.field_70163_u - 6.0 + random.nextDouble() * 12.0;
                        player.field_70170_p.func_175688_a(random.nextBoolean() ? ParticleInit.LARGE_BUBBLE : ParticleInit.LARGE_BUBBLE_PURPLE, xpos, ypos, zpos, 0.0, 0.0, 0.0, new int[0]);
                    }
                }
            }
        });
    }

    private static void dimensionalTear(Player player) {
        int level = 0;
        if (player.func_70644_a(PotionInit.DIMENSIONAL_TEAR)) {
            level = player.func_70660_b(PotionInit.DIMENSIONAL_TEAR).func_76458_c() + 1;
            player.func_184589_d(PotionInit.DIMENSIONAL_TEAR);
        }
        player.func_70690_d(new PotionEffect(PotionInit.DIMENSIONAL_TEAR, 100, level));
    }
}

