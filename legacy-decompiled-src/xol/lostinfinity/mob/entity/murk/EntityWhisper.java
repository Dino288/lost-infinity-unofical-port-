/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.network.datasync.DataParameter
 *  net.minecraft.network.datasync.DataSerializer
 *  net.minecraft.network.datasync.DataSerializers
 *  net.minecraft.network.datasync.EntityDataManager
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.math.Vec3
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.murk;

import java.util.Arrays;
import java.util.List;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializer;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.ai.IBasicAI;
import xol.lostinfinity.mob.entity.base.EntityMultipleLives;
import xol.lostinfinity.mob.entity.murk.EntityScreamer;
import xol.lostinfinity.util.data.IMaxAttack;

public class EntityWhisper
extends EntityMultipleLives
implements IMaxAttack,
IBasicAI {
    private LivingEntity followingTarget = null;
    private static final DataParameter<Boolean> SACRIFICED = EntityDataManager.func_187226_a(EntityWhisper.class, (DataSerializer)DataSerializers.field_187198_h);
    private static final DataParameter<Boolean> RITUAL_LEADER = EntityDataManager.func_187226_a(EntityWhisper.class, (DataSerializer)DataSerializers.field_187198_h);
    private int timer = 200;
    private float pitch = 0.0f;

    public EntityWhisper(Level worldIn) {
        super(worldIn);
        this.func_70105_a(4.0f, 5.0f);
    }

    @Override
    protected void func_70088_a() {
        super.func_70088_a();
        this.func_184212_Q().func_187214_a(SACRIFICED, (Object)false);
        this.func_184212_Q().func_187214_a(RITUAL_LEADER, (Object)false);
    }

    public boolean func_70652_k(Entity entity) {
        if (this.func_70638_az() != null) {
            if (this.followingTarget != null) {
                if (this.func_70638_az().equals((Object)this.followingTarget)) {
                    this.func_70624_b(null);
                    return false;
                }
            } else {
                IMaxAttack.dealMaxHealth((Entity)this, this.func_70638_az(), 2, Arrays.asList("Darkborn"));
                return true;
            }
        }
        return false;
    }

    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(3000.0);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(1.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.35);
        this.func_110148_a(SharedMonsterAttributes.field_111266_c).func_111128_a(1.0);
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

    @Override
    public boolean func_70601_bi() {
        return super.func_70601_bi() && this.nothingInRadius(45);
    }

    @Override
    protected int numberOfLives() {
        return 15;
    }

    public boolean isSacrificed() {
        return (Boolean)this.field_70180_af.func_187225_a(SACRIFICED);
    }

    public void setSacrificed(boolean sacrificed) {
        this.field_70180_af.func_187227_b(SACRIFICED, (Object)sacrificed);
        this.followingTarget = null;
    }

    public boolean isLeader() {
        return (Boolean)this.field_70180_af.func_187225_a(RITUAL_LEADER);
    }

    public void setLeader(boolean leader) {
        this.field_70180_af.func_187227_b(RITUAL_LEADER, (Object)leader);
    }

    public void setFollowingTarget(LivingEntity t) {
        this.followingTarget = t;
    }

    public void func_70636_d() {
        super.func_70636_d();
        if (!this.field_70170_p.field_72995_K) {
            if (this.isLeader()) {
                if (this.timer == 0) {
                    List sacrifices = this.field_70170_p.func_72872_a(EntityWhisper.class, new AABB(this.func_180425_c()).func_186662_g(50.0));
                    for (EntityWhisper sacrifice : sacrifices) {
                        if (sacrifice.func_110124_au().equals(this.func_110124_au())) continue;
                        sacrifice.func_70106_y();
                    }
                    EntityScreamer screamer = new EntityScreamer(this.field_70170_p);
                    screamer.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
                    screamer.setInOcean(false);
                    this.field_70170_p.func_72838_d((Entity)screamer);
                    this.func_70106_y();
                } else {
                    --this.timer;
                    if (this.field_70173_aa % 10 == 0) {
                        this.pitch += 0.1f;
                        this.field_70170_p.func_184133_a(null, this.func_180425_c(), SoundInit.BIOENERGIZE, SoundSource.HOSTILE, 1.0f, this.pitch);
                    }
                }
            }
            if (this.followingTarget != null) {
                this.func_70624_b(null);
                this.func_70671_ap().func_75650_a(this.followingTarget.field_70165_t, this.followingTarget.field_70163_u + 2.0, this.followingTarget.field_70161_v, 10.0f, 10.0f);
                if (this.followingTarget.field_70128_L) {
                    this.followingTarget = null;
                    return;
                }
                if (this.func_70068_e((Entity)this.followingTarget) > 1750.0) {
                    this.followingTarget = null;
                    return;
                }
                if (this.followingTarget.field_70163_u > this.field_70163_u && (this.field_70159_w == 0.0 || this.field_70179_y == 0.0) && !this.isSacrificed()) {
                    this.field_70181_x = 0.5;
                }
                if (!this.isSacrificed()) {
                    this.func_70605_aq().func_75642_a(this.followingTarget.field_70165_t, this.followingTarget.field_70163_u, this.followingTarget.field_70161_v, 0.75);
                } else {
                    this.func_70605_aq().func_75642_a(this.followingTarget.field_70165_t, this.followingTarget.field_70163_u, this.followingTarget.field_70161_v, 0.5);
                }
            }
            if (this.isSacrificed() && this.field_70146_Z.nextInt(15) == 0) {
                this.field_70170_p.func_184133_a(null, this.func_180425_c(), this.randomWhisper(this.field_70146_Z.nextInt(5)), SoundSource.PLAYERS, 1.25f, 0.7f + this.field_70146_Z.nextFloat() * 0.6f);
            }
        } else if (this.isLeader() && this.field_70173_aa % 4 == 0) {
            List sacrifices = this.field_70170_p.func_72872_a(EntityWhisper.class, new AABB(this.func_180425_c()).func_186662_g(50.0));
            for (EntityWhisper sacrifice : sacrifices) {
                if (sacrifice.func_110124_au().equals(this.func_110124_au())) continue;
                Vec3 dir = sacrifice.func_174791_d().func_178788_d(this.func_174791_d());
                dir = dir.func_72432_b();
                double dist = sacrifice.func_70011_f(this.field_70165_t, this.field_70163_u, this.field_70161_v);
                for (double i = 0.0; i < dist; i += 0.9) {
                    if (!this.field_70146_Z.nextBoolean()) continue;
                    this.field_70170_p.func_175688_a(ParticleInit.GENERIC_DOT_PURPLE, this.field_70165_t + dir.field_72450_a * i, this.field_70163_u + dir.field_72448_b * i + (double)this.field_70131_O / 1.8, this.field_70161_v + dir.field_72449_c * i, 0.0, 0.0, 0.0, new int[0]);
                }
            }
        }
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

