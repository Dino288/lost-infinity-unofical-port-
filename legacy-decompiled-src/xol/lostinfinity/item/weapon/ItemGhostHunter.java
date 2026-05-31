/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.client.util.ITooltipFlag
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.InteractionResultHolder
 *  net.minecraft.util.EnumInteractionResultHolder
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.EnumParticleTypes
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Mth
 *  net.minecraft.util.math.HitResult
 *  net.minecraft.util.math.HitResult$Type
 *  net.minecraft.util.math.Vec3
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
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.util.EnumInteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.weapon.ItemCooldownSword;
import xol.lostinfinity.util.data.IMaxAttack;

public class ItemGhostHunter
extends ItemCooldownSword
implements IMaxAttack {
    public ItemGhostHunter(String regName) {
        super(regName);
        this.func_77637_a(TabsInit.TAB_DEVIANTWEP);
    }

    public boolean func_77644_a(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        IMaxAttack.dealMaxHealth((Entity)attacker, target, 10);
        return true;
    }

    public InteractionResultHolder<ItemStack> func_77659_a(Level worldIn, Player playerIn, InteractionHand handIn) {
        block8: {
            if (this.showDurabilityBar(playerIn.func_184586_b(handIn))) break block8;
            HitResult mop = this.func_77621_a(worldIn, playerIn, true);
            if (mop == null || mop.field_72313_a != HitResult.Type.BLOCK) {
                return InteractionResultHolder.newResult((EnumInteractionResultHolder)EnumInteractionResultHolder.PASS, (Object)playerIn.func_184586_b(handIn));
            }
            BlockPos start = playerIn.func_180425_c();
            BlockPos result = mop.func_178782_a();
            boolean flag = worldIn.func_175623_d(result.func_177982_a(0, 1, 0)) && worldIn.func_175623_d(result.func_177982_a(0, 2, 0));
            double dist = playerIn.func_70011_f((double)result.func_177958_n(), (double)result.func_177956_o(), (double)result.func_177952_p());
            if (flag) {
                worldIn.func_184133_a(null, result, SoundInit.ITEM_GHOSTHUNTER, SoundSource.MASTER, 2.0f, 1.0f);
                if (!worldIn.field_72995_K) {
                    playerIn.func_184586_b(handIn).func_77978_p().func_74772_a("lastUse", System.currentTimeMillis());
                    playerIn.func_70634_a((double)result.func_177958_n(), (double)(result.func_177956_o() + 1), (double)result.func_177952_p());
                    for (LivingEntity near_entity : worldIn.func_72872_a(LivingEntity.class, new AABB(result.func_177982_a(-3, -3, -3), result.func_177982_a(3, 3, 3)))) {
                        if (near_entity.func_110124_au() == playerIn.func_110124_au()) continue;
                        int denomDamage = Math.round(10L - Math.round(8.0 * (dist / 20.0)));
                        if (denomDamage < 2) {
                            denomDamage = 2;
                        }
                        IMaxAttack.dealMaxHealth((Entity)playerIn, near_entity, denomDamage);
                    }
                } else {
                    int repeats = 10 + Math.abs(Math.round((float)dist));
                    double xdiff = start.func_177958_n() - result.func_177958_n();
                    double ydiff = start.func_177956_o() - result.func_177956_o();
                    double zdiff = start.func_177952_p() - result.func_177952_p();
                    for (int part = 0; part < repeats; ++part) {
                        for (int k = 0; k < 3; ++k) {
                            worldIn.func_175688_a(EnumParticleTypes.SMOKE_LARGE, (double)start.func_177958_n() + -xdiff / (double)repeats * (double)part, (double)start.func_177956_o() + -ydiff / (double)repeats * (double)part, (double)start.func_177952_p() + -zdiff / (double)repeats * (double)part, (worldIn.field_73012_v.nextDouble() - 0.5) * 0.1, 0.0, (worldIn.field_73012_v.nextDouble() - 0.5) * 0.1, new int[0]);
                        }
                    }
                }
            }
        }
        return super.func_77659_a(worldIn, playerIn, handIn);
    }

    protected HitResult func_77621_a(Level worldIn, Player playerIn, boolean useLiquids) {
        float f = playerIn.field_70125_A;
        float f1 = playerIn.field_70177_z;
        double d0 = playerIn.field_70165_t;
        double d1 = playerIn.field_70163_u + (double)playerIn.func_70047_e();
        double d2 = playerIn.field_70161_v;
        Vec3 vec3d = new Vec3(d0, d1, d2);
        float f2 = Mth.func_76134_b((float)(-f1 * ((float)Math.PI / 180) - (float)Math.PI));
        float f3 = Mth.func_76126_a((float)(-f1 * ((float)Math.PI / 180) - (float)Math.PI));
        float f4 = -Mth.func_76134_b((float)(-f * ((float)Math.PI / 180)));
        float f5 = Mth.func_76126_a((float)(-f * ((float)Math.PI / 180)));
        float f6 = f3 * f4;
        float f7 = f2 * f4;
        double d3 = 40.0;
        Vec3 vec3d1 = vec3d.func_72441_c((double)f6 * d3, (double)f5 * d3, (double)f7 * d3);
        return worldIn.func_147447_a(vec3d, vec3d1, useLiquids, !useLiquids, false);
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Gold) + "Deals 10% Max Health Damage");
        tooltip.add((Object)((Object)TextFmt.Dark_Purple) + "Right click to teleport up to 30 blocks.");
        tooltip.add(TextFmt.getFormatting(TextFmt.Italic, TextFmt.Light_Purple) + "On Arrival:");
        tooltip.add((Object)((Object)TextFmt.Red) + "Deal up to 50% Max Health Damage to Very Close Enemies");
        tooltip.add((Object)((Object)TextFmt.Italic) + "Damage based on distance travelled.");
    }
}

