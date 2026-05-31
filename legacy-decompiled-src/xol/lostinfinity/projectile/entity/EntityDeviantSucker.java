/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Mob
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.math.HitResult
 *  net.minecraft.world.World
 */
package xol.lostinfinity.projectile.entity;

import java.util.ArrayList;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.item.tool.ItemDeviantRelocator;
import xol.lostinfinity.mob.entity.base.EntityDeviantMob;
import xol.lostinfinity.mob.entity.base.EntityFloatingDeviant;
import xol.lostinfinity.projectile.entity.EntityBaseThrowable;

public class EntityDeviantSucker
extends EntityBaseThrowable {
    public EntityDeviantSucker(Level par1World) {
        super(par1World);
    }

    public EntityDeviantSucker(Level par1World, LivingEntity par2Mob) {
        super(par1World, par2Mob);
    }

    @Override
    protected void func_70184_a(HitResult result) {
        if (!this.field_70170_p.field_72995_K) {
            ItemStack held;
            boolean count = false;
            ArrayList<Class<? extends Mob>> foundDeviants = new ArrayList<Class<? extends Mob>>();
            for (Mob found_creature : this.field_70170_p.func_72872_a(Mob.class, this.func_174813_aQ().func_72314_b(20.0, 20.0, 20.0))) {
                if (!(found_creature instanceof EntityDeviantMob) && !(found_creature instanceof EntityFloatingDeviant)) continue;
                foundDeviants.add(found_creature.getClass());
                found_creature.func_70106_y();
            }
            if (this.func_85052_h() != null && !(held = this.func_85052_h().func_184586_b(InteractionHand.MAIN_HAND)).func_190926_b() && held.func_77973_b().equals(ItemInit.deviantRelocator)) {
                ItemDeviantRelocator heldRel = (ItemDeviantRelocator)held.func_77973_b();
                heldRel.passDeviantList(foundDeviants);
            }
            this.func_70106_y();
        }
        this.func_184185_a(SoundInit.SCANNER, 1.0f, 1.0f);
    }

    protected float func_70185_h() {
        return 0.05f;
    }
}

