package fr.papergx.grade;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import java.io.File;
import java.io.IOException;

public class Grade {
    private Scoreboard scoreboard;
    private Main main;

    public Grade(Main main) {
        this.main = main;
    }

    public Scoreboard getScoreboard() {
        return scoreboard;
    }

    public Main getMain() {
        return main;
    }
    private GradeList gradeList;
    private String playerPrefix;

    public void initscoreboard() {
        if (scoreboard !=null) throw new UnsupportedOperationException("Le scoreboard est deja creer");
        scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
        for (GradeList gradeList : GradeList.values()){
            Team team = scoreboard.registerNewTeam(gradeList.getName());
            team.setPrefix(gradeList.getPrefix());
        }
    }

    public void loadPlayer(Player player) {
        File dataFile = new File("plugins/Grade/dataPlayer.yml");
        YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(dataFile);
        if(yamlConfiguration.contains(player.getUniqueId().toString()+ ".grade")) {return;}
        yamlConfiguration.set(player.getUniqueId().toString()+ ".grade", GradeList.RECRUE.getName());
        try {
            yamlConfiguration.save(dataFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public GradeList getGradePlayer(Player player) {
        File dataFile = new File("plugins/Grade/dataPlayer.yml");
        YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(dataFile);
        this.gradeList = GradeList.valueOf(yamlConfiguration.getString(player.getUniqueId().toString()+ ".grade").toUpperCase()); //KEZUK REPLACE
        return gradeList;
    }
    public String getPlayerPrefix(Player player) {
        File dataFile = new File("plugins/Grade/dataPlayer.yml");
        YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(dataFile);
        this.playerPrefix = GradeList.valueOf(yamlConfiguration.getString(player.getUniqueId().toString()+ ".grade").toUpperCase()).getPrefix(); //KEZUK REPLACE
        return playerPrefix;
    }
}
