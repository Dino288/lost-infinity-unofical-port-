/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.item.ItemEntity
 *  net.minecraft.entity.monster.Monster
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.ItemStack
 *  net.minecraft.network.datasync.DataParameter
 *  net.minecraft.network.datasync.DataSerializer
 *  net.minecraft.network.datasync.DataSerializers
 *  net.minecraft.network.datasync.EntityDataManager
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.EnumDifficulty
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.starforge;

import java.util.Iterator;
import net.minecraft.world.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializer;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.core.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.util.data.CustomParticleConfig;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.fx.IParticleSpawner;

public class EntityWisp
extends Monster
implements IMaxAttack {
    private static final DataParameter<Float> GMOVE_X = EntityDataManager.func_187226_a(EntityWisp.class, (DataSerializer)DataSerializers.field_187193_c);
    private static final DataParameter<Float> GMOVE_Y = EntityDataManager.func_187226_a(EntityWisp.class, (DataSerializer)DataSerializers.field_187193_c);
    private static final DataParameter<Float> GMOVE_Z = EntityDataManager.func_187226_a(EntityWisp.class, (DataSerializer)DataSerializers.field_187193_c);

    public EntityWisp(Level worldIn) {
        super(worldIn);
        this.func_70105_a(0.75f, 0.75f);
        this.func_189654_d(true);
    }

    protected void func_184651_r() {
    }

    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a(GMOVE_X, (Object)Float.valueOf(0.0f));
        this.field_70180_af.func_187214_a(GMOVE_Y, (Object)Float.valueOf(0.0f));
        this.field_70180_af.func_187214_a(GMOVE_Z, (Object)Float.valueOf(0.0f));
    }

    public float getXMovement() {
        return ((Float)this.field_70180_af.func_187225_a(GMOVE_X)).floatValue();
    }

    public float getYMovement() {
        return ((Float)this.field_70180_af.func_187225_a(GMOVE_Y)).floatValue();
    }

    public float getZMovement() {
        return ((Float)this.field_70180_af.func_187225_a(GMOVE_Z)).floatValue();
    }

    private void randomizeMovement() {
        float xrand = (-1.0f + 2.0f * this.field_70146_Z.nextFloat()) * 0.04f;
        float yrand = (-1.0f + 2.0f * this.field_70146_Z.nextFloat()) * 0.04f;
        float zrand = (-1.0f + 2.0f * this.field_70146_Z.nextFloat()) * 0.04f;
        this.field_70180_af.func_187227_b(GMOVE_X, (Object)Float.valueOf(xrand));
        this.field_70180_af.func_187227_b(GMOVE_Y, (Object)Float.valueOf(yrand));
        this.field_70180_af.func_187227_b(GMOVE_Z, (Object)Float.valueOf(zrand));
    }

    public void func_70636_d() {
        super.func_70636_d();
        this.field_70143_R = -1.0f;
        if (!this.field_70170_p.field_72995_K && this.field_70173_aa % 60 == 3) {
            Player near_pl;
            boolean found = false;
            Iterator iterator = this.field_70170_p.func_72872_a(Player.class, this.func_174813_aQ().func_72314_b(15.0, 15.0, 15.0)).iterator();
            if (iterator.hasNext() && (near_pl = (Player)iterator.next()).func_184614_ca().func_77973_b() == ItemInit.beaconOfLight) {
                found = true;
                float xmove = (float)((near_pl.field_70165_t - this.field_70165_t) * (double)0.02f);
                float ymove = (float)((near_pl.field_70163_u - this.field_70163_u) * (double)0.02f);
                float zmove = (float)((near_pl.field_70161_v - this.field_70161_v) * (double)0.02f);
                this.field_70180_af.func_187227_b(GMOVE_X, (Object)Float.valueOf(xmove));
                this.field_70180_af.func_187227_b(GMOVE_Y, (Object)Float.valueOf(ymove));
                this.field_70180_af.func_187227_b(GMOVE_Z, (Object)Float.valueOf(zmove));
            }
            if (!found) {
                this.randomizeMovement();
            }
        }
        this.field_70159_w = this.getXMovement();
        this.field_70181_x = this.getYMovement();
        this.field_70179_y = this.getZMovement();
    }

    public boolean func_184645_a(Player player, InteractionHand hand) {
        if (!this.field_70170_p.field_72995_K) {
            boolean foundLeaves = false;
            Iterable nearblocks = BlockPos.func_177980_a((BlockPos)this.func_180425_c().func_177982_a(-6, -6, -6), (BlockPos)this.func_180425_c().func_177982_a(6, 6, 6));
            for (BlockPos pos : nearblocks) {
                if (this.field_70170_p.func_180495_p(pos).func_177230_c() != BlockInit.leavesRebirth) continue;
                foundLeaves = true;
                break;
            }
            if (foundLeaves) {
                ItemEntity heart = new ItemEntity(this.field_70170_p, this.field_70165_t, this.field_70163_u, this.field_70161_v, new ItemStack(ItemInit.branchOfEnergy));
                heart.field_70159_w = 0.0;
                heart.field_70181_x = 0.0;
                heart.field_70179_y = 0.0;
                this.field_70170_p.func_72838_d((Entity)heart);
                this.func_70106_y();
                this.func_184185_a(SoundInit.LIGHT_MAGIC, 1.0f, 1.0f + this.field_70146_Z.nextFloat() * 0.3f);
                CustomParticleConfig config1 = new CustomParticleConfig();
                config1.createInstance().setParticle(ParticleInit.CRYSTAL_MAGIC).setSpread(4.0, 1.0, 4.0).setCount(10).setIgnoreRange(true);
                IParticleSpawner.spawnParticle(this.field_70170_p, config1, this.field_70165_t, this.field_70163_u + (double)(this.field_70131_O / 2.0f), this.field_70161_v);
            }
        }
        return true;
    }

    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(1000.0);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(1.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.25);
        this.func_110148_a(SharedMonsterAttributes.field_111266_c).func_111128_a(1.0);
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

    protected SoundEvent func_184615_bR() {
        return SoundInit.WISP_DEATH;
    }

    protected SoundEvent func_184601_bQ(DamageSource damageSourceIn) {
        return SoundInit.WISP_HURT;
    }

    protected SoundEvent func_184639_G() {
        return SoundInit.WISP_AMBIENT;
    }
}

