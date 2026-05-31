/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.NetworkManager
 *  net.minecraft.network.play.server.SPacketUpdateBlockEntity
 *  net.minecraft.tileentity.BlockEntity
 *  net.minecraft.util.ITickable
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3
 *  net.minecraft.util.math.Vec3i
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.block.tileentity;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import javax.annotation.Nullable;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.util.ITickable;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.Vec3;
import net.minecraft.core.Vec3i;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.util.data.CustomHitResult;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.data.RayTraceBuilder;
import xol.lostinfinity.util.math.LMath;

public class BlockEntityTeslaTower
extends BlockEntity
implements ITickable {
    private static final double RANGE = 40.0;
    private final Set<BlockPos> others = new HashSet<BlockPos>();
    private final Set<BlockPos> connected = new HashSet<BlockPos>();
    private int towerId;
    private UUID owner;
    private boolean active;
    private int tickExisted;
    private boolean pendingUpdate;
    private int random1;
    private int random2;
    private float random3;

    public void func_73660_a() {
        if (this.tickExisted == 1200) {
            this.field_145850_b.func_175698_g(this.func_174877_v());
            return;
        }
        if (this.shouldRefresh()) {
            this.pendingUpdate = false;
            this.updateConnected();
        }
        if (!this.field_145850_b.field_72995_K && this.tickExisted % 5 == 0 && this.active) {
            this.zapEntities();
        }
        ++this.tickExisted;
        this.random1 = this.field_145850_b.field_73012_v.nextInt(19);
        this.random2 = this.field_145850_b.field_73012_v.nextInt(7);
        this.random3 = this.field_145850_b.field_73012_v.nextFloat();
    }

    public void setTowerId(int towerId) {
        this.towerId = towerId;
    }

    public int getTowerId() {
        return this.towerId;
    }

    public int getRandom1() {
        return this.random1;
    }

    public int getRandom2() {
        return this.random2;
    }

    public float getRandom3() {
        return this.random3;
    }

    public void setOwner(UUID owner) {
        this.owner = owner;
    }

    public void setOthers(Set<BlockPos> set) {
        this.others.clear();
        this.others.addAll(set);
        this.others.remove(this.func_174877_v());
        this.updateConnected();
    }

    public void setActive(boolean state) {
        this.active = state;
        if (this.active) {
            this.field_145850_b.func_184133_a(null, this.field_174879_c, SoundInit.ELECTRIC_SHOCK, SoundSource.BLOCKS, 1.0f, 1.0f);
        }
    }

    public boolean isActive() {
        return this.active;
    }

    public void doBlockUpdate() {
        BlockState blockState = this.field_145850_b.func_180495_p(this.func_174877_v());
        this.field_145850_b.func_184138_a(this.func_174877_v(), blockState, blockState, 3);
    }

    public Set<BlockPos> getConnected() {
        return this.connected;
    }

    public int getTickExisted() {
        return this.tickExisted;
    }

    public void func_145839_a(CompoundTag compound) {
        super.func_145839_a(compound);
        this.towerId = compound.func_74762_e("tower_id");
        this.tickExisted = compound.func_74762_e("age");
        this.owner = compound.func_186857_a("owner");
        this.active = compound.func_74767_n("active");
        this.readOthers(compound);
    }

    public CompoundTag func_189515_b(CompoundTag compound) {
        super.func_189515_b(compound);
        compound.func_74768_a("tower_id", this.towerId);
        compound.func_74768_a("age", this.tickExisted);
        if (this.owner != null) {
            compound.func_186854_a("owner", this.owner);
        }
        compound.func_74757_a("active", this.active);
        this.writeOthers(compound);
        return compound;
    }

    @SideOnly(value=Side.CLIENT)
    public AABB getRenderBoundingBox() {
        return INFINITE_EXTENT_AABB;
    }

    private boolean shouldRefresh() {
        for (BlockPos pos : this.connected) {
            if (this.field_145850_b.func_180495_p(pos) == BlockInit.teslaTower.func_176223_P()) continue;
            return true;
        }
        return this.pendingUpdate || this.tickExisted % 100 == 0;
    }

    private void updateConnected() {
        this.connected.clear();
        for (BlockPos pos : this.others) {
            if (!(pos.func_177951_i((Vec3i)this.func_174877_v()) <= 1600.0) || !(this.field_145850_b.func_175625_s(pos) instanceof BlockEntityTeslaTower)) continue;
            this.connected.add(pos);
        }
    }

    private void zapEntities() {
        Player player = null;
        if (this.owner != null) {
            player = this.field_145850_b.func_152378_a(this.owner);
        }
        for (BlockPos other : this.connected) {
            Vec3 loc = new Vec3((double)this.field_174879_c.func_177958_n() + 0.5, (double)this.field_174879_c.func_177956_o() + 0.5, (double)this.field_174879_c.func_177952_p() + 0.5);
            Vec3 dir = LMath.fastNormalize(new Vec3((double)(other.func_177958_n() - this.field_174879_c.func_177958_n()), (double)(other.func_177956_o() - this.field_174879_c.func_177956_o()), (double)(other.func_177952_p() - this.field_174879_c.func_177952_p())));
            CustomHitResult result = RayTraceBuilder.entity(LivingEntity.class, 40).maxEntity(0).trace(this.field_145850_b, null, loc.func_178787_e(dir), dir);
            if (result == null) continue;
            for (Entity entity : result.getResultEntities()) {
                if (!(entity instanceof LivingEntity) || entity == player) continue;
                IMaxAttack.dealTrueDamage((Entity)player, (LivingEntity)entity, ((LivingEntity)entity).func_110138_aP() * 0.05f);
            }
        }
    }

    private void readOthers(CompoundTag compound) {
        this.others.clear();
        int id = 0;
        while (compound.func_74764_b("pos_x_" + id)) {
            this.others.add(new BlockPos(compound.func_74762_e("pos_x_" + id), compound.func_74762_e("pos_y_" + id), compound.func_74762_e("pos_z_" + id)));
            ++id;
        }
    }

    private void writeOthers(CompoundTag compound) {
        int i = 0;
        for (BlockPos pos : this.others) {
            compound.func_74768_a("pos_x_" + i, pos.func_177958_n());
            compound.func_74768_a("pos_y_" + i, pos.func_177956_o());
            compound.func_74768_a("pos_z_" + i, pos.func_177952_p());
            ++i;
        }
    }

    public CompoundTag func_189517_E_() {
        return this.func_189515_b(new CompoundTag());
    }

    @Nullable
    public SPacketUpdateBlockEntity func_189518_D_() {
        return new SPacketUpdateBlockEntity(this.field_174879_c, 0, this.func_189517_E_());
    }

    public void onDataPacket(NetworkManager net, SPacketUpdateBlockEntity pkt) {
        this.func_145839_a(pkt.func_148857_g());
        this.updateConnected();
    }
}

