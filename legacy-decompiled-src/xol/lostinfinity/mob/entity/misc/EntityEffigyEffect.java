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
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.util.data.IMaxAttack;

public class EntityEffigyEffect
extends Entity
implements IMaxAttack {
    protected static final DataParameter<Optional<UUID>> CASTER_ID = EntityDataManager.func_187226_a(EntityEffigyEffect.class, (DataSerializer)DataSerializers.field_187203_m);
    protected static final DataParameter<Optional<UUID>> TARGET_ID = EntityDataManager.func_187226_a(EntityEffigyEffect.class, (DataSerializer)DataSerializers.field_187203_m);

    public EntityEffigyEffect(Level worldIn) {
        super(worldIn);
        this.func_184224_h(true);
    }

    public void func_70071_h_() {
        super.func_70071_h_();
        Player caster = this.getCaster();
        Player target = this.getTarget();
        if (this.field_70173_aa > 2 && target == null || target.field_70128_L) {
            if (!this.field_70170_p.field_72995_K) {
                this.func_70106_y();
            }
        } else if (target != null) {
            if (!this.field_70170_p.field_72995_K) {
                this.func_70634_a(target.field_70165_t, target.field_70163_u, target.field_70161_v);
            }
            if (this.field_70173_aa <= 40) {
                if (!this.field_70170_p.field_72995_K) {
                    if (caster != null && this.field_70173_aa % 10 == 0) {
                        IMaxAttack.dealMaxHealth((Entity)caster, (LivingEntity)target, 20);
                    }
                } else {
                    for (double i = 0.0; i <= 4.0; i += 1.0) {
                        this.field_70170_p.func_175688_a(ParticleInit.FLAME_SMALL, target.field_70165_t, target.field_70163_u + 0.4, target.field_70161_v, (this.field_70146_Z.nextDouble() - 0.5) * 0.2, this.field_70146_Z.nextDouble() * 0.2, (this.field_70146_Z.nextDouble() - 0.5) * 0.2, new int[0]);
                    }
                }
            } else if (this.field_70173_aa <= 80) {
                if (!this.field_70170_p.field_72995_K) {
                    if (caster != null && this.field_70173_aa % 10 == 0) {
                        IMaxAttack.dealMaxHealth((Entity)caster, (LivingEntity)target, 10);
                    }
                } else {
                    for (double i = 0.0; i <= 4.0; i += 1.0) {
                        this.field_70170_p.func_175688_a(ParticleInit.FLAME_MEDIUM, target.field_70165_t, target.field_70163_u + 0.4, target.field_70161_v, (this.field_70146_Z.nextDouble() - 0.5) * 0.2, this.field_70146_Z.nextDouble() * 0.2, (this.field_70146_Z.nextDouble() - 0.5) * 0.2, new int[0]);
                    }
                }
            } else if (this.field_70173_aa <= 120) {
                if (!this.field_70170_p.field_72995_K) {
                    if (caster != null && this.field_70173_aa % 10 == 0) {
                        IMaxAttack.dealMaxHealth((Entity)caster, (LivingEntity)target, 5);
                    }
                } else {
                    for (double i = 0.0; i <= 4.0; i += 1.0) {
                        this.field_70170_p.func_175688_a(ParticleInit.FLAME_LARGE, target.field_70165_t, target.field_70163_u + 0.4, target.field_70161_v, (this.field_70146_Z.nextDouble() - 0.5) * 0.2, this.field_70146_Z.nextDouble() * 0.2, (this.field_70146_Z.nextDouble() - 0.5) * 0.2, new int[0]);
                    }
                }
            } else if (!this.field_70170_p.field_72995_K) {
                target.func_70606_j(0.0f);
                this.func_145779_a(ItemInit.lifeSynchronizer, 1);
            } else {
                this.field_70170_p.func_175688_a(ParticleInit.EXPLOSION_RED, target.field_70165_t, target.field_70163_u + 0.4, target.field_70161_v, 0.0, this.field_70146_Z.nextDouble() * 0.2, 0.0, new int[0]);
            }
        }
    }

    protected void func_70088_a() {
        this.field_70180_af.func_187214_a(CASTER_ID, (Object)Optional.absent());
        this.field_70180_af.func_187214_a(TARGET_ID, (Object)Optional.absent());
    }

    protected void func_70037_a(CompoundTag compound) {
    }

    protected void func_70014_b(CompoundTag compound) {
    }

    public Player getCaster() {
        if (((Optional)this.field_70180_af.func_187225_a(CASTER_ID)).orNull() != null) {
            return this.field_70170_p.func_152378_a((UUID)((Optional)this.field_70180_af.func_187225_a(CASTER_ID)).get());
        }
        return null;
    }

    public void setCaster(Player player) {
        this.field_70180_af.func_187227_b(CASTER_ID, (Object)Optional.fromNullable((Object)player.func_110124_au()));
    }

    public Player getTarget() {
        if (((Optional)this.field_70180_af.func_187225_a(TARGET_ID)).orNull() != null) {
            return this.field_70170_p.func_152378_a((UUID)((Optional)this.field_70180_af.func_187225_a(TARGET_ID)).get());
        }
        return null;
    }

    public void setTarget(UUID id) {
        this.field_70180_af.func_187227_b(TARGET_ID, (Object)Optional.fromNullable((Object)id));
    }
}

