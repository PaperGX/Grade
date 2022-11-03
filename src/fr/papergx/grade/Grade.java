package fr.papergx.grade;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import com.google.common.collect.Maps;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

public class Grade {
    private Scoreboard scoreboard;
    private Main main;
	private HashMap<UUID, PermissionAttachment> permissible;

    public Grade(Main main) {
        this.main = main;
        this.permissible = Maps.newHashMap();
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
        File dataFile = new File("plugins/Grade/" + player.getUniqueId() + ".yml");
        YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(dataFile);
        if(yamlConfiguration.contains("grade")) {
        	this.registerPermissions(player.getUniqueId());
        	return;
        }
        yamlConfiguration.set("grade", GradeList.RECRUE.getName());
        this.registerPermissions(player.getUniqueId());
        try {
            yamlConfiguration.save(dataFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public GradeList getGradePlayer(Player player) {
        File dataFile = new File("plugins/Grade/" + player.getUniqueId() + ".yml");
        YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(dataFile);
        this.gradeList = GradeList.valueOf(yamlConfiguration.getString("grade").toUpperCase()); //KEZUK REPLACE
        return gradeList;
    }
    public String getPlayerPrefix(Player player) {
        File dataFile = new File("plugins/Grade/" + player.getUniqueId() + ".yml");
        YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(dataFile);
        this.playerPrefix = GradeList.valueOf(yamlConfiguration.getString("grade").toUpperCase()).getPrefix(); //KEZUK REPLACE
        return playerPrefix;
    }
    
	public void registerPermissions(final UUID uuid) {
		PermissionAttachment attachment = Bukkit.getPlayer(uuid).addAttachment(this.main);
		this.getPermissible().put(uuid, attachment);
        File dataFile = new File("plugins/Grade/" + uuid + ".yml");
        YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(dataFile);
		for (String perm : GradeList.valueOf(yamlConfiguration.getString("grade").toUpperCase()).getPermissions()) {
			attachment.setPermission(perm, true);	
		}
	}
	
	public HashMap<UUID, PermissionAttachment> getPermissible() {
		return permissible;
	}
}
