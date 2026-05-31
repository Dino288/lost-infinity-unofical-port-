/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.math.HitResult
 *  net.minecraft.world.World
 */
package xol.lostinfinity.projectile.entity;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.item.weapon.droid.ItemDroidRelocatorStorage;
import xol.lostinfinity.mob.entity.misc.EntityDroid;
import xol.lostinfinity.projectile.entity.EntityBaseThrowable;

public class EntityDroidSucker
extends EntityBaseThrowable {
    public EntityDroidSucker(Level par1World) {
        super(par1World);
    }

    public EntityDroidSucker(Level par1World, LivingEntity par2Mob) {
        super(par1World, par2Mob);
    }

    @Override
    protected void func_70184_a(HitResult result) {
        if (!this.field_70170_p.field_72995_K) {
            ItemStack held;
            int count = 0;
            for (EntityDroid droid : this.field_70170_p.func_72872_a(EntityDroid.class, this.func_174813_aQ().func_72314_b(30.0, 30.0, 30.0))) {
                droid.func_70106_y();
                ++count;
            }
            if (this.func_85052_h() != null && !(held = this.func_85052_h().func_184586_b(InteractionHand.MAIN_HAND)).func_190926_b() && held.func_77973_b() instanceof ItemDroidRelocatorStorage && held.func_77942_o()) {
                int current = held.func_77978_p().func_74762_e("Stored");
                held.func_77978_p().func_74768_a("Stored", current + count);
            }
            this.func_70106_y();
        }
        this.func_184185_a(SoundInit.LARGE_TELEPORT, 1.0f, 1.0f);
    }

    protected float func_70185_h() {
        return 0.05f;
    }
}

