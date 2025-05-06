package it.scopped.smartduels.utility;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class PlayerUtil {

    public static void resetPlayer(Player... players) {
        for (Player player : players) {
            player.getInventory().clear();
            player.getInventory().setArmorContents(null);

            player.setNoDamageTicks(0);
            player.setFireTicks(0);
            player.setVelocity(new Vector(0, 0, 0));

            player.setHealth(20);
            player.setFoodLevel(20);

            player.setGameMode(GameMode.SURVIVAL);

            player.setAllowFlight(false);
        }
    }

}
