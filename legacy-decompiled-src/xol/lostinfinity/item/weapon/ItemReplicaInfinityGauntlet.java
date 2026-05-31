/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.IEntityOwnable
 *  net.minecraft.entity.player.Player
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.util.InteractionResultHolder
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraft.world.World
 */
package xol.lostinfinity.item.weapon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.entity.IEntityOwnable;
import net.minecraft.world.entity.player.Player;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.init.PotionInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.basics.ItemCooldown;
import xol.lostinfinity.item.classify.ICustomHoldPose;
import xol.lostinfinity.item.classify.IHotbarDeath;
import xol.lostinfinity.item.classify.IModeSelect;
import xol.lostinfinity.mob.entity.minion.EntityMinion;
import xol.lostinfinity.mob.entity.misc.EntityTNTZombie;
import xol.lostinfinity.projectile.entity.EntitySoundwaveBullet;
import xol.lostinfinity.util.PotionBasic;
import xol.lostinfinity.util.data.CustomParticleConfig;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.fx.IParticleSpawner;

public class ItemReplicaInfinityGauntlet
extends ItemCooldown
implements IMaxAttack,
IModeSelect,
ICustomHoldPose,
IHotbarDeath {
    public ItemReplicaInfinityGauntlet(String regName) {
        super(regName);
        this.func_77637_a(TabsInit.TAB_AUXWEP);
    }

    public InteractionResultHolder<ItemStack> func_77659_a(Level worldIn, Player playerIn, InteractionHand handIn) {
        ItemStack stack = playerIn.func_184586_b(handIn);
        if (this.showDurabilityBar(stack)) {
            return super.func_77659_a(worldIn, playerIn, handIn);
        }
        if (!worldIn.field_72995_K) {
            CustomParticleConfig config = new CustomParticleConfig();
            switch (this.getMode(stack)) {
                case 0: {
                    this.gravityGrasp(playerIn);
                    worldIn.func_184133_a(null, playerIn.func_180425_c(), SoundInit.MAGIC_WEAPON_5, SoundSource.PLAYERS, 1.0f, 1.0f);
                    config.createInstance().setCount(10).setParticle(ParticleInit.GRAVITY_RING).setSpread(3.0, 2.0, 3.0).setIgnoreRange(true);
                    IParticleSpawner.spawnParticle(worldIn, config, playerIn.func_174791_d().func_72441_c(0.0, (double)playerIn.func_70047_e(), 0.0));
                    break;
                }
                case 1: {
                    this.thunderSkin(playerIn);
                    worldIn.func_184133_a(null, playerIn.func_180425_c(), SoundInit.MAGIC_POWDER, SoundSource.PLAYERS, 1.0f, 1.0f);
                    config.createInstance().setCount(10).setParticle(ParticleInit.LIGHT_FLASH).setSpread(1.5, 2.0, 1.5).setIgnoreRange(true);
                    IParticleSpawner.spawnParticle(worldIn, config, playerIn.func_174791_d().func_72441_c(0.0, (double)playerIn.func_70047_e(), 0.0));
                    break;
                }
                case 2: {
                    this.embuedEmbers(playerIn);
                    worldIn.func_184133_a(null, playerIn.func_180425_c(), SoundInit.DRAGON_FIRE_BALL, SoundSource.PLAYERS, 1.0f, 1.0f);
                    break;
                }
                case 3: {
                    this.riteOfRise(playerIn);
                    worldIn.func_184133_a(null, playerIn.func_180425_c(), SoundInit.DROID_SUMMON, SoundSource.PLAYERS, 1.0f, 1.0f);
                    break;
                }
                case 4: {
                    this.echoBlast(playerIn);
                    worldIn.func_184133_a(null, playerIn.func_180425_c(), SoundInit.SOUND_GUN, SoundSource.PLAYERS, 1.0f, 0.8f + worldIn.field_73012_v.nextFloat() * 0.4f);
                    break;
                }
                case 5: {
                    this.realityCleanse(playerIn);
                    worldIn.func_184133_a(null, playerIn.func_180425_c(), SoundInit.LIGHT_MAGIC, SoundSource.PLAYERS, 1.0f, 1.0f);
                    config.createInstance().setCount(100).setParticle(ParticleInit.GOLDEN_MAGIC).setSpread(2.0, 2.0, 2.0).setIgnoreRange(true);
                    IParticleSpawner.spawnParticle(worldIn, config, playerIn.func_174791_d().func_72441_c(0.0, (double)playerIn.func_70047_e(), 0.0));
                }
            }
        }
        this.startCooldown(stack);
        return super.func_77659_a(worldIn, playerIn, handIn);
    }

    private void gravityGrasp(Player playerIn) {
        List entities = playerIn.field_70170_p.func_72872_a(LivingEntity.class, playerIn.func_174813_aQ().func_186662_g(50.0));
        for (LivingEntity entity : entities) {
            if (entity == playerIn || entity instanceof IEntityOwnable && ((IEntityOwnable)entity).func_184753_b() == playerIn.func_110124_au() || entity instanceof EntityMinion && ((EntityMinion)entity).getOwner() == playerIn || entity instanceof Player && (((Player)entity).func_184812_l_() || ((Player)entity).func_175149_v())) continue;
            entity.field_70159_w = (playerIn.field_70165_t - entity.field_70165_t) / 5.0;
            entity.field_70181_x = (playerIn.field_70163_u - entity.field_70163_u) / 5.0 + 0.25;
            entity.field_70179_y = (playerIn.field_70161_v - entity.field_70161_v) / 5.0;
            entity.field_70133_I = true;
            IMaxAttack.dealTrueDamage((Entity)playerIn, entity, entity.func_110138_aP() * 0.5f);
        }
    }

    private void thunderSkin(Player playerIn) {
        playerIn.func_70690_d(new PotionEffect(PotionInit.POTION_AFFINITY, 200, 4));
        playerIn.func_70690_d(new PotionEffect(PotionInit.ADRENALINE, 200, 4));
    }

    private void embuedEmbers(Player playerIn) {
        playerIn.func_70690_d(new PotionEffect(PotionInit.UNLEASHING, 400, 5));
        playerIn.func_70690_d(new PotionEffect(PotionInit.NITROUS, 400, 3));
    }

    private void riteOfRise(Player playerIn) {
        Random rand = new Random();
        for (int i = 0; i < 10; ++i) {
            EntityTNTZombie zombie = new EntityTNTZombie(playerIn.field_70170_p);
            zombie.func_184754_b(playerIn.func_110124_au());
            zombie.func_70107_b(playerIn.field_70165_t + (double)rand.nextInt(10) - 5.0, playerIn.field_70163_u, playerIn.field_70161_v + (double)rand.nextInt(10) - 5.0);
            playerIn.field_70170_p.func_72838_d((Entity)zombie);
        }
    }

    private void echoBlast(Player playerIn) {
        for (int i = 0; i < 8; ++i) {
            EntitySoundwaveBullet bullet = new EntitySoundwaveBullet(playerIn.field_70170_p, (LivingEntity)playerIn);
            bullet.setThrower((LivingEntity)playerIn);
            bullet.func_184538_a((Entity)playerIn, playerIn.field_70125_A, playerIn.field_70177_z, 0.0f, 1.5f, 7.0f);
            playerIn.field_70170_p.func_72838_d((Entity)bullet);
        }
    }

    private void realityCleanse(Player playerIn) {
        ArrayList<PotionEffect> effectsToRemove = new ArrayList<PotionEffect>();
        for (PotionEffect effect : playerIn.func_70651_bq()) {
            if (effect.func_188419_a() instanceof PotionBasic) {
                PotionBasic potion = (PotionBasic)effect.func_188419_a();
                if (!potion.negativeLostEffect()) continue;
                effectsToRemove.add(effect);
                continue;
            }
            if (!effect.func_188419_a().func_76398_f()) continue;
            effectsToRemove.add(effect);
        }
        for (PotionEffect effect : effectsToRemove) {
            playerIn.func_184589_d(effect.func_188419_a());
        }
    }

    @Override
    public void modeUpdate(ItemStack stack, Player player) {
        int mode;
        int n = mode = this.getMode(stack) == 5 ? 0 : this.getMode(stack) + 1;
        if (mode == 5) {
            this.setMode(stack, mode);
        } else {
            this.setMode(stack, mode);
        }
        if (!stack.func_77942_o()) {
            stack.func_77982_d(new CompoundTag());
        }
        switch (mode) {
            case 0: {
                stack.func_77978_p().func_74768_a("ComplexCooldown", 1000);
                break;
            }
            case 1: {
                stack.func_77978_p().func_74768_a("ComplexCooldown", 3000);
                break;
            }
            case 2: {
                stack.func_77978_p().func_74768_a("ComplexCooldown", 3000);
                break;
            }
            case 3: {
                stack.func_77978_p().func_74768_a("ComplexCooldown", 2000);
                break;
            }
            case 4: {
                stack.func_77978_p().func_74768_a("ComplexCooldown", 300);
                break;
            }
            case 5: {
                stack.func_77978_p().func_74768_a("ComplexCooldown", 1000);
            }
        }
        this.announceUpdate(player, mode);
    }

    @Override
    protected boolean hasSimpleCooldown() {
        return false;
    }

    private void announceUpdate(Player player, int mode) {
        switch (mode) {
            case 0: {
                player.func_146105_b((Component)new Component("Gravity Grasp"), true);
                break;
            }
            case 1: {
                player.func_146105_b((Component)new Component("Thunder Skin"), true);
                break;
            }
            case 2: {
                player.func_146105_b((Component)new Component("Embued Embers"), true);
                break;
            }
            case 3: {
                player.func_146105_b((Component)new Component("Rite of Rise"), true);
                break;
            }
            case 4: {
                player.func_146105_b((Component)new Component("Echo Blast"), true);
                break;
            }
            case 5: {
                player.func_146105_b((Component)new Component("Reality Cleanse"), true);
            }
        }
    }

    private void setMode(ItemStack stack, int mode) {
        if (!stack.func_77942_o()) {
            stack.func_77982_d(new CompoundTag());
        }
        stack.func_77978_p().func_74768_a("mode", mode);
    }

    private int getMode(ItemStack stack) {
        if (!stack.func_77942_o()) {
            stack.func_77982_d(new CompoundTag());
        }
        return stack.func_77978_p().func_74762_e("mode");
    }

    @Override
    public boolean playedKilled(ItemStack stack, Player player, Entity attacker, float damageDealt) {
        Level world = player.field_70170_p;
        if (player.func_70644_a(PotionInit.LAST_BREATH)) {
            int level = player.func_70660_b(PotionInit.LAST_BREATH).func_76458_c();
            if (level >= 5) {
                return true;
            }
            if (!world.field_72995_K) {
                this.potionApplication(world, player, level + 1);
            }
        } else if (!world.field_72995_K) {
            this.potionApplication(world, player, 0);
        }
        player.func_70691_i(player.func_110138_aP());
        return false;
    }

    private void potionApplication(Level world, Player player, int amp) {
        player.func_70690_d(new PotionEffect(PotionInit.LAST_BREATH, 200, amp));
        for (LivingEntity near_creature : player.field_70170_p.func_72872_a(LivingEntity.class, player.func_174813_aQ().func_72314_b(20.0, 10.0, 20.0))) {
            if (near_creature.func_110124_au().equals(player.func_110124_au())) continue;
            player.func_70690_d(new PotionEffect(PotionInit.BLIGHTED, 200, amp));
        }
        if (!world.field_72995_K) {
            CustomParticleConfig config1 = new CustomParticleConfig();
            config1.createInstance().setParticle(ParticleInit.BLIGHT_SPELL_GREEN).setSpread(4.0, 1.0, 4.0).setCount(4).setIgnoreRange(true);
            IParticleSpawner.spawnParticle(world, config1, player.field_70165_t, player.field_70163_u + 1.0, player.field_70161_v);
            CustomParticleConfig config2 = new CustomParticleConfig();
            config2.createInstance().setParticle(ParticleInit.CORRUPTION_MAGIC).setSpread(4.0, 1.0, 4.0).setCount(10).setIgnoreRange(true);
            IParticleSpawner.spawnParticle(world, config2, player.field_70165_t, player.field_70163_u + 1.0, player.field_70161_v);
            world.func_184133_a(null, player.func_180425_c(), SoundEvents.field_187664_bz, SoundSource.MASTER, 1.0f, 1.0f);
        }
    }
}

