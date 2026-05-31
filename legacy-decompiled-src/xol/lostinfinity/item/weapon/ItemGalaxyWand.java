/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.client.util.ITooltipFlag
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.Item
 *  net.minecraft.item.Item$ToolMaterial
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.SwordItem
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.util.InteractionResultHolder
 *  net.minecraft.util.EnumInteractionResultHolder
 *  net.minecraft.util.InteractionHand
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
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.util.EnumInteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.projectile.entity.EntityWandAttack;
import xol.lostinfinity.util.data.IMaxAttack;

public class ItemGalaxyWand
extends SwordItem
implements IMaxAttack {
    private String wep = "";

    public ItemGalaxyWand(String regName) {
        super(Item.ToolMaterial.WOOD);
        this.func_77637_a(TabsInit.TAB_GALAXY);
        this.setRegistryName(regName);
        this.func_77655_b(regName);
        this.wep = regName;
        ItemInit.ITEMS.add((Item)this);
    }

    public InteractionResultHolder<ItemStack> func_77659_a(Level worldIn, Player playerIn, InteractionHand handIn) {
        if (!this.showDurabilityBar(playerIn.func_184586_b(handIn))) {
            HitResult mop = this.func_77621_a(worldIn, playerIn, true);
            if (mop == null || mop.field_72313_a != HitResult.Type.BLOCK) {
                return InteractionResultHolder.newResult((EnumInteractionResultHolder)EnumInteractionResultHolder.PASS, (Object)playerIn.func_184586_b(handIn));
            }
            BlockPos result = mop.func_178782_a();
            AABB aabb = new AABB(result.func_177982_a(-5, -5, -5), result.func_177982_a(5, 5, 5));
            for (LivingEntity li : worldIn.func_72872_a(LivingEntity.class, aabb)) {
                IMaxAttack.dealMaxHealth((Entity)playerIn, li, 8);
            }
            if (!worldIn.field_72995_K) {
                playerIn.func_184586_b(handIn).func_77978_p().func_74772_a("lastUse", System.currentTimeMillis());
                EntityWandAttack attack = new EntityWandAttack(worldIn);
                attack.func_70107_b(playerIn.field_70165_t, playerIn.field_70163_u + 1.0, playerIn.field_70161_v);
                attack.setAimBlock(result);
                attack.setCaster(playerIn);
                worldIn.func_72838_d((Entity)attack);
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

    public boolean showDurabilityBar(ItemStack stack) {
        if (!stack.func_77942_o()) {
            stack.func_77982_d(new CompoundTag());
            stack.func_77978_p().func_74772_a("lastUse", 0L);
        }
        long lastUse = stack.func_77978_p().func_74763_f("lastUse");
        long maxDelay = TimeUnit.SECONDS.toMillis(3L);
        return System.currentTimeMillis() - lastUse <= maxDelay;
    }

    public double getDurabilityForDisplay(ItemStack stack) {
        if (this.showDurabilityBar(stack)) {
            double result = System.currentTimeMillis() - stack.func_77978_p().func_74763_f("lastUse");
            double fin = result / (double)TimeUnit.SECONDS.toMillis(3L);
            return 1.0 - Math.pow(fin, 1.0);
        }
        return 1.0;
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Red) + "In several directions fire projectiles.");
        switch (this.wep) {
            case "moonglow_wand": {
                tooltip.add((Object)((Object)TextFmt.Gold) + "While Above 80% Life:");
                tooltip.add((Object)((Object)TextFmt.Aqua) + "Deal 15% Max Health Damage");
                break;
            }
            case "novacron_wand": {
                tooltip.add((Object)((Object)TextFmt.Gold) + "To Targets Below 50% Health:");
                tooltip.add((Object)((Object)TextFmt.Light_Purple) + "Deal 10% Max Health Damage");
                break;
            }
            case "aurorus_wand": {
                tooltip.add((Object)((Object)TextFmt.Gold) + "To Targets Above 50% Health:");
                tooltip.add((Object)((Object)TextFmt.Green) + "Deal 10% Max Health Damage");
                break;
            }
            case "starfire_wand": {
                tooltip.add((Object)((Object)TextFmt.Gold) + "While Below 20% Life:");
                tooltip.add((Object)((Object)TextFmt.Yellow) + "Deal 20% Max Health Damage");
            }
        }
    }
}

