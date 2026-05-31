/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.sea;

import net.minecraft.sounds.SoundSource;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.entity.sea.EntitySeaCreature;

public class EntityFish
extends EntitySeaCreature {
    BlockPos targetPos = null;
    private int timer = 0;
    private boolean fed = false;
    private int recentFood = 0;

    public EntityFish(Level worldIn) {
        super(worldIn);
    }

    public void setTargetPos(BlockPos pos) {
        this.targetPos = pos;
        this.recentFood = 120;
    }

    @Override
    public void func_70636_d() {
        block3: {
            block4: {
                super.func_70636_d();
                if (this.field_70170_p.field_72995_K) break block3;
                --this.recentFood;
                if (!this.fed) break block4;
                ++this.timer;
                if (this.timer < 400) break block3;
                this.func_145779_a(ItemInit.organicShadowMatter, 1);
                this.fed = false;
                this.targetPos = null;
                this.timer = 0;
                break block3;
            }
            if (this.targetPos != null && this.recentFood > 0) {
                this.func_70605_aq().func_75642_a((double)this.targetPos.func_177958_n(), (double)this.targetPos.func_177956_o(), (double)this.targetPos.func_177952_p(), 2.0);
            }
            if (this.field_70173_aa % 20 == 19 && this.recentFood > 0) {
                int radius = 3;
                for (BlockPos check : BlockPos.func_177980_a((BlockPos)this.func_180425_c().func_177982_a(-radius, -radius, -radius), (BlockPos)this.func_180425_c().func_177982_a(radius, radius, radius))) {
                    if (!this.field_70170_p.func_180495_p(check).func_177230_c().equals(BlockInit.fishChow)) continue;
                    this.field_70170_p.func_175698_g(check);
                    this.targetPos = null;
                    this.fed = true;
                    this.field_70170_p.func_184133_a(null, this.func_180425_c(), SoundInit.FISH_EAT, SoundSource.HOSTILE, 1.5f, 1.0f);
                    break;
                }
            }
        }
    }
}

