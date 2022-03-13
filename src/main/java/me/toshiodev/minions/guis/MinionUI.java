package me.toshiodev.minions.guis;

import me.toshiodev.minions.minions.CustomItemsList;
import me.toshiodev.minions.minions.Minion;
import me.toshiodev.minions.minions.MinionTier;
import me.toshiodev.minions.utils.TextUtils;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

import java.util.HashMap;

public class MinionUI implements Listener, InventoryHolder {

    // basic spigot gui code
    private Inventory currentInventory;
    private String owner;
    private Minion minion;
    private MinionUIType state;

    public MinionUI(Minion minion, MinionUIType state) {
        this.owner = minion.getOwner();
        this.minion = minion;
        this.state = state;

        if (state == MinionUIType.PRINCIPAL) {
            currentInventory = createPrincipalInventory();
        }else if (state == MinionUIType.LAYOUT) {
            currentInventory = createLayoutInventory();
        }else if (state == MinionUIType.CRAFTING) {
            currentInventory = createCraftingInventory();
        }else if (state == MinionUIType.TIERS) {
            currentInventory = createTiersInventory();
        }
    }

    private Inventory createTiersInventory() {
        Inventory inventory = Bukkit.createInventory(this, 9*6, MinionUIType.TIERS.getTitle());
        return inventory;
    }

    private Inventory createCraftingInventory() {
        Inventory inventory = Bukkit.createInventory(this, 9*6, MinionUIType.CRAFTING.getTitle());
        return inventory;
    }

    private Inventory createLayoutInventory() {
        int[] background = new int[]{0,1,7,8,9,10,16,17,18,19,25,26,27,28,34,35,36,37,43,44,45,46,47,50,51,52,53};
        Inventory inventory = Bukkit.createInventory(this, 9*6, MinionUIType.LAYOUT.getTitle());

        for (int slot : background) {
            inventory.setItem(slot, CustomItemsList.BACKGROUND);
        }
        for (int slot : minion.getLayout().getGuiLayout().keySet()){
            inventory.setItem(slot, minion.getLayout().getGuiLayout().get(slot));
        }
        return inventory;
    }

    public Inventory createPrincipalInventory() {
        int[] background = new int[] { 0,1,2,6,7,8,9,11,12,13,14,15,16,17,18,20,26,27,29,35,36,38,44,45,47,49,51,52 };
        storageSlots[] slots = new storageSlots[] {new storageSlots(1,null),new storageSlots(2,new int[]{22,23}),new storageSlots(3,null), new storageSlots(4,new int[]{24,25,30}), new storageSlots(5,null), new storageSlots(6, new int[]{31,32,33}), new storageSlots(7,null), new storageSlots(8, new int[]{34,39,40}), new storageSlots(9,null), new storageSlots(10, new int[]{41,42,43})};
        Inventory inventory = Bukkit.createInventory(this, 9*6, MinionUIType.PRINCIPAL.getTitle().replace("%id%", TextUtils.format(minion.getName())).replace("%tier%", TextUtils.romanize(minion.getCurrentTier().getId())));

        int j = minion.getMinionTier() - 1;

        for (int i = j; i < slots.length; i++) {
            if (slots[i].getSlots() != null) {
                if (slots[i] != slots[j]) {
                    for (int slot : slots[i].getSlots()) {
                        inventory.setItem(slot, CustomItemsList.getStorageItem(i+1));
                    }
                }
            }
        }
        for (int slot : background) {
            inventory.setItem(slot, CustomItemsList.BACKGROUND);
        }

        return inventory;
    }
    @Override
    public Inventory getInventory() {
        return currentInventory;
    }

    public String getOwner() {
        return owner;
    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        if (event.getInventory().equals(currentInventory)) {
            event.setCancelled(true);

        }
    }

    @EventHandler
    public void onDrag(InventoryDragEvent event) {
        if (event.getInventory().equals(currentInventory)) {
            event.setCancelled(true);

        }
    }

    public Minion getMinion() {
        return minion;
    }

    public MinionUIType getState() {
        return state;
    }
}

class storageSlots {
    private int tier;
    private int[] slots;

    public storageSlots(int tier, int[] slots) {
        this.tier = tier;
        this.slots = slots;
    }

    public int getTier() {
        return tier;
    }

    public int[] getSlots() {
        return slots;
    }
}

