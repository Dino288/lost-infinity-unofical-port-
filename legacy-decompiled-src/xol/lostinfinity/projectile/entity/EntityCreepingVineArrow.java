/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.HitResult
 *  net.minecraft.util.math.Vec3
 *  net.minecraft.world.World
 */
package xol.lostinfinity.projectile.entity;

import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.projectile.entity.EntityBaseThrowable;
import xol.lostinfinity.projectile.entity.EntityCreepingVinePod;
import xol.lostinfinity.util.math.LMath;

public class EntityCreepingVineArrow
extends EntityBaseThrowable {
    private static final int POD_COUNT = 20;

    public EntityCreepingVineArrow(Level worldIn) {
        super(worldIn);
        this.func_70105_a(0.75f, 0.75f);
    }

    @Override
    protected void func_70184_a(HitResult result) {
        if (this.field_70170_p.field_72995_K) {
            return;
        }
        switch (result.field_72313_a) {
            case BLOCK: {
                this.spawnPods();
                break;
            }
            case ENTITY: {
                if (result.field_72308_g == this.field_70192_c) {
                    return;
                }
                this.spawnPods();
            }
        }
    }

    private void spawnPods() {
        this.field_70170_p.func_184133_a(null, this.func_180425_c(), SoundInit.SPLAT_EXPLODE, SoundSource.PLAYERS, 1.5f, 1.0f);
        for (int i = 0; i < 20; ++i) {
            EntityCreepingVinePod pod = new EntityCreepingVinePod(this.field_70170_p);
            pod.setThrower(this.field_70192_c);
            pod.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
            Vec3 randDir = LMath.fastNormalize(new Vec3((double)this.field_70146_Z.nextFloat() - 0.5, (double)this.field_70146_Z.nextFloat() - 0.5, (double)this.field_70146_Z.nextFloat() - 0.5));
            pod.setInitDirection(randDir);
            pod.func_70186_c(randDir.field_72450_a, randDir.field_72448_b, randDir.field_72449_c, 0.25f, 0.0f);
            this.field_70170_p.func_72838_d((Entity)pod);
        }
        this.func_70106_y();
    }
}

