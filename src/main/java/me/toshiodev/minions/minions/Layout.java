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
        }else if (minion.getType() == MinionType.FORAGING){
            for (int i : guiMatrix) {
                guiLayout.put(i, LayoutGuiItem.GRASS);
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
        }else if (minion.getType() == MinionType.FORAGING){
            for (Vector vector : baseMatrix){
                blockLayout.put(vector,Material.GRASS);
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
    public static ItemStack SAND = ItemBuilder.item(Material.SAND,1,(short)0,"§7Sand",asList("§7Sand should be 1 layer","§7underneath wherethe minion","§7is standing."));
    public static ItemStack DIRT = ItemBuilder.item(Material.DIRT,1,(short)0,"§7Dirt",asList("§7Dirt should be 1 layer","§7underneath wherethe minion","§7is standing."));
    public static ItemStack GRASS = ItemBuilder.item(Material.GRASS,1,(short)0,"§7Grass",asList("§7Grass should be 1 layer","§7underneath wherethe minion","§7is standing."));
    public static ItemStack STONE = ItemBuilder.item(Material.STONE,1,(short)0,"§7Stone",asList("§7Stone should be 1 layer","§7underneath wherethe minion","§7is standing."));
    public static ItemStack COBBLESTONE = ItemBuilder.item(Material.COBBLESTONE,1,(short)0,"§7Cobblestone",asList("§7Cobblestone should be 1 layer","§7underneath wherethe minion","§7is standing."));
    public static ItemStack LOG = ItemBuilder.item(Material.LOG,1,(short)0,"§7Log",asList("§7Log should be 1 layer","§7underneath wherethe minion","§7is standing."));
    public static ItemStack BEDROCK = ItemBuilder.item(Material.BEDROCK,1,(short)0,"§7Bedrock",asList("§7Bedrock should be 1 layer","§7underneath wherethe minion","§7is standing."));
    public static ItemStack WATER = ItemBuilder.item(Material.WATER,1,(short)0,"§7Water",asList("§7Water should be 1 layer","§7underneath wherethe minion","§7is standing."));
    public static ItemStack LAVA = ItemBuilder.item(Material.LAVA,1,(short)0,"§7Lava",asList("§7Lava should be 1 layer","§7underneath wherethe minion","§7is standing."));
    public static ItemStack SANDSTONE = ItemBuilder.item(Material.SANDSTONE,1,(short)0,"§7Sandstone",asList("§7Sandstone should be 1 layer","§7underneath wherethe minion","§7is standing."));
    public static ItemStack BRICK_STAIRS = ItemBuilder.item(Material.BRICK_STAIRS,1,(short)0,"§7Brick Stairs",asList("§7Brick Stairs should be 1 layer","§7underneath wherethe minion","§7is standing."));
    public static ItemStack NETHER_BRICK_STAIRS = ItemBuilder.item(Material.NETHER_BRICK_STAIRS,1,(short)0,"§7Nether Brick Stairs",asList("§7Nether Brick Stairs should be 1 layer","§7underneath wherethe minion","§7is standing."));
    public static ItemStack SANDSTONE_STAIRS = ItemBuilder.item(Material.SANDSTONE_STAIRS,1,(short)0,"§7Sandstone Stairs",asList("§7Sandstone Stairs should be 1 layer","§7underneath wherethe minion","§7is standing."));
    public static ItemStack QUARTZ_STAIRS = ItemBuilder.item(Material.QUARTZ_STAIRS,1,(short)0,"§7Quartz Stairs",asList("§7Quartz Stairs should be 1 layer","§7underneath wherethe minion","§7is standing."));
    public static ItemStack QUARTZ_BLOCK = ItemBuilder.item(Material.QUARTZ_BLOCK,1,(short)0,"§7Quartz Block",asList("§7Quartz Block should be 1 layer","§7underneath wherethe minion","§7is standing."));


}
