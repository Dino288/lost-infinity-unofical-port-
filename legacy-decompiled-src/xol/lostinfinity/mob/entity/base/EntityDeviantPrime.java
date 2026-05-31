/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.Item
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.base;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.mob.entity.base.EntityMultipleLives;
import xol.lostinfinity.util.data.IMaxAttack;

public class EntityDeviantPrime
extends EntityMultipleLives
implements IMaxAttack {
    public EntityDeviantPrime(Level worldIn) {
        super(worldIn);
    }

    protected boolean func_70692_ba() {
        return false;
    }

    @Override
    protected int numberOfLives() {
        return 25;
    }

    @Override
    public void trueDeathAction() {
        if (!this.field_70170_p.field_72995_K) {
            for (Player near_pl : this.field_70170_p.func_72872_a(Player.class, this.func_174813_aQ().func_72314_b(25.0, 25.0, 25.0))) {
                near_pl.func_145747_a((Component)new Component((Object)((Object)TextFmt.Dark_Aqua) + "Prime Deviant " + this.primeName() + ": I'll return for you."));
            }
            this.func_145779_a(this.primeDrop(), 1);
        }
    }

    protected String primeName() {
        return "";
    }

    protected Item primeDrop() {
        return null;
    }
}

