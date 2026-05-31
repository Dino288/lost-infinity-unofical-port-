/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.player.Player
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.datasync.DataParameter
 *  net.minecraft.network.datasync.DataSerializer
 *  net.minecraft.network.datasync.DataSerializers
 *  net.minecraft.network.datasync.EntityDataManager
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.Vec3
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.misc;

import java.util.UUID;
import net.minecraft.world.entity.player.Player;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializer;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.entity.base.EntityImmaterial;

public class EntityBaseCannon
extends EntityImmaterial {
    private static final DataParameter<Integer> ROTATION = EntityDataManager.func_187226_a(EntityBaseCannon.class, (DataSerializer)DataSerializers.field_187192_b);
    private UUID ownerID = null;
    private Player owner = null;
    private Vec3 homePos = null;

    public EntityBaseCannon(Level worldIn) {
        super(worldIn);
        this.func_70105_a(1.0f, 1.75f);
    }

    protected void func_70088_a() {
        super.func_70088_a();
        this.func_184224_h(true);
        this.field_70765_h = null;
        this.field_70767_i = null;
        this.field_70180_af.func_187214_a(ROTATION, (Object)-1);
    }

    public void setHomePos(Vec3 homePos) {
        this.homePos = homePos;
    }

    protected void func_184651_r() {
    }

    public int getRotationMulti() {
        return (Integer)this.field_70180_af.func_187225_a(ROTATION);
    }

    public float getRotation() {
        return (float)((double)((Integer)this.field_70180_af.func_187225_a(ROTATION)).intValue() * Math.PI / 8.0);
    }

    public void setRotation(int i) {
        this.field_70180_af.func_187227_b(ROTATION, (Object)i);
    }

    public void setOwner(Player play) {
        this.owner = play;
    }

    public Player getOwner() {
        return this.owner;
    }

    @Override
    public void func_70636_d() {
        super.func_70636_d();
        this.field_70143_R = -1.0f;
        this.field_70177_z = 0.0f;
        if (!this.field_70170_p.field_72995_K) {
            Player player;
            if (this.homePos != null && !this.func_174791_d().equals((Object)this.homePos)) {
                this.func_70634_a(this.homePos.field_72450_a, this.homePos.field_72448_b, this.homePos.field_72449_c);
            }
            if (this.owner == null && this.ownerID != null && (player = this.field_70170_p.func_152378_a(this.ownerID)) != null) {
                this.owner = player;
            }
            if (this.field_70173_aa >= 900) {
                this.func_70106_y();
            }
        }
    }

    public void func_70014_b(CompoundTag compound) {
        super.func_70014_b(compound);
        if (this.owner != null) {
            compound.func_186854_a("ownerID", this.owner.func_110124_au());
        }
        if (this.homePos != null) {
            compound.func_74780_a("homeX", this.homePos.field_72450_a);
            compound.func_74780_a("homeY", this.homePos.field_72448_b);
            compound.func_74780_a("homeZ", this.homePos.field_72449_c);
        }
    }

    public void func_70037_a(CompoundTag compound) {
        super.func_70037_a(compound);
        if (compound.func_186855_b("ownerID")) {
            this.ownerID = compound.func_186857_a("ownerID");
        }
        this.homePos = compound.func_74764_b("homeX") ? new Vec3(compound.func_74769_h("homeX"), compound.func_74769_h("homeY"), compound.func_74769_h("homeZ")) : this.func_174791_d();
    }

    protected boolean func_184645_a(Player player, InteractionHand hand) {
        if (!this.field_70170_p.field_72995_K && this.owner != null && player.func_110124_au().equals(this.owner.func_110124_au())) {
            if (player.func_70093_af()) {
                this.func_70106_y();
            } else {
                int rotation = this.getRotationMulti();
                if (++rotation == 16) {
                    rotation = 0;
                }
                this.setRotation(rotation);
                this.field_70170_p.func_184133_a(null, this.func_180425_c(), SoundInit.GEAR_MACHINE, SoundSource.PLAYERS, 1.0f, 0.8f + 0.4f * this.field_70146_Z.nextFloat());
            }
        }
        return true;
    }

    @Override
    public boolean func_70067_L() {
        return true;
    }
}

