/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.monster.Monster
 *  net.minecraft.entity.player.Player
 *  net.minecraft.network.datasync.DataParameter
 *  net.minecraft.network.datasync.DataSerializer
 *  net.minecraft.network.datasync.DataSerializers
 *  net.minecraft.network.datasync.EntityDataManager
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.world.EnumDifficulty
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.starforge;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializer;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.Difficulty;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.load.LootTableRegistry;

public class EntityGrappler
extends Monster
implements IMaxAttack {
    private static final DataParameter<Integer> MOVE_STYLE = EntityDataManager.func_187226_a(EntityGrappler.class, (DataSerializer)DataSerializers.field_187192_b);

    public EntityGrappler(Level worldIn) {
        super(worldIn);
        this.func_70105_a(1.7f, 2.2f);
        this.func_189654_d(true);
        this.field_70178_ae = true;
    }

    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a(MOVE_STYLE, (Object)0);
    }

    public int getMoveStyle() {
        return (Integer)this.field_70180_af.func_187225_a(MOVE_STYLE);
    }

    public void setMoveStyle(int f) {
        this.field_70180_af.func_187227_b(MOVE_STYLE, (Object)f);
    }

    private void randomizeMovement() {
        int style = this.getMoveStyle();
        boolean run = true;
        int new_style = 0;
        while (run) {
            new_style = this.field_70146_Z.nextInt(6);
            if (new_style == style) continue;
            run = false;
        }
        this.setMoveStyle(new_style);
    }

    protected void func_184651_r() {
    }

    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(1200.0);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(1.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.0);
        this.func_110148_a(SharedMonsterAttributes.field_111266_c).func_111128_a(1.0);
    }

    protected void func_82167_n(Entity entityIn) {
        Player play;
        if (entityIn instanceof Player && !(play = (Player)entityIn).func_184812_l_()) {
            IMaxAttack.dealMaxHealth((Entity)this, (LivingEntity)play, 3, 2.0f);
        }
        entityIn.func_70108_f((Entity)this);
    }

    public void func_70636_d() {
        super.func_70636_d();
        this.field_70143_R = -1.0f;
        if (!this.field_70170_p.field_72995_K && this.field_70173_aa % 120 == 0) {
            this.randomizeMovement();
            this.func_184185_a(SoundInit.STARFORGE_GRAPPLER_AMBIENT, 2.0f, 1.0f);
        }
        switch (this.getMoveStyle()) {
            case 0: {
                this.field_70181_x = 0.25;
                this.field_70159_w *= 0.95;
                this.field_70179_y *= 0.95;
                break;
            }
            case 1: {
                this.field_70181_x = -0.25;
                this.field_70159_w *= 0.95;
                this.field_70179_y *= 0.95;
                break;
            }
            case 2: {
                this.field_70159_w = 0.25;
                this.field_70181_x *= 0.95;
                this.field_70179_y *= 0.95;
                break;
            }
            case 3: {
                this.field_70159_w = -0.25;
                this.field_70181_x *= 0.95;
                this.field_70179_y *= 0.95;
                break;
            }
            case 4: {
                this.field_70179_y = 0.25;
                this.field_70181_x *= 0.95;
                this.field_70159_w *= 0.95;
                break;
            }
            case 5: {
                this.field_70179_y = -0.25;
                this.field_70181_x *= 0.95;
                this.field_70159_w *= 0.95;
            }
        }
    }

    protected SoundEvent func_184615_bR() {
        return SoundInit.STARFORGE_GRAPPLER_DEATH;
    }

    protected SoundEvent func_184601_bQ(DamageSource damageSourceIn) {
        return SoundInit.STARFORGE_GRAPPLER_HURT;
    }

    protected SoundEvent func_184639_G() {
        return null;
    }

    protected ResourceLocation func_184647_J() {
        return LootTableRegistry.ENTITIES_STARFORGE_GRAPPLER;
    }

    protected boolean func_70692_ba() {
        return false;
    }

    public boolean func_70814_o() {
        return true;
    }

    public int func_70641_bl() {
        return 1;
    }

    public boolean func_70601_bi() {
        return this.field_70170_p.func_175659_aa() != EnumDifficulty.PEACEFUL;
    }
}

