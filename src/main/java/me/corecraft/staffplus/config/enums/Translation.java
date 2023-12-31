package me.corecraft.staffplus.config.enums;

import ch.jalu.configme.SettingsManager;
import ch.jalu.configme.properties.Property;
import me.corecraft.staffplus.StaffPlus;
import me.corecraft.staffplus.api.managers.ConfigManager;
import me.corecraft.staffplus.config.Messages;
import net.kyori.adventure.text.Component;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import java.util.HashMap;
import java.util.Map;

public enum Translation {

    no_permission(Messages.no_permission),
    config_reload(Messages.config_reload),
    must_be_player(Messages.must_be_player),
    must_be_console(Messages.must_be_console),
    unknown_command(Messages.unknown_command),
    invalid_arguments(Messages.invalid_arguments),
    internal_error(Messages.internal_error),
    staff_mode_enter(Messages.staff_mode_enter),
    staff_mode_exit(Messages.staff_mode_exit),
    staff_mode_force_exited(Messages.staff_mode_force_exited);

    private final Property<String> property;

    private String message;

    Translation(Property<String> property) {
        this.property = property;
    }

    @NotNull
    private final StaffPlus plugin = JavaPlugin.getPlugin(StaffPlus.class);

    @NotNull
    private final ConfigManager configManager = this.plugin.getCrazyHandler().getConfigManager();

    @NotNull
    private final SettingsManager messages = this.configManager.getMessages();

    @NotNull
    private String getProperty(@NotNull Property<String> property) {
        return this.messages.getProperty(property);
    }

    @NotNull
    public Translation getMessage() {
        return getMessage(new HashMap<>());
    }

    @NotNull
    public Translation getMessage(@NotNull String placeholder, @NotNull String replacement) {
        HashMap<String, String> placeholders = new HashMap<>();
        placeholders.put(placeholder, replacement);

        return getMessage(placeholders);
    }

    @NotNull
    public Translation getMessage(@NotNull HashMap<String, String> placeholder) {
        String message;

        message = getProperty(this.property);

        if (!placeholder.isEmpty()) {
            for (Map.Entry<String, String> value : placeholder.entrySet()) {
                message = message.replace(value.getKey(), value.getValue()).replace(value.getKey().toLowerCase(), value.getValue());
            }
        }

        this.message = message;

        return this;
    }

    @NotNull
    public String toMessage() {
        return this.message.replaceAll("\\{prefix}", this.messages.getProperty(Messages.command_prefix));
    }

    @NotNull
    public Component toComponent() {
        return this.plugin.getPaperPlugin().parse(getMessage().toMessage());
    }
}