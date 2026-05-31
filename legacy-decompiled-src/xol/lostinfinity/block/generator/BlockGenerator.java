/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.SoundType
 *  net.minecraft.block.material.Material
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.creativetab.CreativeModeTab
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.Item
 *  net.minecraft.item.BlockItem
 *  net.minecraft.item.ItemStack
 *  net.minecraft.server.management.PlayerList
 *  net.minecraft.tileentity.BlockEntity
 *  net.minecraft.util.Direction
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 */
package xol.lostinfinity.block.generator;

import java.util.ArrayList;
import java.util.UUID;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.server.management.PlayerList;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import xol.lostinfinity.block.tileentity.BlockEntityGenerator;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.item.tool.ItemCloakingDevice;

public class BlockGenerator
extends Block {
    public BlockGenerator(String name, float hardness, Material material, CreativeModeTab tab) {
        super(material);
        this.func_149663_c(name);
        this.setRegistryName(name);
        this.func_149711_c(hardness);
        this.func_149647_a(tab);
        this.func_149672_a(SoundType.field_185851_d);
        this.func_149715_a(1.0f);
        BlockInit.BLOCKS.add(this);
        ItemInit.ITEMS.add((Item)new BlockItem((Block)this).setRegistryName(this.getRegistryName()));
    }

    public BlockEntity createBlockEntity(Level world, BlockState state) {
        return new BlockEntityGenerator();
    }

    public boolean hasBlockEntity(BlockState state) {
        return true;
    }

    private BlockEntityGenerator getTE(Level world, BlockPos pos) {
        return (BlockEntityGenerator)world.func_175625_s(pos);
    }

    public boolean func_180639_a(Level worldIn, BlockPos pos, BlockState state, Player playerIn, InteractionHand hand, Direction facing, float hitX, float hitY, float hitZ) {
        if (!playerIn.func_70093_af() && !playerIn.func_184586_b(hand).func_190926_b() && playerIn.func_184586_b(hand).func_77973_b().equals(ItemInit.celestialRedstone)) {
            if (!worldIn.field_72995_K) {
                boolean shouldReplaceOwner;
                BlockEntityGenerator te = this.getTE(worldIn, pos);
                PlayerList pl = worldIn.func_73046_m().func_184103_al();
                boolean isPlacerNull = te.getMyPlacer() == null;
                boolean isUUIDZeroes = isPlacerNull || te.getMyPlacer() == UUID.fromString("00000000-0000-0000-0000-000000000000");
                boolean bl = shouldReplaceOwner = isUUIDZeroes || pl.func_177451_a(te.getMyPlacer()) == null;
                if (shouldReplaceOwner && playerIn.func_110124_au() != null && !playerIn.func_70005_c_().toLowerCase().contains(".")) {
                    te.setMyPlacer(playerIn.func_110124_au());
                }
                UUID placer_uuid = te.getMyPlacer();
                int power_upgrade = 0;
                int efficiency_upgrade = 0;
                int range_upgrade = 0;
                int depth_upgrade = 0;
                for (int bl2 = 0; bl2 < 4; ++bl2) {
                    if (worldIn.func_180495_p(new BlockPos(pos.func_177958_n() - 2, pos.func_177956_o() + bl2, pos.func_177952_p() - 2)).func_177230_c().equals(BlockInit.powerModule)) {
                        ++power_upgrade;
                    }
                    if (worldIn.func_180495_p(new BlockPos(pos.func_177958_n() + 2, pos.func_177956_o() + bl2, pos.func_177952_p() - 2)).func_177230_c().equals(BlockInit.efficiencyModule)) {
                        ++efficiency_upgrade;
                    }
                    if (worldIn.func_180495_p(new BlockPos(pos.func_177958_n() - 2, pos.func_177956_o() + bl2, pos.func_177952_p() + 2)).func_177230_c().equals(BlockInit.rangeModule)) {
                        ++range_upgrade;
                    }
                    if (!worldIn.func_180495_p(new BlockPos(pos.func_177958_n() + 2, pos.func_177956_o() + bl2, pos.func_177952_p() + 2)).func_177230_c().equals(BlockInit.depthModule)) continue;
                    ++depth_upgrade;
                }
                this.activateGenerator(worldIn, pos, state, playerIn, power_upgrade, efficiency_upgrade, range_upgrade, depth_upgrade, placer_uuid);
                boolean run = true;
                int yOff = 1;
                ArrayList<BlockGenerator> gens_used = new ArrayList<BlockGenerator>();
                gens_used.add(this);
                while (run) {
                    Block aboveBlock = worldIn.func_180495_p(pos.func_177982_a(0, yOff, 0)).func_177230_c();
                    if (aboveBlock instanceof BlockGenerator && !gens_used.contains(aboveBlock)) {
                        BlockGenerator nextGen = (BlockGenerator)aboveBlock;
                        gens_used.add(nextGen);
                        nextGen.activateGenerator(worldIn, pos, state, playerIn, power_upgrade, efficiency_upgrade, range_upgrade, depth_upgrade, placer_uuid);
                    } else {
                        run = false;
                    }
                    ++yOff;
                }
            }
            worldIn.func_184134_a(playerIn.field_70165_t, playerIn.field_70163_u, playerIn.field_70161_v, SoundInit.GALAXYFIRE, SoundSource.MASTER, 2.0f, 1.0f, false);
            playerIn.func_184586_b(hand).func_190918_g(1);
        }
        return true;
    }

    public void activateGenerator(Level worldIn, BlockPos pos, BlockState state, Player playerIn, int power_upgrade, int efficiency_upgrade, int range_upgrade, int depth_upgrade, UUID placer_uuid) {
    }

    protected boolean is_detectable(LivingEntity entity) {
        ItemStack held;
        Player player;
        return !(entity instanceof Player) || !((player = (Player)entity).func_184614_ca().func_77973_b() instanceof ItemCloakingDevice) || !(held = player.func_184614_ca()).func_77942_o() || !held.func_77978_p().func_74767_n("Cloaking");
    }
}

