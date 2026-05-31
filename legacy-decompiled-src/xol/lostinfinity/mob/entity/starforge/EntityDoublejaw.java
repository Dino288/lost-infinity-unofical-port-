/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.player.Player
 *  net.minecraft.network.datasync.DataParameter
 *  net.minecraft.network.datasync.DataSerializer
 *  net.minecraft.network.datasync.DataSerializers
 *  net.minecraft.network.datasync.EntityDataManager
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.world.EnumDifficulty
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.starforge;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializer;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.Difficulty;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.PotionInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.entity.base.EntityMultipleLives;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.load.LootTableRegistry;

public class EntityDoublejaw
extends EntityMultipleLives
implements IMaxAttack {
    private static final DataParameter<Float> GMOVE_X = EntityDataManager.func_187226_a(EntityDoublejaw.class, (DataSerializer)DataSerializers.field_187193_c);
    private static final DataParameter<Float> GMOVE_Y = EntityDataManager.func_187226_a(EntityDoublejaw.class, (DataSerializer)DataSerializers.field_187193_c);
    private static final DataParameter<Float> GMOVE_Z = EntityDataManager.func_187226_a(EntityDoublejaw.class, (DataSerializer)DataSerializers.field_187193_c);

    public EntityDoublejaw(Level worldIn) {
        super(worldIn);
        this.func_70105_a(4.25f, 4.25f);
        this.func_189654_d(true);
    }

    @Override
    protected void func_184651_r() {
    }

    @Override
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a(GMOVE_X, (Object)Float.valueOf(0.0f));
        this.field_70180_af.func_187214_a(GMOVE_Y, (Object)Float.valueOf(0.0f));
        this.field_70180_af.func_187214_a(GMOVE_Z, (Object)Float.valueOf(0.0f));
    }

    public float getXMovement() {
        return ((Float)this.field_70180_af.func_187225_a(GMOVE_X)).floatValue();
    }

    public float getYMovement() {
        return ((Float)this.field_70180_af.func_187225_a(GMOVE_Y)).floatValue();
    }

    public float getZMovement() {
        return ((Float)this.field_70180_af.func_187225_a(GMOVE_Z)).floatValue();
    }

    private void randomizeMovement() {
        float xrand = (-1.0f + 2.0f * this.field_70146_Z.nextFloat()) * 0.1f;
        float yrand = (-1.0f + 2.0f * this.field_70146_Z.nextFloat()) * 0.1f;
        float zrand = (-1.0f + 2.0f * this.field_70146_Z.nextFloat()) * 0.1f;
        this.field_70180_af.func_187227_b(GMOVE_X, (Object)Float.valueOf(xrand));
        this.field_70180_af.func_187227_b(GMOVE_Y, (Object)Float.valueOf(yrand));
        this.field_70180_af.func_187227_b(GMOVE_Z, (Object)Float.valueOf(zrand));
    }

    protected void func_82167_n(Entity entityIn) {
        Player play;
        if (entityIn instanceof Player && this.field_70173_aa % 5 == 0 && !(play = (Player)entityIn).func_184812_l_() && IMaxAttack.dealMaxHealth((Entity)this, (LivingEntity)play, 3).didSuccessfulHit()) {
            play.func_70690_d(new PotionEffect(PotionInit.BLIGHTED, 200));
        }
        entityIn.func_70108_f((Entity)this);
    }

    public void func_70636_d() {
        super.func_70636_d();
        this.field_70143_R = -1.0f;
        if (!this.field_70170_p.field_72995_K && this.field_70173_aa % 80 == 3) {
            this.randomizeMovement();
        }
        this.field_70159_w = this.getXMovement();
        this.field_70181_x = this.getYMovement();
        this.field_70179_y = this.getZMovement();
    }

    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(1000.0);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(1.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.25);
        this.func_110148_a(SharedMonsterAttributes.field_111266_c).func_111128_a(1.0);
    }

    protected SoundEvent func_184615_bR() {
        return SoundInit.DOUBLEJAW_DEATH;
    }

    protected SoundEvent func_184601_bQ(DamageSource damageSourceIn) {
        return SoundInit.DOUBLEJAW_HURT;
    }

    protected SoundEvent func_184639_G() {
        return SoundInit.DOUBLEJAW_AMBIENT;
    }

    @Override
    protected int numberOfLives() {
        return 12;
    }

    @Override
    public boolean func_70601_bi() {
        return this.field_70170_p.func_175659_aa() != EnumDifficulty.PEACEFUL;
    }

    protected ResourceLocation func_184647_J() {
        return LootTableRegistry.ENTITIES_DOUBLEJAW;
    }
}

