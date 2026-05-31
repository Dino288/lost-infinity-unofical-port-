/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.IEntityOwnable
 *  net.minecraft.entity.player.Player
 *  net.minecraft.network.datasync.DataParameter
 *  net.minecraft.network.datasync.DataSerializer
 *  net.minecraft.network.datasync.DataSerializers
 *  net.minecraft.network.datasync.EntityDataManager
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.util.DamageSource
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.minion;

import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.entity.IEntityOwnable;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializer;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.init.PotionInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.entity.base.EntityImmaterial;
import xol.lostinfinity.mob.entity.base.EntityMultipleLivesMount;
import xol.lostinfinity.mob.entity.base.IConditionalDamage;
import xol.lostinfinity.util.data.CustomParticleConfig;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.fx.IParticleSpawner;

public class EntityBombDrone
extends EntityMultipleLivesMount
implements IConditionalDamage {
    private static final DataParameter<Float> OWNER_POS_X = EntityDataManager.func_187226_a(EntityBombDrone.class, (DataSerializer)DataSerializers.field_187193_c);
    private static final DataParameter<Float> OWNER_POS_Y = EntityDataManager.func_187226_a(EntityBombDrone.class, (DataSerializer)DataSerializers.field_187193_c);
    private static final DataParameter<Float> OWNER_POS_Z = EntityDataManager.func_187226_a(EntityBombDrone.class, (DataSerializer)DataSerializers.field_187193_c);
    private static final DataParameter<Float> OWNER_PITCH = EntityDataManager.func_187226_a(EntityBombDrone.class, (DataSerializer)DataSerializers.field_187193_c);
    private static final DataParameter<Float> OWNER_YAW = EntityDataManager.func_187226_a(EntityBombDrone.class, (DataSerializer)DataSerializers.field_187193_c);

    public EntityBombDrone(Level worldIn) {
        super(worldIn);
        this.func_70105_a(0.6f, 0.6f);
        this.field_70138_W = 5.0f;
    }

    @Override
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a(OWNER_POS_X, (Object)Float.valueOf((float)this.field_70165_t));
        this.field_70180_af.func_187214_a(OWNER_POS_Y, (Object)Float.valueOf((float)this.field_70163_u));
        this.field_70180_af.func_187214_a(OWNER_POS_Z, (Object)Float.valueOf((float)this.field_70161_v));
        this.field_70180_af.func_187214_a(OWNER_PITCH, (Object)Float.valueOf(this.field_70125_A));
        this.field_70180_af.func_187214_a(OWNER_YAW, (Object)Float.valueOf(this.field_70177_z));
    }

    public void func_70106_y() {
        super.func_70106_y();
        if (!this.field_70170_p.field_72995_K || this.owner == Minecraft.func_71410_x().field_71439_g) {
            this.resetOwnerPosition();
        }
    }

    @Override
    public void setOwner(Player player) {
        super.setOwner(player);
        this.field_70180_af.func_187227_b(OWNER_POS_X, (Object)Float.valueOf((float)player.field_70165_t));
        this.field_70180_af.func_187227_b(OWNER_POS_Y, (Object)Float.valueOf((float)player.field_70163_u));
        this.field_70180_af.func_187227_b(OWNER_POS_Z, (Object)Float.valueOf((float)player.field_70161_v));
        this.field_70180_af.func_187227_b(OWNER_PITCH, (Object)Float.valueOf(player.field_70125_A));
        this.field_70180_af.func_187227_b(OWNER_YAW, (Object)Float.valueOf(player.field_70759_as));
    }

    public void func_70636_d() {
        super.func_70636_d();
        if (!this.field_70170_p.field_72995_K) {
            if (this.owner != null && this.field_70173_aa % 5 == 0) {
                this.owner.func_70690_d(new PotionEffect(PotionInit.PROTECTED, 8, 0));
            }
            if (this.field_70173_aa % 20 == 0) {
                this.func_184185_a(SoundInit.BOMB_TICK, 1.0f, 1.0f);
            }
        }
        if (!this.field_70170_p.field_72995_K && this.func_184179_bs() == null) {
            this.func_70106_y();
            CustomParticleConfig config = new CustomParticleConfig();
            config.createInstance().setIgnoreRange(true).setParticle(ParticleInit.EXPLOSION_RED).setSpread(5.0, 5.0, 5.0).setCount(5);
            IParticleSpawner.spawnParticle(this.field_70170_p, config, this.field_70165_t, this.field_70163_u, this.field_70161_v);
            CustomParticleConfig config2 = new CustomParticleConfig();
            config2.createInstance().setIgnoreRange(true).setParticle(ParticleInit.EXPLOSION_YELLOW).setSpread(5.0, 5.0, 5.0).setCount(5);
            IParticleSpawner.spawnParticle(this.field_70170_p, config2, this.field_70165_t, this.field_70163_u, this.field_70161_v);
            CustomParticleConfig config3 = new CustomParticleConfig();
            config3.createInstance().setIgnoreRange(true).setParticle(ParticleInit.EXPLOSION_ORANGE).setSpread(5.0, 5.0, 5.0).setCount(5);
            IParticleSpawner.spawnParticle(this.field_70170_p, config3, this.field_70165_t, this.field_70163_u, this.field_70161_v);
            this.func_184185_a(SoundInit.DEEP_EXPLOSION, 1.0f, 1.0f);
            for (LivingEntity target : this.field_70170_p.func_175647_a(LivingEntity.class, this.func_174813_aQ().func_72314_b(5.0, 5.0, 5.0), this::validateTarget)) {
                IMaxAttack.dealTrueDamage((Entity)this.owner, target, target.func_110138_aP() * 1.1f);
            }
        }
    }

    public boolean func_70097_a(DamageSource source, float amount) {
        return source.func_76346_g() != this.owner && super.func_70097_a(source, amount);
    }

    @Override
    public double func_70042_X() {
        return -0.85;
    }

    public boolean func_184215_y(Entity entityIn) {
        return entityIn != this.owner && super.func_184215_y(entityIn);
    }

    @Override
    protected void func_184651_r() {
    }

    @Override
    protected int numberOfLives() {
        return 5;
    }

    @Override
    public boolean canBeDamaged(Entity attacker) {
        return attacker != this.owner;
    }

    protected void resetOwnerPosition() {
        float yaw;
        float posX = ((Float)this.field_70180_af.func_187225_a(OWNER_POS_X)).floatValue();
        float posY = ((Float)this.field_70180_af.func_187225_a(OWNER_POS_Y)).floatValue();
        float posZ = ((Float)this.field_70180_af.func_187225_a(OWNER_POS_Z)).floatValue();
        float pitch = ((Float)this.field_70180_af.func_187225_a(OWNER_PITCH)).floatValue();
        this.owner.field_70759_as = yaw = ((Float)this.field_70180_af.func_187225_a(OWNER_YAW)).floatValue();
        this.owner.field_70177_z = yaw;
        this.owner.field_70125_A = pitch;
        this.owner.func_70634_a((double)posX, (double)posY, (double)posZ);
    }

    protected boolean validateTarget(Entity input) {
        if (!(input instanceof LivingEntity)) {
            return false;
        }
        if (input instanceof EntityImmaterial || input == this.getOwner() || input.field_70128_L || ((LivingEntity)input).func_110143_aJ() <= 0.0f) {
            return false;
        }
        if (input instanceof Player) {
            return !((Player)input).func_184812_l_() && !((Player)input).func_175149_v();
        }
        if (input instanceof IEntityOwnable) {
            return ((IEntityOwnable)input).func_70902_q() != this.getOwner();
        }
        return true;
    }
}

