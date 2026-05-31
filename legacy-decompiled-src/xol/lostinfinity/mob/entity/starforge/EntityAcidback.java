/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.PathfinderMob
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.monster.Monster
 *  net.minecraft.entity.player.Player
 *  net.minecraft.init.Items
 *  net.minecraft.init.MobEffects
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.datasync.DataParameter
 *  net.minecraft.network.datasync.DataSerializer
 *  net.minecraft.network.datasync.DataSerializers
 *  net.minecraft.network.datasync.EntityDataManager
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.EnumParticleTypes
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.world.EnumDifficulty
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.starforge;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializer;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.Difficulty;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.ai.IBasicAI;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.load.LootTableRegistry;

public class EntityAcidback
extends Monster
implements IMaxAttack,
IBasicAI {
    private int cooldown = 0;
    private static final DataParameter<Boolean> IS_VOLATILE = EntityDataManager.func_187226_a(EntityAcidback.class, (DataSerializer)DataSerializers.field_187198_h);

    public EntityAcidback(Level worldIn) {
        super(worldIn);
        this.func_70105_a(1.0f, 1.2f);
    }

    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a(IS_VOLATILE, (Object)false);
    }

    public boolean isVolatile() {
        return (Boolean)this.field_70180_af.func_187225_a(IS_VOLATILE);
    }

    public void setVolatility(boolean bool) {
        if (bool) {
            this.cooldown = 100;
        }
        this.field_70180_af.func_187227_b(IS_VOLATILE, (Object)bool);
    }

    public void func_70014_b(CompoundTag tag) {
        super.func_70014_b(tag);
        tag.func_74757_a("Volatility", this.isVolatile());
        tag.func_74768_a("VolCooldown", this.cooldown);
    }

    public void func_70037_a(CompoundTag tag) {
        super.func_70037_a(tag);
        this.setVolatility(tag.func_74767_n("Volatility"));
        this.cooldown = tag.func_74762_e("VolCooldown");
    }

    protected void func_184651_r() {
        this.initBasicTasks((PathfinderMob)this);
    }

    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(700.0);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(1.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.27);
        this.func_110148_a(SharedMonsterAttributes.field_111266_c).func_111128_a(1.0);
    }

    public boolean func_70652_k(Entity entity) {
        super.func_70652_k(entity);
        IMaxAttack.dealMaxHealth((Entity)this, this.func_70638_az(), 5);
        if (this.func_70638_az() instanceof Player && !this.field_70170_p.field_72995_K) {
            Player target = (Player)this.func_70638_az();
            boolean is_vol = this.isVolatile();
            if (is_vol) {
                this.func_70606_j(0.0f);
            } else {
                ItemStack held = target.func_184614_ca();
                if (held.func_77973_b().equals(Items.field_151069_bo) && target.func_70644_a(MobEffects.field_76436_u)) {
                    this.setVolatility(true);
                    held.func_190918_g(1);
                    this.func_145779_a(ItemInit.concentratedVenom, 1);
                }
            }
        }
        return true;
    }

    public void func_70636_d() {
        block8: {
            super.func_70636_d();
            if (!this.field_70170_p.field_72995_K && this.cooldown > 0) {
                --this.cooldown;
                if (this.cooldown == 0) {
                    this.setVolatility(false);
                }
            }
            if (this.field_70170_p.field_72995_K && this.isVolatile()) {
                for (int i = 0; i < 2; ++i) {
                    this.field_70170_p.func_175688_a(ParticleInit.ACID, this.field_70165_t + (this.field_70146_Z.nextDouble() - 0.5) * (double)this.field_70130_N, this.field_70163_u + this.field_70146_Z.nextDouble() * (double)this.field_70131_O - 0.25, this.field_70161_v + (this.field_70146_Z.nextDouble() - 0.5) * (double)this.field_70130_N, (this.field_70146_Z.nextDouble() - 0.5) * 10.0, 5.0, (this.field_70146_Z.nextDouble() - 0.5) * 3.0, new int[0]);
                }
            }
            if (!this.field_70128_L && !(this.func_110143_aJ() < 0.0f)) break block8;
            if (this.field_70170_p.field_72995_K) {
                float partspeed = this.isVolatile() ? 6.0f : 3.0f;
                for (int i = 0; i < 9; ++i) {
                    this.field_70170_p.func_175688_a(EnumParticleTypes.TOTEM, this.field_70165_t + (this.field_70146_Z.nextDouble() - 0.5) * (double)this.field_70130_N, this.field_70163_u + this.field_70146_Z.nextDouble() * (double)this.field_70131_O - 0.25, this.field_70161_v + (this.field_70146_Z.nextDouble() - 0.5) * (double)this.field_70130_N, (this.field_70146_Z.nextDouble() - 0.5) * (double)partspeed, 1.0, (this.field_70146_Z.nextDouble() - 0.5) * (double)partspeed, new int[0]);
                }
            } else {
                double aoe = this.isVolatile() ? 12.0 : 5.0;
                int denom = this.isVolatile() ? 8 : 4;
                for (LivingEntity near_pl : this.field_70170_p.func_72872_a(LivingEntity.class, this.func_174813_aQ().func_72314_b(aoe, aoe, aoe))) {
                    if (near_pl.func_110124_au().equals(this.func_110124_au())) continue;
                    IMaxAttack.dealMaxHealth((Entity)this, near_pl, denom);
                }
            }
        }
    }

    protected SoundEvent func_184615_bR() {
        return SoundInit.STARFORGE_ACIDBACK_DEATH;
    }

    protected SoundEvent func_184601_bQ(DamageSource damageSourceIn) {
        return SoundInit.STARFORGE_ACIDBACK_HURT;
    }

    protected SoundEvent func_184639_G() {
        return SoundInit.STARFORGE_ACIDBACK_AMBIENT;
    }

    protected ResourceLocation func_184647_J() {
        return LootTableRegistry.ENTITIES_STARFORGE_ACIDBACK;
    }

    protected boolean func_70692_ba() {
        return false;
    }

    public boolean func_70814_o() {
        return true;
    }

    public int func_70641_bl() {
        return 1;
    }

    public boolean func_70601_bi() {
        return this.field_70170_p.func_175659_aa() != EnumDifficulty.PEACEFUL;
    }
}

