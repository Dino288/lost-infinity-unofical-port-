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
import xol.lostinfinity.item.classify.ICustomHoldPose;
import xol.lostinfinity.item.classify.IModeSelect;
import xol.lostinfinity.item.classify.ISwitchModels;
import xol.lostinfinity.projectile.entity.EntityElementiumAir;
import xol.lostinfinity.projectile.entity.EntityElementiumBlight;
import xol.lostinfinity.projectile.entity.EntityElementiumEarth;
import xol.lostinfinity.projectile.entity.EntityElementiumFire;
import xol.lostinfinity.projectile.entity.EntityElementiumPlague;
import xol.lostinfinity.projectile.entity.EntityElementiumShadow;
import xol.lostinfinity.projectile.entity.EntityElementiumWater;

public class ItemElementiumBow
extends ItemCooldown
implements ICustomHoldPose,
ISwitchModels,
IModeSelect {
    private int elements_stored;

    public ItemElementiumBow(String regName, int numElements) {
        super(regName);
        this.func_77637_a(TabsInit.TAB_AUXWEP);
        this.setModelSwitch("elements", this, numElements);
        this.elements_stored = numElements;
    }

    public InteractionResultHolder<ItemStack> func_77659_a(Level worldIn, Player playerIn, InteractionHand handIn) {
        ItemStack stack = playerIn.func_184586_b(handIn);
        if (!stack.func_77942_o()) {
            stack.func_77982_d(new CompoundTag());
            stack.func_77978_p().func_74768_a("elements_data", 0);
            stack.func_77978_p().func_74768_a("elements_stored", this.elements_stored);
        }
        if (!worldIn.field_72995_K && !this.showDurabilityBar(playerIn.func_184586_b(handIn))) {
            switch (stack.func_77978_p().func_74762_e("elements_data")) {
                case 0: {
                    EntityElementiumAir air = new EntityElementiumAir(worldIn, (LivingEntity)playerIn);
                    air.setThrower((LivingEntity)playerIn);
                    air.func_184538_a((Entity)playerIn, playerIn.field_70125_A, playerIn.field_70177_z, 0.0f, 4.0f, 0.0f);
                    worldIn.func_72838_d((Entity)air);
                    break;
                }
                case 1: {
                    for (int shot = 0; shot < 8; ++shot) {
                        EntityElementiumWater water = new EntityElementiumWater(worldIn, (LivingEntity)playerIn);
                        water.setThrower((LivingEntity)playerIn);
                        water.func_184538_a((Entity)playerIn, playerIn.field_70125_A, playerIn.field_70177_z, 0.0f, 2.0f, 8.0f);
                        worldIn.func_72838_d((Entity)water);
                    }
                    break;
                }
                case 2: {
                    EntityElementiumEarth earth = new EntityElementiumEarth(worldIn, (LivingEntity)playerIn);
                    earth.setThrower((LivingEntity)playerIn);
                    earth.func_184538_a((Entity)playerIn, playerIn.field_70125_A, playerIn.field_70177_z, 0.0f, 2.5f, 0.0f);
                    worldIn.func_72838_d((Entity)earth);
                    break;
                }
                case 3: {
                    EntityElementiumFire fire = new EntityElementiumFire(worldIn, (LivingEntity)playerIn);
                    fire.setThrower((LivingEntity)playerIn);
                    fire.func_184538_a((Entity)playerIn, playerIn.field_70125_A, playerIn.field_70177_z, 0.0f, 2.5f, 0.0f);
                    worldIn.func_72838_d((Entity)fire);
                    break;
                }
                case 4: {
                    EntityElementiumShadow shadow = new EntityElementiumShadow(worldIn, (LivingEntity)playerIn);
                    shadow.setThrower((LivingEntity)playerIn);
                    shadow.func_184538_a((Entity)playerIn, playerIn.field_70125_A, playerIn.field_70177_z, 0.0f, 2.5f, 0.0f);
                    worldIn.func_72838_d((Entity)shadow);
                    break;
                }
                case 5: {
                    EntityElementiumBlight blight = new EntityElementiumBlight(worldIn, (LivingEntity)playerIn);
                    blight.setThrower((LivingEntity)playerIn);
                    blight.func_184538_a((Entity)playerIn, playerIn.field_70125_A, playerIn.field_70177_z, 0.0f, 2.5f, 0.0f);
                    worldIn.func_72838_d((Entity)blight);
                    break;
                }
                case 6: {
                    EntityElementiumPlague plague = new EntityElementiumPlague(worldIn, (LivingEntity)playerIn);
                    plague.setThrower((LivingEntity)playerIn);
                    plague.func_184538_a((Entity)playerIn, playerIn.field_70125_A, playerIn.field_70177_z, 0.0f, 2.5f, 0.0f);
                    worldIn.func_72838_d((Entity)plague);
                }
            }
            worldIn.func_184133_a(null, playerIn.func_180425_c(), SoundEvents.field_187866_fi, SoundSource.MASTER, 1.0f, 1.0f);
            playerIn.func_184586_b(handIn).func_77978_p().func_74772_a("lastUse", System.currentTimeMillis());
        }
        return super.func_77659_a(worldIn, playerIn, handIn);
    }

    @Override
    protected int getCooldown() {
        return 500;
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Light_Purple) + "A bow that can switch between elements.");
        if (stack.func_77942_o()) {
            tooltip.add((Object)((Object)TextFmt.Italic) + "Active Element: " + this.getElementName(stack.func_77978_p().func_74762_e("elements_data")));
            tooltip.add((Object)((Object)TextFmt.Gold) + "Currently has " + stack.func_77978_p().func_74762_e("elements_stored") + " elements stored.");
        }
    }

    private String getElementName(int element) {
        switch (element) {
            case 0: {
                return "Wind";
            }
            case 1: {
                return "Waves";
            }
            case 2: {
                return "Nature";
            }
            case 3: {
                return "Flames";
            }
            case 4: {
                return "Shadows";
            }
            case 5: {
                return "Blight";
            }
            case 6: {
                return "Plague";
            }
            case 7: {
                return "Magnetism";
            }
            case 8: {
                return "Electricity";
            }
        }
        return "";
    }

    @Override
    public void modeUpdate(ItemStack stack, Player player) {
        int new_element;
        if (!stack.func_77942_o()) {
            stack.func_77982_d(new CompoundTag());
            stack.func_77978_p().func_74768_a("elements_data", 0);
            stack.func_77978_p().func_74768_a("elements_stored", this.elements_stored);
        }
        if (!stack.func_77978_p().func_74764_b("elements_stored")) {
            stack.func_77978_p().func_74768_a("elements_stored", this.elements_stored);
        }
        if ((new_element = stack.func_77978_p().func_74762_e("elements_data") + 1) >= stack.func_77978_p().func_74762_e("elements_stored")) {
            new_element = 0;
        }
        stack.func_77978_p().func_74768_a("elements_data", new_element);
        player.field_70170_p.func_184133_a(null, player.func_180425_c(), SoundEvents.field_187556_aj, SoundSource.MASTER, 1.0f, 1.0f);
    }
}

