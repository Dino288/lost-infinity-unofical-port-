/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.client.util.ITooltipFlag
 *  net.minecraft.entity.Mob
 *  net.minecraft.entity.passive.EntityTameable
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.ItemStack
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.SoundSource
 *  net.minecraft.world.World
 */
package xol.lostinfinity.item.weapon;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.world.entity.Mob;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.init.PotionInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.basics.ItemChanneling;
import xol.lostinfinity.util.data.CustomParticleConfig;
import xol.lostinfinity.util.fx.IParticleSpawner;

public class ItemSongOfInvigoration
extends ItemChanneling {
    public ItemSongOfInvigoration(String regName) {
        super(regName);
        this.func_77637_a(TabsInit.TAB_AUXWEP);
    }

    @Override
    public void chargeTick(Level worldIn, Player player, InteractionHand hand, ItemStack stack, int chargeTime) {
        if (worldIn.field_72995_K) {
            return;
        }
        if (chargeTime % 7 == 0) {
            int chosenSound = worldIn.field_73012_v.nextInt(3) + 1;
            switch (chosenSound) {
                case 1: {
                    worldIn.func_184133_a(null, player.func_180425_c(), SoundInit.NOTE_TYPE_1, SoundSource.PLAYERS, 1.0f, 0.5f + worldIn.field_73012_v.nextFloat());
                    break;
                }
                case 2: {
                    worldIn.func_184133_a(null, player.func_180425_c(), SoundInit.NOTE_TYPE_3, SoundSource.PLAYERS, 1.0f, 0.5f + worldIn.field_73012_v.nextFloat());
                    break;
                }
                case 3: {
                    worldIn.func_184133_a(null, player.func_180425_c(), SoundInit.NOTE_TYPE_4, SoundSource.PLAYERS, 1.0f, 0.5f + worldIn.field_73012_v.nextFloat());
                }
            }
        }
        if (chargeTime % 20 == 0) {
            List nearEntities = worldIn.func_72872_a(EntityTameable.class, player.func_174813_aQ().func_186662_g(30.0));
            ArrayList<EntityTameable> toRemove = new ArrayList<EntityTameable>();
            for (EntityTameable entity : nearEntities) {
                if (entity.func_70909_n() && entity.func_70902_q() == player) continue;
                toRemove.add(entity);
            }
            nearEntities.removeAll(toRemove);
            if (nearEntities.size() == 0) {
                return;
            }
            int chosenIndex = worldIn.field_73012_v.nextInt(nearEntities.size());
            Mob chosenEntity = (Mob)nearEntities.get(chosenIndex);
            CustomParticleConfig config = new CustomParticleConfig();
            config.createInstance().setParticle(ParticleInit.CRYSTAL_MAGIC).setCount(10).setSpread(0.5, 0.5, 0.5);
            IParticleSpawner.spawnParticle(worldIn, config, (double)chosenEntity.func_180425_c().func_177958_n(), (double)chosenEntity.func_180425_c().func_177956_o(), (double)chosenEntity.func_180425_c().func_177952_p());
            int chosenEffect = worldIn.field_73012_v.nextInt(4);
            switch (chosenEffect) {
                case 0: {
                    if (chosenEntity.func_70644_a(PotionInit.ADRENALINE)) {
                        int newDuration = chosenEntity.func_70660_b(PotionInit.ADRENALINE).func_76459_b() + 100;
                        int newAmplifier = Math.min(chosenEntity.func_70660_b(PotionInit.ADRENALINE).func_76458_c() + 1, 9);
                        chosenEntity.func_70690_d(new PotionEffect(PotionInit.ADRENALINE, newDuration, newAmplifier));
                        break;
                    }
                    chosenEntity.func_70690_d(new PotionEffect(PotionInit.ADRENALINE, 100, 0));
                    break;
                }
                case 1: {
                    if (chosenEntity.func_70644_a(PotionInit.PLANESPLIT)) {
                        int newDuration = chosenEntity.func_70660_b(PotionInit.PLANESPLIT).func_76459_b() + 100;
                        int newAmplifier = Math.min(chosenEntity.func_70660_b(PotionInit.PLANESPLIT).func_76458_c() + 1, 9);
                        chosenEntity.func_70690_d(new PotionEffect(PotionInit.PLANESPLIT, newDuration, newAmplifier));
                        break;
                    }
                    chosenEntity.func_70690_d(new PotionEffect(PotionInit.PLANESPLIT, 100, 0));
                    break;
                }
                case 2: {
                    if (chosenEntity.func_70644_a(PotionInit.IRONHEART)) {
                        int newDuration = chosenEntity.func_70660_b(PotionInit.IRONHEART).func_76459_b() + 100;
                        chosenEntity.func_70690_d(new PotionEffect(PotionInit.IRONHEART, newDuration, 0));
                        break;
                    }
                    chosenEntity.func_70690_d(new PotionEffect(PotionInit.IRONHEART, 100, 0));
                    break;
                }
                case 4: {
                    if (chosenEntity.func_70644_a(PotionInit.TRANSFUSION)) {
                        int newDuration = chosenEntity.func_70660_b(PotionInit.TRANSFUSION).func_76459_b() + 100;
                        int newAmplifier = Math.min(chosenEntity.func_70660_b(PotionInit.TRANSFUSION).func_76458_c() + 1, 9);
                        chosenEntity.func_70690_d(new PotionEffect(PotionInit.TRANSFUSION, newDuration, newAmplifier));
                        break;
                    }
                    chosenEntity.func_70690_d(new PotionEffect(PotionInit.TRANSFUSION, 100, 0));
                }
            }
        }
    }

    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Gold) + "Empower your nearby tames through with a battle song.");
        tooltip.add((Object)((Object)TextFmt.Green) + "Your tames will periodically gain buffs as you play.");
        tooltip.add((Object)((Object)TextFmt.Red) + "Buffs they already have, are extended and made stronger.");
        tooltip.add((Object)((Object)TextFmt.Italic) + "Buffs are Adrenaline, Planesplit, Ironheart & Transfusion");
    }
}

