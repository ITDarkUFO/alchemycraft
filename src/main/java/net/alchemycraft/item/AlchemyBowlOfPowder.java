package net.alchemycraft.item;

import net.alchemycraft.registry.AlchemyItemsGroups;
import net.minecraft.item.Item;
import net.minecraft.item.Items;

public class AlchemyBowlOfPowder extends Item {
    public AlchemyBowlOfPowder(Settings settings) {
        super(settings.maxCount(16).recipeRemainder(Items.BOWL).group(AlchemyItemsGroups.MISC));
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
}