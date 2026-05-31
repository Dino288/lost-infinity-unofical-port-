/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.PathfinderMob
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.network.datasync.DataParameter
 *  net.minecraft.network.datasync.DataSerializer
 *  net.minecraft.network.datasync.DataSerializers
 *  net.minecraft.network.datasync.EntityDataManager
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.starforge;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializer;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.ai.IBasicAI;
import xol.lostinfinity.mob.entity.base.EntityMultipleLives;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.load.LootTableRegistry;

public class EntityMinimite
extends EntityMultipleLives
implements IMaxAttack,
IBasicAI {
    private boolean growing = false;
    private float creatureScale = 0.75f;
    private static final DataParameter<Boolean> ATTACKING = EntityDataManager.func_187226_a(EntityMinimite.class, (DataSerializer)DataSerializers.field_187198_h);

    public EntityMinimite(Level worldIn) {
        super(worldIn);
        this.func_70105_a(1.25f, 1.0f);
    }

    @Override
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a(ATTACKING, (Object)false);
    }

    public boolean getAngry() {
        return (Boolean)this.field_70180_af.func_187225_a(ATTACKING);
    }

    public void setAngry(boolean f) {
        this.field_70180_af.func_187227_b(ATTACKING, (Object)f);
    }

    @Override
    protected void func_184651_r() {
        this.initBasicTasks((PathfinderMob)this);
    }

    public boolean isGrowing() {
        return this.growing;
    }

    public float myScale() {
        return this.creatureScale;
    }

    public boolean func_70652_k(Entity entity) {
        super.func_70652_k(entity);
        if (this.func_70638_az() != null) {
            IMaxAttack.dealMaxHealth((Entity)this, this.func_70638_az(), 2);
            return true;
        }
        return false;
    }

    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(1500.0);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(1.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.23);
        this.func_110148_a(SharedMonsterAttributes.field_111266_c).func_111128_a(1.0);
    }

    @Override
    protected int numberOfLives() {
        return 8;
    }

    public void func_70636_d() {
        super.func_70636_d();
        if (!this.field_70170_p.field_72995_K) {
            boolean shouldBeAngry = this.func_70638_az() != null;
            this.setAngry(shouldBeAngry);
            if (shouldBeAngry) {
                if (this.creatureScale < 3.0f) {
                    this.creatureScale += 0.125f;
                    this.func_70105_a(1.6f * this.creatureScale, 1.3f * this.creatureScale);
                }
            } else if (this.creatureScale > 0.75f) {
                this.creatureScale -= 0.75f;
                this.func_70105_a(1.6f * this.creatureScale, 1.3f * this.creatureScale);
            }
        } else {
            boolean angry = this.getAngry();
            if (angry) {
                if (this.creatureScale < 3.0f) {
                    this.creatureScale += 0.125f;
                    this.func_70105_a(1.6f * this.creatureScale, 1.3f * this.creatureScale);
                    this.growing = true;
                } else {
                    this.growing = false;
                }
            } else {
                this.growing = false;
                if (this.creatureScale > 0.75f) {
                    this.creatureScale -= 0.125f;
                    this.func_70105_a(1.6f * this.creatureScale, 1.3f * this.creatureScale);
                }
            }
        }
    }

    protected SoundEvent func_184615_bR() {
        return SoundInit.MINIMITE_DEATH;
    }

    protected SoundEvent func_184601_bQ(DamageSource damageSourceIn) {
        return SoundInit.MINIMITE_HURT;
    }

    protected SoundEvent func_184639_G() {
        return SoundInit.MINIMITE_AMBIENT;
    }

    protected boolean func_70692_ba() {
        return false;
    }

    protected ResourceLocation func_184647_J() {
        return LootTableRegistry.ENTITIES_MINIMITE;
    }
}

