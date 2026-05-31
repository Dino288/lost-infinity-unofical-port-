/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.Mob
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.deviant.prime;

import javax.annotation.Nullable;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.ai.EntityAIFloatAttack;
import xol.lostinfinity.mob.entity.base.EntityFloatingBase;
import xol.lostinfinity.projectile.entity.EntityLivoraxBullet;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.load.LootTableRegistry;

public class EntityLivorax
extends EntityFloatingBase
implements IMaxAttack {
    public EntityLivorax(Level worldIn) {
        super(worldIn);
        this.func_70105_a(2.5f, 2.5f);
    }

    @Override
    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(1.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.32);
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(4000.0);
    }

    public boolean func_70652_k(Entity entity) {
        super.func_70652_k(entity);
        if (this.func_70638_az() != null) {
            IMaxAttack.dealMaxHealth((Entity)this, this.func_70638_az(), 1, 2.0f);
            return true;
        }
        return false;
    }

    @Override
    public void func_70636_d() {
        super.func_70636_d();
        this.field_70143_R = -1.0f;
    }

    protected SoundEvent func_184615_bR() {
        return SoundInit.LIVORAX_DEATH;
    }

    protected SoundEvent func_184601_bQ(DamageSource damageSourceIn) {
        return SoundInit.LIVORAX_HURT;
    }

    protected SoundEvent func_184639_G() {
        return SoundInit.LIVORAX_AMBIENT;
    }

    @Override
    @Nullable
    protected EntityAIFloatAttack createShootAI() {
        return new EntityAIFloatAttack((Mob)this, (world1, parent, x, y, z, fireballStrength) -> new EntityLivoraxBullet(this.field_70170_p, parent, (Entity)this.func_70638_az()), SoundInit.LIVORAX_ABILITY, 5);
    }

    protected ResourceLocation func_184647_J() {
        return LootTableRegistry.ENTITIES_LIVORAX;
    }

    @Override
    protected int numberOfLives() {
        return 80;
    }
}

