/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.client.gui.inventory.GuiContainer
 *  net.minecraft.entity.player.Player
 *  net.minecraft.inventory.Container
 *  net.minecraft.inventory.IInventory
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.common.network.IGuiHandler
 */
package xol.lostinfinity.gui;

import java.util.Arrays;
import java.util.Optional;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.common.network.IGuiHandler;
import xol.lostinfinity.block.basic.BlockBasicGui;
import xol.lostinfinity.block.tileentity.BlockEntityChemistryTable;
import xol.lostinfinity.block.tileentity.BlockEntityCombustionEngine;
import xol.lostinfinity.block.tileentity.BlockEntityCthulhuSpawner;
import xol.lostinfinity.block.tileentity.BlockEntityFusionTable;
import xol.lostinfinity.block.tileentity.BlockEntityGearbox;
import xol.lostinfinity.block.tileentity.BlockEntityGrinder;
import xol.lostinfinity.block.tileentity.BlockEntityNebulousBeacon;
import xol.lostinfinity.block.tileentity.BlockEntityNicroniumInfuser;
import xol.lostinfinity.block.tileentity.BlockEntityRainfallGenerator;
import xol.lostinfinity.block.tileentity.BlockEntitySapEvaporator;
import xol.lostinfinity.block.tileentity.BlockEntityShipmentFiller;
import xol.lostinfinity.block.tileentity.BlockEntityWeldingChamber;
import xol.lostinfinity.gui.containers.ContainerAugmentor;
import xol.lostinfinity.gui.containers.ContainerChemistryTable;
import xol.lostinfinity.gui.containers.ContainerCombustionEngine;
import xol.lostinfinity.gui.containers.ContainerCompressionTable;
import xol.lostinfinity.gui.containers.ContainerCthulhuSpawner;
import xol.lostinfinity.gui.containers.ContainerDeconstructor;
import xol.lostinfinity.gui.containers.ContainerFabricationStation;
import xol.lostinfinity.gui.containers.ContainerFossilCombiner;
import xol.lostinfinity.gui.containers.ContainerFusionTable;
import xol.lostinfinity.gui.containers.ContainerGearbox;
import xol.lostinfinity.gui.containers.ContainerGrinder;
import xol.lostinfinity.gui.containers.ContainerItemCharger;
import xol.lostinfinity.gui.containers.ContainerModulator;
import xol.lostinfinity.gui.containers.ContainerModuleCreator;
import xol.lostinfinity.gui.containers.ContainerNebulousBeacon;
import xol.lostinfinity.gui.containers.ContainerNicroniumInfuser;
import xol.lostinfinity.gui.containers.ContainerPickChargingTable;
import xol.lostinfinity.gui.containers.ContainerPortableBeacon;
import xol.lostinfinity.gui.containers.ContainerRainfallGenerator;
import xol.lostinfinity.gui.containers.ContainerSapEvaporator;
import xol.lostinfinity.gui.containers.ContainerShipmentFiller;
import xol.lostinfinity.gui.containers.ContainerSupplyDeposit;
import xol.lostinfinity.gui.containers.ContainerSupplyStore;
import xol.lostinfinity.gui.containers.ContainerWeldingChamber;
import xol.lostinfinity.gui.guis.GuiAugmentor;
import xol.lostinfinity.gui.guis.GuiChemistryTable;
import xol.lostinfinity.gui.guis.GuiCombustionEngine;
import xol.lostinfinity.gui.guis.GuiCompressionTable;
import xol.lostinfinity.gui.guis.GuiCthulhuSpawner;
import xol.lostinfinity.gui.guis.GuiDeconstructor;
import xol.lostinfinity.gui.guis.GuiFabricationStation;
import xol.lostinfinity.gui.guis.GuiFossilCombiner;
import xol.lostinfinity.gui.guis.GuiFusionTable;
import xol.lostinfinity.gui.guis.GuiGearbox;
import xol.lostinfinity.gui.guis.GuiGrinder;
import xol.lostinfinity.gui.guis.GuiItemCharger;
import xol.lostinfinity.gui.guis.GuiModulator;
import xol.lostinfinity.gui.guis.GuiModuleCreator;
import xol.lostinfinity.gui.guis.GuiNebulousBeacon;
import xol.lostinfinity.gui.guis.GuiNicroniumInfuser;
import xol.lostinfinity.gui.guis.GuiPickChargingTable;
import xol.lostinfinity.gui.guis.GuiPortableBeacon;
import xol.lostinfinity.gui.guis.GuiRainfallGenerator;
import xol.lostinfinity.gui.guis.GuiSapEvaporator;
import xol.lostinfinity.gui.guis.GuiShipmentFiller;
import xol.lostinfinity.gui.guis.GuiSupplyDeposit;
import xol.lostinfinity.gui.guis.GuiSupplyStore;
import xol.lostinfinity.gui.guis.GuiWeldingChamber;

public class GuiHandler
implements IGuiHandler {
    private static final GuiHandler guiHandler = new GuiHandler();

    public static GuiHandler getInstance() {
        return guiHandler;
    }

    private Optional<RegisteredGuis> getGuiFor(int id) {
        return Arrays.stream(RegisteredGuis.values()).filter(it -> ((RegisteredGuis)it).id == id).findFirst();
    }

    public Object getServerGuiElement(int ID, Player player, Level world, int x, int y, int z) {
        Optional<RegisteredGuis> gui = this.getGuiFor(ID);
        Container result = null;
        if (gui.isPresent()) {
            RegisteredGuis g = gui.get();
            if (g.requiresBlock) {
                BlockPos xyz = new BlockPos(x, y, z);
                BlockState state = world.func_180495_p(xyz);
                if (state.func_177230_c() instanceof BlockBasicGui) {
                    switch (g) {
                        case MODULATOR: {
                            result = new ContainerModulator(player.field_71071_by, world, xyz, state.func_177230_c());
                            break;
                        }
                        case PICKAXE_CHARGETABLE: {
                            result = new ContainerPickChargingTable(player.field_71071_by, world, xyz, state.func_177230_c());
                            break;
                        }
                        case FABRICATION_STATION: {
                            result = new ContainerFabricationStation(player.field_71071_by, world, xyz, state.func_177230_c());
                            break;
                        }
                        case COMPRESSION_TABLE: {
                            result = new ContainerCompressionTable(player.field_71071_by, world, xyz, state.func_177230_c(), (IInventory)world.func_175625_s(xyz));
                            break;
                        }
                        case AUGMENTOR: {
                            result = new ContainerAugmentor((IInventory)player.field_71071_by);
                            break;
                        }
                        case SAP_EVAPORATOR: {
                            result = new ContainerSapEvaporator(player.field_71071_by, (BlockEntitySapEvaporator)world.func_175625_s(new BlockPos(x, y, z)));
                            break;
                        }
                        case NICRONIUM_INFUSER: {
                            result = new ContainerNicroniumInfuser(player.field_71071_by, (BlockEntityNicroniumInfuser)world.func_175625_s(new BlockPos(x, y, z)));
                            break;
                        }
                        case MODULE_CREATOR: {
                            result = new ContainerModuleCreator(player.field_71071_by, world, xyz, state.func_177230_c());
                            break;
                        }
                        case RAINFALL_GENERATOR: {
                            result = new ContainerRainfallGenerator(player.field_71071_by, (BlockEntityRainfallGenerator)world.func_175625_s(new BlockPos(x, y, z)));
                            break;
                        }
                        case WELDING_CHAMBER: {
                            result = new ContainerWeldingChamber(player.field_71071_by, (BlockEntityWeldingChamber)world.func_175625_s(new BlockPos(x, y, z)));
                            break;
                        }
                        case FUSION_TABLE: {
                            result = new ContainerFusionTable(player.field_71071_by, (BlockEntityFusionTable)world.func_175625_s(new BlockPos(x, y, z)));
                            break;
                        }
                        case FOSSIL_COMBINER: {
                            result = new ContainerFossilCombiner(player.field_71071_by, world, xyz, state.func_177230_c());
                            break;
                        }
                        case NEBULOUS_BEACON: {
                            result = new ContainerNebulousBeacon(player.field_71071_by, (BlockEntityNebulousBeacon)world.func_175625_s(new BlockPos(x, y, z)));
                            break;
                        }
                        case CHEMISTRY_TABLE: {
                            result = new ContainerChemistryTable(player.field_71071_by, (BlockEntityChemistryTable)world.func_175625_s(new BlockPos(x, y, z)));
                            break;
                        }
                        case SHIPMENT_FILLER: {
                            result = new ContainerShipmentFiller(player.field_71071_by, (BlockEntityShipmentFiller)world.func_175625_s(new BlockPos(x, y, z)));
                            break;
                        }
                        case DECONSTRUCTOR: {
                            result = new ContainerDeconstructor(player.field_71071_by);
                            break;
                        }
                        case GEARBOX: {
                            result = new ContainerGearbox(player.field_71071_by, (BlockEntityGearbox)world.func_175625_s(new BlockPos(x, y, z)));
                            break;
                        }
                        case GRINDER: {
                            result = new ContainerGrinder(player.field_71071_by, (BlockEntityGrinder)world.func_175625_s(new BlockPos(x, y, z)));
                            break;
                        }
                        case COMBUSTION_ENGINE: {
                            result = new ContainerCombustionEngine(player.field_71071_by, (BlockEntityCombustionEngine)world.func_175625_s(new BlockPos(x, y, z)));
                        }
                    }
                } else {
                    switch (g) {
                        case CTHULHU_SPAWNER: {
                            result = new ContainerCthulhuSpawner(player.field_71071_by, (BlockEntityCthulhuSpawner)world.func_175625_s(new BlockPos(x, y, z)));
                        }
                    }
                }
            } else {
                switch (g) {
                    case ITEM_CHARGER: {
                        result = new ContainerItemCharger(player.field_71071_by, world, player.field_71071_by.func_70448_g());
                        break;
                    }
                    case PORTABLE_BEACON: {
                        result = new ContainerPortableBeacon(player.field_71071_by, world, player.field_71071_by.func_70448_g());
                        break;
                    }
                    case SUPPLY_STORE: {
                        result = new ContainerSupplyStore(player.field_71071_by);
                        break;
                    }
                    case SUPPLY_DEPOSIT: {
                        result = new ContainerSupplyDeposit(player.field_71071_by);
                    }
                }
            }
        }
        return result;
    }

    public Object getClientGuiElement(int ID, Player player, Level world, int x, int y, int z) {
        Optional<RegisteredGuis> gui = this.getGuiFor(ID);
        GuiContainer result = null;
        if (gui.isPresent()) {
            RegisteredGuis g = gui.get();
            if (g.requiresBlock) {
                BlockPos xyz = new BlockPos(x, y, z);
                BlockState state = world.func_180495_p(xyz);
                if (state.func_177230_c() instanceof BlockBasicGui) {
                    switch (g) {
                        case MODULATOR: {
                            result = new GuiModulator(player.field_71071_by, world, xyz, state.func_177230_c());
                            break;
                        }
                        case PICKAXE_CHARGETABLE: {
                            result = new GuiPickChargingTable(player.field_71071_by, world, xyz, state.func_177230_c());
                            break;
                        }
                        case FABRICATION_STATION: {
                            result = new GuiFabricationStation(player.field_71071_by, world, xyz, state.func_177230_c());
                            break;
                        }
                        case COMPRESSION_TABLE: {
                            result = new GuiCompressionTable(player.field_71071_by, world, xyz, state.func_177230_c(), (IInventory)world.func_175625_s(xyz));
                            break;
                        }
                        case AUGMENTOR: {
                            result = new GuiAugmentor((IInventory)player.field_71071_by);
                            break;
                        }
                        case SAP_EVAPORATOR: {
                            result = new GuiSapEvaporator(player.field_71071_by, (BlockEntitySapEvaporator)world.func_175625_s(new BlockPos(x, y, z)));
                            break;
                        }
                        case NICRONIUM_INFUSER: {
                            result = new GuiNicroniumInfuser(player.field_71071_by, (BlockEntityNicroniumInfuser)world.func_175625_s(new BlockPos(x, y, z)));
                            break;
                        }
                        case MODULE_CREATOR: {
                            result = new GuiModuleCreator(player.field_71071_by, world, xyz, state.func_177230_c());
                            break;
                        }
                        case RAINFALL_GENERATOR: {
                            result = new GuiRainfallGenerator(player.field_71071_by, (BlockEntityRainfallGenerator)world.func_175625_s(new BlockPos(x, y, z)));
                            break;
                        }
                        case WELDING_CHAMBER: {
                            result = new GuiWeldingChamber(player.field_71071_by, (BlockEntityWeldingChamber)world.func_175625_s(new BlockPos(x, y, z)));
                            break;
                        }
                        case FUSION_TABLE: {
                            result = new GuiFusionTable(player.field_71071_by, (BlockEntityFusionTable)world.func_175625_s(new BlockPos(x, y, z)));
                            break;
                        }
                        case FOSSIL_COMBINER: {
                            result = new GuiFossilCombiner(player.field_71071_by, world, xyz, state.func_177230_c());
                            break;
                        }
                        case NEBULOUS_BEACON: {
                            result = new GuiNebulousBeacon(player.field_71071_by, (BlockEntityNebulousBeacon)world.func_175625_s(new BlockPos(x, y, z)));
                            break;
                        }
                        case CHEMISTRY_TABLE: {
                            result = new GuiChemistryTable(player.field_71071_by, (BlockEntityChemistryTable)world.func_175625_s(new BlockPos(x, y, z)));
                            break;
                        }
                        case SHIPMENT_FILLER: {
                            result = new GuiShipmentFiller(player.field_71071_by, (BlockEntityShipmentFiller)world.func_175625_s(new BlockPos(x, y, z)));
                            break;
                        }
                        case DECONSTRUCTOR: {
                            result = new GuiDeconstructor(player.field_71071_by);
                            break;
                        }
                        case CTHULHU_SPAWNER: {
                            result = new GuiCthulhuSpawner(player.field_71071_by, (BlockEntityCthulhuSpawner)world.func_175625_s(new BlockPos(x, y, z)));
                            break;
                        }
                        case GEARBOX: {
                            result = new GuiGearbox(player.field_71071_by, (BlockEntityGearbox)world.func_175625_s(new BlockPos(x, y, z)));
                            break;
                        }
                        case GRINDER: {
                            result = new GuiGrinder(player.field_71071_by, (BlockEntityGrinder)world.func_175625_s(new BlockPos(x, y, z)));
                            break;
                        }
                        case COMBUSTION_ENGINE: {
                            result = new GuiCombustionEngine(player.field_71071_by, (BlockEntityCombustionEngine)world.func_175625_s(new BlockPos(x, y, z)));
                        }
                    }
                } else {
                    switch (g) {
                        case CTHULHU_SPAWNER: {
                            result = new GuiCthulhuSpawner(player.field_71071_by, (BlockEntityCthulhuSpawner)world.func_175625_s(new BlockPos(x, y, z)));
                        }
                    }
                }
            } else {
                switch (g) {
                    case ITEM_CHARGER: {
                        result = new GuiItemCharger(player.field_71071_by, world);
                        break;
                    }
                    case PORTABLE_BEACON: {
                        result = new GuiPortableBeacon(player.field_71071_by, world);
                        break;
                    }
                    case SUPPLY_STORE: {
                        result = new GuiSupplyStore(player.field_71071_by);
                        break;
                    }
                    case SUPPLY_DEPOSIT: {
                        result = new GuiSupplyDeposit(player.field_71071_by);
                    }
                }
            }
        }
        return result;
    }

    public static enum RegisteredGuis {
        MODULATOR(69, true),
        PICKAXE_CHARGETABLE(70, true),
        FABRICATION_STATION(71, true),
        COMPRESSION_TABLE(72, true),
        ITEM_CHARGER(73, false),
        PORTABLE_BEACON(74, false),
        AUGMENTOR(75, true),
        ESSENCE_CHAMBER(76, false),
        SAP_EVAPORATOR(77, true),
        NICRONIUM_INFUSER(78, true),
        MODULE_CREATOR(79, true),
        RAINFALL_GENERATOR(80, true),
        WELDING_CHAMBER(81, true),
        FUSION_TABLE(82, true),
        FOSSIL_COMBINER(83, true),
        NEBULOUS_BEACON(84, true),
        CHEMISTRY_TABLE(85, true),
        SHIPMENT_FILLER(86, true),
        SUPPLY_STORE(87, false),
        SUPPLY_DEPOSIT(88, false),
        DECONSTRUCTOR(89, true),
        CTHULHU_SPAWNER(90, true),
        COMBUSTION_ENGINE(91, true),
        GRINDER(92, true),
        GEARBOX(93, true);

        private final int id;
        final boolean requiresBlock;

        public int getId() {
            return this.id;
        }

        private RegisteredGuis(int id, boolean requiresBlock) {
            this.id = id;
            this.requiresBlock = requiresBlock;
        }
    }
}

