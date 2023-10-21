package me.corecraft.staffplus.commands.handlers.interfaces;

import com.ryderbelserion.cluster.paper.PaperPlugin;
import dev.triumphteam.cmd.bukkit.BukkitCommandManager;
import net.kyori.adventure.text.Component;
import org.bukkit.command.CommandSender;

public abstract class MessageHandler {

    @NotNull
    private final PaperPlugin paperPlugin;

    @NotNull
        this.bukkitCommandManager = bukkitCommandManager;
        this.paperPlugin = paperPlugin;
    @NotNull

    @NotNull
    public PaperPlugin getPaperPlugin() {
        return this.paperPlugin;
    }

    @NotNull
    public BukkitCommandManager<CommandSender> getBukkitCommandManager() {
        return this.bukkitCommandManager;
    }

    public abstract void build();

    public abstract void send(CommandSender sender, Component component);

    public abstract Component parse(String message);

}