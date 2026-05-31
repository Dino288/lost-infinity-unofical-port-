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
 *  net.minecraft.init.SoundEvents
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
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.sounds.SoundEvents;
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

public class EntityDeviantSpider
extends EntityDeviantMob {
    public EntityDeviantSpider(Level worldIn) {
        super(worldIn);
        this.func_70105_a(2.0f, 2.2f);
    }

    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(0.5);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.43200000000000005);
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(500.0);
    }

    public boolean func_70652_k(Entity entity) {
        super.func_70652_k(entity);
        if (this.func_70638_az() != null) {
            IMaxAttack.dealMaxHealth((Entity)this, this.func_70638_az(), 5 - this.getMutation());
            return true;
        }
        return false;
    }

    public void func_70636_d() {
        super.func_70636_d();
        this.field_70143_R = -1.0f;
        if (this.field_70173_aa % 40 == 0 && this.func_70638_az() != null && this.func_70638_az() instanceof Player) {
            Player pl = (Player)this.func_70638_az();
            BlockPos pos = this.func_180425_c().func_177977_b();
            BlockState block = this.field_70170_p.func_180495_p(pos);
            if (!this.field_70170_p.field_72995_K && block.func_177230_c().equals(Blocks.field_150482_ag)) {
                this.field_70170_p.func_72838_d((Entity)new ItemEntity(this.field_70170_p, (double)pos.func_177958_n(), (double)(pos.func_177956_o() + 1), (double)pos.func_177952_p(), new ItemStack(ItemInit.envenomedDiamond)));
                this.field_70170_p.func_175698_g(pos);
            }
            this.func_70024_g((pl.field_70165_t - this.field_70165_t) * 0.145, 1.0 + (double)this.getMutation() * 0.3, (pl.field_70161_v - this.field_70161_v) * 0.145);
            this.field_70133_I = true;
        }
    }

    protected SoundEvent func_184615_bR() {
        return SoundEvents.field_187819_fL;
    }

    protected SoundEvent func_184601_bQ(DamageSource damageSourceIn) {
        return SoundEvents.field_187821_fM;
    }

    protected SoundEvent func_184639_G() {
        return SoundEvents.field_187817_fK;
    }

    @Override
    protected ResourceLocation deviantDrop() {
        return LootTableRegistry.ENTITIES_DEVIANTSPIDER;
    }

    @Override
    protected ResourceLocation superMutatedDrop() {
        return LootTableRegistry.ENTITIES_SUPERMUTANT_SPIDER;
    }
}

