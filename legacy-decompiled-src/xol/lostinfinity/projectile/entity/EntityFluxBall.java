/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.util.EnumParticleTypes
 *  net.minecraft.util.math.HitResult
 *  net.minecraft.world.World
 *  net.minecraftforge.common.util.ITeleporter
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.projectile.entity;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.util.ITeleporter;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.dimension.util.BasicTeleporter;
import xol.lostinfinity.projectile.entity.EntityBaseThrowable;

public class EntityFluxBall
extends EntityBaseThrowable {
    private int dim;
    private double telex;
    private double teley;
    private double telez;

    public EntityFluxBall(Level par1World) {
        super(par1World);
    }

    public EntityFluxBall(Level par1World, LivingEntity par2Mob) {
        super(par1World, par2Mob);
    }

    public EntityFluxBall(Level par1World, double par2, double par4, double par6) {
        super(par1World, par2, par4, par6);
    }

    public void setFlux(int d, double x, double y, double z) {
        this.dim = d;
        this.telex = x;
        this.teley = y;
        this.telez = z;
    }

    @Override
    protected void func_70184_a(HitResult result) {
        if (!this.field_70170_p.field_72995_K) {
            if (result.field_72308_g != null && this.func_85052_h() != null && result.field_72308_g != this.func_85052_h() && result.field_72308_g instanceof Player) {
                if (result.field_72308_g.field_71093_bK != this.dim) {
                    BasicTeleporter teleporter = new BasicTeleporter(result.field_72308_g.func_184102_h().func_71218_a(this.dim), this.telex, this.teley, this.telez);
                    result.field_72308_g.changeDimension(this.dim, (ITeleporter)teleporter);
                } else {
                    result.field_72308_g.func_70634_a(this.telex, this.teley, this.telez);
                }
            }
            this.func_70106_y();
        }
        if (result.field_72308_g != null && result.field_72308_g instanceof Player) {
            this.func_184185_a(SoundEvents.field_187534_aX, 3.0f, 1.0f);
        }
    }

    protected float func_70185_h() {
        return 0.05f;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void func_70071_h_() {
        super.func_70071_h_();
        if (this.field_70170_p.field_72995_K) {
            this.field_70170_p.func_175688_a(EnumParticleTypes.SPELL_WITCH, this.field_70165_t + (this.field_70146_Z.nextDouble() - 0.5) * (double)this.field_70130_N, this.field_70163_u + this.field_70146_Z.nextDouble() * (double)this.field_70131_O - 0.25, this.field_70161_v + (this.field_70146_Z.nextDouble() - 0.5) * (double)this.field_70130_N, (this.field_70146_Z.nextDouble() - 0.5) * 2.0, -this.field_70146_Z.nextDouble(), (this.field_70146_Z.nextDouble() - 0.5) * 2.0, new int[0]);
        }
    }
}

