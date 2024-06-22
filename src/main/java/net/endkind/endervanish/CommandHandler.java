package net.endkind.endervanish;

import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CommandHandler implements CommandExecutor {

    private final Set<Player> vanishedPlayers = new HashSet<>();
    private final Map<Player, BossBar> vanishBossBars = new HashMap<>();

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
            removeVanishBossBar(player);
            player.sendMessage("§5EnderVanish§8 >>§2 You are now visible");
        } else {
            for (Player onlinePlayer: Bukkit.getOnlinePlayers()) {
                onlinePlayer.hidePlayer(player);
            }
            vanishedPlayers.add(player);
            showVanishBossBar(player);
            player.sendMessage("§5EnderVanish§8 >>§6 You are now invisible");
        }

        return true;
    }

    public Set<Player> getVanishedPlayers() {
        return vanishedPlayers;
    }

    private void showVanishBossBar(Player player) {
        BossBar bossBar = Bukkit.createBossBar(
                "You are in Vanish mode",
                BarColor.PURPLE,
                BarStyle.SOLID
        );
        bossBar.addPlayer(player);
        vanishBossBars.put(player, bossBar);
    }

    private void removeVanishBossBar(Player player) {
        BossBar bossBar = vanishBossBars.remove(player);
        if (bossBar != null) {
            bossBar.removeAll();
        }
    }
}
