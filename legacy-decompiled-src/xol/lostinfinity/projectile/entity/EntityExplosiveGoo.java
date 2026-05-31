/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.init.Items
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.math.HitResult
 *  net.minecraft.world.World
 */
package xol.lostinfinity.projectile.entity;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.projectile.entity.EntityBaseThrowable;
import xol.lostinfinity.util.data.CustomParticleConfig;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.fx.IParticleSpawner;

public class EntityExplosiveGoo
extends EntityBaseThrowable {
    private int size = 4;
    private int denom = 4;

    public EntityExplosiveGoo(Level par1World) {
        super(par1World);
        this.func_70105_a(0.75f, 0.75f);
    }

    public EntityExplosiveGoo(Level par1World, LivingEntity par2Mob) {
        super(par1World, par2Mob);
    }

    public EntityExplosiveGoo(Level par1World, double par2, double par4, double par6) {
        super(par1World, par2, par4, par6);
    }

    public void setDenomAndSize(int s, int d) {
        this.size = s;
        this.denom = d;
    }

    @Override
    protected void func_70184_a(HitResult result) {
        if (!this.field_70170_p.field_72995_K) {
            Player player;
            ItemStack held;
            if (result.field_72308_g != null && result.field_72308_g instanceof Player && (held = (player = (Player)result.field_72308_g).func_184614_ca()).func_77973_b() == Items.field_151069_bo) {
                player.func_191521_c(new ItemStack(ItemInit.explosiveGooSample));
                held.func_190918_g(1);
            }
            CustomParticleConfig config1 = new CustomParticleConfig();
            config1.createInstance().setParticle(ParticleInit.EXPLOSION_RING).setSpread(2.0, 1.0, 2.0).setCount(3).setIgnoreRange(true);
            IParticleSpawner.spawnParticle(this.field_70170_p, config1, this.field_70165_t, this.field_70163_u, this.field_70161_v);
            for (Player target : this.field_70170_p.func_72872_a(Player.class, this.func_174813_aQ().func_72314_b((double)this.size, (double)this.size, (double)this.size))) {
                IMaxAttack.dealMaxHealth((Entity)this, (LivingEntity)target, this.denom);
            }
            this.func_70106_y();
        }
    }

    protected float func_70185_h() {
        return 0.0f;
    }
}

