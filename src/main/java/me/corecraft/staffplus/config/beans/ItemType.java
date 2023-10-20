package me.corecraft.staffplus.config.beans;

import java.util.List;

public class ItemType {

    private String material;
    private String displayName;
    private List<String> displayLore;
    private int displayAmount;

    public ItemType setMaterial(String material) {
        this.material = material;

        return this;
    }

    public String getMaterial() {
        return this.material;
    }

    public ItemType setDisplayName(String displayName) {
        this.displayName = displayName;

        return this;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public ItemType setDisplayLore(List<String> displayLore) {
        this.displayLore = displayLore;

        return this;
    }

    public List<String> getDisplayLore() {
        return this.displayLore;
    }

    public ItemType setDisplayAmount(int displayAmount) {
        this.displayAmount = displayAmount;

        return this;
    }

    public int getDisplayAmount() {
        return this.displayAmount;
    }
}