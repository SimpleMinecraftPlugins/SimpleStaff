package me.corecraft.staffplus;

import com.ryderbelserion.cluster.paper.PaperPlugin;
import me.corecraft.staffplus.api.CrazyHandler;
import me.corecraft.staffplus.listeners.TestUtil;
import org.bukkit.plugin.java.JavaPlugin;

public class StaffPlus extends JavaPlugin {

    private PaperPlugin paperPlugin;

    private CrazyHandler crazyHandler;

    @Override
    public void onEnable() {
        this.paperPlugin = new PaperPlugin(this, true);
        this.paperPlugin.enable();

        this.crazyHandler = new CrazyHandler(this);
        this.crazyHandler.load();

        TestUtil testUtil = new TestUtil();
        testUtil.send(this);
    }

    @Override
    public void onDisable() {
        this.crazyHandler.stop();

        this.paperPlugin.disable();
    }

    public PaperPlugin getPaperPlugin() {
        return this.paperPlugin;
    }

    public CrazyHandler getCrazyHandler() {
        return this.crazyHandler;
    }
}