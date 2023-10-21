package me.corecraft.staffplus.config.persist.data;

import me.corecraft.staffplus.StaffPlus;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.nio.file.Path;
import java.util.UUID;

public non-sealed class StaffManager extends StaffCache {

    @NotNull
    private final StaffPlus plugin = JavaPlugin.getPlugin(StaffPlus.class);

    @NotNull
    private final Path path;

    public StaffManager(@NotNull Path path) {
        super(path);

        this.path = path;
    }

    public void load() {
        this.plugin.getPaperPlugin().getStorageManager().addFile(new StaffCache(this.path));
    }

    public void save() {
        this.plugin.getPaperPlugin().getStorageManager().saveFile(new StaffCache(this.path));
    }

    public void addStaff(@NotNull UUID uuid) {
        if (hasStaff(uuid)) return;
    }

    public boolean hasStaff(@NotNull UUID uuid) {
        return cache.contains(uuid);
    }
}