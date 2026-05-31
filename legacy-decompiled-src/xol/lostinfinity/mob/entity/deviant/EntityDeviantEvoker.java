/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.player.Player
 *  net.minecraft.init.MobEffects
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.network.datasync.DataParameter
 *  net.minecraft.network.datasync.DataSerializer
 *  net.minecraft.network.datasync.DataSerializers
 *  net.minecraft.network.datasync.EntityDataManager
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.util.EnumParticleTypes
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Mth
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraft.world.IBlockAccess
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.deviant;

import java.util.ArrayList;
import java.util.Iterator;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.client.model.ModelBase;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.init.MobEffects;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializer;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.level.Level;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.mob.entity.base.EntityMultipleLives;
import xol.lostinfinity.mob.entity.deviant.EntityDeviantEvokerVex;
import xol.lostinfinity.mob.entity.misc.EntitySandAttack;
import xol.lostinfinity.mob.model.deviant.ModelDeviantBat;
import xol.lostinfinity.mob.model.deviant.ModelDeviantCaveSpider;
import xol.lostinfinity.mob.model.deviant.ModelDeviantChicken;
import xol.lostinfinity.mob.model.deviant.ModelDeviantCreeper;
import xol.lostinfinity.mob.model.deviant.ModelDeviantEnderman;
import xol.lostinfinity.mob.model.deviant.ModelDeviantEvoker;
import xol.lostinfinity.mob.model.deviant.ModelDeviantHusk;
import xol.lostinfinity.mob.model.deviant.ModelDeviantLlama;
import xol.lostinfinity.mob.model.deviant.ModelDeviantPiglin;
import xol.lostinfinity.mob.model.deviant.ModelDeviantSkeleton;
import xol.lostinfinity.mob.model.deviant.ModelDeviantStray;
import xol.lostinfinity.projectile.entity.EntityDeviantEvokerBomb;
import xol.lostinfinity.projectile.entity.EntityDeviantEvokerFangs;
import xol.lostinfinity.projectile.entity.EntityDeviantSpit;
import xol.lostinfinity.projectile.entity.EntityEchoBlast;
import xol.lostinfinity.projectile.entity.EntityPlagueBlast;
import xol.lostinfinity.projectile.entity.EntitySkullShot;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.load.LootTableRegistry;

public class EntityDeviantEvoker
extends EntityMultipleLives
implements IMaxAttack {
    private static final DataParameter<Integer> INDEX = EntityDataManager.func_187226_a(EntityDeviantEvoker.class, (DataSerializer)DataSerializers.field_187192_b);
    private ResourceLocation curTexture = new ResourceLocation("lostinfinity:textures/entity/deviant/deviantevoker.png");
    private ModelBase curModel = new ModelDeviantEvoker();
    ArrayList<ModelBase> modelList = new ArrayList();
    ArrayList<ResourceLocation> textureList = new ArrayList();
    private boolean swapped = false;

    @Override
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a(INDEX, (Object)-1);
    }

    private int getIndex() {
        return (Integer)this.field_70180_af.func_187225_a(INDEX);
    }

    private void setIndex(int index) {
        this.field_70180_af.func_187227_b(INDEX, (Object)index);
    }

    public ResourceLocation getCurTexture() {
        return this.curTexture;
    }

    private void skeleShot(LivingEntity target) {
        if (this.field_70173_aa % 12 == 0 && target != null) {
            if (!this.field_70170_p.field_72995_K) {
                EntitySkullShot shot = new EntitySkullShot(this.field_70170_p, (LivingEntity)this);
                double d0 = target.field_70165_t - this.field_70165_t;
                double d1 = target.func_174813_aQ().field_72338_b + (double)(target.field_70131_O / 6.0f) - shot.field_70163_u;
                double d2 = target.field_70161_v - this.field_70161_v;
                double d3 = Mth.func_76133_a((double)(d0 * d0 + d2 * d2));
                shot.func_70186_c(d0, d1 + d3 * (double)0.2f, d2, 2.0f, 0.0f);
                this.field_70170_p.func_72838_d((Entity)shot);
            }
            this.func_184185_a(SoundEvents.field_193784_dd, 1.0f, 1.0f);
        }
    }

    private void huskShot() {
        if (!this.field_70170_p.field_72995_K && this.field_70173_aa % 25 == 0) {
            for (Player near_pl : this.field_70170_p.func_72872_a(Player.class, this.func_174813_aQ().func_186662_g(30.0))) {
                int yOffset = 1;
                boolean canRun = true;
                while (this.field_70170_p.func_175623_d(near_pl.func_180425_c().func_177982_a(0, yOffset, 0)) && canRun) {
                    if (++yOffset != 35) continue;
                    canRun = false;
                }
                EntitySandAttack attack = new EntitySandAttack(this.field_70170_p);
                attack.func_70107_b(near_pl.field_70165_t, near_pl.field_70163_u + (double)yOffset, near_pl.field_70161_v);
                this.field_70170_p.func_72838_d((Entity)attack);
            }
        }
    }

    private void batShot(LivingEntity target) {
        if (this.field_70173_aa % 20 == 0 && target != null) {
            if (!this.field_70170_p.field_72995_K) {
                EntityEchoBlast shot = new EntityEchoBlast(this.field_70170_p);
                double d0 = target.field_70165_t - this.field_70165_t;
                double d1 = target.func_174813_aQ().field_72338_b + (double)(target.field_70131_O / 6.0f) - shot.field_70163_u - 0.5;
                double d2 = target.field_70161_v - this.field_70161_v;
                double d3 = Mth.func_76133_a((double)(d0 * d0 + d2 * d2));
                shot.func_70186_c(d0, d1 + d3 * (double)0.2f, d2, 3.5f, 0.0f);
                this.field_70170_p.func_72838_d((Entity)shot);
            }
            this.func_184185_a(SoundEvents.field_191255_dF, 1.0f, 1.0f);
        }
    }

    private void llamaShot(LivingEntity target) {
        if (this.field_70173_aa % 20 == 0 && target != null) {
            if (!this.field_70170_p.field_72995_K) {
                EntityDeviantSpit shot = new EntityDeviantSpit(this.field_70170_p, (LivingEntity)this);
                double d0 = target.field_70165_t - this.field_70165_t;
                double d1 = target.func_174813_aQ().field_72338_b + (double)(target.field_70131_O / 6.0f) - shot.field_70163_u - 0.5;
                double d2 = target.field_70161_v - this.field_70161_v;
                double d3 = Mth.func_76133_a((double)(d0 * d0 + d2 * d2));
                shot.func_70186_c(d0, d1 + d3 * (double)0.2f, d2, 3.5f, 0.0f);
                this.field_70170_p.func_72838_d((Entity)shot);
            }
            this.func_184185_a(SoundEvents.field_191255_dF, 1.0f, 1.0f);
        }
    }

    private void strayShot(LivingEntity target) {
        if (this.field_70173_aa % 18 == 0 && target != null) {
            if (!this.field_70170_p.field_72995_K) {
                for (int i = 0; i < 8 + this.field_70170_p.field_73012_v.nextInt(4); ++i) {
                    EntitySkullShot shot = new EntitySkullShot(this.field_70170_p, target.field_70165_t - 4.0 + this.field_70170_p.field_73012_v.nextDouble() * 8.0, target.field_70163_u + 15.0, target.field_70161_v - 4.0 + this.field_70170_p.field_73012_v.nextDouble() * 8.0, 1.0f);
                    shot.setThrower((LivingEntity)this);
                    shot.func_70186_c(0.0, -0.05, 0.0, 0.7f, 0.0f);
                    this.field_70170_p.func_72838_d((Entity)shot);
                }
            }
            this.func_184185_a(SoundEvents.field_193784_dd, 1.0f, 1.0f);
        }
    }

    private void spiderShot(LivingEntity target) {
        if (this.field_70173_aa % 20 == 0 && target != null) {
            if (!this.field_70170_p.field_72995_K) {
                EntityPlagueBlast shot = new EntityPlagueBlast(this.field_70170_p, (LivingEntity)this);
                double d0 = target.field_70165_t - this.field_70165_t;
                double d1 = target.func_174813_aQ().field_72338_b + (double)(target.field_70131_O / 6.0f) - shot.field_70163_u;
                double d2 = target.field_70161_v - this.field_70161_v;
                double d3 = Mth.func_76133_a((double)(d0 * d0 + d2 * d2));
                shot.func_70186_c(d0, d1 + d3 * (double)0.2f, d2, 2.5f, 0.0f);
                shot.addPoison(2);
                this.field_70170_p.func_72838_d((Entity)shot);
            }
            this.func_184185_a(SoundEvents.field_191255_dF, 1.0f, 1.0f);
        }
    }

    private void chickenJump(LivingEntity target) {
        this.field_70143_R = -1.0f;
        if (this.field_70173_aa % 40 == 0 && target != null && target instanceof Player) {
            Player pl = (Player)target;
            this.func_70024_g((pl.field_70165_t - this.field_70165_t) * 0.145, 1.0, (pl.field_70161_v - this.field_70161_v) * 0.145);
            this.field_70133_I = true;
        }
    }

    private void creeperExplosion(LivingEntity target) {
        if (this.field_70173_aa % 50 == 0 && !this.field_70170_p.field_72995_K) {
            this.field_70170_p.func_72876_a(null, this.field_70165_t, this.field_70163_u, this.field_70161_v, 7.0f, false);
            for (Player near_pl : this.field_70170_p.func_72872_a(Player.class, this.func_174813_aQ().func_72314_b(4.0, 4.0, 4.0))) {
                IMaxAttack.dealMaxHealth((Entity)this, (LivingEntity)near_pl, 3);
            }
        }
    }

    private void endermanInvis() {
        if (this.field_70173_aa % 120 == 0) {
            if (this.field_70170_p.field_72995_K) {
                for (int i = 0; i < 14; ++i) {
                    this.field_70170_p.func_175688_a(EnumParticleTypes.SPELL_WITCH, this.field_70165_t + (this.field_70146_Z.nextDouble() - 0.5) * (double)this.field_70130_N, this.field_70163_u + this.field_70146_Z.nextDouble() * (double)this.field_70131_O - 0.25, this.field_70161_v + (this.field_70146_Z.nextDouble() - 0.5) * (double)this.field_70130_N, (this.field_70146_Z.nextDouble() - 0.5) * 2.0, -this.field_70146_Z.nextDouble(), (this.field_70146_Z.nextDouble() - 0.5) * 2.0, new int[0]);
                }
            }
            this.field_70170_p.func_184134_a(this.field_70165_t, this.field_70163_u, this.field_70161_v, SoundEvents.field_187534_aX, SoundSource.HOSTILE, 1.5f, 0.5f + this.field_70170_p.field_73012_v.nextFloat(), true);
            this.func_70690_d(new PotionEffect(MobEffects.field_76441_p, 40));
        }
        if (this.func_82150_aj() && this.field_70170_p.field_72995_K) {
            this.field_70170_p.func_175688_a(EnumParticleTypes.SPELL, this.field_70165_t + (this.field_70146_Z.nextDouble() - 0.5) * (double)this.field_70130_N * 3.0, this.field_70163_u + this.field_70146_Z.nextDouble() * (double)this.field_70131_O - 0.25, this.field_70161_v + (this.field_70146_Z.nextDouble() - 0.5) * (double)this.field_70130_N * 3.0, (this.field_70146_Z.nextDouble() - 0.5) * 2.0, -this.field_70146_Z.nextDouble(), (this.field_70146_Z.nextDouble() - 0.5) * 2.0, new int[0]);
        }
    }

    private void piglinJump(LivingEntity target) {
        this.field_70143_R = -1.0f;
        if (!this.field_70170_p.field_72995_K) {
            if (this.field_70122_E && this.field_70173_aa % 60 == 10) {
                this.field_70181_x = 1.2;
            } else if (this.field_70173_aa % 60 == 30) {
                Player dashto = null;
                if (target == null || !(target instanceof Player)) {
                    Iterator iterator = this.field_70170_p.func_72872_a(Player.class, this.func_174813_aQ().func_72314_b(15.0, 15.0, 15.0)).iterator();
                    if (iterator.hasNext()) {
                        Player near_pl;
                        dashto = near_pl = (Player)iterator.next();
                        this.func_70624_b((LivingEntity)near_pl);
                    }
                } else {
                    dashto = (Player)target;
                }
                if (dashto != null) {
                    this.func_70024_g((dashto.field_70165_t - this.field_70165_t) * 0.245, (dashto.field_70163_u - this.field_70163_u) * 0.145, (dashto.field_70161_v - this.field_70161_v) * 0.245);
                }
            }
        }
    }

    public void func_70636_d() {
        block33: {
            LivingEntity entitylivingbase;
            LivingEntity target;
            block32: {
                super.func_70636_d();
                target = this.func_70638_az();
                int index = this.getIndex();
                switch (index) {
                    case 0: {
                        this.huskShot();
                        break;
                    }
                    case 1: {
                        this.skeleShot(target);
                        break;
                    }
                    case 2: {
                        this.batShot(target);
                        break;
                    }
                    case 3: {
                        this.strayShot(target);
                        break;
                    }
                    case 4: {
                        this.llamaShot(target);
                        break;
                    }
                    case 5: {
                        this.chickenJump(target);
                        break;
                    }
                    case 6: {
                        this.creeperExplosion(target);
                        break;
                    }
                    case 7: {
                        this.endermanInvis();
                        break;
                    }
                    case 8: {
                        this.piglinJump(target);
                        break;
                    }
                    case 9: {
                        this.spiderShot(target);
                    }
                }
                if (!this.field_70170_p.field_72995_K) break block32;
                if (this.modelList.isEmpty() && this.textureList.isEmpty()) {
                    this.modelList.add(new ModelDeviantHusk());
                    this.textureList.add(new ResourceLocation("lostinfinity:textures/entity/deviant/devianthusk.png"));
                    this.modelList.add(new ModelDeviantSkeleton());
                    this.textureList.add(new ResourceLocation("lostinfinity:textures/entity/deviant/deviantskeleton.png"));
                    this.modelList.add(new ModelDeviantBat());
                    this.textureList.add(new ResourceLocation("lostinfinity:textures/entity/deviant/deviantbat.png"));
                    this.modelList.add(new ModelDeviantStray());
                    this.textureList.add(new ResourceLocation("lostinfinity:textures/entity/deviant/deviantstray.png"));
                    this.modelList.add(new ModelDeviantLlama());
                    this.textureList.add(new ResourceLocation("lostinfinity:textures/entity/deviant/deviantllama.png"));
                    this.modelList.add(new ModelDeviantChicken());
                    this.textureList.add(new ResourceLocation("lostinfinity:textures/entity/deviant/deviantchicken.png"));
                    this.modelList.add(new ModelDeviantCreeper());
                    this.textureList.add(new ResourceLocation("lostinfinity:textures/entity/deviant/deviantcreeper.png"));
                    this.modelList.add(new ModelDeviantEnderman());
                    this.textureList.add(new ResourceLocation("lostinfinity:textures/entity/deviant/deviantenderman.png"));
                    this.modelList.add(new ModelDeviantPiglin());
                    this.textureList.add(new ResourceLocation("lostinfinity:textures/entity/deviant/deviantpiglin.png"));
                    this.modelList.add(new ModelDeviantCaveSpider());
                    this.textureList.add(new ResourceLocation("lostinfinity:textures/entity/deviant/deviantcavespider.png"));
                } else {
                    int i = this.getIndex();
                    if (i >= 0 && i < this.modelList.size()) {
                        this.curModel = this.modelList.get(i);
                        this.curTexture = this.textureList.get(i);
                    } else {
                        this.curModel = new ModelDeviantEvoker();
                        this.curTexture = new ResourceLocation("lostinfinity:textures/entity/deviant/deviantevoker.png");
                    }
                }
                break block33;
            }
            if (this.field_70173_aa % 140 == 0) {
                if (!this.swapped) {
                    this.setIndex(this.field_70146_Z.nextInt(9));
                    this.swapped = true;
                } else {
                    this.setIndex(-1);
                    this.swapped = false;
                }
            }
            if (target != null && target instanceof EntityDeviantEvokerVex) {
                this.func_70624_b(null);
            }
            if (this.field_70173_aa % 600 == 20) {
                int count = 0;
                for (EntityDeviantEvokerVex bat : this.field_70170_p.func_72872_a(EntityDeviantEvokerVex.class, new AABB(this.func_180425_c()).func_186662_g(7.0))) {
                    ++count;
                }
                if (count < 2) {
                    for (int i = 0; i < 2; ++i) {
                        EntityDeviantEvokerVex bat;
                        bat = new EntityDeviantEvokerVex(this.field_70170_p);
                        bat.setTamedBy((LivingEntity)this);
                        bat.func_70634_a(this.field_70165_t + this.field_70146_Z.nextDouble() * 2.0 - 1.0, this.field_70163_u + 4.0, this.field_70161_v + this.field_70146_Z.nextDouble() * 2.0 - 1.0);
                        LivingEntity entitylivingbase2 = this.func_70638_az();
                        if (entitylivingbase2 != null) {
                            bat.func_70624_b(entitylivingbase2);
                        }
                        this.field_70170_p.func_72838_d((Entity)bat);
                    }
                }
            }
            if (this.field_70173_aa % 500 > 400 && this.field_70173_aa % 10 == 0) {
                double angle = this.field_70146_Z.nextDouble() * 2.0 * Math.PI;
                EntityDeviantEvokerBomb shot = new EntityDeviantEvokerBomb(this.field_70170_p);
                shot.func_70107_b(this.field_70165_t, this.field_70163_u + 1.0, this.field_70161_v);
                double velocity_x = 0.4 * Math.cos(angle);
                double velocity_z = (double)0.4f * Math.sin(angle);
                shot.setThrower((LivingEntity)this);
                shot.calculateVelocity(velocity_x, 0.5, velocity_z);
                this.field_70170_p.func_72838_d((Entity)shot);
            }
            if (this.field_70173_aa % 100 != 0 || (entitylivingbase = this.func_70638_az()) == null) break block33;
            double d0 = Math.min(entitylivingbase.field_70163_u, this.field_70163_u);
            double d1 = Math.max(entitylivingbase.field_70163_u, this.field_70163_u) + 1.0;
            float f = (float)Mth.func_181159_b((double)(entitylivingbase.field_70161_v - this.field_70161_v), (double)(entitylivingbase.field_70165_t - this.field_70165_t));
            if (this.func_70068_e((Entity)entitylivingbase) < 9.0) {
                for (int i = 0; i < 5; ++i) {
                    float f1 = f + (float)i * (float)Math.PI * 0.4f;
                    this.spawnFangs(this.field_70165_t + (double)Mth.func_76134_b((float)f1) * 1.5, this.field_70161_v + (double)Mth.func_76126_a((float)f1) * 1.5, d0, d1, f1, 0);
                }
                for (int k = 0; k < 8; ++k) {
                    float f2 = f + (float)k * (float)Math.PI * 2.0f / 8.0f + 1.2566371f;
                    this.spawnFangs(this.field_70165_t + (double)Mth.func_76134_b((float)f2) * 2.5, this.field_70161_v + (double)Mth.func_76126_a((float)f2) * 2.5, d0, d1, f2, 3);
                }
            } else {
                for (double h = -1.0471975511965976; h <= 1.0571975511965976; h += 0.5235987755982988) {
                    float f3 = f + (float)h;
                    for (int l = 0; l < 16; ++l) {
                        double d2 = 1.25 * (double)(l + 1);
                        int j = 1 * l;
                        this.spawnFangs(this.field_70165_t + (double)Mth.func_76134_b((float)f3) * d2, this.field_70161_v + (double)Mth.func_76126_a((float)f3) * d2, d0, d1, f3, j);
                    }
                }
            }
        }
    }

    private void spawnFangs(double x, double z, double minHeight, double y, float yaw, int warmupTicks) {
        BlockPos blockpos = new BlockPos(x, y, z);
        boolean flag = false;
        double d0 = 0.0;
        do {
            BlockState iblockstate;
            AABB axisalignedbb;
            if (this.field_70170_p.func_175677_d(blockpos, true) || !this.field_70170_p.func_175677_d(blockpos.func_177977_b(), true)) continue;
            if (!this.field_70170_p.func_175623_d(blockpos) && (axisalignedbb = (iblockstate = this.field_70170_p.func_180495_p(blockpos)).func_185890_d((IBlockAccess)this.field_70170_p, blockpos)) != null) {
                d0 = axisalignedbb.field_72337_e;
            }
            flag = true;
            break;
        } while ((blockpos = blockpos.func_177977_b()).func_177956_o() >= Mth.func_76128_c((double)minHeight) - 1);
        if (flag) {
            EntityDeviantEvokerFangs entityevokerfangs = new EntityDeviantEvokerFangs(this.field_70170_p, x, (double)blockpos.func_177956_o() + d0, z, yaw, warmupTicks, (LivingEntity)this);
            this.field_70170_p.func_72838_d((Entity)entityevokerfangs);
        }
    }

    public EntityDeviantEvoker(Level worldIn) {
        super(worldIn);
        this.func_70105_a(1.25f, 4.0f);
    }

    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(1.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.32);
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(500.0);
    }

    public boolean func_70652_k(Entity entity) {
        super.func_70652_k(entity);
        if (this.func_70638_az() != null) {
            IMaxAttack.dealMaxHealth((Entity)this, this.func_70638_az(), 1);
            return true;
        }
        return false;
    }

    public ModelBase getCurModel() {
        return this.curModel;
    }

    @Override
    protected int numberOfLives() {
        return 300;
    }

    @Override
    protected void updateLifeAction() {
        int lifePercent = Math.round(100 * (this.numberOfLives() - this.getLivesCount()) / this.numberOfLives());
        AABB pullBox = new AABB(this.func_180425_c()).func_186662_g(45.0);
        for (Player entity : this.field_70170_p.func_72872_a(Player.class, pullBox)) {
            entity.func_145747_a((Component)new Component((Object)((Object)TextFmt.Gold) + "The Evoker is at " + lifePercent + "% health."));
        }
    }

    protected ResourceLocation func_184647_J() {
        return LootTableRegistry.ENTITIES_DEVIANTEVOKER;
    }
}

