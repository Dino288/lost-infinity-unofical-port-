/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.nbt.CompoundTag
 */
package xol.lostinfinity.mob.entity.cthulhu;

import java.util.UUID;
import net.minecraft.world.entity.Entity;
import net.minecraft.nbt.CompoundTag;
import xol.lostinfinity.mob.entity.cthulhu.EntityCthulhu;

public interface ICthulhuMinion {
    public void setOwner(EntityCthulhu var1);

    public EntityCthulhu getOwner();

    default public void write(CompoundTag tag) {
        if (this.getOwner() != null) {
            tag.func_186854_a("owner", this.getOwner().func_110124_au());
        }
    }

    default public void read(CompoundTag tag, Entity minion) {
        if (minion.field_70170_p.field_72995_K) {
            return;
        }
        UUID uuid = tag.func_186857_a("owner");
        if (uuid == null) {
            return;
        }
        Entity entity = minion.field_70170_p.func_73046_m().func_175576_a(uuid);
        if (entity instanceof EntityCthulhu) {
            this.setOwner((EntityCthulhu)entity);
            this.getOwner().registerMinion(minion);
        }
    }
}

