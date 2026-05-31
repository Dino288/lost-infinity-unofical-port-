/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.player.Player
 *  net.minecraft.entity.player.Inventory
 *  net.minecraft.inventory.ClickType
 *  net.minecraft.inventory.Container
 *  net.minecraft.inventory.IInventory
 *  net.minecraft.inventory.InventoryBasic
 *  net.minecraft.inventory.Slot
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 */
package xol.lostinfinity.gui.containers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.inventory.ClickType;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.inventory.Slot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import xol.lostinfinity.init.ItemInit;

public class ContainerDeconstructor
extends Container {
    private static final int PLAYER_INVENTORY_ROW_COUNT = 3;
    private static final int PLAYER_INVENTORY_COLUMN_COUNT = 9;
    private final Inventory invPlayer;
    private final Slot inputSlot;
    private final Slot outputSlot0;
    private final Slot outputSlot1;
    private final Slot outputSlot2;
    private final Slot outputSlot3;
    private InventoryBasic inventory;
    private HashMap<Item, DeconstructorResult> deconstructorResults = new HashMap();

    public ContainerDeconstructor(Inventory invPlayer) {
        this.inventory = new InventoryBasic("Deconstructor", false, 5);
        this.invPlayer = invPlayer;
        this.inputSlot = new Slot((IInventory)this.inventory, 0, 80, 35);
        this.outputSlot0 = new Slot((IInventory)this.inventory, 1, 152, 7);
        this.outputSlot1 = new Slot((IInventory)this.inventory, 2, 152, 26);
        this.outputSlot2 = new Slot((IInventory)this.inventory, 3, 152, 45);
        this.outputSlot3 = new Slot((IInventory)this.inventory, 4, 152, 64);
        this.func_75146_a(this.inputSlot);
        this.func_75146_a(this.outputSlot0);
        this.func_75146_a(this.outputSlot1);
        this.func_75146_a(this.outputSlot2);
        this.func_75146_a(this.outputSlot3);
        this.initRecipes();
        for (int playerSlotIndexY = 0; playerSlotIndexY < 3; ++playerSlotIndexY) {
            for (int playerSlotIndexX = 0; playerSlotIndexX < 9; ++playerSlotIndexX) {
                this.func_75146_a(new Slot((IInventory)this.invPlayer, playerSlotIndexX + playerSlotIndexY * 9 + 9, 8 + playerSlotIndexX * 18, 84 + playerSlotIndexY * 18));
            }
        }
        for (int hotbarSlotIndex = 0; hotbarSlotIndex < 9; ++hotbarSlotIndex) {
            this.func_75146_a(new Slot((IInventory)this.invPlayer, hotbarSlotIndex, 8 + hotbarSlotIndex * 18, 142));
        }
    }

    public ItemStack func_184996_a(int slotId, int dragType, ClickType clickTypeIn, Player player) {
        ItemStack heldStack = player.field_71071_by.func_70445_o();
        ItemStack inputStack = this.inputSlot.func_75211_c();
        ItemStack outputStack0 = this.outputSlot0.func_75211_c();
        ItemStack outputStack1 = this.outputSlot1.func_75211_c();
        ItemStack outputStack2 = this.outputSlot2.func_75211_c();
        ItemStack outputStack3 = this.outputSlot3.func_75211_c();
        if (slotId == 0) {
            if (heldStack.func_190926_b()) {
                this.outputSlot0.func_75215_d(ItemStack.field_190927_a);
                this.outputSlot1.func_75215_d(ItemStack.field_190927_a);
                this.outputSlot2.func_75215_d(ItemStack.field_190927_a);
                this.outputSlot3.func_75215_d(ItemStack.field_190927_a);
                return super.func_184996_a(slotId, dragType, clickTypeIn, player);
            }
            if (!heldStack.func_190926_b() && inputStack.func_190926_b() && outputStack0.func_190926_b() && outputStack1.func_190926_b() && outputStack2.func_190926_b() && outputStack3.func_190926_b()) {
                if (!this.deconstructorResults.containsKey(heldStack.func_77973_b())) {
                    return ItemStack.field_190927_a;
                }
                DeconstructorResult result = this.deconstructorResults.get(heldStack.func_77973_b());
                for (int i = 0; i < result.getResults().size(); ++i) {
                    if (i == 0) {
                        this.outputSlot0.func_75215_d(new ItemStack(result.getResults().get(i)));
                        continue;
                    }
                    if (i == 1) {
                        this.outputSlot1.func_75215_d(new ItemStack(result.getResults().get(i)));
                        continue;
                    }
                    if (i == 2) {
                        this.outputSlot2.func_75215_d(new ItemStack(result.getResults().get(i)));
                        continue;
                    }
                    if (i != 3) continue;
                    this.outputSlot3.func_75215_d(new ItemStack(result.getResults().get(i)));
                }
                return super.func_184996_a(slotId, dragType, clickTypeIn, player);
            }
            return ItemStack.field_190927_a;
        }
        if (slotId > 0 && slotId <= 4) {
            if (heldStack.func_190926_b()) {
                this.inputSlot.func_75215_d(ItemStack.field_190927_a);
                return super.func_184996_a(slotId, dragType, clickTypeIn, player);
            }
            return ItemStack.field_190927_a;
        }
        return super.func_184996_a(slotId, dragType, clickTypeIn, player);
    }

    public ItemStack func_82846_b(Player playerIn, int index) {
        return ItemStack.field_190927_a;
    }

    private void initRecipes() {
        this.deconstructorResults.put(ItemInit.drinkOfDuality, new DeconstructorResult(ItemInit.dualityStone));
        this.deconstructorResults.put(ItemInit.bladesOfDuality, new DeconstructorResult(ItemInit.dualityStone));
        this.deconstructorResults.put(ItemInit.theSkyverge, new DeconstructorResult(ItemInit.aspirationStone));
        this.deconstructorResults.put(ItemInit.mirrorShield, new DeconstructorResult(ItemInit.misdirectionStone));
        this.deconstructorResults.put(ItemInit.lifeVessel, new DeconstructorResult(ItemInit.misdirectionStone));
        this.deconstructorResults.put(ItemInit.axiomCelestarium, new DeconstructorResult(ItemInit.vengeanceStone));
        this.deconstructorResults.put(ItemInit.bladeOfTheDead, new DeconstructorResult(ItemInit.dreadStone));
        this.deconstructorResults.put(ItemInit.portableBeacon, new DeconstructorResult(ItemInit.impositionStone));
        this.deconstructorResults.put(ItemInit.ironheartElixir, new DeconstructorResult(ItemInit.impositionStone));
        this.deconstructorResults.put(ItemInit.headCollector, new DeconstructorResult(ItemInit.retrospectionStone));
        this.deconstructorResults.put(ItemInit.plasmaMaterializer, new DeconstructorResult(ItemInit.anxietyStone));
        this.deconstructorResults.put(ItemInit.cometShower, new DeconstructorResult(ItemInit.anxietyStone));
        this.deconstructorResults.put(ItemInit.relicOfTheMirage, new DeconstructorResult(ItemInit.perceptionStone));
        this.deconstructorResults.put(ItemInit.rayOfSelection, new DeconstructorResult(ItemInit.perceptionStone));
        this.deconstructorResults.put(ItemInit.primeElementiumBow, new DeconstructorResult(ItemInit.perceptionStone));
        this.deconstructorResults.put(ItemInit.superShocker, new DeconstructorResult(ItemInit.gemAnticipation, ItemInit.anxietyStone));
        this.deconstructorResults.put(ItemInit.theStarSoldier, new DeconstructorResult(ItemInit.gemAnticipation, ItemInit.anxietyStone));
        this.deconstructorResults.put(ItemInit.mirrorOfConsumption, new DeconstructorResult(ItemInit.gemResolve));
        this.deconstructorResults.put(ItemInit.flaskOfTheCorrupted, new DeconstructorResult(ItemInit.gemResolve));
        this.deconstructorResults.put(ItemInit.arcOfTheForbidden, new DeconstructorResult(ItemInit.gemResolve, ItemInit.vengeanceStone, ItemInit.dualityStone, ItemInit.misdirectionStone));
        this.deconstructorResults.put(ItemInit.riftMaker, new DeconstructorResult(ItemInit.gemCruelty));
        this.deconstructorResults.put(ItemInit.rampageInjection, new DeconstructorResult(ItemInit.ambitionStone));
        this.deconstructorResults.put(ItemInit.gigacron, new DeconstructorResult(ItemInit.ambitionStone));
        this.deconstructorResults.put(ItemInit.furyOfTheFeared, new DeconstructorResult(ItemInit.ambitionStone));
        this.deconstructorResults.put(ItemInit.lifeReconfigurator, new DeconstructorResult(ItemInit.ingenuityStone));
        this.deconstructorResults.put(ItemInit.hexbreaker, new DeconstructorResult(ItemInit.ingenuityStone));
        this.deconstructorResults.put(ItemInit.fluxLantern, new DeconstructorResult(ItemInit.ingenuityStone));
        this.deconstructorResults.put(ItemInit.droidConstructor, new DeconstructorResult(ItemInit.corruptionStone));
        this.deconstructorResults.put(ItemInit.auraOfAllegiance, new DeconstructorResult(ItemInit.ambitionStone, ItemInit.gemResolve, ItemInit.dreadStone, ItemInit.ingenuityStone));
        this.deconstructorResults.put(ItemInit.duskOfEternity, new DeconstructorResult(ItemInit.ingenuityCube));
        this.deconstructorResults.put(ItemInit.dualityStone, new DeconstructorResult(ItemInit.dualityCube));
        this.deconstructorResults.put(ItemInit.aspirationStone, new DeconstructorResult(ItemInit.aspirationCube));
        this.deconstructorResults.put(ItemInit.misdirectionStone, new DeconstructorResult(ItemInit.misdirectionCube));
        this.deconstructorResults.put(ItemInit.vengeanceStone, new DeconstructorResult(ItemInit.vengeanceCube));
        this.deconstructorResults.put(ItemInit.dreadStone, new DeconstructorResult(ItemInit.dreadCube));
        this.deconstructorResults.put(ItemInit.impositionStone, new DeconstructorResult(ItemInit.impositionCube));
        this.deconstructorResults.put(ItemInit.retrospectionStone, new DeconstructorResult(ItemInit.retrospectionCube));
        this.deconstructorResults.put(ItemInit.anxietyStone, new DeconstructorResult(ItemInit.anxietyCube));
        this.deconstructorResults.put(ItemInit.perceptionStone, new DeconstructorResult(ItemInit.perceptionCube));
        this.deconstructorResults.put(ItemInit.gemAnticipation, new DeconstructorResult(ItemInit.anticipationCube));
        this.deconstructorResults.put(ItemInit.gemResolve, new DeconstructorResult(ItemInit.resolveCube));
        this.deconstructorResults.put(ItemInit.gemCruelty, new DeconstructorResult(ItemInit.crueltyCube));
        this.deconstructorResults.put(ItemInit.ambitionStone, new DeconstructorResult(ItemInit.ambitionCube));
        this.deconstructorResults.put(ItemInit.ingenuityStone, new DeconstructorResult(ItemInit.ingenuityCube));
        this.deconstructorResults.put(ItemInit.corruptionStone, new DeconstructorResult(ItemInit.corruptionCube));
    }

    public boolean func_75145_c(Player playerIn) {
        return true;
    }

    public void func_75134_a(Player playerIn) {
        if (this.inputSlot.func_75216_d()) {
            this.outputSlot0.func_75215_d(ItemStack.field_190927_a);
            this.outputSlot1.func_75215_d(ItemStack.field_190927_a);
            this.outputSlot2.func_75215_d(ItemStack.field_190927_a);
            this.outputSlot3.func_75215_d(ItemStack.field_190927_a);
        }
        this.func_193327_a(playerIn, playerIn.field_70170_p, (IInventory)this.inventory);
    }

    private class DeconstructorResult {
        private final List<Item> results = new ArrayList<Item>();

        public DeconstructorResult(Item ... results) {
            for (Item result : results) {
                this.results.add(result);
            }
        }

        public List<Item> getResults() {
            return this.results;
        }
    }
}

