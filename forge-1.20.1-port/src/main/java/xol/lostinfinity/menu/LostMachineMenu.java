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
            } else if (!moveItemStackTo(stack, 0, MACHINE_SLOTS, false)) {
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

    @Override
    public void removed(Player player) {
        super.removed(player);
        container.stopOpen(player);
    }
}
