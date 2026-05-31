/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.PathfinderMob
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.monster.Monster
 *  net.minecraft.entity.player.Player
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.world.EnumDifficulty
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.deviant;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.Difficulty;
import net.minecraft.world.level.Level;
import xol.lostinfinity.mob.ai.IBasicAI;
import xol.lostinfinity.util.data.IMaxAttack;

public class EntityLostDeviant
extends Monster
implements IMaxAttack,
IBasicAI {
    public EntityLostDeviant(Level worldIn) {
        super(worldIn);
        this.func_70105_a(1.0f, 2.0f);
    }

    protected void func_184651_r() {
        this.initBasicTasks((PathfinderMob)this);
    }

    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(0.5);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.27);
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(500.0);
    }

    public boolean func_70652_k(Entity entity) {
        super.func_70652_k(entity);
        if (this.func_70638_az() != null) {
            IMaxAttack.dealMaxHealth((Entity)this, this.func_70638_az(), 5);
            return true;
        }
        return false;
    }

    public void func_70636_d() {
        super.func_70636_d();
        this.field_70143_R = -1.0f;
        if (this.field_70173_aa % 40 == 0 && this.func_70638_az() != null && this.func_70638_az() instanceof Player) {
            Player pl = (Player)this.func_70638_az();
            this.func_70024_g((pl.field_70165_t - this.field_70165_t) * 0.145, 1.0, (pl.field_70161_v - this.field_70161_v) * 0.145);
            this.field_70133_I = true;
        }
    }

    protected SoundEvent func_184615_bR() {
        return SoundEvents.field_193786_de;
    }

    protected SoundEvent func_184601_bQ(DamageSource damageSourceIn) {
        return SoundEvents.field_193789_dh;
    }

    protected SoundEvent func_184639_G() {
        return SoundEvents.field_193790_di;
    }

    protected boolean func_70692_ba() {
        int time = (int)(this.field_70170_p.func_72820_D() % 24000L);
        return time > 13000 && time < 18000;
    }

    public boolean func_70814_o() {
        return true;
    }

    public boolean func_70601_bi() {
        return this.field_70170_p.func_175659_aa() != EnumDifficulty.PEACEFUL;
    }
}

