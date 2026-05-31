/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.player.Player
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.deviant;

import net.minecraft.world.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.PotionInit;
import xol.lostinfinity.mob.entity.base.EntityDeviantMob;
import xol.lostinfinity.mob.entity.base.IConditionalDamage;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.load.LootTableRegistry;

public class EntityDeviantWitherSkeleton
extends EntityDeviantMob
implements IConditionalDamage {
    public EntityDeviantWitherSkeleton(Level worldIn) {
        super(worldIn);
        this.func_70105_a(2.0f, 4.0f);
    }

    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(1.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.32);
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(2500.0);
    }

    public boolean func_70652_k(Entity entity) {
        super.func_70652_k(entity);
        if (this.func_70638_az() != null) {
            if (IMaxAttack.dealMaxHealth((Entity)this, this.func_70638_az(), 10, 8 + 1 * this.getMutation()).didSuccessfulHit()) {
                this.func_70638_az().func_70690_d(new PotionEffect(PotionInit.NULLIFIED, 100 + this.getMutation() * 200));
            }
            return true;
        }
        return false;
    }

    protected SoundEvent func_184615_bR() {
        return SoundEvents.field_187856_fd;
    }

    protected SoundEvent func_184601_bQ(DamageSource damageSourceIn) {
        return SoundEvents.field_187864_fh;
    }

    protected SoundEvent func_184639_G() {
        return SoundEvents.field_187854_fc;
    }

    @Override
    protected ResourceLocation deviantDrop() {
        return LootTableRegistry.ENTITIES_DEVIANTWITHERSKELETON;
    }

    @Override
    protected ResourceLocation superMutatedDrop() {
        return LootTableRegistry.ENTITIES_SUPERMUTANT_WITHERSKELETON;
    }

    @Override
    public boolean canBeDamaged(Entity attacker) {
        if (attacker instanceof Player) {
            return this.func_70032_d(attacker) < 3.0f;
        }
        return false;
    }
}

