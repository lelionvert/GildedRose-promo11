package com.gildedrose;

public class Item {

    public String name;

    public int sellIn;

    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    public void increaseQuality() {
        if (quality < 50) {
            quality++;
        }
    }

    public void decreaseQuality() {
        if (quality > 0) {
            quality--;
        }
    }

    public void resetQuality() {
        quality = 0;
    }

    public void decreaseSellIn() {
        sellIn--;
    }
}
