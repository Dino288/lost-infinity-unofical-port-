/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.ItemStack
 *  net.minecraft.network.datasync.DataParameter
 *  net.minecraft.network.datasync.DataSerializer
 *  net.minecraft.network.datasync.DataSerializers
 *  net.minecraft.network.datasync.EntityDataManager
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.murk;

import java.util.Arrays;
import javax.annotation.Nullable;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializer;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.DimensionInit;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.init.PotionInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.ai.EntityAIFloatAttack;
import xol.lostinfinity.mob.entity.base.EntityFloatingBase;
import xol.lostinfinity.mob.entity.base.IConditionalDamage;
import xol.lostinfinity.projectile.entity.EntityScreamerBlast;
import xol.lostinfinity.projectile.entity.EntityScreamerPortalEffect;
import xol.lostinfinity.util.data.CustomParticleConfig;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.fx.IParticleSpawner;

public class EntityScreamer
extends EntityFloatingBase
implements IConditionalDamage {
    private static final DataParameter<Boolean> PINCERS_MOVING = EntityDataManager.func_187226_a(EntityScreamer.class, (DataSerializer)DataSerializers.field_187198_h);
    private static final DataParameter<Boolean> MOVE_PINCER_UP = EntityDataManager.func_187226_a(EntityScreamer.class, (DataSerializer)DataSerializers.field_187198_h);
    private static final DataParameter<Boolean> IN_OCEAN = EntityDataManager.func_187226_a(EntityScreamer.class, (DataSerializer)DataSerializers.field_187198_h);
    private boolean hasPortal = false;

    public EntityScreamer(Level worldIn) {
        super(worldIn);
        this.func_70105_a(5.0f, 8.0f);
        this.rawFlySpeed = 0.94f;
    }

    @Override
    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(1.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.32);
        this.func_110148_a(SharedMonsterAttributes.field_111266_c).func_111128_a(1.0);
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(5000.0);
    }

    @Override
    protected void func_70088_a() {
        super.func_70088_a();
        this.func_184212_Q().func_187214_a(PINCERS_MOVING, (Object)false);
        this.func_184212_Q().func_187214_a(MOVE_PINCER_UP, (Object)false);
        this.func_184212_Q().func_187214_a(IN_OCEAN, (Object)false);
    }

    public boolean func_70652_k(Entity entity) {
        super.func_70652_k(entity);
        if (this.func_70638_az() != null) {
            IMaxAttack.dealMaxHealth((Entity)this, this.func_70638_az(), 1, Arrays.asList("Darkborn", "Aquatic"));
            return true;
        }
        return false;
    }

    @Override
    @Nullable
    protected EntityAIFloatAttack createShootAI() {
        return null;
    }

    public boolean isPincerMovingUp() {
        return (Boolean)this.func_184212_Q().func_187225_a(MOVE_PINCER_UP);
    }

    public boolean isPincerMoving() {
        return (Boolean)this.func_184212_Q().func_187225_a(PINCERS_MOVING);
    }

    public void setPincerMoving(boolean moving) {
        this.func_184212_Q().func_187227_b(PINCERS_MOVING, (Object)moving);
    }

    public void setPincerMovingUp(boolean moving) {
        this.func_184212_Q().func_187227_b(MOVE_PINCER_UP, (Object)moving);
    }

    public boolean getInOcean() {
        return (Boolean)this.field_70180_af.func_187225_a(IN_OCEAN);
    }

    public void setInOcean(boolean inOcean) {
        this.func_184212_Q().func_187227_b(IN_OCEAN, (Object)false);
    }

    protected SoundEvent func_184615_bR() {
        return SoundInit.WHISPER_DEATH;
    }

    protected SoundEvent func_184601_bQ(DamageSource damageSourceIn) {
        return SoundInit.WHISPER_HURT;
    }

    protected SoundEvent func_184639_G() {
        return SoundInit.WHISPER_AMBIENT;
    }

    protected boolean func_70692_ba() {
        return false;
    }

    @Override
    public void func_70636_d() {
        super.func_70636_d();
        if (!this.field_70170_p.field_72995_K) {
            if (this.hasPortal) {
                for (EntityScreamerPortalEffect portal : this.field_70170_p.func_72872_a(EntityScreamerPortalEffect.class, new AABB(this.func_180425_c()).func_72314_b(2.0, 2.0, 2.0))) {
                    Player closest;
                    double dist = portal.func_70011_f(this.field_70165_t, this.field_70163_u, this.field_70161_v);
                    if (!(dist < 1.2) || (closest = this.field_70170_p.func_72890_a((Entity)this, 200.0)) == null) continue;
                    ItemStack stack = new ItemStack(ItemInit.scrollOfRedirection, 1);
                    closest.func_191521_c(stack);
                    closest.func_145747_a((Component)new Component((Object)((Object)TextFmt.Green) + String.format("The screamer is trying to escape to the Shadow Sea %s. It thinks you cannot find it there. I have given you a scroll to it's location.", closest.func_70005_c_())));
                    this.func_70106_y();
                    portal.func_70106_y();
                    this.func_184185_a(SoundInit.RAPID_TELEPORT, 2.0f, 1.0f);
                    this.field_70170_p.func_184133_a(null, closest.func_180425_c(), SoundInit.RAPID_TELEPORT, SoundSource.HOSTILE, 1.0f, 1.0f);
                    CustomParticleConfig config1 = new CustomParticleConfig();
                    config1.setCount(3);
                    config1.createInstance().setParticle(ParticleInit.EXPLOSION_BLUE).setSpread(5.0, 1.0, 5.0).setIgnoreRange(true);
                    config1.createInstance().setParticle(ParticleInit.EXPLOSION_TEAL).setSpread(5.0, 1.0, 5.0).setIgnoreRange(true);
                    CustomParticleConfig config2 = new CustomParticleConfig();
                    config2.createInstance().setParticle(ParticleInit.MURK).setSpread(10.0, 2.0, 10.0).setCount(7).setIgnoreRange(true);
                    IParticleSpawner.spawnParticle(this.field_70170_p, config1, this.field_70165_t, this.field_70163_u + 0.25, this.field_70161_v);
                    IParticleSpawner.spawnParticle(this.field_70170_p, config2, this.field_70165_t, this.field_70163_u + 0.25, this.field_70161_v);
                }
            } else {
                boolean ocean;
                if (this.func_70638_az() != null) {
                    LivingEntity target = this.func_70638_az();
                    this.func_70605_aq().func_75642_a(target.field_70165_t, target.field_70163_u, target.field_70161_v, 1.0);
                }
                if (this.field_70173_aa % 400 == 0) {
                    for (Player player : this.field_70170_p.func_72872_a(Player.class, new AABB(this.func_180425_c()).func_186662_g(40.0))) {
                        player.func_70690_d(new PotionEffect(PotionInit.DISTORTION, 120, 1));
                        player.func_145747_a((Component)new Component((Object)((Object)TextFmt.Dark_Aqua) + String.format("Your head is rattled by the scream.", new Object[0])));
                        this.field_70170_p.func_184133_a(null, player.func_180425_c(), SoundInit.WHISPER_AMBIENT, SoundSource.MASTER, 1.3f, 0.5f);
                    }
                }
                if (this.field_70146_Z.nextInt(50) == 0) {
                    this.soundPlayers(this.randomWhisper(this.field_70146_Z.nextInt(5)), 1.0f, 0.4f + this.field_70146_Z.nextFloat() * 0.5f);
                }
                this.rawFlySpeed = this.field_70173_aa % ((ocean = this.getInOcean()) ? 100 : 200) <= 40 ? (ocean ? 1.2f : 0.98f) : (ocean ? 0.97f : 0.94f);
                if (ocean && this.field_70173_aa % 10 == 0 || !ocean && this.field_70173_aa % 30 == 0) {
                    EntityScreamerBlast shot = new EntityScreamerBlast(this.field_70170_p, this.field_70165_t, this.field_70163_u, this.field_70161_v);
                    shot.setThrower((LivingEntity)this);
                    shot.func_70186_c(-0.1f + this.field_70146_Z.nextFloat() * 0.2f, this.field_70146_Z.nextBoolean() ? -2.0 : 2.0, -0.1f + this.field_70146_Z.nextFloat() * 0.2f, 0.7f, 0.0f);
                    this.field_70170_p.func_72838_d((Entity)shot);
                    this.soundPlayers(SoundInit.LASER_WEAPON_1, 0.5f, 0.9f + this.field_70146_Z.nextFloat() * 0.2f);
                }
            }
        }
    }

    protected void soundPlayers(SoundEvent sound, float vol, float pitch) {
        for (Player contender : this.field_70170_p.func_72872_a(Player.class, new AABB(this.func_180425_c()).func_186662_g(25.0))) {
            this.field_70170_p.func_184133_a(null, contender.func_180425_c(), sound, SoundSource.MASTER, vol, pitch);
        }
    }

    @Override
    protected int numberOfLives() {
        return 100;
    }

    @Override
    protected void updateLifeAction() {
        if (!this.field_70170_p.field_72995_K) {
            int lifePercent = Math.round(100 * (this.numberOfLives() - this.getLivesCount()) / this.numberOfLives());
            AABB pullBox = new AABB(this.func_180425_c()).func_186662_g(45.0);
            for (Player entity : this.field_70170_p.func_72872_a(Player.class, pullBox)) {
                entity.func_145747_a((Component)new Component((Object)((Object)TextFmt.Gold) + "The Screamer is at " + lifePercent + "% health."));
            }
            if (this.field_70170_p.field_73011_w.func_186058_p() == DimensionInit.infiniteMurk && this.remainingLives() <= this.numberOfLives() / 2 && !this.hasPortal) {
                this.func_184185_a(SoundInit.LARGE_TELEPORT, 2.0f, 1.0f);
                this.hasPortal = true;
                EntityScreamerPortalEffect portal = new EntityScreamerPortalEffect(this.field_70170_p);
                portal.func_70107_b(this.field_70165_t, this.field_70163_u + 8.0, this.field_70161_v);
                this.func_70605_aq().func_75642_a(this.field_70165_t, this.field_70163_u + 8.0, this.field_70161_v, 0.75);
                this.field_70170_p.func_72838_d((Entity)portal);
                this.func_70606_j(this.func_110138_aP());
            }
        }
    }

    @Override
    public void trueDeathAction() {
        if (!this.field_70170_p.field_72995_K) {
            this.func_145779_a(ItemInit.astralOrgan, 1);
        }
    }

    @Override
    public boolean canBeDamaged(Entity attacker) {
        return !this.hasPortal;
    }

    private SoundEvent randomWhisper(int i) {
        switch (i) {
            case 0: {
                return SoundInit.WHISPER_1;
            }
            case 1: {
                return SoundInit.WHISPER_2;
            }
            case 2: {
                return SoundInit.WHISPER_3;
            }
            case 3: {
                return SoundInit.WHISPER_4;
            }
            case 4: {
                return SoundInit.WHISPER_5;
            }
        }
        return SoundInit.WHISPER_5;
    }
}

