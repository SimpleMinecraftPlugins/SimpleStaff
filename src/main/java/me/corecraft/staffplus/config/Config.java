package me.corecraft.staffplus.config;

import ch.jalu.configme.Comment;
import ch.jalu.configme.SettingsHolder;
import ch.jalu.configme.properties.Property;
import me.corecraft.staffplus.config.beans.ItemType;
import java.util.List;
import static ch.jalu.configme.properties.PropertyInitializer.newBeanProperty;
import static ch.jalu.configme.properties.PropertyInitializer.newProperty;

public class Config implements SettingsHolder {

    protected Config() {}

    @Comment("Any user who joins with the permission staffplus.join will be put into staff mode wih this enabled.")
    public static final Property<Boolean> enable_staff_on_join = newProperty("staff.enable-on-join", false);

    @Comment("If enabled, Once a staff leaves /staff. They will have their previous inventory restored.")
    public static final Property<Boolean> restore_inventory = newProperty("staff.on-leave.restore-inventory", true);

    @Comment("If enabled, Once a staff leaves /staff. They will have their armor restored.")
    public static final Property<Boolean> restore_armor = newProperty("staff.on-leave.restore-armor", true);

    @Comment("If enabled, Once a staff leaves /staff. They will be teleported back to their old location.")
    public static final Property<Boolean> restore_location = newProperty("staff.on-leave.restore-location", true);

    @Comment("What should the freeze wand look like and do?")
    public static final Property<ItemType> freeze_wand = newBeanProperty(ItemType.class, "staff.items.freeze-wand", new ItemType().setMaterial("BLAZE_ROD").setDisplayAmount(1).setDisplayLore(List.of(
            "<gray>Freezes any player you right click",
            "<gray>The player will be immune to any damage",
            "<gray>or from being moved"
    )).setDisplayName("<blue>Freeze Wand <gray>(Right click)"));

    @Comment("What should the teleport wand look like and do?")
    public static final Property<ItemType> teleport_wand = newBeanProperty(ItemType.class, "staff.items.teleport-wand", new ItemType());

    @Comment("What should the player wand look like and do?")
    public static final Property<ItemType> player_wand = newBeanProperty(ItemType.class, "staff.items.player-wand", new ItemType());
}