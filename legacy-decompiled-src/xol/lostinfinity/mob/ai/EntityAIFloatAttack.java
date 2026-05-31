/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.Mob
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.ai.EntityAIBase
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.ai;

import java.util.Random;
import java.util.function.BiFunction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.Level;
import xol.lostinfinity.mob.ai.IFireballAttack;
import xol.lostinfinity.mob.ai.IThrowableAttack;

public class EntityAIFloatAttack
extends EntityAIBase {
    private final Mob parentEntity;
    private final BiFunction<LivingEntity, Entity, Entity> createFireballFunc;
    public int attackTimer;
    private int attackDelay;
    private final int maxDistance;
    private final SoundEvent beforeShoot;
    private final SoundEvent onShoot;

    public EntityAIFloatAttack(Mob parentEntity, BiFunction<LivingEntity, Entity, Entity> createFireballFunc, int attackDelay, int maxDistance, SoundEvent beforeShoot, SoundEvent onShoot) {
        this.parentEntity = parentEntity;
        this.createFireballFunc = createFireballFunc;
        this.attackDelay = attackDelay;
        this.maxDistance = maxDistance;
        this.beforeShoot = beforeShoot;
        this.onShoot = onShoot;
    }

    public EntityAIFloatAttack(Mob ghast, IFireballAttack func) {
        this(ghast, func::createFireball, 20, 64, SoundEvents.field_187559_bL, SoundEvents.field_187557_bK);
    }

    public EntityAIFloatAttack(Mob ghast, IFireballAttack createFireball, SoundEvent onShoot) {
        this(ghast, createFireball::createFireball, 20, 64, null, onShoot);
    }

    public EntityAIFloatAttack(Mob ghast, IFireballAttack createFireball, SoundEvent onShoot, int delay) {
        this(ghast, createFireball::createFireball, delay, 64, null, onShoot);
    }

    public EntityAIFloatAttack(Mob ghast, IThrowableAttack createThrowable, SoundEvent onShoot) {
        this(ghast, createThrowable::createFireball, 20, 64, null, onShoot);
    }

    public boolean func_75250_a() {
        return this.parentEntity.func_70638_az() != null;
    }

    public void func_75249_e() {
        this.attackTimer = 0;
    }

    public void updateDelay(int newDelay) {
        this.attackDelay = newDelay;
    }

    public void func_75251_c() {
        this.parentEntity.func_70624_b(null);
    }

    public void func_75246_d() {
        LivingEntity entitylivingbase = this.parentEntity.func_70638_az();
        if (Math.sqrt(entitylivingbase.func_70068_e((Entity)this.parentEntity)) < (double)this.maxDistance && this.parentEntity.func_70685_l((Entity)entitylivingbase)) {
            Level world = this.parentEntity.field_70170_p;
            ++this.attackTimer;
            if (this.attackTimer == this.attackDelay - 10) {
                this.playSound(this.beforeShoot);
            }
            if (this.attackTimer == this.attackDelay) {
                this.playSound(this.onShoot);
                world.func_72838_d(this.createFireballFunc.apply((LivingEntity)this.parentEntity, (Entity)entitylivingbase));
                this.attackTimer = this.attackDelay * -2;
            }
        } else if (this.attackTimer > 0) {
            --this.attackTimer;
        }
        if (this.attackTimer <= 10) {
            // empty if block
        }
    }

    private void playSound(SoundEvent event) {
        if (this.parentEntity == null || this.parentEntity.field_70170_p == null || event == null) {
            return;
        }
        Random rand = this.parentEntity.field_70170_p.field_73012_v;
        this.parentEntity.field_70170_p.func_184133_a(null, this.parentEntity.func_180425_c(), event, SoundSource.HOSTILE, 10.0f, (rand.nextFloat() - rand.nextFloat()) * 0.2f + 1.0f);
    }
}

