package net.advait.testmod.effect;

import net.minecraft.world.Difficulty;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;

public class RadiationEffect extends MobEffect {
    public RadiationEffect(MobEffectCategory mobEffectCategory, int colour) {
        super(mobEffectCategory, colour);
    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        if (!pLivingEntity.level.isClientSide()) {
            if (!pLivingEntity.isInvulnerableTo(DamageSource.WITHER)) {
                pLivingEntity.addEffect(new MobEffectInstance(MobEffects.WITHER, 400));
            }
        }
        super.applyEffectTick(pLivingEntity, pAmplifier);
    }
    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return true;
    }
}



