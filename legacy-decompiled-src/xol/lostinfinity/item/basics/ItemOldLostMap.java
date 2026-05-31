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
 *  net.minecraft.util.SoundSource
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
import net.minecraft.sounds.SoundSource;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.mob.entity.boss.EntityElara;

public class ItemOldLostMap
extends Item {
    private String loc_clue = "";
    private String originatorName = "";
    private String biomeType = "";

    public ItemOldLostMap(String regName, String clue, String orname) {
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
            for (int i = 0; i < playerIn.field_71071_by.func_70302_i_(); ++i) {
                if (playerIn.field_71071_by.func_70301_a(i) == null || playerIn.field_71071_by.func_70301_a(i).func_77973_b() != spawnItem) continue;
                foundSpawner = true;
                worldIn.func_184148_a(playerIn, playerIn.field_70165_t, playerIn.field_70163_u, playerIn.field_70161_v, SoundInit.ARENA_CHALLENGE, SoundSource.MASTER, 2.0f, 1.0f);
                if (!worldIn.field_72995_K) {
                    if (BiomeDictionary.getBiomes((BiomeDictionary.Type)BiomeDictionary.Type.OCEAN).contains(playerIn.field_70170_p.func_180494_b(playerIn.func_180425_c()))) {
                        EntityElara siren = new EntityElara(worldIn);
                        siren.func_70107_b(playerIn.field_70165_t, playerIn.field_70163_u + 5.0, playerIn.field_70161_v);
                        worldIn.func_72838_d((Entity)siren);
                    } else {
                        EntityElara boundless = new EntityElara(worldIn);
                        boundless.func_70107_b(playerIn.field_70165_t, playerIn.field_70163_u + 5.0, playerIn.field_70161_v);
                        boundless.setForm((byte)1);
                        worldIn.func_72838_d((Entity)boundless);
                    }
                }
                playerIn.field_71071_by.func_70301_a(i).func_190918_g(1);
            }
            if (!foundSpawner && worldIn.field_72995_K) {
                playerIn.func_145747_a((Component)new Component((Object)((Object)TextFmt.Dark_Red) + "No encounter spawn item found."));
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
                biotype = BiomeDictionary.Type.END;
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
        }
        return ItemInit.elarasNecklace;
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Gold) + "A map " + this.loc_clue);
        tooltip.add((Object)((Object)TextFmt.Red) + "You will challenge " + this.originatorName);
    }
}

