package fr.sywoo.api.uhcconfig;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @Author : Baptiste#0001
 **/

public class ConfigData {

    private UUID uuid;
    private List<UHCConfig> configs;

    public ConfigData(UUID uuid){
        this.uuid = uuid;
        this.configs = new ArrayList<>();
    }

    public List<UHCConfig> getUhcConfigs() {
        return configs;
    }

    public ConfigData addUhcConfig(UHCConfig uhcConfig){
        this.configs.add(uhcConfig);
        return this;
    }

    public ConfigData removeUhcConfig(UHCConfig uhcConfig){
        this.configs.remove(uhcConfig);
        return this;
    }

    public UHCConfig getUhcConfigByName(String name) {
        for (UHCConfig uhcConfig : configs) {
            if (uhcConfig.getName().equalsIgnoreCase(name)) {
                return uhcConfig;
            }
        }
        return null;
    }

    public List<UHCConfig> getConfigs() {
        return configs;
    }

    public ConfigData setConfigs(List<UHCConfig> configs) {
        this.configs = configs;
        return this;
    }

    public UUID getUUID() {
        return uuid;
    }
}
