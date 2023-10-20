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

    private final StaffPlus plugin;

    private final ConfigManager configManager;

    public StaffCommand(StaffPlus plugin) {
        this.plugin = plugin;

        CrazyHandler crazyHandler = this.plugin.getCrazyHandler();

        this.configManager = crazyHandler.getConfigManager();
    }

    @Default
    //@Permission(value = "staffplus.use", def = PermissionDefault.FALSE)
    public void execute(Player player) {
        player.getInventory().clear();

        /*ItemStack teleportTool = ParentBuilder.of(this.plugin).setMaterial(Material.ENDER_CHEST).setDisplayName("<dark_purple>Teleport Wand <gray>(Right click)").setDisplayLore(List.of(
                "<gray>Opens a menu that lets you pick",
                "<gray>a player to teleport to."
        )).setAmount(1).build();

        ItemStack profileTool = ParentBuilder.of(this.plugin).setMaterial(Material.PLAYER_HEAD).setPlayer(player.getName()).setDisplayName("<light_purple>Player Wand <gray>(Right click)").setDisplayLore(List.of(
                "<gray>Opens a menu when you right click a",
                "<gray>player showing information about the player."
        )).setAmount(1).build();*/

        //player.getInventory().setItem(3, freezeTool);
        //player.getInventory().setItem(5, teleportTool);
        //player.getInventory().setItem(7, profileTool);

        player.sendMessage(Translation.staff_mode_enter.toComponent());
    }

    @SubCommand("reload")
    //@Permission(value = "staffplus.reload", def = PermissionDefault.FALSE)
    public void reload(CommandSender sender) {
        this.configManager.reload();

        sender.sendMessage(Translation.config_reload.toComponent());
    }
}