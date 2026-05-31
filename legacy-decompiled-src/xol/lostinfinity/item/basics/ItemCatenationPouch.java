/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.item.ItemEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.InteractionResultHolder
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 */
package xol.lostinfinity.item.basics;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import xol.lostinfinity.dimension.murk.BiomeInfiniteMurk;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.basics.ItemBasic;

public class ItemCatenationPouch
extends ItemBasic {
    private Item item1;
    private Item item2;
    private Item item3;
    private Item result;

    public InteractionResultHolder<ItemStack> func_77659_a(Level world, Player player, InteractionHand hand) {
        ItemStack held = player.func_184586_b(hand);
        if (world.func_180494_b(player.func_180425_c()) instanceof BiomeInfiniteMurk) {
            ItemCatenationPouch pouch = (ItemCatenationPouch)held.func_77973_b();
            BlockPos itemPos = player.func_180425_c();
            boolean shards = false;
            boolean tissue = false;
            boolean sac = false;
            ItemEntity shardsEntity = null;
            ItemEntity tissueEntity = null;
            ItemEntity sacEntity = null;
            for (ItemEntity itemEntity : world.func_72872_a(ItemEntity.class, new AABB(itemPos.func_177982_a(-4, -2, -4), itemPos.func_177982_a(4, 2, 4)))) {
                Item testItem = itemEntity.func_92059_d().func_77973_b();
                BlockPos dropPos = itemEntity.func_180425_c();
                if (world.func_180495_p(dropPos).func_177230_c().equals(BlockInit.concentratedAcid)) {
                    if (testItem == pouch.getFirstIngredient() && !shards) {
                        if (itemEntity.func_92059_d().func_190916_E() >= 5) {
                            shardsEntity = itemEntity;
                            shards = true;
                        }
                    } else if (testItem == pouch.getSecondIngredient() && !tissue) {
                        if (itemEntity.func_92059_d().func_190916_E() >= 5) {
                            tissueEntity = itemEntity;
                            tissue = true;
                        }
                    } else if (testItem == pouch.getThirdIngredient() && !sac && itemEntity.func_92059_d().func_190916_E() >= 5) {
                        sacEntity = itemEntity;
                        sac = true;
                    }
                }
                if (!shards || !tissue || !sac) continue;
                if (!world.field_72995_K) {
                    ItemEntity resultItem = new ItemEntity(world, (double)itemPos.func_177958_n(), (double)(itemPos.func_177956_o() + 2), (double)itemPos.func_177952_p(), new ItemStack(pouch.getResult()));
                    resultItem.field_70159_w = 0.0;
                    resultItem.field_70181_x = 0.0;
                    resultItem.field_70179_y = 0.0;
                    world.func_72838_d((Entity)resultItem);
                    world.func_184133_a(null, itemPos.func_177984_a(), SoundInit.SPECIAL_CRAFT, SoundSource.BLOCKS, 2.0f, 1.0f);
                    shardsEntity.func_92059_d().func_190918_g(5);
                    tissueEntity.func_92059_d().func_190918_g(5);
                    sacEntity.func_92059_d().func_190918_g(5);
                }
                held.func_190918_g(1);
            }
        }
        return super.func_77659_a(world, player, hand);
    }

    public ItemCatenationPouch(String regName) {
        super(regName, TabsInit.TAB_AUXMATS);
    }

    public void setRecipe(Item item1, Item item2, Item item3, Item result) {
        this.item1 = item1;
        this.item2 = item2;
        this.item3 = item3;
        this.result = result;
    }

    public Item getFirstIngredient() {
        return this.item1;
    }

    public Item getSecondIngredient() {
        return this.item2;
    }

    public Item getThirdIngredient() {
        return this.item3;
    }

    public Item getResult() {
        return this.result;
    }
}

