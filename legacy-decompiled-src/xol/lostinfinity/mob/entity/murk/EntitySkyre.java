/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.player.Player
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.murk;

import java.util.Arrays;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.ai.EntityAIFloatAttack;
import xol.lostinfinity.mob.entity.base.EntityFloatingBase;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.load.LootTableRegistry;

public class EntitySkyre
extends EntityFloatingBase
implements IMaxAttack {
    private LivingEntity darkTarget = null;
    private boolean canIgnoreHeight = false;

    public EntitySkyre(Level worldIn) {
        super(worldIn);
        this.func_70105_a(4.0f, 10.0f);
    }

    public boolean func_70652_k(Entity entity) {
        super.func_70652_k(entity);
        if (this.func_70638_az() != null) {
            IMaxAttack.dealMaxHealth((Entity)this, this.func_70638_az(), 2, 3.0f, Arrays.asList("Darkborn"));
            if (this.darkTarget != null && entity.func_110124_au().equals(this.darkTarget.func_110124_au())) {
                this.func_145779_a(ItemInit.chewedSkull, 1);
                this.field_70170_p.func_184133_a(null, this.func_180425_c(), SoundInit.CRUNCHING, SoundSource.HOSTILE, 2.0f, 1.0f);
            }
            return true;
        }
        return false;
    }

    public void setMyDarkTarget(LivingEntity t) {
        this.darkTarget = t;
        this.func_70624_b(t);
    }

    @Override
    public void func_70636_d() {
        super.func_70636_d();
        if (!this.field_70170_p.field_72995_K) {
            if (this.darkTarget != null) {
                if (this.darkTarget.field_70128_L) {
                    this.darkTarget = null;
                } else {
                    this.rawFlySpeed = 0.98f;
                    this.func_70605_aq().func_75642_a(this.darkTarget.field_70165_t, this.darkTarget.field_70163_u, this.darkTarget.field_70161_v, 1.0);
                }
            } else {
                this.rawFlySpeed = 0.91f;
                boolean found = false;
                if (this.field_70173_aa % 10 == 0) {
                    for (Player near_pl : this.field_70170_p.func_72872_a(Player.class, this.func_174813_aQ().func_186662_g(20.0))) {
                        if (near_pl.func_184614_ca().func_77973_b() != ItemInit.beaconOfDarkness) continue;
                        this.func_70605_aq().func_75642_a(near_pl.field_70165_t, near_pl.field_70163_u, near_pl.field_70161_v, 1.0);
                        found = true;
                        this.canIgnoreHeight = true;
                        break;
                    }
                    if (!found) {
                        this.canIgnoreHeight = false;
                    }
                }
                if (!found) {
                    if (this.func_70638_az() != null) {
                        LivingEntity target = this.func_70638_az();
                        this.func_70605_aq().func_75642_a(target.field_70165_t, target.field_70163_u, target.field_70161_v, 1.0);
                    } else if (this.field_70163_u < 120.0 && !this.canIgnoreHeight) {
                        this.field_70181_x = 0.25;
                        this.field_70133_I = true;
                    }
                }
            }
        }
    }

    @Override
    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(4000.0);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(1.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.25);
        this.func_110148_a(SharedMonsterAttributes.field_111266_c).func_111128_a(1.0);
    }

    protected SoundEvent func_184615_bR() {
        return SoundInit.SKYRE_DEATH;
    }

    protected SoundEvent func_184601_bQ(DamageSource damageSourceIn) {
        return SoundInit.SKYRE_HURT;
    }

    protected SoundEvent func_184639_G() {
        return SoundInit.SKYRE_AMBIENT;
    }

    @Override
    protected int numberOfLives() {
        return 15;
    }

    @Override
    protected void func_82167_n(Entity entityIn) {
        super.func_82167_n(entityIn);
        if (this.darkTarget != null && entityIn.func_110124_au().equals(this.darkTarget.func_110124_au()) && this.attackCooldown == 0) {
            this.func_70652_k(entityIn);
            this.attackCooldown = this.attackGracePeriod;
        }
    }

    @Override
    public boolean func_70601_bi() {
        return super.func_70601_bi() && this.nothingInRadius(45);
    }

    @Override
    protected EntityAIFloatAttack createShootAI() {
        return null;
    }

    protected ResourceLocation func_184647_J() {
        return LootTableRegistry.ENTITIES_SKYRE;
    }
}

