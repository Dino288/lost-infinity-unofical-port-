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
package xol.lostinfinity.mob.entity.deviant.titan;

import net.minecraft.world.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.Level;
import xol.lostinfinity.mob.entity.base.EntityDeviantTitan;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.load.LootTableRegistry;

public class EntityTitanSpider
extends EntityDeviantTitan
implements IMaxAttack {
    public EntityTitanSpider(Level worldIn) {
        super(worldIn);
        this.func_70105_a(7.0f, 4.5f);
    }

    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(0.5);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.43200000000000005);
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(3000.0);
    }

    public boolean func_70652_k(Entity entity) {
        super.func_70652_k(entity);
        if (this.func_70638_az() != null) {
            IMaxAttack.dealMaxHealth((Entity)this, this.func_70638_az(), 3);
            return true;
        }
        return false;
    }

    public void func_70636_d() {
        super.func_70636_d();
        this.field_70143_R = -1.0f;
        if (this.field_70173_aa % 60 == 0 && this.func_70638_az() != null && this.func_70638_az() instanceof Player) {
            Player pl = (Player)this.func_70638_az();
            this.func_70024_g((pl.field_70165_t - this.field_70165_t) * 0.22, 1.0, (pl.field_70161_v - this.field_70161_v) * 0.22);
            this.field_70133_I = true;
        }
    }

    protected SoundEvent func_184615_bR() {
        return SoundEvents.field_187819_fL;
    }

    protected SoundEvent func_184601_bQ(DamageSource damageSourceIn) {
        return SoundEvents.field_187821_fM;
    }

    protected SoundEvent func_184639_G() {
        return SoundEvents.field_187817_fK;
    }

    protected ResourceLocation func_184647_J() {
        return this.onFinalLife() ? LootTableRegistry.ENTITIES_TITAN_SPIDER : null;
    }
}

