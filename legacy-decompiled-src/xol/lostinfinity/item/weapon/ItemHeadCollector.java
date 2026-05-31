/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.GameProfile
 *  javax.annotation.Nullable
 *  net.minecraft.client.util.ITooltipFlag
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.item.ItemEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.init.Items
 *  net.minecraft.item.Item
 *  net.minecraft.item.Item$ToolMaterial
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.SwordItem
 *  net.minecraft.nbt.NBTBase
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.nbt.NBTUtil
 *  net.minecraft.tileentity.BlockEntitySkull
 *  net.minecraft.util.InteractionResultHolder
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.item.weapon;

import com.mojang.authlib.GameProfile;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.tileentity.BlockEntitySkull;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.common.lostinfinity;
import xol.lostinfinity.gui.GuiHandler;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.util.data.IMaxAttack;

public class ItemHeadCollector
extends SwordItem
implements IMaxAttack {
    public static final int CHARGE_LIMIT = 10;

    public ItemHeadCollector(String regName) {
        super(Item.ToolMaterial.WOOD);
        this.func_77637_a(TabsInit.TAB_INFINITYWEP);
        this.setRegistryName(regName);
        this.func_77655_b(regName);
        ItemInit.ITEMS.add((Item)this);
    }

    public boolean func_77644_a(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        boolean shouldDropHead;
        boolean player = target instanceof Player;
        boolean bl = shouldDropHead = stack.func_77942_o() && stack.func_77978_p().func_74762_e("Charge") > 0;
        if (shouldDropHead && player) {
            ItemStack st = new ItemStack(Items.field_151144_bL, 1, 3);
            if (!st.func_77942_o()) {
                st.func_77982_d(new CompoundTag());
            }
            st.func_77978_p().func_74778_a("Owner", target.func_70005_c_());
            st.func_77978_p().func_74768_a("Immunity", 10);
            st.func_77978_p().func_74772_a("LastBlock", 0L);
            GameProfile gameprofile = new GameProfile(target.func_110124_au(), target.func_70005_c_());
            gameprofile = BlockEntitySkull.func_174884_b((GameProfile)gameprofile);
            st.func_77978_p().func_74782_a("SkullOwner", (NBTBase)NBTUtil.func_180708_a((CompoundTag)new CompoundTag(), (GameProfile)gameprofile));
            if (!attacker.field_70170_p.field_72995_K) {
                ItemEntity skull = new ItemEntity(attacker.field_70170_p, attacker.field_70165_t, attacker.field_70163_u + 1.0, attacker.field_70161_v, st);
                skull.field_70159_w = 0.0;
                skull.field_70181_x = 0.0;
                skull.field_70179_y = 0.0;
                attacker.field_70170_p.func_72838_d((Entity)skull);
            }
            stack.func_77978_p().func_74768_a("Charge", stack.func_77978_p().func_74762_e("Charge") - 1);
        }
        IMaxAttack.dealMaxHealth((Entity)attacker, target, 10);
        return true;
    }

    public InteractionResultHolder<ItemStack> func_77659_a(Level worldIn, Player playerIn, InteractionHand handIn) {
        playerIn.openGui((Object)lostinfinity.instance, GuiHandler.RegisteredGuis.ITEM_CHARGER.getId(), worldIn, 0, 0, 0);
        return super.func_77659_a(worldIn, playerIn, handIn);
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        if (!stack.func_77942_o()) {
            stack.func_77982_d(new CompoundTag());
        }
        tooltip.add((Object)((Object)TextFmt.Gold) + "Deals 10% Max Health Damage");
        tooltip.add((Object)((Object)TextFmt.Green) + "Current Charge: " + stack.func_77978_p().func_74762_e("Charge") + " / " + 10);
        tooltip.add(TextFmt.getFormatting(TextFmt.Italic, TextFmt.Light_Purple) + "With charge:");
        tooltip.add((Object)((Object)TextFmt.Red) + "Collects the head of a player on kill, using a charge.");
        tooltip.add((Object)((Object)TextFmt.Italic) + "Wearing the collected head is honestly pretty morbid");
    }
}

