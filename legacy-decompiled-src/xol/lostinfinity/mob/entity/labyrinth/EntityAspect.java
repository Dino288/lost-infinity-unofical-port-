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
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.datasync.DataParameter
 *  net.minecraft.network.datasync.DataSerializer
 *  net.minecraft.network.datasync.DataSerializers
 *  net.minecraft.network.datasync.EntityDataManager
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.util.math.Mth
 *  net.minecraft.util.math.Vec3
 *  net.minecraft.world.EnumDifficulty
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.labyrinth;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.Item;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializer;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.Difficulty;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.entity.base.EntityMultipleLives;
import xol.lostinfinity.projectile.entity.EntityDeviantFireball;
import xol.lostinfinity.projectile.entity.EntityWizardBlast;
import xol.lostinfinity.util.data.IMaxAttack;

public class EntityAspect
extends EntityMultipleLives
implements IMaxAttack {
    private static final DataParameter<Integer> STYLE = EntityDataManager.func_187226_a(EntityAspect.class, (DataSerializer)DataSerializers.field_187192_b);
    private Item map_drop;

    public EntityAspect(Level worldIn) {
        super(worldIn);
        this.func_70105_a(1.0f, 2.5f);
    }

    @Override
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a(STYLE, (Object)0);
    }

    public int getStyle() {
        return (Integer)this.field_70180_af.func_187225_a(STYLE);
    }

    public void setStyle(int f) {
        this.field_70180_af.func_187227_b(STYLE, (Object)f);
    }

    @Override
    public void func_70014_b(CompoundTag tag) {
        super.func_70014_b(tag);
        tag.func_74768_a("SpawnForm", this.getStyle());
    }

    @Override
    public void func_70037_a(CompoundTag tag) {
        super.func_70037_a(tag);
        this.setStyle(tag.func_74762_e("SpawnForm"));
    }

    public void setMapDrop(Item item) {
        this.map_drop = item;
    }

    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(1.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.2);
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(1000.0);
    }

    @Override
    public void trueDeathAction() {
        if (!this.field_70170_p.field_72995_K && this.map_drop != null) {
            this.func_145779_a(this.map_drop, 1);
        }
    }

    public boolean func_70652_k(Entity entity) {
        super.func_70652_k(entity);
        if (this.func_70638_az() != null) {
            IMaxAttack.dealMaxHealth((Entity)this, this.func_70638_az(), 4);
            return true;
        }
        return false;
    }

    protected SoundEvent func_184615_bR() {
        return SoundInit.ASPECT_DEATH;
    }

    protected SoundEvent func_184601_bQ(DamageSource damageSourceIn) {
        return SoundInit.ASPECT_HIT;
    }

    protected SoundEvent func_184639_G() {
        return null;
    }

    public void func_70636_d() {
        super.func_70636_d();
        if (!this.field_70170_p.field_72995_K) {
            LivingEntity target = this.func_70638_az();
            switch (this.getStyle()) {
                case 0: {
                    if (this.field_70173_aa % 5 == 0 && target != null) {
                        EntityWizardBlast shot = new EntityWizardBlast(this.field_70170_p, (LivingEntity)this);
                        double d0 = target.field_70165_t - this.field_70165_t;
                        double d1 = target.func_174813_aQ().field_72338_b + (double)(target.field_70131_O / 5.0f) - shot.field_70163_u;
                        double d2 = target.field_70161_v - this.field_70161_v;
                        double d3 = Mth.func_76133_a((double)(d0 * d0 + d2 * d2));
                        shot.func_70186_c(d0, d1 + d3 * (double)0.2f, d2, 2.0f, 0.0f);
                        this.field_70170_p.func_72838_d((Entity)shot);
                        this.func_184185_a(SoundEvents.field_187606_E, 1.0f, 1.0f);
                    }
                    if (this.field_70173_aa % 40 != 0 || this.field_70170_p.field_72995_K) break;
                    for (int snum = 0; snum < 5; ++snum) {
                        EntityWizardBlast shot = new EntityWizardBlast(this.field_70170_p, (LivingEntity)this);
                        shot.func_70186_c(-1.0 + this.field_70170_p.field_73012_v.nextDouble() * 2.0, 0.0 + (double)(0.2f * (float)Math.floorDiv(this.field_70173_aa % 90, 10)), -1.0 + this.field_70170_p.field_73012_v.nextDouble() * 2.0, 1.0f, 0.0f);
                        this.field_70170_p.func_72838_d((Entity)shot);
                    }
                    this.func_184185_a(SoundEvents.field_187606_E, 1.0f, 1.0f);
                    break;
                }
                case 1: {
                    if (this.field_70173_aa % 30 != 0) break;
                    double x0 = this.field_70165_t;
                    double y0 = this.field_70163_u + 2.5;
                    double z0 = this.field_70161_v;
                    double radius = 5.0;
                    this.func_184185_a(SoundEvents.field_187606_E, 1.0f, 1.0f);
                    float angle = 0.0f;
                    while ((double)angle <= Math.PI * 2) {
                        EntityWizardBlast shot = new EntityWizardBlast(this.field_70170_p, (LivingEntity)this);
                        shot.func_70107_b(x0, y0, z0);
                        double velocity_x = radius * Math.cos(angle);
                        double velocity_z = radius * Math.sin(angle);
                        shot.setThrower((LivingEntity)this);
                        shot.calculateVelocity(velocity_x, -0.5, velocity_z);
                        shot.func_184538_a((Entity)this, shot.field_70125_A, shot.field_70177_z, 0.0f, 1.5f, 0.0f);
                        this.field_70170_p.func_72838_d((Entity)shot);
                        angle = (float)((double)angle + 0.3141592653589793);
                    }
                    break;
                }
                case 2: {
                    if (this.field_70173_aa % 50 > 20 || this.field_70173_aa % 10 != 0) break;
                    boolean did_shot = false;
                    for (Player near_pl : this.field_70170_p.func_72872_a(Player.class, this.func_174813_aQ().func_72314_b(18.0, 18.0, 18.0))) {
                        if (near_pl.func_184812_l_()) continue;
                        Vec3 vec3d = this.func_70676_i(1.0f);
                        double makeX = (this.func_174813_aQ().field_72340_a + this.func_174813_aQ().field_72336_d) / 2.0;
                        double makeY = this.field_70163_u + (double)(this.field_70131_O / 2.0f) + 0.5;
                        double makeZ = (this.func_174813_aQ().field_72339_c + this.func_174813_aQ().field_72334_f) / 2.0;
                        double d2 = near_pl.field_70165_t - makeX;
                        double d3 = near_pl.func_174813_aQ().field_72338_b + (double)(near_pl.field_70131_O / 2.0f) - makeY;
                        double d4 = near_pl.field_70161_v - makeZ;
                        EntityDeviantFireball shot = new EntityDeviantFireball(this.field_70170_p, (LivingEntity)this, d2, d3, d4, 3, 0.5f);
                        shot.field_70165_t = makeX;
                        shot.field_70163_u = makeY;
                        shot.field_70161_v = makeZ;
                        this.field_70170_p.func_72838_d((Entity)shot);
                        did_shot = true;
                    }
                    if (!did_shot) break;
                    this.func_184185_a(SoundEvents.field_187606_E, 2.0f, 0.5f + this.field_70146_Z.nextFloat());
                }
            }
            if (this.field_70173_aa == 2400) {
                this.func_70106_y();
            }
        }
    }

    public boolean func_180427_aV() {
        return true;
    }

    @Override
    protected int numberOfLives() {
        return 5;
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

    @Override
    public boolean func_70601_bi() {
        return this.field_70170_p.func_175659_aa() != EnumDifficulty.PEACEFUL;
    }
}

