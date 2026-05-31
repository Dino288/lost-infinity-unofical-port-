/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.Item
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 */
package xol.lostinfinity.block.harvest;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import xol.lostinfinity.block.basic.BlockBasicLight;
import xol.lostinfinity.block.basic.ISpecialHarvest;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.entity.starforge.EntityGlomite;
import xol.lostinfinity.util.data.CustomParticleConfig;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.fx.IParticleSpawner;

public class BlockPrismosisOre
extends BlockBasicLight
implements ISpecialHarvest,
IMaxAttack {
    public BlockPrismosisOre(String name) {
        super(name);
        this.func_149711_c(2.0f);
    }

    @Override
    public void failedHarvest(Level world, BlockPos pos, Player harvester) {
    }

    @Override
    public Item getHarvestResult(Level world, BlockPos pos) {
        return ItemInit.prismosisShards;
    }

    @Override
    public Item getToolNeeded() {
        return ItemInit.crystalPickaxe;
    }

    @Override
    public void worldHarvestEffect(Level world, BlockPos pos, Player harvester) {
        if (!world.field_72995_K) {
            boolean teleported = false;
            for (EntityGlomite glomite : world.func_72872_a(EntityGlomite.class, new AABB(pos.func_177982_a(-7, -7, -7), pos.func_177982_a(7, 7, 7)))) {
                glomite.func_70634_a(harvester.field_70165_t, harvester.field_70163_u, harvester.field_70161_v);
                glomite.func_70624_b((LivingEntity)harvester);
                teleported = true;
            }
            if (teleported) {
                world.func_184133_a(null, pos, SoundInit.GLOMITE_TELEPORT, SoundSource.HOSTILE, 2.0f, 1.0f);
                CustomParticleConfig config = new CustomParticleConfig();
                config.createInstance().setParticle(ParticleInit.GLOMITE_WARP).setIgnoreRange(true);
                IParticleSpawner.spawnParticle(world, config, harvester.field_70165_t, harvester.field_70163_u + 0.5, harvester.field_70161_v);
            }
        }
    }

    @Override
    public boolean isHarvestable(Level world, BlockPos pos, Player harvester) {
        return true;
    }
}

