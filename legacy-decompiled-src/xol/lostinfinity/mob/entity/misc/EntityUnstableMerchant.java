/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.Mob
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.player.Player
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.EnumParticleTypes
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraft.world.World
 *  net.minecraft.world.ServerLevel
 */
package xol.lostinfinity.mob.entity.misc;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import net.minecraft.server.level.ServerLevel;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.item.activate.ItemGeoCorrelator;
import xol.lostinfinity.mob.entity.misc.EntityFeralMerchant;

public class EntityUnstableMerchant
extends Mob {
    private int mode = 0;

    public EntityUnstableMerchant(Level worldIn) {
        super(worldIn);
    }

    public int getMode() {
        return this.mode;
    }

    public void setMode(int b) {
        this.mode = b;
    }

    public void func_70014_b(CompoundTag tag) {
        super.func_70014_b(tag);
        tag.func_74768_a("FindState", this.getMode());
    }

    public void func_70037_a(CompoundTag tag) {
        super.func_70037_a(tag);
        this.setMode(tag.func_74762_e("FindState"));
    }

    public boolean func_184645_a(Player player, InteractionHand hand) {
        ItemStack held = player.func_184614_ca();
        if (!this.field_70170_p.field_72995_K && held.func_77973_b() instanceof ItemGeoCorrelator) {
            int gameState = this.getMode();
            if (gameState == 0) {
                if (held.func_77942_o() && held.func_77978_p().func_74762_e("GameState") == 0) {
                    held.func_77978_p().func_74768_a("GameState", 1);
                    this.doTeleport(held, player);
                }
            } else if (held.func_77942_o() && held.func_77978_p().func_74762_e("GameState") > 0) {
                this.func_70106_y();
                this.func_82142_c(true);
                EntityFeralMerchant newMerchant = new EntityFeralMerchant(this.field_70170_p);
                newMerchant.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
                int aggromode = held.func_77978_p().func_74762_e("GameState") - 1;
                newMerchant.setMode(aggromode);
                newMerchant.func_70624_b((LivingEntity)player);
                this.field_70170_p.func_72838_d((Entity)newMerchant);
                this.func_184185_a(SoundInit.CINEMATIC_WARNING, 1.0f, 1.0f);
                player.func_184611_a(hand, ItemStack.field_190927_a);
            }
        }
        return true;
    }

    private void doTeleport(ItemStack held, Player player) {
        BlockPos telepos = this.findTeleport();
        held.func_77978_p().func_74780_a("FindX", (double)telepos.func_177958_n());
        held.func_77978_p().func_74780_a("FindY", (double)telepos.func_177956_o());
        held.func_77978_p().func_74780_a("FindZ", (double)telepos.func_177952_p());
        ((ServerLevel)this.field_70170_p).func_175739_a(EnumParticleTypes.PORTAL, this.field_70165_t, this.field_70163_u, this.field_70161_v, 12, (-0.5 + this.field_70146_Z.nextDouble()) * 3.0, 0.3, (-0.5 + this.field_70146_Z.nextDouble()) * 3.0, (double)0.15f, new int[0]);
        player.func_145747_a((Component)new Component((Object)((Object)TextFmt.Gold) + "Unstable Merchant: " + (Object)((Object)TextFmt.Reset) + (Object)((Object)TextFmt.Italic) + "Meet me at the new location!"));
        this.func_184185_a(SoundEvents.field_187791_eX, 1.0f, 1.0f);
        this.func_70106_y();
        this.func_82142_c(true);
    }

    private BlockPos findTeleport() {
        double d0 = this.field_70165_t + (this.field_70146_Z.nextDouble() - 0.5) * 400.0;
        double d2 = this.field_70161_v + (this.field_70146_Z.nextDouble() - 0.5) * 400.0;
        double d1 = 5 + this.field_70146_Z.nextInt(95);
        return new BlockPos(d0, d1, d2);
    }

    public void func_70636_d() {
        super.func_70636_d();
        this.field_70143_R = -1.0f;
    }

    protected SoundEvent func_184639_G() {
        return SoundEvents.field_187910_gj;
    }

    protected SoundEvent func_184601_bQ(DamageSource damageSourceIn) {
        return SoundEvents.field_187912_gl;
    }

    protected SoundEvent func_184615_bR() {
        return SoundEvents.field_187911_gk;
    }

    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.2);
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(20.0);
    }
}

