/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.Item
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.util.math.Vec3
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.deviant.prime;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.entity.base.EntityDeviantPrime;
import xol.lostinfinity.util.data.IMaxAttack;

public class EntityAzross
extends EntityDeviantPrime
implements IMaxAttack {
    private LivingEntity marked = null;
    private int markedTimer = 0;

    public EntityAzross(Level worldIn) {
        super(worldIn);
        this.func_70105_a(1.75f, 2.9f);
    }

    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(1.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.32);
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(2000.0);
    }

    public boolean func_70652_k(Entity entity) {
        super.func_70652_k(entity);
        if (this.func_70638_az() != null) {
            boolean killed = IMaxAttack.dealMaxHealth((Entity)this, this.func_70638_az(), 3).wasTargetKilled();
            Vec3 lookMulti = this.func_70040_Z();
            this.func_70638_az().func_70024_g(lookMulti.field_72450_a * 5.0, 0.25, lookMulti.field_72449_c * 5.0);
            this.func_70638_az().field_70133_I = true;
            if (killed && this.func_70638_az() instanceof Player) {
                this.func_70106_y();
            }
            return true;
        }
        return false;
    }

    public void func_70636_d() {
        super.func_70636_d();
        this.field_70143_R = -1.0f;
        if (!this.field_70170_p.field_72995_K) {
            LivingEntity target = this.func_70638_az();
            if (target != null && this.field_70173_aa % 60 == 0) {
                this.func_70024_g((target.field_70165_t - this.field_70165_t) * 0.145, (target.field_70163_u - this.field_70163_u) * 0.145, (target.field_70161_v - this.field_70161_v) * 0.145);
                this.field_70133_I = true;
                this.marked = target;
            }
            if (this.marked != null) {
                if (this.markedTimer == 15) {
                    this.func_70634_a(this.marked.field_70165_t, this.marked.field_70163_u, this.marked.field_70161_v);
                } else {
                    ++this.markedTimer;
                }
            } else {
                this.markedTimer = 0;
            }
        }
    }

    protected SoundEvent func_184615_bR() {
        return SoundInit.GENERIC_STYLE1_DEATH;
    }

    protected SoundEvent func_184601_bQ(DamageSource damageSourceIn) {
        return SoundInit.GENERIC_STYLE1_HURT;
    }

    protected SoundEvent func_184639_G() {
        return null;
    }

    @Override
    protected String primeName() {
        return "Azross";
    }

    @Override
    protected Item primeDrop() {
        return ItemInit.deviantFragmentTR;
    }
}

