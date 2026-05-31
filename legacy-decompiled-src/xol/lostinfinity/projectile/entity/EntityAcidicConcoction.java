/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.HitResult
 *  net.minecraft.world.World
 */
package xol.lostinfinity.projectile.entity;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.potion.PotionEffect;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.init.PotionInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.projectile.entity.EntityBaseThrowable;
import xol.lostinfinity.util.data.CustomParticleConfig;
import xol.lostinfinity.util.fx.IParticleSpawner;

public class EntityAcidicConcoction
extends EntityBaseThrowable {
    public EntityAcidicConcoction(Level par1World) {
        super(par1World);
    }

    public EntityAcidicConcoction(Level par1World, LivingEntity par2Mob) {
        super(par1World, par2Mob);
    }

    public EntityAcidicConcoction(Level par1World, double par2, double par4, double par6) {
        super(par1World, par2, par4, par6);
    }

    protected float func_70185_h() {
        return 0.05f;
    }

    @Override
    protected void func_70184_a(HitResult result) {
        if (!this.field_70170_p.field_72995_K) {
            if (result.field_72308_g != null && result.field_72308_g.equals((Object)this.func_85052_h())) {
                return;
            }
            int radius = 10;
            CustomParticleConfig config1 = new CustomParticleConfig();
            config1.createInstance().setParticle(ParticleInit.POISON_EXPLOSION).setSpread(15.0, 2.0, 15.0).setCount(15).setIgnoreRange(true);
            IParticleSpawner.spawnParticle(this.field_70170_p, config1, this.field_70165_t, this.field_70163_u, this.field_70161_v);
            this.func_184185_a(SoundInit.FLASK_EXPLODE, 1.0f, 0.8f + 0.4f * this.field_70146_Z.nextFloat());
            for (LivingEntity target : this.field_70170_p.func_72872_a(LivingEntity.class, this.func_174813_aQ().func_186662_g((double)radius))) {
                if (target.equals((Object)this.func_85052_h())) continue;
                target.func_70690_d(new PotionEffect(PotionInit.ULTRAHEAVY, 200, 2));
            }
            for (int i = -radius; i <= radius; ++i) {
                for (int j = -radius; j <= radius; ++j) {
                    if (i * i + j * j > radius * radius) continue;
                    BlockPos pos = this.func_180425_c().func_177982_a(i, 0, j);
                    if (this.field_70170_p.func_175623_d(pos) && this.field_70170_p.func_175665_u(pos.func_177977_b())) {
                        this.field_70170_p.func_175656_a(pos, BlockInit.acidicConcoctionGel.func_176223_P());
                        continue;
                    }
                    boolean found = false;
                    int dist = 0;
                    while (!found && dist < 5) {
                        ++dist;
                        if (this.field_70170_p.func_175623_d(pos) && this.field_70170_p.func_175665_u(pos.func_177977_b())) {
                            this.field_70170_p.func_175656_a(pos, BlockInit.acidicConcoctionGel.func_176223_P());
                            found = true;
                        }
                        if (this.field_70170_p.func_175623_d(pos) && this.field_70170_p.func_175623_d(pos.func_177977_b())) {
                            pos = pos.func_177977_b();
                            continue;
                        }
                        if (this.field_70170_p.func_175623_d(pos)) continue;
                        pos = pos.func_177984_a();
                    }
                }
            }
            this.func_70106_y();
        }
    }
}

