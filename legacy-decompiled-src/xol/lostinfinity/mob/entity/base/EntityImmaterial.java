/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Mob
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.base;

import net.minecraft.world.entity.Mob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.level.Level;

public class EntityImmaterial
extends Mob {
    public EntityImmaterial(Level worldIn) {
        super(worldIn);
        this.func_184224_h(true);
        this.func_189654_d(true);
    }

    public void func_70636_d() {
        super.func_70636_d();
        if (!this.field_70170_p.field_72995_K && !this.field_70128_L) {
            this.func_70674_bp();
            this.func_70606_j(Float.MAX_VALUE);
        }
    }

    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.0);
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(10000.0);
    }

    public boolean func_70067_L() {
        return false;
    }

    public boolean func_70104_M() {
        return false;
    }

    public boolean func_70601_bi() {
        return true;
    }

    protected boolean func_70692_ba() {
        return false;
    }
}

