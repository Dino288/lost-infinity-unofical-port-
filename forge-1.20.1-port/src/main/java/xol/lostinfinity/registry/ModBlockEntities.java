package xol.lostinfinity.registry;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import xol.lostinfinity.LostInfinity;
import xol.lostinfinity.blockentity.LostMachineBlockEntity;

public final class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, LostInfinity.MODID);

    public static final RegistryObject<BlockEntityType<LostMachineBlockEntity>> LOST_MACHINE =
            BLOCK_ENTITY_TYPES.register("lost_machine", () -> BlockEntityType.Builder.of(LostMachineBlockEntity::new,
                    ModBlocks.ALIGNMENT_DIAL_GAME.get(),
                    ModBlocks.ANCIENT_SYMBOL_INTERPRETER.get(),
                    ModBlocks.CHEMISTRY_TABLE.get(),
                    ModBlocks.CHROMA_GAME.get(),
                    ModBlocks.CIRCUIT_CALIBRATOR.get(),
                    ModBlocks.COMBUSTION_ENGINE.get(),
                    ModBlocks.COMPRESSIONTABLE.get(),
                    ModBlocks.CTHULHU_SPAWNER.get(),
                    ModBlocks.DRILL_CONSOLE.get(),
                    ModBlocks.ETERNAL_BEACON.get(),
                    ModBlocks.FUSION_TABLE.get(),
                    ModBlocks.GEARBOX.get(),
                    ModBlocks.GRINDER.get(),
                    ModBlocks.KILLER_VINE.get(),
                    ModBlocks.LIGHT_EMITTER.get(),
                    ModBlocks.MELODIC_SEQUENCER.get(),
                    ModBlocks.NAVIGATION_DEVICE.get(),
                    ModBlocks.NEBULOUS_BEACON.get(),
                    ModBlocks.NICRONIUM_INFUSER.get(),
                    ModBlocks.POLYMERIZATION_DEVICE.get(),
                    ModBlocks.POWER_COLLIDER.get(),
                    ModBlocks.RAINFALL_GENERATOR.get(),
                    ModBlocks.SAP_EVAPORATOR.get(),
                    ModBlocks.SHIPMENT_FILLER.get(),
                    ModBlocks.SHOCKWAVE_GENERATOR.get(),
                    ModBlocks.TESLA_TOWER.get(),
                    ModBlocks.VOID_VACUUM.get(),
                    ModBlocks.WELDING_CHAMBER.get()).build(null));

    private ModBlockEntities() {
    }
}
