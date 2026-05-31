/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.base;

import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.mob.entity.base.EntityMultipleLives;
import xol.lostinfinity.util.data.IMaxAttack;

public class EntityDeviantTitan
extends EntityMultipleLives
implements IMaxAttack {
    public EntityDeviantTitan(Level worldIn) {
        super(worldIn);
    }

    protected AABB getArenaAABB() {
        return new AABB(new BlockPos(-493.0, 60.0, 407.0), new BlockPos(548.0, 85.0, 460.0));
    }

    protected boolean func_70692_ba() {
        return false;
    }

    @Override
    protected int numberOfLives() {
        return 25;
    }

    @Override
    public void trueDeathAction() {
        if (!this.field_70170_p.field_72995_K) {
            this.func_145779_a(ItemInit.arenaCard, 1);
        }
    }
}

