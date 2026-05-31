/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.player.Player
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.deviant;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.ai.EntityAIFloatAttack;
import xol.lostinfinity.mob.entity.base.EntityFloatingDeviant;
import xol.lostinfinity.mob.entity.base.IConditionalDamage;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.load.LootTableRegistry;

public class EntityDeviantSquid
extends EntityFloatingDeviant
implements IMaxAttack,
IConditionalDamage {
    private int eatTimer = 0;

    public EntityDeviantSquid(Level worldIn) {
        super(worldIn);
        this.func_70105_a(4.0f, 4.0f);
        this.rawFlySpeed = 0.95f;
    }

    @Override
    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(1.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.4);
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(2000.0);
    }

    public boolean func_70652_k(Entity entity) {
        super.func_70652_k(entity);
        if (this.func_70638_az() != null) {
            IMaxAttack.dealMaxHealth((Entity)this, this.func_70638_az(), 4 - this.getMutation());
            return true;
        }
        return false;
    }

    @Override
    public void func_70636_d() {
        super.func_70636_d();
        if (!this.field_70170_p.field_72995_K) {
            if (this.eatTimer > 0) {
                --this.eatTimer;
            }
            if (this.func_70638_az() != null) {
                LivingEntity target = this.func_70638_az();
                this.func_70605_aq().func_75642_a(target.field_70165_t, target.field_70163_u, target.field_70161_v, 1.0);
            }
        }
    }

    @Override
    public boolean func_184645_a(Player player, InteractionHand hand) {
        ItemStack held = player.func_184586_b(hand);
        if (held.func_77973_b().equals(ItemInit.acidbloodSolution)) {
            if (!this.field_70170_p.field_72995_K) {
                player.func_145747_a((Component)new Component((Object)((Object)TextFmt.Aqua) + "The squid swallows the acid, temporarily weakening its husk."));
                this.eatTimer = 100;
            }
            this.func_184185_a(SoundInit.CREATURE_FEED, 1.5f, 1.0f);
            held.func_190918_g(1);
        }
        super.func_184645_a(player, hand);
        return true;
    }

    public boolean func_70648_aU() {
        return true;
    }

    protected SoundEvent func_184615_bR() {
        return SoundEvents.field_187831_fR;
    }

    protected SoundEvent func_184601_bQ(DamageSource damageSourceIn) {
        return SoundEvents.field_187833_fS;
    }

    protected SoundEvent func_184639_G() {
        return SoundEvents.field_187829_fQ;
    }

    @Override
    protected ResourceLocation deviantDrop() {
        return LootTableRegistry.ENTITIES_DEVIANTSQUID;
    }

    @Override
    protected ResourceLocation superMutatedDrop() {
        return LootTableRegistry.ENTITIES_SUPERMUTANT_SQUID;
    }

    @Override
    protected EntityAIFloatAttack createShootAI() {
        return null;
    }

    @Override
    public boolean canBeDamaged(Entity attacker) {
        return this.eatTimer > 0;
    }
}

