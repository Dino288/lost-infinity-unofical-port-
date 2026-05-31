/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.PathfinderMob
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.item.ItemEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.item.ItemStack
 *  net.minecraft.network.datasync.DataParameter
 *  net.minecraft.network.datasync.DataSerializer
 *  net.minecraft.network.datasync.DataSerializers
 *  net.minecraft.network.datasync.EntityDataManager
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.starforge;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializer;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.DimensionInit;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.PotionInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.entity.base.EntityMultipleLives;
import xol.lostinfinity.mob.entity.base.IConditionalDamage;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.load.LootTableRegistry;

public class EntityGrubber
extends EntityMultipleLives
implements IMaxAttack,
IConditionalDamage {
    private static final DataParameter<Boolean> AWAKE = EntityDataManager.func_187226_a(EntityGrubber.class, (DataSerializer)DataSerializers.field_187198_h);
    private int sleepTimer = 0;
    private float eyeCoverAng;

    public EntityGrubber(Level worldIn) {
        super(worldIn);
        this.func_70105_a(0.75f, 0.75f);
    }

    @Override
    protected void func_184651_r() {
    }

    @Override
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a(AWAKE, (Object)false);
    }

    public boolean isAwake() {
        return (Boolean)this.field_70180_af.func_187225_a(AWAKE);
    }

    public void setAwake(boolean awoke) {
        this.field_70180_af.func_187227_b(AWAKE, (Object)awoke);
        if (!awoke) {
            this.field_70714_bg.field_75782_a.clear();
            this.field_70715_bh.field_75782_a.clear();
        } else {
            this.initBasicTasks((PathfinderMob)this);
        }
        this.sleepTimer = 0;
    }

    public float getEyeCoverRot() {
        return this.eyeCoverAng;
    }

    public void func_70636_d() {
        super.func_70636_d();
        this.field_70143_R = -1.0f;
        if (!this.field_70170_p.field_72995_K) {
            if (this.isAwake()) {
                if (this.sleepTimer == 100) {
                    this.setAwake(false);
                }
                ++this.sleepTimer;
                if (this.field_70173_aa % 80 == 0 && this.func_70638_az() != null) {
                    LivingEntity target = this.func_70638_az();
                    this.func_70024_g((target.field_70165_t - this.field_70165_t) * 0.145, 0.5, (target.field_70161_v - this.field_70161_v) * 0.145);
                    this.field_70133_I = true;
                }
            }
        } else if (this.isAwake()) {
            if (this.eyeCoverAng < 2.4f) {
                this.eyeCoverAng += 0.1f;
            }
        } else if (this.eyeCoverAng > 0.0f) {
            this.eyeCoverAng -= 0.1f;
        }
    }

    protected boolean func_184645_a(Player player, InteractionHand hand) {
        ItemStack held = player.func_184586_b(hand);
        if (held.func_77973_b().equals(ItemInit.jarOfMurkySyrup) && this.field_70170_p.field_73011_w.func_186058_p() == DimensionInit.infiniteMurk) {
            if (!this.field_70170_p.field_72995_K) {
                if (this.isAwake()) {
                    player.func_70690_d(new PotionEffect(PotionInit.DISTORTION, 300));
                    this.func_184185_a(SoundEvents.field_191255_dF, 1.5f, 0.9f + this.field_70146_Z.nextFloat() * 0.1f);
                    ItemEntity item = new ItemEntity(this.field_70170_p, this.field_70165_t, this.field_70163_u + 2.0, this.field_70161_v, new ItemStack(ItemInit.murkyClay, 2));
                    item.field_70159_w = 0.0;
                    item.field_70181_x = 0.0;
                    item.field_70179_y = 0.0;
                    this.field_70170_p.func_72838_d((Entity)item);
                } else {
                    this.setAwake(true);
                }
            }
            held.func_190918_g(1);
        }
        return true;
    }

    public boolean func_70652_k(Entity entity) {
        super.func_70652_k(entity);
        if (this.func_70638_az() != null) {
            if (IMaxAttack.dealMaxHealth((Entity)this, this.func_70638_az(), 2).didSuccessfulHit()) {
                this.func_70638_az().func_70690_d(new PotionEffect(PotionInit.BLIGHTED, 200));
            }
            return true;
        }
        return false;
    }

    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(3000.0);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(1.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.25);
        this.func_110148_a(SharedMonsterAttributes.field_111266_c).func_111128_a(1.0);
    }

    protected SoundEvent func_184615_bR() {
        return SoundInit.GRUBBER_DEATH;
    }

    protected SoundEvent func_184601_bQ(DamageSource damageSourceIn) {
        return SoundInit.GRUBBER_HURT;
    }

    protected SoundEvent func_184639_G() {
        if (!this.isAwake()) {
            return SoundInit.GRUBBER_AMBIENT_SLEEPING;
        }
        return SoundInit.GRUBBER_AMBIENT;
    }

    protected ResourceLocation func_184647_J() {
        return LootTableRegistry.ENTITIES_GRUBBER;
    }

    @Override
    protected int numberOfLives() {
        return 3;
    }

    @Override
    public boolean canBeDamaged(Entity attacker) {
        return this.isAwake();
    }
}

