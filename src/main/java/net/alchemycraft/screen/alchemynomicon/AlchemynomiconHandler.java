package net.alchemycraft.screen.alchemynomicon;

import net.alchemycraft.config.HandlersConfig;
import net.alchemycraft.item.AlchemynomiconItem;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.screen.slot.Slot;
import net.minecraft.screen.slot.SlotActionType;

public class AlchemynomiconHandler extends ScreenHandler {
	private final Inventory inventory;

	public AlchemynomiconHandler(int syncId, PlayerInventory playerInventory) {
		this(HandlersConfig.ALCHEMYNOMICON_HANDLER, syncId, playerInventory, new SimpleInventory(1));	
	}

	public AlchemynomiconHandler(int syncId, PlayerInventory playerInventory, Inventory inventory) {
		this(HandlersConfig.ALCHEMYNOMICON_HANDLER, syncId, playerInventory, inventory);
	}

	public AlchemynomiconHandler(ScreenHandlerType<?> type, int syncId, PlayerInventory playerInventory, Inventory inventory) {
		super(type, syncId);	
		
		this.inventory = inventory;
		checkSize(this.inventory, 1);

		this.inventory.onOpen(playerInventory.player);
		
		addPlayerInventory(playerInventory);
		addPlayerHotbar(playerInventory);
	}

	private void addPlayerInventory(PlayerInventory playerInventory) {
        for (int y = 0; y < 3; ++y)
            for (int x = 0; x < 9; ++x)
                this.addSlot(new Slot(playerInventory, x + y * 9 + 9, 8 + x * 18, 84 + y * 18));
    }

    private void addPlayerHotbar(PlayerInventory playerInventory) {
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 142));
        }
    }

	@Override
	public void onSlotClick(int slotId, int clickData, SlotActionType actionType, PlayerEntity playerEntity) {
		if (slotId >= 0) {
			ItemStack stack = getSlot(slotId).getStack();

			if (stack.getItem() instanceof AlchemynomiconItem)
				return;
		}

		super.onSlotClick(slotId, clickData, actionType, playerEntity);
	}

	@Override
	public boolean canUse(PlayerEntity player) {
		return true;
	}

	@Override
	public ItemStack transferSlot(PlayerEntity player, int index) {
		return null;
	}

}
