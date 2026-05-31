/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.util.math.HitResult
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraft.world.World
 */
package xol.lostinfinity.projectile.entity;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.HitResult;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.mob.entity.deviant.prime.EntityZenon;
import xol.lostinfinity.projectile.entity.EntityBaseThrowable;

public class EntityUnstableBalloon
extends EntityBaseThrowable {
    private Player recentPlayer = null;
    private int hitCount = 0;
    int graceTimer = 10;

    public EntityUnstableBalloon(Level par1World) {
        super(par1World);
        this.func_70105_a(0.95f, 0.95f);
    }

    public EntityUnstableBalloon(Level par1World, double par2, double par4, double par6) {
        super(par1World, par2, par4, par6);
        this.func_70105_a(0.95f, 0.95f);
    }

    @Override
    protected boolean willDespawn() {
        return false;
    }

    @Override
    protected void func_70184_a(HitResult result) {
        if (!this.field_70170_p.field_72995_K) {
            if (result.field_72308_g != null && result.field_72308_g instanceof Player && this.graceTimer <= 0) {
                Player player = (Player)result.field_72308_g;
                if (this.recentPlayer == null) {
                    this.bounce(player);
                } else if (this.recentPlayer.func_110124_au().equals(player.func_110124_au())) {
                    player.func_145747_a((Component)new Component((Object)((Object)TextFmt.Red) + "You popped the balloon!"));
                } else {
                    this.bounce(player);
                }
            } else {
                this.func_70106_y();
            }
        }
    }

    private void bounce(Player player) {
        this.graceTimer = 10;
        this.recentPlayer = player;
        this.field_70181_x = 0.0;
        this.func_70024_g(this.field_70146_Z.nextDouble() * 0.5 - 0.25, 1.4, this.field_70146_Z.nextDouble() * 0.5 - 0.25);
        this.field_70133_I = true;
        ++this.hitCount;
        if (this.hitCount >= 8 && this.field_70192_c != null && player.func_110124_au().equals(this.field_70192_c.func_110124_au())) {
            this.func_145779_a(ItemInit.gasFilledBalloon, 1);
            EntityZenon zenon = new EntityZenon(this.field_70170_p);
            zenon.func_70634_a(this.field_70165_t, this.field_70163_u + 4.0, this.field_70161_v);
            this.field_70170_p.func_72838_d((Entity)zenon);
            player.func_145747_a((Component)new Component((Object)((Object)TextFmt.Dark_Aqua) + "Prime Deviant Zenon: Your atrocities against the Deviants will not be tolerated " + player.func_70005_c_() + "!"));
            this.func_70106_y();
        } else {
            player.func_145747_a((Component)new Component(8 - this.hitCount + " Hits Remaining"));
        }
    }

    public void func_70030_z() {
        super.func_70030_z();
        --this.graceTimer;
    }

    protected float func_70185_h() {
        return 0.03f;
    }
}

