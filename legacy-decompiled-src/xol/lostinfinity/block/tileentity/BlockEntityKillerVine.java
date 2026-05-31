/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.IEntityOwnable
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.NetworkManager
 *  net.minecraft.network.play.server.SPacketUpdateBlockEntity
 *  net.minecraft.tileentity.BlockEntity
 *  net.minecraft.util.ITickable
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3
 *  net.minecraft.world.World
 */
package xol.lostinfinity.block.tileentity;

import java.util.ArrayList;
import java.util.UUID;
import javax.annotation.Nullable;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.entity.IEntityOwnable;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.util.ITickable;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.Level;
import xol.lostinfinity.block.misc.BlockKillerVine;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.mob.entity.base.EntityImmaterial;
import xol.lostinfinity.util.data.IMaxAttack;

public class BlockEntityKillerVine
extends BlockEntity
implements ITickable,
IMaxAttack {
    private int ticks = 0;
    private boolean killer = false;
    private UUID placer = null;
    private ArrayList<VineNode> nodes = new ArrayList();

    public void func_73660_a() {
        ++this.ticks;
        if (this.killer) {
            int radius = 15;
            for (LivingEntity entity : this.field_145850_b.func_72872_a(LivingEntity.class, new AABB(this.field_174879_c.func_177982_a(-radius, -1, -radius), this.field_174879_c.func_177982_a(radius, radius, radius)))) {
                if (entity == null || entity.field_70128_L || entity instanceof EntityImmaterial || this.placer != null && this.placer.equals(entity.func_110124_au()) || entity instanceof IEntityOwnable && ((IEntityOwnable)entity).func_184753_b() != null && ((IEntityOwnable)entity).func_184753_b().equals(this.placer)) continue;
                ArrayList<VineNode> toRemove = new ArrayList<VineNode>();
                boolean found = false;
                int growth = 0;
                for (VineNode node : this.nodes) {
                    if (node.getEntity() == null || node.getEntity().field_70128_L) {
                        toRemove.add(node);
                        continue;
                    }
                    if (node.getEntity() != entity) continue;
                    node.grow();
                    growth = node.getGrowth();
                    found = true;
                    break;
                }
                this.nodes.removeAll(toRemove);
                if (!found) {
                    this.nodes.add(new VineNode(entity));
                }
                if (this.field_145850_b.field_72995_K || growth < 20) continue;
                double xDiff = -entity.field_70165_t + ((double)this.field_174879_c.func_177958_n() + 0.5);
                double yDiff = -entity.field_70163_u + ((double)this.field_174879_c.func_177956_o() + 1.0);
                double zDiff = -entity.field_70161_v + ((double)this.field_174879_c.func_177952_p() + 0.5);
                Vec3 pullDir = new Vec3(xDiff, yDiff, zDiff);
                pullDir = pullDir.func_72432_b();
                double dist = entity.func_174791_d().func_72438_d(new Vec3((double)this.field_174879_c.func_177958_n(), (double)this.field_174879_c.func_177956_o(), (double)this.field_174879_c.func_177952_p()));
                if (dist > 10.0) {
                    entity.func_70024_g(pullDir.field_72450_a / 3.0, pullDir.field_72448_b / 3.0 + 0.05, pullDir.field_72449_c / 3.0);
                } else {
                    entity.func_70024_g(pullDir.field_72450_a / 10.0, pullDir.field_72448_b / 10.0 + 0.05, pullDir.field_72449_c / 10.0);
                    if (dist < 3.0) {
                        if (this.placer != null) {
                            boolean killed;
                            Player placerPlayer = this.field_145850_b.func_152378_a(this.placer);
                            if (placerPlayer != null && (killed = IMaxAttack.dealTrueDamage((Entity)placerPlayer, entity, entity.func_110138_aP() * 0.1f).wasTargetKilled()) && entity instanceof Player) {
                                placerPlayer.func_191521_c(new ItemStack(ItemInit.entangledHeart));
                            }
                        } else {
                            IMaxAttack.dealPotionDamage(entity, entity.func_110138_aP() * 0.1f);
                        }
                    }
                }
                entity.field_70133_I = true;
            }
        }
        if (!this.field_145850_b.field_72995_K) {
            Player placerEntity;
            if (this.placer == null && (placerEntity = this.field_145850_b.func_184137_a((double)this.field_174879_c.func_177958_n(), (double)this.field_174879_c.func_177956_o(), (double)this.field_174879_c.func_177952_p(), 10.0, false)) != null) {
                this.placer = placerEntity.func_110124_au();
            }
            if (this.ticks % 10 == 0) {
                this.doBlockUpdate();
                if (!this.killer && ((BlockKillerVine)BlockInit.killerVine).getCropAge(this.field_145850_b.func_180495_p(this.field_174879_c)) == 7) {
                    this.killer = true;
                }
            }
        }
    }

    public boolean isKiller() {
        return this.killer;
    }

    public ArrayList<VineNode> getNodes() {
        return this.nodes;
    }

    public UUID getPlacer() {
        return this.getPlacer();
    }

    public CompoundTag func_189515_b(CompoundTag compound) {
        super.func_189515_b(compound);
        compound.func_74757_a("killer", this.killer);
        if (this.placer != null) {
            compound.func_186854_a("Placer", this.placer);
        }
        return compound;
    }

    public void func_145839_a(CompoundTag compound) {
        super.func_145839_a(compound);
        this.killer = compound.func_74767_n("killer");
        this.placer = compound.func_186857_a("Placer");
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

    protected void doBlockUpdate() {
        BlockState state = this.field_145850_b.func_180495_p(this.func_174877_v());
        this.field_145850_b.func_184138_a(this.func_174877_v(), state, state, 3);
    }

    public boolean shouldRefresh(Level world, BlockPos pos, BlockState oldState, BlockState newSate) {
        return world.func_180495_p(pos).func_177230_c() != BlockInit.killerVine;
    }

    public void setPlacer(Player placer) {
        this.placer = placer.func_110124_au();
    }

    public class VineNode {
        private LivingEntity entity;
        private int growth;

        public VineNode(LivingEntity entity) {
            this.entity = entity;
            this.growth = 0;
        }

        public LivingEntity getEntity() {
            return this.entity;
        }

        public int getGrowth() {
            return this.growth;
        }

        public void grow() {
            ++this.growth;
        }
    }
}

