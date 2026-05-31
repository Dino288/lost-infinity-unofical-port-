/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Optional
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.datasync.DataParameter
 *  net.minecraft.network.datasync.DataSerializer
 *  net.minecraft.network.datasync.DataSerializers
 *  net.minecraft.network.datasync.EntityDataManager
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.misc;

import com.google.common.base.Optional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializer;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.level.Level;
import xol.lostinfinity.mob.entity.base.EntityImmaterial;
import xol.lostinfinity.mob.entity.base.EntityMultipleLives;
import xol.lostinfinity.util.data.IMaxAttack;

public class EntityRisingPhantom
extends EntityImmaterial {
    private List<LivingEntity> hitTargets = new ArrayList<LivingEntity>();
    private static final DataParameter<Optional<UUID>> OWNER = EntityDataManager.func_187226_a(EntityRisingPhantom.class, (DataSerializer)DataSerializers.field_187203_m);
    private static final DataParameter<Float> VELOCITY = EntityDataManager.func_187226_a(EntityRisingPhantom.class, (DataSerializer)DataSerializers.field_187193_c);
    private int livesTaken = 0;
    private Player owner;
    private float faceRotation = 0.0f;

    public EntityRisingPhantom(Level world) {
        this(world, null);
    }

    public EntityRisingPhantom(Level worldIn, Player owner) {
        super(worldIn);
        this.func_70105_a(2.75f, 1.75f);
        this.func_184224_h(true);
        this.owner = owner;
        this.setOwner(owner == null ? null : owner.func_110124_au());
    }

    public float getFaceRotation() {
        return this.faceRotation;
    }

    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a(OWNER, (Object)Optional.absent());
        this.field_70180_af.func_187214_a(VELOCITY, (Object)Float.valueOf(0.0f));
    }

    public void setLivesTaken(int toTake) {
        this.livesTaken = toTake;
    }

    public void func_70071_h_() {
        this.field_70145_X = true;
        super.func_70071_h_();
        this.field_70145_X = false;
        this.func_189654_d(true);
    }

    public boolean func_70075_an() {
        return false;
    }

    @Override
    public void func_70636_d() {
        this.field_70759_as = this.field_70177_z;
        this.field_70761_aq = this.field_70177_z;
        super.func_70636_d();
        if (!this.field_70170_p.field_72995_K) {
            if (this.field_70173_aa > 80) {
                this.func_70106_y();
                return;
            }
            this.field_70181_x = this.getVelocity();
            this.field_70133_I = true;
        } else if ((double)this.faceRotation < 1.5707963267948966) {
            this.faceRotation += 0.02f;
        }
    }

    protected void func_82167_n(Entity entityIn) {
        LivingEntity collided;
        if (this.field_70170_p.field_72995_K) {
            return;
        }
        if (entityIn instanceof LivingEntity && !(entityIn instanceof EntityRisingPhantom) && !entityIn.equals((Object)this.owner) && !this.hitTargets.contains(collided = (LivingEntity)entityIn)) {
            this.hitTargets.add(collided);
            if (!IMaxAttack.dealTrueDamage((Entity)this.owner, collided, collided.func_110138_aP() * 1.5f, Arrays.asList("Darkborn")).wasTargetKilled() && collided instanceof EntityMultipleLives) {
                EntityMultipleLives multiLifer = (EntityMultipleLives)collided;
                multiLifer.takeawayNumLives(this.livesTaken);
            }
        }
    }

    public void func_70014_b(CompoundTag tag) {
        super.func_70014_b(tag);
        tag.func_186854_a("phantom_owner", this.getOwner());
        tag.func_74776_a("init_velocity", this.getVelocity());
    }

    public void func_70037_a(CompoundTag tag) {
        super.func_70037_a(tag);
        this.setOwner(tag.func_186857_a("phantom_owner"));
        this.setVelocity(tag.func_74760_g("init_velocity"));
        this.owner = this.getOwnerEntity();
    }

    public UUID getOwner() {
        return (UUID)((Optional)this.field_70180_af.func_187225_a(OWNER)).orNull();
    }

    public Player getOwnerEntity() {
        UUID uuid = this.getOwner();
        if (uuid == null) {
            return null;
        }
        return this.field_70170_p.func_152378_a(uuid);
    }

    public void setOwner(UUID uuid) {
        this.field_70180_af.func_187227_b(OWNER, (Object)Optional.fromNullable((Object)uuid));
    }

    public float getVelocity() {
        return ((Float)this.field_70180_af.func_187225_a(VELOCITY)).floatValue();
    }

    public void setVelocity(float vel) {
        this.field_70180_af.func_187227_b(VELOCITY, (Object)Float.valueOf(vel));
    }
}

