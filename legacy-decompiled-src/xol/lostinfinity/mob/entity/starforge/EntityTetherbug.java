/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.item.ItemEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.ItemStack
 *  net.minecraft.network.datasync.DataParameter
 *  net.minecraft.network.datasync.DataSerializer
 *  net.minecraft.network.datasync.DataSerializers
 *  net.minecraft.network.datasync.EntityDataManager
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.util.math.Mth
 *  net.minecraft.world.EnumDifficulty
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.starforge;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializer;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.Difficulty;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.DimensionInit;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.ai.IBasicAI;
import xol.lostinfinity.mob.entity.base.EntityMultipleLives;
import xol.lostinfinity.projectile.entity.EntityTetherBall;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.load.LootTableRegistry;

public class EntityTetherbug
extends EntityMultipleLives
implements IMaxAttack,
IBasicAI {
    private static final DataParameter<Boolean> ATTACKING = EntityDataManager.func_187226_a(EntityTetherbug.class, (DataSerializer)DataSerializers.field_187198_h);

    public EntityTetherbug(Level worldIn) {
        super(worldIn);
        this.func_70105_a(2.7f, 1.0f);
    }

    @Override
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a(ATTACKING, (Object)false);
    }

    public boolean getAngry() {
        return (Boolean)this.field_70180_af.func_187225_a(ATTACKING);
    }

    public void setAngry(boolean f) {
        this.field_70180_af.func_187227_b(ATTACKING, (Object)f);
    }

    public boolean func_70652_k(Entity entity) {
        super.func_70652_k(entity);
        if (this.func_70638_az() != null) {
            IMaxAttack.dealMaxHealth((Entity)this, this.func_70638_az(), 1);
            return true;
        }
        return false;
    }

    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(1500.0);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(1.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.23);
        this.func_110148_a(SharedMonsterAttributes.field_111266_c).func_111128_a(1.0);
    }

    public void func_70636_d() {
        super.func_70636_d();
        this.field_70143_R = -1.0f;
        if (!this.field_70170_p.field_72995_K) {
            this.setAngry(this.func_70638_az() != null);
            if (this.func_70638_az() == null) {
                this.field_70181_x = 0.2;
                this.field_70133_I = true;
            } else if (this.field_70173_aa % 60 == 0) {
                this.func_184185_a(SoundInit.TETHERBUG_ATTACK, 1.0f, 1.0f);
                EntityTetherBall shot = new EntityTetherBall(this.field_70170_p, (LivingEntity)this);
                double d0 = this.func_70638_az().field_70165_t - this.field_70165_t;
                double d1 = this.func_70638_az().func_174813_aQ().field_72338_b + (double)(this.func_70638_az().field_70131_O / 6.0f) - shot.field_70163_u;
                double d2 = this.func_70638_az().field_70161_v - this.field_70161_v;
                double d3 = Mth.func_76133_a((double)(d0 * d0 + d2 * d2));
                shot.func_70186_c(d0, d1 + d3 * (double)0.2f, d2, 2.0f, 0.0f);
                this.field_70170_p.func_72838_d((Entity)shot);
            }
        }
    }

    protected boolean func_184645_a(Player player, InteractionHand hand) {
        ItemStack held = player.func_184586_b(hand);
        if (held.func_77973_b().equals(ItemInit.darksteelSheets) && this.field_70170_p.field_73011_w.func_186058_p() == DimensionInit.nonexistence) {
            if (!this.field_70170_p.field_72995_K) {
                ItemEntity item = new ItemEntity(this.field_70170_p, this.field_70165_t, this.field_70163_u, this.field_70161_v, new ItemStack(ItemInit.stickyDarksteel));
                item.field_70159_w = 0.0;
                item.field_70181_x = 0.0;
                item.field_70179_y = 0.0;
                this.field_70170_p.func_72838_d((Entity)item);
            }
            this.func_184185_a(SoundInit.CREATURE_FEED, 1.5f, 0.7f);
            held.func_190918_g(1);
        }
        return true;
    }

    @Override
    protected int numberOfLives() {
        return 3;
    }

    protected SoundEvent func_184615_bR() {
        return SoundInit.TETHERBUG_DEATH;
    }

    protected SoundEvent func_184601_bQ(DamageSource damageSourceIn) {
        return SoundInit.TETHERBUG_HURT;
    }

    protected SoundEvent func_184639_G() {
        return SoundInit.TETHERBUG_AMBIENT;
    }

    protected boolean func_70692_ba() {
        return false;
    }

    @Override
    public boolean func_70814_o() {
        return true;
    }

    public int func_70641_bl() {
        return 1;
    }

    @Override
    public boolean func_70601_bi() {
        return this.field_70170_p.func_175659_aa() != EnumDifficulty.PEACEFUL;
    }

    protected ResourceLocation func_184647_J() {
        return LootTableRegistry.ENTITIES_TETHERBUG;
    }
}

