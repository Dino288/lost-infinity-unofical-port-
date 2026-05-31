/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.PathfinderMob
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.monster.Monster
 *  net.minecraft.entity.player.Player
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.datasync.DataParameter
 *  net.minecraft.network.datasync.DataSerializer
 *  net.minecraft.network.datasync.DataSerializers
 *  net.minecraft.network.datasync.EntityDataManager
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.world.EnumDifficulty
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.misc;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializer;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.Difficulty;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.ai.IBasicAI;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.load.LootTableRegistry;

public class EntityStarfiend
extends Monster
implements IMaxAttack,
IBasicAI {
    private static final DataParameter<Byte> SCALETYPE = EntityDataManager.func_187226_a(EntityStarfiend.class, (DataSerializer)DataSerializers.field_187191_a);

    public EntityStarfiend(Level worldIn) {
        super(worldIn);
        this.func_70105_a(2.2f, 3.7f);
    }

    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a(SCALETYPE, (Object)0);
    }

    public byte getScaleType() {
        return (Byte)this.field_70180_af.func_187225_a(SCALETYPE);
    }

    public void setScaleType(byte f) {
        this.field_70180_af.func_187227_b(SCALETYPE, (Object)f);
    }

    public float getPhysicalScale() {
        return 2.0f - 0.2f * (float)this.getScaleType();
    }

    public void func_70014_b(CompoundTag tag) {
        super.func_70014_b(tag);
        tag.func_74774_a("ScaleType", this.getScaleType());
    }

    public void func_70037_a(CompoundTag tag) {
        super.func_70037_a(tag);
        this.setScaleType(tag.func_74771_c("ScaleType"));
    }

    public void func_70636_d() {
        super.func_70636_d();
        this.func_70105_a(1.0f * this.getPhysicalScale(), 2.0f * this.getPhysicalScale());
        if (this.field_70173_aa % 60 == 0 && this.func_70638_az() != null && this.func_70638_az() instanceof Player) {
            Player pl = (Player)this.func_70638_az();
            this.func_70024_g((pl.field_70165_t - this.field_70165_t) * 0.145, 1.0, (pl.field_70161_v - this.field_70161_v) * 0.145);
            this.field_70133_I = true;
        }
    }

    public boolean func_70652_k(Entity entity) {
        super.func_70652_k(entity);
        if (this.func_70638_az() != null) {
            IMaxAttack.dealMaxHealth((Entity)this, this.func_70638_az(), 5);
            return true;
        }
        return false;
    }

    protected void func_184651_r() {
        this.initBasicTasks((PathfinderMob)this);
    }

    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(1.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.4);
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(1500.0);
    }

    protected SoundEvent func_184615_bR() {
        return SoundInit.STARFIEND_DEATH;
    }

    protected SoundEvent func_184601_bQ(DamageSource damageSourceIn) {
        return SoundInit.STARFIEND_HIT;
    }

    protected SoundEvent func_184639_G() {
        return SoundInit.STARFIEND_AMBIENT;
    }

    public boolean func_70814_o() {
        return true;
    }

    public boolean func_70601_bi() {
        return this.field_70170_p.func_175659_aa() != EnumDifficulty.PEACEFUL;
    }

    protected ResourceLocation func_184647_J() {
        return LootTableRegistry.ENTITIES_STARFIEND;
    }
}

