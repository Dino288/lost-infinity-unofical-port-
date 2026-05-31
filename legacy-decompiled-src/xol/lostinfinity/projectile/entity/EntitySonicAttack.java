/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.ItemStack
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.HitResult
 *  net.minecraft.util.math.HitResult$Type
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraft.world.World
 */
package xol.lostinfinity.projectile.entity;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.HitResult;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.PotionInit;
import xol.lostinfinity.projectile.entity.EntityBaseThrowable;
import xol.lostinfinity.util.data.IMaxAttack;

public class EntitySonicAttack
extends EntityBaseThrowable {
    public EntitySonicAttack(Level worldIn) {
        super(worldIn);
        this.func_70105_a(1.0f, 1.0f);
    }

    public EntitySonicAttack(Level worldIn, LivingEntity entityIn) {
        super(worldIn, entityIn);
        this.func_70105_a(1.0f, 1.0f);
    }

    public EntitySonicAttack(Level worldIn, double x, double y, double z) {
        super(worldIn, x, y, z);
        this.func_70105_a(1.0f, 1.0f);
    }

    @Override
    protected void func_70184_a(HitResult result) {
        if (!this.field_70170_p.field_72995_K) {
            Block hitBlock;
            if (result.field_72313_a == HitResult.Type.BLOCK && (hitBlock = this.field_70170_p.func_180495_p(result.func_178782_a()).func_177230_c()).equals(BlockInit.mutantBloom)) {
                this.harvestFungus(result.func_178782_a());
            }
            if (result.field_72308_g != null && this.func_85052_h() != null && result.field_72308_g != this.func_85052_h() && result.field_72308_g instanceof LivingEntity && result.field_72308_g instanceof Player) {
                Player play = (Player)result.field_72308_g;
                if (play.func_184614_ca().func_77973_b().equals(ItemInit.sonicShield)) {
                    IMaxAttack.dealMaxHealth((Entity)this, (LivingEntity)result.field_72308_g, 4);
                } else if (play.func_184614_ca().func_77973_b().equals(ItemInit.gigacron)) {
                    IMaxAttack.dealMaxHealth((Entity)this, (LivingEntity)result.field_72308_g, 4);
                } else if (play.func_184614_ca().func_77973_b().equals(ItemInit.hypercron)) {
                    IMaxAttack.dealMaxHealth((Entity)this, (LivingEntity)result.field_72308_g, 4);
                } else if (play.func_184614_ca().func_77973_b().equals(ItemInit.swordOfReverberance)) {
                    IMaxAttack.dealMaxHealth((Entity)this, (LivingEntity)result.field_72308_g, 4);
                    ItemStack stack = play.func_184614_ca();
                    if (stack.func_77942_o()) {
                        int newcharge = stack.func_77978_p().func_74762_e("sword_charge") * 2;
                        if (newcharge > 250) {
                            newcharge = 250;
                        }
                        stack.func_77978_p().func_74768_a("sword_charge", newcharge);
                    }
                } else {
                    IMaxAttack.dealMaxHealth((Entity)this, (LivingEntity)result.field_72308_g, 1, 5.0f);
                }
            }
            this.func_70106_y();
        }
    }

    private void harvestFungus(BlockPos pos) {
        this.field_70170_p.func_175656_a(pos, BlockInit.forgebloom.func_176223_P());
        AABB checkBox = new AABB(pos.func_177982_a(-3, -3, -3), pos.func_177982_a(3, 3, 3));
        for (Player player : this.field_70170_p.func_72872_a(Player.class, checkBox)) {
            player.func_70690_d(new PotionEffect(PotionInit.PLAGUE, 200));
            player.func_145747_a((Component)new Component(TextFmt.getFormatting(TextFmt.Bold, TextFmt.Green) + "You have been afflicted by mutant spores!"));
        }
        this.func_145779_a(ItemInit.mutantFungus, 1);
    }

    protected float func_70185_h() {
        return 0.0f;
    }
}

