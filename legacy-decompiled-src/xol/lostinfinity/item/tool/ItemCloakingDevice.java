/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.client.util.ITooltipFlag
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.init.MobEffects
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.item.IItemPropertyGetter
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.util.InteractionResultHolder
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.SoundSource
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.item.tool;

import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.init.MobEffects;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.basics.ItemBasic;
import xol.lostinfinity.item.classify.IHeldTick;

public class ItemCloakingDevice
extends ItemBasic
implements IHeldTick {
    public ItemCloakingDevice(String regName) {
        super(regName, TabsInit.TAB_AUXWEP);
        this.func_185043_a(new ResourceLocation("lostinfinity", "cloaking"), new IItemPropertyGetter(){

            public float func_185085_a(ItemStack stack, @Nullable Level worldIn, @Nullable LivingEntity entityIn) {
                return ItemCloakingDevice.getCloakingProperty(stack, entityIn);
            }
        });
    }

    public static float getCloakingProperty(ItemStack stack, @Nullable LivingEntity entityIn) {
        if (entityIn == null) {
            return 0.0f;
        }
        if (!stack.func_190926_b() && stack.func_77973_b() instanceof ItemCloakingDevice) {
            if (stack.func_77942_o() && stack.func_77978_p().func_74767_n("Cloaking")) {
                return 0.1f;
            }
            return 0.0f;
        }
        return 0.0f;
    }

    public InteractionResultHolder<ItemStack> func_77659_a(Level worldIn, Player playerIn, InteractionHand handIn) {
        ItemStack stack = playerIn.func_184586_b(handIn);
        if (!stack.func_77942_o()) {
            stack.func_77982_d(new CompoundTag());
            stack.func_77978_p().func_74757_a("Cloaking", true);
        } else {
            stack.func_77978_p().func_74757_a("Cloaking", !stack.func_77978_p().func_74767_n("Cloaking"));
        }
        if (!worldIn.field_72995_K) {
            if (stack.func_77978_p().func_74767_n("Cloaking")) {
                worldIn.func_184133_a(null, playerIn.func_180425_c(), SoundInit.ITEM_GHOSTHUNTER, SoundSource.MASTER, 2.0f, 1.0f);
            } else {
                worldIn.func_184133_a(null, playerIn.func_180425_c(), SoundEvents.field_191248_br, SoundSource.MASTER, 2.0f, 1.0f);
            }
        }
        return super.func_77659_a(worldIn, playerIn, handIn);
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Gold) + "Toggle a cloaking mode that avoids radar detection.");
        if (stack.func_77942_o()) {
            if (stack.func_77978_p().func_74767_n("Cloaking")) {
                tooltip.add((Object)((Object)TextFmt.Dark_Purple) + "CLOAKING");
            } else {
                tooltip.add((Object)((Object)TextFmt.Red) + "Cloak not activated.");
            }
        }
    }

    @Override
    public void heldTick(Player player, InteractionHand hand, ItemStack stack) {
        if (player.field_70173_aa % 10 == 0 && stack.func_77942_o() && stack.func_77978_p().func_74767_n("Cloaking")) {
            player.func_70690_d(new PotionEffect(MobEffects.field_76441_p, 12));
        }
    }
}

