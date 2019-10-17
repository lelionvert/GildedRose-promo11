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
        if (isSulfuras()) {
            // doNothing
        }
        else {
            sellIn--;
        }
    }

    public boolean isAgedBrie() {
        return name.equals("Aged Brie");
    }

    public boolean isBackstage() {
        return name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    public boolean isSulfuras() {
        return name.equals("Sulfuras, Hand of Ragnaros");
    }

    public void updateQuality() {
        if (isSulfuras()) {
            // doNothing
        } else if (isAgedBrie()) {
            increaseQuality();
        } else if (isBackstage()) {
            increaseQuality();
            if (sellIn < 11) {
                increaseQuality();
            }
            if (sellIn < 6) {
                increaseQuality();
            }
        } else {
            decreaseQuality();
        }
    }

    public void updateQualityAfterDeadline() {
        if (sellIn < 0) {
            if (isSulfuras()) {
                // doNothing
            } else if (isAgedBrie()) {
                increaseQuality();
            } else if (isBackstage()) {
                resetQuality();
            } else {
                decreaseQuality();
            }
        }
    }

}
