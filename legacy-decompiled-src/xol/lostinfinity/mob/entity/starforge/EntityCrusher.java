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
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.world.EnumDifficulty
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.starforge;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.Difficulty;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.entity.base.EntityMultipleLives;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.load.LootTableRegistry;

public class EntityCrusher
extends EntityMultipleLives
implements IMaxAttack {
    private float speed = 0.0f;
    private boolean movingUpwards = true;
    private int timer = 100;

    public EntityCrusher(Level worldIn) {
        super(worldIn);
        this.func_70105_a(1.2f, 2.5f);
        this.func_189654_d(true);
    }

    @Override
    protected void func_184651_r() {
    }

    protected void func_82167_n(Entity entityIn) {
        Player play;
        if (entityIn instanceof Player && this.field_70173_aa % 5 == 0 && !(play = (Player)entityIn).func_184812_l_()) {
            IMaxAttack.dealMaxHealth((Entity)this, (LivingEntity)play, 3);
        }
        entityIn.func_70108_f((Entity)this);
    }

    public void func_70636_d() {
        super.func_70636_d();
        this.field_70143_R = -1.0f;
        if (!this.field_70170_p.field_72995_K) {
            if (this.field_70173_aa % this.timer == 0) {
                this.reverseDirection();
            }
            if (this.speed < 0.5f) {
                this.speed += 0.02f;
            }
            this.field_70181_x = this.movingUpwards ? (double)this.speed : (double)(-this.speed);
            this.field_70133_I = true;
        }
    }

    private void reverseDirection() {
        this.movingUpwards = !this.movingUpwards;
        this.speed = 0.0f;
        this.timer = 80 + this.field_70146_Z.nextInt(60);
    }

    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(1000.0);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(1.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.25);
        this.func_110148_a(SharedMonsterAttributes.field_111266_c).func_111128_a(1.0);
    }

    protected SoundEvent func_184615_bR() {
        return SoundInit.CRUSHER_DEATH;
    }

    protected SoundEvent func_184601_bQ(DamageSource damageSourceIn) {
        return SoundInit.CRUSHER_HURT;
    }

    protected SoundEvent func_184639_G() {
        return SoundInit.CRUSHER_DEATH;
    }

    @Override
    protected int numberOfLives() {
        return 3;
    }

    @Override
    public boolean func_70601_bi() {
        return this.field_70170_p.func_175659_aa() != EnumDifficulty.PEACEFUL;
    }

    protected ResourceLocation func_184647_J() {
        return LootTableRegistry.ENTITIES_CRUSHER;
    }
}

