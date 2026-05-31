/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.util.math.HitResult
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.projectile.entity;

import java.util.regex.Pattern;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.projectile.entity.EntityBaseThrowable;
import xol.lostinfinity.util.data.IMaxAttack;

public class EntitySelectionLaser
extends EntityBaseThrowable {
    private int selectionType = 0;
    static Pattern pattern_ah = Pattern.compile("[a-h]");
    static Pattern pattern_io = Pattern.compile("[i-o]");
    static Pattern pattern_pz = Pattern.compile("[p-z]");
    static Pattern pattern_09 = Pattern.compile("[0-9]");

    public EntitySelectionLaser(Level par1World) {
        super(par1World);
        this.func_70105_a(0.75f, 0.75f);
    }

    public EntitySelectionLaser(Level par1World, LivingEntity par2Mob) {
        super(par1World, par2Mob);
        this.func_70105_a(0.75f, 0.75f);
    }

    public EntitySelectionLaser(Level par1World, double par2, double par4, double par6) {
        super(par1World, par2, par4, par6);
        this.func_70105_a(0.75f, 0.75f);
    }

    public void setSelectionType(int type) {
        this.selectionType = type;
    }

    @Override
    protected void func_70184_a(HitResult result) {
        if (!this.field_70170_p.field_72995_K) {
            LivingEntity target;
            String hit_name;
            if (result.field_72308_g != null && this.func_85052_h() != null && !result.field_72308_g.equals((Object)this.func_85052_h()) && result.field_72308_g instanceof LivingEntity && !(hit_name = (target = (LivingEntity)result.field_72308_g).func_70005_c_().toLowerCase()).isEmpty() && this.regexMatch(this.selectionType, hit_name.substring(0, 1))) {
                IMaxAttack.dealMaxHealth((Entity)this, target, 2, 3.0f);
            }
            this.func_70106_y();
        }
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void func_70071_h_() {
        super.func_70071_h_();
        if (this.field_70170_p.field_72995_K) {
            for (int k = 0; k < 4; ++k) {
                this.field_70170_p.func_175688_a(ParticleInit.LASER_FIZZLE, this.field_70165_t + (this.field_70146_Z.nextDouble() - 0.5) * (double)this.field_70130_N, this.field_70163_u + this.field_70146_Z.nextDouble() * (double)this.field_70131_O - 0.25, this.field_70161_v + (this.field_70146_Z.nextDouble() - 0.5) * (double)this.field_70130_N, (this.field_70146_Z.nextDouble() - 0.5) * 2.0, -this.field_70146_Z.nextDouble(), (this.field_70146_Z.nextDouble() - 0.5) * 2.0, new int[0]);
            }
        }
    }

    protected float func_70185_h() {
        return 0.0f;
    }

    private boolean regexMatch(int selection, String ch) {
        switch (selection) {
            case 0: {
                return pattern_ah.matcher(ch).matches();
            }
            case 1: {
                return pattern_io.matcher(ch).matches();
            }
            case 2: {
                return pattern_pz.matcher(ch).matches();
            }
            case 3: {
                return pattern_09.matcher(ch).matches();
            }
        }
        return false;
    }
}

