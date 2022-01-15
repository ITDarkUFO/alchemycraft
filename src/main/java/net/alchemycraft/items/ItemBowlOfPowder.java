package net.alchemycraft.items;

import net.alchemycraft.configs.ConfigItemsGroups;
import net.minecraft.item.Item;
import net.minecraft.item.Items;

public class ItemBowlOfPowder extends Item {
    public ItemBowlOfPowder(Settings settings) {
        super(settings.maxCount(16).recipeRemainder(Items.BOWL).group(ConfigItemsGroups.MISC));
    }

    // @Override
    // public boolean damage(DamageSource source) {
    // return super.damage(source);
    // }

    // public void changeDurability(PlayerEntity playerEntity, Hand hand) {
    // int durability = playerEntity.getStackInHand(hand).getDamage();
    // int maxDurability = playerEntity.getStackInHand(hand).getMaxDamage();

    // if (durability != maxDurability - 1)
    // playerEntity.getStackInHand(hand).setDamage(durability + 1);
    // else {
    // int slot = playerEntity.getInventory().selectedSlot;
    // playerEntity.getInventory().setStack(slot, new ItemStack(Items.BOWL));
    // }
    // }

    // public void changeDurability(PlayerEntity playerEntity, Hand hand, int
    // durability) {
    // int maxDurability = playerEntity.getStackInHand(hand).getMaxDamage();

    // if (durability == 0 || maxDurability - durability == 0) {
    // int slot = playerEntity.getInventory().selectedSlot;
    // playerEntity.getInventory().setStack(slot, new ItemStack(Items.BOWL));
    // } else {
    // playerEntity.getStackInHand(hand).setDamage(maxDurability - durability);
    // }
    // }

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