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
 *  net.minecraft.util.EnumParticleTypes
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraft.world.World
 *  net.minecraft.world.ServerLevel
 *  net.minecraftforge.fml.common.registry.EntityEntry
 *  net.minecraftforge.fml.common.registry.EntityRegistry
 *  net.minecraftforge.fml.common.registry.ForgeRegistries
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.item.weapon;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Random;
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
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import net.minecraft.server.level.ServerLevel;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.basics.ItemCooldown;
import xol.lostinfinity.item.classify.ICustomRaytrace;
import xol.lostinfinity.item.classify.ISwitchModels;
import xol.lostinfinity.mob.entity.base.EntityDeviantMob;
import xol.lostinfinity.util.data.CustomHitResult;

public class ItemBranchOfLife
extends ItemCooldown
implements ICustomRaytrace,
ISwitchModels {
    public ItemBranchOfLife(String regName) {
        super(regName);
        this.func_77637_a(TabsInit.TAB_AUXWEP);
        this.setModelSwitch("deviation", this, 4);
    }

    public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity) {
        if (!stack.func_77942_o()) {
            stack.func_77982_d(new CompoundTag());
        }
        int flag = 0;
        if (entity instanceof EntityDeviantMob) {
            if (entity.func_145818_k_()) {
                flag = 2;
            } else {
                EntityDeviantMob deviant = (EntityDeviantMob)entity;
                if (deviant.atMaxMutation()) {
                    String entity_name = deviant.func_70005_c_().replaceAll("\\s", "");
                    ResourceLocation entname = EntityRegistry.getEntry(entity.getClass()).getRegistryName();
                    String resource_path = entname.toString();
                    if (stack.func_77978_p().func_74764_b(entity_name)) {
                        flag = 4;
                    } else {
                        stack.func_77978_p().func_74778_a(entity_name, resource_path);
                        stack.func_77978_p().func_74778_a("currentdeviant", entity_name);
                        if (!player.field_70170_p.field_72995_K) {
                            player.field_70170_p.func_184133_a(null, player.func_180425_c(), SoundInit.FLUX_MARK, SoundSource.MASTER, 1.0f, 1.0f);
                            player.func_145747_a((Component)new Component((Object)((Object)TextFmt.Gold) + entity.func_70005_c_() + " sucessfully stored."));
                        }
                    }
                } else {
                    flag = 5;
                }
            }
        } else {
            flag = 1;
        }
        if (flag > 0) {
            String msg = "";
            switch (flag) {
                case 1: {
                    msg = "Entity must be a deviant";
                    break;
                }
                case 2: {
                    msg = "Entity cannot have a custom name.";
                    break;
                }
                case 3: {
                    break;
                }
                case 4: {
                    msg = "Already have " + entity.func_70005_c_() + " stored.";
                    break;
                }
                case 5: {
                    msg = "Deviant must be fully super-mutated.";
                }
            }
            if (!player.field_70170_p.field_72995_K) {
                player.func_145747_a((Component)new Component((Object)((Object)TextFmt.Red) + msg));
            }
        }
        return true;
    }

    public InteractionResultHolder<ItemStack> func_77659_a(Level worldIn, Player playerIn, InteractionHand handIn) {
        ItemStack stack = playerIn.func_184586_b(handIn);
        if (!stack.func_77942_o()) {
            stack.func_77982_d(new CompoundTag());
        }
        if (playerIn.func_70093_af()) {
            int new_level = stack.func_77978_p().func_74762_e("deviation_data") + 1;
            if (new_level > 3) {
                new_level = 0;
            }
            stack.func_77978_p().func_74768_a("deviation_data", new_level);
            worldIn.func_184133_a(null, playerIn.func_180425_c(), SoundEvents.field_187556_aj, SoundSource.MASTER, 1.0f, 1.0f);
        } else if (!this.showDurabilityBar(playerIn.func_184586_b(handIn)) && stack.func_77978_p().func_74764_b("currentdeviant")) {
            CustomHitResult trace_result;
            if (!worldIn.field_72995_K && (trace_result = this.simpleBlockTrace(worldIn, (LivingEntity)playerIn, 60)) != null) {
                BlockPos result_pos = trace_result.getResultPos();
                String deviant_name = stack.func_77978_p().func_74779_i("currentdeviant");
                String resource_name = stack.func_77978_p().func_74779_i(deviant_name);
                EntityEntry entry = (EntityEntry)ForgeRegistries.ENTITIES.getValue(new ResourceLocation(resource_name));
                Class dev_class = entry.getEntityClass();
                try {
                    Constructor con = dev_class.getConstructor(World.class);
                    Object[] obj = new Object[]{worldIn};
                    Object devEntity = con.newInstance(obj);
                    ((Entity)devEntity).func_70107_b((double)result_pos.func_177958_n(), (double)(result_pos.func_177956_o() + 1), (double)result_pos.func_177952_p());
                    int level = stack.func_77978_p().func_74762_e("deviation_data");
                    ((EntityDeviantMob)devEntity).setMutation(level);
                    worldIn.func_72838_d((Entity)devEntity);
                    Random rand = worldIn.field_73012_v;
                    double particleY = ((Entity)devEntity).field_70131_O / 2.0f + (float)result_pos.func_177956_o() + 1.0f;
                    ((ServerLevel)worldIn).func_175739_a(EnumParticleTypes.LAVA, (double)result_pos.func_177958_n(), particleY, (double)result_pos.func_177952_p(), 10, (-0.5 + rand.nextDouble()) * 3.0, 0.3, (-0.5 + rand.nextDouble()) * 3.0, (double)0.15f, new int[0]);
                }
                catch (IllegalAccessException | IllegalArgumentException | InstantiationException | NoSuchMethodException | SecurityException | InvocationTargetException e) {
                    e.printStackTrace();
                }
                worldIn.func_184133_a(null, playerIn.func_180425_c(), SoundInit.SUPERMUTATION, SoundSource.MASTER, 1.0f, 1.0f);
            }
            playerIn.func_184586_b(handIn).func_77978_p().func_74772_a("lastUse", System.currentTimeMillis());
        }
        return super.func_77659_a(worldIn, playerIn, handIn);
    }

    @Override
    protected int getCooldown() {
        return 100;
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Aqua) + "Permanently stores the DNA of fully super-mutated deviants.");
        tooltip.add((Object)((Object)TextFmt.Gold) + "Can summon new lifeforms from the list of stored deviants.");
        tooltip.add((Object)((Object)TextFmt.Dark_Purple) + "Use </setdeviant Name> to set the type of deviant summoned.");
        if (stack.func_77942_o()) {
            if (stack.func_77978_p().func_74764_b("currentdeviant")) {
                tooltip.add((Object)((Object)TextFmt.Dark_Aqua) + "Summoning: " + stack.func_77978_p().func_74779_i("currentdeviant"));
            }
            tooltip.add(TextFmt.getFormatting(TextFmt.Italic, TextFmt.Yellow) + "Mutation Level: " + stack.func_77978_p().func_74762_e("deviation_data"));
        }
    }
}

