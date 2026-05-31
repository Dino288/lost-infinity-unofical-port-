/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.sea;

import java.util.Arrays;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.init.PotionInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.entity.sea.EntitySeaCreature;
import xol.lostinfinity.util.data.CustomParticleConfig;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.fx.IParticleSpawner;
import xol.lostinfinity.util.load.LootTableRegistry;

public class EntityEelShark
extends EntitySeaCreature {
    public EntityEelShark(Level worldIn) {
        super(worldIn);
        this.func_70105_a(3.0f, 3.0f);
        this.rawFlySpeed = 0.95f;
    }

    public boolean func_70652_k(Entity entity) {
        super.func_70652_k(entity);
        if (this.func_70638_az() != null) {
            IMaxAttack.dealMaxHealth((Entity)this, this.func_70638_az(), 1, Arrays.asList("Aquatic"));
            return true;
        }
        return false;
    }

    protected SoundEvent func_184615_bR() {
        return SoundInit.EELSHARK_DEATH;
    }

    protected SoundEvent func_184601_bQ(DamageSource damageSourceIn) {
        return SoundInit.EELSHARK_HURT;
    }

    protected SoundEvent func_184639_G() {
        return SoundInit.EELSHARK_AMBIENT;
    }

    @Override
    public void func_70636_d() {
        super.func_70636_d();
        if (!this.field_70170_p.field_72995_K) {
            if (this.func_70638_az() != null) {
                LivingEntity target = this.func_70638_az();
                this.func_70605_aq().func_75642_a(target.field_70165_t, target.field_70163_u, target.field_70161_v, 1.0);
            }
            if (this.field_70173_aa % 100 == 20) {
                this.field_70170_p.func_184133_a(null, this.func_180425_c(), SoundInit.ELECTRIC_SHOCK, SoundSource.HOSTILE, 1.75f, 0.8f + this.field_70146_Z.nextFloat() * 0.4f);
                for (Player near_pl : this.field_70170_p.func_72872_a(Player.class, this.func_174813_aQ().func_72314_b(8.0, 8.0, 8.0))) {
                    near_pl.func_70690_d(new PotionEffect(PotionInit.NULLIFIED, 300));
                }
                for (int i = 0; i < 3; ++i) {
                    CustomParticleConfig config1 = new CustomParticleConfig();
                    config1.setCount(3);
                    config1.createInstance().setParticle(ParticleInit.ELECTRIC_EXPLOSION_BLUE).setSpread(2.0, 1.0, 2.0).setIgnoreRange(true);
                    config1.createInstance().setParticle(ParticleInit.ELECTRIC_EXPLOSION_YELLOW).setSpread(2.0, 1.0, 2.0).setIgnoreRange(true);
                    IParticleSpawner.spawnParticle(this.field_70170_p, config1, this.field_70165_t, this.field_70163_u + (double)(this.field_70131_O / 2.0f), this.field_70161_v);
                }
            }
        }
    }

    private double getROD(int multi) {
        return (-0.5 + this.field_70146_Z.nextDouble()) * (double)multi;
    }

    @Override
    protected int numberOfLives() {
        return 25;
    }

    protected ResourceLocation func_184647_J() {
        return LootTableRegistry.ENTITIES_EELSHARK;
    }
}

