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

    public MiscRelations(BukkitCommandManager<CommandSender> bukkitCommandManager, PaperPlugin paperPlugin) {
        super(bukkitCommandManager, paperPlugin);
    }

    @Override
    public void build() {
        getBukkitCommandManager().registerMessage(MessageKey.INVALID_ARGUMENT, (sender, context) -> send(sender, parse(Translation.invalid_arguments.getMessage("{usage}", context.getTypedArgument()).toMessage())));

        getBukkitCommandManager().registerMessage(BukkitMessageKey.NO_PERMISSION, (sender, context) -> send(sender, parse(Translation.no_permission.getMessage("{permission}", context.getNodes().get(0)).toMessage())));

        getBukkitCommandManager().registerMessage(BukkitMessageKey.PLAYER_ONLY, (sender, context) -> send(sender, parse(Translation.must_be_player.toMessage())));
        getBukkitCommandManager().registerMessage(BukkitMessageKey.CONSOLE_ONLY, (sender, context) -> send(sender, parse(Translation.must_be_console.toMessage())));
    }

    @Override
    public void send(CommandSender sender, Component component) {
        sender.sendMessage(component);
    }

    @Override
    public Component parse(String message) {
        return getPaperPlugin().parse(message);
    }
}