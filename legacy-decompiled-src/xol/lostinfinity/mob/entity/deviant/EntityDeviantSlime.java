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
 *  net.minecraft.util.EnumParticleTypes
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Mth
 *  net.minecraft.world.EnumDifficulty
 *  net.minecraft.world.World
 *  net.minecraft.world.ServerLevel
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
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.Difficulty;
import net.minecraft.world.level.Level;
import net.minecraft.server.level.ServerLevel;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.mob.entity.base.EntityDeviantMob;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.load.LootTableRegistry;

public class EntityDeviantSlime
extends EntityDeviantMob
implements IMaxAttack {
    public EntityDeviantSlime(Level worldIn) {
        super(worldIn);
        this.func_70105_a(4.0f, 4.0f);
        this.func_189654_d(true);
    }

    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(0.5);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.35);
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(400.0);
    }

    public boolean func_70652_k(Entity entity) {
        super.func_70652_k(entity);
        if (this.func_70638_az() != null) {
            IMaxAttack.dealMaxHealth((Entity)this, this.func_70638_az(), 8 - this.getMutation());
            return true;
        }
        return false;
    }

    @Override
    protected Item playerInput() {
        return ItemInit.organicPowerCell;
    }

    @Override
    protected Item mutantOutput() {
        return ItemInit.catalyzingCell;
    }

    public void func_70636_d() {
        super.func_70636_d();
        if (this.field_70173_aa % (40 - 8 * this.getMutation()) == 0) {
            this.func_70024_g(0.0, 1.0 + 0.2 * (double)this.getMutation(), 0.0);
            this.func_184185_a(SoundEvents.field_187882_fq, 1.0f, 0.5f + this.field_70146_Z.nextFloat());
            BlockPos pos = this.func_180425_c().func_177977_b();
            BlockState block = this.field_70170_p.func_180495_p(pos);
            if (!this.field_70170_p.field_72995_K && block.func_177230_c().equals(Blocks.field_150357_h)) {
                this.field_70170_p.func_72838_d((Entity)new ItemEntity(this.field_70170_p, (double)pos.func_177958_n(), (double)(pos.func_177956_o() + 1), (double)pos.func_177952_p(), new ItemStack(ItemInit.slimedBedrock)));
                this.field_70170_p.func_175698_g(pos);
            }
        }
        this.field_70181_x -= 0.08 + 0.03 * (double)this.getMutation();
        float scl = 2.5f + Mth.func_76126_a((float)((float)this.field_70173_aa * (0.1f + 0.1f * (float)this.getMutation())));
        this.func_70105_a(scl, scl);
    }

    public void func_180430_e(float distance, float damageMultiplier) {
        if (!this.field_70170_p.field_72995_K) {
            for (Player near_pl : this.field_70170_p.func_72872_a(Player.class, this.func_174813_aQ().func_72314_b(3.0, 3.0, 3.0))) {
                IMaxAttack.dealMaxHealth((Entity)this, (LivingEntity)near_pl, 3);
            }
            ((ServerLevel)this.field_70170_p).func_175739_a(EnumParticleTypes.SWEEP_ATTACK, this.field_70165_t, this.field_70163_u, this.field_70161_v, 5, (-0.5 + this.field_70146_Z.nextDouble()) * 3.0, 0.3, (-0.5 + this.field_70146_Z.nextDouble()) * 3.0, (double)0.15f, new int[0]);
        }
    }

    protected SoundEvent func_184615_bR() {
        return SoundEvents.field_187874_fm;
    }

    protected SoundEvent func_184601_bQ(DamageSource damageSourceIn) {
        return SoundEvents.field_187880_fp;
    }

    protected SoundEvent func_184639_G() {
        return SoundEvents.field_187886_fs;
    }

    @Override
    public void updateSupermutationAI() {
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.35 + 0.07 * (double)this.getMutation());
    }

    @Override
    protected boolean func_70692_ba() {
        int time = (int)(this.field_70170_p.func_72820_D() % 24000L);
        return time > 13000 && time < 18000;
    }

    @Override
    public boolean func_70814_o() {
        return true;
    }

    @Override
    public boolean func_70601_bi() {
        return this.field_70170_p.func_175659_aa() != EnumDifficulty.PEACEFUL;
    }

    @Override
    protected ResourceLocation deviantDrop() {
        return LootTableRegistry.ENTITIES_DEVIANTSLIME;
    }

    @Override
    protected ResourceLocation superMutatedDrop() {
        return LootTableRegistry.ENTITIES_SUPERMUTANT_SLIME;
    }
}

