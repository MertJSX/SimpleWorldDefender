package org.simpleworlddefender.simpleworlddefender.listeners;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.simpleworlddefender.simpleworlddefender.SimpleWorldDefender;

import java.util.Objects;

public class Defender implements Listener {

    private final SimpleWorldDefender plugin;

    public Defender(SimpleWorldDefender plugin) {
        this.plugin = plugin;
    }
    @EventHandler
    public void breakDefenderEvent(BlockBreakEvent event) {
        Player player = event.getPlayer();
        player.sendMessage(player.getWorld().getName());
        for (String world : this.plugin.getConfig().getStringList("disabled.breaking-blocks")) {
            player.sendMessage(world);
            if (player.getWorld().getName().equals(world)) {
                if (player.getGameMode() == GameMode.SURVIVAL) {
                    player.sendMessage(ChatColor.YELLOW + "Breaking blocks on this world is disabled!");
                    event.setCancelled(true);
                    break;
                }
            }
        }
    }
    @EventHandler
    public void placeDefenderEvent(BlockPlaceEvent event) {
        Player player = event.getPlayer();
        for (String world : this.plugin.getConfig().getStringList("disabled.placing-blocks")) {
            if (player.getWorld().getName().equals(world)) {
                if (player.getGameMode() == GameMode.SURVIVAL) {
                    player.sendMessage(ChatColor.YELLOW + "Placing blocks on this world is disabled!");
                    event.setCancelled(true);
                    break;
                }
            }
        }
    }
}
