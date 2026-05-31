/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Mob
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.sea;

import java.util.ArrayList;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.phys.AABB;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.ItemInit;

public class EntityPearlCollector
extends Mob {
    private boolean game = false;
    private boolean win = false;
    private int stage = 0;
    private int time = 0;
    private int stageLength = 2000;
    private ArrayList<Item> pearlList = null;
    private boolean lose = false;
    Item curPearl = null;
    private static final int finalStage = 5;

    public EntityPearlCollector(Level worldIn) {
        super(worldIn);
    }

    public void startGame() {
        this.game = true;
    }

    public boolean func_184645_a(Player player, InteractionHand hand) {
        ItemStack stack = player.func_184586_b(hand);
        if (stack.func_77973_b() == ItemInit.silverToken) {
            this.initPearls(player);
            if (!this.field_70170_p.field_72995_K) {
                this.game = true;
                this.stage = 0;
                this.time = 0;
                this.lose = false;
                player.func_145747_a((Component)new Component(TextFmt.getFormatting(TextFmt.Bold, TextFmt.Gold) + "Collect pearls for me to receive a reward!"));
            }
            stack.func_190918_g(1);
        } else if (!this.field_70170_p.field_72995_K && this.win) {
            player.func_145747_a((Component)new Component(TextFmt.getFormatting(TextFmt.Bold, TextFmt.Green) + "Here is your reward!"));
            this.func_145779_a(ItemInit.magicConch, 1);
            this.win = false;
            this.game = false;
            this.stage = 0;
            this.time = 0;
        } else if (this.lose) {
            player.func_145747_a((Component)new Component(TextFmt.getFormatting(TextFmt.Bold, TextFmt.Red) + "You have taken too long to find the pearl! Try again"));
            this.game = false;
        } else if (this.game && this.curPearl != null) {
            if (stack.func_77973_b() == this.curPearl) {
                if (!this.field_70170_p.field_72995_K) {
                    this.stageUp(player);
                }
                stack.func_190918_g(1);
            } else if (!this.field_70170_p.field_72995_K) {
                player.func_145747_a((Component)new Component(TextFmt.getFormatting(TextFmt.Bold, TextFmt.Red) + "You haven't given me the correct pearl!"));
            }
        }
        return true;
    }

    private void stageUp(Player player) {
        if (this.stage <= 5) {
            ++this.stage;
            this.nextPearl(player);
            this.time = 0;
        } else {
            this.win = true;
            player.func_145747_a((Component)new Component(TextFmt.getFormatting(TextFmt.Bold, TextFmt.Green) + "You have collected all the pearls, come get your reward!"));
        }
    }

    private void nextPearl(Player player) {
        int nextPearl = 0;
        if (this.pearlList != null && !this.pearlList.isEmpty()) {
            nextPearl = this.field_70170_p.field_73012_v.nextInt(this.pearlList.size());
            this.curPearl = this.pearlList.get(nextPearl);
        }
        String pearlName = "Igneous Pearl";
        switch (nextPearl) {
            case 0: {
                pearlName = "Igneous Pearl";
                break;
            }
            case 1: {
                pearlName = "Twilight Pearl";
                break;
            }
            case 2: {
                pearlName = "Bioluminescent Pearl";
            }
        }
        if (!this.field_70170_p.field_72995_K) {
            player.func_145747_a((Component)new Component((Object)((Object)TextFmt.Green) + pearlName + " is needed next!"));
        }
    }

    private void initPearls(Player player) {
        this.pearlList = new ArrayList();
        this.pearlList.add(ItemInit.pearlIgneous);
        this.pearlList.add(ItemInit.pearlTwilight);
        this.pearlList.add(ItemInit.pearlBioluminescent);
        this.nextPearl(player);
    }

    public void func_70636_d() {
        super.func_70636_d();
        if (!this.field_70170_p.field_72995_K) {
            if (this.game && this.time < this.stageLength) {
                ++this.time;
            } else if (this.game && !this.lose) {
                this.lose = true;
                for (Player player : this.field_70170_p.func_72872_a(Player.class, new AABB(this.func_180425_c()).func_186662_g(10.0))) {
                    player.func_145747_a((Component)new Component(TextFmt.getFormatting(TextFmt.Bold, TextFmt.Red) + "The pearls have not been collected fast enough!"));
                }
            }
        }
    }
}

