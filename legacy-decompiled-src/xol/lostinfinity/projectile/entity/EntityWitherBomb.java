/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.util.math.HitResult
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.projectile.entity;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.projectile.entity.EntityBaseThrowable;
import xol.lostinfinity.util.data.IMaxAttack;

public class EntityWitherBomb
extends EntityBaseThrowable {
    public EntityWitherBomb(Level par1World) {
        super(par1World);
        this.func_70105_a(0.75f, 0.75f);
    }

    public EntityWitherBomb(Level par1World, LivingEntity par2Mob) {
        super(par1World, par2Mob);
        this.func_70105_a(0.75f, 0.75f);
    }

    @Override
    protected void func_70184_a(HitResult result) {
        if (!(this.field_70170_p.field_72995_K || result.field_72308_g != null && result.field_72308_g.equals((Object)this.func_85052_h()))) {
            this.field_70170_p.func_72876_a(null, this.field_70165_t, this.field_70163_u, this.field_70161_v, 1.5f, false);
            for (Player target : this.field_70170_p.func_72872_a(Player.class, this.func_174813_aQ().func_72314_b(5.0, 5.0, 5.0))) {
                IMaxAttack.dealMaxHealth((Entity)this, (LivingEntity)target, 2);
            }
            this.func_70106_y();
        }
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void func_70071_h_() {
        super.func_70071_h_();
        if (this.field_70170_p.field_72995_K) {
            this.field_70170_p.func_175682_a(ParticleInit.WITHER_RINGS, true, this.field_70165_t + this.getROD(1), this.field_70163_u + this.getROD(1), this.field_70161_v + this.getROD(1), 0.0, 0.0, 0.0, new int[0]);
        }
    }

    protected float func_70185_h() {
        return 0.0f;
    }
}

