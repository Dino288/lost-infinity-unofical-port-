/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.player.Player
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.labyrinth;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.init.PotionInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.entity.base.EntityMultipleLives;
import xol.lostinfinity.util.data.CustomParticleConfig;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.fx.IParticleSpawner;
import xol.lostinfinity.util.load.LootTableRegistry;

public class EntitySentry
extends EntityMultipleLives
implements IMaxAttack {
    public EntitySentry(Level worldIn) {
        super(worldIn);
        this.func_70105_a(1.75f, 1.75f);
    }

    public boolean func_70652_k(Entity entity) {
        super.func_70652_k(entity);
        if (this.func_70638_az() != null) {
            if (entity instanceof LivingEntity) {
                LivingEntity target = (LivingEntity)entity;
                if (target.func_70644_a(PotionInit.SHOCKED)) {
                    IMaxAttack.dealTrueDamage((Entity)this, target, target.func_110138_aP() * 0.5f);
                } else {
                    IMaxAttack.dealMaxHealth((Entity)this, this.func_70638_az(), 2);
                }
            }
            return true;
        }
        return false;
    }

    public void func_70636_d() {
        super.func_70636_d();
        if (!this.field_70170_p.field_72995_K && this.field_70173_aa % 120 == 0) {
            this.func_184185_a(SoundInit.SENTRY_ABILITY, 1.0f, 0.8f + 0.4f * this.field_70146_Z.nextFloat());
            for (Player near_pl : this.field_70170_p.func_72872_a(Player.class, this.func_174813_aQ().func_186662_g(5.0))) {
                near_pl.func_70690_d(new PotionEffect(PotionInit.SHOCKED, 100));
                CustomParticleConfig config1 = new CustomParticleConfig();
                config1.createInstance().setParticle(ParticleInit.ZAP).setSpread(3.0, 1.0, 3.0).setCount(5).setIgnoreRange(true);
                IParticleSpawner.spawnParticle(this.field_70170_p, config1, this.field_70165_t, this.field_70163_u + (double)(this.field_70131_O / 2.0f), this.field_70161_v);
            }
        }
    }

    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(10000.0);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(1.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.22);
        this.func_110148_a(SharedMonsterAttributes.field_111266_c).func_111128_a(1.0);
    }

    protected SoundEvent func_184615_bR() {
        return SoundInit.SENTRY_DEATH;
    }

    protected SoundEvent func_184601_bQ(DamageSource damageSourceIn) {
        return SoundInit.SENTRY_HURT;
    }

    protected SoundEvent func_184639_G() {
        return SoundInit.SENTRY_AMBIENT;
    }

    @Override
    protected int numberOfLives() {
        return 5;
    }

    protected ResourceLocation func_184647_J() {
        if (this.field_70146_Z.nextInt(7) == 0) {
            return LootTableRegistry.LABYRINTH_BOTTOM;
        }
        return null;
    }
}

