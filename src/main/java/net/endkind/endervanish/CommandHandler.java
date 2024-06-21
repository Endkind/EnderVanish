package net.endkind.endervanish;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Set;

public class CommandHandler implements CommandExecutor {

    private final Set<Player> vanishedPlayers = new HashSet<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§5EnderVanish§8 >>§4 This command can only be executed by a player");
            return true;
        }

        Player player = (Player) sender;

        if (vanishedPlayers.contains(player)) {
            for (Player onlinePlayer: Bukkit.getOnlinePlayers()) {
                onlinePlayer.showPlayer(player);
            }
            vanishedPlayers.remove(player);
            player.sendMessage("§5EnderVanish§8 >>§2 You are now visible");
        } else {
            for (Player onlinePlayer: Bukkit.getOnlinePlayers()) {
                onlinePlayer.hidePlayer(player);
            }
            vanishedPlayers.add(player);
            player.sendMessage("§5EnderVanish§8 >>§6 You are now invisible");
        }

        return true;
    }
}
