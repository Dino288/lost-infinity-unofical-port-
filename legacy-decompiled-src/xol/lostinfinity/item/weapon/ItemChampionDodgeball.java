/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.client.util.ITooltipFlag
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.util.InteractionResultHolder
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.SoundSource
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.item.weapon;

import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.basics.ItemCooldown;
import xol.lostinfinity.item.classify.ISwitchModels;
import xol.lostinfinity.projectile.entity.EntityChampionDodgeball;

public class ItemChampionDodgeball
extends ItemCooldown
implements ISwitchModels {
    public ItemChampionDodgeball(String regName) {
        super(regName);
        this.func_77637_a(TabsInit.TAB_AUXWEP);
        this.setModelSwitch("balltype", this, 3);
    }

    public InteractionResultHolder<ItemStack> func_77659_a(Level worldIn, Player playerIn, InteractionHand handIn) {
        ItemStack stack = playerIn.func_184586_b(handIn);
        if (!stack.func_77942_o()) {
            stack.func_77982_d(new CompoundTag());
        }
        int type = stack.func_77978_p().func_74762_e("balltype_data");
        if (!this.showDurabilityBar(stack)) {
            if (!worldIn.field_72995_K) {
                if (type == 1) {
                    for (int i = 0; i < 4; ++i) {
                        EntityChampionDodgeball shot = new EntityChampionDodgeball(worldIn, (LivingEntity)playerIn);
                        shot.setType(type);
                        shot.setThrower((LivingEntity)playerIn);
                        shot.shootNoVel((Entity)playerIn, playerIn.field_70125_A, playerIn.field_70177_z, 0.0f, 1.7f, 6.0f);
                        worldIn.func_72838_d((Entity)shot);
                    }
                } else {
                    EntityChampionDodgeball shot = new EntityChampionDodgeball(worldIn, (LivingEntity)playerIn);
                    shot.setType(type);
                    shot.setThrower((LivingEntity)playerIn);
                    shot.shootNoVel((Entity)playerIn, playerIn.field_70125_A, playerIn.field_70177_z, 0.0f, type == 2 ? 3.0f : 1.5f, 0.0f);
                    worldIn.func_72838_d((Entity)shot);
                }
                worldIn.func_184133_a(null, playerIn.func_180425_c(), SoundEvents.field_187578_au, SoundSource.PLAYERS, 1.0f, 1.0f);
            }
            stack.func_77978_p().func_74772_a("lastUse", System.currentTimeMillis());
            stack.func_190918_g(1);
        }
        return super.func_77659_a(worldIn, playerIn, handIn);
    }

    @Override
    protected int getCooldown() {
        return 2000;
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Gold) + "A premium dodgeball.");
    }
}

