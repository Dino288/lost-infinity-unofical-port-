/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.util.math.HitResult
 *  net.minecraft.world.World
 */
package xol.lostinfinity.projectile.entity;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.init.PotionInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.projectile.entity.EntityBaseThrowable;
import xol.lostinfinity.util.data.CustomParticleConfig;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.fx.IParticleSpawner;

public class EntityFirePellet
extends EntityBaseThrowable {
    public EntityFirePellet(Level par1World) {
        super(par1World);
        this.func_70105_a(0.75f, 0.75f);
    }

    public EntityFirePellet(Level par1World, LivingEntity par2Mob) {
        super(par1World, par2Mob);
    }

    public EntityFirePellet(Level par1World, double par2, double par4, double par6) {
        super(par1World, par2, par4, par6);
    }

    @Override
    protected void func_70184_a(HitResult result) {
        if (!this.field_70170_p.field_72995_K) {
            CustomParticleConfig config1 = new CustomParticleConfig();
            config1.createInstance().setParticle(ParticleInit.FLAME_MEDIUM).setSpread(1.0, 1.0, 1.0).setCount(9).setIgnoreRange(true);
            IParticleSpawner.spawnParticle(this.field_70170_p, config1, this.field_70165_t, this.field_70163_u + 1.0, this.field_70161_v);
            this.func_184185_a(SoundInit.GENERIC_WEAPON_6, 1.0f, 0.8f + 0.4f * this.field_70146_Z.nextFloat());
            for (Player target : this.field_70170_p.func_72872_a(Player.class, this.func_174813_aQ().func_72314_b(2.0, 2.0, 2.0))) {
                if (!IMaxAttack.dealMaxHealth((Entity)this, (LivingEntity)target, 2).didSuccessfulHit()) continue;
                target.func_70690_d(new PotionEffect(PotionInit.BLIGHTED, 200));
            }
            this.func_70106_y();
        }
    }

    protected float func_70185_h() {
        return 0.2f;
    }
}

