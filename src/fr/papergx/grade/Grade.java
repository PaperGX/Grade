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
        switch (yamlConfiguration.getString(player.getUniqueId().toString()+ ".grade").toUpperCase()) {
            case "FONDATEUR":
                this.gradeList = GradeList.FONDATEUR;
                break;
            case "ADMINISTRATEUR":
                this.gradeList = GradeList.ADMINISTRATEUR;
                break;
            case "COMMUNITYMANAGER":
                this.gradeList = GradeList.COMMUNITYMANAGER;
                break;
            case "RESPONSABLE":
                this.gradeList = GradeList.RESPONSABLE;
                break;
            case "MODERATEURPLUS":
                this.gradeList = GradeList.MODERATEURPLUS;
                break;
            case "MODERATEUR":
                this.gradeList = GradeList.MODERATEUR;
                break;
            case "PARTENAIRE":
                this.gradeList = GradeList.PARTENAIRE;
                break;
            case "YOUTUBEURPLUS":
                this.gradeList = GradeList.YOUTUBEURPLUS;
                break;
            case "YOUTUBEUR":
                this.gradeList = GradeList.YOUTUBEUR;
                break;
            case "ROI":
                this.gradeList = GradeList.ROI;
                break;
            case "PRINCE":
                this.gradeList = GradeList.PRINCE;
                break;
            case "NOBLE":
                this.gradeList = GradeList.NOBLE;
                break;
            case "CHEVALIER":
                this.gradeList = GradeList.CHEVALIER;
                break;
            case "RECRUE":
                this.gradeList = GradeList.RECRUE;
                break;
        }
        return gradeList;
    }
    public String getPlayerPrefix(Player player) {
        File dataFile = new File("plugins/Grade/dataPlayer.yml");
        YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(dataFile);
        switch (yamlConfiguration.getString(player.getUniqueId().toString()+ ".grade").toUpperCase()) {
            case "FONDATEUR":
                this.playerPrefix = GradeList.FONDATEUR.getPrefix();
                break;
            case "ADMINISTRATEUR":
                this.playerPrefix = GradeList.ADMINISTRATEUR.getPrefix();
                break;
            case "COMMUNITYMANAGER":
                this.playerPrefix = GradeList.COMMUNITYMANAGER.getPrefix();
                break;
            case "RESPONSABLE":
                this.playerPrefix = GradeList.RESPONSABLE.getPrefix();
                break;
            case "MODERATEURPLUS":
                this.playerPrefix = GradeList.MODERATEURPLUS.getPrefix();
                break;
            case "MODERATEUR":
                this.playerPrefix = GradeList.MODERATEUR.getPrefix();
                break;
            case "PARTENAIRE":
                this.playerPrefix = GradeList.PARTENAIRE.getPrefix();
                break;
            case "YOUTUBEURPLUS":
                this.playerPrefix = GradeList.YOUTUBEURPLUS.getPrefix();
                break;
            case "YOUTUBEUR":
                this.playerPrefix = GradeList.YOUTUBEUR.getPrefix();
                break;
            case "ROI":
                this.playerPrefix = GradeList.ROI.getPrefix();
                break;
            case "PRINCE":
                this.playerPrefix = GradeList.PRINCE.getPrefix();
                break;
            case "NOBLE":
                this.playerPrefix = GradeList.NOBLE.getPrefix();
                break;
            case "CHEVALIER":
                this.playerPrefix = GradeList.CHEVALIER.getPrefix();
                break;
            case "RECRUE":
                this.playerPrefix = GradeList.RECRUE.getPrefix();
                break;
        }
        return playerPrefix;
    }
}
