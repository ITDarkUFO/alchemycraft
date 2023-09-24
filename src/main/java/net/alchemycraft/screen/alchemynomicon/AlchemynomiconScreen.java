package net.alchemycraft.screen.alchemynomicon;

import java.util.List;

import com.mojang.blaze3d.systems.RenderSystem;

import net.alchemycraft.config.Config;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class AlchemynomiconScreen extends Screen {
    protected int backgroundWidth = 176;
    protected int backgroundHeight = 166;

    private final Identifier TEXTURE = new Identifier(Config.MOD_ID, "textures/gui/alchemynomicon/alchemynomicon.png");
    private ItemStack stack;
    private NbtCompound nbt;

    private List<String> pages = List.of("deepslate_silver_ore", "brain_in_jar");

    public AlchemynomiconScreen(ItemStack stack) {
        this(Text.of("Temp"));
        this.stack = stack;

        this.nbt = stack.getNbt();

        if (this.nbt == null)
        {
            this.nbt = new NbtCompound();
            this.nbt.putInt("page", 0);
            stack.setNbt(nbt);
        }
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
        var itemStack = new ItemStack(Registry.ITEM.get(new Identifier(Config.MOD_ID, pages.get(nbt.getInt("page")))));
        this.itemRenderer.renderInGui(itemStack, 157, 32);

        super.render(matrices, mouseX, mouseY, delta);
    }

    public void openPage()
    {
        nbt.putInt("page", 1);
    }

    @Override
    public void close() {
        stack.writeNbt(nbt);
        super.close();
    }
}
