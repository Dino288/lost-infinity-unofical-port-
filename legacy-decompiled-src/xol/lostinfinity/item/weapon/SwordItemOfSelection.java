/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.client.util.ITooltipFlag
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.item.Item
 *  net.minecraft.item.Item$ToolMaterial
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.SwordItem
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.util.InteractionResultHolder
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.SoundSource
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.item.weapon;

import java.util.List;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.classify.IHeldTick;
import xol.lostinfinity.item.classify.ISwitchModels;
import xol.lostinfinity.util.data.IMaxAttack;

public class SwordItemOfSelection
extends SwordItem
implements IMaxAttack,
ISwitchModels,
IHeldTick {
    static Pattern pattern_ah = Pattern.compile("[a-h]");
    static Pattern pattern_io = Pattern.compile("[i-o]");
    static Pattern pattern_pz = Pattern.compile("[p-z]");
    static Pattern pattern_09 = Pattern.compile("[0-9]");

    public SwordItemOfSelection(String regName) {
        super(Item.ToolMaterial.DIAMOND);
        this.func_77637_a(TabsInit.TAB_AUXWEP);
        this.setRegistryName(regName);
        this.func_77655_b(regName);
        ItemInit.ITEMS.add((Item)this);
        this.setModelSwitch("characters", (Item)this, 4);
    }

    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
        return false;
    }

    public InteractionResultHolder<ItemStack> func_77659_a(Level worldIn, Player playerIn, InteractionHand handIn) {
        ItemStack stack = playerIn.func_184586_b(handIn);
        if (!stack.func_77942_o()) {
            stack.func_77982_d(new CompoundTag());
            stack.func_77978_p().func_74757_a("cycling_style", true);
            stack.func_77978_p().func_74768_a("characters_data", 0);
        } else {
            stack.func_77978_p().func_74757_a("cycling_style", !stack.func_77978_p().func_74767_n("cycling_style"));
        }
        worldIn.func_184133_a(null, playerIn.func_180425_c(), SoundEvents.field_187556_aj, SoundSource.MASTER, 1.0f, 1.0f);
        return super.func_77659_a(worldIn, playerIn, handIn);
    }

    public boolean func_77644_a(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        String hit_name;
        if (stack.func_77942_o() && !(hit_name = target.func_70005_c_().toLowerCase()).isEmpty() && this.regexMatch(stack.func_77978_p().func_74762_e("characters_data"), hit_name.substring(0, 1))) {
            target.field_70170_p.func_184133_a(null, target.func_180425_c(), SoundInit.GALAXYFIRE, SoundSource.MASTER, 1.0f, 1.0f);
            IMaxAttack.dealMaxHealth((Entity)attacker, target, 2, 3.0f);
        }
        return false;
    }

    private boolean regexMatch(int selection, String ch) {
        switch (selection) {
            case 0: {
                return pattern_ah.matcher(ch).matches();
            }
            case 1: {
                return pattern_io.matcher(ch).matches();
            }
            case 2: {
                return pattern_pz.matcher(ch).matches();
            }
            case 3: {
                return pattern_09.matcher(ch).matches();
            }
        }
        return false;
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Light_Purple) + "Right Click: Toggle cycling through groups of characters.");
        tooltip.add((Object)((Object)TextFmt.Red) + "When hitting an entity who's name begins with a character in the group:");
        tooltip.add((Object)((Object)TextFmt.Green) + "Deal 150% maximum life damage to the entity.");
    }

    @Override
    public void heldTick(Player player, InteractionHand hand, ItemStack stack) {
        if (stack.func_77942_o() && stack.func_77978_p().func_74764_b("cycling_style") && player.field_70173_aa % 5 == 0 && stack.func_77978_p().func_74767_n("cycling_style")) {
            int data = stack.func_77978_p().func_74762_e("characters_data");
            data = data < 3 ? ++data : 0;
            player.field_70170_p.func_184133_a(null, player.func_180425_c(), SoundInit.GENERIC_WEAPON_3, SoundSource.MASTER, 1.0f, 0.9f + player.field_70170_p.field_73012_v.nextFloat() * 0.2f);
            stack.func_77978_p().func_74768_a("characters_data", data);
        }
    }
}

