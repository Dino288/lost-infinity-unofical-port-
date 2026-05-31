/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.PathfinderMob
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.monster.Monster
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.datasync.DataParameter
 *  net.minecraft.network.datasync.DataSerializer
 *  net.minecraft.network.datasync.DataSerializers
 *  net.minecraft.network.datasync.EntityDataManager
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.util.math.Mth
 *  net.minecraft.world.EnumDifficulty
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.galaxy;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializer;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.Difficulty;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.ai.IBasicAI;
import xol.lostinfinity.projectile.entity.EntityGalaxySpell;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.load.LootTableRegistry;

public class EntityGalaxySorcerer
extends Monster
implements IMaxAttack,
IBasicAI {
    private static final DataParameter<Byte> COLOR = EntityDataManager.func_187226_a(EntityGalaxySorcerer.class, (DataSerializer)DataSerializers.field_187191_a);

    public EntityGalaxySorcerer(Level worldIn) {
        super(worldIn);
        this.func_70105_a(2.0f, 4.0f);
    }

    protected void func_184651_r() {
        this.initBasicTasks((PathfinderMob)this);
    }

    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a(COLOR, (Object)0);
    }

    public byte getColor() {
        return (Byte)this.field_70180_af.func_187225_a(COLOR);
    }

    public void setColor(byte f) {
        this.field_70180_af.func_187227_b(COLOR, (Object)f);
    }

    public void func_70014_b(CompoundTag tag) {
        super.func_70014_b(tag);
        tag.func_74774_a("CreatureType", this.getColor());
    }

    public void func_70037_a(CompoundTag tag) {
        super.func_70037_a(tag);
        this.setColor(tag.func_74771_c("CreatureType"));
    }

    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(1.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.22);
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(500.0);
    }

    public boolean func_70652_k(Entity entity) {
        super.func_70652_k(entity);
        if (this.func_70638_az() != null) {
            IMaxAttack.dealMaxHealth((Entity)this, this.func_70638_az(), 8);
            return true;
        }
        return false;
    }

    public boolean func_70814_o() {
        return true;
    }

    public boolean func_70601_bi() {
        return this.field_70170_p.func_175659_aa() != EnumDifficulty.PEACEFUL;
    }

    public void func_70636_d() {
        super.func_70636_d();
        if (!this.field_70170_p.field_72995_K && this.field_70173_aa == 1 && this.getColor() == 0) {
            this.setColor((byte)(this.field_70146_Z.nextInt(4) + 1));
        }
        LivingEntity target = this.func_70638_az();
        if (this.field_70173_aa % 20 == 0 && target != null) {
            if (!this.field_70170_p.field_72995_K) {
                EntityGalaxySpell shot = new EntityGalaxySpell(this.field_70170_p, (LivingEntity)this);
                double d0 = target.field_70165_t - this.field_70165_t;
                double d1 = target.func_174813_aQ().field_72338_b + (double)(target.field_70131_O / 6.0f) - shot.field_70163_u;
                double d2 = target.field_70161_v - this.field_70161_v;
                double d3 = Mth.func_76133_a((double)(d0 * d0 + d2 * d2));
                shot.func_70186_c(d0, d1 + d3 * (double)0.2f, d2, 0.5f, 0.0f);
                this.field_70170_p.func_72838_d((Entity)shot);
            }
            this.func_184185_a(SoundEvents.field_193784_dd, 1.0f, 1.0f);
        }
    }

    protected SoundEvent func_184615_bR() {
        return SoundInit.GALAXYCREATURE_DEATH;
    }

    protected SoundEvent func_184601_bQ(DamageSource damageSourceIn) {
        return SoundInit.GALAXYCREATURE_DEATH;
    }

    protected SoundEvent func_184639_G() {
        return SoundInit.GALAXYCREATURE_AMBIENT;
    }

    protected ResourceLocation func_184647_J() {
        ResourceLocation result = null;
        switch (this.getColor()) {
            case 1: {
                result = LootTableRegistry.ENTITIES_GALAXYSORCERER_BLUE;
                break;
            }
            case 2: {
                result = LootTableRegistry.ENTITIES_GALAXYSORCERER_GREEN;
                break;
            }
            case 3: {
                result = LootTableRegistry.ENTITIES_GALAXYSORCERER_YELLOW;
                break;
            }
            case 4: {
                result = LootTableRegistry.ENTITIES_GALAXYSORCERER_PURPLE;
            }
        }
        return result;
    }
}

