/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.Gson
 *  com.google.gson.GsonBuilder
 *  net.minecraft.client.Minecraft
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.ResourceLocation
 */
package xol.lostinfinity.util.animation.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import xol.lostinfinity.util.animation.client.AnimationDeserializer;
import xol.lostinfinity.util.animation.client.blueprint.AnimationBlueprint;
import xol.lostinfinity.util.animation.entity.IXolAnimated;
import xol.lostinfinity.util.animation.model.ModelRenderer;

public interface IXolModel {
    public static final Set<IXolModel> models = new HashSet<IXolModel>();
    public static final Gson gson = new GsonBuilder().registerTypeAdapter(AnimationBlueprint.class, (Object)new AnimationDeserializer()).create();

    public static void initializeModel(IXolModel model) {
        models.add(model);
        model.indexModel();
        model.refresh();
    }

    default public void indexModel() {
        try {
            Map<String, ModelRenderer> index = this.getIndex();
            for (Field field : this.getClass().getDeclaredFields()) {
                ModelRenderer renderer;
                field.setAccessible(true);
                if (!ModelRenderer.class.isAssignableFrom(field.getType()) || (renderer = (ModelRenderer)((Object)field.get(this))) == null) continue;
                renderer.lockDefaultRotation();
                index.put(field.getName(), renderer);
            }
        }
        catch (Throwable e) {
            e.printStackTrace();
        }
    }

    default public void refresh() {
        try {
            InputStream input = Minecraft.func_71410_x().func_110442_L().func_110536_a(this.getAnimationJson()).func_110527_b();
            InputStreamReader reader = new InputStreamReader(input);
            this.setBlueprint((AnimationBlueprint)gson.fromJson((Reader)reader, AnimationBlueprint.class));
        }
        catch (Throwable e) {
            e.printStackTrace();
        }
    }

    default public void animate(Entity entity) {
        if (entity instanceof IXolAnimated) {
            IXolAnimated animated = (IXolAnimated)entity;
            animated.setAnimationBlueprint(this.getBlueprint());
            animated.getAnimationHandler().update(this, Minecraft.func_71410_x().func_147113_T() ? 0.0f : Minecraft.func_71410_x().func_193989_ak());
        }
    }

    public ResourceLocation getAnimationJson();

    public void setBlueprint(AnimationBlueprint var1);

    public AnimationBlueprint getBlueprint();

    public Map<String, ModelRenderer> getIndex();
}

