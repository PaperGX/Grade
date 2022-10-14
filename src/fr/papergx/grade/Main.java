package fr.papergx.grade;

import fr.papergx.grade.cmd.CommandManager;
import fr.papergx.grade.listeners.Listeners;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    private Grade grade;

    @Override
    public void onLoad() {
        grade = new Grade(this);
    }

    @Override
    public void onEnable() {
        grade.initscoreboard();
        getServer().getPluginManager().registerEvents(new Listeners(grade), this);
        getCommand("grade").setExecutor(new CommandManager());
    }

    @Override
    public void onDisable() {

    }
}
