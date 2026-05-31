/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.PathfinderMob
 *  net.minecraft.entity.Mob
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.IMobData
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.ai.EntityAIBase
 *  net.minecraft.entity.ai.EntityAINearestAttackableTarget
 *  net.minecraft.entity.ai.EntityMoveHelper
 *  net.minecraft.entity.ai.EntityMoveHelper$Action
 *  net.minecraft.entity.player.Player
 *  net.minecraft.entity.player.ServerPlayer
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.datasync.DataParameter
 *  net.minecraft.network.datasync.DataSerializer
 *  net.minecraft.network.datasync.DataSerializers
 *  net.minecraft.network.datasync.EntityDataManager
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.EntitySelectors
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.util.math.Mth
 *  net.minecraft.util.math.Vec3
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraft.world.DifficultyInstance
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.sea.leviathan;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.entity.IMobData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityMoveHelper;
import net.minecraft.world.entity.player.Player;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializer;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.EntitySelectors;
import net.minecraft.sounds.SoundSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.level.Level;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.client.fx.ClientParticleRenderer;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.ai.EntityAIFloatAttack;
import xol.lostinfinity.mob.entity.base.EntityFloatingBase;
import xol.lostinfinity.mob.entity.classify.IKnockbackImmunity;
import xol.lostinfinity.mob.entity.classify.ILostMultiPart;
import xol.lostinfinity.mob.entity.sea.EntityEelShark;
import xol.lostinfinity.mob.entity.sea.EntitySeaCreature;
import xol.lostinfinity.mob.entity.sea.leviathan.EntityLeviathanHead;
import xol.lostinfinity.mob.entity.sea.leviathan.EntityLeviathanSegment;
import xol.lostinfinity.mob.entity.sea.leviathan.EntityLeviathanTail;
import xol.lostinfinity.projectile.entity.EntityLeviathanBreath;
import xol.lostinfinity.projectile.entity.EntityLeviathanTeslaOrb;
import xol.lostinfinity.projectile.entity.EntityLeviathanTracer;
import xol.lostinfinity.util.data.CustomDamageResult;
import xol.lostinfinity.util.data.CustomParticleConfig;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.fx.IParticleSpawner;
import xol.lostinfinity.util.math.LMath;

public class EntityLeviathanController
extends EntityFloatingBase
implements ILostMultiPart,
IKnockbackImmunity,
IMaxAttack {
    private static final DataParameter<Integer> LEVIATHAN_SIZE = EntityDataManager.func_187226_a(EntityLeviathanController.class, (DataSerializer)DataSerializers.field_187192_b);
    private static final DataParameter<Integer> LEVIATHAN_PHASE = EntityDataManager.func_187226_a(EntityLeviathanController.class, (DataSerializer)DataSerializers.field_187192_b);
    private static final DataParameter<Integer> LEVIATHAN_PHASE_DATA = EntityDataManager.func_187226_a(EntityLeviathanController.class, (DataSerializer)DataSerializers.field_187192_b);
    public final EntityLeviathanSegment[] segments = new EntityLeviathanSegment[20];
    private final LeviathanMoveHelper leviathanMoveHelper;
    protected Phase phase = Phase.CHARGE;
    protected int nextPhaseChange = 400;
    protected EntityLeviathanBreath breath;
    protected int attackCooldown = 0;
    protected int attackGracePeriod = 4;

    public EntityLeviathanController(Level worldIn) {
        super(worldIn);
        this.func_70105_a(0.25f, 0.25f);
        this.field_70145_X = true;
        this.rawFlySpeed = 0.9f;
        this.leviathanMoveHelper = (LeviathanMoveHelper)this.field_70765_h;
        EntityLeviathanSegment lastSegment = new EntityLeviathanHead(this);
        ((EntityLeviathanSegment)lastSegment).updatePosition();
        lastSegment.setId(0);
        this.segments[0] = lastSegment;
        for (int i = 1; i < this.segments.length - 1; ++i) {
            EntityLeviathanSegment segment = new EntityLeviathanSegment(this, lastSegment);
            segment.updatePosition();
            lastSegment = segment;
            segment.setId(i);
            this.segments[i] = segment;
        }
        EntityLeviathanTail tail = new EntityLeviathanTail(this, lastSegment);
        tail.updatePosition();
        tail.setId(this.segments.length - 1);
        this.segments[this.segments.length - 1] = tail;
    }

    @Nullable
    public IMobData func_180482_a(DifficultyInstance difficulty, @Nullable IMobData livingdata) {
        this.setLeviathanSize(5);
        this.setLeviathanPhase(Phase.CHARGE);
        return super.func_180482_a(difficulty, livingdata);
    }

    public void func_184206_a(DataParameter<?> key) {
        if (LEVIATHAN_SIZE.equals(key)) {
            int size = this.getLeviathanSize();
            for (EntityLeviathanSegment segment : this.segments) {
                segment.setSize(size);
            }
        }
        super.func_184206_a(key);
    }

    @Override
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a(LEVIATHAN_SIZE, (Object)1);
        this.field_70180_af.func_187214_a(LEVIATHAN_PHASE, (Object)0);
        this.field_70180_af.func_187214_a(LEVIATHAN_PHASE_DATA, (Object)0);
    }

    @Override
    public void func_70014_b(CompoundTag tag) {
        super.func_70014_b(tag);
        tag.func_74768_a("LeviathanSize", this.getLeviathanSize());
        tag.func_74768_a("LeviathanPhase", this.getLeviathanPhase().ordinal());
        tag.func_74768_a("LeviathanPhaseData", this.getLeviathanPhaseData());
    }

    @Override
    public void func_70037_a(CompoundTag tag) {
        super.func_70037_a(tag);
        this.setLeviathanSize(tag.func_74762_e("LeviathanSize"));
        this.setLeviathanPhase(Phase.values()[tag.func_74762_e("LeviathanPhase")]);
        this.setLeviathanPhaseData(tag.func_74762_e("LeviathanPhaseData"));
    }

    public void setLeviathanSize(int size) {
        this.field_70180_af.func_187227_b(LEVIATHAN_SIZE, (Object)size);
        for (EntityLeviathanSegment segment : this.segments) {
            segment.setSize(size);
        }
    }

    public int getLeviathanSize() {
        return (Integer)this.field_70180_af.func_187225_a(LEVIATHAN_SIZE);
    }

    public void setLeviathanPhase(Phase phase) {
        this.phase = phase;
        this.breath = null;
        switch (phase) {
            case CHARGE: {
                this.nextPhaseChange = this.field_70173_aa + 400;
                break;
            }
            case VOLLEY: {
                this.nextPhaseChange = this.field_70173_aa + 200;
                break;
            }
            case TESLA: {
                this.nextPhaseChange = this.field_70173_aa + 100;
                break;
            }
            case BEAM: {
                this.nextPhaseChange = this.field_70173_aa + 600;
            }
        }
        this.field_70180_af.func_187227_b(LEVIATHAN_PHASE, (Object)phase.ordinal());
    }

    public Phase getLeviathanPhase() {
        return Phase.values()[(Integer)this.field_70180_af.func_187225_a(LEVIATHAN_PHASE)];
    }

    public void setLeviathanPhaseData(int data) {
        this.field_70180_af.func_187227_b(LEVIATHAN_PHASE_DATA, (Object)data);
    }

    public int getLeviathanPhaseData() {
        return (Integer)this.field_70180_af.func_187225_a(LEVIATHAN_PHASE_DATA);
    }

    @Override
    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(1.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.32);
        this.func_110148_a(SharedMonsterAttributes.field_111266_c).func_111128_a(1.0);
        this.func_110148_a(SharedMonsterAttributes.field_111265_b).func_111128_a(256.0);
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(5000.0);
    }

    @Override
    protected void func_184651_r() {
        super.func_184651_r();
        this.field_70715_bh.func_75776_a(2, (EntityAIBase)new EntityAINearestAttackableTarget((PathfinderMob)this, EntityEelShark.class, 5, false, false, null));
        this.field_70715_bh.func_75776_a(3, (EntityAIBase)new EntityAINearestAttackableTarget((PathfinderMob)this, EntitySeaCreature.class, 5, false, false, null));
    }

    @Override
    public void func_70636_d() {
        super.func_70636_d();
        if (this.field_70170_p.field_72995_K) {
            int id;
            boolean isTeslaPhase = this.getLeviathanPhase() == Phase.TESLA;
            int n = id = isTeslaPhase ? this.field_70173_aa % this.segments.length : this.field_70173_aa / 3 % (this.segments.length * 5);
            if (id < this.segments.length) {
                EntityLeviathanSegment segment = this.segments[id];
                Vec3 loc = LMath.getEntityMiddle((Entity)segment);
                CustomParticleConfig config = isTeslaPhase ? EntityLeviathanController.createBlueShock(segment.field_70130_N, segment.field_70131_O, segment.field_70130_N) : EntityLeviathanController.createYellowShock(segment.field_70130_N / 2.0f, segment.field_70131_O / 2.0f, segment.field_70130_N / 2.0f);
                config.setCount(4);
                config.setOrigin(loc);
                ClientParticleRenderer.renderComplex(config);
            }
            return;
        }
        --this.attackCooldown;
        LivingEntity target = this.func_70638_az();
        if (target != null) {
            if (this.field_70173_aa > this.nextPhaseChange) {
                this.setLeviathanPhase(Phase.randomPhase(this.field_70170_p, this.phase));
            }
            boolean shouldLookAtTarget = false;
            switch (this.phase) {
                case CHARGE: {
                    if (target.func_110143_aJ() <= 0.0f) {
                        this.setLeviathanPhaseData(0);
                    }
                    if (this.field_70173_aa % 4 == 0) {
                        int phaseData = 0;
                        Vec3 selfLoc = this.func_174791_d();
                        double distSqr = LMath.getDistanceSquaredToAABB(selfLoc, target.func_174813_aQ());
                        if (distSqr <= 100.0 && distSqr > 1.0) {
                            this.leviathanMoveHelper.setCorrectionRate(0.8);
                            this.leviathanMoveHelper.setCourseChangeChance(1);
                            if (target.func_110143_aJ() > 0.0f) {
                                phaseData = 1;
                            }
                        } else {
                            this.leviathanMoveHelper.setCorrectionRate(0.1);
                            this.leviathanMoveHelper.setCourseChangeChance(5);
                        }
                        this.leviathanMoveHelper.func_75642_a(target.field_70165_t, target.field_70163_u + (double)(target.field_70131_O / 2.0f), target.field_70161_v, 1.0);
                        this.setLeviathanPhaseData(phaseData);
                    }
                    this.rawFlySpeed = 1.0f;
                    break;
                }
                case VOLLEY: {
                    if (this.field_70173_aa % 4 == 0) {
                        EntityLeviathanSegment segment = this.segments[this.field_70170_p.field_73012_v.nextInt(this.segments.length - 2) + 1];
                        EntityLeviathanTracer tracer = new EntityLeviathanTracer(this.field_70170_p, segment.field_70165_t, segment.field_70163_u + (double)(segment.field_70131_O / 2.0f), segment.field_70161_v, (Entity)target);
                        tracer.setLeviathanThrower(this);
                        Vec3 motion = LMath.fastNormalize(new Vec3(this.field_70170_p.field_73012_v.nextDouble() - 0.5, this.field_70170_p.field_73012_v.nextDouble() - 0.5, this.field_70170_p.field_73012_v.nextDouble() - 0.5));
                        tracer.field_70159_w = motion.field_72450_a;
                        tracer.field_70181_x = motion.field_72448_b;
                        tracer.field_70179_y = motion.field_72449_c;
                        this.field_70170_p.func_72838_d((Entity)tracer);
                        this.field_70170_p.func_184133_a(null, tracer.func_180425_c(), SoundInit.ELECTRIC_WOOSH, SoundSource.HOSTILE, 8.0f, 0.5f + this.field_70170_p.field_73012_v.nextFloat() * 0.25f);
                        IParticleSpawner.spawnParticle(this.field_70170_p, EntityLeviathanController.createBlueShock(0.0, 0.0, 0.0), tracer.field_70165_t + motion.field_72450_a * 3.0, tracer.field_70163_u + motion.field_72448_b * 3.0, tracer.field_70161_v + motion.field_72449_c * 3.0);
                    }
                    this.rawFlySpeed = 0.5f;
                    shouldLookAtTarget = true;
                    break;
                }
                case TESLA: {
                    if (this.field_70173_aa % 20 == 0) {
                        EntityLeviathanTeslaOrb teslaOrb = new EntityLeviathanTeslaOrb(this.field_70170_p, this.field_70165_t, this.field_70163_u + (double)(this.field_70131_O / 2.0f), this.field_70161_v);
                        teslaOrb.setLeviathanThrower(this);
                        Vec3 motion = this.segments[0].func_70040_Z().func_186678_a(0.5);
                        teslaOrb.field_70159_w = motion.field_72450_a;
                        teslaOrb.field_70181_x = motion.field_72448_b;
                        teslaOrb.field_70179_y = motion.field_72449_c;
                        this.field_70170_p.func_72838_d((Entity)teslaOrb);
                    }
                    this.rawFlySpeed = 0.5f;
                    shouldLookAtTarget = true;
                    break;
                }
                case BEAM: {
                    int tick = 600 - (this.nextPhaseChange - this.field_70173_aa);
                    if (tick >= 0 && tick < 200) {
                        if (tick % 2 == 0) {
                            double ratio = Mth.func_76131_a((float)((float)tick / 180.0f), (float)0.0f, (float)1.0f);
                            int range = (int)((double)(this.segments.length - 2) * (1.0 - ratio));
                            int size = this.getLeviathanSize();
                            CustomParticleConfig config = EntityLeviathanController.createYellowShock(size, size, size);
                            config.setCount(2);
                            for (int i = this.segments.length - 2; i > range; --i) {
                                EntityLeviathanSegment segment = this.segments[i];
                                Vec3 loc = LMath.getEntityMiddle((Entity)segment);
                                IParticleSpawner.spawnParticle(this.field_70170_p, config, loc);
                            }
                        }
                        if (tick % 20 == 0) {
                            this.field_70170_p.func_184133_a(null, this.func_180425_c(), SoundInit.GENERIC_WEAPON_12, SoundSource.HOSTILE, this.func_70599_aP(), 1.0f);
                        }
                        this.rawFlySpeed = 0.5f;
                        shouldLookAtTarget = true;
                        break;
                    }
                    if (this.breath == null) {
                        this.breath = new EntityLeviathanBreath(this.field_70170_p);
                        this.breath.setOwner(this);
                        EntityLeviathanSegment seg = this.segments[0];
                        this.breath.func_70107_b(seg.field_70165_t, seg.field_70163_u + (double)(seg.field_70131_O / 2.0f), seg.field_70161_v);
                        this.field_70170_p.func_72838_d((Entity)this.breath);
                    }
                    if (!this.breath.field_70128_L) {
                        this.rawFlySpeed = 0.5f;
                        shouldLookAtTarget = true;
                        this.setLeviathanPhaseData(1);
                        if (tick % 2 != 0) break;
                        int size = this.getLeviathanSize();
                        CustomParticleConfig config = EntityLeviathanController.createYellowShock(size, size, size);
                        config.setCount(2);
                        for (int i = 1; i < this.segments.length - 1; ++i) {
                            EntityLeviathanSegment segment = this.segments[i];
                            Vec3 loc = LMath.getEntityMiddle((Entity)segment);
                            IParticleSpawner.spawnParticle(this.field_70170_p, config, loc);
                        }
                        break;
                    }
                    this.rawFlySpeed = 0.9f;
                    this.setLeviathanPhaseData(0);
                    break;
                }
            }
            if (shouldLookAtTarget) {
                EntityLeviathanSegment segment = this.segments[0];
                Vec3 dir = LMath.fastNormalize(target.func_174791_d().func_178788_d(this.func_174791_d()));
                double hMagnitude = LMath.fastSqrt(dir.field_72450_a * dir.field_72450_a + dir.field_72449_c * dir.field_72449_c);
                float pitch = (float)Mth.func_181159_b((double)(-dir.field_72448_b), (double)hMagnitude) * 57.29578f;
                float yaw = (float)Mth.func_181159_b((double)(-dir.field_72450_a), (double)dir.field_72449_c) * 57.29578f;
                if (Math.abs(pitch - segment.field_70125_A) > 5.0f || Math.abs(yaw - segment.field_70177_z) > 5.0f) {
                    this.leviathanMoveHelper.field_188491_h = EntityMoveHelper.Action.WAIT;
                    this.field_70159_w = dir.field_72450_a * 0.2;
                    this.field_70181_x = dir.field_72448_b * 0.2;
                    this.field_70179_y = dir.field_72449_c * 0.2;
                    this.field_70133_I = true;
                }
            }
        } else {
            if (this.phase != Phase.BEAM || this.breath == null || this.breath.field_70128_L) {
                this.setLeviathanPhaseData(0);
            }
            this.leviathanMoveHelper.setCorrectionRate(0.1);
            this.leviathanMoveHelper.setCourseChangeChance(5);
            this.rawFlySpeed = 0.9f;
        }
    }

    @Override
    protected int numberOfLives() {
        return 200;
    }

    protected void func_85033_bc() {
        if (this.attackCooldown > 0) {
            return;
        }
        this.attackCooldown = this.attackGracePeriod;
        HashSet targets = new HashSet();
        for (EntityLeviathanSegment segment : this.segments) {
            List segList = this.field_70170_p.func_175674_a((Entity)segment, segment.func_174813_aQ(), input -> {
                if (input == this || targets.contains(input) || !EntitySelectors.func_188442_a((Entity)segment).apply(input)) {
                    return false;
                }
                return !(input instanceof EntityLeviathanSegment) && !(input instanceof EntityLeviathanController);
            });
            targets.addAll(segList);
        }
        if (targets.isEmpty()) {
            return;
        }
        for (Entity entity : targets) {
            this.func_82167_n(entity);
        }
    }

    @Override
    @Nullable
    protected EntityAIFloatAttack createShootAI() {
        return null;
    }

    @Override
    protected void func_82167_n(Entity entityIn) {
        this.func_70652_k(entityIn);
    }

    @Override
    protected EntityMoveHelper createMoveHelper() {
        return new LeviathanMoveHelper(this);
    }

    public void func_70106_y() {
        super.func_70106_y();
        for (EntityLeviathanSegment segment : this.segments) {
            this.field_70170_p.func_72973_f((Entity)segment);
        }
    }

    @Nullable
    public Entity[] func_70021_al() {
        return this.segments;
    }

    public void func_70071_h_() {
        super.func_70071_h_();
        for (EntityLeviathanSegment segment : this.segments) {
            this.field_70170_p.func_72866_a((Entity)segment, true);
            segment.updatePosition();
        }
    }

    public boolean func_70072_I() {
        return false;
    }

    public boolean func_180799_ab() {
        return false;
    }

    @Nullable
    protected SoundEvent func_184639_G() {
        return SoundInit.LEVIATHAN_AMBIENT;
    }

    protected SoundEvent func_184601_bQ(DamageSource damageSourceIn) {
        return SoundInit.LEVIATHAN_HURT;
    }

    protected SoundEvent func_184615_bR() {
        return SoundInit.LEVIATHAN_DEATH;
    }

    protected float func_70599_aP() {
        return 8.0f;
    }

    public boolean func_70652_k(Entity entityIn) {
        super.func_70652_k(entityIn);
        if (!(entityIn instanceof LivingEntity)) {
            return false;
        }
        if (entityIn instanceof Player && ((Player)entityIn).func_184812_l_()) {
            return false;
        }
        LivingEntity target = (LivingEntity)entityIn;
        if (target instanceof EntitySeaCreature) {
            EntitySeaCreature seaCreature = (EntitySeaCreature)target;
            seaCreature.takeawayNumLives(seaCreature.remainingLives() + 1);
        } else {
            IMaxAttack.dealTrueDamage((Entity)this, target, target.func_110138_aP() * 0.5f, Collections.singletonList("Aquatic"));
        }
        return true;
    }

    protected boolean func_70692_ba() {
        return false;
    }

    public Level func_82194_d() {
        return this.field_70170_p;
    }

    @Override
    public boolean attackEntityFromPart(LivingEntity part, DamageSource source, float damage) {
        return this.func_70097_a(source, damage);
    }

    @Override
    public float getKnockbackResistance(CustomDamageResult damageResult) {
        return 1.0f;
    }

    private static CustomParticleConfig createYellowShock(double spreadX, double spreadY, double spreadZ) {
        CustomParticleConfig config = new CustomParticleConfig();
        config.createInstance().setParticle(ParticleInit.TESLA_RING_YELLOW).setSpread(spreadX, spreadY, spreadZ).setIgnoreRange(true);
        return config;
    }

    private static CustomParticleConfig createBlueShock(double spreadX, double spreadY, double spreadZ) {
        CustomParticleConfig config = new CustomParticleConfig();
        config.createInstance().setParticle(ParticleInit.TESLA_RING_BLUE).setSpread(spreadX, spreadY, spreadZ).setIgnoreRange(true);
        return config;
    }

    @Override
    public void trueDeathAction() {
        if (!this.field_70170_p.field_72995_K) {
            this.func_145779_a(ItemInit.giantHeart, 1);
        }
    }

    @Override
    protected void updateLifeAction() {
        int lifePercent = Math.round(100 * (this.numberOfLives() - this.getLivesCount()) / this.numberOfLives());
        for (ServerPlayer playerMP : this.field_70170_p.func_73046_m().func_184103_al().func_181057_v()) {
            if (!(this.func_70032_d((Entity)playerMP) < 150.0f)) continue;
            playerMP.func_145747_a((Component)new Component((Object)((Object)TextFmt.Gold) + "The Leviathan is at " + lifePercent + "% health."));
        }
    }

    private static class LeviathanMoveHelper
    extends EntityMoveHelper {
        private final EntityLeviathanController parentEntity;
        private int courseChangeCooldown;
        private int courseChangeChance = 5;
        private double correctionRate = 0.1;

        public LeviathanMoveHelper(EntityLeviathanController leviathan) {
            super((Mob)leviathan);
            this.parentEntity = leviathan;
        }

        public void func_75642_a(double x, double y, double z, double speedIn) {
            y = this.parentEntity.func_70638_az() == null ? Mth.func_151237_a((double)y, (double)30.0, (double)220.0) : y;
            super.func_75642_a(x, y, z, speedIn);
        }

        public void func_75641_c() {
            if (this.field_188491_h == EntityMoveHelper.Action.MOVE_TO) {
                double dX = this.field_75646_b - this.parentEntity.field_70165_t;
                double dY = this.field_75647_c - this.parentEntity.field_70163_u;
                double dZ = this.field_75644_d - this.parentEntity.field_70161_v;
                double invMag = Mth.func_181161_i((double)(dX * dX + dY * dY + dZ * dZ));
                if (this.courseChangeCooldown-- <= 0) {
                    this.courseChangeCooldown += this.parentEntity.func_70681_au().nextInt(this.courseChangeChance) + 2;
                    this.parentEntity.field_70159_w *= 1.0 - this.correctionRate;
                    this.parentEntity.field_70181_x *= 1.0 - this.correctionRate;
                    this.parentEntity.field_70179_y *= 1.0 - this.correctionRate;
                    this.parentEntity.field_70159_w += dX * invMag * this.correctionRate;
                    this.parentEntity.field_70181_x += dY * invMag * this.correctionRate;
                    this.parentEntity.field_70179_y += dZ * invMag * this.correctionRate;
                }
            }
        }

        public void setCourseChangeChance(int chance) {
            this.courseChangeChance = chance;
        }

        public void setCorrectionRate(double rate) {
            this.correctionRate = rate;
        }
    }

    public static enum Phase {
        CHARGE,
        VOLLEY,
        TESLA,
        BEAM;


        public static Phase randomPhase(Level world, Phase exclude) {
            int nextPhase = world.field_73012_v.nextInt(3);
            if (nextPhase == exclude.ordinal()) {
                ++nextPhase;
            }
            return Phase.values()[nextPhase];
        }
    }
}

