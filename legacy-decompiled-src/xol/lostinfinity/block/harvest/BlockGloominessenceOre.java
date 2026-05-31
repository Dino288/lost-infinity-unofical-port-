/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.Item
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraft.world.World
 */
package xol.lostinfinity.block.harvest;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import xol.lostinfinity.block.basic.BlockBasicLight;
import xol.lostinfinity.block.basic.ISpecialHarvest;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.PotionInit;
import xol.lostinfinity.mob.entity.starforge.EntityEssenceDweller;
import xol.lostinfinity.util.data.IMaxAttack;

public class BlockGloominessenceOre
extends BlockBasicLight
implements ISpecialHarvest,
IMaxAttack {
    public BlockGloominessenceOre(String name) {
        super(name);
        this.func_149711_c(2.0f);
        this.func_149715_a(1.0f);
    }

    @Override
    public void failedHarvest(Level world, BlockPos pos, Player harvester) {
    }

    @Override
    public Item getHarvestResult(Level world, BlockPos pos) {
        return ItemInit.gloominessence;
    }

    @Override
    public Item getToolNeeded() {
        return ItemInit.crystalPickaxe;
    }

    @Override
    public void worldHarvestEffect(Level world, BlockPos pos, Player harvester) {
        if (!world.field_72995_K) {
            world.func_175656_a(pos, BlockInit.gloominessenceOreEmpty.func_176223_P());
            int rand_result = world.field_73012_v.nextInt(3);
            switch (rand_result) {
                case 0: {
                    world.func_72876_a(null, (double)pos.func_177958_n(), (double)pos.func_177956_o(), (double)pos.func_177952_p(), 3.0f, false);
                    for (Player target : world.func_72872_a(Player.class, new AABB(pos).func_186662_g(5.0))) {
                        IMaxAttack.dealMaxHealth((Entity)harvester, (LivingEntity)target, 2);
                        target.func_145747_a((Component)new Component((Object)((Object)TextFmt.Red) + "A gas pocket in the ore explodes!"));
                    }
                    break;
                }
                case 1: {
                    EntityEssenceDweller dwel = new EntityEssenceDweller(world);
                    dwel.func_70107_b(harvester.field_70165_t, harvester.field_70163_u + 1.0, harvester.field_70161_v);
                    dwel.func_70624_b((LivingEntity)harvester);
                    world.func_72838_d((Entity)dwel);
                    harvester.func_145747_a((Component)new Component((Object)((Object)TextFmt.Dark_Aqua) + "An Essence Dweller emerged when you mined the Luminessence!"));
                    break;
                }
                case 2: {
                    for (Player target : world.func_72872_a(Player.class, new AABB(pos).func_186662_g(5.0))) {
                        target.func_70690_d(new PotionEffect(PotionInit.NULLIFIED, 100));
                        target.func_145747_a((Component)new Component((Object)((Object)TextFmt.Red) + "An electrical surge from the ore temporarily disables your armor."));
                    }
                    break;
                }
            }
        }
    }

    @Override
    public boolean isHarvestable(Level world, BlockPos pos, Player harvester) {
        return true;
    }
}

