package net.endkind.endervanish;

import org.bukkit.plugin.java.JavaPlugin;

public final class EnderVanish extends JavaPlugin {

    private static EnderVanish instance;

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("Enabling EnderVanish");

        instance = this;

        getServer().getPluginManager().registerEvents(new PlayerListener(), this);

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

    public static EnderVanish getInstance() {
        return instance;
    }
}
