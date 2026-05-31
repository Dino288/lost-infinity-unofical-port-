/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.item.Item
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
package xol.lostinfinity.mob.entity.deviant.prime;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.item.Item;
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
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.entity.base.EntityDeviantPrime;
import xol.lostinfinity.mob.entity.classify.IEntityReactive;
import xol.lostinfinity.projectile.entity.EntityZenonShot;
import xol.lostinfinity.util.data.IMaxAttack;

public class EntityZenon
extends EntityDeviantPrime
implements IMaxAttack,
IEntityReactive {
    private static final DataParameter<Boolean> REFLECT = EntityDataManager.func_187226_a(EntityZenon.class, (DataSerializer)DataSerializers.field_187198_h);

    public EntityZenon(Level worldIn) {
        super(worldIn);
        this.func_70105_a(1.75f, 3.2f);
    }

    public boolean getReflect() {
        return (Boolean)this.field_70180_af.func_187225_a(REFLECT);
    }

    public void setReflect(boolean reflect) {
        this.field_70180_af.func_187227_b(REFLECT, (Object)reflect);
    }

    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(1.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.32);
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(4000.0);
    }

    @Override
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a(REFLECT, (Object)false);
    }

    public boolean func_70652_k(Entity entity) {
        super.func_70652_k(entity);
        if (this.func_70638_az() != null) {
            IMaxAttack.dealTrueDamage((Entity)this, this.func_70638_az(), this.func_70638_az().func_110138_aP() * 0.6f);
            return true;
        }
        return false;
    }

    public void func_70636_d() {
        super.func_70636_d();
        this.field_70143_R = -1.0f;
        if (!this.field_70170_p.field_72995_K) {
            LivingEntity target = this.func_70638_az();
            if (this.field_70173_aa % 80 == 0) {
                double radius = 15.0;
                double returnSpeed = 1.0;
                for (EntityZenonShot shot : this.field_70170_p.func_72872_a(EntityZenonShot.class, new AABB(this.func_180425_c()).func_186662_g(radius))) {
                    Vec3 returnPos = new Vec3(this.field_70165_t, this.field_70163_u + (double)this.field_70131_O / 2.0, this.field_70161_v);
                    Vec3 dir = returnPos.func_178788_d(shot.func_174791_d()).func_72432_b();
                    shot.field_70159_w = dir.field_72450_a * returnSpeed;
                    shot.field_70181_x = dir.field_72448_b * returnSpeed;
                    shot.field_70179_y = dir.field_72449_c * returnSpeed;
                    shot.clearHits();
                    shot.field_70133_I = true;
                    this.field_70170_p.func_184133_a(null, shot.func_180425_c(), SoundInit.LASER_WEAPON_8, SoundSource.HOSTILE, 1.1f, 0.8f + this.field_70146_Z.nextFloat() * 0.4f);
                }
            }
            if (this.field_70173_aa % 10 == 0 && target != null) {
                this.field_70170_p.func_184133_a(null, this.func_180425_c(), SoundInit.LASER_WEAPON_5, SoundSource.HOSTILE, 1.25f, 0.8f + this.field_70146_Z.nextFloat() * 0.4f);
                EntityZenonShot shot = new EntityZenonShot(this.field_70170_p, (LivingEntity)this);
                Vec3 start = new Vec3(this.field_70165_t, this.field_70163_u + (double)this.field_70131_O / 2.0, this.field_70161_v);
                Vec3 targetVec = new Vec3(target.field_70165_t, target.field_70163_u + (double)(target.field_70131_O / 2.0f), target.field_70161_v);
                Vec3 dir = targetVec.func_178788_d(start).func_72432_b();
                shot.func_70634_a(start.field_72450_a, start.field_72448_b, start.field_72449_c);
                shot.func_70186_c(dir.field_72450_a, dir.field_72448_b, dir.field_72449_c, 1.0f, 2.0f);
                this.field_70170_p.func_72838_d((Entity)shot);
            }
            if (this.field_70173_aa % 100 == 0) {
                this.setReflect(!this.getReflect());
                this.field_70170_p.func_184133_a(null, this.func_180425_c(), SoundInit.LASER_WEAPON_7, SoundSource.HOSTILE, 2.0f, 0.6f + this.field_70146_Z.nextFloat() * 0.4f);
            }
        }
    }

    @Override
    protected int numberOfLives() {
        return 75;
    }

    protected SoundEvent func_184615_bR() {
        return SoundInit.GENERIC_STYLE1_DEATH;
    }

    protected SoundEvent func_184601_bQ(DamageSource damageSourceIn) {
        return SoundInit.GENERIC_STYLE1_HURT;
    }

    protected SoundEvent func_184639_G() {
        return null;
    }

    @Override
    protected String primeName() {
        return "Zenon";
    }

    @Override
    public float hitEffect(LivingEntity attacker, float damage) {
        if (this.getReflect()) {
            IMaxAttack.dealTrueDamage((Entity)this, attacker, damage * 0.1f);
            return 0.0f;
        }
        return damage;
    }

    @Override
    protected Item primeDrop() {
        return ItemInit.deviantFragmentBL;
    }
}

