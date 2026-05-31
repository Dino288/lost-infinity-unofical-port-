/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Mob
 *  net.minecraft.entity.player.Player
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.util.SoundSource
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.misc;

import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.potion.PotionEffect;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.PotionInit;
import xol.lostinfinity.init.SoundInit;

public class EntityTotemSplitter
extends Mob {
    private Player owner = null;

    public EntityTotemSplitter(Level worldIn) {
        super(worldIn);
        this.func_70105_a(1.0f, 1.0f);
        this.func_184224_h(true);
    }

    public void setOwner(Player play) {
        this.owner = play;
    }

    public void func_70636_d() {
        super.func_70636_d();
        this.field_70143_R = -1.0f;
        if (!this.field_70170_p.field_72995_K) {
            if (this.owner != null) {
                if (this.field_70173_aa % 4 == 0) {
                    for (Player near_pl : this.field_70170_p.func_72872_a(Player.class, this.func_174813_aQ().func_186662_g(20.0))) {
                        if (near_pl.func_184812_l_() || near_pl.equals((Object)this.owner)) continue;
                        near_pl.func_70690_d(new PotionEffect(PotionInit.ULTRAHEAVY, 10, 2));
                        near_pl.func_70690_d(new PotionEffect(PotionInit.INTANGIBLE, 10));
                        near_pl.func_70690_d(new PotionEffect(PotionInit.PHASED, 10));
                    }
                }
                if (this.field_70173_aa % 40 == 0) {
                    this.field_70170_p.func_184133_a(null, this.func_180425_c(), SoundInit.INFUSER, SoundSource.BLOCKS, 1.5f, 0.5f + this.field_70170_p.field_73012_v.nextFloat());
                }
                if (this.field_70173_aa > 400) {
                    this.func_70106_y();
                }
            } else {
                this.func_70106_y();
            }
        }
    }
}

