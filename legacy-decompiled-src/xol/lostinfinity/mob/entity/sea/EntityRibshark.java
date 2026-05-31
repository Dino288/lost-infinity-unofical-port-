/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.PathfinderMob
 *  net.minecraft.entity.Mob
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.ai.EntityAIAttackMelee
 *  net.minecraft.entity.ai.EntityAIBase
 *  net.minecraft.entity.ai.EntityAINearestAttackableTarget
 *  net.minecraft.entity.ai.EntityAIWatchClosest
 *  net.minecraft.entity.player.Player
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.sea;

import java.util.Arrays;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.ai.EntityAILookAround;
import xol.lostinfinity.mob.ai.EntityAIRandomFly;
import xol.lostinfinity.mob.entity.sea.EntitySeaCreature;
import xol.lostinfinity.util.data.IMaxAttack;

public class EntityRibshark
extends EntitySeaCreature {
    public EntityRibshark(Level worldIn) {
        super(worldIn);
        this.rawFlySpeed = 0.95f;
        this.func_70105_a(1.5f, 1.5f);
    }

    @Override
    protected void func_184651_r() {
        this.field_70714_bg.func_75776_a(5, (EntityAIBase)new EntityAIRandomFly((Mob)this));
        this.field_70714_bg.func_75776_a(7, (EntityAIBase)new EntityAILookAround((Mob)this));
        this.field_70714_bg.func_75776_a(9, (EntityAIBase)new EntityAIWatchClosest((Mob)this, Player.class, 3.0f, 1.0f));
        this.field_70714_bg.func_75776_a(10, (EntityAIBase)new EntityAIAttackMelee((PathfinderMob)this, 1.0, true));
        this.field_70715_bh.func_75776_a(3, (EntityAIBase)new EntityAINearestAttackableTarget((PathfinderMob)this, Player.class, false));
    }

    public boolean func_70652_k(Entity entity) {
        super.func_70652_k(entity);
        if (this.func_70638_az() != null) {
            IMaxAttack.dealTrueDamage((Entity)this, this.func_70638_az(), this.func_70638_az().func_110138_aP() * 0.4f, Arrays.asList("Aquatic"));
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
        }
    }

    protected SoundEvent func_184615_bR() {
        return SoundInit.RIB_SHARK_DEATH;
    }

    protected SoundEvent func_184601_bQ(DamageSource damageSourceIn) {
        return SoundInit.RIB_SHARK_HURT;
    }

    protected SoundEvent func_184639_G() {
        return SoundInit.RIB_SHARK_AMBIENT;
    }
}

