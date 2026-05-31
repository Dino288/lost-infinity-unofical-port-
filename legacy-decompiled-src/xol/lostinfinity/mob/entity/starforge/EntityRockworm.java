/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.PathfinderMob
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.network.datasync.DataParameter
 *  net.minecraft.network.datasync.DataSerializer
 *  net.minecraft.network.datasync.DataSerializers
 *  net.minecraft.network.datasync.EntityDataManager
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.starforge;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializer;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.PotionInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.entity.base.EntityMultipleLives;
import xol.lostinfinity.mob.entity.base.IConditionalDamage;
import xol.lostinfinity.mob.entity.starforge.EntityGrubber;
import xol.lostinfinity.util.data.IMaxAttack;

public class EntityRockworm
extends EntityMultipleLives
implements IMaxAttack,
IConditionalDamage {
    private static final DataParameter<Boolean> AWAKE = EntityDataManager.func_187226_a(EntityGrubber.class, (DataSerializer)DataSerializers.field_187198_h);
    private int sleepTimer = 0;

    public EntityRockworm(Level worldIn) {
        super(worldIn);
        this.func_70105_a(1.5f, 1.5f);
    }

    @Override
    protected void func_184651_r() {
    }

    @Override
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a(AWAKE, (Object)false);
    }

    public boolean isAwake() {
        return (Boolean)this.field_70180_af.func_187225_a(AWAKE);
    }

    public void setAwake(boolean awoke) {
        this.field_70180_af.func_187227_b(AWAKE, (Object)awoke);
        if (!awoke) {
            this.field_70714_bg.field_75782_a.clear();
            this.field_70715_bh.field_75782_a.clear();
        } else {
            this.initBasicTasks((PathfinderMob)this);
        }
        this.sleepTimer = 0;
    }

    public void func_70636_d() {
        super.func_70636_d();
        if (!this.field_70170_p.field_72995_K && this.isAwake() && this.func_70638_az() == null) {
            if (this.sleepTimer == 200) {
                this.setAwake(false);
            }
            ++this.sleepTimer;
        }
    }

    public boolean func_70652_k(Entity entity) {
        super.func_70652_k(entity);
        if (this.func_70638_az() != null) {
            if (IMaxAttack.dealTrueDamage((Entity)this, this.func_70638_az(), this.func_70638_az().func_110138_aP() * 0.5f).didSuccessfulHit()) {
                this.func_70638_az().func_70690_d(new PotionEffect(PotionInit.PHASED, 200));
            }
            return true;
        }
        return false;
    }

    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(1000.0);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(1.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.42);
        this.func_110148_a(SharedMonsterAttributes.field_111266_c).func_111128_a(1.0);
    }

    protected SoundEvent func_184615_bR() {
        return SoundInit.ROCKWORM_DEATH;
    }

    protected SoundEvent func_184601_bQ(DamageSource damageSourceIn) {
        return SoundInit.ROCKWORM_HURT;
    }

    protected SoundEvent func_184639_G() {
        return this.isAwake() ? SoundInit.ROCKWORM_AMBIENT : SoundInit.ROCKWORM_SLEEPING;
    }

    @Override
    public void trueDeathAction() {
        if (!this.field_70170_p.field_72995_K && this.field_70170_p.func_175623_d(this.func_180425_c()) && this.isAwake()) {
            this.field_70170_p.func_184133_a(null, this.func_180425_c(), SoundInit.ROCK_TUMBLE, SoundSource.HOSTILE, 1.5f, 1.0f);
            this.field_70170_p.func_175656_a(this.func_180425_c(), BlockInit.ioniteOre.func_176223_P());
        }
    }

    @Override
    public boolean canBeDamaged(Entity attacker) {
        return this.isAwake();
    }
}

