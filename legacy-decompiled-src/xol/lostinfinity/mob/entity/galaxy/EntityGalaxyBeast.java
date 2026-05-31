/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.PathfinderMob
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.monster.Monster
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.datasync.DataParameter
 *  net.minecraft.network.datasync.DataSerializer
 *  net.minecraft.network.datasync.DataSerializers
 *  net.minecraft.network.datasync.EntityDataManager
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.EnumParticleTypes
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.world.EnumDifficulty
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.galaxy;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializer;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.Difficulty;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.ai.IBasicAI;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.load.LootTableRegistry;

public class EntityGalaxyBeast
extends Monster
implements IMaxAttack,
IBasicAI {
    private static final DataParameter<Byte> COLOR = EntityDataManager.func_187226_a(EntityGalaxyBeast.class, (DataSerializer)DataSerializers.field_187191_a);

    public EntityGalaxyBeast(Level worldIn) {
        super(worldIn);
        this.func_70105_a(3.5f, 3.0f);
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
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.4);
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(1000.0);
    }

    public boolean func_70652_k(Entity entity) {
        super.func_70652_k(entity);
        if (this.func_70638_az() != null) {
            IMaxAttack.dealMaxHealth((Entity)this, this.func_70638_az(), 5);
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
        if (this.field_70173_aa % 20 < 10) {
            this.field_70181_x += 0.1;
        }
        this.field_70143_R = -1.0f;
        if (this.field_70170_p.field_72995_K) {
            this.field_70170_p.func_175688_a(EnumParticleTypes.SPELL_MOB_AMBIENT, this.field_70165_t + (this.field_70146_Z.nextDouble() - 0.5) * (double)this.field_70130_N, this.field_70163_u + this.field_70146_Z.nextDouble() * (double)this.field_70131_O - 0.25, this.field_70161_v + (this.field_70146_Z.nextDouble() - 0.5) * (double)this.field_70130_N, (this.field_70146_Z.nextDouble() - 0.5) * 2.0, -this.field_70146_Z.nextDouble(), (this.field_70146_Z.nextDouble() - 0.5) * 2.0, new int[0]);
        }
        if (this.func_70638_az() != null) {
            if (this.func_70638_az().field_70163_u > this.field_70163_u) {
                this.field_70181_x += 0.1;
                this.field_70133_I = true;
            }
            if (this.field_70159_w > (double)-0.07f && this.field_70159_w < (double)0.07f) {
                this.func_70024_g((this.func_70638_az().field_70165_t - this.field_70165_t) * 0.1, 0.0, 0.0);
                this.field_70133_I = true;
            }
            if (this.field_70179_y > (double)-0.07f && this.field_70179_y < (double)0.07f) {
                this.func_70024_g(0.0, 0.0, (this.func_70638_az().field_70161_v - this.field_70161_v) * 0.1);
                this.field_70133_I = true;
            }
        }
    }

    protected SoundEvent func_184615_bR() {
        return SoundInit.GALAXYBEAST_DEATH;
    }

    protected SoundEvent func_184601_bQ(DamageSource damageSourceIn) {
        return SoundInit.GALAXYBEAST_HIT;
    }

    protected SoundEvent func_184639_G() {
        return SoundInit.GALAXYBEAST_AMBIENT;
    }

    protected ResourceLocation func_184647_J() {
        ResourceLocation result = null;
        switch (this.getColor()) {
            case 1: {
                result = LootTableRegistry.ENTITIES_GALAXYBEAST_BLUE;
                break;
            }
            case 2: {
                result = LootTableRegistry.ENTITIES_GALAXYBEAST_GREEN;
                break;
            }
            case 3: {
                result = LootTableRegistry.ENTITIES_GALAXYBEAST_YELLOW;
                break;
            }
            case 4: {
                result = LootTableRegistry.ENTITIES_GALAXYBEAST_PURPLE;
            }
        }
        return result;
    }
}

