/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.util.math.HitResult
 *  net.minecraft.util.math.Vec3
 *  net.minecraft.world.World
 */
package xol.lostinfinity.projectile.entity;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.mob.entity.sea.leviathan.EntityLeviathanController;
import xol.lostinfinity.mob.entity.sea.leviathan.EntityLeviathanSegment;
import xol.lostinfinity.projectile.entity.EntityBaseThrowable;
import xol.lostinfinity.util.data.CustomParticleConfig;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.fx.IParticleSpawner;
import xol.lostinfinity.util.math.LMath;

public class EntityLeviathanTeslaOrb
extends EntityBaseThrowable {
    private static final List<String> DAMAGE_TYPE = Collections.singletonList("Aquatic");
    private final Map<Entity, Long> hitCooldown = new ConcurrentHashMap<Entity, Long>();
    private EntityLeviathanController leviathanController;

    public EntityLeviathanTeslaOrb(Level worldIn) {
        super(worldIn);
        this.func_70105_a(0.5f, 0.5f);
    }

    public EntityLeviathanTeslaOrb(Level worldIn, double x, double y, double z) {
        super(worldIn, x, y, z);
        this.func_70105_a(0.5f, 0.5f);
    }

    public void setLeviathanThrower(EntityLeviathanController throwset) {
        super.setThrower((LivingEntity)throwset);
        this.leviathanController = throwset;
    }

    @Override
    protected void func_70184_a(HitResult result) {
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
        if (!this.field_70170_p.field_72995_K) {
            if (this.field_70173_aa % 20 != 0 || this.leviathanController == null) {
                return;
            }
            List list = this.field_70170_p.func_175674_a((Entity)this, this.func_174813_aQ().func_186662_g(10.0), input -> {
                if (input == this.leviathanController) {
                    return false;
                }
                if (input instanceof EntityLeviathanSegment) {
                    int id = ((EntityLeviathanSegment)input).getId();
                    return this.leviathanController.segments[id] != input;
                }
                return true;
            });
            CustomParticleConfig config = new CustomParticleConfig();
            config.createInstance().setParticle(ParticleInit.GOLDEN_MAGIC).setIgnoreRange(true);
            for (Entity entity : list) {
                if (!(entity instanceof LivingEntity)) continue;
                LivingEntity hit = (LivingEntity)entity;
                IMaxAttack.dealTrueDamage((Entity)this.leviathanController, hit, hit.func_110138_aP() * 0.2f, DAMAGE_TYPE);
                for (int i = 1; i <= 10; ++i) {
                    Vec3 vec = LMath.lerp(LMath.getEntityMiddle((Entity)this), LMath.getEntityMiddle((Entity)hit), (double)((float)i / 10.0f));
                    IParticleSpawner.spawnParticle(this.field_70170_p, config, vec.field_72450_a, vec.field_72448_b, vec.field_72449_c);
                }
            }
        }
    }

    protected float func_70185_h() {
        return 0.0f;
    }
}

