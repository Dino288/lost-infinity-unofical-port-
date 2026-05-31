/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelBase
 */
package xol.lostinfinity.mob.model.cthulhu;

import java.util.HashMap;
import java.util.Map;
import net.minecraft.client.model.ModelBase;
import xol.lostinfinity.util.animation.client.blueprint.AnimationBlueprint;
import xol.lostinfinity.util.animation.model.IXolModel;
import xol.lostinfinity.util.animation.model.ModelRenderer;

public abstract class AnimatedModelBase
extends ModelBase
implements IXolModel {
    protected AnimationBlueprint blueprint;
    protected final Map<String, ModelRenderer> index = new HashMap<String, ModelRenderer>();

    @Override
    public void setBlueprint(AnimationBlueprint blueprint) {
        this.blueprint = blueprint;
    }

    @Override
    public AnimationBlueprint getBlueprint() {
        return this.blueprint;
    }

    @Override
    public Map<String, ModelRenderer> getIndex() {
        return this.index;
    }
}

