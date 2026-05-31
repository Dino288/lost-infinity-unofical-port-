/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.util.math.HitResult
 *  net.minecraft.world.World
 */
package xol.lostinfinity.projectile.entity;

import java.util.Collections;
import java.util.List;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.level.Level;
import xol.lostinfinity.client.fx.ClientParticleRenderer;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.mob.entity.base.EntityImmaterial;
import xol.lostinfinity.projectile.entity.EntityBaseThrowable;
import xol.lostinfinity.util.data.CustomParticleConfig;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.fx.IParticleSpawner;

public class EntityGalaxyDragonFireball
extends EntityBaseThrowable {
    public EntityGalaxyDragonFireball(Level worldIn) {
        super(worldIn);
        this.func_70105_a(0.25f, 0.25f);
    }

    public EntityGalaxyDragonFireball(Level worldIn, double x, double y, double z) {
        super(worldIn, x, y, z);
        this.func_70105_a(0.25f, 0.25f);
    }

    @Override
    protected void func_70184_a(HitResult result) {
        if (this.field_70170_p.field_72995_K) {
            return;
        }
        switch (result.field_72313_a) {
            case BLOCK: {
                this.func_70106_y();
                break;
            }
            case ENTITY: {
                Entity hitResult = result.field_72308_g;
                if (hitResult == null) break;
                if (hitResult == this.field_70192_c || hitResult == this.getSecondaryThrower()) {
                    return;
                }
                this.func_70106_y();
                break;
            }
        }
        List entityList = this.field_70170_p.func_175647_a(LivingEntity.class, this.func_174813_aQ().func_186662_g(5.0), input -> !(input instanceof EntityImmaterial));
        for (Entity entity : entityList) {
            if (entity == this.field_70192_c || entity == this.getSecondaryThrower()) continue;
            IMaxAttack.dealTrueDamage((Entity)this, (LivingEntity)entity, ((LivingEntity)entity).func_110138_aP() * 0.5f, Collections.singletonList("Aquatic"));
        }
        CustomParticleConfig config = new CustomParticleConfig();
        config.setCount(10);
        config.createInstance().setParticle(ParticleInit.COSMIC_EXPLOSION_TYPE1).setSpread(10.0, 10.0, 10.0).setIgnoreRange(true);
        config.createInstance().setParticle(ParticleInit.COSMIC_EXPLOSION_TYPE2).setSpread(10.0, 10.0, 10.0).setIgnoreRange(true);
        config.createInstance().setParticle(ParticleInit.COSMIC_EXPLOSION_TYPE3).setSpread(10.0, 10.0, 10.0).setIgnoreRange(true);
        config.createInstance().setParticle(ParticleInit.COSMIC_EXPLOSION_TYPE4).setSpread(10.0, 10.0, 10.0).setIgnoreRange(true);
        IParticleSpawner.spawnParticle(this.field_70170_p, config, this.func_174791_d());
    }

    @Override
    public void func_70071_h_() {
        double mX = this.field_70159_w;
        double mY = this.field_70181_x;
        double mZ = this.field_70179_y;
        super.func_70071_h_();
        this.field_70159_w = mX;
        this.field_70181_x = mY;
        this.field_70179_y = mZ;
        if (this.field_70170_p.field_72995_K) {
            CustomParticleConfig config = new CustomParticleConfig();
            config.setOrigin(this.field_70165_t, this.field_70163_u, this.field_70161_v);
            config.createInstance().setParticle(ParticleInit.FLAME_LARGE).setCount(10).setSpread(0.5, 0.5, 0.5).setIgnoreRange(true);
            ClientParticleRenderer.renderComplex(config);
        }
    }

    protected float func_70185_h() {
        return 0.0f;
    }
}

