package me.corecraft.staffplus.api;

import me.corecraft.staffplus.StaffPlus;
import me.corecraft.staffplus.api.managers.CommandManager;
import me.corecraft.staffplus.api.managers.ConfigManager;

public class CrazyHandler {

    private final StaffPlus plugin;

    private ConfigManager configManager;
    private CommandManager commandManager;

    public CrazyHandler(StaffPlus plugin) {
        this.plugin = plugin;
    }

    public void load() {
        this.configManager = new ConfigManager(this.plugin);
        this.configManager.load();

        this.commandManager = new CommandManager(this.plugin);
        this.commandManager.load();
    }

    public void reload() {
        this.configManager.reload();
    }

    public void stop() {
        this.configManager.save();
    }

    public ConfigManager getConfigManager() {
        return this.configManager;
    }

    public CommandManager getCommandManager() {
        return this.commandManager;
    }
}