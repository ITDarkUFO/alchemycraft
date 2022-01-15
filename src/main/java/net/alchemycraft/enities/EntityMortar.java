package net.alchemycraft.enities;

import java.util.Optional;
import java.util.Random;

import net.alchemycraft.configs.ConfigBlockEnities;
import net.alchemycraft.libs.utils.ImplementedInventory;
import net.alchemycraft.recipes.RecipesMortar;
import net.alchemycraft.screens.HandlerMortar;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EntityMortar extends BlockEntity implements NamedScreenHandlerFactory, ImplementedInventory {
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(4, ItemStack.EMPTY);

    public EntityMortar(BlockPos pos, BlockState state) {
        super(ConfigBlockEnities.GRANITE_MORTAR_ENTITY, pos, state);
    }

    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new HandlerMortar(syncId, playerInventory, this);
    }

    public Text getDisplayName() {
        return new TranslatableText(getCachedState().getBlock().getTranslationKey());
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        Inventories.readNbt(nbt, inventory);

    }

    @Override
    public void writeNbt(NbtCompound nbt) {
        Inventories.writeNbt(nbt, inventory);
        super.writeNbt(nbt);
    }

    // Crafting System
    public static void tick(World world, BlockPos blockPos, BlockState blockState, EntityMortar entity) {
        if (hasRecipe(entity) && isReachStackLimit(entity)) {
            craftItem(entity);
        }
    }
    
    private static void craftItem(EntityMortar entity) {
        World world = entity.world;
        SimpleInventory inventory = new SimpleInventory(entity.inventory.size());
        for (int i = 0; i < entity.inventory.size(); i++) {
            inventory.setStack(i, entity.getStack(i));
        }

        Optional<RecipesMortar> match = world.getRecipeManager().getFirstMatch(RecipesMortar.Type.INSTANCE, inventory,
                world);

        if (match.isPresent()) {
            entity.removeStack(0, 1); // First Inventory Slot
            entity.removeStack(1, 1); // Second Inventory Slot

            entity.inventory.get(2).damage(1, new Random(), null);

            entity.setStack(3, new ItemStack(match.get().getOutput().getItem(),
                    entity.getStack(3).getCount() + 1));
        }
    }

    private static boolean canInsertItemOutputSlot(SimpleInventory inventory, ItemStack output) {
        return inventory.getStack(3).getItem() == output.getItem() || inventory.getStack(3).isEmpty();
    }

    private static boolean canInsertAmountIntoOutputSlot(SimpleInventory inventory) {
        return inventory.getStack(3).getMaxCount() > inventory.getStack(3).getCount();
    }

    private static boolean isReachStackLimit(EntityMortar entity) {
        return entity.getStack(3).getCount() < entity.getStack(3).getMaxCount();
    }

    private static boolean hasRecipe(EntityMortar entity) {
        World world = entity.world;
        SimpleInventory inventory = new SimpleInventory(entity.inventory.size());
        for (int i = 0; i < entity.inventory.size(); i++) {
            inventory.setStack(i, entity.getStack(i));
        }

        Optional<RecipesMortar> match = world.getRecipeManager().getFirstMatch(RecipesMortar.Type.INSTANCE, inventory,
                world);

        return match.isPresent() && canInsertAmountIntoOutputSlot(inventory)
                && canInsertItemOutputSlot(inventory, match.get().getOutput());
    }
}
