/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.creativetab.CreativeModeTab
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.init;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.init.ArmorInit;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.ItemInit;

public class TabsInit {
    public static final CreativeModeTab TAB_STONES = new CreativeModeTab("tab_stones"){

        @SideOnly(value=Side.CLIENT)
        public ItemStack func_78016_d() {
            return new ItemStack(ItemInit.corruptionCube);
        }
    };
    public static final CreativeModeTab TAB_MAPS = new CreativeModeTab("tab_maps"){

        @SideOnly(value=Side.CLIENT)
        public ItemStack func_78016_d() {
            return new ItemStack(ItemInit.corruptionMap);
        }
    };
    public static final CreativeModeTab TAB_DEVIANT = new CreativeModeTab("tab_deviant"){

        @SideOnly(value=Side.CLIENT)
        public ItemStack func_78016_d() {
            return new ItemStack(ItemInit.deviantEnderPearl);
        }
    };
    public static final CreativeModeTab TAB_AUXMATS = new CreativeModeTab("tab_auxillary"){

        @SideOnly(value=Side.CLIENT)
        public ItemStack func_78016_d() {
            return new ItemStack(ItemInit.celestialDiamond);
        }
    };
    public static final CreativeModeTab TAB_INFINITYWEP = new CreativeModeTab("tab_infinity"){

        @SideOnly(value=Side.CLIENT)
        public ItemStack func_78016_d() {
            return new ItemStack(ItemInit.bladesOfDuality);
        }
    };
    public static final CreativeModeTab TAB_AUXWEP = new CreativeModeTab("tab_auxweps"){

        @SideOnly(value=Side.CLIENT)
        public ItemStack func_78016_d() {
            return new ItemStack(ItemInit.celestialMinersPickaxe);
        }
    };
    public static final CreativeModeTab TAB_BLOCKS = new CreativeModeTab("tab_blocks"){

        @SideOnly(value=Side.CLIENT)
        public ItemStack func_78016_d() {
            return new ItemStack(Item.func_150898_a((Block)BlockInit.arenaBrickBlue));
        }
    };
    public static final CreativeModeTab TAB_ARMORS = new CreativeModeTab("tab_armors"){

        @SideOnly(value=Side.CLIENT)
        public ItemStack func_78016_d() {
            return new ItemStack(ArmorInit.celestialHeadguard);
        }
    };
    public static final CreativeModeTab TAB_DEVIANTWEP = new CreativeModeTab("tab_deviantweapons"){

        @SideOnly(value=Side.CLIENT)
        public ItemStack func_78016_d() {
            return new ItemStack(ItemInit.deviantRelocator);
        }
    };
    public static final CreativeModeTab TAB_STARFORGE = new CreativeModeTab("tab_starforge"){

        @SideOnly(value=Side.CLIENT)
        public ItemStack func_78016_d() {
            return new ItemStack(ItemInit.astralliumIngot);
        }
    };
    public static final CreativeModeTab TAB_MASTERCRAFT = new CreativeModeTab("tab_mastercraft"){

        @SideOnly(value=Side.CLIENT)
        public ItemStack func_78016_d() {
            return new ItemStack(ItemInit.masterForgedIngot);
        }
    };
    public static final CreativeModeTab TAB_SUPERMUTATED = new CreativeModeTab("tab_supermutated"){

        @SideOnly(value=Side.CLIENT)
        public ItemStack func_78016_d() {
            return new ItemStack(ItemInit.superMutatedPearl);
        }
    };
    public static final CreativeModeTab TAB_GALAXY = new CreativeModeTab("tab_galaxydungeon"){

        @SideOnly(value=Side.CLIENT)
        public ItemStack func_78016_d() {
            return new ItemStack(ItemInit.galaxyBeacon);
        }
    };
    public static final CreativeModeTab TAB_CELESTIALARENA = new CreativeModeTab("tab_celestialarena"){

        @SideOnly(value=Side.CLIENT)
        public ItemStack func_78016_d() {
            return new ItemStack(ItemInit.tokenUrogo);
        }
    };
}

