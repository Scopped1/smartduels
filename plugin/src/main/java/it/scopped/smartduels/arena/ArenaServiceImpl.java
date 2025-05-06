package it.scopped.smartduels.arena;

import it.scopped.smartduels.SmartDuels;
import it.scopped.smartduels.arena.model.ArenaImpl;
import it.scopped.smartduels.generic.Reloadable;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ArenaServiceImpl implements ArenaService, Reloadable {

    private final SmartDuels plugin;
    private final Map<String, Arena> loadedArenas = new HashMap<>();

    public ArenaServiceImpl(SmartDuels plugin) {
        this.plugin = plugin;
        reload();
    }

    @Override
    public void reload() {
        loadedArenas.clear();

        File folder = plugin.arenasFolder().toFile();

        if (!folder.exists()) {
            folder.mkdirs();
            return;
        }

        File[] files = folder.listFiles();
        if (files == null) return;

        for (File file : files) {
            if (!file.getName().endsWith(".yml")) continue;

            try {
                YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
                String identifier = file.getName().replace(".yml", "");

                loadedArenas.put(identifier, new ArenaImpl(plugin, identifier, config));
            } catch (Exception e) {
                plugin.logger().severe("Failed to load arena " + file.getName());
            }
        }

        plugin.logger().info("Loaded " + loadedArenas.size() + " arenas.");
    }

    @Override
    public void create(String identifier) {
        File file = new File(plugin.arenasFolder().toFile(), identifier + ".yml");

        if (file.exists()) {
            plugin.logger().warning("Arena " + identifier + " already exists.");
            return;
        }

        try {
            file.createNewFile();
            YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
            config.save(file);

            loadedArenas.put(identifier, new ArenaImpl(plugin, identifier));
        } catch (Exception e) {
            plugin.logger().severe("Failed to create arena " + identifier + ": " + e.getMessage());
        }
    }

    @Override
    public void delete(String identifier) {
        File file = new File(plugin.arenasFolder().toFile(), identifier + ".yml");

        if (!file.exists()) {
            plugin.logger().warning("Arena " + identifier + " does not exist.");
            return;
        }

        try {
            file.delete();
            loadedArenas.remove(identifier);
        } catch (Exception e) {
            plugin.logger().severe("Failed to delete arena " + identifier + ": " + e.getMessage());
        }
    }

    @Override
    public Optional<Arena> find(String identifier) {
        return Optional.ofNullable(loadedArenas.get(identifier));
    }

    @Override
    public boolean validate(String identifier) {
        Optional<Arena> arena = find(identifier);
        return arena.isPresent() && arena.get().valid();
    }
}
