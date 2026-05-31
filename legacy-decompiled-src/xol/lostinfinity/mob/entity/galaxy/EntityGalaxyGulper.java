/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.PathfinderMob
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.galaxy;

import java.util.Random;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.ai.IBasicAI;
import xol.lostinfinity.mob.entity.base.EntityMultipleLives;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.load.LootTableRegistry;

public class EntityGalaxyGulper
extends EntityMultipleLives
implements IMaxAttack,
IBasicAI {
    private int pinkFeed = 0;
    private int blueFeed = 0;
    private int purpleFeed = 0;
    private int pinkFeedMax;
    private int blueFeedMax;
    private int purpleFeedMax;

    public EntityGalaxyGulper(Level worldIn) {
        super(worldIn);
        this.func_70105_a(1.75f, 2.5f);
        Random rand = new Random();
        this.pinkFeedMax = rand.nextInt(3) + 1;
        this.blueFeedMax = rand.nextInt(3) + 1;
        this.purpleFeedMax = rand.nextInt(3) + 1;
    }

    @Override
    protected void func_184651_r() {
        this.initBasicTasks((PathfinderMob)this);
    }

    public boolean func_184645_a(Player player, InteractionHand hand) {
        ItemStack itemstack;
        String itemName;
        if (!this.field_70170_p.field_72995_K && (itemName = (itemstack = player.func_184586_b(hand)).func_77977_a()).contains("watchful_eye")) {
            itemstack.func_190918_g(1);
            if (itemName.contains("pink")) {
                if (this.pinkFeed < this.pinkFeedMax) {
                    player.func_145747_a((Component)new Component(TextFmt.getFormatting(TextFmt.Underline, TextFmt.Red) + "Nom Nom Nom"));
                    ++this.pinkFeed;
                } else {
                    player.func_145747_a((Component)new Component(TextFmt.getFormatting(TextFmt.Underline, TextFmt.Red) + "Blleeecchhh"));
                }
            } else if (itemName.contains("blue")) {
                if (this.blueFeed < this.blueFeedMax) {
                    player.func_145747_a((Component)new Component(TextFmt.getFormatting(TextFmt.Underline, TextFmt.Red) + "Nom Nom Nom"));
                    ++this.blueFeed;
                } else {
                    player.func_145747_a((Component)new Component(TextFmt.getFormatting(TextFmt.Underline, TextFmt.Red) + "Blleeecchhh"));
                }
            } else if (itemName.contains("purple")) {
                if (this.purpleFeed < this.purpleFeedMax) {
                    player.func_145747_a((Component)new Component(TextFmt.getFormatting(TextFmt.Underline, TextFmt.Red) + "Nom Nom Nom"));
                    ++this.purpleFeed;
                } else {
                    player.func_145747_a((Component)new Component(TextFmt.getFormatting(TextFmt.Underline, TextFmt.Red) + "Blleeecchhh"));
                }
            }
            return true;
        }
        return false;
    }

    public boolean func_70652_k(Entity entity) {
        super.func_70652_k(entity);
        if (this.func_70638_az() != null) {
            int degreeAge = this.field_70173_aa % 360;
            int multi = 1;
            if (degreeAge > 200 && degreeAge < 340) {
                multi = 6;
            }
            IMaxAttack.dealMaxHealth((Entity)this, this.func_70638_az(), 3, multi);
            return true;
        }
        return false;
    }

    public void func_70636_d() {
        if (!this.field_70170_p.field_72995_K && this.pinkFeed >= this.pinkFeedMax && this.blueFeed >= this.blueFeedMax && this.purpleFeed >= this.purpleFeedMax) {
            this.func_145779_a(ItemInit.acidbloodSolution, 1);
            this.pinkFeed = 0;
            this.blueFeed = 0;
            this.purpleFeed = 0;
            Random rand = new Random();
            this.pinkFeedMax = rand.nextInt(3) + 1;
            this.blueFeedMax = rand.nextInt(3) + 1;
            this.purpleFeedMax = rand.nextInt(3) + 1;
        }
        super.func_70636_d();
    }

    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(5500.0);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(3.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.25);
        this.func_110148_a(SharedMonsterAttributes.field_111266_c).func_111128_a(1.0);
    }

    protected SoundEvent func_184615_bR() {
        return SoundInit.GALAXY_GULPER_DEATH;
    }

    protected SoundEvent func_184601_bQ(DamageSource damageSourceIn) {
        return SoundInit.GALAXY_GULPER_HURT;
    }

    protected SoundEvent func_184639_G() {
        return SoundInit.GALAXY_GULPER_AMBIENT;
    }

    protected ResourceLocation func_184647_J() {
        return LootTableRegistry.ENTITIES_GALAXYGULPER;
    }
}

