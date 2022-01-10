package net.alchemycraft.item;

import net.alchemycraft.registry.AlchemyItemsGroups;
import net.minecraft.item.ToolMaterial;

public class AlchemyBowlOfSalt extends AlchemyBowlOfPowder {
    public AlchemyBowlOfSalt(ToolMaterial material, Settings settings) {
        super(material, settings.group(AlchemyItemsGroups.MISC));
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