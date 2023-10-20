package me.corecraft.staffplus.commands;

import dev.triumphteam.cmd.core.BaseCommand;
import dev.triumphteam.cmd.core.annotation.Command;
import dev.triumphteam.cmd.core.annotation.Default;
import dev.triumphteam.cmd.core.annotation.SubCommand;
import me.corecraft.staffplus.StaffPlus;
import me.corecraft.staffplus.api.CrazyHandler;
import me.corecraft.staffplus.api.managers.ConfigManager;
import me.corecraft.staffplus.config.enums.Translation;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@Command("staff")
public class StaffCommand extends BaseCommand {

    private final ConfigManager configManager;

    public StaffCommand(StaffPlus plugin) {
        CrazyHandler crazyHandler = plugin.getCrazyHandler();

        this.configManager = crazyHandler.getConfigManager();
    }

    @Default
    //@Permission(value = "staffplus.use", def = PermissionDefault.FALSE)
    public void execute(Player player) {
        player.sendMessage(Translation.staff_mode_enter.toComponent());
    }

    @SubCommand("reload")
    //@Permission(value = "staffplus.reload", def = PermissionDefault.FALSE)
    public void reload(CommandSender sender) {
        this.configManager.reload();

        sender.sendMessage(Translation.config_reload.toComponent());
    }
}