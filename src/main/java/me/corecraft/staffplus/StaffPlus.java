package me.corecraft.staffplus;

import com.ryderbelserion.cluster.paper.PaperPlugin;
import com.ryderbelserion.cluster.paper.PaperService;
import me.corecraft.staffplus.api.CrazyHandler;
import org.bukkit.plugin.java.JavaPlugin;

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

    public PaperPlugin getPaperPlugin() {
        return this.paperPlugin;
    }

    public CrazyHandler getCrazyHandler() {
        return this.crazyHandler;
    }
}