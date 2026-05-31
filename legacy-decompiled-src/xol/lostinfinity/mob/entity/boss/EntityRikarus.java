/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.PathfinderMob
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.monster.Monster
 *  net.minecraft.entity.player.Player
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.datasync.DataParameter
 *  net.minecraft.network.datasync.DataSerializer
 *  net.minecraft.network.datasync.DataSerializers
 *  net.minecraft.network.datasync.EntityDataManager
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.EnumParticleTypes
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.boss;

import java.util.Iterator;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializer;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.DimensionInit;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.ai.IBasicAI;
import xol.lostinfinity.mob.entity.boss.EntityRestorationCrystal;
import xol.lostinfinity.stone.EntityInfinityStone;
import xol.lostinfinity.util.data.IMaxAttack;

public class EntityRikarus
extends Monster
implements IMaxAttack,
IBasicAI {
    private static final DataParameter<Byte> FORM = EntityDataManager.func_187226_a(EntityRikarus.class, (DataSerializer)DataSerializers.field_187191_a);
    private static final DataParameter<Boolean> SPINNING = EntityDataManager.func_187226_a(EntityRikarus.class, (DataSerializer)DataSerializers.field_187198_h);

    public EntityRikarus(Level worldIn) {
        super(worldIn);
        this.func_70105_a(3.5f, 5.5f);
    }

    protected void func_184651_r() {
        this.initBasicTasks((PathfinderMob)this);
    }

    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a(FORM, (Object)0);
        this.field_70180_af.func_187214_a(SPINNING, (Object)false);
    }

    public byte getForm() {
        return (Byte)this.field_70180_af.func_187225_a(FORM);
    }

    public void setForm(byte f) {
        this.field_70180_af.func_187227_b(FORM, (Object)f);
    }

    public boolean isSpinning() {
        return (Boolean)this.field_70180_af.func_187225_a(SPINNING);
    }

    public void setSpinning(boolean f) {
        this.field_70180_af.func_187227_b(SPINNING, (Object)f);
    }

    public void gainFormBack() {
        if (this.getForm() > 0) {
            this.setForm((byte)(this.getForm() - 1));
            for (Player near_pl : this.field_70170_p.func_72872_a(Player.class, this.getArenaAABB())) {
                this.sendHealthMSG(near_pl, 100);
            }
        }
    }

    public void func_70014_b(CompoundTag tag) {
        super.func_70014_b(tag);
        tag.func_74774_a("BossForm", this.getForm());
        tag.func_74757_a("SpinningAttack", this.isSpinning());
    }

    public void func_70037_a(CompoundTag tag) {
        super.func_70037_a(tag);
        this.setForm(tag.func_74771_c("BossForm"));
        this.setSpinning(tag.func_74767_n("SpinningAttack"));
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

    private void sendHealthMSG(Player play, int topnum) {
        play.func_145747_a((Component)new Component((Object)((Object)TextFmt.Light_Purple) + "Rikarus is at " + (topnum - 10 * this.getForm()) + "% health"));
    }

    public void func_70645_a(DamageSource cause) {
        if (this.field_70170_p.field_73011_w.func_186058_p() == DimensionInit.celestialVoid) {
            byte stage = this.getForm();
            if (stage < 9) {
                if (!this.field_70170_p.field_72995_K) {
                    for (Player near_pl : this.field_70170_p.func_72872_a(Player.class, this.getArenaAABB())) {
                        this.sendHealthMSG(near_pl, 90);
                    }
                    EntityRikarus newRikarus = new EntityRikarus(this.field_70170_p);
                    boolean inAir = false;
                    int x_pos = 0;
                    int z_pos = 0;
                    while (!inAir) {
                        x_pos = this.field_70146_Z.nextInt(30);
                        if (!this.field_70170_p.func_175623_d(new BlockPos(0 + x_pos, 63, -140 + (z_pos = this.field_70146_Z.nextInt(80))))) continue;
                        inAir = true;
                    }
                    newRikarus.func_70107_b(0 + x_pos, 63.0, -140 + z_pos);
                    newRikarus.setForm((byte)(this.getForm() + 1));
                    this.field_70170_p.func_72838_d((Entity)newRikarus);
                }
            } else {
                super.func_70645_a(cause);
                if (!this.field_70170_p.field_72995_K) {
                    EntityInfinityStone misdirStone = new EntityInfinityStone(this.field_70170_p);
                    misdirStone.setStoneNum((byte)4);
                    misdirStone.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
                    this.field_70170_p.func_72838_d((Entity)misdirStone);
                    this.func_145779_a(ItemInit.arenaCard, 1);
                }
            }
        }
    }

    public void func_70636_d() {
        super.func_70636_d();
        this.field_70143_R = -1.0f;
        if (this.field_70170_p.field_72995_K && (this.func_110143_aJ() <= 0.0f || this.field_70128_L)) {
            for (int i = 0; i < 24; ++i) {
                this.field_70170_p.func_175688_a(EnumParticleTypes.DRAGON_BREATH, this.field_70165_t + (this.field_70146_Z.nextDouble() - 0.5) * (double)this.field_70130_N, this.field_70163_u + this.field_70146_Z.nextDouble() * (double)this.field_70131_O - 0.25, this.field_70161_v + (this.field_70146_Z.nextDouble() - 0.5) * (double)this.field_70130_N, (this.field_70146_Z.nextDouble() - 0.5) * 2.0, -this.field_70146_Z.nextDouble(), (this.field_70146_Z.nextDouble() - 0.5) * 2.0, new int[0]);
            }
        }
        if (this.getForm() != 0 && !this.field_70170_p.field_72995_K && (this.field_70173_aa + 320) % 400 == 0) {
            this.func_184185_a(SoundInit.RIKARUS_CRYSTAL, 3.0f, 1.0f);
            for (int crystal = 0; crystal < (this.getForm() < 5 ? 1 : 3); ++crystal) {
                EntityRestorationCrystal crystalheal = new EntityRestorationCrystal(this.field_70170_p);
                boolean inAir = false;
                int x_pos = 0;
                int z_pos = 0;
                while (!inAir) {
                    x_pos = this.field_70146_Z.nextInt(30);
                    if (!this.field_70170_p.func_175623_d(new BlockPos(0 + x_pos, 63, -140 + (z_pos = this.field_70146_Z.nextInt(80))))) continue;
                    inAir = true;
                }
                crystalheal.func_70107_b(0 + x_pos, 63.0, -140 + z_pos);
                this.field_70170_p.func_72838_d((Entity)crystalheal);
            }
            for (Player near_pl : this.field_70170_p.func_72872_a(Player.class, this.getArenaAABB())) {
                String crystalMessage = "";
                switch (this.field_70146_Z.nextInt(3)) {
                    case 0: {
                        crystalMessage = "Rise my crystals! Heal me.";
                        break;
                    }
                    case 1: {
                        crystalMessage = "With my crystals I am unkillable!";
                        break;
                    }
                    case 2: {
                        crystalMessage = "Crystals, give me life!";
                    }
                }
                near_pl.func_145747_a((Component)new Component((Object)((Object)TextFmt.Dark_Purple) + "Rikarus: " + crystalMessage));
            }
        }
        this.func_70024_g(0.0, this.field_70173_aa % 60 < 30 ? (double)0.1f : 0.0, 0.0);
        if (!this.field_70170_p.field_72995_K) {
            if (this.func_70638_az() == null) {
                AABB aabb = this.getArenaAABB();
                Iterator iterator = this.field_70170_p.func_72872_a(Player.class, aabb).iterator();
                if (iterator.hasNext()) {
                    Player near_pl = (Player)iterator.next();
                    if (this.field_70159_w > (double)-0.7f && this.field_70159_w < (double)0.7f && this.field_70179_y > (double)-0.7f && this.field_70179_y < (double)0.7f) {
                        this.func_70024_g((near_pl.field_70165_t - this.field_70165_t) * 0.03, (near_pl.field_70163_u - this.field_70163_u) * 0.02, (near_pl.field_70161_v - this.field_70161_v) * 0.03);
                        this.field_70133_I = true;
                    }
                    this.setSpinning(true);
                }
            } else {
                this.setSpinning(false);
            }
        }
    }

    protected SoundEvent func_184615_bR() {
        if (this.getForm() == 9) {
            return SoundInit.RIKARUS_DEATH;
        }
        return SoundInit.RIKARUS_HURT;
    }

    protected SoundEvent func_184601_bQ(DamageSource damageSourceIn) {
        return SoundInit.RIKARUS_HURT;
    }

    protected SoundEvent func_184639_G() {
        return SoundInit.RIKARUS_AMBIENT;
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

