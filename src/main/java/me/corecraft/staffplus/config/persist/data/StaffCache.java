package me.corecraft.staffplus.config.persist.data;

import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.ryderbelserion.cluster.api.config.context.FileData;
import com.ryderbelserion.cluster.api.config.context.FileType;
import com.ryderbelserion.cluster.paper.files.adapters.InventoryTypeAdapter;
import com.ryderbelserion.cluster.paper.files.adapters.LocationTypeAdapter;
import org.bukkit.Location;
import org.bukkit.inventory.Inventory;
import java.lang.reflect.Modifier;
import java.nio.file.Path;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public sealed class StaffCache extends FileData permits StaffManager {

    public StaffCache(Path path) {
        super(FileType.json, "staff.json", path.toString(), new GsonBuilder()
                .disableHtmlEscaping()
                .setPrettyPrinting()
                .enableComplexMapKeySerialization()
                .excludeFieldsWithModifiers(Modifier.TRANSIENT)
                .excludeFieldsWithoutExposeAnnotation()
                .registerTypeAdapter(Location.class, new LocationTypeAdapter())
                .registerTypeAdapter(Inventory.class, new InventoryTypeAdapter()));
    }

    @Expose
    public static ConcurrentHashMap<UUID, Location> cache = new ConcurrentHashMap<>();

}