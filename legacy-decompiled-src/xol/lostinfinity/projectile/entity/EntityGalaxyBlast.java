/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.item.ItemEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.EnumParticleTypes
 *  net.minecraft.util.math.HitResult
 *  net.minecraft.util.math.HitResult$Type
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.projectile.entity;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.projectile.entity.EntityBaseThrowable;
import xol.lostinfinity.util.data.IMaxAttack;

public class EntityGalaxyBlast
extends EntityBaseThrowable {
    public EntityGalaxyBlast(Level par1World) {
        super(par1World);
        this.func_70105_a(0.5f, 0.5f);
    }

    public EntityGalaxyBlast(Level par1World, LivingEntity par2Mob) {
        super(par1World, par2Mob);
    }

    public EntityGalaxyBlast(Level par1World, double par2, double par4, double par6) {
        super(par1World, par2, par4, par6);
    }

    @Override
    protected void func_70184_a(HitResult result) {
        if (!this.field_70170_p.field_72995_K) {
            if (result.field_72308_g != null && this.func_85052_h() != null) {
                if (result.field_72308_g != this.func_85052_h() && result.field_72308_g instanceof Player) {
                    IMaxAttack.dealMaxHealth((Entity)this, (LivingEntity)result.field_72308_g, 5);
                    this.func_70106_y();
                }
            } else if (result.field_72313_a == HitResult.Type.BLOCK) {
                if (this.field_70170_p.func_180495_p(result.func_178782_a()).func_177230_c().equals(BlockInit.galDungeonTarget)) {
                    ItemEntity crystal = new ItemEntity(this.field_70170_p, (double)result.func_178782_a().func_177958_n(), (double)result.func_178782_a().func_177956_o(), (double)result.func_178782_a().func_177952_p(), new ItemStack(ItemInit.chargedGalaxyCrystal));
                    crystal.field_70159_w = 0.0;
                    crystal.field_70181_x = 0.0;
                    crystal.field_70179_y = 0.0;
                    this.field_70170_p.func_72838_d((Entity)crystal);
                    this.func_184185_a(SoundInit.GAME_DING, 1.0f, 1.0f);
                }
                this.func_70106_y();
            }
        }
    }

    protected float func_70185_h() {
        return 0.0f;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void func_70071_h_() {
        super.func_70071_h_();
        if (this.field_70170_p.field_72995_K) {
            for (int k = 0; k < 4; ++k) {
                this.field_70170_p.func_175688_a(EnumParticleTypes.SPELL_INSTANT, this.field_70165_t + (this.field_70146_Z.nextDouble() - 0.5) * (double)this.field_70130_N, this.field_70163_u + this.field_70146_Z.nextDouble() * (double)this.field_70131_O - 0.25, this.field_70161_v + (this.field_70146_Z.nextDouble() - 0.5) * (double)this.field_70130_N, (this.field_70146_Z.nextDouble() - 0.5) * 2.0, -this.field_70146_Z.nextDouble(), (this.field_70146_Z.nextDouble() - 0.5) * 2.0, new int[0]);
            }
        }
    }
}

