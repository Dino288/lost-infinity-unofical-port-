/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.datasync.DataParameter
 *  net.minecraft.network.datasync.DataSerializer
 *  net.minecraft.network.datasync.DataSerializers
 *  net.minecraft.network.datasync.EntityDataManager
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.EnumParticleTypes
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.Mth
 *  net.minecraft.util.math.Vec3
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.minion;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializer;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.item.weapon.ItemLostBladesOfInfinity;
import xol.lostinfinity.mob.entity.base.EntityImmaterial;
import xol.lostinfinity.mob.entity.minion.EntityMinion;
import xol.lostinfinity.util.data.CustomDamageResult;
import xol.lostinfinity.util.data.CustomParticleConfig;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.fx.IParticleSpawner;
import xol.lostinfinity.util.math.LMath;

public class EntityLostBlade
extends EntityMinion {
    private static final DataParameter<Integer> POSE = EntityDataManager.func_187226_a(EntityLostBlade.class, (DataSerializer)DataSerializers.field_187192_b);
    private static final double VELOCITY = 2.0;
    private static final double ATTACK_COOLDOWN = 400.0;
    private final Map<Entity, Long> attackCooldown = new ConcurrentHashMap<Entity, Long>();
    private LivingEntity target;

    public EntityLostBlade(Level worldIn) {
        super(worldIn);
        this.func_70105_a(0.5f, 0.5f);
    }

    @Override
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a(POSE, (Object)-1);
    }

    public void setTarget(LivingEntity livingBase) {
        this.target = livingBase;
    }

    public void setPose(int pose) {
        this.field_70180_af.func_187227_b(POSE, (Object)pose);
        this.setLocation();
    }

    public int getPose() {
        return (Integer)this.field_70180_af.func_187225_a(POSE);
    }

    @Override
    public void livingUpdate() {
        block19: {
            block17: {
                int randomTick;
                block18: {
                    Player owner = this.getOwner();
                    if (owner == null || owner.field_70128_L) {
                        this.func_70106_y();
                        return;
                    }
                    if (this.field_70170_p.field_72995_K) break block17;
                    ItemLostBladesOfInfinity.BladeMode bladeMode = this.getMode(this.trackedItemStack);
                    if (bladeMode == ItemLostBladesOfInfinity.BladeMode.STANDBY) {
                        this.setActive(false);
                        this.target = null;
                        this.setLocation();
                        return;
                    }
                    if (this.target != null) {
                        if (this.target.field_70128_L || this.target.func_110143_aJ() <= 0.0f) {
                            this.target = null;
                        } else {
                            double dist = this.target.func_174791_d().func_178788_d(owner.func_174791_d()).func_189985_c();
                            if (dist > 1000.0) {
                                this.target = null;
                            }
                        }
                    }
                    if ((randomTick = this.field_70173_aa + this.getPose()) % 20 == 0) {
                        switch (bladeMode) {
                            case GENOCIDE: {
                                this.findClosestTarget();
                                break;
                            }
                            case TARGET: {
                                this.target = owner.func_110144_aD();
                            }
                        }
                    }
                    if (randomTick % 6 != 0) break block18;
                    if (this.target != null) {
                        Vec3 targetVec = new Vec3(this.target.field_70165_t, this.target.field_70163_u + (double)(this.target.field_70131_O * this.field_70146_Z.nextFloat()), this.target.field_70161_v);
                        Vec3 motion = LMath.fastNormalize(targetVec.func_178788_d(this.func_174791_d())).func_186678_a(2.0);
                        this.field_70159_w = motion.field_72450_a;
                        this.field_70181_x = motion.field_72448_b;
                        this.field_70179_y = motion.field_72449_c;
                        this.field_70133_I = true;
                        this.setActive(true);
                    } else {
                        this.setActive(false);
                    }
                    break block19;
                }
                if (randomTick % 6 != 3 || this.target == null) break block19;
                Vec3 motion = LMath.fastNormalize(new Vec3(this.field_70159_w + this.getRandomDouble(3.0), this.field_70181_x, this.field_70179_y + this.getRandomDouble(3.0))).func_186678_a(2.0);
                this.field_70159_w = motion.field_72450_a;
                this.field_70181_x = motion.field_72448_b;
                this.field_70179_y = motion.field_72449_c;
                this.field_70133_I = true;
                break block19;
            }
            if (this.isActive()) {
                for (int i = 0; i < 4; ++i) {
                    this.field_70170_p.func_175682_a(this.field_70146_Z.nextBoolean() ? ParticleInit.GENERIC_DOT_ORANGE : ParticleInit.GENERIC_DOT_WHITE, true, Mth.func_151238_b((double)this.field_70169_q, (double)this.field_70165_t, (double)((float)i / 4.0f)), Mth.func_151238_b((double)this.field_70167_r, (double)this.field_70163_u, (double)((float)i / 4.0f)), Mth.func_151238_b((double)this.field_70166_s, (double)this.field_70161_v, (double)((float)i / 4.0f)), 0.0, 0.0, 0.0, new int[0]);
                }
            }
        }
        if (!this.isActive()) {
            this.setLocation();
        } else {
            this.field_70126_B = 0.0f;
            this.field_70177_z = 0.0f;
            this.field_70759_as = 0.0f;
            this.field_70761_aq = 0.0f;
        }
    }

    protected void func_82167_n(Entity entityIn) {
        Long time;
        if (this.field_70170_p.field_72995_K || !this.isActive()) {
            return;
        }
        if (entityIn instanceof LivingEntity && !(entityIn instanceof EntityImmaterial) && entityIn != this.getOwner() && ((time = this.attackCooldown.get(entityIn)) == null || (double)(System.currentTimeMillis() - time) >= 400.0)) {
            double dX = entityIn.field_70159_w;
            double dY = entityIn.field_70181_x;
            double dZ = entityIn.field_70179_y;
            CustomDamageResult damageResult = IMaxAttack.dealMaxHealth((Entity)this.getOwner(), (LivingEntity)entityIn, 5, Arrays.asList("Aquatic"));
            if (damageResult.didSuccessfulHit() && damageResult.targetHealthChanged()) {
                entityIn.field_70159_w = dX;
                entityIn.field_70181_x = dY;
                entityIn.field_70179_y = dZ;
            }
            this.attackCooldown.put(entityIn, System.currentTimeMillis());
            CustomParticleConfig config = new CustomParticleConfig();
            config.createInstance().setParticle(EnumParticleTypes.SWEEP_ATTACK).setCount(2).setSpread(entityIn.field_70130_N / 2.0f, entityIn.field_70131_O / 2.0f, entityIn.field_70130_N / 2.0f).setIgnoreRange(true);
            IParticleSpawner.spawnParticle(this.field_70170_p, config, entityIn.field_70165_t, entityIn.field_70163_u + (double)(entityIn.field_70131_O / 2.0f), entityIn.field_70161_v);
            if (this.field_70146_Z.nextInt(6) == 0) {
                this.field_70170_p.func_184148_a(null, this.field_70165_t, this.field_70163_u, this.field_70161_v, SoundInit.GENERIC_SLICE, SoundSource.NEUTRAL, 1.0f, 1.5f + this.field_70146_Z.nextFloat());
            }
        }
    }

    protected void func_70665_d(DamageSource damageSrc, float damageAmount) {
        super.func_70665_d(damageSrc, damageAmount);
    }

    protected void setLocation() {
        float yaw;
        Vec3 pos;
        switch (this.getPose()) {
            case 0: {
                pos = new Vec3(0.25, 1.0, -0.5);
                yaw = this.owner.field_70761_aq + 10.0f;
                break;
            }
            case 1: {
                pos = new Vec3(0.5, 1.1, -0.55);
                yaw = this.owner.field_70761_aq + 20.0f;
                break;
            }
            case 2: {
                pos = new Vec3(0.75, 1.2, -0.6);
                yaw = this.owner.field_70761_aq + 30.0f;
                break;
            }
            case 3: {
                pos = new Vec3(-0.25, 1.0, -0.5);
                yaw = this.owner.field_70761_aq - 10.0f;
                break;
            }
            case 4: {
                pos = new Vec3(-0.5, 1.1, -0.55);
                yaw = this.owner.field_70761_aq - 20.0f;
                break;
            }
            case 5: {
                pos = new Vec3(-0.75, 1.2, -0.6);
                yaw = this.owner.field_70761_aq - 30.0f;
                break;
            }
            default: {
                return;
            }
        }
        pos = pos.func_178785_b(-yaw * ((float)Math.PI / 180));
        this.func_70080_a(this.owner.field_70165_t + pos.field_72450_a, this.owner.field_70163_u + pos.field_72448_b, this.owner.field_70161_v + pos.field_72449_c, yaw, 0.0f);
        this.field_70759_as = yaw;
        this.field_70761_aq = yaw;
    }

    private ItemLostBladesOfInfinity.BladeMode getMode(ItemStack stack) {
        if (!stack.func_77942_o()) {
            stack.func_77982_d(new CompoundTag());
            return ItemLostBladesOfInfinity.BladeMode.STANDBY;
        }
        return ItemLostBladesOfInfinity.BladeMode.values()[stack.func_77978_p().func_74762_e("blade_mode")];
    }

    private void findClosestTarget() {
        List targets = this.field_70170_p.func_175647_a(LivingEntity.class, this.owner.func_174813_aQ().func_186662_g(24.0), this::validateTarget);
        Vec3 pos = this.owner.func_174791_d();
        double targetDist = Double.MAX_VALUE;
        for (LivingEntity entity : targets) {
            double dist = LMath.getDistanceSquaredToAABB(pos, entity.func_174813_aQ());
            if (!(dist < targetDist)) continue;
            targetDist = dist;
            this.target = entity;
        }
    }
}

