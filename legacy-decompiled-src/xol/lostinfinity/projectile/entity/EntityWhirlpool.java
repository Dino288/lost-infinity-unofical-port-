/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.init.MobEffects
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.util.SoundSource
 *  net.minecraft.world.World
 */
package xol.lostinfinity.projectile.entity;

import java.util.Arrays;
import java.util.List;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.init.MobEffects;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.potion.PotionEffect;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.init.PotionInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.entity.cthulhu.EntityCthulhu;
import xol.lostinfinity.mob.entity.cthulhu.EntityCthulhuTurret;
import xol.lostinfinity.mob.entity.misc.EntityRift;
import xol.lostinfinity.util.data.IMaxAttack;

public class EntityWhirlpool
extends Entity {
    private static final double RANGE = 15.0;
    private float growth = 0.0f;
    private float rotation = 0.0f;
    private float angle = 0.0f;
    private Entity owner;
    private static final int LIFESPAN_TICKS = 200;

    public EntityWhirlpool(Level worldIn) {
        super(worldIn);
        this.func_70105_a(0.5f, 0.5f);
    }

    public void func_70071_h_() {
        super.func_70071_h_();
        this.growth = this.field_70173_aa < 100 ? (this.growth += 0.1f) : (this.growth -= 0.075f);
        this.rotation += 0.2f;
        if (!this.field_70170_p.field_72995_K) {
            if (this.field_70173_aa % 5 == 0) {
                this.field_70170_p.func_184133_a(null, this.func_180425_c(), SoundInit.WATER_ECHO, SoundSource.PLAYERS, 1.5f, 0.5f + this.field_70146_Z.nextFloat() * 0.6f);
            }
            if (this.field_70173_aa >= 200) {
                this.func_70106_y();
                return;
            }
            List nearEntities = this.field_70170_p.func_72872_a(LivingEntity.class, this.func_174813_aQ().func_186662_g(15.0));
            for (LivingEntity entity : nearEntities) {
                if (entity.equals((Object)this.owner) || entity instanceof EntityCthulhuTurret || entity instanceof EntityRift || entity instanceof EntityCthulhu) continue;
                entity.func_70024_g((this.field_70165_t - entity.field_70165_t) / 30.0, (this.field_70163_u - entity.field_70163_u) / 20.0, (this.field_70161_v - entity.field_70161_v) / 30.0);
                entity.field_70133_I = true;
                if (!entity.func_174813_aQ().func_72326_a(this.func_174813_aQ().func_186662_g((double)this.growth)) || this.field_70173_aa % 10 != 0) continue;
                IMaxAttack.dealTrueDamage(this.owner, entity, entity.func_110138_aP() * 0.1f, Arrays.asList("Aquatic"));
            }
        } else {
            for (int i = 0; i < 4; ++i) {
                float growthDist = this.growth * 1.06f;
                this.angle += 0.15f;
                double velocity_x = (double)growthDist * Math.cos(this.angle);
                double velocity_z = (double)growthDist * Math.sin(this.angle);
                this.field_70170_p.func_175688_a(ParticleInit.STATIONARY_BUBBLE, this.field_70165_t - velocity_x / 2.0, this.field_70163_u - 0.25, this.field_70161_v - velocity_z / 2.0, 0.0, 0.0, 0.0, new int[0]);
                this.field_70170_p.func_175688_a(ParticleInit.STATIONARY_BUBBLE, this.field_70165_t + velocity_x / 2.0, this.field_70163_u - 0.25, this.field_70161_v + velocity_z / 2.0, 0.0, 0.0, 0.0, new int[0]);
                this.field_70170_p.func_175688_a(this.field_70146_Z.nextBoolean() ? ParticleInit.GENERIC_DOT_AQUA : ParticleInit.GENERIC_DOT_BLUE, this.field_70165_t + velocity_x / 2.0, this.field_70163_u, this.field_70161_v + velocity_z / 2.0, 0.0, 0.0, 0.0, new int[0]);
            }
        }
    }

    public void func_70037_a(CompoundTag compound) {
        this.growth = compound.func_74760_g("growth");
        this.rotation = compound.func_74760_g("rotation");
        this.angle = compound.func_74760_g("angle");
        if (compound.func_74764_b("owner")) {
            this.owner = this.field_70170_p.func_73045_a(compound.func_74762_e("owner"));
        }
    }

    public void func_70014_b(CompoundTag compound) {
        compound.func_74776_a("growth", this.growth);
        compound.func_74776_a("rotation", this.rotation);
        compound.func_74776_a("angle", this.angle);
        if (this.owner != null) {
            compound.func_74768_a("owner", this.owner.func_145782_y());
        }
    }

    protected void func_70088_a() {
    }

    public float getGrowth() {
        return this.growth;
    }

    public float getRotation() {
        return this.rotation;
    }

    public void setOwner(Entity owner) {
        this.owner = owner;
    }

    public void func_70106_y() {
        this.field_70170_p.func_72876_a((Entity)this, this.field_70165_t, this.field_70163_u, this.field_70161_v, 5.0f, false);
        List nearbyEntities = this.field_70170_p.func_72872_a(LivingEntity.class, this.func_174813_aQ().func_186662_g(5.0));
        for (LivingEntity entity : nearbyEntities) {
            entity.func_70690_d(new PotionEffect(PotionInit.PLAGUE, 200, 3, false, false));
            entity.func_70690_d(new PotionEffect(MobEffects.field_76436_u, 200, 3, false, false));
            entity.func_70690_d(new PotionEffect(MobEffects.field_76421_d, 200, 3, false, false));
            IMaxAttack.dealTrueDamage(this, entity, entity.func_110138_aP());
        }
        super.func_70106_y();
    }
}

