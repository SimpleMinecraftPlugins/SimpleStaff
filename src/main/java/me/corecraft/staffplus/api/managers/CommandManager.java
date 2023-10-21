package me.corecraft.staffplus.api.managers;

import com.ryderbelserion.cluster.paper.PaperPlugin;
import dev.triumphteam.cmd.bukkit.BukkitCommandManager;
import me.corecraft.staffplus.StaffPlus;
import me.corecraft.staffplus.commands.StaffCommand;
import me.corecraft.staffplus.commands.handlers.ArgumentRelations;
import me.corecraft.staffplus.commands.handlers.MiscRelations;
import org.bukkit.command.CommandSender;

public class CommandManager {

    @NotNull

    @NotNull
    private final PaperPlugin paperPlugin;

    public CommandManager(StaffPlus plugin) {
        this.plugin = plugin;

        this.bukkitCommandManager = BukkitCommandManager.create(this.plugin);
        this.paperPlugin = this.plugin.getPaperPlugin();
    }

    public void load() {
        this.bukkitCommandManager.registerCommand(new StaffCommand(this.plugin));

        new MiscRelations(this.bukkitCommandManager, this.paperPlugin).build();
        new ArgumentRelations(this.bukkitCommandManager, this.paperPlugin).build();
    }

    @NotNull
    public BukkitCommandManager<CommandSender> getBukkitCommandManager() {
        return this.bukkitCommandManager;
    }
}