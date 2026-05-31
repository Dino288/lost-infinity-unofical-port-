/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.client.util.ITooltipFlag
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.tileentity.BlockEntity
 *  net.minecraft.util.InteractionResultHolder
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.item.weapon;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import javax.annotation.Nullable;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.block.tileentity.BlockEntityTeslaTower;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.basics.ItemCooldown;
import xol.lostinfinity.item.classify.IModeSelect;
import xol.lostinfinity.util.data.CustomParticleConfig;
import xol.lostinfinity.util.data.CustomHitResult;
import xol.lostinfinity.util.data.RayTraceBuilder;
import xol.lostinfinity.util.fx.IParticleSpawner;

public class ItemTeslaTowers
extends ItemCooldown
implements IModeSelect {
    private static final int MAX_TOWER = 6;

    public ItemTeslaTowers(String regName) {
        super(regName);
        this.func_77637_a(TabsInit.TAB_AUXWEP);
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Gold) + "A scythe imbued with electric magic.");
        tooltip.add((Object)((Object)TextFmt.Aqua) + "Places Tesla Towers that Deal True Damage");
        tooltip.add((Object)((Object)TextFmt.Italic) + "Towers can be turned on to damage entities between them.");
        tooltip.add((Object)((Object)TextFmt.Red) + "Towers last 60 seconds.");
    }

    public InteractionResultHolder<ItemStack> func_77659_a(Level worldIn, Player playerIn, InteractionHand handIn) {
        ItemStack stack = playerIn.func_184586_b(handIn);
        if (!this.showDurabilityBar(stack)) {
            CustomHitResult result;
            if (!worldIn.field_72995_K && (result = RayTraceBuilder.force(60).raySize(0.1f).trace((Entity)playerIn, true)) != null) {
                BlockEntityTeslaTower placed = this.placeTower(stack, worldIn, result.getResultPos());
                boolean mode = this.getMode(stack);
                placed.setOwner(playerIn.func_110124_au());
                placed.setActive(mode);
                if (mode) {
                    this.iterateTowers(worldIn, stack, (tile, posSet) -> {
                        tile.setOwner(playerIn.func_110124_au());
                        tile.setOthers((Set<BlockPos>)posSet);
                        tile.doBlockUpdate();
                    });
                }
                CustomParticleConfig config1 = new CustomParticleConfig();
                config1.setCount(3);
                config1.createInstance().setParticle(ParticleInit.ELECTRIC_EXPLOSION_BLUE).setSpread(2.0, 1.0, 2.0).setIgnoreRange(true);
                config1.createInstance().setParticle(ParticleInit.ELECTRIC_EXPLOSION_YELLOW).setSpread(2.0, 1.0, 2.0).setIgnoreRange(true);
                IParticleSpawner.spawnParticle(worldIn, config1, result.getResultVector().field_72450_a, result.getResultVector().field_72448_b, result.getResultVector().field_72449_c);
                worldIn.func_184133_a(null, result.getResultPos(), SoundInit.ELECTRIC_WOOSH, SoundSource.PLAYERS, 1.5f, 0.8f + worldIn.field_73012_v.nextFloat() * 0.4f);
                worldIn.func_184133_a(null, result.getResultPos(), SoundEvents.field_187845_fY, SoundSource.PLAYERS, 1.5f, 1.0f);
                worldIn.func_184133_a(null, playerIn.func_180425_c(), SoundInit.ELECTRIC_WOOSH, SoundSource.PLAYERS, 1.5f, 0.8f + worldIn.field_73012_v.nextFloat() * 0.4f);
                worldIn.func_184133_a(null, playerIn.func_180425_c(), SoundEvents.field_187845_fY, SoundSource.PLAYERS, 1.5f, 1.0f);
            }
            this.startCooldown(stack);
        }
        return super.func_77659_a(worldIn, playerIn, handIn);
    }

    @Override
    public void modeUpdate(ItemStack stack, Player player) {
        boolean mode = !this.getMode(stack);
        this.setMode(stack, mode);
        Level world = player.field_70170_p;
        if (world.field_72995_K) {
            return;
        }
        this.iterateTowers(world, stack, (tile, posSet) -> {
            tile.setActive(mode);
            tile.setOthers((Set<BlockPos>)posSet);
            tile.doBlockUpdate();
        });
    }

    @Override
    protected int getCooldown() {
        return 150;
    }

    private BlockEntityTeslaTower placeTower(ItemStack stack, Level world, BlockPos pos) {
        BlockEntityTeslaTower oldTower;
        int id = this.getPlaceAt(stack);
        BlockPos spot = this.getTowerPos(stack, id);
        if (spot != null && world.func_180495_p(spot) == BlockInit.teslaTower.func_176223_P() && (oldTower = (BlockEntityTeslaTower)world.func_175625_s(spot)).getTowerId() == id) {
            world.func_175698_g(spot);
        }
        stack.func_77978_p().func_74768_a("tower_x_" + id, pos.func_177958_n());
        stack.func_77978_p().func_74768_a("tower_y_" + id, pos.func_177956_o());
        stack.func_77978_p().func_74768_a("tower_z_" + id, pos.func_177952_p());
        world.func_175656_a(pos, BlockInit.teslaTower.func_176223_P());
        BlockEntityTeslaTower tower = (BlockEntityTeslaTower)world.func_175625_s(pos);
        tower.setTowerId(id);
        return tower;
    }

    private int getPlaceAt(ItemStack stack) {
        if (!stack.func_77942_o()) {
            stack.func_77982_d(new CompoundTag());
        }
        int next = stack.func_77978_p().func_74762_e("next");
        stack.func_77978_p().func_74768_a("next", (next + 1) % 6);
        return next;
    }

    private void setMode(ItemStack stack, boolean flag) {
        if (!stack.func_77942_o()) {
            stack.func_77982_d(new CompoundTag());
        }
        stack.func_77978_p().func_74757_a("mode", flag);
    }

    private boolean getMode(ItemStack stack) {
        if (!stack.func_77942_o()) {
            stack.func_77982_d(new CompoundTag());
        }
        return stack.func_77978_p().func_74767_n("mode");
    }

    private BlockPos getTowerPos(ItemStack stack, int id) {
        if (!stack.func_77942_o()) {
            stack.func_77982_d(new CompoundTag());
        }
        if (!stack.func_77978_p().func_74764_b("tower_x_" + id)) {
            return null;
        }
        return new BlockPos(stack.func_77978_p().func_74762_e("tower_x_" + id), stack.func_77978_p().func_74762_e("tower_y_" + id), stack.func_77978_p().func_74762_e("tower_z_" + id));
    }

    private void iterateTowers(Level world, ItemStack stack, BiConsumer<BlockEntityTeslaTower, Set<BlockPos>> towerConsumer) {
        HashSet<BlockPos> poses = new HashSet<BlockPos>();
        for (int i = 0; i < 6; ++i) {
            BlockPos spot = this.getTowerPos(stack, i);
            if (spot == null) continue;
            poses.add(spot);
        }
        for (BlockPos pos : poses) {
            BlockEntity tile = world.func_175625_s(pos);
            if (!(tile instanceof BlockEntityTeslaTower)) continue;
            towerConsumer.accept((BlockEntityTeslaTower)tile, poses);
        }
    }
}

