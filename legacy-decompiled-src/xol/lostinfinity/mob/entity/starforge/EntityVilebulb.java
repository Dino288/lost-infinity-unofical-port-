/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.player.Player
 *  net.minecraft.network.datasync.DataParameter
 *  net.minecraft.network.datasync.DataSerializer
 *  net.minecraft.network.datasync.DataSerializers
 *  net.minecraft.network.datasync.EntityDataManager
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.world.EnumDifficulty
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.starforge;

import java.util.Iterator;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializer;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.Difficulty;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.init.PotionInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.entity.base.EntityMultipleLives;
import xol.lostinfinity.util.data.CustomParticleConfig;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.fx.IParticleSpawner;
import xol.lostinfinity.util.load.LootTableRegistry;

public class EntityVilebulb
extends EntityMultipleLives
implements IMaxAttack {
    private static final DataParameter<Integer> GMOVE = EntityDataManager.func_187226_a(EntityVilebulb.class, (DataSerializer)DataSerializers.field_187192_b);
    private static final DataParameter<Boolean> VOLATILE = EntityDataManager.func_187226_a(EntityVilebulb.class, (DataSerializer)DataSerializers.field_187198_h);
    private boolean randomziedSpeed = false;
    private int explodeTimer = 0;
    private boolean exploded = false;

    public EntityVilebulb(Level worldIn) {
        super(worldIn);
        this.func_70105_a(0.5f, 0.5f);
        this.func_189654_d(true);
    }

    @Override
    protected void func_184651_r() {
    }

    @Override
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a(GMOVE, (Object)0);
        this.field_70180_af.func_187214_a(VOLATILE, (Object)false);
    }

    public int getMovement() {
        return (Integer)this.field_70180_af.func_187225_a(GMOVE);
    }

    private void randomizeMovement() {
        int pick = this.field_70146_Z.nextInt(6);
        this.field_70180_af.func_187227_b(GMOVE, (Object)pick);
        this.randomziedSpeed = true;
    }

    public boolean isVolatile() {
        return (Boolean)this.field_70180_af.func_187225_a(VOLATILE);
    }

    private void setVolatile(boolean vol) {
        this.field_70180_af.func_187227_b(VOLATILE, (Object)vol);
    }

    protected void func_82167_n(Entity entityIn) {
        Player play;
        if (entityIn instanceof Player && this.field_70173_aa % 5 == 0 && !(play = (Player)entityIn).func_184812_l_() && !this.field_70170_p.field_72995_K) {
            this.explode();
        }
        entityIn.func_70108_f((Entity)this);
    }

    private void explode() {
        if (!this.exploded) {
            for (Player near_pl : this.field_70170_p.func_72872_a(Player.class, this.func_174813_aQ().func_186662_g(4.0))) {
                if (!IMaxAttack.dealMaxHealth((Entity)this, (LivingEntity)near_pl, 1).didSuccessfulHit()) continue;
                near_pl.func_70690_d(new PotionEffect(PotionInit.BLIGHTED, 200));
            }
            this.func_184185_a(SoundInit.HOT_POD, 1.5f, 0.7f + 0.6f * this.field_70146_Z.nextFloat());
        }
        CustomParticleConfig config1 = new CustomParticleConfig();
        config1.createInstance().setParticle(ParticleInit.VENOM).setSpread(4.0, 1.0, 4.0).setCount(10).setIgnoreRange(true);
        CustomParticleConfig config2 = new CustomParticleConfig();
        config2.createInstance().setParticle(ParticleInit.VENOM_RING).setSpread(1.0, 1.0, 1.0).setCount(5).setIgnoreRange(true);
        IParticleSpawner.spawnParticle(this.field_70170_p, config1, this.field_70165_t, this.field_70163_u + (double)(this.field_70131_O / 2.0f), this.field_70161_v);
        IParticleSpawner.spawnParticle(this.field_70170_p, config2, this.field_70165_t, this.field_70163_u + (double)(this.field_70131_O / 2.0f), this.field_70161_v);
        this.func_70106_y();
    }

    public void func_70636_d() {
        super.func_70636_d();
        this.field_70143_R = -1.0f;
        if (!this.field_70170_p.field_72995_K) {
            if (!this.randomziedSpeed) {
                this.randomizeMovement();
            }
            if (this.field_70173_aa % 10 == 0) {
                boolean found = false;
                Iterator iterator = this.field_70170_p.func_72872_a(Player.class, this.func_174813_aQ().func_186662_g(6.0)).iterator();
                if (iterator.hasNext()) {
                    Player near_pl = (Player)iterator.next();
                    found = true;
                }
                this.setVolatile(found);
            }
            if (this.isVolatile()) {
                if (this.explodeTimer < 40) {
                    ++this.explodeTimer;
                } else {
                    this.explode();
                }
            } else if (this.explodeTimer > 0) {
                --this.explodeTimer;
            }
        }
        switch (this.getMovement()) {
            case 0: {
                this.field_70159_w = -0.5;
                break;
            }
            case 1: {
                this.field_70159_w = 0.5;
                break;
            }
            case 2: {
                this.field_70181_x = -0.5;
                break;
            }
            case 3: {
                this.field_70181_x = 0.5;
                break;
            }
            case 4: {
                this.field_70179_y = -0.5;
                break;
            }
            case 5: {
                this.field_70179_y = 0.5;
            }
        }
        this.field_70133_I = true;
    }

    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(1000.0);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(1.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.25);
        this.func_110148_a(SharedMonsterAttributes.field_111266_c).func_111128_a(1.0);
    }

    protected SoundEvent func_184615_bR() {
        return null;
    }

    protected SoundEvent func_184601_bQ(DamageSource damageSourceIn) {
        return null;
    }

    protected SoundEvent func_184639_G() {
        return null;
    }

    @Override
    protected int numberOfLives() {
        return 3;
    }

    @Override
    public boolean func_70601_bi() {
        return this.field_70170_p.func_175659_aa() != EnumDifficulty.PEACEFUL;
    }

    protected ResourceLocation func_184647_J() {
        return LootTableRegistry.ENTITIES_VILEBULB;
    }
}

