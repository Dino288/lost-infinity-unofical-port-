/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.sea;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.entity.sea.EntitySeaCreature;

public class EntityGlowfish
extends EntitySeaCreature {
    public EntityGlowfish(Level worldIn) {
        super(worldIn);
        this.func_70105_a(1.0f, 1.0f);
    }

    protected SoundEvent func_184615_bR() {
        return SoundInit.LONGFIN_DEATH;
    }

    protected SoundEvent func_184601_bQ(DamageSource damageSourceIn) {
        return SoundInit.LONGFIN_HURT;
    }

    protected SoundEvent func_184639_G() {
        return SoundInit.LONGFIN_AMBIENT;
    }

    @Override
    public void trueDeathAction() {
        Player player;
        if (!this.field_70170_p.field_72995_K && (player = this.field_70170_p.func_184137_a(this.field_70165_t, this.field_70163_u, this.field_70161_v, 15.0, false)) != null) {
            boolean found = false;
            for (int i = 0; i < player.field_71071_by.func_70302_i_(); ++i) {
                ItemStack playerStack = player.field_71071_by.func_70301_a(i);
                if (playerStack.func_77973_b() != ItemInit.pearlBioluminescent) continue;
                found = true;
                break;
            }
            if (found) {
                player.func_145747_a((Component)new Component((Object)((Object)TextFmt.Red) + "A strange magical property in the pearl prevents you from collecting another."));
            } else {
                player.func_191521_c(new ItemStack(ItemInit.pearlBioluminescent));
            }
        }
        super.trueDeathAction();
    }
}

