/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.client.util.ITooltipFlag
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.InteractionResultHolder
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraft.world.World
 *  net.minecraftforge.common.BiomeDictionary
 *  net.minecraftforge.common.BiomeDictionary$Type
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.item.basics;

import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.dimension.util.DimensionActivator;
import xol.lostinfinity.init.ArmorInit;
import xol.lostinfinity.init.DimensionInit;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.util.player.PlayerManager;

public class ItemLostMap
extends Item {
    private String loc_clue = "";
    private String originatorName = "";
    private String biomeType = "";

    public ItemLostMap(String regName, String clue, String orname) {
        this.func_77637_a(TabsInit.TAB_MAPS);
        this.setRegistryName(regName);
        this.func_77655_b(regName);
        this.loc_clue = clue;
        this.originatorName = orname;
        this.biomeType = regName.replace("map_", "");
        ItemInit.ITEMS.add(this);
    }

    public InteractionResultHolder<ItemStack> func_77659_a(Level worldIn, Player playerIn, InteractionHand handIn) {
        if (this.biomeMatchMap(playerIn)) {
            Item spawnItem = this.getSpawnItem();
            boolean foundSpawner = false;
            boolean wearingHeadguard = false;
            for (int i = 0; i < playerIn.field_71071_by.func_70302_i_(); ++i) {
                if (playerIn.field_71071_by.func_70301_a(i).func_77973_b() != spawnItem) continue;
                foundSpawner = true;
                ItemStack helm = playerIn.field_71071_by.func_70301_a(39);
                if (helm.func_77973_b() != ArmorInit.celestialHeadguard && !PlayerManager.isWearingAnySet(playerIn)) continue;
                wearingHeadguard = true;
                playerIn.field_71071_by.func_70301_a(i).func_190918_g(1);
                playerIn.field_71071_by.func_70299_a(i, this.getBossToken());
                DimensionActivator.transferEntityWithCoords((Entity)playerIn, DimensionInit.celestialVoid, 25.5, 31.5, 31.5);
                if (!worldIn.field_72995_K) continue;
                playerIn.func_145747_a((Component)new Component((Object)((Object)TextFmt.Dark_Blue) + "Welcome to the Grand Celestial Arena."));
            }
            if (!foundSpawner) {
                if (worldIn.field_72995_K) {
                    playerIn.func_145747_a((Component)new Component((Object)((Object)TextFmt.Dark_Red) + "No encounter spawn item found."));
                }
            } else if (!wearingHeadguard && worldIn.field_72995_K) {
                playerIn.func_145747_a((Component)new Component((Object)((Object)TextFmt.Dark_Red) + "You must wear a Celestial Headguard to enter the arena."));
            }
        } else if (worldIn.field_72995_K) {
            playerIn.func_145747_a((Component)new Component((Object)((Object)TextFmt.Dark_Red) + "This biome does not match the clue."));
        }
        return super.func_77659_a(worldIn, playerIn, handIn);
    }

    private boolean biomeMatchMap(Player player) {
        BiomeDictionary.Type biotype;
        switch (this.biomeType) {
            case "corruption": {
                biotype = BiomeDictionary.Type.MESA;
                break;
            }
            case "duality": {
                biotype = BiomeDictionary.Type.OCEAN;
                break;
            }
            case "aspiration": {
                biotype = BiomeDictionary.Type.MOUNTAIN;
                break;
            }
            case "ingenuity": {
                biotype = BiomeDictionary.Type.VOID;
                break;
            }
            case "misdirection": {
                biotype = BiomeDictionary.Type.MUSHROOM;
                break;
            }
            case "vengeance": {
                biotype = BiomeDictionary.Type.END;
                break;
            }
            case "dread": {
                biotype = BiomeDictionary.Type.HOT;
                break;
            }
            case "imposition": {
                biotype = BiomeDictionary.Type.SWAMP;
                break;
            }
            case "anxiety": {
                biotype = BiomeDictionary.Type.SNOWY;
                break;
            }
            case "retrospection": {
                biotype = BiomeDictionary.Type.SAVANNA;
                break;
            }
            default: {
                biotype = BiomeDictionary.Type.PLAINS;
            }
        }
        return BiomeDictionary.getBiomes((BiomeDictionary.Type)biotype).contains(player.field_70170_p.func_180494_b(player.func_180425_c()));
    }

    private Item getSpawnItem() {
        switch (this.biomeType) {
            case "duality": {
                return ItemInit.elarasNecklace;
            }
            case "aspiration": {
                return ItemInit.elarasNecklace;
            }
            case "corruption": {
                return ItemInit.jeweledSkullTrophy;
            }
            case "ingenuity": {
                return ItemInit.makeshiftTrinket;
            }
            case "misdirection": {
                return ItemInit.etherealMirror;
            }
            case "vengeance": {
                return ItemInit.twinnedJewel;
            }
            case "dread": {
                return ItemInit.engulfedEye;
            }
            case "imposition": {
                return ItemInit.mountedCrystal;
            }
            case "anxiety": {
                return ItemInit.frostedStar;
            }
            case "retrospection": {
                return ItemInit.mixOfDominance;
            }
        }
        return ItemInit.elarasNecklace;
    }

    private ItemStack getBossToken() {
        switch (this.biomeType) {
            case "duality": {
                return new ItemStack(ItemInit.tokenUrogo);
            }
            case "aspiration": {
                return new ItemStack(ItemInit.tokenUrogo);
            }
            case "corruption": {
                return new ItemStack(ItemInit.tokenUrogo);
            }
            case "ingenuity": {
                return new ItemStack(ItemInit.tokenVelo);
            }
            case "misdirection": {
                return new ItemStack(ItemInit.tokenRikarus);
            }
            case "vengeance": {
                return new ItemStack(ItemInit.tokenNuxuro);
            }
            case "dread": {
                return new ItemStack(ItemInit.tokenDario);
            }
            case "imposition": {
                return new ItemStack(ItemInit.tokenAtlasspire);
            }
            case "anxiety": {
                return new ItemStack(ItemInit.tokenAlestria);
            }
            case "retrospection": {
                return new ItemStack(ItemInit.tokenArash);
            }
        }
        return new ItemStack(ItemInit.tokenUrogo);
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Gold) + "A map " + this.loc_clue);
        tooltip.add((Object)((Object)TextFmt.Red) + "You will challenge " + this.originatorName);
    }
}

