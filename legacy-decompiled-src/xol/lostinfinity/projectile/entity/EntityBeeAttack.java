/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.util.math.HitResult
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.projectile.entity;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.init.PotionInit;
import xol.lostinfinity.projectile.entity.EntityBaseThrowable;
import xol.lostinfinity.util.data.IMaxAttack;

public class EntityBeeAttack
extends EntityBaseThrowable {
    public EntityBeeAttack(Level par1World) {
        super(par1World);
        this.func_70105_a(0.75f, 0.75f);
    }

    public EntityBeeAttack(Level par1World, LivingEntity par2Mob) {
        super(par1World, par2Mob);
        this.func_70105_a(0.75f, 0.75f);
    }

    public EntityBeeAttack(Level par1World, double par2, double par4, double par6) {
        super(par1World, par2, par4, par6);
        this.func_70105_a(0.75f, 0.75f);
    }

    @Override
    protected void func_70184_a(HitResult result) {
        if (!this.field_70170_p.field_72995_K) {
            if (result.field_72308_g != null && this.func_85052_h() != null) {
                ItemStack stack;
                Item item;
                if (result.field_72308_g instanceof Player && (item = (stack = ((Player)result.field_72308_g).func_184614_ca()).func_77973_b()).equals(ItemInit.honeyJarEmpty)) {
                    stack.func_190918_g(1);
                    this.func_145779_a(ItemInit.honeyJar, 1);
                    return;
                }
                if (!result.field_72308_g.equals((Object)this.func_85052_h()) && result.field_72308_g instanceof LivingEntity && IMaxAttack.dealMaxHealth((Entity)this, (LivingEntity)result.field_72308_g, 5).didSuccessfulHit()) {
                    int level = 0;
                    if (((LivingEntity)result.field_72308_g).func_70644_a(PotionInit.VULNERABILITY)) {
                        level = ((LivingEntity)result.field_72308_g).func_70660_b(PotionInit.VULNERABILITY).func_76458_c();
                    }
                    ((LivingEntity)result.field_72308_g).func_70690_d(new PotionEffect(PotionInit.VULNERABILITY, 150, level));
                }
            }
            this.func_70106_y();
        }
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void func_70071_h_() {
        super.func_70071_h_();
        if (this.field_70170_p.field_72995_K) {
            for (int k = 0; k < 2; ++k) {
                this.field_70170_p.func_175688_a(ParticleInit.HONEY_BUBBLE, this.field_70165_t + (this.field_70146_Z.nextDouble() - 0.5) * (double)this.field_70130_N, this.field_70163_u + this.field_70146_Z.nextDouble() * (double)this.field_70131_O - 0.25, this.field_70161_v + (this.field_70146_Z.nextDouble() - 0.5) * (double)this.field_70130_N, (this.field_70146_Z.nextDouble() - 0.5) * 2.0, -this.field_70146_Z.nextDouble(), (this.field_70146_Z.nextDouble() - 0.5) * 2.0, new int[0]);
            }
        }
    }

    protected float func_70185_h() {
        return 0.0f;
    }
}

