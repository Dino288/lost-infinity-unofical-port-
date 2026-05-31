/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.item.ItemEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.init.Blocks
 *  net.minecraft.init.MobEffects
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.EnumParticleTypes
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.deviant;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.mob.entity.base.EntityDeviantMob;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.load.LootTableRegistry;

public class EntityDeviantEnderman
extends EntityDeviantMob {
    public EntityDeviantEnderman(Level worldIn) {
        super(worldIn);
        this.func_70105_a(2.5f, 8.0f);
    }

    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(1.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.378);
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(500.0);
    }

    public boolean func_70652_k(Entity entity) {
        super.func_70652_k(entity);
        if (this.func_70638_az() != null) {
            IMaxAttack.dealMaxHealth((Entity)this, this.func_70638_az(), 8 - 2 * this.getMutation());
            return true;
        }
        return false;
    }

    protected Entity findPlayerToAttack() {
        Player entityPlayer = this.field_70170_p.func_72890_a((Entity)this, 16.0);
        return entityPlayer != null && this.func_70685_l((Entity)entityPlayer) ? entityPlayer : null;
    }

    protected SoundEvent func_184615_bR() {
        return SoundEvents.field_187530_aT;
    }

    protected SoundEvent func_184601_bQ(DamageSource damageSourceIn) {
        return SoundEvents.field_187531_aU;
    }

    protected SoundEvent func_184639_G() {
        return SoundEvents.field_187529_aS;
    }

    @Override
    protected Item playerInput() {
        return ItemInit.cursedEmerald;
    }

    @Override
    protected Item mutantOutput() {
        return ItemInit.lifeboundEmerald;
    }

    public void func_70636_d() {
        super.func_70636_d();
        if (this.field_70173_aa % (120 + 20 * this.getMutation()) == 0) {
            if (this.field_70170_p.field_72995_K) {
                for (int i = 0; i < 14; ++i) {
                    this.field_70170_p.func_175688_a(EnumParticleTypes.SPELL_WITCH, this.field_70165_t + (this.field_70146_Z.nextDouble() - 0.5) * (double)this.field_70130_N, this.field_70163_u + this.field_70146_Z.nextDouble() * (double)this.field_70131_O - 0.25, this.field_70161_v + (this.field_70146_Z.nextDouble() - 0.5) * (double)this.field_70130_N, (this.field_70146_Z.nextDouble() - 0.5) * 2.0, -this.field_70146_Z.nextDouble(), (this.field_70146_Z.nextDouble() - 0.5) * 2.0, new int[0]);
                }
            }
            this.field_70170_p.func_184134_a(this.field_70165_t, this.field_70163_u, this.field_70161_v, SoundEvents.field_187534_aX, SoundSource.HOSTILE, 1.5f, 0.5f + this.field_70170_p.field_73012_v.nextFloat(), true);
            this.func_70690_d(new PotionEffect(MobEffects.field_76441_p, 40 + 20 * this.getMutation()));
            BlockPos pos = this.func_180425_c().func_177977_b();
            BlockState block = this.field_70170_p.func_180495_p(pos);
            if (!this.field_70170_p.field_72995_K && (block.func_177230_c().equals(Blocks.field_150450_ax) || block.func_177230_c().equals(Blocks.field_150439_ay))) {
                this.field_70170_p.func_72838_d((Entity)new ItemEntity(this.field_70170_p, (double)pos.func_177958_n(), (double)(pos.func_177956_o() + 1), (double)pos.func_177952_p(), new ItemStack(ItemInit.ghostlyRedstone)));
                this.field_70170_p.func_175698_g(pos);
            }
        }
        if (this.func_82150_aj() && this.field_70170_p.field_72995_K) {
            this.field_70170_p.func_175688_a(EnumParticleTypes.SPELL, this.field_70165_t + (this.field_70146_Z.nextDouble() - 0.5) * (double)this.field_70130_N * 3.0, this.field_70163_u + this.field_70146_Z.nextDouble() * (double)this.field_70131_O - 0.25, this.field_70161_v + (this.field_70146_Z.nextDouble() - 0.5) * (double)this.field_70130_N * 3.0, (this.field_70146_Z.nextDouble() - 0.5) * 2.0, -this.field_70146_Z.nextDouble(), (this.field_70146_Z.nextDouble() - 0.5) * 2.0, new int[0]);
        }
    }

    @Override
    protected ResourceLocation deviantDrop() {
        return LootTableRegistry.ENTITIES_DEVIANTENDERMAN;
    }

    @Override
    protected ResourceLocation superMutatedDrop() {
        return LootTableRegistry.ENTITIES_SUPERMUTANT_ENDERMAN;
    }
}

