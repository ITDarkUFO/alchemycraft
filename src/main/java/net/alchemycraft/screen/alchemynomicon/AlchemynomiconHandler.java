package net.alchemycraft.screen.alchemynomicon;

import java.util.ArrayList;
import java.util.List;

import net.alchemycraft.config.HandlersConfig;
import net.alchemycraft.item.AlchemynomiconItem;
import net.alchemycraft.screen.AbstractPage;
import net.alchemycraft.screen.alchemynomicon.pages.Test;
import net.alchemycraft.screen.alchemynomicon.pages.Test1;
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
	protected List<AbstractPage> pageList = new ArrayList<>();
	protected Integer pageNumber = 0;

	private final PlayerInventory playerInventory;
	public final Inventory inventory;

	public AlchemynomiconHandler(int syncId, PlayerInventory playerInventory) {
		this(HandlersConfig.ALCHEMYNOMICON_HANDLER, syncId, playerInventory, new SimpleInventory(1));
	}

	public AlchemynomiconHandler(int syncId, PlayerInventory playerInventory, Inventory inventory) {
		this(HandlersConfig.ALCHEMYNOMICON_HANDLER, syncId, playerInventory, inventory);
	}

	public AlchemynomiconHandler(ScreenHandlerType<?> type, int syncId, PlayerInventory playerInventory,
			Inventory inventory) {
		super(type, syncId);

		this.playerInventory = playerInventory;
		this.inventory = inventory;

		checkSize(this.inventory, 1);
		this.inventory.onOpen(this.playerInventory.player);

		// Add pages
		pageList.add(new Test(this));
		pageList.add(new Test1(this));

		// Draw pages
		getPage().draw(this);
	}

	// Paginator
	public AbstractPage getPage() {
		return pageList.get(pageNumber);
	}

	public void nextPage() {
		if (pageNumber >= pageList.size() - 1)
			pageNumber = 0;
		else
			pageNumber += 1;

		getPage().draw(this);
	}

	public void prevPage() {
		if (pageNumber <= 0)
			pageNumber = pageList.size() - 1;
		else
			pageNumber -= 1;

		getPage().draw(this);
	}

	public Slot addSlot(Slot slot) {
		return super.addSlot(slot);
	}
	
	// Pass Inventories
	public Inventory getInventory() {
		return inventory;
	}

	public PlayerInventory getPlayerInventory() {
		return playerInventory;
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
		ItemStack newStack = ItemStack.EMPTY;
		return newStack;
	}

	@Override
	public void close(PlayerEntity player) {
		this.dropInventory(player, inventory);
		super.close(player);
	}
}
