/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 */
package xol.lostinfinity.util.data;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import xol.lostinfinity.mob.entity.base.EntityMultiLivesTameable;
import xol.lostinfinity.mob.entity.base.EntityMultipleLives;

public class CustomDamageResult {
    private LivingEntity target;
    private Entity attacker;
    private boolean validHit = true;
    private boolean sucessfulHit = true;
    private boolean targetLifeTaken = false;
    private boolean targetKilled = false;
    private float intendedDamage = 0.0f;
    private float preTargetHealth = 0.0f;
    private float postTargetHealth = 0.0f;
    private float damageDealt = 0.0f;
    private List<Float> damageReductions = new ArrayList<Float>();
    private List<Float> damageAmplifications = new ArrayList<Float>();
    private List<String> damageClassifications = new ArrayList<String>();

    public CustomDamageResult(Entity attacker, LivingEntity target) {
        this.target = target;
        this.preTargetHealth = target.func_110143_aJ();
        this.attacker = attacker;
    }

    public void addClassifications(List<String> damageTypes) {
        if (damageTypes != null) {
            this.damageClassifications.addAll(damageTypes);
        }
    }

    public void setIntendedDamage(float intended) {
        this.intendedDamage = intended;
    }

    public void setHitMissed() {
        this.sucessfulHit = false;
    }

    public void setHitInvalid() {
        this.validHit = false;
    }

    public void addReduction(float reduction) {
        this.damageReductions.add(Float.valueOf(reduction));
    }

    public void addAmplification(float amplification) {
        this.damageAmplifications.add(Float.valueOf(amplification));
    }

    public void finishHitData(float final_damage, float postHealth) {
        this.damageDealt = final_damage;
        this.postTargetHealth = postHealth;
        if (postHealth <= 0.0f) {
            this.takeLife();
        }
    }

    public void takeLife() {
        this.targetLifeTaken = true;
        if (this.target instanceof EntityMultipleLives) {
            EntityMultipleLives multiTarget = (EntityMultipleLives)this.target;
            if (multiTarget.onFinalLife()) {
                this.targetKilled = true;
            }
        } else if (this.target instanceof EntityMultiLivesTameable) {
            EntityMultiLivesTameable multiTarget = (EntityMultiLivesTameable)this.target;
            if (multiTarget.onFinalLife()) {
                this.targetKilled = true;
            }
        } else {
            this.targetKilled = true;
        }
    }

    public LivingEntity getDamageTarget() {
        return this.target;
    }

    public Entity getAttacker() {
        return this.attacker;
    }

    public boolean didSuccessfulHit() {
        return this.sucessfulHit && this.validHit;
    }

    public boolean wasHitValid() {
        return this.validHit;
    }

    public boolean hitBlockedOrDodged() {
        return this.validHit && !this.didSuccessfulHit();
    }

    public boolean didTargetLoseLife() {
        return this.targetLifeTaken;
    }

    public boolean wasTargetKilled() {
        return this.targetKilled;
    }

    public float getIntendedDamage() {
        return this.intendedDamage;
    }

    public float getInitialTargetHealth() {
        return this.preTargetHealth;
    }

    public float getTargetEndHealth() {
        return this.postTargetHealth;
    }

    public float getDamageDealt() {
        if (this.damageDealt < 0.0f) {
            return 0.0f;
        }
        return this.damageDealt;
    }

    public boolean targetHealthChanged() {
        return this.preTargetHealth != this.postTargetHealth;
    }

    public int numberOfReductions() {
        return this.damageReductions.size();
    }

    public int numberOfAmplifications() {
        return this.damageAmplifications.size();
    }

    public float extraDamageDealt() {
        if (this.numberOfAmplifications() == 0) {
            return 0.0f;
        }
        float extra = 0.0f;
        for (float f : this.damageAmplifications) {
            extra += f;
        }
        return extra;
    }

    public float damageReduced() {
        if (this.numberOfReductions() == 0) {
            return 0.0f;
        }
        float reduced = 0.0f;
        for (float f : this.damageReductions) {
            reduced += f;
        }
        return reduced;
    }
}

