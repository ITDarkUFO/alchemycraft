package net.alchemycraft.screen;

import java.util.List;

import net.minecraft.screen.ScreenHandler;
import net.minecraft.util.Identifier;

public abstract class AbstractPage {
    private final Identifier texture;
    private final int textureWidth;
    private final int textureHeight;

    protected final ScreenHandler handler;

    protected AbstractPage(ScreenHandler handler, Identifier texture) {
        this(handler, texture, 255, 255);
    }

    protected AbstractPage(ScreenHandler handler, Identifier texture, int textureWidth, int textureHeight) {
        this.handler = handler;
        
        this.texture = texture;
        this.textureWidth = textureWidth;
        this.textureHeight = textureHeight;
    }

    public void draw(ScreenHandler handler) {
        // handler.slots.clear();
    }

    public Identifier getTexture() {
        return texture;
    }

    public List<Integer> getTextureSize() {
        return List.of(textureWidth, textureHeight);
    } 
}
