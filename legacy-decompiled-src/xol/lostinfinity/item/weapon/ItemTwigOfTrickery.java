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
 *  net.minecraft.util.InteractionResultHolder
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.item.weapon;

import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.basics.ItemCooldown;
import xol.lostinfinity.mob.entity.deviant.EntityDeviantCreeper;
import xol.lostinfinity.mob.entity.deviant.EntityDeviantSkeleton;
import xol.lostinfinity.mob.entity.deviant.EntityDeviantSpider;

public class ItemTwigOfTrickery
extends ItemCooldown {
    public ItemTwigOfTrickery(String regName) {
        super(regName);
        this.func_77637_a(TabsInit.TAB_DEVIANTWEP);
    }

    public InteractionResultHolder<ItemStack> func_77659_a(Level worldIn, Player playerIn, InteractionHand handIn) {
        if (!this.showDurabilityBar(playerIn.func_184586_b(handIn))) {
            if (!worldIn.field_72995_K) {
                worldIn.func_184133_a(null, new BlockPos(playerIn.field_70165_t, playerIn.field_70163_u, playerIn.field_70161_v), SoundInit.ITEM_SPACESLINGER, SoundSource.MASTER, 1.0f, 1.0f);
                EntityDeviantCreeper creep = new EntityDeviantCreeper(worldIn);
                creep.func_70107_b(playerIn.field_70165_t, playerIn.field_70163_u + 0.2, playerIn.field_70161_v);
                creep.setMutation(1);
                worldIn.func_72838_d((Entity)creep);
                EntityDeviantSkeleton skele = new EntityDeviantSkeleton(worldIn);
                skele.func_70107_b(playerIn.field_70165_t, playerIn.field_70163_u + 0.2, playerIn.field_70161_v);
                skele.setMutation(1);
                worldIn.func_72838_d((Entity)skele);
                EntityDeviantSpider spid = new EntityDeviantSpider(worldIn);
                spid.func_70107_b(playerIn.field_70165_t, playerIn.field_70163_u + 0.2, playerIn.field_70161_v);
                spid.setMutation(1);
                worldIn.func_72838_d((Entity)spid);
                boolean canStop = false;
                BlockPos telePos = new BlockPos(playerIn.field_70165_t, playerIn.field_70163_u + 2.0, playerIn.field_70161_v);
                int ypos = 3;
                while (!canStop) {
                    int multX = worldIn.field_73012_v.nextBoolean() ? 1 : -1;
                    int multZ = worldIn.field_73012_v.nextBoolean() ? 1 : -1;
                    BlockPos test = telePos.func_177982_a((15 + worldIn.field_73012_v.nextInt(15)) * multX, ypos, (15 + worldIn.field_73012_v.nextInt(15)) * multZ);
                    if (worldIn.func_175623_d(test)) {
                        canStop = true;
                        worldIn.func_184133_a(null, test, SoundEvents.field_187534_aX, SoundSource.MASTER, 2.0f, 1.0f);
                        playerIn.func_70634_a((double)test.func_177958_n(), (double)test.func_177956_o(), (double)test.func_177952_p());
                        continue;
                    }
                    ++ypos;
                }
            }
            playerIn.func_184586_b(handIn).func_77978_p().func_74772_a("lastUse", System.currentTimeMillis());
        }
        return super.func_77659_a(worldIn, playerIn, handIn);
    }

    @Override
    protected int getCooldown() {
        return 8000;
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Gold) + "Teleports you out of dire situations.");
        tooltip.add(TextFmt.getFormatting(TextFmt.Italic, TextFmt.Dark_Red) + "Leaves behind super-mutated monsters.");
    }
}

