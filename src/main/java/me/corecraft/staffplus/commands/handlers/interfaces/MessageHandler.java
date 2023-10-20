package me.corecraft.staffplus.commands.handlers.interfaces;

import com.ryderbelserion.cluster.paper.PaperPlugin;
import dev.triumphteam.cmd.bukkit.BukkitCommandManager;
import net.kyori.adventure.text.Component;
import org.bukkit.command.CommandSender;

public abstract class MessageHandler {

    private final BukkitCommandManager<CommandSender> bukkitCommandManager;
    private final PaperPlugin paperPlugin;

    public MessageHandler(BukkitCommandManager<CommandSender> bukkitCommandManager, PaperPlugin paperPlugin) {
        this.bukkitCommandManager = bukkitCommandManager;
        this.paperPlugin = paperPlugin;
    }

    public PaperPlugin getPaperPlugin() {
        return this.paperPlugin;
    }

    public BukkitCommandManager<CommandSender> getBukkitCommandManager() {
        return this.bukkitCommandManager;
    }

    public abstract void build();

    public abstract void send(CommandSender sender, Component component);

    public abstract Component parse(String message);

}