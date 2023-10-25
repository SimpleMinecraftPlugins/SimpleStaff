package me.corecraft.staffplus.api;

import me.corecraft.staffplus.api.managers.CommandManager;
import me.corecraft.staffplus.api.managers.ConfigManager;
import org.jetbrains.annotations.NotNull;

public class CrazyHandler {

    private ConfigManager configManager;

    private CommandManager commandManager;

    public void load() {
        this.configManager = new ConfigManager();
        this.configManager.load();

        this.commandManager = new CommandManager();
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