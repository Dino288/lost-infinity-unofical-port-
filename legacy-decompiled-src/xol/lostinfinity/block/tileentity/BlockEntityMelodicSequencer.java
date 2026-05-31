/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.item.ItemEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.ItemStack
 *  net.minecraft.tileentity.BlockEntity
 *  net.minecraft.util.ITickable
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 */
package xol.lostinfinity.block.tileentity;

import java.util.ArrayList;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.util.ITickable;
import net.minecraft.sounds.SoundSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.SoundInit;

public class BlockEntityMelodicSequencer
extends BlockEntity
implements ITickable {
    ArrayList<SoundEvent> notes = null;
    ArrayList<Integer> sequence = new ArrayList();
    private boolean roundStart = false;
    private static int finalRound = 2;
    private int remainingFails = 0;
    private int round = 0;
    private int sequenceIndex = 0;
    private int noteTimer = 30;
    private int roundDelay = 0;
    private int time = 0;
    private Player player = null;
    private boolean finishedRound = true;
    private int playerSequenceIndex = 0;
    private boolean game = false;

    public void func_73660_a() {
        if (this.game && this.notes != null && this.notes.size() == 5 && this.roundStart && this.finishedRound) {
            if (this.roundDelay > 0) {
                --this.roundDelay;
            } else if (this.time < this.noteTimer) {
                ++this.time;
            } else {
                this.time = 0;
                this.field_145850_b.func_184133_a(null, this.field_174879_c, this.notes.get(this.sequence.get(this.sequenceIndex)), SoundSource.BLOCKS, 0.8f, 1.0f);
                ++this.sequenceIndex;
                if (this.sequenceIndex == this.sequence.size()) {
                    this.sequenceIndex = 0;
                    this.roundStart = false;
                    this.finishedRound = false;
                }
            }
        }
    }

    public boolean playNote(int meta, BlockPos pos, Player player) {
        this.player = player;
        if (!this.roundStart && this.notes != null && this.notes.size() > meta) {
            this.field_145850_b.func_184133_a(null, this.field_174879_c, this.notes.get(meta), SoundSource.BLOCKS, 0.8f, 1.0f);
            if (meta == this.sequence.get(this.playerSequenceIndex)) {
                ++this.playerSequenceIndex;
                if (this.playerSequenceIndex == this.sequence.size()) {
                    this.roundUp();
                }
            } else if (this.remainingFails > 0) {
                --this.remainingFails;
                this.playerSequenceIndex = 0;
                player.func_145747_a((Component)new Component(this.remainingFails + 1 + " fails remaining. Try again!"));
            } else {
                player.func_145747_a((Component)new Component("Failed sequence. No attempts remaining"));
                this.game = false;
            }
            return true;
        }
        return false;
    }

    private void roundUp() {
        this.finishedRound = true;
        if (this.round < finalRound) {
            if (this.player != null) {
                this.player.func_145747_a((Component)new Component("Round complete! Repeat the next sequence."));
            }
            ++this.round;
            this.generateSequence();
            this.roundStart = true;
            this.roundDelay = 40;
            this.playerSequenceIndex = 0;
            this.noteTimer -= 4;
        } else {
            if (this.player != null) {
                this.player.func_145747_a((Component)new Component("All sequences complete! The disc has been configured."));
            }
            this.game = false;
            this.notes = null;
            ItemEntity reward = new ItemEntity(this.field_145850_b, (double)this.field_174879_c.func_177958_n(), (double)(this.field_174879_c.func_177956_o() + 1), (double)this.field_174879_c.func_177952_p(), new ItemStack(ItemInit.audioSynchronizedDisc, 1));
            reward.field_70159_w = 0.0;
            reward.field_70181_x = 0.0;
            reward.field_70179_y = 0.0;
            this.field_145850_b.func_72838_d((Entity)reward);
        }
    }

    public static ArrayList<SoundEvent> getNotes() {
        ArrayList<SoundEvent> noteList = new ArrayList<SoundEvent>();
        noteList.add(SoundInit.NOTE_TYPE_1);
        noteList.add(SoundInit.NOTE_TYPE_2);
        noteList.add(SoundInit.NOTE_TYPE_3);
        noteList.add(SoundInit.NOTE_TYPE_4);
        noteList.add(SoundInit.NOTE_TYPE_5);
        return noteList;
    }

    private void initSounds() {
        this.notes = BlockEntityMelodicSequencer.getNotes();
    }

    public void startGame() {
        this.remainingFails = 5;
        this.game = true;
        this.finishedRound = true;
        this.round = 0;
        this.playerSequenceIndex = 0;
        this.roundStart = true;
        this.noteTimer = 30;
        this.initSounds();
        this.generateSequence();
    }

    private void generateSequence() {
        if (this.notes != null) {
            this.sequence.clear();
            int length = this.round * 1 + 3;
            for (int i = 0; i < length; ++i) {
                int randSound = this.field_145850_b.field_73012_v.nextInt(this.notes.size());
                this.sequence.add(randSound);
            }
        }
    }
}

