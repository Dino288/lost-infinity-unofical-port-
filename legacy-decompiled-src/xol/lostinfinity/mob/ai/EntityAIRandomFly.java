/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Mob
 *  net.minecraft.entity.ai.EntityAIBase
 *  net.minecraft.entity.ai.EntityMoveHelper
 */
package xol.lostinfinity.mob.ai;

import java.util.Random;
import net.minecraft.world.entity.Mob;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityMoveHelper;

public class EntityAIRandomFly
extends EntityAIBase {
    private final Mob parentEntity;

    public EntityAIRandomFly(Mob ghast) {
        this.parentEntity = ghast;
        this.func_75248_a(1);
    }

    public boolean func_75250_a() {
        double d2;
        double d1;
        EntityMoveHelper entitymovehelper = this.parentEntity.func_70605_aq();
        if (!entitymovehelper.func_75640_a()) {
            return true;
        }
        double d0 = entitymovehelper.func_179917_d() - this.parentEntity.field_70165_t;
        double d3 = d0 * d0 + (d1 = entitymovehelper.func_179919_e() - this.parentEntity.field_70163_u) * d1 + (d2 = entitymovehelper.func_179918_f() - this.parentEntity.field_70161_v) * d2;
        return d3 < 1.0 || d3 > 3600.0;
    }

    public boolean func_75253_b() {
        return false;
    }

    public void func_75249_e() {
        Random random = this.parentEntity.func_70681_au();
        double d0 = this.parentEntity.field_70165_t + (double)((random.nextFloat() * 2.0f - 1.0f) * 16.0f);
        double d1 = this.parentEntity.field_70163_u + (double)((random.nextFloat() * 2.0f - 1.0f) * 16.0f);
        double d2 = this.parentEntity.field_70161_v + (double)((random.nextFloat() * 2.0f - 1.0f) * 16.0f);
        this.parentEntity.func_70605_aq().func_75642_a(d0, d1, d2, 1.0);
    }
}

