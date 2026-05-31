/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.util.EnumParticleTypes
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.cthulhu;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.sounds.SoundSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.init.PotionInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.entity.cthulhu.AbstractCthulhuMinion;
import xol.lostinfinity.mob.entity.cthulhu.ICthulhuMinion;
import xol.lostinfinity.util.data.CustomParticleConfig;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.fx.IParticleSpawner;

public class EntityCthulhuCloud
extends AbstractCthulhuMinion {
    public EntityCthulhuCloud(Level worldIn) {
        super(worldIn);
        this.func_189654_d(true);
        this.func_184224_h(true);
    }

    @Override
    protected void func_184651_r() {
    }

    public void func_70636_d() {
        super.func_70636_d();
        if (this.field_70170_p.field_72995_K) {
            return;
        }
        this.func_70015_d(0);
        if (this.field_70173_aa % 4 == 1) {
            Object type = ParticleInit.CLOUD_GREEN;
            if (this.field_70146_Z.nextBoolean()) {
                type = ParticleInit.CLOUD_PURPLE;
            }
            CustomParticleConfig config = new CustomParticleConfig();
            config.createInstance().setSpread(3.5, 1.25, 3.5).setParticle((EnumParticleTypes)type).setCount(50).setIgnoreRange(true);
            IParticleSpawner.spawnParticle(this.field_70170_p, config, this.field_70165_t, this.field_70163_u, this.field_70161_v);
        }
        if (this.field_70173_aa % 20 == 1) {
            for (LivingEntity entity : this.field_70170_p.func_72872_a(LivingEntity.class, this.func_174813_aQ().func_186662_g(3.0))) {
                if (entity == this.owner || entity instanceof ICthulhuMinion) continue;
                IMaxAttack.dealTrueDamage((Entity)this, entity, entity.func_110138_aP() * 0.25f);
                entity.func_70690_d(new PotionEffect(PotionInit.PLAGUE, 100, 3));
                entity.func_70690_d(new PotionEffect(PotionInit.CONTAGIOUS, 100, 3));
                this.field_70170_p.func_184133_a(null, entity.func_180425_c(), this.randomWhisper(this.field_70146_Z.nextInt(5)), SoundSource.PLAYERS, 1.5f, 0.6f + 0.4f * this.field_70146_Z.nextFloat());
            }
        }
        if (this.func_70638_az() != null && this.func_70638_az().field_70128_L) {
            this.func_70624_b(null);
        }
        if (this.func_70638_az() != null) {
            LivingEntity target = this.func_70638_az();
            this.field_70159_w = (target.field_70165_t - this.field_70165_t) / 25.0;
            this.field_70181_x = (target.field_70163_u - this.field_70163_u) / 25.0;
            this.field_70179_y = (target.field_70161_v - this.field_70161_v) / 25.0;
            this.field_70133_I = true;
        } else if (this.field_70173_aa % 40 == 1 && this.field_70146_Z.nextBoolean()) {
            this.field_70159_w = (this.field_70146_Z.nextFloat() - 0.5f) * 0.75f;
            this.field_70181_x = (this.field_70146_Z.nextFloat() - 0.5f) * 0.75f;
            this.field_70179_y = (this.field_70146_Z.nextFloat() - 0.5f) * 0.75f;
            this.field_70133_I = true;
        }
        if (this.field_70173_aa == 300) {
            this.func_70106_y();
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

