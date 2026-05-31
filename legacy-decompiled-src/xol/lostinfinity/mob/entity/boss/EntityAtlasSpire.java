/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.monster.Monster
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
 *  net.minecraft.util.math.Vec3
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.boss;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.entity.monster.Monster;
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
import net.minecraft.world.phys.Vec3;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.entity.boss.EntityAtlasCrystal;
import xol.lostinfinity.projectile.entity.EntityAtlasAttack;
import xol.lostinfinity.stone.EntityInfinityStone;
import xol.lostinfinity.util.data.IMaxAttack;

public class EntityAtlasSpire
extends Monster
implements IMaxAttack {
    private static final DataParameter<Integer> CRYSTAL_STYLE = EntityDataManager.func_187226_a(EntityAtlasCrystal.class, (DataSerializer)DataSerializers.field_187192_b);
    private static final DataParameter<Integer> ROUNDS_PASSED = EntityDataManager.func_187226_a(EntityAtlasCrystal.class, (DataSerializer)DataSerializers.field_187192_b);

    public EntityAtlasSpire(Level worldIn) {
        super(worldIn);
        this.func_70105_a(3.5f, 6.0f);
        this.func_184224_h(true);
    }

    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a(CRYSTAL_STYLE, (Object)0);
        this.field_70180_af.func_187214_a(ROUNDS_PASSED, (Object)0);
    }

    public int getStyle() {
        return (Integer)this.field_70180_af.func_187225_a(CRYSTAL_STYLE);
    }

    public void setStyle(int f) {
        this.field_70180_af.func_187227_b(CRYSTAL_STYLE, (Object)f);
    }

    public void passRound() {
        int roundsSoFar = this.getRounds();
        this.field_70180_af.func_187227_b(ROUNDS_PASSED, (Object)(roundsSoFar + 1));
        int style = 0;
        boolean run = true;
        while (run) {
            style = this.field_70146_Z.nextInt(4);
            if (style == this.getStyle()) continue;
            run = false;
        }
        this.setStyle(style);
        this.func_184185_a(SoundInit.SPIRE_TARGET, 1.0f, 1.0f);
        this.messageRound(style, roundsSoFar + 1);
    }

    private void messageRound(int newStyle, int round) {
        String msg;
        switch (newStyle) {
            case 0: {
                msg = "Spawning Crystals Rapidly... If more than 15 exist, you die.";
                break;
            }
            case 1: {
                msg = "Spawning Crystals... Dealing 5% HP Damage Per Crystal.";
                break;
            }
            case 2: {
                msg = "Repeatedly dealing damage. SURVIVE.";
                break;
            }
            case 3: {
                msg = "Rapid fire mode enabled";
                break;
            }
            default: {
                msg = "Error";
            }
        }
        for (Player near_pl : this.field_70170_p.func_72872_a(Player.class, this.getArenaAABB())) {
            near_pl.func_145747_a((Component)new Component(TextFmt.getFormatting(TextFmt.Bold, TextFmt.Green) + "ROUND: " + round));
            near_pl.func_145747_a((Component)new Component((Object)((Object)TextFmt.Aqua) + msg));
        }
    }

    public int getRounds() {
        return (Integer)this.field_70180_af.func_187225_a(ROUNDS_PASSED);
    }

    private void setRounds(int r) {
        this.field_70180_af.func_187227_b(ROUNDS_PASSED, (Object)r);
    }

    public void func_70014_b(CompoundTag tag) {
        super.func_70014_b(tag);
        tag.func_74768_a("SpawnForm", this.getStyle());
        tag.func_74768_a("Rounds", this.getRounds());
    }

    public void func_70037_a(CompoundTag tag) {
        super.func_70037_a(tag);
        this.setStyle(tag.func_74762_e("SpawnForm"));
        this.setRounds(tag.func_74762_e("Rounds"));
    }

    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(1.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.0);
        this.func_110148_a(SharedMonsterAttributes.field_111266_c).func_111128_a(1.0);
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(50000.0);
    }

    private AABB getArenaAABB() {
        return new AABB(new BlockPos(-3.0, 60.0, -145.0), new BlockPos(52.0, 85.0, -40.0));
    }

    private void fireBlast() {
        if (!this.field_70170_p.field_72995_K) {
            boolean fired = false;
            for (Player near_pl : this.field_70170_p.func_72872_a(Player.class, this.getArenaAABB())) {
                if (near_pl.func_184812_l_()) continue;
                fired = true;
                Vec3 vec3d = this.func_70676_i(1.0f);
                double makeX = (this.func_174813_aQ().field_72340_a + this.func_174813_aQ().field_72336_d) / 2.0;
                double makeY = this.field_70163_u + (double)(this.field_70131_O / 2.0f) + 0.5;
                double makeZ = (this.func_174813_aQ().field_72339_c + this.func_174813_aQ().field_72334_f) / 2.0;
                double d2 = near_pl.field_70165_t - makeX;
                double d3 = near_pl.func_174813_aQ().field_72338_b + (double)(near_pl.field_70131_O / 8.0f) - makeY;
                double d4 = near_pl.field_70161_v - makeZ;
                EntityAtlasAttack shot = new EntityAtlasAttack(this.field_70170_p, (LivingEntity)this);
                shot.func_70186_c(d2, d3, d4, 2.0f, 0.0f);
                this.field_70170_p.func_72838_d((Entity)shot);
            }
            if (fired) {
                this.func_184185_a(SoundInit.GALAXYFIRE, 2.0f, 1.0f);
            }
        }
    }

    private void spawnCrystals(int count) {
        for (int crystal = 0; crystal < count; ++crystal) {
            EntityAtlasCrystal crystal_spawn = new EntityAtlasCrystal(this.field_70170_p);
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
    }

    private int getCrystalCount() {
        int num = 0;
        for (EntityAtlasCrystal crystal : this.field_70170_p.func_72872_a(EntityAtlasCrystal.class, this.getArenaAABB())) {
            ++num;
        }
        return num;
    }

    public void func_70636_d() {
        super.func_70636_d();
        if (this.func_110143_aJ() > 0.0f) {
            this.func_70606_j(this.func_110138_aP());
            if (!this.field_70170_p.field_72995_K) {
                if (this.field_70173_aa % 40 == 0) {
                    this.fireBlast();
                }
                switch (this.getStyle()) {
                    case 0: {
                        if (this.field_70173_aa % 60 != 0) break;
                        int count = this.getCrystalCount();
                        if (count >= 15) {
                            for (Player player : this.field_70170_p.func_72872_a(Player.class, this.getArenaAABB())) {
                                IMaxAttack.dealMaxHealth((Entity)this, (LivingEntity)player, 1, 20.0f);
                                player.func_145747_a((Component)new Component((Object)((Object)TextFmt.Red) + "Atlas Spire: DEALING SEVERE DAMAGE"));
                            }
                            break;
                        }
                        this.spawnCrystals(this.field_70146_Z.nextInt(2) + 2);
                        break;
                    }
                    case 1: {
                        int count;
                        if (this.field_70173_aa % 40 == 0 && (count = this.getCrystalCount()) > 0) {
                            for (Player player : this.field_70170_p.func_72872_a(Player.class, this.getArenaAABB())) {
                                IMaxAttack.dealMaxHealth((Entity)this, (LivingEntity)player, 20, count);
                                player.func_145747_a((Component)new Component((Object)((Object)TextFmt.Red) + "Atlas Spire: Dealing " + 5 * count + "% health damage."));
                            }
                        }
                        if (this.field_70173_aa % 60 != 0 || this.getCrystalCount() > 15) break;
                        this.spawnCrystals(this.field_70146_Z.nextInt(1) + 1);
                        break;
                    }
                    case 2: {
                        if (this.field_70173_aa % 60 != 0) break;
                        for (Player player : this.field_70170_p.func_72872_a(Player.class, this.getArenaAABB())) {
                            IMaxAttack.dealMaxHealth((Entity)this, (LivingEntity)player, 3);
                            player.func_145747_a((Component)new Component((Object)((Object)TextFmt.Red) + "Atlas Spire: SURVIVE."));
                        }
                        break;
                    }
                    case 3: {
                        if ((this.field_70173_aa + 5) % 20 != 0) break;
                        this.fireBlast();
                    }
                }
                if ((this.field_70173_aa + 395) % 400 == 0) {
                    if (this.getRounds() < 15) {
                        this.passRound();
                    } else {
                        for (Player player : this.field_70170_p.func_72872_a(Player.class, this.getArenaAABB())) {
                            player.func_145747_a((Component)new Component((Object)((Object)TextFmt.Gold) + "Atlas Spire: Challenge Complete."));
                        }
                        this.func_70106_y();
                        EntityInfinityStone imposStone = new EntityInfinityStone(this.field_70170_p);
                        imposStone.setStoneNum((byte)9);
                        imposStone.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
                        this.field_70170_p.func_72838_d((Entity)imposStone);
                        this.func_145779_a(ItemInit.arenaCard, 1);
                    }
                }
            }
        }
    }

    protected SoundEvent func_184639_G() {
        return null;
    }

    protected SoundEvent func_184601_bQ(DamageSource damageSourceIn) {
        return null;
    }

    protected SoundEvent func_184615_bR() {
        return null;
    }

    public boolean func_70104_M() {
        return false;
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
}

