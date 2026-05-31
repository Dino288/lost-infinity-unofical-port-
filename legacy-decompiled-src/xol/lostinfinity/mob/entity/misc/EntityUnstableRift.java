/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.util.SoundSource
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.misc;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.entity.misc.EntityBaseRift;
import xol.lostinfinity.util.data.CustomParticleConfig;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.fx.IParticleSpawner;

public class EntityUnstableRift
extends EntityBaseRift
implements IMaxAttack {
    private Player owner = null;

    public EntityUnstableRift(Level worldIn) {
        super(worldIn);
    }

    public void setOwner(Player play) {
        this.owner = play;
    }

    @Override
    public void func_70636_d() {
        super.func_70636_d();
        this.field_70159_w = 0.0;
        this.field_70181_x = 0.0;
        this.field_70179_y = 0.0;
        if (!this.field_70170_p.field_72995_K) {
            if (this.field_70173_aa >= 120) {
                CustomParticleConfig config1 = new CustomParticleConfig();
                config1.createInstance().setParticle(ParticleInit.ION_BLAST).setSpread(6.0, 4.0, 6.0).setCount(10).setIgnoreRange(true);
                CustomParticleConfig config2 = new CustomParticleConfig();
                config2.createInstance().setParticle(ParticleInit.EXPLOSION_LAVENDER).setSpread(5.0, 1.0, 5.0).setCount(10).setIgnoreRange(true);
                IParticleSpawner.spawnParticle(this.field_70170_p, config1, this.field_70165_t, this.field_70163_u, this.field_70161_v);
                IParticleSpawner.spawnParticle(this.field_70170_p, config2, this.field_70165_t, this.field_70163_u, this.field_70161_v);
                this.field_70170_p.func_184133_a(null, this.func_180425_c(), SoundInit.GENERIC_WEAPON_4, SoundSource.PLAYERS, 1.0f, 0.9f + this.field_70146_Z.nextFloat() * 0.2f);
                for (LivingEntity target : this.field_70170_p.func_72872_a(LivingEntity.class, this.func_174813_aQ().func_72314_b(20.0, 20.0, 20.0))) {
                    if (target.equals((Object)this.owner) || target.func_110124_au().equals(this.func_110124_au())) continue;
                    IMaxAttack.dealMaxHealth((Entity)this, target, 1, 1.0f);
                }
                this.func_70106_y();
            }
        } else if (this.field_70146_Z.nextInt(2) == 0) {
            this.field_70170_p.func_175682_a(ParticleInit.FLAME_MEDIUM, true, this.field_70165_t + this.getROD(8), this.field_70163_u + 2.0, this.field_70161_v + this.getROD(8), 0.0, 0.0, 0.0, new int[0]);
        }
    }
}

