package me.corecraft.staffplus.api.managers;

import ch.jalu.configme.SettingsManager;
import ch.jalu.configme.SettingsManagerBuilder;
import ch.jalu.configme.resource.YamlFileResourceOptions;
import com.ryderbelserion.cluster.api.config.StorageManager;
import me.corecraft.staffplus.StaffPlus;
import me.corecraft.staffplus.config.Config;
import me.corecraft.staffplus.config.Messages;
import me.corecraft.staffplus.config.persist.Items;
import java.io.File;

public class ConfigManager {

    private final File dataFolder;

    private final StorageManager storageManager;

    public ConfigManager(StaffPlus plugin) {
        this.dataFolder = plugin.getDataFolder();

        this.storageManager = plugin.getPaperPlugin().getStorageManager();
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

        this.storageManager.addFile(new Items(this.dataFolder.toPath()));
    }

    public void reload() {
        this.config.reload();

        this.storageManager.saveFile(new Items(this.dataFolder.toPath()));

        this.messages.reload();
    }

    public void save() {
        this.config.save();

        this.storageManager.saveFile(new Items(this.dataFolder.toPath()));

        this.messages.save();
    }

    public SettingsManager getConfig() {
        return this.config;
    }

    public SettingsManager getMessages() {
        return this.messages;
    }
}