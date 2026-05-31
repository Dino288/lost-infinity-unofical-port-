/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.HitResult
 *  net.minecraft.util.math.HitResult$Type
 *  net.minecraft.world.World
 */
package xol.lostinfinity.projectile.entity;

import java.util.Iterator;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.sounds.SoundSource;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.level.Level;
import xol.lostinfinity.block.misc.BlockInkable;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.entity.contest.controller.EntityControllerInkBattle;
import xol.lostinfinity.projectile.entity.EntityBaseThrowable;
import xol.lostinfinity.util.coordinates.ContestCoordinates;

public class EntityInkBomb
extends EntityBaseThrowable {
    public EntityInkBomb(Level par1World) {
        super(par1World);
        this.func_70105_a(0.75f, 0.75f);
    }

    public EntityInkBomb(Level par1World, LivingEntity par2Mob) {
        super(par1World, par2Mob);
        this.func_70105_a(0.75f, 0.75f);
    }

    public EntityInkBomb(Level par1World, double par2, double par4, double par6) {
        super(par1World, par2, par4, par6);
        this.func_70105_a(0.75f, 0.75f);
    }

    @Override
    protected void func_70184_a(HitResult result) {
        if (!this.field_70170_p.field_72995_K) {
            Iterator iterator;
            if (result.field_72313_a == HitResult.Type.BLOCK) {
                if (this.field_70192_c != null) {
                    Iterator iterator2;
                    BlockPos pos = result.func_178782_a();
                    int radius = 6;
                    if (this.field_70170_p.func_180495_p(pos).func_177230_c() instanceof BlockInkable && (iterator2 = this.field_70170_p.func_72872_a(EntityControllerInkBattle.class, ContestCoordinates.inkBattleControllerAABB()).iterator()).hasNext()) {
                        EntityControllerInkBattle controller = (EntityControllerInkBattle)((Object)iterator2.next());
                        for (BlockPos nearPos : BlockPos.func_177980_a((BlockPos)pos.func_177982_a(-radius, -radius, -radius), (BlockPos)pos.func_177982_a(radius, radius, radius))) {
                            controller.inkBlock(this.field_70192_c.func_110124_au(), nearPos);
                        }
                    }
                    this.field_70170_p.func_184133_a(null, this.func_180425_c(), SoundInit.MAGIC_WEAPON_7, SoundSource.PLAYERS, 0.7f, 0.7f + this.field_70170_p.field_73012_v.nextFloat() * 0.6f);
                }
            } else if (result.field_72308_g != null && result.field_72308_g instanceof Player && (iterator = this.field_70170_p.func_72872_a(EntityControllerInkBattle.class, ContestCoordinates.inkBattleControllerAABB()).iterator()).hasNext()) {
                EntityControllerInkBattle controller = (EntityControllerInkBattle)((Object)iterator.next());
                controller.inkPlayer((Player)result.field_72308_g);
            }
            this.func_70106_y();
        }
    }

    protected float func_70185_h() {
        return 0.08f;
    }
}

