package it.scopped.smartduels.arena;

import org.bukkit.Location;
import org.bukkit.block.Block;

import java.util.List;

public interface Arena {

    void reset();

    boolean valid();

    String identifier();

    Location firstSpawn();

    Location secondSpawn();

    Location spectatorSpawn();

    boolean busy();

    List<Block> placedBlocks();

    void setBusy(boolean busy);

    void setFirstSpawn(Location firstSpawn);

    void setSecondSpawn(Location secondSpawn);

    void setSpectatorSpawn(Location spectatorSpawn);


}
