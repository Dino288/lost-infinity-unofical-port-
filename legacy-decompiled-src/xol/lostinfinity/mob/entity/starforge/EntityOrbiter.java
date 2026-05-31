/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.item.ItemEntity
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.starforge;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.Level;
import xol.lostinfinity.block.harvest.BlockCatatoniteOre;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.ai.EntityAIFloatAttack;
import xol.lostinfinity.mob.entity.base.EntityFloatingBase;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.load.LootTableRegistry;

public class EntityOrbiter
extends EntityFloatingBase
implements IMaxAttack {
    private int recentDash = 0;
    boolean hitBlock = false;
    private Vec3 dir = null;
    private BlockPos recentlyKnocked = null;

    public EntityOrbiter(Level worldIn) {
        super(worldIn);
        this.func_70105_a(1.85f, 1.85f);
        this.rawFlySpeed = 0.6f;
    }

    public boolean func_70652_k(Entity entity) {
        super.func_70652_k(entity);
        if (this.func_70638_az() != null) {
            if (this.recentDash > 0) {
                IMaxAttack.dealMaxHealth((Entity)this, this.func_70638_az(), 1);
            } else {
                IMaxAttack.dealMaxHealth((Entity)this, this.func_70638_az(), 2);
            }
            return true;
        }
        return false;
    }

    @Override
    public void func_70636_d() {
        super.func_70636_d();
        if (!this.field_70170_p.field_72995_K) {
            if (this.recentDash > 0) {
                --this.recentDash;
            }
            if (this.func_70638_az() != null) {
                int tickRem;
                if (!this.hitBlock && this.recentDash > 0) {
                    int meta;
                    if (!(this.field_70170_p.func_180495_p(this.func_180425_c()).func_177230_c() != BlockInit.bumblefruit || this.recentlyKnocked != null && this.recentlyKnocked.equals((Object)this.func_180425_c()))) {
                        this.recentlyKnocked = this.func_180425_c();
                        ItemEntity blossom = new ItemEntity(this.field_70170_p, this.field_70165_t, this.field_70163_u, this.field_70161_v, new ItemStack(ItemInit.bumbleBlossom, 1));
                        blossom.field_70159_w = this.field_70159_w / 2.0;
                        blossom.field_70181_x = this.field_70181_x / 2.0;
                        blossom.field_70179_y = this.field_70179_y / 2.0;
                        this.field_70170_p.func_72838_d((Entity)blossom);
                    }
                    Vec3 forward = this.dir;
                    BlockPos forwardBlock = new BlockPos(this.field_70165_t + forward.field_72450_a * 1.85, this.field_70163_u + forward.field_72448_b * 1.85 + 0.5, this.field_70161_v + forward.field_72449_c * 1.85);
                    BlockState state = this.field_70170_p.func_180495_p(forwardBlock);
                    Block block = state.func_177230_c();
                    if (block instanceof BlockCatatoniteOre) {
                        meta = ((BlockCatatoniteOre)block).func_176201_c(state);
                        if (meta < 3) {
                            this.field_70170_p.func_175656_a(forwardBlock, ((BlockCatatoniteOre)block).func_176203_a(meta + 1));
                            this.field_70170_p.func_184133_a(null, forwardBlock, SoundInit.ROCK_TUMBLE, SoundSource.BLOCKS, 1.5f, 0.8f + this.field_70170_p.field_73012_v.nextFloat() * 0.4f);
                        }
                        this.hitBlock = true;
                    }
                    if ((block = (state = this.field_70170_p.func_180495_p(forwardBlock.func_177977_b())).func_177230_c()) instanceof BlockCatatoniteOre) {
                        meta = ((BlockCatatoniteOre)block).func_176201_c(state);
                        if (meta < 3) {
                            this.field_70170_p.func_175656_a(forwardBlock.func_177977_b(), ((BlockCatatoniteOre)block).func_176203_a(meta + 1));
                            this.field_70170_p.func_184133_a(null, forwardBlock, SoundInit.ROCK_TUMBLE, SoundSource.BLOCKS, 1.5f, 0.8f + this.field_70170_p.field_73012_v.nextFloat() * 0.4f);
                        }
                        this.hitBlock = true;
                    }
                    if ((block = (state = this.field_70170_p.func_180495_p(forwardBlock.func_177984_a())).func_177230_c()) instanceof BlockCatatoniteOre) {
                        meta = ((BlockCatatoniteOre)block).func_176201_c(state);
                        if (meta < 3) {
                            this.field_70170_p.func_175656_a(forwardBlock.func_177984_a(), ((BlockCatatoniteOre)block).func_176203_a(meta + 1));
                            this.field_70170_p.func_184133_a(null, forwardBlock, SoundInit.ROCK_TUMBLE, SoundSource.BLOCKS, 1.5f, 0.8f + this.field_70170_p.field_73012_v.nextFloat() * 0.4f);
                        }
                        this.hitBlock = true;
                    }
                    if ((block = (state = this.field_70170_p.func_180495_p(forwardBlock.func_177974_f())).func_177230_c()) instanceof BlockCatatoniteOre) {
                        meta = ((BlockCatatoniteOre)block).func_176201_c(state);
                        if (meta < 3) {
                            this.field_70170_p.func_175656_a(forwardBlock.func_177974_f(), ((BlockCatatoniteOre)block).func_176203_a(meta + 1));
                            this.field_70170_p.func_184133_a(null, forwardBlock, SoundInit.ROCK_TUMBLE, SoundSource.BLOCKS, 1.5f, 0.8f + this.field_70170_p.field_73012_v.nextFloat() * 0.4f);
                        }
                        this.hitBlock = true;
                    }
                    if ((block = (state = this.field_70170_p.func_180495_p(forwardBlock.func_177976_e())).func_177230_c()) instanceof BlockCatatoniteOre) {
                        meta = ((BlockCatatoniteOre)block).func_176201_c(state);
                        if (meta < 3) {
                            this.field_70170_p.func_175656_a(forwardBlock.func_177976_e(), ((BlockCatatoniteOre)block).func_176203_a(meta + 1));
                            this.field_70170_p.func_184133_a(null, forwardBlock, SoundInit.ROCK_TUMBLE, SoundSource.BLOCKS, 1.5f, 0.8f + this.field_70170_p.field_73012_v.nextFloat() * 0.4f);
                        }
                        this.hitBlock = true;
                    }
                    if ((block = (state = this.field_70170_p.func_180495_p(forwardBlock.func_177976_e().func_177984_a())).func_177230_c()) instanceof BlockCatatoniteOre) {
                        meta = ((BlockCatatoniteOre)block).func_176201_c(state);
                        if (meta < 3) {
                            this.field_70170_p.func_175656_a(forwardBlock.func_177976_e().func_177984_a(), ((BlockCatatoniteOre)block).func_176203_a(meta + 1));
                            this.field_70170_p.func_184133_a(null, forwardBlock, SoundInit.ROCK_TUMBLE, SoundSource.BLOCKS, 1.5f, 0.8f + this.field_70170_p.field_73012_v.nextFloat() * 0.4f);
                        }
                        this.hitBlock = true;
                    }
                    if ((block = (state = this.field_70170_p.func_180495_p(forwardBlock.func_177976_e().func_177977_b())).func_177230_c()) instanceof BlockCatatoniteOre) {
                        meta = ((BlockCatatoniteOre)block).func_176201_c(state);
                        if (meta < 3) {
                            this.field_70170_p.func_175656_a(forwardBlock.func_177976_e().func_177977_b(), ((BlockCatatoniteOre)block).func_176203_a(meta + 1));
                            this.field_70170_p.func_184133_a(null, forwardBlock, SoundInit.ROCK_TUMBLE, SoundSource.BLOCKS, 1.5f, 0.8f + this.field_70170_p.field_73012_v.nextFloat() * 0.4f);
                        }
                        this.hitBlock = true;
                    }
                    if ((block = (state = this.field_70170_p.func_180495_p(forwardBlock.func_177974_f().func_177984_a())).func_177230_c()) instanceof BlockCatatoniteOre) {
                        meta = ((BlockCatatoniteOre)block).func_176201_c(state);
                        if (meta < 3) {
                            this.field_70170_p.func_175656_a(forwardBlock.func_177974_f().func_177984_a(), ((BlockCatatoniteOre)block).func_176203_a(meta + 1));
                            this.field_70170_p.func_184133_a(null, forwardBlock, SoundInit.ROCK_TUMBLE, SoundSource.BLOCKS, 1.5f, 0.8f + this.field_70170_p.field_73012_v.nextFloat() * 0.4f);
                        }
                        this.hitBlock = true;
                    }
                    if ((block = (state = this.field_70170_p.func_180495_p(forwardBlock.func_177974_f().func_177977_b())).func_177230_c()) instanceof BlockCatatoniteOre) {
                        meta = ((BlockCatatoniteOre)block).func_176201_c(state);
                        if (meta < 3) {
                            this.field_70170_p.func_175656_a(forwardBlock.func_177974_f().func_177977_b(), ((BlockCatatoniteOre)block).func_176203_a(meta + 1));
                            this.field_70170_p.func_184133_a(null, forwardBlock, SoundInit.ROCK_TUMBLE, SoundSource.BLOCKS, 1.5f, 0.8f + this.field_70170_p.field_73012_v.nextFloat() * 0.4f);
                        }
                        this.hitBlock = true;
                    }
                }
                if ((tickRem = this.field_70173_aa % 120) <= 50) {
                    if (this.dir != null) {
                        this.func_70024_g(this.dir.field_72450_a / 6.0, this.dir.field_72448_b / 6.0, this.dir.field_72449_c / 6.0);
                        this.field_70133_I = true;
                    }
                    if (tickRem == 0) {
                        this.dir = this.func_70638_az().func_174791_d().func_178788_d(this.func_174791_d()).func_72432_b();
                        this.recentDash = 50;
                        this.hitBlock = false;
                        this.func_184185_a(SoundInit.ORBITER_ATTACK, 1.0f, 0.8f + 0.4f * this.field_70146_Z.nextFloat());
                    }
                }
            }
        }
    }

    @Override
    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(4000.0);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(1.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.25);
        this.func_110148_a(SharedMonsterAttributes.field_111266_c).func_111128_a(1.0);
    }

    public int getRecentDash() {
        return this.recentDash;
    }

    protected SoundEvent func_184615_bR() {
        return SoundInit.ORBITER_DEATH;
    }

    protected SoundEvent func_184601_bQ(DamageSource damageSourceIn) {
        return SoundInit.ORBITER_HURT;
    }

    protected SoundEvent func_184639_G() {
        return SoundInit.ORBITER_AMBIENT;
    }

    @Override
    protected int numberOfLives() {
        return 4;
    }

    protected ResourceLocation func_184647_J() {
        return LootTableRegistry.ENTITIES_ORBITER;
    }

    @Override
    protected EntityAIFloatAttack createShootAI() {
        return null;
    }
}

