/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Optional
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.datasync.DataParameter
 *  net.minecraft.network.datasync.DataSerializer
 *  net.minecraft.network.datasync.DataSerializers
 *  net.minecraft.network.datasync.EntityDataManager
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.Vec3
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.misc;

import com.google.common.base.Optional;
import java.util.UUID;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializer;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.item.basics.ItemChanneling;
import xol.lostinfinity.projectile.entity.EntityWormholeShot;

public class EntityWormholePortal
extends Entity {
    protected static final DataParameter<Optional<UUID>> CASTER_ID = EntityDataManager.func_187226_a(EntityWormholePortal.class, (DataSerializer)DataSerializers.field_187203_m);
    protected static final DataParameter<Float> LOOK_X = EntityDataManager.func_187226_a(EntityWormholePortal.class, (DataSerializer)DataSerializers.field_187193_c);
    protected static final DataParameter<Float> LOOK_Y = EntityDataManager.func_187226_a(EntityWormholePortal.class, (DataSerializer)DataSerializers.field_187193_c);
    protected static final DataParameter<Float> LOOK_Z = EntityDataManager.func_187226_a(EntityWormholePortal.class, (DataSerializer)DataSerializers.field_187193_c);
    protected static final DataParameter<Boolean> SHOOT = EntityDataManager.func_187226_a(EntityWormholePortal.class, (DataSerializer)DataSerializers.field_187198_h);

    public EntityWormholePortal(Level worldIn) {
        super(worldIn);
        this.func_184224_h(true);
    }

    public void func_70071_h_() {
        super.func_70071_h_();
        if (this.getCaster() == null) {
            this.func_70106_y();
        } else if (!this.field_70170_p.field_72995_K) {
            Player caster;
            ItemStack stack;
            if (this.field_70173_aa % 5 == 0) {
                this.field_70170_p.func_184133_a(null, this.func_180425_c(), SoundInit.GENERIC_WEAPON_23, SoundSource.PLAYERS, 0.5f, 0.6f + this.field_70146_Z.nextFloat() * 0.8f);
            }
            if ((stack = (caster = this.getCaster()).func_184614_ca()).func_77973_b() == ItemInit.wormholeRifle && stack.func_77942_o()) {
                int range = (stack.func_77978_p().func_74762_e("usetype_data") + 1) * 10;
                Vec3 look = caster.func_70040_Z().func_72432_b();
                Vec3 sideVec = caster.func_70040_Z().func_178785_b(1.5707964f);
                Vec3 firstPortalPos = caster.func_174791_d().func_72441_c(-sideVec.field_72450_a / 4.0, (double)caster.field_70131_O / 1.1, -sideVec.field_72449_c / 4.0).func_72441_c(look.field_72450_a, 0.0, look.field_72449_c);
                Vec3 secondPortalPos = firstPortalPos.func_178787_e(look.func_186678_a((double)range));
                if (ItemChanneling.isChanneling((LivingEntity)caster, stack)) {
                    if (this.getShoot()) {
                        this.func_70634_a(secondPortalPos.field_72450_a, secondPortalPos.field_72448_b, secondPortalPos.field_72449_c);
                        if (this.field_70173_aa % 5 == 0) {
                            Vec3 normLook = caster.func_70040_Z().func_72432_b().func_186678_a(1.0);
                            EntityWormholeShot shot = new EntityWormholeShot(this.field_70170_p, (LivingEntity)caster);
                            shot.func_70634_a(this.field_70165_t + normLook.field_72450_a, this.field_70163_u + normLook.field_72448_b, this.field_70161_v + normLook.field_72449_c);
                            shot.func_184538_a((Entity)caster, caster.field_70125_A, caster.field_70177_z, 0.0f, 1.5f, 0.5f);
                            this.field_70170_p.func_72838_d((Entity)shot);
                        }
                    } else {
                        this.func_70634_a(firstPortalPos.field_72450_a, firstPortalPos.field_72448_b, firstPortalPos.field_72449_c);
                    }
                } else {
                    this.func_70106_y();
                }
            } else {
                this.func_70106_y();
            }
        }
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

    protected void func_70088_a() {
        this.field_70180_af.func_187214_a(CASTER_ID, (Object)Optional.absent());
        this.field_70180_af.func_187214_a(LOOK_X, (Object)Float.valueOf(0.0f));
        this.field_70180_af.func_187214_a(LOOK_Y, (Object)Float.valueOf(0.0f));
        this.field_70180_af.func_187214_a(LOOK_Z, (Object)Float.valueOf(0.0f));
        this.field_70180_af.func_187214_a(SHOOT, (Object)false);
    }

    public void setPlayerLook(Vec3 lookVec) {
        this.field_70180_af.func_187227_b(LOOK_X, (Object)Float.valueOf((float)lookVec.field_72450_a));
        this.field_70180_af.func_187227_b(LOOK_Y, (Object)Float.valueOf((float)lookVec.field_72448_b));
        this.field_70180_af.func_187227_b(LOOK_Z, (Object)Float.valueOf((float)lookVec.field_72449_c));
    }

    protected void func_70037_a(CompoundTag compound) {
    }

    protected void func_70014_b(CompoundTag compound) {
    }

    public Vec3 getPlayerLook() {
        return new Vec3((double)((Float)this.field_70180_af.func_187225_a(LOOK_X)).floatValue(), (double)((Float)this.field_70180_af.func_187225_a(LOOK_Y)).floatValue(), (double)((Float)this.field_70180_af.func_187225_a(LOOK_Z)).floatValue());
    }

    public void setShoot() {
        this.field_70180_af.func_187227_b(SHOOT, (Object)true);
    }

    private boolean getShoot() {
        return (Boolean)this.field_70180_af.func_187225_a(SHOOT);
    }
}

