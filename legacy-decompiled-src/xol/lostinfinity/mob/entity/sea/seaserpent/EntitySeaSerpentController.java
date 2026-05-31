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
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.datasync.DataParameter
 *  net.minecraft.network.datasync.DataSerializer
 *  net.minecraft.network.datasync.DataSerializers
 *  net.minecraft.network.datasync.EntityDataManager
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.EntitySelectors
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.util.math.Mth
 *  net.minecraft.util.math.Vec3
 *  net.minecraft.world.DifficultyInstance
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.sea.seaserpent;

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
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializer;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.EntitySelectors;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.ai.EntityAIFloatAttack;
import xol.lostinfinity.mob.entity.base.EntityFloatingBase;
import xol.lostinfinity.mob.entity.classify.IKnockbackImmunity;
import xol.lostinfinity.mob.entity.classify.ILostMultiPart;
import xol.lostinfinity.mob.entity.sea.EntityFish;
import xol.lostinfinity.mob.entity.sea.EntitySeaCreature;
import xol.lostinfinity.mob.entity.sea.seaserpent.EntitySeaSerpentHead;
import xol.lostinfinity.mob.entity.sea.seaserpent.EntitySeaSerpentSegment;
import xol.lostinfinity.mob.entity.sea.seaserpent.EntitySeaSerpentTail;
import xol.lostinfinity.util.data.CustomDamageResult;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.load.LootTableRegistry;
import xol.lostinfinity.util.math.LMath;

public class EntitySeaSerpentController
extends EntityFloatingBase
implements ILostMultiPart,
IKnockbackImmunity,
IMaxAttack {
    private static final DataParameter<Integer> SIZE = EntityDataManager.func_187226_a(EntitySeaSerpentController.class, (DataSerializer)DataSerializers.field_187192_b);
    private static final DataParameter<Integer> ANIMATION_DATA = EntityDataManager.func_187226_a(EntitySeaSerpentController.class, (DataSerializer)DataSerializers.field_187192_b);
    public final EntitySeaSerpentSegment[] segments = new EntitySeaSerpentSegment[7];
    private final SeaSerpentMoveHelper serpentMoveHelper;
    protected int attackCooldown = 0;
    protected int attackGracePeriod = 15;

    public EntitySeaSerpentController(Level worldIn) {
        super(worldIn);
        this.func_70105_a(0.0f, 0.0f);
        this.field_70145_X = true;
        this.rawFlySpeed = 0.9f;
        this.serpentMoveHelper = (SeaSerpentMoveHelper)this.field_70765_h;
        EntitySeaSerpentSegment lastSegment = new EntitySeaSerpentHead(this);
        ((EntitySeaSerpentSegment)lastSegment).updatePosition();
        lastSegment.setId(0);
        this.segments[0] = lastSegment;
        for (int i = 1; i < this.segments.length - 1; ++i) {
            EntitySeaSerpentSegment segment = new EntitySeaSerpentSegment(this, lastSegment);
            segment.updatePosition();
            lastSegment = segment;
            segment.setId(i);
            this.segments[i] = segment;
        }
        EntitySeaSerpentTail tail = new EntitySeaSerpentTail(this, lastSegment);
        tail.updatePosition();
        tail.setId(this.segments.length - 1);
        this.segments[this.segments.length - 1] = tail;
    }

    @Nullable
    public IMobData func_180482_a(DifficultyInstance difficulty, @Nullable IMobData livingdata) {
        this.setSize(2);
        return super.func_180482_a(difficulty, livingdata);
    }

    public void func_184206_a(DataParameter<?> key) {
        if (SIZE.equals(key)) {
            int size = this.getSize();
            for (EntitySeaSerpentSegment segment : this.segments) {
                segment.setSize(size);
            }
        }
        super.func_184206_a(key);
    }

    @Override
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a(SIZE, (Object)1);
        this.field_70180_af.func_187214_a(ANIMATION_DATA, (Object)0);
    }

    @Override
    public void func_70014_b(CompoundTag tag) {
        super.func_70014_b(tag);
        tag.func_74768_a("Size", this.getSize());
        tag.func_74768_a("AnimationData", this.getAnimation());
    }

    @Override
    public void func_70037_a(CompoundTag tag) {
        super.func_70037_a(tag);
        this.setSize(tag.func_74762_e("Size"));
        this.setAnimation(tag.func_74762_e("AnimationData"));
    }

    public void setSize(int size) {
        this.field_70180_af.func_187227_b(SIZE, (Object)size);
        for (EntitySeaSerpentSegment segment : this.segments) {
            segment.setSize(size);
        }
    }

    public int getSize() {
        return (Integer)this.field_70180_af.func_187225_a(SIZE);
    }

    public void setAnimation(int data) {
        this.field_70180_af.func_187227_b(ANIMATION_DATA, (Object)data);
    }

    public int getAnimation() {
        return (Integer)this.field_70180_af.func_187225_a(ANIMATION_DATA);
    }

    @Override
    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(1.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.32);
        this.func_110148_a(SharedMonsterAttributes.field_111266_c).func_111128_a(1.0);
        this.func_110148_a(SharedMonsterAttributes.field_111265_b).func_111128_a(128.0);
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(5000.0);
    }

    @Override
    protected void func_184651_r() {
        super.func_184651_r();
        this.field_70715_bh.func_75776_a(2, (EntityAIBase)new EntityAINearestAttackableTarget((PathfinderMob)this, EntityFish.class, false));
    }

    @Override
    public void func_70636_d() {
        super.func_70636_d();
        if (this.field_70170_p.field_72995_K) {
            return;
        }
        --this.attackCooldown;
        LivingEntity target = this.func_70638_az();
        if (target != null) {
            if (target.func_110143_aJ() <= 0.0f) {
                this.setAnimation(0);
            }
            if (this.field_70173_aa % 4 == 0) {
                int phaseData = 0;
                Vec3 selfLoc = this.func_174791_d();
                double distSqr = LMath.getDistanceSquaredToAABB(selfLoc, target.func_174813_aQ());
                if (distSqr <= 25.0) {
                    this.serpentMoveHelper.setCorrectionRate(0.8);
                    this.serpentMoveHelper.setCourseChangeChance(1);
                    if (target.func_110143_aJ() > 0.0f) {
                        phaseData = 1;
                    }
                } else {
                    this.serpentMoveHelper.setCorrectionRate(0.1);
                    this.serpentMoveHelper.setCourseChangeChance(5);
                }
                this.serpentMoveHelper.func_75642_a(target.field_70165_t, target.field_70163_u + (double)(target.field_70131_O / 2.0f), target.field_70161_v, 1.0);
                this.setAnimation(phaseData);
            }
        } else {
            this.setAnimation(0);
            this.serpentMoveHelper.setCorrectionRate(0.1);
            this.serpentMoveHelper.setCourseChangeChance(5);
        }
    }

    @Override
    protected int numberOfLives() {
        return 20;
    }

    protected ResourceLocation func_184647_J() {
        return LootTableRegistry.ENTITIES_SEASERPENT;
    }

    protected void func_85033_bc() {
        if (this.attackCooldown > 0) {
            return;
        }
        this.attackCooldown = this.attackGracePeriod;
        HashSet targets = new HashSet();
        for (EntitySeaSerpentSegment segment : this.segments) {
            List segList = this.field_70170_p.func_175674_a((Entity)segment, segment.func_174813_aQ(), input -> {
                if (input == this || targets.contains(input) || !EntitySelectors.func_188442_a((Entity)segment).apply(input)) {
                    return false;
                }
                return !(input instanceof EntitySeaSerpentSegment) && !(input instanceof EntitySeaSerpentController);
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
        return new SeaSerpentMoveHelper(this);
    }

    public void func_70106_y() {
        super.func_70106_y();
        for (EntitySeaSerpentSegment segment : this.segments) {
            this.field_70170_p.func_72973_f((Entity)segment);
        }
    }

    @Nullable
    public Entity[] func_70021_al() {
        return this.segments;
    }

    public void func_70071_h_() {
        super.func_70071_h_();
        for (EntitySeaSerpentSegment segment : this.segments) {
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
        return 2.0f;
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
            IMaxAttack.dealMaxHealth((Entity)this, target, 1, Collections.singletonList("Aquatic"));
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

    @Override
    public boolean func_70601_bi() {
        return super.func_70601_bi() && this.nothingInRadius(35);
    }

    private static class SeaSerpentMoveHelper
    extends EntityMoveHelper {
        private final EntitySeaSerpentController parentEntity;
        private int courseChangeCooldown;
        private int courseChangeChance = 5;
        private double correctionRate = 0.1;

        public SeaSerpentMoveHelper(EntitySeaSerpentController leviathan) {
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
}

