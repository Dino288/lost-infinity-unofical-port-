/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.item.ItemEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.init.Blocks
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.math.HitResult
 *  net.minecraft.util.math.HitResult$Type
 *  net.minecraft.world.World
 *  net.minecraftforge.common.BiomeDictionary
 *  net.minecraftforge.common.BiomeDictionary$Type
 */
package xol.lostinfinity.projectile.entity;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.BiomeDictionary;
import xol.lostinfinity.projectile.entity.EntityBaseThrowable;

public class EntityExothermite
extends EntityBaseThrowable {
    private ItemStack stack = null;

    public EntityExothermite(Level par1World) {
        super(par1World);
    }

    public EntityExothermite(Level par1World, LivingEntity par2Mob) {
        super(par1World, par2Mob);
    }

    public EntityExothermite(Level par1World, double par2, double par4, double par6) {
        super(par1World, par2, par4, par6);
    }

    @Override
    protected void func_70184_a(HitResult result) {
        if (!this.field_70170_p.field_72995_K && this.stack != null) {
            boolean flag = false;
            if (result.field_72308_g != null && result.field_72308_g instanceof Player) {
                Player target = (Player)result.field_72308_g;
                if (this.stack != null) {
                    target.func_191521_c(this.stack.func_77946_l());
                    flag = true;
                }
            }
            if (result.field_72313_a == HitResult.Type.BLOCK && BiomeDictionary.getBiomes((BiomeDictionary.Type)BiomeDictionary.Type.SNOWY).contains(this.field_70170_p.func_180494_b(this.func_180425_c())) && this.field_70170_p.func_180495_p(result.func_178782_a()).func_177230_c().equals(Blocks.field_150432_aD)) {
                if (this.stack.func_77942_o() && this.stack.func_77978_p().func_74764_b("progress")) {
                    long progress = this.stack.func_77978_p().func_74763_f("progress");
                    this.stack.func_77978_p().func_74772_a("progress", progress += 100L);
                }
                this.field_70170_p.func_175656_a(result.func_178782_a(), Blocks.field_150355_j.func_176223_P());
            }
            if (!flag) {
                ItemEntity exo = new ItemEntity(this.field_70170_p, (double)result.func_178782_a().func_177958_n(), (double)result.func_178782_a().func_177956_o(), (double)result.func_178782_a().func_177952_p(), this.stack);
                this.field_70170_p.func_72838_d((Entity)exo);
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

