/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.misc;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.entity.base.EntityImmaterial;
import xol.lostinfinity.mob.entity.base.EntityParticleTrojan;
import xol.lostinfinity.util.data.CustomParticleConfig;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.fx.IParticleSpawner;

public class EntityNitroExplosion
extends EntityImmaterial
implements IMaxAttack {
    private boolean hasExploded = false;
    private static final int range = 5;
    private int numBlocks = 0;
    private Player thrower = null;

    public void setThrower(Player thrower) {
        this.thrower = thrower;
    }

    public EntityNitroExplosion(Level worldIn) {
        super(worldIn);
        this.func_70105_a(0.001f, 0.001f);
        this.func_184224_h(true);
        this.func_82142_c(true);
        this.func_189654_d(true);
    }

    public void setNumBlocks(int numBlocks) {
        this.numBlocks = numBlocks;
    }

    @Override
    public void func_70636_d() {
        super.func_70636_d();
        if (this.field_70170_p.field_72995_K && this.field_70173_aa >= 3 && this.field_70173_aa <= 5) {
            for (int i = 0; i < 3; ++i) {
                this.field_70170_p.func_175682_a(ParticleInit.NATURE_RING, true, this.field_70165_t - 1.0 + this.field_70146_Z.nextDouble() * 2.0, this.field_70163_u + this.field_70146_Z.nextDouble(), this.field_70161_v - 1.0 + this.field_70146_Z.nextDouble() * 2.0, 0.0, 0.0, 0.0, new int[0]);
            }
        }
        if (!this.field_70170_p.field_72995_K) {
            if (!this.hasExploded && this.field_70173_aa >= 2) {
                this.func_184185_a(SoundInit.GENERIC_WEAPON_5, 2.0f, 1.0f);
                this.explosion();
            }
            if (this.field_70173_aa >= 40) {
                this.func_70106_y();
            }
        }
    }

    private void explosion() {
        this.hasExploded = true;
        EntityNitroExplosion attacker = this;
        for (LivingEntity target : this.field_70170_p.func_72872_a(LivingEntity.class, this.func_174813_aQ().func_72314_b(5.0, 5.0, 5.0))) {
            if (target instanceof Player && ((Player)target).equals((Object)this.thrower) || target instanceof EntityParticleTrojan) continue;
            IMaxAttack.dealTrueDamage((Entity)attacker, target, target.func_110138_aP() / 20.0f * (float)this.numBlocks);
            CustomParticleConfig config1 = new CustomParticleConfig();
            config1.createInstance().setParticle(ParticleInit.CLAW_MARKS).setSpread(4.0, 1.0, 4.0).setCount(8).setIgnoreRange(true);
            IParticleSpawner.spawnParticle(this.field_70170_p, config1, target.field_70165_t, target.field_70163_u + (double)(target.field_70131_O / 2.0f), target.field_70161_v);
        }
    }
}

