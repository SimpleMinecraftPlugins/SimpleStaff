package me.corecraft.staffplus.api;

import me.corecraft.staffplus.StaffPlus;
import me.corecraft.staffplus.api.managers.CommandManager;
import me.corecraft.staffplus.api.managers.ConfigManager;

public class CrazyHandler {

    @NotNull

    @NotNull
    private CommandManager commandManager;

    @NotNull
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

    @NotNull
    public ConfigManager getConfigManager() {
        return this.configManager;
    }

    @NotNull
    public CommandManager getCommandManager() {
        return this.commandManager;
    }
}