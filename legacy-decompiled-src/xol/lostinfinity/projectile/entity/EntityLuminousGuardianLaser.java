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
 *  net.minecraft.util.math.Vec3
 *  net.minecraft.world.World
 */
package xol.lostinfinity.projectile.entity;

import java.util.ArrayList;
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
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.entity.base.EntityImmaterial;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.math.LMath;

public class EntityLuminousGuardianLaser
extends Entity
implements IMaxAttack {
    private LivingEntity owner = null;
    private static final DataParameter<Float> TARGET_X = EntityDataManager.func_187226_a(EntityLuminousGuardianLaser.class, (DataSerializer)DataSerializers.field_187193_c);
    private static final DataParameter<Float> TARGET_Y = EntityDataManager.func_187226_a(EntityLuminousGuardianLaser.class, (DataSerializer)DataSerializers.field_187193_c);
    private static final DataParameter<Float> TARGET_Z = EntityDataManager.func_187226_a(EntityLuminousGuardianLaser.class, (DataSerializer)DataSerializers.field_187193_c);
    private static final DataParameter<Integer> OWNER_ID = EntityDataManager.func_187226_a(EntityLuminousGuardianLaser.class, (DataSerializer)DataSerializers.field_187192_b);
    private static final int duration = 10;
    Player playerOwner = null;
    private final double dist = 20.0;
    public int counter = 0;

    public EntityLuminousGuardianLaser(Level worldIn) {
        super(worldIn);
    }

    protected void func_70088_a() {
        this.field_70180_af.func_187214_a(TARGET_X, (Object)Float.valueOf(0.0f));
        this.field_70180_af.func_187214_a(TARGET_Y, (Object)Float.valueOf(0.0f));
        this.field_70180_af.func_187214_a(TARGET_Z, (Object)Float.valueOf(0.0f));
        this.field_70180_af.func_187214_a(OWNER_ID, (Object)0);
    }

    public void setOwnerID(int id) {
        this.field_70180_af.func_187227_b(OWNER_ID, (Object)id);
    }

    public int getOwnerID() {
        return (Integer)this.field_70180_af.func_187225_a(OWNER_ID);
    }

    public Vec3 getTargetPos() {
        double x = ((Float)this.field_70180_af.func_187225_a(TARGET_X)).floatValue();
        double y = ((Float)this.field_70180_af.func_187225_a(TARGET_Y)).floatValue();
        double z = ((Float)this.field_70180_af.func_187225_a(TARGET_Z)).floatValue();
        return new Vec3(x, y, z);
    }

    public void setTargetPos(Vec3 pos) {
        float xpos = (float)pos.field_72450_a;
        float ypos = (float)pos.field_72448_b;
        float zpos = (float)pos.field_72449_c;
        this.field_70180_af.func_187227_b(TARGET_X, (Object)Float.valueOf(xpos));
        this.field_70180_af.func_187227_b(TARGET_Y, (Object)Float.valueOf(ypos));
        this.field_70180_af.func_187227_b(TARGET_Z, (Object)Float.valueOf(zpos));
    }

    public LivingEntity getOwner() {
        return this.owner;
    }

    public void setOwner(LivingEntity owner) {
        this.owner = owner;
    }

    public void func_70030_z() {
        super.func_70030_z();
        ++this.counter;
        if (!this.field_70170_p.field_72995_K) {
            if (this.owner == null) {
                this.func_70106_y();
                return;
            }
            if (this.counter % 5 == 0 && this.counter < 6) {
                this.field_70170_p.func_184133_a(null, this.owner.func_180425_c(), SoundInit.MAGIC_WEAPON_22, SoundSource.MASTER, 0.1f, 0.7f + (float)this.counter / 10.0f);
            }
            this.func_70634_a(this.owner.field_70165_t, this.owner.field_70163_u, this.owner.field_70161_v);
            if (this.counter == 6) {
                this.damageTarget();
            } else if (this.counter >= 10) {
                this.counter = 0;
                this.func_70106_y();
            }
        } else {
            this.spawnParticles();
        }
    }

    private void damageTarget() {
        Vec3 dir = this.getTargetPos().func_178788_d(this.owner.func_174791_d()).func_72432_b();
        ArrayList<LivingEntity> hitEntities = new ArrayList<LivingEntity>();
        for (double i = 0.0; i <= 20.0; i += 0.4) {
            Vec3 pos = this.owner.func_174791_d().func_72441_c(dir.field_72450_a * i, dir.field_72448_b * i, dir.field_72449_c * i);
            double radius = 1.8;
            AABB checkBox = new AABB(pos.field_72450_a - radius, pos.field_72448_b - radius, pos.field_72449_c - radius, pos.field_72450_a + radius, pos.field_72448_b + radius, pos.field_72449_c + radius);
            for (LivingEntity entity : this.field_70170_p.func_72872_a(LivingEntity.class, checkBox)) {
                if (entity instanceof EntityImmaterial || entity.func_110124_au().equals(this.owner.func_110124_au()) || hitEntities.contains(entity) || this.playerOwner != null && this.playerOwner.func_110124_au().equals(entity.func_110124_au())) continue;
                IMaxAttack.dealTrueDamage((Entity)this.owner, entity, entity.func_110138_aP() * 0.35f);
                hitEntities.add(entity);
            }
        }
        this.field_70170_p.func_184133_a(null, this.owner.func_180425_c(), SoundInit.MAGIC_WEAPON_22, SoundSource.MASTER, 0.1f, 1.0f);
    }

    private void spawnParticles() {
        int id = this.getOwnerID();
        Entity owner = this.field_70170_p.func_73045_a(id);
        if (owner != null) {
            if (this.counter >= 10) {
                return;
            }
            Vec3 dir = LMath.fastNormalize(this.getTargetPos().func_178788_d(owner.func_174791_d()));
            for (double i = 0.0; i <= 20.0; i += 1.0) {
                if (this.field_70146_Z.nextInt(8) != 0) continue;
                Vec3 pos = owner.func_174791_d().func_178787_e(dir.func_186678_a(i));
                this.field_70170_p.func_175688_a(this.counter < 5 ? ParticleInit.GALAXY_YELLOW : ParticleInit.GALAXY_PURPLE, pos.field_72450_a, pos.field_72448_b + 0.4, pos.field_72449_c, (this.field_70146_Z.nextDouble() - 0.5) * 0.2, (this.field_70146_Z.nextDouble() - 0.5) * 0.2, (this.field_70146_Z.nextDouble() - 0.5) * 0.2, new int[0]);
            }
        }
    }

    public double getDist() {
        return 20.0;
    }

    protected void func_70037_a(CompoundTag compound) {
    }

    protected void func_70014_b(CompoundTag compound) {
    }

    public void setPlayerOwner(Player player) {
        this.playerOwner = player;
    }
}

