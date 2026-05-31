/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.Mob
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.item.Item
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.world.EnumDifficulty
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.deviant;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.Item;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.Difficulty;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.mob.ai.EntityAIFloatAttack;
import xol.lostinfinity.mob.entity.base.EntityFloatingDeviant;
import xol.lostinfinity.projectile.entity.EntityEchoBlast;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.load.LootTableRegistry;

public class EntityDeviantBat
extends EntityFloatingDeviant
implements IMaxAttack {
    public EntityDeviantBat(Level worldIn) {
        super(worldIn);
        this.func_70105_a(1.6f, 1.8f);
    }

    @Override
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
        return ItemInit.heavyCrystal;
    }

    @Override
    protected Item mutantOutput() {
        return ItemInit.nightglazedCrystal;
    }

    @Override
    public void func_70636_d() {
        super.func_70636_d();
        if (!this.field_70170_p.field_72995_K && this.func_70638_az() != null) {
            LivingEntity target = this.func_70638_az();
            this.func_70605_aq().func_75642_a(target.field_70165_t, target.field_70163_u, target.field_70161_v, 1.0);
        }
    }

    protected SoundEvent func_184615_bR() {
        return SoundEvents.field_187742_x;
    }

    protected SoundEvent func_184601_bQ(DamageSource damageSourceIn) {
        return SoundEvents.field_187743_y;
    }

    protected SoundEvent func_184639_G() {
        return SoundEvents.field_187740_w;
    }

    @Override
    protected boolean func_70692_ba() {
        int time = (int)(this.field_70170_p.func_72820_D() % 24000L);
        return time > 13000 && time < 18000;
    }

    @Override
    public boolean func_70814_o() {
        return true;
    }

    @Override
    public int func_70641_bl() {
        return 1;
    }

    @Override
    public boolean func_70601_bi() {
        return this.field_70170_p.func_175659_aa() != EnumDifficulty.PEACEFUL;
    }

    @Override
    protected ResourceLocation deviantDrop() {
        return LootTableRegistry.ENTITIES_DEVIANTBAT;
    }

    @Override
    protected ResourceLocation superMutatedDrop() {
        return LootTableRegistry.ENTITIES_SUPERMUTANT_BAT;
    }

    @Override
    protected EntityAIFloatAttack createShootAI() {
        return new EntityAIFloatAttack((Mob)this, (world1, parent, x, y, z, fireballStrength) -> new EntityEchoBlast(this.field_70170_p, parent, x, y, z, 5.0f, 2 + 2 * this.getMutation()), SoundEvents.field_187744_z, 20);
    }
}

