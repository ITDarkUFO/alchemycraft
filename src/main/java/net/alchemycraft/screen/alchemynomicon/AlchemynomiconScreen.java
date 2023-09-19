package net.alchemycraft.screen.alchemynomicon;

import java.util.ArrayList;
import java.util.List;

import com.mojang.blaze3d.systems.RenderSystem;

import net.alchemycraft.config.Config;
import net.alchemycraft.config.ItemsConfig;
import net.fabricmc.fabric.api.client.screen.v1.Screens;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ClickableWidget;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class AlchemynomiconScreen extends Screen {
    protected int backgroundWidth = 176;
    protected int backgroundHeight = 166;

    private final Identifier TEXTURE = new Identifier(Config.MOD_ID, "textures/gui/alchemynomicon/alchemynomicon.png");
    private List<String> pages = List.of("deepslate_silver_ore", "brain_in_jar");
    private int page = 0;

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
        var itemStack = new ItemStack(Registry.ITEM.get(new Identifier(Config.MOD_ID, pages.get(page))));
        this.itemRenderer.renderInGui(itemStack, 157, 32);

        super.render(matrices, mouseX, mouseY, delta);
    }

    public void openPage()
    {
        page = 1;
    }
}
