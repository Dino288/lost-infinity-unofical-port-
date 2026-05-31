/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.PathfinderMob
 *  net.minecraft.entity.Mob
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.ai.EntityAIAttackMelee
 *  net.minecraft.entity.ai.EntityAIBase
 *  net.minecraft.entity.ai.EntityAIHurtByTarget
 *  net.minecraft.entity.ai.EntityAILookIdle
 *  net.minecraft.entity.ai.EntityAIMoveThroughVillage
 *  net.minecraft.entity.ai.EntityAIMoveTowardsRestriction
 *  net.minecraft.entity.ai.EntityAINearestAttackableTarget
 *  net.minecraft.entity.ai.EntityAISwimming
 *  net.minecraft.entity.ai.EntityAIWanderAvoidWater
 *  net.minecraft.entity.ai.EntityAIWatchClosest
 *  net.minecraft.entity.monster.EntityGuardian
 *  net.minecraft.entity.monster.EntityIronGolem
 *  net.minecraft.entity.monster.Monster
 *  net.minecraft.entity.monster.EntityPigZombie
 *  net.minecraft.entity.passive.EntityVillager
 *  net.minecraft.entity.player.Player
 *  net.minecraft.entity.player.ServerPlayer
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.Packet
 *  net.minecraft.network.datasync.DataParameter
 *  net.minecraft.network.datasync.DataSerializer
 *  net.minecraft.network.datasync.DataSerializers
 *  net.minecraft.network.datasync.EntityDataManager
 *  net.minecraft.network.play.server.SPacketEntityTeleport
 *  net.minecraft.network.play.server.SPacketEntityVelocity
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.util.math.Mth
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraft.world.World
 *  net.minecraftforge.common.BiomeDictionary
 *  net.minecraftforge.common.BiomeDictionary$Type
 */
package xol.lostinfinity.mob.entity.boss;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityGuardian;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Packet;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializer;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.play.server.SPacketEntityTeleport;
import net.minecraft.network.play.server.SPacketEntityVelocity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.BiomeDictionary;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.projectile.entity.EntityElaraShot;
import xol.lostinfinity.stone.EntityInfinityStone;

public class EntityElara
extends Monster {
    private static final DataParameter<Byte> TYPE = EntityDataManager.func_187226_a(EntityElara.class, (DataSerializer)DataSerializers.field_187191_a);
    private static final DataParameter<Float> spawnX = EntityDataManager.func_187226_a(EntityElara.class, (DataSerializer)DataSerializers.field_187193_c);
    private static final DataParameter<Float> spawnY = EntityDataManager.func_187226_a(EntityElara.class, (DataSerializer)DataSerializers.field_187193_c);
    private static final DataParameter<Float> spawnZ = EntityDataManager.func_187226_a(EntityElara.class, (DataSerializer)DataSerializers.field_187193_c);

    public EntityElara(Level worldIn) {
        super(worldIn);
        this.func_70105_a(2.5f, 7.0f);
    }

    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a(TYPE, (Object)0);
        this.field_70180_af.func_187214_a(spawnX, (Object)Float.valueOf(0.0f));
        this.field_70180_af.func_187214_a(spawnY, (Object)Float.valueOf(-10.0f));
        this.field_70180_af.func_187214_a(spawnZ, (Object)Float.valueOf(0.0f));
    }

    public byte getForm() {
        return (Byte)this.field_70180_af.func_187225_a(TYPE);
    }

    public void setForm(byte f) {
        this.field_70180_af.func_187227_b(TYPE, (Object)f);
    }

    public void resetSpawnCoords(float xp, float yp, float zp) {
        this.field_70180_af.func_187227_b(spawnX, (Object)Float.valueOf(xp));
        this.field_70180_af.func_187227_b(spawnY, (Object)Float.valueOf(yp));
        this.field_70180_af.func_187227_b(spawnZ, (Object)Float.valueOf(zp));
    }

    public void func_70014_b(CompoundTag tag) {
        super.func_70014_b(tag);
        tag.func_74774_a("BossType", this.getForm());
        tag.func_74776_a("SpawnX", ((Float)this.field_70180_af.func_187225_a(spawnX)).floatValue());
        tag.func_74776_a("SpawnY", ((Float)this.field_70180_af.func_187225_a(spawnY)).floatValue());
        tag.func_74776_a("SpawnZ", ((Float)this.field_70180_af.func_187225_a(spawnZ)).floatValue());
    }

    public void func_70037_a(CompoundTag tag) {
        super.func_70037_a(tag);
        this.setForm(tag.func_74771_c("BossType"));
        this.resetSpawnCoords(tag.func_74760_g("SpawnX"), tag.func_74760_g("SpawnY"), tag.func_74760_g("SpawnZ"));
    }

    public void func_70645_a(DamageSource cause) {
        super.func_70645_a(cause);
        if (!this.field_70170_p.field_72995_K) {
            switch (this.getForm()) {
                case 0: {
                    EntityInfinityStone ocstone = new EntityInfinityStone(this.field_70170_p);
                    ocstone.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
                    this.field_70170_p.func_72838_d((Entity)ocstone);
                    break;
                }
                case 1: {
                    EntityInfinityStone mtstone = new EntityInfinityStone(this.field_70170_p);
                    mtstone.setStoneNum((byte)1);
                    mtstone.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
                    this.field_70170_p.func_72838_d((Entity)mtstone);
                }
            }
        }
    }

    protected void func_184651_r() {
        this.field_70714_bg.func_75776_a(0, (EntityAIBase)new EntityAISwimming((Mob)this));
        this.field_70714_bg.func_75776_a(2, (EntityAIBase)new EntityAIAttackMelee((PathfinderMob)this, 1.0, true));
        this.field_70714_bg.func_75776_a(5, (EntityAIBase)new EntityAIMoveTowardsRestriction((PathfinderMob)this, 1.0));
        this.field_70714_bg.func_75776_a(7, (EntityAIBase)new EntityAIWanderAvoidWater((PathfinderMob)this, 1.0));
        this.field_70714_bg.func_75776_a(8, (EntityAIBase)new EntityAIWatchClosest((Mob)this, Player.class, 16.0f));
        this.field_70714_bg.func_75776_a(8, (EntityAIBase)new EntityAILookIdle((Mob)this));
        this.func_175456_n();
    }

    protected void func_175456_n() {
        this.field_70714_bg.func_75776_a(6, (EntityAIBase)new EntityAIMoveThroughVillage((PathfinderMob)this, 1.0, false));
        this.field_70715_bh.func_75776_a(1, (EntityAIBase)new EntityAIHurtByTarget((PathfinderMob)this, true, new Class[]{EntityPigZombie.class}));
        this.field_70715_bh.func_75776_a(2, (EntityAIBase)new EntityAINearestAttackableTarget((PathfinderMob)this, Player.class, true));
        this.field_70715_bh.func_75776_a(3, (EntityAIBase)new EntityAINearestAttackableTarget((PathfinderMob)this, EntityVillager.class, false));
        this.field_70715_bh.func_75776_a(3, (EntityAIBase)new EntityAINearestAttackableTarget((PathfinderMob)this, EntityIronGolem.class, true));
    }

    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(5.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.5);
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(5000.0);
        this.func_110148_a(SharedMonsterAttributes.field_111265_b).func_111128_a(30.0);
    }

    public void func_70636_d() {
        super.func_70636_d();
        this.field_70143_R = -1.0f;
        if (((Float)this.field_70180_af.func_187225_a(spawnY)).floatValue() == -10.0f) {
            this.field_70180_af.func_187227_b(spawnY, (Object)Float.valueOf((float)this.field_70163_u));
            this.field_70180_af.func_187227_b(spawnX, (Object)Float.valueOf((float)this.field_70165_t));
            this.field_70180_af.func_187227_b(spawnZ, (Object)Float.valueOf((float)this.field_70161_v));
        }
        LivingEntity target = this.func_70638_az();
        if (this.getForm() == 0) {
            EntityElaraShot shot;
            if (!this.field_70170_p.field_72995_K && this.field_70173_aa % 60 == 0 && target != null) {
                shot = new EntityElaraShot(this.field_70170_p, (LivingEntity)this);
                double d0 = target.field_70165_t - this.field_70165_t;
                double d1 = target.func_174813_aQ().field_72338_b + (double)(target.field_70131_O / 3.0f) - shot.field_70163_u;
                double d2 = target.field_70161_v - this.field_70161_v;
                double d3 = Mth.func_76133_a((double)(d0 * d0 + d2 * d2));
                shot.func_70186_c(d0, d1 + d3 * (double)0.2f, d2, 2.0f, 0.0f);
                this.field_70170_p.func_184133_a(this.field_70717_bb, this.func_180425_c(), SoundEvents.field_187609_F, SoundSource.HOSTILE, 1.0f, 1.0f);
                this.field_70170_p.func_72838_d((Entity)shot);
            }
            if (!this.field_70170_p.field_72995_K && this.field_70173_aa % 140 == 0 && target != null && target instanceof Player && !BiomeDictionary.getBiomes((BiomeDictionary.Type)BiomeDictionary.Type.OCEAN).contains(target.field_70170_p.func_180494_b(target.func_180425_c()))) {
                target.field_70165_t = ((Float)this.field_70180_af.func_187225_a(spawnX)).floatValue();
                target.field_70163_u = (double)((Float)this.field_70180_af.func_187225_a(spawnY)).floatValue() + 10.0;
                target.field_70161_v = ((Float)this.field_70180_af.func_187225_a(spawnZ)).floatValue();
                ((ServerPlayer)target).field_71135_a.func_147359_a((Packet)new SPacketEntityTeleport((Entity)target));
                target.func_145747_a((Component)new Component((Object)((Object)TextFmt.Blue) + "Elara: Back to the ocean!"));
            }
            if (this.field_70173_aa % 100 == 0 && !this.field_70170_p.field_72995_K) {
                this.pushPlayersAway(this.field_70170_p, (Mob)this);
            }
            if (this.field_70173_aa % 250 == 0) {
                this.func_70024_g(0.0, 3.0, 0.0);
                this.field_70133_I = true;
            }
            if (this.field_70181_x > 0.3 && !this.field_70703_bu && !this.field_70170_p.field_72995_K) {
                shot = new EntityElaraShot(this.field_70170_p, (LivingEntity)this, 12);
                shot.func_70186_c(-1.0 + this.field_70170_p.field_73012_v.nextDouble() * 2.0, -1.0, -1.0 + this.field_70170_p.field_73012_v.nextDouble() * 2.0, 2.0f, 0.0f);
                this.field_70170_p.func_184133_a(this.field_70717_bb, this.func_180425_c(), SoundEvents.field_187612_G, SoundSource.HOSTILE, 1.0f, 1.0f);
                this.field_70170_p.func_72838_d((Entity)shot);
            }
            if (!this.field_70170_p.field_72995_K && this.field_70173_aa % 400 == 0) {
                for (int i = 0; i < 4 + this.field_70170_p.field_73012_v.nextInt(2); ++i) {
                    EntityGuardian guardian = new EntityGuardian(this.field_70170_p);
                    guardian.func_70107_b(this.field_70165_t - 4.0 + 8.0 * this.field_70170_p.field_73012_v.nextDouble(), this.field_70163_u + 2.0, this.field_70161_v - 4.0 + 8.0 * this.field_70170_p.field_73012_v.nextDouble());
                    this.field_70170_p.func_72838_d((Entity)guardian);
                }
                if (target != null && target instanceof Player) {
                    target.func_145747_a((Component)new Component((Object)((Object)TextFmt.Gray) + "Elara: Guardians, to me!"));
                }
            }
        } else {
            if (!this.field_70170_p.field_72995_K && this.field_70173_aa % 60 == 0 && target != null) {
                EntityElaraShot shot = new EntityElaraShot(this.field_70170_p, (LivingEntity)this);
                double d0 = target.field_70165_t - this.field_70165_t;
                double d1 = target.func_174813_aQ().field_72338_b + (double)(target.field_70131_O / 3.0f) - shot.field_70163_u;
                double d2 = target.field_70161_v - this.field_70161_v;
                double d3 = Mth.func_76133_a((double)(d0 * d0 + d2 * d2));
                shot.func_70186_c(d0, d1 + d3 * (double)0.2f, d2, 2.0f, 0.0f);
                this.field_70170_p.func_184133_a(this.field_70717_bb, this.func_180425_c(), SoundEvents.field_187534_aX, SoundSource.HOSTILE, 1.0f, 1.0f);
                this.field_70170_p.func_72838_d((Entity)shot);
            }
            if (this.field_70173_aa % 100 == 0 && !this.field_70170_p.field_72995_K) {
                this.pushPlayersAway(this.field_70170_p, (Mob)this);
            }
            if (this.field_70173_aa % 150 == 0 && this.func_70638_az() != null && this.func_70638_az() instanceof Player) {
                Player pl = (Player)this.func_70638_az();
                this.func_70024_g((pl.field_70165_t - this.field_70165_t) * 0.145, 1.0, (pl.field_70161_v - this.field_70161_v) * 0.145);
                this.field_70133_I = true;
            }
            if (this.field_70173_aa % 120 == 0 && !this.field_70170_p.field_72995_K && target != null && target instanceof Player) {
                for (int i = 0; i < 8 + this.field_70170_p.field_73012_v.nextInt(4); ++i) {
                    EntityElaraShot shot = new EntityElaraShot(this.field_70170_p, target.field_70165_t - 4.0 + this.field_70170_p.field_73012_v.nextDouble() * 8.0, target.field_70163_u + 20.0, target.field_70161_v - 4.0 + this.field_70170_p.field_73012_v.nextDouble() * 8.0);
                    shot.setThrower((LivingEntity)this);
                    shot.setDenom(6);
                    shot.func_70186_c(0.0, -0.05, 0.0, 0.3f, 0.0f);
                    this.field_70170_p.func_184133_a(this.field_70717_bb, this.func_180425_c(), SoundEvents.field_187528_aR, SoundSource.HOSTILE, 1.0f, 1.0f);
                    this.field_70170_p.func_72838_d((Entity)shot);
                }
                target.func_145747_a((Component)new Component((Object)((Object)TextFmt.Light_Purple) + "Elara: Look up!"));
            }
        }
    }

    private void pushPlayersAway(Level worldIn, Mob creature) {
        for (Player e : worldIn.func_72872_a(Player.class, creature.func_174813_aQ().func_72314_b(7.0, 7.0, 7.0))) {
            e.func_70024_g(Math.signum(creature.field_70165_t - e.field_70165_t) * -1.39, 0.65, Math.signum(creature.field_70161_v - e.field_70161_v) * -1.39);
            ((ServerPlayer)e).field_71135_a.func_147359_a((Packet)new SPacketEntityVelocity((Entity)e));
            e.func_145747_a((Component)new Component((Object)((Object)TextFmt.Dark_Aqua) + "Elara: Stand back!"));
        }
    }

    protected SoundEvent func_184615_bR() {
        return SoundEvents.field_187798_ea;
    }

    protected SoundEvent func_184601_bQ(DamageSource damageSourceIn) {
        return SoundEvents.field_187800_eb;
    }

    protected SoundEvent func_184639_G() {
        return null;
    }
}

