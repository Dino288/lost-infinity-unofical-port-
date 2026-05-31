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
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.load.LootTableRegistry;

public class EntityDeviantOcelote
extends EntityDeviantMob
implements IMaxAttack {
    public EntityDeviantOcelote(Level worldIn) {
        super(worldIn);
        this.func_70105_a(1.6f, 1.5f);
    }

    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(0.5);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.43200000000000005);
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(1500.0);
    }

    public boolean func_70652_k(Entity entity) {
        super.func_70652_k(entity);
        if (this.func_70638_az() != null) {
            IMaxAttack.dealTrueDamage((Entity)this, this.func_70638_az(), this.func_70638_az().func_110138_aP() * (0.5f + 0.25f * (float)this.getMutation()));
            return true;
        }
        return false;
    }

    public void func_70636_d() {
        super.func_70636_d();
        this.field_70143_R = -1.0f;
        if (this.field_70173_aa % (40 - 5 * this.getMutation()) == 0 && this.func_70638_az() != null && this.func_70638_az() instanceof Player) {
            Player pl = (Player)this.func_70638_az();
            this.func_70024_g((pl.field_70165_t - this.field_70165_t) * 0.145, 1.0, (pl.field_70161_v - this.field_70161_v) * 0.145);
            this.field_70133_I = true;
        }
    }

    protected SoundEvent func_184615_bR() {
        return SoundEvents.field_187639_P;
    }

    protected SoundEvent func_184601_bQ(DamageSource damageSourceIn) {
        return SoundEvents.field_187642_Q;
    }

    protected SoundEvent func_184639_G() {
        return SoundEvents.field_187636_O;
    }

    @Override
    protected ResourceLocation deviantDrop() {
        return LootTableRegistry.ENTITIES_DEVIANTOCELOTE;
    }

    @Override
    protected ResourceLocation superMutatedDrop() {
        return LootTableRegistry.ENTITIES_SUPERMUTANT_OCELOTE;
    }
}

