/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.network.datasync.DataParameter
 *  net.minecraft.network.datasync.DataSerializer
 *  net.minecraft.network.datasync.DataSerializers
 *  net.minecraft.network.datasync.EntityDataManager
 *  net.minecraft.util.math.Mth
 *  net.minecraft.util.math.Rotations
 *  net.minecraft.util.math.Vec3
 *  net.minecraft.world.World
 */
package xol.lostinfinity.projectile.cthulhu;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializer;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.Mth;
import net.minecraft.util.math.Rotations;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.Level;
import xol.lostinfinity.mob.entity.base.EntityImmaterial;
import xol.lostinfinity.util.data.CustomHitResult;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.data.RayTraceBuilder;
import xol.lostinfinity.util.math.LMath;

public class EntityCthulhuBeam
extends EntityImmaterial {
    private static final DataParameter<Float> DIR_X = EntityDataManager.func_187226_a(EntityCthulhuBeam.class, (DataSerializer)DataSerializers.field_187193_c);
    private static final DataParameter<Float> DIR_Y = EntityDataManager.func_187226_a(EntityCthulhuBeam.class, (DataSerializer)DataSerializers.field_187193_c);
    private static final DataParameter<Float> DIR_Z = EntityDataManager.func_187226_a(EntityCthulhuBeam.class, (DataSerializer)DataSerializers.field_187193_c);
    public float pitch;
    public float yaw;

    public EntityCthulhuBeam(Level worldIn) {
        super(worldIn);
    }

    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a(DIR_X, (Object)Float.valueOf(0.0f));
        this.field_70180_af.func_187214_a(DIR_Y, (Object)Float.valueOf(0.0f));
        this.field_70180_af.func_187214_a(DIR_Z, (Object)Float.valueOf(0.0f));
    }

    public Vec3 getDirection() {
        return new Vec3((double)((Float)this.field_70180_af.func_187225_a(DIR_X)).floatValue(), (double)((Float)this.field_70180_af.func_187225_a(DIR_Y)).floatValue(), (double)((Float)this.field_70180_af.func_187225_a(DIR_Z)).floatValue());
    }

    public void setDirection(float x, float y, float z) {
        float a = (float)Mth.func_181161_i((double)(x * x + y * y + z * z));
        this.field_70180_af.func_187227_b(DIR_X, (Object)Float.valueOf(x * a));
        this.field_70180_af.func_187227_b(DIR_Y, (Object)Float.valueOf(y * a));
        this.field_70180_af.func_187227_b(DIR_Z, (Object)Float.valueOf(z * a));
    }

    public void func_70071_h_() {
        if (this.field_70173_aa > 45) {
            this.func_70106_y();
            return;
        }
        if (this.field_70170_p.field_72995_K) {
            return;
        }
        if (this.field_70173_aa >= 15 && this.field_70173_aa < 30 && this.field_70173_aa % 3 == 0) {
            this.damagePlayer();
        }
    }

    public void func_184206_a(DataParameter<?> key) {
        super.func_184206_a(key);
        if (this.field_70170_p.field_72995_K) {
            Rotations rot = LMath.toPitchYaw(this.getDirection());
            this.pitch = rot.func_179415_b();
            this.yaw = rot.func_179416_c();
        }
    }

    private void damagePlayer() {
        CustomHitResult result = RayTraceBuilder.entity(Player.class, 64).maxEntity(0).trace(this.field_70170_p, (Entity)this, this.func_174791_d(), this.getDirection());
        if (result == null || result.getResultEntities().isEmpty()) {
            return;
        }
        for (Entity entity : result.getResultEntities()) {
            Player player = (Player)entity;
            IMaxAttack.dealTrueDamage((Entity)this, (LivingEntity)player, player.func_110138_aP() * 0.08f);
        }
    }
}

