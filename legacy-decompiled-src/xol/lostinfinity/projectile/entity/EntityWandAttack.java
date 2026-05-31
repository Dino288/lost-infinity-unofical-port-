/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.datasync.DataParameter
 *  net.minecraft.network.datasync.DataSerializer
 *  net.minecraft.network.datasync.DataSerializers
 *  net.minecraft.network.datasync.EntityDataManager
 *  net.minecraft.util.EnumParticleTypes
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec2f
 *  net.minecraft.world.World
 */
package xol.lostinfinity.projectile.entity;

import java.util.UUID;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializer;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.util.math.Vec2f;
import net.minecraft.world.level.Level;

public class EntityWandAttack
extends Entity {
    private UUID caster;
    private static final DataParameter<Float> AIM_X = EntityDataManager.func_187226_a(EntityWandAttack.class, (DataSerializer)DataSerializers.field_187193_c);
    private static final DataParameter<Float> AIM_Y = EntityDataManager.func_187226_a(EntityWandAttack.class, (DataSerializer)DataSerializers.field_187193_c);
    private static final DataParameter<Float> AIM_Z = EntityDataManager.func_187226_a(EntityWandAttack.class, (DataSerializer)DataSerializers.field_187193_c);
    private static final DataParameter<Float> PLAYER_X = EntityDataManager.func_187226_a(EntityWandAttack.class, (DataSerializer)DataSerializers.field_187193_c);
    private static final DataParameter<Float> PLAYER_Y = EntityDataManager.func_187226_a(EntityWandAttack.class, (DataSerializer)DataSerializers.field_187193_c);
    private static final DataParameter<Float> PLAYER_Z = EntityDataManager.func_187226_a(EntityWandAttack.class, (DataSerializer)DataSerializers.field_187193_c);
    private static final DataParameter<Float> YAW = EntityDataManager.func_187226_a(EntityWandAttack.class, (DataSerializer)DataSerializers.field_187193_c);
    private static final DataParameter<Float> PITCH = EntityDataManager.func_187226_a(EntityWandAttack.class, (DataSerializer)DataSerializers.field_187193_c);

    public EntityWandAttack(Level worldIn) {
        super(worldIn);
    }

    public void setCaster(Player playerIn) {
        this.caster = playerIn.func_110124_au();
    }

    public void setAimBlock(BlockPos pos) {
        float xpos = pos.func_177958_n();
        float ypos = pos.func_177956_o();
        float zpos = pos.func_177952_p();
        this.field_70180_af.func_187227_b(AIM_X, (Object)Float.valueOf(xpos));
        this.field_70180_af.func_187227_b(AIM_Y, (Object)Float.valueOf(ypos));
        this.field_70180_af.func_187227_b(AIM_Z, (Object)Float.valueOf(zpos));
    }

    public BlockPos getAimBlock() {
        double xpos = ((Float)this.field_70180_af.func_187225_a(AIM_X)).floatValue();
        double ypos = ((Float)this.field_70180_af.func_187225_a(AIM_Y)).floatValue();
        double zpos = ((Float)this.field_70180_af.func_187225_a(AIM_Z)).floatValue();
        return new BlockPos(xpos, ypos, zpos);
    }

    public void setPlayerXYZ(BlockPos pos) {
        float xpos = pos.func_177958_n();
        float ypos = pos.func_177956_o();
        float zpos = pos.func_177952_p();
        this.field_70180_af.func_187227_b(PLAYER_X, (Object)Float.valueOf(xpos));
        this.field_70180_af.func_187227_b(PLAYER_Y, (Object)Float.valueOf(ypos));
        this.field_70180_af.func_187227_b(PLAYER_Z, (Object)Float.valueOf(zpos));
    }

    public BlockPos getPlayerPos() {
        double xpos = ((Float)this.field_70180_af.func_187225_a(PLAYER_X)).floatValue();
        double ypos = ((Float)this.field_70180_af.func_187225_a(PLAYER_Y)).floatValue();
        double zpos = ((Float)this.field_70180_af.func_187225_a(PLAYER_Z)).floatValue();
        return new BlockPos(xpos, ypos, zpos);
    }

    public Vec2f func_189653_aC() {
        float playerYaw = ((Float)this.field_70180_af.func_187225_a(YAW)).floatValue();
        float playerPitch = ((Float)this.field_70180_af.func_187225_a(PITCH)).floatValue();
        Vec2f pitchYaw = new Vec2f(playerYaw, playerPitch);
        return pitchYaw;
    }

    public void func_70071_h_() {
        super.func_70071_h_();
        if (!this.field_70170_p.field_72995_K) {
            Player play;
            if (this.field_70173_aa == 30) {
                this.func_70106_y();
            }
            if ((play = this.field_70170_p.func_152378_a(this.caster)) != null) {
                this.setPlayerXYZ(play.func_180425_c().func_177982_a(0, 1, 0));
                this.setPlayerYawPitch(play.func_189653_aC());
            } else {
                this.func_70106_y();
            }
        } else {
            BlockPos playerPos = this.getPlayerPos();
            for (int i = 0; i < 5; ++i) {
                this.field_70170_p.func_175688_a(EnumParticleTypes.FIREWORKS_SPARK, (double)playerPos.func_177958_n(), (double)playerPos.func_177956_o(), (double)playerPos.func_177952_p(), (this.field_70146_Z.nextDouble() - 0.5) * 2.0, -this.field_70146_Z.nextDouble(), (this.field_70146_Z.nextDouble() - 0.5) * 2.0, new int[0]);
            }
        }
    }

    private void setPlayerYawPitch(Vec2f pitchYaw) {
        float playerYaw = pitchYaw.field_189982_i;
        float playerPitch = pitchYaw.field_189983_j;
        this.field_70180_af.func_187227_b(YAW, (Object)Float.valueOf(playerYaw));
        this.field_70180_af.func_187227_b(PITCH, (Object)Float.valueOf(playerPitch));
    }

    protected void func_70088_a() {
        this.field_70180_af.func_187214_a(AIM_X, (Object)Float.valueOf(0.0f));
        this.field_70180_af.func_187214_a(AIM_Y, (Object)Float.valueOf(0.0f));
        this.field_70180_af.func_187214_a(AIM_Z, (Object)Float.valueOf(0.0f));
        this.field_70180_af.func_187214_a(PLAYER_X, (Object)Float.valueOf(0.0f));
        this.field_70180_af.func_187214_a(PLAYER_Y, (Object)Float.valueOf(0.0f));
        this.field_70180_af.func_187214_a(PLAYER_Z, (Object)Float.valueOf(0.0f));
        this.field_70180_af.func_187214_a(YAW, (Object)Float.valueOf(0.0f));
        this.field_70180_af.func_187214_a(PITCH, (Object)Float.valueOf(0.0f));
    }

    protected void func_70037_a(CompoundTag compound) {
    }

    protected void func_70014_b(CompoundTag compound) {
    }
}

