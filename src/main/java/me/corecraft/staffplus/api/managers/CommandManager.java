package me.corecraft.staffplus.api.managers;

import dev.triumphteam.cmd.bukkit.BukkitCommandManager;
import me.corecraft.staffplus.StaffPlus;
import me.corecraft.staffplus.commands.StaffCommand;
import me.corecraft.staffplus.commands.handlers.ArgumentRelations;
import me.corecraft.staffplus.commands.handlers.MiscRelations;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public class CommandManager {

    @NotNull
    private final StaffPlus plugin = JavaPlugin.getPlugin(StaffPlus.class);

    @NotNull
    private final BukkitCommandManager<CommandSender> bukkitCommandManager = BukkitCommandManager.create(this.plugin);

    public void load() {
        this.bukkitCommandManager.registerCommand(new StaffCommand());

        new MiscRelations().build();
        new ArgumentRelations().build();
    }

    @NotNull
    public BukkitCommandManager<CommandSender> getBukkitCommandManager() {
        return this.bukkitCommandManager;
    }
}