/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.renderer.entity.Render
 *  net.minecraft.client.renderer.entity.RenderManager
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.math.Mth
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 *  org.lwjgl.opengl.GL11
 */
package xol.lostinfinity.projectile.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;
import xol.lostinfinity.mob.model.item.ModelIonicChakram;
import xol.lostinfinity.projectile.entity.EntityMiniChakram;

@SideOnly(value=Side.CLIENT)
public class RenderMiniChakram<T extends EntityMiniChakram>
extends Render<T> {
    public static final ResourceLocation TEXTURES = new ResourceLocation("lostinfinity:textures/3d/ionic_chakram.png");
    private ModelBase model = new ModelIonicChakram();

    public RenderMiniChakram(RenderManager renderManagerIn) {
        super(renderManagerIn);
    }

    protected ResourceLocation getEntityTexture(T entity) {
        return this.getCustomTexture((EntityMiniChakram)entity);
    }

    private ResourceLocation getCustomTexture(EntityMiniChakram entity) {
        return TEXTURES;
    }

    public void doRender(T entity, double x, double y, double z, float yaw, float partialTick) {
        GL11.glPushMatrix();
        this.func_110776_a(TEXTURES);
        GL11.glTranslated((double)x, (double)(y - 0.75), (double)z);
        GL11.glRotated((double)(Mth.func_151238_b((double)(((EntityMiniChakram)entity).field_70173_aa - 1), (double)((EntityMiniChakram)entity).field_70173_aa, (double)partialTick) * 8.0), (double)0.0, (double)1.0, (double)0.0);
        this.model.func_78088_a(entity, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0625f);
        GL11.glPopMatrix();
    }
}

