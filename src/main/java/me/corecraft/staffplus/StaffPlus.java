package me.corecraft.staffplus;

import com.ryderbelserion.cluster.paper.AbstractPaperPlugin;
import me.corecraft.staffplus.api.ConfigManager;
import org.bukkit.plugin.java.JavaPlugin;

public class StaffPlus extends JavaPlugin {

    private AbstractPaperPlugin plugin;

    private ConfigManager configManager;

    @Override
    public void onEnable() {
        this.plugin = new AbstractPaperPlugin(this, true);
        this.plugin.enable();

        this.configManager = new ConfigManager(this);
        this.configManager.load();
    }

    @Override
    public void onDisable() {
        this.configManager.save();

        this.plugin.disable();
    }

    public AbstractPaperPlugin getAbstractPlugin() {
        return this.plugin;
    }

    public ConfigManager getConfigManager() {
        return this.configManager;
    }
}