/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.entity.PathfinderMob
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.starforge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.SoundInit;

public class EntityEssenceIdol
extends PathfinderMob {
    private BlockPos gameReference = null;
    private List<BlockPos> oreLocations = new ArrayList<BlockPos>();
    private int gameLife = 1000;
    private int gameDifficulty = 0;

    public EntityEssenceIdol(Level worldIn) {
        super(worldIn);
        this.func_70105_a(2.75f, 5.0f);
    }

    protected void func_184651_r() {
    }

    public void setGameRef(BlockPos pos, int difficulty) {
        this.gameDifficulty = difficulty;
        this.gameReference = pos;
        this.fillOreLocations();
    }

    public boolean func_184645_a(Player player, InteractionHand hand) {
        ItemStack stack = player.func_184586_b(hand);
        if (stack.func_77973_b().equals(this.getHealItem())) {
            this.gameLife = Integer.min(this.gameLife + (this.gameDifficulty == 0 ? 250 : 125), 1000);
            stack.func_190918_g(1);
            this.func_184185_a(SoundInit.ESSENCE_IDOL_RESTORE, 1.0f, 0.75f + this.field_70146_Z.nextFloat() * 0.5f);
        }
        return true;
    }

    public void func_70636_d() {
        super.func_70636_d();
        if (!this.field_70170_p.field_72995_K && this.field_70173_aa > 5) {
            if (this.gameReference == null || this.gameLife <= 0) {
                this.deathEffect();
            } else if (this.field_70173_aa >= 3600) {
                this.win();
            } else {
                if (this.field_70173_aa % 140 == 130) {
                    this.randomlyLight();
                }
                if (this.field_70173_aa % 20 == 0) {
                    this.func_70691_i(200.0f);
                }
                if (this.field_70173_aa % 40 == 0) {
                    this.gameLife -= 25;
                }
                if (this.field_70173_aa % 100 == 0) {
                    this.messagePlayers((Object)((Object)(this.gameLife > 250 ? TextFmt.Gold : TextFmt.Red)) + "The idol has " + this.gameLife + " energy remaining.");
                }
            }
        }
    }

    public void fillOreLocations() {
        for (int xoff = -32; xoff < 32; ++xoff) {
            for (int zoff = -32; zoff < 32; ++zoff) {
                BlockPos testpos = this.gameReference.func_177982_a(xoff, 0, zoff);
                if (this.field_70170_p.func_180495_p(testpos).func_177230_c() == this.getOffBlock()) {
                    this.oreLocations.add(testpos);
                    continue;
                }
                if (this.field_70170_p.func_180495_p(testpos).func_177230_c() != this.getOnBlock()) continue;
                this.oreLocations.add(testpos);
            }
        }
    }

    private void messagePlayers(String message) {
        AABB aabb = new AABB(this.gameReference.func_177982_a(-32, -5, -32), this.gameReference.func_177982_a(32, 15, 32));
        for (Player contender : this.field_70170_p.func_72872_a(Player.class, aabb)) {
            contender.func_145747_a((Component)new Component(message));
        }
    }

    private void randomlyLight() {
        int currently_lit = 0;
        Collections.shuffle(this.oreLocations);
        for (BlockPos pos : this.oreLocations) {
            if ((currently_lit <= 4 || this.field_70146_Z.nextInt(4) == 0) && currently_lit <= 8) {
                this.field_70170_p.func_175656_a(pos, this.getOnBlock().func_176223_P());
                ++currently_lit;
                continue;
            }
            this.field_70170_p.func_175656_a(pos, this.getOffBlock().func_176223_P());
        }
    }

    private Block getOffBlock() {
        if (this.gameDifficulty == 0) {
            return BlockInit.lumioOreEmpty;
        }
        return BlockInit.gloominessenceOreEmpty;
    }

    private Block getOnBlock() {
        if (this.gameDifficulty == 0) {
            return BlockInit.lumioOre;
        }
        return BlockInit.gloominessenceOre;
    }

    private Item getHealItem() {
        if (this.gameDifficulty == 0) {
            return ItemInit.luminessence;
        }
        return ItemInit.gloominessence;
    }

    public void darkenAll() {
        for (BlockPos pos : this.oreLocations) {
            if (this.field_70170_p.func_180495_p(pos).func_177230_c() != this.getOnBlock()) continue;
            this.field_70170_p.func_175656_a(pos, this.getOffBlock().func_176223_P());
        }
    }

    private void deathEffect() {
        this.func_70106_y();
        if (this.gameReference != null) {
            this.darkenAll();
        }
    }

    private void win() {
        this.deathEffect();
        if (this.gameDifficulty == 0) {
            this.func_145779_a(ItemInit.luminescentCubes, this.field_70146_Z.nextInt(10) + 5);
        } else {
            this.func_145779_a(ItemInit.gloominessenceCubes, this.field_70146_Z.nextInt(10) + 5);
        }
    }

    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(2000.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.0);
    }

    protected SoundEvent func_184615_bR() {
        return null;
    }

    protected SoundEvent func_184601_bQ(DamageSource damageSourceIn) {
        return null;
    }

    protected SoundEvent func_184639_G() {
        return SoundInit.ESSENCE_IDOL_AMBIENT;
    }

    protected boolean func_70692_ba() {
        return false;
    }

    public int func_70641_bl() {
        return 1;
    }
}

