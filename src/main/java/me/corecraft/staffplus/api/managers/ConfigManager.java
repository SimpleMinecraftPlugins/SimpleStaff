package me.corecraft.staffplus.api.managers;

import ch.jalu.configme.SettingsManager;
import ch.jalu.configme.SettingsManagerBuilder;
import ch.jalu.configme.resource.YamlFileResourceOptions;
import me.corecraft.staffplus.StaffPlus;
import me.corecraft.staffplus.config.Config;
import me.corecraft.staffplus.config.Messages;
import java.io.File;

public class ConfigManager {

    private final File dataFolder;

    public ConfigManager(StaffPlus plugin) {
        this.dataFolder = plugin.getDataFolder();
    }

    private SettingsManager config;
    private SettingsManager messages;

    public void load() {
        YamlFileResourceOptions builder = YamlFileResourceOptions.builder().indentationSize(2).build();

        this.config = SettingsManagerBuilder
                .withYamlFile(new File(this.dataFolder, "config.yml"), builder)
                .useDefaultMigrationService()
                .configurationData(Config.class)
                .create();

        this.messages = SettingsManagerBuilder
                .withYamlFile(new File(this.dataFolder, "messages.yml"), builder)
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

    public SettingsManager getConfig() {
        return this.config;
    }

    public SettingsManager getMessages() {
        return this.messages;
    }
}