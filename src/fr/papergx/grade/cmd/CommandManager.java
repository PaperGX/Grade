package fr.papergx.grade.cmd;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class CommandManager implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(!(commandSender instanceof Player)) {return false;}
        final Player player = (Player) commandSender;
        final String prefix = "§2§lIrilia§a§lMC §f§l➜ §f";
        if(!player.hasPermission("grade.use")) {player.sendMessage(prefix + "§cTu n'as pas la permission de faire cela !");}
        switch (strings.length) {
            case 0:
                messageHelp(player);
                break;
            case 3:
                if(strings[0].equalsIgnoreCase("set")) {
                    if (Bukkit.getPlayer(strings[1]) == null) {return false;}
                    final Player player1 = Bukkit.getPlayer(strings[1]);
                    final File dataFile = new File("plugins/Grade/" + player1.getUniqueId()+ ".yml");
                    final YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(dataFile);
                    yamlConfiguration.set("grade", strings[2].toUpperCase());
                    player.sendMessage(prefix + "Le grade de §a§l" + strings[1] + " §fa été changé avec §a§lsuccès");
                    try {
                        yamlConfiguration.save(dataFile);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    messageHelp(player);
                }
                break;
        }
        return false;
    }

    private void messageHelp(Player player) {
        player.sendMessage("§a§m-----------------------------");
        player.sendMessage(" ");
        player.sendMessage("§f§lPlugin §7§l➜ §2§lGrade");
        player.sendMessage(" ");
        player.sendMessage("§7§l➥ §a/grade set (pseudo) (grade) §7§l➢ §fPermet de mettre un grade a un joueur");
        player.sendMessage(" ");
        player.sendMessage("§a§m-----------------------------");
    }
}
