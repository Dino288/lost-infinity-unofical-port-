/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.inventory.EntityEquipmentSlot
 *  net.minecraft.item.Item
 *  net.minecraft.item.ArmorItem$ArmorMaterial
 *  net.minecraft.util.SoundEvent
 *  net.minecraftforge.common.util.EnumHelper
 *  net.minecraftforge.event.RegistryEvent$Register
 *  net.minecraftforge.fml.common.Mod$EventBusSubscriber
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  net.minecraftforge.registries.IForgeRegistry
 *  net.minecraftforge.registries.IForgeRegistryEntry
 */
package xol.lostinfinity.init;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.List;
import net.minecraft.world.level.block.Block;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.item.armor.ItemBionicVeggitronArmor;
import xol.lostinfinity.item.armor.ItemBlightcystArmor;
import xol.lostinfinity.item.armor.ItemBlightcystPrimeArmor;
import xol.lostinfinity.item.armor.ItemCelestialHeadguard;
import xol.lostinfinity.item.armor.ItemFiltrationMask;
import xol.lostinfinity.item.armor.ItemGraviteriumArmor;
import xol.lostinfinity.item.armor.ItemLostArmor;
import xol.lostinfinity.item.armor.ItemPlasmythicArmor;
import xol.lostinfinity.item.armor.ItemSpectrosArmor;
import xol.lostinfinity.item.armor.ItemSpectrosPrimeArmor;
import xol.lostinfinity.item.armor.ItemVampyreonArmor;
import xol.lostinfinity.item.armor.ItemVampyreonPrimeArmor;
import xol.lostinfinity.item.armor.ItemVitralitonArmor;
import xol.lostinfinity.item.armor.ItemVitralitonPrimeArmor;

@Mod.EventBusSubscriber
public class ArmorInit {
    public static final ArmorItem.ArmorMaterial ARMOUR_CELESTIAL = EnumHelper.addArmorMaterial((String)"armor_celestial", (String)"lostinfinity:celestial", (int)-1, (int[])new int[]{3, 6, 8, 3}, (int)10, (SoundEvent)SoundEvents.field_187716_o, (float)2.0f);
    public static final ArmorSet vampyreonSet = new ArmorSet("Vampyreon", ItemVampyreonArmor.class);
    public static final ArmorSet graviteriumSet = new ArmorSet("Graviterium", ItemGraviteriumArmor.class);
    public static final ArmorSet plasmythicSet = new ArmorSet("Plasmythic", ItemPlasmythicArmor.class);
    public static final ArmorSet spectrosSet = new ArmorSet("Spectros", ItemSpectrosArmor.class);
    public static final ArmorSet vitralitonSet = new ArmorSet("Vitraliton", ItemVitralitonArmor.class);
    public static final ArmorSet blightcystSet = new ArmorSet("Blightcyst", ItemBlightcystArmor.class);
    public static final ArmorSet bionicveggitronSet = new ArmorSet("Bionic_veggitron", ItemBionicVeggitronArmor.class);
    public static final ArmorSet vampyreonPrimeSet = new ArmorSet("Vampyreon_prime", ItemVampyreonPrimeArmor.class);
    public static final ArmorSet spectrosPrimeSet = new ArmorSet("Spectros_prime", ItemSpectrosPrimeArmor.class);
    public static final ArmorSet vitralitonPrimeSet = new ArmorSet("Vitraliton_prime", ItemVitralitonPrimeArmor.class);
    public static final ArmorSet blightcystPrimeSet = new ArmorSet("Blightcyst_prime", ItemBlightcystPrimeArmor.class);
    public static final Item celestialHeadguard = new ItemCelestialHeadguard(ARMOUR_CELESTIAL, 1, EntityEquipmentSlot.HEAD, "celestialheadguard");
    public static final Item filtrationMask = new ItemFiltrationMask(ARMOUR_CELESTIAL, 1, EntityEquipmentSlot.HEAD, "filtrationmask");

    @SubscribeEvent
    public static void onBlockRegister(RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll((IForgeRegistryEntry[])BlockInit.BLOCKS.toArray(new Block[0]));
    }

    @SubscribeEvent
    public static void onItemRegister(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll((IForgeRegistryEntry[])ItemInit.ITEMS.toArray(new Item[0]));
        ArmorInit.registerArmorSets((IForgeRegistry<Item>)event.getRegistry(), vampyreonSet);
        ArmorInit.registerArmorSets((IForgeRegistry<Item>)event.getRegistry(), graviteriumSet);
        ArmorInit.registerArmorSets((IForgeRegistry<Item>)event.getRegistry(), plasmythicSet);
        ArmorInit.registerArmorSets((IForgeRegistry<Item>)event.getRegistry(), spectrosSet);
        ArmorInit.registerArmorSets((IForgeRegistry<Item>)event.getRegistry(), blightcystSet);
        ArmorInit.registerArmorSets((IForgeRegistry<Item>)event.getRegistry(), bionicveggitronSet);
        ArmorInit.registerArmorSets((IForgeRegistry<Item>)event.getRegistry(), vitralitonSet);
        ArmorInit.registerArmorSets((IForgeRegistry<Item>)event.getRegistry(), vampyreonPrimeSet);
        ArmorInit.registerArmorSets((IForgeRegistry<Item>)event.getRegistry(), spectrosPrimeSet);
        ArmorInit.registerArmorSets((IForgeRegistry<Item>)event.getRegistry(), vitralitonPrimeSet);
        ArmorInit.registerArmorSets((IForgeRegistry<Item>)event.getRegistry(), blightcystPrimeSet);
    }

    public static void registerArmorSets(IForgeRegistry<Item> registry, ArmorSet ... sets) {
        Arrays.stream(sets).forEach(set -> registry.registerAll((IForgeRegistryEntry[])((ArmorSet)set).getArmor().toArray(new Item[0])));
    }

    public static class ArmorSet {
        public ItemLostArmor helmet = null;
        public ItemLostArmor chestplate = null;
        public ItemLostArmor leggings = null;
        public ItemLostArmor boots = null;

        private List<? extends Item> getArmor() {
            return Arrays.asList(this.helmet, this.chestplate, this.leggings, this.boots);
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        private ArmorSet(String name, Class<? extends ItemLostArmor> armor) {
            ItemLostArmor helm = null;
            ItemLostArmor chest = null;
            ItemLostArmor legs = null;
            ItemLostArmor boot = null;
            try {
                Constructor<? extends ItemLostArmor> c = armor.getConstructor(String.class, EntityEquipmentSlot.class);
                helm = c.newInstance(name.toLowerCase() + "_helmet", EntityEquipmentSlot.HEAD);
                chest = c.newInstance(name.toLowerCase() + "_chestplate", EntityEquipmentSlot.CHEST);
                legs = c.newInstance(name.toLowerCase() + "_leggings", EntityEquipmentSlot.LEGS);
                boot = c.newInstance(name.toLowerCase() + "_boots", EntityEquipmentSlot.FEET);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            finally {
                this.helmet = helm;
                this.chestplate = chest;
                this.leggings = legs;
                this.boots = boot;
            }
        }
    }
}

