package me.corecraft.staffplus.commands.handlers;

import com.ryderbelserion.cluster.paper.PaperPlugin;
import dev.triumphteam.cmd.bukkit.BukkitCommandManager;
import dev.triumphteam.cmd.bukkit.message.BukkitMessageKey;
import dev.triumphteam.cmd.core.message.MessageKey;
import me.corecraft.staffplus.commands.handlers.interfaces.MessageHandler;
import me.corecraft.staffplus.config.enums.Translation;
import net.kyori.adventure.text.Component;
import org.bukkit.command.CommandSender;

public class MiscRelations extends MessageHandler {

    private final BukkitCommandManager<CommandSender> bukkitCommandManager;
    private final PaperPlugin paperPlugin;

    public MiscRelations(BukkitCommandManager<CommandSender> bukkitCommandManager, PaperPlugin paperPlugin) {
        super(bukkitCommandManager, paperPlugin);

        this.bukkitCommandManager = bukkitCommandManager;
        this.paperPlugin = paperPlugin;
    }

    @Override
    public void build() {
        this.bukkitCommandManager.registerMessage(MessageKey.INVALID_ARGUMENT, (sender, context) -> send(sender, parse(Translation.invalid_arguments.getMessage("{usage}", context.getTypedArgument()).toMessage())));

        this.bukkitCommandManager.registerMessage(BukkitMessageKey.NO_PERMISSION, (sender, context) -> send(sender, parse(Translation.no_permission.getMessage("{permission}", context.getNodes().get(0)).toMessage())));

        this.bukkitCommandManager.registerMessage(BukkitMessageKey.PLAYER_ONLY, (sender, context) -> send(sender, parse(Translation.must_be_player.toMessage())));
        this.bukkitCommandManager.registerMessage(BukkitMessageKey.CONSOLE_ONLY, (sender, context) -> send(sender, parse(Translation.must_be_console.toMessage())));
    }

    @Override
    public void send(CommandSender sender, Component component) {
        sender.sendMessage(component);
    }

    @Override
    public Component parse(String message) {
        return this.paperPlugin.parse(message);
    }
}