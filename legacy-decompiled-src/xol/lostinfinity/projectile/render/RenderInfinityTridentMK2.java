/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.renderer.entity.Render
 *  net.minecraft.client.renderer.entity.RenderManager
 *  net.minecraft.util.ResourceLocation
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 *  org.lwjgl.opengl.GL11
 */
package xol.lostinfinity.projectile.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;
import xol.lostinfinity.mob.model.item.ModelInfinityTrident;
import xol.lostinfinity.projectile.entity.EntityInfinityTridentMK2;

@SideOnly(value=Side.CLIENT)
public class RenderInfinityTridentMK2<T extends EntityInfinityTridentMK2>
extends Render<T> {
    public static final ResourceLocation TEXTURES = new ResourceLocation("lostinfinity:textures/entity/infinity_trident_mk2.png");
    private ModelBase model = new ModelInfinityTrident();

    public RenderInfinityTridentMK2(RenderManager renderManagerIn) {
        super(renderManagerIn);
    }

    protected ResourceLocation getEntityTexture(T entity) {
        return this.getCustomTexture((EntityInfinityTridentMK2)entity);
    }

    private ResourceLocation getCustomTexture(EntityInfinityTridentMK2 entity) {
        return TEXTURES;
    }

    public void doRender(T entity, double x, double y, double z, float yaw, float partialTick) {
        GL11.glPushMatrix();
        this.func_110776_a(TEXTURES);
        GL11.glTranslated((double)x, (double)(y - 0.75), (double)z);
        GL11.glRotated((double)yaw, (double)0.0, (double)1.0, (double)0.0);
        this.model.func_78088_a(entity, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0625f);
        GL11.glPopMatrix();
    }
}

