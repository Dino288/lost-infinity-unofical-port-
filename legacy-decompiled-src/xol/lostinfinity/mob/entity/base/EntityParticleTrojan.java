/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.datasync.DataParameter
 *  net.minecraft.network.datasync.DataSerializer
 *  net.minecraft.network.datasync.DataSerializers
 *  net.minecraft.network.datasync.EntityDataManager
 *  net.minecraft.util.EnumParticleTypes
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.base;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializer;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.mob.entity.base.EntityImmaterial;

public class EntityParticleTrojan
extends EntityImmaterial {
    private static final DataParameter<Integer> PARTICLE_FX = EntityDataManager.func_187226_a(EntityParticleTrojan.class, (DataSerializer)DataSerializers.field_187192_b);
    private static final DataParameter<Integer> EXTRA_PARTICLE_DATA = EntityDataManager.func_187226_a(EntityParticleTrojan.class, (DataSerializer)DataSerializers.field_187192_b);

    public EntityParticleTrojan(Level worldIn) {
        super(worldIn);
        this.func_70105_a(0.001f, 0.001f);
        this.func_184224_h(true);
        this.func_82142_c(true);
        this.func_189654_d(true);
    }

    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a(PARTICLE_FX, (Object)0);
        this.field_70180_af.func_187214_a(EXTRA_PARTICLE_DATA, (Object)0);
    }

    public int getFX() {
        return (Integer)this.field_70180_af.func_187225_a(PARTICLE_FX);
    }

    public void setFX(int fx) {
        this.field_70180_af.func_187227_b(PARTICLE_FX, (Object)fx);
    }

    public int getFXData() {
        return (Integer)this.field_70180_af.func_187225_a(EXTRA_PARTICLE_DATA);
    }

    public void setFX(int fx, int extraData) {
        this.field_70180_af.func_187227_b(PARTICLE_FX, (Object)fx);
        this.field_70180_af.func_187227_b(EXTRA_PARTICLE_DATA, (Object)extraData);
    }

    public void func_70037_a(CompoundTag compound) {
        super.func_70037_a(compound);
        this.setFX(compound.func_74762_e("PartFX"), compound.func_74762_e("PartData"));
    }

    public void func_70014_b(CompoundTag compound) {
        super.func_70014_b(compound);
        compound.func_74768_a("PartFX", this.getFX());
        compound.func_74768_a("PartData", this.getFXData());
    }

    @Override
    public void func_70636_d() {
        block138: {
            block139: {
                super.func_70636_d();
                if (this.field_70173_aa != 1) break block138;
                if (!this.field_70170_p.field_72995_K) break block139;
                switch (this.getFX()) {
                    case 0: {
                        int i;
                        for (i = 0; i < 10; ++i) {
                            this.field_70170_p.func_175682_a(ParticleInit.VENOM, true, this.field_70165_t + this.getROD(4), this.field_70163_u + this.getROD(1), this.field_70161_v + this.getROD(4), 0.0, 0.0, 0.0, new int[0]);
                        }
                        for (i = 0; i < 5; ++i) {
                            this.field_70170_p.func_175682_a(ParticleInit.VENOM_RING, true, this.field_70165_t + this.getROD(1), this.field_70163_u + this.getROD(1), this.field_70161_v + this.getROD(1), 0.0, 0.0, 0.0, new int[0]);
                        }
                        break block138;
                    }
                    case 1: {
                        for (int i = 0; i < 4; ++i) {
                            this.field_70170_p.func_175682_a(ParticleInit.PLASMA_EXPLOSION, true, this.field_70165_t, this.field_70163_u, this.field_70161_v, 0.0, 0.0, 0.0, new int[]{2});
                        }
                        break block138;
                    }
                    case 2: {
                        for (int i = 0; i < 5 + this.getFXData(); ++i) {
                            this.field_70170_p.func_175682_a(EnumParticleTypes.DRAGON_BREATH, true, this.field_70165_t + this.getROD(1), this.field_70163_u + 0.75, this.field_70161_v + this.getROD(1), this.getROD(1), Math.abs(this.getROD(1)), this.getROD(1), new int[0]);
                        }
                        if (this.getFXData() == 0) break;
                        this.field_70170_p.func_175682_a(EnumParticleTypes.EXPLOSION_HUGE, true, this.field_70165_t, this.field_70163_u, this.field_70161_v, 0.0, 0.0, 0.0, new int[0]);
                        break;
                    }
                    case 3: {
                        for (int i = 0; i < 10; ++i) {
                            this.field_70170_p.func_175682_a(ParticleInit.QUANTUM_MARK, true, this.field_70165_t + this.getROD(2), this.field_70163_u + this.getROD(1), this.field_70161_v + this.getROD(2), 0.0, 0.0, 0.0, new int[0]);
                        }
                        break block138;
                    }
                    case 4: {
                        for (int i = 0; i < 3; ++i) {
                            this.field_70170_p.func_175682_a(ParticleInit.ATTRACT_FIELD, true, this.field_70165_t + this.getROD(1), this.field_70163_u + this.getROD(1), this.field_70161_v + this.getROD(1), 0.0, 0.0, 0.0, new int[0]);
                        }
                        break block138;
                    }
                    case 5: {
                        for (int i = 0; i < 3; ++i) {
                            this.field_70170_p.func_175682_a(ParticleInit.REPEL_FIELD, true, this.field_70165_t + this.getROD(1), this.field_70163_u + this.getROD(1), this.field_70161_v + this.getROD(1), 0.0, 0.0, 0.0, new int[0]);
                        }
                        break block138;
                    }
                    case 6: {
                        for (int i = 0; i < 2; ++i) {
                            this.field_70170_p.func_175682_a(ParticleInit.SLAM, true, this.field_70165_t + this.getROD(1), this.field_70163_u + this.getROD(1), this.field_70161_v + this.getROD(1), 0.0, 0.0, 0.0, new int[0]);
                        }
                        break block138;
                    }
                    case 7: {
                        this.field_70170_p.func_175682_a(ParticleInit.WARP, true, this.field_70165_t, this.field_70163_u, this.field_70161_v, 0.0, 0.0, 0.0, new int[0]);
                        break;
                    }
                    case 8: {
                        for (int i = 0; i < 5; ++i) {
                            this.field_70170_p.func_175682_a(ParticleInit.GOO_RING, true, this.field_70165_t + this.getROD(2), this.field_70163_u + this.getROD(1), this.field_70161_v + this.getROD(2), 0.0, 0.0, 0.0, new int[0]);
                        }
                        break block138;
                    }
                    case 9: {
                        this.field_70170_p.func_175682_a(ParticleInit.EXPLOSION, true, this.field_70165_t, this.field_70163_u, this.field_70161_v, 0.0, 0.0, 0.0, new int[0]);
                        break;
                    }
                    case 10: {
                        for (int i = 0; i < 3; ++i) {
                            this.field_70170_p.func_175682_a(ParticleInit.EXPLOSION_RING, true, this.field_70165_t + this.getROD(2), this.field_70163_u + this.getROD(1), this.field_70161_v + this.getROD(2), 0.0, 0.0, 0.0, new int[0]);
                        }
                        break block138;
                    }
                    case 11: {
                        for (int i = 0; i < 5; ++i) {
                            this.field_70170_p.func_175682_a(ParticleInit.ZAP, true, this.field_70165_t + this.getROD(3), this.field_70163_u + this.getROD(1), this.field_70161_v + this.getROD(3), 0.0, 0.0, 0.0, new int[0]);
                        }
                        break block138;
                    }
                    case 12: {
                        this.field_70170_p.func_175682_a(ParticleInit.DARK_MAGIC, true, this.field_70165_t, this.field_70163_u, this.field_70161_v, 0.0, 0.0, 0.0, new int[0]);
                        this.field_70170_p.func_175682_a(ParticleInit.PLAGUE, true, this.field_70165_t, this.field_70163_u, this.field_70161_v, 0.0, 0.0, 0.0, new int[0]);
                        break;
                    }
                    case 13: {
                        for (int i = 0; i < 3; ++i) {
                            this.field_70170_p.func_175682_a(ParticleInit.GLOOM_BURST, true, this.field_70165_t + this.getROD(1), this.field_70163_u + this.getROD(1), this.field_70161_v + this.getROD(1), 0.0, 0.0, 0.0, new int[0]);
                        }
                        break block138;
                    }
                    case 14: {
                        for (int i = 0; i < 10; ++i) {
                            this.field_70170_p.func_175682_a(ParticleInit.LIGHT_FLASH, true, this.field_70165_t + this.getROD(4), this.field_70163_u + this.getROD(1), this.field_70161_v + this.getROD(4), 0.0, 0.0, 0.0, new int[0]);
                        }
                        break block138;
                    }
                    case 15: {
                        for (int i = 0; i < 10; ++i) {
                            this.field_70170_p.func_175682_a(ParticleInit.DARK_FLASH, true, this.field_70165_t + this.getROD(4), this.field_70163_u + this.getROD(1), this.field_70161_v + this.getROD(4), 0.0, 0.0, 0.0, new int[0]);
                        }
                        break block138;
                    }
                    case 16: {
                        for (int i = 0; i < 1 + this.getFXData(); ++i) {
                            this.field_70170_p.func_175682_a(ParticleInit.FLAME_SMALL, true, this.field_70165_t + this.getROD(1), this.field_70163_u, this.field_70161_v + this.getROD(1), (double)0.3f * this.getROD(1), 0.0, (double)0.3f * this.getROD(1), new int[0]);
                        }
                        break block138;
                    }
                    case 17: {
                        for (int i = 0; i < 1 + 2 * this.getFXData(); ++i) {
                            this.field_70170_p.func_175682_a(ParticleInit.FLAME_MEDIUM, true, this.field_70165_t + this.getROD(1), this.field_70163_u, this.field_70161_v + this.getROD(1), (double)0.3f * this.getROD(1), 0.0, (double)0.3f * this.getROD(1), new int[0]);
                        }
                        break block138;
                    }
                    case 18: {
                        for (int i = 0; i < 1 + 4 * this.getFXData(); ++i) {
                            this.field_70170_p.func_175682_a(ParticleInit.FLAME_LARGE, true, this.field_70165_t + this.getROD(1), this.field_70163_u, this.field_70161_v + this.getROD(1), (double)0.3f * this.getROD(1), 0.0, (double)0.3f * this.getROD(1), new int[0]);
                        }
                        break block138;
                    }
                    case 19: {
                        for (int i = 0; i < 8; ++i) {
                            this.field_70170_p.func_175688_a(ParticleInit.FIREGOO, this.field_70165_t + this.getROD(1), this.field_70163_u + this.getROD(1), this.field_70161_v + this.getROD(1), this.getROD(1), this.getROD(1), this.getROD(1), new int[0]);
                        }
                        break block138;
                    }
                    case 20: {
                        this.field_70170_p.func_175682_a(ParticleInit.BOMBER_EXPLOSION, true, this.field_70165_t + 0.5, this.field_70163_u, this.field_70161_v + 0.5, 0.0, 0.0, 0.0, new int[0]);
                        break;
                    }
                    case 21: {
                        this.field_70170_p.func_175682_a(ParticleInit.GLOMITE_WARP, true, this.field_70165_t, this.field_70163_u, this.field_70161_v, 0.0, 0.0, 0.0, new int[0]);
                        break;
                    }
                    case 22: {
                        for (int i = 0; i < 8; ++i) {
                            this.field_70170_p.func_175682_a(ParticleInit.SPACE_MAGIC, true, this.field_70165_t + this.getROD(4), this.field_70163_u + this.getROD(1), this.field_70161_v + this.getROD(4), 0.0, 0.0, 0.0, new int[0]);
                        }
                        break block138;
                    }
                    case 23: {
                        this.field_70170_p.func_175682_a(ParticleInit.POWER_FIELD, true, this.field_70165_t, this.field_70163_u, this.field_70161_v, 0.0, 0.0, 0.0, new int[0]);
                        break;
                    }
                    case 24: {
                        this.field_70170_p.func_175682_a(ParticleInit.POWER_LOSS, true, this.field_70165_t, this.field_70163_u, this.field_70161_v, 0.0, 0.0, 0.0, new int[0]);
                        break;
                    }
                    case 25: {
                        for (int i = 0; i < 8; ++i) {
                            this.field_70170_p.func_175682_a(ParticleInit.PLAGUE, true, this.field_70165_t, this.field_70163_u, this.field_70161_v, 0.0, 0.0, 0.0, new int[0]);
                        }
                        break block138;
                    }
                    case 26: {
                        for (int i = 0; i < 14; ++i) {
                            this.field_70170_p.func_175682_a(ParticleInit.ANCIENT_SPELL, true, this.field_70165_t + this.getROD(1), this.field_70163_u, this.field_70161_v + this.getROD(1), (double)0.3f * this.getROD(1), 0.0, (double)0.3f * this.getROD(1), new int[0]);
                        }
                        break block138;
                    }
                    case 27: {
                        for (int i = 0; i < 8; ++i) {
                            this.field_70170_p.func_175682_a(ParticleInit.CLAW_MARKS, true, this.field_70165_t + this.getROD(4), this.field_70163_u + this.getROD(1), this.field_70161_v + this.getROD(4), 0.0, 0.0, 0.0, new int[0]);
                        }
                        break block138;
                    }
                    case 28: {
                        for (int i = 0; i < 3; ++i) {
                            this.field_70170_p.func_175682_a(this.field_70146_Z.nextBoolean() ? ParticleInit.ELECTRIC_EXPLOSION_BLUE : ParticleInit.ELECTRIC_EXPLOSION_YELLOW, true, this.field_70165_t + this.getROD(2), this.field_70163_u + this.getROD(1), this.field_70161_v + this.getROD(2), 0.0, 0.0, 0.0, new int[0]);
                        }
                        break block138;
                    }
                    case 29: {
                        for (int i = 0; i < 10; ++i) {
                            this.field_70170_p.func_175682_a(ParticleInit.CORRUPTION_MAGIC, true, this.field_70165_t + this.getROD(4), this.field_70163_u + this.getROD(1), this.field_70161_v + this.getROD(4), 0.0, 0.0, 0.0, new int[0]);
                        }
                        break block138;
                    }
                    case 30: {
                        for (int i = 0; i < 3; ++i) {
                            this.field_70170_p.func_175682_a(ParticleInit.NATURE_RING, true, this.field_70165_t, this.field_70163_u, this.field_70161_v, 0.0, 0.0, 0.0, new int[0]);
                        }
                        break block138;
                    }
                    case 31: {
                        for (int i = 0; i < 10; ++i) {
                            this.field_70170_p.func_175682_a(ParticleInit.NATURE_MAGIC, true, this.field_70165_t + this.getROD(4), this.field_70163_u + this.getROD(1), this.field_70161_v + this.getROD(4), 0.0, 0.0, 0.0, new int[0]);
                        }
                        break block138;
                    }
                    case 32: {
                        for (int i = 0; i < 10; ++i) {
                            this.field_70170_p.func_175682_a(ParticleInit.CRYSTAL_MAGIC, true, this.field_70165_t + this.getROD(4), this.field_70163_u + this.getROD(1), this.field_70161_v + this.getROD(4), 0.0, 0.0, 0.0, new int[0]);
                        }
                        break block138;
                    }
                    case 33: {
                        for (int i = 0; i < 2; ++i) {
                            this.field_70170_p.func_175682_a(ParticleInit.VENOM, true, this.field_70165_t + this.getROD(4), this.field_70163_u + this.getROD(1), this.field_70161_v + this.getROD(4), 0.0, 0.0, 0.0, new int[0]);
                        }
                        this.field_70170_p.func_175682_a(ParticleInit.VENOM_RING, true, this.field_70165_t + this.getROD(1), this.field_70163_u + this.getROD(1), this.field_70161_v + this.getROD(1), 0.0, 0.0, 0.0, new int[0]);
                        break;
                    }
                    case 34: {
                        this.field_70170_p.func_175682_a(ParticleInit.SHADOW_BLAST, true, this.field_70165_t + this.getROD(1), this.field_70163_u + this.getROD(1), this.field_70161_v + this.getROD(1), 0.0, 0.0, 0.0, new int[0]);
                        break;
                    }
                    case 35: {
                        for (int i = 0; i < 10; ++i) {
                            this.field_70170_p.func_175682_a(ParticleInit.POISON_BUBBLE, true, this.field_70165_t + this.getROD(4), this.field_70163_u + this.getROD(1), this.field_70161_v + this.getROD(4), 0.0, 0.0, 0.0, new int[0]);
                        }
                        break block138;
                    }
                    case 36: {
                        for (int i = 0; i < 12; ++i) {
                            this.field_70170_p.func_175682_a(ParticleInit.PURPLE_SKULL, true, this.field_70165_t + this.getROD(4), this.field_70163_u + this.getROD(1), this.field_70161_v + this.getROD(4), 0.0, 0.0, 0.0, new int[0]);
                        }
                        break block138;
                    }
                    case 37: {
                        for (int i = 0; i < 4; ++i) {
                            this.field_70170_p.func_175682_a(ParticleInit.BLIGHT_SPELL_GREEN, true, this.field_70165_t + this.getROD(4), this.field_70163_u + this.getROD(1), this.field_70161_v + this.getROD(4), 0.0, 0.0, 0.0, new int[0]);
                        }
                        break block138;
                    }
                    case 38: {
                        for (int i = 0; i < 5; ++i) {
                            this.field_70170_p.func_175682_a(ParticleInit.DARK_MAGIC, true, this.field_70165_t + this.getROD(4), this.field_70163_u + this.getROD(1), this.field_70161_v + this.getROD(4), 0.0, 0.0, 0.0, new int[0]);
                        }
                        break block138;
                    }
                    case 39: {
                        this.field_70170_p.func_175682_a(ParticleInit.BLUE_SKULL, true, this.field_70165_t + this.getROD(1), this.field_70163_u + this.getROD(1), this.field_70161_v + this.getROD(1), 0.0, 0.0, 0.0, new int[0]);
                        break;
                    }
                    case 40: {
                        for (int i = 0; i < 5; ++i) {
                            this.field_70170_p.func_175682_a(ParticleInit.ION_BLAST, true, this.field_70165_t + this.getROD(6), this.field_70163_u + this.getROD(4), this.field_70161_v + this.getROD(6), 0.0, 0.0, 0.0, new int[0]);
                        }
                        break block138;
                    }
                    case 41: {
                        for (int i = 0; i < 5; ++i) {
                            this.field_70170_p.func_175682_a(ParticleInit.NUCLEAR_BLAST, true, this.field_70165_t + this.getROD(1), this.field_70163_u + this.getROD(1), this.field_70161_v + this.getROD(1), 0.0, 0.0, 0.0, new int[0]);
                        }
                        break block138;
                    }
                    case 42: {
                        for (int i = 0; i < 10; ++i) {
                            this.field_70170_p.func_175682_a(ParticleInit.EXPLOSION, true, this.field_70165_t + this.getROD(8), this.field_70163_u + this.getROD(2), this.field_70161_v + this.getROD(8), 0.0, 0.0, 0.0, new int[0]);
                        }
                        break block138;
                    }
                    case 43: {
                        for (int i = 0; i < 8; ++i) {
                            this.field_70170_p.func_175682_a(ParticleInit.PLASMA_RIFT, true, this.field_70165_t + this.getROD(3), this.field_70163_u + this.getROD(1), this.field_70161_v + this.getROD(3), 0.0, 0.0, 0.0, new int[0]);
                        }
                        break block138;
                    }
                    case 44: {
                        for (int i = 0; i < 20; ++i) {
                            this.field_70170_p.func_175682_a(ParticleInit.MURK, true, this.field_70165_t + this.getROD(5), this.field_70163_u + this.getROD(2), this.field_70161_v + this.getROD(5), 0.0, 0.0, 0.0, new int[0]);
                        }
                        break block138;
                    }
                    case 45: {
                        this.field_70170_p.func_175682_a(ParticleInit.SPECTRAL, true, this.field_70165_t + this.getROD(1), this.field_70163_u + this.getROD(1), this.field_70161_v + this.getROD(1), 0.0, 0.0, 0.0, new int[0]);
                        break;
                    }
                    case 46: {
                        block117: for (int i = 0; i < 5; ++i) {
                            switch (this.field_70146_Z.nextInt(3)) {
                                case 0: {
                                    this.field_70170_p.func_175682_a(ParticleInit.PRISMATIC_EXPLOSION_TYPE1, true, this.field_70165_t + this.getROD(1), this.field_70163_u + this.getROD(1), this.field_70161_v + this.getROD(1), 0.0, 0.0, 0.0, new int[0]);
                                    continue block117;
                                }
                                case 1: {
                                    this.field_70170_p.func_175682_a(ParticleInit.PRISMATIC_EXPLOSION_TYPE2, true, this.field_70165_t + this.getROD(1), this.field_70163_u + this.getROD(1), this.field_70161_v + this.getROD(1), 0.0, 0.0, 0.0, new int[0]);
                                    continue block117;
                                }
                                case 2: {
                                    this.field_70170_p.func_175682_a(ParticleInit.PRISMATIC_EXPLOSION_TYPE3, true, this.field_70165_t + this.getROD(1), this.field_70163_u + this.getROD(1), this.field_70161_v + this.getROD(1), 0.0, 0.0, 0.0, new int[0]);
                                }
                            }
                        }
                        break block138;
                    }
                    case 47: {
                        for (int i = 0; i < 5; ++i) {
                            this.field_70170_p.func_175682_a(ParticleInit.PRISMATIC_EXPLOSION_TYPE1, true, this.field_70165_t + this.getROD(1), this.field_70163_u + this.getROD(1), this.field_70161_v + this.getROD(1), 0.0, 0.0, 0.0, new int[0]);
                        }
                        break block138;
                    }
                    case 48: {
                        for (int i = 0; i < 5; ++i) {
                            this.field_70170_p.func_175682_a(ParticleInit.PRISMATIC_EXPLOSION_TYPE2, true, this.field_70165_t + this.getROD(1), this.field_70163_u + this.getROD(1), this.field_70161_v + this.getROD(1), 0.0, 0.0, 0.0, new int[0]);
                        }
                        break block138;
                    }
                    case 49: {
                        for (int i = 0; i < 5; ++i) {
                            this.field_70170_p.func_175682_a(ParticleInit.PRISMATIC_EXPLOSION_TYPE3, true, this.field_70165_t + this.getROD(1), this.field_70163_u + this.getROD(1), this.field_70161_v + this.getROD(1), 0.0, 0.0, 0.0, new int[0]);
                        }
                        break block138;
                    }
                    case 50: {
                        for (int i = 0; i < 5; ++i) {
                            this.field_70170_p.func_175682_a(ParticleInit.EXPLOSION_RING_DARK, true, this.field_70165_t + this.getROD(1), this.field_70163_u + this.getROD(1), this.field_70161_v + this.getROD(1), 0.0, 0.0, 0.0, new int[0]);
                        }
                        break block138;
                    }
                    case 51: {
                        int i;
                        for (i = 0; i < 3; ++i) {
                            if (this.field_70146_Z.nextBoolean()) {
                                this.field_70170_p.func_175682_a(ParticleInit.EXPLOSION_BLUE, true, this.field_70165_t + this.getROD(5), this.field_70163_u + this.getROD(1), this.field_70161_v + this.getROD(5), 0.0, 0.0, 0.0, new int[0]);
                                continue;
                            }
                            this.field_70170_p.func_175682_a(ParticleInit.EXPLOSION_TEAL, true, this.field_70165_t + this.getROD(5), this.field_70163_u + this.getROD(1), this.field_70161_v + this.getROD(5), 0.0, 0.0, 0.0, new int[0]);
                        }
                        for (i = 0; i < 7; ++i) {
                            this.field_70170_p.func_175682_a(ParticleInit.MURK, true, this.field_70165_t + this.getROD(10), this.field_70163_u + this.getROD(2), this.field_70161_v + this.getROD(10), 0.0, 0.0, 0.0, new int[0]);
                        }
                        break block138;
                    }
                    case 52: {
                        for (int i = 0; i < 2; ++i) {
                            this.field_70170_p.func_175682_a(ParticleInit.CLAW_MARKS, true, this.field_70165_t + this.getROD(2), this.field_70163_u + this.getROD(1), this.field_70161_v + this.getROD(2), 0.0, 0.0, 0.0, new int[0]);
                            this.field_70170_p.func_175682_a(ParticleInit.BLOOD_DROP, true, this.field_70165_t + this.getROD(2), this.field_70163_u + this.getROD(1), this.field_70161_v + this.getROD(2), 0.0, 0.0, 0.0, new int[0]);
                        }
                        break block138;
                    }
                    case 53: {
                        for (int i = 0; i < 10; ++i) {
                            this.field_70170_p.func_175682_a(ParticleInit.ION_BLAST, true, this.field_70165_t + this.getROD(6), this.field_70163_u + this.getROD(4), this.field_70161_v + this.getROD(6), 0.0, 0.0, 0.0, new int[0]);
                            this.field_70170_p.func_175682_a(ParticleInit.EXPLOSION_LAVENDER, true, this.field_70165_t + this.getROD(5), this.field_70163_u + this.getROD(1), this.field_70161_v + this.getROD(5), 0.0, 0.0, 0.0, new int[0]);
                        }
                        break block138;
                    }
                    case 54: {
                        int i;
                        for (i = 0; i < 15; ++i) {
                            this.field_70170_p.func_175682_a(ParticleInit.POISON_EXPLOSION, true, this.field_70165_t + this.getROD(15), this.field_70163_u + this.getROD(2), this.field_70161_v + this.getROD(15), 0.0, 0.0, 0.0, new int[0]);
                        }
                    }
                    case 55: {
                        int i;
                        switch (this.field_70146_Z.nextInt(4)) {
                            case 0: {
                                this.field_70170_p.func_175682_a(ParticleInit.COSMIC_EXPLOSION_TYPE1, true, this.field_70165_t + this.getROD(5), this.field_70163_u + this.getROD(1), this.field_70161_v + this.getROD(5), 0.0, 0.0, 0.0, new int[0]);
                                break;
                            }
                            case 1: {
                                this.field_70170_p.func_175682_a(ParticleInit.COSMIC_EXPLOSION_TYPE2, true, this.field_70165_t + this.getROD(5), this.field_70163_u + this.getROD(1), this.field_70161_v + this.getROD(5), 0.0, 0.0, 0.0, new int[0]);
                                break;
                            }
                            case 2: {
                                this.field_70170_p.func_175682_a(ParticleInit.COSMIC_EXPLOSION_TYPE3, true, this.field_70165_t + this.getROD(5), this.field_70163_u + this.getROD(1), this.field_70161_v + this.getROD(5), 0.0, 0.0, 0.0, new int[0]);
                                break;
                            }
                            case 3: {
                                this.field_70170_p.func_175682_a(ParticleInit.COSMIC_EXPLOSION_TYPE4, true, this.field_70165_t + this.getROD(5), this.field_70163_u + this.getROD(1), this.field_70161_v + this.getROD(5), 0.0, 0.0, 0.0, new int[0]);
                            }
                        }
                        block127: for (i = 0; i < 4; ++i) {
                            switch (this.field_70146_Z.nextInt(4)) {
                                case 0: {
                                    this.field_70170_p.func_175682_a(ParticleInit.BASIC_STAR_TYPE1, true, this.field_70165_t + this.getROD(5), this.field_70163_u + this.getROD(3), this.field_70161_v + this.getROD(5), 0.0, 0.0, 0.0, new int[0]);
                                    continue block127;
                                }
                                case 1: {
                                    this.field_70170_p.func_175682_a(ParticleInit.BASIC_STAR_TYPE2, true, this.field_70165_t + this.getROD(5), this.field_70163_u + this.getROD(3), this.field_70161_v + this.getROD(5), 0.0, 0.0, 0.0, new int[0]);
                                    continue block127;
                                }
                                case 2: {
                                    this.field_70170_p.func_175682_a(ParticleInit.BASIC_STAR_TYPE3, true, this.field_70165_t + this.getROD(5), this.field_70163_u + this.getROD(3), this.field_70161_v + this.getROD(5), 0.0, 0.0, 0.0, new int[0]);
                                    continue block127;
                                }
                                case 3: {
                                    this.field_70170_p.func_175682_a(ParticleInit.BASIC_STAR_TYPE4, true, this.field_70165_t + this.getROD(5), this.field_70163_u + this.getROD(3), this.field_70161_v + this.getROD(5), 0.0, 0.0, 0.0, new int[0]);
                                }
                            }
                        }
                        break block138;
                    }
                    case 56: {
                        int i;
                        for (i = 0; i < 4; ++i) {
                            this.field_70170_p.func_175682_a(ParticleInit.VENOM_RING, true, this.field_70165_t + this.getROD(15), this.field_70163_u + this.getROD(2), this.field_70161_v + this.getROD(15), 0.0, 0.0, 0.0, new int[0]);
                            this.field_70170_p.func_175682_a(ParticleInit.EXPLOSION_RING_DARK, true, this.field_70165_t + this.getROD(15), this.field_70163_u + this.getROD(2), this.field_70161_v + this.getROD(15), 0.0, 0.0, 0.0, new int[0]);
                        }
                    }
                    case 57: {
                        int i;
                        for (i = 0; i < 5; ++i) {
                            this.field_70170_p.func_175682_a(ParticleInit.MIASMA, true, this.field_70165_t + this.getROD(4), this.field_70163_u + this.getROD(1), this.field_70161_v + this.getROD(4), 0.0, 0.0, 0.0, new int[0]);
                        }
                        break block138;
                    }
                    case 58: {
                        if (this.field_70146_Z.nextBoolean()) {
                            for (int i = 0; i < 2; ++i) {
                                this.field_70170_p.func_175682_a(ParticleInit.SUPERSONIC_BLUE, true, this.field_70165_t, this.field_70163_u, this.field_70161_v, 0.0, 0.0, 0.0, new int[0]);
                            }
                        } else {
                            for (int i = 0; i < 2; ++i) {
                                this.field_70170_p.func_175682_a(ParticleInit.SUPERSONIC_RED, true, this.field_70165_t, this.field_70163_u, this.field_70161_v, 0.0, 0.0, 0.0, new int[0]);
                            }
                        }
                        break block138;
                    }
                    case 59: {
                        for (int i = 0; i < 15; ++i) {
                            if (this.field_70146_Z.nextBoolean()) {
                                this.field_70170_p.func_175682_a(ParticleInit.EXPLOSION_RED, true, this.field_70165_t + this.getROD(25), this.field_70163_u + this.getROD(4), this.field_70161_v + this.getROD(25), 0.0, 0.0, 0.0, new int[0]);
                                continue;
                            }
                            this.field_70170_p.func_175682_a(ParticleInit.EXPLOSION_ORANGE, true, this.field_70165_t + this.getROD(25), this.field_70163_u + this.getROD(4), this.field_70161_v + this.getROD(25), 0.0, 0.0, 0.0, new int[0]);
                        }
                        break block138;
                    }
                    case 60: {
                        this.field_70170_p.func_175682_a(ParticleInit.POWER_FIELD, true, this.field_70165_t, this.field_70163_u, this.field_70161_v, 0.0, 0.0, 0.0, new int[0]);
                        for (int i = 0; i < 12; ++i) {
                            this.field_70170_p.func_175682_a(this.field_70146_Z.nextBoolean() ? ParticleInit.EXPLOSION_BLUE : ParticleInit.EXPLOSION_LAVENDER, true, this.field_70165_t + this.getROD(18), this.field_70163_u + this.getROD(2), this.field_70161_v + this.getROD(18), 0.0, 0.0, 0.0, new int[0]);
                        }
                        break;
                    }
                }
                break block138;
            }
            this.func_70106_y();
        }
    }

    @Override
    public boolean func_70067_L() {
        return false;
    }

    @Override
    public boolean func_70104_M() {
        return false;
    }

    private double getROD(int multi) {
        return (-0.5 + this.field_70146_Z.nextDouble()) * (double)multi;
    }
}

