package me.corecraft.staffplus.api.items;

import com.ryderbelserion.cluster.paper.items.ItemBuilder;
import com.ryderbelserion.cluster.paper.items.NbtBuilder;
import com.ryderbelserion.cluster.paper.items.ParentBuilder;
import me.corecraft.staffplus.StaffPlus;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.List;

public class SerializableItem {

    private final StaffPlus plugin = JavaPlugin.getPlugin(StaffPlus.class);

    private final ItemStack itemStack;
    private ItemBuilder itemBuilder;
    private final NbtBuilder nbtBuilder;

    public SerializableItem(Material material, String displayName, List<String> displayLore, int amount) {
        this.itemBuilder = ParentBuilder.of().setMaterial(material).setDisplayName(displayName).setDisplayLore(displayLore).setAmount(amount);

        this.nbtBuilder = new NbtBuilder(this.plugin, this.itemStack = this.itemBuilder.build());
    }

    public SerializableItem(Material material, String displayName, List<String> displayLore, int amount, String skullName) {
        this.itemBuilder = ParentBuilder.of().setMaterial(material).setDisplayName(displayName).setDisplayLore(displayLore).setAmount(amount).setPlayer(skullName);

        this.nbtBuilder = new NbtBuilder(this.plugin, this.itemStack = this.itemBuilder.build());
    }

    public ItemStack getItemStack() {
        return this.itemStack;
    }

    public NbtBuilder getNbt() {
        return this.nbtBuilder;
    }

    public void deconstruct(ItemBuilder builder) {
        this.itemBuilder = ParentBuilder.of(builder);
    }
}