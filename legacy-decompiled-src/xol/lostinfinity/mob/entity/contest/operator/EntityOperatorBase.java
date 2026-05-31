/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.PathfinderMob
 *  net.minecraft.entity.Mob
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.ai.EntityAIBase
 *  net.minecraft.entity.ai.EntityAIWatchClosest2
 *  net.minecraft.entity.player.Player
 *  net.minecraft.init.Items
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.contest.operator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.Mob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIWatchClosest2;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.entity.contest.controller.EntityControllerBase;

public class EntityOperatorBase
extends PathfinderMob {
    protected int style;
    protected int timeSinceSwitch = 0;
    protected int gameStartCountdown = -1;
    protected List<UUID> contenders = new ArrayList<UUID>();

    public EntityOperatorBase(Level worldIn) {
        super(worldIn);
    }

    protected void func_184651_r() {
        this.field_70714_bg.func_75776_a(9, (EntityAIBase)new EntityAIWatchClosest2((Mob)this, Player.class, 3.0f, 1.0f));
    }

    public void func_70014_b(CompoundTag tag) {
        super.func_70014_b(tag);
        tag.func_74768_a("ArenaStyle", this.style);
    }

    public void func_70037_a(CompoundTag tag) {
        super.func_70037_a(tag);
        this.style = tag.func_74762_e("ArenaStyle");
    }

    public boolean func_70104_M() {
        return false;
    }

    public void func_70636_d() {
        super.func_70636_d();
        if (!this.field_70170_p.field_72995_K) {
            if (this.timeSinceSwitch > 0) {
                --this.timeSinceSwitch;
            }
            if (this.gameStartCountdown >= 0) {
                if (this.gameStartCountdown == 0) {
                    if (this.canStartGame()) {
                        this.startGame();
                    } else {
                        this.notEnoughPlayers();
                    }
                } else if (this.gameStartCountdown % 20 == 0) {
                    this.gameStartWarning();
                }
                --this.gameStartCountdown;
            }
        }
    }

    public boolean func_184645_a(Player player, InteractionHand hand) {
        if (!this.field_70170_p.field_72995_K) {
            if (this.isGameInProgress() || this.gameStartCountdown >= 0) {
                player.func_145747_a((Component)new Component((Object)((Object)TextFmt.Red) + "A match is currently in progress."));
                return true;
            }
            if (this.timeSinceSwitch == 0) {
                Item held = player.func_184586_b(hand).func_77973_b();
                if (held.equals(Items.field_190931_a)) {
                    player.func_145747_a((Component)new Component("Arena Randomized"));
                    this.incrementStyle();
                    this.generateArena();
                    this.timeSinceSwitch = 120;
                } else if (held.equals(ItemInit.contenderPass)) {
                    this.gameStartCountdown = 200;
                    this.arenaClear();
                    this.generateArena();
                }
            } else {
                player.func_145747_a((Component)new Component((Object)((Object)TextFmt.Red) + "Operator: The arena was just changed. Be patient mortal."));
            }
        }
        return true;
    }

    protected AABB getArenaAABB() {
        return null;
    }

    protected AABB getLobbyAABB() {
        return null;
    }

    protected void generateArena() {
    }

    protected void incrementStyle() {
    }

    protected void arenaClear() {
    }

    protected boolean isGameInProgress() {
        Iterator iterator = this.field_70170_p.func_72872_a(EntityControllerBase.class, this.getArenaAABB()).iterator();
        if (iterator.hasNext()) {
            EntityControllerBase search_cont = (EntityControllerBase)((Object)iterator.next());
            return true;
        }
        return false;
    }

    protected void gameStartWarning() {
        this.func_184185_a(SoundInit.GENERIC_WEAPON_3, 1.0f, 1.0f);
        for (Player near_pl : this.field_70170_p.func_72872_a(Player.class, this.getLobbyAABB().func_72314_b(5.0, 0.0, 5.0))) {
            near_pl.func_145747_a((Component)new Component(TextFmt.getFormatting(TextFmt.Italic, TextFmt.Gold) + "A match will begin in: " + Math.floorDiv(this.gameStartCountdown, 20)));
        }
    }

    protected boolean canStartGame() {
        int pl_count = 0;
        block0: for (Player near_pl : this.field_70170_p.func_72872_a(Player.class, this.getLobbyAABB())) {
            for (int i = 0; i < near_pl.field_71071_by.func_70302_i_(); ++i) {
                if (!near_pl.field_71071_by.func_70301_a(i).func_77973_b().equals(ItemInit.contenderPass)) continue;
                ++pl_count;
                this.contenders.add(near_pl.func_110124_au());
                near_pl.field_71071_by.func_70299_a(i, ItemStack.field_190927_a);
                continue block0;
            }
        }
        return pl_count >= 2;
    }

    private void notEnoughPlayers() {
        UUID lonerUUID = this.contenders.get(0);
        Player loner = this.field_70170_p.func_152378_a(lonerUUID);
        loner.field_71071_by.func_70299_a(loner.field_71071_by.func_70447_i(), new ItemStack(ItemInit.contenderPass));
        this.contenders.clear();
        for (Player near_pl : this.field_70170_p.func_72872_a(Player.class, this.getLobbyAABB())) {
            near_pl.func_145747_a((Component)new Component((Object)((Object)TextFmt.Red) + "Not enough players."));
        }
    }

    protected void startGame() {
    }

    protected SoundEvent func_184639_G() {
        return SoundEvents.field_187910_gj;
    }

    protected SoundEvent func_184601_bQ(DamageSource damageSourceIn) {
        return SoundEvents.field_187912_gl;
    }

    protected SoundEvent func_184615_bR() {
        return SoundEvents.field_187911_gk;
    }

    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.2);
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(20000.0);
        this.field_70144_Y = 1.0f;
        this.func_174813_aQ().func_186664_h(100.0);
        this.func_184224_h(true);
    }

    public boolean func_70692_ba() {
        return false;
    }

    public boolean func_70601_bi() {
        return true;
    }
}

