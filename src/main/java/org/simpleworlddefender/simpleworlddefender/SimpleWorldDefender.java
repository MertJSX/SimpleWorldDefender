package org.simpleworlddefender.simpleworlddefender;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.simpleworlddefender.simpleworlddefender.listeners.Defender;

public final class SimpleWorldDefender extends JavaPlugin {
    FileConfiguration worlds = getConfig();

    @Override
    public void onEnable() {
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new Defender(this), this);
        getServer().getConsoleSender().sendMessage(ChatColor.DARK_GREEN + "SimpleWordDefender has started!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }


}
