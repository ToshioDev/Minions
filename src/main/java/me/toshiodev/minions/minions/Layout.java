package me.toshiodev.minions.minions;

import me.toshiodev.minions.utils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.HashMap;

import static java.util.Arrays.asList;

public class Layout {
    private Minion minion;
    private int[] guiMatrix = new int[]{2, 3, 4, 5, 6, 11, 12, 13, 14, 15, 20, 21, 23, 24, 29, 30, 31, 32, 33, 38, 39, 40, 41, 42 };
    private Vector[] baseMatrix;

    public Layout(Minion minion) {
        this.minion = minion;
        this.baseMatrix = new Vector[]{
                new Vector(1,-1,0),new Vector(0,-1,1),new Vector(1,-1,1),new Vector(-1,-1,0),
                new Vector(0,-1,-1),new Vector(-1,-1,-1),new Vector(1,-1,-1),new Vector(-1,-1,1),
                new Vector(2,-1,0),new Vector(2,-1,-1),new Vector(-2,-1,0),new Vector(-2,-1,-1),
                new Vector(-2,-1,1),new Vector(0,-1,2),new Vector(1,-1,2),new Vector(-1,-1,2),
                new Vector(0,-1,-2),new Vector(1,-1,-2),new Vector(-1,-1,-2),new Vector(2,-1,0),
                new Vector(2,-1,-1),new Vector(2,-1,2),new Vector(-2,-1,-2),new Vector(-2,-1,2)

        };

    }

    public HashMap<Integer, ItemStack> getGuiLayout() {
        HashMap<Integer, ItemStack> guiLayout = new HashMap<>();
        if (minion.getType() == MinionType.MINING) {
            for (int i : guiMatrix) {
                guiLayout.put(i, LayoutGuiItem.AIR);
            }
        }

        return guiLayout;
    }

    public HashMap<Vector, Material> getBlocks() {
        HashMap<Vector, Material> blockLayout = new HashMap<>();
        if (minion.getType() == MinionType.MINING) {
            for (Vector vector : baseMatrix){
                    blockLayout.put(vector,Material.AIR);
            }
        }

        return blockLayout;
    }

    public Minion getMinion() {
        return this.minion;
    }
}

class LayoutGuiItem{
    public static ItemStack AIR = ItemBuilder.item(Material.STAINED_GLASS_PANE,1,(short)0,"§7Air",asList("§7Air should be 1 layer","§7underneath wherethe minion","§7is standing."));
}
