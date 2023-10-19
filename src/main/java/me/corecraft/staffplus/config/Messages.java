package me.corecraft.staffplus.config;

import ch.jalu.configme.Comment;
import ch.jalu.configme.SettingsHolder;
import ch.jalu.configme.properties.Property;
import static ch.jalu.configme.properties.PropertyInitializer.newProperty;

public class Messages implements SettingsHolder {

    protected Messages() {}

    public static final Property<String> command_prefix = newProperty("prefix", "<red><bold>Staff</bold><red> <dark_gray>»");

    @Comment({
            "The message sent when you are lacking required permissions.",
            "Available Placeholders:",
            " - {permission}",
            ""
    })
    public static final Property<String> no_permission = newProperty("no-permission", "<red>Access denied!");

    public static final Property<String> config_reload = newProperty("config-reload", "<green>Successfully reloaded the plugin");

    public static final Property<String> must_be_player = newProperty("must-be-player", "<red>This command can only be used in-game");

}