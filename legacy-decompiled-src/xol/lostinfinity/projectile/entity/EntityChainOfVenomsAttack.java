/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.datasync.DataParameter
 *  net.minecraft.network.datasync.DataSerializer
 *  net.minecraft.network.datasync.DataSerializers
 *  net.minecraft.network.datasync.EntityDataManager
 *  net.minecraft.util.math.Vec3
 *  net.minecraft.world.World
 */
package xol.lostinfinity.projectile.entity;

import java.util.UUID;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializer;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.Level;

public class EntityChainOfVenomsAttack
extends Entity {
    private static final DataParameter<Float> PLAYER_X = EntityDataManager.func_187226_a(EntityChainOfVenomsAttack.class, (DataSerializer)DataSerializers.field_187193_c);
    private static final DataParameter<Float> PLAYER_Y = EntityDataManager.func_187226_a(EntityChainOfVenomsAttack.class, (DataSerializer)DataSerializers.field_187193_c);
    private static final DataParameter<Float> PLAYER_Z = EntityDataManager.func_187226_a(EntityChainOfVenomsAttack.class, (DataSerializer)DataSerializers.field_187193_c);
    private static final DataParameter<Float> ORIGIN_X = EntityDataManager.func_187226_a(EntityChainOfVenomsAttack.class, (DataSerializer)DataSerializers.field_187193_c);
    private static final DataParameter<Float> ORIGIN_Y = EntityDataManager.func_187226_a(EntityChainOfVenomsAttack.class, (DataSerializer)DataSerializers.field_187193_c);
    private static final DataParameter<Float> ORIGIN_Z = EntityDataManager.func_187226_a(EntityChainOfVenomsAttack.class, (DataSerializer)DataSerializers.field_187193_c);
    private static final DataParameter<Float> TARGET_X = EntityDataManager.func_187226_a(EntityChainOfVenomsAttack.class, (DataSerializer)DataSerializers.field_187193_c);
    private static final DataParameter<Float> TARGET_Y = EntityDataManager.func_187226_a(EntityChainOfVenomsAttack.class, (DataSerializer)DataSerializers.field_187193_c);
    private static final DataParameter<Float> TARGET_Z = EntityDataManager.func_187226_a(EntityChainOfVenomsAttack.class, (DataSerializer)DataSerializers.field_187193_c);
    private static final DataParameter<Float> ORIGIN_HEIGHT = EntityDataManager.func_187226_a(EntityChainOfVenomsAttack.class, (DataSerializer)DataSerializers.field_187193_c);
    private static final DataParameter<Float> TARGET_HEIGHT = EntityDataManager.func_187226_a(EntityChainOfVenomsAttack.class, (DataSerializer)DataSerializers.field_187193_c);
    private UUID caster;
    private int origin;
    private int target;

    public double getOriginHeight() {
        return ((Float)this.field_70180_af.func_187225_a(ORIGIN_HEIGHT)).floatValue();
    }

    public double getTargetHeight() {
        return ((Float)this.field_70180_af.func_187225_a(TARGET_HEIGHT)).floatValue();
    }

    public void setOriginHeight(double height) {
        this.field_70180_af.func_187227_b(ORIGIN_HEIGHT, (Object)Float.valueOf((float)height));
    }

    public void setTargetHeight(double height) {
        this.field_70180_af.func_187227_b(TARGET_HEIGHT, (Object)Float.valueOf((float)height));
    }

    public Vec3 getOriginPos() {
        double x = ((Float)this.field_70180_af.func_187225_a(ORIGIN_X)).floatValue();
        double y = ((Float)this.field_70180_af.func_187225_a(ORIGIN_Y)).floatValue();
        double z = ((Float)this.field_70180_af.func_187225_a(ORIGIN_Z)).floatValue();
        return new Vec3(x, y, z);
    }

    public void setOriginPos(Vec3 pos) {
        float xpos = (float)pos.field_72450_a;
        float ypos = (float)pos.field_72448_b;
        float zpos = (float)pos.field_72449_c;
        this.field_70180_af.func_187227_b(ORIGIN_X, (Object)Float.valueOf(xpos));
        this.field_70180_af.func_187227_b(ORIGIN_Y, (Object)Float.valueOf(ypos));
        this.field_70180_af.func_187227_b(ORIGIN_Z, (Object)Float.valueOf(zpos));
    }

    public Vec3 getTargetPos() {
        double x = ((Float)this.field_70180_af.func_187225_a(TARGET_X)).floatValue();
        double y = ((Float)this.field_70180_af.func_187225_a(TARGET_Y)).floatValue();
        double z = ((Float)this.field_70180_af.func_187225_a(TARGET_Z)).floatValue();
        return new Vec3(x, y, z);
    }

    public void setTargetPos(Vec3 pos) {
        float xpos = (float)pos.field_72450_a;
        float ypos = (float)pos.field_72448_b;
        float zpos = (float)pos.field_72449_c;
        this.field_70180_af.func_187227_b(TARGET_X, (Object)Float.valueOf(xpos));
        this.field_70180_af.func_187227_b(TARGET_Y, (Object)Float.valueOf(ypos));
        this.field_70180_af.func_187227_b(TARGET_Z, (Object)Float.valueOf(zpos));
    }

    public Vec3 getPlayerPos() {
        double x = ((Float)this.field_70180_af.func_187225_a(PLAYER_X)).floatValue();
        double y = ((Float)this.field_70180_af.func_187225_a(PLAYER_Y)).floatValue();
        double z = ((Float)this.field_70180_af.func_187225_a(PLAYER_Z)).floatValue();
        return new Vec3(x, y, z);
    }

    public void setPlayerXYZ(Vec3 pos) {
        float xpos = (float)pos.field_72450_a;
        float ypos = (float)pos.field_72448_b;
        float zpos = (float)pos.field_72449_c;
        this.field_70180_af.func_187227_b(PLAYER_X, (Object)Float.valueOf(xpos));
        this.field_70180_af.func_187227_b(PLAYER_Y, (Object)Float.valueOf(ypos));
        this.field_70180_af.func_187227_b(PLAYER_Z, (Object)Float.valueOf(zpos));
    }

    public void setCaster(Player playerIn) {
        this.caster = playerIn.func_110124_au();
    }

    public void setOrigin(int origin) {
        this.origin = origin;
    }

    public void setTarget(int target) {
        this.target = target;
    }

    public Entity getOrigin() {
        return this.field_70170_p.func_73045_a(this.origin);
    }

    public Entity getTarget() {
        return this.field_70170_p.func_73045_a(this.target);
    }

    public EntityChainOfVenomsAttack(Level worldIn) {
        super(worldIn);
    }

    public void func_70071_h_() {
        super.func_70071_h_();
        if (!this.field_70170_p.field_72995_K) {
            if (this.caster == null) {
                this.func_70106_y();
            } else {
                Player player = this.field_70170_p.func_152378_a(this.caster);
                LivingEntity originEntity = (LivingEntity)this.field_70170_p.func_73045_a(this.origin);
                LivingEntity targetEntity = (LivingEntity)this.field_70170_p.func_73045_a(this.target);
                if (player != null && originEntity != null && targetEntity != null) {
                    this.setPlayerXYZ(new Vec3(player.field_70165_t, player.field_70163_u, player.field_70161_v));
                    this.setOriginPos(new Vec3(originEntity.field_70165_t, originEntity.field_70163_u, originEntity.field_70161_v));
                    this.setTargetPos(new Vec3(targetEntity.field_70165_t, targetEntity.field_70163_u, targetEntity.field_70161_v));
                    this.setOriginHeight(originEntity.field_70131_O);
                    this.setTargetHeight(targetEntity.field_70131_O);
                }
                if (this.field_70173_aa == 20) {
                    this.func_70106_y();
                }
            }
        }
    }

    protected void func_70037_a(CompoundTag compound) {
    }

    protected void func_70014_b(CompoundTag compound) {
    }

    protected void func_70088_a() {
        this.field_70180_af.func_187214_a(ORIGIN_HEIGHT, (Object)Float.valueOf(0.0f));
        this.field_70180_af.func_187214_a(TARGET_HEIGHT, (Object)Float.valueOf(0.0f));
        this.field_70180_af.func_187214_a(PLAYER_X, (Object)Float.valueOf(0.0f));
        this.field_70180_af.func_187214_a(PLAYER_Y, (Object)Float.valueOf(0.0f));
        this.field_70180_af.func_187214_a(PLAYER_Z, (Object)Float.valueOf(0.0f));
        this.field_70180_af.func_187214_a(ORIGIN_X, (Object)Float.valueOf(0.0f));
        this.field_70180_af.func_187214_a(ORIGIN_Y, (Object)Float.valueOf(0.0f));
        this.field_70180_af.func_187214_a(ORIGIN_Z, (Object)Float.valueOf(0.0f));
        this.field_70180_af.func_187214_a(TARGET_X, (Object)Float.valueOf(0.0f));
        this.field_70180_af.func_187214_a(TARGET_Y, (Object)Float.valueOf(0.0f));
        this.field_70180_af.func_187214_a(TARGET_Z, (Object)Float.valueOf(0.0f));
    }

    public Player getCaster() {
        return this.field_70170_p.func_152378_a(this.caster);
    }
}

