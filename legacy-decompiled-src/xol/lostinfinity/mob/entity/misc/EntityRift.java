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
package xol.lostinfinity.mob.entity.misc;

import java.util.UUID;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.init.PotionInit;
import xol.lostinfinity.mob.entity.misc.EntityBaseRift;
import xol.lostinfinity.util.data.IMaxAttack;

public class EntityRift
extends EntityBaseRift
implements IMaxAttack {
    private Entity owner;

    public EntityRift(Level worldIn) {
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
                    if (near_pl.equals((Object)this.owner) || near_pl.func_184812_l_()) continue;
                    near_pl.func_70690_d(new PotionEffect(PotionInit.DIMENSIONAL_TEAR, 40, 2));
                }
            }
        } else if (this.field_70146_Z.nextInt(2) == 0) {
            this.field_70170_p.func_175682_a(ParticleInit.PLASMA, true, this.field_70165_t + this.getROD(8), this.field_70163_u + 2.0, this.field_70161_v + this.getROD(8), 0.0, 0.0, 0.0, new int[0]);
        }
    }

    public Entity getOwner() {
        return this.owner;
    }

    public void setOwner(Entity owner) {
        this.owner = owner;
    }

    public void func_70014_b(CompoundTag compound) {
        super.func_70014_b(compound);
        if (this.owner != null) {
            compound.func_74778_a("owner", this.owner.func_110124_au().toString());
        }
    }

    public void func_70037_a(CompoundTag compound) {
        super.func_70037_a(compound);
        if (compound.func_74764_b("owner")) {
            this.owner = this.field_70170_p.func_152378_a(UUID.fromString(compound.func_74779_i("owner")));
        }
    }
}

