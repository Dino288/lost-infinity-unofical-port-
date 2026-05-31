/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.HitResult
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraft.world.World
 */
package xol.lostinfinity.projectile.entity;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.phys.HitResult;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.projectile.entity.EntityBaseThrowable;

public class EntityRainDrop
extends EntityBaseThrowable {
    public EntityRainDrop(Level par1World) {
        super(par1World);
        this.func_70105_a(0.95f, 0.95f);
    }

    public EntityRainDrop(Level par1World, double par2, double par4, double par6) {
        super(par1World, par2, par4, par6);
        this.func_70105_a(0.95f, 0.95f);
    }

    @Override
    protected void func_70184_a(HitResult result) {
        if (!this.field_70170_p.field_72995_K) {
            if (result.field_72308_g != null && result.field_72308_g instanceof Player) {
                ItemStack stack = ((Player)result.field_72308_g).func_184614_ca();
                Item item = stack.func_77973_b();
                this.field_70170_p.func_184133_a(null, result.field_72308_g.func_180425_c(), SoundInit.WATER_DROP, SoundSource.PLAYERS, 1.0f, 0.8f + this.field_70146_Z.nextFloat() * 0.4f);
                if (item.equals(ItemInit.rainfallCollector)) {
                    if (!stack.func_77942_o()) {
                        stack.func_77982_d(new CompoundTag());
                    }
                    int progress = stack.func_77978_p().func_74762_e("Progress");
                    stack.func_77978_p().func_74768_a("Progress", progress + 1);
                    result.field_72308_g.func_145747_a((Component)new Component((Object)((Object)TextFmt.Dark_Aqua) + "You catch a raindrop."));
                    return;
                }
            }
            this.func_70106_y();
        }
    }

    protected float func_70185_h() {
        return 0.02f;
    }
}

