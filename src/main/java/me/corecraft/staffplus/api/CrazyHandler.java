package me.corecraft.staffplus.api;

import me.corecraft.staffplus.StaffPlus;
import me.corecraft.staffplus.api.managers.CommandManager;
import me.corecraft.staffplus.api.managers.ConfigManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public class CrazyHandler {

    @NotNull
    private final StaffPlus plugin = JavaPlugin.getPlugin(StaffPlus.class);

    @NotNull
    private ConfigManager configManager = this.plugin.getCrazyHandler().getConfigManager();

    @NotNull
    private CommandManager commandManager = this.plugin.getCrazyHandler().getCommandManager();

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