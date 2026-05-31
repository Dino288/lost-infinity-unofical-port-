/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Optional
 *  javax.annotation.Nullable
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.PathfinderMob
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.IEntityOwnable
 *  net.minecraft.entity.ai.EntityAIBase
 *  net.minecraft.entity.ai.EntityAIHurtByTarget
 *  net.minecraft.entity.ai.EntityAINearestAttackableTarget
 *  net.minecraft.entity.player.Player
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.datasync.DataParameter
 *  net.minecraft.network.datasync.DataSerializer
 *  net.minecraft.network.datasync.DataSerializers
 *  net.minecraft.network.datasync.EntityDataManager
 *  net.minecraft.scoreboard.Team
 *  net.minecraft.server.MinecraftServer
 *  net.minecraft.server.management.PreYggdrasilConverter
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.base;

import com.google.common.base.Optional;
import java.util.UUID;
import javax.annotation.Nullable;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.entity.IEntityOwnable;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.world.entity.player.Player;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializer;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.scoreboard.Team;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.PreYggdrasilConverter;
import net.minecraft.world.level.Level;
import xol.lostinfinity.mob.ai.EntityAIFloatAttack;
import xol.lostinfinity.mob.entity.base.EntityFloatingBase;

public class EntityFloatingTameable
extends EntityFloatingBase
implements IEntityOwnable {
    protected static final DataParameter<Boolean> TAMED = EntityDataManager.func_187226_a(EntityFloatingTameable.class, (DataSerializer)DataSerializers.field_187198_h);
    protected static final DataParameter<Optional<UUID>> OWNER_UNIQUE_ID = EntityDataManager.func_187226_a(EntityFloatingTameable.class, (DataSerializer)DataSerializers.field_187203_m);

    public EntityFloatingTameable(Level worldIn) {
        super(worldIn);
    }

    @Override
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a(TAMED, (Object)false);
        this.field_70180_af.func_187214_a(OWNER_UNIQUE_ID, (Object)Optional.absent());
    }

    @Override
    protected void func_184651_r() {
        super.func_184651_r();
        this.field_70715_bh.func_75776_a(1, (EntityAIBase)new EntityAINearestAttackableTarget((PathfinderMob)this, LivingEntity.class, false));
        this.field_70715_bh.func_75776_a(3, (EntityAIBase)new EntityAIHurtByTarget((PathfinderMob)this, true, new Class[0]));
    }

    public boolean isTamed() {
        return (Boolean)this.field_70180_af.func_187225_a(TAMED);
    }

    public void setTamed(boolean tamed) {
        this.field_70180_af.func_187227_b(TAMED, (Object)tamed);
    }

    public void setTamedBy(Player player) {
        this.setTamed(true);
        this.setOwnerId(player.func_110124_au());
    }

    public void setOwnerId(@Nullable UUID uuid) {
        this.field_70180_af.func_187227_b(OWNER_UNIQUE_ID, (Object)Optional.fromNullable((Object)uuid));
    }

    @Override
    public void func_70014_b(CompoundTag compound) {
        super.func_70014_b(compound);
        if (this.func_184753_b() == null) {
            compound.func_74778_a("OwnerUUID", "");
        } else {
            compound.func_74778_a("OwnerUUID", this.func_184753_b().toString());
        }
    }

    @Override
    public void func_70037_a(CompoundTag compound) {
        String s;
        super.func_70037_a(compound);
        if (compound.func_150297_b("OwnerUUID", 8)) {
            s = compound.func_74779_i("OwnerUUID");
        } else {
            String s1 = compound.func_74779_i("Owner");
            s = PreYggdrasilConverter.func_187473_a((MinecraftServer)this.func_184102_h(), (String)s1);
        }
        if (!s.isEmpty()) {
            try {
                this.setOwnerId(UUID.fromString(s));
                this.setTamed(true);
            }
            catch (Throwable var4) {
                this.setTamed(false);
            }
        }
    }

    @Nullable
    public LivingEntity getOwner() {
        try {
            UUID uuid = this.func_184753_b();
            return uuid == null ? null : this.field_70170_p.func_152378_a(uuid);
        }
        catch (IllegalArgumentException var2) {
            return null;
        }
    }

    @Nullable
    public UUID func_184753_b() {
        return (UUID)((Optional)this.field_70180_af.func_187225_a(OWNER_UNIQUE_ID)).orNull();
    }

    public boolean isOwner(LivingEntity entityIn) {
        return entityIn == this.getOwner();
    }

    public Team func_96124_cp() {
        LivingEntity entitylivingbase;
        if (this.isTamed() && (entitylivingbase = this.getOwner()) != null) {
            return entitylivingbase.func_96124_cp();
        }
        return super.func_96124_cp();
    }

    public boolean func_184191_r(Entity entityIn) {
        if (this.isTamed()) {
            LivingEntity entitylivingbase = this.getOwner();
            if (entityIn == entitylivingbase) {
                return true;
            }
            if (entitylivingbase != null) {
                return entitylivingbase.func_184191_r(entityIn);
            }
        }
        return super.func_184191_r(entityIn);
    }

    @Override
    protected EntityAIFloatAttack createShootAI() {
        return null;
    }

    public boolean shouldAttackEntity(LivingEntity target, LivingEntity owner) {
        return !(target instanceof Player) || !(owner instanceof Player) || ((Player)owner).func_96122_a((Player)target);
    }
}

