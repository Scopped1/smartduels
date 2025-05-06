package it.scopped.smartduels.boot;

import it.scopped.smartduels.SmartDuels;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public final class SmartDuelsBootstrap extends JavaPlugin {

    private SmartDuels plugin;

    @Override
    public void onEnable() {
        try {
            this.plugin = new SmartDuels(this);
        } catch (Exception e) {
            getLogger().log(Level.SEVERE, "Failed to enable the plugin.", e);
            getServer().getPluginManager().disablePlugin(this);
        }
    }

    @Override
    public void onDisable() {
        if (this.plugin != null) this.plugin.disable();
    }
}
