/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.tileentity.BlockEntity
 */
package xol.lostinfinity.block.tileentity;

import java.util.UUID;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntity;

public class BlockEntityGenerator
extends BlockEntity {
    private UUID myPlacer = null;

    public void func_145839_a(CompoundTag compound) {
        if (compound != null && compound.func_186855_b("teplace")) {
            this.myPlacer = compound.func_186857_a("teplace");
        }
        super.func_145839_a(compound);
    }

    public CompoundTag func_189515_b(CompoundTag compound) {
        if (compound == null) {
            compound = new CompoundTag();
        }
        UUID uuid = this.myPlacer == null ? UUID.fromString("00000000-0000-0000-0000-000000000000") : this.myPlacer;
        compound.func_186854_a("teplace", uuid);
        return super.func_189515_b(compound);
    }

    public void setMyPlacer(UUID the_id) {
        this.myPlacer = the_id;
        this.func_70296_d();
    }

    public UUID getMyPlacer() {
        return this.myPlacer;
    }
}

