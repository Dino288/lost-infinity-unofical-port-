/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.HitResult
 *  net.minecraft.world.World
 */
package xol.lostinfinity.projectile.entity;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.level.Level;
import xol.lostinfinity.projectile.entity.EntityBaseThrowable;
import xol.lostinfinity.util.data.IMaxAttack;

public class EntityWitchMagic
extends EntityBaseThrowable {
    public EntityWitchMagic(Level par1World) {
        super(par1World);
    }

    public EntityWitchMagic(Level par1World, LivingEntity par2Mob) {
        super(par1World, par2Mob);
    }

    public EntityWitchMagic(Level par1World, double par2, double par4, double par6) {
        super(par1World, par2, par4, par6);
    }

    @Override
    protected void func_70184_a(HitResult result) {
        if (!this.field_70170_p.field_72995_K) {
            if (result.field_72308_g != null && this.func_85052_h() != null && result.field_72308_g != this.func_85052_h() && result.field_72308_g instanceof LivingEntity) {
                IMaxAttack.dealMaxHealth((Entity)this, (LivingEntity)result.field_72308_g, 2);
                boolean canStop = false;
                BlockPos telePos = new BlockPos(this.field_70165_t, this.field_70163_u + 2.0, this.field_70161_v);
                int ypos = 10;
                while (!canStop) {
                    BlockPos test = telePos.func_177982_a(-10 + this.field_70146_Z.nextInt(20), ypos, -10 + this.field_70146_Z.nextInt(20));
                    if (this.field_70170_p.func_175623_d(test)) {
                        canStop = true;
                        this.field_70170_p.func_184133_a(null, telePos.func_177982_a(0, ypos, 0), SoundEvents.field_187534_aX, SoundSource.MASTER, 2.0f, 1.0f);
                        result.field_72308_g.func_70634_a((double)test.func_177958_n(), (double)test.func_177956_o(), (double)test.func_177952_p());
                        continue;
                    }
                    ++ypos;
                }
            }
            this.func_70106_y();
        }
    }

    protected float func_70185_h() {
        return 0.05f;
    }
}

