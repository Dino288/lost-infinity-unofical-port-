/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.datasync.DataParameter
 *  net.minecraft.network.datasync.DataSerializer
 *  net.minecraft.network.datasync.DataSerializers
 *  net.minecraft.network.datasync.EntityDataManager
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraft.world.World
 */
package xol.lostinfinity.stone;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializer;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.mob.entity.base.EntityImmaterial;

public class EntityInfinityStone
extends EntityImmaterial {
    private static final DataParameter<Byte> TYPE = EntityDataManager.func_187226_a(EntityInfinityStone.class, (DataSerializer)DataSerializers.field_187191_a);

    public EntityInfinityStone(Level worldIn) {
        super(worldIn);
        this.func_184224_h(false);
    }

    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a(TYPE, (Object)0);
    }

    public byte getStoneNum() {
        return (Byte)this.field_70180_af.func_187225_a(TYPE);
    }

    public void setStoneNum(byte f) {
        this.field_70180_af.func_187227_b(TYPE, (Object)f);
    }

    public void func_70014_b(CompoundTag tag) {
        super.func_70014_b(tag);
        tag.func_74774_a("StoneType", this.getStoneNum());
    }

    public void func_70037_a(CompoundTag tag) {
        super.func_70037_a(tag);
        this.setStoneNum(tag.func_74771_c("StoneType"));
    }

    @Override
    public boolean func_70067_L() {
        return true;
    }

    protected void func_184651_r() {
    }

    protected SoundEvent func_184639_G() {
        return null;
    }

    protected SoundEvent func_184601_bQ(DamageSource damageSourceIn) {
        return null;
    }

    protected SoundEvent func_184615_bR() {
        return null;
    }

    private Item getStoneItem() {
        switch (this.getStoneNum()) {
            case 0: {
                return ItemInit.dualityCube;
            }
            case 1: {
                return ItemInit.aspirationCube;
            }
            case 2: {
                return ItemInit.corruptionCube;
            }
            case 3: {
                return ItemInit.ingenuityCube;
            }
            case 4: {
                return ItemInit.misdirectionCube;
            }
            case 5: {
                return ItemInit.vengeanceCube;
            }
            case 6: {
                return ItemInit.retrospectionCube;
            }
            case 7: {
                return ItemInit.dreadCube;
            }
            case 8: {
                return ItemInit.anxietyCube;
            }
            case 9: {
                return ItemInit.impositionCube;
            }
            case 10: {
                return ItemInit.ambitionCube;
            }
            case 11: {
                return ItemInit.perceptionCube;
            }
            case 12: {
                return ItemInit.anticipationCube;
            }
            case 13: {
                return ItemInit.resolveCube;
            }
            case 14: {
                return ItemInit.crueltyCube;
            }
        }
        return ItemInit.dualityCube;
    }

    public boolean func_184645_a(Player player, InteractionHand hand) {
        this.func_70106_y();
        Item stone_item = this.getStoneItem();
        if (!player.func_191521_c(new ItemStack(stone_item)) && !this.field_70170_p.field_72995_K) {
            this.func_145779_a(stone_item, 1);
        }
        if (!this.field_70170_p.field_72995_K && this.getStoneNum() >= 13) {
            player.func_145747_a((Component)new Component(TextFmt.getFormatting(TextFmt.Italic, TextFmt.Light_Purple) + "Looming voice: Yet another stone " + player.func_70005_c_() + "... And if that wasn't enough, your helping a dark force we've locked away. Don't push your luck " + player.func_70005_c_() + ", you don't want to deal with us."));
        }
        return true;
    }
}

