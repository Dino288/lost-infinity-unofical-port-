/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.item.ItemEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.Direction
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 */
package xol.lostinfinity.block.activator;

import java.util.ArrayList;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import xol.lostinfinity.block.basic.BlockBasic;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.util.coordinates.GalaxyCoordinates;
import xol.lostinfinity.util.damagesource.DeathMessage;

public class BlockMetaMaterializer
extends BlockBasic {
    public BlockMetaMaterializer(String name) {
        super(name);
    }

    public boolean func_180639_a(Level worldIn, BlockPos pos, BlockState state, Player playerIn, InteractionHand hand, Direction facing, float hitX, float hitY, float hitZ) {
        if (!playerIn.func_70093_af() && !worldIn.field_72995_K) {
            MetaRecipe rec = this.getRecipe(playerIn.func_184586_b(hand));
            if (rec == null) {
                return true;
            }
            ArrayList ingots = rec.getIngots();
            ArrayList organics = rec.getOrganics();
            Item result = rec.getResult();
            if (ingots != null && organics != null && result != null) {
                ItemStack stack;
                AABB ingotBox = GalaxyCoordinates.materializerOreAABB();
                AABB organicsBox = GalaxyCoordinates.materializerOrganicsAABB();
                AABB sacrificeBox = GalaxyCoordinates.materializerSacrificeAABB();
                ArrayList<ItemEntity> IngotEntities = new ArrayList<ItemEntity>();
                ArrayList<Object> ingotsFound = new ArrayList<Object>();
                for (ItemEntity entityItem : worldIn.func_72872_a(ItemEntity.class, ingotBox)) {
                    Item testItem = entityItem.func_92059_d().func_77973_b();
                    for (Item ingot : ingots) {
                        if (!testItem.equals(ingot)) continue;
                        ingotsFound.add(testItem);
                        IngotEntities.add(entityItem);
                    }
                }
                for (Item item : ingotsFound) {
                    ingots.remove(item);
                }
                ArrayList<ItemEntity> OrganicEntities = new ArrayList<ItemEntity>();
                ArrayList<Object> arrayList = new ArrayList<Object>();
                for (ItemEntity entityItem : worldIn.func_72872_a(ItemEntity.class, organicsBox)) {
                    Item testItem = entityItem.func_92059_d().func_77973_b();
                    for (Item item : organics) {
                        if (!testItem.equals(item)) continue;
                        arrayList.add(testItem);
                        OrganicEntities.add(entityItem);
                    }
                }
                for (Item item : arrayList) {
                    organics.remove(item);
                }
                int count = 0;
                ArrayList<Object> arrayList2 = new ArrayList<Object>();
                for (Object sacrifice : worldIn.func_72872_a(LivingEntity.class, sacrificeBox)) {
                    ++count;
                    arrayList2.add(sacrifice);
                    if (!(sacrifice instanceof Player)) continue;
                    count = 3;
                }
                int minNum = 99;
                for (ItemEntity entityItem : IngotEntities) {
                    stack = entityItem.func_92059_d();
                    if (stack.func_190916_E() >= minNum) continue;
                    minNum = stack.func_190916_E();
                }
                for (ItemEntity entityItem : OrganicEntities) {
                    stack = entityItem.func_92059_d();
                    if (stack.func_190916_E() >= minNum) continue;
                    minNum = stack.func_190916_E();
                }
                if (ingots.isEmpty() && organics.isEmpty() && count >= 3) {
                    for (ItemEntity entityItem : IngotEntities) {
                        entityItem.func_92059_d().func_190918_g(minNum);
                    }
                    for (ItemEntity entityItem : OrganicEntities) {
                        entityItem.func_92059_d().func_190918_g(minNum);
                    }
                    for (LivingEntity entityLivingBase : arrayList2) {
                        entityLivingBase.func_70606_j(0.0f);
                        if (!(entityLivingBase instanceof Player)) continue;
                        DeathMessage.broadcastDeathMessage(entityLivingBase.func_184102_h(), (Object)((Object)TextFmt.Red) + entityLivingBase.func_70005_c_() + " was sacrificed to the Meta Materializer.");
                    }
                    for (int i = 0; i < 3; ++i) {
                        ItemEntity entityItem = new ItemEntity(worldIn, (double)pos.func_177958_n(), (double)pos.func_177956_o(), (double)pos.func_177952_p(), new ItemStack(result, minNum));
                        entityItem.field_70159_w = 0.0;
                        entityItem.field_70181_x = 0.0;
                        entityItem.field_70179_y = 0.0;
                        worldIn.func_72838_d((Entity)entityItem);
                        worldIn.func_184133_a(null, pos, SoundInit.MACHINE_CRAFT, SoundSource.MASTER, 1.0f, 1.0f);
                    }
                }
            }
        }
        return true;
    }

    private MetaRecipe getRecipe(ItemStack heldItem) {
        if (heldItem.func_77973_b().equals(ItemInit.clovinitePowerBank)) {
            return new MetaRecipe(ItemInit.velloriumIngot, ItemInit.kylaxiumIngot, ItemInit.xeroviumIngot, ItemInit.organicPlate, ItemInit.corruptedRoot, ItemInit.giantTentacle, ItemInit.kyvoriumIngot);
        }
        if (heldItem.func_77973_b().equals(ItemInit.adhesiveFibre)) {
            return new MetaRecipe(ItemInit.olysiumIngot, ItemInit.detheriumIngot, ItemInit.phytrosiumIngot, ItemInit.gloomBulb, ItemInit.pickle, ItemInit.anthocite, ItemInit.biosynthiumIngot);
        }
        if (heldItem.func_77973_b().equals(ItemInit.externalCloviniteBattery)) {
            return new MetaRecipe(ItemInit.noxeriumIngot, ItemInit.incadiumIngot, ItemInit.emberiumIngot, ItemInit.ghostlyHusk, ItemInit.flexibleHusk, ItemInit.corruptedRoot, ItemInit.maliciumIngot);
        }
        if (heldItem.func_77973_b().equals(ItemInit.ionCell)) {
            return new MetaRecipe(ItemInit.olysiumIngot, ItemInit.xeroviumIngot, ItemInit.detheriumIngot, ItemInit.ghostlyHusk, ItemInit.photochromicHusk, ItemInit.luminescentStingers, ItemInit.etheriumIngot);
        }
        if (heldItem.func_77973_b().equals(ItemInit.potentPolarcronite)) {
            return new MetaRecipe(ItemInit.phytrosiumIngot, ItemInit.xeroviumIngot, ItemInit.hextoriumIngot, ItemInit.volatileBlood, ItemInit.glowingGlobes, ItemInit.glowingOrgan, ItemInit.polariumIngot);
        }
        return null;
    }

    public class MetaRecipe {
        private ArrayList<Item> ingots = new ArrayList();
        private ArrayList<Item> organics = null;
        private Item result = null;

        private MetaRecipe(Item ingot1, Item ingot2, Item ingot3, Item organic1, Item organic2, Item organic3, Item result) {
            this.ingots.add(ingot1);
            this.ingots.add(ingot2);
            this.ingots.add(ingot3);
            this.organics = new ArrayList();
            this.organics.add(organic1);
            this.organics.add(organic2);
            this.organics.add(organic3);
            this.result = result;
        }

        private ArrayList<Item> getIngots() {
            return this.ingots;
        }

        private ArrayList<Item> getOrganics() {
            return this.organics;
        }

        private Item getResult() {
            return this.result;
        }
    }
}

