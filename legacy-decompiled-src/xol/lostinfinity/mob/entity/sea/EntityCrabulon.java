/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.PathfinderMob
 *  net.minecraft.entity.Mob
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.IRangedAttackMob
 *  net.minecraft.entity.ai.EntityAIAttackMelee
 *  net.minecraft.entity.ai.EntityAIAttackRanged
 *  net.minecraft.entity.ai.EntityAIBase
 *  net.minecraft.entity.ai.EntityAINearestAttackableTarget
 *  net.minecraft.entity.ai.EntityAIWatchClosest
 *  net.minecraft.entity.player.Player
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.sea;

import java.util.Arrays;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIAttackRanged;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.ai.EntityAILookAround;
import xol.lostinfinity.mob.ai.EntityAIRandomFly;
import xol.lostinfinity.mob.entity.sea.EntitySeaCreature;
import xol.lostinfinity.projectile.entity.EntityCrabulonProjectile;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.load.LootTableRegistry;

public class EntityCrabulon
extends EntitySeaCreature
implements IRangedAttackMob {
    public EntityCrabulon(Level worldIn) {
        super(worldIn);
        this.func_70105_a(7.0f, 7.0f);
    }

    @Override
    protected void func_184651_r() {
        this.field_70714_bg.func_75776_a(5, (EntityAIBase)new EntityAIRandomFly((Mob)this));
        this.field_70714_bg.func_75776_a(7, (EntityAIBase)new EntityAILookAround((Mob)this));
        this.field_70714_bg.func_75776_a(9, (EntityAIBase)new EntityAIWatchClosest((Mob)this, Player.class, 3.0f, 1.0f));
        this.field_70714_bg.func_75776_a(10, (EntityAIBase)new EntityAIAttackMelee((PathfinderMob)this, 1.0, true));
        this.field_70714_bg.func_75776_a(11, (EntityAIBase)new EntityAIAttackRanged((IRangedAttackMob)this, 1.0, 20, 60, 15.0f));
        this.field_70715_bh.func_75776_a(3, (EntityAIBase)new EntityAINearestAttackableTarget((PathfinderMob)this, Player.class, false));
    }

    public boolean func_70652_k(Entity entity) {
        super.func_70652_k(entity);
        if (this.func_70638_az() != null) {
            IMaxAttack.dealTrueDamage((Entity)this, this.func_70638_az(), this.func_70638_az().func_110138_aP() * 0.75f, Arrays.asList("Aquatic"));
            return true;
        }
        return false;
    }

    @Override
    public void func_70636_d() {
        super.func_70636_d();
        if (this.field_70170_p.field_72995_K) {
            return;
        }
        if (this.func_70638_az() != null) {
            LivingEntity target = this.func_70638_az();
            this.func_70605_aq().func_75642_a(target.field_70165_t, target.field_70163_u, target.field_70161_v, 1.0);
            if (this.field_70173_aa % 60 == 0 && this.func_70032_d((Entity)target) > 4.0f) {
                this.func_82196_d(target, 1.0f);
            }
        }
    }

    public void func_82196_d(LivingEntity target, float distanceFactor) {
        EntityCrabulonProjectile projectile = new EntityCrabulonProjectile(this.field_70170_p, this.func_180425_c().func_177958_n(), (double)this.func_180425_c().func_177956_o() + 1.5, this.func_180425_c().func_177952_p());
        projectile.setThrower((LivingEntity)this);
        projectile.func_70186_c(this.func_70040_Z().field_72450_a, this.func_70040_Z().field_72448_b, this.func_70040_Z().field_72449_c, 1.5f, 0.0f);
        this.field_70170_p.func_72838_d((Entity)projectile);
    }

    protected ResourceLocation func_184647_J() {
        return LootTableRegistry.ENTITIES_CRABULON;
    }

    @Override
    protected int numberOfLives() {
        return 25;
    }

    public void func_184724_a(boolean swingingArms) {
    }

    protected SoundEvent func_184615_bR() {
        return SoundInit.CRABULON_DEATH;
    }

    protected SoundEvent func_184601_bQ(DamageSource damageSourceIn) {
        return SoundInit.CRABULON_HURT;
    }

    protected SoundEvent func_184639_G() {
        return SoundInit.CRABULON_AMBIENT;
    }
}

