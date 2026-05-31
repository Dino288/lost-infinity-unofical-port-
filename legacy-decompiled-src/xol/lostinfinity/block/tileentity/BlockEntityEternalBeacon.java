/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.NetworkManager
 *  net.minecraft.network.play.server.SPacketUpdateBlockEntity
 *  net.minecraft.util.ITickable
 *  net.minecraft.util.math.AABB
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.block.tileentity;

import javax.annotation.Nullable;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateBlockEntity;
import net.minecraft.util.ITickable;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.block.tileentity.BlockEntityGenerator;

public class BlockEntityEternalBeacon
extends BlockEntityGenerator
implements ITickable {
    private int tickRemaining;
    private int activeTick;
    private int radius;

    public void func_73660_a() {
        ++this.activeTick;
        if (this.tickRemaining > 0) {
            --this.tickRemaining;
        }
    }

    public int getTickRemaining() {
        return this.tickRemaining;
    }

    public int getActiveTick() {
        return this.activeTick;
    }

    public void setTickRemaining(int tickRemaining) {
        this.tickRemaining = tickRemaining;
    }

    public int getRadius() {
        return this.radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @SideOnly(value=Side.CLIENT)
    public AABB getRenderBoundingBox() {
        return INFINITE_EXTENT_AABB;
    }

    @SideOnly(value=Side.CLIENT)
    public double func_145833_n() {
        return 65536.0;
    }

    @Nullable
    public SPacketUpdateBlockEntity func_189518_D_() {
        return new SPacketUpdateBlockEntity(this.field_174879_c, 0, this.func_189517_E_());
    }

    public CompoundTag func_189517_E_() {
        CompoundTag compound = new CompoundTag();
        compound.func_74768_a("tick", this.tickRemaining);
        compound.func_74768_a("radius", this.radius);
        return compound;
    }

    public void onDataPacket(NetworkManager net, SPacketUpdateBlockEntity pkt) {
        this.handleUpdateTag(pkt.func_148857_g());
    }

    public void handleUpdateTag(CompoundTag tag) {
        this.tickRemaining = tag.func_74762_e("tick");
        this.radius = tag.func_74762_e("radius");
    }

    public void doBlockUpdate() {
        BlockState blockState = this.field_145850_b.func_180495_p(this.func_174877_v());
        this.field_145850_b.func_184138_a(this.func_174877_v(), blockState, blockState, 3);
    }
}

