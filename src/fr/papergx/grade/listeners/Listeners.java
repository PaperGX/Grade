package fr.papergx.grade.listeners;

import fr.papergx.grade.Grade;
import fr.papergx.grade.GradeList;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class Listeners implements Listener {
    private Grade grade;
    public Listeners(Grade grade) {
        this.grade = grade;
    }
    @EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        grade.loadPlayer(player);
    }

    @EventHandler
    public void onPlayerQuitEvent(PlayerQuitEvent event) {

    }

    @EventHandler
    public void AsyncChatEvent(AsyncPlayerChatEvent event) {
        GradeList gradeList = grade.getGradePlayer(event.getPlayer());
        event.setFormat(grade.getPlayerPrefix(event.getPlayer()) + ChatColor.RESET + " %1$s" + ChatColor.DARK_GRAY + ChatColor.BOLD + " ➜ " + ChatColor.GRAY + "%2$s");
        //"%1$s" évite une exploitation du chat lié au pseudo!
        //"%2$s" evite une exploitation du chat lié au message! si tu veut essayer le problème rentre l'une de ces deux valeurs dans ton chat ^^
    }
}
