package me.corecraft.staffplus;

import com.ryderbelserion.cluster.paper.PaperPlugin;
import com.ryderbelserion.cluster.paper.PaperService;
import me.corecraft.staffplus.api.CrazyHandler;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public class StaffPlus extends JavaPlugin {

    private PaperPlugin paperPlugin;

    private CrazyHandler crazyHandler;

    @Override
    public void onEnable() {
        // Enable paper plugin
        this.paperPlugin = new PaperPlugin(this, true);
        this.paperPlugin.enable();

        // Load crazy handler
        this.crazyHandler = new CrazyHandler(this);
        this.crazyHandler.load();
    }

    @Override
    public void onDisable() {
        // Disable crazy handler
        this.crazyHandler.stop();

        // Disable paper plugin
        this.paperPlugin.disable();
    }

    @NotNull
    public PaperPlugin getPaperPlugin() {
        return this.paperPlugin;
    }

    @NotNull
    public CrazyHandler getCrazyHandler() {
        return this.crazyHandler;
    }
}