package me.toshiodev.minions.minions;

public enum MinionType {
    FARMING("farming",new String[]{"wheat","carrot","potato","pumpkin","melon","mushroom","cocoa","cactus","sugar_cane","cow","pig","chicken","sheep","rabbit","nether_warts"}),
    MINING("mining", new String[]{"cobblestone","coal","iron","gold","diamong","lapis","emerald","redstone","quartz","obsidian","glowstone","gravel","ice","sand","end_stone","mithril","hard_stone"}),
    COMBAT("combat", new String[]{"zombie","skeleton","spider","cave_spider","creeper","enderman","ghast","slime","blaze","magma_cube"}),
    SLAYER("slayer", new String[]{"revenant","taratula","voidling"}),
    FORAGING("foraging", new String[]{"oak","spruce","birch","dark_oak","acacia","jungle"}),
    FISHING("fishing", new String[]{"fishing","clay"}),
    OTHER("other", new String[]{"flower","snow"});

    String iddentificator;
    String[] minions;
    MinionType(String id, String[] minions) {
        this.iddentificator = id;
        this.minions = minions;
    }

    public String getIddentificator(){
        return iddentificator;
    }

    public String[] getMinions() {
        return minions;
    }
}
