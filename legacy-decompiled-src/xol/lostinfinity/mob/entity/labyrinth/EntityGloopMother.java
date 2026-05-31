/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.player.Player
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.labyrinth;

import java.util.Iterator;
import net.minecraft.world.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import xol.lostinfinity.mob.entity.base.EntityMultipleLives;
import xol.lostinfinity.mob.entity.labyrinth.EntityGloop;
import xol.lostinfinity.util.load.LootTableRegistry;

public class EntityGloopMother
extends EntityMultipleLives {
    private int spawnTimer = 0;

    public EntityGloopMother(Level worldIn) {
        super(worldIn);
        this.func_70105_a(1.0f, 1.0f);
    }

    @Override
    protected void func_184651_r() {
    }

    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(2500.0);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(1.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.0);
        this.func_110148_a(SharedMonsterAttributes.field_111266_c).func_111128_a(1.0);
    }

    public void func_70636_d() {
        super.func_70636_d();
        if (this.spawnTimer == 0) {
            if (!this.field_70170_p.field_72995_K && this.field_70173_aa % 20 == 0) {
                Player foundPlayer = null;
                Iterator iterator = this.field_70170_p.func_72872_a(Player.class, this.func_174813_aQ().func_72314_b(12.0, 12.0, 12.0)).iterator();
                while (iterator.hasNext()) {
                    Player near_pl;
                    foundPlayer = near_pl = (Player)iterator.next();
                }
                if (foundPlayer != null) {
                    this.spawnTimer = 100;
                }
            }
        } else {
            if (this.spawnTimer % 20 == 0) {
                int count = 0;
                for (EntityGloop near_pl : this.field_70170_p.func_72872_a(EntityGloop.class, this.func_174813_aQ().func_72314_b(18.0, 18.0, 18.0))) {
                    ++count;
                }
                if (count < 8) {
                    EntityGloop gloop = new EntityGloop(this.field_70170_p);
                    gloop.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
                    this.field_70170_p.func_72838_d((Entity)gloop);
                }
            }
            --this.spawnTimer;
        }
    }

    @Override
    protected int numberOfLives() {
        return 7;
    }

    protected ResourceLocation func_184647_J() {
        return LootTableRegistry.ENTITIES_GLOOPMOTHER;
    }
}

