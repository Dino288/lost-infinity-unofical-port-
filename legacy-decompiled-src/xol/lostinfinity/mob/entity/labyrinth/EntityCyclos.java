/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.player.Player
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.labyrinth;

import net.minecraft.world.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.entity.base.EntityMultipleLives;
import xol.lostinfinity.util.data.IMaxAttack;

public class EntityCyclos
extends EntityMultipleLives
implements IMaxAttack {
    public EntityCyclos(Level worldIn) {
        super(worldIn);
        this.func_70105_a(1.0f, 1.5f);
    }

    public boolean func_70652_k(Entity entity) {
        super.func_70652_k(entity);
        if (this.func_70638_az() != null) {
            IMaxAttack.dealMaxHealth((Entity)this, this.func_70638_az(), 4);
            return true;
        }
        return false;
    }

    public void func_70636_d() {
        super.func_70636_d();
        if (this.field_70173_aa % 120 < 50) {
            if (this.field_70173_aa % 120 == 0) {
                this.func_184185_a(SoundInit.CYCLOS_AMBIENT, 2.0f, 1.0f);
            }
            for (Player near_pl : this.field_70170_p.func_72872_a(Player.class, this.func_174813_aQ().func_72314_b(12.0, 12.0, 12.0))) {
                if (near_pl.func_184812_l_()) continue;
                near_pl.field_70181_x = 0.85;
                near_pl.field_70133_I = true;
            }
        }
    }

    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(500.0);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(1.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.22);
        this.func_110148_a(SharedMonsterAttributes.field_111266_c).func_111128_a(1.0);
    }

    protected SoundEvent func_184615_bR() {
        return SoundInit.CYCLOS_DEATH;
    }

    protected SoundEvent func_184601_bQ(DamageSource damageSourceIn) {
        return SoundInit.CYCLOS_HURT;
    }

    protected SoundEvent func_184639_G() {
        return null;
    }

    @Override
    protected int numberOfLives() {
        return 5;
    }
}

