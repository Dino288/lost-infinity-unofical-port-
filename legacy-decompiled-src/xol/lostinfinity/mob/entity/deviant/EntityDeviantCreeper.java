/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.item.ItemEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.init.Blocks
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.deviant;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.mob.entity.base.EntityDeviantMob;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.load.LootTableRegistry;

public class EntityDeviantCreeper
extends EntityDeviantMob {
    private boolean animationState = false;
    private boolean cageVisible = false;

    public EntityDeviantCreeper(Level worldIn) {
        super(worldIn);
        this.func_70105_a(2.5f, 4.0f);
    }

    @Override
    public boolean func_180427_aV() {
        return true;
    }

    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(1.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.4);
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(700.0);
    }

    public boolean func_70652_k(Entity entity) {
        super.func_70652_k(entity);
        if (this.func_70638_az() != null) {
            IMaxAttack.dealMaxHealth((Entity)this, this.func_70638_az(), 8);
            return true;
        }
        return false;
    }

    @Override
    protected Item playerInput() {
        return ItemInit.mechanicalPowerCell;
    }

    @Override
    protected Item mutantOutput() {
        return ItemInit.superchargedCell;
    }

    public void func_70636_d() {
        super.func_70636_d();
        if (this.animationState) {
            if (this.field_70173_aa % (3 - Math.floorDiv(this.getMutation(), 2)) == 0) {
                boolean bl = this.cageVisible = !this.cageVisible;
            }
            if (this.field_70173_aa % (50 - this.getMutation() * 10) == 0) {
                this.cageVisible = false;
                this.animationState = false;
                if (!this.field_70170_p.field_72995_K) {
                    this.field_70170_p.func_72876_a(null, this.field_70165_t, this.field_70163_u, this.field_70161_v, 7.0f + (float)(8 * this.getMutation()), false);
                    for (Player near_pl : this.field_70170_p.func_72872_a(Player.class, this.func_174813_aQ().func_72314_b(4.0 + (double)(4 * this.getMutation()), 4.0 + (double)(4 * this.getMutation()), 4.0 + (double)(4 * this.getMutation())))) {
                        IMaxAttack.dealMaxHealth((Entity)this, (LivingEntity)near_pl, 3);
                    }
                }
                BlockPos pos = this.func_180425_c().func_177977_b();
                BlockState block = this.field_70170_p.func_180495_p(pos);
                if (!this.field_70170_p.field_72995_K && block.func_177230_c().equals(Blocks.field_150449_bY)) {
                    this.field_70170_p.func_72838_d((Entity)new ItemEntity(this.field_70170_p, (double)pos.func_177958_n(), (double)(pos.func_177956_o() + 1), (double)pos.func_177952_p(), new ItemStack(ItemInit.electrifiedQuartz)));
                    this.field_70170_p.func_175698_g(pos);
                }
            }
        } else if (this.field_70173_aa % (100 - 30 * this.getMutation()) == 0) {
            this.animationState = true;
            this.func_184185_a(SoundEvents.field_187572_ar, 2.0f, 1.0f);
        }
    }

    public boolean getCageVisible() {
        return this.cageVisible;
    }

    protected SoundEvent func_184615_bR() {
        return SoundEvents.field_187568_ap;
    }

    protected SoundEvent func_184601_bQ(DamageSource damageSourceIn) {
        return SoundEvents.field_187570_aq;
    }

    protected SoundEvent func_184639_G() {
        return null;
    }

    @Override
    protected ResourceLocation deviantDrop() {
        return LootTableRegistry.ENTITIES_DEVIANTCREEPER;
    }

    @Override
    protected ResourceLocation superMutatedDrop() {
        return LootTableRegistry.ENTITIES_SUPERMUTANT_CREEPER;
    }
}

