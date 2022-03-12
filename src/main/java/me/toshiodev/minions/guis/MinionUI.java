package me.toshiodev.minions.guis;

import me.toshiodev.minions.minions.Minion;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

public class MinionUI implements Listener, InventoryHolder {

    // basic spigot gui code
    private Inventory currentInventory;
    private String owner;

    public MinionUI(Minion minion) {
        this.owner = minion.getOwner();
    }

    public Inventory createPrincipalInventory() {
        Inventory inventory = Bukkit.createInventory(this, 9, "Minion");
        return inventory;
    }
    @Override
    public Inventory getInventory() {
        return currentInventory;
    }

}

enum MinionUIState {
    PRINCIPAL("%id% Minion %tier%"),
    LAYOUT("Ideal layout (top down view)"),
    CRAFTING("%id% Minion %nextTier% Recipe"),
    TIERS("%id% Minion Recipes");

    String title;

    MinionUIState(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}