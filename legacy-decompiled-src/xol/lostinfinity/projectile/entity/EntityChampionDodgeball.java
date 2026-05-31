/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.item.ItemEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.ItemStack
 *  net.minecraft.network.datasync.DataParameter
 *  net.minecraft.network.datasync.DataSerializer
 *  net.minecraft.network.datasync.DataSerializers
 *  net.minecraft.network.datasync.EntityDataManager
 *  net.minecraft.util.math.HitResult
 *  net.minecraft.world.World
 */
package xol.lostinfinity.projectile.entity;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializer;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.mob.entity.contest.controller.EntityControllerTrampolineDodgeball;
import xol.lostinfinity.projectile.entity.EntityBaseThrowable;
import xol.lostinfinity.util.coordinates.ContestCoordinates;

public class EntityChampionDodgeball
extends EntityBaseThrowable {
    private static final DataParameter<Integer> TYPE = EntityDataManager.func_187226_a(EntityChampionDodgeball.class, (DataSerializer)DataSerializers.field_187192_b);

    public EntityChampionDodgeball(Level par1World) {
        super(par1World);
        this.func_70105_a(0.75f, 0.75f);
    }

    public EntityChampionDodgeball(Level par1World, LivingEntity par2Mob) {
        super(par1World, par2Mob);
        this.func_70105_a(0.75f, 0.75f);
    }

    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a(TYPE, (Object)0);
    }

    public EntityChampionDodgeball(Level par1World, double par2, double par4, double par6) {
        super(par1World, par2, par4, par6);
        this.func_70105_a(0.75f, 0.75f);
    }

    @Override
    protected void func_70184_a(HitResult result) {
        if (!this.field_70170_p.field_72995_K) {
            if (result.field_72308_g != null && this.func_85052_h() != null && result.field_72308_g instanceof Player) {
                Player playerEntity = (Player)result.field_72308_g;
                for (EntityControllerTrampolineDodgeball controller : this.field_70170_p.func_72872_a(EntityControllerTrampolineDodgeball.class, ContestCoordinates.dodgeballArenaAABB())) {
                    controller.eliminatePlayerFromRound(playerEntity);
                }
            }
            if (this.getType() == 0) {
                ItemEntity item = new ItemEntity(this.field_70170_p, this.field_70165_t, this.field_70163_u, this.field_70161_v, new ItemStack(ItemInit.championDodgeball, 1));
                item.field_70159_w = 0.0;
                item.field_70181_x = 0.0;
                item.field_70179_y = 0.0;
                this.field_70170_p.func_72838_d((Entity)item);
            }
            this.func_70106_y();
        }
    }

    protected float func_70185_h() {
        return 0.07f;
    }

    public void setType(int type) {
        this.field_70180_af.func_187227_b(TYPE, (Object)type);
    }

    public int getType() {
        return (Integer)this.field_70180_af.func_187225_a(TYPE);
    }

    @Override
    public void func_70071_h_() {
        super.func_70071_h_();
        if (this.field_70170_p.field_72995_K && this.getType() != 0) {
            this.field_70170_p.func_175688_a(this.getType() == 1 ? ParticleInit.GENERIC_DOT_GREEN : ParticleInit.FLAME_SMALL, this.field_70165_t + (this.field_70146_Z.nextDouble() - 0.5) * (double)this.field_70130_N, this.field_70163_u + this.field_70146_Z.nextDouble() * (double)this.field_70131_O - 0.25, this.field_70161_v + (this.field_70146_Z.nextDouble() - 0.5) * (double)this.field_70130_N, (this.field_70146_Z.nextDouble() - 0.5) * 2.0, -this.field_70146_Z.nextDouble(), (this.field_70146_Z.nextDouble() - 0.5) * 2.0, new int[0]);
        }
    }
}

