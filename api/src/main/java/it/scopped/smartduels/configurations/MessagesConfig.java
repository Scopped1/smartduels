package it.scopped.smartduels.configurations;

import it.scopped.smartduels.SmartDuelsAPI;
import net.pino.simpleconfig.BaseConfig;
import net.pino.simpleconfig.annotations.Config;
import net.pino.simpleconfig.annotations.ConfigFile;

@Config
@ConfigFile("messages.yml")
public class MessagesConfig extends BaseConfig {

    public MessagesConfig(SmartDuelsAPI plugin) {
        registerConfig(plugin.bootstrap());
    }

}
