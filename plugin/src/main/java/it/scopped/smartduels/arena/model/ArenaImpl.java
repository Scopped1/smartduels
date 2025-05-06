package it.scopped.smartduels.arena.model;

import it.scopped.smartduels.SmartDuels;
import it.scopped.smartduels.arena.Arena;
import it.scopped.smartduels.serializer.LocationSerializer;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.ArrayList;
import java.util.List;

public class ArenaImpl implements Arena {

    private final SmartDuels plugin;

    private final String identifier;
    private boolean busy;

    private Location firstSpawn;
    private Location secondSpawn;
    private Location spectatorSpawn;
    private final List<Block> placedBlocks;

    public ArenaImpl(SmartDuels plugin, String identifier) {
        this.plugin = plugin;

        this.identifier = identifier;
        this.busy = false;

        this.firstSpawn = null;
        this.secondSpawn = null;
        this.spectatorSpawn = null;
        this.placedBlocks = new ArrayList<>();
    }

    public ArenaImpl(SmartDuels plugin, String identifier, FileConfiguration config) {
        this.plugin = plugin;

        this.identifier = identifier;
        this.busy = false;

        this.firstSpawn = LocationSerializer.deserialize(config.getString("first_spawn"));
        this.secondSpawn = LocationSerializer.deserialize(config.getString("second_spawn"));
        this.spectatorSpawn = LocationSerializer.deserialize(config.getString("spectator_spawn"));
        this.placedBlocks = new ArrayList<>();
    }

    @Override
    public void reset() {
        placedBlocks.forEach(block ->
                plugin.workloadService().workload(() -> block.setType(Material.AIR)));
    }

    @Override
    public boolean valid() {
        return !busy && firstSpawn != null && secondSpawn != null && spectatorSpawn != null && placedBlocks.isEmpty();
    }

    @Override
    public String identifier() {
        return identifier;
    }

    @Override
    public Location firstSpawn() {
        return firstSpawn;
    }

    @Override
    public Location secondSpawn() {
        return secondSpawn;
    }

    @Override
    public Location spectatorSpawn() {
        return spectatorSpawn;
    }

    @Override
    public boolean busy() {
        return busy;
    }

    @Override
    public List<Block> placedBlocks() {
        return placedBlocks;
    }

    @Override
    public void setBusy(boolean busy) {
        this.busy = busy;
    }

    @Override
    public void setFirstSpawn(Location firstSpawn) {
        this.firstSpawn = firstSpawn;
    }

    @Override
    public void setSecondSpawn(Location secondSpawn) {
        this.secondSpawn = secondSpawn;
    }

    @Override
    public void setSpectatorSpawn(Location spectatorSpawn) {
        this.spectatorSpawn = spectatorSpawn;
    }
}
