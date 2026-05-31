/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.player.Player
 *  net.minecraft.network.datasync.DataParameter
 *  net.minecraft.network.datasync.DataSerializer
 *  net.minecraft.network.datasync.DataSerializers
 *  net.minecraft.network.datasync.EntityDataManager
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.starforge;

import net.minecraft.world.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializer;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.ai.IBasicAI;
import xol.lostinfinity.mob.entity.base.EntityMultipleLives;
import xol.lostinfinity.mob.entity.base.IConditionalDamage;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.load.LootTableRegistry;

public class EntityLeer
extends EntityMultipleLives
implements IMaxAttack,
IBasicAI,
IConditionalDamage {
    private static final DataParameter<Boolean> REVEALED = EntityDataManager.func_187226_a(EntityLeer.class, (DataSerializer)DataSerializers.field_187198_h);
    private int revealedTimer = 200;
    private float revealedAlph = 0.0f;

    public EntityLeer(Level worldIn) {
        super(worldIn);
        this.func_70105_a(1.2f, 2.2f);
    }

    @Override
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a(REVEALED, (Object)false);
    }

    public boolean isRevealed() {
        return (Boolean)this.field_70180_af.func_187225_a(REVEALED);
    }

    public void setRevealed(boolean rev) {
        this.field_70180_af.func_187227_b(REVEALED, (Object)rev);
    }

    public float getAlpha() {
        return this.revealedAlph;
    }

    public boolean func_70652_k(Entity entity) {
        super.func_70652_k(entity);
        if (this.func_70638_az() != null) {
            IMaxAttack.dealMaxHealth((Entity)this, this.func_70638_az(), 3);
            if (!this.isRevealed() && entity instanceof Player) {
                entity.func_145747_a((Component)new Component((Object)((Object)TextFmt.Light_Purple) + "You feel something scratch you."));
            }
            return true;
        }
        return false;
    }

    public void func_70636_d() {
        super.func_70636_d();
        if (!this.field_70170_p.field_72995_K) {
            if (this.isRevealed()) {
                --this.revealedTimer;
                if (this.revealedTimer == 0) {
                    this.setRevealed(false);
                }
            } else {
                this.revealedTimer = 200;
            }
        } else if (this.isRevealed()) {
            if (this.revealedAlph < 1.0f) {
                this.revealedAlph += 0.02f;
            }
        } else if (this.revealedAlph > 0.0f) {
            this.revealedAlph -= 0.02f;
        }
    }

    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(1000.0);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(1.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.25);
        this.func_110148_a(SharedMonsterAttributes.field_111266_c).func_111128_a(1.0);
    }

    protected SoundEvent func_184615_bR() {
        return SoundInit.LEER_DEATH;
    }

    protected SoundEvent func_184601_bQ(DamageSource damageSourceIn) {
        return SoundInit.LEER_HURT;
    }

    protected SoundEvent func_184639_G() {
        return SoundInit.LEER_AMBIENT;
    }

    @Override
    protected int numberOfLives() {
        return 3;
    }

    protected ResourceLocation func_184647_J() {
        return LootTableRegistry.ENTITIES_LEER;
    }

    @Override
    public boolean canBeDamaged(Entity attacker) {
        return this.isRevealed();
    }
}

