/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.HitResult
 *  net.minecraft.util.math.HitResult$Type
 *  net.minecraft.world.World
 */
package xol.lostinfinity.projectile.entity;

import java.util.Iterator;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.projectile.entity.EntityBallOfContainedGluons;
import xol.lostinfinity.projectile.entity.EntityBaseThrowable;
import xol.lostinfinity.util.data.CustomParticleConfig;
import xol.lostinfinity.util.fx.IParticleSpawner;

public class EntityBallOfContainedQuarks
extends EntityBaseThrowable {
    public EntityBallOfContainedQuarks(Level par1World) {
        super(par1World);
    }

    public EntityBallOfContainedQuarks(Level par1World, LivingEntity par2Mob) {
        super(par1World, par2Mob);
    }

    public EntityBallOfContainedQuarks(Level par1World, double par2, double par4, double par6) {
        super(par1World, par2, par4, par6);
    }

    @Override
    public void func_70071_h_() {
        block2: {
            super.func_70071_h_();
            if (this.field_70170_p.field_72995_K) break block2;
            double radius = 0.5;
            int reactionRadius = 2;
            AABB bb = new AABB(this.func_180425_c()).func_72314_b(radius, radius, radius);
            Iterator iterator = this.field_70170_p.func_72872_a(EntityBallOfContainedGluons.class, bb).iterator();
            if (iterator.hasNext()) {
                EntityBallOfContainedGluons gluons = (EntityBallOfContainedGluons)iterator.next();
                for (BlockPos pos : BlockPos.func_177980_a((BlockPos)this.func_180425_c().func_177982_a(-reactionRadius, -reactionRadius, -reactionRadius), (BlockPos)this.func_180425_c().func_177982_a(reactionRadius, reactionRadius, reactionRadius))) {
                    if (!this.field_70170_p.func_180495_p(pos).equals(BlockInit.atomiteOre.func_176203_a(0))) continue;
                    this.field_70170_p.func_175656_a(pos, BlockInit.atomiteOre.func_176203_a(1));
                }
                CustomParticleConfig config1 = new CustomParticleConfig();
                config1.setCount(3);
                config1.createInstance().setParticle(ParticleInit.EXPLOSION_BLUE).setSpread(5.0, 1.0, 5.0).setIgnoreRange(true);
                config1.createInstance().setParticle(ParticleInit.EXPLOSION_TEAL).setSpread(5.0, 1.0, 5.0).setIgnoreRange(true);
                CustomParticleConfig config2 = new CustomParticleConfig();
                config2.createInstance().setParticle(ParticleInit.MURK).setSpread(10.0, 2.0, 10.0).setCount(7).setIgnoreRange(true);
                IParticleSpawner.spawnParticle(this.field_70170_p, config1, this.field_70165_t, this.field_70163_u, this.field_70161_v);
                IParticleSpawner.spawnParticle(this.field_70170_p, config2, this.field_70165_t, this.field_70163_u, this.field_70161_v);
                this.func_184185_a(SoundInit.GENERIC_WEAPON_6, 1.0f, 0.8f + 0.4f * this.field_70146_Z.nextFloat());
                gluons.func_70106_y();
                this.func_70106_y();
            }
        }
    }

    protected float func_70185_h() {
        return 0.05f;
    }

    @Override
    protected void func_70184_a(HitResult result) {
        if (!this.field_70170_p.field_72995_K && result.field_72313_a == HitResult.Type.BLOCK) {
            this.func_70106_y();
        }
    }
}

