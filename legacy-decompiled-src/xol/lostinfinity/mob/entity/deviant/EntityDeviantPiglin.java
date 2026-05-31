/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.player.Player
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.item.Item
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.deviant;

import java.util.Iterator;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.Item;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.mob.entity.base.EntityDeviantMob;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.load.LootTableRegistry;

public class EntityDeviantPiglin
extends EntityDeviantMob
implements IMaxAttack {
    public EntityDeviantPiglin(Level worldIn) {
        super(worldIn);
        this.func_70105_a(2.5f, 4.2f);
    }

    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(1.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.4);
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(800.0);
    }

    public boolean func_70652_k(Entity entity) {
        super.func_70652_k(entity);
        if (this.func_70638_az() != null) {
            IMaxAttack.dealMaxHealth((Entity)this, this.func_70638_az(), 4 - this.getMutation());
            return true;
        }
        return false;
    }

    @Override
    protected Item playerInput() {
        return ItemInit.syntheticFibre;
    }

    @Override
    protected Item mutantOutput() {
        return ItemInit.elasticFibre;
    }

    public void func_70636_d() {
        super.func_70636_d();
        this.field_70143_R = -1.0f;
        if (!this.field_70170_p.field_72995_K) {
            if (this.field_70122_E && this.field_70173_aa % 60 == 10) {
                this.field_70181_x = 1.2;
            } else if (this.field_70173_aa % 60 == 30) {
                Player dashto = null;
                if (this.func_70638_az() == null || !(this.func_70638_az() instanceof Player)) {
                    Iterator iterator = this.field_70170_p.func_72872_a(Player.class, this.func_174813_aQ().func_72314_b(15.0, 15.0, 15.0)).iterator();
                    if (iterator.hasNext()) {
                        Player near_pl;
                        dashto = near_pl = (Player)iterator.next();
                        this.func_70624_b((LivingEntity)near_pl);
                    }
                } else {
                    dashto = (Player)this.func_70638_az();
                }
                if (dashto != null) {
                    this.func_70024_g((dashto.field_70165_t - this.field_70165_t) * 0.245, (dashto.field_70163_u - this.field_70163_u) * 0.145, (dashto.field_70161_v - this.field_70161_v) * 0.245);
                }
            }
        }
    }

    protected SoundEvent func_184615_bR() {
        return SoundEvents.field_187937_hk;
    }

    protected SoundEvent func_184601_bQ(DamageSource damageSourceIn) {
        return SoundEvents.field_187938_hl;
    }

    protected SoundEvent func_184639_G() {
        return SoundEvents.field_187935_hi;
    }

    @Override
    protected boolean func_70692_ba() {
        int time = (int)(this.field_70170_p.func_72820_D() % 24000L);
        return time > 13000 && time < 18000;
    }

    @Override
    protected ResourceLocation deviantDrop() {
        return LootTableRegistry.ENTITIES_DEVIANTPIGLIN;
    }

    @Override
    protected ResourceLocation superMutatedDrop() {
        return LootTableRegistry.ENTITIES_SUPERMUTANT_PIGLIN;
    }
}

