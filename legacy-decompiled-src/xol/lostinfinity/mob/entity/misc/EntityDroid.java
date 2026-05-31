/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityAgeable
 *  net.minecraft.entity.PathfinderMob
 *  net.minecraft.entity.Mob
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.ai.EntityAIAttackMelee
 *  net.minecraft.entity.ai.EntityAIBase
 *  net.minecraft.entity.ai.EntityAIHurtByTarget
 *  net.minecraft.entity.ai.EntityAILeapAtTarget
 *  net.minecraft.entity.ai.EntityAILookIdle
 *  net.minecraft.entity.ai.EntityAIOwnerHurtByTarget
 *  net.minecraft.entity.ai.EntityAIOwnerHurtTarget
 *  net.minecraft.entity.ai.EntityAISwimming
 *  net.minecraft.entity.ai.EntityAIWanderAvoidWater
 *  net.minecraft.entity.ai.EntityAIWatchClosest
 *  net.minecraft.entity.passive.EntityTameable
 *  net.minecraft.entity.player.Player
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.datasync.DataParameter
 *  net.minecraft.network.datasync.DataSerializer
 *  net.minecraft.network.datasync.DataSerializers
 *  net.minecraft.network.datasync.EntityDataManager
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.EnumParticleTypes
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Mth
 *  net.minecraft.world.DimensionType
 *  net.minecraft.world.EnumDifficulty
 *  net.minecraft.world.World
 *  net.minecraft.world.ServerLevel
 */
package xol.lostinfinity.mob.entity.misc;

import net.minecraft.world.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIOwnerHurtByTarget;
import net.minecraft.entity.ai.EntityAIOwnerHurtTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.world.entity.player.Player;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializer;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.DimensionType;
import net.minecraft.world.Difficulty;
import net.minecraft.world.level.Level;
import net.minecraft.server.level.ServerLevel;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.entity.base.EntityDeviantMob;
import xol.lostinfinity.projectile.entity.EntityDroidLaser;
import xol.lostinfinity.util.data.IMaxAttack;

public class EntityDroid
extends EntityTameable
implements IMaxAttack {
    private static final DataParameter<Integer> GRADE = EntityDataManager.func_187226_a(EntityDroid.class, (DataSerializer)DataSerializers.field_187192_b);
    private static final DataParameter<Boolean> AGGRESSIVE = EntityDataManager.func_187226_a(EntityDroid.class, (DataSerializer)DataSerializers.field_187198_h);
    private static final DataParameter<Integer> ATTACK_TIME = EntityDataManager.func_187226_a(EntityDroid.class, (DataSerializer)DataSerializers.field_187192_b);
    private static final DataParameter<Integer> TARGET_LEVEL = EntityDataManager.func_187226_a(EntityDroid.class, (DataSerializer)DataSerializers.field_187192_b);
    private int killcount = 0;

    public EntityDroid(Level worldIn) {
        super(worldIn);
        this.func_70105_a(1.2f, 2.2f);
    }

    protected void func_184651_r() {
        this.field_70714_bg.func_75776_a(1, (EntityAIBase)new EntityAISwimming((Mob)this));
        this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAILeapAtTarget((Mob)this, 0.4f));
        this.field_70714_bg.func_75776_a(4, (EntityAIBase)new EntityAIAttackMelee((PathfinderMob)this, 1.0, true));
        this.field_70714_bg.func_75776_a(7, (EntityAIBase)new EntityAIWanderAvoidWater((PathfinderMob)this, 1.0));
        this.field_70714_bg.func_75776_a(9, (EntityAIBase)new EntityAIWatchClosest((Mob)this, Player.class, 8.0f));
        this.field_70714_bg.func_75776_a(9, (EntityAIBase)new EntityAILookIdle((Mob)this));
        this.field_70715_bh.func_75776_a(1, (EntityAIBase)new EntityAIOwnerHurtByTarget((EntityTameable)this));
        this.field_70715_bh.func_75776_a(2, (EntityAIBase)new EntityAIOwnerHurtTarget((EntityTameable)this));
        this.field_70715_bh.func_75776_a(3, (EntityAIBase)new EntityAIHurtByTarget((PathfinderMob)this, true, new Class[0]));
    }

    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.35);
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(1250.0);
    }

    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a(GRADE, (Object)0);
        this.field_70180_af.func_187214_a(AGGRESSIVE, (Object)true);
        this.field_70180_af.func_187214_a(ATTACK_TIME, (Object)0);
        this.field_70180_af.func_187214_a(TARGET_LEVEL, (Object)0);
    }

    public int getGrade() {
        return (Integer)this.field_70180_af.func_187225_a(GRADE);
    }

    public void setGrade(int grade) {
        this.field_70180_af.func_187227_b(GRADE, (Object)grade);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.35 + 0.1 * (double)grade);
    }

    public boolean isAggressive() {
        return (Boolean)this.field_70180_af.func_187225_a(AGGRESSIVE);
    }

    public void setAggressive(boolean aggro) {
        this.field_70180_af.func_187227_b(AGGRESSIVE, (Object)aggro);
    }

    public int getAttackTime() {
        return (Integer)this.field_70180_af.func_187225_a(ATTACK_TIME);
    }

    public void setAttackTime(int f) {
        this.field_70180_af.func_187227_b(ATTACK_TIME, (Object)f);
    }

    public int getTargetLevel() {
        return (Integer)this.field_70180_af.func_187225_a(TARGET_LEVEL);
    }

    public void setTargetLevel(int f) {
        this.field_70180_af.func_187227_b(TARGET_LEVEL, (Object)f);
    }

    public void func_70014_b(CompoundTag tag) {
        super.func_70014_b(tag);
        tag.func_74768_a("KillCount", this.killcount);
        tag.func_74757_a("AttackStyle", this.isAggressive());
        tag.func_74768_a("DroidGrade", this.getGrade());
    }

    public void func_70037_a(CompoundTag tag) {
        super.func_70037_a(tag);
        this.killcount = tag.func_74762_e("KillCount");
        this.setAggressive(tag.func_74767_n("AttackStyle"));
        this.setGrade(tag.func_74762_e("DroidGrade"));
    }

    public boolean func_70652_k(Entity entity) {
        this.setAttackTime(20);
        super.func_70652_k(entity);
        if (!this.field_70170_p.field_72995_K && this.func_70638_az() != null) {
            boolean attackingDeviant = this.func_70638_az() instanceof EntityDeviantMob;
            boolean wasKilled = IMaxAttack.dealMaxHealth((Entity)this, this.func_70638_az(), 10, 2 + 2 * this.getGrade()).wasTargetKilled();
            ((ServerLevel)this.field_70170_p).func_175739_a(EnumParticleTypes.SWEEP_ATTACK, this.field_70165_t, this.field_70163_u + 1.0, this.field_70161_v, 2, -0.5 + this.field_70146_Z.nextDouble(), 0.3 * (-0.5 + this.field_70146_Z.nextDouble()), -0.5 + this.field_70146_Z.nextDouble(), (double)0.15f, new int[0]);
            if (!wasKilled && this.func_70638_az() instanceof Player) {
                if (this.getGrade() == 2 && this.field_70146_Z.nextInt(10) == 1) {
                    Player player = (Player)this.func_70638_az();
                    player.field_71071_by.func_70436_m();
                }
            } else if (wasKilled && attackingDeviant) {
                if (this.killcount == 5) {
                    this.func_145779_a(ItemInit.droidLocationDataD, 1);
                    this.killcount = 0;
                } else {
                    ++this.killcount;
                }
            }
            return true;
        }
        return false;
    }

    public void func_70645_a(DamageSource cause) {
        super.func_70645_a(cause);
        if (cause.func_76346_g() instanceof Player && cause.func_76346_g() == this.func_70902_q() && !this.field_70170_p.field_72995_K) {
            if (this.field_70170_p.field_73011_w.func_186058_p() == DimensionType.OVERWORLD) {
                this.func_145779_a(ItemInit.droidLocationDataO, 1);
            } else if (this.field_70170_p.field_73011_w.func_186058_p() == DimensionType.THE_END) {
                this.func_145779_a(ItemInit.droidLocationDataE, 1);
            } else if (this.field_70170_p.field_73011_w.func_186058_p() == DimensionType.NETHER) {
                this.func_145779_a(ItemInit.droidLocationDataN, 1);
            }
        }
    }

    public void func_70636_d() {
        int grade;
        super.func_70636_d();
        if (!this.field_70170_p.field_72995_K && this.field_70170_p.func_175659_aa() == EnumDifficulty.PEACEFUL) {
            this.func_70106_y();
        }
        if (this.getAttackTime() > 0) {
            this.setAttackTime(this.getAttackTime() - 1);
        }
        this.field_70143_R = -1.0f;
        if (this.isAggressive() && this.field_70173_aa % 30 == 0) {
            float lowest = 100000.0f;
            for (LivingEntity li : this.field_70170_p.func_72872_a(LivingEntity.class, this.func_174813_aQ().func_72314_b(12.0, 12.0, 12.0))) {
                float newdist;
                if (li.func_110124_au().equals(this.func_184753_b()) || li instanceof EntityDroid || li.field_70128_L || !((newdist = this.func_70032_d((Entity)li)) < lowest)) continue;
                this.func_70624_b(li);
                lowest = newdist;
            }
        }
        if ((grade = this.getGrade()) > 0 && !this.field_70170_p.field_72995_K) {
            if (this.field_70173_aa % 10 == 0) {
                this.func_70691_i(150.0f);
            }
            float distance_to_target = 0.0f;
            if (this.func_70638_az() != null) {
                distance_to_target = this.func_70032_d((Entity)this.func_70638_az());
            }
            if (this.field_70173_aa % 20 == 0) {
                if (this.func_70638_az() != null) {
                    this.setTargetLevel(1 + (distance_to_target < 10.0f ? 0 : 1));
                } else {
                    this.setTargetLevel(0);
                }
            }
            if (this.func_70638_az() != null) {
                if (this.func_70638_az().field_70128_L) {
                    this.func_70624_b(null);
                } else {
                    int ticksRemainder = this.field_70173_aa % 200;
                    if (ticksRemainder == 0) {
                        if (grade == 1 && this.func_70032_d((Entity)this.func_70638_az()) < 30.0f) {
                            this.func_70024_g((this.func_70638_az().field_70165_t - this.field_70165_t) * 0.35, (this.func_70638_az().field_70163_u - this.field_70163_u) * 0.3, (this.func_70638_az().field_70161_v - this.field_70161_v) * 0.35);
                        } else if (grade == 2) {
                            ((ServerLevel)this.field_70170_p).func_175739_a(EnumParticleTypes.LAVA, this.field_70165_t, this.field_70163_u + 1.0, this.field_70161_v, 5, -0.5 + this.field_70146_Z.nextDouble(), 0.3 * (-0.5 + this.field_70146_Z.nextDouble()), -0.5 + this.field_70146_Z.nextDouble(), (double)0.15f, new int[0]);
                            this.func_70634_a(this.func_70638_az().field_70165_t, this.func_70638_az().field_70163_u, this.func_70638_az().field_70161_v);
                            this.func_184185_a(SoundEvents.field_187534_aX, 1.0f, 1.0f);
                        }
                    }
                    if (grade == 2) {
                        if (ticksRemainder % 3 == 0 && distance_to_target >= 10.0f) {
                            BlockPos startPos = this.func_180425_c().func_177984_a();
                            BlockPos endPos = this.func_70638_az().func_180425_c().func_177984_a();
                            double xdiff = startPos.func_177958_n() - endPos.func_177958_n();
                            double ydiff = startPos.func_177956_o() - endPos.func_177956_o();
                            double zdiff = startPos.func_177952_p() - endPos.func_177952_p();
                            int count = 8;
                            for (int part = 0; part < count; ++part) {
                                BlockPos curPos = new BlockPos((double)startPos.func_177958_n() + -xdiff / (double)count * (double)part, (double)startPos.func_177956_o() + -ydiff / (double)count * (double)part, (double)startPos.func_177952_p() + -zdiff / (double)count * (double)part);
                                ((ServerLevel)this.field_70170_p).func_175739_a(EnumParticleTypes.PORTAL, (double)curPos.func_177958_n(), (double)curPos.func_177956_o(), (double)curPos.func_177952_p(), 2, -0.5 + this.field_70146_Z.nextDouble(), 0.3 * (-0.5 + this.field_70146_Z.nextDouble()), -0.5 + this.field_70146_Z.nextDouble(), (double)0.15f, new int[0]);
                            }
                            this.func_70638_az().func_70024_g(Math.signum(this.field_70165_t - this.func_70638_az().field_70165_t) * 0.8, Math.signum(this.field_70163_u - this.func_70638_az().field_70163_u) * 0.7, Math.signum(this.field_70161_v - this.func_70638_az().field_70161_v) * 0.8);
                            this.func_70638_az().field_70133_I = true;
                        }
                        if (ticksRemainder % 20 == 0) {
                            LivingEntity target = this.func_70638_az();
                            EntityDroidLaser shot = new EntityDroidLaser(this.field_70170_p, (LivingEntity)this);
                            double d0 = target.field_70165_t - this.field_70165_t;
                            double d1 = target.func_174813_aQ().field_72338_b + (double)(target.field_70131_O / 6.0f) - shot.field_70163_u;
                            double d2 = target.field_70161_v - this.field_70161_v;
                            double d3 = Mth.func_76133_a((double)(d0 * d0 + d2 * d2));
                            shot.func_70186_c(d0, d1 + d3 * (double)0.2f, d2, 2.0f, 0.0f);
                            shot.setOwner(this.func_70902_q());
                            this.field_70170_p.func_72838_d((Entity)shot);
                            this.func_184185_a(SoundInit.LASER_WEAPON_1, 1.0f, 0.75f + this.field_70146_Z.nextFloat() * 0.5f);
                        }
                    }
                }
            }
        }
    }

    protected SoundEvent func_184615_bR() {
        return SoundEvents.field_187599_cE;
    }

    protected SoundEvent func_184601_bQ(DamageSource damageSourceIn) {
        return SoundEvents.field_187602_cF;
    }

    protected SoundEvent func_184639_G() {
        return null;
    }

    protected boolean func_70692_ba() {
        return this.func_70902_q() == null;
    }

    public boolean func_70601_bi() {
        return this.field_70170_p.func_175659_aa() != EnumDifficulty.PEACEFUL;
    }

    public EntityAgeable func_90011_a(EntityAgeable ageable) {
        return null;
    }
}

