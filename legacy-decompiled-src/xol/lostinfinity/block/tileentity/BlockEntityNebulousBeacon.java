/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.item.ItemEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.inventory.IInventory
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.tileentity.BlockEntity
 *  net.minecraft.util.ITickable
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.math.BlockPos
 */
package xol.lostinfinity.block.tileentity;

import java.util.List;
import java.util.Random;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.inventory.IInventory;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.util.ITickable;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.entity.nebula.EntityNebulaGiant;
import xol.lostinfinity.mob.entity.nebula.EntityNebulaGrunt;
import xol.lostinfinity.mob.entity.nebula.EntityNebulaWizard;
import xol.lostinfinity.util.fx.IParticleSpawner;

public class BlockEntityNebulousBeacon
extends BlockEntity
implements IInventory,
ITickable {
    private static final int RANGE = 3;
    public static final int HEALTH_MAX = 100;
    public static final int DURATION_MAX = 4800;
    private Random rand = new Random();
    private int health = 100;
    private int duration = 0;

    public void func_73660_a() {
        if (!this.field_145850_b.field_72995_K) {
            if (this.health <= 0) {
                this.field_145850_b.func_175655_b(this.field_174879_c, false);
                this.field_145850_b.func_175713_t(this.field_174879_c);
                this.field_145850_b.func_184133_a(null, this.field_174879_c, SoundEvents.field_187929_hc, SoundSource.BLOCKS, 1.0f, 1.0f);
                return;
            }
            ++this.duration;
            this.trySpawnMob();
            this.checkIfDamaged();
            if (this.duration % 160 == 0) {
                this.field_145850_b.func_184133_a(null, this.field_174879_c, SoundInit.NEBULOUS_BEACON, SoundSource.BLOCKS, 1.5f, 0.8f + this.rand.nextFloat() * 0.4f);
            }
            if (this.duration >= 4800) {
                this.duration = 0;
                this.health = 100;
                this.field_145850_b.func_175713_t(this.field_174879_c);
                this.field_145850_b.func_175698_g(this.field_174879_c);
                ItemEntity generator = new ItemEntity(this.field_145850_b, (double)this.field_174879_c.func_177958_n(), (double)(this.field_174879_c.func_177956_o() + 1), (double)this.field_174879_c.func_177952_p(), new ItemStack(ItemInit.astralGenerator));
                this.field_145850_b.func_72838_d((Entity)generator);
                this.field_145850_b.func_184133_a(null, this.field_174879_c, SoundInit.SPACE_VICTORY, SoundSource.BLOCKS, 1.5f, 1.0f);
                IParticleSpawner.spawnParticle(this.field_145850_b, 61, 16, (double)this.field_174879_c.func_177958_n(), (double)(this.field_174879_c.func_177956_o() + 1), (double)this.field_174879_c.func_177952_p());
            }
        }
    }

    private void checkIfDamaged() {
        if (this.duration % 40 == 0) {
            List nearGrunts = this.field_145850_b.func_72872_a(EntityNebulaGrunt.class, new AABB(this.field_174879_c).func_186662_g(3.0));
            List nearGiants = this.field_145850_b.func_72872_a(EntityNebulaGiant.class, new AABB(this.field_174879_c).func_186662_g(3.0));
            List nearWizards = this.field_145850_b.func_72872_a(EntityNebulaWizard.class, new AABB(this.field_174879_c).func_186662_g(3.0));
            int damage = nearGrunts.size() + nearGiants.size() + nearWizards.size();
            this.health -= damage;
            if (damage > 0) {
                this.field_145850_b.func_184133_a(null, this.field_174879_c, SoundEvents.field_187927_ha, SoundSource.PLAYERS, 1.0f, 1.5f - this.field_145850_b.field_73012_v.nextFloat());
            }
        }
    }

    private void trySpawnMob() {
        if (this.duration % 40 == 0 && this.field_145850_b.field_73012_v.nextBoolean()) {
            double x = this.field_145850_b.field_73012_v.nextBoolean() ? (double)(this.field_174879_c.func_177958_n() - (this.field_145850_b.field_73012_v.nextInt(15) + 25)) : (double)(this.field_174879_c.func_177958_n() + this.field_145850_b.field_73012_v.nextInt(15) + 25);
            double y = this.field_174879_c.func_177956_o();
            double z = this.field_145850_b.field_73012_v.nextBoolean() ? (double)(this.field_174879_c.func_177952_p() - (this.field_145850_b.field_73012_v.nextInt(15) + 25)) : (double)(this.field_174879_c.func_177952_p() + this.field_145850_b.field_73012_v.nextInt(15) + 25);
            BlockPos spawnPos = new BlockPos(x, y, z);
            while (!this.field_145850_b.func_175623_d(spawnPos.func_177982_a(0, -1, 0))) {
                spawnPos = new BlockPos(x, y += 1.0, z);
            }
            BlockPos targetPos = this.field_174879_c.func_177963_a(0.0, 1.0, 0.0);
            if ((double)((float)this.duration / 4800.0f) < 0.25) {
                EntityNebulaGrunt grunt = new EntityNebulaGrunt(this.field_145850_b, targetPos);
                grunt.func_70107_b(spawnPos.func_177958_n(), spawnPos.func_177956_o(), spawnPos.func_177952_p());
                this.field_145850_b.func_72838_d((Entity)grunt);
            } else if ((double)((float)this.duration / 4800.0f) < 0.5) {
                EntityNebulaWizard wizard = new EntityNebulaWizard(this.field_145850_b, targetPos);
                wizard.func_70107_b(spawnPos.func_177958_n(), spawnPos.func_177956_o(), spawnPos.func_177952_p());
                this.field_145850_b.func_72838_d((Entity)wizard);
            } else if ((double)((float)this.duration / 4800.0f) < 0.75) {
                EntityNebulaGiant giant = new EntityNebulaGiant(this.field_145850_b, targetPos);
                giant.func_70107_b(spawnPos.func_177958_n(), spawnPos.func_177956_o(), spawnPos.func_177952_p());
                this.field_145850_b.func_72838_d((Entity)giant);
            } else {
                switch (this.field_145850_b.field_73012_v.nextInt(3)) {
                    case 0: {
                        EntityNebulaGrunt grunt = new EntityNebulaGrunt(this.field_145850_b, targetPos);
                        grunt.func_70107_b(spawnPos.func_177958_n(), spawnPos.func_177956_o(), spawnPos.func_177952_p());
                        this.field_145850_b.func_72838_d((Entity)grunt);
                        break;
                    }
                    case 1: {
                        EntityNebulaWizard wizard = new EntityNebulaWizard(this.field_145850_b, targetPos);
                        wizard.func_70107_b(spawnPos.func_177958_n(), spawnPos.func_177956_o(), spawnPos.func_177952_p());
                        this.field_145850_b.func_72838_d((Entity)wizard);
                        break;
                    }
                    case 2: {
                        EntityNebulaGiant giant = new EntityNebulaGiant(this.field_145850_b, targetPos);
                        giant.func_70107_b(spawnPos.func_177958_n(), spawnPos.func_177956_o(), spawnPos.func_177952_p());
                        this.field_145850_b.func_72838_d((Entity)giant);
                    }
                }
            }
        }
    }

    public int func_70302_i_() {
        return 0;
    }

    public boolean func_191420_l() {
        return false;
    }

    public ItemStack func_70301_a(int index) {
        return null;
    }

    public ItemStack func_70298_a(int index, int count) {
        return null;
    }

    public ItemStack func_70304_b(int index) {
        return null;
    }

    public void func_70299_a(int index, ItemStack stack) {
    }

    public int func_70297_j_() {
        return 0;
    }

    public boolean func_70300_a(Player player) {
        return true;
    }

    public void func_174889_b(Player player) {
    }

    public void func_174886_c(Player player) {
    }

    public boolean func_94041_b(int index, ItemStack stack) {
        return false;
    }

    public int func_174887_a_(int id) {
        switch (id) {
            case 0: {
                return this.health;
            }
            case 1: {
                return this.duration;
            }
        }
        return 0;
    }

    public void func_174885_b(int id, int value) {
        switch (id) {
            case 0: {
                this.health = value;
                break;
            }
            case 1: {
                this.duration = value;
            }
        }
    }

    public int func_174890_g() {
        return 2;
    }

    public void func_174888_l() {
    }

    public String func_70005_c_() {
        return "tile.nebulous_beacon";
    }

    public boolean func_145818_k_() {
        return false;
    }

    public int getCurrentHealth() {
        return this.func_174887_a_(0);
    }

    public int getCurrentDuration() {
        return this.func_174887_a_(1);
    }

    public CompoundTag func_189515_b(CompoundTag compound) {
        super.func_189515_b(compound);
        compound.func_74768_a("health", this.health);
        compound.func_74768_a("duration", this.duration);
        return compound;
    }

    public void func_145839_a(CompoundTag compound) {
        super.func_145839_a(compound);
        this.health = compound.func_74762_e("health");
        this.duration = compound.func_74762_e("duration");
    }
}

