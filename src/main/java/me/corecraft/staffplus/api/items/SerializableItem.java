package me.corecraft.staffplus.api.items;

import com.google.gson.annotations.Expose;
import com.ryderbelserion.cluster.paper.items.ItemBuilder;
import com.ryderbelserion.cluster.paper.items.NbtBuilder;
import com.ryderbelserion.cluster.paper.items.ParentBuilder;
import me.corecraft.staffplus.StaffPlus;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class SerializableItem {

    @NotNull
    private final StaffPlus plugin = JavaPlugin.getPlugin(StaffPlus.class);

    private final NbtBuilder nbtBuilder;

    private ItemBuilder itemBuilder;
    private ItemStack itemStack;

    @Expose
    private Material material;
    @Expose
    private String displayName;
    @Expose
    private List<String> displayLore;
    @Expose
    private int amount;
    @Expose
    private String skullName;

    public SerializableItem(Material material, String displayName, List<String> displayLore, int amount) {
        this.material = material;
        this.displayName = displayName;
        this.displayLore = displayLore;
        this.amount = amount;

        this.itemBuilder = ParentBuilder.of().setMaterial(material).setDisplayName(displayName).setDisplayLore(displayLore).setAmount(amount);

        this.nbtBuilder = new NbtBuilder(this.plugin, this.itemStack = this.itemBuilder.build());
    }

    public SerializableItem(Material material, String displayName, List<String> displayLore, int amount, String skullName) {
        this.material = material;
        this.displayName = displayName;
        this.displayLore = displayLore;
        this.amount = amount;
        this.skullName = skullName;

        this.itemBuilder = ParentBuilder.of().setMaterial(material).setDisplayName(displayName).setDisplayLore(displayLore).setAmount(amount).setPlayer(skullName);

        this.nbtBuilder = new NbtBuilder(this.plugin, this.itemStack = this.itemBuilder.build());
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public Material getMaterial() {
        return this.material;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public void setDisplayLore(List<String> displayLore) {
        this.displayLore = displayLore;
    }

    public List<String> getDisplayLore() {
        return this.displayLore;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return this.amount;
    }

    public String getSkullName() {
        return this.skullName;
    }

    public ItemStack getItemStack() {
        return this.itemStack;
    }

    public NbtBuilder getNbt() {
        return this.nbtBuilder;
    }

    public void deconstruct(ItemBuilder builder) {
        this.itemStack = builder.build();
        this.itemBuilder = ParentBuilder.of(builder);
    }
}