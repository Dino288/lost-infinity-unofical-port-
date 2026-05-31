/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.sea;

import java.util.Arrays;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.entity.sea.EntitySeaCreature;
import xol.lostinfinity.util.data.IMaxAttack;

public class EntityOctobrella
extends EntitySeaCreature {
    public EntityOctobrella(Level worldIn) {
        super(worldIn);
        this.rawFlySpeed = 0.8f;
        this.func_70105_a(2.5f, 2.5f);
    }

    public boolean func_70652_k(Entity entity) {
        super.func_70652_k(entity);
        if (this.func_70638_az() != null) {
            IMaxAttack.dealTrueDamage((Entity)this, this.func_70638_az(), this.func_70638_az().func_110138_aP() * 0.25f, Arrays.asList("Aquatic"));
            return true;
        }
        return false;
    }

    protected boolean func_184645_a(Player player, InteractionHand hand) {
        ItemStack stack = player.func_184586_b(hand);
        if (stack.func_77973_b() == ItemInit.deviantEgg) {
            if (!this.field_70170_p.field_72995_K) {
                boolean found = false;
                for (int i = 0; i < player.field_71071_by.func_70302_i_(); ++i) {
                    ItemStack playerStack = player.field_71071_by.func_70301_a(i);
                    if (playerStack.func_77973_b() != ItemInit.pearlTwilight) continue;
                    found = true;
                    break;
                }
                if (found) {
                    player.func_145747_a((Component)new Component((Object)((Object)TextFmt.Red) + "A strange magical property in the pearl prevents you from collecting another."));
                } else {
                    player.func_191521_c(new ItemStack(ItemInit.pearlTwilight));
                }
            }
            stack.func_190918_g(1);
        }
        return true;
    }

    protected SoundEvent func_184615_bR() {
        return SoundInit.OCTOBRELLA_DEATH;
    }

    protected SoundEvent func_184601_bQ(DamageSource damageSourceIn) {
        return SoundInit.OCTOBRELLA_HURT;
    }

    protected SoundEvent func_184639_G() {
        return SoundInit.OCTOBRELLA_AMBIENT;
    }
}

