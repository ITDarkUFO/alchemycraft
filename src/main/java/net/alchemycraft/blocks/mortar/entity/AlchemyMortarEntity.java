package net.alchemycraft.blocks.mortar.entity;

import net.alchemycraft.blocks.mortar.handler.AlchemyMortarHandler;
import net.alchemycraft.config.ConfigBlockEnities;
import net.alchemycraft.libs.utils.ImplementedInventory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;

public class AlchemyMortarEntity extends BlockEntity implements NamedScreenHandlerFactory, ImplementedInventory {

    public AlchemyMortarEntity(BlockPos pos, BlockState state) {
        super(ConfigBlockEnities.MORTAR_ENTITY, pos, state);
    }

    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new AlchemyMortarHandler(syncId, playerInventory, this);
    }

    public Text getDisplayName() {
        return new TranslatableText(getCachedState().getBlock().getTranslationKey());
    }

    // From the ImplementedInventory Interface
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(3, ItemStack.EMPTY);

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        Inventories.readNbt(nbt, this.inventory);

    }

    @Override
    public void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, this.inventory);
    }

    // @Override
    // public NbtCompound writeNbt(NbtCompound tag) {
    //     super.writeNbt(tag);
    //     return tag;
    // }
}
