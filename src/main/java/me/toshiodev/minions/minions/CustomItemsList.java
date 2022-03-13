package me.toshiodev.minions.minions;

import me.toshiodev.minions.utils.ItemBuilder;
import me.toshiodev.minions.utils.TextUtils;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import static java.util.Arrays.asList;

public class CustomItemsList {
    public static ItemStack AIR = ItemBuilder.item(Material.STAINED_GLASS_PANE, 1, (short) 0, "§7Air", asList("§7Air should be 1 layer", "§7underneath wherethe minion", "§7is standing."));
    public static ItemStack SAND = ItemBuilder.item(Material.SAND, 1, (short) 0, "§7Sand", asList("§7Sand should be 1 layer", "§7underneath wherethe minion", "§7is standing."));
    public static ItemStack DIRT = ItemBuilder.item(Material.DIRT, 1, (short) 0, "§7Dirt", asList("§7Dirt should be 1 layer", "§7underneath wherethe minion", "§7is standing."));
    public static ItemStack GRASS = ItemBuilder.item(Material.GRASS, 1, (short) 0, "§7Grass", asList("§7Grass should be 1 layer", "§7underneath wherethe minion", "§7is standing."));
    public static ItemStack STONE = ItemBuilder.item(Material.STONE, 1, (short) 0, "§7Stone", asList("§7Stone should be 1 layer", "§7underneath wherethe minion", "§7is standing."));
    public static ItemStack COBBLESTONE = ItemBuilder.item(Material.COBBLESTONE, 1, (short) 0, "§7Cobblestone", asList("§7Cobblestone should be 1 layer", "§7underneath wherethe minion", "§7is standing."));
    public static ItemStack LOG = ItemBuilder.item(Material.LOG, 1, (short) 0, "§7Log", asList("§7Log should be 1 layer", "§7underneath wherethe minion", "§7is standing."));
    public static ItemStack BEDROCK = ItemBuilder.item(Material.BEDROCK, 1, (short) 0, "§7Bedrock", asList("§7Bedrock should be 1 layer", "§7underneath wherethe minion", "§7is standing."));
    public static ItemStack WATER = ItemBuilder.item(Material.WATER, 1, (short) 0, "§7Water", asList("§7Water should be 1 layer", "§7underneath wherethe minion", "§7is standing."));
    public static ItemStack LAVA = ItemBuilder.item(Material.LAVA, 1, (short) 0, "§7Lava", asList("§7Lava should be 1 layer", "§7underneath wherethe minion", "§7is standing."));
    public static ItemStack SANDSTONE = ItemBuilder.item(Material.SANDSTONE, 1, (short) 0, "§7Sandstone", asList("§7Sandstone should be 1 layer", "§7underneath wherethe minion", "§7is standing."));
    public static ItemStack BRICK_STAIRS = ItemBuilder.item(Material.BRICK_STAIRS, 1, (short) 0, "§7Brick Stairs", asList("§7Brick Stairs should be 1 layer", "§7underneath wherethe minion", "§7is standing."));
    public static ItemStack NETHER_BRICK_STAIRS = ItemBuilder.item(Material.NETHER_BRICK_STAIRS, 1, (short) 0, "§7Nether Brick Stairs", asList("§7Nether Brick Stairs should be 1 layer", "§7underneath wherethe minion", "§7is standing."));
    public static ItemStack SANDSTONE_STAIRS = ItemBuilder.item(Material.SANDSTONE_STAIRS, 1, (short) 0, "§7Sandstone Stairs", asList("§7Sandstone Stairs should be 1 layer", "§7underneath wherethe minion", "§7is standing."));
    public static ItemStack QUARTZ_STAIRS = ItemBuilder.item(Material.QUARTZ_STAIRS, 1, (short) 0, "§7Quartz Stairs", asList("§7Quartz Stairs should be 1 layer", "§7underneath wherethe minion", "§7is standing."));
    public static ItemStack QUARTZ_BLOCK = ItemBuilder.item(Material.QUARTZ_BLOCK, 1, (short) 0, "§7Quartz Block", asList("§7Quartz Block should be 1 layer", "§7underneath wherethe minion", "§7is standing."));

    public static ItemStack BACKGROUND = ItemBuilder.item(Material.STAINED_GLASS_PANE, 1, (short) 15, "§7 ");

    public static ItemStack getStorageItem(int tier){
        return ItemBuilder.item(Material.STAINED_GLASS_PANE, 1, (short) 0, "§eStorage unlocked at tier " + TextUtils.romanize(tier));
    }
}
