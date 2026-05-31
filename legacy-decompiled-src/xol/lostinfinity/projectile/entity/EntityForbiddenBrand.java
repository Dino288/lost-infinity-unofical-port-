/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.world.World
 */
package xol.lostinfinity.projectile.entity;

import java.util.UUID;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.util.data.CustomDamageResult;
import xol.lostinfinity.util.data.IMaxAttack;

public class EntityForbiddenBrand
extends Entity
implements IMaxAttack {
    private Player creator = null;
    private LivingEntity target = null;
    private float rotation = 0.0f;
    private UUID targetID = null;

    public EntityForbiddenBrand(Level worldIn) {
        super(worldIn);
    }

    public void func_70071_h_() {
        super.func_70071_h_();
        if (!this.field_70170_p.field_72995_K) {
            if (this.targetID != null) {
                this.target = this.field_70170_p.func_152378_a(this.targetID);
                this.targetID = null;
            }
            if (this.creator == null || this.target == null) {
                if (this.field_70173_aa > 5) {
                    this.func_70106_y();
                }
            } else {
                CustomDamageResult dr;
                if (this.field_70173_aa % 3 == 0) {
                    this.func_70634_a(this.target.field_70165_t, this.target.field_70163_u + (double)(this.target.field_70131_O / 2.0f), this.target.field_70161_v);
                }
                if (this.field_70173_aa % 10 == 0 && (dr = IMaxAttack.dealMaxHealth((Entity)this.creator, this.target, 3)).wasTargetKilled() && this.target instanceof Player) {
                    this.targetID = this.target.func_110124_au();
                }
                if (this.field_70173_aa % 20 == 0) {
                    this.func_184185_a(SoundInit.GENERIC_WEAPON_12, 1.0f, 0.8f + this.field_70146_Z.nextFloat() * 0.4f);
                }
            }
            if (this.field_70173_aa >= 800) {
                this.func_70106_y();
            }
        } else {
            float growthDist = 8.0f;
            this.rotation += 0.15f;
            double velocity_x = (double)growthDist * Math.cos(this.rotation);
            double velocity_z = (double)growthDist * Math.sin(this.rotation);
            for (int i = 0; i < 3; ++i) {
                if (this.field_70173_aa % 80 < 40) {
                    this.field_70170_p.func_175688_a(ParticleInit.BLIGHT_SPELL_PINK, this.field_70165_t + velocity_x / 2.0, this.field_70163_u, this.field_70161_v + velocity_z / 2.0, 0.0, 0.0, 0.0, new int[0]);
                    continue;
                }
                this.field_70170_p.func_175688_a(ParticleInit.BLIGHT_SPELL_GREEN, this.field_70165_t + velocity_x / 2.0, this.field_70163_u, this.field_70161_v + velocity_z / 2.0, 0.0, 0.0, 0.0, new int[0]);
            }
        }
    }

    public void setTarget(LivingEntity target) {
        this.target = target;
    }

    public void setCreator(Player creator) {
        this.creator = creator;
    }

    protected void func_70037_a(CompoundTag compound) {
    }

    protected void func_70014_b(CompoundTag compound) {
    }

    protected void func_70088_a() {
    }
}

