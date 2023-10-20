package me.corecraft.staffplus.commands.handlers;

import com.ryderbelserion.cluster.paper.PaperPlugin;
import dev.triumphteam.cmd.bukkit.BukkitCommandManager;
import dev.triumphteam.cmd.core.message.MessageKey;
import me.corecraft.staffplus.commands.handlers.interfaces.MessageHandler;
import me.corecraft.staffplus.config.enums.Translation;
import net.kyori.adventure.text.Component;
import org.bukkit.command.CommandSender;

public class ArgumentRelations extends MessageHandler {

    private final BukkitCommandManager<CommandSender> bukkitCommandManager;
    private final PaperPlugin paperPlugin;

    public ArgumentRelations(BukkitCommandManager<CommandSender> bukkitCommandManager, PaperPlugin paperPlugin) {
        super(bukkitCommandManager, paperPlugin);

        this.bukkitCommandManager = bukkitCommandManager;
        this.paperPlugin = paperPlugin;
    }

    @Override
    public void build() {
        this.bukkitCommandManager.registerMessage(MessageKey.NOT_ENOUGH_ARGUMENTS, (sender, context) -> {
            String command = context.getCommand();

            String correctUsage = null;

            if (command.equalsIgnoreCase("staff")) correctUsage = "/" + command;

            if (correctUsage != null) {
                send(sender, parse(Translation.invalid_arguments.getMessage("{usage}", correctUsage).toMessage()));
            }
        });

        this.bukkitCommandManager.registerMessage(MessageKey.TOO_MANY_ARGUMENTS, (sender, context) -> {
            String command = context.getCommand();

            String correctUsage = null;

            if (command.equalsIgnoreCase("staff")) correctUsage = "/" + command;

            if (correctUsage != null) {
                send(sender, parse(Translation.invalid_arguments.getMessage("{usage}", correctUsage).toMessage()));
            }
        });

        this.bukkitCommandManager.registerMessage(MessageKey.UNKNOWN_COMMAND, (sender, context) -> {
            String command = context.getCommand();
            String subCommand = context.getSubCommand();

            if (subCommand.isBlank()) {
                send(sender, parse(Translation.unknown_command.getMessage("{command}", command).toMessage()));
                return;
            }

            String commandOrder = "/" + command + " " + subCommand;

            send(sender, parse(Translation.unknown_command.getMessage("{command}", commandOrder).toMessage()));
        });
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