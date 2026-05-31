/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.init.Blocks
 *  net.minecraft.item.Item
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.util.math.Mth
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.deviant.prime;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.Item;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.entity.base.EntityDeviantPrime;
import xol.lostinfinity.mob.entity.base.IConditionalDamage;
import xol.lostinfinity.util.data.CustomParticleConfig;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.fx.IParticleSpawner;

public class EntityKalikos
extends EntityDeviantPrime
implements IMaxAttack,
IConditionalDamage {
    public EntityKalikos(Level worldIn) {
        super(worldIn);
        this.func_70105_a(2.0f, 4.5f);
    }

    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(1.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.4);
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(4000.0);
    }

    public boolean func_70652_k(Entity entity) {
        super.func_70652_k(entity);
        if (this.func_70638_az() != null) {
            IMaxAttack.dealTrueDamage((Entity)this, this.func_70638_az(), this.func_70638_az().func_110138_aP() * 0.15f);
            return true;
        }
        return false;
    }

    public void func_70636_d() {
        super.func_70636_d();
        this.field_70143_R = -1.0f;
        if (!this.field_70170_p.field_72995_K) {
            int tickOffset = this.field_70173_aa % 300;
            if (this.func_70638_az() != null) {
                if (tickOffset == 100) {
                    if (this.field_70170_p.func_175623_d(this.func_70638_az().func_180425_c())) {
                        this.field_70170_p.func_175656_a(this.func_70638_az().func_180425_c(), Blocks.field_150358_i.func_176223_P());
                    }
                    if (this.field_70170_p.func_175623_d(this.func_180425_c())) {
                        this.field_70170_p.func_175656_a(this.func_180425_c(), Blocks.field_150358_i.func_176223_P());
                    }
                } else if (tickOffset == 150) {
                    this.func_70634_a(this.func_70638_az().field_70165_t, this.func_70638_az().field_70163_u, this.func_70638_az().field_70161_v);
                    this.func_184185_a(SoundInit.RAPID_TELEPORT, 1.0f, 0.8f + this.field_70146_Z.nextFloat() * 0.3f);
                }
            }
            if (tickOffset <= 60) {
                if (tickOffset == 60) {
                    for (LivingEntity near_pl : this.field_70170_p.func_72872_a(LivingEntity.class, this.func_174813_aQ().func_186662_g(12.0))) {
                        if (near_pl.equals((Object)this)) continue;
                        IMaxAttack.dealTrueDamage((Entity)this, near_pl, near_pl.func_110138_aP());
                    }
                    this.field_70170_p.func_184133_a(null, this.func_180425_c(), SoundInit.LASER_WEAPON_11, SoundSource.HOSTILE, 2.0f, 1.0f);
                    CustomParticleConfig config1 = new CustomParticleConfig();
                    config1.createInstance().setParticle(ParticleInit.POWER_FIELD).setIgnoreRange(true);
                    CustomParticleConfig config2 = new CustomParticleConfig();
                    config2.setCount(12);
                    config2.createInstance().setParticle(ParticleInit.EXPLOSION_BLUE).setSpread(18.0, 2.0, 18.0).setIgnoreRange(true);
                    config2.createInstance().setParticle(ParticleInit.EXPLOSION_LAVENDER).setSpread(18.0, 2.0, 18.0).setIgnoreRange(true);
                    IParticleSpawner.spawnParticle(this.field_70170_p, config1, this.field_70165_t, this.field_70163_u + 1.5, this.field_70161_v);
                    IParticleSpawner.spawnParticle(this.field_70170_p, config2, this.field_70165_t, this.field_70163_u + 1.5, this.field_70161_v);
                } else if (tickOffset % 10 == 0) {
                    this.func_184185_a(SoundInit.CHARGING_POWER, 1.2f + 0.1f * (float)Mth.func_76141_d((float)(tickOffset / 10)), 0.6f + 0.2f * (float)Mth.func_76141_d((float)(tickOffset / 10)));
                    CustomParticleConfig config1 = new CustomParticleConfig();
                    config1.createInstance().setParticle(ParticleInit.PLASMA_RIFT).setSpread(3.0, 1.0, 3.0).setCount(8).setIgnoreRange(true);
                    IParticleSpawner.spawnParticle(this.field_70170_p, config1, this.field_70165_t, this.field_70163_u, this.field_70161_v);
                }
            }
        }
    }

    protected float func_189749_co() {
        return 1.25f;
    }

    protected SoundEvent func_184615_bR() {
        return SoundInit.KALIKOS_DEATH;
    }

    protected SoundEvent func_184601_bQ(DamageSource damageSourceIn) {
        return SoundInit.KALIKOS_HURT;
    }

    protected SoundEvent func_184639_G() {
        return SoundInit.KALIKOS_AMBIENT;
    }

    @Override
    protected String primeName() {
        return "Kalikos";
    }

    @Override
    protected Item primeDrop() {
        return ItemInit.deviantFragmentTL;
    }

    @Override
    public boolean canBeDamaged(Entity attacker) {
        return !this.func_70090_H();
    }

    @Override
    protected int numberOfLives() {
        return 40;
    }
}

