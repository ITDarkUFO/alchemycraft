package net.alchemycraft.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class BowlOfSaltItem extends BowlOfPowderItem {
    public BowlOfSaltItem(Settings settings) {
        super(settings.food(new FoodComponent.Builder().alwaysEdible()
                .statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 20 * 10), 1f)
                .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 20 * 15), 0.25f).build()));
    }
}