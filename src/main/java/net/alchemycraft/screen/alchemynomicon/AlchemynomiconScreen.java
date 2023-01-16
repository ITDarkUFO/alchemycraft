package net.alchemycraft.screen.alchemynomicon;

import com.mojang.blaze3d.systems.RenderSystem;

import net.alchemycraft.config.Config;
import net.alchemycraft.config.ItemsConfig;
import net.fabricmc.fabric.api.client.screen.v1.Screens;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ClickableWidget;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class AlchemynomiconScreen extends Screen {
    protected int backgroundWidth = 176;
    protected int backgroundHeight = 166;

    private final Identifier TEXTURE = new Identifier(Config.MOD_ID, "textures/gui/alchemynomicon/alchemynomicon.png");

    public AlchemynomiconScreen(ItemStack stack) {
        this(Text.of("Temp"));
    }

    protected AlchemynomiconScreen(Text title) {
        super(title);
    }

    @Override
    public void renderBackground(MatrixStack matrices) {
        // Get page background
        RenderSystem.setShader(GameRenderer::getPositionColorTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - backgroundWidth) / 2;
        int y = 15;
        super.renderBackground(matrices);
        drawTexture(matrices, x, y, getZOffset(), 0, 0, 256, 256, 256, 256);
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        renderBackground(matrices);
        this.drawHorizontalLine(matrices, 100, 200, 50, -267386864);
        this.itemRenderer.renderInGui(new ItemStack(ItemsConfig.BOWL_OF_SALT), 169, 32);
        
        super.render(matrices, mouseX, mouseY, delta);
    }
}
