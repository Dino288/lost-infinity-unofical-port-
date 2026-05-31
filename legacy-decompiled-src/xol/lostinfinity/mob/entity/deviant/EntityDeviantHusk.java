/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.player.Player
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.deviant;

import net.minecraft.world.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.Level;
import xol.lostinfinity.mob.entity.base.EntityDeviantMob;
import xol.lostinfinity.mob.entity.misc.EntitySandAttack;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.load.LootTableRegistry;

public class EntityDeviantHusk
extends EntityDeviantMob {
    public EntityDeviantHusk(Level worldIn) {
        super(worldIn);
        this.func_70105_a(2.0f, 3.9f);
    }

    @Override
    public boolean func_180427_aV() {
        return true;
    }

    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(1.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.22);
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(4000.0);
    }

    protected SoundEvent func_184615_bR() {
        return SoundEvents.field_190023_cJ;
    }

    protected SoundEvent func_184601_bQ(DamageSource damageSourceIn) {
        return SoundEvents.field_190024_cK;
    }

    protected SoundEvent func_184639_G() {
        return SoundEvents.field_190022_cI;
    }

    public boolean func_70652_k(Entity entity) {
        super.func_70652_k(entity);
        if (this.func_70638_az() != null) {
            IMaxAttack.dealTrueDamage((Entity)this, this.func_70638_az(), this.func_70638_az().func_110138_aP() * (0.5f + 0.2f * (float)this.getMutation()));
            return true;
        }
        return false;
    }

    public void func_70636_d() {
        super.func_70636_d();
        if (!this.field_70170_p.field_72995_K && this.field_70173_aa % (30 - this.getMutation() * 5) == 0) {
            for (Player near_pl : this.field_70170_p.func_72872_a(Player.class, this.func_174813_aQ().func_186662_g(30.0))) {
                int yOffset = 1;
                boolean canRun = true;
                while (this.field_70170_p.func_175623_d(near_pl.func_180425_c().func_177982_a(0, yOffset, 0)) && canRun) {
                    if (++yOffset != 35) continue;
                    canRun = false;
                }
                EntitySandAttack attack = new EntitySandAttack(this.field_70170_p);
                attack.func_70107_b(near_pl.field_70165_t, near_pl.field_70163_u + (double)yOffset, near_pl.field_70161_v);
                this.field_70170_p.func_72838_d((Entity)attack);
            }
        }
    }

    @Override
    protected ResourceLocation deviantDrop() {
        return LootTableRegistry.ENTITIES_DEVIANTHUSK;
    }

    @Override
    protected ResourceLocation superMutatedDrop() {
        return LootTableRegistry.ENTITIES_SUPERMUTANT_HUSK;
    }
}

