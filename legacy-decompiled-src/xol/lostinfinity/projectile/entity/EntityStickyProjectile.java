/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.HitResult
 *  net.minecraft.world.World
 */
package xol.lostinfinity.projectile.entity;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.level.Level;
import xol.lostinfinity.item.weapon.ItemStickyBombLauncher;
import xol.lostinfinity.mob.entity.misc.EntityStickyBomb;
import xol.lostinfinity.projectile.entity.EntityBaseThrowable;

public class EntityStickyProjectile
extends EntityBaseThrowable {
    private ItemStack referenceStack = null;

    public EntityStickyProjectile(Level par1World) {
        super(par1World);
    }

    public EntityStickyProjectile(Level par1World, LivingEntity par2Mob) {
        super(par1World, par2Mob);
    }

    public EntityStickyProjectile(Level par1World, double par2, double par4, double par6) {
        super(par1World, par2, par4, par6);
    }

    public void setStack(ItemStack stack) {
        this.referenceStack = stack;
    }

    @Override
    protected void func_70184_a(HitResult result) {
        if (!this.field_70170_p.field_72995_K) {
            if (this.func_85052_h() != null && this.referenceStack != null) {
                EntityStickyBomb bomb = new EntityStickyBomb(this.field_70170_p);
                bomb.setCreator(this.func_85052_h().func_110124_au());
                ItemStickyBombLauncher launcher = (ItemStickyBombLauncher)this.referenceStack.func_77973_b();
                launcher.addBomb(bomb);
                if (result.field_72308_g != null && result.field_72308_g instanceof LivingEntity) {
                    bomb.setHoldPos((LivingEntity)result.field_72308_g);
                    bomb.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
                } else {
                    BlockPos resultPos = result.func_178782_a();
                    bomb.setHoldPos(resultPos);
                    bomb.func_70107_b(this.field_70169_q, this.field_70167_r, this.field_70166_s);
                }
                this.field_70170_p.func_72838_d((Entity)bomb);
            }
            this.func_70106_y();
        }
    }

    protected float func_70185_h() {
        return 0.030000001f;
    }
}

