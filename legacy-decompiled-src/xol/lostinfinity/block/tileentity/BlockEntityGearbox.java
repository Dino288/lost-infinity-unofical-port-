/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.NetworkManager
 *  net.minecraft.network.play.server.SPacketUpdateBlockEntity
 *  net.minecraft.tileentity.BlockEntity
 *  net.minecraft.util.ITickable
 *  net.minecraft.util.SoundSource
 */
package xol.lostinfinity.block.tileentity;

import java.util.ArrayList;
import javax.annotation.Nullable;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.util.ITickable;
import net.minecraft.sounds.SoundSource;
import xol.lostinfinity.block.tileentity.IMachine;
import xol.lostinfinity.block.tileentity.BlockEntityCombustionEngine;

public class BlockEntityGearbox
extends BlockEntity
implements IMachine,
ITickable {
    private int[] pegPositions = new int[6];
    private int[] gears = new int[6];
    private int[] placedGears = new int[6];
    private boolean active = false;
    private int ticks = 0;

    @Override
    public boolean getPowered() {
        ArrayList connectedMachines = this.getConnectedMachines(this, null);
        for (IMachine machine : connectedMachines) {
            if (!(machine instanceof BlockEntityCombustionEngine)) continue;
            return machine.getPowered();
        }
        return false;
    }

    public void setActive(boolean active) {
        if (!this.active && active) {
            this.field_145850_b.func_184133_a(null, this.func_174877_v(), SoundEvents.field_187692_g, SoundSource.BLOCKS, 1.5f, 1.0f);
        }
        this.active = active;
    }

    public int[] getPlacedGears() {
        return this.placedGears;
    }

    public void setPlacedGears(int[] placedGears) {
        this.placedGears = placedGears;
    }

    public void func_73660_a() {
        if (this.field_145850_b.field_72995_K && this.pegPositions[1] == 0) {
            this.pegPositions[0] = 0;
            int curPos = 0;
            int curGear = 0;
            for (int i = 0; i < this.gears.length; ++i) {
                int newGear;
                if (curGear == 0) {
                    this.gears[0] = curGear = this.field_145850_b.field_73012_v.nextInt(5) + 2;
                    continue;
                }
                this.gears[i] = newGear = this.field_145850_b.field_73012_v.nextInt(5) + 2;
                curGear = newGear;
                this.pegPositions[i] = curPos += newGear + curGear + 1;
            }
        }
        if (!this.field_145850_b.field_72995_K) {
            ++this.ticks;
            if (this.ticks % 10 == 0) {
                this.doBlockUpdate();
            }
        }
    }

    public int[] getGears() {
        return this.gears;
    }

    public int[] getPegPositions() {
        return this.pegPositions;
    }

    public void func_145839_a(CompoundTag compound) {
        super.func_145839_a(compound);
        this.active = compound.func_74767_n("active");
    }

    public CompoundTag func_189515_b(CompoundTag compound) {
        compound.func_74757_a("active", this.active);
        return super.func_189515_b(compound);
    }

    public boolean getActive() {
        return this.active;
    }

    @Nullable
    public SPacketUpdateBlockEntity func_189518_D_() {
        return new SPacketUpdateBlockEntity(this.func_174877_v(), 0, this.func_189517_E_());
    }

    public CompoundTag func_189517_E_() {
        return this.func_189515_b(new CompoundTag());
    }

    public void onDataPacket(NetworkManager net, SPacketUpdateBlockEntity pkt) {
        this.handleUpdateTag(pkt.func_148857_g());
    }

    private void doBlockUpdate() {
        BlockState state = this.field_145850_b.func_180495_p(this.func_174877_v());
        this.field_145850_b.func_184138_a(this.func_174877_v(), state, state, 3);
    }
}

