package it.scopped.smartduels;

import it.scopped.smartduels.boot.SmartDuelsBootstrap;
import it.scopped.smartduels.workload.WorkloadService;
import it.scopped.smartduels.workload.WorkloadServiceImpl;
import org.bukkit.Server;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.nio.file.Path;
import java.util.logging.Logger;

public class SmartDuels implements SmartDuelsAPI {

    private final SmartDuelsBootstrap bootstrap;

    private final WorkloadService workloadService;

    public SmartDuels(SmartDuelsBootstrap bootstrap) {
        this.bootstrap = bootstrap;

        this.workloadService = new WorkloadServiceImpl();
        this.workloadService.register(this);
    }

    @Override
    public void reload() {

    }

    @Override
    public void disable() {

    }

    @Override
    public WorkloadService workloadService() {
        return workloadService;
    }

    @Override
    public Path arenasFolder() {
        return bootstrap.getDataFolder().toPath().resolve("arenas");
    }

    @Override
    public Server server() {
        return bootstrap.getServer();
    }

    @Override
    public Logger logger() {
        return bootstrap.getLogger();
    }

    @Override
    public Plugin bootstrap() {
        return bootstrap;
    }
}
