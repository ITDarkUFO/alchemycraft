package net.alchemycraft;

import net.alchemycraft.config.HandlersConfig;
import net.alchemycraft.screen.alchemynomicon.AlchemynomiconScreen;
import net.alchemycraft.screen.mortar.MortarScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.screen.v1.ScreenEvents;
import net.fabricmc.fabric.api.client.screen.v1.Screens;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.ButtonWidget.PressAction;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.s2c.play.WorldTimeUpdateS2CPacket;
import net.minecraft.server.network.ServerPlayNetworkHandler;

@Environment(EnvType.CLIENT)
public class AlchemyCraftClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        HandledScreens.register(HandlersConfig.MORTAR_HANDLER, MortarScreen::new);

        ScreenEvents.AFTER_INIT.register((client, screen, scaledWidth, scaledHeight) -> {
            if (screen instanceof AlchemynomiconScreen) {
                PressAction setTimeAction = (button) -> {
                    // long time = client.getServer().getOverworld().getTime();
                    // long timeOfDay = client.getServer().getOverworld().getTimeOfDay();

                    // Packet<ClientPlayPacketListener> packet = new WorldTimeUpdateS2CPacket(time, timeOfDay, true);

                    // ServerPlayNetworking.send(null, null, null);
                    // client.getServer().send
                    // client.world.sendPacket(packet);

                    // client.getNetworkHandler().sendPacket(packet);
                    // client.world.sendPacket(packet);
                };
            
                ButtonWidget button = new ButtonWidget(100, 100, 50, 20, screen.getTitle(), setTimeAction);
                
                Screens.getButtons(screen).add(button);
            }
        });   
    }
}