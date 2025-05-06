package it.scopped.smartduels.configurations;

import it.scopped.smartduels.SmartDuelsAPI;
import net.pino.simpleconfig.BaseConfig;
import net.pino.simpleconfig.annotations.Config;
import net.pino.simpleconfig.annotations.ConfigFile;

@Config
@ConfigFile("settings.yml")
public class SettingsConfig extends BaseConfig {

    public SettingsConfig(SmartDuelsAPI plugin) {
        registerConfig(plugin.bootstrap());
    }

}
