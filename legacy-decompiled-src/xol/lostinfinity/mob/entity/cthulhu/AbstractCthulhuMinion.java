/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.cthulhu;

import net.minecraft.world.entity.Entity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.Level;
import xol.lostinfinity.mob.entity.base.EntityMultipleLives;
import xol.lostinfinity.mob.entity.cthulhu.EntityCthulhu;
import xol.lostinfinity.mob.entity.cthulhu.ICthulhuMinion;

public abstract class AbstractCthulhuMinion
extends EntityMultipleLives
implements ICthulhuMinion {
    protected EntityCthulhu owner;

    public AbstractCthulhuMinion(Level worldIn) {
        super(worldIn);
    }

    @Override
    protected void func_184651_r() {
    }

    @Override
    public void setOwner(EntityCthulhu owner) {
        this.owner = owner;
    }

    @Override
    public EntityCthulhu getOwner() {
        return this.owner;
    }

    @Override
    public void func_70014_b(CompoundTag tag) {
        super.func_70014_b(tag);
        this.write(tag);
    }

    @Override
    public void func_70037_a(CompoundTag tag) {
        super.func_70037_a(tag);
        this.read(tag, (Entity)this);
    }

    protected boolean func_70692_ba() {
        return false;
    }
}

