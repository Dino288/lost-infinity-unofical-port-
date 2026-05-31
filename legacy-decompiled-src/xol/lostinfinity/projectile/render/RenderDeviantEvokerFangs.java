/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.entity.Render
 *  net.minecraft.client.renderer.entity.RenderManager
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.ResourceLocation
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.projectile.render;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.mob.model.deviant.ModelDeviantEvokerFangs;
import xol.lostinfinity.projectile.entity.EntityDeviantEvokerFangs;

@SideOnly(value=Side.CLIENT)
public class RenderDeviantEvokerFangs
extends Render<EntityDeviantEvokerFangs> {
    private static final ResourceLocation EVOKER_ILLAGER_FANGS = new ResourceLocation("lostinfinity:textures/projectiles/deviantevokerfangs.png");
    private final ModelDeviantEvokerFangs model = new ModelDeviantEvokerFangs();

    public RenderDeviantEvokerFangs(RenderManager p_i47208_1_) {
        super(p_i47208_1_);
    }

    public void doRender(EntityDeviantEvokerFangs entity, double x, double y, double z, float entityYaw, float partialTicks) {
        float f = entity.getAnimationProgress(partialTicks);
        if (f != 0.0f) {
            float f1 = 2.0f;
            if (f > 0.9f) {
                f1 = (float)((double)f1 * ((1.0 - (double)f) / (double)0.1f));
            }
            GlStateManager.func_179094_E();
            GlStateManager.func_179129_p();
            GlStateManager.func_179141_d();
            this.func_180548_c(entity);
            GlStateManager.func_179109_b((float)((float)x), (float)((float)y), (float)((float)z));
            GlStateManager.func_179114_b((float)(90.0f - entity.field_70177_z), (float)0.0f, (float)1.0f, (float)0.0f);
            GlStateManager.func_179152_a((float)(-f1), (float)(-f1), (float)f1);
            float f2 = 0.03125f;
            GlStateManager.func_179109_b((float)0.0f, (float)-0.626f, (float)0.0f);
            this.model.func_78088_a(entity, f, 0.0f, 0.0f, entity.field_70177_z, entity.field_70125_A, 0.03125f);
            GlStateManager.func_179121_F();
            GlStateManager.func_179089_o();
            super.func_76986_a((Entity)entity, x, y, z, entityYaw, partialTicks);
        }
    }

    protected ResourceLocation getEntityTexture(EntityDeviantEvokerFangs entity) {
        return EVOKER_ILLAGER_FANGS;
    }
}

