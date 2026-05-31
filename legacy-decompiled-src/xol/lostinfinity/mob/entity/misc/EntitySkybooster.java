/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.Mob
 *  net.minecraft.entity.player.Player
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.util.EnumParticleTypes
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.misc;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.dimension.util.DimensionActivator;
import xol.lostinfinity.init.DimensionInit;
import xol.lostinfinity.util.coordinates.ContestCoordinates;

public class EntitySkybooster
extends Mob {
    private float scale = 1.0f;
    private Player owner = null;
    private int timer = 120;

    public float getMyScale() {
        return this.scale;
    }

    public EntitySkybooster(Level worldIn) {
        super(worldIn);
        this.func_70105_a(1.0f, 1.0f);
        this.func_184224_h(true);
    }

    public void setOwner(Player play) {
        this.owner = play;
    }

    public void func_70636_d() {
        block6: {
            block4: {
                block5: {
                    super.func_70636_d();
                    this.field_70143_R = -1.0f;
                    if (this.scale < 3.0f) {
                        this.scale += 0.05f;
                    }
                    if (this.field_70170_p.field_72995_K) break block4;
                    if (this.owner != null && !this.owner.field_70128_L) break block5;
                    this.func_70106_y();
                    break block6;
                }
                if (this.timer % 10 == 0) {
                    this.func_184185_a(SoundEvents.field_191244_bn, 2.0f, 0.5f + this.field_70146_Z.nextFloat());
                }
                this.owner.field_70181_x = 2.0;
                this.owner.field_70133_I = true;
                this.func_70634_a(this.owner.field_70165_t, this.owner.field_70163_u + 1.5, this.owner.field_70161_v);
                --this.timer;
                if (this.timer != 0) break block6;
                if (this.field_70170_p.field_73011_w.func_186058_p() != DimensionInit.grandmasterOutpost) {
                    BlockPos teleto = ContestCoordinates.grandEntryPos();
                    DimensionActivator.transferEntityWithCoords((Entity)this.owner, DimensionInit.grandmasterOutpost, teleto.func_177958_n(), teleto.func_177956_o(), teleto.func_177952_p());
                    this.owner.func_145747_a((Component)new Component((Object)((Object)TextFmt.Aqua) + "The Grandmaster: " + (Object)((Object)TextFmt.Gold) + "Mmm, get a look at you. You'll fit right in here at the Contest of Champions."));
                    this.owner.func_145747_a((Component)new Component((Object)((Object)TextFmt.Aqua) + "The Grandmaster: " + (Object)((Object)TextFmt.Light_Purple) + "Here you can join the fun and compete to the death for our entertainment. All proceeds go to me so I can create more games."));
                }
                this.func_70106_y();
                break block6;
            }
            for (int i = 0; i < 2; ++i) {
                this.field_70170_p.func_175688_a(EnumParticleTypes.LAVA, this.field_70165_t, this.field_70163_u - 1.5, this.field_70161_v, (this.field_70170_p.field_73012_v.nextDouble() - 0.5) * 5.0, -1.0, (this.field_70170_p.field_73012_v.nextDouble() - 0.5) * 5.0, new int[0]);
            }
        }
    }
}

