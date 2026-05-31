/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.SoundType
 *  net.minecraft.block.material.Material
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.item.Item
 *  net.minecraft.item.BlockItem
 *  net.minecraft.util.Direction
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.EnumParticleTypes
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraft.world.World
 *  net.minecraft.world.ServerLevel
 */
package xol.lostinfinity.block.activator;

import java.util.Random;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import net.minecraft.server.level.ServerLevel;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.mob.entity.misc.EntityMemPuzzleMerchant;

public class BlockChargeCore
extends Block {
    private boolean hard_mode = false;

    public BlockChargeCore(String name, boolean hard) {
        super(Material.field_151573_f);
        this.func_149663_c(name);
        this.setRegistryName(name);
        this.func_149711_c(3.0f);
        this.func_149647_a(TabsInit.TAB_BLOCKS);
        this.func_149672_a(SoundType.field_185851_d);
        this.func_149715_a(1.0f);
        this.hard_mode = hard;
        BlockInit.BLOCKS.add(this);
        ItemInit.ITEMS.add((Item)new BlockItem((Block)this).setRegistryName(this.getRegistryName()));
    }

    private boolean validInput(Item item) {
        if (this.hard_mode) {
            return item.equals(ItemInit.unpoweredEmberstar);
        }
        return item.equals(ItemInit.unpoweredStarcrystal);
    }

    public boolean func_180639_a(Level worldIn, BlockPos pos, BlockState state, Player playerIn, InteractionHand hand, Direction facing, float hitX, float hitY, float hitZ) {
        if (!playerIn.func_70093_af() && !worldIn.field_72995_K && this.validInput(playerIn.func_184586_b(hand).func_77973_b())) {
            Random rand = worldIn.field_73012_v;
            AABB checkBox = new AABB(pos.func_177982_a(-10, -10, -10), pos.func_177982_a(10, 10, 10));
            for (EntityMemPuzzleMerchant merch : worldIn.func_72872_a(EntityMemPuzzleMerchant.class, checkBox)) {
                ((ServerLevel)worldIn).func_175739_a(EnumParticleTypes.PORTAL, merch.field_70165_t, merch.field_70163_u, merch.field_70161_v, 5, (-0.5 + rand.nextDouble()) * 3.0, 0.3, (-0.5 + rand.nextDouble()) * 3.0, (double)0.15f, new int[0]);
                merch.func_70106_y();
            }
            worldIn.func_184133_a(null, pos, SoundEvents.field_187620_cL, SoundSource.MASTER, 1.0f, 1.0f);
            EntityMemPuzzleMerchant newMerchant = new EntityMemPuzzleMerchant(worldIn);
            newMerchant.func_70107_b(pos.func_177958_n(), (double)pos.func_177956_o() + 1.5, pos.func_177952_p());
            ((ServerLevel)worldIn).func_175739_a(EnumParticleTypes.PORTAL, newMerchant.field_70165_t, newMerchant.field_70163_u, newMerchant.field_70161_v, 8, (-0.5 + rand.nextDouble()) * 3.0, 0.3, (-0.5 + rand.nextDouble()) * 3.0, (double)0.15f, new int[0]);
            newMerchant.setLightPositions(pos, 6 + (this.hard_mode ? 3 : 0), this.hard_mode ? 1 : 0);
            newMerchant.setHardMode(this.hard_mode);
            worldIn.func_72838_d((Entity)newMerchant);
            playerIn.func_145747_a((Component)new Component(TextFmt.getFormatting(TextFmt.Italic, TextFmt.Aqua) + "Merchant: Give me an unpowered " + (this.hard_mode ? "emberstar" : "starcrystal") + " to begin the challenge that can charge it."));
        }
        return true;
    }
}

