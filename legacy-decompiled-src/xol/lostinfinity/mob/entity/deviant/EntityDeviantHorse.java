/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.monster.Monster
 *  net.minecraft.entity.player.Player
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.deviant;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.mob.entity.base.EntityDeviantMob;
import xol.lostinfinity.util.data.CustomParticleConfig;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.fx.IParticleSpawner;
import xol.lostinfinity.util.load.LootTableRegistry;

public class EntityDeviantHorse
extends EntityDeviantMob
implements IMaxAttack {
    public EntityDeviantHorse(Level worldIn) {
        super(worldIn);
        this.func_70105_a(2.3f, 3.5f);
    }

    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(1.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.3);
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(1200.0);
    }

    public boolean func_70652_k(Entity entity) {
        super.func_70652_k(entity);
        if (this.func_70638_az() != null) {
            IMaxAttack.dealMaxHealth((Entity)this, this.func_70638_az(), 4 - this.getMutation());
            return true;
        }
        return false;
    }

    public void func_70636_d() {
        if (!this.field_70170_p.field_72995_K && this.field_70173_aa % (120 - this.getMutation() * 20) == 0) {
            Player nearest = null;
            float neardist = 9999.0f;
            for (Player near_pl : this.field_70170_p.func_72872_a(Player.class, this.func_174813_aQ().func_186662_g(25.0))) {
                float checkdist = near_pl.func_70032_d((Entity)this);
                if (!(checkdist < neardist)) continue;
                nearest = near_pl;
                neardist = checkdist;
            }
            if (nearest != null) {
                this.func_184185_a(SoundEvents.field_187936_hj, 1.0f, 0.8f + 0.4f * this.field_70146_Z.nextFloat());
                for (Monster near_mob : this.field_70170_p.func_72872_a(Monster.class, this.func_174813_aQ().func_186662_g(25.0))) {
                    if (!(near_mob.func_70032_d((Entity)nearest) > 3.0f)) continue;
                    near_mob.func_70634_a(nearest.field_70165_t, nearest.field_70163_u, nearest.field_70161_v);
                    near_mob.func_70624_b((LivingEntity)nearest);
                    CustomParticleConfig config1 = new CustomParticleConfig();
                    config1.createInstance().setParticle(ParticleInit.MIASMA).setSpread(3.0, 1.0, 3.0).setCount(5).setIgnoreRange(true);
                    IParticleSpawner.spawnParticle(this.field_70170_p, config1, near_mob.field_70165_t, near_mob.field_70163_u + (double)(near_mob.field_70131_O / 2.0f), near_mob.field_70161_v);
                }
            }
        }
        super.func_70636_d();
    }

    protected SoundEvent func_184615_bR() {
        return SoundEvents.field_187708_co;
    }

    protected SoundEvent func_184601_bQ(DamageSource damageSourceIn) {
        return SoundEvents.field_187717_cr;
    }

    protected SoundEvent func_184639_G() {
        return SoundEvents.field_187696_ck;
    }

    @Override
    protected ResourceLocation deviantDrop() {
        return LootTableRegistry.ENTITIES_DEVIANTHORSE;
    }

    @Override
    protected ResourceLocation superMutatedDrop() {
        return LootTableRegistry.ENTITIES_SUPERMUTANT_HORSE;
    }
}

