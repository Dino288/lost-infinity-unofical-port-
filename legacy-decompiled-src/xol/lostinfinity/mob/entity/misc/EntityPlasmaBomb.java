/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.Vec3
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.misc;

import java.util.UUID;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.util.data.CustomParticleConfig;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.fx.IParticleSpawner;

public class EntityPlasmaBomb
extends Entity
implements IMaxAttack {
    private UUID creator_UUID = null;
    private int timer = 0;
    private int repeats = 0;
    private Vec3 dir = null;

    public void setRepeats(int repeats) {
        this.repeats = repeats;
    }

    public void setDir(Vec3 dir) {
        this.dir = dir;
    }

    public EntityPlasmaBomb(Level worldIn) {
        super(worldIn);
        this.func_189654_d(true);
    }

    public void setTimer(int timer) {
        this.timer = timer;
    }

    public void setCreator(UUID uuid) {
        this.creator_UUID = uuid;
    }

    public void func_70071_h_() {
        super.func_70071_h_();
        if (!this.field_70170_p.field_72995_K && !this.field_70128_L && this.field_70173_aa >= this.timer) {
            this.explosionEffect();
        }
    }

    public void explosionEffect() {
        if (this.creator_UUID != null && this.dir != null) {
            CustomParticleConfig config1 = new CustomParticleConfig();
            config1.createInstance().setParticle(ParticleInit.PLASMA_RIFT).setSpread(3.0, 1.0, 3.0).setCount(8).setIgnoreRange(true);
            IParticleSpawner.spawnParticle(this.field_70170_p, config1, this.field_70165_t, this.field_70163_u + 0.25, this.field_70161_v);
            CustomParticleConfig config2 = new CustomParticleConfig();
            config2.createInstance().setParticle(ParticleInit.PLASMA_EXPLOSION).setCount(4).setIgnoreRange(true).setArgs(2);
            IParticleSpawner.spawnParticle(this.field_70170_p, config2, this.field_70165_t, this.field_70163_u + 0.5, this.field_70161_v);
            CustomParticleConfig config3 = new CustomParticleConfig();
            config3.createInstance().setParticle(ParticleInit.NUCLEAR_BLAST).setSpread(1.0, 1.0, 1.0).setCount(5).setIgnoreRange(true);
            IParticleSpawner.spawnParticle(this.field_70170_p, config3, this.field_70165_t, this.field_70163_u + 0.5, this.field_70161_v);
            this.field_70170_p.func_184133_a(null, this.func_180425_c(), SoundInit.GENERIC_WEAPON_14, SoundSource.PLAYERS, 1.5f, 0.7f + 0.6f * this.field_70146_Z.nextFloat());
            for (LivingEntity target : this.field_70170_p.func_72872_a(LivingEntity.class, this.func_174813_aQ().func_186662_g(5.0))) {
                if (target.func_110124_au().equals(this.creator_UUID)) continue;
                IMaxAttack.dealTrueDamage(this, target, target.func_110138_aP());
            }
            if (this.repeats > 0) {
                EntityPlasmaBomb bomb = new EntityPlasmaBomb(this.field_70170_p);
                bomb.setCreator(this.creator_UUID);
                int height = this.field_70170_p.func_189649_b(this.func_180425_c().func_177958_n() + (int)this.dir.field_72450_a * 3, this.func_180425_c().func_177952_p() + (int)this.dir.field_72449_c * 3);
                bomb.func_70107_b((double)this.func_180425_c().func_177958_n() + this.dir.field_72450_a * 3.0, height + 1, (double)this.func_180425_c().func_177952_p() + this.dir.field_72449_c * 3.0);
                bomb.setTimer(5);
                bomb.setDir(this.dir);
                bomb.setRepeats(this.repeats - 1);
                this.field_70170_p.func_72838_d((Entity)bomb);
            }
        }
        this.func_70106_y();
    }

    protected void func_70088_a() {
    }

    protected void func_70037_a(CompoundTag compound) {
    }

    protected void func_70014_b(CompoundTag compound) {
    }
}

