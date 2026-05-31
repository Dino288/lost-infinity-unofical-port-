/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.init.Items
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.item.Item
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.deviant;

import net.minecraft.world.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.item.Items;
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

public class EntityDeviantZombie
extends EntityDeviantMob
implements IMaxAttack {
    private boolean isSummoner = true;

    public EntityDeviantZombie(Level worldIn) {
        super(worldIn);
        this.func_70105_a(2.0f, 3.0f);
    }

    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(0.5);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.43200000000000005);
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(400.0);
    }

    public boolean func_70652_k(Entity entity) {
        super.func_70652_k(entity);
        if (this.func_70638_az() != null) {
            IMaxAttack.dealMaxHealth((Entity)this, this.func_70638_az(), 7 - this.getMutation());
            return true;
        }
        return false;
    }

    @Override
    protected Item playerInput() {
        return Items.field_151055_y;
    }

    @Override
    protected Item mutantOutput() {
        return ItemInit.pluckedEye;
    }

    public void setNotSummoner() {
        this.isSummoner = false;
    }

    public boolean isSummoner() {
        return this.isSummoner;
    }

    public void func_70636_d() {
        super.func_70636_d();
        this.field_70143_R = -1.0f;
        if (!this.field_70170_p.field_72995_K && this.field_70173_aa % (40 - this.getMutation() * 6) == 0 && this.isSummoner && this.func_70638_az() != null) {
            EntityDeviantZombie zombie = new EntityDeviantZombie(this.field_70170_p);
            zombie.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
            zombie.field_70181_x = 0.3;
            zombie.setNotSummoner();
            zombie.setMutation(this.getMutation());
            this.field_70170_p.func_72838_d((Entity)zombie);
        }
    }

    protected SoundEvent func_184615_bR() {
        return SoundEvents.field_187930_hd;
    }

    protected SoundEvent func_184601_bQ(DamageSource damageSourceIn) {
        return SoundEvents.field_187934_hh;
    }

    protected SoundEvent func_184639_G() {
        return SoundEvents.field_187899_gZ;
    }

    @Override
    protected ResourceLocation deviantDrop() {
        return LootTableRegistry.ENTITIES_DEVIANTZOMBIE;
    }

    @Override
    protected ResourceLocation superMutatedDrop() {
        return LootTableRegistry.ENTITIES_SUPERMUTANT_ZOMBIE;
    }
}

