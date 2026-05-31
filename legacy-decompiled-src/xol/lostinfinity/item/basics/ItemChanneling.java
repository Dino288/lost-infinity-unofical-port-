/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.EnumAction
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.InteractionResultHolder
 *  net.minecraft.util.EnumInteractionResultHolder
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.world.World
 */
package xol.lostinfinity.item.basics;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.item.EnumAction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.util.EnumInteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import xol.lostinfinity.item.basics.ItemCooldown;
import xol.lostinfinity.item.classify.IHeldTick;

public class ItemChanneling
extends ItemCooldown
implements IHeldTick {
    protected static final String CHARGE_STATE = "charging";
    protected static final String CHARGE = "charge";
    protected float maxChargeTime = 20.0f;

    public ItemChanneling(String regName) {
        super(regName);
        this.func_185043_a(new ResourceLocation("lostinfinity", CHARGE_STATE), this::getChargeState);
        this.func_185043_a(new ResourceLocation("lostinfinity", CHARGE), this::getChargeRatio);
    }

    public void func_77615_a(ItemStack stack, Level worldIn, LivingEntity entityLiving, int timeLeft) {
        this.chargeStop(stack, worldIn, entityLiving, this.func_77626_a(stack) - timeLeft);
    }

    public int func_77626_a(ItemStack stack) {
        return 72000;
    }

    public EnumAction func_77661_b(ItemStack stack) {
        return EnumAction.BOW;
    }

    public InteractionResultHolder<ItemStack> func_77659_a(Level worldIn, Player playerIn, InteractionHand handIn) {
        ItemStack stack = playerIn.func_184586_b(handIn);
        if (!this.showDurabilityBar(stack)) {
            playerIn.func_184598_c(handIn);
            return this.chargeStart(worldIn, playerIn, handIn, stack);
        }
        return new InteractionResultHolder(EnumInteractionResultHolder.FAIL, (Object)stack);
    }

    @Override
    public void heldTick(Player player, InteractionHand hand, ItemStack stack) {
        if (player.func_184607_cu() != stack) {
            return;
        }
        this.chargeTick(player.field_70170_p, player, hand, stack, player.func_184612_cw());
    }

    public float getMaxChargeTime() {
        return this.maxChargeTime;
    }

    public void setMaxChargeTime(int tick) {
        this.maxChargeTime = tick;
    }

    public InteractionResultHolder<ItemStack> chargeStart(Level worldIn, Player player, InteractionHand handIn, ItemStack stack) {
        return new InteractionResultHolder(EnumInteractionResultHolder.PASS, (Object)stack);
    }

    public void chargeTick(Level worldIn, Player player, InteractionHand hand, ItemStack stack, int chargeTime) {
    }

    public void chargeStop(ItemStack stack, Level worldIn, LivingEntity entityLiving, int chargeTime) {
        if ((float)chargeTime >= this.maxChargeTime) {
            this.startCooldown(stack);
        }
    }

    public float updateFOV(Player player, ItemStack stack, float original) {
        float chargeRatio = (float)player.func_184612_cw() / 20.0f;
        chargeRatio = chargeRatio > 1.0f ? 1.0f : (chargeRatio *= chargeRatio);
        return original * (1.0f - chargeRatio * 0.15f);
    }

    protected float getChargeState(ItemStack stack, Level world, LivingEntity entityLivingBase) {
        return ItemChanneling.isChanneling(entityLivingBase, stack) ? 1.0f : 0.0f;
    }

    protected float getChargeRatio(ItemStack stack, Level world, LivingEntity entityLivingBase) {
        if (entityLivingBase == null || stack.func_190926_b()) {
            return 0.0f;
        }
        return entityLivingBase.func_184607_cu().func_77973_b() == this ? (float)entityLivingBase.func_184612_cw() / this.maxChargeTime : 0.0f;
    }

    @Override
    protected int getCooldown() {
        return 0;
    }

    public static boolean isChanneling(LivingEntity entityLivingBase, ItemStack stack) {
        if (entityLivingBase == null || stack.func_190926_b() || !stack.func_77942_o()) {
            return false;
        }
        return entityLivingBase.func_184587_cr() && stack.func_77969_a(entityLivingBase.func_184607_cu());
    }
}

