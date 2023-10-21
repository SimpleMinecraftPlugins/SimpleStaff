package me.corecraft.staffplus.commands.handlers.interfaces;

import com.ryderbelserion.cluster.paper.PaperPlugin;
import dev.triumphteam.cmd.bukkit.BukkitCommandManager;
import me.corecraft.staffplus.StaffPlus;
import net.kyori.adventure.text.Component;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public abstract class MessageHandler {

    @NotNull
    private final StaffPlus plugin = JavaPlugin.getPlugin(StaffPlus.class);

    @NotNull
    private final BukkitCommandManager<CommandSender> bukkitCommandManager = this.plugin.getCrazyHandler().getCommandManager().getBukkitCommandManager();

    @NotNull
    private final PaperPlugin paperPlugin = this.plugin.getPaperPlugin();

    @NotNull
    public PaperPlugin getPaperPlugin() {
        return this.paperPlugin;
    }

    @NotNull
    public BukkitCommandManager<CommandSender> getBukkitCommandManager() {
        return this.bukkitCommandManager;
    }

    public abstract void build();

    public abstract void send(@NotNull CommandSender sender, @NotNull Component component);

    public abstract Component parse(@NotNull String message);

}