/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.entity.player.ServerPlayer
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.datasync.DataParameter
 *  net.minecraft.network.datasync.DataSerializer
 *  net.minecraft.network.datasync.DataSerializers
 *  net.minecraft.network.datasync.EntityDataManager
 *  net.minecraft.util.Direction
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.Vec3
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.misc;

import java.util.UUID;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializer;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.entity.mount.EntityJetMount;

public class EntityCourseRing
extends Entity {
    protected static final DataParameter<Direction> FACING = EntityDataManager.func_187226_a(EntityCourseRing.class, (DataSerializer)DataSerializers.field_187202_l);
    protected static final DataParameter<Integer> INDEX = EntityDataManager.func_187226_a(EntityCourseRing.class, (DataSerializer)DataSerializers.field_187192_b);
    protected static final DataParameter<Boolean> NEXT = EntityDataManager.func_187226_a(EntityCourseRing.class, (DataSerializer)DataSerializers.field_187198_h);
    private UUID ownerId = null;

    public EntityCourseRing(Level worldIn) {
        super(worldIn);
        this.func_70105_a(1.0f, 1.0f);
    }

    public void func_70030_z() {
        super.func_70030_z();
        if (!this.field_70170_p.field_72995_K && this.field_70173_aa > 10) {
            boolean found = false;
            for (ServerPlayer player : this.field_70170_p.func_73046_m().func_184103_al().func_181057_v()) {
                if (!player.func_110124_au().equals(this.ownerId)) continue;
                found = true;
            }
            if (!found) {
                this.func_70106_y();
            }
        }
        if (this.field_70170_p.field_72995_K && this.field_70173_aa % 10 == 0) {
            Vec3 rightDir;
            switch (this.getFacing()) {
                case WEST: {
                    rightDir = new Vec3(0.0, 0.0, -1.0);
                    break;
                }
                case NORTH: {
                    rightDir = new Vec3(1.0, 0.0, 0.0);
                    break;
                }
                case EAST: {
                    rightDir = new Vec3(0.0, 0.0, 1.0);
                    break;
                }
                case SOUTH: {
                    rightDir = new Vec3(-1.0, 0.0, 0.0);
                    break;
                }
                default: {
                    rightDir = new Vec3(-1.0, 0.0, 0.0);
                }
            }
            double radius = 3.0;
            for (double i = 0.0; i < Math.PI * 2; i += 0.2) {
                double x = rightDir.field_72450_a * Math.cos(i) * radius;
                double z = rightDir.field_72449_c * Math.cos(i) * radius;
                double y = Math.sin(i) * radius;
                if (this.getNext()) {
                    this.field_70170_p.func_175688_a(ParticleInit.LIGHT_FIZZLE, this.field_70165_t + x, this.field_70163_u + y, this.field_70161_v + z, (this.field_70146_Z.nextDouble() - 0.5) * 0.01, (this.field_70146_Z.nextDouble() - 0.5) * 0.01, (this.field_70146_Z.nextDouble() - 0.5) * 0.01, new int[0]);
                    continue;
                }
                this.field_70170_p.func_175688_a(ParticleInit.DARK_FIZZLE, this.field_70165_t + x, this.field_70163_u + y, this.field_70161_v + z, (this.field_70146_Z.nextDouble() - 0.5) * 0.01, (this.field_70146_Z.nextDouble() - 0.5) * 0.01, (this.field_70146_Z.nextDouble() - 0.5) * 0.01, new int[0]);
            }
        }
    }

    private Direction getFacing() {
        return (Direction)this.field_70180_af.func_187225_a(FACING);
    }

    private int getIndex() {
        return (Integer)this.field_70180_af.func_187225_a(INDEX);
    }

    public void func_70100_b_(Player entityIn) {
        Entity mount;
        super.func_70100_b_(entityIn);
        if (!this.field_70170_p.field_72995_K && !this.field_70128_L && (mount = entityIn.func_184208_bv()) instanceof EntityJetMount) {
            EntityJetMount jetMount = (EntityJetMount)mount;
            if (this.getNext()) {
                jetMount.progressCourse(entityIn);
                this.field_70170_p.func_184133_a(null, this.func_180425_c(), SoundInit.GAME_DING, SoundSource.PLAYERS, 1.0f, 0.8f + this.field_70146_Z.nextFloat() * 0.4f);
                this.func_70106_y();
            }
        }
    }

    protected void func_70088_a() {
        this.field_70180_af.func_187214_a(FACING, (Object)Direction.NORTH);
        this.field_70180_af.func_187214_a(INDEX, (Object)0);
        this.field_70180_af.func_187214_a(NEXT, (Object)false);
    }

    public void setFacing(Direction facing) {
        this.field_70180_af.func_187227_b(FACING, (Object)facing);
    }

    public void setIndex(int i) {
        this.field_70180_af.func_187227_b(INDEX, (Object)i);
    }

    protected void func_70037_a(CompoundTag compound) {
        this.ownerId = compound.func_186857_a("ownerID");
    }

    protected void func_70014_b(CompoundTag compound) {
        compound.func_186854_a("ownerID", this.ownerId);
    }

    private boolean getNext() {
        return (Boolean)this.field_70180_af.func_187225_a(NEXT);
    }

    public void setNext() {
        this.field_70180_af.func_187227_b(NEXT, (Object)true);
    }

    public void setOwner(Player owner) {
        this.ownerId = owner.func_110124_au();
    }
}

