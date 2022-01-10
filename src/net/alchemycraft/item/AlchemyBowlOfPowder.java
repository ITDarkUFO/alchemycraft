package net.alchemycraft.item;

import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.ToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.Hand;

public class AlchemyBowlOfPowder extends ToolItem {
    public AlchemyBowlOfPowder(ToolMaterial material, Settings settings) {
        super(material, settings);
    }

    @Override
    public boolean damage(DamageSource source) {
        return super.damage(source);
    }

    public void changeDurability(PlayerEntity playerEntity, Hand hand) {
        int durability = playerEntity.getStackInHand(hand).getDamage();
        int maxDurability = playerEntity.getStackInHand(hand).getMaxDamage();

        if (durability != maxDurability - 1)
            playerEntity.getStackInHand(hand).setDamage(durability + 1);
        else {
            int slot = playerEntity.getInventory().selectedSlot;
            playerEntity.getInventory().setStack(slot, new ItemStack(Items.BOWL));
        }
    }

    public void changeDurability(PlayerEntity playerEntity, Hand hand, int durability) {
        int maxDurability = playerEntity.getStackInHand(hand).getMaxDamage();

        if (durability == 0 || maxDurability - durability == 0) {
            int slot = playerEntity.getInventory().selectedSlot;
            playerEntity.getInventory().setStack(slot, new ItemStack(Items.BOWL));
        } else {
            playerEntity.getStackInHand(hand).setDamage(maxDurability - durability);
        }
    }
}