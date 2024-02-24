package net.alchemycraft;

import net.alchemycraft.config.ClientConfig;
import net.alchemycraft.screen.alchemynomicon.AlchemynomiconScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.screen.v1.ScreenEvents;
import net.fabricmc.fabric.api.client.screen.v1.Screens;
import net.minecraft.client.gui.tooltip.Tooltip;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.ButtonWidget.PressAction;
import net.minecraft.text.Text;

@Environment(EnvType.CLIENT)
public class AlchemyCraftClient implements ClientModInitializer {
    private ClientConfig clientConfig;

    @Override
    public void onInitializeClient() {
        clientConfig = new ClientConfig();

        ScreenEvents.AFTER_INIT.register((client, screen, scaledWidth, scaledHeight) -> {
            if (screen instanceof AlchemynomiconScreen) {
                PressAction setTimeAction = (button) -> {
                    ((AlchemynomiconScreen) screen).openPage();
                    // long time = client.getServer().getOverworld().getTime();
                    // long timeOfDay = client.getServer().getOverworld().getTimeOfDay();

                    // Packet<ClientPlayPacketListener> packet = new WorldTimeUpdateS2CPacket(time,
                    // timeOfDay, true);

                    // ServerPlayNetworking.send(null, null, null);
                    // client.getServer().send
                    // client.world.sendPacket(packet);

                    // client.getNetworkHandler().sendPacket(packet);
                    // client.world.sendPacket(packet);
                };

                ButtonWidget button = new ButtonWidget.Builder(screen.getTitle(), setTimeAction)
                        .dimensions(100, 100, 50, 20)
                        .tooltip(Tooltip.of(Text.of("Тестовый текст кнопки")))
                        .build();

                Screens.getButtons(screen).add(button);
            }
        });

        clientConfig.init();
    }
}