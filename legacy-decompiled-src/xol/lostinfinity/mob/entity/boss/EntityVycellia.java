/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.monster.EntitySpider
 *  net.minecraft.entity.player.Player
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.datasync.DataParameter
 *  net.minecraft.network.datasync.DataSerializer
 *  net.minecraft.network.datasync.DataSerializers
 *  net.minecraft.network.datasync.EntityDataManager
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.boss;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializer;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.init.PotionInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.entity.base.EntityDeviantMob;
import xol.lostinfinity.mob.entity.base.EntityMultipleLives;
import xol.lostinfinity.mob.entity.deviant.EntityDeviantCaveSpider;
import xol.lostinfinity.mob.entity.deviant.EntityDeviantSpider;
import xol.lostinfinity.projectile.entity.EntityGloomSpell;
import xol.lostinfinity.projectile.entity.EntitySpiderBlast;
import xol.lostinfinity.stone.EntityInfinityStone;
import xol.lostinfinity.util.data.CustomParticleConfig;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.fx.IParticleSpawner;

public class EntityVycellia
extends EntityMultipleLives
implements IMaxAttack {
    private static final DataParameter<Boolean> EASY_FORM = EntityDataManager.func_187226_a(EntityVycellia.class, (DataSerializer)DataSerializers.field_187198_h);
    private static final DataParameter<Integer> SUBSTAGE = EntityDataManager.func_187226_a(EntityVycellia.class, (DataSerializer)DataSerializers.field_187192_b);
    private float secondFormScale = 0.0f;

    public EntityVycellia(Level worldIn) {
        super(worldIn);
        this.func_70105_a(3.5f, 4.5f);
    }

    @Override
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a(EASY_FORM, (Object)true);
        this.field_70180_af.func_187214_a(SUBSTAGE, (Object)0);
    }

    public boolean isEasy() {
        return (Boolean)this.field_70180_af.func_187225_a(EASY_FORM);
    }

    public void setEasy(boolean f) {
        this.field_70180_af.func_187227_b(EASY_FORM, (Object)f);
    }

    public int getSubstage() {
        return (Integer)this.field_70180_af.func_187225_a(SUBSTAGE);
    }

    public void setSubstage(int f) {
        this.field_70180_af.func_187227_b(SUBSTAGE, (Object)f);
    }

    public float getFormScale() {
        return this.secondFormScale;
    }

    @Override
    public void func_70014_b(CompoundTag tag) {
        super.func_70014_b(tag);
        tag.func_74757_a("EasyForm", this.isEasy());
        tag.func_74768_a("Substage", this.getSubstage());
    }

    @Override
    public void func_70037_a(CompoundTag tag) {
        super.func_70037_a(tag);
        this.setEasy(tag.func_74767_n("EasyForm"));
        this.setSubstage(tag.func_74762_e("Substage"));
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
            IMaxAttack.dealMaxHealth((Entity)this, this.func_70638_az(), 3);
            return true;
        }
        return false;
    }

    private AABB getArenaAABB() {
        return new AABB(new BlockPos(-3.0, 60.0, -149.0), new BlockPos(52.0, 85.0, -36.0));
    }

    private void fireBlast(float speed) {
        boolean fired = false;
        for (Player near_pl : this.field_70170_p.func_72872_a(Player.class, this.getArenaAABB())) {
            if (near_pl.func_184812_l_()) continue;
            fired = true;
            double makeX = (this.func_174813_aQ().field_72340_a + this.func_174813_aQ().field_72336_d) / 2.0;
            double makeY = this.field_70163_u + (double)(this.field_70131_O / 2.0f) + 0.5;
            double makeZ = (this.func_174813_aQ().field_72339_c + this.func_174813_aQ().field_72334_f) / 2.0;
            double d2 = near_pl.field_70165_t - makeX;
            double d3 = near_pl.func_174813_aQ().field_72338_b + (double)(near_pl.field_70131_O / 2.0f) - makeY;
            if (!this.isEasy()) {
                d3 -= 3.0;
            }
            double d4 = near_pl.field_70161_v - makeZ;
            EntitySpiderBlast shot = new EntitySpiderBlast(this.field_70170_p, (LivingEntity)this);
            shot.func_70186_c(d2, d3, d4, speed, 0.0f);
            this.field_70170_p.func_72838_d((Entity)shot);
        }
        if (fired) {
            this.soundPlayers(SoundInit.MAGIC_WEAPON_6);
        }
    }

    private void fireGloom(float speed, float ydir) {
        EntityGloomSpell shot = new EntityGloomSpell(this.field_70170_p, (LivingEntity)this);
        shot.func_70186_c(this.randomVeloDouble(), ydir, this.randomVeloDouble(), speed, 0.0f);
        this.field_70170_p.func_72838_d((Entity)shot);
        this.soundPlayers(SoundInit.MAGIC_WEAPON_8);
    }

    private double randomVeloDouble() {
        return this.field_70146_Z.nextDouble() - 0.5;
    }

    public void func_70636_d() {
        super.func_70636_d();
        this.field_70143_R = -1.0f;
        if (!this.field_70170_p.field_72995_K && this.field_70173_aa % 10 == 0) {
            this.immunityCheck();
        }
        if (!this.isEasy()) {
            if (this.secondFormScale < 5.0f) {
                this.secondFormScale += 0.05f;
            } else if (!this.field_70170_p.field_72995_K && this.getSubstage() == 0) {
                this.setSubstage(1);
            }
            this.func_70105_a(7.5f * this.secondFormScale / 5.0f, 11.0f * this.secondFormScale / 5.0f);
            if (!this.field_70170_p.field_72995_K) {
                int form = this.getSubstage();
                if (form == 0) {
                    if (this.field_70173_aa == 8) {
                        AABB aabb = this.getArenaAABB();
                        double xSpawn = (aabb.field_72340_a + aabb.field_72336_d) / 2.0;
                        double ySpawn = aabb.field_72338_b + 5.0;
                        double zSpawn = (aabb.field_72339_c + aabb.field_72334_f) / 2.0;
                        for (int i = 0; i < 15; ++i) {
                            EntitySpider spider = new EntitySpider(this.field_70170_p);
                            spider.func_70107_b(xSpawn - 2.0 + this.field_70146_Z.nextDouble() * 4.0, ySpawn, zSpawn - 2.0 + this.field_70146_Z.nextDouble() * 4.0);
                            this.field_70170_p.func_72838_d((Entity)spider);
                        }
                    }
                    if (this.field_70173_aa % 5 == 0) {
                        this.popSpider();
                    }
                } else {
                    if (this.field_70173_aa % 400 == 150) {
                        this.spawnSpiders(true, true);
                    }
                    if (this.field_70173_aa % 150 == 0) {
                        if (form == 1) {
                            this.setSubstage(2);
                        } else {
                            this.setSubstage(1);
                        }
                    } else if (form == 1) {
                        if (this.field_70173_aa % 15 == 0) {
                            this.fireBlast(2.5f);
                        }
                    } else if (this.field_70173_aa % 3 == 0) {
                        this.fireGloom(1.0f, 0.0f);
                    }
                }
            }
        } else if (!this.field_70170_p.field_72995_K) {
            int form = this.getSubstage();
            if (this.field_70173_aa % 500 == 250) {
                this.spawnSpiders(false, true);
            }
            if (this.field_70173_aa % 350 == 0) {
                if (form == 0) {
                    this.setSubstage(1);
                    this.func_189654_d(true);
                } else {
                    this.setSubstage(0);
                    this.func_189654_d(false);
                }
            } else if (form == 0) {
                if (this.field_70173_aa % 30 == 0) {
                    this.fireBlast(1.5f);
                }
            } else {
                this.field_70181_x = this.field_70163_u < 70.0 ? 0.1 : 0.0;
                this.field_70160_al = true;
                this.field_70133_I = true;
                if (this.field_70173_aa % 4 == 0) {
                    this.fireGloom(1.0f, -0.1f);
                }
            }
        }
    }

    private void spawnSpiders(boolean cave, boolean sound) {
        if (this.spiderCount() < 15) {
            int repeats = 2 + this.field_70146_Z.nextInt(3);
            for (int i = 0; i < repeats; ++i) {
                EntityDeviantMob devspider;
                if (cave && this.field_70146_Z.nextBoolean()) {
                    devspider = new EntityDeviantCaveSpider(this.field_70170_p);
                    devspider.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
                    this.field_70170_p.func_72838_d((Entity)devspider);
                    continue;
                }
                devspider = new EntityDeviantSpider(this.field_70170_p);
                devspider.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
                this.field_70170_p.func_72838_d((Entity)devspider);
            }
            if (sound) {
                this.soundPlayers(SoundInit.SPIDER_UNLEASH);
            }
            this.messagePlayers((Object)((Object)TextFmt.Dark_Aqua) + "Vycellia: While my spiders live, I cannot die!");
        }
    }

    private int spiderCount() {
        int count = 0;
        for (LivingEntity entity : this.field_70170_p.func_72872_a(LivingEntity.class, this.getArenaAABB())) {
            if (!(entity instanceof EntityDeviantSpider) && !(entity instanceof EntityDeviantCaveSpider)) continue;
            ++count;
        }
        return count;
    }

    private void immunityCheck() {
        if (this.spiderCount() > 0) {
            this.func_70690_d(new PotionEffect(PotionInit.PROTECTED, 11));
        }
    }

    private void popSpider() {
        for (LivingEntity entity : this.field_70170_p.func_72872_a(LivingEntity.class, this.getArenaAABB())) {
            if (!(entity instanceof EntitySpider)) continue;
            entity.func_70106_y();
            this.soundPlayers(SoundInit.MAGIC_WEAPON_7);
            CustomParticleConfig config1 = new CustomParticleConfig();
            config1.createInstance().setParticle(ParticleInit.GLOOM_BURST).setSpread(1.0, 1.0, 1.0).setCount(3).setIgnoreRange(true);
            IParticleSpawner.spawnParticle(entity.field_70170_p, config1, entity.field_70165_t, entity.field_70163_u + (double)(entity.field_70131_O / 2.0f), entity.field_70161_v);
            return;
        }
    }

    protected SoundEvent func_184615_bR() {
        return SoundEvents.field_187819_fL;
    }

    protected SoundEvent func_184601_bQ(DamageSource damageSourceIn) {
        return SoundEvents.field_187821_fM;
    }

    protected SoundEvent func_184639_G() {
        return SoundEvents.field_187817_fK;
    }

    @Override
    protected int numberOfLives() {
        return 100;
    }

    @Override
    protected void updateLifeAction() {
        int lifePercent = Math.round(100 * (this.numberOfLives() - this.getLivesCount()) / this.numberOfLives());
        this.messagePlayers((Object)((Object)TextFmt.Gold) + "Vycellia is at " + lifePercent + "% health.");
    }

    protected void messagePlayers(String message) {
        for (Player contender : this.field_70170_p.func_72872_a(Player.class, this.getArenaAABB())) {
            contender.func_145747_a((Component)new Component(message));
        }
    }

    protected void soundPlayers(SoundEvent sound) {
        for (Player contender : this.field_70170_p.func_72872_a(Player.class, this.getArenaAABB())) {
            this.field_70170_p.func_184133_a(null, contender.func_180425_c(), sound, SoundSource.MASTER, 0.75f, 0.9f + this.field_70146_Z.nextFloat() * 0.2f);
        }
    }

    @Override
    public void trueDeathAction() {
        if (!this.field_70170_p.field_72995_K) {
            if (this.isEasy()) {
                EntityVycellia rematch = new EntityVycellia(this.field_70170_p);
                AABB aabb = this.getArenaAABB();
                rematch.func_70107_b((aabb.field_72340_a + aabb.field_72336_d) / 2.0, aabb.field_72338_b + 5.0, (aabb.field_72339_c + aabb.field_72334_f) / 2.0);
                rematch.setEasy(false);
                this.field_70170_p.func_72838_d((Entity)rematch);
                this.messagePlayers((Object)((Object)TextFmt.Light_Purple) + "Vycellia: I told you, my army is Eteneral!");
            } else {
                EntityInfinityStone stone = new EntityInfinityStone(this.field_70170_p);
                stone.setStoneNum((byte)10);
                stone.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
                this.field_70170_p.func_72838_d((Entity)stone);
                this.func_145779_a(ItemInit.arenaCard, 1);
            }
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

