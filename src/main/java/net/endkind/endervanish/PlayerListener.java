package net.endkind.endervanish;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerListener implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player joiningPlayer = event.getPlayer();
        CommandHandler commandHandler = (CommandHandler) EnderVanish.getInstance().getCommand("endervanish").getExecutor();

        for (Player vanishedPlayer : commandHandler.getVanishedPlayers()) {
            joiningPlayer.hidePlayer(EnderVanish.getInstance(), vanishedPlayer);
        }
    }
}
