/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.starforge;

import net.minecraft.world.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.PotionInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.ai.IBasicAI;
import xol.lostinfinity.mob.entity.base.EntityMultipleLives;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.load.LootTableRegistry;

public class EntitySnapper
extends EntityMultipleLives
implements IMaxAttack,
IBasicAI {
    public EntitySnapper(Level worldIn) {
        super(worldIn);
        this.func_70105_a(1.2f, 2.2f);
    }

    public boolean func_70652_k(Entity entity) {
        super.func_70652_k(entity);
        if (this.func_70638_az() != null) {
            if (IMaxAttack.dealMaxHealth((Entity)this, this.func_70638_az(), 4).didSuccessfulHit()) {
                this.func_70638_az().func_70690_d(new PotionEffect(PotionInit.PLAGUE, 200, 1));
            }
            return true;
        }
        return false;
    }

    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(1000.0);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(1.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.25);
        this.func_110148_a(SharedMonsterAttributes.field_111266_c).func_111128_a(1.0);
    }

    protected SoundEvent func_184615_bR() {
        return SoundInit.STARFORGE_CHOMPER_DEATH;
    }

    protected SoundEvent func_184601_bQ(DamageSource damageSourceIn) {
        return SoundInit.STARFORGE_CHOMPER_HURT;
    }

    protected SoundEvent func_184639_G() {
        return SoundInit.STARFORGE_CHOMPER_AMBIENT;
    }

    @Override
    protected int numberOfLives() {
        return 4;
    }

    protected ResourceLocation func_184647_J() {
        return LootTableRegistry.ENTITIES_SNAPPER;
    }
}

