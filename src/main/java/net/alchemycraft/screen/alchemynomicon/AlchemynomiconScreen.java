package net.alchemycraft.screen.alchemynomicon;

import java.util.List;

import com.mojang.blaze3d.systems.RenderSystem;

import net.fabricmc.fabric.api.client.screen.v1.Screens;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.ButtonWidget.PressAction;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

// import net.alchemycraft.config.Config;

public class AlchemynomiconScreen extends HandledScreen<AlchemynomiconHandler> {
    public AlchemynomiconHandler handler;
    
    private Identifier TEXTURE;

    public AlchemynomiconScreen(AlchemynomiconHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
        this.handler = handler;
        this.TEXTURE = handler.getPage().getTexture();
    }

    @Override
    protected void drawBackground(MatrixStack matrices, float delta, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - backgroundWidth) / 2;
        int y = 15;

        List<Integer> textureSize = handler.getPage().getTextureSize();
        drawTexture(matrices, x, y, getZOffset(), 0, 0, textureSize.get(0), textureSize.get(1), 256, 256);
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        PressAction prevPageAction = (button) -> {
            handler.prevPage();
            TEXTURE = handler.getPage().getTexture();
        };
        
        PressAction nextPageAction = (button) -> {
            handler.nextPage();
            TEXTURE = handler.getPage().getTexture();
        };

        ButtonWidget prevPage = new ButtonWidget(0, 0, 50, 20, Text.of("prev"), prevPageAction);
        ButtonWidget nextPage = new ButtonWidget(0, 25, 50, 20, Text.of("next"), nextPageAction);

        Screens.getButtons(this).add(prevPage);
        Screens.getButtons(this).add(nextPage);
        // Screens.getItemRenderer(this).renderItem(null, null, passEvents, matrices, null, mouseX, mouseY, null);

        renderBackground(matrices);
        super.render(matrices, mouseX, mouseY, delta);
        drawMouseoverTooltip(matrices, mouseX, mouseY);
    }
    
    @Override
    protected void init() {
        super.init();
        titleX = (backgroundWidth - textRenderer.getWidth(title)) / 2;
    }
}
