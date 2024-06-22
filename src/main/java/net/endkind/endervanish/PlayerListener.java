package net.endkind.endervanish;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerListener implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player joiningPlayer = event.getPlayer();
        CommandHandler commandHandler = (CommandHandler) EnderVanish.getInstance().getCommand("endervanish").getExecutor();

        for (Player vanishedPlayer : commandHandler.getVanishedPlayers()) {
            joiningPlayer.hidePlayer(EnderVanish.getInstance(), vanishedPlayer);
        }
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        CommandHandler commandHandler = (CommandHandler) EnderVanish.getInstance().getCommand("endervanish").getExecutor();

        commandHandler.clearVanish(player);
    }
}
