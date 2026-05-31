/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.PathfinderMob
 *  net.minecraft.entity.Mob
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.ai.EntityAIBase
 *  net.minecraft.entity.ai.EntityAIHurtByTarget
 *  net.minecraft.entity.ai.EntityAILookIdle
 *  net.minecraft.entity.ai.EntityAIMoveTowardsRestriction
 *  net.minecraft.entity.ai.EntityAINearestAttackableTarget
 *  net.minecraft.entity.ai.EntityAIWanderAvoidWater
 *  net.minecraft.entity.ai.EntityAIWatchClosest
 *  net.minecraft.entity.player.Player
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.item.Item
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.util.math.Vec3
 *  net.minecraft.world.EnumDifficulty
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.deviant;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.world.entity.player.Player;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.Item;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.Difficulty;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.mob.entity.base.EntityDeviantMob;
import xol.lostinfinity.projectile.entity.EntityDeviantFireball;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.load.LootTableRegistry;

public class EntityDeviantBlaze
extends EntityDeviantMob
implements IMaxAttack {
    public EntityDeviantBlaze(Level worldIn) {
        super(worldIn);
        this.func_70105_a(3.5f, 6.0f);
    }

    @Override
    protected void func_184651_r() {
        this.field_70714_bg.func_75776_a(5, (EntityAIBase)new EntityAIMoveTowardsRestriction((PathfinderMob)this, 1.0));
        this.field_70714_bg.func_75776_a(7, (EntityAIBase)new EntityAIWanderAvoidWater((PathfinderMob)this, 1.0, 0.0f));
        this.field_70714_bg.func_75776_a(8, (EntityAIBase)new EntityAIWatchClosest((Mob)this, Player.class, 8.0f));
        this.field_70714_bg.func_75776_a(8, (EntityAIBase)new EntityAILookIdle((Mob)this));
        this.field_70715_bh.func_75776_a(1, (EntityAIBase)new EntityAIHurtByTarget((PathfinderMob)this, true, new Class[0]));
        this.field_70715_bh.func_75776_a(2, (EntityAIBase)new EntityAINearestAttackableTarget((PathfinderMob)this, Player.class, true));
    }

    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(0.5);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a((double)0.23f);
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(600.0);
    }

    public boolean func_70652_k(Entity entity) {
        super.func_70652_k(entity);
        if (this.func_70638_az() != null) {
            IMaxAttack.dealMaxHealth((Entity)this, this.func_70638_az(), 4 - (this.getMutation() > 0 ? 2 : 0));
            return true;
        }
        return false;
    }

    public void func_70636_d() {
        super.func_70636_d();
        if (this.field_70173_aa % (80 - 10 * this.getMutation()) <= 20 && this.field_70173_aa % 10 == 0) {
            boolean did_shot = false;
            for (Player near_pl : this.field_70170_p.func_72872_a(Player.class, this.func_174813_aQ().func_72314_b(30.0, 30.0, 30.0))) {
                if (near_pl.func_184812_l_() || this.field_70170_p.field_72995_K) continue;
                Vec3 vec3d = this.func_70676_i(1.0f);
                double makeX = (this.func_174813_aQ().field_72340_a + this.func_174813_aQ().field_72336_d) / 2.0;
                double makeY = this.field_70163_u + (double)(this.field_70131_O / 2.0f) + 0.5;
                double makeZ = (this.func_174813_aQ().field_72339_c + this.func_174813_aQ().field_72334_f) / 2.0;
                double d2 = near_pl.field_70165_t - makeX;
                double d3 = near_pl.func_174813_aQ().field_72338_b + (double)(near_pl.field_70131_O / 2.0f) - makeY;
                double d4 = near_pl.field_70161_v - makeZ;
                EntityDeviantFireball shot = new EntityDeviantFireball(this.field_70170_p, (LivingEntity)this, d2, d3, d4, 4, 0.5f);
                shot.field_70165_t = makeX;
                shot.field_70163_u = makeY;
                shot.field_70161_v = makeZ;
                this.field_70170_p.func_72838_d((Entity)shot);
                did_shot = true;
            }
            if (did_shot) {
                this.func_184185_a(SoundEvents.field_187606_E, 2.0f, 0.5f + this.field_70146_Z.nextFloat());
            }
        }
    }

    protected SoundEvent func_184615_bR() {
        return SoundEvents.field_187600_C;
    }

    protected SoundEvent func_184601_bQ(DamageSource damageSourceIn) {
        return SoundEvents.field_187603_D;
    }

    protected SoundEvent func_184639_G() {
        return SoundEvents.field_187594_A;
    }

    @Override
    protected Item playerInput() {
        return ItemInit.organicCalcium;
    }

    @Override
    protected Item mutantOutput() {
        return ItemInit.prismaticCalcium;
    }

    @Override
    protected boolean func_70692_ba() {
        int time = (int)(this.field_70170_p.func_72820_D() % 24000L);
        return time > 13000 && time < 18000;
    }

    @Override
    public boolean func_70814_o() {
        return true;
    }

    @Override
    public boolean func_70601_bi() {
        return this.field_70170_p.func_175659_aa() != EnumDifficulty.PEACEFUL;
    }

    @Override
    protected ResourceLocation deviantDrop() {
        return LootTableRegistry.ENTITIES_DEVIANTBLAZE;
    }

    @Override
    protected ResourceLocation superMutatedDrop() {
        return LootTableRegistry.ENTITIES_SUPERMUTANT_BLAZE;
    }
}

