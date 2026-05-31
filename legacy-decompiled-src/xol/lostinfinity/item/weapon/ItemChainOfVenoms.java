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
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.EnumParticleTypes
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.item.weapon;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.classify.ICustomRaytrace;
import xol.lostinfinity.item.weapon.ItemCooldownSword;
import xol.lostinfinity.projectile.entity.EntityChainOfVenomsAttack;
import xol.lostinfinity.util.data.CustomParticleConfig;
import xol.lostinfinity.util.data.CustomHitResult;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.fx.IParticleSpawner;

public class ItemChainOfVenoms
extends ItemCooldownSword
implements IMaxAttack,
ICustomRaytrace {
    private static final int chainCount = 4;
    private static final int range = 10;

    public ItemChainOfVenoms(String regName) {
        super(regName);
        this.func_77637_a(TabsInit.TAB_AUXWEP);
    }

    private ArrayList<LivingEntity> findChainEnemies(LivingEntity target, Player playerIn, Level worldIn) {
        ArrayList<LivingEntity> entitiesHit = new ArrayList<LivingEntity>();
        ArrayList<Object> entitiesVisited = new ArrayList<Object>();
        entitiesVisited.add(playerIn);
        entitiesVisited.add(target);
        entitiesHit.add(target);
        for (int count = 0; count < 4; ++count) {
            LivingEntity chainFrom = entitiesHit.get(entitiesHit.size() - 1);
            BlockPos pos = chainFrom.func_180425_c();
            AABB checkBox = new AABB(pos.func_177982_a(-10, -10, -10), pos.func_177982_a(10, 10, 10));
            LivingEntity closest = null;
            double minDist = 1000.0;
            for (LivingEntity entity : worldIn.func_72872_a(LivingEntity.class, checkBox)) {
                double dist;
                if (entitiesVisited.contains(entity) || !((dist = (double)entity.func_70032_d((Entity)chainFrom)) <= minDist)) continue;
                minDist = dist;
                closest = entity;
            }
            if (closest == null) continue;
            entitiesVisited.add(closest);
            entitiesHit.add(closest);
        }
        return entitiesHit;
    }

    private void dealChainDamage(Player playerIn, ArrayList<LivingEntity> entitiesHit) {
        for (LivingEntity target : entitiesHit) {
            int potion_count = target.func_70651_bq().size();
            if (potion_count <= 0) continue;
            IMaxAttack.dealMaxHealth((Entity)playerIn, target, 10, potion_count);
        }
    }

    private ArrayList<EntityChainOfVenomsAttack> createChainRender(Level worldIn, Player player, ArrayList<LivingEntity> entitiesHit) {
        ArrayList<EntityChainOfVenomsAttack> attackEntities = new ArrayList<EntityChainOfVenomsAttack>();
        if (entitiesHit != null && entitiesHit.size() > 1) {
            for (int i = 0; i < entitiesHit.size() - 1; ++i) {
                LivingEntity origin = entitiesHit.get(i);
                LivingEntity target = entitiesHit.get(i + 1);
                EntityChainOfVenomsAttack attackEntity = new EntityChainOfVenomsAttack(worldIn);
                attackEntity.setOrigin(origin.func_145782_y());
                attackEntity.setTarget(target.func_145782_y());
                attackEntity.setCaster(player);
                attackEntity.func_70107_b(origin.field_70165_t, origin.field_70163_u, origin.field_70161_v);
                attackEntities.add(attackEntity);
                CustomParticleConfig config1 = new CustomParticleConfig();
                config1.createInstance().setParticle(ParticleInit.VENOM).setSpread(4.0, 1.0, 4.0).setCount(2).setIgnoreRange(true);
                CustomParticleConfig config2 = new CustomParticleConfig();
                config2.createInstance().setParticle(ParticleInit.VENOM_RING).setSpread(1.0, 1.0, 1.0).setIgnoreRange(true);
                IParticleSpawner.spawnParticle(worldIn, config1, target.field_70165_t, target.field_70163_u + (double)(target.field_70131_O / 2.0f), target.field_70161_v);
                IParticleSpawner.spawnParticle(worldIn, config2, target.field_70165_t, target.field_70163_u + (double)(target.field_70131_O / 2.0f), target.field_70161_v);
            }
        }
        return attackEntities;
    }

    public InteractionResultHolder<ItemStack> func_77659_a(Level worldIn, Player playerIn, InteractionHand handIn) {
        ItemStack stack = playerIn.func_184586_b(handIn);
        if (!this.showDurabilityBar(stack) && !playerIn.func_70093_af()) {
            CustomHitResult trace_result;
            if (!worldIn.field_72995_K && (trace_result = this.standardFXTrace(worldIn, (LivingEntity)playerIn, 45, EnumParticleTypes.SMOKE_NORMAL, LivingEntity.class)) != null && trace_result.getResultEntity() != null) {
                LivingEntity target = (LivingEntity)trace_result.getResultEntity();
                ArrayList<LivingEntity> entitiesHit = this.findChainEnemies(target, playerIn, worldIn);
                ArrayList<EntityChainOfVenomsAttack> attackEntities = this.createChainRender(worldIn, playerIn, entitiesHit);
                this.renderChains(worldIn, attackEntities);
                this.dealChainDamage(playerIn, entitiesHit);
                CustomParticleConfig config1 = new CustomParticleConfig();
                config1.createInstance().setParticle(ParticleInit.VENOM).setSpread(4.0, 1.0, 4.0).setCount(2).setIgnoreRange(true);
                CustomParticleConfig config2 = new CustomParticleConfig();
                config2.createInstance().setParticle(ParticleInit.VENOM_RING).setSpread(1.0, 1.0, 1.0).setIgnoreRange(true);
                IParticleSpawner.spawnParticle(worldIn, config1, target.field_70165_t, target.field_70163_u + (double)(target.field_70131_O / 2.0f), target.field_70161_v);
                IParticleSpawner.spawnParticle(worldIn, config2, target.field_70165_t, target.field_70163_u + (double)(target.field_70131_O / 2.0f), target.field_70161_v);
            }
            playerIn.func_184185_a(SoundInit.LASER_WEAPON_6, 1.0f, 1.0f);
            playerIn.func_184586_b(handIn).func_77978_p().func_74772_a("lastUse", System.currentTimeMillis());
        }
        return super.func_77659_a(worldIn, playerIn, handIn);
    }

    private void renderChains(Level worldIn, ArrayList<EntityChainOfVenomsAttack> attackEntities) {
        if (attackEntities != null) {
            for (EntityChainOfVenomsAttack attackEntity : attackEntities) {
                worldIn.func_72838_d((Entity)attackEntity);
            }
        }
    }

    @Override
    protected int getCooldown() {
        return 300;
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Gold) + "Fires a projectile that chains between nearby enemies, dealing damage based on potion effects.");
        tooltip.add((Object)((Object)TextFmt.Light_Purple) + "Per Potion Effect on Target:");
        tooltip.add((Object)((Object)TextFmt.Gold) + "Deals 10% Max Health Damage");
    }
}

