package net.endkind.endervanish;

import org.bukkit.plugin.java.JavaPlugin;

public final class EnderVanish extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("Enabling EnderVanish");

        if (getCommand("endervanish") != null) {
            getCommand("endervanish").setExecutor(new CommandHandler());
        } else {
            getLogger().severe("Command 'endervanish' could not be found!");
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("Disabling EnderVanish");
    }
}
