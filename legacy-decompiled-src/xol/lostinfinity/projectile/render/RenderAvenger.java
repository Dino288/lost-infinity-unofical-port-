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
import xol.lostinfinity.mob.model.item.ModelAvengerHammer;
import xol.lostinfinity.projectile.entity.EntityAvenger;

@SideOnly(value=Side.CLIENT)
public class RenderAvenger<T extends EntityAvenger>
extends Render<T> {
    public static final ResourceLocation TEXTURES = new ResourceLocation("lostinfinity:textures/3d/avenger.png");
    public static final ResourceLocation TEXTURES_ALTERNATE = new ResourceLocation("lostinfinity:textures/3d/avenger_alternate.png");
    private ModelBase model = new ModelAvengerHammer();

    public RenderAvenger(RenderManager renderManagerIn) {
        super(renderManagerIn);
    }

    protected ResourceLocation getEntityTexture(T entity) {
        return this.getCustomTexture((EntityAvenger)entity);
    }

    private ResourceLocation getCustomTexture(EntityAvenger entity) {
        return TEXTURES;
    }

    public void doRender(T entity, double x, double y, double z, float yaw, float partialTick) {
        GL11.glPushMatrix();
        if (((EntityAvenger)entity).field_70173_aa % 10 < 5) {
            this.func_110776_a(TEXTURES);
        } else {
            this.func_110776_a(TEXTURES_ALTERNATE);
        }
        GL11.glTranslated((double)x, (double)(y - 0.75), (double)z);
        GL11.glRotated((double)(Mth.func_151238_b((double)(((EntityAvenger)entity).field_70173_aa - 1), (double)((EntityAvenger)entity).field_70173_aa, (double)partialTick) * 32.0), (double)0.0, (double)1.0, (double)0.0);
        this.model.func_78088_a(entity, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0625f);
        GL11.glPopMatrix();
    }
}

