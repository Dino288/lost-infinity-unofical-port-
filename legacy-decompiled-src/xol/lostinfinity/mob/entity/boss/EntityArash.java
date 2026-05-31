/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.player.Player
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.EnumParticleTypes
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraft.world.World
 *  net.minecraft.world.ServerLevel
 */
package xol.lostinfinity.mob.entity.boss;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import net.minecraft.server.level.ServerLevel;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.entity.base.EntityMultipleLives;
import xol.lostinfinity.mob.entity.boss.EntityDeviantCrystal;
import xol.lostinfinity.stone.EntityInfinityStone;
import xol.lostinfinity.util.data.IMaxAttack;

public class EntityArash
extends EntityMultipleLives
implements IMaxAttack {
    public EntityArash(Level worldIn) {
        super(worldIn);
        this.func_70105_a(2.0f, 3.2f);
    }

    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(1.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.32);
        this.func_110148_a(SharedMonsterAttributes.field_111266_c).func_111128_a(1.0);
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(5000.0);
    }

    public boolean func_70652_k(Entity entity) {
        super.func_70652_k(entity);
        if (this.func_70638_az() != null) {
            IMaxAttack.dealMaxHealth((Entity)this, this.func_70638_az(), 4);
            return true;
        }
        return false;
    }

    private AABB getArenaAABB() {
        return new AABB(new BlockPos(-3.0, 60.0, -145.0), new BlockPos(52.0, 85.0, -40.0));
    }

    private void spawnCrystals(int count) {
        for (int crystal = 0; crystal < count; ++crystal) {
            EntityDeviantCrystal crystal_spawn = new EntityDeviantCrystal(this.field_70170_p);
            boolean inAir = false;
            int x_pos = 0;
            int z_pos = 0;
            while (!inAir) {
                x_pos = this.field_70146_Z.nextInt(30);
                if (!this.field_70170_p.func_175623_d(new BlockPos(0 + x_pos, 63, -140 + (z_pos = this.field_70146_Z.nextInt(80))))) continue;
                inAir = true;
            }
            crystal_spawn.func_70107_b(0 + x_pos, 63.0, -140 + z_pos);
            if (this.getLivesCount() > 5) {
                crystal_spawn.setSuperMutated(true);
            }
            this.field_70170_p.func_72838_d((Entity)crystal_spawn);
        }
        for (Player near_pl : this.field_70170_p.func_72872_a(Player.class, this.getArenaAABB())) {
            if (this.getLivesCount() > 5) {
                near_pl.func_145747_a((Component)new Component((Object)((Object)TextFmt.Green) + "Arash: Super mutants, rise!"));
                continue;
            }
            near_pl.func_145747_a((Component)new Component((Object)((Object)TextFmt.Green) + "Arash: Let's add some deviants to the mix."));
        }
    }

    public void func_70636_d() {
        super.func_70636_d();
        if (!this.field_70170_p.field_72995_K) {
            if (this.func_70638_az() == null && this.field_70173_aa % 120 == 0) {
                for (Player near_pl : this.field_70170_p.func_72872_a(Player.class, this.getArenaAABB())) {
                    if (near_pl.func_184812_l_()) continue;
                    this.func_70624_b((LivingEntity)near_pl);
                    this.func_70634_a(near_pl.field_70165_t, near_pl.field_70163_u, near_pl.field_70161_v);
                    IMaxAttack.dealMaxHealth((Entity)this, (LivingEntity)near_pl, 4);
                    near_pl.func_145747_a((Component)new Component((Object)((Object)TextFmt.Light_Purple) + "Arash: Surprise attack!"));
                    ((ServerLevel)this.field_70170_p).func_175739_a(EnumParticleTypes.SWEEP_ATTACK, this.field_70165_t, this.field_70163_u, this.field_70161_v, 5, this.field_70146_Z.nextDouble() * 3.0, 0.3, this.field_70146_Z.nextDouble() * 3.0, (double)0.15f, new int[0]);
                    break;
                }
            }
            if ((this.field_70173_aa + 80) % 100 == 0) {
                int crystal_count = 0;
                for (EntityDeviantCrystal crys : this.field_70170_p.func_72872_a(EntityDeviantCrystal.class, this.getArenaAABB())) {
                    ++crystal_count;
                    if (this.getLivesCount() <= 5) continue;
                    crys.setSuperMutated(true);
                }
                if (crystal_count < 5) {
                    int crystals = this.field_70146_Z.nextInt(1) + 1;
                    if (this.getLivesCount() > 3) {
                        ++crystals;
                        if (this.getLivesCount() > 6) {
                            ++crystals;
                        }
                    }
                    this.spawnCrystals(crystals);
                }
            }
        }
    }

    protected SoundEvent func_184615_bR() {
        return SoundInit.UROGO_DEATH;
    }

    protected SoundEvent func_184601_bQ(DamageSource damageSourceIn) {
        return SoundInit.UROGO_HIT;
    }

    protected SoundEvent func_184639_G() {
        return null;
    }

    @Override
    protected int numberOfLives() {
        return 15;
    }

    @Override
    protected void updateLifeAction() {
        for (Player near_pl : this.field_70170_p.func_72872_a(Player.class, this.getArenaAABB())) {
            near_pl.func_145747_a((Component)new Component((Object)((Object)TextFmt.Dark_Gray) + "Arash: Die already!"));
        }
        for (Player e : this.field_70170_p.func_72872_a(Player.class, this.func_174813_aQ().func_72314_b(4.0, 4.0, 4.0))) {
            e.func_70024_g(Math.signum(this.field_70165_t - e.field_70165_t) * -0.59, 0.35, Math.signum(this.field_70161_v - e.field_70161_v) * -0.59);
            e.field_70133_I = true;
        }
    }

    @Override
    public void trueDeathAction() {
        if (!this.field_70170_p.field_72995_K) {
            EntityInfinityStone stone = new EntityInfinityStone(this.field_70170_p);
            stone.setStoneNum((byte)6);
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

