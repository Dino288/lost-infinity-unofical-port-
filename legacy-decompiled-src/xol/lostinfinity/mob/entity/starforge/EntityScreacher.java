/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.player.Player
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.util.math.Vec3
 *  net.minecraft.world.EnumDifficulty
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.starforge;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.Difficulty;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.ai.EntityAIFloatAttack;
import xol.lostinfinity.mob.entity.base.EntityFloatingBase;
import xol.lostinfinity.projectile.entity.EntitySonicAttack;
import xol.lostinfinity.util.data.IMaxAttack;

public class EntityScreacher
extends EntityFloatingBase
implements IMaxAttack {
    public EntityScreacher(Level worldIn) {
        super(worldIn);
        this.func_70105_a(6.0f, 3.0f);
    }

    @Override
    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(10000.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.0);
        this.func_110148_a(SharedMonsterAttributes.field_111266_c).func_111128_a(1.0);
    }

    @Override
    public void func_70636_d() {
        super.func_70636_d();
        if (!this.field_70170_p.field_72995_K && !this.field_70128_L) {
            this.func_70606_j(this.func_110138_aP());
        }
        if (this.field_70173_aa % 20 == 0) {
            boolean did_shot = false;
            for (Player near_pl : this.field_70170_p.func_72872_a(Player.class, this.func_174813_aQ().func_72314_b(45.0, 45.0, 45.0))) {
                if (near_pl.func_184812_l_() || this.field_70170_p.field_72995_K) continue;
                Vec3 vec3d = this.func_70676_i(1.0f);
                double makeX = (this.func_174813_aQ().field_72340_a + this.func_174813_aQ().field_72336_d) / 2.0;
                double makeY = this.field_70163_u + (double)(this.field_70131_O / 2.0f) + 0.5;
                double makeZ = (this.func_174813_aQ().field_72339_c + this.func_174813_aQ().field_72334_f) / 2.0;
                double d2 = near_pl.field_70165_t - makeX;
                double d3 = near_pl.func_174813_aQ().field_72338_b + (double)(near_pl.field_70131_O / 2.0f) - makeY;
                double d4 = near_pl.field_70161_v - makeZ;
                EntitySonicAttack shot = new EntitySonicAttack(this.field_70170_p, (LivingEntity)this);
                shot.func_70186_c(d2, d3, d4, 2.0f, 0.0f);
                this.field_70170_p.func_72838_d((Entity)shot);
                did_shot = true;
            }
            if (did_shot) {
                this.func_184185_a(SoundInit.STARFORGE_SCREACHER_ATTACK, 2.0f, 0.5f + this.field_70146_Z.nextFloat());
            }
        }
    }

    protected SoundEvent func_184615_bR() {
        return null;
    }

    protected SoundEvent func_184601_bQ(DamageSource damageSourceIn) {
        return null;
    }

    protected SoundEvent func_184639_G() {
        return SoundInit.STARFORGE_SCREACHER_AMBIENT;
    }

    protected boolean func_70692_ba() {
        return false;
    }

    public int func_70641_bl() {
        return 1;
    }

    @Override
    public boolean func_70601_bi() {
        return this.field_70170_p.func_175659_aa() != EnumDifficulty.PEACEFUL;
    }

    @Override
    protected EntityAIFloatAttack createShootAI() {
        return null;
    }
}

