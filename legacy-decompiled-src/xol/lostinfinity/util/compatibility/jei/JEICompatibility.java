/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nonnull
 *  mezz.jei.api.IGuiHelper
 *  mezz.jei.api.IJeiHelpers
 *  mezz.jei.api.IModPlugin
 *  mezz.jei.api.IModRegistry
 *  mezz.jei.api.JEIPlugin
 *  mezz.jei.api.ingredients.IIngredientRegistry
 *  mezz.jei.api.ingredients.VanillaTypes
 *  mezz.jei.api.recipe.IRecipeCategory
 *  mezz.jei.api.recipe.IRecipeCategoryRegistration
 *  mezz.jei.api.recipe.transfer.IRecipeTransferRegistry
 *  net.minecraft.item.ItemStack
 *  net.minecraftforge.fml.common.Loader
 */
package xol.lostinfinity.util.compatibility.jei;

import java.util.Arrays;
import javax.annotation.Nonnull;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.JEIPlugin;
import mezz.jei.api.ingredients.IIngredientRegistry;
import mezz.jei.api.ingredients.VanillaTypes;
import mezz.jei.api.recipe.IRecipeCategory;
import mezz.jei.api.recipe.IRecipeCategoryRegistration;
import mezz.jei.api.recipe.transfer.IRecipeTransferRegistry;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fml.common.Loader;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.util.compatibility.jei.augmentor.AugmentorRecipeCategory;
import xol.lostinfinity.util.compatibility.jei.augmentor.AugmentorRecipeWrapper;
import xol.lostinfinity.util.compatibility.jei.chemistrynegametric.ChemistryNegametricRecipeCategory;
import xol.lostinfinity.util.compatibility.jei.chemistrynegametric.ChemistryNegametricRecipeWrapper;
import xol.lostinfinity.util.compatibility.jei.chemistryradiochronic.ChemistryRadiochronicRecipeCategory;
import xol.lostinfinity.util.compatibility.jei.chemistryradiochronic.ChemistryRadiochronicRecipeWrapper;
import xol.lostinfinity.util.compatibility.jei.compressiontable.CompressionTableRecipeCategory;
import xol.lostinfinity.util.compatibility.jei.compressiontable.CompressionTableRecipeWrapper;
import xol.lostinfinity.util.compatibility.jei.fabricationstation.FabricationStationRecipeCategory;
import xol.lostinfinity.util.compatibility.jei.fabricationstation.FabricationStationRecipeWrapper;
import xol.lostinfinity.util.compatibility.jei.fossilcombiner.FossilCombinerRecipeCategory;
import xol.lostinfinity.util.compatibility.jei.fossilcombiner.FossilCombinerRecipeWrapper;
import xol.lostinfinity.util.compatibility.jei.fusiontable.FusionTableRecipeCategory;
import xol.lostinfinity.util.compatibility.jei.fusiontable.FusionTableRecipeWrapper;
import xol.lostinfinity.util.compatibility.jei.itemcharger.ItemChargerRecipeCategory;
import xol.lostinfinity.util.compatibility.jei.itemcharger.ItemChargerRecipeWrapper;
import xol.lostinfinity.util.compatibility.jei.modulator.ModulatorRecipeCategory;
import xol.lostinfinity.util.compatibility.jei.modulator.ModulatorRecipeWrapper;
import xol.lostinfinity.util.compatibility.jei.modulecreator.ModuleCreatorRecipeCategory;
import xol.lostinfinity.util.compatibility.jei.modulecreator.ModuleCreatorRecipeWrapper;
import xol.lostinfinity.util.compatibility.jei.mysterybox.MysteryBoxRecipeCategory;
import xol.lostinfinity.util.compatibility.jei.mysterybox.MysteryBoxRecipeWrapper;
import xol.lostinfinity.util.compatibility.jei.nicroniuminfuser.NicroniumInfuserRecipeCategory;
import xol.lostinfinity.util.compatibility.jei.nicroniuminfuser.NicroniumInfuserRecipeWrapper;
import xol.lostinfinity.util.compatibility.jei.pickchargingtable.PickChargingTableRecipeCategory;
import xol.lostinfinity.util.compatibility.jei.pickchargingtable.PickChargingTableRecipeWrapper;
import xol.lostinfinity.util.compatibility.jei.rainfallgenerator.RainfallGeneratorRecipeCategory;
import xol.lostinfinity.util.compatibility.jei.rainfallgenerator.RainfallGeneratorRecipeWrapper;
import xol.lostinfinity.util.compatibility.jei.sapevaporator.SapEvaporatorRecipeCategory;
import xol.lostinfinity.util.compatibility.jei.sapevaporator.SapEvaporatorRecipeWrapper;
import xol.lostinfinity.util.compatibility.jei.trades.archeologist.ArcheologistTradeCategory;
import xol.lostinfinity.util.compatibility.jei.trades.archeologist.ArcheologistTradeWrapper;
import xol.lostinfinity.util.compatibility.jei.trades.blackmarket.BlackMarketTradeCategory;
import xol.lostinfinity.util.compatibility.jei.trades.blackmarket.BlackMarketTradeWrapper;
import xol.lostinfinity.util.compatibility.jei.trades.chemist.ChemistTradeCategory;
import xol.lostinfinity.util.compatibility.jei.trades.chemist.ChemistTradeWrapper;
import xol.lostinfinity.util.compatibility.jei.trades.zirconia.aubergine.AubergineTradeCategory;
import xol.lostinfinity.util.compatibility.jei.trades.zirconia.aubergine.AubergineTradeWrapper;
import xol.lostinfinity.util.compatibility.jei.trades.zirconia.celadon.CeladonTradeCategory;
import xol.lostinfinity.util.compatibility.jei.trades.zirconia.celadon.CeladonTradeWrapper;
import xol.lostinfinity.util.compatibility.jei.trades.zirconia.cerulean.CeruleanTradeCategory;
import xol.lostinfinity.util.compatibility.jei.trades.zirconia.cerulean.CeruleanTradeWrapper;
import xol.lostinfinity.util.compatibility.jei.trades.zirconia.citrine.CitrineTradeCategory;
import xol.lostinfinity.util.compatibility.jei.trades.zirconia.citrine.CitrineTradeWrapper;
import xol.lostinfinity.util.compatibility.jei.trades.zirconia.crimson.CrimsonTradeCategory;
import xol.lostinfinity.util.compatibility.jei.trades.zirconia.crimson.CrimsonTradeWrapper;
import xol.lostinfinity.util.compatibility.jei.trades.zirconia.ivory.IvoryTradeCategory;
import xol.lostinfinity.util.compatibility.jei.trades.zirconia.ivory.IvoryTradeWrapper;
import xol.lostinfinity.util.compatibility.jei.trades.zirconia.malachite.MalachiteTradeCategory;
import xol.lostinfinity.util.compatibility.jei.trades.zirconia.malachite.MalachiteTradeWrapper;
import xol.lostinfinity.util.compatibility.jei.trades.zirconia.midnight.MidnightTradeCategory;
import xol.lostinfinity.util.compatibility.jei.trades.zirconia.midnight.MidnightTradeWrapper;
import xol.lostinfinity.util.compatibility.jei.trades.zirconia.musky.MuskyTradeCategory;
import xol.lostinfinity.util.compatibility.jei.trades.zirconia.musky.MuskyTradeWrapper;
import xol.lostinfinity.util.compatibility.jei.trades.zirconia.mythic.MythicTradeCategory;
import xol.lostinfinity.util.compatibility.jei.trades.zirconia.mythic.MythicTradeWrapper;
import xol.lostinfinity.util.compatibility.jei.trades.zirconia.oyster.OysterTradeCategory;
import xol.lostinfinity.util.compatibility.jei.trades.zirconia.oyster.OysterTradeWrapper;
import xol.lostinfinity.util.compatibility.jei.trades.zirconia.rosewood.RosewoodTradeCategory;
import xol.lostinfinity.util.compatibility.jei.trades.zirconia.rosewood.RosewoodTradeWrapper;

@JEIPlugin
public class JEICompatibility
implements IModPlugin {
    public void registerCategories(@Nonnull IRecipeCategoryRegistration registry) {
        if (!Loader.isModLoaded((String)"jei")) {
            return;
        }
        IJeiHelpers jeiHelpers = registry.getJeiHelpers();
        IGuiHelper guiHelper = jeiHelpers.getGuiHelper();
        registry.addRecipeCategories(new IRecipeCategory[]{new AugmentorRecipeCategory(guiHelper)});
        registry.addRecipeCategories(new IRecipeCategory[]{new CompressionTableRecipeCategory(guiHelper)});
        registry.addRecipeCategories(new IRecipeCategory[]{new FossilCombinerRecipeCategory(guiHelper)});
        registry.addRecipeCategories(new IRecipeCategory[]{new FusionTableRecipeCategory(guiHelper)});
        registry.addRecipeCategories(new IRecipeCategory[]{new ItemChargerRecipeCategory(guiHelper)});
        registry.addRecipeCategories(new IRecipeCategory[]{new ModulatorRecipeCategory(guiHelper)});
        registry.addRecipeCategories(new IRecipeCategory[]{new ModuleCreatorRecipeCategory(guiHelper)});
        registry.addRecipeCategories(new IRecipeCategory[]{new NicroniumInfuserRecipeCategory(guiHelper)});
        registry.addRecipeCategories(new IRecipeCategory[]{new PickChargingTableRecipeCategory(guiHelper)});
        registry.addRecipeCategories(new IRecipeCategory[]{new RainfallGeneratorRecipeCategory(guiHelper)});
        registry.addRecipeCategories(new IRecipeCategory[]{new SapEvaporatorRecipeCategory(guiHelper)});
        registry.addRecipeCategories(new IRecipeCategory[]{new FabricationStationRecipeCategory(guiHelper)});
        registry.addRecipeCategories(new IRecipeCategory[]{new MysteryBoxRecipeCategory(guiHelper)});
        registry.addRecipeCategories(new IRecipeCategory[]{new ChemistryRadiochronicRecipeCategory(guiHelper)});
        registry.addRecipeCategories(new IRecipeCategory[]{new ChemistryNegametricRecipeCategory(guiHelper)});
        registry.addRecipeCategories(new IRecipeCategory[]{new ArcheologistTradeCategory(guiHelper)});
        registry.addRecipeCategories(new IRecipeCategory[]{new BlackMarketTradeCategory(guiHelper)});
        registry.addRecipeCategories(new IRecipeCategory[]{new ChemistTradeCategory(guiHelper)});
        registry.addRecipeCategories(new IRecipeCategory[]{new AubergineTradeCategory(guiHelper)});
        registry.addRecipeCategories(new IRecipeCategory[]{new CeladonTradeCategory(guiHelper)});
        registry.addRecipeCategories(new IRecipeCategory[]{new CeruleanTradeCategory(guiHelper)});
        registry.addRecipeCategories(new IRecipeCategory[]{new CitrineTradeCategory(guiHelper)});
        registry.addRecipeCategories(new IRecipeCategory[]{new CrimsonTradeCategory(guiHelper)});
        registry.addRecipeCategories(new IRecipeCategory[]{new IvoryTradeCategory(guiHelper)});
        registry.addRecipeCategories(new IRecipeCategory[]{new MalachiteTradeCategory(guiHelper)});
        registry.addRecipeCategories(new IRecipeCategory[]{new MidnightTradeCategory(guiHelper)});
        registry.addRecipeCategories(new IRecipeCategory[]{new MuskyTradeCategory(guiHelper)});
        registry.addRecipeCategories(new IRecipeCategory[]{new MythicTradeCategory(guiHelper)});
        registry.addRecipeCategories(new IRecipeCategory[]{new OysterTradeCategory(guiHelper)});
        registry.addRecipeCategories(new IRecipeCategory[]{new RosewoodTradeCategory(guiHelper)});
    }

    public void register(@Nonnull IModRegistry registry) {
        IIngredientRegistry ingredientRegistry = registry.getIngredientRegistry();
        IJeiHelpers jeiHelpers = registry.getJeiHelpers();
        IRecipeTransferRegistry recipeTransferRegistry = registry.getRecipeTransferRegistry();
        registry.addRecipes(AugmentorRecipeWrapper.getRecipes(jeiHelpers), "lostinfinity.augmentor");
        registry.addRecipes(CompressionTableRecipeWrapper.getRecipes(jeiHelpers), "lostinfinity.compressiontable");
        registry.addRecipes(FabricationStationRecipeWrapper.getRecipes(jeiHelpers), "lostinfinity.fabricationstation");
        registry.addRecipes(FossilCombinerRecipeWrapper.getRecipes(jeiHelpers), "lostinfinity.fossilcombiner");
        registry.addRecipes(FusionTableRecipeWrapper.getRecipes(jeiHelpers), "lostinfinity.fusiontable");
        registry.addRecipes(ModulatorRecipeWrapper.getRecipes(jeiHelpers), "lostinfinity.modulator");
        registry.addRecipes(ModuleCreatorRecipeWrapper.getRecipes(jeiHelpers), "lostinfinity.modulecreator");
        registry.addRecipes(NicroniumInfuserRecipeWrapper.getRecipes(jeiHelpers), "lostinfinity.nicroniuminfuser");
        registry.addRecipes(PickChargingTableRecipeWrapper.getRecipes(jeiHelpers), "lostinfinity.pickchargingtable");
        registry.addRecipes(SapEvaporatorRecipeWrapper.getRecipes(jeiHelpers), "lostinfinity.sapevaporator");
        registry.addRecipes(ArcheologistTradeWrapper.getRecipes(jeiHelpers), "lostinfinity.archeologist");
        registry.addRecipes(BlackMarketTradeWrapper.getRecipes(jeiHelpers), "lostinfinity.blackmarket");
        registry.addRecipes(ChemistTradeWrapper.getRecipes(jeiHelpers), "lostinfinity.chemist");
        registry.addRecipes(ChemistryRadiochronicRecipeWrapper.getRecipes(jeiHelpers), "lostinfinity.chemistryradiochronic");
        registry.addRecipes(ChemistryNegametricRecipeWrapper.getRecipes(jeiHelpers), "lostinfinity.chemistrynegametric");
        registry.addRecipes(MysteryBoxRecipeWrapper.getRecipes(jeiHelpers), "lostinfinity.mysterybox");
        registry.addRecipes(AubergineTradeWrapper.getRecipes(jeiHelpers), "lostinfinity.zirconia_aubergine");
        registry.addRecipes(CeladonTradeWrapper.getRecipes(jeiHelpers), "lostinfinity.zirconia_celadon");
        registry.addRecipes(CeruleanTradeWrapper.getRecipes(jeiHelpers), "lostinfinity.zirconia_cerulean");
        registry.addRecipes(CitrineTradeWrapper.getRecipes(jeiHelpers), "lostinfinity.zirconia_citrine");
        registry.addRecipes(CrimsonTradeWrapper.getRecipes(jeiHelpers), "lostinfinity.zirconia_crimson");
        registry.addRecipes(IvoryTradeWrapper.getRecipes(jeiHelpers), "lostinfinity.zirconia_ivory");
        registry.addRecipes(MalachiteTradeWrapper.getRecipes(jeiHelpers), "lostinfinity.zirconia_malachite");
        registry.addRecipes(MidnightTradeWrapper.getRecipes(jeiHelpers), "lostinfinity.zirconia_midnight");
        registry.addRecipes(MuskyTradeWrapper.getRecipes(jeiHelpers), "lostinfinity.zirconia_musky");
        registry.addRecipes(MythicTradeWrapper.getRecipes(jeiHelpers), "lostinfinity.zirconia_mythic");
        registry.addRecipes(OysterTradeWrapper.getRecipes(jeiHelpers), "lostinfinity.zirconia_oyster");
        registry.addRecipes(RosewoodTradeWrapper.getRecipes(jeiHelpers), "lostinfinity.zirconia_rosewood");
        registry.addRecipes(RainfallGeneratorRecipeWrapper.getRecipes(jeiHelpers), "lostinfinity.rainfallgenerator");
        registry.addRecipes(ItemChargerRecipeWrapper.getRecipes(jeiHelpers), "lostinfinity.itemcharger");
        registry.addIngredientInfo(Arrays.asList(new ItemStack(ItemInit.emberiumIngot), new ItemStack(ItemInit.hextoriumIngot), new ItemStack(ItemInit.crystoniumIngot), new ItemStack(ItemInit.astralliumIngot), new ItemStack(ItemInit.kylaxiumIngot), new ItemStack(ItemInit.velloriumIngot), new ItemStack(ItemInit.incadiumIngot), new ItemStack(ItemInit.noxeriumIngot), new ItemStack(ItemInit.olysiumIngot), new ItemStack(ItemInit.detheriumIngot), new ItemStack(ItemInit.xeroviumIngot), new ItemStack(ItemInit.phytrosiumIngot), new ItemStack(ItemInit.kyvoriumIngot), new ItemStack(ItemInit.biosynthiumIngot), new ItemStack(ItemInit.maliciumIngot), new ItemStack(ItemInit.etheriumIngot), new ItemStack(ItemInit.polariumIngot)), VanillaTypes.ITEM, new String[]{"description.lostinfinity.jei.ingots"});
        registry.addIngredientInfo(Arrays.asList(new ItemStack(ItemInit.kyvoriumIngot)), VanillaTypes.ITEM, new String[]{"description.lostinfinity.jei.ingots.kyvorium"});
        registry.addIngredientInfo(Arrays.asList(new ItemStack(ItemInit.biosynthiumIngot)), VanillaTypes.ITEM, new String[]{"description.lostinfinity.jei.ingots.biosynthium"});
        registry.addIngredientInfo(Arrays.asList(new ItemStack(ItemInit.maliciumIngot)), VanillaTypes.ITEM, new String[]{"description.lostinfinity.jei.ingots.malicium"});
        registry.addIngredientInfo(Arrays.asList(new ItemStack(ItemInit.etheriumIngot)), VanillaTypes.ITEM, new String[]{"description.lostinfinity.jei.ingots.etherium"});
        registry.addIngredientInfo(Arrays.asList(new ItemStack(ItemInit.polariumIngot)), VanillaTypes.ITEM, new String[]{"description.lostinfinity.jei.ingots.polarium"});
        registry.addIngredientInfo(Arrays.asList(new ItemStack(ItemInit.colixium)), VanillaTypes.ITEM, new String[]{"description.lostinfinity.jei.chemistryclays.colixium"});
        registry.addIngredientInfo(Arrays.asList(new ItemStack(ItemInit.phoroxium)), VanillaTypes.ITEM, new String[]{"description.lostinfinity.jei.chemistryclays.phoroxium"});
        registry.addIngredientInfo(Arrays.asList(new ItemStack(ItemInit.laraxium)), VanillaTypes.ITEM, new String[]{"description.lostinfinity.jei.chemistryclays.laraxium"});
        registry.addIngredientInfo(Arrays.asList(new ItemStack(ItemInit.ingenuityMap)), VanillaTypes.ITEM, new String[]{"description.lostinfinity.jei.minigames.map.ingenuity"});
        registry.addIngredientInfo(Arrays.asList(new ItemStack(ItemInit.dualityMap)), VanillaTypes.ITEM, new String[]{"description.lostinfinity.jei.minigames.map.duality"});
        registry.addIngredientInfo(Arrays.asList(new ItemStack(ItemInit.corruptionMap)), VanillaTypes.ITEM, new String[]{"description.lostinfinity.jei.minigames.map.corruption"});
        registry.addIngredientInfo(Arrays.asList(new ItemStack(ItemInit.aspirationMap)), VanillaTypes.ITEM, new String[]{"description.lostinfinity.jei.minigames.map.aspiration"});
        registry.addIngredientInfo(Arrays.asList(new ItemStack(ItemInit.misdirectionMap)), VanillaTypes.ITEM, new String[]{"description.lostinfinity.jei.minigames.map.misdirection"});
        registry.addIngredientInfo(Arrays.asList(new ItemStack(ItemInit.vengeanceMap)), VanillaTypes.ITEM, new String[]{"description.lostinfinity.jei.minigames.map.vengeance"});
        registry.addIngredientInfo(Arrays.asList(new ItemStack(ItemInit.dreadMap)), VanillaTypes.ITEM, new String[]{"description.lostinfinity.jei.minigames.map.dread"});
        registry.addIngredientInfo(Arrays.asList(new ItemStack(ItemInit.anxietyMap)), VanillaTypes.ITEM, new String[]{"description.lostinfinity.jei.minigames.map.anxiety"});
        registry.addIngredientInfo(Arrays.asList(new ItemStack(ItemInit.impositionMap)), VanillaTypes.ITEM, new String[]{"description.lostinfinity.jei.minigames.map.imposition"});
        registry.addIngredientInfo(Arrays.asList(new ItemStack(ItemInit.retrospectionMap)), VanillaTypes.ITEM, new String[]{"description.lostinfinity.jei.minigames.map.retrospection"});
        registry.addIngredientInfo(Arrays.asList(new ItemStack(ItemInit.ambitionMap)), VanillaTypes.ITEM, new String[]{"description.lostinfinity.jei.minigames.map.ambition"});
        registry.addIngredientInfo(Arrays.asList(new ItemStack(ItemInit.perceptionMap)), VanillaTypes.ITEM, new String[]{"description.lostinfinity.jei.minigames.map.perception"});
        registry.addIngredientInfo(Arrays.asList(new ItemStack(ItemInit.anticipationMap)), VanillaTypes.ITEM, new String[]{"description.lostinfinity.jei.minigames.map.anticipation"});
        registry.addIngredientInfo(Arrays.asList(new ItemStack(ItemInit.crueltyMap)), VanillaTypes.ITEM, new String[]{"description.lostinfinity.jei.minigames.map.cruelty"});
        registry.addIngredientInfo(Arrays.asList(new ItemStack(ItemInit.resolveMap)), VanillaTypes.ITEM, new String[]{"description.lostinfinity.jei.minigames.map.resolve"});
        registry.addIngredientInfo(Arrays.asList(new ItemStack(ItemInit.interspaceTransmitter)), VanillaTypes.ITEM, new String[]{"description.lostinfinity.jei.minigames.interspacetransmitter"});
        registry.addIngredientInfo(Arrays.asList(new ItemStack(ItemInit.mechanicalSextant)), VanillaTypes.ITEM, new String[]{"description.lostinfinity.jei.minigames.mechanicalsextant"});
        registry.addIngredientInfo(Arrays.asList(new ItemStack(ItemInit.biosyncedClock)), VanillaTypes.ITEM, new String[]{"description.lostinfinity.jei.minigames.biosyncedclock"});
        registry.addIngredientInfo(Arrays.asList(new ItemStack(ItemInit.audioSynchronizedDisc)), VanillaTypes.ITEM, new String[]{"description.lostinfinity.jei.minigames.audiosynchronizeddisc"});
        registry.addIngredientInfo(Arrays.asList(new ItemStack(ItemInit.dimensionalPolymer)), VanillaTypes.ITEM, new String[]{"description.lostinfinity.jei.minigames.dimensionalpolymer"});
        registry.addIngredientInfo(Arrays.asList(new ItemStack(ItemInit.multiTimelineDataChip)), VanillaTypes.ITEM, new String[]{"description.lostinfinity.jei.minigames.multitimelinedatachip"});
        registry.addIngredientInfo(Arrays.asList(new ItemStack(ItemInit.astralPlaneAnalyzer)), VanillaTypes.ITEM, new String[]{"description.lostinfinity.jei.minigames.astralplaneanalyzer"});
        registry.addIngredientInfo(Arrays.asList(new ItemStack(ItemInit.spacetimeTrigger)), VanillaTypes.ITEM, new String[]{"description.lostinfinity.jei.minigames.spacetimetrigger"});
        registry.addIngredientInfo(Arrays.asList(new ItemStack(ItemInit.powerBlade)), VanillaTypes.ITEM, new String[]{"description.lostinfinity.jei.minigames.powerblade"});
        registry.addIngredientInfo(Arrays.asList(new ItemStack(ItemInit.nanofluoricAcid)), VanillaTypes.ITEM, new String[]{"description.lostinfinity.jei.minigames.nanofluoricacid"});
        registry.addIngredientInfo(Arrays.asList(new ItemStack(ItemInit.highSpeedWire)), VanillaTypes.ITEM, new String[]{"description.lostinfinity.jei.minigames.highspeedwire"});
        registry.addIngredientInfo(Arrays.asList(new ItemStack(ItemInit.rewiredIonCell)), VanillaTypes.ITEM, new String[]{"description.lostinfinity.jei.minigames.rewiredioncell"});
        registry.addIngredientInfo(Arrays.asList(new ItemStack(ItemInit.overchargedCell)), VanillaTypes.ITEM, new String[]{"description.lostinfinity.jei.minigames.overchargedcell"});
        registry.addIngredientInfo(Arrays.asList(new ItemStack(ItemInit.eternalEmberstarGenerator)), VanillaTypes.ITEM, new String[]{"description.lostinfinity.jei.minigames.eternalemberstargenerator"});
        registry.addIngredientInfo(Arrays.asList(new ItemStack(ItemInit.geocoordinatedOrb)), VanillaTypes.ITEM, new String[]{"description.lostinfinity.jei.minigames.geocoordinatedorb"});
        registry.addIngredientInfo(Arrays.asList(new ItemStack(ItemInit.geolocationOrb)), VanillaTypes.ITEM, new String[]{"description.lostinfinity.jei.minigames.geolocationorb"});
        registry.addIngredientInfo(Arrays.asList(new ItemStack(ItemInit.starcrystalCapacitor)), VanillaTypes.ITEM, new String[]{"description.lostinfinity.jei.minigames.starcrystalcapacitor"});
        registry.addIngredientInfo(Arrays.asList(new ItemStack(ItemInit.georedirectionOrb)), VanillaTypes.ITEM, new String[]{"description.lostinfinity.jei.minigames.georedirectionorb"});
        registry.addIngredientInfo(Arrays.asList(new ItemStack(ItemInit.microstoragePowerCluster)), VanillaTypes.ITEM, new String[]{"description.lostinfinity.jei.minigames.microstoragepowercluster"});
        registry.addIngredientInfo(Arrays.asList(new ItemStack(ItemInit.powerControlDisc)), VanillaTypes.ITEM, new String[]{"description.lostinfinity.jei.minigames.powercontroldisc"});
        registry.addIngredientInfo(Arrays.asList(new ItemStack(ItemInit.powerClamp)), VanillaTypes.ITEM, new String[]{"description.lostinfinity.jei.minigames.powerclamp"});
        registry.addIngredientInfo(Arrays.asList(new ItemStack(ItemInit.navigationMechanism)), VanillaTypes.ITEM, new String[]{"description.lostinfinity.jei.minigames.navigationmechanism"});
        registry.addIngredientInfo(Arrays.asList(new ItemStack(ItemInit.gasFilledBalloon)), VanillaTypes.ITEM, new String[]{"description.lostinfinity.jei.misc.gasfilledballoon"});
        registry.addIngredientInfo(Arrays.asList(new ItemStack(ItemInit.lifeSynchronizer)), VanillaTypes.ITEM, new String[]{"description.lostinfinity.jei.misc.lifesynchronizer"});
        registry.addIngredientInfo(Arrays.asList(new ItemStack(ItemInit.giantHeart)), VanillaTypes.ITEM, new String[]{"description.lostinfinity.jei.misc.giantheart"});
        registry.addIngredientInfo(Arrays.asList(new ItemStack(ItemInit.clayReinforcement), new ItemStack(ItemInit.claySupportBase), new ItemStack(ItemInit.claySupportCap)), VanillaTypes.ITEM, new String[]{"description.lostinfinity.jei.misc.claysupports"});
        registry.addIngredientInfo(Arrays.asList(new ItemStack(ItemInit.plasmaticCranium)), VanillaTypes.ITEM, new String[]{"description.lostinfinity.jei.misc.plasmaticcranium"});
        registry.addIngredientInfo(Arrays.asList(new ItemStack(ItemInit.voidAlteredSpine)), VanillaTypes.ITEM, new String[]{"description.lostinfinity.jei.misc.voidalteredspine"});
        registry.addIngredientInfo(Arrays.asList(new ItemStack(ItemInit.astralGenerator)), VanillaTypes.ITEM, new String[]{"description.lostinfinity.jei.misc.astralgenerator"});
        registry.addIngredientInfo(Arrays.asList(new ItemStack(ItemInit.astralOrgan)), VanillaTypes.ITEM, new String[]{"description.lostinfinity.jei.misc.astralorgan"});
        registry.addIngredientInfo(Arrays.asList(new ItemStack(ItemInit.reconfiguredMatter)), VanillaTypes.ITEM, new String[]{"description.lostinfinity.jei.misc.reconfiguredmatter"});
        registry.addIngredientInfo(Arrays.asList(new ItemStack(ItemInit.stickyDarksteel)), VanillaTypes.ITEM, new String[]{"description.lostinfinity.jei.misc.stickydarksteel"});
        registry.addIngredientInfo(Arrays.asList(new ItemStack(ItemInit.organicShadowMatter)), VanillaTypes.ITEM, new String[]{"description.lostinfinity.jei.misc.organicshadowmatter"});
        registry.addIngredientInfo(Arrays.asList(new ItemStack(ItemInit.velocitizedFemur)), VanillaTypes.ITEM, new String[]{"description.lostinfinity.jei.misc.velocitizedfemur"});
        registry.addIngredientInfo(Arrays.asList(new ItemStack(ItemInit.magicConch)), VanillaTypes.ITEM, new String[]{"description.lostinfinity.jei.misc.magicconch"});
        registry.addIngredientInfo(Arrays.asList(new ItemStack(ItemInit.chewedSkull)), VanillaTypes.ITEM, new String[]{"description.lostinfinity.jei.misc.chewedskull"});
        registry.addIngredientInfo(Arrays.asList(new ItemStack(ItemInit.heartOfLight)), VanillaTypes.ITEM, new String[]{"description.lostinfinity.jei.misc.heartoflight"});
        registry.addIngredientInfo(Arrays.asList(new ItemStack(ItemInit.alignedDisc)), VanillaTypes.ITEM, new String[]{"description.lostinfinity.jei.misc.aligneddisc"});
        registry.addIngredientInfo(Arrays.asList(new ItemStack(ItemInit.murkyClay)), VanillaTypes.ITEM, new String[]{"description.lostinfinity.jei.misc.murkyclay"});
        registry.addIngredientInfo(Arrays.asList(new ItemStack(ItemInit.voidsplitBone)), VanillaTypes.ITEM, new String[]{"description.lostinfinity.jei.misc.voidsplitbone"});
        registry.addIngredientInfo(Arrays.asList(new ItemStack(ItemInit.branchOfEnergy)), VanillaTypes.ITEM, new String[]{"description.lostinfinity.jei.misc.branchofenergy"});
        registry.addIngredientInfo(Arrays.asList(new ItemStack(ItemInit.electricalAccelerator)), VanillaTypes.ITEM, new String[]{"description.lostinfinity.jei.misc.electricalaccelerator"});
        registry.addIngredientInfo(Arrays.asList(new ItemStack(ItemInit.crushedBones)), VanillaTypes.ITEM, new String[]{"description.lostinfinity.jei.misc.crushedbones"});
        registry.addIngredientInfo(Arrays.asList(new ItemStack(ItemInit.toxicSporeSample)), VanillaTypes.ITEM, new String[]{"description.lostinfinity.jei.misc.toxicsporesample"});
        registry.addIngredientInfo(Arrays.asList(new ItemStack(ItemInit.darkworldDataChip)), VanillaTypes.ITEM, new String[]{"description.lostinfinity.jei.misc.darkworlddatachip"});
        registry.addIngredientInfo(Arrays.asList(new ItemStack(ItemInit.florocite)), VanillaTypes.ITEM, new String[]{"description.lostinfinity.jei.misc.florocite"});
        registry.addIngredientInfo(Arrays.asList(new ItemStack(ItemInit.heartOfDarkness)), VanillaTypes.ITEM, new String[]{"description.lostinfinity.jei.misc.heartofdarkness"});
        registry.addIngredientInfo(Arrays.asList(new ItemStack(ItemInit.mutantFungus)), VanillaTypes.ITEM, new String[]{"description.lostinfinity.jei.misc.mutantfungus"});
        registry.addIngredientInfo(Arrays.asList(new ItemStack(ItemInit.incarnationOfTheKnife)), VanillaTypes.ITEM, new String[]{"description.lostinfinity.jei.misc.knifeincarnation"});
        registry.addIngredientInfo(Arrays.asList(new ItemStack(ItemInit.incarnationOfTheSword)), VanillaTypes.ITEM, new String[]{"description.lostinfinity.jei.misc.swordincarnation"});
        registry.addIngredientInfo(Arrays.asList(new ItemStack(ItemInit.incarnationOfTheBomb)), VanillaTypes.ITEM, new String[]{"description.lostinfinity.jei.misc.bombincarnation"});
        registry.addIngredientInfo(Arrays.asList(new ItemStack(ItemInit.warpedDisc)), VanillaTypes.ITEM, new String[]{"description.lostinfinity.jei.misc.warpeddisc"});
        registry.addIngredientInfo(Arrays.asList(new ItemStack(ItemInit.clovinitePowerHub)), VanillaTypes.ITEM, new String[]{"description.lostinfinity.jei.misc.clovinitepowerhub"});
        registry.addIngredientInfo(Arrays.asList(new ItemStack(ItemInit.explosiveGooSample)), VanillaTypes.ITEM, new String[]{"description.lostinfinity.jei.misc.explosivegoosample"});
        registry.addIngredientInfo(Arrays.asList(new ItemStack(ItemInit.luminessence), new ItemStack(ItemInit.gloominessence), new ItemStack(ItemInit.luminescentCubes), new ItemStack(ItemInit.gloominessenceCubes)), VanillaTypes.ITEM, new String[]{"description.lostinfinity.jei.misc.essence"});
        registry.addIngredientInfo(Arrays.asList(new ItemStack(ItemInit.eternoCell)), VanillaTypes.ITEM, new String[]{"description.lostinfinity.jei.misc.eternocell"});
        registry.addIngredientInfo(Arrays.asList(new ItemStack(ItemInit.etherflower)), VanillaTypes.ITEM, new String[]{"description.lostinfinity.jei.unknown.etherflower"});
        registry.addIngredientInfo(Arrays.asList(new ItemStack(ItemInit.containedLifeforce)), VanillaTypes.ITEM, new String[]{"description.lostinfinity.jei.unknown.lifeforce"});
        registry.addIngredientInfo(Arrays.asList(new ItemStack(ItemInit.radionFragment)), VanillaTypes.ITEM, new String[]{"description.lostinfinity.jei.unknown.radionfragment"});
        registry.addIngredientInfo(Arrays.asList(new ItemStack(ItemInit.fossilEelBotjaw), new ItemStack(ItemInit.fossilEelTopjaw), new ItemStack(ItemInit.fossilRibbedTail), new ItemStack(ItemInit.fossilSmallRibs)), VanillaTypes.ITEM, new String[]{"description.lostinfinity.jei.unknown.fossils"});
        registry.addIngredientInfo(Arrays.asList(new ItemStack(ItemInit.scrollOfRedirection)), VanillaTypes.ITEM, new String[]{"description.lostinfinity.jei.unknown.scroll"});
        registry.addIngredientInfo(Arrays.asList(new ItemStack(ItemInit.bookOfTranslation)), VanillaTypes.ITEM, new String[]{"description.lostinfinity.jei.unknown.translationbook"});
        registry.addIngredientInfo(Arrays.asList(new ItemStack(ItemInit.anthocite)), VanillaTypes.ITEM, new String[]{"description.lostinfinity.jei.unknown.anthocite"});
        registry.addIngredientInfo(Arrays.asList(new ItemStack(ItemInit.watchfulEyeBlue), new ItemStack(ItemInit.watchfulEyePink), new ItemStack(ItemInit.watchfulEyePurple)), VanillaTypes.ITEM, new String[]{"description.lostinfinity.jei.unknown.watchfuleye"});
        registry.addIngredientInfo(Arrays.asList(new ItemStack(ItemInit.elementStone)), VanillaTypes.ITEM, new String[]{"description.lostinfinity.jei.unknown.elementstone"});
        registry.addIngredientInfo(Arrays.asList(new ItemStack(ItemInit.firefeather)), VanillaTypes.ITEM, new String[]{"description.lostinfinity.jei.unknown.firefeather"});
        registry.addIngredientInfo(Arrays.asList(new ItemStack(ItemInit.concentratedVenom)), VanillaTypes.ITEM, new String[]{"description.lostinfinity.jei.unknown.concentratedvenom"});
        registry.addIngredientInfo(Arrays.asList(new ItemStack(ItemInit.cursedEmerald)), VanillaTypes.ITEM, new String[]{"description.lostinfinity.jei.unknown.cursedemerald"});
        registry.addIngredientInfo(Arrays.asList(new ItemStack(ItemInit.droidLocationDataD), new ItemStack(ItemInit.droidLocationDataO), new ItemStack(ItemInit.droidLocationDataN), new ItemStack(ItemInit.droidLocationDataE)), VanillaTypes.ITEM, new String[]{"description.lostinfinity.jei.unknown.droidlocation"});
        registry.addIngredientInfo(Arrays.asList(new ItemStack(ItemInit.superheatedIngot)), VanillaTypes.ITEM, new String[]{"description.lostinfinity.jei.unknown.superheatedingot"});
        registry.addIngredientInfo(Arrays.asList(new ItemStack(ItemInit.starlitGlobe)), VanillaTypes.ITEM, new String[]{"description.lostinfinity.jei.unknown.starlitglobe"});
        registry.addIngredientInfo(Arrays.asList(new ItemStack(BlockInit.gearbox)), VanillaTypes.ITEM, new String[]{"description.lostinfinity.jei.machines.gearbox"});
        registry.addIngredientInfo(Arrays.asList(new ItemStack(BlockInit.compressionTable)), VanillaTypes.ITEM, new String[]{"description.lostinfinity.jei.machines.compressiontable"});
        registry.addIngredientInfo(Arrays.asList(new ItemStack(BlockInit.grinder)), VanillaTypes.ITEM, new String[]{"description.lostinfinity.jei.machines.grinder"});
        registry.addIngredientInfo(Arrays.asList(new ItemStack(BlockInit.combustionEngine)), VanillaTypes.ITEM, new String[]{"description.lostinfinity.jei.machines.engine"});
        registry.addIngredientInfo(Arrays.asList(new ItemStack(BlockInit.fusionTable)), VanillaTypes.ITEM, new String[]{"description.lostinfinity.jei.machines.fusion"});
        registry.addIngredientInfo(Arrays.asList(new ItemStack(BlockInit.cthulhuSpawner)), VanillaTypes.ITEM, new String[]{"description.lostinfinity.jei.machines.irg"});
    }
}

