package me.chaseoes.tf2.listeners;

import me.chaseoes.tf2.*;
import me.chaseoes.tf2.classes.TF2Class;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

public class PlayerRespawnListener implements Listener {

    @EventHandler
    public void onPlayerRespawn(final PlayerRespawnEvent event) {
        final GamePlayer gp = GameUtilities.getUtilities().getGamePlayer(event.getPlayer());
        Game game = gp.getGame();
        if (game == null) {
            return;
        }
        final Map map = game.getMap();
        event.setRespawnLocation(MapUtilities.getUtilities().loadTeamSpawn(map.getName(), gp.getTeam()));
        TF2Class c = gp.getCurrentClass();
        c.apply(gp);
    }
}
