/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Optional
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.item.ItemEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.datasync.DataParameter
 *  net.minecraft.network.datasync.DataSerializer
 *  net.minecraft.network.datasync.DataSerializers
 *  net.minecraft.network.datasync.EntityDataManager
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.math.Vec3
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.misc;

import com.google.common.base.Optional;
import java.util.ArrayList;
import java.util.UUID;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializer;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.mob.entity.base.EntityImmaterial;
import xol.lostinfinity.util.data.IMaxAttack;

public class EntityPlasmaSlicer
extends Entity {
    protected static final DataParameter<Optional<UUID>> EMITTER_ID = EntityDataManager.func_187226_a(EntityPlasmaSlicer.class, (DataSerializer)DataSerializers.field_187203_m);
    protected static final DataParameter<Optional<UUID>> RECEIVER_ID = EntityDataManager.func_187226_a(EntityPlasmaSlicer.class, (DataSerializer)DataSerializers.field_187203_m);
    private static final float collapseDist = 2.5f;
    private int collapseTimer = 60;
    private static final float distRange = 25.0f;
    protected static final DataParameter<Float> STABLE_DIST = EntityDataManager.func_187226_a(EntityPlasmaSlicer.class, (DataSerializer)DataSerializers.field_187193_c);

    public EntityPlasmaSlicer(Level worldIn) {
        super(worldIn);
        this.func_184224_h(true);
    }

    public float getCollapseDist() {
        return 2.5f;
    }

    public void func_70071_h_() {
        super.func_70071_h_();
        Player emitter = this.getEmitter();
        Player receiver = this.getReceiver();
        if (this.field_70173_aa > 2 && emitter == null || receiver == null) {
            if (!this.field_70170_p.field_72995_K) {
                this.func_70106_y();
            }
        } else if (!this.field_70170_p.field_72995_K) {
            if (emitter.func_184614_ca().func_77973_b() != ItemInit.plasmaEmitter || receiver.func_184614_ca().func_77973_b() != ItemInit.plasmaReceiver) {
                this.func_70106_y();
                return;
            }
            if (this.field_70173_aa % 80 == 0) {
                float curDist = this.getStableDist();
                float newDist = Math.max(this.field_70146_Z.nextFloat() * 25.0f, 8.0f);
                while (Math.abs(curDist - newDist) > 6.0f) {
                    newDist = Math.max(this.field_70146_Z.nextFloat() * 25.0f, 8.0f);
                }
                this.setStableDist(newDist);
            }
            float dist = emitter.func_70032_d((Entity)receiver);
            this.func_70634_a(emitter.field_70165_t, emitter.field_70163_u + (double)emitter.field_70131_O / 2.0, emitter.field_70161_v);
            if (this.field_70173_aa % 4 == 0) {
                ArrayList<LivingEntity> hitEntities = new ArrayList<LivingEntity>();
                Vec3 start = this.func_174791_d();
                Vec3 end = receiver.func_174791_d().func_72441_c(0.0, (double)receiver.field_70131_O / 2.0, 0.0);
                Vec3 dir = end.func_178788_d(start).func_72432_b();
                for (double i = 0.0; i < (double)dist; i += 0.5) {
                    Vec3 pos = start.func_72441_c(dir.field_72450_a * i, dir.field_72448_b * i, dir.field_72449_c * i);
                    double radius = 1.0;
                    AABB checkBox = new AABB(pos.field_72450_a - radius, pos.field_72448_b - radius, pos.field_72449_c - radius, pos.field_72450_a + radius, pos.field_72448_b + radius, pos.field_72449_c + radius);
                    for (LivingEntity entity : this.field_70170_p.func_72872_a(LivingEntity.class, checkBox)) {
                        if (entity instanceof EntityImmaterial || entity.func_110124_au().equals(emitter.func_110124_au()) || entity.func_110124_au().equals(receiver.func_110124_au()) || hitEntities.contains(entity)) continue;
                        if (IMaxAttack.dealTrueDamage((Entity)emitter, entity, entity.func_110138_aP() * 0.1f).wasTargetKilled() && entity instanceof Player) {
                            ItemEntity reward = new ItemEntity(this.field_70170_p, entity.field_70165_t, entity.field_70163_u + 0.4, entity.field_70161_v, new ItemStack(ItemInit.plasmaticCranium));
                            reward.field_70159_w = 0.0;
                            reward.field_70181_x = 0.0;
                            reward.field_70179_y = 0.0;
                            this.field_70170_p.func_72838_d((Entity)reward);
                        }
                        hitEntities.add(entity);
                    }
                }
            }
            if (Math.abs(dist - this.getStableDist()) > 2.5f) {
                if (this.field_70173_aa % 20 == 0) {
                    if (dist - this.getStableDist() < -1.25f) {
                        emitter.func_145747_a((Component)new Component("You are too close together, move apart to stabilize the plasma!"));
                        receiver.func_145747_a((Component)new Component("You are too close together, move apart to stabilize the plasma!"));
                    } else if (dist - this.getStableDist() > 1.25f) {
                        emitter.func_145747_a((Component)new Component("You are too far apart, move closer to stabilize the plasma!"));
                        receiver.func_145747_a((Component)new Component("You are too far apart, move closer to stabilize the plasma!"));
                    }
                }
                if (this.collapseTimer > 0) {
                    --this.collapseTimer;
                } else {
                    emitter.func_145747_a((Component)new Component((Object)((Object)TextFmt.Dark_Red) + "Plasma Destabilized"));
                    receiver.func_145747_a((Component)new Component((Object)((Object)TextFmt.Dark_Red) + "Plasma Destabilized"));
                    this.func_70106_y();
                }
            } else {
                this.collapseTimer = 60;
            }
        }
    }

    public Player getEmitter() {
        if (((Optional)this.field_70180_af.func_187225_a(EMITTER_ID)).orNull() != null) {
            return this.field_70170_p.func_152378_a((UUID)((Optional)this.field_70180_af.func_187225_a(EMITTER_ID)).get());
        }
        return null;
    }

    public void setEmitter(Player player) {
        this.field_70180_af.func_187227_b(EMITTER_ID, (Object)Optional.fromNullable((Object)player.func_110124_au()));
    }

    public Player getReceiver() {
        if (((Optional)this.field_70180_af.func_187225_a(RECEIVER_ID)).orNull() != null) {
            return this.field_70170_p.func_152378_a((UUID)((Optional)this.field_70180_af.func_187225_a(RECEIVER_ID)).get());
        }
        return null;
    }

    public void setReceiver(Player player) {
        this.field_70180_af.func_187227_b(RECEIVER_ID, (Object)Optional.fromNullable((Object)player.func_110124_au()));
    }

    public void setStableDist(float dist) {
        this.field_70180_af.func_187227_b(STABLE_DIST, (Object)Float.valueOf(dist));
    }

    public float getStableDist() {
        return ((Float)this.field_70180_af.func_187225_a(STABLE_DIST)).floatValue();
    }

    protected void func_70088_a() {
        this.field_70180_af.func_187214_a(EMITTER_ID, (Object)Optional.absent());
        this.field_70180_af.func_187214_a(RECEIVER_ID, (Object)Optional.absent());
        this.field_70180_af.func_187214_a(STABLE_DIST, (Object)Float.valueOf(0.0f));
    }

    protected void func_70037_a(CompoundTag compound) {
    }

    protected void func_70014_b(CompoundTag compound) {
    }
}

