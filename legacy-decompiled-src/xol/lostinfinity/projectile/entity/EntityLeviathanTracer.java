/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.util.math.HitResult
 *  net.minecraft.util.math.HitResult$Type
 *  net.minecraft.util.math.Vec3
 *  net.minecraft.world.World
 */
package xol.lostinfinity.projectile.entity;

import java.util.Collections;
import java.util.List;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.mob.entity.sea.leviathan.EntityLeviathanController;
import xol.lostinfinity.mob.entity.sea.leviathan.EntityLeviathanSegment;
import xol.lostinfinity.projectile.entity.EntityBaseThrowable;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.math.LMath;

public class EntityLeviathanTracer
extends EntityBaseThrowable {
    private static final List<String> DAMAGE_TYPE = Collections.singletonList("Aquatic");
    private final Entity target;
    private EntityLeviathanController leviathanController;

    public EntityLeviathanTracer(Level worldIn) {
        super(worldIn);
        this.func_70105_a(0.5f, 0.5f);
        this.target = null;
    }

    public void setLeviathanThrower(EntityLeviathanController throwset) {
        super.setThrower((LivingEntity)throwset);
        this.leviathanController = throwset;
    }

    public EntityLeviathanTracer(Level worldIn, double x, double y, double z, Entity target) {
        super(worldIn, x, y, z);
        this.func_70105_a(0.5f, 0.5f);
        this.target = target;
    }

    @Override
    protected void func_70184_a(HitResult result) {
        int id;
        if (this.field_70170_p.field_72995_K) {
            return;
        }
        if (result.field_72313_a == HitResult.Type.BLOCK || !(result.field_72308_g instanceof LivingEntity)) {
            return;
        }
        LivingEntity hit = (LivingEntity)result.field_72308_g;
        if (hit == this.leviathanController) {
            return;
        }
        if (hit instanceof EntityLeviathanSegment && this.leviathanController.segments[id = ((EntityLeviathanSegment)hit).getId()] == hit) {
            return;
        }
        IMaxAttack.dealMaxHealth((Entity)(this.leviathanController != null ? this.leviathanController : this), hit, 1, DAMAGE_TYPE);
        this.func_70106_y();
    }

    @Override
    public void func_70071_h_() {
        super.func_70071_h_();
        if (this.field_70170_p.field_72995_K) {
            this.field_70170_p.func_175682_a(ParticleInit.ION_FUEL, true, this.field_70165_t, this.field_70163_u, this.field_70161_v, 0.0, 0.0, 0.0, new int[0]);
        } else if (this.field_70173_aa > 140 || this.leviathanController == null) {
            this.func_70106_y();
            return;
        }
        if (this.target == null) {
            return;
        }
        if (this.target.field_70128_L || this.field_70173_aa < 40) {
            return;
        }
        this.field_70159_w *= 0.95;
        this.field_70181_x *= 0.95;
        this.field_70179_y *= 0.95;
        Vec3 dir = LMath.fastNormalize(LMath.getEntityMiddle(this.target).func_178788_d(this.func_174791_d())).func_186678_a(0.2);
        this.func_70024_g(dir.field_72450_a, dir.field_72448_b, dir.field_72449_c);
    }

    protected float func_70185_h() {
        return 0.0f;
    }
}

