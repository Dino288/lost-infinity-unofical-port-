/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.PathfinderMob
 *  net.minecraft.entity.Mob
 *  net.minecraft.entity.ai.EntityAIAttackMelee
 *  net.minecraft.entity.ai.EntityAIBase
 *  net.minecraft.entity.ai.EntityAIHurtByTarget
 *  net.minecraft.entity.ai.EntityAILookIdle
 *  net.minecraft.entity.ai.EntityAIMoveThroughVillage
 *  net.minecraft.entity.ai.EntityAIMoveTowardsRestriction
 *  net.minecraft.entity.ai.EntityAINearestAttackableTarget
 *  net.minecraft.entity.ai.EntityAISwimming
 *  net.minecraft.entity.ai.EntityAIWanderAvoidWater
 *  net.minecraft.entity.ai.EntityAIWatchClosest
 *  net.minecraft.entity.monster.EntityIronGolem
 *  net.minecraft.entity.monster.EntityPigZombie
 *  net.minecraft.entity.passive.EntityVillager
 *  net.minecraft.entity.player.Player
 */
package xol.lostinfinity.mob.ai;

import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.Mob;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.world.entity.player.Player;

public interface IBasicAI {
    default public void initBasicTasks(PathfinderMob entityIn) {
        entityIn.field_70714_bg.func_75776_a(0, (EntityAIBase)new EntityAISwimming((Mob)entityIn));
        entityIn.field_70714_bg.func_75776_a(2, (EntityAIBase)new EntityAIAttackMelee(entityIn, 1.0, true));
        entityIn.field_70714_bg.func_75776_a(5, (EntityAIBase)new EntityAIMoveTowardsRestriction(entityIn, 1.0));
        entityIn.field_70714_bg.func_75776_a(6, (EntityAIBase)new EntityAIMoveThroughVillage(entityIn, 1.0, false));
        entityIn.field_70714_bg.func_75776_a(7, (EntityAIBase)new EntityAIWanderAvoidWater(entityIn, 1.0));
        entityIn.field_70714_bg.func_75776_a(8, (EntityAIBase)new EntityAIWatchClosest((Mob)entityIn, Player.class, 8.0f));
        entityIn.field_70714_bg.func_75776_a(8, (EntityAIBase)new EntityAILookIdle((Mob)entityIn));
        entityIn.field_70715_bh.func_75776_a(1, (EntityAIBase)new EntityAIHurtByTarget(entityIn, true, new Class[]{EntityPigZombie.class}));
        entityIn.field_70715_bh.func_75776_a(2, (EntityAIBase)new EntityAINearestAttackableTarget(entityIn, Player.class, true));
        entityIn.field_70715_bh.func_75776_a(3, (EntityAIBase)new EntityAINearestAttackableTarget(entityIn, EntityVillager.class, false));
        entityIn.field_70715_bh.func_75776_a(3, (EntityAIBase)new EntityAINearestAttackableTarget(entityIn, EntityIronGolem.class, true));
    }
}

