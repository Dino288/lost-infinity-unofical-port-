/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.entity.Mob
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.ai.EntityAIBase
 *  net.minecraft.entity.ai.EntityAITasks$EntityAITaskEntry
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.item.Item
 *  net.minecraft.pathfinding.PathNodeType
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.world.EnumDifficulty
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.deviant;

import javax.annotation.Nullable;
import net.minecraft.world.entity.Mob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAITasks;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.Item;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.Difficulty;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.mob.ai.EntityAIFloatAttack;
import xol.lostinfinity.mob.entity.base.EntityFloatingDeviant;
import xol.lostinfinity.projectile.entity.EntityDeviantFireball;
import xol.lostinfinity.util.load.LootTableRegistry;

public class EntityDeviantSkyworm
extends EntityFloatingDeviant {
    public EntityDeviantSkyworm(Level worldIn) {
        super(worldIn);
        this.func_70105_a(2.5f, 2.8f);
        this.func_184644_a(PathNodeType.WATER, -1.0f);
    }

    public float func_70047_e() {
        return 0.5f;
    }

    @Override
    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(200.0);
    }

    @Override
    public void updateSupermutationAI() {
        for (EntityAITasks.EntityAITaskEntry task : this.field_70714_bg.field_75782_a) {
            EntityAIBase ai = task.field_75733_a;
            if (!(ai instanceof EntityAIFloatAttack)) continue;
            ((EntityAIFloatAttack)ai).updateDelay(10 - 2 * this.getMutation());
        }
    }

    @Override
    @Nullable
    protected EntityAIFloatAttack createShootAI() {
        return new EntityAIFloatAttack((Mob)this, (world1, parent, x, y, z, fireballStrength) -> new EntityDeviantFireball(this.field_70170_p, parent, x, y, z, 3, 0.0f), SoundEvents.field_187527_aQ, 20);
    }

    protected SoundEvent func_184615_bR() {
        return SoundEvents.field_187525_aO;
    }

    protected SoundEvent func_184601_bQ(DamageSource damageSourceIn) {
        return SoundEvents.field_187526_aP;
    }

    protected SoundEvent func_184639_G() {
        return SoundEvents.field_187521_aK;
    }

    @Override
    protected Item playerInput() {
        return ItemInit.celestialDiamond;
    }

    @Override
    protected Item mutantOutput() {
        return ItemInit.moltenDiamond;
    }

    @Override
    public boolean func_70601_bi() {
        return this.field_70146_Z.nextInt(5) == 0 && this.field_70170_p.func_175659_aa() != EnumDifficulty.PEACEFUL && this.field_70170_p.field_73011_w.getDimension() == 0;
    }

    @Override
    protected ResourceLocation deviantDrop() {
        return LootTableRegistry.ENTITIES_DEVIANTSKYWORM;
    }

    @Override
    protected ResourceLocation superMutatedDrop() {
        return LootTableRegistry.ENTITIES_SUPERMUTANT_SKYWORM;
    }
}

