package xol.lostinfinity.menu;

import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.SimpleContainerData;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import xol.lostinfinity.blockentity.LostMachineBlockEntity;
import xol.lostinfinity.registry.ModMenus;

public class LostMachineMenu extends AbstractContainerMenu {
    private static final int MACHINE_SLOTS = 9;
    private static final int INPUT_SLOT = 0;
    private static final int CATALYST_SLOT = 1;
    private static final int FUEL_SLOT = 2;
    private static final int MODULE_START_SLOT = 3;
    private static final int MODULE_END_SLOT = 7;
    private final Container container;
    private final ContainerData data;

    public LostMachineMenu(int containerId, Inventory playerInventory) {
        this(containerId, playerInventory, new SimpleContainer(MACHINE_SLOTS), new SimpleContainerData(5));
    }

    public LostMachineMenu(int containerId, Inventory playerInventory, Container container) {
        this(containerId, playerInventory, container, new SimpleContainerData(5));
    }

    public LostMachineMenu(int containerId, Inventory playerInventory, Container container, ContainerData data) {
        super(ModMenus.LOST_MACHINE_MENU.get(), containerId);
        checkContainerSize(container, MACHINE_SLOTS);
        this.container = container;
        this.data = data;
        addDataSlots(data);
        container.startOpen(playerInventory.player);

        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                addSlot(new Slot(container, column + row * 3, 62 + column * 18, 17 + row * 18));
            }
        }

        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 9; column++) {
                addSlot(new Slot(playerInventory, column + row * 9 + 9, 8 + column * 18, 84 + row * 18));
            }
        }

        for (int column = 0; column < 9; column++) {
            addSlot(new Slot(playerInventory, column, 8 + column * 18, 142));
        }
    }

    @Override
    public boolean stillValid(Player player) {
        return container.stillValid(player);
    }

    public int progress() {
        return data.get(0);
    }

    public int processTime() {
        return Math.max(1, data.get(1));
    }

    public int energy() {
        return data.get(2);
    }

    public boolean active() {
        return data.get(3) != 0;
    }

    public int puzzleState() {
        return data.get(4);
    }

    public String machineId() {
        return container instanceof LostMachineBlockEntity machine ? machine.machineId() : "lost_machine";
    }

    @Override
    public ItemStack quickMoveStack(Player player, int slotIndex) {
        ItemStack moved = ItemStack.EMPTY;
        Slot slot = slots.get(slotIndex);
        if (slot.hasItem()) {
            ItemStack stack = slot.getItem();
            moved = stack.copy();
            if (slotIndex < MACHINE_SLOTS) {
                if (!moveItemStackTo(stack, MACHINE_SLOTS, slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!movePlayerStackToMachine(stack)) {
                return ItemStack.EMPTY;
            }
            if (stack.isEmpty()) {
                slot.setByPlayer(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }
        }
        return moved;
    }

    private boolean movePlayerStackToMachine(ItemStack stack) {
        if (isFuel(stack) && moveItemStackTo(stack, FUEL_SLOT, FUEL_SLOT + 1, false)) {
            return true;
        }
        if (isModule(stack) && moveItemStackTo(stack, MODULE_START_SLOT, MODULE_END_SLOT + 1, false)) {
            return true;
        }
        if (moveItemStackTo(stack, INPUT_SLOT, INPUT_SLOT + 1, false)) {
            return true;
        }
        return moveItemStackTo(stack, CATALYST_SLOT, CATALYST_SLOT + 1, false);
    }

    private static boolean isFuel(ItemStack stack) {
        String path = itemPath(stack);
        return path.contains("fuel") || path.contains("battery") || path.contains("power_cell") || path.contains("energy_cell")
                || path.contains("capacitor") || path.contains("mechanicalpowercell") || path.contains("organicpowercell")
                || path.contains("superchargedcell") || stack.is(net.minecraft.world.item.Items.REDSTONE)
                || stack.is(net.minecraft.world.item.Items.COAL) || stack.is(net.minecraft.world.item.Items.CHARCOAL)
                || stack.is(net.minecraft.world.item.Items.COAL_BLOCK);
    }

    private static boolean isModule(ItemStack stack) {
        String path = itemPath(stack);
        return path.contains("module") || path.contains("_upgrade") || path.contains("_chip");
    }

    private static String itemPath(ItemStack stack) {
        if (stack.isEmpty()) {
            return "";
        }
        return stack.getItem().builtInRegistryHolder().key().location().getPath();
    }

    @Override
    public void removed(Player player) {
        super.removed(player);
        container.stopOpen(player);
    }
}
