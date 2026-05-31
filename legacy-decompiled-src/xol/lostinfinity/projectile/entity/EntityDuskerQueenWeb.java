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
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3
 *  net.minecraft.world.World
 */
package xol.lostinfinity.projectile.entity;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializer;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.Level;
import xol.lostinfinity.mob.entity.boss.EntityDuskerQueen;
import xol.lostinfinity.util.data.IMaxAttack;

public class EntityDuskerQueenWeb
extends Entity
implements IMaxAttack {
    private static final DataParameter<Float> PLAYER_X = EntityDataManager.func_187226_a(EntityDuskerQueenWeb.class, (DataSerializer)DataSerializers.field_187193_c);
    private static final DataParameter<Float> PLAYER_Y = EntityDataManager.func_187226_a(EntityDuskerQueenWeb.class, (DataSerializer)DataSerializers.field_187193_c);
    private static final DataParameter<Float> PLAYER_Z = EntityDataManager.func_187226_a(EntityDuskerQueenWeb.class, (DataSerializer)DataSerializers.field_187193_c);
    private Player target = null;
    private EntityDuskerQueen owner = null;
    private Vec3 stopPos = null;
    private float growth = 0.0f;

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

    public Player getTarget() {
        return this.target;
    }

    public EntityDuskerQueenWeb(Level worldIn) {
        super(worldIn);
    }

    public void func_70071_h_() {
        super.func_70071_h_();
        if (this.growth < 1.0f) {
            this.growth += 0.05f;
        }
        Vec3 playerPos = this.getPlayerPos();
        Vec3 dir = playerPos.func_178788_d(this.func_174791_d());
        dir = dir.func_72432_b();
        int dist = (int)playerPos.func_72438_d(this.func_174791_d());
        Vec3 nextPos = this.func_174791_d().func_178787_e(dir);
        int steps = 1;
        boolean foundBlock = false;
        while (!foundBlock && steps < dist) {
            if (this.field_70170_p.func_175623_d(new BlockPos(nextPos.field_72450_a, nextPos.field_72448_b, nextPos.field_72449_c))) {
                ++steps;
                nextPos = nextPos.func_178787_e(dir);
                continue;
            }
            foundBlock = true;
        }
        this.stopPos = foundBlock ? nextPos : null;
        if (!this.field_70170_p.field_72995_K) {
            if (this.target == null || this.owner == null || this.owner.field_70128_L || this.target.field_70128_L) {
                this.func_70106_y();
            } else {
                this.func_70634_a(this.owner.field_70165_t, this.owner.field_70163_u + (double)(this.owner.field_70131_O / 2.0f), this.owner.field_70161_v);
                this.setPlayerXYZ(new Vec3(this.target.field_70165_t, this.target.field_70163_u, this.target.field_70161_v));
            }
        }
    }

    public Vec3 getStopPos() {
        return this.stopPos;
    }

    protected void func_70037_a(CompoundTag compound) {
    }

    protected void func_70014_b(CompoundTag compound) {
    }

    protected void func_70088_a() {
        this.field_70180_af.func_187214_a(PLAYER_X, (Object)Float.valueOf(0.0f));
        this.field_70180_af.func_187214_a(PLAYER_Y, (Object)Float.valueOf(0.0f));
        this.field_70180_af.func_187214_a(PLAYER_Z, (Object)Float.valueOf(0.0f));
    }

    public void setOwner(EntityDuskerQueen entityDuskerQueen) {
        this.owner = entityDuskerQueen;
    }

    public void setTarget(Player target) {
        this.target = target;
    }

    public float getGrowth() {
        return this.growth;
    }
}

