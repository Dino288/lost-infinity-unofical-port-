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
 *  net.minecraft.entity.monster.EntityIronGolem
 *  net.minecraft.entity.monster.EntityPigZombie
 *  net.minecraft.entity.passive.EntityVillager
 *  net.minecraft.entity.player.Player
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Mth
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraft.world.EnumDifficulty
 *  net.minecraft.world.World
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
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Difficulty;
import net.minecraft.world.level.Level;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.DimensionInit;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.mob.entity.base.EntityMultipleLives;
import xol.lostinfinity.projectile.entity.EntityVeloMagic;
import xol.lostinfinity.stone.EntityInfinityStone;
import xol.lostinfinity.util.data.IMaxAttack;

public class EntityVelo
extends EntityMultipleLives
implements IMaxAttack {
    public EntityVelo(Level worldIn) {
        super(worldIn);
        this.func_70105_a(1.7f, 3.0f);
        this.field_70178_ae = true;
    }

    @Override
    protected void func_184651_r() {
        this.field_70714_bg.func_75776_a(0, (EntityAIBase)new EntityAISwimming((Mob)this));
        this.field_70714_bg.func_75776_a(2, (EntityAIBase)new EntityAIAttackMelee((PathfinderMob)this, 1.0, true));
        this.field_70714_bg.func_75776_a(5, (EntityAIBase)new EntityAIMoveTowardsRestriction((PathfinderMob)this, 1.0));
        this.field_70714_bg.func_75776_a(7, (EntityAIBase)new EntityAIWanderAvoidWater((PathfinderMob)this, 1.0));
        this.field_70714_bg.func_75776_a(8, (EntityAIBase)new EntityAIWatchClosest((Mob)this, Player.class, 8.0f));
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
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(1.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.25);
        this.func_110148_a(SharedMonsterAttributes.field_111266_c).func_111128_a(1.0);
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(4000.0);
    }

    public boolean func_70652_k(Entity entity) {
        super.func_70652_k(entity);
        if (this.func_70638_az() != null) {
            IMaxAttack.dealMaxHealth((Entity)this, this.func_70638_az(), 6);
            return true;
        }
        return false;
    }

    public void func_70636_d() {
        EntityVeloMagic shot;
        int snum;
        super.func_70636_d();
        this.field_70143_R = -1.0f;
        if (this.field_70173_aa % 30 == 0 && this.func_70638_az() != null) {
            if (!this.field_70170_p.field_72995_K) {
                LivingEntity target = this.func_70638_az();
                for (snum = -1; snum < 2; ++snum) {
                    shot = new EntityVeloMagic(this.field_70170_p, (LivingEntity)this);
                    double d0 = (target.field_70165_t - this.field_70165_t) * (1.0 + (double)snum * 0.75);
                    double d1 = target.func_174813_aQ().field_72338_b + (double)(target.field_70131_O / (3.0f + (float)(snum * 2))) - shot.field_70163_u;
                    double d2 = (target.field_70161_v - this.field_70161_v) * (1.0 + (double)snum * 0.75);
                    double d3 = Mth.func_76133_a((double)(d0 * d0 + d2 * d2));
                    shot.func_70186_c(d0, d1 + d3 * (double)0.2f, d2, 2.0f, 0.0f);
                    this.field_70170_p.func_72838_d((Entity)shot);
                }
            }
            this.func_184185_a(SoundEvents.field_193784_dd, 1.0f, 1.0f);
        }
        int roomForm = (this.getLivesCount() - 1) % 3;
        if (this.field_70173_aa % 80 == 0 && roomForm == 2) {
            if (!this.field_70170_p.field_72995_K) {
                for (snum = 0; snum < 12; ++snum) {
                    shot = new EntityVeloMagic(this.field_70170_p, (LivingEntity)this);
                    shot.setGravity(Float.valueOf(0.10000001f));
                    shot.func_70186_c(-1.0 + this.field_70170_p.field_73012_v.nextDouble() * 2.0, 0.0, -1.0 + this.field_70170_p.field_73012_v.nextDouble() * 2.0, 2.0f, 0.0f);
                    this.field_70170_p.func_72838_d((Entity)shot);
                }
            }
            this.func_184185_a(SoundEvents.field_187631_bo, 3.0f, 1.0f);
        } else if (this.field_70173_aa % 60 < 30 && this.field_70173_aa % 2 == 0 && roomForm == 1) {
            if (!this.field_70170_p.field_72995_K) {
                EntityVeloMagic shot2 = new EntityVeloMagic(this.field_70170_p, (LivingEntity)this);
                shot2.setGravity(Float.valueOf(0.10000001f));
                shot2.func_70186_c(-1.0 + this.field_70170_p.field_73012_v.nextDouble() * 2.0, 0.0, -1.0 + this.field_70170_p.field_73012_v.nextDouble() * 2.0, 2.0f, 0.0f);
                this.field_70170_p.func_72838_d((Entity)shot2);
            }
            this.func_184185_a(SoundEvents.field_187775_eP, 3.0f, 0.0f);
        } else if (this.field_70173_aa % 90 <= 30 && this.field_70173_aa % 10 == 0 && roomForm == 0) {
            if (!this.field_70170_p.field_72995_K) {
                for (snum = 0; snum < 10; ++snum) {
                    shot = new EntityVeloMagic(this.field_70170_p, (LivingEntity)this);
                    shot.setGravity(Float.valueOf(0.10000001f));
                    shot.func_70186_c(-1.0 + this.field_70170_p.field_73012_v.nextDouble() * 2.0, 0.0 + (double)(0.2f * (float)Math.floorDiv(this.field_70173_aa % 90, 10)), -1.0 + this.field_70170_p.field_73012_v.nextDouble() * 2.0, 2.0f, 0.0f);
                    this.field_70170_p.func_72838_d((Entity)shot);
                }
            }
            this.func_184185_a(SoundEvents.field_187625_bm, 3.0f, 1.0f);
        }
    }

    @Override
    protected void updateLifeAction() {
        if (this.field_70170_p.field_73011_w.func_186058_p() == DimensionInit.celestialVoid) {
            int stage = this.getLivesCount() - 1;
            if (stage == 0) {
                AABB aabb = new AABB(new BlockPos(-3.0, 60.0, -145.0), new BlockPos(52.0, 85.0, -40.0));
                for (Player near_pl : this.field_70170_p.func_72872_a(Player.class, aabb)) {
                    near_pl.func_145747_a((Component)new Component((Object)((Object)TextFmt.Dark_Purple) + "Velo: And away we go!"));
                    near_pl.func_70634_a(6.0, 61.0, -171.0);
                }
                this.func_70634_a(12.0, 61.0, -171.0);
            } else {
                int roomGo = (stage - 1) % 3;
                switch (roomGo) {
                    case 0: {
                        AABB aabb = new AABB(new BlockPos(0.0, 59.0, -180.0), new BlockPos(18.0, 68.0, -160.0));
                        for (Player near_pl : this.field_70170_p.func_72872_a(Player.class, aabb)) {
                            near_pl.func_145747_a((Component)new Component((Object)((Object)TextFmt.Dark_Purple) + "Velo: To Fire!"));
                            near_pl.func_70634_a(26.0, 62.0, -171.0);
                        }
                        this.func_70107_b(31.0, 62.0, -171.0);
                        break;
                    }
                    case 1: {
                        AABB aabb = new AABB(new BlockPos(20.0, 59.0, -180.0), new BlockPos(38.0, 68.0, -160.0));
                        for (Player near_pl : this.field_70170_p.func_72872_a(Player.class, aabb)) {
                            near_pl.func_145747_a((Component)new Component((Object)((Object)TextFmt.Dark_Purple) + "Velo: To Ender!"));
                            near_pl.func_70634_a(43.0, 64.0, -171.0);
                        }
                        this.func_70107_b(48.0, 64.0, -171.0);
                        break;
                    }
                    case 2: {
                        AABB aabb = new AABB(new BlockPos(40.0, 59.0, -180.0), new BlockPos(58.0, 68.0, -160.0));
                        for (Player near_pl : this.field_70170_p.func_72872_a(Player.class, aabb)) {
                            near_pl.func_145747_a((Component)new Component((Object)((Object)TextFmt.Dark_Purple) + "Velo: To Space!"));
                            near_pl.func_70634_a(6.0, 61.0, -171.0);
                        }
                        this.func_70107_b(12.0, 61.0, -171.0);
                    }
                }
            }
        }
        this.func_184185_a(SoundEvents.field_187534_aX, 3.0f, 1.0f);
    }

    private void clearPlayersToStart() {
        AABB aabb = new AABB(new BlockPos(0.0, 59.0, -180.0), new BlockPos(18.0, 68.0, -160.0));
        for (Player near_pl : this.field_70170_p.func_72872_a(Player.class, aabb)) {
            near_pl.func_70634_a(25.5, 61.2, -73.0);
            near_pl.func_145779_a(ItemInit.arenaCard, 1);
        }
        aabb = new AABB(new BlockPos(20.0, 59.0, -180.0), new BlockPos(38.0, 68.0, -160.0));
        for (Player near_pl : this.field_70170_p.func_72872_a(Player.class, aabb)) {
            near_pl.func_70634_a(25.5, 61.2, -73.0);
            near_pl.func_145779_a(ItemInit.arenaCard, 1);
        }
        aabb = new AABB(new BlockPos(40.0, 59.0, -180.0), new BlockPos(58.0, 68.0, -160.0));
        for (Player near_pl : this.field_70170_p.func_72872_a(Player.class, aabb)) {
            near_pl.func_70634_a(25.5, 61.2, -73.0);
            near_pl.func_145779_a(ItemInit.arenaCard, 1);
        }
        EntityInfinityStone stone = new EntityInfinityStone(this.field_70170_p);
        stone.setStoneNum((byte)3);
        stone.func_70107_b(25.5, 61.2, -73.0);
        this.field_70170_p.func_72838_d((Entity)stone);
    }

    @Override
    protected int numberOfLives() {
        return 10;
    }

    @Override
    public void trueDeathAction() {
        if (!this.field_70170_p.field_72995_K) {
            this.clearPlayersToStart();
        }
    }

    protected SoundEvent func_184615_bR() {
        return null;
    }

    protected SoundEvent func_184601_bQ(DamageSource damageSourceIn) {
        return SoundEvents.field_193787_df;
    }

    protected SoundEvent func_184639_G() {
        return null;
    }

    protected boolean func_70692_ba() {
        return false;
    }

    @Override
    public boolean func_70814_o() {
        return true;
    }

    public int func_70641_bl() {
        return 1;
    }

    @Override
    public boolean func_70601_bi() {
        return this.field_70170_p.func_175659_aa() != EnumDifficulty.PEACEFUL;
    }
}

