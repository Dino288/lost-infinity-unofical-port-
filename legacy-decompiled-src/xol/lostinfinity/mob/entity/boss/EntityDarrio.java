/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.player.Player
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.datasync.DataParameter
 *  net.minecraft.network.datasync.DataSerializer
 *  net.minecraft.network.datasync.DataSerializers
 *  net.minecraft.network.datasync.EntityDataManager
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.boss;

import net.minecraft.world.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializer;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.entity.base.EntityMultipleLives;
import xol.lostinfinity.mob.entity.boss.EntitySentryCrystal;
import xol.lostinfinity.stone.EntityInfinityStone;
import xol.lostinfinity.util.data.IMaxAttack;

public class EntityDarrio
extends EntityMultipleLives
implements IMaxAttack {
    private static final DataParameter<Boolean> SPINNING = EntityDataManager.func_187226_a(EntityDarrio.class, (DataSerializer)DataSerializers.field_187198_h);

    public EntityDarrio(Level worldIn) {
        super(worldIn);
        this.func_70105_a(3.5f, 5.5f);
    }

    @Override
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a(SPINNING, (Object)false);
    }

    public boolean isSpinning() {
        return (Boolean)this.field_70180_af.func_187225_a(SPINNING);
    }

    public void setSpinning(boolean f) {
        this.field_70180_af.func_187227_b(SPINNING, (Object)f);
    }

    @Override
    public void func_70014_b(CompoundTag tag) {
        super.func_70014_b(tag);
        tag.func_74757_a("SpinningAttack", this.isSpinning());
    }

    @Override
    public void func_70037_a(CompoundTag tag) {
        super.func_70037_a(tag);
        this.setSpinning(tag.func_74767_n("SpinningAttack"));
    }

    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(1.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.35);
        this.func_110148_a(SharedMonsterAttributes.field_111266_c).func_111128_a(1.0);
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(5000.0);
    }

    public boolean func_70652_k(Entity entity) {
        super.func_70652_k(entity);
        if (this.func_70638_az() != null) {
            IMaxAttack.dealMaxHealth((Entity)this, this.func_70638_az(), 3);
            return true;
        }
        return false;
    }

    private AABB getArenaAABB() {
        return new AABB(new BlockPos(-3.0, 60.0, -145.0), new BlockPos(52.0, 85.0, -40.0));
    }

    private void spawnCrystals(int count) {
        for (int crystal = 0; crystal < count; ++crystal) {
            EntitySentryCrystal crystal_spawn = new EntitySentryCrystal(this.field_70170_p);
            boolean inAir = false;
            int x_pos = 0;
            int z_pos = 0;
            while (!inAir) {
                x_pos = this.field_70146_Z.nextInt(30);
                if (!this.field_70170_p.func_175623_d(new BlockPos(0 + x_pos, 63, -140 + (z_pos = this.field_70146_Z.nextInt(80))))) continue;
                inAir = true;
            }
            crystal_spawn.func_70107_b(0 + x_pos, 63.0, -140 + z_pos);
            this.field_70170_p.func_72838_d((Entity)crystal_spawn);
        }
        for (Player near_pl : this.field_70170_p.func_72872_a(Player.class, this.getArenaAABB())) {
            near_pl.func_145747_a((Component)new Component((Object)((Object)TextFmt.Red) + "Darrio: Behold my sentry crystals!"));
        }
    }

    public void func_70636_d() {
        super.func_70636_d();
        this.field_70143_R = -1.0f;
        this.func_70024_g(0.0, this.field_70173_aa % 60 < 20 ? (double)0.1f : 0.0, 0.0);
        if (!this.field_70170_p.field_72995_K) {
            if (this.func_70638_az() == null) {
                boolean found_target = false;
                AABB aabb = this.getArenaAABB();
                for (Player near_pl : this.field_70170_p.func_72872_a(Player.class, aabb)) {
                    if (near_pl.func_184812_l_()) continue;
                    if (this.field_70159_w > (double)-0.7f && this.field_70159_w < (double)0.7f && this.field_70179_y > (double)-0.7f && this.field_70179_y < (double)0.7f) {
                        this.func_70024_g((near_pl.field_70165_t - this.field_70165_t) * 0.03, (near_pl.field_70163_u - this.field_70163_u) * 0.02, (near_pl.field_70161_v - this.field_70161_v) * 0.03);
                        this.field_70133_I = true;
                    }
                    found_target = true;
                    this.setSpinning(true);
                    break;
                }
                if (!found_target) {
                    this.setSpinning(false);
                }
            } else {
                this.setSpinning(true);
            }
            if ((this.field_70173_aa + 1) % 120 == 0) {
                int crystals = this.field_70146_Z.nextInt(2) + 1;
                if (this.getLivesCount() > 3) {
                    crystals += 2;
                    if (this.getLivesCount() > 6) {
                        crystals += 3;
                    }
                }
                this.spawnCrystals(crystals);
            }
        }
    }

    @Override
    protected void updateLifeAction() {
        for (Player near_pl : this.field_70170_p.func_72872_a(Player.class, this.getArenaAABB())) {
            near_pl.func_145747_a((Component)new Component((Object)((Object)TextFmt.Gold) + "Darrio: I cannot be killed so easily mortal."));
        }
    }

    protected SoundEvent func_184615_bR() {
        return SoundInit.GENERIC_STYLE1_DEATH;
    }

    protected SoundEvent func_184601_bQ(DamageSource damageSourceIn) {
        return SoundInit.GENERIC_STYLE1_HURT;
    }

    protected SoundEvent func_184639_G() {
        return null;
    }

    @Override
    protected int numberOfLives() {
        return 10;
    }

    @Override
    public void trueDeathAction() {
        if (!this.field_70170_p.field_72995_K) {
            EntityInfinityStone stone = new EntityInfinityStone(this.field_70170_p);
            stone.setStoneNum((byte)7);
            stone.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
            this.field_70170_p.func_72838_d((Entity)stone);
            this.func_145779_a(ItemInit.arenaCard, 1);
        }
    }

    protected boolean func_70692_ba() {
        return false;
    }

    @Override
    public boolean func_70814_o() {
        return true;
    }

    public int func_70641_bl() {
        return 1;
    }
}

