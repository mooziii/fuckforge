package me.obsilabor.fuckforge;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.JoinConfiguration;
import net.kyori.adventure.text.event.ClickEvent;
import net.kyori.adventure.text.event.HoverEvent;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.messaging.PluginMessageListener;
import org.jetbrains.annotations.NotNull;
import java.nio.charset.StandardCharsets;

public class FuckForge extends JavaPlugin implements PluginMessageListener {

    @Override
    public void onEnable() {
        Bukkit.getMessenger().registerIncomingPluginChannel(this, "minecraft:brand", this);
    }

    @Override
    public void onPluginMessageReceived(@NotNull String channel, @NotNull Player player, byte[] message) {
        String brand = new String(message, StandardCharsets.UTF_8);
        if(brand.contains("forge")) {
            Component component = Component.join(JoinConfiguration.noSeparators(),
                    Component.text("How about using ").
                            color(TextColor.color(15961742)),
                    Component.text("Fabric")
                            .color(TextColor.color(16191761))
                            .decorate(TextDecoration.UNDERLINED)
                            .clickEvent(ClickEvent.openUrl("https://fabricmc.net/use/"))
                            .hoverEvent(HoverEvent.showText(Component.text("Download fabric."))),
                    Component.text(" instead of Forge?").
                            color(TextColor.color(15961742))
            );
            player.sendMessage(component);
        }
    }
}
