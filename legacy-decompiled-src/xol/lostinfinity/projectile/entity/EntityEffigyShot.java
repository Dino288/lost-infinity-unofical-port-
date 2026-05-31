/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.material.Material
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.item.ItemEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.math.HitResult
 *  net.minecraft.util.math.HitResult$Type
 *  net.minecraft.world.World
 */
package xol.lostinfinity.projectile.entity;

import java.util.UUID;
import net.minecraft.block.material.Material;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.level.Level;
import xol.lostinfinity.mob.entity.misc.EntityEffigyEffect;
import xol.lostinfinity.projectile.entity.EntityBaseThrowable;

public class EntityEffigyShot
extends EntityBaseThrowable {
    private ItemStack stack = null;

    public EntityEffigyShot(Level par1World) {
        super(par1World);
    }

    public EntityEffigyShot(Level par1World, LivingEntity par2Mob) {
        super(par1World, par2Mob);
    }

    public EntityEffigyShot(Level par1World, double par2, double par4, double par6) {
        super(par1World, par2, par4, par6);
    }

    @Override
    protected void func_70184_a(HitResult result) {
        if (!this.field_70170_p.field_72995_K && this.stack != null) {
            boolean flag = false;
            if (result.field_72313_a == HitResult.Type.BLOCK && this.field_70170_p.func_180495_p(result.func_178782_a().func_177984_a()).func_185904_a().equals(Material.field_151587_i) && this.stack.func_77942_o() && this.stack.func_77978_p().func_186855_b("targetID")) {
                UUID targetID = this.stack.func_77978_p().func_186857_a("targetID");
                EntityEffigyEffect effect = new EntityEffigyEffect(this.field_70170_p);
                Player target = this.field_70170_p.func_152378_a(targetID);
                if (target != null) {
                    effect.func_70634_a(target.field_70165_t, target.field_70163_u, target.field_70161_v);
                }
                if (this.field_70192_c != null && this.field_70192_c instanceof Player) {
                    effect.setCaster((Player)this.field_70192_c);
                }
                effect.setTarget(targetID);
                this.field_70170_p.func_72838_d((Entity)effect);
            }
            if (!flag) {
                ItemEntity effigy = new ItemEntity(this.field_70170_p, (double)result.func_178782_a().func_177958_n(), (double)result.func_178782_a().func_177956_o(), (double)result.func_178782_a().func_177952_p(), this.stack);
                this.field_70170_p.func_72838_d((Entity)effigy);
            }
            this.func_70106_y();
        }
    }

    public void setStack(ItemStack stack) {
        this.stack = stack.func_77946_l();
    }

    protected float func_70185_h() {
        return 0.05f;
    }
}

