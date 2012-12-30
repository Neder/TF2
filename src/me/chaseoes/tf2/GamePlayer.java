package me.chaseoes.tf2;

import me.chaseoes.tf2.classes.TF2Class;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class GamePlayer {

    Player player;
    String map;
    Team team;
    int kills;
    int deaths;
    int totalKills;
    int totalDeaths;
    boolean inLobby;
    boolean usingChangeClassButton;
    boolean makingChangeClassButton;
    boolean makingClassButton;
    boolean justSpawned;
    String classButtonType;
    String classButtonName;
    TF2Class currentClass;

    ItemStack[] savedInventoryItems;
    ItemStack[] savedArmorItems;
    GameMode savedGameMode;
    float savedXPCount;
    int savedLevelCount;
    int savedFoodLevel;
    int savedHealth;

    public GamePlayer(Player p) {
        player = p;
        team = null;
        map = null;
        kills = 0;
        deaths = 0;
        inLobby = false;
        savedInventoryItems = null;
        savedArmorItems = null;
        savedXPCount = 0;
        savedLevelCount = 0;
        savedFoodLevel = 0;
        savedHealth = 0;
        savedGameMode = null;
    }

    public Game getGame() {
        if(getCurrentMap() == null)
            return null;
        return GameUtilities.getUtilities().games.get(getCurrentMap());
    }

    public Player getPlayer() {
        return player;
    }

    public String getName() {
        return player.getName();
    }

    public boolean isIngame() {
        return team != null;
    }

    public boolean isInLobby() {
        return inLobby;
    }

    public void setInLobby(boolean b) {
        inLobby = b;
    }

    public String getCurrentMap() {
        return map;
    }

    public void setMap(String m) {
        map = m;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team t) {
        team = t;
    }

    public int getKills() {
        return kills;
    }

    public void setKills(int i) {
        if (i == -1) {
            kills++;
        } else {
            kills = i;
        }
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int i) {
        if (i == -1) {
            deaths++;
        } else {
            deaths = i;
        }
    }

    public String getTeamColor(Player player) {
        if (!isIngame()) {
            return null;
        }

        String color = "" + ChatColor.BLUE + ChatColor.BOLD;
        if (getTeam() == Team.RED) {
            color = "" + ChatColor.DARK_RED + ChatColor.BOLD;
        }

        return color;
    }

    public void leaveCurrentGame() {
        getGame().leave(player, false);
    }

    public void saveInventory() {
        savedInventoryItems = player.getInventory().getContents();
        savedArmorItems = player.getInventory().getArmorContents();
        savedXPCount = player.getExp();
        savedLevelCount = player.getLevel();
        savedFoodLevel = player.getFoodLevel();
        savedHealth = player.getHealth();
        savedGameMode = player.getGameMode();
    }

    @SuppressWarnings("deprecation")
    public void loadInventory() {
        player.getInventory().setContents(savedInventoryItems);
        player.getInventory().setArmorContents(savedArmorItems);
        player.setExp(savedXPCount);
        player.setLevel(savedLevelCount);
        player.setFoodLevel(savedFoodLevel);
        player.setHealth(savedHealth);
        player.setGameMode(savedGameMode);
        player.updateInventory();
    }

    public void setUsingChangeClassButton(Boolean b) {
        usingChangeClassButton = b;
    }

    public void setMakingChangeClassButton(Boolean b) {
        makingChangeClassButton = b;
    }

    public boolean isUsingChangeClassButton() {
        return usingChangeClassButton;
    }

    public boolean isMakingChangeClassButton() {
        return makingChangeClassButton;
    }

    public void setMakingClassButton(boolean b) {
        makingClassButton = b;
    }

    public boolean isMakingClassButton() {
        return makingClassButton;
    }

    public void setClassButtonType(String s) {
        classButtonType = s;
    }

    public String getClassButtonType() {
        return classButtonType;
    }

    public void setClassButtonName(String name) {
        classButtonName = name;
    }

    public String getClassButtonName() {
        return classButtonName;
    }

    public TF2Class getCurrentClass() {
        return currentClass;
    }

    public void setCurrentClass(TF2Class c) {
        currentClass = c;
    }

    public int getTotalKills() {
        return totalKills;
    }

    public void setTotalKills(int i) {
        if (i == -1) {
            totalKills++;
        } else {
            totalKills = i;
        }
    }

    public int getTotalDeaths() {
        return totalDeaths;
    }

    public void settotalDeaths(int i) {
        if (i == -1) {
            totalDeaths++;
        } else {
            totalDeaths = i;
        }
    }
    
    public boolean justSpawned() {
        return justSpawned;
    }
    
    public void setJustSpawned(Boolean b) {
        justSpawned = b;
    }

}
