package it.scopped.smartduels.arena;

import org.bukkit.entity.Player;

import java.util.Optional;

public interface ArenaService {

    void create(String identifier);

    void delete(String identifier);

    Optional<Arena> find(String identifier);

    boolean validate(String identifier);

}
