package me.corecraft.staffplus.api.items;

import com.google.gson.annotations.Expose;

public record InventoryItem(@Expose SerializableItem item, @Expose int slot) {}