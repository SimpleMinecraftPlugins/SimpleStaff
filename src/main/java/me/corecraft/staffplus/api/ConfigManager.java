package me.corecraft.staffplus.api;

import ch.jalu.configme.SettingsManager;
import ch.jalu.configme.SettingsManagerBuilder;
import me.corecraft.staffplus.StaffPlus;
import me.corecraft.staffplus.config.Config;
import me.corecraft.staffplus.config.Messages;
import java.io.File;

public class ConfigManager {

    private final File dataFolder;

    public ConfigManager(StaffPlus staffPlus) {
        this.dataFolder = staffPlus.getDataFolder();
    }

    private SettingsManager config;
    private SettingsManager messages;

    public void load() {
        this.config = SettingsManagerBuilder
                .withYamlFile(new File(this.dataFolder, "config.yml"))
                .useDefaultMigrationService()
                .configurationData(Config.class)
                .create();

        this.messages = SettingsManagerBuilder
                .withYamlFile(new File(this.dataFolder, "messages.yml"))
                .useDefaultMigrationService()
                .configurationData(Messages.class)
                .create();
    }

    public void reload() {
        this.config.reload();

        this.messages.reload();
    }

    public void save() {
        this.config.save();

        this.messages.save();
    }
}