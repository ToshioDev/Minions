package me.toshiodev.minions.guis;

public enum MinionUIType {
    PRINCIPAL("%id% Minion %tier%"),
    LAYOUT("Ideal Layout (Top-down view)"),
    CRAFTING("%id% Minion %nextTier% Recipe"),
    TIERS("%id% Minion Recipes");

    String title;

    MinionUIType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
