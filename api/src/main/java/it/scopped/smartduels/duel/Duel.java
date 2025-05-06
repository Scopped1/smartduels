package it.scopped.smartduels.duel;

import it.scopped.smartduels.arena.Arena;
import it.scopped.smartduels.kit.Kit;
import org.bukkit.entity.Player;

public interface Duel {

    void start();

    void stop();

    Player sender();

    Player receiver();

    Kit selectedKit();

    Arena arena();

}
