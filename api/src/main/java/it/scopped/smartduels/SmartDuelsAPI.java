package it.scopped.smartduels;

import it.scopped.smartduels.workload.WorkloadService;
import org.bukkit.Server;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.nio.file.Path;
import java.util.logging.Logger;

public interface SmartDuelsAPI {

    void reload();

    void disable();

    WorkloadService workloadService();

    Path arenasFolder();

    Server server();

    Logger logger();

    Plugin bootstrap();

}
