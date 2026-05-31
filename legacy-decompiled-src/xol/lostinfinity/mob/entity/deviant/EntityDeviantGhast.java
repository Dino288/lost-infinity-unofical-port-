/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.entity.Mob
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.ai.EntityAIBase
 *  net.minecraft.entity.ai.EntityAITasks$EntityAITaskEntry
 *  net.minecraft.init.Items
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.item.Item
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
import net.minecraft.world.item.Items;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.Item;
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

public class EntityDeviantGhast
extends EntityFloatingDeviant {
    public EntityDeviantGhast(Level worldIn) {
        super(worldIn);
        this.func_70105_a(3.5f, 4.8f);
    }

    @Override
    @Nullable
    protected EntityAIFloatAttack createShootAI() {
        return new EntityAIFloatAttack((Mob)this, (world1, parent, x, y, z, fireballStrength) -> new EntityDeviantFireball(this.field_70170_p, parent, x, y, z, 8, 4.0f), SoundEvents.field_187606_E, 8);
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
    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(500.0);
    }

    public float func_70047_e() {
        return 1.5f;
    }

    @Override
    protected Item playerInput() {
        return Items.field_151131_as;
    }

    @Override
    protected Item mutantOutput() {
        return ItemInit.smolderingGhastTear;
    }

    public boolean func_70097_a(DamageSource source, float amount) {
        if (source == DamageSource.field_76371_c || source == DamageSource.field_76370_b || source == DamageSource.field_76372_a) {
            return false;
        }
        return super.func_70097_a(source, amount);
    }

    protected SoundEvent func_184615_bR() {
        return SoundEvents.field_187553_bI;
    }

    protected SoundEvent func_184601_bQ(DamageSource damageSourceIn) {
        return SoundEvents.field_187555_bJ;
    }

    protected SoundEvent func_184639_G() {
        return SoundEvents.field_187551_bH;
    }

    @Override
    public boolean func_70601_bi() {
        return super.func_70601_bi() && this.field_70170_p.func_175659_aa() != EnumDifficulty.PEACEFUL;
    }

    @Override
    protected ResourceLocation deviantDrop() {
        return LootTableRegistry.ENTITIES_DEVIANTGHAST;
    }

    @Override
    protected ResourceLocation superMutatedDrop() {
        return LootTableRegistry.ENTITIES_SUPERMUTANT_GHAST;
    }
}

