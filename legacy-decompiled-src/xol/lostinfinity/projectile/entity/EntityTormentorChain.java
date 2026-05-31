/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.datasync.DataParameter
 *  net.minecraft.network.datasync.DataSerializer
 *  net.minecraft.network.datasync.DataSerializers
 *  net.minecraft.network.datasync.EntityDataManager
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3
 *  net.minecraft.world.World
 */
package xol.lostinfinity.projectile.entity;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializer;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.util.data.CustomParticleConfig;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.fx.IParticleSpawner;

public class EntityTormentorChain
extends Entity
implements IMaxAttack {
    private static final DataParameter<Float> TARGET_X = EntityDataManager.func_187226_a(EntityTormentorChain.class, (DataSerializer)DataSerializers.field_187193_c);
    private static final DataParameter<Float> TARGET_Y = EntityDataManager.func_187226_a(EntityTormentorChain.class, (DataSerializer)DataSerializers.field_187193_c);
    private static final DataParameter<Float> TARGET_Z = EntityDataManager.func_187226_a(EntityTormentorChain.class, (DataSerializer)DataSerializers.field_187193_c);
    private LivingEntity target = null;
    private Player owner = null;
    private Vec3 stopPos = null;
    private BlockPos spawnLocation = null;
    private float growth = 0.0f;
    private boolean playedPull = false;

    public Vec3 getTargetPos() {
        double x = ((Float)this.field_70180_af.func_187225_a(TARGET_X)).floatValue();
        double y = ((Float)this.field_70180_af.func_187225_a(TARGET_Y)).floatValue();
        double z = ((Float)this.field_70180_af.func_187225_a(TARGET_Z)).floatValue();
        return new Vec3(x, y, z);
    }

    public void setTargetXYZ(Vec3 pos) {
        float xpos = (float)pos.field_72450_a;
        float ypos = (float)pos.field_72448_b;
        float zpos = (float)pos.field_72449_c;
        this.field_70180_af.func_187227_b(TARGET_X, (Object)Float.valueOf(xpos));
        this.field_70180_af.func_187227_b(TARGET_Y, (Object)Float.valueOf(ypos));
        this.field_70180_af.func_187227_b(TARGET_Z, (Object)Float.valueOf(zpos));
    }

    public LivingEntity getTarget() {
        return this.target;
    }

    public EntityTormentorChain(Level worldIn) {
        super(worldIn);
    }

    public void setRespawnPosition(BlockPos newSpawn) {
        this.spawnLocation = newSpawn;
    }

    public void func_70071_h_() {
        block11: {
            block9: {
                block10: {
                    super.func_70071_h_();
                    if (this.growth < 1.0f) {
                        this.growth += 0.04f;
                    } else if (!this.playedPull && this.owner != null) {
                        this.field_70170_p.func_184133_a(null, this.owner.func_180425_c(), SoundInit.MAGIC_WEAPON_16, SoundSource.PLAYERS, 1.0f, 0.9f + this.field_70170_p.field_73012_v.nextFloat() * 0.2f);
                        this.playedPull = true;
                    }
                    Vec3 playerPos = this.getTargetPos();
                    Vec3 dir = playerPos.func_178788_d(this.func_174791_d());
                    dir = dir.func_72432_b();
                    int dist = (int)playerPos.func_72438_d(this.func_174791_d());
                    Vec3 nextPos = this.func_174791_d().func_178787_e(dir);
                    int steps = 1;
                    boolean foundBlock = false;
                    while (!foundBlock && steps < dist) {
                        if (this.field_70170_p.func_175623_d(new BlockPos(nextPos.field_72450_a, nextPos.field_72448_b, nextPos.field_72449_c))) {
                            ++steps;
                            nextPos = nextPos.func_178787_e(dir);
                            continue;
                        }
                        foundBlock = true;
                    }
                    this.stopPos = foundBlock ? nextPos : null;
                    if (this.field_70170_p.field_72995_K) break block9;
                    if (this.target != null && this.owner != null && !this.owner.field_70128_L && !this.target.field_70128_L && !(this.target.func_110143_aJ() <= 0.0f)) break block10;
                    this.func_70106_y();
                    break block11;
                }
                Vec3 lookVec = this.owner.func_70040_Z().func_178785_b(1.5707964f).func_72432_b();
                this.func_70634_a(this.owner.field_70165_t - lookVec.field_72450_a / 2.0, this.owner.field_70163_u + (double)this.owner.field_70131_O / 2.2, this.owner.field_70161_v - lookVec.field_72449_c / 2.0);
                this.setTargetXYZ(new Vec3(this.target.field_70165_t, this.target.field_70163_u + (double)this.target.field_70131_O / 2.0 - 0.3, this.target.field_70161_v));
                if (this.getStopPos() != null || !(this.growth >= 1.0f)) break block11;
                double length = this.target.func_174791_d().func_72438_d(this.func_174791_d());
                if (length < 2.0) {
                    if (this.spawnLocation != null && this.target instanceof Player) {
                        ((Player)this.target).setSpawnDimension(Integer.valueOf(0));
                        ((Player)this.target).func_180473_a(this.spawnLocation, true);
                    }
                    AABB checkBox = new AABB(this.func_180425_c()).func_186662_g(10.0);
                    for (LivingEntity entity : this.field_70170_p.func_72872_a(LivingEntity.class, checkBox)) {
                        if (entity.equals((Object)this.owner)) continue;
                        CustomParticleConfig config1 = new CustomParticleConfig();
                        config1.createInstance().setParticle(ParticleInit.BLUE_SKULL).setSpread(1.0, 1.0, 1.0).setIgnoreRange(true);
                        IParticleSpawner.spawnParticle(this.field_70170_p, config1, entity.field_70165_t, entity.field_70163_u + (double)(entity.field_70131_O / 2.0f), entity.field_70161_v);
                        IMaxAttack.dealTrueDamage((Entity)this.owner, entity, this.target.func_110138_aP());
                    }
                    this.target.field_70159_w = 0.0;
                    this.target.field_70181_x = 0.0;
                    this.target.field_70179_y = 0.0;
                    this.target.field_70133_I = true;
                    this.field_70170_p.func_184133_a(null, this.owner.func_180425_c(), SoundInit.MAGIC_WEAPON_17, SoundSource.PLAYERS, 1.5f, 0.9f + this.field_70170_p.field_73012_v.nextFloat() * 0.2f);
                    this.func_70106_y();
                    return;
                }
                Vec3 pullDir = this.func_174791_d().func_178788_d(this.target.func_174791_d());
                pullDir = pullDir.func_72432_b();
                this.target.field_70159_w = pullDir.field_72450_a * 1.5;
                this.target.field_70181_x = pullDir.field_72448_b * 1.5;
                this.target.field_70179_y = pullDir.field_72449_c * 1.5;
                this.target.field_70133_I = true;
                break block11;
            }
            for (int i = 0; i < 3; ++i) {
                double randX = this.field_70165_t - 10.0 + this.field_70170_p.field_73012_v.nextDouble() * 20.0;
                double randY = this.field_70163_u - 2.0 + this.field_70170_p.field_73012_v.nextDouble() * 4.0;
                double randZ = this.field_70161_v - 10.0 + this.field_70170_p.field_73012_v.nextDouble() * 20.0;
                this.field_70170_p.func_175688_a(ParticleInit.SNOW_BUBBLE, randX, randY, randZ, 0.0, 0.0, 0.0, new int[0]);
            }
        }
    }

    public Vec3 getStopPos() {
        return this.stopPos;
    }

    protected void func_70037_a(CompoundTag compound) {
    }

    protected void func_70014_b(CompoundTag compound) {
    }

    protected void func_70088_a() {
        this.field_70180_af.func_187214_a(TARGET_X, (Object)Float.valueOf(0.0f));
        this.field_70180_af.func_187214_a(TARGET_Y, (Object)Float.valueOf(0.0f));
        this.field_70180_af.func_187214_a(TARGET_Z, (Object)Float.valueOf(0.0f));
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public void setTarget(LivingEntity hit_entity) {
        this.target = hit_entity;
    }

    public float getGrowth() {
        return this.growth;
    }
}

