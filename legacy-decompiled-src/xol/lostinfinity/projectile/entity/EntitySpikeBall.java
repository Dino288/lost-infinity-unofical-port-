/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.item.ItemEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.HitResult
 *  net.minecraft.util.math.HitResult$Type
 *  net.minecraft.world.World
 */
package xol.lostinfinity.projectile.entity;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.projectile.entity.EntityBaseThrowable;
import xol.lostinfinity.util.data.CustomParticleConfig;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.fx.IParticleSpawner;

public class EntitySpikeBall
extends EntityBaseThrowable {
    public EntitySpikeBall(Level par1World) {
        super(par1World);
    }

    public EntitySpikeBall(Level par1World, LivingEntity par2Mob) {
        super(par1World, par2Mob);
    }

    public EntitySpikeBall(Level par1World, double par2, double par4, double par6) {
        super(par1World, par2, par4, par6);
    }

    @Override
    protected void func_70184_a(HitResult result) {
        if (!this.field_70170_p.field_72995_K) {
            if (result.field_72313_a == HitResult.Type.BLOCK) {
                Block hitBlock = this.field_70170_p.func_180495_p(result.func_178782_a()).func_177230_c();
                if (hitBlock.equals(BlockInit.blueTentacleEye)) {
                    this.hitEye(result.func_178782_a(), ItemInit.watchfulEyeBlue, BlockInit.blueTentacleEyeEmpty);
                } else if (hitBlock.equals(BlockInit.pinkTentacleEye)) {
                    this.hitEye(result.func_178782_a(), ItemInit.watchfulEyePink, BlockInit.pinkTentacleEyeEmpty);
                } else if (hitBlock.equals(BlockInit.purpleTentacleEye)) {
                    this.hitEye(result.func_178782_a(), ItemInit.watchfulEyePurple, BlockInit.purpleTentacleEyeEmpty);
                } else if (hitBlock.equals(BlockInit.galaxySporeBlue)) {
                    this.spawnItem(ItemInit.toxicSporeSample, result.func_178782_a(), 1 + this.field_70146_Z.nextInt(3));
                    this.poisonCloud(result.func_178782_a());
                } else if (hitBlock.equals(BlockInit.galaxySporePink)) {
                    this.spawnItem(ItemInit.toxicSporeSample, result.func_178782_a(), 1 + this.field_70146_Z.nextInt(3));
                    this.poisonCloud(result.func_178782_a());
                } else if (hitBlock.equals(BlockInit.galaxySporeYellow)) {
                    this.spawnItem(ItemInit.toxicSporeSample, result.func_178782_a(), 1 + this.field_70146_Z.nextInt(3));
                    this.poisonCloud(result.func_178782_a());
                } else if (hitBlock.equals(BlockInit.galaxySporeGreen)) {
                    this.spawnItem(ItemInit.toxicSporeSample, result.func_178782_a(), 1 + this.field_70146_Z.nextInt(3));
                    this.poisonCloud(result.func_178782_a());
                }
            }
            this.func_70106_y();
        }
    }

    private void hitEye(BlockPos pos, Item drop, Block replace) {
        Block old_block = this.field_70170_p.func_180495_p(pos).func_177230_c();
        this.field_70170_p.func_175656_a(pos, replace.func_176203_a(old_block.func_176201_c(this.field_70170_p.func_180495_p(pos))));
        this.spawnItem(drop, pos, 1);
    }

    private void spawnItem(Item drop, BlockPos place, int numDrop) {
        ItemEntity eyedrop = new ItemEntity(this.field_70170_p, (double)place.func_177958_n(), (double)place.func_177956_o(), (double)place.func_177952_p(), new ItemStack(drop, numDrop));
        eyedrop.field_70159_w = 0.0;
        eyedrop.field_70181_x = 0.0;
        eyedrop.field_70179_y = 0.0;
        this.field_70170_p.func_72838_d((Entity)eyedrop);
    }

    private void poisonCloud(BlockPos place) {
        for (Player target : this.field_70170_p.func_72872_a(Player.class, this.func_174813_aQ().func_72314_b(5.0, 5.0, 5.0))) {
            IMaxAttack.dealTrueDamage((Entity)this, (LivingEntity)target, target.func_110138_aP() * 0.9f);
        }
        CustomParticleConfig config1 = new CustomParticleConfig();
        config1.createInstance().setParticle(ParticleInit.POISON_BUBBLE).setSpread(4.0, 1.0, 4.0).setCount(10).setIgnoreRange(true);
        IParticleSpawner.spawnParticle(this.field_70170_p, config1, (double)place.func_177958_n(), (double)place.func_177956_o(), (double)place.func_177952_p());
    }

    protected float func_70185_h() {
        return 0.05f;
    }
}

