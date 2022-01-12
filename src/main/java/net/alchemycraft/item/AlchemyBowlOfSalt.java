package net.alchemycraft.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class AlchemyBowlOfSalt extends AlchemyBowlOfPowder {
    public AlchemyBowlOfSalt(Settings settings) {
        super(settings.food(new FoodComponent.Builder().alwaysEdible().statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 20 * 10), 1f).statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 20 * 15), 0.25f).build()));
    }
    

    // @Override
    // public ActionResult useOnBlock(ItemUsageContext context) {
    // double x = context.getHitPos().x;
    // double y = context.getHitPos().y;
    // double z = context.getHitPos().z;
    // context.getWorld().addParticle(ParticleTypes.POOF, x, y, z, 0, 0.2, 0);

    // return super.useOnBlock(context);
    // }

    // @Override
    // public TypedActionResult<ItemStack> use(World world, PlayerEntity
    // playerEntity, Hand hand) {
    // double x = playerEntity.getEyePos().x;
    // double y = playerEntity.getEyePos().y;
    // double z = playerEntity.getEyePos().z;
    // world.addParticle(ParticleTypes.CLOUD, x, y, z, 0, 0.2, 0);
    // return super.use(world, playerEntity, hand);
    // }
}