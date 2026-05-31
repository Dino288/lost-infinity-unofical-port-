/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.cthulhu;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.init.PotionInit;
import xol.lostinfinity.mob.entity.cthulhu.EntityCthulhu;
import xol.lostinfinity.mob.entity.cthulhu.ICthulhuMinion;
import xol.lostinfinity.mob.entity.misc.EntityBaseRift;
import xol.lostinfinity.util.data.IMaxAttack;

public class EntityCthulhuRift
extends EntityBaseRift
implements IMaxAttack,
ICthulhuMinion {
    protected EntityCthulhu owner;

    public EntityCthulhuRift(Level worldIn) {
        super(worldIn);
    }

    @Override
    public void func_70636_d() {
        super.func_70636_d();
        this.field_70159_w = 0.0;
        this.field_70181_x = 0.0;
        this.field_70179_y = 0.0;
        if (!this.field_70170_p.field_72995_K) {
            if (this.field_70173_aa % 10 == 0) {
                for (Player near_pl : this.field_70170_p.func_72872_a(Player.class, this.func_174813_aQ().func_186662_g(20.0))) {
                    if (near_pl.func_184812_l_()) continue;
                    near_pl.func_70690_d(new PotionEffect(PotionInit.DIMENSIONAL_TEAR, 40, 2));
                }
            }
        } else if (this.field_70146_Z.nextInt(2) == 0) {
            this.field_70170_p.func_175682_a(this.field_70146_Z.nextBoolean() ? ParticleInit.PLASMA : ParticleInit.GLOOM_SPELL, true, this.field_70165_t + this.getROD(8), this.field_70163_u + 2.0, this.field_70161_v + this.getROD(8), 0.0, 0.0, 0.0, new int[0]);
        }
    }

    public void func_70014_b(CompoundTag tag) {
        super.func_70014_b(tag);
        this.write(tag);
    }

    public void func_70037_a(CompoundTag tag) {
        super.func_70037_a(tag);
        this.read(tag, (Entity)this);
    }

    @Override
    public void setOwner(EntityCthulhu owner) {
        this.owner = owner;
    }

    @Override
    public EntityCthulhu getOwner() {
        return this.owner;
    }
}

