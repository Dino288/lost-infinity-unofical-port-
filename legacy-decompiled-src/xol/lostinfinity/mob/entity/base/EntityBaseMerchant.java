/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.entity.PathfinderMob
 *  net.minecraft.entity.Mob
 *  net.minecraft.entity.IMerchant
 *  net.minecraft.entity.INpc
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.ai.EntityAIBase
 *  net.minecraft.entity.ai.EntityAIWatchClosest2
 *  net.minecraft.entity.player.Player
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.village.MerchantRecipe
 *  net.minecraft.village.MerchantRecipeList
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.mob.entity.base;

import javax.annotation.Nullable;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.Mob;
import net.minecraft.entity.IMerchant;
import net.minecraft.entity.INpc;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIWatchClosest2;
import net.minecraft.world.entity.player.Player;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.core.BlockPos;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityBaseMerchant
extends PathfinderMob
implements INpc,
IMerchant {
    private Player buyingPlayer;
    private MerchantRecipeList buyingList;

    public EntityBaseMerchant(Level worldIn) {
        super(worldIn);
    }

    protected void func_184651_r() {
        this.field_70714_bg.func_75776_a(9, (EntityAIBase)new EntityAIWatchClosest2((Mob)this, Player.class, 3.0f, 1.0f));
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

    public void func_70636_d() {
        super.func_70636_d();
    }

    public boolean func_70104_M() {
        return false;
    }

    public boolean func_184645_a(Player player, InteractionHand hand) {
        if (this.func_70089_S() && !this.isTrading() && !player.func_70093_af()) {
            if (this.buyingList == null) {
                this.buyingList = this.getRecipeList();
            }
            if (!this.field_70170_p.field_72995_K && !this.buyingList.isEmpty()) {
                this.func_70932_a_(player);
                player.func_180472_a((IMerchant)this);
            } else if (this.buyingList.isEmpty()) {
                return false;
            }
            return true;
        }
        return false;
    }

    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.2);
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(20.0);
        this.func_184224_h(true);
    }

    public MerchantRecipeList getRecipeList() {
        MerchantRecipeList list = new MerchantRecipeList();
        return list;
    }

    public int func_70641_bl() {
        return 1;
    }

    public boolean func_70692_ba() {
        return false;
    }

    public boolean func_70601_bi() {
        return false;
    }

    public void func_70932_a_(@Nullable Player player) {
        this.buyingPlayer = player;
    }

    @Nullable
    public Player func_70931_l_() {
        return this.buyingPlayer;
    }

    public boolean isTrading() {
        return this.buyingPlayer != null;
    }

    @SideOnly(value=Side.CLIENT)
    public void func_70930_a(@Nullable MerchantRecipeList recipeList) {
    }

    public void func_70933_a(MerchantRecipe recipe) {
    }

    public void func_110297_a_(ItemStack var1) {
    }

    @Nullable
    public MerchantRecipeList func_70934_b(Player player) {
        if (this.buyingList == null) {
            this.buyingList = this.getRecipeList();
        }
        return this.buyingList;
    }

    public Level func_190670_t_() {
        return this.field_70170_p;
    }

    public BlockPos func_190671_u_() {
        return this.func_180425_c();
    }
}

